/**
 * 
 */
package query.model.PoValueAddShare;

import java.util.HashMap;

/**
 * @author F1256819
 * @category 增值回饋分享金第三區資料
 */
public class PoValueAddShare03 {
	private String r_result_ind;
	private String r_int_ym;// 年月
	private String r_int_rate_decl;// 宣告利率

	/**
	 * 
	 */
	public PoValueAddShare03() {

	}

	public PoValueAddShare03(HashMap<String, String> hsmp) {
		r_result_ind = (hsmp.get("r_result_ind") == null) ? "" : hsmp.get(
				"r_result_ind").trim();
		r_int_ym = (hsmp.get("r_int_ym") == null) ? "" : hsmp.get("r_int_ym")
				.trim();
		r_int_rate_decl = (hsmp.get("r_int_rate_decl") == null) ? "" : hsmp
				.get("r_int_rate_decl").trim();
	}

	public String getR_result_ind() {
		return r_result_ind;
	}

	public void setR_result_ind(String r_result_ind) {
		this.r_result_ind = r_result_ind;
	}

	public String getR_int_ym() {
		return r_int_ym;
	}

	public void setR_int_ym(String r_int_ym) {
		this.r_int_ym = r_int_ym;
	}

	public String getR_int_rate_decl() {
		return r_int_rate_decl;
	}

	public void setR_int_rate_decl(String r_int_rate_decl) {
		this.r_int_rate_decl = r_int_rate_decl;
	}

	

}
