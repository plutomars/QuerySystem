package query.model.PremBldt;

import java.util.HashMap;

/**
 * 
 * @author cychu
 * 
 * @version 1.0<br/>
 * 			101/04/11<br/>
 * 			�e���O���d�ߡЭק���v�d��(JavaBean)
 * 
 * @since 1.0
 *
 */
public class PremBldt03 {
	private String result_ind;				//0_���G
	private String bill_sts_pre_desc;		//1_�ܧ�e�e�����p�y�z
	private String collector_pre;			//2_�ܧ�e���O���N�X
	private String coll_rate_ind_pre;		//3_�ܧ�e���O�v
	private String mode_prem_pre;			//4_�ܧ�e�O�O���J
	private String bill_sts_new_desc;		//5_�ܧ��e�����p�y�z
	private String collector_new;			//6_�ܧ�᦬�O���N�X
	private String coll_rate_ind_new;		//7_�ܧ�᦬�O�v
	private String mode_prem_new;			//8_�ܧ��O�O���J
	private String process_user_name;		//9_�ܧ�̩m�W
	private String program_id;				//10_�ܧ�{���N�X
	private String process_date;			//11_�B�z���
	private String process_time;			//12_�B�z�ɶ�
	
	public PremBldt03(HashMap<String, String> hsmp) {
		result_ind = (hsmp.get("r_result_ind") == null) ? "" : hsmp.get(
		"r_result_ind").trim();
		bill_sts_pre_desc = (hsmp.get("r_bill_sts_pre_desc") == null) ? "" : hsmp.get(
		"r_bill_sts_pre_desc").trim();
		collector_pre = (hsmp.get("r_collector_pre") == null) ? "" : hsmp.get(
		"r_collector_pre").trim();
		coll_rate_ind_pre = (hsmp.get("r_coll_rate_ind_pre") == null) ? "" : hsmp.get(
		"r_coll_rate_ind_pre").trim();
		mode_prem_pre = (hsmp.get("r_rmode_prem_pre") == null) ? "" : hsmp.get(
		"r_mode_prem_pre").trim();
		bill_sts_new_desc = (hsmp.get("r_bill_sts_new_desc") == null) ? "" : hsmp.get(
		"r_bill_sts_new_desc").trim();
		collector_new = (hsmp.get("r_collector_new") == null) ? "" : hsmp.get(
		"r_collector_new").trim();
		coll_rate_ind_new = (hsmp.get("r_coll_rate_ind_new") == null) ? "" : hsmp.get(
		"r_coll_rate_ind_new").trim();
		mode_prem_new = (hsmp.get("r_mode_prem_new") == null) ? "" : hsmp.get(
		"r_mode_prem_new").trim();
		process_user_name = (hsmp.get("r_process_user_name") == null) ? "" : hsmp.get(
		"r_process_user_name").trim();
		program_id = (hsmp.get("r_program_id") == null) ? "" : hsmp.get(
		"r_program_id").trim();
		process_date = (hsmp.get("r_process_date") == null) ? "" : hsmp.get(
		"r_process_date").trim();
		process_time = (hsmp.get("r_process_time") == null) ? "" : hsmp.get(
		"r_process_time").trim();
	}

	public String getResult_ind() {
		return result_ind;
	}

	public void setResult_ind(String result_ind) {
		this.result_ind = result_ind;
	}

	public String getBill_sts_pre_desc() {
		return bill_sts_pre_desc;
	}

	public void setBill_sts_pre_desc(String bill_sts_pre_desc) {
		this.bill_sts_pre_desc = bill_sts_pre_desc;
	}

	public String getCollector_pre() {
		return collector_pre;
	}

	public void setCollector_pre(String collector_pre) {
		this.collector_pre = collector_pre;
	}

	public String getColl_rate_ind_pre() {
		return coll_rate_ind_pre;
	}

	public void setColl_rate_ind_pre(String coll_rate_ind_pre) {
		this.coll_rate_ind_pre = coll_rate_ind_pre;
	}

	public String getMode_prem_pre() {
		return mode_prem_pre;
	}

	public void setMode_prem_pre(String mode_prem_pre) {
		this.mode_prem_pre = mode_prem_pre;
	}

	public String getBill_sts_new_desc() {
		return bill_sts_new_desc;
	}

	public void setBill_sts_new_desc(String bill_sts_new_desc) {
		this.bill_sts_new_desc = bill_sts_new_desc;
	}

	public String getCollector_new() {
		return collector_new;
	}

	public void setCollector_new(String collector_new) {
		this.collector_new = collector_new;
	}

	public String getColl_rate_ind_new() {
		return coll_rate_ind_new;
	}

	public void setColl_rate_ind_new(String coll_rate_ind_new) {
		this.coll_rate_ind_new = coll_rate_ind_new;
	}

	public String getMode_prem_new() {
		return mode_prem_new;
	}

	public void setMode_prem_new(String mode_prem_new) {
		this.mode_prem_new = mode_prem_new;
	}

	public String getProcess_user_name() {
		return process_user_name;
	}

	public void setProcess_user_name(String process_user_name) {
		this.process_user_name = process_user_name;
	}

	public String getProgram_id() {
		return program_id;
	}

	public void setProgram_id(String program_id) {
		this.program_id = program_id;
	}

	public String getProcess_date() {
		return process_date;
	}

	public void setProcess_date(String process_date) {
		this.process_date = process_date;
	}

	public String getProcess_time() {
		return process_time;
	}

	public void setProcess_time(String process_time) {
		this.process_time = process_time;
	}
}
