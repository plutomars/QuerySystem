package query.model.NewPhysicalExam;

import java.sql.Statement;
import java.util.HashMap;
import java.util.List;

import query.model.NewSamplingRecord.SamplingRecordQuery;

import database.connection.DBConnection;

public class NewPhysicalExamQuery {
	
//	public final static int PHYSICAL_EXAM = 1;
		
	public List<HashMap<String, String>> getResultList(String agent_code,String date_yymm) {
		
		Statement st = DBConnection.createStatement();
		List<HashMap<String, String>> list = null;
				
		list = DBConnection.getResultList(DBConnection.executeQuery(st,
				"execute procedure cc221i('" + agent_code + "','"+date_yymm+"')"));
		
		
		DBConnection.closeStatement(st);
		return list;
	}
	
	public String getAGname(String agent_code)
	{  
		Statement st = DBConnection.createStatement();
		List<HashMap<String, String>> list = null;
		list = DBConnection.getResultList(DBConnection.executeQuery(st,"SELECT names name FROM clnt WHERE client_id = '" + agent_code + "'"));
//		String agent_name = "";
        System.out.println(list.get(0).get("name"));
		return (list.get(0).get("name")== null) ? "" :list.get(0).get("name").trim();
	}
	
}
