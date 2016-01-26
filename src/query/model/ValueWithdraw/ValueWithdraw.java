package query.model.ValueWithdraw;

import java.util.ArrayList;
import java.util.HashMap;

import query.model.AbstractModelObject;
/**
 * 
 * @author 陳冠瑜
 * 
 */
public class ValueWithdraw extends AbstractModelObject {
	private String result_ind; // 查詢結果
	private String policy_no; // 保單號碼
	private String tran_date; // 作業日期
	private String last_accu_amt; // 作業前累積本金
	private String last_misc_ac_amt; // 作業前發單前帳戶本金
	private String last_ac_bal_int; // 作業前應計利息
	private String accu_amt; // 作業後累積本金
	private String misc_accu_amt; // 作業後發單前帳戶本金
	private String accu_bal_int; // 作業後應計利息

	private String entry_no; // 登錄序號
	private String ansv_proc_ind; // 處理狀況
	private String proc_ind_desc; // 處理狀況
	private String this_int; // 本次計算利息
	private String diff_accu_amt; // 變動本金
	private String front_charge_amt; // 附加費用
	private String diff_int; // 使用利息
	private String misc_susp; // 預收保費
	private String surd_charge_amt; // 解約費用

	public ValueWithdraw(HashMap<String, String> hsmp) {
		result_ind = (hsmp.get("r_result_ind") == null) ? "" : hsmp.get(
				"r_result_ind").trim();
		policy_no = (hsmp.get("r_policy_no") == null) ? "" : hsmp.get(
				"r_policy_no").trim();
		tran_date = (hsmp.get("r_tran_date") == null) ? "" : hsmp.get(
				"r_tran_date").trim();
		last_accu_amt = (hsmp.get("r_last_accu_amt") == null) ? "" : hsmp.get(
				"r_last_accu_amt").trim();
		last_misc_ac_amt = (hsmp.get("r_last_misc_ac_amt") == null) ? "": hsmp.get(
				"r_last_misc_ac_amt").trim();
		last_ac_bal_int = (hsmp.get("r_last_ac_bal_int") == null) ? "" : hsmp.get(
				"r_last_ac_bal_int").trim();
		accu_amt = (hsmp.get("r_accu_amt") == null) ? "" : hsmp.get(
				"r_accu_amt").trim();
		misc_accu_amt = (hsmp.get("r_misc_accu_amt") == null) ? "" : hsmp.get(
				"r_misc_accu_amt").trim();
		accu_bal_int = (hsmp.get("r_accu_bal_int") == null) ? "" : hsmp.get(
				"r_accu_bal_int").trim();

		entry_no = (hsmp.get("r_entry_no") == null) ? "" : hsmp.get(
				"r_entry_no").trim();
		ansv_proc_ind = (hsmp.get("r_ansv_proc_ind") == null) ? "" : hsmp.get(
				"r_ansv_proc_ind").trim();
		proc_ind_desc = (hsmp.get("r_proc_ind_desc") == null) ? "" : hsmp.get(
				"r_proc_ind_desc").trim();
		this_int = (hsmp.get("r_this_int") == null) ? "" : hsmp.get(
				"r_this_int").trim();
		diff_accu_amt = (hsmp.get("r_diff_accu_amt") == null) ? "" : hsmp.get(
				"r_diff_accu_amt").trim();
		front_charge_amt = (hsmp.get("r_front_charge_amt") == null) ? "" : hsmp.get(
				"r_front_charge_amt").trim();
		diff_int = (hsmp.get("r_diff_int") == null) ? "" : hsmp.get(
				"r_diff_int").trim();
		misc_susp = (hsmp.get("r_misc_susp") == null) ? "" : hsmp.get(
				"r_misc_susp").trim();
		surd_charge_amt = (hsmp.get("r_surd_charge_amt") == null) ? "" : hsmp.get(
				"r_surd_charge_amt").trim();
	}

	public String[] getValues(int type) {
		ArrayList<String> valueList = new ArrayList<String>();

		switch (type) {
		case 1:
			valueList.add(entry_no);
			valueList.add(ansv_proc_ind + proc_ind_desc);
			valueList.add(this_int);
			valueList.add(diff_accu_amt);
			break;
		case 2:
			valueList.add(front_charge_amt);
			valueList.add(diff_int);
			valueList.add(misc_susp);
			valueList.add(surd_charge_amt);
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

	public String getTran_date() {
		return tran_date;
	}

	public void setTran_date(String tran_date) {
		this.tran_date = tran_date;
	}

	public String getLast_accu_amt() {
		return last_accu_amt;
	}

	public void setLast_accu_amt(String last_accu_amt) {
		this.last_accu_amt = last_accu_amt;
	}

	public String getLast_misc_ac_amt() {
		return last_misc_ac_amt;
	}

	public void setLast_misc_ac_amt(String last_misc_amt) {
		this.last_misc_ac_amt = last_misc_amt;
	}

	public String getLast_ac_bal_int() {
		return last_ac_bal_int;
	}

	public void setLast_ac_bal_int(String last_ac_bal_int) {
		this.last_ac_bal_int = last_ac_bal_int;
	}

	public String getAccu_amt() {
		return accu_amt;
	}

	public void setAccu_amt(String accu_amt) {
		this.accu_amt = accu_amt;
	}

	public String getMisc_accu_amt() {
		return misc_accu_amt;
	}

	public void setMisc_accu_amt(String misc_accu_amt) {
		this.misc_accu_amt = misc_accu_amt;
	}

	public String getAccu_bal_int() {
		return accu_bal_int;
	}

	public void setAccu_bal_int(String accu_bal_int) {
		this.accu_bal_int = accu_bal_int;
	}

	public String getEntry_no() {
		return entry_no;
	}

	public void setEntry_no(String entry_no) {
		this.entry_no = entry_no;
	}

	public String getAnsv_proc_ind() {
		return ansv_proc_ind;
	}

	public void setAnsv_proc_ind(String ansv_proc_ind) {
		this.ansv_proc_ind = ansv_proc_ind;
	}

	public String getProc_ind_desc() {
		return proc_ind_desc;
	}

	public void setProc_ind_desc(String proc_ind_desc) {
		this.proc_ind_desc = proc_ind_desc;
	}
	public String getThis_int() {
		return this_int;
	}

	public void setThis_int(String this_int) {
		this.this_int = this_int;
	}

	public String getDiff_accu_amt() {
		return diff_accu_amt;
	}

	public void setDiff_accu_amt(String diff_accu_amt) {
		this.diff_accu_amt = diff_accu_amt;
	}

	public String getFront_charge_amt() {
		return front_charge_amt;
	}

	public void setFront_charge_amt(String front_charge_amt) {
		this.front_charge_amt = front_charge_amt;
	}

	public String getDiff_int() {
		return diff_int;
	}

	public void setDiff_int(String diff_int) {
		this.diff_int = diff_int;
	}

	public String getMisc_susp() {
		return misc_susp;
	}

	public void setMisc_susp(String misc_susp) {
		this.misc_susp = misc_susp;
	}

	public String getSurd_charge_amt() {
		return surd_charge_amt;
	}

	public void setSurd_charge_amt(String surd_charge_amt) {
		this.surd_charge_amt = surd_charge_amt;
	}
}
