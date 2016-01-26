/**
 * 
 */
package query.model.PosChange;

import java.util.HashMap;

/**
 * @author F1256819
 * @category 其它契變保單
 * 
 */
public class PosChange05 {
	private String r_policy_no;
	private String r_po_sts_code;

	/**
	 * 
	 */
	public PosChange05(HashMap<String,String> hsmp) {
		// TODO Auto-generated constructor stub
		r_policy_no = (hsmp.get("r_policy_no") == null) ? "" : hsmp.get(
				"r_policy_no").trim();
		r_po_sts_code = (hsmp.get("r_po_sts_code") == null) ? "" : hsmp.get(
				"r_po_sts_code").trim();
	}

	public String getR_policy_no() {
		return r_policy_no;
	}

	public void setR_policy_no(String r_policy_no) {
		this.r_policy_no = r_policy_no;
	}

	public String getR_po_sts_code() {
		return r_po_sts_code;
	}

	public void setR_po_sts_code(String r_po_sts_code) {
		this.r_po_sts_code = r_po_sts_code;
	}

}
