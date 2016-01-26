package query.model.PayQuery;

import java.util.HashMap;

import query.model.AbstractModelObject;

public class PayQuery04 extends AbstractModelObject {

	private String m_dbdi_desc;   //重開註記資料

	public PayQuery04(){
	}
	
	public PayQuery04(HashMap<String, String> hsmp) {		
		m_dbdi_desc = (hsmp.get("r_dbdi_desc") == null) ? "" : hsmp.get("r_dbdi_desc").trim();
	}

	public String getM_dbdi_desc() {
		return m_dbdi_desc;
	}

	public void setM_dbdi_desc(String m_dbdi_desc) {
		this.m_dbdi_desc = m_dbdi_desc;
	}
	
}
