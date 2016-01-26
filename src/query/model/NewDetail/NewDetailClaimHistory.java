package query.model.NewDetail;

import java.util.HashMap;

/**
 * 新契約明細理賠記錄(JavaBean) 使用理賠記錄的Query 此處另外作JavaBean binding
 * 
 * @author epf
 * 
 * @version 1.0
 * @since 1.0
 */
public class NewDetailClaimHistory {
	private String r_result_ind;
	private String r_event_name;
	private String r_claim_seq;
	private String r_claim_year;
	private String r_claim_desc;
	private String r_cl_event_desc;
	private String r_cl_event_desc_1;
	private String r_cl_event_desc_2;
	private String r_cl_event_desc_3;
	private String r_cl_event_desc_4;
	private String r_approve_date;
	private String r_cl_examine_desc;

	public NewDetailClaimHistory() {
	}

	public NewDetailClaimHistory(HashMap<String, String> hsmp) {
		r_result_ind = (hsmp.get("r_result_ind") == null) ? "" : hsmp.get(
				"r_result_ind").trim();
		r_event_name = (hsmp.get("r_event_name") == null) ? "" : hsmp.get(
				"r_event_name").trim();
		r_claim_seq = (hsmp.get("r_claim_seq") == null) ? "" : hsmp.get(
				"r_claim_seq").trim();
		r_claim_year = (hsmp.get("r_claim_year") == null) ? "" : hsmp.get(
				"r_claim_year").trim();
		r_claim_desc = (hsmp.get("r_claim_desc") == null) ? "" : hsmp.get(
				"r_claim_desc").trim();
		r_cl_event_desc = (hsmp.get("r_cl_event_desc") == null) ? "" : hsmp
				.get("r_cl_event_desc").trim();
		r_cl_event_desc_1 = (hsmp.get("r_cl_event_desc_1") == null) ? "" : hsmp
				.get("r_cl_event_desc_1").trim();
		r_cl_event_desc_2 = (hsmp.get("r_cl_event_desc_2") == null) ? "" : hsmp
				.get("r_cl_event_desc_2").trim();
		r_cl_event_desc_3 = (hsmp.get("r_cl_event_desc_3") == null) ? "" : hsmp
				.get("r_cl_event_desc_3").trim();
		r_cl_event_desc_4 = (hsmp.get("r_cl_event_desc_4") == null) ? "" : hsmp
				.get("r_cl_event_desc_4").trim();
		r_approve_date = (hsmp.get("r_approve_date") == null) ? "" : hsmp.get(
				"r_approve_date").trim();
		r_cl_examine_desc = (hsmp.get("r_cl_examine_desc") == null) ? "" : hsmp
				.get("r_cl_examine_desc").trim();
	}

	public String getR_result_ind() {
		return r_result_ind;
	}

	public void setR_result_ind(String r_result_ind) {
		this.r_result_ind = r_result_ind;
	}

	public String getR_event_name() {
		return r_event_name;
	}

	public void setR_event_name(String r_event_name) {
		this.r_event_name = r_event_name;
	}

	public String getR_claim_seq() {
		return r_claim_seq;
	}

	public void setR_claim_seq(String r_claim_seq) {
		this.r_claim_seq = r_claim_seq;
	}

	public String getR_claim_year() {
		return r_claim_year;
	}

	public void setR_claim_year(String r_claim_year) {
		this.r_claim_year = r_claim_year;
	}

	public String getR_claim_desc() {
		return r_claim_desc;
	}

	public void setR_claim_desc(String r_claim_desc) {
		this.r_claim_desc = r_claim_desc;
	}

	public String getR_cl_event_desc() {
		return r_cl_event_desc;
	}

	public void setR_cl_event_desc(String r_cl_event_desc) {
		this.r_cl_event_desc = r_cl_event_desc;
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

	public String getR_approve_date() {
		return r_approve_date;
	}

	public void setR_approve_date(String r_approve_date) {
		this.r_approve_date = r_approve_date;
	}

	public String getR_cl_examine_desc() {
		return r_cl_examine_desc;
	}

	public void setR_cl_examine_desc(String r_cl_examine_desc) {
		this.r_cl_examine_desc = r_cl_examine_desc;
	}

}
