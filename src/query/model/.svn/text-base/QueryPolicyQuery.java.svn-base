package query.model;

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;

import database.connection.DBConnection;
import database.connection.DBLiteConnection;

/**
 * @author F1256819
 * @category SR140200243 新增class_type U 一般停利
 */
public class QueryPolicyQuery implements Query {
	public final static int CLIENT_ID = 1;
	public final static int POLICY_NO = 2;
	public final static int AREANAME = 3;
	public final static int O1_CLIENT_ID = 4;
	public final static int I1_CLIENT_ID = 5;
	public final static int NAMES = 6;
	public final static int AREA_NAMES = 7;
	public final static int BIRTH_NAMES = 8;
	public final static int O1_AREA_NAME = 9; // O1 name + area code
	public final static int I1_AREA_NAME = 10; // I1 name + area code
	public final static int O1_BIRTH_NAME = 11; // O1 name + O1 birthday
	public final static int I1_BIRTH_NAME = 12; // I1 name + I1 birthday

	public final static int BENEFICIARIES_ID = 13;
	public final static int BENEFICIARIES_NAME = 14;

	// private Connection connLite;
	private Statement stat;
	private String polfString;
	private String poanString;
	private String popaString;
	private String poiaString;
	private String commString;
	private String variString;
	private String anudString;
	private PreparedStatement ps;
	private boolean isInterupted; // 是否已按過processDialog的中斷

	public QueryPolicyQuery() {
		polfString = "select FIRST 201 a.policy_no,a.currency||getDesc('currency',a.currency),a.po_sts_code||getDesc('po_sts_code',a.po_sts_code),getDesc('modx',a.modx)"
				+ ",a.method||getDesc('method',a.method),a.basic_plan_code"
				+ ",a.basic_rate_scale,a.po_issue_date,a.bill_to_date,a.paid_to_date,a.last_check_date"
				+ ",a.mode_prem,a.prem_susp,a.edp_susp,a.misc_susp,a.mail_addr_ind,a.home_addr_ind"
				+ ",a.app_apply_date,a.in_force_date,a.matured_date,a.expired_date,a.loan_date,a.loan_amt"
				+ ",a.div_option ,div_option||getDesc( 'div_option',a.div_option) div_desc"
				+ ",a.accumulated_div,a.total_div_declared,a.auto_pay_ind,a.uw_write_date,a.other_susp"
				+ ",a.insurance_type,a.free_look_opt,a.misc_susp_check,a.plan_prem"
				+ ",a.policy_year,a.deposit_amt_accu ,a.nf_option ,a.reinstate_apply"
				+ ",a.po_sub_sts_code,a.apl_date ,a.apl_amt ,a.sign_paper_date"
				+ ",a.sign_input_date,a.paid_to_date_coi,a.gap_start_date,a.group_code"
				+ ",a.part_wd_amt_accu,a.ori_target_prem,a.target_prem,a.prem_refund_year"
				+ ",a.free_part_wd_yr,a.tg_prem_last_year,a.es_prem_last_year,a.prem_refund_flag"
				+ ",a.free_part_wd_cnt,a.tg_prem_this_year,a.es_prem_this_year,a.non_lapse_flag"
				+ ",a.free_switching_yr,a.tg_prem_next_year,a.es_prem_next_year,a.free_switching_mn"
				+ ",a.target_prem_accu,a.excess_prem_accu,a.free_switching_cnt,a.fy_billing_ind||' '||getDesc('fy_billing_ind',a.fy_billing_ind) fy_billing_ind"
				+ ",(case a.insurance_type when 'G' then 'I1' when 'V' then "
				+ " (case when a.basic_plan_code IN (select plan_code from pldf where invs_avail_type in ('2','3')) then 'I4'"
				+
				// "when a.basic_plan_code matches 'SVUL*' then 'I4' when a.basic_plan_code matches 'YVUL*' then 'I4'"
				// +
				" when a.basic_plan_code in (select plan_code from pldf where invs_avail_type = '5') then 'I5' "
				+ " when a.basic_plan_code in (select plan_code from pldf where invs_avail_type = '6') then 'I6' "
				+ " else 'I1' end ) "
				+ " when 'N' then (case when a.basic_plan_code in (select plan_code from pldf where invs_avail_type in ('2','3')) then 'I2' "
				+ " when a.basic_plan_code in (select plan_code from pldf where invs_avail_type in ('5')) then 'I5' "
				+ " when a.basic_plan_code in (select plan_code from pldf where invs_avail_type in ('6')) then 'I6' "
				// + "when 'HVA' then 'I2' when 'DVA' then 'I2'"
				+ " else 'I3' end )  when 'U' then 'U' else 'L' end ) class_type "
				+ ",b.client_id o1_id,d.names o1_name,(case d.sex when '1' then '男' when '2' then '女' else '--' end) o1_sex,d.birth_date o1_birth,d.occupation_code||':'||occuDesc(d.occupation_code) o1_occu"
				+ ",c.client_id i1_id,e.names i1_name,(case e.sex when '1' then '男' when '2' then '女' else '--' end) i1_sex,e.birth_date i1_birth,e.occupation_code||':'||occuDesc(e.occupation_code) i1_occu"
				+ ",f.zip_code mail_zip_code,f.address mail_addr,nvl(f.tel_1,'')||' / '||nvl(f.tel_2,'') mail_tel"
				+ ",f.fax mail_fax,f.addr_sts_code mail_addr_sts,g.agent_code s_ag_code,h.names s_ag_name"
				+ ",d.sign_ptn_card o1_sign_ptn_card,e.sign_ptn_card i1_sign_ptn_card"
				+ " from polf a,pocl b,pocl c,clnt d,clnt e ,addr f,poag g,clnt h ";

		poanString = "select a.policy_no,a.currency||getDesc('currency',a.currency),a.po_sts_code||getDesc('po_sts_code',a.po_sts_code),getDesc('modx',a.modx)"
				+ ",a.method||getDesc('method',a.method),a.basic_plan_code"
				+ ",a.basic_rate_scale,a.po_issue_date,a.bill_to_date,a.paid_to_date,a.last_check_date"
				+ ",( case a.modx when '0' then i.prem_when_issue else a.mode_prem end),a.prem_susp,a.edp_susp,a.misc_susp,a.mail_addr_ind,a.home_addr_ind"
				+ ",i.app_apply_date,i.in_force_date"
				+ ",a.matured_date,a.expired_date,a.loan_date,a.loan_amt"
				+ ",'' div_option,'' div_desc"
				+ ",a.accumulated_div,a.total_div_declared,'' auto_pay_ind ,i.uw_write_date,0 other_susp "
				+ ",'A','',0,0,0,0,'','','','',0,'','','','','',0,0,0,0,0,0,0,'',0,0,0,'',0,0,0,0,0,0,0,a.fy_billing_ind||' '||getDesc('fy_billing_ind',a.fy_billing_ind) fy_billing_ind"
				+ ",'A'"
				+ ",b.client_id o1_id,d.names,(case d.sex when '1' then '男' else '女' end) o1_sex,d.birth_date o1_birth,d.occupation_code||' / '||occuDesc(d.occupation_code) o1_occu"
				+ ",c.client_id i1_id,e.names,(case e.sex when '1' then '男' else '女' end) i1_sex,e.birth_date i1_birth,e.occupation_code||' / '||occuDesc(e.occupation_code) i1_occu"
				+ ",f.zip_code mail_zip_code,f.address mail_addr,nvl(f.tel_1,'')||' / '||nvl(f.tel_2,'') mail_tel"
				+ ",f.fax mail_fax,f.addr_sts_code mail_addr_sts,g.agent_code s_ag_code,h.names s_ag_name"
				+ ",d.sign_ptn_card,e.sign_ptn_card"
				+ " from poan a,pocl b,pocl c,clnt d,clnt e ,addr f ,poag g,clnt h,outer anud i ";

		anudString = "and i.policy_no = a.policy_no "; // 101/07/23 cora增加

		popaString = "select a.policy_no,'TWD新台幣',a.po_sts_code||getDesc('po_sts_code',a.po_sts_code),getDesc('modx',a.modx)"
				+ ",a.method||getDesc('method',a.method),a.basic_plan_code"
				+ ",a.basic_rate_scale,a.po_issue_date,a.bill_to_date,a.paid_to_date,a.last_check_date"
				+ ",a.mode_prem,a.prem_susp,a.edp_susp,a.misc_susp,a.mail_addr_ind,a.mail_addr_ind home_addr_ind"
				+ ",a.app_apply_date,a.in_force_date,'','','',0,"
				+ "'',''"
				+ ",0,0,a.auto_pay_ind,a.uw_write_date,a.other_susp,"
				+ "'P','',0,0,0,0,'','','','',0,'','','','','',0,0,0,0,0,0,0,'',0,0,0,'',0,0,0,0,0,0,0,''"
				+ ",'P'"
				+ ",b.client_id o1_id,d.names,(case d.sex when '1' then '男' else '女' end) o1_sex,d.birth_date o1_birth,d.occupation_code||' / '||occuDesc(d.occupation_code) o1_occu"
				+ ",c.client_id i1_id,e.names,(case e.sex when '1' then '男' else '女' end) i1_sex,e.birth_date i1_birth,e.occupation_code||' / '||occuDesc(e.occupation_code) i1_occu"
				+ ",f.zip_code mail_zip_code,f.address mail_addr,nvl(f.tel_1,'')||' / '||nvl(f.tel_2,'') mail_tel"
				+ ",f.fax mail_fax,f.addr_sts_code mail_addr_sts,g.agent_code s_ag_code,h.names s_ag_name "
				+ ",d.sign_ptn_card ,e.sign_ptn_card "
				+ " from popa a,pocl b,pocl c,clnt d,clnt e ,addr f ,poag g,clnt h ";

		poiaString = "select a.policy_no,'TWD新台幣',a.po_sts_code||getDesc('po_sts_code',a.po_sts_code),getDesc('modx',a.modx)"
				+ ",'',a.basic_plan_code"
				+ ",a.basic_rate_scale,a.po_issue_date,a.bill_to_date,a.paid_to_date,''"
				+ ",a.mode_prem,a.prem_susp,a.edp_susp,a.misc_susp,a.mail_addr_ind,a.home_addr_ind"
				+ ",a.app_apply_date,a.in_force_date,a.matured_date,a.expired_date,'',0"
				+ ",''  div_option,'' div_desc"
				+ ",0 ,0 ,'' auto_pay_ind,a.uw_write_date,0"
				+ ",a.insurance_type,'' free_look_opt,0 misc_susp_check,0 plan_prem"
				+ ",0 policy_year,0 deposit_amt_accu ,'' nf_option ,'' reinstate_apply"
				+ ",'' po_sub_sts_code,'' apl_date ,0 apl_amt ,a.sign_paper_date"
				+ ",a.sign_input_date,'' paid_to_date_coi,'' gap_start_date,'' group_code"
				+ ",0,0,0,0,0,0,0,'',0,0,0,'',0,0,0,0,0,0,0,''"
				+ ",'J'"
				+ ",b.client_id o1_id,d.names,(case d.sex when '1' then '男' else '女' end) o1_sex,d.birth_date o1_birth,d.occupation_code||' / '||occuDesc(d.occupation_code) o1_occu"
				+ ",c.client_id i1_id,e.names,(case e.sex when '1' then '男' else '女' end) i1_sex,e.birth_date i1_birth,e.occupation_code||' / '||occuDesc(e.occupation_code) i1_occu"
				+ ",f.zip_code mail_zip_code,f.address mail_addr,nvl(f.tel_1,'')||' / '||nvl(f.tel_2,'') mail_tel"
				+ ",f.fax mail_fax,f.addr_sts_code mail_addr_sts,g.agent_code s_ag_code,h.names s_ag_name"
				+ ",d.sign_ptn_card ,e.sign_ptn_card "
				+ " from poia a,pocl b,pocl c,clnt d,clnt e ,addr f ,poag g,clnt h ";

		commString = "where a.policy_no = b.policy_no "
				+ "and c.policy_no = a.policy_no "
				+ "and d.client_id = b.client_id "
				+ "and e.client_id = c.client_id "
				+ "and b.client_ident = 'O1' " + "and c.client_ident = 'I1' "
				+ "and f.client_id = b.client_id "
				+ "and f.addr_ind = a.mail_addr_ind "
				+ "and g.policy_no = a.policy_no " + "and g.relation = 'S' "
				+ "and h.client_id = g.agent_code ";
		isInterupted = false;

	}

	public void stopSearching() {
		DBConnection.stopSearching(ps);
		isInterupted = true;
	}

	public List<HashMap<String, String>> getResultList(int type) {
		// TODO Auto-generated method stub
		// PreparedStatement ps = null;
		if (type == QueryPolicyQuery.AREANAME) {
			ps = DBConnection
					.createPreparedStatement("SELECT DISTINCT(city_name) FROM zpct;");
		}

		//
		ResultSet rs = DBConnection.executeQuery(ps);

		List<HashMap<String, String>> list = DBConnection.getResultList(rs);
		DBConnection.closeStatement(ps);

		return list;

	}

	public List<HashMap<String, String>> getResultList(String policy_no,
			String areaData, int type) {

		if (policy_no.length() == 0)
			return new ArrayList<HashMap<String, String>>();

		// 非單純姓名時,欄位不可為空
		if (type != QueryPolicyQuery.NAMES)
			if (areaData.trim().length() == 2) {
				return new ArrayList<HashMap<String, String>>();
			}
		if (areaData.equals("000/00/00"))
			areaData = "*";
		variString = "";
		if (policy_no.length() == 0)
			return null;
		// PreparedStatement ps = null;
		switch (type) {
		// 要被保人時分開抓,先抓要保人d

		case QueryPolicyQuery.AREA_NAMES:
		case QueryPolicyQuery.O1_AREA_NAME:
			variString += "and (d.names matches ?) ";
			variString += "and f.std_addr matches ? ";
			areaData = "*" + areaData + "*";
			break;
		case QueryPolicyQuery.NAMES:
			System.out.println(policy_no + areaData + "now is here");
			variString += "and (d.names matches ?) ";
			break;
		case QueryPolicyQuery.BIRTH_NAMES:
		case QueryPolicyQuery.O1_BIRTH_NAME:
			variString += "and (d.names matches ?) ";
			variString += "and (d.birth_date matches ?) ";
			break;
		// case QueryPolicyQuery.O1_NAME:
		// variString = "and d.names matches ? ";
		// break;
		case QueryPolicyQuery.I1_AREA_NAME:
			variString = "and e.names matches ? ";
			variString += "and f.std_addr matches ? ";
			areaData = "*" + areaData + "*";
			break;
		case QueryPolicyQuery.I1_BIRTH_NAME:
			variString = "and e.names matches ? ";
			variString += "and (e.birth_date matches ?) ";
			break;
		}
		System.out.println(polfString + commString + variString + " union "
				+ poanString + commString + anudString + variString + " union "
				+ popaString + commString + variString + " union " + poiaString
				+ commString + variString);
		// variString += "and f.std_addr matches ? ";
		ps = DBConnection.createPreparedStatement(polfString + commString
				+ variString + " union " + poanString + commString + anudString
				+ variString + " union " + popaString + commString + variString
				+ " union " + poiaString + commString + variString);

		// areaData = "*" + areaData + "*";
		// 除了要被保人姓名外其餘有兩參數
		if (type != QueryPolicyQuery.NAMES)
			for (int i = 1; i <= 8; i++) {
				DBConnection.setPreparedStatementString(ps, i++, policy_no);
				DBConnection.setPreparedStatementString(ps, i, areaData);
			}
		else
			for (int i = 1; i <= 4; i++) {
				DBConnection.setPreparedStatementString(ps, i, policy_no);
			}

		List<HashMap<String, String>> list = setSQLiteData(
				DBConnection.executeQuery(ps), true);
		DBConnection.closeStatement(ps);
		// 再抓被保人
		if ((type == QueryPolicyQuery.NAMES
				|| type == QueryPolicyQuery.AREA_NAMES || type == QueryPolicyQuery.BIRTH_NAMES)
				&& !isInterupted) {
			switch (type) {
			case QueryPolicyQuery.NAMES:
				variString = "and (e.names matches ?) ";
				break;
			case QueryPolicyQuery.AREA_NAMES:
				variString = "and (e.names matches ?) ";
				variString += "and f.std_addr matches ? ";
				break;
			case QueryPolicyQuery.BIRTH_NAMES:
				variString = "and (e.names matches ?) ";
				variString += "and (e.birth_date matches ?) ";

			}
			// variString = "and (e.names matches ?) ";
			// variString += "and f.std_addr matches ? ";
			ps = DBConnection.createPreparedStatement(polfString + commString
					+ variString + " union " + poanString + commString
					+ anudString + variString + " union " + popaString
					+ commString + variString + " union " + poiaString
					+ commString + variString);

			// 除了要被保人姓名外其餘有兩參數
			if (type != QueryPolicyQuery.NAMES)
				for (int i = 1; i <= 8; i++) {
					DBConnection.setPreparedStatementString(ps, i++, policy_no);
					DBConnection.setPreparedStatementString(ps, i, areaData);
				}
			else
				for (int i = 1; i <= 4; i++) {
					DBConnection.setPreparedStatementString(ps, i, policy_no);
				}

			list = setSQLiteData(DBConnection.executeQuery(ps), false);
			DBConnection.closeStatement(ps);
		} else
			isInterupted = false;

		return list;
	}

	public List<HashMap<String, String>> getResultList(String policy_no,
			int type) {

		if (policy_no.length() == 0)
			return new ArrayList<HashMap<String, String>>();

		if (type == QueryPolicyQuery.CLIENT_ID) {
			variString = "and a.policy_no in (select policy_no from pocl where client_id = ? ) ";
		}

		else if (type == QueryPolicyQuery.POLICY_NO) {
			variString = "and a.policy_no in (select policy_no from pocl where client_id in "
					+ "(select client_id from pocl where policy_no =?))";
		} else if (type == QueryPolicyQuery.O1_CLIENT_ID) {
			variString = "and b.client_id = ? ";
		} else if (type == QueryPolicyQuery.I1_CLIENT_ID) {
			variString = "and c.client_id = ? ";

		} else if (type == QueryPolicyQuery.BENEFICIARIES_ID) {
			variString = "and a.policy_no in (select policy_no from benf where client_id = ? "
					+ " and relation in ('L','M')) ";
		} else if (type == QueryPolicyQuery.BENEFICIARIES_NAME) {
			variString = "and a.policy_no in (select policy_no from benf where client_id in"
					+ " (select client_id from clnt where names =?) "
					+ " and relation in ('L','M')) ";
		}
		ps = DBConnection.createPreparedStatement(polfString + commString
				+ variString + " union " + poanString + commString + anudString
				+ variString + " union " + popaString + commString + variString
				+ " union " + poiaString + commString + variString);

		DBConnection.setPreparedStatementString(ps, 1, policy_no);
		DBConnection.setPreparedStatementString(ps, 2, policy_no);
		DBConnection.setPreparedStatementString(ps, 3, policy_no);
		DBConnection.setPreparedStatementString(ps, 4, policy_no);
		//
		List<HashMap<String, String>> list = setSQLiteData(
				DBConnection.executeQuery(ps), true);

		DBConnection.closeStatement(ps);

		return list;

	}

	private void deleteSQLiteData() {
		stat = DBLiteConnection.createStatement();
		DBLiteConnection.executeUpdate(stat, "delete from jpolf;");

	}

	private List<HashMap<String, String>> setSQLiteData(ResultSet infomixData,
			boolean delete) throws NullPointerException {
		if (infomixData == null)
			return null;
		try {
			if (delete) {
				deleteSQLiteData();
			}
			PreparedStatement prep = DBLiteConnection
					.createPreparedStatement("insert into jpolf values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);");

			while (infomixData.next()) {
				// 不知欄位名稱的狀況下
				for (int i = 1; i <= infomixData.getMetaData().getColumnCount(); i++) {
					prep.setString(i, (infomixData.getString(i) == null) ? ""
							: infomixData.getString(i).toString());
				}
				prep.addBatch();
			}

			// connLite.setAutoCommit(false);
			prep.executeBatch();
			// connLite.setAutoCommit(true);
			prep.close();
			List<HashMap<String, String>> list = DBLiteConnection
					.getResultList(stat
							.executeQuery("select DISTINCT policy_no,app_apply_date,po_issue_date,basic_plan_code,po_sts_code,mode_prem,o1_name, i1_name,o1_id,i1_id,mail_addr,paid_to_date,bill_to_date,modx,method,s_ag_name,class_type,currency,o1_sign_ptn_card,i1_sign_ptn_card,mail_addr_ind,home_addr_ind,uw_write_date from jpolf;"));

			DBLiteConnection.closeStatement(stat);
			return list;
			// connLite.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR1",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
			return null;
		}
	}
}
