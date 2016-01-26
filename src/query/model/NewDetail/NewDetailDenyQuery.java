package query.model.NewDetail;

import java.sql.Statement;
import java.util.HashMap;
import java.util.List;

import database.connection.DBConnection;

import query.model.Query;
/**
 * 新契約明細基本資料 未承保原因
 * 
 * @author cora
 * 
 * @version 1.0
 * 
 * @since 1.0
 */
public class NewDetailDenyQuery implements Query {

	@Override
	public List<HashMap<String, String>> getResultList(String policy_no, int type) {
		if (type == NOTYPE) {
			List<HashMap<String, String>> list = getResultList(policy_no);
			return list;
		}
		return null;
	}
	
	public List<HashMap<String, String>> getResultList(String policy_no) {
		Statement st = DBConnection.createStatement();
		List<HashMap<String, String>> list = null;
		String s = "execute procedure cc212i('" + policy_no + "')";
		list = DBConnection.getResultList(DBConnection.executeQuery(st, s));
		DBConnection.closeStatement(st);
		return list;
	}
}
