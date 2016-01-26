package query.model.ValueRepay;

import java.util.HashMap;

/**
 * @author F1256819
 * @category 還本未回回覆 回覆明細
 */
public class ValueRepay09 {

	private String r_result_ind;// 錯誤指示
	private String r_cp_anniv_date;// 保單週年日
	private String r_ca_disb_desc;// 付款方式
	private String r_crt_user_name;// 建檔者
	private String r_mail_addr;// 郵寄地址

	public ValueRepay09(HashMap<String, String> hsmp) {
		r_result_ind = (hsmp.get("r_result_ind") == null) ? "" : hsmp.get(
				"r_result_ind").trim();
		r_cp_anniv_date = (hsmp.get("r_cp_anniv_date") == null) ? "" : hsmp
				.get("r_cp_anniv_date").trim();
		r_ca_disb_desc = (hsmp.get("r_ca_disb_desc") == null) ? "" : hsmp.get(
				"r_ca_disb_desc").trim();
		r_crt_user_name = (hsmp.get("r_crt_user_name") == null) ? "" : hsmp
				.get("r_crt_user_name").trim();
		r_mail_addr = (hsmp.get("r_mail_addr") == null) ? "" : hsmp.get(
				"r_mail_addr").trim();

	}

	public String getR_result_ind() {
		return r_result_ind;
	}

	public void setR_result_ind(String r_result_ind) {
		this.r_result_ind = r_result_ind;
	}

	public String getR_cp_anniv_date() {
		return r_cp_anniv_date;
	}

	public void setR_cp_anniv_date(String r_cp_anniv_date) {
		this.r_cp_anniv_date = r_cp_anniv_date;
	}

	public String getR_ca_disb_desc() {
		return r_ca_disb_desc;
	}

	public void setR_ca_disb_desc(String r_ca_disb_desc) {
		this.r_ca_disb_desc = r_ca_disb_desc;
	}

	public String getR_crt_user_name() {
		return r_crt_user_name;
	}

	public void setR_crt_user_name(String r_crt_user_name) {
		this.r_crt_user_name = r_crt_user_name;
	}

	public String getR_mail_addr() {
		return r_mail_addr;
	}

	public void setR_mail_addr(String r_mail_addr) {
		this.r_mail_addr = r_mail_addr;
	}

}
