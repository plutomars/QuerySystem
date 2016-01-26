package query.model.PoBonus;

import java.sql.Statement;
import java.util.HashMap;
import java.util.List;

import query.model.Query;

import database.connection.DBConnection;

public class PoBonusQuery implements Query{
	
	public final static int BONUS = 1;
	public final static int BONUSLIST = 2;

//	public static Object BONUS;

	public List<HashMap<String, String>> getResultList(String policy_no,int type) {
				
		Statement st = DBConnection.createStatement();
	
		List<HashMap<String, String>> list = null;

			list = DBConnection.getResultList(DBConnection.executeQuery(st,
					"execute procedure cc113i('" + policy_no + "')"));
	
		return list;
		
	}
	
	public List<HashMap<String, String>> getResultList(String policy_no,
			String bonus_type,int type) {
		Statement st = DBConnection.createStatement();
		
		List<HashMap<String, String>> list = null;
		list = DBConnection.getResultList(DBConnection.executeQuery(st,
				"execute procedure cc114i('" + policy_no +"','" + bonus_type+ "')"));
	DBConnection.closeStatement(st);
	return list;
		
	}

}
