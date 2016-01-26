package query.model.NewRescind;

import java.util.HashMap;

public class NewRescind01 {
	private String r_result_ind;
	private String r_policy_no;
	private String r_applicant_name;
	private String r_insured_name;
	private String r_pocc_sts_code;
	private String r_pocc_sts_desc;
	private String r_process_date;
	private String r_image_prn_date;
	private String r_apply_date;
	private String r_receive_date;
	private String r_settle_date;
	private String r_in_force_date;
	private String r_pocc_rej_code;
	private String r_pocc_rej_desc;
	private String r_po_sts_code;
	private String r_po_sts_desc;
	private String r_tran_policy_no;

	public void setValues(HashMap<String, String> hsmp) {

		r_result_ind = (hsmp.get("r_result_ind") == null) ? "" : hsmp.get(
				"r_result_ind").trim();
		r_policy_no = (hsmp.get("r_policy_no") == null) ? "" : hsmp.get(
				"r_policy_no").trim();
		r_applicant_name = (hsmp.get("r_applicant_name") == null) ? "" : hsmp
				.get("r_applicant_name").trim();
		r_insured_name = (hsmp.get("r_insured_name") == null) ? "" : hsmp.get(
				"r_insured_name").trim();
		r_pocc_sts_code = (hsmp.get("r_pocc_sts_code") == null) ? "" : hsmp
				.get("r_pocc_sts_code").trim();
		r_pocc_sts_desc = (hsmp.get("r_pocc_sts_desc") == null) ? "" : hsmp
				.get("r_pocc_sts_desc").trim();
		r_process_date = (hsmp.get("r_process_date") == null) ? "" : hsmp.get(
				"r_process_date").trim();
		r_image_prn_date = (hsmp.get("r_image_prn_date") == null) ? "" : hsmp.get(
				"r_image_prn_date").trim();
		r_apply_date = (hsmp.get("r_apply_date") == null) ? "" : hsmp.get(
				"r_apply_date").trim();
		r_receive_date = (hsmp.get("r_receive_date") == null) ? "" : hsmp.get(
				"r_receive_date").trim();
		r_in_force_date = (hsmp.get("r_in_force_date") == null) ? "" : hsmp.get(
				"r_in_force_date").trim();
		r_settle_date = (hsmp.get("r_settle_date") == null) ? "" : hsmp.get(
				"r_settle_date").trim();
		r_pocc_rej_code = (hsmp.get("r_pocc_rej_code") == null) ? "" : hsmp
				.get("r_pocc_rej_code").trim();
		r_pocc_rej_desc = (hsmp.get("r_pocc_rej_desc") == null) ? "" : hsmp
				.get("r_pocc_rej_desc").trim();
		r_po_sts_code = (hsmp.get("r_po_sts_code") == null) ? "" : hsmp.get(
				"r_po_sts_code").trim();
		r_po_sts_desc = (hsmp.get("r_po_sts_desc") == null) ? "" : hsmp.get(
				"r_po_sts_desc").trim();
		r_tran_policy_no = (hsmp.get("r_tran_policy_no") == null) ? "" : hsmp
				.get("r_tran_policy_no").trim();
	}

	// Panel®M¥Î
	public String[] getColumn1Values() {
		return new String[] { r_policy_no, r_applicant_name, r_insured_name,
				r_po_sts_code +" "+ r_po_sts_desc };
	}

	public String[] getColumn2Values() {
		return new String[] { r_in_force_date,r_image_prn_date, r_apply_date, r_receive_date
				 };
	}

	public String[] getColumn3Values() {
		return new String[] { r_settle_date,r_pocc_sts_code +" "+ r_pocc_sts_desc,
				r_pocc_rej_code +" "+ r_pocc_rej_desc,r_tran_policy_no };
	}

	public NewRescind01() {

	}
	
	// Äæ¦ì­È
	public String getR_result_ind() {
		return r_result_ind;
	}

	public void setR_result_ind(String r_result_ind) {
		this.r_result_ind = r_result_ind;
	}

	public String getR_policy_no() {
		return r_policy_no;
	}

	public void setR_policy_no(String r_policy_no) {
		this.r_policy_no = r_policy_no;
	}

	public String getR_applicant_name() {
		return r_applicant_name;
	}

	public void setR_applicant_name(String r_applicant_name) {
		this.r_applicant_name = r_applicant_name;
	}

	public String getR_insured_name() {
		return r_insured_name;
	}

	public void setR_insured_name(String r_insured_name) {
		this.r_insured_name = r_insured_name;
	}

	public String getR_pocc_sts_code() {
		return r_pocc_sts_code;
	}

	public void setR_pocc_sts_code(String r_pocc_sts_code) {
		this.r_pocc_sts_code = r_pocc_sts_code;
	}

	public String getR_pocc_sts_desc() {
		return r_pocc_sts_desc;
	}

	public void setR_pocc_sts_desc(String r_pocc_sts_desc) {
		this.r_pocc_sts_desc = r_pocc_sts_desc;
	}

	public String getR_process_date() {
		return r_process_date;
	}

	public void setR_process_date(String r_process_date) {
		this.r_process_date = r_process_date;
	}

	public String getR_image_prn_date() {
		return r_image_prn_date;
	}

	public void setR_image_prn_date(String r_image_prn_date) {
		this.r_image_prn_date = r_image_prn_date;
	}

	
	public String getR_apply_date() {
		return r_apply_date;
	}

	public void setR_apply_date(String r_apply_date) {
		this.r_apply_date = r_apply_date;
	}

	public String getR_receive_date() {
		return r_receive_date;
	}

	public void setR_receive_date(String r_receive_date) {
		this.r_receive_date = r_receive_date;
	}

	public String getR_settle_date() {
		return r_settle_date;
	}

	public void setR_settle_date(String r_settle_date) {
		this.r_settle_date = r_settle_date;
	}

	public String getR_in_force_date() {
		return r_in_force_date;
	}

	public void setR_in_force_date(String r_in_force_date) {
		this.r_in_force_date = r_in_force_date;
	}
	
	public String getR_pocc_rej_code() {
		return r_pocc_rej_code;
	}

	public void setR_pocc_rej_code(String r_pocc_rej_code) {
		this.r_pocc_rej_code = r_pocc_rej_code;
	}

	public String getR_pocc_rej_desc() {
		return r_pocc_rej_desc;
	}

	public void setR_pocc_rej_desc(String r_pocc_rej_desc) {
		this.r_pocc_rej_desc = r_pocc_rej_desc;
	}

	public String getR_po_sts_code() {
		return r_po_sts_code;
	}

	public void setR_po_sts_code(String r_po_sts_code) {
		this.r_po_sts_code = r_po_sts_code;
	}

	public String getR_po_sts_desc() {
		return r_po_sts_desc;
	}

	public void setR_po_sts_desc(String r_po_sts_desc) {
		this.r_po_sts_desc = r_po_sts_desc;
	}

	public String getR_tran_policy_no() {
		return r_tran_policy_no;
	}

	public void setR_tran_policy_no(String r_tran_policy_no) {
		this.r_tran_policy_no = r_tran_policy_no;
	}

}