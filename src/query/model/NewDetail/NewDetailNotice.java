package query.model.NewDetail;

import java.util.HashMap;

/**
 * 新契約明細照會項目部份(JavaBean)
 * 
 * @author epf
 * 
 * @version 1.0<br>
 *          100/07/28<br>
 * 
 * @since 1.0
 */
public class NewDetailNotice {
	private String r_result_ind;
	private String app_apply_date;
	private String r_notify_date;
	private String r_re_notify_date;
	private String r_exp_return_date;
	private String r_ag_dept;
	private String r_ag_name;
	private String r_user_name;
	private String r_nb_notify_code;
	private String r_nb_notify_desc;
	private String r_act_return_date;

	public NewDetailNotice(HashMap<String, String> hsmp) {
		app_apply_date = (hsmp.get("app_apply_date") == null) ? "" : hsmp.get(
				"app_apply_date").trim();
		r_notify_date = (hsmp.get("r_notify_date") == null) ? "" : hsmp.get(
				"r_notify_date").trim();
		r_re_notify_date = (hsmp.get("r_re_notify_date") == null) ? "" : hsmp
				.get("r_re_notify_date").trim();
		r_exp_return_date = (hsmp.get("r_exp_return_date") == null) ? "" : hsmp
				.get("r_exp_return_date").trim();
		r_ag_dept = (hsmp.get("r_ag_dept") == null) ? "" : hsmp
				.get("r_ag_dept").trim();
		r_ag_name = (hsmp.get("r_ag_name") == null) ? "" : hsmp
				.get("r_ag_name").trim();
		r_user_name = (hsmp.get("r_user_name") == null) ? "" : hsmp.get(
				"r_user_name").trim();
		r_nb_notify_code = (hsmp.get("r_nb_notify_code") == null) ? "" : hsmp
				.get("r_nb_notify_code").trim();
		r_nb_notify_desc = (hsmp.get("r_nb_notify_desc") == null) ? "" : hsmp
				.get("r_nb_notify_desc").trim();
		r_act_return_date = (hsmp.get("r_act_return_date") == null) ? "" : hsmp
				.get("r_act_return_date").trim();
	}

	public String getR_result_ind() {
		return r_result_ind;
	}

	public void setR_result_ind(String r_result_ind) {
		this.r_result_ind = r_result_ind;
	}

	public String getApp_apply_date() {
		return app_apply_date;
	}

	public void setApp_apply_date(String app_apply_date) {
		this.app_apply_date = app_apply_date;
	}

	public String getR_notify_date() {
		return r_notify_date;
	}

	public void setR_notify_date(String r_notify_date) {
		this.r_notify_date = r_notify_date;
	}

	public String getR_re_notify_date() {
		return r_re_notify_date;
	}

	public void setR_re_notify_date(String r_re_notify_date) {
		this.r_re_notify_date = r_re_notify_date;
	}

	public String getR_exp_return_date() {
		return r_exp_return_date;
	}

	public void setR_exp_return_date(String r_exp_return_date) {
		this.r_exp_return_date = r_exp_return_date;
	}

	public String getR_ag_dept() {
		return r_ag_dept;
	}

	public void setR_ag_dept(String r_ag_dept) {
		this.r_ag_dept = r_ag_dept;
	}

	public String getR_ag_name() {
		return r_ag_name;
	}

	public void setR_ag_name(String r_ag_name) {
		this.r_ag_name = r_ag_name;
	}

	public String getR_user_name() {
		return r_user_name;
	}

	public void setR_user_name(String r_user_name) {
		this.r_user_name = r_user_name;
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

	public String[] getColumn1() {
		return new String[] { app_apply_date, r_ag_dept+"營業處  "+r_ag_name.trim()+"  君" };
	}

	public String[] getColumn2() {
		return new String[] { r_user_name, r_exp_return_date, r_re_notify_date };
	}

}
