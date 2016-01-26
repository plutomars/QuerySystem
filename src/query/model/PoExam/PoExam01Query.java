package query.model.PoExam;

/**
 * 
 * @author 
 * @version 1.0
 * 體檢批註告知查詢(Query)
 * 
 */

import java.sql.Statement;
import java.util.HashMap;
import java.util.List;

import query.model.Query;

import database.connection.DBConnection;

public class PoExam01Query implements Query {
	public final static int Supplement = 0;  //弱體資料
	public final static int Reason = 1;      //體檢原因資料
	public final static int Told = 2;        //告知資料
	public final static int Comments = 3;    //批註資料


	@Override
	public List<HashMap<String, String>> getResultList(String policy_no,int type) {
		// TODO Auto-generated method stub
		Statement st = DBConnection.createStatement();
		List<HashMap<String, String>> list = null;		
		
		if (type == PoExam01Query.Reason)        //--------體檢原因資料
			list = DBConnection.getResultList(DBConnection.executeQuery(st,
					"execute procedure cc106i('" + policy_no + "')"));
		//******************************************************************************//
		else if (type == PoExam01Query.Told)     //--------告知資料
			list = DBConnection.getResultList(DBConnection.executeQuery(st,
					"execute procedure cc107i('" + policy_no + "','I')")); 
		//******************************************************************************//
		else if (type == PoExam01Query.Comments) //--------批註資料
			list = DBConnection.getResultList(DBConnection.executeQuery(st,
					"execute procedure cc108i('" + policy_no + "')"));
		
		//******************************************************************************//
		else if (type == PoExam01Query.Supplement)//0 
		list = DBConnection.getResultList(DBConnection.executeQuery(st,
				"execute procedure cc211i('" + policy_no + "')"));
//		 " SELECT "                         //-----新契約弱體(1)
//		+" a.policy_no r_policy_no, " 
//		+" a.client_ident r_client_ident,"
//		+" b.receive_date r_receive_date,"
//		+" b.receive_no   r_receive_no,  "
//		+" c.names r_names,"
//		+" d.client_id r_client_id,"
//		+" CONCAT('[新 契 約]:  ', (e.sub_std_desc)) as r_standard "
//		+" FROM poss a ,popr b,clnt c,pocl d, nbss e "
//		+" WHERE c.client_id = '" + policy_no + "' "//'K223373348'
//		+" AND a.policy_no = b.policy_no "
//		+" AND a.policy_no = d.policy_no " 
//		+" AND d.client_id = c.client_id "
//		+" AND d.client_ident <> 'O1' "
//		+" AND a.sub_std_code_1 = e.sub_std_code "
//		+" UNION"                            //-----新契約弱體(2)
//		+" SELECT "
//		+" a.policy_no r_policy_no, " 
//		+" a.client_ident r_client_ident,"
//		+" b.receive_date r_receive_date,"
//		+" b.receive_no   r_receive_no,  "
//		+" c.names r_names,"
//		+" d.client_id r_client_id,"
//		+" CONCAT('[新 契 約]:  ', (e.sub_std_desc)) as r_standard "
//		+" FROM poss a ,popr b,clnt c,pocl d, nbss e "
//		+" WHERE c.client_id = '" + policy_no + "' "
//		+" AND a.policy_no = b.policy_no "
//		+" AND a.policy_no = d.policy_no " 
//		+" AND d.client_id = c.client_id "
//		+" AND d.client_ident <> 'O1' "
//		+" AND a.sub_std_code_2 = e.sub_std_code "
//		+" UNION"                             //-----新契約弱體(3)
//		+" SELECT "
//		+" a.policy_no r_policy_no, " 
//		+" a.client_ident r_client_ident,"
//		+" b.receive_date r_receive_date,"
//		+" b.receive_no   r_receive_no,  "
//		+" c.names r_names,"
//		+" d.client_id r_client_id,"
//		+" CONCAT('[新 契 約]:  ', (e.sub_std_desc)) as r_standard "
//		+" FROM poss a ,popr b,clnt c,pocl d, nbss e "
//		+" WHERE c.client_id = '" + policy_no + "' "
//		+" AND a.policy_no = b.policy_no "
//		+" AND a.policy_no = d.policy_no " 
//		+" AND d.client_id = c.client_id "
//		+" AND d.client_ident <> 'O1' "
//		+" AND a.sub_std_code_3 = e.sub_std_code "
//		+" UNION"                              //-----新契約弱體(4)
//		+" SELECT "
//		+" a.policy_no r_policy_no, " 
//		+" a.client_ident r_client_ident,"
//		+" b.receive_date r_receive_date,"
//		+" b.receive_no   r_receive_no,  "
//		+" c.names r_names,"
//		+" d.client_id r_client_id,"
//		+" CONCAT('[新 契 約]:  ', (e.sub_std_desc)) as r_standard "
//		+" FROM poss a ,popr b,clnt c,pocl d, nbss e "
//		+" WHERE c.client_id = '" + policy_no + "' "
//		+" AND a.policy_no = b.policy_no "
//		+" AND a.policy_no = d.policy_no " 
//		+" AND d.client_id = c.client_id "
//		+" AND d.client_ident <> 'O1' "
//		+" AND a.sub_std_code_4 = e.sub_std_code "	
//		+" UNION"                               //-----契撤弱體
//		+" SELECT  "
//		+" a.policy_no r_policy_no, "
//		+" c.client_ident r_client_ident,"
//		+" a.receive_date r_receive_date, "
//		+" a.receive_no r_receive_no,  "
//		+" d.names r_names, "
//		+" a.client_id r_client_id, "
//		+" CONCAT('[契      撤]:  ', (b.sub_std_desc)) as r_sub_std_desc "
//		+" FROM psss a,nbss b,pocl c,clnt d"
//		+" WHERE a.sub_std_code = b.sub_std_code"
//		+" AND c.client_id = '" + policy_no + "' "//'H125323575'
//		+" AND a.policy_no = c.policy_no "
//		+" AND d.client_id = c.client_id "
//		+" AND c.client_ident <> 'O1' "));
		
//		141300221087	氣喘                                    
//		141300221087	慢性支氣管炎                            
//		146800103616	貧血                                    
//		146800103616	肝炎                                    
//		141600034355	慢性支氣管炎                            
//		118600024252	血尿                                    
//		112100202007	過重                                    
//		112100202007	Ｂ型肝炎                                
//		176700110513	貧血                                    
//		676700012753	貧血                                    
//		140900083059	尿液異常                                
//		175100043845	血壓異常                                
//		110800105803	妊娠（懷孕）
//      616700021996
		DBConnection.closeStatement(st);
		return list;
	}

}
