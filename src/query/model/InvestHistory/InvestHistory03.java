/**
 * 
 */
package query.model.InvestHistory;

import java.util.HashMap;

/**
 * @author F1256819
 * @category 首期投入前利息
 */
public class InvestHistory03 {
	private String r_result_ind;
	private String r_policy_no;
	private String r_int_str_date;
	private String r_int_end_date;
	private String r_invs_ivtr_amt;
	private String r_this_int;
	private String r_entry_no;
	private String r_invs_code;
	private String r_tran_date;

	/**
	 * 
	 */
	public InvestHistory03(HashMap<String, String> hsmp) {
		// TODO Auto-generated constructor stub
		r_result_ind = (hsmp.get("r_result_ind") == null) ? "" : hsmp.get(
				"r_result_ind").trim();
		r_policy_no = (hsmp.get("r_policy_no") == null) ? "" : hsmp.get(
				"r_policy_no").trim();
		r_int_str_date = (hsmp.get("r_int_str_date") == null) ? "" : hsmp.get(
				"r_int_str_date").trim();
		r_int_end_date = (hsmp.get("r_int_end_date") == null) ? "" : hsmp.get(
				"r_int_end_date").trim();
		r_invs_ivtr_amt = (hsmp.get("r_invs_ivtr_amt") == null) ? "" : hsmp
				.get("r_invs_ivtr_amt").trim();
		r_this_int = (hsmp.get("r_this_int") == null) ? "" : hsmp.get(
				"r_this_int").trim();
		r_entry_no = (hsmp.get("r_entry_no") == null) ? "" : hsmp.get(
				"r_entry_no").trim();
		r_invs_code = (hsmp.get("r_invs_code") == null) ? "" : hsmp.get(
				"r_invs_code").trim();
		r_tran_date = (hsmp.get("r_tran_date") == null) ? "" : hsmp.get(
				"r_tran_date").trim();
	}

	public String getR_result_ind() {
		return r_result_ind;
	}

	public void setR_result_ind(String r_result_ind) {
		this.r_result_ind = r_result_ind;
	}

	public String getR_policy_no() {
		return r_policy_no;
	}

	public void setR_policy_no(String r_policy_no) {
		this.r_policy_no = r_policy_no;
	}

	public String getR_int_str_date() {
		return r_int_str_date;
	}

	public void setR_int_str_date(String r_int_str_date) {
		this.r_int_str_date = r_int_str_date;
	}

	public String getR_int_end_date() {
		return r_int_end_date;
	}

	public void setR_int_end_date(String r_int_end_date) {
		this.r_int_end_date = r_int_end_date;
	}

	public String getR_invs_ivtr_amt() {
		return r_invs_ivtr_amt;
	}

	public void setR_invs_ivtr_amt(String r_invs_ivtr_amt) {
		this.r_invs_ivtr_amt = r_invs_ivtr_amt;
	}

	public String getR_this_int() {
		return r_this_int;
	}

	public void setR_this_int(String r_this_int) {
		this.r_this_int = r_this_int;
	}

	public String getR_entry_no() {
		return r_entry_no;
	}

	public void setR_entry_no(String r_entry_no) {
		this.r_entry_no = r_entry_no;
	}

	public String getR_invs_code() {
		return r_invs_code;
	}

	public void setR_invs_code(String r_invs_code) {
		this.r_invs_code = r_invs_code;
	}

	public String getR_tran_date() {
		return r_tran_date;
	}

	public void setR_tran_date(String r_tran_date) {
		this.r_tran_date = r_tran_date;
	}

}
