package query.model.NewRescind;

import java.util.HashMap;


public class NewRescind04 {
	private String r_result_ind;
	private String r_nbcd_sts_code;
	private String r_nb_notify_code;
	private String r_nb_notify_desc;
	private String r_act_return_date;
	
	public NewRescind04(HashMap<String, String> hsmp) {
		r_result_ind = (hsmp.get("r_result_ind") == null) ? "" : hsmp.get(
				"r_result_ind").trim();
		r_nbcd_sts_code = (hsmp.get("r_nbcd_sts_code") == null) ? "" : hsmp.get(
				"r_nbcd_sts_code").trim();
		r_nb_notify_code = (hsmp.get("r_nb_notify_code") == null) ? "" : hsmp
				.get("r_nb_notify_code").trim();
		r_nb_notify_desc = (hsmp.get("r_nb_notify_desc") == null) ? "" : hsmp.get(
				"r_nb_notify_desc").trim();
		r_act_return_date = (hsmp.get("r_act_return_date") == null) ? "" : hsmp
				.get("r_act_return_date").trim();
		
	}

	public String getR_result_ind() {
		return r_result_ind;
	}

	public void setR_result_ind(String r_result_ind) {
		this.r_result_ind = r_result_ind;
	}

	public String getR_nbcd_sts_code() {
		return r_nbcd_sts_code;
	}

	public void setR_nbcd_sts_code(String r_nbcd_sts_code) {
		this.r_nbcd_sts_code = r_nbcd_sts_code;
	}

	public String getR_nb_notify_code() {
		return r_nb_notify_code;
	}

	public void setR_nb_notify_code(String r_nb_notify_code) {
		this.r_nb_notify_code = r_nb_notify_code;
	}

	public String getR_nb_notify_desc() {
		return r_nb_notify_desc;
	}

	public void setR_nb_notify_desc(String r_nb_notify_desc) {
		this.r_nb_notify_desc = r_nb_notify_desc;
	}

	public String getR_act_return_date() {
		return r_act_return_date;
	}

	public void setR_act_return_date(String r_act_return_date) {
		this.r_act_return_date = r_act_return_date;
	}
	
	
}
