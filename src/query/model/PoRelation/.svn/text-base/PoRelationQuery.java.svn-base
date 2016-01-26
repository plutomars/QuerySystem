package query.model.PoRelation;

import java.sql.Statement;
import java.util.HashMap;
import java.util.List;

import query.model.Query;

import database.connection.DBConnection;

public class PoRelationQuery implements Query {
	public final static int RELATION = 1;
	public final static int AGENT = 2;
	public final static int NEWRELATION = 3; // 新契約用
	public final static int PARELATION = 4; // 意外險用

	@Override
	public List<HashMap<String, String>> getResultList(String policy_no,
			int type) {
		// TODO Auto-generated method stub
		Statement st = DBConnection.createStatement();
		List<HashMap<String, String>> list = null;
		switch (type) {
		case PoRelationQuery.RELATION:
			list = DBConnection.getResultList(DBConnection.executeQuery(st,
					"execute procedure cc111i('" + policy_no + "')"));
			break;
		case PoRelationQuery.AGENT:
			list = DBConnection.getResultList(DBConnection.executeQuery(st,
					"execute procedure cc110i('" + policy_no + "')"));
			break;
		case PoRelationQuery.NEWRELATION:
			list = DBConnection.getResultList(DBConnection.executeQuery(st,
					"execute procedure cc111i('" + policy_no + "','I')"));
			break;
		case PoRelationQuery.PARELATION:
			list = DBConnection.getResultList(DBConnection.executeQuery(st,
					"execute procedure papuData('" + policy_no + "')"));
			break;
		}

		DBConnection.closeStatement(st);
		return list;
	}
}
