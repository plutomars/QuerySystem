package query.model.PosChange;

import java.sql.Statement;
import java.util.HashMap;
import java.util.List;

import query.model.Query;
import database.connection.DBConnection;

public class PosChangeQuery01 implements Query {

	@Override
	// TODO Auto-generated method stub
	public List<HashMap<String, String>> getResultList(String policy_no,
			int arg1) {
		Statement st = DBConnection.createStatement();
		List<HashMap<String, String>> list = null;
		list = DBConnection.getResultList(DBConnection.executeQuery(st,
				"execute procedure cc136i('" + policy_no + "')"));
		DBConnection.closeStatement(st);
		return list;
	}

	// for 新契約用, 只show未結案件
	//	public List<HashMap<String, String>> getResultList(String policy_no,
	//			String client_ind) {
	//		Statement st = DBConnection.createStatement();
	//		List<HashMap<String, String>> list = null;
	//		list = DBConnection.getResultList(DBConnection.executeQuery(st,
	//				"execute procedure cc136i('" + policy_no +"','"+client_ind+ "')"));
	//		DBConnection.closeStatement(st);
	//		return list;
	//	}
	
	
	public List<HashMap<String, String>> getResultList(String policy_no,//101.04.02  新增保單號碼/申請人ID/受理號碼 之索引參數
			String client_ind) {
		Statement st = DBConnection.createStatement();
		List<HashMap<String, String>> list = null;
		list = DBConnection.getResultList(DBConnection.executeQuery(st,
				"execute procedure cc136i('" + policy_no +"','"+client_ind+ "')"));
		DBConnection.closeStatement(st);
		return list;
	}
	
		public List<HashMap<String, String>> getResultList(String policy_no,//101.04.02  新增保單號碼/client_id=''/申請人ID/受理號碼 之索引參數
				String client_ind,String applicant_id,String rece_no) {
			Statement st = DBConnection.createStatement();
			List<HashMap<String, String>> list = null;
			list = DBConnection.getResultList(DBConnection.executeQuery(st,
					"execute procedure cc136i('" + policy_no +"','"+client_ind+ "','"+applicant_id+ "','"+rece_no+ "')"));
			DBConnection.closeStatement(st);
			return list;
		}
}
