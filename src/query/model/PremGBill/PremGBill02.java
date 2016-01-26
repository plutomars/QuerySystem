package query.model.PremGBill;

/**
 * 
 * @author swei
 * @version 1.0
 * 集體彙繳查詢cc134i
 * 
 */

import java.util.ArrayList;
import java.util.HashMap;

import query.model.AbstractModelObject;

public class PremGBill02 extends AbstractModelObject {
	private String m_result_ind;     // 查詢結果
	private String m_group_code;     // 彙繳編號 
	private String m_address;        // 彙繳地址
	private String m_zip_code;       // 郵遞區號
	private String m_assigner;       // 受任人姓名
	private String m_tel_1;          // 彙繳電話
	private String m_company_name;   // 公司名稱-
	private String m_effect_date;    // 生效日期
	private String m_process_date;   // 前次修改日
	private String m_process_name;   // 前次修改者
	private String m_group_rate;     // 保費折扣率	目前無用 空值
	private String m_group_rate_desc;//折扣說明
	private String m_old_desc;       //舊制件數與折扣
	private String m_new_desc;       //新制人數與折扣	
	
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
				valueList.add(m_group_code);     // 查詢結果
				valueList.add(m_address);        // 彙繳地址
				valueList.add(m_zip_code);       // 郵遞區號
				valueList.add(m_assigner);       // 受任人姓名
				valueList.add(m_tel_1);			 // 彙繳電話
				valueList.add(m_company_name);   // 公司名稱
				break;
			
			case 2:
				valueList.add(m_effect_date);    // 生效日期
				valueList.add(m_process_date);   // 前次修改日
				valueList.add(m_process_name);   // 前次修改者
				valueList.add(m_group_rate_desc);// 指示說明
				valueList.add(m_old_desc);       // 舊制件數與折扣
				valueList.add(m_new_desc);       // 新制人數與折扣
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
			javax.swing.JOptionPane.showMessageDialog(null, "查詢條件有誤cc000s:"+this.m_result_ind);
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
