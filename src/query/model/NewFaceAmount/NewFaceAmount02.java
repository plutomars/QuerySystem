package query.model.NewFaceAmount;

import java.util.HashMap;
/**
 * 
 * @author 陳冠瑜
 * 
 */
public class NewFaceAmount02 {
	private String r_today;      // 系統日
	private String r_birth_date; // 生日
	private String r_occu_code;  // 職業代碼

	public NewFaceAmount02() {
	}

	// public NewFaceAmount02(HashMap<String, String> hsmp) {
	public void setValues(HashMap<String, String> hsmp) {
		r_today = (hsmp.get("r_today") == null) ? "" : hsmp.get("r_today")
				.trim();
		r_birth_date = (hsmp.get("r_birth_date") == null) ? "" : hsmp.get(
				"r_birth_date").trim();
		r_occu_code = (hsmp.get("r_occu_code") == null) ? "" : hsmp.get(
				"r_occu_code").trim();
	}

	public String getR_today() {
		return r_today;
	}

	public void setR_today(String r_today) {
		this.r_today = r_today;
	}

	public String getR_birth_date() {
		return r_birth_date;
	}

	public void setR_birth_date(String r_birth_date) {
		this.r_birth_date = r_birth_date;
	}

	public String getR_occu_code() {
		return r_occu_code;
	}

	public void setR_occu_code(String r_occu_code) {
		this.r_occu_code = r_occu_code;
	}

}
