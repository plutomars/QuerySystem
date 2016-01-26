package query.model.ClaimHistory;

import java.util.HashMap;

/**
 * @ * @author FYYANG
 * 
 * @version 1.0<br>
 *          100/08/22<br>
 *          (JavaBean)
 * @since 1.0
 */
public class ClaimHistory03 {
	private String r_result_ind;
	private String r_plan_code;
	private String r_rate_scale;
	private String r_co_issue_date;
	private String r_co_sts_code;
	private String r_face_amt;
	private String r_claim_amt;
	private String r_coverage_no;

	public ClaimHistory03(HashMap<String, String> hsmp) {
		r_result_ind = (hsmp.get("r_result_ind") == null) ? "" : hsmp.get(
				"r_result_ind").trim();
		r_plan_code = (hsmp.get("r_plan_code") == null) ? "" : hsmp.get(
				"r_plan_code").trim();
		r_rate_scale = (hsmp.get("r_rate_scale") == null) ? "" : hsmp.get(
				"r_rate_scale").trim();
		r_co_issue_date = (hsmp.get("r_co_issue_date") == null) ? "" : hsmp
				.get("r_co_issue_date").trim();
		r_co_sts_code = (hsmp.get("r_co_sts_code") == null) ? "" : hsmp.get(
				"r_co_sts_code").trim();
		r_face_amt = (hsmp.get("r_face_amt") == null) ? "" : hsmp.get(
				"r_face_amt").trim();
		r_claim_amt = (hsmp.get("r_claim_amt") == null) ? "" : hsmp.get(
				"r_claim_amt").trim();
		r_coverage_no = (hsmp.get("r_coverage_no") == null) ? "" : hsmp.get(
				"r_coverage_no").trim();
	}

	public String getR_result_ind() {
		return r_result_ind;
	}

	public void setR_result_ind(String r_result_ind) {
		this.r_result_ind = r_result_ind;
	}

	public String getR_plan_code() {
		return r_plan_code;
	}

	public void setR_plan_code(String r_plan_code) {
		this.r_plan_code = r_plan_code;
	}

	public String getR_rate_scale() {
		return r_rate_scale;
	}

	public void setR_rate_scale(String r_rate_scale) {
		this.r_rate_scale = r_rate_scale;
	}

	public String getR_co_issue_date() {
		return r_co_issue_date;
	}

	public void setR_co_issue_date(String r_co_issue_date) {
		this.r_co_issue_date = r_co_issue_date;
	}

	public String getR_co_sts_code() {
		return r_co_sts_code;
	}

	public void setR_co_sts_code(String r_co_sts_code) {
		this.r_co_sts_code = r_co_sts_code;
	}

	public String getR_face_amt() {
		return r_face_amt;
	}

	public void setR_face_amt(String r_face_amt) {
		this.r_face_amt = r_face_amt;
	}

	public String getR_claim_amt() {
		return r_claim_amt;
	}

	public void setR_claim_amt(String r_claim_amt) {
		this.r_claim_amt = r_claim_amt;
	}

	public String getR_coverage_no() {
		return r_coverage_no;
	}

	public void setR_coverage_no(String r_coverage_no) {
		this.r_coverage_no = r_coverage_no;
	}

}
