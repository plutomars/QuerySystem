package query.model.ValueReAssociate;

import java.util.HashMap;

import query.model.AbstractModelObject;
/**
 * @version 1.0
 * @author swei
 * 回流關聯查詢PoReAssociate_model
 * 
 */
public class ValueReAssociate02 extends AbstractModelObject {

	private String m_join_policy;     // 舊件保單號碼
	private String m_benf_name;       // 受益人姓名
	private String m_cp_anniv_date;   // 還本週年日
	private String m_cp_real_payamt;  // 實付金額
	
	public ValueReAssociate02(HashMap<String, String> hsmp) {		
		m_join_policy = (hsmp.get("r_join_policy") == null) ? "" : hsmp.get("r_join_policy").trim();
		m_benf_name = (hsmp.get("r_benf_name") == null) ? "" : hsmp.get("r_benf_name").trim();
		m_cp_anniv_date = (hsmp.get("r_cp_anniv_date") == null) ? "" : hsmp.get("r_cp_anniv_date").trim();
		m_cp_real_payamt = (hsmp.get("r_cp_real_payamt") == null) ? "" : hsmp.get("r_cp_real_payamt").trim();
	}	
	
	public String getM_join_policy() {
		return m_join_policy;
	}

	public void setM_join_policy(String m_join_policy) {
		this.m_join_policy = m_join_policy;
	}

	public String getM_benf_name() {
		return m_benf_name;
	}

	public void setM_benf_name(String m_benf_name) {
		this.m_benf_name = m_benf_name;
	}

	public String getM_cp_anniv_date() {
		return m_cp_anniv_date;
	}

	public void setM_cp_anniv_date(String m_cp_anniv_date) {
		this.m_cp_anniv_date = m_cp_anniv_date;
	}

	public String getM_cp_real_payamt() {
		return m_cp_real_payamt;
	}

	public void setM_cp_real_payamt(String m_cp_real_payamt) {
		this.m_cp_real_payamt = m_cp_real_payamt;
	}

	
}
