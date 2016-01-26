package query.model.NewDetail;

import java.sql.Statement;
import java.util.HashMap;
import java.util.List;

import database.connection.DBConnection;

import query.model.Query;

/**
 * 新契約明細契變受理Query
 * 
 * @author epf
 * 
 */
public class NewDetailPosChangeQuery implements Query {

	@Override
	public List<HashMap<String, String>> getResultList(String policy_no,
			int type) {
		if (type == NOTYPE) {
			List<HashMap<String, String>> list = getResultList(policy_no);
			return list;
		}
		return null;

	}

	public List<HashMap<String, String>> getResultList(String policy_no) {
		Statement st = DBConnection.createStatement();
		String cmd = "SELECT DISTINCT c.policy_no,po_chg_rece_no receive_no,po_chg_rece_date receive_date,po_chg_sts_code"
				+ " FROM pocl a,pocl b,apdt c"
				+ " WHERE a.policy_no = '"
				+ policy_no
				+ "'"
				+ " AND a.client_ident <> 'O1'"
				+ " AND a.client_id = b.client_id"
				+ " AND b.client_ident <> 'O1'"
				+ " AND b.policy_no = c.policy_no"
				+ " AND po_chg_sts_code NOT MATCHES '[56]'" + " ORDER BY 1,2;";
		List<HashMap<String, String>> list = DBConnection
				.getResultList(DBConnection.executeQuery(st, cmd));
		for (HashMap<String, String> hsmp : list) {
			if (policy_no.matches("[16]8100*")) {
				if (!hsmp.get("policy_no").matches("[16]8100*")) {
					list.remove(list.indexOf(hsmp));
					continue;
				}
			} else {
				if (hsmp.get("policy_no").matches("[16]8100*")) {
					list.remove(list.indexOf(hsmp));
					continue;
				}
			}
			int chg_sts_code = 0;
			try {
				chg_sts_code = Integer.parseInt(hsmp.get("po_chg_sts_code"));
			} catch (Exception e) {
				chg_sts_code = 0;
			}
			switch (chg_sts_code) {
			case 1:
				hsmp.put("po_chg_sts_code", "受理中");
				break;
			case 2:
				hsmp.put("po_chg_sts_code", "承辦中");
				break;
			case 3:
				hsmp.put("po_chg_sts_code", "照會補件");
				break;
			case 4:
				hsmp.put("po_chg_sts_code", "照會繳費");
				break;
			}
		}
		DBConnection.closeStatement(st);
		return list;
	}
}
