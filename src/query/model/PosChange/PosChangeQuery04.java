package query.model.PosChange;

import java.sql.Statement;
import java.util.HashMap;
import java.util.List;

import query.model.Query;
import database.connection.DBConnection;

public class PosChangeQuery04 implements Query {

	@Override
	public List<HashMap<String, String>> getResultList(String po_chg_rece_no,
			int arg1) {
		// TODO Auto-generated method stub
		List<HashMap<String, String>> list = getResultList(po_chg_rece_no);
		return list;
	}

	public List<HashMap<String, String>> getResultList(String po_chg_rece_no) {
		Statement st = DBConnection.createStatement();
		List<HashMap<String, String>> list = null;
		list = DBConnection.getResultList(DBConnection.executeQuery(st,
				"execute procedure cc139i('" + po_chg_rece_no + "')"));
		DBConnection.closeStatement(st);
		return list;
	}

}
