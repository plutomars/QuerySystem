package query.model.ClaimHistory;

import java.util.HashMap;

import query.model.Policy;

/**
 * @ * @author FYYANG
 * 
 * @version 1.0<br>
 *          100/09/27<br>
 *          ¦w¹ç½w©MÂåÀø(JavaBean)
 * @since 1.0
 */
public class ClaimHistory09 {
	private String hi_hospital_id;
	private String hi_hospital_name;
	private String remark;
	private String cl_hs_date_1;
	private String cl_hs_date_2;
	private int period;

	public ClaimHistory09(HashMap<String, String> hsmp) {
		hi_hospital_id = (hsmp.get("hi_hospital_id") == null) ? "" : hsmp.get(
				"hi_hospital_id").trim();
		hi_hospital_name = (hsmp.get("hi_hospital_name") == null) ? "" : hsmp
				.get("hi_hospital_name").trim();
		remark = (hsmp.get("remark") == null) ? "" : hsmp.get("remark").trim();
		cl_hs_date_1 = (hsmp.get("cl_hs_date_1") == null) ? "" : hsmp.get(
				"cl_hs_date_1").trim();
		cl_hs_date_2 = (hsmp.get("cl_hs_date_2") == null) ? "" : hsmp.get(
				"cl_hs_date_2").trim();
		if (cl_hs_date_1.length() == 9 && cl_hs_date_2.length() == 9){
			period = Policy.period(cl_hs_date_1, cl_hs_date_2)+1;
		}
			
	}

	public int getPeriod() {
		return period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

	public String getHi_hospital_id() {
		return hi_hospital_id;
	}

	public void setHi_hospital_id(String hi_hospital_id) {
		this.hi_hospital_id = hi_hospital_id;
	}

	public String getHi_hospital_name() {
		return hi_hospital_name;
	}

	public void setHi_hospital_name(String hi_hospital_name) {
		this.hi_hospital_name = hi_hospital_name;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getCl_hs_date_1() {
		return cl_hs_date_1;
	}

	public void setCl_hs_date_1(String cl_hs_date_1) {
		this.cl_hs_date_1 = cl_hs_date_1;
	}

	public String getCl_hs_date_2() {
		return cl_hs_date_2;
	}

	public void setCl_hs_date_2(String cl_hs_date_2) {
		this.cl_hs_date_2 = cl_hs_date_2;
	}

}
