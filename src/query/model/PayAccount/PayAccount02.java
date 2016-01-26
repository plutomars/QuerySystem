package query.model.PayAccount;

import java.util.HashMap;
/**
 * 
 * @author 陳冠瑜
 * 
 */
public class PayAccount02 {
	private String r_result_ind;     // 查詢結果
	private String r_data_ind;       // 資料指示(1:帳戶明細；2:異動紀錄)
	private String r_acct_type_desc; // 台幣/外幣帳戶
	private String r_po_chg_rece_no; // 受理號碼
	private String r_acct_sts_desc;  // 帳號狀況(有效；無效)/動作中文(新增；修改；刪除)
	private String r_process_user;   // 異動者中文
	private String r_process_date;   // 異動日期
	private String r_process_time;   // 異動時間

	public PayAccount02(HashMap<String, String> hsmp) {
		r_result_ind = (hsmp.get("r_result_ind") == null) ? "" : hsmp.get(
				"r_result_ind").trim();
		r_data_ind = (hsmp.get("r_data_ind") == null) ? "" : hsmp
				.get("r_data_ind").trim();		
		r_acct_type_desc = (hsmp.get("r_acct_type_desc") == null) ? "" : hsmp
				.get("r_acct_type_desc").trim();
		r_po_chg_rece_no = (hsmp.get("r_po_chg_rece_no") == null) ? "" : hsmp
				.get("r_po_chg_rece_no").trim();
		r_acct_sts_desc = (hsmp.get("r_acct_sts_desc") == null) ? "" : hsmp.get(
				"r_acct_sts_desc").trim();
		r_process_user = (hsmp.get("r_process_user") == null) ? "" : hsmp.get(
				"r_process_user").trim();
		r_process_date = (hsmp.get("r_process_date") == null) ? "" : hsmp.get(
				"r_process_date").trim();
		r_process_time = (hsmp.get("r_process_time") == null) ? "" : hsmp.get(
				"r_process_time").trim();
	}

	public String getR_result_ind() {
		return r_result_ind;
	}

	public void setR_result_ind(String r_result_ind) {
		this.r_result_ind = r_result_ind;
	}

	public String getR_data_ind() {
		return r_data_ind;
	}

	public void setR_data_ind(String r_data_ind) {
		this.r_data_ind = r_data_ind;
	}

	public String getR_acct_type_desc() {
		return r_acct_type_desc;
	}

	public void setR_acct_type_desc(String r_acct_type_desc) {
		this.r_acct_type_desc = r_acct_type_desc;
	}

	public String getR_po_chg_rece_no() {
		return r_po_chg_rece_no;
	}

	public void setR_po_chg_rece_no(String r_po_chg_rece_no) {
		this.r_po_chg_rece_no = r_po_chg_rece_no;
	}

	public String getR_acct_sts_desc() {
		return r_acct_sts_desc;
	}

	public void setR_acct_sts_desc(String r_acct_sts_desc) {
		this.r_acct_sts_desc = r_acct_sts_desc;
	}

	public String getR_process_user() {
		return r_process_user;
	}

	public void setR_process_user(String r_process_user) {
		this.r_process_user = r_process_user;
	}

	public String getR_process_date() {
		return r_process_date;
	}

	public void setR_process_date(String r_process_date) {
		this.r_process_date = r_process_date;
	}

	public String getR_process_time() {
		return r_process_time;
	}

	public void setR_process_time(String r_process_time) {
		this.r_process_time = r_process_time;
	}
}
