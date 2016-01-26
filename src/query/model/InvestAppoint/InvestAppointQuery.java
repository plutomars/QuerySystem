package query.model.InvestAppoint;

import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.List;

import query.model.Query;
import database.connection.DBConnection;

public class InvestAppointQuery implements Query {
	public final static int INVESTAPPOINTSWITCH = 1; // ���w�ഫ
	public final static int INVESTAPPOINTWITHDRAW = 2; // ���w����

	/**
	 * 
	 */
	public InvestAppointQuery() {
		// TODO Auto-generated constructor stub
	}


	/**  
	 * @category ������w����O����1
	 * @param policy_no
	 * @param chah_ind 1 �ഫ 2����
	 * @return
	 **/
	public List<HashMap<String, String>> getResultList(String policy_no,
			int type) {
		List<HashMap<String, String>> list = null;
		String cmd = "execute procedure cc_chlh_query(?,?)";
		PreparedStatement st = DBConnection.createPreparedStatement(cmd);

		DBConnection.setPreparedStatementString(st, 1, policy_no);
		DBConnection.setPreparedStatementString(st, 2, String.valueOf(type));
		list = DBConnection.getResultList(DBConnection.executeQuery(st));

		DBConnection.closeStatement(st);
		return list;
	}

	/**
	 * @category ������w����O����2���
	 * @param chah_seq
	 * @param chlh_seq
	 * @return
	 */
	public List<HashMap<String, String>> getResultList(int chah_seq,
			int chlh_seq) {
		List<HashMap<String, String>> list = null;
		String cmd = "execute procedure cc_chld_query(?,?)";

		PreparedStatement st = DBConnection.createPreparedStatement(cmd);

		DBConnection
				.setPreparedStatementString(st, 1, String.valueOf(chah_seq));
		DBConnection
				.setPreparedStatementString(st, 2, String.valueOf(chlh_seq));
		list = DBConnection.getResultList(DBConnection.executeQuery(st));

		DBConnection.closeStatement(st);
		return list;

	}

	/**
	 * @category ������w������
	 * @param chah_seq
	 * @return
	 */
	public List<HashMap<String, String>> getResultList(int chah_seq) {
		List<HashMap<String, String>> list = null;
		String cmd = "execute procedure cc_chah_query(?)";

		PreparedStatement st = DBConnection.createPreparedStatement(cmd);

		DBConnection
				.setPreparedStatementString(st, 1, String.valueOf(chah_seq));

		list = DBConnection.getResultList(DBConnection.executeQuery(st));

		DBConnection.closeStatement(st);
		return list;

	}

}
