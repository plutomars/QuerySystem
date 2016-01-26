package query.model.PayAccount;

import java.util.ArrayList;
import java.util.HashMap;
/**
 * 
 * @author 陳冠瑜
 * 
 */
public class PayAccount01 {
	private String r_result_ind;     // 查詢結果
	private String r_client_id;      // 客戶ID
	private String r_acct_source;	 //
	private String r_names;          // 客戶姓名
	private String r_names_e;        // 受款人英文名
	private String r_data_ind;       // 資料指示(1:帳戶明細；2:異動紀錄)
	private String r_acct_type_desc; // 台幣/外幣帳戶
	private String r_acct_sts_desc;  // 帳號狀況(有效；無效)/動作中文(新增；修改；刪除)
	private String r_bank_code;      // 銀行代碼
	private String r_bank_name;      // 銀行名稱
	private String r_bank_name_e;    // 銀行英文名稱
	private String r_swift_code;     // 通匯代碼
	private String r_bank_account;   // 匯款帳號
	private String r_policy_no;

	public String[] getValues(int type) {
		ArrayList<String> valueList = new ArrayList<String>();
		switch (type) {
		case 1:
			valueList.add(r_client_id);
			break;
		case 2:
			valueList.add(r_names);
			break;
		case 3:
			valueList.add(r_names_e);
			break;
		}
		String[] valueArray = new String[valueList.size()];
		valueList.toArray(valueArray);

		return valueArray;
	}
	
	public PayAccount01(HashMap<String, String> hsmp) {
		r_result_ind = (hsmp.get("r_result_ind") == null) ? "" : hsmp.get(
				"r_result_ind").trim();
		r_acct_source = (hsmp.get("r_acct_source") == null) ? "" : hsmp.get(
				"r_acct_source").trim();
		r_data_ind = (hsmp.get("r_data_ind") == null) ? "" : hsmp.get(
				"r_data_ind").trim();
		r_acct_type_desc = (hsmp.get("r_acct_type_desc") == null) ? "" : hsmp
				.get("r_acct_type_desc").trim();
		r_acct_sts_desc = (hsmp.get("r_acct_sts_desc") == null) ? "" : hsmp
				.get("r_acct_sts_desc").trim();
		r_bank_code = (hsmp.get("r_bank_code") == null) ? "" : hsmp.get(
				"r_bank_code").trim();
		r_bank_name = (hsmp.get("r_bank_name") == null) ? "" : hsmp.get(
				"r_bank_name").trim();
		r_bank_name_e = (hsmp.get("r_bank_name_e") == null) ? "" : hsmp.get(
				"r_bank_name_e").trim();
		r_swift_code = (hsmp.get("r_swift_code") == null) ? "" : hsmp.get(
				"r_swift_code").trim();
		r_bank_account = (hsmp.get("r_bank_account") == null) ? "" : hsmp.get(
				"r_bank_account").trim();
		// for verticalPane
//		r_client_id = (hsmp.get("r_client_id") == null) ? "" : hsmp.get(
//				"r_client_id").trim();
		r_names = (hsmp.get("r_names") == null) ? "" : hsmp.get("r_names")
				.trim();
		r_names_e = (hsmp.get("r_names_e") == null) ? "" : hsmp
				.get("r_names_e").trim();
		r_policy_no = (hsmp.get("r_policy_no") == null) ? "" : hsmp.get(
				"r_policy_no").trim();
	}

	public String getR_result_ind() {
		return r_result_ind;
	}

	public void setR_result_ind(String r_result_ind) {
		this.r_result_ind = r_result_ind;
	}

	public String getR_client_id() {
		return r_client_id;
	}

	public void setR_client_id(String r_client_id) {
		this.r_client_id = r_client_id;
	}

	public String getR_names() {
		return r_names;
	}

	public void setR_names(String r_names) {
		this.r_names = r_names;
	}

	public String getR_names_e() {
		return r_names_e;
	}

	public void setR_names_e(String r_names_e) {
		this.r_names_e = r_names_e;
	}

	public String getR_acct_source() {
		return r_acct_source;
	}

	public void setR_acct_source(String r_acct_source) {
		this.r_acct_source = r_acct_source;
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

	public String getR_acct_sts_desc() {
		return r_acct_sts_desc;
	}

	public void setR_acct_sts_desc(String r_acct_sts_desc) {
		this.r_acct_sts_desc = r_acct_sts_desc;
	}

	public String getR_bank_code() {
		return r_bank_code;
	}

	public void setR_bank_code(String r_bank_code) {
		this.r_bank_code = r_bank_code;
	}

	public String getR_bank_name() {
		return r_bank_name;
	}

	public void setR_bank_name(String r_bank_name) {
		this.r_bank_name = r_bank_name;
	}

	public String getR_bank_name_e() {
		return r_bank_name_e;
	}

	public void setR_bank_name_e(String r_bank_name_e) {
		this.r_bank_name_e = r_bank_name_e;
	}

	public String getR_swift_code() {
		return r_swift_code;
	}

	public void setR_swift_code(String r_swift_code) {
		this.r_swift_code = r_swift_code;
	}

	public String getR_bank_account() {
		return r_bank_account;
	}

	public void setR_bank_account(String r_bank_account) {
		this.r_bank_account = r_bank_account;
	}

	public String getR_policy_no() {
		return r_policy_no;
	}

	public void setR_policy_no(String r_policy_no) {
		this.r_policy_no = r_policy_no;
	}
}
