package query.model.PosNotice;

import java.util.ArrayList;
import java.util.HashMap;

import query.model.AbstractModelObject;
/**
 * @author cychu
 * 
 * @version 1.0<br/>
 * 			100/09/07<br/>
 * 			照會繳費(JavaBean)
 * 
 * @since 1.0
 */
public class PosNotice01 extends AbstractModelObject {
	private String result_ind;				//0_查詢結果
	private String policy_no;				//1_保單號碼
	private String po_chg_rece_no;			//2_受理號碼
	private String notice_seq;				//4_照會序號
	
	private String access_name;				//3_承辦人姓名
	private String notify_date;				//5_照會日期
	private String act_return_date;			//6_回覆日期
	private String po_chg_pay_ind;			//7_契約變更繳費指示(申請項目)
	private String po_chg_uw_date;			//8_契約變更核保通過日
	private String po_chg_due_date;			//9_契約變更繳費截止日

	private String prem_primary_lf;			//10_主契約保費
	private String prem_rider_en;			//11_壽險附約保費
	private String prem_primary_hr;			//12_健康險保費
	private String prem_primary_pa;			//13_傷害險保費
	private String pv_amt;					//14_保單價值準備金
	private String prem_delay_int;			//15_延繳保費利息
	private String loan_return_this;		//16_償還借款本息
	private String apl_return_this;			//17_償還自動墊繳本息
	private String amt_return_this;			//16+17
	private String debt_return_this;		//18_償還欠繳金額
	
	private String paid_to_date;			//19_繳費終日
	private String mode_prem;				//22_變更前繳別保費(到期續期保費)
	private String cv_amt;					//20_解約金
	private String prem_rider_tr;			//21_紅利退費
	private String po_chg_pay_total;		//23_契變應收小計
	private String prem_susp;				//24_暫收款(暫收契變+暫收復效)
	private String grand_total;				//25_合計應繳金額
	private String po_chg_susp;				//26_變更後繳別
	private String reinstate_susp;			//27_變更後繳別保費
	
	public PosNotice01() {
	}
	
	public PosNotice01(HashMap<String, String> hsmp) {
		result_ind = (hsmp.get("r_result_ind") == null) ? "" : hsmp.get(
			"r_result_ind").trim();
		policy_no = (hsmp.get("r_policy_no") == null) ? "" : hsmp.get(
			"r_policy_no").trim();
		po_chg_rece_no = (hsmp.get("r_po_chg_rece_no") == null) ? "" : hsmp.get(
			"r_po_chg_rece_no").trim();
		notice_seq = (hsmp.get("r_notice_seq") == null) ? "" : hsmp.get(
			"r_notice_seq").trim();
		
		access_name = (hsmp.get("r_access_name") == null) ? "" : hsmp.get(
			"r_access_name").trim();
		notify_date = (hsmp.get("r_notify_date") == null) ? "" : hsmp.get(
			"r_notify_date").trim();
		act_return_date = (hsmp.get("r_act_return_date") == null) ? "" : hsmp.get(
			"r_act_return_date").trim();
		po_chg_pay_ind = (hsmp.get("r_po_chg_pay_ind") == null) ? "" : hsmp.get(
			"r_po_chg_pay_ind").trim();
		po_chg_uw_date = (hsmp.get("r_po_chg_uw_date") == null) ? "" : hsmp.get(
			"r_po_chg_uw_date").trim();
		po_chg_due_date = (hsmp.get("r_po_chg_due_date") == null) ? "" : hsmp.get(
			"r_po_chg_due_date").trim();
		
		prem_primary_lf = (hsmp.get("r_prem_primary_lf") == null) ? "" : hsmp.get(
			"r_prem_primary_lf").trim();
		prem_rider_en = (hsmp.get("r_prem_rider_en") == null) ? "" : hsmp.get(
			"r_prem_rider_en").trim();
		prem_primary_hr = (hsmp.get("r_prem_primary_hr") == null) ? "" : hsmp.get(
			"r_prem_primary_hr").trim();
		prem_primary_pa = (hsmp.get("r_prem_primary_pa") == null) ? "" : hsmp.get(
			"r_prem_primary_pa").trim();
		pv_amt = (hsmp.get("r_pv_amt") == null) ? "" : hsmp.get(
			"r_pv_amt").trim();
		prem_delay_int = (hsmp.get("r_prem_delay_int") == null) ? "" : hsmp.get(
			"r_prem_delay_int").trim();
		loan_return_this = (hsmp.get("r_loan_return_this") == null) ? "" : hsmp.get(
			"r_loan_return_this").trim();
		apl_return_this = (hsmp.get("r_apl_return_this") == null) ? "" : hsmp.get(
			"r_apl_return_this").trim();
		amt_return_this = Float.toString((Float.parseFloat(loan_return_this) 
						+ Float.parseFloat(apl_return_this)));
		debt_return_this = (hsmp.get("r_debt_return_this") == null) ? "" : hsmp.get(
			"r_debt_return_this").trim();
		
		paid_to_date = (hsmp.get("r_paid_to_date") == null) ? "" : hsmp.get(
			"r_paid_to_date").trim();
		mode_prem = (hsmp.get("r_mode_prem") == null) ? "" : hsmp.get(
			"r_mode_prem").trim();
		cv_amt = (hsmp.get("r_cv_amt") == null) ? "" : hsmp.get(
			"r_cv_amt").trim();
		prem_rider_tr = (hsmp.get("r_prem_rider_tr") == null) ? "" : hsmp.get(
			"r_prem_rider_tr").trim();
		po_chg_pay_total = (hsmp.get("r_po_chg_pay_total") == null) ? "" : hsmp.get(
			"r_po_chg_pay_total").trim();
		prem_susp = (hsmp.get("r_prem_susp") == null) ? "" : hsmp.get(
			"r_prem_susp").trim();
		grand_total = (hsmp.get("r_grand_total") == null) ? "" : hsmp.get(
			"r_grand_total").trim();
		po_chg_susp = (hsmp.get("r_po_chg_susp") == null) ? "" : hsmp.get(
			"r_po_chg_susp").trim();
		reinstate_susp = (hsmp.get("r_reinstate_susp") == null) ? "" : hsmp.get(
			"r_reinstate_susp").trim();
	}
	
	public String[] getValues(int type) {
		ArrayList<String> valueList = new ArrayList<String>();
		
		switch(type) {
			case 1:
				valueList.add(policy_no);
				valueList.add(po_chg_rece_no);
				valueList.add(access_name);
				valueList.add(notice_seq);
				valueList.add(notify_date);
				valueList.add(act_return_date);
				valueList.add(po_chg_pay_ind);
				valueList.add(po_chg_uw_date);
				valueList.add(po_chg_due_date);
				break;
			case 2:
				valueList.add(prem_primary_lf);
				valueList.add(prem_rider_en);
				valueList.add(prem_primary_hr);
				valueList.add(prem_primary_pa);
				valueList.add(pv_amt);
				valueList.add(prem_delay_int);
				valueList.add(amt_return_this);
				valueList.add(debt_return_this);
				break;
			case 3:
				valueList.add(paid_to_date);
				valueList.add(mode_prem);
				valueList.add(cv_amt);
				valueList.add(prem_rider_tr);
				valueList.add(po_chg_pay_total);
				valueList.add(prem_susp);
				valueList.add(grand_total);
				valueList.add(po_chg_susp);
				valueList.add(reinstate_susp);
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

	public String getPo_chg_rece_no() {
		return po_chg_rece_no;
	}

	public void setPo_chg_rece_no(String po_chg_rece_no) {
		String oldValue = this.po_chg_rece_no;
		this.po_chg_rece_no = po_chg_rece_no;
		firePropertyChange("po_chg_rece_no", oldValue, po_chg_rece_no);
	}

	public String getNotice_seq() {
		return notice_seq;
	}

	public void setNotice_seq(String notice_seq) {
		String oldValue = this.notice_seq;
		this.notice_seq = notice_seq;
		firePropertyChange("notice_seq", oldValue, notice_seq);
	}

	public String getAccess_name() {
		return access_name;
	}

	public void setAccess_name(String access_name) {
		this.access_name = access_name;
	}

	public String getNotify_date() {
		return notify_date;
	}

	public void setNotify_date(String notify_date) {
		this.notify_date = notify_date;
	}

	public String getAct_return_date() {
		return act_return_date;
	}

	public void setAct_return_date(String act_return_date) {
		this.act_return_date = act_return_date;
	}

	public String getPo_chg_pay_ind() {
		return po_chg_pay_ind;
	}

	public void setPo_chg_pay_ind(String po_chg_pay_ind) {
		this.po_chg_pay_ind = po_chg_pay_ind;
	}

	public String getPo_chg_uw_date() {
		return po_chg_uw_date;
	}

	public void setPo_chg_uw_date(String po_chg_uw_date) {
		this.po_chg_uw_date = po_chg_uw_date;
	}

	public String getPo_chg_due_date() {
		return po_chg_due_date;
	}

	public void setPo_chg_due_date(String po_chg_due_date) {
		this.po_chg_due_date = po_chg_due_date;
	}

	public String getPrem_primary_lf() {
		return prem_primary_lf;
	}

	public void setPrem_primary_lf(String prem_primary_lf) {
		this.prem_primary_lf = prem_primary_lf;
	}

	public String getPrem_rider_en() {
		return prem_rider_en;
	}

	public void setPrem_rider_en(String prem_rider_en) {
		this.prem_rider_en = prem_rider_en;
	}

	public String getPrem_primary_hr() {
		return prem_primary_hr;
	}

	public void setPrem_primary_hr(String prem_primary_hr) {
		this.prem_primary_hr = prem_primary_hr;
	}

	public String getPrem_primary_pa() {
		return prem_primary_pa;
	}

	public void setPrem_primary_pa(String prem_primary_pa) {
		this.prem_primary_pa = prem_primary_pa;
	}

	public String getPv_amt() {
		return pv_amt;
	}

	public void setPv_amt(String pv_amt) {
		this.pv_amt = pv_amt;
	}

	public String getPrem_delay_int() {
		return prem_delay_int;
	}

	public void setPrem_delay_int(String prem_delay_int) {
		this.prem_delay_int = prem_delay_int;
	}

	public String getLoan_return_this() {
		return loan_return_this;
	}

	public void setLoan_return_this(String loan_return_this) {
		this.loan_return_this = loan_return_this;
	}

	public String getApl_return_this() {
		return apl_return_this;
	}

	public void setApl_return_this(String apl_return_this) {
		this.apl_return_this = apl_return_this;
	}

	public String getAmt_return_this() {
		return amt_return_this;
	}

	public void setAmt_return_this(String amt_return_this) {
		this.amt_return_this = amt_return_this;
	}

	public String getDebt_return_this() {
		return debt_return_this;
	}

	public void setDebt_return_this(String debt_return_this) {
		this.debt_return_this = debt_return_this;
	}

	public String getPaid_to_date() {
		return paid_to_date;
	}

	public void setPaid_to_date(String paid_to_date) {
		this.paid_to_date = paid_to_date;
	}

	public String getMode_prem() {
		return mode_prem;
	}

	public void setMode_prem(String mode_prem) {
		this.mode_prem = mode_prem;
	}

	public String getCv_amt() {
		return cv_amt;
	}

	public void setCv_amt(String cv_amt) {
		this.cv_amt = cv_amt;
	}

	public String getPrem_rider_tr() {
		return prem_rider_tr;
	}

	public void setPrem_rider_tr(String prem_rider_tr) {
		this.prem_rider_tr = prem_rider_tr;
	}

	public String getPo_chg_pay_total() {
		return po_chg_pay_total;
	}

	public void setPo_chg_pay_total(String po_chg_pay_total) {
		this.po_chg_pay_total = po_chg_pay_total;
	}

	public String getPrem_susp() {
		return prem_susp;
	}

	public void setPrem_susp(String prem_susp) {
		this.prem_susp = prem_susp;
	}

	public String getGrand_total() {
		return grand_total;
	}

	public void setGrand_total(String grand_total) {
		this.grand_total = grand_total;
	}

	public String getPo_chg_susp() {
		return po_chg_susp;
	}

	public void setPo_chg_susp(String po_chg_susp) {
		this.po_chg_susp = po_chg_susp;
	}

	public String getReinstate_susp() {
		return reinstate_susp;
	}

	public void setReinstate_susp(String reinstate_susp) {
		this.reinstate_susp = reinstate_susp;
	}
}
