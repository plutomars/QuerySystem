package query.model.NewDetail;

import java.sql.Statement;
import java.util.HashMap;
import java.util.List;

import query.model.Query;
import database.connection.DBConnection;

/**
 * 新契約明細體檢照會部份查詢(JavaBean)
 * 
 * @author epf
 * 
 * @version 1.0
 * 
 * @since 1.0
 */
public class NewDetailExamNoticeQuery implements Query {

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
		String cmd = "SELECT pocl.client_ident, nbxr.exam_item_code, nbxc.exam_item_desc, nbxr.exam_required_ind"
				+ ", REPLACE( pocl.client_ident[1,1], 'S', 'D' ) client_order"
				+ " FROM nbxr, polf, nbxc, pocl WHERE nbxr.policy_no = '"
				+ policy_no
				+ "' AND nbxr.policy_no = polf.policy_no "
//				+ " AND polf.uw_write_date <> ' ' "   101/03/02 秋燕要求未核保件的也要顯示
				+ " AND nbxr.exam_item_code = nbxc.exam_item_code AND nbxr.policy_no = pocl.policy_no "
				+ " AND nbxr.client_id  = pocl.client_id AND pocl.client_ident <> 'O1' ORDER BY 5 DESC, 1, 2, 4";

		List<HashMap<String, String>> list = DBConnection
				.getResultList(DBConnection.executeQuery(st, cmd));

		// 類別帶中文，要建立名辭數值
		for (HashMap<String, String> hsmp : list) {
			cmd = "select term_meaning from edp_base:trmval where term_id='exam_required_ind' and term_value='"
					+ hsmp.get("exam_required_ind") + "';";
			for (HashMap<String, String> tmphsmp : DBConnection
					.getResultList(DBConnection.executeQuery(st, cmd))) {
				hsmp.put("exam_required_ind", tmphsmp.get("term_meaning"));
			}
			// 項目說明代碼加上中文描述
			hsmp.put(
					"exam_item_desc",
					hsmp.get("exam_item_code") + " "
							+ hsmp.get("exam_item_desc"));

			list.set(list.indexOf(hsmp), hsmp);
		}
		DBConnection.closeStatement(st);
		return list;
	}
}
