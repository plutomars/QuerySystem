package query.model.PremGBill;

/**
 * 
 * @author swei
 * @version 1.0
 * 集體彙繳查詢查詢(Query)
 * 
 */

import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import database.connection.DBConnection;


public class PremGBill01Query
{
	public final static int Grouper = 1;   // 集體彙繳--索引
	public final static int GContext02 = 2;// 集體彙繳查詢--內容
	public final static int GContext03 = 3;// 集體彙繳查詢--內容
	
	public List<HashMap<String, String>> getResultList(String group_code,String assigner,String company_name,int type) 
	{		
		Statement st = DBConnection.createStatement();
		List<HashMap<String, String>> list = null;
		if (type == PremGBill01Query.Grouper) //1
		{
			list = DBConnection.getResultList(DBConnection.executeQuery(st,
					"execute procedure cc133i('" + group_code + "','" + assigner + "','" + company_name + "')"));

		}		
		if (type == PremGBill01Query.GContext02) //2
		{
			list = DBConnection.getResultList(DBConnection.executeQuery(st,
					"execute procedure cc134i('" + group_code + "','" + assigner + "','" + company_name + "')"));
		}		
		DBConnection.closeStatement(st);
		return list;
    }
	
	public List<HashMap<String, String>> getResultList2(String group_code,int type) 
	{		
		Statement st2 = DBConnection.createStatement();
		List<HashMap<String, String>> list2 = null;
		
		if (type == PremGBill01Query.GContext03) //3
		{
			list2 = DBConnection.getResultList(DBConnection.executeQuery(st2,
					"execute procedure cc135i('" + group_code + "')"));
		}
		DBConnection.closeStatement(st2);
		return list2;
	}
}
