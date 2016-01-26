package query.model.PoDetail;

import java.util.HashMap;

/**
 * 保單明細 cc004i與cc004i_va共用
 * 
 * @author cora 100/08
 */
public class PoDetailIList {
	private String result_ind;
	private String policy_no;
	private String invs_no; // 序號
	private String invs_code; // 標的代碼
	private String invs_title; // 投資標的名稱
	private String invs_alloc_perc; // 比例
	private String currency_desc; // 計價貨幣
	private String invs_class_desc; // 類型 --cc004i_va專有
	private String gain_lock_in_rate;// 停利點 cc004i_va專有
	private String drip_feed_amount; // 自動轉換金額 cc004i_va專有
	private String over_feed_type; // 0不加碼；1加強型；cc004i_va專有
	private String invs_sts_code; // 狀況 --cc004i_va專有
	private String iv_shutting_date; // 停售日期 --cc004i_va專有

	private String gain_lock_join_invs_code; // 停利指定標的
	private String gain_lock_join_invs_title; // 停利指定基金標的名稱
	private String coi_seq;// 扣除額順序
	private String profit_alloc_join_invs_code;// 收益分配指定標的
	private String profit_alloc_join_invs_title;// 收益分配指定標的名稱

	public PoDetailIList(HashMap<String, String> hsmp) {
		result_ind = (hsmp.get("r_result_ind") == null) ? "" : hsmp.get(
				"r_result_ind").trim();
		policy_no = (hsmp.get("r_policy_no") == null) ? "" : hsmp.get(
				"r_policy_no").trim();
		invs_no = (hsmp.get("r_invs_no") == null) ? "" : hsmp.get("r_invs_no")
				.trim();
		invs_code = (hsmp.get("r_invs_code") == null) ? "" : hsmp.get(
				"r_invs_code").trim();
		invs_title = (hsmp.get("r_invs_title") == null) ? "" : hsmp.get(
				"r_invs_title").trim();
		invs_alloc_perc = (hsmp.get("r_invs_alloc_perc") == null) ? "" : hsmp
				.get("r_invs_alloc_perc").trim();
		currency_desc = (hsmp.get("r_currency_desc") == null) ? "" : hsmp.get(
				"r_currency_desc").trim();
		invs_class_desc = (hsmp.get("r_invs_class_desc") == null) ? "" : hsmp
				.get("r_invs_class_desc").trim();
		gain_lock_in_rate = (hsmp.get("r_gain_lock_in_rate") == null) ? ""
				: hsmp.get("r_gain_lock_in_rate").trim();
		drip_feed_amount = (hsmp.get("r_drip_feed_amount") == null) ? "" : hsmp
				.get("r_drip_feed_amount").trim();
		over_feed_type = (hsmp.get("r_over_feed_type") == null) ? "" : hsmp
				.get("r_over_feed_type").trim();
		invs_sts_code = (hsmp.get("r_invs_sts_code") == null) ? "" : hsmp.get(
				"r_invs_sts_code").trim();
		iv_shutting_date = (hsmp.get("r_iv_shutting_date") == null) ? "" : hsmp
				.get("r_iv_shutting_date").trim();

		gain_lock_join_invs_code = (hsmp.get("r_gain_lock_join_invs_code") == null) ? ""
				: hsmp.get("r_gain_lock_join_invs_code").trim();
		gain_lock_join_invs_title = (hsmp.get("r_gain_lock_join_invs_title") == null) ? ""
				: hsmp.get("r_gain_lock_join_invs_title").trim();
		coi_seq = (hsmp.get("r_coi_seq") == null) ? "" : hsmp.get("r_coi_seq")
				.trim();
		profit_alloc_join_invs_code = (hsmp
				.get("r_profit_alloc_join_invs_code") == null) ? "" : hsmp.get(
				"r_profit_alloc_join_invs_code").trim();
		profit_alloc_join_invs_title = (hsmp
				.get("r_profit_alloc_join_invs_title") == null) ? "" : hsmp
				.get("r_profit_alloc_join_invs_title").trim();
	}

	public String getResult_ind() {
		return result_ind;
	}

	public void setResult_ind(String result_ind) {
		this.result_ind = result_ind;
	}

	public String getpolicy_no() {
		return policy_no;
	}

	public void setpolicy_no(String policy_no) {
		this.policy_no = policy_no;
	}

	public String getinvs_no() {
		return invs_no;
	}

	public void setinvs_no(String invs_no) {
		this.invs_no = invs_no;
	}

	public String getinvs_code() {
		return invs_code;
	}

	public void setinvs_code(String invs_code) {
		this.invs_code = invs_code;
	}

	public String getinvs_title() {
		return invs_title;
	}

	public void setinvs_title(String invs_title) {
		this.invs_title = invs_title;
	}

	public String getinvs_alloc_perc() {
		return invs_alloc_perc;
	}

	public void setinvs_alloc_perc(String invs_alloc_perc) {
		this.invs_alloc_perc = invs_alloc_perc;
	}

	public String getcurrency_desc() {
		return currency_desc;
	}

	public void setcurrency_desc(String currency_desc) {
		this.currency_desc = currency_desc;
	}

	public String getinvs_class_desc() {
		return invs_class_desc;
	}

	public void setinvs_class_desc(String invs_class_desc) {
		this.invs_class_desc = invs_class_desc;
	}

	public String getgain_lock_in_rate() {
		return gain_lock_in_rate;
	}

	public void setgain_lock_in_rate(String gain_lock_in_rate) {
		this.gain_lock_in_rate = gain_lock_in_rate;
	}

	public String getdrip_feed_amount() {
		return drip_feed_amount;
	}

	public void setdrip_feed_amount(String drip_feed_amount) {
		this.drip_feed_amount = drip_feed_amount;
	}

	public String getover_feed_type() {
		return over_feed_type;
	}

	public void setover_feed_type(String over_feed_type) {
		this.over_feed_type = over_feed_type;
	}

	public String getinvs_sts_code() {
		return invs_sts_code;
	}

	public void setinvs_sts_code(String invs_sts_code) {
		this.invs_sts_code = invs_sts_code;
	}

	public String getiv_shutting_date() {
		return iv_shutting_date;
	}

	public void setiv_shutting_date(String iv_shutting_date) {
		this.iv_shutting_date = iv_shutting_date;
	}

	public String getGain_lock_join_invs_code() {
		return gain_lock_join_invs_code;
	}

	public void setGain_lock_join_invs_code(String gain_lock_join_invs_code) {
		this.gain_lock_join_invs_code = gain_lock_join_invs_code;
	}

	public String getGain_lock_join_invs_title() {
		return gain_lock_join_invs_title;
	}

	public void setGain_lock_join_invs_title(String gain_lock_join_invs_title) {
		this.gain_lock_join_invs_title = gain_lock_join_invs_title;
	}

	public String getCoi_seq() {
		return coi_seq;
	}

	public void setCoi_seq(String coi_seq) {
		this.coi_seq = coi_seq;
	}

	public String getProfit_alloc_join_invs_code() {
		return profit_alloc_join_invs_code;
	}

	public void setProfit_alloc_join_invs_code(
			String profit_alloc_join_invs_code) {
		this.profit_alloc_join_invs_code = profit_alloc_join_invs_code;
	}

	public String getProfit_alloc_join_invs_title() {
		return profit_alloc_join_invs_title;
	}

	public void setProfit_alloc_join_invs_title(
			String profit_alloc_join_invs_title) {
		this.profit_alloc_join_invs_title = profit_alloc_join_invs_title;
	}
}
