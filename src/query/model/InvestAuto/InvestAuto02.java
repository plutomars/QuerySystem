package query.model.InvestAuto;

import java.util.HashMap;
/**
 * 
 * @author 陳冠瑜
 * 
 */
public class InvestAuto02 {
	
	private String r_result_ind;
	private String r_invs_code;        //基金代碼
	private String r_drip_feed_amount; //自動轉換金額
	private String r_gain_rate;        //報酬率
	private String r_over_feed_desc;   //加碼機制
	private String r_over_multiple;    //加碼倍數
	private String r_plus_drip_feed;   //加碼後轉換金額

	public InvestAuto02(HashMap<String, String> hsmp) {
		r_result_ind = (hsmp.get("r_result_ind") == null) ? "" : hsmp.get(
				"r_result_ind").trim();
		r_invs_code = (hsmp.get("r_invs_code") == null) ? "" : hsmp.get(
				"r_invs_code").trim();
		r_drip_feed_amount = (hsmp.get("r_drip_feed_amount") == null) ? ""
				: hsmp.get("r_drip_feed_amount").trim();
		r_gain_rate = (hsmp.get("r_gain_rate") == null) ? "" : hsmp.get(
				"r_gain_rate").trim();
		r_over_feed_desc = (hsmp.get("r_over_feed_desc") == null) ? "" : hsmp
				.get("r_over_feed_desc").trim();
		r_over_multiple = (hsmp.get("r_over_multiple") == null) ? "" : hsmp
				.get("r_over_multiple").trim();
		r_plus_drip_feed = (hsmp.get("r_plus_drip_feed") == null) ? "" : hsmp
				.get("r_plus_drip_feed").trim();
	}

	public String getR_result_ind() {
		return r_result_ind;
	}

	public void setR_result_ind(String r_result_ind) {
		this.r_result_ind = r_result_ind;
	}

	public String getR_invs_code() {
		return r_invs_code;
	}

	public void setR_invs_code(String r_invs_code) {
		this.r_invs_code = r_invs_code;
	}

	public String getR_drip_feed_amount() {
		return r_drip_feed_amount;
	}

	public void setR_drip_feed_amount(String r_drip_feed_amount) {
		this.r_drip_feed_amount = r_drip_feed_amount;
	}

	public String getR_gain_rate() {
		return r_gain_rate;
	}

	public void setR_gain_rate(String r_gain_rate) {
		this.r_gain_rate = r_gain_rate;
	}

	public String getR_over_feed_desc() {
		return r_over_feed_desc;
	}

	public void setR_over_feed_desc(String r_over_feed_desc) {
		this.r_over_feed_desc = r_over_feed_desc;
	}

	public String getR_over_multiple() {
		return r_over_multiple;
	}

	public void setR_over_multiple(String r_over_multiple) {
		this.r_over_multiple = r_over_multiple;
	}

	public String getR_plus_drip_feed() {
		return r_plus_drip_feed;
	}

	public void setR_plus_drip_feed(String r_plus_drip_feed) {
		this.r_plus_drip_feed = r_plus_drip_feed;
	}

}
