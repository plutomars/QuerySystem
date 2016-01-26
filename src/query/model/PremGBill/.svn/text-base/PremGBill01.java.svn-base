package query.model.PremGBill;

/**
 * 
 * @author swei
 * @version 1.0
 * 集體彙繳查詢cc133i
 * 
 */
import java.util.HashMap;
import query.model.AbstractModelObject;

public class PremGBill01 extends AbstractModelObject {
	private String m_result_ind;
	private String m_group_code;   // 彙繳編號 
	private String m_assigner;     // 受任人姓名
	private String m_company_name; // 公司名稱
	
	public PremGBill01(){
	}
	
	public PremGBill01(HashMap<String, String> hsmp) {		
		m_result_ind = (hsmp.get("r_result_ind") == null) ? "" : hsmp.get("r_result_ind").trim();
		m_group_code = (hsmp.get("r_group_code") == null) ? "" : hsmp.get("r_group_code").trim();
		m_assigner = (hsmp.get("r_assigner") == null) ? "" : hsmp.get("r_assigner").trim();
		m_company_name = (hsmp.get("r_company_name") == null) ? "" : hsmp.get("r_company_name").trim();
	}

	public String getM_result_ind() {
		return m_result_ind;
	}

	public void setM_result_ind(String m_result_ind) {	
		this.m_result_ind = m_result_ind;
		
		if (this.m_result_ind.equals("0")==false)
			javax.swing.JOptionPane.showMessageDialog(null, "查詢條件有誤:"+this.m_result_ind);
	}

	public String getM_group_code() {
		return m_group_code;
	}

	public void setM_group_code(String m_group_code) {
		this.m_group_code = m_group_code;
	}

	public String getM_assigner() {
		return m_assigner;
	}

	public void setM_assigner(String m_assigner) {
		this.m_assigner = m_assigner;
	}

	public String getM_company_name() {
		return m_company_name;
	}

	public void setM_company_name(String m_company_name) {
		this.m_company_name = m_company_name;
	}

	
}
