package query.model.NewDetail;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;

import query.model.Query;
import database.connection.DBConnection;

/**
 * 新契約明細照會項目資料查詢
 * 
 * @author epf
 * 
 * @version 1.0<br>
 *          100/07/28<br>
 * 
 * @since 1.0
 */
public class NewDetailNoticeQuery implements Query {	

	@Override
	public List<HashMap<String, String>> getResultList(String policy_no,
			int type) {
		// TODO Auto-generated method stub
		if (type==NOTYPE){
			List<HashMap<String, String>> list = getResultList(policy_no);
			return list;	
		}
		return null;
	}
	
	public List<HashMap<String, String>> getResultList(String policy_no) {
		try {
			Statement stat = DBConnection.createLiteStatement();
			Statement st = DBConnection.createStatement();

			String cmd = "select app_apply_date from jpolf where policy_no = '"
					+ policy_no + "';";

			// 抓取sqllite的要保日
			String app_apply_date = "";
			for (HashMap<String, String> tmphsmp : DBConnection
					.getResultList(stat.executeQuery(cmd))) {
				app_apply_date = tmphsmp.get("app_apply_date");
			}
			PreparedStatement prest = DBConnection
					.createPreparedStatement("execute procedure cc215i(?)");
			DBConnection.setPreparedStatementString(prest, 1, policy_no);
			List<HashMap<String, String>> list = DBConnection
					.getResultList(prest.executeQuery());
			DBConnection.closeStatement(prest);
			List<HashMap<String, String>> final_list = new ArrayList<HashMap<String, String>>();
			for (HashMap<String, String> hsmp : list) {
				PreparedStatement prst = DBConnection
						.createPreparedStatement("execute procedure cc216i(?,?)");
				DBConnection.setPreparedStatementString(prst, 1, policy_no);
				DBConnection.setPreparedStatementString(prst, 2,
						hsmp.get("r_notify_date"));
				List<HashMap<String, String>> tmp_list = DBConnection
						.getResultList(prst.executeQuery());
				DBConnection.closeStatement(prst);
				for (HashMap<String, String> tmphsmp : tmp_list) {
					tmphsmp.put("app_apply_date", app_apply_date);
					tmphsmp.putAll(hsmp);
					final_list.add(tmphsmp);
				}
			}

			DBConnection.closeStatement(stat);
			DBConnection.closeStatement(st);
			return final_list;

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR1",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
			return null;
		}
	}
}
