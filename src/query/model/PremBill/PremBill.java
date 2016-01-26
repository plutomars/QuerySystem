package query.model.PremBill;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 
 * @author cychu
 * 
 * @version 1.1
 * 			104/04/14<br>
 * 			目前扣款資料(JavaBean)
 * 
 * @since 1.0
 */
public class PremBill {
	private String result_ind;				//0_查詢結果
	private String policy_no;				//1_保單號碼
	private String owner_name;				//2_要保人
	private String insured_name;			//3_被保人
	private String po_sts_desc;				//4_保單狀態
	private String modx_name;				//5_繳別
	private String method_name;				//6_收費方式(保費繳法)
	private String trf_cnt;					//22_累積失敗次數
	
	private String po_issue_date;			//7_生效日期
	private String paid_to_date;			//10_應繳費日
	private String bill_to_date;			//9_通知單到期日
	private String gap_start_date;			//8_停效日期
	private String mode_prem;				//11_當期保費
	private String prem_susp;				//12_溢/欠繳
	private String div_susp;				//13_紅利金額
	
	private String client_name;				//15_委託人姓名
	private String client_id;				//16_委託人ID
	private String client_kind;				//14_委託對象
//	private String bank_id;
	private String bank_name;				//18_轉帳銀行
	private String account_no;				//19_帳號
	private String bank_paid_date;			//20_帳單日
	private String proxy_sts_name;			//21_委託書狀態
	
	private String accu_return_amt;			//24_回饋分享金
//	private String method;

	public PremBill(HashMap<String, String> hsmp) {
		result_ind = (hsmp.get("r_result_ind") == null) ? "" : hsmp.get(
			"r_result_ind").trim();
		policy_no = (hsmp.get("r_policy_no") == null) ? "" : hsmp.get(
			"r_policy_no").trim();
		owner_name = (hsmp.get("r_owner_name") == null) ? "" : hsmp.get(
			"r_owner_name").trim();
		insured_name = (hsmp.get("r_insured_name") == null) ? "" : hsmp.get(
			"r_insured_name").trim();
		po_sts_desc = (hsmp.get("r_po_sts_desc") == null) ? "" : hsmp.get(
			"r_po_sts_desc").trim();
		modx_name = (hsmp.get("r_modx_name") == null) ? "" : hsmp.get(
			"r_modx_name").trim();
		method_name = (hsmp.get("r_method_name") == null) ? "" : hsmp.get(
			"r_method_name").trim();
		trf_cnt = (hsmp.get("r_trf_cnt") == null) ? "" : hsmp.get(
			"r_trf_cnt").trim();
		
		po_issue_date = (hsmp.get("r_po_issue_date") == null) ? "" : hsmp.get(
			"r_po_issue_date").trim();
		paid_to_date = (hsmp.get("r_paid_to_date") == null) ? "" : hsmp.get(
			"r_paid_to_date").trim();
		bill_to_date = (hsmp.get("r_bill_to_date") == null) ? "" : hsmp.get(
			"r_bill_to_date").trim();
		gap_start_date = (hsmp.get("r_gap_start_date") == null) ? "" : hsmp.get(
			"r_gap_start_date").trim();
		mode_prem = (hsmp.get("r_mode_prem") == null) ? "" : hsmp.get(
			"r_mode_prem").trim();
		prem_susp = (hsmp.get("r_prem_susp") == null) ? "" : hsmp.get(
			"r_prem_susp").trim();
		div_susp = (hsmp.get("r_div_susp") == null) ? "" : hsmp.get(
			"r_div_susp").trim();
		
		client_name = (hsmp.get("r_client_name") == null) ? "" : hsmp.get(
			"r_client_name").trim();
		client_id = (hsmp.get("r_client_id") == null) ? "" : hsmp.get(
			"r_client_id").trim();
		client_kind = (hsmp.get("r_client_king") == null) ? "" : hsmp.get(
			"r_client_king").trim();
		bank_name = (hsmp.get("r_bank_name") == null) ? "" : hsmp.get(
			"r_bank_name").trim();
		account_no = (hsmp.get("r_account_no") == null) ? "" : hsmp.get(
			"r_account_no").trim();
		bank_paid_date = (hsmp.get("r_bank_paid_date") == null) ? "" : hsmp.get(
			"r_bank_paid_date").trim();
		proxy_sts_name = (hsmp.get("r_proxy_sts_name") == null) ? "" : hsmp.get(
			"r_proxy_sts_name").trim();
		
		accu_return_amt = (hsmp.get("r_accu_return_amt") == null) ? "" : hsmp.get(
			"r_accu_return_amt").trim();
	}

	public String[] getValues(int type) {
		ArrayList<String> valueList = new ArrayList<String>();

		switch (type) {
			case 1:
				valueList.add(policy_no);
				valueList.add(owner_name);
				valueList.add(insured_name);
				valueList.add(po_sts_desc);
				valueList.add(modx_name);
				valueList.add(method_name);
				valueList.add(trf_cnt);
				break;
			case 2:
				valueList.add(po_issue_date);
				valueList.add(paid_to_date);
				valueList.add(bill_to_date);
				valueList.add(gap_start_date);
				valueList.add(mode_prem);
				valueList.add(prem_susp);
				valueList.add(div_susp);
				valueList.add(accu_return_amt);
				break;
			case 3:
				valueList.add(client_name);
				valueList.add(client_id);
				valueList.add(client_kind);
				valueList.add(bank_name);
				valueList.add(account_no);
				valueList.add(bank_paid_date);
				valueList.add(proxy_sts_name);
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

	public String getOwner_name() {
		return owner_name;
	}

	public void setOwner_name(String owner_name) {
		this.owner_name = owner_name;
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

	public String getModx_name() {
		return modx_name;
	}

	public void setModx_name(String modx_name) {
		this.modx_name = modx_name;
	}

	public String getMethod_name() {
		return method_name;
	}

	public void setMethod_name(String method_name) {
		this.method_name = method_name;
	}

	public String getTrf_cnt() {
		return trf_cnt;
	}

	public void setTrf_cnt(String trf_cnt) {
		this.trf_cnt = trf_cnt;
	}

	public String getPo_issue_date() {
		return po_issue_date;
	}

	public void setPo_issue_date(String po_issue_date) {
		this.po_issue_date = po_issue_date;
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

	public String getMode_prem() {
		return mode_prem;
	}

	public void setMode_prem(String mode_prem) {
		this.mode_prem = mode_prem;
	}

	public String getPrem_susp() {
		return prem_susp;
	}

	public void setPrem_susp(String prem_susp) {
		this.prem_susp = prem_susp;
	}

	public String getDiv_susp() {
		return div_susp;
	}

	public void setDiv_susp(String div_susp) {
		this.div_susp = div_susp;
	}

	public String getClient_name() {
		return client_name;
	}

	public void setClient_name(String client_name) {
		this.client_name = client_name;
	}

	public String getClient_id() {
		return client_id;
	}

	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}

	public String getClient_kind() {
		return client_kind;
	}

	public void setClient_kind(String client_kind) {
		this.client_kind = client_kind;
	}

	public String getBank_name() {
		return bank_name;
	}

	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}

	public String getAccount_no() {
		return account_no;
	}

	public void setAccount_no(String account_no) {
		this.account_no = account_no;
	}

	public String getBank_paid_date() {
		return bank_paid_date;
	}

	public void setBank_paid_date(String bank_paid_date) {
		this.bank_paid_date = bank_paid_date;
	}

	public String getProxy_sts_name() {
		return proxy_sts_name;
	}

	public void setProxy_sts_name(String proxy_sts_name) {
		this.proxy_sts_name = proxy_sts_name;
	}

	public String getAccu_return_amt() {
		return accu_return_amt;
	}

	public void setAccu_return_amt(String accu_return_amt) {
		this.accu_return_amt = accu_return_amt;
	}
}