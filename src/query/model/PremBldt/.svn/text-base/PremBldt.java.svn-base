package query.model.PremBldt;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 
 * @author cychu
 *
 * @version 1.0<br/>
 * 			101/04/11<br/>
 * 			送金記錄查詢－基本資料(JavaBean)
 * 
 * @since 1.0
 */
public class PremBldt {
	private String result_ind;				//0_查詢結果
	private String policy_no;				//1_保單號碼
	private String po_sts_desc;				//2_保單狀態描述
	private String po_issue_date;			//3_保單生效日
	private String i1_name;					//4_被保人姓名
	private String o1_name;					//5_要保人姓名
	private String modx_desc;				//6_繳法描述
	private String paid_to_date;			//7_應繳費日
	private String bill_to_date;			//8_送金到期日
	private String method_desc;				//9_收費方式描述
	private String mode_prem_h;				//10_本期保費(高保費折扣後)
	private String prem_susp;				//11_溢/欠繳
	private String prem_disc;				//12_折扣金額
	private String disc_deadline;			//13_折扣期限
	private String dividend;				//14_紅利金額
	private String gross_mode_prem;			//15_原始保費
	private String collector_id;			//16_收費代碼
	private String collector_name;			//17_收費員姓名
	private String collect_code;			//18_收費區域
	private String accu_return_amt;			//19_回饋分享金
	
	public PremBldt(HashMap<String, String> hsmp) {
		result_ind = (hsmp.get("r_result_ind") == null) ? "" : hsmp.get(
		"r_result_ind").trim();
		policy_no = (hsmp.get("r_policy_no") == null) ? "" : hsmp.get(
		"r_policy_no").trim();
		po_sts_desc = (hsmp.get("r_po_sts_desc") == null) ? "" : hsmp.get(
		"r_po_sts_desc").trim();
		po_issue_date = (hsmp.get("r_po_issue_date") == null) ? "" : hsmp.get(
		"r_po_issue_date").trim();
		i1_name = (hsmp.get("r_i1_name") == null) ? "" : hsmp.get(
		"r_i1_name").trim();
		o1_name = (hsmp.get("r_o1_name") == null) ? "" : hsmp.get(
		"r_o1_name").trim();
		modx_desc = (hsmp.get("r_modx_desc") == null) ? "" : hsmp.get(
		"r_modx_desc").trim();
		paid_to_date = (hsmp.get("r_paid_to_date") == null) ? "" : hsmp.get(
		"r_paid_to_date").trim();
		bill_to_date = (hsmp.get("r_bill_to_date") == null) ? "" : hsmp.get(
		"r_bill_to_date").trim();
		method_desc = (hsmp.get("r_method_desc") == null) ? "" : hsmp.get(
		"r_method_desc").trim();
		mode_prem_h = (hsmp.get("r_mode_prem_h") == null) ? "" : hsmp.get(
		"r_mode_prem_h").trim();
		prem_susp = (hsmp.get("r_prem_susp") == null) ? "" : hsmp.get(
		"r_prem_susp").trim();
		prem_disc = (hsmp.get("r_prem_disc") == null) ? "" : hsmp.get(
		"r_prem_disc").trim();
		disc_deadline = (hsmp.get("r_disc_deadline") == null) ? "" : hsmp.get(
		"r_disc_deadline").trim();
		dividend = (hsmp.get("r_dividend") == null) ? "" : hsmp.get(
		"r_dividend").trim();
		gross_mode_prem = (hsmp.get("r_gross_mode_prem") == null) ? "" : hsmp.get(
		"r_gross_mode_prem").trim();
		collector_id = (hsmp.get("r_collector_id") == null) ? "" : hsmp.get(
		"r_collector_id").trim();
		collector_name = (hsmp.get("r_collector_name") == null) ? "" : hsmp.get(
		"r_collector_name").trim();
		collect_code = (hsmp.get("r_collect_code") == null) ? "" : hsmp.get(
		"r_collect_code").trim();
		accu_return_amt= (hsmp.get("r_accu_return_amt") == null) ? "" : hsmp.get(
		"r_accu_return_amt").trim();
	}
	
	public String[] getValues(int type) {
		ArrayList<String> valueList = new ArrayList<String>();

		switch (type) {
			case 1:
				valueList.add(policy_no);
				valueList.add(po_sts_desc);
				valueList.add(po_issue_date);
				valueList.add(i1_name);
				valueList.add(o1_name);
				valueList.add(modx_desc);
				valueList.add(method_desc);
				break;
			case 2:
				valueList.add(paid_to_date);
				valueList.add(bill_to_date);
				valueList.add(mode_prem_h);
				valueList.add(gross_mode_prem);
				valueList.add(prem_susp);
				valueList.add(prem_disc);
				break;
			case 3:
				valueList.add(dividend);
				valueList.add(accu_return_amt);
				valueList.add(collector_id);
				valueList.add(collector_name);
				valueList.add(collect_code);
				valueList.add(disc_deadline);
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

	public String getPo_sts_desc() {
		return po_sts_desc;
	}

	public void setPo_sts_desc(String po_sts_desc) {
		this.po_sts_desc = po_sts_desc;
	}

	public String getPo_issue_date() {
		return po_issue_date;
	}

	public void setPo_issue_date(String po_issue_date) {
		this.po_issue_date = po_issue_date;
	}

	public String getI1_name() {
		return i1_name;
	}

	public void setI1_name(String i1_name) {
		this.i1_name = i1_name;
	}

	public String getO1_name() {
		return o1_name;
	}

	public void setO1_name(String o1_name) {
		this.o1_name = o1_name;
	}

	public String getModx_desc() {
		return modx_desc;
	}

	public void setModx_desc(String modx_desc) {
		this.modx_desc = modx_desc;
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

	public String getMethod_desc() {
		return method_desc;
	}

	public void setMethod_desc(String method_desc) {
		this.method_desc = method_desc;
	}

	public String getMode_prem_h() {
		return mode_prem_h;
	}

	public void setMode_prem_h(String mode_prem_h) {
		this.mode_prem_h = mode_prem_h;
	}

	public String getPrem_susp() {
		return prem_susp;
	}

	public void setPrem_susp(String prem_susp) {
		this.prem_susp = prem_susp;
	}

	public String getPrem_disc() {
		return prem_disc;
	}

	public void setPrem_disc(String prem_disc) {
		this.prem_disc = prem_disc;
	}

	public String getDisc_deadline() {
		return disc_deadline;
	}

	public void setDisc_deadline(String disc_deadline) {
		this.disc_deadline = disc_deadline;
	}

	public String getDividend() {
		return dividend;
	}

	public void setDividend(String dividend) {
		this.dividend = dividend;
	}

	public String getGross_mode_prem() {
		return gross_mode_prem;
	}

	public void setGross_mode_prem(String gross_mode_prem) {
		this.gross_mode_prem = gross_mode_prem;
	}

	public String getCollector_id() {
		return collector_id;
	}

	public void setCollector_id(String collector_id) {
		this.collector_id = collector_id;
	}

	public String getCollector_name() {
		return collector_name;
	}

	public void setCollector_name(String collector_name) {
		this.collector_name = collector_name;
	}

	public String getCollect_code() {
		return collect_code;
	}

	public void setCollect_code(String collect_code) {
		this.collect_code = collect_code;
	}

	public String getAccu_return_amt() {
		return accu_return_amt;
	}

	public void setAccu_return_amt(String accu_return_amt) {
		this.accu_return_amt = accu_return_amt;
	}
}
