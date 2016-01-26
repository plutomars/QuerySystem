package query.model.NewDetail;

import java.util.HashMap;

/**
 * 新契約明細基本資料要保人部份(JavaBean)
 * 
 * @author epf
 * 
 * @version 1.0<br>
 * 
 * @since 1.0
 */
public class NewDetailComm {
	private String o1_id;
	private String o1_name;
	private String o1_birth;
	private String home_addr;
	private String mail_addr;
	private String policy_no;
	private String po_sts_code;
	private String modx;
	private String method;
	private String mode_prem;
	private String app_apply_date;
	private String po_issue_date;
	private String in_force_date;
	private String uw_write_date;
	private String image_prn_date;
	private String home_tel;
	private String mail_tel;
	private String mobile_phone;
	private String e_mail;
	private String o1_occu;
	private String class_type;
	private String o1_sign_ptn_card;
	private String home_addr_ind; // 101/03/30秋燕要求
	private String mail_addr_ind;
	private String fy_billing_ind; //101/09/19 cora
	
	public NewDetailComm(HashMap<String, String> hsmp) {
		o1_id = (hsmp.get("o1_id") == null) ? "" : hsmp.get("o1_id").trim();
		o1_name = (hsmp.get("o1_name") == null) ? "" : hsmp.get("o1_name")
				.trim();
		o1_birth = (hsmp.get("o1_birth") == null) ? "" : hsmp.get("o1_birth")
				.trim();
		home_addr = (hsmp.get("home_addr") == null) ? "" : hsmp
				.get("home_addr").trim();
		mail_addr = (hsmp.get("mail_addr") == null) ? "" : hsmp
				.get("mail_addr").trim();
		policy_no = (hsmp.get("policy_no") == null) ? "" : hsmp
				.get("policy_no").trim();
		po_sts_code = (hsmp.get("po_sts_code") == null) ? "" : hsmp.get(
				"po_sts_code").trim();
		modx = (hsmp.get("modx") == null) ? "" : hsmp.get("modx").trim();
		method = (hsmp.get("method") == null) ? "" : hsmp.get("method").trim();
		mode_prem = (hsmp.get("mode_prem") == null) ? "" : hsmp
				.get("mode_prem").trim();
		po_issue_date = (hsmp.get("po_issue_date") == null) ? "" : hsmp.get(
				"po_issue_date").trim();
		in_force_date = (hsmp.get("in_force_date") == null) ? "" : hsmp.get(
				"in_force_date").trim();
		app_apply_date = (hsmp.get("app_apply_date") == null) ? "" : hsmp.get(
				"app_apply_date").trim();
		uw_write_date = (hsmp.get("uw_write_date") == null) ? "" : hsmp.get(
				"uw_write_date").trim();
		image_prn_date = (hsmp.get("image_prn_date") == null) ? "" : hsmp
				.get("image_prn_date").trim();
		home_tel = (hsmp.get("home_tel") == null) ? "" : hsmp.get("home_tel")
				.trim();
		mail_tel = (hsmp.get("mail_tel") == null) ? "" : hsmp.get("mail_tel")
				.trim();
		mobile_phone = (hsmp.get("mobile_phone") == null) ? "" : hsmp.get(
				"mobile_phone").trim();
		e_mail = (hsmp.get("e_mail") == null) ? "" : hsmp.get("e_mail").trim();
		o1_occu = (hsmp.get("o1_occu") == null) ? "" : hsmp.get("o1_occu")
				.trim();
		class_type = (hsmp.get("class_type") == null) ? "" : hsmp.get("class_type")
				.trim();
		o1_sign_ptn_card = (hsmp.get("o1_sign_ptn_card") == null) ? "" : hsmp.get("o1_sign_ptn_card")
				.trim();
		home_addr_ind = (hsmp.get("home_addr_ind") == null) ? "" : hsmp
				.get("home_addr_ind").trim();
		mail_addr_ind = (hsmp.get("mail_addr_ind") == null) ? "" : hsmp
				.get("mail_addr_ind").trim();
		fy_billing_ind = (hsmp.get("fy_billing_ind") == null) ? "" : hsmp
				.get("fy_billing_ind").trim();
		
	}

	public String getO1_id() {
		return o1_id;
	}

	public void setO1_id(String o1_id) {
		this.o1_id = o1_id;
	}

	public String getO1_name() {
		return o1_name;
	}

	public void setO1_name(String o1_name) {
		this.o1_name = o1_name;
	}

	public String getO1_birth() {
		return o1_birth;
	}

	public void setO1_birth(String o1_birth) {
		this.o1_birth = o1_birth;
	}

	public String getHome_addr() {
		return home_addr;
	}

	public void setHome_addr(String home_addr) {
		this.home_addr = home_addr;
	}

	public String getMail_addr() {
		return mail_addr;
	}

	public void setMail_addr(String mail_addr) {
		this.mail_addr = mail_addr;
	}

	public String getPolicy_no() {
		return policy_no;
	}

	public void setPolicy_no(String policy_no) {
		this.policy_no = policy_no;
	}

	public String getPo_sts_code() {
		return po_sts_code;
	}

	public void setPo_sts_code(String po_sts_code) {
		this.po_sts_code = po_sts_code;
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

	public String getMode_prem() {
		return mode_prem;
	}

	public void setMode_prem(String mode_prem) {
		this.mode_prem = mode_prem;
	}

	public String getApp_apply_date() {
		return app_apply_date;
	}

	public void setApp_apply_date(String app_apply_date) {
		this.app_apply_date = app_apply_date;
	}

	public String getPo_issue_date() {
		return po_issue_date;
	}

	public void setPo_issue_date(String po_issue_date) {
		this.po_issue_date = po_issue_date;
	}

	public String getIn_force_date() {
		return in_force_date;
	}

	public void setIn_force_date(String in_force_date) {
		this.in_force_date = in_force_date;
	}

	public String getUw_write_date() {
		return uw_write_date;
	}

	public void setUw_write_date(String uw_write_date) {
		this.uw_write_date = uw_write_date;
	}

	public String getimage_prn_date() {
		return image_prn_date;
	}

	public void setimage_prn_date(String image_prn_date) {
		this.image_prn_date = image_prn_date;
	}

	public String getHome_tel() {
		return home_tel;
	}

	public void setHome_tel(String home_tel) {
		this.home_tel = home_tel;
	}

	public String getMail_tel() {
		return mail_tel;
	}

	public void setMail_tel(String mail_tel) {
		this.mail_tel = mail_tel;
	}

	public String getMobile_phone() {
		return mobile_phone;
	}

	public void setMobile_phone(String mobile_phone) {
		this.mobile_phone = mobile_phone;
	}

	public String getE_mail() {
		return e_mail;
	}

	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}

	public String getO1_occu() {
		return o1_occu;
	}

	public void setO1_occu(String o1_occu) {
		this.o1_occu = o1_occu;
	}
	
	public String getClass_type() {
		return class_type;
	}
	
	public String getO1_sign_ptn_card() {
		return o1_sign_ptn_card;
	}

	public void setO1_sign_ptn_card(String o1_sign_ptn_card) {
		this.o1_sign_ptn_card = o1_sign_ptn_card;
	}

	public void setClass_type(String class_type) {
		this.class_type = class_type;
	}
	
	public String getHome_addr_ind() {
		return home_addr_ind;
	}

	public void setHome_addr_ind(String home_addr_ind) {
		this.home_addr_ind = home_addr_ind;
	}

	public String getMail_addr_ind() {
		return mail_addr_ind;
	}

	public void setMail_addr_ind(String mail_addr_ind) {
		this.mail_addr_ind = mail_addr_ind;
	}
	
	public String getfy_billing_ind() {
		return fy_billing_ind;
	}

	public void setfy_billing_ind(String fy_billing_ind) {
		this.fy_billing_ind = fy_billing_ind;
	}
	
	public String[] getColumn1() {
		return new String[] { o1_id, o1_name+"/"+o1_sign_ptn_card, o1_birth, home_addr_ind+"/"+home_addr, mail_addr_ind+"/"+mail_addr };
	}

	public String[] getColumn2() {
		return new String[] { policy_no, po_sts_code, modx+"/"+mode_prem, method,fy_billing_ind  };
	}

	public String[] getColumn3() {
		return new String[] { app_apply_date, po_issue_date,uw_write_date, 
				in_force_date, image_prn_date };
	}

	public String[] getColumn4() {
		return new String[] { home_tel, mail_tel, mobile_phone, e_mail, o1_occu };
	}

}
