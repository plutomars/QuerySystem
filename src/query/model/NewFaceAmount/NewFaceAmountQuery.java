package query.model.NewFaceAmount;

import java.sql.Statement;
import java.util.HashMap;
import java.util.List;

import query.model.Query;
import database.connection.DBConnection;
/**
 * 
 * @author ���a��
 * 
 */
public class NewFaceAmountQuery implements Query {
	public final static int NEWFACEBIRTH = 1;  // �ͤ�+¾�~�N�X�d��
	public final static int NEWFACEOCCUP = 2;  // ¾�~�N�X�����d��
	public final static int NEWFACEAMOUNT = 3; // �֭p�O�B�d��
	public final static int NEWFACEIPA = 4;    // IPA��O���v��Ƭd��

	@Override
	public List<HashMap<String, String>> getResultList(String client_id,
			int type) {
		// TODO Auto-generated method stub
		Statement st = DBConnection.createStatement();
		List<HashMap<String, String>> list = null;
		if (type == NewFaceAmountQuery.NEWFACEBIRTH)
			list = DBConnection
					.getResultList(DBConnection
							.executeQuery(
									st,
									"SELECT tdate() r_today, birth_date r_birth_date, occupation_code r_occu_code FROM clnt WHERE client_id = '"
											+ client_id + "';"));
		else if (type == NewFaceAmountQuery.NEWFACEOCCUP)
			list = DBConnection
					.getResultList(DBConnection
							.executeQuery(
									st,
									"SELECT TRIM(occupation_desc)||' '||occupation_level||' ��' r_occupation FROM nboc WHERE occupation_code='"
											+ client_id + "';"));
		else if (type == NewFaceAmountQuery.NEWFACEIPA)
			list = DBConnection
			.getResultList(DBConnection
					.executeQuery(
							st,
							"execute procedure cc014i01('" 
									+ client_id + "');"));

		DBConnection.closeStatement(st);
		return list;
	}

	public List<HashMap<String, String>> getResultList(String client_id,
			String ag_ind, String occu_code, int type) {
		Statement st = DBConnection.createStatement();
		List<HashMap<String, String>> list = null;
//		if (type == NewFaceAmountQuery.NEWFACEAMOUNT)
			list = DBConnection.getResultList(DBConnection.executeQuery(st,
					"execute procedure cc014i('" + client_id + "','" + ag_ind
							+ "','" + occu_code + "','" +type+ "')"));
//		System.out.println(list.get(0).get("r_desc4")+"--"+list.get(0).get("r_desc3"));
		DBConnection.closeStatement(st);
		return list;
	}
}
