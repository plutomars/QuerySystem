package query.model.NewDetail;

import java.util.HashMap;

/**
 * 新契約明細契變受理部份(JavaBean)
 * 
 * @author epf
 * 
 * @version 1.0<br>
 *          100/07/28<br>
 * 
 * @since 1.0
 */
public class NewDetailPosChange {
	private String receive_no;
	private String receive_date;
	private String po_chg_sts_code;
	private String policy_no;

	public NewDetailPosChange(HashMap<String, String> hsmp) {
		receive_no = (hsmp.get("receive_no") == null) ? "" : hsmp.get(
				"receive_no").trim();
		receive_date = (hsmp.get("receive_date") == null) ? "" : hsmp.get(
				"receive_date").trim();
		po_chg_sts_code = (hsmp.get("po_chg_sts_code") == null) ? "" : hsmp
				.get("po_chg_sts_code").trim();
		policy_no = (hsmp.get("policy_no") == null) ? "" : hsmp
				.get("policy_no").trim();
	}

	public String getReceive_no() {
		return receive_no;
	}

	public void setReceive_no(String receive_no) {
		this.receive_no = receive_no;
	}

	public String getReceive_date() {
		return receive_date;
	}

	public void setReceive_date(String receive_date) {
		this.receive_date = receive_date;
	}

	public String getPo_chg_sts_code() {
		return po_chg_sts_code;
	}

	public void setPo_chg_sts_code(String po_chg_sts_code) {
		this.po_chg_sts_code = po_chg_sts_code;
	}
	
	public String getPolicy_no() {
		return policy_no;
	}

	public void setPolicy_no(String policy_no) {
		this.policy_no = policy_no;
	}
}
