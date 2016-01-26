package query.model.ValueReAssociate;

import java.util.HashMap;

import query.model.AbstractModelObject;
/**
 * @version 1.0
 * @author swei
 * 回流關聯查詢PoReAssociate_model
 * 
 */

public class ValueReAssociate01 extends AbstractModelObject {
	private String m_policy_no;      // 新件保單號碼
	private String m_plan_code;      // 新件險種
	private String m_O1_name;        // 新件要保人
	private String m_I1_name;        // 新件被保人	

	public ValueReAssociate01(HashMap<String, String> hsmp) {		
		m_policy_no = (hsmp.get("r_policy_no") == null) ? "" : hsmp.get("r_policy_no").trim();
		m_plan_code = (hsmp.get("r_plan_code") == null) ? "" : hsmp.get("r_plan_code").trim();
		m_O1_name = (hsmp.get("r_o1_name") == null) ? "" : hsmp.get("r_o1_name").trim();
		m_I1_name = (hsmp.get("r_i1_name") == null) ? "" : hsmp.get("r_i1_name").trim();
	}


	public String getM_policy_no() {
		return m_policy_no;
	}

	public void setM_policy_no(String m_policy_no) {
		this.m_policy_no = m_policy_no;
	}

	public String getM_plan_code() {
		return m_plan_code;
	}

	public void setM_plan_code(String m_plan_code) {
		this.m_plan_code = m_plan_code;
	}

	public String getM_O1_name() {
		return m_O1_name;
	}


	public void setM_O1_name(String m_O1_name) {
		this.m_O1_name = m_O1_name;
	}


	public String getM_I1_name() {
		return m_I1_name;
	}

	public void setM_I1_name(String m_I1_name) {
		this.m_I1_name = m_I1_name;
	}

}
