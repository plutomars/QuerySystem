package query.model.NewDetail;

import java.sql.Statement;
import java.util.HashMap;
import java.util.List;

import database.connection.DBConnection;

import query.model.Query;

/**
 * 新契約明細簽收單查詢 Query
 * 
 * @author epf
 * @version 1.0<br>
 * 
 * @since 100/10/14
 */
public class NewDetailSignPaperQuery implements Query {

	@Override
	public List<HashMap<String, String>> getResultList(String policy_no,
			int type) {
		if (type == NOTYPE) {
			List<HashMap<String, String>> list = getResultList(policy_no);
			return list;
		}
		return null;

	}

	public List<HashMap<String, String>> getResultList(String policy_no) {
		Statement st = DBConnection.createStatement();
		List<HashMap<String, String>> list = DBConnection
				.getResultList(DBConnection.executeQuery(st,
						"execute procedure cc210i('" + policy_no + "');"));
		DBConnection.closeStatement(st);
		return list;
	}

}
