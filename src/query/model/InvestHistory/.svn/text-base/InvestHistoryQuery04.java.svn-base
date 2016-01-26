package query.model.InvestHistory;

import java.sql.Statement;
import java.util.HashMap;
import java.util.List;

import database.connection.DBConnection;

import query.model.Query;

public class InvestHistoryQuery04 implements Query {

	public InvestHistoryQuery04() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<HashMap<String, String>> getResultList(String invs_ad_no, int arg1) {
		// TODO Auto-generated method stub
		Statement st = DBConnection.createStatement();
		List<HashMap<String, String>> list = null;
		list = DBConnection.getResultList(DBConnection.executeQuery(st,
				"execute procedure iv017i('" + invs_ad_no + "')"));

		DBConnection.closeStatement(st);
		return list;
	}

}
