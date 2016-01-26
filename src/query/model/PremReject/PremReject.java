package query.model.PremReject;

import java.util.HashMap;

/**
 * 
 * @author cychu
 *
 * @version 1.0
 *          101/03/21
 *          授權書、委託書退件查詢(JavaBean)
 *          
 * @since 1.0
 */

public class PremReject {
	private String result_ind;			//0_查詢結果
	private String policy_no;			//1_保單號碼
	private	String currency_desc;		//2_幣別
	private String bank_op_desc;		//3_銀行作業類別
	private String reject_msg;			//4_錯誤訊息
	private String method_desc;			//5_收費方式描述
	private String paid_to_date;		//6_應繳日期
	private String receive_no;			//7_受理號碼
	private String process_date;		//8_處理日期
	private String process_time;		//9_處理時間
	private String process_user;		//10_處理者
	
	public PremReject(HashMap<String, String> hsmp) {
		result_ind = (hsmp.get("r_result_ind") == null) ? "" : hsmp.get(
		"r_result_ind").trim();
		policy_no = (hsmp.get("r_policy_no") == null) ? "" : hsmp.get(
		"r_policy_no").trim();
		currency_desc = (hsmp.get("r_currency_desc") == null) ? "" : hsmp.get(
		"r_currency_desc").trim();
		bank_op_desc = (hsmp.get("r_bank_op_desc") == null) ? "" : hsmp.get(
		"r_bank_op_desc").trim();
		reject_msg = (hsmp.get("r_reject_msg") == null) ? "" : hsmp.get(
		"r_reject_msg").trim();
		method_desc = (hsmp.get("r_method_desc") == null) ? "" : hsmp.get(
		"r_method_desc").trim();
		paid_to_date = (hsmp.get("r_paid_to_date") == null) ? "" : hsmp.get(
		"r_paid_to_date").trim();
		receive_no = (hsmp.get("r_receive_no") == null) ? "" : hsmp.get(
		"r_receive_no").trim();
		process_date = (hsmp.get("r_process_date") == null) ? "" : hsmp.get(
		"r_process_date").trim();
		process_time = (hsmp.get("r_process_time") == null) ? "" : hsmp.get(
		"r_process_time").trim();
		process_user = (hsmp.get("r_process_user") == null) ? "" : hsmp.get(
		"r_process_user").trim();
	}

	public String getResult_ind() {
		return result_ind;
	}

	public void setResult_ind(String result_ind) {
		this.result_ind = result_ind;
	}

	public String getPolicy_no() {
		return policy_no;
	}

	public void setPolicy_no(String policy_no) {
		this.policy_no = policy_no;
	}

	public String getCurrency_desc() {
		return currency_desc;
	}

	public void setCurrency_desc(String currency_desc) {
		this.currency_desc = currency_desc;
	}

	public String getBank_op_desc() {
		return bank_op_desc;
	}

	public void setBank_op_desc(String bank_op_desc) {
		this.bank_op_desc = bank_op_desc;
	}
	
	public String getBank_op_ind() {
		return bank_op_desc.substring(0, 1);
	}

	public String getReject_msg() {
		return reject_msg;
	}

	public void setReject_msg(String reject_msg) {
		this.reject_msg = reject_msg;
	}

	public String getMethod_desc() {
		return method_desc;
	}

	public void setMethod_desc(String method_desc) {
		this.method_desc = method_desc;
	}

	public String getPaid_to_date() {
		return paid_to_date;
	}

	public void setPaid_to_date(String paid_to_date) {
		this.paid_to_date = paid_to_date;
	}

	public String getReceive_no() {
		return receive_no;
	}

	public void setReceive_no(String receive_no) {
		this.receive_no = receive_no;
	}

	public String getProcess_date() {
		return process_date;
	}

	public void setProcess_date(String process_date) {
		this.process_date = process_date;
	}

	public String getProcess_time() {
		return process_time;
	}

	public void setProcess_time(String process_time) {
		this.process_time = process_time;
	}

	public String getProcess_user() {
		return process_user;
	}

	public void setProcess_user(String process_user) {
		this.process_user = process_user;
	}	
}