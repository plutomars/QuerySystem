package query.model.PayAccount;

import java.sql.Statement;
import java.util.HashMap;
import java.util.List;

import query.model.Query;
import database.connection.DBConnection;
/**
 * 
 * @author 陳冠瑜
 * 
 */
public class PayAccountQuery implements Query {
	public final static int PREMACCOUNT = 1;    // 匯款約定帳戶資料暨異動資料
	
	@Override
	public List<HashMap<String, String>> getResultList(String policy_no,
			int type) {
		return null;
	}
	
	public List<HashMap<String, String>> getResultList(String client_id,
			String client_name, int type) {
		// TODO Auto-generated method stub
		Statement st = DBConnection.createStatement();
		List<HashMap<String, String>> list = null;
		System.out.println(client_id+"*"+client_name);
		// 匯款約定帳戶資料暨異動資料
		if (type == PayAccountQuery.PREMACCOUNT)
			list = DBConnection.getResultList(DBConnection.executeQuery(st,
					"execute procedure cc190i('" + client_id + "','" + client_name
							+ "')"));

		DBConnection.closeStatement(st);
		return list;
	}
}
