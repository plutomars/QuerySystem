package query.model.PosEC;

import java.sql.Statement;
import java.util.HashMap;
import java.util.List;

import database.connection.DBConnection;

import query.model.Query;

public class PosECQuery implements Query {

	@Override
	public List<HashMap<String, String>> getResultList(String txn_seq, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<HashMap<String, String>> getResultList(String client_id, String date_beg,String date_end,String txn_code,String policy_no) {
		// TODO Auto-generated method stub
		Statement st = DBConnection.createStatement();
		List<HashMap<String, String>> list = null;
//		System.out.println("execute procedure cc196i('"+ client_id +"','"+ date_beg +"','"+date_end+"','" + txn_code+"','"+ policy_no + "')");
		list = DBConnection.getResultList(DBConnection.executeQuery(st,
				"execute procedure cc196i('"+ client_id +"','"+ date_beg +"','"+date_end+"','" + txn_code+"','"+ policy_no + "')"));

	DBConnection.closeStatement(st);
	return list;
	}
	
	public List<HashMap<String, String>> getResultList(String txn_seq, String txn_code) {
		// TODO Auto-generated method stub
		Statement st = DBConnection.createStatement();
		List<HashMap<String, String>> list = null;
		list = DBConnection.getResultList(DBConnection.executeQuery(st,
				"execute procedure cc197i('"+ txn_seq +"','" + txn_code+ "')"));

	DBConnection.closeStatement(st);
	return list;
	}

}
