package query.model.PremPostal;
/**
 * @author cora
 *
 * @version 1.0<br/>
 * 			101/11/07<br/>
 * 			劃撥/ATM/便利商店繳費查詢(Query)
 * 
 * @since 1.0
 */
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;

import database.connection.DBConnection;

import query.model.Query;

public class PremPostalQuery implements Query {
//	public final static int COMMBASIC = 1;
//	public final static int DETAIL    = 2;
//	public final static int SUBDETAIL = 3;
	@Override
	public List<HashMap<String, String>> getResultList(String policy_no, int type) {
		Statement st = DBConnection.createStatement();
		List<HashMap<String, String>> list = null;

		Statement stLite = DBConnection.createLiteStatement();
//			JOptionPane.showMessageDialog(null, "\uE031\u9023\u91AB\u4E8B\u6AA2\u9A57\u6240\t");
		String cmd = "select policy_no ,po_sts_code po_sts_desc,modx modx_desc,method method_desc,"
					   + "o1_name owner_name,i1_name insured_name,po_issue_date,paid_to_date,"
					   + "prem_susp,0 div_amt,mode_prem gross_mode_prem,currency" 
					   + " from jpolf where policy_no = '"+ policy_no + "'";
		list = getOtherFileds(DBConnection.getResultList(DBConnection.executeQuery(stLite,cmd)),st);
		DBConnection.closeStatement(stLite);

//			System.out.println("beg");
		DBConnection.closeStatement(st);
		return list;
	}
	
	public List<HashMap<String, String>> getResultList(String policy_no,String currency,String pcrc_kind)
	{
		Statement st = DBConnection.createStatement();
		List<HashMap<String, String>> list = null;
		
		list = DBConnection.getResultList(DBConnection.executeQuery(st,
	 			"execute procedure cc245i('" + policy_no+"','"+currency+"','"+ pcrc_kind + "')"));
		return list;
	}
	
	public List<HashMap<String, String>> getResultList(String policy_no,String pcrc_key)
	{
		Statement st = DBConnection.createStatement();
		List<HashMap<String, String>> list = null;
	
		list = DBConnection.getResultList(DBConnection.executeQuery(st,
	 			"execute procedure cc245i02('" + policy_no+"','"+ pcrc_key + "')"));
		return list;
	}
	
	private List<HashMap<String, String>> getOtherFileds(List<HashMap<String, String>> list,Statement st)
	{
//		Statement st = DBConnection.createStatement();
		List<HashMap<String, String>> Qlist = null;
		String f_cmd = null;
		
		for (HashMap<String, String> hsmap : list) {  // 保費計算+ 紅利計算
		    f_cmd = "execute procedure cc001i_ad('"+ hsmap.get("policy_no") +"','"+hsmap.get("paid_to_date")+"')";	
		    Qlist = DBConnection.getResultList(DBConnection.executeQuery(st,f_cmd));
		    hsmap.put("gross_mode_prem",Qlist.get(0).get("r_gross_mode_prem"));
		    
		    f_cmd = "execute procedure cc245i01('"+ hsmap.get("policy_no") +"')";
		    Qlist = DBConnection.getResultList(DBConnection.executeQuery(st,f_cmd));
		    hsmap.put("div_amt",Qlist.get(0).get("r_div_amt"));
		}
		return list;
	}
	

}
