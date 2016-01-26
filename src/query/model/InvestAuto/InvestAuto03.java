package query.model.InvestAuto;

import java.util.HashMap;
/**
 * 
 * @author 陳冠瑜
 * 
 */
public class InvestAuto03 {
	private String r_result_ind;     //查詢結果
	private String r_invs_title;     //基金代碼中文
	private String r_effect_date;    //批次作業日
	private String r_invs_code;      //基金代碼
	private String r_gain_lock_rate; //預定停利率
	private String r_gain_rate;      //報酬率
	private String r_invs_cost_amt;  //持有成本
	private String r_invs_amt;       //基金子價值

	public InvestAuto03(HashMap<String, String> hsmp) {
		r_result_ind = (hsmp.get("r_result_ind") == null) ? "" : hsmp.get(
				"r_result_ind").trim();
		r_invs_title = (hsmp.get("r_invs_title") == null) ? "" : hsmp.get(
				"r_invs_title").trim();
		r_effect_date = (hsmp.get("r_effect_date") == null) ? "" : hsmp.get(
				"r_effect_date").trim();
		r_invs_code = (hsmp.get("r_invs_code") == null) ? "" : hsmp.get(
				"r_invs_code").trim();
		r_gain_lock_rate = (hsmp.get("r_gain_lock_rate") == null) ? "" : hsmp
				.get("r_gain_lock_rate").trim();
		r_gain_rate = (hsmp.get("r_gain_rate") == null) ? "" : hsmp.get(
				"r_gain_rate").trim();
		r_invs_cost_amt = (hsmp.get("r_invs_cost_amt") == null) ? "" : hsmp
				.get("r_invs_cost_amt").trim();
		r_invs_amt = (hsmp.get("r_invs_amt") == null) ? "" : hsmp.get(
				"r_invs_amt").trim();
	}

	public String getR_result_ind() {
		return r_result_ind;
	}

	public void setR_result_ind(String r_result_ind) {
		this.r_result_ind = r_result_ind;
	}

	public String getR_invs_title() {
		return r_invs_title;
	}

	public void setR_invs_title(String r_invs_title) {
		this.r_invs_title = r_invs_title;
	}

	public String getR_effect_date() {
		return r_effect_date;
	}

	public void setR_effect_date(String r_effect_date) {
		this.r_effect_date = r_effect_date;
	}

	public String getR_invs_code() {
		return r_invs_code;
	}

	public void setR_invs_code(String r_invs_code) {
		this.r_invs_code = r_invs_code;
	}

	public String getR_gain_lock_rate() {
		return r_gain_lock_rate;
	}

	public void setR_gain_lock_rate(String r_gain_lock_rate) {
		this.r_gain_lock_rate = r_gain_lock_rate;
	}

	public String getR_gain_rate() {
		return r_gain_rate;
	}

	public void setR_gain_rate(String r_gain_rate) {
		this.r_gain_rate = r_gain_rate;
	}

	public String getR_invs_cost_amt() {
		return r_invs_cost_amt;
	}

	public void setR_invs_cost_amt(String r_invs_cost_amt) {
		this.r_invs_cost_amt = r_invs_cost_amt;
	}

	public String getR_invs_amt() {
		return r_invs_amt;
	}

	public void setR_invs_amt(String r_invs_amt) {
		this.r_invs_amt = r_invs_amt;
	}

}
