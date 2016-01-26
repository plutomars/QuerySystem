package query.model.InvestGoal;

import java.util.HashMap;

public class InvestGoal03 {
	private String r_result_ind;
	private String r_seq;
	private String r_invs_code;
	private String r_invs_name;
	private String r_invs_units;
	private String r_invs_value;
	private String r_invs_amt_nt;
	private String r_invs_avg_cost;
	private String r_invs_amt_cost;
	private String r_invs_invs_rate;
	private String r_invs_currency;
	private String r_dividend_calc;

	public InvestGoal03(HashMap<String, String> hsmp) {
		r_result_ind = (hsmp.get("r_result_ind") == null) ? "" : hsmp.get(
				"r_result_ind").trim();
		r_seq = (hsmp.get("r_seq") == null) ? "" : hsmp.get("r_seq").trim();
		r_invs_code = (hsmp.get("r_invs_code") == null) ? "" : hsmp.get(
				"r_invs_code").trim();
		r_invs_name = (hsmp.get("r_invs_name") == null) ? "" : hsmp.get(
				"r_invs_name").trim();
		r_invs_units = (hsmp.get("r_invs_units") == null) ? "" : hsmp.get(
				"r_invs_units").trim();
		r_invs_value = (hsmp.get("r_invs_value") == null) ? "" : hsmp.get(
				"r_invs_value").trim();
		
		r_invs_amt_nt = (hsmp.get("r_invs_amt_nt") == null) ? "" : hsmp.get(
				"r_invs_amt_nt").trim();
		r_invs_avg_cost = (hsmp.get("r_invs_avg_cost") == null) ? "" : hsmp.get(
				"r_invs_avg_cost").trim();
		r_invs_amt_cost = (hsmp.get("r_invs_amt_cost") == null) ? "" : hsmp.get(
				"r_invs_amt_cost").trim();
		r_invs_invs_rate = (hsmp.get("r_invs_invs_rate") == null) ? "" : hsmp.get(
				"r_invs_invs_rate").trim();
		r_invs_currency = (hsmp.get("r_invs_currency") == null) ? "" : hsmp.get(
				"r_invs_currency").trim();
		r_dividend_calc = (hsmp.get("r_dividend_calc") == null) ? "" : hsmp.get(
				"r_dividend_calc").trim();
	}

	public String getR_result_ind() {
		return r_result_ind;
	}

	public void setR_result_ind(String r_result_ind) {
		this.r_result_ind = r_result_ind;
		if (this.r_result_ind.equals("0")==false)
			   JOptionPaneshowMessageDialog(null, "查詢條件有誤cc000s:"+this.r_result_ind);

	}

	private void JOptionPaneshowMessageDialog(Object object, String string) {
		// TODO Auto-generated method stub
		
	}

	public String getR_seq() {
		return r_seq;
	}

	public void setR_seq(String r_seq) {
		this.r_seq = r_seq;
	}

	public String getR_invs_code() {
		return r_invs_code;
	}

	public void setR_invs_code(String r_invs_code) {
		this.r_invs_code = r_invs_code;
	}

	public String getR_invs_name() {
		return r_invs_name;
	}

	public void setR_invs_name(String r_invs_name) {
		this.r_invs_name = r_invs_name;
	}

	public String getR_invs_units() {
		return r_invs_units;
	}

	public void setR_invs_units(String r_invs_units) {
		this.r_invs_units = r_invs_units;
	}

	public String getR_invs_value() {
		return r_invs_value;
	}

	public void setR_invs_value(String r_invs_value) {
		this.r_invs_value = r_invs_value;
	}

	public String getR_invs_amt_nt() {
		return r_invs_amt_nt;
	}

	public void setR_invs_amt_nt(String r_invs_amt_nt) {
		this.r_invs_amt_nt = r_invs_amt_nt;
	}

	public String getR_invs_avg_cost() {
		return r_invs_avg_cost;
	}

	public void setR_invs_avg_cost(String r_invs_avg_cost) {
		this.r_invs_avg_cost = r_invs_avg_cost;
	}

	public String getR_invs_amt_cost() {
		return r_invs_amt_cost;
	}

	public void setR_invs_amt_cost(String r_invs_amt_cost) {
		this.r_invs_amt_cost = r_invs_amt_cost;
	}

	public String getR_invs_invs_rate() {
		return r_invs_invs_rate;
	}

	public void setR_invs_invs_rate(String r_invs_invs_rate) {
		this.r_invs_invs_rate = r_invs_invs_rate;
	}

	public String getR_invs_currency() {
		return r_invs_currency;
	}

	public void setR_invs_currency(String r_invs_currency) {
		this.r_invs_currency = r_invs_currency;
	}

	public String getR_dividend_calc() {
		return r_dividend_calc;
	}

	public void setR_dividend_calc(String r_dividend_calc) {
		this.r_dividend_calc = r_dividend_calc;
	}
}
