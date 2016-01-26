package query.model.PremGBill;

/**
 * 
 * @author swei
 * @version 1.0
 * ����Jú�d��cc134i
 * 
 */

import java.util.ArrayList;
import java.util.HashMap;

import query.model.AbstractModelObject;

public class PremGBill02 extends AbstractModelObject {
	private String m_result_ind;     // �d�ߵ��G
	private String m_group_code;     // �Jú�s�� 
	private String m_address;        // �Jú�a�}
	private String m_zip_code;       // �l���ϸ�
	private String m_assigner;       // �����H�m�W
	private String m_tel_1;          // �Jú�q��
	private String m_company_name;   // ���q�W��-
	private String m_effect_date;    // �ͮĤ��
	private String m_process_date;   // �e���ק��
	private String m_process_name;   // �e���ק��
	private String m_group_rate;     // �O�O�馩�v	�ثe�L�� �ŭ�
	private String m_group_rate_desc;//�馩����
	private String m_old_desc;       //�¨��ƻP�馩
	private String m_new_desc;       //�s��H�ƻP�馩	
	
	public PremGBill02(){
	}
	public PremGBill02(HashMap<String, String> hsmp) {	
		m_result_ind = (hsmp.get("r_result_ind") == null) ? "" : hsmp.get("r_result_ind").trim();
		m_group_code = (hsmp.get("r_group_code") == null) ? "" : hsmp.get("r_group_code").trim();
		m_address = (hsmp.get("r_address") == null) ? "" : hsmp.get("r_address").trim();
		m_zip_code = (hsmp.get("r_zip_code") == null) ? "" : hsmp.get("r_zip_code").trim();
		m_assigner = (hsmp.get("r_assigner") == null) ? "" : hsmp.get("r_assigner").trim();
		m_tel_1 = (hsmp.get("r_tel_1") == null) ? "" : hsmp.get("r_tel_1").trim();
		m_company_name = (hsmp.get("r_company_name") == null) ? "" : hsmp.get("r_company_name").trim();
		m_effect_date = (hsmp.get("r_effect_date") == null) ? "" : hsmp.get("r_effect_date").trim();
		m_process_date = (hsmp.get("r_process_date") == null) ? "" : hsmp.get("r_process_date").trim();
		m_process_name= (hsmp.get("r_process_name") == null) ? "" : hsmp.get("r_process_name").trim();
		m_group_rate= (hsmp.get("r_group_rate") == null) ? "" : hsmp.get("r_group_rate").trim();
		m_group_rate_desc= (hsmp.get("r_group_rate_desc") == null) ? "" : hsmp.get("r_group_rate_desc").trim();
		m_old_desc= (hsmp.get("r_old_desc") == null) ? "" : hsmp.get("r_old_desc").trim();
		m_new_desc= (hsmp.get("r_new_desc") == null) ? "" : hsmp.get("r_new_desc").trim();
	}
	
	public void setAttributes(HashMap<String, String> hsmp) {	
		setM_result_ind ((hsmp.get("r_result_ind") == null) ? "" : hsmp.get("r_result_ind").trim());
		setM_group_code((hsmp.get("r_group_code") == null) ? "" : hsmp.get("r_group_code").trim());
		setM_address((hsmp.get("r_address") == null) ? "" : hsmp.get("r_address").trim());
		setM_zip_code ((hsmp.get("r_zip_code") == null) ? "" : hsmp.get("r_zip_code").trim());
		setM_assigner ((hsmp.get("r_assigner") == null) ? "" : hsmp.get("r_assigner").trim());
		setM_tel_1((hsmp.get("r_tel_1") == null) ? "" : hsmp.get("r_tel_1").trim());
		setM_company_name((hsmp.get("r_company_name") == null) ? "" : hsmp.get("r_company_name").trim());
		setM_effect_date ((hsmp.get("r_effect_date") == null) ? "" : hsmp.get("r_effect_date").trim());
		setM_process_date ((hsmp.get("r_process_date") == null) ? "" : hsmp.get("r_process_date").trim());
		setM_process_name((hsmp.get("r_process_name") == null) ? "" : hsmp.get("r_process_name").trim());
		setM_group_rate((hsmp.get("r_group_rate") == null) ? "" : hsmp.get("r_group_rate").trim());
		setM_group_rate_desc((hsmp.get("r_group_rate_desc") == null) ? "" : hsmp.get("r_group_rate_desc").trim());
		setM_old_desc((hsmp.get("r_old_desc") == null) ? "" : hsmp.get("r_old_desc").trim());
		setM_new_desc((hsmp.get("r_new_desc") == null) ? "" : hsmp.get("r_new_desc").trim());
	}
	public String[] getValues(int type) {
		ArrayList<String> valueList = new ArrayList<String>();

		switch (type) {
			case 1:
				valueList.add(m_group_code);     // �d�ߵ��G
				valueList.add(m_address);        // �Jú�a�}
				valueList.add(m_zip_code);       // �l���ϸ�
				valueList.add(m_assigner);       // �����H�m�W
				valueList.add(m_tel_1);			 // �Jú�q��
				valueList.add(m_company_name);   // ���q�W��
				break;
			
			case 2:
				valueList.add(m_effect_date);    // �ͮĤ��
				valueList.add(m_process_date);   // �e���ק��
				valueList.add(m_process_name);   // �e���ק��
				valueList.add(m_group_rate_desc);// ���ܻ���
				valueList.add(m_old_desc);       // �¨��ƻP�馩
				valueList.add(m_new_desc);       // �s��H�ƻP�馩
				break;
		}
		String[] valueArray = new String[valueList.size()];
		valueList.toArray(valueArray);
		return valueArray;
	}
	public String getM_result_ind() {
		return m_result_ind;
	}
	public void setM_result_ind(String m_result_ind) {
		this.m_result_ind = m_result_ind;
		
		if (this.m_result_ind.equals("0")==false)
			javax.swing.JOptionPane.showMessageDialog(null, "�d�߱��󦳻~cc000s:"+this.m_result_ind);
	}
	public String getM_group_code() {
		return m_group_code;
	}
	public void setM_group_code(String m_group_code) {
		this.m_group_code = m_group_code;
	}
	public String getM_address() {
		return m_address;
	}
	public void setM_address(String m_address) {
		this.m_address = m_address;
	}
	public String getM_zip_code() {
		return m_zip_code;
	}
	public void setM_zip_code(String m_zip_code) {
		this.m_zip_code = m_zip_code;
	}
	public String getM_assigner() {
		return m_assigner;
	}
	public void setM_assigner(String m_assigner) {
		this.m_assigner = m_assigner;
	}
	public String getM_tel_1() {
		return m_tel_1;
	}
	public void setM_tel_1(String m_tel_1) {
		this.m_tel_1 = m_tel_1;
	}
	public String getM_company_name() {
		return m_company_name;
	}
	public void setM_company_name(String m_company_name) {
		this.m_company_name = m_company_name;
	}
	public String getM_effect_date() {
		return m_effect_date;
	}
	public void setM_effect_date(String m_effect_date) {
		this.m_effect_date = m_effect_date;
	}
	public String getM_process_date() {
		return m_process_date;
	}
	public void setM_process_date(String m_process_date) {
		this.m_process_date = m_process_date;
	}
	public String getM_process_name() {
		return m_process_name;
	}
	public void setM_process_name(String m_process_name) {
		this.m_process_name = m_process_name;
	}
	public String getM_group_rate() {
		return m_group_rate;
	}
	public void setM_group_rate(String m_group_rate) {
		this.m_group_rate = m_group_rate;
	}
	public String getM_group_rate_desc() {
		return m_group_rate_desc;
	}
	public void setM_group_rate_desc(String m_group_rate_desc) {
		this.m_group_rate_desc = m_group_rate_desc;
	}
	public String getM_old_desc() {
		return m_old_desc;
	}
	public void setM_old_desc(String m_old_desc) {
		this.m_old_desc = m_old_desc;
	}
	public String getM_new_desc() {
		return m_new_desc;
	}
	public void setM_new_desc(String m_new_desc) {
		this.m_new_desc = m_new_desc;
	}

}
