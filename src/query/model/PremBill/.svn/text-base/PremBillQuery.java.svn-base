package query.model.PremBill;

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
 * 			100/08/17<br/>
 * 			¦©´Ú©ú²Ó¬d¸ß(Query)
 * 
 * @since 1.0
 */
public class PremBillQuery implements Query {

	public final static int PREMBILL = 1;
	public final static int PREMBILL01 = 2;
	
	@Override
	public List<HashMap<String, String>> getResultList(String policy_no,
			int type) {
		Statement st = DBConnection.createStatement();
		List<HashMap<String, String>> list = null;
		if (type == PremBillQuery.PREMBILL)
			list = DBConnection.getResultList(DBConnection.executeQuery(st,
					"execute procedure cc131i('" + policy_no + "')"));
		else if (type == PremBillQuery.PREMBILL01)
			list = DBConnection.getResultList(DBConnection.executeQuery(st,
					"execute procedure cc132i('" + policy_no + "')"));
		DBConnection.closeStatement(st);
		return list;
	}

}
