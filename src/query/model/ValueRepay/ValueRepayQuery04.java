package query.model.ValueRepay;

import java.sql.Statement;
import java.util.HashMap;
import java.util.List;

import query.model.Query;

import database.connection.DBConnection;

public class ValueRepayQuery04 implements Query {

	@Override
	public List<HashMap<String, String>> getResultList(String policy_no,
			int type) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<HashMap<String, String>> getResultList(String policy_no,
			String cp_anniv_date, String disb_spec_ind, String relation,String currency) {
		// TODO Auto-generated method stub
		Statement st = DBConnection.createStatement();
		List<HashMap<String, String>> list = null;
		String s = "execute procedure cc165i('" + policy_no + "','"
				+ cp_anniv_date + "','" + disb_spec_ind + "','" + relation +"','" + currency.substring(0, 3).toString() +"')";
		list = DBConnection.getResultList(DBConnection.executeQuery(st, s));
		DBConnection.closeStatement(st);
		return list;
	}

}
