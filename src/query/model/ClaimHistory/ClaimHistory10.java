package query.model.ClaimHistory;

import java.util.HashMap;

/**
 * @ * @author FYYANG
 * 
 * @version 1.0<br>
 *          100/09/28<br>
 *          ²z½ßµù°O(JavaBean)
 * @since 1.0
 */
public class ClaimHistory10 {
	private String cl_comment_code;
	private String cl_comment_desc;

	public ClaimHistory10(HashMap<String, String> hsmp) {
		cl_comment_code = (hsmp.get("cl_comment_code") == null) ? "" : hsmp
				.get("cl_comment_code").trim();
		cl_comment_desc = (hsmp.get("cl_comment_desc") == null) ? "" : hsmp
				.get("cl_comment_desc").trim();
	}

	public String getCl_comment_code() {
		return cl_comment_code;
	}

	public void setCl_comment_code(String cl_comment_code) {
		this.cl_comment_code = cl_comment_code;
	}

	public String getCl_comment_desc() {
		return cl_comment_desc;
	}

	public void setCl_comment_desc(String cl_comment_desc) {
		this.cl_comment_desc = cl_comment_desc;
	}

}
