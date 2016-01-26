package query.model.NewHospital;

/**
 * @version 1.0
 * @author swei
 * 體檢醫院查詢cc123i
 * 
 */

import java.util.HashMap;

import query.model.AbstractModelObject;

public class NewHospital02 extends AbstractModelObject {
	private String m_result_ind;    // 查詢結果
	private String m_exam_item_code;// 是否回覆
	private String m_exam_fee;      // 照會碼
	private String m_exam_item_desc;// 照會內容
	
	public NewHospital02(){
	}
	
	public NewHospital02(HashMap<String, String> hsmp) {		
		m_result_ind = (hsmp.get("r_result_ind") == null) ? "" : hsmp.get("r_result_ind").trim();
		m_exam_item_code = (hsmp.get("r_exam_item_code") == null) ? "" : hsmp.get("r_exam_item_code").trim();
		m_exam_fee = (hsmp.get("r_exam_fee") == null) ? "" : hsmp.get("r_exam_fee").trim();
		m_exam_item_desc = (hsmp.get("r_exam_item_desc") == null) ? "" : hsmp.get("r_exam_item_desc").trim();
	}
	
	public String getM_result_ind() {
		return m_result_ind;
	}
	public void setM_result_ind(String m_result_ind) {
		this.m_result_ind = m_result_ind;
		
		if (this.m_result_ind.equals("0")==false)
			javax.swing.JOptionPane.showMessageDialog(null, "查詢條件有誤:"+ this.m_result_ind);
	}
	public String getM_exam_item_code() {
		return m_exam_item_code;
	}
	public void setM_exam_item_code(String m_exam_item_code) {
		this.m_exam_item_code = m_exam_item_code;
	}
	public String getM_exam_fee() {
		return m_exam_fee;
	}
	public void setM_exam_fee(String m_exam_fee) {
		this.m_exam_fee = m_exam_fee;
	}
	public String getM_exam_item_desc() {
		return m_exam_item_desc;
	}
	public void setM_exam_item_desc(String m_exam_item_desc) {
		this.m_exam_item_desc = m_exam_item_desc;
	}
	
}
