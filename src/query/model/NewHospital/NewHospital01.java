package query.model.NewHospital;

/**
 * @version 1.0
 * @author swei
 * 體檢醫院查詢cc122i
 * 
 */

import java.util.HashMap;

import query.model.AbstractModelObject;

public class NewHospital01 extends AbstractModelObject {
	private String m_result_ind;    // 查詢結果
	private String m_surr_id;       // 合約終止碼
	private String m_hospital_id;   // 醫院代碼
	private String m_hospital_name; // 醫院名稱
	private String m_hospital_hc;   // 是否為健檢醫院
	private String m_address;       // 地址
	private String m_tel;           // 電話
	private String m_assign;        // 指定醫院
	private String m_area_name;        // 指定醫院
	
	public NewHospital01(){
	}
	
	public NewHospital01(HashMap<String, String> hsmp) {		
		m_result_ind = (hsmp.get("r_result_ind") == null) ? "" : hsmp.get("r_result_ind").trim();
		m_surr_id = (hsmp.get("r_surr_id") == null) ? "" : hsmp.get("r_surr_id").trim();
		m_hospital_id = (hsmp.get("r_hospital_id") == null) ? "" : hsmp.get("r_hospital_id").trim();
		m_hospital_name = (hsmp.get("r_hospital_name") == null) ? "" : hsmp.get("r_hospital_name").trim();
		m_hospital_hc = (hsmp.get("r_hospital_hc") == null) ? "" : hsmp.get("r_hospital_hc").trim();
		m_address = (hsmp.get("r_address") == null) ? "" : hsmp.get("r_address").trim();
		m_tel = (hsmp.get("r_tel") == null) ? "" : hsmp.get("r_tel").trim();	
		
		m_assign = (hsmp.get("r_assign") == null) ? "" : hsmp.get("r_assign").trim();
		m_area_name = (hsmp.get("r_area_name") == null) ? "" : hsmp.get("r_area_name").trim();
	}

	public String getM_assign() {
		return m_assign;
	}

	public void setM_assign(String m_assign) {
		this.m_assign = m_assign;
	}

	public String getM_result_ind() {
		return m_result_ind;
	}

	public void setM_result_ind(String m_result_ind) {
		this.m_result_ind = m_result_ind;
		
		if (this.m_result_ind.equals("0")==false)
			javax.swing.JOptionPane.showMessageDialog(null, "查詢條件有誤:"+ this.m_result_ind);
	}

	public String getM_surr_id() {
		return m_surr_id;
	}

	public void setM_surr_id(String m_surr_id) {
		this.m_surr_id = m_surr_id;
	}

	public String getM_hospital_id() {
		return m_hospital_id;
	}

	public void setM_hospital_id(String m_hospital_id) {
		this.m_hospital_id = m_hospital_id;
	}

	public String getM_hospital_name() {
		return m_hospital_name;
	}

	public void setM_hospital_name(String m_hospital_name) {
		this.m_hospital_name = m_hospital_name;
	}

	public String getM_hospital_hc() {
		return m_hospital_hc;
	}

	public void setM_hospital_hc(String m_hospital_hc) {
		this.m_hospital_hc = m_hospital_hc;
	}

	public String getM_address() {
		return m_address;
	}

	public void setM_address(String m_address) {
		this.m_address = m_address;
	}

	public String getM_tel() {
		return m_tel;
	}

	public void setM_tel(String m_tel) {
		this.m_tel = m_tel;
	}

	public String getM_area_name() {
		return m_area_name;
	}

	public void setM_area_name(String m_area_name) {
		this.m_area_name = m_area_name;
	}
	
}
