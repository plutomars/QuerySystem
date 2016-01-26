package query.model.NewDetail;

import java.sql.Statement;
import java.util.HashMap;
import java.util.List;

import query.model.Query;
import database.connection.DBConnection;

/**
 * 新契約明細查詢批註資料查詢
 * 
 * @author epf
 * 
 * @version 1.0<br>
 * 
 * @since 1.0
 */
public class NewDetailCommCmntQuery implements Query {

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
		List<HashMap<String, String>> list = null;
		String s = "execute procedure cc108i('" + policy_no + "')";
		list = DBConnection.getResultList(DBConnection.executeQuery(st, s));
		DBConnection.closeStatement(st);
		return list;
	}
}
