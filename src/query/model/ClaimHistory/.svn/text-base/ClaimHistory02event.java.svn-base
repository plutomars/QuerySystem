package query.model.ClaimHistory;

import java.util.HashMap;

public class ClaimHistory02event {
	private String cl_event_code;
	private String cl_event_desc;
	private String cl_code_type;
	
	public ClaimHistory02event(HashMap<String, String> hsmp) {
		cl_code_type = (hsmp.get("r_cl_code_type") == null) ? "" : hsmp
				.get("r_cl_code_type").trim();
		cl_event_code = (hsmp.get("r_cl_event_code") == null) ? "" : hsmp
				.get("r_cl_event_code").trim();
		cl_event_desc = (hsmp.get("r_cl_event_desc") == null) ? "" : hsmp
				.get("r_cl_event_desc").trim();
	}
	
	public String getcl_code_type() {
		return cl_code_type;
	}

	public void setcl_code_type(String cl_code_type) {
		this.cl_code_type = cl_code_type;
	}
	
	public String getcl_event_code() {
		return cl_event_code;
	}

	public void setcl_event_code(String cl_event_code) {
		this.cl_event_code = cl_event_code;
	}
	
	public String getcl_event_desc() {
		return cl_event_desc;
	}

	public void setcl_event_desc(String cl_event_desc) {
		this.cl_event_desc = cl_event_desc;
	}
}
