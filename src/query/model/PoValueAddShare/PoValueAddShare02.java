/**
 * 
 */
package query.model.PoValueAddShare;

import java.util.HashMap;

/**
 * @author F1256819
 * @category 增值回饋分享金第二區資料
 */
public class PoValueAddShare02 {

	private String r_int_date;// 計息日
	private String r_this_calc_amt;// 計算利息本金
	private String r_this_int;// 利息
	private String r_amount; // 交易金額
	private String r_accu_refund;// 累計回饋分享金
	private String r_tran_item;// 交易項目
	private String r_process_date;// 作業日期
	private String r_accu_return_amt;// 回饋抵繳

	/**
	 * 
	 */
	public PoValueAddShare02(HashMap<String, String> hsmp) {
		r_int_date = (hsmp.get("r_int_date") == null) ? "" : hsmp.get(
				"r_int_date").trim();
		r_this_calc_amt = (hsmp.get("r_this_calc_amt") == null) ? "" : hsmp
				.get("r_this_calc_amt").trim();
		r_this_int = (hsmp.get("r_this_int") == null) ? "" : hsmp.get(
				"r_this_int").trim();
		r_amount = (hsmp.get("r_amount") == null) ? "" : hsmp.get("r_amount")
				.trim();
		r_accu_refund = (hsmp.get("r_accu_refund") == null) ? "" : hsmp.get(
				"r_accu_refund").trim();
		r_tran_item = (hsmp.get("r_tran_item") == null) ? "" : hsmp.get(
				"r_tran_item").trim();
		r_process_date = (hsmp.get("r_process_date") == null) ? "" : hsmp.get(
				"r_process_date").trim();
		r_accu_return_amt = (hsmp.get("r_accu_return_amt") == null) ? "" : hsmp
				.get("r_accu_return_amt").trim();

	}

	public String getR_int_date() {
		return r_int_date;
	}

	public void setR_int_date(String r_int_date) {
		this.r_int_date = r_int_date;
	}

	public String getR_this_calc_amt() {
		return r_this_calc_amt;
	}

	public void setR_this_calc_amt(String r_this_calc_amt) {
		this.r_this_calc_amt = r_this_calc_amt;
	}

	public String getR_this_int() {
		return r_this_int;
	}

	public void setR_this_int(String r_this_int) {
		this.r_this_int = r_this_int;
	}

	public String getR_amount() {
		return r_amount;
	}

	public void setR_amount(String r_amount) {
		this.r_amount = r_amount;
	}

	public String getR_accu_refund() {
		return r_accu_refund;
	}

	public void setR_accu_refund(String r_accu_refund) {
		this.r_accu_refund = r_accu_refund;
	}

	public String getR_tran_item() {
		return r_tran_item;
	}

	public void setR_tran_item(String r_tran_item) {
		this.r_tran_item = r_tran_item;
	}

	public String getR_process_date() {
		return r_process_date;
	}

	public void setR_process_date(String r_process_date) {
		this.r_process_date = r_process_date;
	}

	public String getR_accu_return_amt() {
		return r_accu_return_amt;
	}

	public void setR_accu_return_amt(String r_accu_return_amt) {
		this.r_accu_return_amt = r_accu_return_amt;
	}

}
