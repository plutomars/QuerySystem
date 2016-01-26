package query.model.PremBldt;

import java.sql.Statement;
import java.util.HashMap;
import java.util.List;

import query.model.Query;
import database.connection.DBConnection;
/**
 * 
 * @author cychu
 *
 * @version 1.0<br/>
 * 			101/04/11<br/>
 * 			送金記錄查詢－入帳資料/修改歷史(Query)
 * 
 * @since 1.0
 */
public class PremBldtQuery01 implements Query {
	
	public final static int PREMBLDT02 = 1;
	public final static int PREMBLDT03 = 2;
	
	@Override
	public List<HashMap<String, String>> getResultList(String arg0, int arg1) {
		return null;
	}
	
	public List<HashMap<String, String>> getResultList(String bill_no,
			String related_key, int type) {
		Statement st = DBConnection.createStatement();
		List<HashMap<String, String>> list = null;
		if (type == PremBldtQuery01.PREMBLDT02) {
			list = DBConnection.getResultList(DBConnection.executeQuery(st, 
					"execute procedure cc242i('" + bill_no + "','"
					+ related_key + "')"));
		} else if (type == PremBldtQuery01.PREMBLDT03) {
			list = DBConnection.getResultList(DBConnection.executeQuery(st, 
					"execute procedure cc243i('" + bill_no + "','"
					+ related_key + "')"));
		}
		DBConnection.closeStatement(st);
		return list;
	}

}
