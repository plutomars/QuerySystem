package query.model.NewDetail;

import java.sql.Statement;
import java.util.HashMap;
import java.util.List;

import query.model.Query;
import database.connection.DBConnection;

/**
 * 新契約明細體檢資料查詢(JavaBean)
 * 
 * @author epf
 * 
 * @version 1.0
 * 
 * @since 1.0
 */
public class NewDetailExamInfoQuery implements Query {

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
//		String cmd = "SELECT nbxh.client_id,nbxd.exam_item_code,exam_item_desc,exam_date"
//				+ ",exam_result_ind,exam_result_value,hospital_name FROM nbxh,nbxd,nbxc,hchp "
//				+ " WHERE nbxh.client_id IN (SELECT client_id FROM pocl WHERE policy_no = '"
//				+ policy_no
//				+ "' AND client_ident <> 'O1') AND nbxh.exam_seq = nbxd.exam_seq AND nbxd.exam_item_code = nbxc.exam_item_code "
//				+ " AND nbxh.hospital_id = hchp.hospital_id UNION "
//				+ " SELECT nbxh.client_id,nbxd.exam_item_code,exam_item_desc,exam_date,exam_result_ind,exam_result_value,hospital_name"
//				+ " FROM nbxh,nbxd,nbxc,hchp WHERE nbxh.client_id IN (SELECT b.client_id FROM pocl,clnt a,clnt b WHERE policy_no = '"
//				+ policy_no
//				+ "' AND client_ident <> 'O1' AND pocl.client_id = a.client_id AND a.id_ind MATCHES '[356]' AND a.names = b.names"
//				+ " AND b.id_ind MATCHES '[356]' AND b.client_id <> pocl.client_id)"
//				+ " AND nbxh.exam_seq = nbxd.exam_seq AND nbxd.exam_item_code = nbxc.exam_item_code AND nbxh.hospital_id = hchp.hospital_id "
//				+ " ORDER BY 1,4 DESC,2";
//
//		List<HashMap<String, String>> list = DBConnection
//				.getResultList(DBConnection.executeQuery(st, cmd));
//
//		for (HashMap<String, String> hsmp : list) {
//			hsmp.put(
//					"exam_item_desc",
//					hsmp.get("exam_item_code") + " "
//							+ hsmp.get("exam_item_desc"));
//			hsmp.put(
//					"exam_item_result",
//					hsmp.get("exam_result_ind") == null ? "" : hsmp.get(
//							"exam_result_ind").trim()
//							+ " " + hsmp.get("exam_result_value") == null ? ""
//							: hsmp.get("exam_result_value").trim());
//			list.set(list.indexOf(hsmp), hsmp);
//		}
		List<HashMap<String, String>> list = DBConnection.getResultList(DBConnection.executeQuery(st, "execute procedure cc213i('" + policy_no + "')"));
//		System.out.println(list.get(0).get(""));
		DBConnection.closeStatement(st);
		return list;
	}
}
