package query.model.InvestAppoint;

import java.util.HashMap;

public class InvestWithdrawAppoint02 {

	private String r_receive_no;// 約定受理號碼
	private String r_bgn_date;// 約定日期
	private String r_chah_freq;// 約定頻率
	private String r_auto_tr_date; // 下次執行日

	public InvestWithdrawAppoint02() {

	}

	public InvestWithdrawAppoint02(HashMap<String, String> hsmp) {
		r_receive_no = (hsmp.get("r_receive_no") == null) ? "" : hsmp.get(
				"r_receive_no").trim();
		r_bgn_date = (hsmp.get("r_bgn_date") == null) ? "" : hsmp.get(
				"r_bgn_date").trim();
		r_chah_freq = (hsmp.get("r_chah_freq") == null) ? "" : hsmp.get(
				"r_chah_freq").trim();
		r_auto_tr_date = (hsmp.get("r_auto_tr_date") == null) ? "" : hsmp.get(
				"r_auto_tr_date").trim();
	}

	public String getR_receive_no() {
		return r_receive_no;
	}

	public void setR_receive_no(String r_receive_no) {
		this.r_receive_no = r_receive_no;
	}

	public String getR_bgn_date() {
		return r_bgn_date;
	}

	public void setR_bgn_date(String r_bgn_date) {
		this.r_bgn_date = r_bgn_date;
	}

	public String getR_chah_freq() {
		return r_chah_freq;
	}

	public void setR_chah_freq(String r_chah_freq) {
		this.r_chah_freq = r_chah_freq;
	}

	public String getR_auto_tr_date() {
		return r_auto_tr_date;
	}

	public void setR_auto_tr_date(String r_auto_tr_date) {
		this.r_auto_tr_date = r_auto_tr_date;
	}

}
