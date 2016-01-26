package query.model.InvestHistory;

import java.util.HashMap;

/**
 * @ * @author epf
 * 
 * @version 1.0<br>
 *          100/10/20<br>
 *          投資交易記錄(JavaBean)
 * @since 1.0
 */
public class InvestHistory01 {
	private String r_result_ind;
	private String r_invs_ad_date;
	private String r_invs_tr_date;
	private String r_invs_ad_sts_desc;
	private String r_next_tr_date;
	private String r_invs_ivtr_amt;
	private String r_invs_ad_no;
	private String r_invs_ad_desc;
	private String r_invs_expense; 
	private String r_invs_ivtr_code;
	private String r_currency;
	private String r_check_info_join; //101.04.02  新增[交易資訊欄位]
	private String r_exsrc;           //101.04.02  新增[匯率來源欄位]
	private String r_exprc;           //101.04.02  新增[匯率盤別欄位]

	public InvestHistory01(HashMap<String, String> hsmp) {
		r_result_ind = (hsmp.get("r_result_ind") == null) ? "" : hsmp.get(
				"r_result_ind").trim();
		r_invs_ad_date = (hsmp.get("r_invs_ad_date") == null) ? "" : hsmp.get(
				"r_invs_ad_date").trim();
		r_invs_tr_date = (hsmp.get("r_invs_tr_date") == null) ? "" : hsmp.get(
				"r_invs_tr_date").trim();
		r_invs_ad_sts_desc = (hsmp.get("r_invs_ad_sts_desc") == null) ? ""
				: hsmp.get("r_invs_ad_sts_desc").trim();
		r_next_tr_date = (hsmp.get("r_next_tr_date") == null) ? "" : hsmp.get(
				"r_next_tr_date").trim();
		r_invs_ivtr_amt = (hsmp.get("r_invs_ivtr_amt") == null) ? "" : hsmp
				.get("r_invs_ivtr_amt").trim();
		r_invs_ad_no = (hsmp.get("r_invs_ad_no") == null) ? "" : hsmp.get(
				"r_invs_ad_no").trim();
		r_invs_ad_desc = (hsmp.get("r_invs_ad_desc") == null) ? "" : hsmp.get(
				"r_invs_ad_desc").trim();
		r_invs_expense = (hsmp.get("r_invs_expense") == null) ? "" : hsmp.get(
				"r_invs_expense").trim();
		r_invs_ivtr_code = (hsmp.get("r_invs_ivtr_code") == null) ? "" : hsmp
				.get("r_invs_ivtr_code").trim();
		r_currency = (hsmp.get("r_currency") == null) ? "" : hsmp.get(
				"r_currency").trim();
		r_check_info_join = (hsmp.get("r_check_info_join") == null) ? "" : hsmp.get(
				"r_check_info_join").trim();
		r_exsrc = (hsmp.get("r_exsrc") == null) ? "" : hsmp.get(
				"r_exsrc").trim();
		r_exprc = (hsmp.get("r_exprc") == null) ? "" : hsmp.get(
				"r_exprc").trim();

	}

	public String getR_exsrc() {
		return r_exsrc;
	}

	public void setR_exsrc(String r_exsrc) {
		this.r_exsrc = r_exsrc;
	}

	public String getR_exprc() {
		return r_exprc;
	}

	public void setR_exprc(String r_exprc) {
		this.r_exprc = r_exprc;
	}

	public String getR_check_info_join() {
		return r_check_info_join;
	}

	public void setR_check_info_join(String r_check_info_join) {
		this.r_check_info_join = r_check_info_join;
	}

	public String getR_result_ind() {
		return r_result_ind;
	}

	public void setR_result_ind(String r_result_ind) {
		this.r_result_ind = r_result_ind;
	}

	public String getR_invs_ad_date() {
		return r_invs_ad_date;
	}

	public void setR_invs_ad_date(String r_invs_ad_date) {
		this.r_invs_ad_date = r_invs_ad_date;
	}

	public String getR_invs_tr_date() {
		return r_invs_tr_date;
	}

	public void setR_invs_tr_date(String r_invs_tr_date) {
		this.r_invs_tr_date = r_invs_tr_date;
	}

	public String getR_invs_ad_sts_desc() {
		return r_invs_ad_sts_desc;
	}

	public void setR_invs_ad_sts_desc(String r_invs_ad_sts_desc) {
		this.r_invs_ad_sts_desc = r_invs_ad_sts_desc;
	}

	public String getR_next_tr_date() {
		return r_next_tr_date;
	}

	public void setR_next_tr_date(String r_next_tr_date) {
		this.r_next_tr_date = r_next_tr_date;
	}

	public String getR_invs_ivtr_amt() {
		return r_invs_ivtr_amt;
	}

	public void setR_invs_ivtr_amt(String r_invs_ivtr_amt) {
		this.r_invs_ivtr_amt = r_invs_ivtr_amt;
	}

	public String getR_invs_ad_no() {
		return r_invs_ad_no;
	}

	public void setR_invs_ad_no(String r_invs_ad_no) {
		this.r_invs_ad_no = r_invs_ad_no;
	}

	public String getR_invs_ad_desc() {
		return r_invs_ad_desc;
	}

	public void setR_invs_ad_desc(String r_invs_ad_desc) {
		this.r_invs_ad_desc = r_invs_ad_desc;
	}

	public String getR_invs_expense() {
		return r_invs_expense;
	}

	public void setR_invs_expense(String r_invs_expense) {
		this.r_invs_expense = r_invs_expense;
	}

	public String getR_invs_ivtr_code() {
		return r_invs_ivtr_code;
	}

	public void setR_invs_ivtr_code(String r_invs_ivtr_code) {
		this.r_invs_ivtr_code = r_invs_ivtr_code;
	}

	public String getR_currency() {
		return r_currency;
	}

	public void setR_currency(String r_currency) {
		this.r_currency = r_currency;
	}

}
