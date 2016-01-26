package query.model.ValueRepay;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;

import database.connection.DBConnection;

import query.model.Query;

/**
 * @author F1256819
 * @category 還本未回回覆 抵繳保單
 */
public class ValueRepayQuery11 implements Query {

	public ValueRepayQuery11() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<HashMap<String, String>> getResultList(String arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<HashMap<String, String>> getResultList(String policy_no,
			String cp_anniv_date) {
		// TODO Auto-generated method stub
		List<HashMap<String, String>> list = null;
		String s = "execute procedure psca_premium_pay(?,?)";
		PreparedStatement pst = DBConnection.createPreparedStatement(s);
		DBConnection.setPreparedStatementString(pst, 1, policy_no);
		DBConnection.setPreparedStatementString(pst, 2, cp_anniv_date);
		list = DBConnection.getResultList(DBConnection.executeQuery(pst));
		DBConnection.closeStatement(pst);
		return list;
	}

}
