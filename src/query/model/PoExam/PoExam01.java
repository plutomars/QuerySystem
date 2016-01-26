package query.model.PoExam;

/**
 * @version 1.0
 * @author swei
 * 體檢批註告知查詢cc106i
 * 
 */
import java.util.HashMap;

import query.model.AbstractModelObject;

public class PoExam01 extends AbstractModelObject {
	private String m_result_ind;   // 查詢結果
	private String m_client_ident; // 關係
	private String m_client_id;    // 身分證
	private String m_names;        // 姓名
	private String m_notify_date;  // 照會日期
	private String m_exam_reason;  // 體檢原因

	private String m_receive_date; // 受理日期
	private String m_receive_no;   // 受理號碼

	public PoExam01(HashMap<String, String> hsmp) {
		m_result_ind = (hsmp.get("r_result_ind") == null) ? "" : hsmp.get("r_result_ind").trim();
		m_client_ident =(hsmp.get("r_client_ident") == null) ? "" : hsmp.get("r_client_ident").trim();
		m_client_id =(hsmp.get("r_client_id") == null) ? "" : hsmp.get("r_client_id").trim();
		m_names =(hsmp.get("r_names") == null) ? "" : hsmp.get("r_names").trim();
		m_notify_date =(hsmp.get("r_notify_date") == null) ? "" : hsmp.get("r_notify_date").trim();
		m_exam_reason =(hsmp.get("r_exam_reason") == null) ? "" : hsmp.get("r_exam_reason").trim();
		
		m_receive_date = (hsmp.get("r_receive_date") == null) ? "" : hsmp.get("r_receive_date").trim();
		m_receive_no = (hsmp.get("r_receive_no") == null) ? "" : hsmp.get("r_receive_no").trim();
	}
	public String getM_result_ind() {
		return m_result_ind;
	}

	public void setM_result_ind(String result_ind) {
		String oldValue = m_result_ind;
		m_result_ind = result_ind;
		firePropertyChange("result_ind", oldValue, m_result_ind);
		
		if (this.m_result_ind.equals("0")==false)
			javax.swing.JOptionPane.showMessageDialog(null, "查詢條件有誤cc000s:"+this.m_result_ind);
	}
	
	public String getM_client_ident() {
		return m_client_ident;
	}

	public void setM_client_ident(String client_ident) {
		String oldValue = m_client_ident;
		m_client_ident = client_ident;
		firePropertyChange("client_ident", oldValue, m_client_ident);
	}

	public String getM_client_id() {
		return m_client_id;
	}

	public void setM_client_id(String client_id) {
		String oldValue = m_client_id;
		m_client_id = client_id;
		firePropertyChange("client_id", oldValue, m_client_id);
	}

	public String getM_names() {
		return m_names;
	}

	public void setM_names(String names) {
		String oldValue = m_names;
		m_names = names;
		firePropertyChange("names", oldValue, m_names);
	}

	public String getM_notify_date() {
		return m_notify_date;
	}

	public void setM_notify_date(String notify_date) {
		String oldValue = m_notify_date;
		m_notify_date = notify_date;
		firePropertyChange("notify_date", oldValue, m_notify_date);
	}

	public String getM_exam_reason() {
		return m_exam_reason;
	}

	public void setM_exam_reason(String exam_reason) {
		String oldValue = m_exam_reason;
		m_exam_reason = exam_reason;
		firePropertyChange("exam_reason", oldValue, m_exam_reason);
	}

	public String getM_receive_date() {
		return m_receive_date;
	}

	public void setM_receive_date(String receive_date) {
		String oldValue = m_receive_date;
		m_receive_date = receive_date;
		firePropertyChange("receive_date", oldValue, m_receive_date);
	}

	public String getM_receive_no() {
		return m_receive_no;
	}

	public void setM_receive_no(String receive_no) {
		String oldValue = m_receive_no;
		m_receive_no = receive_no;
		firePropertyChange("receive_no", oldValue, m_receive_no);
	}

}
