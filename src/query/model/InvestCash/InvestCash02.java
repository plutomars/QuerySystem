package query.model.InvestCash;

import java.util.HashMap;
/**
 * 
 * @author 陳冠瑜
 * 
 */
public class InvestCash02 {
	private String result_ind;
	private String cash_flow_type_d;  //費用類別
	private String amt;               //費用金額

	public InvestCash02(HashMap<String, String> hsmp) {
		result_ind = (hsmp.get("r_result_ind") == null) ? "" : hsmp.get(
				"r_result_ind").trim();
		cash_flow_type_d = (hsmp.get("r_cash_flow_type_d") == null) ? "" : hsmp
				.get("r_cash_flow_type_d").trim();
		amt = (hsmp.get("r_amt") == null) ? "" : hsmp.get("r_amt").trim();
	}

	public String getResult_ind() {
		return result_ind;
	}

	public void setResult_ind(String result_ind) {
		this.result_ind = result_ind;
	}

	public String getCash_flow_type_d() {
		return cash_flow_type_d;
	}

	public void setCash_flow_type_d(String cash_flow_type_d) {
		this.cash_flow_type_d = cash_flow_type_d;
	}

	public String getAmt() {
		return amt;
	}

	public void setAmt(String amt) {
		this.amt = amt;
	}
}
