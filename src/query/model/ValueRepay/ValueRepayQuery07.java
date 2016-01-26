package query.model.ValueRepay;

import java.sql.Statement;
import java.util.HashMap;
import java.util.List;

import query.model.Query;

import database.connection.DBConnection;

public class ValueRepayQuery07 implements Query {

	@Override
	public List<HashMap<String, String>> getResultList(String policy_no,
			int type) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<HashMap<String, String>> getResultList(String policy_no,
			String cp_anniv_date, int cp_notice_serial) {
		// TODO Auto-generated method stub
		Statement st = DBConnection.createStatement();
		List<HashMap<String, String>> list = null;
		String s = "execute procedure cc168i('" + policy_no + "','"
				+ cp_anniv_date + "','" + cp_notice_serial + "')";
		list = DBConnection.getResultList(DBConnection.executeQuery(st, s));
		DBConnection.closeStatement(st);
		return list;
	}

}
