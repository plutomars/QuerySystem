package query.model.PosNotice;

import java.util.HashMap;
/**
 * @author cychu
 * 
 * @version 1.0<br/>
 * 			100/09/07<br/>
 * 			體檢項目(JavaBean)
 * 
 * @since 1.0
 */
public class PosNotice05 {
	private String result_ind;				//0_查詢結果
	private String exam_item_code;			//1_體檢項目碼
	private String exam_item_desc;			//2_體檢項目說明
	
	public PosNotice05(HashMap<String, String> hsmp) {
		result_ind = (hsmp.get("r_result_ind") == null) ? "" : hsmp.get(
			"r_result_ind").trim();
		exam_item_code = (hsmp.get("r_exam_item_code") == null) ? "" : hsmp.get(
			"r_exam_item_code").trim();
		exam_item_desc = (hsmp.get("r_exam_item_desc") == null) ? "" : hsmp.get(
			"r_exam_item_desc").trim();
	}

	public String getResult_ind() {
		return result_ind;
	}

	public void setResult_ind(String result_ind) {
		this.result_ind = result_ind;
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
}
