package query.model;

import java.util.HashMap;

public class Authority {

	private String user_group_code;
	private String program_id;
	private String user_authority;
	private String system_id;
	private String query_authority;

	public Authority(HashMap<String, String> hsmp) {
		program_id = (hsmp.get("program_id") == null) ? "" : hsmp.get(
				"program_id").trim();
		user_group_code = (hsmp.get("user_group_code") == null) ? "" : hsmp
				.get("user_group_code").trim();
		user_authority = (hsmp.get("user_authority") == null) ? "" : hsmp.get(
				"user_authority").trim();
		system_id = (hsmp.get("system_id") == null) ? "" : hsmp
				.get("system_id").trim();
		query_authority = (hsmp.get("query_authority") == null) ? "" : hsmp
				.get("query_authority").trim();

	}
	
	public String getQuery_authority() {
		return query_authority;
	}

	public void setQuery_authority(String query_authority) {
		this.query_authority = query_authority;
	}

	public String getUser_group_code() {
		return user_group_code;
	}

	public void setUser_group_code(String user_group_code) {
		this.user_group_code = user_group_code;
	}

	public String getProgram_id() {
		return program_id;
	}

	public void setProgram_id(String program_id) {
		this.program_id = program_id;
	}

	public String getUser_authority() {
		return user_authority;
	}

	public void setUser_authority(String user_authority) {
		this.user_authority = user_authority;
	}

	public String getSystem_id() {
		return system_id;
	}

	public void setSystem_id(String system_id) {
		this.system_id = system_id;
	}

}