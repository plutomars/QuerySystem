package query.model.InvestGoal;

import java.util.HashMap;

//修    改: 102.06.05 新增投資標的報酬率上下限 by 冠瑜
/**
 * @author F1256819
 * @version 103/09/12 新增標的原幣價值
 */
public class InvestGoal02 {
	private String r_result_ind;
	private String r_seq;
	private String r_invs_code;
	private String r_invs_name;
	private String r_invs_units;
	private String r_invs_value;
	private String r_invs_amt;
	private String r_invs_amt_nt;
	private String r_invs_avg_cost;
	private String r_invs_amt_cost;
	private String r_invs_invs_rate;
	private String r_invs_currency;
	private String r_dividend_calc;
	private String r_invs_upper;
	private String r_invs_lower;
	private String r_invs_risk_degree; // SR140100176 風險屬性 by epf

	public InvestGoal02(HashMap<String, String> hsmp) {
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
		// 新增原幣標的價值
		r_invs_amt = (hsmp.get("r_invs_amt") == null) ? "" : hsmp.get(
				"r_invs_amt").trim();
		r_invs_avg_cost = (hsmp.get("r_invs_avg_cost") == null) ? "" : hsmp
				.get("r_invs_avg_cost").trim();
		r_invs_amt_cost = (hsmp.get("r_invs_amt_cost") == null) ? "" : hsmp
				.get("r_invs_amt_cost").trim();
		r_invs_invs_rate = (hsmp.get("r_invs_invs_rate") == null) ? "" : hsmp
				.get("r_invs_invs_rate").trim();
		r_invs_currency = (hsmp.get("r_invs_currency") == null) ? "" : hsmp
				.get("r_invs_currency").trim();
		r_dividend_calc = (hsmp.get("r_dividend_calc") == null) ? "" : hsmp
				.get("r_dividend_calc").trim();
		r_invs_upper = (hsmp.get("r_invs_upper") == null) ? "" : hsmp.get(
				"r_invs_upper").trim();
		r_invs_lower = (hsmp.get("r_invs_lower") == null) ? "" : hsmp.get(
				"r_invs_lower").trim();
		r_invs_risk_degree = (hsmp.get("r_invs_risk_degree") == null) ? ""
				: hsmp.get("r_invs_risk_degree").trim();
	}

	public String getR_result_ind() {
		return r_result_ind;
	}

	public void setR_result_ind(String r_result_ind) {
		this.r_result_ind = r_result_ind;
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

	public String getR_invs_upper() {
		return r_invs_upper;
	}

	public void setR_invs_upper(String r_invs_upper) {
		this.r_invs_upper = r_invs_upper;
	}

	public String getR_invs_lower() {
		return r_invs_lower;
	}

	public void setR_invs_lower(String r_invs_lower) {
		this.r_invs_lower = r_invs_lower;
	}

	public String getR_invs_risk_degree() {
		return r_invs_risk_degree;
	}

	public void setR_invs_risk_degree(String r_invs_risk_degree) {
		this.r_invs_risk_degree = r_invs_risk_degree;
	}

	public String getR_invs_amt() {
		return r_invs_amt;
	}

	public void setR_invs_amt(String r_invs_amt) {
		this.r_invs_amt = r_invs_amt;
	}

}
