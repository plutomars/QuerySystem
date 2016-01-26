package query.model.NewDetail;

import java.util.HashMap;

/**
 * 新契約明細基本資料優體保單部份(JavaBean)
 * 
 * @author epf
 * 
 * @version 1.0<br>
 *          100/07/28<br>
 * 
 * @since 1.0
 */
public class NewDetailPreferredExam {
	private String exam_item_code_desc;// 包含代碼及敘述
	private String exam_value;
	private String exam_value_rank; // 是否為正常值 Y N
	private String exam_respond_value; // 是否為優體P N
	private String height;
	private String weight;
	private String bmi;
	private String cho_hdl_ratio;
	private String preferred_Exam_Ind; // 優體壽險等級

	public NewDetailPreferredExam(HashMap<String, String> hsmp) {
		exam_item_code_desc = (hsmp.get("exam_item_code_desc") == null) ? ""
				: hsmp.get("exam_item_code_desc").trim();
		exam_value = (hsmp.get("exam_value") == null) ? "" : hsmp.get(
				"exam_value").trim();
		exam_value_rank = (hsmp.get("exam_value_rank") == null) ? "" : hsmp
				.get("exam_value_rank").trim();
		exam_respond_value = (hsmp.get("exam_respond_value") == null) ? ""
				: hsmp.get("exam_respond_value").trim();
		height = (hsmp.get("height") == null) ? "" : hsmp.get("height").trim();
		weight = (hsmp.get("weight") == null) ? "" : hsmp.get("weight").trim();
		bmi = (hsmp.get("bmi") == null) ? "" : hsmp.get("bmi").trim();
		cho_hdl_ratio = (hsmp.get("cho_hdl_ratio") == null) ? "" : hsmp.get(
				"cho_hdl_ratio").trim();
		preferred_Exam_Ind = (hsmp.get("preferred_Exam_Ind") == null) ? ""
				: hsmp.get("preferred_Exam_Ind").trim();
	}

	public String getExam_item_code_desc() {
		return exam_item_code_desc;
	}

	public void setExam_item_code_desc(String exam_item_code_desc) {
		this.exam_item_code_desc = exam_item_code_desc;
	}

	public String getExam_value() {
		return exam_value;
	}

	public void setExam_value(String exam_value) {
		this.exam_value = exam_value;
	}

	public String getExam_value_rank() {
		return exam_value_rank;
	}

	public void setExam_value_rank(String exam_value_rank) {
		this.exam_value_rank = exam_value_rank;
	}

	public String getExam_respond_value() {
		return exam_respond_value;
	}

	public void setExam_respond_value(String exam_respond_value) {
		this.exam_respond_value = exam_respond_value;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getBmi() {
		return bmi;
	}

	public void setBmi(String bmi) {
		this.bmi = bmi;
	}

	public String getCho_hdl_ratio() {
		return cho_hdl_ratio;
	}

	public void setCho_hdl_ratio(String cho_hdl_ratio) {
		this.cho_hdl_ratio = cho_hdl_ratio;
	}

	public String getPreferred_Exam_Ind() {
		return preferred_Exam_Ind;
	}

	public void setPreferred_Exam_Ind(String preferred_Exam_Ind) {
		this.preferred_Exam_Ind = preferred_Exam_Ind;
	}

}
