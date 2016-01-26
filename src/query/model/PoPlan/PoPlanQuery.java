package query.model.PoPlan;

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
 * 			100/09/07<br/>
 * 			保障險種資料查詢(Query)
 * 
 * @since 1.0
 */
public class PoPlanQuery implements Query {

	public final static int POPLAN = 1;
	public final static int POPLANPREM = 2;

	@Override
	public List<HashMap<String, String>> getResultList(String policy_no,
			int type) {
		Statement st = DBConnection.createStatement();
		List<HashMap<String, String>> list = null;
		if (type == PoPlanQuery.POPLAN)
			list = DBConnection.getResultList(DBConnection.executeQuery(st,
					"execute procedure cc112i('" + policy_no + "')"));
		else if (type == PoPlanQuery.POPLANPREM)
			list = DBConnection.getResultList(DBConnection.executeQuery(st,
					"execute procedure cc112i_ad('" + policy_no + "')"));
		DBConnection.closeStatement(st);
		return list;
	}
}
