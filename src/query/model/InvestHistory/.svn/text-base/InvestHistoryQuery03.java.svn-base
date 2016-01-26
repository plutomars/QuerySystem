/**
 * 
 */
package query.model.InvestHistory;

import java.sql.Statement;
import java.util.HashMap;
import java.util.List;

import query.model.Query;
import database.connection.DBConnection;

/**
 * @author F1256819
 * 
 */
public class InvestHistoryQuery03 implements Query {

	/**
	 * 
	 */
	public InvestHistoryQuery03() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see query.model.Query#getResultList(java.lang.String, int)
	 */
	@Override
	public List<HashMap<String, String>> getResultList(String policy_no,
			int arg1) {
		// TODO Auto-generated method stub
		Statement st = DBConnection.createStatement();
		List<HashMap<String, String>> list = null;
		list = DBConnection.getResultList(DBConnection.executeQuery(st,
				"execute procedure cc246i('" + policy_no + "')"));

		DBConnection.closeStatement(st);
		return list;
	}

}
