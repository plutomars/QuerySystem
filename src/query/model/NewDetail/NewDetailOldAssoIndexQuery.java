package query.model.NewDetail;

import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.List;

import query.model.Query;
import database.connection.DBConnection;

/**
 * �s���������¤��|���޸��Query
 * 
 * @author epf
 * 
 * @version 1.0<br>
 *          100/10/20<br>
 * 
 * @since 1.0
 */
public class NewDetailOldAssoIndexQuery implements Query {

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
		PreparedStatement st = DBConnection
				.createPreparedStatement("execute procedure cc228i(?)");
		DBConnection.setPreparedStatementString(st, 1, policy_no);
		List<HashMap<String, String>> list = DBConnection
				.getResultList(DBConnection.executeQuery(st));
		// String cmd = " SELECT distinct nbui.nbui_industry, "
		// + " nbui.client_id, nbui_name, face_amt, "
		// + " a.desc, ' ' nbui_company_name, effect_date, nbui_company_code, "
		// + " nbui_type,  nbui_ins_type,  nbui_clnt_type, "
		// + " nbui_pno,  process_date,  expired_date,"
		// + " ' ' clnt_type_desc, app_apply_date  FROM   nbui,OUTER etab a"
		// + " WHERE nbui.client_id = '" + client_id + "'"
		// + " AND  nbui.nbui_type = a.e_type "
		// + " AND  a.code = 'NU'  ORDER BY 2, 8, 7 DESC ";
		// List<HashMap<String, String>> list = DBConnection
		// .getResultList(DBConnection.executeQuery(st, cmd));
		// for (HashMap<String, String> hsmp : list) {
		// String e_type = "";
		// if (hsmp.get("nbui_industry").compareTo("L") == 0) {
		// hsmp.put("nbui_industry_desc", "���I");
		// e_type = "0" + hsmp.get("nbui_company_code");
		// } else if (hsmp.get("nbui_industry").compareTo("N") == 0) {
		// hsmp.put("nbui_industry_desc", "���I");
		// e_type = "1" + hsmp.get("nbui_company_code");
		// } else if (hsmp.get("nbui_industry").compareTo("R") == 0) {
		// hsmp.put("nbui_industry_desc", "����");
		// e_type = "0" + hsmp.get("nbui_company_code");
		// } else if (hsmp.get("nbui_industry").compareTo("r") == 0) {
		// hsmp.put("nbui_industry_desc", "����");
		// e_type = "1" + hsmp.get("nbui_company_code");
		// } else {
		// hsmp.put("nbui_industry_desc", "���I");
		// e_type = "0" + hsmp.get("nbui_company_code");
		// }
		//
		// // ���q�W��
		// cmd =
		// "select nvl(desc,'') nbui_company_name from etab where code = 'co' and e_type ='"
		// + e_type + "'";
		// hsmp.put(
		// "nbui_company_name",
		// DBConnection
		// .getResultList(DBConnection.executeQuery(st, cmd))
		// .get(0).get("nbui_company_name"));
		// // �Ȥ�m�W
		// cmd = "select nvl(names,'') names from clnt where client_id ='"
		// + client_id + "'";
		// hsmp.put(
		// "nbui_name",
		// DBConnection
		// .getResultList(DBConnection.executeQuery(st, cmd))
		// .get(0).get("names"));
		//
		// if (hsmp.get("nbui_type").compareTo("05") == 0
		// || hsmp.get("nbui_type").compareTo("06") == 0) {
		// // ���O
		// if (hsmp.get("nbui_ins_type").compareTo("01") == 0) {
		// hsmp.put("nbui_type_desc", "���I");
		// } else if (hsmp.get("nbui_ins_type").compareTo("02") == 0) {
		// hsmp.put("nbui_type_desc", "�N�~�I");
		// } else if (hsmp.get("nbui_ins_type").compareTo("03") == 0) {
		// hsmp.put("nbui_type_desc", "���d�I");
		// } else if (hsmp.get("nbui_ins_type").compareTo("04") == 0) {
		// hsmp.put("nbui_type_desc", "���ILF");
		// } else if (hsmp.get("nbui_ins_type").compareTo("G1") == 0) {
		// hsmp.put("nbui_type_desc", "���ILF");
		// } else if (hsmp.get("nbui_ins_type").compareTo("05") == 0) {
		// hsmp.put("nbui_type_desc", "���IPA");
		// } else if (hsmp.get("nbui_ins_type").compareTo("G2") == 0) {
		// hsmp.put("nbui_type_desc", "���IPA");
		// } else if (hsmp.get("nbui_ins_type").compareTo("09") == 0) {
		// hsmp.put("nbui_type_desc", "�ȥ��I");
		// }
		// // �Ȥ����O
		// if (hsmp.get("nbui_clnt_type").compareTo("01") == 0) {
		// hsmp.put("clnt_type_desc", "����14�����������H");
		// } else if (hsmp.get("nbui_clnt_type").compareTo("02") == 0) {
		// hsmp.put("clnt_type_desc", "�߯��ॢ�κ믫�Ӯz���H");
		// } else {
		// hsmp.put("clnt_type_desc", "");
		// }
		//
		// }
		//
		// if (hsmp.get("nbui_type").compareTo("12") == 0) {
		// if (hsmp.get("nbui_ins_type").compareTo("G1") == 0) {
		// hsmp.put("nbui_type_desc", "���I");
		// } else if (hsmp.get("nbui_ins_type").compareTo("G2") == 0) {
		// hsmp.put("nbui_type_desc", "�ˮ`�I");
		// } else if (hsmp.get("nbui_ins_type").compareTo("G3") == 0) {
		// hsmp.put("nbui_type_desc", "�e�f���");
		// } else if (hsmp.get("nbui_ins_type").compareTo("G4") == 0) {
		// hsmp.put("nbui_type_desc", "�N�~���");
		// } else if (hsmp.get("nbui_ins_type").compareTo("G5") == 0) {
		// hsmp.put("nbui_type_desc", "�e�f���");
		// } else if (hsmp.get("nbui_ins_type").compareTo("G5") == 0) {
		// hsmp.put("nbui_type_desc", "�N�~���");
		// }
		// }
		//
		// if (hsmp.get("nbui_type").compareTo("13	") == 0) {
		// if (hsmp.get("nbui_ins_type").compareTo("01") == 0) {
		// hsmp.put("nbui_type_desc", "���I");
		// } else if (hsmp.get("nbui_ins_type").compareTo("02") == 0) {
		// hsmp.put("nbui_type_desc", "�ˮ`�I");
		// } else if (hsmp.get("nbui_ins_type").compareTo("G1") == 0) {
		// hsmp.put("nbui_type_desc", "������I");
		// } else if (hsmp.get("nbui_ins_type").compareTo("G2") == 0) {
		// hsmp.put("nbui_type_desc", "����ˮ`�I");
		// }
		// }
		//
		// }
		DBConnection.closeStatement(st);
		return list;
	}
}
