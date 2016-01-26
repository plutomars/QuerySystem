package query.model.InvestAuto;

import java.util.ArrayList;
import java.util.HashMap;
/**
 * 
 * @author 陳冠瑜
 * 
 */
public class InvestAuto01 {
	
	private String r_result_ind;       //查詢結果
	private String r_n_auto_tr_date;   //下次自動轉換日期
	private String r_auto_tr_date;     //週月日
	private String r_effect_date;      //批次作業日
	private String r_sum_feed_amt;     //應轉出金額
	private String r_invs_ad_amt;      //實際轉出金額
	private String r_ivchg_sts_desc;   //執行狀態中文
	private String r_auto_tr_desc;     //事由代碼說明
	private String r_invs_avail_type;  //險種加碼機制指示

	//for verticalPane
	public InvestAuto01(){
	}
	public void setValues(HashMap<String,String> hsmp) {  
		r_n_auto_tr_date = (hsmp.get("r_n_auto_tr_date") == null) ? "" : hsmp
				.get("r_n_auto_tr_date").trim();
	}
	
	public InvestAuto01(HashMap<String, String> hsmp) {
		r_result_ind = (hsmp.get("r_result_ind") == null) ? "" : hsmp.get(
				"r_result_ind").trim();
		r_auto_tr_date = (hsmp.get("r_auto_tr_date") == null) ? "" : hsmp.get(
				"r_auto_tr_date").trim();
		r_effect_date = (hsmp.get("r_effect_date") == null) ? "" : hsmp.get(
				"r_effect_date").trim();
		r_sum_feed_amt = (hsmp.get("r_sum_feed_amt") == null) ? "" : hsmp.get(
				"r_sum_feed_amt").trim();
		r_invs_ad_amt = (hsmp.get("r_invs_ad_amt") == null) ? "" : hsmp.get(
				"r_invs_ad_amt").trim();
		r_ivchg_sts_desc = (hsmp.get("r_ivchg_sts_desc") == null) ? "" : hsmp
				.get("r_ivchg_sts_desc").trim();
		r_auto_tr_desc = (hsmp.get("r_auto_tr_desc") == null) ? "" : hsmp.get(
				"r_auto_tr_desc").trim();
		r_invs_avail_type = (hsmp.get("r_invs_avail_type") == null) ? "" : hsmp.get(
				"r_invs_avail_type").trim();
	}

	public String[] getValues(int type) {
		ArrayList<String> valueList = new ArrayList<String>();
		switch (type) {
		case 1:
			valueList.add(r_n_auto_tr_date);
			break;
		}
		String[] valueArray = new String[valueList.size()];
		valueList.toArray(valueArray);

		return valueArray;
	}
	
	public String getR_result_ind() {
		return r_result_ind;
	}

	public void setR_result_ind(String r_result_ind) {
		this.r_result_ind = r_result_ind;
	}
	
	public String getR_n_auto_tr_date() {
		return r_n_auto_tr_date;
	}
	
	public void setR_n_auto_tr_date(String r_n_auto_tr_date) {
		this.r_n_auto_tr_date = r_n_auto_tr_date;
	}
	
	public String getR_auto_tr_date() {
		return r_auto_tr_date;
	}

	public void setR_auto_tr_date(String r_auto_tr_date) {
		this.r_auto_tr_date = r_auto_tr_date;
	}

	public String getR_effect_date() {
		return r_effect_date;
	}

	public void setR_effect_date(String r_effect_date) {
		this.r_effect_date = r_effect_date;
	}

	public String getR_sum_feed_amt() {
		return r_sum_feed_amt;
	}

	public void setR_sum_feed_amt(String r_sum_feed_amt) {
		this.r_sum_feed_amt = r_sum_feed_amt;
	}

	public String getR_invs_ad_amt() {
		return r_invs_ad_amt;
	}

	public void setR_invs_ad_amt(String r_invs_ad_amt) {
		this.r_invs_ad_amt = r_invs_ad_amt;
	}

	public String getR_ivchg_sts_desc() {
		return r_ivchg_sts_desc;
	}

	public void setR_ivchg_sts_desc(String r_ivchg_sts_desc) {
		this.r_ivchg_sts_desc = r_ivchg_sts_desc;
	}

	public String getR_auto_tr_desc() {
		return r_auto_tr_desc;
	}

	public void setR_auto_tr_desc(String r_auto_tr_desc) {
		this.r_auto_tr_desc = r_auto_tr_desc;
	}
	
	public String getR_invs_avail_type() {
		return r_invs_avail_type;
	}
	
	public void setR_invs_avail_type(String r_invs_avail_type) {
		this.r_invs_avail_type = r_invs_avail_type;
	}

}
