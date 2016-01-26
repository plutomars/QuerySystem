package query.model.InvestAppoint;

import java.util.HashMap;

public class InvestWithdrawAppoint01 {
	private String r_result_ind;// 結果
	private String r_chah_seq; // 約定交易序號
	private String r_chlh_seq; // 約定交易記錄序號
	private String r_auto_tr_date;// 約定作業日
	private String r_process_date;// 實際作業日
	private String r_receive_no;// 受理號碼
	private String r_invs_amt;// 應贖回金額
	private String r_invs_real_amt;// 實際贖回金額
	private String r_invs_ad_no; // 交易編號
	private String r_ivchg_sts_code;// 狀態
	private String r_resp_code;// 事由

	public InvestWithdrawAppoint01() {
		// TODO Auto-generated constructor stub
	}

	public InvestWithdrawAppoint01(HashMap<String, String> hsmp) {
		r_result_ind = (hsmp.get("r_result_ind") == null) ? "" : hsmp.get(
				"r_result_ind").trim();
		r_chah_seq = (hsmp.get("r_chah_seq") == null) ? "" : hsmp.get(
				"r_chah_seq").trim();
		r_chlh_seq = (hsmp.get("r_chlh_seq") == null) ? "" : hsmp.get(
				"r_chlh_seq").trim();
		r_auto_tr_date = (hsmp.get("r_auto_tr_date") == null) ? "" : hsmp.get(
				"r_auto_tr_date").trim();
		r_process_date = (hsmp.get("r_process_date") == null) ? "" : hsmp.get(
				"r_process_date").trim();
		r_receive_no = (hsmp.get("r_receive_no") == null) ? "" : hsmp.get(
				"r_receive_no").trim();
		r_invs_amt = (hsmp.get("r_invs_amt") == null) ? "" : hsmp.get(
				"r_invs_amt").trim();
		r_invs_real_amt = (hsmp.get("r_invs_real_amt") == null) ? "" : hsmp
				.get("r_invs_real_amt").trim();
		r_invs_ad_no = (hsmp.get("r_invs_ad_no") == null) ? "" : hsmp.get(
				"r_invs_ad_no").trim();
		r_ivchg_sts_code = (hsmp.get("r_ivchg_sts_code") == null) ? "" : hsmp
				.get("r_ivchg_sts_code").trim();
		r_resp_code = (hsmp.get("r_resp_code") == null) ? "" : hsmp.get(
				"r_resp_code").trim();
	}

	public String getR_result_ind() {
		return r_result_ind;
	}

	public void setR_result_ind(String r_result_ind) {
		this.r_result_ind = r_result_ind;
	}

	public String getR_chah_seq() {
		return r_chah_seq;
	}

	public void setR_chah_seq(String r_chah_seq) {
		this.r_chah_seq = r_chah_seq;
	}

	public String getR_chlh_seq() {
		return r_chlh_seq;
	}

	public void setR_chlh_seq(String r_chlh_seq) {
		this.r_chlh_seq = r_chlh_seq;
	}

	public String getR_auto_tr_date() {
		return r_auto_tr_date;
	}

	public void setR_auto_tr_date(String r_auto_tr_date) {
		this.r_auto_tr_date = r_auto_tr_date;
	}

	public String getR_process_date() {
		return r_process_date;
	}

	public void setR_process_date(String r_process_date) {
		this.r_process_date = r_process_date;
	}

	public String getR_receive_no() {
		return r_receive_no;
	}

	public void setR_receive_no(String r_receive_no) {
		this.r_receive_no = r_receive_no;
	}

	public String getR_invs_amt() {
		return r_invs_amt;
	}

	public void setR_invs_amt(String r_invs_amt) {
		this.r_invs_amt = r_invs_amt;
	}

	public String getR_invs_real_amt() {
		return r_invs_real_amt;
	}

	public void setR_invs_real_amt(String r_invs_real_amt) {
		this.r_invs_real_amt = r_invs_real_amt;
	}

	public String getR_invs_ad_no() {
		return r_invs_ad_no;
	}

	public void setR_invs_ad_no(String r_invs_ad_no) {
		this.r_invs_ad_no = r_invs_ad_no;
	}

	public String getR_ivchg_sts_code() {
		return r_ivchg_sts_code;
	}

	public void setR_ivchg_sts_code(String r_ivchg_sts_code) {
		this.r_ivchg_sts_code = r_ivchg_sts_code;
	}

	public String getR_resp_code() {
		return r_resp_code;
	}

	public void setR_resp_code(String r_resp_code) {
		this.r_resp_code = r_resp_code;
	}

}
