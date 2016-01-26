package query.model.NewDetail;

import java.util.HashMap;

/**
 * 新契約查詢 核保訊息部份(JavaBean)
 * 
 * @author epf
 * 
 * @version 1.0<br>
 *          100/07/28<br>
 * 
 * @since 1.0
 */
public class NewDetailUwErrCode {
	private String nb_err_code;
	private String nb_err_desc;
	private String client_id;
	private String client_ident;
	private String c_client_ident;
	private String coverage_no;
	private String plan_code;
	private String policy_no;
	private String occupation_level;

	public NewDetailUwErrCode(HashMap<String, String> hsmp) {
		nb_err_code = (hsmp.get("nb_err_code") == null) ? "" : hsmp.get(
				"nb_err_code").trim();
		nb_err_desc = (hsmp.get("nb_err_desc") == null) ? "" : hsmp.get(
				"nb_err_desc").trim();
		client_id = (hsmp.get("client_id") == null) ? "" : hsmp
				.get("client_id").trim();
		client_ident = (hsmp.get("client_ident") == null) ? "" : hsmp.get(
				"client_ident").trim();
		c_client_ident = (hsmp.get("c_client_ident") == null) ? "" : hsmp.get(
				"c_client_ident").trim();
		coverage_no = (hsmp.get("coverage_no") == null) ? "" : hsmp.get(
				"coverage_no").trim();
		plan_code = (hsmp.get("plan_code") == null) ? "" : hsmp
				.get("plan_code").trim();
		policy_no = (hsmp.get("policy_no") == null) ? "" : hsmp
				.get("policy_no").trim();
		occupation_level = (hsmp.get("occupation_level") == null) ? "" : hsmp
				.get("occupation_level").trim();
	}

	public String getNb_err_code() {
		return nb_err_code;
	}

	public void setNb_err_code(String nb_err_code) {
		this.nb_err_code = nb_err_code;
	}

	public String getNb_err_desc() {
		return nb_err_desc;
	}

	public void setNb_err_desc(String nb_err_desc) {
		this.nb_err_desc = nb_err_desc;
	}

	public String getClient_id() {
		return client_id;
	}

	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}

	public String getClient_ident() {
		return client_ident;
	}

	public void setClient_ident(String client_ident) {
		this.client_ident = client_ident;
	}

	public String getC_client_ident() {
		return c_client_ident;
	}

	public void setC_client_ident(String c_client_ident) {
		this.c_client_ident = c_client_ident;
	}

	public String getCoverage_no() {
		return coverage_no;
	}

	public void setCoverage_no(String coverage_no) {
		this.coverage_no = coverage_no;
	}

	public String getPlan_code() {
		return plan_code;
	}

	public void setPlan_code(String plan_code) {
		this.plan_code = plan_code;
	}

	public String getPolicy_no() {
		return policy_no;
	}

	public void setPolicy_no(String policy_no) {
		this.policy_no = policy_no;
	}

	public String getOccupation_level() {
		return occupation_level;
	}

	public void setOccupation_level(String occupation_level) {
		this.occupation_level = occupation_level;
	}

}
