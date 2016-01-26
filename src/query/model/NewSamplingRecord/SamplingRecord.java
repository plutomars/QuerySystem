package query.model.NewSamplingRecord;

import java.util.HashMap;

import query.model.AbstractModelObject;

/**
 * @ * @author YIHUA
 * 
 * @version 1.0<br>
 *          100/10/06<br>
 *          抽檢記錄查詢(JavaBean)
 * @since 1.0
 */

public class SamplingRecord extends AbstractModelObject { // **set的binding要用到**
	
	private String r_agent_code; // 業務員ID
	private String r_agent_name; // 業務員姓名
	private String r_immune; //是否豁免中

	public SamplingRecord(HashMap<String, String> hsmap) {
		r_agent_code = (hsmap.get("r_agent_code") == null) ? "" : hsmap.get(
				"r_agent_code").trim();
		r_agent_name = (hsmap.get("r_agent_name") == null) ? "" : hsmap.get(
					"r_agent_name").trim();
		r_immune = (hsmap.get("r_immune") == null) ? "" : hsmap.get(
					"r_immune").trim();
		
		System.out.println(r_agent_code);
		System.out.println(r_agent_name);
		System.out.println(r_immune);
	}
		
	public SamplingRecord(){
		
	}
			
	// 欄位值
	public String getR_agent_code() {
		return r_agent_code;
	}

	public void setR_agent_code(String r_agent_code) {
		String oldValue = this.r_agent_code;
		this.r_agent_code = r_agent_code;
		firePropertyChange("r_agent_code", oldValue, r_agent_code);
	}

	public String getR_agent_name() {
		return r_agent_name;
	}
	public void setR_agent_name(String r_agent_name) {
		String oldValue = this.r_agent_name;
		this.r_agent_name = r_agent_name;
		firePropertyChange("r_agent_name", oldValue, r_agent_name);
		
//		System.out.println(r_agent_name);
	}

	public String getR_immune() {
		return r_immune;
	}

	public void setR_immune(String r_immune) {
		String oldValue = this.r_immune;
		this.r_immune = r_immune;
		firePropertyChange("r_immune", oldValue, r_immune);
		
//		System.out.println(r_immune);
	}

	

}
