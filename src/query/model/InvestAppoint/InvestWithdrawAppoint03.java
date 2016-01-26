package query.model.InvestAppoint;

import java.util.HashMap;

public class InvestWithdrawAppoint03 {
	private String r_invs_ad_sub_ind;
	private String r_invs_code;
	private String r_invs_title;
	private String r_chah_sell_type;
	private String r_invs_ad_amt;
	private String r_invs_ad_perc;

	public InvestWithdrawAppoint03() {

	}

	public InvestWithdrawAppoint03(HashMap<String, String> hsmp) {
		r_invs_ad_sub_ind = (hsmp.get("r_invs_ad_sub_ind") == null) ? "" : hsmp
				.get("r_invs_ad_sub_ind").trim();
		r_invs_code = (hsmp.get("r_invs_code") == null) ? "" : hsmp.get(
				"r_invs_code").trim();
		r_invs_title = (hsmp.get("r_invs_title") == null) ? "" : hsmp.get(
				"r_invs_title").trim();
		r_chah_sell_type = (hsmp.get("r_chah_sell_type") == null) ? "" : hsmp
				.get("r_chah_sell_type").trim();
		r_invs_ad_amt = (hsmp.get("r_invs_ad_amt") == null) ? "" : hsmp.get(
				"r_invs_ad_amt").trim();
		r_invs_ad_perc = (hsmp.get("r_invs_ad_perc") == null) ? "" : hsmp.get(
				"r_invs_ad_perc").trim();
	}

	public String getR_invs_ad_sub_ind() {
		return r_invs_ad_sub_ind;
	}

	public void setR_invs_ad_sub_ind(String r_invs_ad_sub_ind) {
		this.r_invs_ad_sub_ind = r_invs_ad_sub_ind;
	}

	public String getR_invs_code() {
		return r_invs_code;
	}

	public void setR_invs_code(String r_invs_code) {
		this.r_invs_code = r_invs_code;
	}

	public String getR_invs_title() {
		return r_invs_title;
	}

	public void setR_invs_title(String r_invs_title) {
		this.r_invs_title = r_invs_title;
	}

	public String getR_chah_sell_type() {
		return r_chah_sell_type;
	}

	public void setR_chah_sell_type(String r_chah_sell_type) {
		this.r_chah_sell_type = r_chah_sell_type;
	}

	public String getR_invs_ad_amt() {
		return r_invs_ad_amt;
	}

	public void setR_invs_ad_amt(String r_invs_ad_amt) {
		this.r_invs_ad_amt = r_invs_ad_amt;
	}

	public String getR_invs_ad_perc() {
		return r_invs_ad_perc;
	}

	public void setR_invs_ad_perc(String r_invs_ad_perc) {
		this.r_invs_ad_perc = r_invs_ad_perc;
	}
	

}
