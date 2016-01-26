package query.model.PoDetail;

import java.util.HashMap;
/**
 * «O³æ©ú²Ó cc001i_ad
 * @author cora
 * 100/08
 */
public class PoDetailPrem {
	private String result_ind;
	private String mode_prem;
	private String gross_mode_prem;
	private String group_code;
	private String prem_disc_perc;
	private String group_ind;
	private String mode_prem_h;
	private String prem_disc_perc_h;
	private String accu_prem;
	
	public PoDetailPrem(HashMap<String, String> hsmp)
	{
		result_ind = (hsmp.get("r_result_ind") == null) ? "" : hsmp.get(
				"r_result_ind").trim();
		mode_prem = (hsmp.get("r_mode_prem") == null) ? "" : hsmp.get(
				"r_mode_prem").trim();
		gross_mode_prem = (hsmp.get("r_gross_mode_prem") == null) ? "" : hsmp.get(
				"r_gross_mode_prem").trim();
		group_code = (hsmp.get("r_group_code") == null) ? "" : hsmp.get(
				"r_group_code").trim();
		prem_disc_perc = (hsmp.get("r_prem_disc_perc") == null) ? "" : hsmp.get(
				"r_prem_disc_perc").trim();
		group_ind = (hsmp.get("r_group_ind") == null) ? "" : hsmp.get(
				"r_group_ind").trim();
		mode_prem_h = (hsmp.get("r_mode_prem_h") == null) ? "" : hsmp.get(
				"r_mode_prem_h").trim();
		prem_disc_perc_h = (hsmp.get("r_prem_disc_perc_h") == null) ? "" : hsmp.get(
				"r_prem_disc_perc_h").trim();
		accu_prem = (hsmp.get("r_accu_prem") == null) ? "" : hsmp.get(
				"r_accu_prem").trim();
	}
	
	public String getResult_ind() {
		return result_ind;
	}

	public void setResult_ind(String result_ind) {
		this.result_ind = result_ind;
	}
	
	public String getmode_prem() {
		return mode_prem;
	}

	public void setmode_prem(String mode_prem) {
		this.mode_prem = mode_prem;
	}
	public String getgross_mode_prem() {
		return gross_mode_prem;
	}

	public void setgross_mode_prem(String gross_mode_prem) {
		this.gross_mode_prem = gross_mode_prem;
	}
	public String getgroup_code() {
		return group_code;
	}

	public void setgroup_code(String group_code) {
		this.group_code = group_code;
	}
	public String getprem_disc_perc() {
		return prem_disc_perc;
	}

	public void setprem_disc_perc(String prem_disc_perc) {
		this.prem_disc_perc = prem_disc_perc;
	}
	public String getgroup_ind() {
		return group_ind;
	}

	public void setgroup_ind(String group_ind) {
		this.group_ind = group_ind;
	}
	public String getmode_prem_h() {
		return mode_prem_h;
	}

	public void setmode_prem_h(String mode_prem_h) {
		this.mode_prem_h = mode_prem_h;
	}
	public String getprem_disc_perc_h() {
		return prem_disc_perc_h;
	}

	public void setprem_disc_perc_h(String prem_disc_perc_h) {
		this.prem_disc_perc_h = prem_disc_perc_h;
	}
	
	public String getaccu_prem() {
		return accu_prem;
	}

	public void setaccu_prem(String accu_prem) {
		this.accu_prem = accu_prem;
	}
}
