package query.model.PoDetail;

import java.util.ArrayList;
import java.util.HashMap;

import query.model.AbstractModelObject;

/**
 * 保單明細 VUL 查詢 cc003i
 * 
 * @author cora 100/08
 * @category by epf 新增銀保投資型新增投資日批註
 */
public class PoDetailI extends AbstractModelObject {
	private String result_ind;
	private String policy_no;
	private String matured_date;
	private String expired_date;
	private String terminate_date;
	private String free_look_desc;
	private String paid_to_date;
	private String bill_to_date;
	private String monthiversary;
	private String gap_start_date; // 停效日期
	private String uw_write_date;
	private String prem_susp;
	private String amt_28250006;
	private String amt_28250007;
	private String div_option;
	private String div_desc;
	private String misc_susp_check;
	private String other_susp;
	private String pay_acct_no;
	private String reminder_date1;
	private String plan_prem;
	private String suggest_prem;
	private String ol_rem_date; // 償還通知 getremdate(3) 80%通知
	private String lap_rem_date; // 90% 通知
	private String policy_year;
	private String face_amt;
	private String amt_28250021;
	private String deposit_amt_accu;
	private String edp_susp;
	private String part_wd_amt_accu;
	private String ori_target_prem; // 原始目標
	private String target_prem; // 目標保費
	private String prem_refund_year; // 特別紅利年度
	private String free_part_wd_yr; // 提領年度
	private String tg_prem_last_yr; // 去年目標
	private String es_prem_last_yr; // 去年額外
	private String prem_refund_flag; // 特別紅利指示
	private String free_part_wd_cnt; // 提領次數
	private String tg_prem_this_yr; // 當年目標
	private String es_prem_this_yr; // 當年額外
	private String non_lapse_flag_d; // 不停效保證
	private String free_switch_yr; // 轉換年度
	private String tg_prem_next_yr; // 次年目標
	private String es_prem_next_yr; // 次年額外
	private String reason_desc; // 不符原因
	private String free_switch_mn; // 轉換月份
	private String target_prem_accu; // 累積目標
	private String excess_prem_accu; // 累積額外
	private String reason_date; // 不符日期
	private String free_switch_cnt; // 轉換次數
	private String loan_amt;
	private String amt_28250008;
	private String last_check_date;
	private String loan_date;
	private String loan_rate;
	private String div_amt; // 紅利金額
	private String div_decl; // 未認紅利
	private String res_apply;
	private String rdr_conti;
	private String mp_code;
	private String bank_name;
	private String fyp_ind;
	private String mc_ident;
	private String mc_mail;
	private String misc_susp;
	private String fy_billing_desc;
	private String anrf_seq_no;
	private String currency;
	private String period_certain;
	private String pay_modx_desc;
	private String pay_date_start;
	private String payout_date_from;
	private String anpay_type_desc;
	private String prem_refund_desc;
	private String prem_refund_date;
	private String cut_date;
	private String ps2y_crt_date;
	private String ps2y_amt;
	private String next_activity_date;
	private String next_activity_type;
	private String last_process_date;
	private String last_effect_date;
	private String last_process_user;
	private String invest_date_mark; // 投資日批註
	private String coi_seq_ind; //每月扣除額扣款方式

	public PoDetailI() {
	}

	public void setValues(HashMap<String, String> hsmp) {
		setresult_ind((hsmp.get("r_result_ind") == null) ? "" : hsmp.get(
				"r_result_ind").trim());
		setpolicy_no((hsmp.get("r_policy_no") == null) ? "" : hsmp.get(
				"r_policy_no").trim());
		setmatured_date((hsmp.get("r_matured_date") == null) ? "" : hsmp.get(
				"r_matured_date").trim());
		setexpired_date((hsmp.get("r_expired_date") == null) ? "" : hsmp.get(
				"r_expired_date").trim());
		setterminate_date((hsmp.get("r_terminate_date") == null) ? "" : hsmp
				.get("r_terminate_date").trim());
		setfree_look_desc((hsmp.get("r_free_look_desc") == null) ? "" : hsmp
				.get("r_free_look_desc").trim());
		setpaid_to_date((hsmp.get("r_paid_to_date") == null) ? "" : hsmp.get(
				"r_paid_to_date").trim());
		setbill_to_date((hsmp.get("r_bill_to_date") == null) ? "" : hsmp.get(
				"r_bill_to_date").trim());
		setmonthiversary((hsmp.get("r_monthiversary") == null) ? "" : hsmp.get(
				"r_monthiversary").trim());
		setgap_start_date((hsmp.get("r_gap_start_date") == null) ? "" : hsmp
				.get("r_gap_start_date").trim());
		setuw_write_date((hsmp.get("r_uw_write_date") == null) ? "" : hsmp.get(
				"r_uw_write_date").trim());
		setprem_susp((hsmp.get("r_prem_susp") == null) ? "" : hsmp.get(
				"r_prem_susp").trim());
		setamt_28250006((hsmp.get("r_amt_28250006") == null) ? "" : hsmp.get(
				"r_amt_28250006").trim());
		setamt_28250007((hsmp.get("r_amt_28250007") == null) ? "" : hsmp.get(
				"r_amt_28250007").trim());
		setdiv_option((hsmp.get("r_div_option") == null) ? "" : hsmp.get(
				"r_div_option").trim());
		setdiv_desc((hsmp.get("r_div_desc") == null) ? "" : hsmp.get(
				"r_div_desc").trim());
		setmisc_susp_check((hsmp.get("r_misc_susp_check") == null) ? "" : hsmp
				.get("r_misc_susp_check").trim());
		setother_susp((hsmp.get("r_other_susp") == null) ? "" : hsmp.get(
				"r_other_susp").trim());
		setpay_acct_no((hsmp.get("r_pay_acct_no") == null) ? "" : hsmp.get(
				"r_pay_acct_no").trim());
		setreminder_date1((hsmp.get("r_reminder_date1") == null) ? "" : hsmp
				.get("r_reminder_date1").trim());
		setplan_prem((hsmp.get("r_plan_prem") == null) ? "" : hsmp.get(
				"r_plan_prem").trim());
		setsuggest_prem((hsmp.get("r_suggest_prem") == null) ? "" : hsmp.get(
				"r_suggest_prem").trim());
		setol_rem_date((hsmp.get("r_ol_rem_date") == null) ? "" : hsmp.get(
				"r_ol_rem_date").trim());
		setlap_rem_date((hsmp.get("r_lap_rem_date") == null) ? "" : hsmp.get(
				"r_lap_rem_date").trim());
		setpolicy_year((hsmp.get("r_policy_year") == null) ? "" : hsmp.get(
				"r_policy_year").trim());
		setface_amt((hsmp.get("r_face_amt") == null) ? "" : hsmp.get(
				"r_face_amt").trim());
		setamt_28250021((hsmp.get("r_amt_28250021") == null) ? "" : hsmp.get(
				"r_amt_28250021").trim());
		setdeposit_amt_accu((hsmp.get("r_deposit_amt_accu") == null) ? ""
				: hsmp.get("r_deposit_amt_accu").trim());
		setedp_susp((hsmp.get("r_edp_susp") == null) ? "" : hsmp.get(
				"r_edp_susp").trim());
		setpart_wd_amt_accu((hsmp.get("r_part_wd_amt_accu") == null) ? ""
				: hsmp.get("r_part_wd_amt_accu").trim());
		setori_target_prem((hsmp.get("r_ori_target_prem") == null) ? "" : hsmp
				.get("r_ori_target_prem").trim());
		settarget_prem((hsmp.get("r_target_prem") == null) ? "" : hsmp.get(
				"r_target_prem").trim());
		setprem_refund_year((hsmp.get("r_prem_refund_year") == null) ? ""
				: hsmp.get("r_prem_refund_year").trim());
		setfree_part_wd_yr((hsmp.get("r_free_part_wd_yr") == null) ? "" : hsmp
				.get("r_free_part_wd_yr").trim());
		settg_prem_last_yr((hsmp.get("r_tg_prem_last_yr") == null) ? "" : hsmp
				.get("r_tg_prem_last_yr").trim());
		setes_prem_last_yr((hsmp.get("r_es_prem_last_yr") == null) ? "" : hsmp
				.get("r_es_prem_last_yr").trim());
		setprem_refund_flag((hsmp.get("r_prem_refund_flag") == null) ? ""
				: hsmp.get("r_prem_refund_flag").trim());
		setfree_part_wd_cnt((hsmp.get("r_free_part_wd_cnt") == null) ? ""
				: hsmp.get("r_free_part_wd_cnt").trim());
		settg_prem_this_yr((hsmp.get("r_tg_prem_this_yr") == null) ? "" : hsmp
				.get("r_tg_prem_this_yr").trim());
		setes_prem_this_yr((hsmp.get("r_es_prem_this_yr") == null) ? "" : hsmp
				.get("r_es_prem_this_yr").trim());
		setnon_lapse_flag_d((hsmp.get("r_non_lapse_flag_d") == null) ? ""
				: hsmp.get("r_non_lapse_flag_d").trim());
		setfree_switch_yr((hsmp.get("r_free_switch_yr") == null) ? "" : hsmp
				.get("r_free_switch_yr").trim());
		settg_prem_next_yr((hsmp.get("r_tg_prem_next_yr") == null) ? "" : hsmp
				.get("r_tg_prem_next_yr").trim());
		setes_prem_next_yr((hsmp.get("r_es_prem_next_yr") == null) ? "" : hsmp
				.get("r_es_prem_next_yr").trim());
		setreason_desc((hsmp.get("r_reason_desc") == null) ? "" : hsmp.get(
				"r_reason_desc").trim());
		setfree_switch_mn((hsmp.get("r_free_switch_mn") == null) ? "" : hsmp
				.get("r_free_switch_mn").trim());
		settarget_prem_accu((hsmp.get("r_target_prem_accu") == null) ? ""
				: hsmp.get("r_target_prem_accu").trim());
		setexcess_prem_accu((hsmp.get("r_excess_prem_accu") == null) ? ""
				: hsmp.get("r_excess_prem_accu").trim());
		setreason_date((hsmp.get("r_reason_date") == null) ? "" : hsmp.get(
				"r_reason_date").trim());
		setfree_switch_cnt((hsmp.get("r_free_switch_cnt") == null) ? "" : hsmp
				.get("r_free_switch_cnt").trim());
		setloan_amt((hsmp.get("r_loan_amt") == null) ? "" : hsmp.get(
				"r_loan_amt").trim());
		setamt_28250008((hsmp.get("r_amt_28250008") == null) ? "" : hsmp.get(
				"r_amt_28250008").trim());
		setlast_check_date((hsmp.get("r_last_check_date") == null) ? "" : hsmp
				.get("r_last_check_date").trim());
		setloan_date((hsmp.get("r_loan_date") == null) ? "" : hsmp.get(
				"r_loan_date").trim());
		setloan_rate((hsmp.get("r_loan_rate") == null) ? "" : hsmp.get(
				"r_loan_rate").trim());
		setdiv_amt((hsmp.get("r_div_amt") == null) ? "" : hsmp.get("r_div_amt")
				.trim());
		setdiv_decl((hsmp.get("r_div_decl") == null) ? "" : hsmp.get(
				"r_div_decl").trim());
		setres_apply((hsmp.get("r_res_apply") == null) ? "" : hsmp.get(
				"r_res_apply").trim());
		setrdr_conti((hsmp.get("r_rdr_conti") == null) ? "" : hsmp.get(
				"r_rdr_conti").trim());
		setmp_code((hsmp.get("r_mp_code") == null) ? "" : hsmp.get("r_mp_code")
				.trim());
		setbank_name((hsmp.get("r_bank_name") == null) ? "" : hsmp.get(
				"r_bank_name").trim());
		setfyp_ind((hsmp.get("r_fyp_ind") == null) ? "" : hsmp.get("r_fyp_ind")
				.trim());
		setmc_ident((hsmp.get("r_mc_ident") == null) ? "" : hsmp.get(
				"r_mc_ident").trim());
		setmc_mail((hsmp.get("r_mc_mail") == null) ? "" : hsmp.get("r_mc_mail")
				.trim());
		setmisc_susp((hsmp.get("r_misc_susp") == null) ? "" : hsmp.get(
				"r_misc_susp").trim());
		setfy_billing_desc((hsmp.get("r_fy_billing_desc") == null) ? "" : hsmp
				.get("r_fy_billing_desc").trim());
		setanrf_seq_no((hsmp.get("r_anrf_seq_no") == null) ? "" : hsmp.get(
				"r_anrf_seq_no").trim());
		setcurrency((hsmp.get("r_currency") == null) ? "" : hsmp.get(
				"r_currency").trim());
		setperiod_certain((hsmp.get("r_period_certain") == null) ? "" : hsmp
				.get("r_period_certain").trim());
		setpay_modx_desc((hsmp.get("r_pay_modx_desc") == null) ? "" : hsmp.get(
				"r_pay_modx_desc").trim());
		setpay_date_start((hsmp.get("r_pay_date_start") == null) ? "" : hsmp
				.get("r_pay_date_start").trim());
		setpayout_date_from((hsmp.get("r_payout_date_from") == null) ? ""
				: hsmp.get("r_payout_date_from").trim());
		setanpay_type_desc((hsmp.get("r_anpay_type_desc") == null) ? "" : hsmp
				.get("r_anpay_type_desc").trim());
		setprem_refund_desc((hsmp.get("r_prem_refund_desc") == null) ? ""
				: hsmp.get("r_prem_refund_desc").trim());
		setprem_refund_date((hsmp.get("r_prem_refund_date") == null) ? ""
				: hsmp.get("r_prem_refund_date").trim());
		setcut_date((hsmp.get("r_cut_date") == null) ? "" : hsmp.get(
				"r_cut_date").trim());
		setps2y_crt_date((hsmp.get("r_ps2y_crt_date") == null) ? "" : hsmp.get(
				"r_ps2y_crt_date").trim());
		setps2y_amt((hsmp.get("r_ps2y_amt") == null) ? "" : hsmp.get(
				"r_ps2y_amt").trim());
		setnext_activity_date((hsmp.get("r_next_activity_date") == null) ? ""
				: hsmp.get("r_next_activity_date").trim());
		setnext_activity_type((hsmp.get("r_next_activity_type") == null) ? ""
				: hsmp.get("r_next_activity_type").trim());
		setlast_process_date((hsmp.get("r_last_process_date") == null) ? ""
				: hsmp.get("r_last_process_date").trim());
		setlast_effect_date((hsmp.get("r_last_effect_date") == null) ? ""
				: hsmp.get("r_last_effect_date").trim());
		setlast_process_user((hsmp.get("r_last_process_user") == null) ? ""
				: hsmp.get("r_last_process_user").trim());
		setInvest_date_mark((hsmp.get("r_invest_date_mark") == null) ? ""
				: hsmp.get("r_invest_date_mark").trim());
		setCoi_seq_ind((hsmp.get("r_coi_seq_ind") == null) ? ""
				: hsmp.get("r_coi_seq_ind").trim());
	}

	public String[] getValues(int type) {
		ArrayList<String> valueList = new ArrayList<String>();

		switch (type) {
		case 11: // //第一頁第一組column
			valueList.add(matured_date);
			valueList.add(expired_date);
			valueList.add(paid_to_date);
			valueList.add(bill_to_date);
			valueList.add(monthiversary);
			valueList.add(policy_year);
			valueList.add(face_amt);
			valueList.add(free_look_desc);
			valueList.add(uw_write_date);
			valueList.add(pay_acct_no);
			valueList.add(res_apply);
			valueList.add(rdr_conti);
			valueList.add(fyp_ind);
			valueList.add(last_effect_date); // 前變更生效日
			valueList.add(invest_date_mark);
			break;
		case 12:
			valueList.add(div_option + " " + div_desc);
			valueList.add(misc_susp);
			valueList.add(prem_susp);
			valueList.add(amt_28250006 + " / " + amt_28250007);
			valueList.add(amt_28250008 + " / " + other_susp);
			valueList.add(misc_susp_check);
			valueList.add(deposit_amt_accu);
			valueList.add(edp_susp);
			valueList.add(part_wd_amt_accu);
			valueList.add(plan_prem);
			valueList.add(suggest_prem);
			valueList.add(fy_billing_desc);
			valueList.add(amt_28250021 + " / " + anrf_seq_no);
			valueList.add(last_process_date + " " + last_process_user); // 前變更日/前變更者
			valueList.add(coi_seq_ind); //每月扣除額扣除方式
			break;
		case 13: // I1,I4
			valueList.add(last_check_date);
			valueList.add(reminder_date1);
			valueList.add(ol_rem_date); // 80%
			valueList.add(lap_rem_date); // 90%
			valueList.add(cut_date); // gap_start_date); 100%
			valueList.add(ps2y_crt_date + " / " + ps2y_amt); // 超額通知
			valueList.add(gap_start_date);
			// valueList.add(terminate_date);
			valueList.add(loan_date);
			valueList.add(loan_amt);
			valueList.add(non_lapse_flag_d); // 不停效保證
			valueList.add(reason_desc); // 不符原因
			valueList.add(reason_date); // 不符日期
			valueList.add(mc_ident + " / " + mc_mail);
			valueList.add(next_activity_date + " / " + next_activity_type); // 次活動日/活動型態
			// valueList.add(currency);
			break;
		case 14: // I2,I3
			valueList.add(last_check_date);
			valueList.add(reminder_date1);
			valueList.add(ol_rem_date + " / " + lap_rem_date); // 80% 90%
			valueList.add(cut_date); // gap_start_date); 100%
			valueList.add(ps2y_crt_date + " / " + ps2y_amt); // 超額通知
			valueList.add(gap_start_date); // 停效日期 101/01/17 麗娟拿掉中止日期
			valueList.add(loan_date);
			valueList.add(loan_amt);
			valueList.add(period_certain); // 年金保證期間
			valueList.add(pay_modx_desc + " / " + anpay_type_desc); // 年金給付週期/類型
			valueList.add(pay_date_start);
			valueList.add(payout_date_from);
			valueList.add(mc_ident + " / " + mc_mail);
			valueList.add(next_activity_date + " / " + next_activity_type); // 次活動日/活動型態
			break;
		case 21:// 第二頁第一組column
			valueList.add(ori_target_prem); // 原始目標
			valueList.add(tg_prem_last_yr); // 去年目標
			valueList.add(tg_prem_this_yr); // 當年目標
			valueList.add(tg_prem_next_yr); // 次年目標
			valueList.add(target_prem_accu); // 累積目標
			valueList.add(target_prem); // 目標保費
			break;

		case 22:
			valueList.add(es_prem_last_yr); // 去年額外
			valueList.add(es_prem_this_yr); // 當年額外
			valueList.add(es_prem_next_yr); // 次年額外
			valueList.add(excess_prem_accu); // 累積額外
			valueList.add(free_part_wd_yr); // 提領年度
			valueList.add(free_part_wd_cnt); // 提領次數
			break;

		case 23:
			valueList.add(free_switch_yr); // 轉換年度
			valueList.add(free_switch_mn); // 轉換月份
			valueList.add(free_switch_cnt); // 轉換次數
			valueList.add(prem_refund_year); // 特別紅利年度
			valueList.add(div_amt); // 紅利金額
			valueList.add(div_decl); // 未認紅利
			break;

		case 24: // 第二頁第四組column
			valueList.add(prem_refund_flag); // 特別紅利指示
			valueList.add(prem_refund_desc); // 不符原因
			valueList.add(prem_refund_date); // 不符日期
			valueList.add(non_lapse_flag_d); // 不停效保證
			valueList.add(reason_desc); // 不符原因
			valueList.add(reason_date); // 不符日期
			break;
		}
		String[] valueArray = new String[valueList.size()];
		valueList.toArray(valueArray);

		return valueArray;
	}

	public String getresult_ind() {
		return result_ind;
	}

	public void setresult_ind(String result_ind) {
		this.result_ind = result_ind;
	}

	public String getpolicy_no() {
		return policy_no;
	}

	public void setpolicy_no(String policy_no) {
		this.policy_no = policy_no;
	}

	public String getmatured_date() {
		return matured_date;
	}

	public void setmatured_date(String matured_date) {
		this.matured_date = matured_date;
	}

	public String getexpired_date() {
		return expired_date;
	}

	public void setexpired_date(String expired_date) {
		this.expired_date = expired_date;
	}

	public String getterminate_date() {
		return terminate_date;
	}

	public void setterminate_date(String terminate_date) {
		this.terminate_date = terminate_date;
	}

	public String getfree_look_desc() {
		return free_look_desc;
	}

	public void setfree_look_desc(String free_look_desc) {
		this.free_look_desc = free_look_desc;
	}

	public String getpaid_to_date() {
		return paid_to_date;
	}

	public void setpaid_to_date(String paid_to_date) {
		this.paid_to_date = paid_to_date;
	}

	public String getbill_to_date() {
		return bill_to_date;
	}

	public void setbill_to_date(String bill_to_date) {
		this.bill_to_date = bill_to_date;
	}

	public String getmonthiversary() {
		return monthiversary;
	}

	public void setmonthiversary(String monthiversary) {
		this.monthiversary = monthiversary;
	}

	public String getgap_start_date() {
		return gap_start_date;
	}

	public void setgap_start_date(String gap_start_date) {
		this.gap_start_date = gap_start_date;
	}

	public String getuw_write_date() {
		return uw_write_date;
	}

	public void setuw_write_date(String uw_write_date) {
		this.uw_write_date = uw_write_date;
	}

	public String getprem_susp() {
		return prem_susp;
	}

	public void setprem_susp(String prem_susp) {
		this.prem_susp = prem_susp;
	}

	public String getamt_28250006() {
		return amt_28250006;
	}

	public void setamt_28250006(String amt_28250006) {
		this.amt_28250006 = amt_28250006;
	}

	public String getamt_28250007() {
		return amt_28250007;
	}

	public void setamt_28250007(String amt_28250007) {
		this.amt_28250007 = amt_28250007;
	}

	public String getdiv_option() {
		return div_option;
	}

	public void setdiv_option(String div_option) {
		this.div_option = div_option;
	}

	public String getdiv_desc() {
		return div_desc;
	}

	public void setdiv_desc(String div_desc) {
		this.div_desc = div_desc;
	}

	public String getmisc_susp_check() {
		return misc_susp_check;
	}

	public void setmisc_susp_check(String misc_susp_check) {
		this.misc_susp_check = misc_susp_check;
	}

	public String getother_susp() {
		return other_susp;
	}

	public void setother_susp(String other_susp) {
		this.other_susp = other_susp;
	}

	public String getpay_acct_no() {
		return pay_acct_no;
	}

	public void setpay_acct_no(String pay_acct_no) {
		this.pay_acct_no = pay_acct_no;
	}

	public String getreminder_date1() {
		return reminder_date1;
	}

	public void setreminder_date1(String reminder_date1) {
		this.reminder_date1 = reminder_date1;
	}

	public String getplan_prem() {
		return plan_prem;
	}

	public void setplan_prem(String plan_prem) {
		this.plan_prem = plan_prem;
	}

	public String getsuggest_prem() {
		return suggest_prem;
	}

	public void setsuggest_prem(String suggest_prem) {
		this.suggest_prem = suggest_prem;
	}

	public String getol_rem_date() {
		return ol_rem_date;
	}

	public void setol_rem_date(String ol_rem_date) {
		this.ol_rem_date = ol_rem_date;
	}

	public String getlap_rem_date() {
		return lap_rem_date;
	}

	public void setlap_rem_date(String lap_rem_date) {
		this.lap_rem_date = lap_rem_date;
	}

	public String getpolicy_year() {
		return policy_year;
	}

	public void setpolicy_year(String policy_year) {
		this.policy_year = policy_year;
	}

	public String getface_amt() {
		return face_amt;
	}

	public void setface_amt(String face_amt) {
		this.face_amt = face_amt;
	}

	public String getamt_28250021() {
		return amt_28250021;
	}

	public void setamt_28250021(String amt_28250021) {
		this.amt_28250021 = amt_28250021;
	}

	public String getdeposit_amt_accu() {
		return deposit_amt_accu;
	}

	public void setdeposit_amt_accu(String deposit_amt_accu) {
		this.deposit_amt_accu = deposit_amt_accu;
	}

	public String getedp_susp() {
		return edp_susp;
	}

	public void setedp_susp(String edp_susp) {
		this.edp_susp = edp_susp;
	}

	public String getpart_wd_amt_accu() {
		return part_wd_amt_accu;
	}

	public void setpart_wd_amt_accu(String part_wd_amt_accu) {
		this.part_wd_amt_accu = part_wd_amt_accu;
	}

	public String getori_target_prem() {
		return ori_target_prem;
	}

	public void setori_target_prem(String ori_target_prem) {
		this.ori_target_prem = ori_target_prem;
	}

	public String gettarget_prem() {
		return target_prem;
	}

	public void settarget_prem(String target_prem) {
		this.target_prem = target_prem;
	}

	public String getprem_refund_year() {
		return prem_refund_year;
	}

	public void setprem_refund_year(String prem_refund_year) {
		this.prem_refund_year = prem_refund_year;
	}

	public String getfree_part_wd_yr() {
		return free_part_wd_yr;
	}

	public void setfree_part_wd_yr(String free_part_wd_yr) {
		this.free_part_wd_yr = free_part_wd_yr;
	}

	public String gettg_prem_last_yr() {
		return tg_prem_last_yr;
	}

	public void settg_prem_last_yr(String tg_prem_last_yr) {
		this.tg_prem_last_yr = tg_prem_last_yr;
	}

	public String getes_prem_last_yr() {
		return es_prem_last_yr;
	}

	public void setes_prem_last_yr(String es_prem_last_yr) {
		this.es_prem_last_yr = es_prem_last_yr;
	}

	public String getprem_refund_flag() {
		return prem_refund_flag;
	}

	public void setprem_refund_flag(String prem_refund_flag) {
		this.prem_refund_flag = prem_refund_flag;
	}

	public String getfree_part_wd_cnt() {
		return free_part_wd_cnt;
	}

	public void setfree_part_wd_cnt(String free_part_wd_cnt) {
		this.free_part_wd_cnt = free_part_wd_cnt;
	}

	public String gettg_prem_this_yr() {
		return tg_prem_this_yr;
	}

	public void settg_prem_this_yr(String tg_prem_this_yr) {
		this.tg_prem_this_yr = tg_prem_this_yr;
	}

	public String getes_prem_this_yr() {
		return es_prem_this_yr;
	}

	public void setes_prem_this_yr(String es_prem_this_yr) {
		this.es_prem_this_yr = es_prem_this_yr;
	}

	public String getnon_lapse_flag_d() {
		return non_lapse_flag_d;
	}

	public void setnon_lapse_flag_d(String non_lapse_flag_d) {
		this.non_lapse_flag_d = non_lapse_flag_d;
	}

	public String getfree_switch_yr() {
		return free_switch_yr;
	}

	public void setfree_switch_yr(String free_switch_yr) {
		this.free_switch_yr = free_switch_yr;
	}

	public String gettg_prem_next_yr() {
		return tg_prem_next_yr;
	}

	public void settg_prem_next_yr(String tg_prem_next_yr) {
		this.tg_prem_next_yr = tg_prem_next_yr;
	}

	public String getes_prem_next_yr() {
		return es_prem_next_yr;
	}

	public void setes_prem_next_yr(String es_prem_next_yr) {
		this.es_prem_next_yr = es_prem_next_yr;
	}

	public String getreason_desc() {
		return reason_desc;
	}

	public void setreason_desc(String reason_desc) {
		this.reason_desc = reason_desc;
	}

	public String getfree_switch_mn() {
		return free_switch_mn;
	}

	public void setfree_switch_mn(String free_switch_mn) {
		this.free_switch_mn = free_switch_mn;
	}

	public String gettarget_prem_accu() {
		return target_prem_accu;
	}

	public void settarget_prem_accu(String target_prem_accu) {
		this.target_prem_accu = target_prem_accu;
	}

	public String getexcess_prem_accu() {
		return excess_prem_accu;
	}

	public void setexcess_prem_accu(String excess_prem_accu) {
		this.excess_prem_accu = excess_prem_accu;
	}

	public String getreason_date() {
		return reason_date;
	}

	public void setreason_date(String reason_date) {
		this.reason_date = reason_date;
	}

	public String getfree_switch_cnt() {
		return free_switch_cnt;
	}

	public void setfree_switch_cnt(String free_switch_cnt) {
		this.free_switch_cnt = free_switch_cnt;
	}

	public String getloan_amt() {
		return loan_amt;
	}

	public void setloan_amt(String loan_amt) {
		this.loan_amt = loan_amt;
	}

	public String getamt_28250008() {
		return amt_28250008;
	}

	public void setamt_28250008(String amt_28250008) {
		this.amt_28250008 = amt_28250008;
	}

	public String getlast_check_date() {
		return last_check_date;
	}

	public void setlast_check_date(String last_check_date) {
		this.last_check_date = last_check_date;
	}

	public String getloan_date() {
		return loan_date;
	}

	public void setloan_date(String loan_date) {
		this.loan_date = loan_date;
	}

	public String getloan_rate() {
		return loan_rate;
	}

	public void setloan_rate(String loan_rate) {
		this.loan_rate = loan_rate;
	}

	public String getdiv_amt() {
		return div_amt;
	}

	public void setdiv_amt(String div_amt) {
		this.div_amt = div_amt;
	}

	public String getdiv_decl() {
		return div_decl;
	}

	public void setdiv_decl(String div_decl) {
		this.div_decl = div_decl;
	}

	public String getres_apply() {
		return res_apply;
	}

	public void setres_apply(String res_apply) {
		this.res_apply = res_apply;
	}

	public String getrdr_conti() {
		return rdr_conti;
	}

	public void setrdr_conti(String rdr_conti) {
		this.rdr_conti = rdr_conti;
	}

	public String getmp_code() {
		return mp_code;
	}

	public void setmp_code(String mp_code) {
		this.mp_code = mp_code;
	}

	public String getbank_name() {
		return bank_name;
	}

	public void setbank_name(String bank_name) {
		this.bank_name = bank_name;
	}

	public String getfyp_ind() {
		return fyp_ind;
	}

	public void setfyp_ind(String fyp_ind) {
		this.fyp_ind = fyp_ind;
	}

	public String getmc_ident() {
		return mc_ident;
	}

	public void setmc_ident(String mc_ident) {
		this.mc_ident = mc_ident;
	}

	public String getmc_mail() {
		return mc_mail;
	}

	public void setmc_mail(String mc_mail) {
		this.mc_mail = mc_mail;
	}

	public String getmisc_susp() {
		return misc_susp;
	}

	public void setmisc_susp(String misc_susp) {
		this.misc_susp = misc_susp;
	}

	public String getfy_billing_desc() {
		return fy_billing_desc;
	}

	public void setfy_billing_desc(String fy_billing_desc) {
		this.fy_billing_desc = fy_billing_desc;
	}

	public String getanrf_seq_no() {
		return anrf_seq_no;
	}

	public void setanrf_seq_no(String anrf_seq_no) {
		this.anrf_seq_no = anrf_seq_no;
	}

	public String getcurrency() {
		return currency;
	}

	public void setcurrency(String currency) {
		this.currency = currency;
	}

	public String getperiod_certain() {
		return period_certain;
	}

	public void setperiod_certain(String period_certain) {
		this.period_certain = period_certain;
	}

	public String getpay_modx_desc() {
		return pay_modx_desc;
	}

	public void setpay_modx_desc(String pay_modx_desc) {
		this.pay_modx_desc = pay_modx_desc;
	}

	public String getpay_date_start() {
		return pay_date_start;
	}

	public void setpay_date_start(String pay_date_start) {
		this.pay_date_start = pay_date_start;
	}

	public String getpayout_date_from() {
		return payout_date_from;
	}

	public void setpayout_date_from(String payout_date_from) {
		this.payout_date_from = payout_date_from;
	}

	public String getanpay_type_desc() {
		return anpay_type_desc;
	}

	public void setanpay_type_desc(String anpay_type_desc) {
		this.anpay_type_desc = anpay_type_desc;
	}

	public String getprem_refund_desc() {
		return prem_refund_desc;
	}

	public void setprem_refund_desc(String prem_refund_desc) {
		this.prem_refund_desc = prem_refund_desc;
	}

	public String getprem_refund_date() {
		return prem_refund_date;
	}

	public void setprem_refund_date(String prem_refund_date) {
		this.prem_refund_date = prem_refund_date;
	}

	public String getcut_date() {
		return cut_date;
	}

	public void setcut_date(String cut_date) {
		this.cut_date = cut_date;
	}

	public String getps2y_crt_date() {
		return ps2y_crt_date;
	}

	public void setps2y_crt_date(String ps2y_crt_date) {
		this.ps2y_crt_date = ps2y_crt_date;
	}

	public String getps2y_amt() {
		return ps2y_amt;
	}

	public void setps2y_amt(String ps2y_amt) {
		this.ps2y_amt = ps2y_amt;
	}

	public String getnext_activity_date() {
		return next_activity_date;
	}

	public void setnext_activity_date(String next_activity_date) {
		this.next_activity_date = next_activity_date;
	}

	public String getnext_activity_type() {
		return next_activity_type;
	}

	public void setnext_activity_type(String next_activity_type) {
		this.next_activity_type = next_activity_type;
	}

	public String getlast_process_date() {
		return last_process_date;
	}

	public void setlast_process_date(String last_process_date) {
		this.last_process_date = last_process_date;
	}

	public String getlast_effect_date() {
		return last_effect_date;
	}

	public void setlast_effect_date(String last_effect_date) {
		this.last_effect_date = last_effect_date;
	}

	public String getlast_process_user() {
		return last_process_user;
	}

	public void setlast_process_user(String last_process_user) {
		this.last_process_user = last_process_user;
	}

	public String getInvest_date_mark() {
		return invest_date_mark;
	}

	public void setInvest_date_mark(String invest_date_mark) {
		this.invest_date_mark = invest_date_mark;
	}

	public String getCoi_seq_ind() {
		return coi_seq_ind;
	}

	public void setCoi_seq_ind(String coi_seq_ind) {
		this.coi_seq_ind = coi_seq_ind;
	}
}
