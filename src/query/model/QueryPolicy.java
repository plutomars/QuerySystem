package query.model;

import java.util.HashMap;

public class QueryPolicy {
	private String policy_no;
	private String app_apply_date;  //要保日
	private String issue_date; 		//生效日
	private String plan_code;		//主約險種
	private String sts_code;		//保單狀態
	private String mode_prem;  	//每期保費
	private String o1_name;			//
	private String i1_name;
	private String o1_id;
	private String i1_id;
	private String s_ag_name;		//服務業務員
	private String mail_addr;		//收費地區
	private String paid_to_date;	//PTD
	private String bill_to_date;	//BTD
	private String modx;			//繳別
	private String method;			//收費方式
	private String class_type;	
	private String currency;
	private String mail_addr_ind;	//101/04/02秋燕要求增加
	private String home_addr_ind;
	private String uw_write_date;

	public QueryPolicy() {

	}

	public QueryPolicy(String policy_no, String issue_date, String plan_code,
			String sts_code, String o1_name, String i1_name, String o1_id) {
		this.policy_no = policy_no;
		this.issue_date = issue_date;
		this.plan_code = plan_code;
		this.sts_code = sts_code;
		this.o1_name = o1_name;
		this.i1_name = i1_name;
		this.o1_id = o1_id;
//		System.out.println("QueryPolicy chg");
	}

	public QueryPolicy(HashMap<String, String> hsmp) {
		policy_no = (hsmp.get("policy_no") == null) ? "" : hsmp.get("policy_no").trim();
		issue_date = (hsmp.get("po_issue_date") == null) ? "" : hsmp.get(
				"po_issue_date").trim();
		plan_code = (hsmp.get("basic_plan_code") == null) ? "" : hsmp.get(
				"basic_plan_code").trim();
		sts_code = (hsmp.get("po_sts_code") == null) ? "" : hsmp.get("po_sts_code").trim();
		o1_name = (hsmp.get("o1_name") == null) ? "" : hsmp.get("o1_name").trim();
		i1_name = (hsmp.get("i1_name") == null) ? "" : hsmp.get("i1_name").trim();
		o1_id = (hsmp.get("o1_id") == null) ? "" : hsmp.get("o1_id").trim();
		class_type = (hsmp.get("class_type") == null) ? "" : hsmp.get("class_type").trim();
		app_apply_date = (hsmp.get("app_apply_date") == null) ? "" : hsmp.get("app_apply_date").trim();
		mode_prem = (hsmp.get("mode_prem") == null) ? "" : hsmp.get("mode_prem").trim();
		i1_id = (hsmp.get("i1_id") == null) ? "" : hsmp.get("i1_id").trim();
		s_ag_name = (hsmp.get("s_ag_name") == null) ? "" : hsmp.get("s_ag_name").trim();
		mail_addr = (hsmp.get("mail_addr") == null) ? "" : hsmp.get("mail_addr").trim();
		paid_to_date = (hsmp.get("paid_to_date") == null) ? "" : hsmp.get("paid_to_date").trim();
		bill_to_date = (hsmp.get("bill_to_date") == null) ? "" : hsmp.get("bill_to_date").trim();
		modx = (hsmp.get("modx") == null) ? "" : hsmp.get("modx").trim();
		method = (hsmp.get("method") == null) ? "" : hsmp.get("method").trim();
		currency = (hsmp.get("currency") == null) ? "" : hsmp.get("currency").trim();
		mail_addr_ind = (hsmp.get("mail_addr_ind") == null) ? "" : hsmp.get("mail_addr_ind").trim();
		home_addr_ind = (hsmp.get("home_addr_ind") == null) ? "" : hsmp.get("home_addr_ind").trim();
		uw_write_date = (hsmp.get("uw_write_date") == null) ? "" : hsmp.get("uw_write_date").trim();
	}

	public String getPolicy_no() {
		return policy_no;
	}

	public void setPolicy_no(String policy_no) {
		this.policy_no = policy_no;
	}

	public String getIssue_date() {
		return issue_date;
	}

	public void setIssue_date(String issue_date) {
		this.issue_date = issue_date;
	}

	public String getPlan_code() {
		return plan_code;
	}

	public void setPlan_code(String plan_code) {
		this.plan_code = plan_code;
	}

	public String getSts_code() {
		return sts_code;
	}

	public void setSts_code(String sts_code) {
		this.sts_code = sts_code;
	}

	public String getO1_name() {
		return o1_name;
	}

	public void setO1_name(String o1_name) {
		this.o1_name = o1_name;
	}

	public String getI1_name() {
		return i1_name;
	}

	public void setI1_name(String i1_name) {
		this.i1_name = i1_name;
	}

	public String getO1_id() {
		return o1_id;
	}

	public void setO1_id(String o1_id) {
		this.o1_id = o1_id;
	}

	public String getClass_type() {
		return class_type;
	}

	public void setClass_type(String class_type) {
		this.class_type = class_type;
	}
	
	public String getapp_apply_date() {
		return app_apply_date;
	}

	public void setapp_apply_date(String app_apply_date) {
		this.app_apply_date = app_apply_date;
	}

	public String getmode_prem() {
		return mode_prem;
	}

	public void setmode_prem(String mode_prem) {
		this.mode_prem = mode_prem;
	}
	
	public String getI1_id() {
		return i1_id;
	}

	public void setI1_id(String i1_id) {
		this.i1_id = i1_id;
	}
	public String getMail_addr() {
		return mail_addr;
	}

	public void setMail_addr(String mail_addr) {
		this.mail_addr = mail_addr;
	}

	public String getPaid_to_date() {
		return paid_to_date;
	}

	public void setPaid_to_date(String paid_to_date) {
		this.paid_to_date = paid_to_date;
	}
	
	public String getBill_to_date() {
		return bill_to_date;
	}

	public void setBill_to_date(String bill_to_date) {
		this.bill_to_date = bill_to_date;
	}
	public String getModx() {
		return modx;
	}

	public void setModx(String modx) {
		this.modx = modx;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}
	
	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	public String getS_ag_name() {
		return s_ag_name;
	}

	public void setS_ag_name(String s_ag_name) {
		this.s_ag_name = s_ag_name;
	}
	
	public String getmail_addr_ind() {
		return mail_addr_ind;
	}

	public void setmail_addr_ind(String mail_addr_ind) {
		this.mail_addr_ind = mail_addr_ind;
	}
	
	public String gethome_addr_ind() {
		return home_addr_ind;
	}

	public void sethome_addr_ind(String home_addr_ind) {
		this.home_addr_ind = home_addr_ind;
	}
	public String getuw_write_date() {
		return uw_write_date;
	}

	public void setuw_write_date(String uw_write_date) {
		this.uw_write_date = uw_write_date;
	}
}
