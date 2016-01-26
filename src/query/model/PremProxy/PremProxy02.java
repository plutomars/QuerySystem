package query.model.PremProxy;

import java.util.HashMap;

import query.model.AbstractModelObject;
/**
 * 
 * @author 陳冠瑜
 * 
 */
public class PremProxy02 extends AbstractModelObject {
	private String result_ind; // 查詢結果

	private String process_date; // 異動日期
	private String status_desc; // 異動狀態
	private String bank_name; // 銀行中文
	private String card_type; // 卡別
	private String bank_paid_date; // 帳單日
	private String acc_name; // 授權人
	private String acc_id; // 授權人ID
	private String process_user; // 異動者(中文)
	private String method_desc; // 收費方式
	private String bank_branch_d; // 扣款銀行(中文)
	private String receive_no; // 受理號碼 101-10-03新增

	public PremProxy02(HashMap<String, String> hsmp) {
		result_ind = (hsmp.get("r_result_ind") == null) ? "" : hsmp.get(
				"r_result_ind").trim();
		process_date = (hsmp.get("r_process_date") == null) ? "" : hsmp.get(
				"r_process_date").trim();
		status_desc = (hsmp.get("r_status_desc") == null) ? "" : hsmp.get(
				"r_status_desc").trim();
		bank_name = (hsmp.get("r_bank_name") == null) ? "" : hsmp.get(
				"r_bank_name").trim();
		card_type = (hsmp.get("r_card_type") == null) ? "" : hsmp.get(
				"r_card_type").trim();
		bank_paid_date = (hsmp.get("r_bank_paid_date") == null) ? "" : hsmp
				.get("r_bank_paid_date").trim();
		acc_name = (hsmp.get("r_acc_name") == null) ? "" : hsmp.get(
				"r_acc_name").trim();
		acc_id = (hsmp.get("r_acc_id") == null) ? "" : hsmp.get("r_acc_id")
				.trim();
		process_user = (hsmp.get("r_process_user") == null) ? "" : hsmp.get(
				"r_process_user").trim();
		method_desc = (hsmp.get("r_method_desc") == null) ? "" : hsmp.get(
				"r_method_desc").trim();
		bank_branch_d = (hsmp.get("r_bank_branch_d") == null) ? "" : hsmp.get(
				"r_bank_branch_d").trim();
		receive_no = (hsmp.get("r_receive_no") == null) ? "" : hsmp.get(
				"r_receive_no").trim();

	}

	public String getReceive_no() {
		return receive_no;
	}

	public void setReceive_no(String receive_no) {
		this.receive_no = receive_no;
	}

	public String getResult_ind() {
		return result_ind;
	}

	public void setResult_ind(String result_ind) {
		this.result_ind = result_ind;
	}

	public String getProcess_date() {
		return process_date;
	}

	public void setProcess_date(String process_date) {
		this.process_date = process_date;
	}

	public String getStatus_desc() {
		return status_desc;
	}

	public void setStatus_desc(String status_desc) {
		this.status_desc = status_desc;
	}

	public String getBank_name() {
		return bank_name;
	}

	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}

	public String getCard_type() {
		return card_type;
	}

	public void setCard_type(String card_type) {
		this.card_type = card_type;
	}

	public String getBank_paid_date() {
		return bank_paid_date;
	}

	public void setBank_paid_date(String bank_paid_date) {
		this.bank_paid_date = bank_paid_date;
	}

	public String getAcc_name() {
		return acc_name;
	}

	public void setAcc_name(String acc_name) {
		this.acc_name = acc_name;
	}

	public String getAcc_id() {
		return acc_id;
	}

	public void setAcc_id(String acc_id) {
		this.acc_id = acc_id;
	}

	public String getProcess_user() {
		return process_user;
	}

	public void setProcess_user(String process_user) {
		this.process_user = process_user;
	}

	public String getMethod_desc() {
		return method_desc;
	}

	public void setMethod_desc(String method_desc) {
		this.method_desc = method_desc;
	}

	public String getBank_branch_d() {
		return bank_branch_d;
	}

	public void setBank_branch_d(String bank_branch_d) {
		this.bank_branch_d = bank_branch_d;
	}
}
