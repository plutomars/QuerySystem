package query.model.NewDetail;

import java.util.HashMap;

/**
 * 新契約明細體檢資料(JavaBean)
 * 
 * @author epf
 * 
 * @version 1.0
 * 
 * @since 1.0
 */
public class NewDetailExamInfo {
	private String insured_id;
	private String exam_item_code;
	private String exam_item_desc;
	private String exam_date;
	private String policy_no;
	private String exam_result_ind;
	private String exam_result;
	private String hospital_name;
	
	public NewDetailExamInfo(HashMap<String, String> hsmp) {
		insured_id = (hsmp.get("r_insured_id") == null) ? "" : hsmp
				.get("r_insured_id").trim();
		exam_item_code = (hsmp.get("r_exam_item_code") == null) ? "" : hsmp
				.get("r_exam_item_code").trim();
		exam_item_desc = (hsmp.get("r_exam_item_desc") == null) ? "" : hsmp.get(
				"r_exam_item_desc").trim();
		exam_date = (hsmp.get("r_exam_date") == null) ? "" : hsmp
				.get("r_exam_date").trim();
		policy_no = (hsmp.get("r_policy_no") == null) ? "" : hsmp
				.get("r_policy_no").trim();
		exam_result_ind = (hsmp.get("r_exam_result_ind") == null) ? "" : hsmp
				.get("r_exam_result_ind").trim();
		exam_result = (hsmp.get("r_exam_result") == null) ? "" : hsmp.get(
				"r_exam_result").trim();
		hospital_name = (hsmp.get("r_hospital_name") == null) ? "" : hsmp.get(
				"r_hospital_name").trim();
	}

	public String getInsured_id() {
		return insured_id;
	}

	public void setInsured_id(String insured_id) {
		this.insured_id = insured_id;
	}
	
	public String getExam_item_code() {
		return exam_item_code;
	}

	public void setExam_item_code(String exam_item_code) {
		this.exam_item_code = exam_item_code;
	}
	
	public String getExam_item_desc() {
		return exam_item_desc;
	}

	public void setExam_item_desc(String exam_item_desc) {
		this.exam_item_desc = exam_item_desc;
	}

	public String getExam_date() {
		return exam_date;
	}

	public void setExam_date(String exam_date) {
		this.exam_date = exam_date;
	}

	public String getPolicy_no() {
		return policy_no;
	}

	public void setPolicy_no(String policy_no) {
		this.policy_no = policy_no;
	}
	
	public String getExam_result_ind() {
		return exam_result_ind;
	}

	public void setExam_result_ind(String exam_result_ind) {
		this.exam_result_ind = exam_result_ind;
	}
	
	public String getExam_result() {
		return exam_result;
	}

	public void setExam_result(String exam_result) {
		this.exam_result = exam_result;
	}

	public String getHospital_name() {
		return hospital_name;
	}

	public void setHospital_name(String hospital_name) {
		this.hospital_name = hospital_name;
	}

}
