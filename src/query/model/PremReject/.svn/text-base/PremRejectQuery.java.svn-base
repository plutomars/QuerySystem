package query.model.PremReject;

import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import database.connection.DBConnection;
import query.model.Query;

/**
 * 
 * @author cychu
 *
 * @version 1.0<br/>
 * 			101/03/21<br/>
 * 			授權書、委託書退件資料查詢(Query)
 * 
 * @since 1.0
 */
public class PremRejectQuery implements Query {

	@Override
	public List<HashMap<String, String>> getResultList(String policy_no,
			int type) {
		Statement st = DBConnection.createStatement();
		List<HashMap<String, String>> list = null;
		list = DBConnection.getResultList(DBConnection.executeQuery(st, 
				"execute procedure cc127i('" + policy_no + "')"));
		DBConnection.closeStatement(st);
		return list;
	}
	
}