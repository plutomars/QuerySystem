package query.model.ClientInfo;

import java.sql.Statement;
import java.util.HashMap;
import java.util.List;

import database.connection.DBConnection;

public class ClientInfoQuery {
	public List<HashMap<String, String>> getResultList(String po_or_client,
			String procedure) {

		Statement st = DBConnection.createStatement();
		List<HashMap<String, String>> list = null;

		list = DBConnection.getResultList(DBConnection.executeQuery(st,
				"execute procedure " + procedure.trim() + "('" + po_or_client
						+ "')"));

		DBConnection.closeStatement(st);
		return list;
	}

	public List<HashMap<String, String>> getResultList(String owner_id) {

		Statement stLite = DBConnection.createLiteStatement();
		List<HashMap<String, String>> list = null;

		String cmd = "select policy_no,po_sts_code po_sts_desc,"
				+ "i1_id,i1_name ,"
				+ "'' home_addr,'' home_zip,"
				+ "'' home_sts,mail_addr ,mail_addr_sts mail_sts,"
				+ " mail_addr_ind,home_addr_ind,'' pmia_desc,"
				+ "(case when mail_addr_ind <> home_addr_ind then '0' else '1' end) order_a"
				+ " from jpolf where substr(po_sts_code,1,2) in('42','43','44','45','46','47','48','49','50','52','53')  "
				+ " and o1_id = '" + owner_id + "' order by order_a";

		list = DBConnection.getResultList(DBConnection
				.executeQuery(stLite, cmd));

		DBConnection.closeStatement(stLite);
		return list;
	}

	public List<HashMap<String, String>> getHomeAddr(String client_id,
			String addr_ind) {

		Statement st = DBConnection.createStatement();
		List<HashMap<String, String>> list = null;
		// System.out.println("select address from addr where client_id ='"+client_id+"' and addr_ind = '"+addr_ind+"'");
		list = DBConnection.getResultList(DBConnection.executeQuery(st,
				"select address from addr where client_id ='" + client_id
						+ "' and addr_ind = '" + addr_ind + "'"));

		DBConnection.closeStatement(st);
		return list;
	}

	public String getEC_acct(String client_id) {
		Statement st = DBConnection.createStatement();
		List<HashMap<String, String>> list = null;
		// System.out.println("select address from addr where client_id ='"+client_id+"' ");//and
		// addr_ind = '"+addr_ind+"'");
		list = DBConnection
				.getResultList(DBConnection
						.executeQuery(
								st,
								"select (case pwd_sw when '2' then '2 交易 已啟用' else '3 交易 未啟用' end) ec_acct "
										+ "from ecpw where pwd_sw in ('2','3') and client_id ='"
										+ client_id + "'"));

		DBConnection.closeStatement(st);
		if (list.isEmpty())
			return " ";
		else
			return list.get(0).get("ec_acct");
	}

	public String getRemit_acct(String client_id, String foreign_ind) {
		Statement st = DBConnection.createStatement();
		List<HashMap<String, String>> list = null;

		String f_cmd = "";

		if (foreign_ind.equals("0"))
			f_cmd = "select getBankName(remit_bank||remit_branch) bank_name,process_date from psra"
					+ " where psra_sts_code = '0' and client_id = '"
					+ client_id + "'"
					// + " union "
					// +
					// " select getBankName(remit_bank||remit_branch) bank_name,process_date from psrag"
					// + " where psra_sts_code = '0' and client_id = '"
					// + client_id + "'"
					+ " order by process_date DESC";
		else
			f_cmd = "select getBankName(bank_code) bank_name,process_date from psrf"
					+ " where psrf_sts_code = '0' and client_id = '"
					+ client_id
					+ "'"
					// + " union "
					// +
					// " select getBankName(bank_code) bank_name,process_date from psrfg"
					// + " where psrf_sts_code = '0' and client_id = '"
					// + client_id + "'" 
					+ " order by process_date DESC";
		list = DBConnection.getResultList(DBConnection.executeQuery(st, f_cmd));

		DBConnection.closeStatement(st);
		if (list.size() == 0)
			return " ";
		else
			return list.get(0).get("bank_name");
	}

	/**
	 * @category 取得失聯保戶指示
	 * @since SR130700054
	 * @param client_id
	 * @return "Y" or ""
	 */
	public String getLost_ind(String client_id) {
		Statement st = DBConnection.createStatement();
		List<HashMap<String, String>> list = null;
		list = DBConnection.getResultList(DBConnection.executeQuery(st,
				"select distinct lost_ind from aaqc where client_id ='"
						+ client_id + "' and lost_ind = 'Y'"));
		DBConnection.closeStatement(st);
		if (list.size() == 0)
			return "";
		else
			return list.get(0).get("lost_ind");
	}

	/**
	 * @category 取得風險屬性等級
	 * @since SR140100176
	 * @param client_id
	 * @return 風險屬性等級中文
	 */
	public String getRisk_suit_ind(String client_id) {
		Statement st = DBConnection.createStatement();
		List<HashMap<String, String>> list = null;
		list = DBConnection.getResultList(DBConnection
				.executeQuery(st,
						"select max(getDesc('risk_suit_ind',risk_suit_ind)) risk_suit_desc"
								+ " from clnt a,vivrk b where a.client_id ='"
								+ client_id
								+ "' and a.risk_suit_seq = b.risk_suit_seq"));
		DBConnection.closeStatement(st);
		if (list.size() == 0)
			return "";
		else
			return list.get(0).get("risk_suit_desc");
	}

	/**
	 * @category 取得FATCA指示
	 * @param client_id
	 * @return 指示欄位加上中文
	 */
	public String getFatac_ind(String client_id) {
		Statement st = DBConnection.createStatement();
		List<HashMap<String, String>> list = null;
		list = DBConnection.getResultList(DBConnection.executeQuery(st,
				"select fatca_ind ||' '|| getDesc('fatca_ind',fatca_ind) fatca_ind_desc"
						+ " from clnt where client_id ='" + client_id + "'"));
		DBConnection.closeStatement(st);
		if (list.size() == 0)
			return "";
		else
			return list.get(0).get("fatca_ind_desc");
	}

	public String getPsckSw(String client_id) {
		Statement st = DBConnection.createStatement();
		List<HashMap<String, String>> list = null;
		list = DBConnection.getResultList(DBConnection.executeQuery(st,
				"execute procedure psckById('" + client_id + "')"));
		DBConnection.closeStatement(st);
		if (list.size() == 0)
			return "";
		else
			return list.get(0).get("r_psck_sw");
	}

}
