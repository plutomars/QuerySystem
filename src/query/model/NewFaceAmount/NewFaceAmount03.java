package query.model.NewFaceAmount;

import java.util.HashMap;
/**
 * 
 * @author 陳冠瑜
 * 
 */
public class NewFaceAmount03 {
	private String r_occupation; // 職業說明

	public NewFaceAmount03() {
	}

	// public NewFaceAmount02(HashMap<String, String> hsmp) {
	public void setValues(HashMap<String, String> hsmp) {
		r_occupation = (hsmp.get("r_occupation") == null) ? "" : hsmp.get(
				"r_occupation").trim();
	}

	public String getR_occupation() {
		return r_occupation;
	}

	public void setR_occupation(String r_occupation) {
		this.r_occupation = r_occupation;
	}

}
