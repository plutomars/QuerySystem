package query.model.ValueWithdraw;

import java.sql.Statement;
import java.util.HashMap;
import java.util.List;

import query.model.Query;

import database.connection.DBConnection;
/**
 * 
 * @author ³¯«a·ì
 * 
 */
public class ValueWithdrawQuery implements Query {
	public final static int VALUEWITHDRAW = 1;
	
	@Override
	public List<HashMap<String, String>> getResultList(String policy_no,
			int type) {
		// TODO Auto-generated method stub
		Statement st = DBConnection.createStatement();
		List<HashMap<String,String>> list = null;
		if (type == ValueWithdrawQuery.VALUEWITHDRAW)
			list = DBConnection.getResultList(DBConnection.executeQuery(st, "execute procedure cc149i('"+policy_no+"')"));
		DBConnection.closeStatement(st);
		return list;
	}

}
