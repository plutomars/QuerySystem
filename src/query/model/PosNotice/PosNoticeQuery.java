package query.model.PosNotice;

import java.sql.Statement;
import java.util.HashMap;
import java.util.List;

import database.connection.DBConnection;

import query.model.Query;
/**
 * @author cychu
 *
 * @version 1.0<br/>
 * 			100/09/07<br/>
 * 			照會記錄(Query)
 * 
 * @since 1.0
 */
public class PosNoticeQuery implements Query {

	public final static int POSNOTICE01 = 1;	//照會繳費
	public final static int POSNOTICE02 = 2;	//照會補件
	public final static int POSNOTICE03 = 3;	//體檢原因
	public final static int POSNOTICE04 = 4;	//照會項目
	public final static int POSNOTICE05 = 5;	//體檢項目
	
	@Override
	public List<HashMap<String, String>> getResultList(String policy_no,
			int type) {
		return null;
	}
	
	public List<HashMap<String, String>> getResultList(String policy_no,
			String po_chg_rece_no, String notice_seq, int type) {
		Statement st = DBConnection.createStatement();
		List<HashMap<String, String>> list = null;
		switch (type) {
			case PosNoticeQuery.POSNOTICE01:
				list = DBConnection.getResultList(DBConnection.executeQuery(st,
						"execute procedure cc140i('" + policy_no + "','" 
						+ po_chg_rece_no + "','" + notice_seq + "')"));
				break;
			case PosNoticeQuery.POSNOTICE02:
				list = DBConnection.getResultList(DBConnection.executeQuery(st,
						"execute procedure cc141i('" + policy_no + "','" 
						+ po_chg_rece_no + "','" + notice_seq + "')"));
				break;
			case PosNoticeQuery.POSNOTICE03:
				list = DBConnection.getResultList(DBConnection.executeQuery(st,
						"execute procedure cc143i('" + policy_no + "','" 
						+ po_chg_rece_no + "','" + notice_seq + "')"));
				break;
			case PosNoticeQuery.POSNOTICE04:
				list = DBConnection.getResultList(DBConnection.executeQuery(st,
						"execute procedure cc142i('" + policy_no + "','" 
						+ po_chg_rece_no + "','" + notice_seq + "')"));
				break;
			case PosNoticeQuery.POSNOTICE05:
				list = DBConnection.getResultList(DBConnection.executeQuery(st,
						"execute procedure cc144i('" + policy_no + "','" 
						+ po_chg_rece_no + "','" + notice_seq + "')"));
				break;
		}	
		DBConnection.closeStatement(st);
		return list;
	}

}
