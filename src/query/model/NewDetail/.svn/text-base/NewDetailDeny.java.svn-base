package query.model.NewDetail;

import java.util.HashMap;

/**
 * 新契約明細基本資料 未承保原因
 * 
 * @author cora
 * 
 * @version 1.0
 * 
 * @since 1.0
 */
public class NewDetailDeny {
	private String nbdl_reason;
	private String nbdl_reason_c;
	private String nbdl_cc_reason;
	private String nbdl_cc_reason_c;
	
	public NewDetailDeny(HashMap<String, String> hsmp) {
		nbdl_reason = (hsmp.get("r_nbdl_reason") == null) ? "" : hsmp.get("r_nbdl_reason").trim();
		nbdl_reason_c = (hsmp.get("r_nbdl_reason_c") == null) ? "" : hsmp.get("r_nbdl_reason_c").trim();
		nbdl_cc_reason = (hsmp.get("r_nbdl_cc_reason") == null) ? "" : hsmp.get("r_nbdl_cc_reason").trim();
		nbdl_cc_reason_c = (hsmp.get("r_nbdl_cc_reason_c") == null) ? "" : hsmp.get("r_nbdl_cc_reason_c").trim();
	}
	
	public String getNbdl_reason() {
		return nbdl_reason;
	}

	public void setNbdl_reason(String nbdl_reason) {
		this.nbdl_reason = nbdl_reason;
	}

	public String getNbdl_reason_c() {
		return nbdl_reason_c;
	}

	public void setNbdl_reason_c(String nbdl_reason_c) {
		this.nbdl_reason_c = nbdl_reason_c;
	}

	public String getNbdl_cc_reason() {
		return nbdl_cc_reason;
	}

	public void setNbdl_cc_reason(String nbdl_cc_reason) {
		this.nbdl_cc_reason = nbdl_cc_reason;
	}

	public String getNbdl_cc_reason_c() {
		return nbdl_cc_reason_c;
	}

	public void setNbdl_cc_reason_c(String nbdl_cc_reason_c) {
		this.nbdl_cc_reason_c = nbdl_cc_reason_c;
	}

}
