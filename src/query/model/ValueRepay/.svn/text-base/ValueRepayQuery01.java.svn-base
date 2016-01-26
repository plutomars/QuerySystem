package query.model.ValueRepay;

import java.sql.Statement;
import java.util.HashMap;
import java.util.List;

import query.model.Query;

import database.connection.DBConnection;

public class ValueRepayQuery01 implements Query {

	@Override
	public List<HashMap<String, String>> getResultList(String policy_no,
			int type) {
		// TODO Auto-generated method stub
		Statement st = DBConnection.createStatement();
		List<HashMap<String, String>> list = null;
		list = DBConnection.getResultList(DBConnection.executeQuery(st,
				"execute procedure cc162i('" + policy_no + "')"));
		DBConnection.closeStatement(st);
		return list;
	}

}
