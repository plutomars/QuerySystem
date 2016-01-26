package query.model.ValueRepay;

import java.util.HashMap;

public class ValueRepay08 {
	private String r_result_ind;
	private String r_cp_remark_desc_1;
	private String r_cp_remark_desc_2;
	private String r_cp_remark_desc_3;
	private String r_cp_remark_desc_4;
	private String r_cp_remark_desc_5;

	public ValueRepay08(HashMap<String, String> hsmp) {
		r_result_ind = (hsmp.get("r_result_ind") == null) ? "" : hsmp.get(
				"r_result_ind").trim();
		r_cp_remark_desc_1 = (hsmp.get("r_cp_remark_desc_1") == null) ? ""
				: hsmp.get("r_cp_remark_desc_1").trim();
		r_cp_remark_desc_2 = (hsmp.get("r_cp_remark_desc_2") == null) ? ""
				: hsmp.get("r_cp_remark_desc_2").trim();
		r_cp_remark_desc_3 = (hsmp.get("r_cp_remark_desc_3") == null) ? ""
				: hsmp.get("r_cp_remark_desc_3").trim();
		r_cp_remark_desc_4 = (hsmp.get("r_cp_remark_desc_4") == null) ? ""
				: hsmp.get("r_cp_remark_desc_4").trim();
		r_cp_remark_desc_5 = (hsmp.get("r_cp_remark_desc_5") == null) ? ""
				: hsmp.get("r_cp_remark_desc_5").trim();
	}

	public String[] getColumn() {
		return new String[] { r_cp_remark_desc_1, r_cp_remark_desc_2,
				r_cp_remark_desc_3, r_cp_remark_desc_4, r_cp_remark_desc_5 };
	}

	public String getR_result_ind() {
		return r_result_ind;
	}

	public void setR_result_ind(String r_result_ind) {
		this.r_result_ind = r_result_ind;
	}

	public String getR_cp_remark_desc_1() {
		return r_cp_remark_desc_1;
	}

	public void setR_cp_remark_desc_1(String r_cp_remark_desc_1) {
		this.r_cp_remark_desc_1 = r_cp_remark_desc_1;
	}

	public String getR_cp_remark_desc_2() {
		return r_cp_remark_desc_2;
	}

	public void setR_cp_remark_desc_2(String r_cp_remark_desc_2) {
		this.r_cp_remark_desc_2 = r_cp_remark_desc_2;
	}

	public String getR_cp_remark_desc_3() {
		return r_cp_remark_desc_3;
	}

	public void setR_cp_remark_desc_3(String r_cp_remark_desc_3) {
		this.r_cp_remark_desc_3 = r_cp_remark_desc_3;
	}

	public String getR_cp_remark_desc_4() {
		return r_cp_remark_desc_4;
	}

	public void setR_cp_remark_desc_4(String r_cp_remark_desc_4) {
		this.r_cp_remark_desc_4 = r_cp_remark_desc_4;
	}

	public String getR_cp_remark_desc_5() {
		return r_cp_remark_desc_5;
	}

	public void setR_cp_remark_desc_5(String r_cp_remark_desc_5) {
		this.r_cp_remark_desc_5 = r_cp_remark_desc_5;
	}

}
