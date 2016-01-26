package query.model.InvestCash;

import java.sql.Statement;
import java.util.HashMap;
import java.util.List;

import query.model.Query;
import database.connection.DBConnection;

/**
 * 
 * @author 陳冠瑜
 * 
 */
public class InvestCashQuery implements Query {
	public final static int INVESTCASH = 1;
	public final static int INVESTCASHDETAIL = 2;
	public final static int INVESTCASHPOS = 3;
	public final static int INVESTCASHENTRY = 4;
	public final static int INVESTCASHIMMED = 5; // 立投費用

	@Override
	public List<HashMap<String, String>> getResultList(String policy_no,
			int type) {
		// TODO Auto-generated method stub
		Statement st = DBConnection.createStatement();
		List<HashMap<String, String>> list = null;

		if (type == InvestCashQuery.INVESTCASH)
			list = DBConnection.getResultList(DBConnection.executeQuery(st,
					"execute procedure cc158i('" + policy_no + "')"));

		DBConnection.closeStatement(st);
		return list;
	}

	public List<HashMap<String, String>> getResultList(String policy_no,
			String entry_no, String currency, int type) {
		Statement st = DBConnection.createStatement();
		List<HashMap<String, String>> list = null;

		if (type == InvestCashQuery.INVESTCASHDETAIL)
			list = DBConnection.getResultList(DBConnection.executeQuery(st,
					"execute procedure cc159i('" + policy_no + "','" + entry_no
							+ "','" + currency + "')"));
		else if (type == InvestCashQuery.INVESTCASHPOS)
			list = DBConnection.getResultList(DBConnection.executeQuery(st,
					"execute procedure cc160i('" + policy_no + "','" + entry_no
							+ "','" + currency + "')"));

		DBConnection.closeStatement(st);
		return list;
	}

	public List<HashMap<String, String>> getResultList(String policy_no,
			String entry_no, int type) {
		Statement st = DBConnection.createStatement();
		List<HashMap<String, String>> list = null;

		if (type == InvestCashQuery.INVESTCASHENTRY)
			list = DBConnection.getResultList(DBConnection.executeQuery(st,
					"execute procedure cc198i('" + policy_no + "','" + entry_no
							+ "')"));
		if (type == InvestCashQuery.INVESTCASHIMMED)
			list = DBConnection.getResultList(DBConnection.executeQuery(st,
					"execute procedure cc199i('" + policy_no + "','" + entry_no
							+ "')"));

		DBConnection.closeStatement(st);
		return list;

	}
}
