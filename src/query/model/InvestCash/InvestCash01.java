package query.model.InvestCash;

import java.util.HashMap;
/**
 * 
 * @author ���a��
 * 
 */
public class InvestCash01 {

	private String result_ind;     //�d�ߵ��G
	private String tran_date;      //������
	private String function_code;  //�\��
	private String receive_amt;    //���J���B
	private String payout_amt;     //���I���B
	private String fee_amt;        //�޲z�O��
	private String charge_amt;     //����O
	private String entry_no;       //�J�b���X
	private String invs_ad_no;     //����s��
	private String currency;       //���O

	public InvestCash01(HashMap<String, String> hsmp) {
		result_ind = (hsmp.get("r_result_ind") == null) ? "" : hsmp.get(
				"r_result_ind").trim();
		tran_date = (hsmp.get("r_tran_date") == null) ? "" : hsmp.get(
				"r_tran_date").trim();
		function_code = (hsmp.get("r_function_code") == null) ? "" : hsmp.get(
				"r_function_code").trim();
		receive_amt = (hsmp.get("r_receive_amt") == null) ? "" : hsmp.get(
				"r_receive_amt").trim();
		payout_amt = (hsmp.get("r_payout_amt") == null) ? "" : hsmp.get(
				"r_payout_amt").trim();
		fee_amt = (hsmp.get("r_fee_amt") == null) ? "" : hsmp.get("r_fee_amt")
				.trim();
		charge_amt = (hsmp.get("r_charge_amt") == null) ? "" : hsmp.get(
				"r_charge_amt").trim();
		entry_no = (hsmp.get("r_entry_no") == null) ? "" : hsmp.get(
				"r_entry_no").trim();
		invs_ad_no = (hsmp.get("r_invs_ad_no") == null) ? "" : hsmp.get(
				"r_invs_ad_no").trim();
		currency = (hsmp.get("r_currency") == null) ? "" : hsmp.get(
				"r_currency").trim();
	}

	public String getResult_ind() {
		return result_ind;
	}

	public void setResult_ind(String result_ind) {
		this.result_ind = result_ind;
	}

	public String getTran_date() {
		return tran_date;
	}

	public void setTran_date(String tran_date) {
		this.tran_date = tran_date;
	}

	public String getFunction_code() {
		return function_code;
	}

	public void setFunction_code(String function_code) {
		this.function_code = function_code;
	}

	public String getReceive_amt() {
		return receive_amt;
	}

	public void setReceive_amt(String receive_amt) {
		this.receive_amt = receive_amt;
	}

	public String getPayout_amt() {
		return payout_amt;
	}

	public void setPayout_amt(String payout_amt) {
		this.payout_amt = payout_amt;
	}

	public String getFee_amt() {
		return fee_amt;
	}

	public void setFee_amt(String fee_amt) {
		this.fee_amt = fee_amt;
	}

	public String getCharge_amt() {
		return charge_amt;
	}

	public void setCharge_amt(String charge_amt) {
		this.charge_amt = charge_amt;
	}

	public String getEntry_no() {
		return entry_no;
	}

	public void setEntry_no(String entry_no) {
		this.entry_no = entry_no;
	}

	public String getInvs_ad_no() {
		return invs_ad_no;
	}

	public void setInvs_ad_no(String invs_ad_no) {
		this.invs_ad_no = invs_ad_no;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}
}
