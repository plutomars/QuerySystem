package query.model.NewDetail;

import java.sql.Statement;
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;

import query.model.Query;
import database.connection.DBConnection;

/**
 * 新契約查詢 核保訊息部份(JavaBean)
 * 
 * @author epf
 * 
 * @version 1.0<br>
 *          100/07/28<br>
 * 
 * @since 1.0
 */
public class NewDetailUwErrCodeQuery implements Query {

	@Override
	public List<HashMap<String, String>> getResultList(String policy_no,
			int type) {
		// TODO Auto-generated method stub
		if (type == NOTYPE) {
			List<HashMap<String, String>> list = getResultList(policy_no);
			return list;
		}
		return null;
	}

	public List<HashMap<String, String>> getResultList(String policy_no) {
		try {
			Statement stat = DBConnection.createLiteStatement();
			String i1_id = "", i2_id = "",po_sts_code = "";
			String cmd = "";
			String cmd_from = "";

			cmd = "select i1_id,po_sts_code from jpolf where policy_no='" + policy_no
					+ "';";

			// 撈取I1 ID
			for (HashMap<String, String> hsmp : DBConnection.getResultList(stat
					.executeQuery(cmd))) {
				i1_id = hsmp.get("i1_id");
				po_sts_code = hsmp.get("po_sts_code");
			}

			// 撈取核保訊息基本資訊
			if (policy_no.startsWith("8")) //101/07/23 cora
				cmd_from = " FROM   aner a,nbec b,OUTER pocl c,OUTER coan d";
			else if (policy_no.startsWith("9"))
				cmd_from = " FROM   nbeh a,nbec b,OUTER pocl c,OUTER copa d";
			else	
				cmd_from = " FROM   nbeh a,nbec b,OUTER pocl c,OUTER colf d";
		
			Statement st = DBConnection.createStatement();
			cmd = "SELECT a.coverage_no,nvl(c.client_ident,'') client_ident,plan_code"
			          + ",a.client_id,b.nb_err_code,nb_err_desc,nvl(d.client_ident,'') c_client_ident"
//			          + " FROM   nbeh a,nbec b,OUTER pocl c,OUTER colf d"
			          + cmd_from
			          + " WHERE  a.policy_no = '"
			          + policy_no
			          + "' "
			          + "AND a.nb_err_code = b.nb_err_code "
			          + "AND a.policy_no = c.policy_no "
			          + "AND a.client_id = c.client_id "
			          + "AND c.client_ident <> 'O1' "
			          + "AND a.policy_no = d.policy_no "
			          + "AND a.coverage_no = d.coverage_no;";
			
			if (Integer.parseInt(po_sts_code.substring(0, 2))<= 6 )
			{	cmd = cmd.replaceAll("nbeh", "nber");
			}
			List<HashMap<String, String>> list = DBConnection
					.getResultList(DBConnection.executeQuery(st, cmd));
			// 撈取i2_id

			cmd = "select client_id from pocl where client_ident='I2' and policy_no='"
					+ policy_no + "';";
			for (HashMap<String, String> hsmp : DBConnection.getResultList(st
					.executeQuery(cmd))) {
				i2_id = hsmp.get("client_id") == null ? "" : hsmp.get(
						"client_id").trim();
			}
			// 以下塞入有舊保單不同職級資訊
			for (HashMap<String, String> hsmp : list) {
				if (hsmp.get("client_ident").trim().compareTo("I2") == 0
						&& i1_id.compareTo(i2_id) == 0) {
					list.remove(list.indexOf(hsmp));
					continue;
				}
				// UA21的處理，需要撈取不同職級舊保單資料的key值塞入bean，以便事後作tooltipframe
				if (hsmp.get("nb_err_code").trim().compareTo("UA21") == 0) {
					String max_rate_occu = "";
					cmd = "select nvl(max(rate_occu),'') max_rate_occu from colf,pldf"
							+ " where policy_no = '"
							+ policy_no
							+ "' "
							+ "and client_ident='"
							+ hsmp.get("client_ident").trim()
							+ "' "
							+ " AND (colf.co_sts_code <= '10' "
							+ " OR colf.co_sts_code BETWEEN '42' AND '51') "
							+ " AND colf.plan_code = pldf.plan_code "
							+ " AND colf.rate_scale = pldf.rate_scale"
							+ " AND plan_class_code MATCHES '6*';";
					for (HashMap<String, String> tmphsmp : DBConnection
							.getResultList(st.executeQuery(cmd))) {
						max_rate_occu = tmphsmp.get("max_rate_occu");
					}
					if (max_rate_occu.trim().compareTo("") == 0) {
						cmd = "select occupation_level from clnt a,nboc b "
								+ "where a.client_id = '"
								+ hsmp.get("client_id") + "'"
								+ " AND a.occupation_code = b.occupation_code;";
						for (HashMap<String, String> tmphsmp : DBConnection
								.getResultList(st.executeQuery(cmd))) {
							max_rate_occu = tmphsmp.get("occupation_level");
						}
					}
					hsmp.put("policy_no", policy_no);
					hsmp.put("occupation_level", max_rate_occu);
				}

				String desc = hsmp.get("nb_err_desc");
				if (hsmp.get("client_id").trim().compareTo("") != 0
						&& !hsmp.get("nb_err_code").matches("IV*")
						&& (hsmp.get("client_ident").trim().compareTo("O1") != 0 || hsmp
								.get("client_ident") == null)) {

					if (hsmp.get("client_ident").trim().compareTo("") == 0
							|| hsmp.get("client_ident") == null
							|| hsmp.get("coverage_no").trim().compareTo("98") == 0) {
						// 撈取業務員關係
						cmd = "select nvl(min(relation),'-') relation from poag where policy_no='"
								+ policy_no
								+ "'"
								+ " and agent_code ='"
								+ hsmp.get("client_id").trim() + "' and relation MATCHES '[WX]';";
						String relation = "";

						for (HashMap<String, String> tmphsmp : DBConnection
								.getResultList(st.executeQuery(cmd))) {
							relation = tmphsmp.get("relation");
						}
						if (relation.trim().compareTo("W") == 0) {
							hsmp.put("client_ident", "A1");
						}
						if (relation.trim().compareTo("X") == 0) {
							hsmp.put("client_ident", "A2");
						}
					}
					if (hsmp.get("coverage_no").trim().compareTo("99") == 0) {
						desc = hsmp.get("client_id") + "," + desc;
					} else { //977000002959
						if (!hsmp.get("client_ident").isEmpty())
						desc = hsmp.get("client_ident") + "," + desc;
					}
				}
				if (hsmp.get("nb_err_code").matches("IV*")) {
					desc = hsmp.get("client_id") + "," + desc;
				}
				if (Integer.parseInt(hsmp.get("coverage_no")) > 0
						&& Integer.parseInt(hsmp.get("coverage_no")) < 98) {
					desc = hsmp.get("c_client_ident") + ","
							+ hsmp.get("plan_code")+desc;
				}
				hsmp.put("nb_err_desc", desc);
				list.set(list.indexOf(hsmp), hsmp);
			}
			DBConnection.closeStatement(st);
			DBConnection.closeStatement(stat);
			return list;

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR1",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
			return null;
		}

	}

	public List<HashMap<String, String>> getToolTipResultList(String client_id,
			String rate_occu, String policy_no) {
		Statement st = DBConnection.createStatement();
		String cmd = "";
		// 撈取舊保單職級
		cmd = "SELECT colf.policy_no,colf.rate_occu "
				+ "FROM pocl,polf,colf,pldf " + "WHERE pocl.client_id = '"
				+ client_id
				+ "'"
				+ " AND pocl.client_ident <> 'O1'"
				+ " AND pocl.policy_no <> '"
				+ policy_no
				+ "'"
				+ " AND pocl.policy_no = polf.policy_no"
				+ " AND (po_sts_code <= '10'"
				+ " OR (po_sts_code = '65' AND co_sts_code = '51')"
				+ " OR po_sts_code BETWEEN '42' AND '50')"
				+ " AND pocl.policy_no = colf.policy_no"
				+ " AND pocl.client_ident = colf.client_ident"
				+ " AND (co_sts_code <= '10' OR co_sts_code BETWEEN '42' AND '51')"
				+ " AND colf.plan_code NOT MATCHES 'TADD*'"
				+ " AND colf.plan_code = pldf.plan_code"
				+ " AND colf.rate_scale = pldf.rate_scale"
				+ " AND plan_class_code MATCHES '6*'"
				+ " AND colf.rate_occu <> '"
				+ rate_occu
				+ "'"
				+ " union"
				+ " SELECT copa.policy_no,copa.rate_occu"
				+ " FROM pocl,popa,copa,pldf"
				+ " WHERE pocl.client_id = '"
				+ client_id
				+ "' AND pocl.client_ident <> 'O1'"
				+ " AND pocl.policy_no <> '"
				+ policy_no
				+ "' AND pocl.policy_no = popa.policy_no"
				+ " AND (po_sts_code <= '10' OR (po_sts_code = '65' AND co_sts_code = '51')"
				+ " OR po_sts_code BETWEEN '42' AND '50')"
				+ " AND pocl.policy_no = copa.policy_no AND pocl.client_ident = copa.client_ident"
				+ " AND (co_sts_code <= '10' OR co_sts_code BETWEEN '42' AND '51')"
				+ " AND copa.plan_code NOT MATCHES 'TADD*'"
				+ " AND copa.plan_code = pldf.plan_code AND copa.rate_scale = pldf.rate_scale"
				+ " AND plan_class_code MATCHES '6*'"
				+ " AND copa.rate_occu <> '" + rate_occu + "';";

		List<HashMap<String, String>> list = DBConnection
				.getResultList(DBConnection.executeQuery(st, cmd));
		DBConnection.closeStatement(st);
		return list;
	}
}
