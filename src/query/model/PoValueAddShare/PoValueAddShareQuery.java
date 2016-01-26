package query.model.PoValueAddShare;

import java.sql.Statement;
import java.util.HashMap;
import java.util.List;

import database.connection.DBConnection;

import query.model.Query;

public class PoValueAddShareQuery implements Query {

	public PoValueAddShareQuery() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see query.model.Query#getResultList(java.lang.String, int)
	 */
	@Override
	public List<HashMap<String, String>> getResultList(String policy_no,
			int type) {
		List<HashMap<String, String>> list = null;
		Statement st = DBConnection.createStatement();
		switch (type) {
		case 1:
			list = DBConnection.getResultList(DBConnection.executeQuery(st,
					"execute procedure ccpsk1('" + policy_no + "')"));
			DBConnection.closeStatement(st);
			return list;
		case 2:
			list = DBConnection.getResultList(DBConnection.executeQuery(st,
					"execute procedure ccpsk2('" + policy_no + "')"));
			DBConnection.closeStatement(st);
			return list;
		case 3:
			list = DBConnection.getResultList(DBConnection.executeQuery(st,
					"execute procedure ccpsk3('" + policy_no + "')"));
		default:
			return list;
		}

	}
}
