package query.model.InvestHistory;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;

import database.connection.DBConnection;

import query.model.Query;


public class InvestHistoryQuery02 implements Query {

	@Override
	public List<HashMap<String, String>> getResultList(String arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<HashMap<String, String>> getResultList(String invs_ad_no, String currency,String invs_tr_date,String invs_ivtr_code,String check_info_join,String  exsrc,String  exprc) {
		// TODO Auto-generated method stub
		Statement st = DBConnection.createStatement();
		List<HashMap<String, String>> list = null;
		list = DBConnection.getResultList(DBConnection.executeQuery(st,
				"execute procedure cc157i('" + invs_ad_no+"','" +currency+ "','" +invs_tr_date+ "','" +invs_ivtr_code+ "','" +check_info_join+ "','" +exsrc+ "','" +exprc+ "')"));
		
		DBConnection.closeStatement(st);
		return list;
	}

}
