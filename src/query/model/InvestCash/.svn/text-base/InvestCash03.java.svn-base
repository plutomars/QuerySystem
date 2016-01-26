package query.model.InvestCash;

import java.util.ArrayList;
import java.util.HashMap;
/**
 * 
 * @author 陳冠瑜
 * 
 */
public class InvestCash03 { 
	
	private String result_ind;
	private String target_prem;  //保費目標/基本
	private String excess_prem;  //保費 額外
	private String invest_prem;  //保費 投資
	private String term_prem;    //壽險保費
	private String rider_prem;   //附約保費
	private String r_due_date_to; // 目標保費堆疊終日

	public InvestCash03() {
	}

	public void setValues(HashMap<String, String> hsmp) {
		result_ind = (hsmp.get("r_result_ind") == null) ? "" : hsmp.get(
				"r_result_ind").trim();
		target_prem = (hsmp.get("r_target_prem") == null) ? "" : hsmp.get(
				"r_target_prem").trim();
		excess_prem = (hsmp.get("r_excess_prem") == null) ? "" : hsmp.get(
				"r_excess_prem").trim();
		invest_prem = (hsmp.get("r_invest_prem") == null) ? "" : hsmp.get(
				"r_invest_prem").trim();
		term_prem = (hsmp.get("r_term_prem") == null) ? "" : hsmp.get(
				"r_term_prem").trim();
		rider_prem = (hsmp.get("r_rider_prem") == null) ? "" : hsmp.get(
				"r_rider_prem").trim();
		r_due_date_to = (hsmp.get("r_due_date_to") == null) ? "" : hsmp.get(
				"r_due_date_to").trim();
	}

	public String[] getValues(int type) {
		ArrayList<String> valueList = new ArrayList<String>();

		switch (type) {
		case 1:
			valueList.add(target_prem);
			valueList.add(excess_prem);
			valueList.add(invest_prem);
			valueList.add(term_prem);
			valueList.add(rider_prem);
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

	public String getTarget_prem() {
		return target_prem;
	}

	public void setTarget_prem(String target_prem) {
		this.target_prem = target_prem;
	}

	public String getExcess_prem() {
		return excess_prem;
	}

	public void setExcess_prem(String excess_prem) {
		this.excess_prem = excess_prem;
	}

	public String getInvest_prem() {
		return invest_prem;
	}

	public void setInvest_prem(String invest_prem) {
		this.invest_prem = invest_prem;
	}

	public String getTerm_prem() {
		return term_prem;
	}

	public void setTerm_prem(String term_prem) {
		this.term_prem = term_prem;
	}

	public String getRider_prem() {
		return rider_prem;
	}

	public void setRider_prem(String rider_prem) {
		this.rider_prem = rider_prem;
	}

	public String getR_due_date_to() {
		return r_due_date_to;
	}

	public void setR_due_date_to(String r_due_date_to) {
		this.r_due_date_to = r_due_date_to;
	}
}
