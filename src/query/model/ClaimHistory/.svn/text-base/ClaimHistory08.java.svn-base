package query.model.ClaimHistory;

import java.util.HashMap;

import query.model.Policy;

/**
 * @ * @author FYYANG
 * 
 * @version 1.0<br>
 *          100/09/26<br>
 *          ´N¶EÂå°|(JavaBean)
 * @since 1.0
 */
public class ClaimHistory08 {
	private String r_result_ind;
	private String hi_hospital_id;
	private String hi_hospital_name;
	private String remark;
	private String cl_hs_date_1;
	private String cl_hs_date_2;
	private String clmd_code;
	private String clmd_desc;
	private String doctor_name;
	private String doctor_id;
	private String clhn_seq;
	
	private int period;

	public ClaimHistory08(HashMap<String, String> hsmp) {
		r_result_ind = (hsmp.get("r_result_ind") == null) ? "" : hsmp.get(
				"r_result_ind").trim();
		hi_hospital_id = (hsmp.get("r_hi_hospital_id") == null) ? "" : hsmp.get(
				"r_hi_hospital_id").trim();
		hi_hospital_name = (hsmp.get("r_hi_hospital_name") == null) ? "" : hsmp
				.get("r_hi_hospital_name").trim();
		remark = (hsmp.get("r_remark") == null) ? "" : hsmp.get("r_remark").trim();
		cl_hs_date_1 = (hsmp.get("r_cl_hs_date_1") == null) ? "" : hsmp.get(
				"r_cl_hs_date_1").trim();
		cl_hs_date_2 = (hsmp.get("r_cl_hs_date_2") == null) ? "" : hsmp.get(
				"r_cl_hs_date_2").trim();
		clmd_code = (hsmp.get("r_clmd_code") == null) ? "" : hsmp
				.get("r_clmd_code").trim();
		clmd_desc = (hsmp.get("r_clmd_desc") == null) ? "" : hsmp
				.get("r_clmd_desc").trim();
		doctor_name = (hsmp.get("r_doctor_name") == null) ? "" : hsmp.get(
				"r_doctor_name").trim();
		doctor_id = (hsmp.get("r_doctor_id") == null) ? "" : hsmp
				.get("r_doctor_id").trim();
		clhn_seq = (hsmp.get("r_clhn_seq") == null) ? "" : hsmp
				.get("r_clhn_seq").trim();

		if (cl_hs_date_1.length() == 9 && cl_hs_date_2.length() == 9){
			period = Policy.period(cl_hs_date_1, cl_hs_date_2)+1;
		}
			
	}

	public String getR_result_ind() {
		return r_result_ind;
	}

	public void setR_result_ind(String r_result_ind) {
		this.r_result_ind = r_result_ind;
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

	public String getClmd_code() {
		return clmd_code;
	}

	public void setClmd_code(String clmd_code) {
		this.clmd_code = clmd_code;
	}

	public String getClmd_desc() {
		return clmd_desc;
	}

	public void setClmd_desc(String clmd_desc) {
		this.clmd_desc = clmd_desc;
	}

	public String getDoctor_name() {
		return doctor_name;
	}

	public void setDoctor_name(String doctor_name) {
		this.doctor_name = doctor_name;
	}

	public String getDoctor_id() {
		return doctor_id;
	}

	public void setDoctor_id(String doctor_id) {
		this.doctor_id = doctor_id;
	}
	
	public String getClhn_seq() {
		return clhn_seq;
	}

	public void setClhn_seq(String clhn_seq) {
		this.clhn_seq = clhn_seq;
	}

}
