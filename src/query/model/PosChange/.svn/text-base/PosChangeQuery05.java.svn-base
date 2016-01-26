package query.model.PosChange;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;

import database.connection.DBConnection;

import query.model.Query;

public class PosChangeQuery05 implements Query {

	public PosChangeQuery05() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<HashMap<String, String>> getResultList(String po_chg_rece_no,
			int arg1) {
		// TODO Auto-generated method stub
		List<HashMap<String, String>> list = getResultList(po_chg_rece_no);
		return list;
	}

	public List<HashMap<String, String>> getResultList(String po_chg_rece_no) {
		List<HashMap<String, String>> list = null;
		String sql = "execute procedure psg84i01(?)";
		PreparedStatement pst = DBConnection.createPreparedStatement(sql);
		DBConnection.setPreparedStatementString(pst, 1, po_chg_rece_no);
		list = DBConnection.getResultList(DBConnection.executeQuery(pst));
		DBConnection.closeStatement(pst);
		return list;
	}
}
