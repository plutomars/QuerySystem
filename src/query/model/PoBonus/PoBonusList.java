package query.model.PoBonus;

import java.util.HashMap;


/**
 * @ * @author YIHUA
 * 
 * @version 1.0<br>
 *          100/08/15<br>
 *          紅利明細(JavaBean)
 * @since 1.0
 */

public class PoBonusList {
	
	private String result_ind;       //查詢結果
	private String plan_code;        //保單狀態碼
	private String rate_scale;       //狀態
	private String pua_this_year;    //狀態說明	
	private String accumulated_pua;  //紅利選擇(英文)
	
	public PoBonusList(HashMap<String, String> hsmp) {
	
		result_ind = (hsmp.get("r_result_ind") == null) ? "" : hsmp.get(
				"r_result_ind").trim();
		
		plan_code = (hsmp.get("r_plan_code") == null) ? "" : hsmp.get(
				"r_plan_code").trim();
		
		rate_scale = (hsmp.get("r_rate_scale") == null) ? "" : hsmp.get(
				"r_rate_scale").trim();
		
		pua_this_year = (hsmp.get("r_pua_this_year") == null) ? "" : hsmp.get(
				"r_pua_this_year").trim();
		
		accumulated_pua = (hsmp.get("r_accumulated_pua") == null) ? "" : hsmp.get(
				"r_accumulated_pua").trim();
			
	}

	public String getResult_ind() {
		return result_ind;
	}

	public void setResult_ind(String result_ind) {
		this.result_ind = result_ind;
	}

	public String getPlan_code() {
		return plan_code;
	}

	public void setPlan_code(String plan_code) {
		this.plan_code = plan_code;
	}

	public String getRate_scale() {
		return rate_scale;
	}

	public void setRate_scale(String rate_scale) {
		this.rate_scale = rate_scale;
	}

	public String getPua_this_year() {
		return pua_this_year;
	}

	public void setPua_this_year(String pua_this_year) {
		this.pua_this_year = pua_this_year;
	}

	public String getAccumulated_pua() {
		return accumulated_pua;
	}

	public void setAccumulated_pua(String accumulated_pua) {
		this.accumulated_pua = accumulated_pua;
	}
	
//	//查詢結果
//	public String getResult_ind() { 
//		return result_ind;
//	}
//	public void setResult_ind(String result_ind) {
//		this.result_ind = result_ind;
//	}
//	
//	//保單狀態碼
//	public String getPlan_code() { 
//		return plan_code;
//	}
//	public void setPlan_code(String plan_code) {
//		this.plan_code = plan_code;
//	}	
//	
//	//險種版數
//	public String getRate_scale() { 
//		return rate_scale;
//	}
//	public void setRate_scale(String rate_scale) {
//		this.rate_scale = rate_scale;
//	}		
//	
//	//當年度ＰＵＡ保額	
//	public String getPua_this_year() { 
//		return pua_this_year;
//	}
//	public void setPua_this_year(String pua_this_year) {
//		this.pua_this_year = pua_this_year;
//	}			
//	
//	//歷年度ＰＵＡ累積保額
//	public String getAccumulated_pua() { 
//		return accumulated_pua;
//	}
//	public void setAccumulated_pua(String accumulated_pua) {
//		this.accumulated_pua = accumulated_pua;
//	}
}
