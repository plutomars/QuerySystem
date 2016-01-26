package query.model.NewDetail;

import java.util.HashMap;

/**
 * 新契約查詢新公會索引資料(JavaBean)
 * 
 * @author epf
 */
public class NewDetailNewAssoIndex {
	private String r_result_ind;
	private String r_insured_id;
	private String r_nbui_industry;
	private String r_nbui_indu_desc;
	private String r_policy_type;
	private String r_policy_type_desc;
	private String r_un_ins_type;
	private String r_un_ins_type_desc;
	private String r_un_plan_type;
	private String r_un_plan_type_desc;
	private String r_un_rpt_item;
	private String r_un_rpt_item_desc;
	private String r_un_rpt_value;
	private String r_nbui_company_code;
	private String r_company_name;

	public NewDetailNewAssoIndex(HashMap<String, String> hsmp) {
		r_result_ind = (hsmp.get("r_result_ind") == null) ? "" : hsmp.get(
				"r_result_ind").trim();
		r_insured_id = (hsmp.get("r_insured_id") == null) ? "" : hsmp.get(
				"r_insured_id").trim();
		r_nbui_industry = (hsmp.get("r_nbui_industry") == null) ? "" : hsmp
				.get("r_nbui_industry").trim();
		r_nbui_indu_desc = (hsmp.get("r_nbui_indu_desc") == null) ? "" : hsmp
				.get("r_nbui_indu_desc").trim();
		r_policy_type = (hsmp.get("r_policy_type") == null) ? "" : hsmp.get(
				"r_policy_type").trim();
		r_policy_type_desc = (hsmp.get("r_policy_type_desc") == null) ? ""
				: hsmp.get("r_policy_type_desc").trim();
		r_un_ins_type = (hsmp.get("r_un_ins_type") == null) ? "" : hsmp.get(
				"r_un_ins_type").trim();
		r_un_ins_type_desc = (hsmp.get("r_un_ins_type_desc") == null) ? ""
				: hsmp.get("r_un_ins_type_desc").trim();
		r_un_plan_type = (hsmp.get("r_un_plan_type") == null) ? "" : hsmp.get(
				"r_un_plan_type").trim();
		r_un_plan_type_desc = (hsmp.get("r_un_plan_type_desc") == null) ? ""
				: hsmp.get("r_un_plan_type_desc").trim();
		r_un_rpt_item = (hsmp.get("r_un_rpt_item") == null) ? "" : hsmp.get(
				"r_un_rpt_item").trim();
		r_un_rpt_item_desc = (hsmp.get("r_un_rpt_item_desc") == null) ? ""
				: hsmp.get("r_un_rpt_item_desc").trim();
		r_un_rpt_value = (hsmp.get("r_un_rpt_value") == null) ? "" : hsmp.get(
				"r_un_rpt_value").trim();
		r_nbui_company_code = (hsmp.get("r_nbui_company_code") == null) ? ""
				: hsmp.get("r_nbui_company_code").trim();
		r_company_name = (hsmp.get("r_company_name") == null) ? "" : hsmp.get(
				"r_company_name").trim();
	}

	public String getR_result_ind() {
		return r_result_ind;
	}

	public void setR_result_ind(String r_result_ind) {
		this.r_result_ind = r_result_ind;
	}

	public String getR_insured_id() {
		return r_insured_id;
	}

	public void setR_insured_id(String r_insured_id) {
		this.r_insured_id = r_insured_id;
	}

	public String getR_nbui_industry() {
		return r_nbui_industry;
	}

	public void setR_nbui_industry(String r_nbui_industry) {
		this.r_nbui_industry = r_nbui_industry;
	}

	public String getR_nbui_indu_desc() {
		return r_nbui_indu_desc;
	}

	public void setR_nbui_indu_desc(String r_nbui_indu_desc) {
		this.r_nbui_indu_desc = r_nbui_indu_desc;
	}

	public String getR_policy_type() {
		return r_policy_type;
	}

	public void setR_policy_type(String r_policy_type) {
		this.r_policy_type = r_policy_type;
	}

	public String getR_policy_type_desc() {
		return r_policy_type_desc;
	}

	public void setR_policy_type_desc(String r_policy_type_desc) {
		this.r_policy_type_desc = r_policy_type_desc;
	}

	public String getR_un_ins_type() {
		return r_un_ins_type;
	}

	public void setR_un_ins_type(String r_un_ins_type) {
		this.r_un_ins_type = r_un_ins_type;
	}

	public String getR_un_ins_type_desc() {
		return r_un_ins_type_desc;
	}

	public void setR_un_ins_type_desc(String r_un_ins_type_desc) {
		this.r_un_ins_type_desc = r_un_ins_type_desc;
	}

	public String getR_un_plan_type() {
		return r_un_plan_type;
	}

	public void setR_un_plan_type(String r_un_plan_type) {
		this.r_un_plan_type = r_un_plan_type;
	}

	public String getR_un_plan_type_desc() {
		return r_un_plan_type_desc;
	}

	public void setR_un_plan_type_desc(String r_un_plan_type_desc) {
		this.r_un_plan_type_desc = r_un_plan_type_desc;
	}

	public String getR_un_rpt_item() {
		return r_un_rpt_item;
	}

	public void setR_un_rpt_item(String r_un_rpt_item) {
		this.r_un_rpt_item = r_un_rpt_item;
	}

	public String getR_un_rpt_item_desc() {
		return r_un_rpt_item_desc;
	}

	public void setR_un_rpt_item_desc(String r_un_rpt_item_desc) {
		this.r_un_rpt_item_desc = r_un_rpt_item_desc;
	}

	public String getR_un_rpt_value() {
		return r_un_rpt_value;
	}

	public void setR_un_rpt_value(String r_un_rpt_value) {
		this.r_un_rpt_value = r_un_rpt_value;
	}

	public String getR_nbui_company_code() {
		return r_nbui_company_code;
	}

	public void setR_nbui_company_code(String r_nbui_company_code) {
		this.r_nbui_company_code = r_nbui_company_code;
	}

	public String getR_company_name() {
		return r_company_name;
	}

	public void setR_company_name(String r_company_name) {
		this.r_company_name = r_company_name;
	}

}
