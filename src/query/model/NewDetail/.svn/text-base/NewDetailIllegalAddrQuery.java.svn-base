package query.model.NewDetail;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import query.model.Query;
import database.connection.DBConnection;

/**
 * 列管地址資料Query(JavaBean)
 * 
 * @author epf
 * 
 * @version 1.0<br>
 *          100/10/24<br>
 * @since 1.0
 */
public class NewDetailIllegalAddrQuery implements Query {
	public final static int IllegalAddrPo = 1;
	public final static int IllegalAddrAg = 2;
	
	@Override
	public List<HashMap<String, String>> getResultList(String policy_no,
			int type) {
		List<HashMap<String, String>> list = null;

		
		if (type == NOTYPE) {
			list = getResultList(policy_no);
			return list;
		}
		
		Statement st = DBConnection.createStatement();
		
		switch(type){
		case IllegalAddrPo:   // 傳地址
			list = DBConnection.getResultList(DBConnection.executeQuery(st,"execute procedure cc235i('" + policy_no + "')"));
			break;
		case IllegalAddrAg:
			list = DBConnection.getResultList(DBConnection.executeQuery(st,"execute procedure cc236i('" + policy_no + "')"));
			break;
		}	
		return list;
	}

	public List<HashMap<String, String>> getResultList(String policy_no) {
		Statement stat = DBConnection.createLiteStatement();
		String home_addr_ind, mail_addr_ind;
		String o1_id = "", i1_id = "";
		ArrayList<HashMap<String, String>> final_list = new ArrayList<HashMap<String, String>>();

		// 從jpolf撈取o1 i1 id
		HashMap<String, String> id_map = DBConnection.getResultList(
				DBConnection.executeQuery(stat,
						"select o1_id,i1_id from jpolf where policy_no='"
								+ policy_no + "'")).get(0);
		o1_id = id_map.get("o1_id");
		i1_id = id_map.get("i1_id");

		// 地址指示
		HashMap<String, String> addr_ind_map = DBConnection.getResultList(
				DBConnection.executeQuery(stat,
						"select home_addr_ind,mail_addr_ind from jpolf where policy_no='"
								+ policy_no + "'")).get(0);
		home_addr_ind = addr_ind_map.get("home_addr_ind");
		mail_addr_ind = addr_ind_map.get("mail_addr_ind");

		Statement st = DBConnection.createStatement();
		List<HashMap<String, String>> tmplist;

		// 郵寄地址
		String mail_addr = "";
		tmplist = DBConnection.getResultList(DBConnection.executeQuery(st,
				"select std_addr address from addr where client_id ='" + o1_id
						+ "' and addr_ind ='" + mail_addr_ind + "'"));
		for (HashMap<String, String> tmphsmp : tmplist) {
			mail_addr = tmphsmp.get("address");
		}

		// 住所地址
		String home_addr = "";
		tmplist = DBConnection.getResultList(DBConnection.executeQuery(st,
				"select std_addr address from addr where client_id ='" + o1_id
						+ "' and addr_ind ='" + home_addr_ind + "'"));
		for (HashMap<String, String> tmphsmp : tmplist) {
			home_addr = tmphsmp.get("address");
		}
		String[] f_err1, f_err2;
		f_err1 = chkIllegalAddr(o1_id, i1_id, home_addr);
		f_err2 = chkIllegalAddr(o1_id, i1_id, mail_addr);

		if (!Boolean.parseBoolean(f_err1[0])) {
			HashMap<String, String> hsmp = new HashMap<String, String>();
			hsmp.put("ind_desc", "住所地址");
			hsmp.put("addr_type", f_err1[1]);
			hsmp.put("address", home_addr);
			final_list.add(hsmp);
		}
		if (!Boolean.parseBoolean(f_err2[0])) {
			HashMap<String, String> hsmp = new HashMap<String, String>();
			hsmp.put("ind_desc", "收費地址");
			hsmp.put("addr_type", f_err2[1]);
			hsmp.put("address", mail_addr);
			final_list.add(hsmp);
		}
		DBConnection.closeStatement(st);
		DBConnection.closeStatement(stat);
		return final_list;
	}

	public String[] chkIllegalAddr(String o1_id, String i1_id, String addr) {

		if (addr == null || addr.trim().compareTo("") == 0) {
			return new String[] { "true", "00000" };
		}
		if (chkIDerr(o1_id) || chkIDerr(i1_id)) {
			return new String[] { "true", "00000" };
		}

		return chkAddrIserr(addr);

	}

	// 檢核地址
	public String[] chkAddrIserr(String addr) {
		Statement st = DBConnection.createStatement();
		String ind = "";
		int cnt = Integer.parseInt(DBConnection
				.getResultList(
						DBConnection.executeQuery(st,
								"select count(*) count from iaer where std_addr='"
										+ addr + "'")).get(0).get("count"));
		if (cnt > 0) {
			List<HashMap<String, String>> list = DBConnection
					.getResultList(DBConnection.executeQuery(st,
							"select distinct pool_type from iaer where std_addr='"
									+ addr + "' order by 1"));
			for (HashMap<String, String> hsmp : list) {
				if (hsmp.get("pool_type").trim().compareTo("A") == 0)
					ind = ind.trim() + "A";
				else if (hsmp.get("pool_type").trim().compareTo("B") == 0)
					ind = ind.trim() + "B";
				else if (hsmp.get("pool_type").trim().compareTo("C") == 0)
					ind = ind.trim() + "C";
				else if (hsmp.get("pool_type").trim().compareTo("D") == 0)
					ind = ind.trim() + "D";
				else if (hsmp.get("pool_type").trim().compareTo("E") == 0)
					ind = ind.trim() + "E";
				else
					ind = "00000";
			}
			return new String[] { "false", ind };
		}
		return new String[] { "true", ind };
	}

	// 檢核ID
	public boolean chkIDerr(String id) {
		Statement st = DBConnection.createStatement();
		if (id == null || id.trim().compareTo("") == 0)
			return true;
		// 收費員
		int cnt = 0;
		cnt = Integer.parseInt(DBConnection
				.getResultList(
						DBConnection.executeQuery(st,
								"select count(*) count from pccm where id_code='"
										+ id
										+ "' and coll_sts_code in ('0','1')"))
				.get(0).get("count"));
		if (cnt > 0)
			return true;

		// 內勤員工
		cnt = 0;
		cnt = Integer
				.parseInt(DBConnection
						.getResultList(
								DBConnection
										.executeQuery(
												st,
												"select count(*) count from hrcm where employee_id='"
														+ id
														+ "' and empl_sts_code in ( ' ', '0', '1','3', '7')"))
						.get(0).get("count"));
		if (cnt > 0)
			return true;

		// 業務員
		cnt = 0;
		cnt = Integer.parseInt(DBConnection
				.getResultList(
						DBConnection.executeQuery(st,
								"select count(*) count from agnt where agent_code='"
										+ id + "' and ag_sts_code = '0'"))
				.get(0).get("count"));
		if (cnt > 0) {
			DBConnection.closeStatement(st);
			return true;
		}
		DBConnection.closeStatement(st);
		return false;
	}
}
