package query.model.ClaimHistory;

import java.util.HashMap;

/**
 * @ * @author FYYANG
 * 
 * @version 1.0<br>
 *          100/07/28<br>
 *          關係(JavaBean)
 * @since 1.0
 */
public class ClaimHistory02 {
	private String r_result_ind;
	private String r_po_issue_date;
	private String r_receive_date;
	private String r_event_date;
	private String r_paper_ok_date;
	private String r_approve_date;
	private String r_event_id;
	private String r_event_name;
	private String r_claim_type;
	private String r_claim_desc;
	private String r_clcm_ind;
	private String r_cl_event_desc_1;
	private String r_cl_event_desc_2;
	private String r_cl_event_desc_3;
	private String r_cl_event_desc_4;
	private String r_cl_event_type;
	private String r_cl_event_desc;
	private String r_examine_id;
	private String r_examine_name;
	private String r_rec_dept_code;
	private String r_rec_dept_name;
	private String r_claim_amt;
	private String r_dividend;
	private String r_approve_id;
	private String r_approve_name;
	private String r_app_dept_code;
	private String r_app_dept_name;
	private String r_prem_susp;
	private String r_misc_susp;
	private String r_unearned_prem;
	private String r_loans;
	private String r_apls;
	private String r_mode_prem;
	private String r_suspense;
	private String r_sub_amt;
	private String r_defer_beg_date;
	private String r_defer_end_date;
	private String r_defer_int;
	private String r_cl_examine_code;
	private String r_cl_examine_desc;
	private String r_clof_approve_ind;
	private String r_tax_withheld;
	private String r_cl_approve_code;
	private String r_cl_approve_desc;
	private String r_disb_amt_d;
	private String r_benf_name;
	private String r_remit_account;
	private String r_client_ident;
	private String r_type;
	private String r_cl_sts_desc;
	private String r_agent_name;
	private String r_agent_dept_code;
	private String r_receive_no;
	private String r_clcp_ind;
	private String r_currency;
	private String r_event_area;
	private String r_loans_apls;
	private String r_minus_prem_susp;
	private String r_clus_ind;
	private String r_cl_type_other;
	private String r_student_no;
	private String r_cl_event_code_1;
	private String r_cl_event_code_2;
	private String r_cl_event_code_3;
	private String r_cl_event_code_4;
	
	private String r_cv_amt_out;       //add 102.06.19
	private String r_addition_premium; //add 102.06.19
	public ClaimHistory02() {

	}

	public void setValues(HashMap<String, String> hsmp) {
		r_result_ind = (hsmp.get("r_result_ind") == null) ? "" : hsmp.get(
				"r_result_ind").trim();
		r_po_issue_date = (hsmp.get("r_po_issue_date") == null) ? "" : hsmp
				.get("r_po_issue_date").trim();
		r_receive_date = (hsmp.get("r_receive_date") == null) ? "" : hsmp.get(
				"r_receive_date").trim();
		r_event_date = (hsmp.get("r_event_date") == null) ? "" : hsmp.get(
				"r_event_date").trim();
		r_paper_ok_date = (hsmp.get("r_paper_ok_date") == null) ? "" : hsmp
				.get("r_paper_ok_date").trim();
		r_approve_date = (hsmp.get("r_approve_date") == null) ? "" : hsmp.get(
				"r_approve_date").trim();
		r_event_id = (hsmp.get("r_event_id") == null) ? "" : hsmp.get(
				"r_event_id").trim();
		r_event_name = (hsmp.get("r_event_name") == null) ? "" : hsmp.get(
				"r_event_name").trim();
		r_claim_type = (hsmp.get("r_claim_type") == null) ? "" : hsmp.get(
				"r_claim_type").trim();
		r_claim_desc = (hsmp.get("r_claim_desc") == null) ? "" : hsmp.get(
				"r_claim_desc").trim();
		r_clcm_ind = (hsmp.get("r_clcm_ind") == null) ? "" : hsmp.get(
				"r_clcm_ind").trim();
		r_cl_event_desc_1 = (hsmp.get("r_cl_event_desc_1") == null) ? "" : hsmp
				.get("r_cl_event_desc_1").trim();
		r_cl_event_desc_2 = (hsmp.get("r_cl_event_desc_2") == null) ? "" : hsmp
				.get("r_cl_event_desc_2").trim();
		r_cl_event_desc_3 = (hsmp.get("r_cl_event_desc_3") == null) ? "" : hsmp
				.get("r_cl_event_desc_3").trim();
		r_cl_event_desc_4 = (hsmp.get("r_cl_event_desc_4") == null) ? "" : hsmp
				.get("r_cl_event_desc_4").trim();
		r_cl_event_type = (hsmp.get("r_cl_event_type") == null) ? "" : hsmp
				.get("r_cl_event_type").trim();
		r_cl_event_desc = (hsmp.get("r_cl_event_desc") == null) ? "" : hsmp
				.get("r_cl_event_desc").trim();
		r_examine_id = (hsmp.get("r_examine_id") == null) ? "" : hsmp.get(
				"r_examine_id").trim();
		r_examine_name = (hsmp.get("r_examine_name") == null) ? "" : hsmp.get(
				"r_examine_name").trim();
		r_rec_dept_code = (hsmp.get("r_rec_dept_code") == null) ? "" : hsmp
				.get("r_rec_dept_code").trim();
		r_rec_dept_name = (hsmp.get("r_rec_dept_name") == null) ? "" : hsmp
				.get("r_rec_dept_name").trim();
		r_claim_amt = (hsmp.get("r_claim_amt") == null) ? "" : hsmp.get(
				"r_claim_amt").trim();
		r_dividend = (hsmp.get("r_dividend") == null) ? "" : hsmp.get(
				"r_dividend").trim();
		r_approve_id = (hsmp.get("r_approve_id") == null) ? "" : hsmp.get(
				"r_approve_id").trim();
		r_approve_name = (hsmp.get("r_approve_name") == null) ? "" : hsmp.get(
				"r_approve_name").trim();
		r_app_dept_code = (hsmp.get("r_app_dept_code") == null) ? "" : hsmp
				.get("r_app_dept_code").trim();
		r_app_dept_name = (hsmp.get("r_app_dept_name") == null) ? "" : hsmp
				.get("r_app_dept_name").trim();
		r_prem_susp = (hsmp.get("r_prem_susp") == null) ? "" : hsmp.get(
				"r_prem_susp").trim();
		r_misc_susp = (hsmp.get("r_misc_susp") == null) ? "" : hsmp.get(
				"r_misc_susp").trim();
		r_unearned_prem = (hsmp.get("r_unearned_prem") == null) ? "" : hsmp
				.get("r_unearned_prem").trim();
		r_loans = (hsmp.get("r_loans") == null) ? "" : hsmp.get("r_loans")
				.trim();
		r_apls = (hsmp.get("r_apls") == null) ? "" : hsmp.get("r_apls").trim();
		r_mode_prem = (hsmp.get("r_mode_prem") == null) ? "" : hsmp.get(
				"r_mode_prem").trim();
		r_suspense = (hsmp.get("r_suspense") == null) ? "" : hsmp.get(
				"r_suspense").trim();
		r_sub_amt = (hsmp.get("r_sub_amt") == null) ? "" : hsmp
				.get("r_sub_amt").trim();
		r_defer_beg_date = (hsmp.get("r_defer_beg_date") == null) ? "" : hsmp
				.get("r_defer_beg_date").trim();
		r_defer_end_date = (hsmp.get("r_defer_end_date") == null) ? "" : hsmp
				.get("r_defer_end_date").trim();
		r_defer_int = (hsmp.get("r_defer_int") == null) ? "" : hsmp.get(
				"r_defer_int").trim();
		r_cl_examine_code = (hsmp.get("r_cl_examine_code") == null) ? "" : hsmp
				.get("r_cl_examine_code").trim();
		r_cl_examine_desc = (hsmp.get("r_cl_examine_desc") == null) ? "" : hsmp
				.get("r_cl_examine_desc").trim();
		r_clof_approve_ind = (hsmp.get("r_clof_approve_ind") == null) ? ""
				: hsmp.get("r_clof_approve_ind").trim();
		r_tax_withheld = (hsmp.get("r_tax_withheld") == null) ? "" : hsmp.get(
				"r_tax_withheld").trim();
		r_cl_approve_code = (hsmp.get("r_cl_approve_code") == null) ? "" : hsmp
				.get("r_cl_approve_code").trim();
		r_cl_approve_desc = (hsmp.get("r_cl_approve_desc") == null) ? "" : hsmp
				.get("r_cl_approve_desc").trim();
		r_disb_amt_d = (hsmp.get("r_disb_amt_d") == null) ? "" : hsmp.get(
				"r_disb_amt_d").trim();
		r_benf_name = (hsmp.get("r_benf_name") == null) ? "" : hsmp.get(
				"r_benf_name").trim();
		r_remit_account = (hsmp.get("r_remit_account") == null) ? "" : hsmp
				.get("r_remit_account").trim();
		r_client_ident = (hsmp.get("r_client_ident") == null) ? "" : hsmp.get(
				"r_client_ident").trim();
		r_type = (hsmp.get("r_type") == null) ? "" : hsmp.get("r_type").trim();
		r_cl_sts_desc = (hsmp.get("r_cl_sts_desc") == null) ? "" : hsmp.get(
				"r_cl_sts_desc").trim();
		r_agent_name = (hsmp.get("r_agent_name") == null) ? "" : hsmp.get(
				"r_agent_name").trim();
		r_agent_dept_code = (hsmp.get("r_agent_dept_code") == null) ? "" : hsmp
				.get("r_agent_dept_code").trim();
		r_receive_no = (hsmp.get("r_receive_no") == null) ? "" : hsmp.get(
				"r_receive_no").trim();
		r_clcp_ind = (hsmp.get("r_clcp_ind") == null) ? "" : hsmp.get(
				"r_clcp_ind").trim();
		r_currency = (hsmp.get("r_currency") == null) ? "" : hsmp.get(
				"r_currency").trim();
		r_event_area = (hsmp.get("r_event_area") == null) ? "" : hsmp.get(
				"r_event_area").trim();
		r_loans_apls = (hsmp.get("r_loans_apls") == null) ? "" : hsmp.get(
				"r_loans_apls").trim();
		r_minus_prem_susp = (hsmp.get("r_minus_prem_susp") == null) ? "" : hsmp.get(
				"r_minus_prem_susp").trim();
		r_clus_ind = (hsmp.get("r_clus_ind") == null) ? "" : hsmp.get("r_clus_ind").trim();
		r_cl_type_other = (hsmp.get("r_cl_type_other") == null) ? "" : hsmp.get("r_cl_type_other").trim();
		r_student_no = (hsmp.get("r_student_no") == null) ? "" : hsmp.get("r_student_no").trim();
		r_cl_event_code_1 = (hsmp.get("r_cl_event_code_1") == null) ? "" : hsmp
				.get("r_cl_event_code_1").trim();
		r_cl_event_code_2 = (hsmp.get("r_cl_event_code_2") == null) ? "" : hsmp
				.get("r_cl_event_code_2").trim();
		r_cl_event_code_3 = (hsmp.get("r_cl_event_code_3") == null) ? "" : hsmp
				.get("r_cl_event_code_3").trim();
		r_cl_event_code_4 = (hsmp.get("r_cl_event_code_4") == null) ? "" : hsmp
				.get("r_cl_event_code_4").trim();
		
		r_cv_amt_out = (hsmp.get("r_cv_amt_out") == null) ? "" : hsmp             // ADD 102.06.19 解約金     
				.get("r_cv_amt_out").trim();

		r_addition_premium = (hsmp.get("r_addition_premium") == null) ? "" : hsmp //ADD 102.06.19 健保補充保
				.get("r_addition_premium").trim();

	}
	public String getR_cv_amt_out() {
		return r_cv_amt_out;       // ADD 102.06.19 解約金   
	}
	public String getR_addition_premium() { 
		return r_addition_premium; //ADD 102.06.19 健保補充保
	}
	
	public String getR_result_ind() {
		return r_result_ind;
	}

	public void setR_result_ind(String r_result_ind) {
		this.r_result_ind = r_result_ind;
	}

	public String getR_po_issue_date() {
		return r_po_issue_date;
	}

	public void setR_po_issue_date(String r_po_issue_date) {
		this.r_po_issue_date = r_po_issue_date;
	}

	public String getR_receive_date() {
		return r_receive_date;
	}

	public void setR_receive_date(String r_receive_date) {
		this.r_receive_date = r_receive_date;
	}

	public String getR_event_date() {
		return r_event_date;
	}

	public void setR_event_date(String r_event_date) {
		this.r_event_date = r_event_date;
	}

	public String getR_paper_ok_date() {
		return r_paper_ok_date;
	}

	public void setR_paper_ok_date(String r_paper_ok_date) {
		this.r_paper_ok_date = r_paper_ok_date;
	}

	public String getR_approve_date() {
		return r_approve_date;
	}

	public void setR_approve_date(String r_approve_date) {
		this.r_approve_date = r_approve_date;
	}

	public String getR_event_id() {
		return r_event_id;
	}

	public void setR_event_id(String r_event_id) {
		this.r_event_id = r_event_id;
	}

	public String getR_event_name() {
		return r_event_name;
	}

	public void setR_event_name(String r_event_name) {
		this.r_event_name = r_event_name;
	}

	public String getR_claim_type() {
		return r_claim_type;
	}

	public void setR_claim_type(String r_claim_type) {
		this.r_claim_type = r_claim_type;
	}

	public String getR_claim_desc() {
		return r_claim_desc;
	}

	public void setR_claim_desc(String r_claim_desc) {
		this.r_claim_desc = r_claim_desc;
	}

	public String getR_clcm_ind() {
		return r_clcm_ind;
	}

	public void setR_clcm_ind(String r_clcm_ind) {
		this.r_clcm_ind = r_clcm_ind;
	}

	public String getR_cl_event_desc_1() {
		return r_cl_event_desc_1;
	}

	public void setR_cl_event_desc_1(String r_cl_event_desc_1) {
		this.r_cl_event_desc_1 = r_cl_event_desc_1;
	}

	public String getR_cl_event_desc_2() {
		return r_cl_event_desc_2;
	}

	public void setR_cl_event_desc_2(String r_cl_event_desc_2) {
		this.r_cl_event_desc_2 = r_cl_event_desc_2;
	}

	public String getR_cl_event_desc_3() {
		return r_cl_event_desc_3;
	}

	public void setR_cl_event_desc_3(String r_cl_event_desc_3) {
		this.r_cl_event_desc_3 = r_cl_event_desc_3;
	}

	public String getR_cl_event_desc_4() {
		return r_cl_event_desc_4;
	}

	public void setR_cl_event_desc_4(String r_cl_event_desc_4) {
		this.r_cl_event_desc_4 = r_cl_event_desc_4;
	}

	public String getR_cl_event_type() {
		return r_cl_event_type;
	}

	public void setR_cl_event_type(String r_cl_event_type) {
		this.r_cl_event_type = r_cl_event_type;
	}

	public String getR_cl_event_desc() {
		return r_cl_event_desc;
	}

	public void setR_cl_event_desc(String r_cl_event_desc) {
		this.r_cl_event_desc = r_cl_event_desc;
	}

	public String getR_examine_id() {
		return r_examine_id;
	}

	public void setR_examine_id(String r_examine_id) {
		this.r_examine_id = r_examine_id;
	}

	public String getR_examine_name() {
		return r_examine_name;
	}

	public void setR_examine_name(String r_examine_name) {
		this.r_examine_name = r_examine_name;
	}

	public String getR_rec_dept_code() {
		return r_rec_dept_code;
	}

	public void setR_rec_dept_code(String r_rec_dept_code) {
		this.r_rec_dept_code = r_rec_dept_code;
	}

	public String getR_rec_dept_name() {
		return r_rec_dept_name;
	}

	public void setR_rec_dept_name(String r_rec_dept_name) {
		this.r_rec_dept_name = r_rec_dept_name;
	}

	public String getR_claim_amt() {
		return r_claim_amt;
	}

	public void setR_claim_amt(String r_claim_amt) {
		this.r_claim_amt = r_claim_amt;
	}

	public String getR_dividend() {
		return r_dividend;
	}

	public void setR_dividend(String r_dividend) {
		this.r_dividend = r_dividend;
	}

	public String getR_approve_id() {
		return r_approve_id;
	}

	public void setR_approve_id(String r_approve_id) {
		this.r_approve_id = r_approve_id;
	}

	public String getR_approve_name() {
		return r_approve_name;
	}

	public void setR_approve_name(String r_approve_name) {
		this.r_approve_name = r_approve_name;
	}

	public String getR_app_dept_code() {
		return r_app_dept_code;
	}

	public void setR_app_dept_code(String r_app_dept_code) {
		this.r_app_dept_code = r_app_dept_code;
	}

	public String getR_app_dept_name() {
		return r_app_dept_name;
	}

	public void setR_app_dept_name(String r_app_dept_name) {
		this.r_app_dept_name = r_app_dept_name;
	}

	public String getR_prem_susp() {
		return r_prem_susp;
	}

	public void setR_prem_susp(String r_prem_susp) {
		this.r_prem_susp = r_prem_susp;
	}

	public String getR_misc_susp() {
		return r_misc_susp;
	}

	public void setR_misc_susp(String r_misc_susp) {
		this.r_misc_susp = r_misc_susp;
	}

	public String getR_unearned_prem() {
		return r_unearned_prem;
	}

	public void setR_unearned_prem(String r_unearned_prem) {
		this.r_unearned_prem = r_unearned_prem;
	}

	public String getR_loans() {
		return r_loans;
	}

	public void setR_loans(String r_loans) {
		this.r_loans = r_loans;
	}

	public String getR_apls() {
		return r_apls;
	}

	public void setR_apls(String r_apls) {
		this.r_apls = r_apls;
	}

	public String getR_mode_prem() {
		return r_mode_prem;
	}

	public void setR_mode_prem(String r_mode_prem) {
		this.r_mode_prem = r_mode_prem;
	}

	public String getR_suspense() {
		return r_suspense;
	}

	public void setR_suspense(String r_suspense) {
		this.r_suspense = r_suspense;
	}

	public String getR_sub_amt() {
		return r_sub_amt;
	}

	public void setR_sub_amt(String r_sub_amt) {
		this.r_sub_amt = r_sub_amt;
	}

	public String getR_defer_beg_date() {
		return r_defer_beg_date;
	}

	public void setR_defer_beg_date(String r_defer_beg_date) {
		this.r_defer_beg_date = r_defer_beg_date;
	}

	public String getR_defer_end_date() {
		return r_defer_end_date;
	}

	public void setR_defer_end_date(String r_defer_end_date) {
		this.r_defer_end_date = r_defer_end_date;
	}

	public String getR_defer_int() {
		return r_defer_int;
	}

	public void setR_defer_int(String r_defer_int) {
		this.r_defer_int = r_defer_int;
	}

	public String getR_cl_examine_code() {
		return r_cl_examine_code;
	}

	public void setR_cl_examine_code(String r_cl_examine_code) {
		this.r_cl_examine_code = r_cl_examine_code;
	}

	public String getR_cl_examine_desc() {
		return r_cl_examine_desc;
	}

	public void setR_cl_examine_desc(String r_cl_examine_desc) {
		this.r_cl_examine_desc = r_cl_examine_desc;
	}

	public String getR_clof_approve_ind() {
		return r_clof_approve_ind;
	}

	public void setR_clof_approve_ind(String r_clof_approve_ind) {
		this.r_clof_approve_ind = r_clof_approve_ind;
	}

	public String getR_tax_withheld() {
		return r_tax_withheld;
	}

	public void setR_tax_withheld(String r_tax_withheld) {
		this.r_tax_withheld = r_tax_withheld;
	}

	public String getR_cl_approve_code() {
		return r_cl_approve_code;
	}

	public void setR_cl_approve_code(String r_cl_approve_code) {
		this.r_cl_approve_code = r_cl_approve_code;
	}

	public String getR_cl_approve_desc() {
		return r_cl_approve_desc;
	}

	public void setR_cl_approve_desc(String r_cl_approve_desc) {
		this.r_cl_approve_desc = r_cl_approve_desc;
	}

	public String getR_disb_amt_d() {
		return r_disb_amt_d;
	}

	public void setR_disb_amt_d(String r_disb_amt_d) {
		this.r_disb_amt_d = r_disb_amt_d;
	}

	public String getR_benf_name() {
		return r_benf_name;
	}

	public void setR_benf_name(String r_benf_name) {
		this.r_benf_name = r_benf_name;
	}

	public String getR_remit_account() {
		return r_remit_account;
	}

	public void setR_remit_account(String r_remit_account) {
		this.r_remit_account = r_remit_account;
	}

	public String getR_client_ident() {
		return r_client_ident;
	}

	public void setR_client_ident(String r_client_ident) {
		this.r_client_ident = r_client_ident;
	}

	public String getR_type() {
		return r_type;
	}

	public void setR_type(String r_type) {
		this.r_type = r_type;
	}

	public String getR_cl_sts_desc() {
		return r_cl_sts_desc;
	}

	public void setR_cl_sts_desc(String r_cl_sts_desc) {
		this.r_cl_sts_desc = r_cl_sts_desc;
	}

	public String getR_agent_name() {
		return r_agent_name;
	}

	public void setR_agent_name(String r_agent_name) {
		this.r_agent_name = r_agent_name;
	}

	public String getR_agent_dept_code() {
		return r_agent_dept_code;
	}

	public void setR_agent_dept_code(String r_agent_dept_code) {
		this.r_agent_dept_code = r_agent_dept_code;
	}

	public String getR_receive_no() {
		return r_receive_no;
	}

	public void setR_receive_no(String r_receive_no) {
		this.r_receive_no = r_receive_no;
	}

	public String getR_clcp_ind() {
		return r_clcp_ind;
	}

	public void setR_clcp_ind(String r_clcp_ind) {
		this.r_clcp_ind = r_clcp_ind;
	}

	public String getR_currency() {
		return r_currency;
	}

	public void setR_currency(String r_currency) {
		this.r_currency = r_currency;
	}

	public String getR_event_area() {
		return r_event_area;
	}

	public void setR_event_area(String r_event_area) {
		this.r_event_area = r_event_area;
	}
	
	public String getR_loans_apls() {
		return r_loans_apls;
	}

	public void setR_loans_apls(String r_loans_apls) {
		this.r_loans_apls = r_loans_apls;
	}
	
	public String getR_minus_prem_susp() {
		return r_minus_prem_susp;
	}

	public void setR_minus_prem_susp(String r_minus_prem_susp) {
		this.r_minus_prem_susp = r_minus_prem_susp;
	}
	
	public String getR_clus_ind() {
		return r_clus_ind;
	}

	public void setR_clus_ind(String r_clus_ind) {
		this.r_clus_ind = r_clus_ind;
	}
	
	public String getR_cl_type_other() {
		return r_cl_type_other;
	}

	public void setR_cl_type_other(String r_cl_type_other) {
		this.r_cl_type_other = r_cl_type_other;
	}
	
	public String getR_student_no() {
		return r_student_no;
	}

	public void setR_student_no(String r_student_no) {
		this.r_student_no = r_student_no;
	}

	public String getR_cl_event_code_1() {
		return r_cl_event_code_1;
	}

	public void setR_cl_event_code_1(String r_cl_event_code_1) {
		this.r_cl_event_code_1 = r_cl_event_code_1;
	}

	public String getR_cl_event_code_2() {
		return r_cl_event_code_2;
	}

	public void setR_cl_event_code_2(String r_cl_event_code_2) {
		this.r_cl_event_code_2 = r_cl_event_code_2;
	}

	public String getR_cl_event_code_3() {
		return r_cl_event_code_3;
	}

	public void setR_cl_event_code_3(String r_cl_event_code_3) {
		this.r_cl_event_code_3 = r_cl_event_code_3;
	}

	public String getR_cl_event_code_4() {
		return r_cl_event_code_4;
	}

	public void setR_cl_event_code_4(String r_cl_event_code_4) {
		this.r_cl_event_code_4 = r_cl_event_code_4;
	}
	
	public String[] getColumn1() {
		if (this.r_type.equals("G")) //cgmf
			return new String[] { r_event_id, r_event_name, r_student_no,
				r_po_issue_date, r_receive_no, r_clof_approve_ind,
				r_receive_date, r_paper_ok_date, r_event_date, r_event_area,
				r_claim_desc, r_clcp_ind };
		else if (this.r_type.equals("T"))  //ctmf
			return new String[] { r_event_id, r_event_name, r_po_issue_date, 
				r_receive_no,r_receive_date,r_paper_ok_date, r_event_date, 
				r_event_area,r_claim_desc, r_clcp_ind, 
				r_agent_name, r_agent_dept_code};
		else //clmf
			return new String[] { r_event_id, r_event_name, r_client_ident,
				r_po_issue_date, r_receive_no, r_clof_approve_ind,
				r_receive_date, r_paper_ok_date, r_event_date, r_event_area,
				r_claim_desc, r_clcp_ind };
	}

	public String[] getColumn2() {
		if (this.r_type.equals("G")) //cgmf
			return new String[] { r_agent_name, r_agent_dept_code, r_cl_event_desc,
				r_clus_ind, r_cl_type_other,r_examine_name, r_rec_dept_name,
				r_approve_name, r_app_dept_name, r_cl_sts_desc,r_cl_examine_desc, 
				r_cl_approve_desc };
		else if (this.r_type.equals("T"))  //ctmf	
			return new String[] { r_cl_type_other,r_examine_name, r_rec_dept_name,
				r_approve_name, r_app_dept_name, r_cl_sts_desc,
				r_examine_name, r_cl_approve_desc,r_benf_name,
				r_approve_date, r_sub_amt ,r_suspense};
		else	
			return new String[] { r_agent_name, r_agent_dept_code, r_cl_event_desc,
				r_clus_ind,	r_cl_type_other, r_examine_name, r_rec_dept_name,
				r_approve_name, r_app_dept_name, r_cl_sts_desc,r_cl_examine_desc, r_cl_approve_desc};
	}

	public String[] getColumn3() {
		if (this.r_type.equals("G")) //cgmf
			
			return new String[] { r_benf_name,	r_approve_date, r_sub_amt ,	r_suspense,
				r_defer_beg_date, r_defer_end_date, r_defer_int, r_tax_withheld, r_addition_premium ,
				r_disb_amt_d, "", "" };
		else if (this.r_type.equals("T"))  //ctmf
		{ 
			return new String[] { r_defer_beg_date, r_defer_end_date,r_defer_int, r_tax_withheld, 
					r_unearned_prem,r_addition_premium,r_disb_amt_d, "","","","","" }; }
		else	
			
			return new String[] {  r_benf_name,r_approve_date, r_type, r_claim_amt, r_dividend, r_prem_susp,
				r_misc_susp, r_unearned_prem, r_loans, r_apls ,r_mode_prem, r_suspense};
	}

	public String[] getColumn4() {
		if (this.r_type.equals("G")) //cgmf
			return new String[] { "", "","" ,"",
				"", "", "","",
				"", "", "" ,""};
		else if (this.r_type.equals("T"))  //ctmf
			return new String[] { "", "","" ,"", "",
				"", "", "","",
				"", "", "" };
		else	
			return new String[] {r_loans_apls ,r_minus_prem_susp, r_cv_amt_out, r_sub_amt,
				r_defer_beg_date, r_defer_end_date, r_defer_int,
				r_tax_withheld, r_addition_premium ,r_disb_amt_d, r_currency };
	}
}
