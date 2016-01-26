package query.model.NewDetail;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;

import query.model.Query;
import database.connection.DBConnection;

/**
 * �s�������Ӱ򥻸�ƭn�O�H������Ƭd��
 * 
 * @author epf
 * 
 * @version 1.0
 * 
 * @since 1.0
 */
public class NewDetailCommQuery implements Query {
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

			stat = DBConnection.createLiteStatement();

			// �ɻ����Ϊ�hashmap,list,statement
			List<HashMap<String, String>> tmplist;
			Statement st = DBConnection.createStatement();

			// ������jpolf�������
			String cmd = "select o1_id,o1_name,o1_birth,home_addr_ind,mail_addr_ind"
					+ ",policy_no,po_sts_code,modx,method,mode_prem,app_apply_date"
					+ ",po_issue_date,in_force_date,' ' image_prn_date,uw_write_date"
					+ ",' ' home_tel,mail_tel,' ' mobile_phone,' ' e_mail,class_type,o1_occu "
					+ ",mail_zip_code||mail_addr mail_addr,insurance_type,o1_sign_ptn_card,fy_billing_ind"
					+ " from jpolf where policy_no = '" + policy_no + "';";
			ResultSet gs = stat.executeQuery(cmd);
			List<HashMap<String, String>> list = null;
			list = DBConnection.getResultList(gs);
			// jpolf�����
			for (HashMap<String, String> hsmp : list) {
				// ��l�ݱqinformix��������
				// ��a�q��
				tmplist = DBConnection
						.getResultList(DBConnection
								.executeQuery(
										st,
										"select nvl(trim(tel_1),'')||' / '||nvl(tel_2,'') home_tel,nvl(zip_code,'')||address address from addr where client_id ='"
												+ hsmp.get("o1_id").toString()
												+ "' and addr_ind ='"
												+ hsmp.get("home_addr_ind")
														.toString() + "'"));
				for (HashMap<String, String> tmphsmp : tmplist) {
					hsmp.put("home_tel", tmphsmp.get("home_tel").toString());
					hsmp.put("home_addr", tmphsmp.get("address").toString());
				}

//				// �l�H�a�} jpolf�w��
//				tmplist = DBConnection.getResultList(DBConnection.executeQuery(
//						st,
//						"select address from addr where client_id ='"
//								+ hsmp.get("o1_id").toString()
//								+ "' and addr_ind ='"
//								+ hsmp.get("mail_addr_ind").toString() + "'"));
//				for (HashMap<String, String> tmphsmp : tmplist) {
//					hsmp.put("mail_addr", tmphsmp.get("address").toString());
//				}
				
				// email���
				tmplist = DBConnection.getResultList(DBConnection.executeQuery(
						st, "select tel_1,address from addr where client_id ='"
								+ hsmp.get("o1_id").toString()
								+ "' and addr_ind ='E'"));
				for (HashMap<String, String> tmphsmp : tmplist) {
					hsmp.put("mobile_phone", tmphsmp.get("tel_1"));
					hsmp.put("e_mail", tmphsmp.get("address"));
				}

				// �s���
				String prn_date_table = "nbis";
				if (hsmp.get("insurance_type").equals("A"))
					prn_date_table = "anis";
				if (hsmp.get("insurance_type").equals("P"))
					prn_date_table = "pais";
				
				tmplist = DBConnection.getResultList(DBConnection.executeQuery(
						st, "select image_prn_date from "+prn_date_table+" where policy_no ='"
								+ hsmp.get("policy_no").toString() + "'"));
				for (HashMap<String, String> tmphsmp : tmplist) {
					hsmp.put("image_prn_date", tmphsmp.get("image_prn_date"));
				}
				list.set(list.indexOf(hsmp), hsmp);
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
