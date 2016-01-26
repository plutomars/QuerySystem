package query.model.ClaimAssoDetail;

import java.sql.Statement;
import java.util.HashMap;
import java.util.List;

import database.connection.DBConnection;

import query.model.Query;

/**
 * @author cychu
 * 
 * @version 1.0<br/>
 * 			101/04/24<br/>
 * 			公會投保記錄資料－明細(Query)
 *
 * @since 1.0
 */
public class ClaimAssoDetailQuery implements Query {

	@Override
	public List<HashMap<String, String>> getResultList(String policy_no, int type) {
		return null;
	}
	
	public List<HashMap<String, String>> getResultList(String client_id,
			String nbui_industry, String policy_type, String un_ins_type,
			String un_plan_type, String un_rpt_item, String nbui_company_code) {
		
		Statement st = DBConnection.createStatement();
		List<HashMap<String, String>> list = null;
		list = DBConnection.getResultList(DBConnection.executeQuery(st, 
				"execute procedure cc226i('" + client_id + "','" + 
				nbui_industry + "','" + policy_type + "','" + 
				un_ins_type + "','" + un_plan_type + "','" + 
				un_rpt_item + "','" + nbui_company_code + "')"));
		DBConnection.closeStatement(st);
		return list;
	}
	
	//取得查詢授權
	public List<HashMap<String, String>> getAuthResult(String client_id) {
		Statement st = DBConnection.createStatement();
		List<HashMap<String, String>> authList = null;
		authList = DBConnection.getResultList(DBConnection.executeQuery(st,
				"execute procedure chkClaim('" + client_id + "')"));
		DBConnection.closeStatement(st);
		return authList;
	}

}
