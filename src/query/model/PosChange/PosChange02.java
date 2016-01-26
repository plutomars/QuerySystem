package query.model.PosChange;

import java.util.HashMap;

public class PosChange02 {
	private String r_result_ind;
	private String r_po_chg_code;
	private String r_po_chg_desc;

	public PosChange02(HashMap<String, String> hsmp) {
		r_result_ind = (hsmp.get("r_result_ind") == null) ? "" : hsmp.get(
				"r_result_ind").trim();
		r_po_chg_code = (hsmp.get("r_po_chg_code") == null) ? "" : hsmp.get(
				"r_po_chg_code").trim();
		r_po_chg_desc = (hsmp.get("r_po_chg_desc") == null) ? "" : hsmp.get(
				"r_po_chg_desc").trim();
	}

	public String getR_result_ind() {
		return r_result_ind;
	}

	public void setR_result_ind(String r_result_ind) {
		this.r_result_ind = r_result_ind;
	}

	public String getR_po_chg_code() {
		return r_po_chg_code;
	}

	public void setR_po_chg_code(String r_po_chg_code) {
		this.r_po_chg_code = r_po_chg_code;
	}

	public String getR_po_chg_desc() {
		return r_po_chg_desc;
	}

	public void setR_po_chg_desc(String r_po_chg_desc) {
		this.r_po_chg_desc = r_po_chg_desc;
	}

}
