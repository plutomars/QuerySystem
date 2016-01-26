package query.model.NewRescind;

import java.sql.Statement;
import java.util.HashMap;
import java.util.List;

import query.model.Query;
import database.connection.DBConnection;

public class NewRescindQuery implements Query{
	
	public final static int NewRescind01 = 1;
	public final static int NewRescind02 = 2;
	public final static int NewRescind03 = 3;
	public final static int NewRescind04 = 4;

	@Override
	public List<HashMap<String, String>> getResultList(String policy_no,
			int type) {
		
		Statement st = DBConnection.createStatement();
		
		List<HashMap<String, String>> list = null;
		if (type == NewRescindQuery.NewRescind01)
			list = DBConnection.getResultList(DBConnection.executeQuery(st,
					"execute procedure cc118i('" + policy_no + "')"));
		else if (type == NewRescindQuery.NewRescind02)
			list = DBConnection.getResultList(DBConnection.executeQuery(st,
					"execute procedure cc119i('" + policy_no + "')"));
		else if (type == NewRescindQuery.NewRescind03)
			list = DBConnection.getResultList(DBConnection.executeQuery(st,
					"execute procedure cc120i('" + policy_no + "')"));
//						
		DBConnection.closeStatement(st);
		return list;		
		
	}
	
	public List<HashMap<String, String>> getResultList(String policy_no,
			String r_notify_date) {
//		System.out.println("result beg");
		Statement st = DBConnection.createStatement();
		List<HashMap<String, String>> list = null;
		list = DBConnection.getResultList(DBConnection.executeQuery(st,
				"execute procedure cc121i('" + policy_no + "','"+r_notify_date+"')"));
		// TODO Auto-generated method stub
		return list;
	}
	

}
