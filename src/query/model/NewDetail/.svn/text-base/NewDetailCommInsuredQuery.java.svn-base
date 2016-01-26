package query.model.NewDetail;

import java.sql.Statement;
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;

import query.model.Query;
import query.model.PoRelation.PoRelationQuery;
import database.connection.DBConnection;

/**
 * 新契約查詢基本資料被保人部份的資料查詢
 * 
 * @author epf
 * 
 * @version 1.0
 * 
 * @since 1.0
 */
public class NewDetailCommInsuredQuery implements Query {

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
		try {

			// 補齊欄位用的hashmap,list,statement
			List<HashMap<String, String>> tmplist;
			Statement st = DBConnection.createStatement();

			// 使用關係人查詢撈取被保險人
			PoRelationQuery prq = new PoRelationQuery();
			List<HashMap<String, String>> list = prq.getResultList(policy_no,
					PoRelationQuery.NEWRELATION);

			// 其餘需從別部份撈的部份
			// 主被保人住所地址
			for (HashMap<String, String> hsmp : list) {
				if (hsmp.get("r_relation").trim().compareTo("I1") == 0) {
					tmplist = DBConnection.getResultList(DBConnection
							.executeQuery(st,
									"select nvl(a.address,'') address from addr a,post b where a.client_id ='"
											+ hsmp.get("r_client_id")
													.toString()
											+ "' and a.addr_ind = b.addr_ind_i"
											+ " and b.policy_no='" + policy_no
											+ "';"));

					for (HashMap<String, String> tmphsmp : tmplist) {
						hsmp.put("home_addr", tmphsmp.get("address").toString());
					}
				}
				// 職級要包含代碼及中文
				hsmp.put(
						"r_occu_desc",
						hsmp.get("r_occu_code") == null ? "" : hsmp
								.get("r_occu_code").trim()
								+ " "
								+ hsmp.get("r_occu_desc")== null ? "" : hsmp
										.get("r_occu_desc"));
				list.set(list.indexOf(hsmp), hsmp);
			}
			DBConnection.closeStatement(st);

			return list;

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR1",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
			return null;
		}
	}
}
