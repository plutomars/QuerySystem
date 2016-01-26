package query.model.PoRelation;

import java.util.HashMap;

/**
 * @ * @author FYYANG
 * 
 * @version 1.0<br>
 *          101/03/20<br>
 *          代理投保(JavaBean)
 * @since 1.0
 */
public class PoRelationPA {
	private String r_result_ind;
	private String r_popu_code;
	private String r_assigner;
	private String r_company_name;
	private String r_zip_code;
	private String r_address;
	private String r_tel_1;
	private String r_papu_ind_1;
	private String r_desc1;
	private String r_papu_ind_2;
	private String r_desc2;

	public PoRelationPA(HashMap<String, String> hsmp) {
		r_result_ind = (hsmp.get("r_result_ind") == null) ? "" : hsmp.get(
				"r_result_ind").trim();
		r_popu_code = (hsmp.get("r_popu_code") == null) ? "" : hsmp.get(
				"r_popu_code").trim();
		r_assigner = (hsmp.get("r_assigner") == null) ? "" : hsmp.get(
				"r_assigner").trim();
		r_company_name = (hsmp.get("r_company_name") == null) ? "" : hsmp.get(
				"r_company_name").trim();
		r_zip_code = (hsmp.get("r_zip_code") == null) ? "" : hsmp.get(
				"r_zip_code").trim();
		r_address = (hsmp.get("r_address") == null) ? "" : hsmp
				.get("r_address").trim();
		r_tel_1 = (hsmp.get("r_tel_1") == null) ? "" : hsmp.get("r_tel_1")
				.trim();
		r_papu_ind_1 = (hsmp.get("r_papu_ind_1") == null) ? "" : hsmp.get(
				"r_papu_ind_1").trim();
		r_desc1 = (hsmp.get("r_desc1") == null) ? "" : hsmp.get("r_desc1")
				.trim();
		r_papu_ind_2 = (hsmp.get("r_papu_ind_2") == null) ? "" : hsmp.get(
				"r_papu_ind_2").trim();
		r_desc2 = (hsmp.get("r_desc2") == null) ? "" : hsmp.get("r_desc2")
				.trim();
	}

	public String getR_result_ind() {
		return r_result_ind;
	}

	public void setR_result_ind(String r_result_ind) {
		this.r_result_ind = r_result_ind;
	}

	public String getR_popu_code() {
		return r_popu_code;
	}

	public void setR_popu_code(String r_popu_code) {
		this.r_popu_code = r_popu_code;
	}

	public String getR_assigner() {
		return r_assigner;
	}

	public void setR_assigner(String r_assigner) {
		this.r_assigner = r_assigner;
	}

	public String getR_company_name() {
		return r_company_name;
	}

	public void setR_company_name(String r_company_name) {
		this.r_company_name = r_company_name;
	}

	public String getR_zip_code() {
		return r_zip_code;
	}

	public void setR_zip_code(String r_zip_code) {
		this.r_zip_code = r_zip_code;
	}

	public String getR_address() {
		return r_address;
	}

	public void setR_address(String r_address) {
		this.r_address = r_address;
	}

	public String getR_tel_1() {
		return r_tel_1;
	}

	public void setR_tel_1(String r_tel_1) {
		this.r_tel_1 = r_tel_1;
	}

	public String getR_papu_ind_1() {
		return r_papu_ind_1;
	}

	public void setR_papu_ind_1(String r_papu_ind_1) {
		this.r_papu_ind_1 = r_papu_ind_1;
	}

	public String getR_desc1() {
		return r_desc1;
	}

	public void setR_desc1(String r_desc1) {
		this.r_desc1 = r_desc1;
	}

	public String getR_papu_ind_2() {
		return r_papu_ind_2;
	}

	public void setR_papu_ind_2(String r_papu_ind_2) {
		this.r_papu_ind_2 = r_papu_ind_2;
	}

	public String getR_desc2() {
		return r_desc2;
	}

	public void setR_desc2(String r_desc2) {
		this.r_desc2 = r_desc2;
	}

}
