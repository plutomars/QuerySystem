package query.model.PremReject;

import java.sql.Statement;
import java.util.HashMap;
import java.util.List;

import query.model.Query;
import database.connection.DBConnection;
/**
 * 
 * @author cychu
 *
 * @version 1.0<br/>
 * 			101/03/26<br/>
 * 			授權書、委託書退件明細查詢(Query)
 * 
 * @since 1.0
 */
public class PremRejectQuery01 implements Query {

	@Override
	public List<HashMap<String, String>> getResultList(String arg0, int arg1) {
		return null;
	}

	public List<HashMap<String, String>> getResultList(String policy_no,
			String bank_op_ind, String process_date) {
		Statement st = DBConnection.createStatement();
		List<HashMap<String, String>> list = null;
		list = DBConnection.getResultList(DBConnection.executeQuery(st, 
				"execute procedure cc128i('" + policy_no + "','"
				+ bank_op_ind + "','" + process_date + "')"));
		DBConnection.closeStatement(st);
		return list;
	}
}
