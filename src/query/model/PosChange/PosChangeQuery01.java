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

	// for �s������, �ushow�����ץ�
	//	public List<HashMap<String, String>> getResultList(String policy_no,
	//			String client_ind) {
	//		Statement st = DBConnection.createStatement();
	//		List<HashMap<String, String>> list = null;
	//		list = DBConnection.getResultList(DBConnection.executeQuery(st,
	//				"execute procedure cc136i('" + policy_no +"','"+client_ind+ "')"));
	//		DBConnection.closeStatement(st);
	//		return list;
	//	}
	
	
	public List<HashMap<String, String>> getResultList(String policy_no,//101.04.02  �s�W�O�渹�X/�ӽФHID/���z���X �����ްѼ�
			String client_ind) {
		Statement st = DBConnection.createStatement();
		List<HashMap<String, String>> list = null;
		list = DBConnection.getResultList(DBConnection.executeQuery(st,
				"execute procedure cc136i('" + policy_no +"','"+client_ind+ "')"));
		DBConnection.closeStatement(st);
		return list;
	}
	
		public List<HashMap<String, String>> getResultList(String policy_no,//101.04.02  �s�W�O�渹�X/client_id=''/�ӽФHID/���z���X �����ްѼ�
				String client_ind,String applicant_id,String rece_no) {
			Statement st = DBConnection.createStatement();
			List<HashMap<String, String>> list = null;
			list = DBConnection.getResultList(DBConnection.executeQuery(st,
					"execute procedure cc136i('" + policy_no +"','"+client_ind+ "','"+applicant_id+ "','"+rece_no+ "')"));
			DBConnection.closeStatement(st);
			return list;
		}
}
