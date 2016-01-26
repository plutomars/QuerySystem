package query.model.ClaimHistory;

import java.util.HashMap;

/**
 * @ * @author FYYANG
 * 
 * @version 1.0<br>
 *          100/07/28<br>
 *          Ãö«Y(JavaBean)
 * @since 1.0
 */
public class ClaimHistory06 {
	private String r_result_ind;
	private String r_plan_abbr_code;
	private String r_rate_scale;
	private String r_cl_notice_code;
	private String r_cl_notice_desc1;

	public ClaimHistory06(HashMap<String, String> hsmp) {
		r_result_ind = (hsmp.get("r_result_ind") == null) ? "" : hsmp.get(
				"r_result_ind").trim();
		r_plan_abbr_code = (hsmp.get("r_plan_abbr_code") == null) ? "" : hsmp
				.get("r_plan_abbr_code").trim();
		r_rate_scale = (hsmp.get("r_rate_scale") == null) ? "" : hsmp.get(
				"r_rate_scale").trim();
		r_cl_notice_code = (hsmp.get("r_cl_notice_code") == null) ? "" : hsmp
				.get("r_cl_notice_code").trim();
		r_cl_notice_desc1 = (hsmp.get("r_cl_notice_desc1") == null) ? "" : hsmp
				.get("r_cl_notice_desc1").trim();

	}

	public String getR_result_ind() {
		return r_result_ind;
	}

	public void setR_result_ind(String r_result_ind) {
		this.r_result_ind = r_result_ind;
	}

	public String getR_plan_abbr_code() {
		return r_plan_abbr_code;
	}

	public void setR_plan_abbr_code(String r_plan_abbr_code) {
		this.r_plan_abbr_code = r_plan_abbr_code;
	}

	public String getR_rate_scale() {
		return r_rate_scale;
	}

	public void setR_rate_scale(String r_rate_scale) {
		this.r_rate_scale = r_rate_scale;
	}

	public String getR_cl_notice_code() {
		return r_cl_notice_code;
	}

	public void setR_cl_notice_code(String r_cl_notice_code) {
		this.r_cl_notice_code = r_cl_notice_code;
	}

	public String getR_cl_notice_desc1() {
		return r_cl_notice_desc1;
	}

	public void setR_cl_notice_desc1(String r_cl_notice_desc1) {
		this.r_cl_notice_desc1 = r_cl_notice_desc1;
	}

}
