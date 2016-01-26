package query.model.PremProxy;

import java.util.ArrayList;
import java.util.HashMap;

import query.model.AbstractModelObject;
/**
 * 
 * @author 陳冠瑜
 * 
 */
public class PremProxy01 extends AbstractModelObject {
	private String result_ind; // 查詢結果

	private String policy_no; // 保單號碼
	private String applicant_name; // 要保人
	private String insured_name; // 被保人
	private String po_sts_desc; // 保單狀態
	private String modx_desc; // 保費繳法
	private String method_desc; // 收費方式
	private String trf_errmax; // 失敗次數

	private String paid_to_date; // 應繳日期
	private String bill_to_date; // 通知書到期日
	private String gap_start_date; // 停效日期
	private String acct_sts_desc; // 帳號狀態
	private String proxy_sts_desc; // 授權書狀態
	private String process_user; // 異動者
	private String process_date; // 異動日

	private String bank_paid_date; // 帳單日
	private String disable_date; // 信用卡有效期限
	private String acc_tel; // 授權人電話
	private String acc_address; // 授權人地址
	private String acc_birth_date; // 授權人生日

	private String com_return_no; // 公司聯歸檔號碼
	private String po_sts_code; // 保單狀態碼

	public PremProxy01() {

	}

	public void setValues(HashMap<String, String> hsmp) {
		result_ind = (hsmp.get("r_result_ind") == null) ? "" : hsmp.get(
				"r_result_ind").trim();
		policy_no = (hsmp.get("r_policy_no") == null) ? "" : hsmp.get(
				"r_policy_no").trim();
		applicant_name = (hsmp.get("r_applicant_name") == null) ? "" : hsmp
				.get("r_applicant_name").trim();
		insured_name = (hsmp.get("r_insured_name") == null) ? "" : hsmp.get(
				"r_insured_name").trim();
		po_sts_desc = (hsmp.get("r_po_sts_desc") == null) ? "" : hsmp.get(
				"r_po_sts_desc").trim();
		modx_desc = (hsmp.get("r_modx_desc") == null) ? "" : hsmp.get(
				"r_modx_desc").trim();
		method_desc = (hsmp.get("r_method_desc") == null) ? "" : hsmp.get(
				"r_method_desc").trim();
		trf_errmax = (hsmp.get("r_trf_errmax") == null) ? "" : hsmp.get(
				"r_trf_errmax").trim();
		paid_to_date = (hsmp.get("r_paid_to_date") == null) ? "" : hsmp.get(
				"r_paid_to_date").trim();
		bill_to_date = (hsmp.get("r_bill_to_date") == null) ? "" : hsmp.get(
				"r_bill_to_date").trim();
		gap_start_date = (hsmp.get("r_gap_start_date") == null) ? "" : hsmp
				.get("r_gap_start_date").trim();
		acct_sts_desc = (hsmp.get("r_acct_sts_desc") == null) ? "" : hsmp.get(
				"r_acct_sts_desc").trim();
		proxy_sts_desc = (hsmp.get("r_proxy_sts_desc") == null) ? "" : hsmp
				.get("r_proxy_sts_desc").trim();
		process_user = (hsmp.get("r_process_user") == null) ? "" : hsmp.get(
				"r_process_user").trim();
		process_date = (hsmp.get("r_process_date") == null) ? "" : hsmp.get(
				"r_process_date").trim();
		bank_paid_date = (hsmp.get("r_bank_paid_date") == null) ? "" : hsmp
				.get("r_bank_paid_date").trim();
		disable_date = (hsmp.get("r_disable_date") == null) ? "" : hsmp.get(
				"r_disable_date").trim();
		acc_tel = (hsmp.get("r_acc_tel") == null) ? "" : hsmp.get("r_acc_tel")
				.trim();
		acc_address = (hsmp.get("r_acc_address") == null) ? "" : hsmp.get(
				"r_acc_address").trim();
		acc_birth_date = (hsmp.get("r_acc_birth_date") == null) ? "" : hsmp
				.get("r_acc_birth_date").trim();
		com_return_no = (hsmp.get("r_com_return_no") == null) ? "" : hsmp.get(
				"r_com_return_no").trim();
		po_sts_code = (hsmp.get("r_po_sts_code") == null) ? "" : hsmp.get(
				"r_po_sts_code").trim();
	}

	public String[] getValues(int type) {
		ArrayList<String> valueList = new ArrayList<String>();

		switch (type) {
		case 1:
			valueList.add(policy_no);
			valueList.add(applicant_name);
			valueList.add(insured_name);
			valueList.add(po_sts_desc);
			valueList.add(modx_desc);
			valueList.add(method_desc);
			valueList.add(trf_errmax);
			break;
		case 2:
			valueList.add(paid_to_date);
			valueList.add(bill_to_date);
			valueList.add(gap_start_date);
			valueList.add(acct_sts_desc);
			valueList.add(proxy_sts_desc);
			valueList.add(process_user);
			valueList.add(process_date);
			break;
		case 3:
			valueList.add(bank_paid_date);
			valueList.add(disable_date);
			valueList.add(acc_tel);
			valueList.add(acc_address);
			valueList.add(acc_birth_date);
			break;
		}
		String[] valueArray = new String[valueList.size()];
		valueList.toArray(valueArray);

		return valueArray;
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

	public String getApplicant_name() {
		return applicant_name;
	}

	public void setApplicant_name(String applicant_name) {
		this.applicant_name = applicant_name;
	}

	public String getInsured_name() {
		return insured_name;
	}

	public void setInsured_name(String insured_name) {
		this.insured_name = insured_name;
	}

	public String getPo_sts_desc() {
		return po_sts_desc;
	}

	public void setPo_sts_desc(String po_sts_desc) {
		this.po_sts_desc = po_sts_desc;
	}

	public String getModx_desc() {
		return modx_desc;
	}

	public void setModx_desc(String modx_desc) {
		this.modx_desc = modx_desc;
	}

	public String getMethod_desc() {
		return method_desc;
	}

	public void setMethod_desc(String method_desc) {
		this.method_desc = method_desc;
	}

	public String getTrf_errmax() {
		return trf_errmax;
	}

	public void setTrf_errmax(String trf_errmax) {
		this.trf_errmax = trf_errmax;
	}

	public String getPaid_to_date() {
		return paid_to_date;
	}

	public void setPaid_to_date(String paid_to_date) {
		this.paid_to_date = paid_to_date;
	}

	public String getBill_to_date() {
		return bill_to_date;
	}

	public void setBill_to_date(String bill_to_date) {
		this.bill_to_date = bill_to_date;
	}

	public String getGap_start_date() {
		return gap_start_date;
	}

	public void setGap_start_date(String gap_start_date) {
		this.gap_start_date = gap_start_date;
	}

	public String getAcct_sts_desc() {
		return acct_sts_desc;
	}

	public void setAcct_sts_desc(String acct_sts_desc) {
		this.acct_sts_desc = acct_sts_desc;
	}

	public String getProxy_sts_desc() {
		return proxy_sts_desc;
	}

	public void setProxy_sts_desc(String proxy_sts_desc) {
		this.proxy_sts_desc = proxy_sts_desc;
	}

	public String getProcess_user() {
		return process_user;
	}

	public void setProcess_user(String process_user) {
		this.process_user = process_user;
	}

	public String getProcess_date() {
		return process_date;
	}

	public void setProcess_date(String process_date) {
		this.process_date = process_date;
	}

	public String getBank_paid_date() {
		return bank_paid_date;
	}

	public void setBank_paid_date(String bank_paid_date) {
		this.bank_paid_date = bank_paid_date;
	}

	public String getDisable_date() {
		return disable_date;
	}

	public void setDisable_date(String disable_date) {
		this.disable_date = disable_date;
	}

	public String getAcc_tel() {
		return acc_tel;
	}

	public void setAcc_tel(String acc_tel) {
		this.acc_tel = acc_tel;
	}

	public String getAcc_address() {
		return acc_address;
	}

	public void setAcc_address(String acc_address) {
		this.acc_address = acc_address;
	}

	public String getAcc_birth_date() {
		return acc_birth_date;
	}

	public void setAcc_birth_date(String acc_birth_date) {
		this.acc_birth_date = acc_birth_date;
	}

	public String getCom_return_no() {
		return com_return_no;
	}

	public void setCom_return_no(String com_return_no) {
		this.com_return_no = com_return_no;
	}

	public String getPo_sts_code() {
		return po_sts_code;
	}

	public void setPo_sts_code(String po_sts_code) {
		this.po_sts_code = po_sts_code;
	}
}
