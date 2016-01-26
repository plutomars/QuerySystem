package query.model.NewDetail;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;

import query.model.Query;
import database.connection.DBConnection;

/**
 * 新契約查詢公會索引資料Query
 * 
 * @author epf
 * 
 */
public class NewDetailNewAssoIndexQuery implements Query {

	@Override
	public List<HashMap<String, String>> getResultList(String policy_no,
			int type) {
		// TODO Auto-generated method stub
		if (type == NOTYPE) {
			List<HashMap<String, String>> list = getResultList(policy_no);
			return list;
		}
		return null;

	}

	public List<HashMap<String, String>> getResultList(String policy_no) {
		Statement st = DBConnection.createStatement();
		List<HashMap<String, String>> list = null;
		String s = "execute procedure cc225i('" + policy_no + "')";
		list = DBConnection.getResultList(DBConnection.executeQuery(st, s));
		DBConnection.closeStatement(st);
		return list;
	}

	public List<HashMap<String, String>> getResultList(String client_id,
			String nbui_industry, String policy_type, String un_ins_type,
			String un_plan_type, String un_rpt_item, String nbui_company_code) {
		List<HashMap<String, String>> list = null;
		String s = "execute procedure cc226i(?,?,?,?,?,?,?)";
		PreparedStatement st = DBConnection.createPreparedStatement(s);
		DBConnection.setPreparedStatementString(st, 1, client_id);
		DBConnection.setPreparedStatementString(st, 2, nbui_industry);
		DBConnection.setPreparedStatementString(st, 3, policy_type);
		DBConnection.setPreparedStatementString(st, 4, un_ins_type);
		DBConnection.setPreparedStatementString(st, 5, un_plan_type);
		DBConnection.setPreparedStatementString(st, 6, un_rpt_item);
		DBConnection.setPreparedStatementString(st, 7, nbui_company_code);
		list = DBConnection.getResultList(DBConnection.executeQuery(st));
		return list;
	}

}
