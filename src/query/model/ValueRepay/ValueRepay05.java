package query.model.ValueRepay;

import java.util.HashMap;

public class ValueRepay05 {
	private String r_result_ind;
	private String r_col_policy_no;
	private String r_po_sts_code;
	private String r_method_desc;
	private String r_paid_to_date;

	public ValueRepay05(HashMap<String, String> hsmp) {
		r_result_ind = (hsmp.get("r_result_ind") == null) ? "" : hsmp.get(
				"r_result_ind").trim();
		r_col_policy_no = (hsmp.get("r_col_policy_no") == null) ? "" : hsmp
				.get("r_col_policy_no").trim();
		r_po_sts_code = (hsmp.get("r_po_sts_code") == null) ? "" : hsmp.get(
				"r_po_sts_code").trim();
		r_method_desc = (hsmp.get("r_method_desc") == null) ? "" : hsmp.get(
				"r_method_desc").trim();
		r_paid_to_date = (hsmp.get("r_paid_to_date") == null) ? "" : hsmp.get(
				"r_paid_to_date").trim();

	}

	public String getR_result_ind() {
		return r_result_ind;
	}

	public void setR_result_ind(String r_result_ind) {
		this.r_result_ind = r_result_ind;
	}

	public String getR_col_policy_no() {
		return r_col_policy_no;
	}

	public void setR_col_policy_no(String r_col_policy_no) {
		this.r_col_policy_no = r_col_policy_no;
	}

	public String getR_po_sts_code() {
		return r_po_sts_code;
	}

	public void setR_po_sts_code(String r_po_sts_code) {
		this.r_po_sts_code = r_po_sts_code;
	}

	public String getR_method_desc() {
		return r_method_desc;
	}

	public void setR_method_desc(String r_method_desc) {
		this.r_method_desc = r_method_desc;
	}

	public String getR_paid_to_date() {
		return r_paid_to_date;
	}

	public void setR_paid_to_date(String r_paid_to_date) {
		this.r_paid_to_date = r_paid_to_date;
	}

}
