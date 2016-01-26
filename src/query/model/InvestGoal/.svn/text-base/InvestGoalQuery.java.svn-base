package query.model.InvestGoal;

import java.sql.Statement;
import java.util.HashMap;
import java.util.List;

import query.model.Query;
import database.connection.DBConnection;

public class InvestGoalQuery implements Query {

	public final static int INVEST_LEFT = 1;
	public final static int INVEST_GOAL1 = 2;
//	public final static int INVEST_GOAL2 = 3;
	public final static int INVEST_GOAL3 = 3;

	@Override
	public List<HashMap<String, String>> getResultList(String policy_no,
			int type) {
		Statement st = DBConnection.createStatement();
		List<HashMap<String, String>> list = null;
		if (type == InvestGoalQuery.INVEST_LEFT)
			list = DBConnection.getResultList(DBConnection.executeQuery(st,
					"execute procedure cc145i('" + policy_no + "')"));
//		else if (type == InvestGoalQuery.INVEST_GOAL1)
//			list = DBConnection.getResultList(DBConnection.executeQuery(st,
//					"execute procedure cc146i('" + policy_no + "')"));
//		else if (type == InvestGoalQuery.INVEST_GOAL2)
//			list = DBConnection.getResultList(DBConnection.executeQuery(st,
//					"execute procedure cc147i('" + policy_no + "')"));
		DBConnection.closeStatement(st);
		return list;
	}

	public List<HashMap<String, String>> getResultList(String policy_no,
		String pv_calc_date, String pv_calc_type,String exsrc,String exprc,String currency,int type) {
//		System.out.println("result beg");
		Statement st = DBConnection.createStatement();
		
		List<HashMap<String, String>> list = null;

			list = DBConnection.getResultList(DBConnection.executeQuery(st,
					"execute procedure cc146i('" + policy_no + "','"+pv_calc_date+"','"+pv_calc_type+"','"+exsrc+"','"+exprc+"','"+currency+"')"));


		// TODO Auto-generated method stub
		
		DBConnection.closeStatement(st);
		return list;
	}
	
	public List<HashMap<String, String>> getResultList(String policy_no,
			String invs_code, String invs_name,int type) {
//			System.out.println("result beg");
			Statement st = DBConnection.createStatement();
			
			List<HashMap<String, String>> list = null;

			    list = DBConnection.getResultList(DBConnection.executeQuery(st,
				     	"execute procedure cc148i('" + policy_no + "','"+invs_code+"','"+invs_name+"')"));

			// TODO Auto-generated method stub
			
			DBConnection.closeStatement(st);
			return list;
		}
	public List<HashMap<String, String>> getResultList(String policy_no,
			String invs_code, String exsrc,String exprc,String currency) {
//			System.out.println("result beg");
			Statement st = DBConnection.createStatement();
			
			List<HashMap<String, String>> list = null;

				list = DBConnection.getResultList(DBConnection.executeQuery(st,
						"execute procedure cc155i('" + policy_no + "','"+invs_code+"','"+exsrc+"','"+exprc+"','"+currency+"')"));


			// TODO Auto-generated method stub
			
			DBConnection.closeStatement(st);
			return list;
		}
}
