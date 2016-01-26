package query.model.PoPlan;

import java.util.ArrayList;
import java.util.HashMap;
/**
 * 
 * @author cychu
 * 
 * @version 1.0<br/>
 * 			100/08/01<br/>
 * 			保障險種資料(JavaBean)
 * 
 * @since 1.0
 */
public class PoPlan {
	private String result_ind;				//0_查詢結果
	private String coverage_no;				//30_保障號碼
	
	private String client_ident;			//1_關係
	private String plan_code;				//2_險種代碼
	private String rate_scale;				//3_險種版數
	private String rate_insu;				//4_費率-社會保險
	private String face_amt;				//5_保障面額
	private String co_sts_desc;				//6_保障狀況
	private String rate_occu;				//7_費率-職業等級
	private String rate_age;				//8_費率-年齡
	private String rate_sex;				//9_費率-性別
	private String dur;						//10_保障年度
	private String co_mode_prem;			//11_保障繳別保費
	private String co_chg_date;				//12_保障異動日
	
	private String plan_desc;				//13_險種中文名稱
	private String unit_value;				//14_單位保額
	private String prem_factor;				//15_單位保費
	private String flat_rating_amt;			//16_定額加費
	private String co_issue_date;			//17_保障生效日
	private String paid_to_date;			//18_應繳費日
	private String accumulated_pua;			//19_增額繳清
	private String sub_std_desc;			//20_弱體代碼
	private String b_prem_inv_amt;			//31_基本投資
	
	private String multi_rating_1;			//21_比例加費
	private String matured_date;			//22_繳費終日
	private String eti_expired_date;		//23_展期終日
	private String eti_pe_amt;				//24_生存保額
	private String b_prem_loading;			//32_基本附加
	private String rate_medi;				//25_體位
	private String init_mode_prem;			//26_原始保費
	private String flat_rating_year;		//27_加費年期
	private String expired_date;			//28_保障終期
	private String eti_pe_date;				//29_生存到期
	private String co_target_prem;			//33_年度目標保費

	public PoPlan(HashMap<String, String> hsmp) {
		result_ind = (hsmp.get("r_result_ind") == null) ? "" : hsmp.get(
					"r_result_ind").trim();
		coverage_no = (hsmp.get("r_coverage_no") == null) ? "" : hsmp.get(
		"r_coverage_no").trim();
		
		client_ident = (hsmp.get("r_client_ident") == null) ? "" : hsmp.get(
					"r_client_ident").trim();
		plan_code = (hsmp.get("r_plan_code") == null) ? "" : hsmp.get(
					"r_plan_code").trim();
		rate_scale = (hsmp.get("r_rate_scale") == null) ? "" : hsmp.get(
					"r_rate_scale").trim(); 
		rate_insu = (hsmp.get("r_rate_insu") == null) ? "" : hsmp.get(
					"r_rate_insu").trim(); 
		face_amt = (hsmp.get("r_face_amt") == null) ? "" : hsmp.get(
					"r_face_amt").trim();
		co_sts_desc = (hsmp.get("r_co_sts_desc") == null) ? "" : hsmp.get(
					"r_co_sts_desc").trim();
		rate_occu = (hsmp.get("r_rate_occu") == null) ? "" : hsmp.get(
					"r_rate_occu").trim();
		rate_age = (hsmp.get("r_rate_age") == null) ? "" : hsmp.get(
					"r_rate_age").trim();
		rate_sex = (hsmp.get("r_rate_sex") == null) ? "" : hsmp.get(
					"r_rate_sex").trim();
		dur = (hsmp.get("r_dur") == null) ? "" : hsmp.get(
					"r_dur").trim();
		co_mode_prem = (hsmp.get("r_co_mode_prem") == null) ? "" : hsmp.get(
					"r_co_mode_prem").trim();
		co_chg_date = (hsmp.get("r_co_chg_date") == null) ? "" : hsmp.get(
					"r_co_chg_date").trim();
		
		plan_desc = (hsmp.get("r_plan_desc") == null) ? "" : hsmp.get(
					"r_plan_desc").trim();
		unit_value = (hsmp.get("r_unit_value") == null) ? "" : hsmp.get(
					"r_unit_value").trim();
		prem_factor = (hsmp.get("r_prem_factor") == null) ? "" : hsmp.get(
					"r_prem_factor").trim();
		flat_rating_amt = (hsmp.get("r_flat_rating_amt") == null) ? "" : hsmp.get(
					"r_flat_rating_amt").trim();
		co_issue_date = (hsmp.get("r_co_issue_date") == null) ? "" : hsmp.get(
					"r_co_issue_date").trim();
		paid_to_date = (hsmp.get("r_paid_to_date") == null) ? "" : hsmp.get(
					"r_paid_to_date").trim();
		accumulated_pua = (hsmp.get("r_accumulated_pua") == null) ? "" : hsmp.get(
					"r_accumulated_pua").trim();
		sub_std_desc = (hsmp.get("r_sub_std_desc") == null) ? "" : hsmp.get(
					"r_sub_std_desc").trim();
		face_amt = (hsmp.get("r_face_amt") == null) ? "" : hsmp.get(
					"r_face_amt").trim();
		b_prem_inv_amt = (hsmp.get("r_b_prem_inv_amt") == null) ? "" : hsmp.get(
					"r_b_prem_inv_amt").trim();
		
		multi_rating_1 = (hsmp.get("r_multi_rating_1") == null) ? "" : hsmp.get(
					"r_multi_rating_1").trim();
		matured_date = (hsmp.get("r_matured_date") == null) ? "" : hsmp.get(
					"r_matured_date").trim();
		eti_expired_date = (hsmp.get("r_eti_expired_date") == null) ? "" : hsmp.get(
					"r_eti_expired_date").trim();
		eti_pe_amt = (hsmp.get("r_eti_pe_amt") == null) ? "" : hsmp.get(
					"r_eti_pe_amt").trim();
		b_prem_loading = (hsmp.get("r_b_prem_loading") == null) ? "" : hsmp.get(
					"r_b_prem_loading").trim();
		rate_medi = (hsmp.get("r_rate_medi") == null) ? "" : hsmp.get(
					"r_rate_medi").trim();
		flat_rating_year = (hsmp.get("r_flat_rating_year") == null) ? "" : hsmp.get(
					"r_flat_rating_year").trim();
		expired_date = (hsmp.get("r_expired_date") == null) ? "" : hsmp.get(
					"r_expired_date").trim();
		co_sts_desc = (hsmp.get("r_co_sts_desc") == null) ? "" : hsmp.get(
					"r_co_sts_desc").trim();
		eti_pe_date = (hsmp.get("r_eti_pe_date") == null) ? "" : hsmp.get(
					"r_eti_pe_date").trim();
		co_target_prem = (hsmp.get("r_co_target_prem") == null) ? "" : hsmp.get(
					"r_co_target_prem").trim();
	}
	
	public String[] getValues(int type) {
		ArrayList<String> valueList = new ArrayList<String>();

		switch (type) {
			case 1:
				valueList.add(plan_desc);
				valueList.add(unit_value);
				valueList.add(prem_factor);
				valueList.add(flat_rating_amt);
				valueList.add(co_issue_date);
				valueList.add(paid_to_date);
				valueList.add(accumulated_pua);
				valueList.add(sub_std_desc);
				valueList.add(face_amt);
				valueList.add(co_mode_prem);
				valueList.add(b_prem_inv_amt);
				break;
			case 2:
				valueList.add(multi_rating_1);
				valueList.add(matured_date);
				valueList.add(eti_expired_date);
				valueList.add(eti_pe_amt);
				valueList.add(b_prem_loading);
				valueList.add(rate_medi);
				valueList.add(init_mode_prem);
				valueList.add(flat_rating_year);
				valueList.add(expired_date);
				valueList.add(co_sts_desc);
				valueList.add(eti_pe_date);
				valueList.add(co_target_prem);
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
	
	public void setCoverage_no(String coverage_no) {
		this.coverage_no = coverage_no;
	}

	public String getCoverage_no() {
		return coverage_no;
	}

	public String getClient_ident() {
		return client_ident;
	}

	public void setClient_ident(String client_ident) {
		this.client_ident = client_ident;
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

	public String getRate_insu() {
		return rate_insu;
	}

	public void setRate_insu(String rate_insu) {
		this.rate_insu = rate_insu;
	}

	public String getFace_amt() {
		return face_amt;
	}

	public void setFace_amt(String face_amt) {
		this.face_amt = face_amt;
	}

	public String getCo_sts_desc() {
		return co_sts_desc;
	}

	public void setCo_sts_desc(String co_sts_desc) {
		this.co_sts_desc = co_sts_desc;
	}

	public String getRate_occu() {
		return rate_occu;
	}

	public void setRate_occu(String rate_occu) {
		this.rate_occu = rate_occu;
	}

	public String getRate_age() {
		return rate_age;
	}

	public void setRate_age(String string) {
		this.rate_age = string;
	}

	public String getRate_sex() {
		return rate_sex;
	}

	public void setRate_sex(String rate_sex) {
		this.rate_sex = rate_sex;
	}

	public String getDur() {
		return dur;
	}

	public void setDur(String dur) {
		this.dur = dur;
	}

	public String getCo_mode_prem() {
		return co_mode_prem;
	}

	public void setCo_mode_prem(String co_mode_prem) {
		this.co_mode_prem = co_mode_prem;
	}

	public String getCo_chg_date() {
		return co_chg_date;
	}

	public void setCo_chg_date(String co_chg_date) {
		this.co_chg_date = co_chg_date;
	}
	
	public String getPlan_desc() {
		return plan_desc;
	}

	public void setPlan_desc(String plan_desc) {
		this.plan_desc = plan_desc;
	}

	public String getUnit_value() {
		return unit_value;
	}

	public void setUnit_value(String unit_value) {
		this.unit_value = unit_value;
	}

	public String getPrem_factor() {
		return prem_factor;
	}

	public void setPrem_factor(String prem_factor) {
		this.prem_factor = prem_factor;
	}

	public String getFlat_rating_amt() {
		return flat_rating_amt;
	}

	public void setFlat_rating_amt(String flat_rating_amt) {
		this.flat_rating_amt = flat_rating_amt;
	}

	public String getCo_issue_date() {
		return co_issue_date;
	}

	public void setCo_issue_date(String co_issue_date) {
		this.co_issue_date = co_issue_date;
	}

	public String getPaid_to_date() {
		return paid_to_date;
	}

	public void setPaid_to_date(String paid_to_date) {
		this.paid_to_date = paid_to_date;
	}

	public String getAccumulated_pua() {
		return accumulated_pua;
	}

	public void setAccumulated_pua(String accumulated_pua) {
		this.accumulated_pua = accumulated_pua;
	}

	public String getSub_std_desc() {
		return sub_std_desc;
	}

	public void setSub_std_desc(String sub_std_desc) {
		this.sub_std_desc = sub_std_desc;
	}

	public String getB_prem_inv_amt() {
		return b_prem_inv_amt;
	}

	public void setB_prem_inv_amt(String b_prem_inv_amt) {
		this.b_prem_inv_amt = b_prem_inv_amt;
	}

	public String getMulti_rating_1() {
		return multi_rating_1;
	}

	public void setMulti_rating_1(String multi_rating_1) {
		this.multi_rating_1 = multi_rating_1;
	}

	public String getMatured_date() {
		return matured_date;
	}

	public void setMatured_date(String matured_date) {
		this.matured_date = matured_date;
	}

	public String getEti_expired_date() {
		return eti_expired_date;
	}

	public void setEti_expired_date(String eti_expired_date) {
		this.eti_expired_date = eti_expired_date;
	}

	public String getEti_pe_amt() {
		return eti_pe_amt;
	}

	public void setEti_pe_amt(String eti_pe_amt) {
		this.eti_pe_amt = eti_pe_amt;
	}

	public String getB_prem_loading() {
		return b_prem_loading;
	}

	public void setB_prem_loading(String b_prem_loading) {
		this.b_prem_loading = b_prem_loading;
	}

	public String getRate_medi() {
		return rate_medi;
	}

	public void setRate_medi(String rate_medi) {
		this.rate_medi = rate_medi;
	}

	public String getInit_mode_prem() {
		return init_mode_prem;
	}

	public void setInit_mode_prem(String init_mode_prem) {
		this.init_mode_prem = init_mode_prem;
	}

	public String getFlat_rating_year() {
		return flat_rating_year;
	}

	public void setFlat_rating_year(String flat_rating_year) {
		this.flat_rating_year = flat_rating_year;
	}

	public String getExpired_date() {
		return expired_date;
	}

	public void setExpired_date(String expired_date) {
		this.expired_date = expired_date;
	}

	public String getEti_pe_date() {
		return eti_pe_date;
	}

	public void setEti_pe_date(String eti_pe_date) {
		this.eti_pe_date = eti_pe_date;
	}

	public String getCo_target_prem() {
		return co_target_prem;
	}

	public void setCo_target_prem(String co_target_prem) {
		this.co_target_prem = co_target_prem;
	}
}
