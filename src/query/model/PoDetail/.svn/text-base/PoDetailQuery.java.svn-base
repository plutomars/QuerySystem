package query.model.PoDetail;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;

import query.model.Query;
import database.connection.DBConnection;

/**
 * 保單明細
 * 
 * @author cora 100/08
 */
public class PoDetailQuery implements Query {
	public final static int COMMBASIC = 1;
	public final static int PODETAIL_PL = 2;
	public final static int PODETAIL_A = 3;
	public final static int PODETAIL_U = 4;
	public final static int PODETAIL_I = 5;
	public final static int PODETAIL_ILIST = 6;
	public final static int PODETAIL_VALIST = 7;
	public final static int PODETAIL_PREM = 8;
	public final static int PODETAIL_TARGET = 9;
	public final static int PODETAIL_PG2 = 10;
	public final static int PODETAIL_ECO = 11; // 帳戶清單 cc192i
	public final static int PODETAIL_PWD = 12; // 密碼列印記錄 cc195i
	public final static int PODETAIL_N = 13;

	@Override
	public List<HashMap<String, String>> getResultList(String policy_no,
			int type) {
		// TODO Auto-generated method stub

		Statement st = DBConnection.createStatement();
		List<HashMap<String, String>> list = null;
		switch (type) {
		case PoDetailQuery.COMMBASIC: // 共通基本資料
			Statement stLite = DBConnection.createLiteStatement();
			// JOptionPane.showMessageDialog(null,
			// "\uE031\u9023\u91AB\u4E8B\u6AA2\u9A57\u6240\t");
			String cmd = "select policy_no r_policy_no,po_sts_code r_po_sts_desc,modx r_modx_desc,method r_method_desc,"
					+ "o1_id r_o1_id,o1_name r_o1_name,i1_id r_i1_id,i1_name r_i1_name,app_apply_date r_app_apply_date,po_issue_date r_po_issue_date,in_force_date r_in_force_date,"
					+ "'' r_image_prn_date,'' r_home_addr,'' r_home_zip,'' r_home_tel,'' r_home_fax,"
					+ "'' r_home_sts,mail_addr r_mail_addr,mail_zip_code r_mail_zip,mail_tel r_mail_tel,'' r_pmia_desc,mail_fax r_mail_fax,mail_addr_sts r_mail_sts,"
					+ "'' r_mobil_no,'' r_e_mail,o1_birth r_o1_birth,i1_birth r_i1_birth,'' r_corridor_ind,basic_rate_scale r_rate_scale,"
					+ " basic_plan_code,insurance_type,mail_addr_ind,home_addr_ind,currency,o1_occu,o1_sex,i1_occu,i1_sex,o1_sign_ptn_card,i1_sign_ptn_card"
					+ " from jpolf where policy_no = '" + policy_no + "'";

			// System.out.print(cmd+"\n");
			// list =
			// DBConnection.getResultList(DBConnection.executeLiteQuery(stLite,cmd));

			list = getOtherFileds(DBConnection.getResultList(DBConnection
					.executeQuery(stLite, cmd)), st);
			DBConnection.closeStatement(stLite);

			// list = getOtherFileds(list,st);
			// System.out.print("after lite:"+list.);
			// list = DBConnection.getResultList(DBConnection.executeQuery(st,
			// "execute procedure cc000s('" + policy_no + "')"));
			break;
		case PoDetailQuery.PODETAIL_PL: // Life & IPA
			list = DBConnection.getResultList(DBConnection.executeQuery(st,
					"execute procedure cc001i('" + policy_no + "')"));
			break;
		case PoDetailQuery.PODETAIL_A: // 年金
			list = DBConnection.getResultList(DBConnection.executeQuery(st,
					"execute procedure cc002i('" + policy_no + "')"));
			break;
		case PoDetailQuery.PODETAIL_U: // UL
			list = DBConnection.getResultList(DBConnection.executeQuery(st,
					"execute procedure cc001i_ul('" + policy_no + "')"));
			break;
		case PoDetailQuery.PODETAIL_N:
		case PoDetailQuery.PODETAIL_I: // vul保單
			list = DBConnection.getResultList(DBConnection.executeQuery(st,
					"execute procedure cc003i('" + policy_no + "')"));
			break;
		case PoDetailQuery.PODETAIL_ILIST: // 投資標的比例
			list = DBConnection.getResultList(DBConnection.executeQuery(st,
					"execute procedure cc004i('" + policy_no + "')"));
			break;
		case PoDetailQuery.PODETAIL_VALIST: // va投資標的比例
			list = DBConnection.getResultList(DBConnection.executeQuery(st,
					"execute procedure cc004i_va('" + policy_no + "')"));
			break;
		case PoDetailQuery.PODETAIL_PREM: // polf保費計算
			list = DBConnection.getResultList(DBConnection.executeQuery(st,
					"execute procedure cc001i_ad('" + policy_no + "')"));
			break;
		case PoDetailQuery.PODETAIL_TARGET: // va投資標的比例
			list = DBConnection.getResultList(DBConnection.executeQuery(st,
					"execute procedure cc010i('" + policy_no + "')"));
			break;
		case PoDetailQuery.PODETAIL_ECO: // EC&ATM帳號
			list = DBConnection.getResultList(DBConnection.executeQuery(st,
					"execute procedure cc192i('" + policy_no + "')"));
			break;
		case PoDetailQuery.PODETAIL_PWD: // EC&ATM帳號
			list = DBConnection.getResultList(DBConnection.executeQuery(st,
					"execute procedure cc195i('" + policy_no + "')"));
			break;
		// String kkk = "ll";
		// ResultSet rs = DBConnection.executeQuery(st,
		// "select hospital_name from hchp where hospital_id = '1040'");
		// try {
		// while (rs.next()) {
		// // 不知欄位名稱的狀況下
		// for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++)
		//
		// System.out.print(rs.getString("hospital_name")); //+ "\t");
		// kkk = rs.getString("hospital_name").toString();
		// byte [] gaBytes = kkk.getBytes("big5");
		// kkk = "收";
		// System.out.println("mm "+new
		// String("\u6536\u8CBB\u5730\u5740\u72C0\u614B/\u5217\u7BA1 "));
		// System.out.println("new "+new String(gaBytes,"MS950"));
		// try {
		// System.out.println("big "+new String(kkk.getBytes("BIG5"), "MS950"));
		// } catch (UnsupportedEncodingException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// System.out.println("new "+gaBytes);
		// System.out.print("kkk="+kkk+ "\t");
		// JOptionPane.showMessageDialog(null, kkk+ "\t");
		// System.out.println("");
		//
		}

		// list = DBConnection.getResultList(DBConnection.executeQuery(st,
		// "select hospital_name from hchp where hospital_id = '1040'"));
		// break;
		// }
		DBConnection.closeStatement(st);
		return list;

	}

	public List<HashMap<String, String>> getResultList(String client_id,
			String acct_source, String bank_id, String account_no, String lcnt) {

		// String cmd = "execute procedure cc193i('" + client_id + "','"+
		// acct_source+ "','"+ bank_id +"','"+account_no +"','"+ lcnt +"')";
		// System.out.println(cmd);
		Statement st = DBConnection.createStatement();
		List<HashMap<String, String>> list = null;
		list = DBConnection.getResultList(DBConnection.executeQuery(st,
				"execute procedure cc193i('" + client_id + "','" + acct_source
						+ "','" + bank_id + "','" + account_no + "','" + lcnt
						+ "')"));
		DBConnection.closeStatement(st);
		return list;
	}

	public List<HashMap<String, String>> getResultList(String client_id,
			String acct_source, String bank_id, String account_no) {

		Statement st = DBConnection.createStatement();
		List<HashMap<String, String>> list = null;
		list = DBConnection.getResultList(DBConnection.executeQuery(st,
				"execute procedure cc194i('" + client_id + "','" + acct_source
						+ "','" + bank_id + "','" + account_no + "')"));
		DBConnection.closeStatement(st);
		return list;
	}

	private List<HashMap<String, String>> getOtherFileds(
			List<HashMap<String, String>> list, Statement st) {
		// Statement st = DBConnection.createStatement();
		List<HashMap<String, String>> Qlist = null;
		String prn_date_table = null;
		String f_cmd = null;

		for (HashMap<String, String> hsmap : list) {
			// System.out.println("yy =" + ((hsmap.get("basic_plan_code") ==
			// null) ? "" : hsmap.get("basic_plan_code")));
			if (hsmap.get("insurance_type").equals("A")) {
				// Qlist =
				// DBConnection.getResultList(DBConnection.executeQuery(st,"SELECT app_apply_date,in_force_date FROM anud WHERE policy_no = '"
				// + hsmap.get("r_policy_no") + "'"));
				// for (HashMap<String, String> Qhsmap : Qlist) {
				// hsmap.put("r_app_apply_date", Qhsmap.get("app_apply_date"));
				// hsmap.put("r_in_force_date", Qhsmap.get("in_force_date"));
				// }
				prn_date_table = "anis";

			} else if (hsmap.get("insurance_type").equals("P")) {
				prn_date_table = "pais";

			} else // polf
			{
				prn_date_table = "nbis";
				// System.out.println("oo =" + ((hsmap.get("basic_plan_code") ==
				// null) ? "" : hsmap.get("basic_plan_code")));
				Qlist = DBConnection.getResultList(DBConnection.executeQuery(
						st,
						"SELECT corridor_ind,corridor_ptr FROM pldf WHERE plan_code = '"
								+ hsmap.get("basic_plan_code")
								+ "' AND rate_scale = '"
								+ hsmap.get("r_rate_scale") + "'"));
				hsmap.put("r_corridor_ind",
						(Qlist.get(0).get("corridor_ind") == null ? "" : Qlist
								.get(0).get("corridor_ind")));
				if (Qlist.get(0).get("corridor_ind").equals("1")
						|| Qlist.get(0).get("corridor_ind").equals("2"))
					if (Qlist.get(0).get("corridor_ptr").equals("pvcoeff1"))
						JOptionPane.showMessageDialog(null, "該保單適用門檻法則\n\n"
								+ "身故給付/帳戶帳值 ≧比例\n\n"
								+ "            40歲以下      155%\n"
								+ "            41-70歲         130%\n"
								+ "            71歲以上      105% \n\n");
					else
						JOptionPane.showMessageDialog(null, "該保單適用門檻法則\n\n"
								+ "身故給付/帳戶帳值 ≧比例\n\n"
								+ "            40歲以下      130%\n"
								+ "            41-70歲         115%\n"
								+ "            71歲以上      101% \n\n");

				// f_cmd =
				// "SELECT count(*) f_cnt FROM colf WHERE policy_no = '"+
				// hsmap.get("r_policy_no") +
				// "' AND co_sts_code IN ('51','44')";
				// Qlist =
				// DBConnection.getResultList(DBConnection.executeQuery(st,f_cmd));
				// if (Integer.parseInt(Qlist.get(0).get("f_cnt"))> 0 )
				// hsmap.put("r_po_sts_desc",hsmap.get("r_po_sts_desc")+" co=51");

			}

			Qlist = DBConnection.getResultList(DBConnection.executeQuery(st,
					"SELECT image_prn_date FROM " + prn_date_table
							+ " WHERE	policy_no = '" + hsmap.get("r_policy_no")
							+ "'"));
			for (HashMap<String, String> Qhsmap : Qlist) {
				hsmap.put("r_image_prn_date", Qhsmap.get("image_prn_date"));
			}

			f_cmd = "SELECT addr_ind,address, zip_code, nvl(tel_1,'') tel_1, nvl(tel_2,'') tel_2, fax, addr_sts_code "
					+ "FROM addr WHERE client_id = '"
					+ hsmap.get("r_o1_id")
					+ "' AND addr_ind in ('"
					+ ((hsmap.get("home_addr_ind") == null) ? "" : hsmap.get(
							"home_addr_ind").trim()) + "','E')";
			// System.out.println("cmd =" +f_cmd);
			Qlist = DBConnection.getResultList(DBConnection.executeQuery(st,
					f_cmd));
			for (HashMap<String, String> Qhsmap : Qlist) {
				// System.out.println("addr ind = "+Qhsmap.get("addr_ind"));
				if (Qhsmap.get("addr_ind").equals("E")) {
					hsmap.put("r_e_mail", Qhsmap.get("address"));
					hsmap.put("r_mobil_no", Qhsmap.get("tel_1"));

					// 是否為列管email
					String tmp_str = null;
					if (getEemail(hsmap.get("r_e_mail"))) {
						tmp_str = "Y / " + hsmap.get("r_e_mail");
					} else {
						tmp_str = "N / " + hsmap.get("r_e_mail");
					}
					hsmap.put("r_e_mail", tmp_str);
					// 是否為列管手機
					if (getEcellNo(hsmap.get("r_mobil_no"))) {
						tmp_str = "Y / " + hsmap.get("r_mobil_no");
					} else {
						tmp_str = "N / " + hsmap.get("r_mobil_no");
					}
					hsmap.put("r_mobil_no", tmp_str);

					if (Qhsmap.get("zip_code") == null
							|| Qhsmap.get("zip_code").toString().equals("")) {
						hsmap.put("r_mail_sts", "");
						hsmap.put("r_home_sts", "");
					} else {
						hsmap.put("r_mail_sts", "Y 啟用");
						hsmap.put("r_home_sts", "Y 驗證中");
						if (Qhsmap.get("zip_code").toString().substring(1, 2)
								.equals("1"))
							hsmap.put("r_mail_sts", "N 停用");

						if (Qhsmap.get("zip_code").substring(3, 4) == null
								|| Qhsmap.get("zip_code").toString()
										.substring(3, 4).equals(" "))
							hsmap.put("r_home_sts", "N 未動作");
						// else
						// System.out.println("zip_code="+Qhsmap.get("zip_code"));

					}
					// hsmap.put("r_home_zip", Qhsmap.get("zip_code"));
				} else {
					hsmap.put("r_home_addr", Qhsmap.get("address"));
					hsmap.put("r_home_zip", Qhsmap.get("zip_code"));
					hsmap.put("r_home_tel", Qhsmap.get("tel_1") + " / "
							+ Qhsmap.get("tel_2"));
					hsmap.put("r_home_fax", Qhsmap.get("fax"));
					// System.out.println("home ="+hsmap.get("r_home_tel"));
					// hsmap.put("r_home_sts", Qhsmap.get("addr_sts_code"));
				}
			}

			// f_cmd =
			// "SELECT nvl(MAX(pmia_sw),'N') pmia_sw FROM pmia WHERE client_id = '"+hsmap.get("r_o1_id")+"'"
			// + " AND policy_no = '"+hsmap.get("r_policy_no")+"'"
			// + " AND mail_addr_ind = '"+ hsmap.get("mail_addr_ind")+"'";
			//
			// // System.out.println("cmd =" +f_cmd);
			// Qlist =
			// DBConnection.getResultList(DBConnection.executeQuery(st,f_cmd));
			hsmap.put("r_pmia_desc", "地址有效");
			// if ((Qlist.get(0).get("pmia_sw")).toString().equals("Y"))
			if (getAddrSts(hsmap.get("r_o1_id"), hsmap.get("r_policy_no"),
					hsmap.get("mail_addr_ind")).equals("Y"))
				hsmap.put("r_pmia_desc", "地址無效");

			f_cmd = "SELECT nvl(getDesc('addr_sts_code',MIN( addr_sts_code )),'') addr_sts_code FROM ader WHERE policy_no = '"
					+ hsmap.get("r_policy_no")
					+ "'"
					+ " AND address_type = '1'";
			Qlist = DBConnection.getResultList(DBConnection.executeQuery(st,
					f_cmd));
			hsmap.put("r_pmia_desc", hsmap.get("r_pmia_desc") + " / "
					+ Qlist.get(0).get("addr_sts_code"));

			f_cmd = "SELECT  count(*) tot_cnt FROM clgh b,clgd c "
					+ " WHERE b.client_id = '" + hsmap.get("r_o1_id") + "'"
					+ " AND b.client_upd_seq = c.client_upd_seq "
					+ " AND c.term_id = '郵遞區號' " + " AND c.addr_ind = 'E'"
					+ " AND b.proc_time >= '2008-01-13 00:00:00.000' "
					+ " AND (c.item_value_ori[2,2]!= ' ' "
					+ " OR c.item_value_ori[2,2] IS NOT NULL) "
					+ " AND    (c.item_value_new[2,2] IS NULL "
					+ " OR c.item_value_new[2,2] = ' ')";

			// System.out.println("cmd =" +f_cmd);
			Qlist = DBConnection.getResultList(DBConnection.executeQuery(st,
					f_cmd));
			if (Integer.parseInt(Qlist.get(0).get("tot_cnt").toString()) == 0)
				hsmap.put("r_e_mail_first", "");
			if (Integer.parseInt(Qlist.get(0).get("tot_cnt").toString()) == 1)
				hsmap.put("r_e_mail_first", "Y");
			if (Integer.parseInt(Qlist.get(0).get("tot_cnt").toString()) > 1)
				hsmap.put("r_e_mail_first", "N");

			System.out
					.println("cnt =" + Qlist.get(0).get("tot_cnt").toString());
			// -- 客戶RFM等級 100/10/08 --
			// f_cmd =
			// "SELECT nvl(MAX(cycle_yymm||rfm_score),'') o1_rfm FROM dwrf WHERE client_id = '"
			// + hsmap.get("r_o1_id") + "'";
			// Qlist =
			// DBConnection.getResultList(DBConnection.executeQuery(st,f_cmd));
			// hsmap.put("o1_rfm",Qlist.get(0).get("o1_rfm").substring(6));
			// if (hsmap.get("r_o1_id").equals(hsmap.get("r_i1_id")))
			// hsmap.put("i1_rfm",hsmap.get("o1_rfm"));
			// else {
			// f_cmd =
			// "SELECT nvl(MAX(cycle_yymm||rfm_score),'') i1_rfm FROM dwrf WHERE client_id = '"
			// + hsmap.get("r_i1_id") + "'";
			// Qlist =
			// DBConnection.getResultList(DBConnection.executeQuery(st,f_cmd));
			// hsmap.put("i1_rfm",(Qlist.get(0).get("i1_rfm").length()<7 ? "　" :
			// Qlist.get(0).get("i1_rfm").substring(6)));
			// }

			// System.out.println(hsmap.get("i1_rfm"));
			// System.out.println(hsmap.get("i1_sex"));
			// f_cmd = "SELECT
			// f_cmd =
			// "SELECT count(*) f_cnt FROM clgh b,clgd c WHERE b.client_id = '"
			// + hsmap.get("r_o1_id")+"'"
			// + " AND b.client_upd_seq = c.client_upd_seq "
			// + " AND c.term_id = '郵遞區號' "
			// + " AND c.addr_ind = 'E' "
			// + " AND b.proc_time >= '2008-01-13 00:00:00.000'"
			// + " AND (c.item_value_ori[2,2]!= ' '"
			// + " OR c.item_value_ori[2,2] IS NOT NULL) "
			// + " AND (c.item_value_new[2,2] IS NULL "
			// + " OR c.item_value_new[2,2] = ' ')";
			// // System.out.println("cmd =" +f_cmd);
			// Qlist =
			// DBConnection.getResultList(DBConnection.executeQuery(st,f_cmd));
			// System.out.println("f_cnt"+Qlist.get(0).get("f_cnt"));
			// switch(Integer.parseInt(Qlist.get(0).get("f_cnt").toString())){
			// case 0:
			// hsmap.put("r_home_sts", hsmap.get("r_home_sts").trim()+"/");
			// break;
			//
			// case 1:
			// hsmap.put("r_home_sts", hsmap.get("r_home_sts").trim()+"/Y");
			// break;
			//
			// default:
			// hsmap.put("r_home_sts", hsmap.get("r_home_sts").trim()+"/N");
			// }

			// 新增年收入資料
			f_cmd = "SELECT income_o,income_i,income_f FROM poim "
					+ " WHERE policy_no = '" + hsmap.get("r_policy_no").trim()
					+ "'" + " order by effect_date desc";

			// System.out.println("cmd =" +f_cmd);
			Qlist = DBConnection.getResultList(DBConnection.executeQuery(st,
					f_cmd));
			if (Qlist.size()>0) {
				hsmap.put("income_o",
						(Qlist.get(0).get("income_o") == null) ? "" : Qlist
								.get(0).get("income_o").toString());
				hsmap.put("income_i",
						(Qlist.get(0).get("income_i") == null) ? "" : Qlist
								.get(0).get("income_i").toString());
				hsmap.put("income_f",
						(Qlist.get(0).get("income_f") == null) ? "" : Qlist
								.get(0).get("income_f").toString());			
			}
			else{
				hsmap.put("income_o", "");
				hsmap.put("income_i", "");
				hsmap.put("income_f", "");
			}

		}

		return list;
	}

	public String getAddrSts(String client_id, String policy_no, String addr_ind) {
		String f_cmd;
		String f_pmia_sts = "N"; // N有效 Y無效
		List<HashMap<String, String>> Qlist = null;
		Statement st = DBConnection.createStatement();
		f_cmd = "SELECT nvl(MAX(pmia_sw),'N') pmia_sw FROM pmia WHERE client_id = '"
				+ client_id
				+ "'"
				+ " AND policy_no = '"
				+ policy_no
				+ "'"
				+ " AND mail_addr_ind = '" + addr_ind + "'";
		// + " AND pmia_sw = 'Y'" ;
		// System.out.println("cmd =" +f_cmd);
		Qlist = DBConnection
				.getResultList(DBConnection.executeQuery(st, f_cmd));
		f_pmia_sts = Qlist.get(0).get("pmia_sw").toString();
		return f_pmia_sts;
	}

	/**
	 * @category 判斷是否為列管email
	 * @param email
	 * @return true or false
	 */
	public boolean getEemail(String email) {
		String cmd = "select std_addr from iaer where std_addr = ? and pool_type in ('E','G')"
				+ " union select e_mail from agpw where e_mail = ?";
		PreparedStatement st = DBConnection.createPreparedStatement(cmd);
		for (int i = 1; i <= 2; i++) {
			DBConnection.setPreparedStatementString(st, i, email);
		}
		List<HashMap<String, String>> Qlist = DBConnection
				.getResultList(DBConnection.executeQuery(st));
		if (Qlist.size() > 0)
			return true;
		else
			return false;
	}

	/**
	 * @category 判斷是否為列管手機
	 * @param cell_no
	 * @return true of false
	 */
	public boolean getEcellNo(String cell_no) {
		String cmd = "select std_addr from iaer where std_addr = ? and pool_type in ('F','H')"
				+ " union select mobile_phone from agpw where mobile_phone = ?";
		PreparedStatement st = DBConnection.createPreparedStatement(cmd);
		for (int i = 1; i <= 2; i++) {
			DBConnection.setPreparedStatementString(st, i, cell_no);
		}
		List<HashMap<String, String>> Qlist = DBConnection
				.getResultList(DBConnection.executeQuery(st));
		if (Qlist.size() > 0)
			return true;
		else
			return false;
	}
}
