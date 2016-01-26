package query.model.PosNotice;

import java.util.HashMap;
/**
 * @author cychu
 * 
 * @version 1.0<br/>
 * 			100/09/07<br/>
 * 			照會項目(JavaBean)
 * 
 * @since 1.0
 */
public class PosNotice03 {
	private String result_ind;				//0_查詢結果
	private String exam_reason_code;		//1_體檢原因碼
	private String exam_reason_desc;		//2_體檢原因說明
	
	public PosNotice03(HashMap<String, String> hsmp) {
		result_ind = (hsmp.get("r_result_ind") == null) ? "" : hsmp.get(
			"r_result_ind").trim();
		exam_reason_code = (hsmp.get("r_exam_reason_code") == null) ? "" : hsmp.get(
			"r_exam_reason_code").trim();
		exam_reason_desc = (hsmp.get("r_exam_reason_desc") == null) ? "" : hsmp.get(
			"r_exam_reason_desc").trim();
	}

	public String getResult_ind() {
		return result_ind;
	}

	public void setResult_ind(String result_ind) {
		this.result_ind = result_ind;
	}

	public String getExam_reason_code() {
		return exam_reason_code;
	}

	public void setExam_reason_code(String exam_reason_code) {
		this.exam_reason_code = exam_reason_code;
	}

	public String getExam_reason_desc() {
		return exam_reason_desc;
	}

	public void setExam_reason_desc(String exam_reason_desc) {
		this.exam_reason_desc = exam_reason_desc;
	}
}
