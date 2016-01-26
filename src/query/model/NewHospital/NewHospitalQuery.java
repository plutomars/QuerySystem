package query.model.NewHospital;

/**
 * 
 * @author swei
 * @version 1.0
 * 體檢醫院查詢(Query)
 * 
 */

import java.sql.Statement;
import java.util.HashMap;
import java.util.List;

import database.connection.DBConnection;

public class NewHospitalQuery {
	public final static int NewHospital_HM = 1;//體檢醫院資料-體檢醫療院所
	public final static int NewHospital_HC = 2;//體檢醫院查詢-體檢項目
	
	public List<HashMap<String, String>> getResultList(String area_code,String txt_search,int type) {
		// TODO Auto-generated method stub
		Statement st = DBConnection.createStatement();
		List<HashMap<String, String>> list = null;
		
		String area_code_9 = "A0";//CHON_HUA
		if (type == NewHospitalQuery.NewHospital_HM) // 1
		{
			if(area_code.equals("0"))
			{
				list = DBConnection.getResultList(DBConnection.executeQuery(st,"execute procedure cc122i('*','" + txt_search + "')"));
			}
			else if(area_code.equals("9") == true)
			{
				list = DBConnection.getResultList(DBConnection.executeQuery(st,"execute procedure cc122i('" + area_code_9 + "','" + txt_search + "')"));
			}
			else
			{
				list = DBConnection.getResultList(DBConnection.executeQuery(st,"execute procedure cc122i('" + area_code + "','" + txt_search + "')"));
			}
		}

		DBConnection.closeStatement(st);
		if (list == null) {
			System.out.println("area"+area_code+" is null");
		}
		return list;
	}
	
	public List<HashMap<String, String>> getResultList2(String Hospital_id,int type) {
		// TODO Auto-generated method stub
		Statement st = DBConnection.createStatement();
		List<HashMap<String, String>> list = null;
		
		if (type == NewHospitalQuery.NewHospital_HC) //1
			list = DBConnection.getResultList(DBConnection.executeQuery(st,"execute procedure cc123i('" + Integer.parseInt(Hospital_id) + "')")
					);//編碼
		DBConnection.closeStatement(st);
		return list;
	}
}