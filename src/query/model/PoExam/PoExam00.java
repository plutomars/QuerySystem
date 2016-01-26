package query.model.PoExam;

/**
 * @version 1.0
 * @author swei
 * ���˧���i���d��PoExam_query
 * 
 */

import java.util.HashMap;

import query.model.AbstractModelObject;

public class PoExam00 extends AbstractModelObject {

	private String m_client_ident;     // ���Y
	private String m_receive_date;     // ���z���
	private String m_receive_no;       // ���z���X
	private String m_client_id;        // ������
	private String m_names;            // �m�W
	private String m_statement;        // �z����
	private String m_policy_no;   

	public PoExam00(HashMap<String, String> hsmp) {
		m_client_ident =(hsmp.get("r_client_ident") == null) ? "" : hsmp.get("r_client_ident").trim();		
		m_receive_date =(hsmp.get("r_receive_date") == null) ? "" : hsmp.get("r_receive_date").trim();
		m_receive_no =(hsmp.get("r_receive_no") == null) ? "" : hsmp.get("r_receive_no").trim();		
		m_client_id =(hsmp.get("r_client_id") == null) ? "" : hsmp.get("r_client_id").trim();
		m_names =(hsmp.get("r_names") == null) ? "" : hsmp.get("r_names").trim();
		m_statement =(hsmp.get("r_statement") == null) ? "" : hsmp.get("r_statement").trim();
		m_policy_no = (hsmp.get("r_policy_no") == null) ? "" : hsmp.get("r_policy_no").trim();
	}

	public String getM_client_ident() {
		return m_client_ident;
	}

	public void setM_client_ident(String client_ident) {
		String oldValue = m_client_ident;
		m_client_ident = client_ident;
		firePropertyChange("client_ident", oldValue, m_client_ident);
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

	public String getM_statement() {
		return m_statement;
	}

	public void setM_statement(String statement) {
		String oldValue = m_statement;
		m_statement = statement;
		firePropertyChange("statement", oldValue, m_statement);
	}
	public String getM_policy_no() {
		return m_policy_no;
	}

	public void setM_policy_no(String policy_no) {
		this.m_policy_no = policy_no;
	}

}
