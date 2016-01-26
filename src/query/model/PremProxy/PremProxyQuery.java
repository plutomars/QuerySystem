package query.model.PremProxy;

import java.sql.Statement;
import java.util.HashMap;
import java.util.List;

import database.connection.DBConnection;
import query.model.Query;
/**
 * 
 * @author ³¯«a·ì
 * 
 */
public class PremProxyQuery implements Query {

	public final static int PREMPROXYMAIN = 1;
	public final static int PREMPROXYCHANGE = 2;
	public final static int PREMPROXYBACK = 3;
	public final static int PREMPROXYSTOP = 4; //101-10-03 ·s¼W

	public List<HashMap<String, String>> getResultList(String policy_no,
			int type) {
		return null;
	}

	public List<HashMap<String, String>> getResultList(String policy_no,
			String bank_op_ind, int type) {

		Statement st = DBConnection.createStatement();
		List<HashMap<String, String>> list = null;
		if (type == PremProxyQuery.PREMPROXYMAIN)
			list = DBConnection.getResultList(DBConnection.executeQuery(st,
					"execute procedure cc124i('" + policy_no + "','"
							+ bank_op_ind + "')"));
		else if (type == PremProxyQuery.PREMPROXYCHANGE)
			list = DBConnection.getResultList(DBConnection.executeQuery(st,
					"execute procedure cc125i('" + policy_no + "','"
							+ bank_op_ind + "')"));
		else if (type == PremProxyQuery.PREMPROXYBACK)
			list = DBConnection.getResultList(DBConnection.executeQuery(st,
					"execute procedure cc126i('" + policy_no + "','"
							+ bank_op_ind + "')"));
		else if (type == PremProxyQuery.PREMPROXYSTOP)
			list = DBConnection.getResultList(DBConnection.executeQuery(st,
					"execute procedure cc129i('" + policy_no + "','"
							+ bank_op_ind + "')")); 
		DBConnection.closeStatement(st);
		return list;
	}

}
