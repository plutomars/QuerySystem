package query.model.InvestAuto;

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
public class InvestAutoQuery implements Query {
	public final static int INVESTAUTO = 1;       // 自傳轉換
	public final static int INVESTAUTODETAIL = 2; // 加碼明細
	public final static int INVESTAUTOSTOP = 3;   // 停利查詢

	@Override
	public List<HashMap<String, String>> getResultList(String policy_no,
			int type) {
		return null;
	}

	// 自動轉換
	public List<HashMap<String, String>> getResultList(String policy_no,
			String currency, int type) {
		// TODO Auto-generated method stub
		Statement st = DBConnection.createStatement();
		List<HashMap<String, String>> list = null;

		if (type == InvestAutoQuery.INVESTAUTO)
			list = DBConnection.getResultList(DBConnection.executeQuery(st,
					"execute procedure cc150i('" + policy_no + "','" + currency
							+ "')"));

		DBConnection.closeStatement(st);
		return list;
	}

	// 加碼明細
	public List<HashMap<String, String>> getResultList(String policy_no,
			String currency, String auto_tr_date, int type) {

		Statement st = DBConnection.createStatement();
		List<HashMap<String, String>> list = null;

		if (type == InvestAutoQuery.INVESTAUTODETAIL)
			list = DBConnection.getResultList(DBConnection.executeQuery(st,
					"execute procedure cc151i('" + policy_no + "','" + currency
							+ "','" + auto_tr_date + "')"));

		DBConnection.closeStatement(st);
		return list;
	}

	// 停利查詢
	public List<HashMap<String, String>> getResultList(String policy_no,
			String currency, String beg_date, String end_date,
			String invs_code, int type) {
		Statement st = DBConnection.createStatement();
		List<HashMap<String, String>> list = null;

		if (type == InvestAutoQuery.INVESTAUTOSTOP)
			list = DBConnection.getResultList(DBConnection.executeQuery(st,
					"execute procedure cc152i('" + policy_no + "','" + currency
							+ "','" + beg_date + "','" + end_date + "','"
							+ invs_code + "')"));

		DBConnection.closeStatement(st);
		return list;
	}
}
