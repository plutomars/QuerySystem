package query.model.PremBill;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 
 * @author cychu
 * 
 * @version 1.1
 * 			104/04/16<br>
 * 			扣款明細(JavaBean)
 * 
 * @since 1.0
 */
public class PremBill01 {
	private String result_ind;				//0_查詢結果
	private String first_auto_ind;			//1_首期轉帳指示
	private String bank_date;				//2_銀行回覆日
	private String trf_type_name;			//3_轉帳類別
	private String trf_amt;					//4_扣款金額
	private String process_date;			//23_處理日
	private String err_code;				//5_錯誤代碼
	private String err_reason;				//6_錯誤代碼中文
	private String method_name;				//7_收費方式
	
	private String policy_no;				//8_保單號碼
	private String bill_date_from;			//9_送金單起日
	private String bill_date_to;			//10_送金單迄日
	private String bill_no;					//31_送金單號碼
	private String modx_sequence;			//11_繳次
	private String client_id;				//12_扣款人ID
	private String names;					//13_扣款人姓名
	
	private String bank_id;					//14_銀行代碼
	private String bank_name;				//15_銀行名稱
	private String card_name;				//17_發卡銀行
	private String branch_account;			//18_帳號/卡號
	private String disable_date;			//20_有效日期
	private String process_user;			//25_處理人員
	private String md_modify_ind;			//19_變更狀態
	
	//繳費通知
	private String mode_prem;				//27_當期保費(繳別保費)
	private String prem_susp;				//28_溢欠繳
	private String div_susp;				//29_紅利
	private String accu_return_amt;			//36_回饋分享金
	private String prem_delay_int;			//30_延滯息
	
	//後印送金單
	private String mode_prem_tot;			//32_繳別保費
	private String prem_susp_tot;			//33_溢欠繳
	private String div_susp_tot;			//34_紅利金額
	private String accu_return_tot;			//37_回饋分享金
	private String delay_int;				//35_延滯息
	
	public PremBill01(HashMap<String, String> hsmp) {
		result_ind = (hsmp.get("r_result_ind") == null) ? "" : hsmp.get(
			"r_result_ind").trim();
		first_auto_ind = (hsmp.get("r_first_auto_ind") == null) ? "" : hsmp.get(
			"r_first_auto_ind").trim();
		bank_date = (hsmp.get("r_bank_date") == null) ? "" : hsmp.get(
			"r_bank_date").trim();
		trf_type_name = (hsmp.get("r_trf_type_name") == null) ? "" : hsmp.get(
			"r_trf_type_name").trim();
		trf_amt = (hsmp.get("r_trf_amt") == null) ? "" : hsmp.get(
			"r_trf_amt").trim();
		process_date = (hsmp.get("r_process_date") == null) ? "" : hsmp.get(
			"r_process_date").trim();
		err_code = (hsmp.get("r_err_code") == null) ? "" : hsmp.get(
			"r_err_code").trim();
		err_reason = (hsmp.get("r_err_reason") == null) ? "" : hsmp.get(
			"r_err_reason").trim();
		method_name = (hsmp.get("r_method_name") == null) ? "" : hsmp.get(
			"r_method_name").trim();

		policy_no = (hsmp.get("r_policy_no") == null) ? "" : hsmp.get(
			"r_policy_no").trim();
		bill_date_from = (hsmp.get("r_bill_date_from") == null) ? "" : hsmp.get(
			"r_bill_date_from").trim();
		bill_date_to = (hsmp.get("r_bill_date_to") == null) ? "" : hsmp.get(
			"r_bill_date_to").trim();
		bill_no = (hsmp.get("r_bill_no") == null) ? "" : hsmp.get(
			"r_bill_no").trim();
		modx_sequence = (hsmp.get("r_modx_sequence") == null) ? "" : hsmp.get(
			"r_modx_sequence").trim();
		client_id = (hsmp.get("r_client_id") == null) ? "" : hsmp.get(
			"r_client_id").trim();
		names = (hsmp.get("r_names") == null) ? "" : hsmp.get(
			"r_names").trim();
		
		bank_id = (hsmp.get("r_bank_id") == null) ? "" : hsmp.get(
			"r_bank_id").trim();
		bank_name = (hsmp.get("r_bank_name") == null) ? "" : hsmp.get(
			"r_bank_name").trim();
		card_name = (hsmp.get("r_card_name") == null) ? "" : hsmp.get(
			"r_card_name").trim();
		branch_account = (hsmp.get("r_branch_account") == null) ? "" : hsmp.get(
			"r_branch_account").trim();
		disable_date = (hsmp.get("r_disable_date") == null) ? "" : hsmp.get(
			"r_disable_date").trim();
		process_user = (hsmp.get("r_process_user") == null) ? "" : hsmp.get(
			"r_process_user").trim();
		md_modify_ind = (hsmp.get("r_md_modify_ind") == null) ? "" : hsmp.get(
			"r_md_modify_ind").trim();
		
		mode_prem = (hsmp.get("r_mode_prem") == null) ? "" : hsmp.get(
			"r_mode_prem").trim();
		prem_susp = (hsmp.get("r_prem_susp") == null) ? "" : hsmp.get(
			"r_prem_susp").trim();
		div_susp = (hsmp.get("r_div_susp") == null) ? "" : hsmp.get(
			"r_div_susp").trim();
		accu_return_amt = (hsmp.get("r_accu_return_amt") == null) ? "" : hsmp.get(
			"r_accu_return_amt").trim();
		prem_delay_int = (hsmp.get("r_prem_delay_int") == null) ? "" : hsmp.get(
			"r_prem_delay_int").trim();
		
		mode_prem_tot = (hsmp.get("r_mode_prem_tot") == null) ? "" : hsmp.get(
			"r_mode_prem_tot").trim();
		prem_susp_tot = (hsmp.get("r_prem_susp_tot") == null) ? "" : hsmp.get(
			"r_prem_susp_tot").trim();
		div_susp_tot = (hsmp.get("r_div_susp_tot") == null) ? "" : hsmp.get(
			"r_div_susp_tot").trim();
		accu_return_tot = (hsmp.get("r_accu_return_tot") == null) ? "" : hsmp.get(
			"r_accu_return_tot").trim();
		delay_int = (hsmp.get("r_delay_int") == null) ? "" : hsmp.get(
			"r_delay_int").trim();	
	}
	
	public String[] getValues(int type) {
		ArrayList<String> valueList = new ArrayList<String>();

		switch (type) {
			case 1:
				valueList.add(policy_no);
				valueList.add(bill_date_from);
				valueList.add(bill_date_to);
				valueList.add(bill_no);
				valueList.add(modx_sequence);
				valueList.add(client_id);
				valueList.add(names);
				break;
			case 2:
				valueList.add(bank_name);
				valueList.add(card_name);
				valueList.add(branch_account);
				valueList.add(disable_date);
				valueList.add(process_date);
				valueList.add(process_user);
				valueList.add(md_modify_ind);
				break;
			case 3:
				valueList.add(mode_prem);
				valueList.add(prem_susp);
				valueList.add(div_susp);
				valueList.add(accu_return_amt);
				valueList.add(prem_delay_int);
				break;
			case 4:
				valueList.add(mode_prem_tot);
				valueList.add(prem_susp_tot);
				valueList.add(div_susp_tot);
				valueList.add(accu_return_tot);
				valueList.add(delay_int);
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

	public String getFirst_auto_ind() {
		return first_auto_ind;
	}

	public void setFirst_auto_ind(String first_auto_ind) {
		this.first_auto_ind = first_auto_ind;
	}

	public String getBank_date() {
		return bank_date;
	}

	public void setBank_date(String bank_date) {
		this.bank_date = bank_date;
	}

	public String getTrf_type_name() {
		return trf_type_name;
	}

	public void setTrf_type_name(String trf_type_name) {
		this.trf_type_name = trf_type_name;
	}

	public String getTrf_amt() {
		return trf_amt;
	}

	public void setTrf_amt(String trf_amt) {
		this.trf_amt = trf_amt;
	}

	public String getProcess_date() {
		return process_date;
	}

	public void setProcess_date(String process_date) {
		this.process_date = process_date;
	}

	public String getErr_code() {
		return err_code;
	}

	public void setErr_code(String err_code) {
		this.err_code = err_code;
	}

	public String getErr_reason() {
		return err_reason;
	}

	public void setErr_reason(String err_reason) {
		this.err_reason = err_reason;
	}

	public String getMethod_name() {
		return method_name;
	}

	public void setMethod_name(String method_name) {
		this.method_name = method_name;
	}

	public String getPolicy_no() {
		return policy_no;
	}

	public void setPolicy_no(String policy_no) {
		this.policy_no = policy_no;
	}

	public String getBill_date_from() {
		return bill_date_from;
	}

	public void setBill_date_from(String bill_date_from) {
		this.bill_date_from = bill_date_from;
	}

	public String getBill_date_to() {
		return bill_date_to;
	}

	public void setBill_date_to(String bill_date_to) {
		this.bill_date_to = bill_date_to;
	}

	public String getBill_no() {
		return bill_no;
	}

	public void setBill_no(String bill_no) {
		this.bill_no = bill_no;
	}

	public String getModx_sequence() {
		return modx_sequence;
	}

	public void setModx_sequence(String modx_sequence) {
		this.modx_sequence = modx_sequence;
	}

	public String getClient_id() {
		return client_id;
	}

	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}

	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	public String getBank_id() {
		return bank_id;
	}

	public void setBank_id(String bank_id) {
		this.bank_id = bank_id;
	}

	public String getBank_name() {
		return bank_name;
	}

	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}

	public String getCard_name() {
		return card_name;
	}

	public void setCard_name(String card_name) {
		this.card_name = card_name;
	}

	public String getBranch_account() {
		return branch_account;
	}

	public void setBranch_account(String branch_account) {
		this.branch_account = branch_account;
	}

	public String getDisable_date() {
		return disable_date;
	}

	public void setDisable_date(String disable_date) {
		this.disable_date = disable_date;
	}

	public String getProcess_user() {
		return process_user;
	}

	public void setProcess_user(String process_user) {
		this.process_user = process_user;
	}

	public String getMd_modify_ind() {
		return md_modify_ind;
	}

	public void setMd_modify_ind(String md_modify_ind) {
		this.md_modify_ind = md_modify_ind;
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

	public String getAccu_return_amt() {
		return accu_return_amt;
	}

	public void setAccu_return_amt(String accu_return_amt) {
		this.accu_return_amt = accu_return_amt;
	}

	public String getPrem_delay_int() {
		return prem_delay_int;
	}

	public void setPrem_delay_int(String prem_delay_int) {
		this.prem_delay_int = prem_delay_int;
	}

	public String getMode_prem_tot() {
		return mode_prem_tot;
	}

	public void setMode_prem_tot(String mode_prem_tot) {
		this.mode_prem_tot = mode_prem_tot;
	}

	public String getPrem_susp_tot() {
		return prem_susp_tot;
	}

	public void setPrem_susp_tot(String prem_susp_tot) {
		this.prem_susp_tot = prem_susp_tot;
	}

	public String getDiv_susp_tot() {
		return div_susp_tot;
	}

	public void setDiv_susp_tot(String div_susp_tot) {
		this.div_susp_tot = div_susp_tot;
	}

	public String getAccu_return_tot() {
		return accu_return_tot;
	}

	public void setAccu_return_tot(String accu_return_tot) {
		this.accu_return_tot = accu_return_tot;
	}

	public String getDelay_int() {
		return delay_int;
	}

	public void setDelay_int(String delay_int) {
		this.delay_int = delay_int;
	}
}
