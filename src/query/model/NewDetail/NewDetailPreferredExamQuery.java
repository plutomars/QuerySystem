package query.model.NewDetail;

import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;

import query.model.Query;
import database.connection.DBConnection;

/**
 * 新契約明細查詢優體保單資料查詢
 * 
 * @author epf
 * 
 * @version 1.0<br>
 *          100/07/28<br>
 * 
 * @since 1.0
 */
public class NewDetailPreferredExamQuery implements Query {

	private Statement stat;

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
		try {
			stat = DBConnection.createLiteStatement(); // sqllite statement
			Statement st = DBConnection.createStatement(); // informix statement
			// // 優體保單只有兩種險種有
			// String plan_code = DBConnection
			// .getResultList(
			// DBConnection.executeQuery(stat,
			// "select basic_plan_code from jpolf where policy_no='"
			// + policy_no + "';")).get(0)
			// .get("basic_plan_code");
			// if (!plan_code.matches("*[UR]PWL*")) {
			// return null;
			// }
			String client_id = "";
			String cmd = "select i1_id from jpolf where policy_no='"
					+ policy_no + "';";
			List<HashMap<String, String>> i1_id_list = DBConnection
					.getResultList(stat.executeQuery(cmd));
			for (HashMap<String, String> hsmp : i1_id_list) {
				client_id = hsmp.get("i1_id").trim();
			}
			// 優體保單等級
			// 先試取受理號碼再抓等級及身高體重
			DecimalFormat digitFormat = new DecimalFormat("0.#");

			Number height = 0, weight = 0;
			Double bmi = 0.0;
			String preferred_Exam_Ind = "";
			String receive_no = "";
			cmd = "SELECT DISTINCT receive_no "
					+ "FROM nbxv WHERE client_id = '" + client_id + "'"
					+ " and policy_no = '" + policy_no + "';";
			for (HashMap<String, String> hsmp : DBConnection.getResultList(st
					.executeQuery(cmd))) {
				receive_no = ((hsmp.get("receive_no") == null) ? "" : hsmp.get(
						"receive_no").trim());
			}
			if (receive_no == null || receive_no.trim().compareTo("") == 0) {
				cmd = "select related_key from nbus where policy_no ='"
						+ policy_no + "'" + " and e_type ='pwl_uw';";
				for (HashMap<String, String> hsmp : DBConnection
						.getResultList(st.executeQuery(cmd))) {
					preferred_Exam_Ind = ((hsmp.get("related_key") == null) ? ""
							: hsmp.get("related_key").trim());
				}
				cmd = "select height,weight from post where policy_no ='"
						+ policy_no + "';";
				for (HashMap<String, String> hsmp : DBConnection
						.getResultList(st.executeQuery(cmd))) {
					height = ((hsmp.get("height") == null) ? 0 : Double
							.parseDouble(hsmp.get("height").trim()));
					weight = ((hsmp.get("weight") == null) ? 0 : Double
							.parseDouble(hsmp.get("weight").trim()));

				}
				bmi = 10000.0 * weight.doubleValue()
						/ (height.doubleValue() * height.doubleValue());
			} else {
				cmd = "select substr(table_id,5,1) ind from pssl"
						+ " where policy_no ='" + policy_no + "' "
						+ " and client_id ='" + client_id + "' "
						+ " and receive_no = '" + receive_no + "'"
						+ " and substr(table_id,1,4)='nbxv';";
				for (HashMap<String, String> hsmp : DBConnection
						.getResultList(st.executeQuery(cmd))) {
					preferred_Exam_Ind = ((hsmp.get("ind") == null) ? "" : hsmp
							.get("ind").trim());
				}
				cmd = "select height,weight from psst where policy_no ='"
						+ policy_no + "' " + "and client_id ='" + client_id
						+ "' " + "and receive_no = '" + receive_no + "'";
				for (HashMap<String, String> hsmp : DBConnection
						.getResultList(st.executeQuery(cmd))) {
					height = ((hsmp.get("height") == null) ? 0 : Double
							.parseDouble(hsmp.get("height").trim()));
					weight = ((hsmp.get("weight") == null) ? 0 : Double
							.parseDouble(hsmp.get("weight").trim()));
				}
				bmi = 10000.0 * weight.doubleValue()
						/ (height.doubleValue() * height.doubleValue());
			}

			// 撈取主要優體保單詳細資料
			cmd = "SELECT exam_item_desc,exam_value,"
					+ " exam_value_rank,exam_respond_value,a.exam_item_code "
					+ "FROM nbxv a,nbxc b,nbux c "
					+ "WHERE a.exam_item_code = b.exam_item_code "
					+ "AND a.exam_item_code = c.exam_item_code"
					+ " AND policy_no = '" + policy_no + "'"
					+ " AND client_id = '" + client_id + "';";
			List<HashMap<String, String>> list = DBConnection
					.getResultList(DBConnection.executeQuery(st, cmd));
			Double cho_value = 0.0, hdl_value = 0.0;
			String cho_hdl_ratio = "";
			for (HashMap<String, String> hsmp : list) {
				hsmp.put("height", Double.toString(height.doubleValue()));
				hsmp.put("weight", Double.toString(weight.doubleValue()));
				hsmp.put("preferred_Exam_Ind", preferred_Exam_Ind);
				hsmp.put("bmi", digitFormat.format(bmi));
				hsmp.put("exam_item_code_desc", hsmp.get("exam_item_code")
						+ hsmp.get("exam_item_desc"));
				if (hsmp.get("exam_item_code").trim().compareTo("CHO") == 0) {
					cho_value = Double.parseDouble(hsmp.get("exam_value"));
				}
				if (hsmp.get("exam_item_code").trim().compareTo("HDL") == 0) {
					hdl_value = Double.parseDouble(hsmp.get("exam_value"));
				}
				if (cho_value > 0 && hdl_value > 0) {
					cho_hdl_ratio = digitFormat.format(cho_value / hdl_value);
				}
				list.set(list.indexOf(hsmp), hsmp);
			}
			// cho_hdl_radio是途中才算出來的，因此要再塞回每一筆資料
			for (HashMap<String, String> hsmp : list) {
				hsmp.put("cho_hdl_ratio", cho_hdl_ratio);
			}
			DBConnection.closeStatement(st);
			return list;

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR1",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
			return null;
		}

	}
}
