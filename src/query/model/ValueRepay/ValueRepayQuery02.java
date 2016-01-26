package query.model.ValueRepay;

import java.sql.Statement;
import java.util.HashMap;
import java.util.List;

import query.model.Query;

import database.connection.DBConnection;

public class ValueRepayQuery02 implements Query {

	@Override
	public List<HashMap<String, String>> getResultList(String policy_no,
			int type) {
		// TODO Auto-generated method stub
		Statement st = DBConnection.createStatement();
		List<HashMap<String, String>> list = null;
		list = DBConnection.getResultList(DBConnection.executeQuery(st,
				"execute procedure cc163i('" + policy_no + "')"));
		DBConnection.closeStatement(st);
		return list;
	}

	/**
	 * @category 取得還本註記
	 * @param policy_no
	 *            保單號碼
	 * @param cp_anniv_date
	 *            還本週年日
	 * @return
	 */
	public String getNonresp_sw(String policy_no, String cp_anniv_date) {
		Statement st = DBConnection.createStatement();
		List<HashMap<String, String>> list = null;
		list = DBConnection.getResultList(DBConnection.executeQuery(st,
				"select distinct policy_no from psck where policy_no='"
						+ policy_no + "' and cp_anniv_date='" + cp_anniv_date
						+ "'" + " and nonresp_sw='Y'"));
		if (list.size() > 0)
			return "＊";
		else
			return " ";
	}

	public String getCpReturn_date(String policy_no, String cp_anniv_date) {
		String result_date_string = "";
		int cp_data_count = 0;
		Statement st = DBConnection.createStatement();
		List<HashMap<String, String>> psc0_list = null;
		psc0_list = DBConnection.getResultList(DBConnection.executeQuery(st,
				"select count(*) as psc0_cnt from psc0 where policy_no='"
						+ policy_no + "' and cp_anniv_date='" + cp_anniv_date
						+ "'"));
		cp_data_count = Integer.parseInt(psc0_list.get(0).get("psc0_cnt"));
		// psc0裡面無資料就無須顯示
		if (cp_data_count == 0)
			return result_date_string;
		List<HashMap<String, String>> list = null;
		list = DBConnection
				.getResultList(DBConnection
						.executeQuery(
								st,
								"select addday('"
										+ cp_anniv_date
										+ "',-desc[1,3]) date1,addday('"
										+ cp_anniv_date
										+ "',-desc[4,6]) date2 from etab where code='PS' and e_type='pscback'"));
		String date1 = list.get(0).get("date1");
		String date2 = list.get(0).get("date2");

		result_date_string = date1 + " ～ " + date2;

		return result_date_string;
	}
}
