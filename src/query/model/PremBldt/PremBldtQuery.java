package query.model.PremBldt;

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
 * 			101/04/11<br/>
 * 			送金記錄查詢－基本資料/送金記錄(Query)
 * 
 * @since 1.0
 */
public class PremBldtQuery implements Query {
	
	public final static int PREMBLDT = 1;
	public final static int PREMBLDT01 = 2;

	@Override
	public List<HashMap<String, String>> getResultList(String policy_no, 
			int type) {
		Statement st = DBConnection.createStatement();
		List<HashMap<String, String>> list = null;
		if (type == PremBldtQuery.PREMBLDT) {
			list = DBConnection.getResultList(DBConnection.executeQuery(st, 
					"execute procedure cc240i('" + policy_no + "')"));
		} else if (type == PremBldtQuery.PREMBLDT01) {
			list = DBConnection.getResultList(DBConnection.executeQuery(st, 
					"execute procedure cc241i('" + policy_no + "')"));
		}
		DBConnection.closeStatement(st);
		return list;
	}
}
