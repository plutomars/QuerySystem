package query.model.InvestDeduction;

import java.util.HashMap;

import query.model.AbstractModelObject;

/**
 * @author swei
 * 
 * @version 1.0<br>
 *          101/03/28<br>
 *          投資交易_每月扣除額(BEANS)
 * @since 1.0
 */

public class InvestDeduction01 extends AbstractModelObject {
	private String m_policy_no;// 保單號碼
	private String m_paid_to_date;// 繳費終日
	private String m_acct_fee;// 帳戶管理費
	private String m_target_fee;// 目標管理費
	private String m_coi_amt;// 應扣 COI
	private String m_coi_amt_pay;// 實扣COI
	private String m_tran_date;// 入帳日
	private String m_vcoid_sts;// 資料狀態_已扣
	private String m_seq_no;// 序號
	private String r_coi_seq_ind;// 每月扣除額扣款方式

	// private String m_plan_code ;//險種代碼
	// private String m_rate_scale ;//險種版數
	// private String m_coi_face_amt ;//保險成本面額_保額
	// private String m_coi_amt2 ;//應扣COI金額_2
	// private String m_coi_amt_pay2 ;//實扣保險成本金額_2
	// private String m_seq_no ;//序號
	// private String m_coverage_no ;//保障號碼
	// private String m_dur ;//年度
	// private String m_program_id ;//程式代碼
	// private String m_process_user ;//處理者
	// private String m_process_date ;//處理日期
	// private String m_process_time ;//處理時間
	// private String m_crt_date ;//建立日期

	public InvestDeduction01() {
	}

	public InvestDeduction01(HashMap<String, String> hsmp) {
		m_policy_no = (hsmp.get("r_policy_no") == null) ? "" : hsmp.get(
				"r_policy_no").trim();
		m_paid_to_date = (hsmp.get("r_paid_to_date") == null) ? "" : hsmp.get(
				"r_paid_to_date").trim();
		m_acct_fee = (hsmp.get("r_acct_fee") == null) ? "" : hsmp.get(
				"r_acct_fee").trim();
		m_target_fee = (hsmp.get("r_target_fee") == null) ? "" : hsmp.get(
				"r_target_fee").trim();
		m_coi_amt = (hsmp.get("r_coi_amt") == null) ? "" : hsmp
				.get("r_coi_amt").trim();
		m_coi_amt_pay = (hsmp.get("r_coi_amt_pay") == null) ? "" : hsmp.get(
				"r_coi_amt_pay").trim();
		m_tran_date = (hsmp.get("r_tran_date") == null) ? "" : hsmp.get(
				"r_tran_date").trim();
		m_vcoid_sts = (hsmp.get("r_vcoid_sts") == null) ? "" : hsmp.get(
				"r_vcoid_sts").trim();
		m_seq_no = (hsmp.get("r_seq_no") == null) ? "" : hsmp.get("r_seq_no")
				.trim();
		r_coi_seq_ind = (hsmp.get("r_coi_seq_ind") == null) ? "" : hsmp.get("r_coi_seq_ind")
				.trim();

		// m_plan_code = (hsmp.get("r_plan_code") == null) ? "" :
		// hsmp.get("r_plan_code").trim();
		// m_rate_scale = (hsmp.get("r_rate_scale") == null) ? "" :
		// hsmp.get("r_rate_scale").trim();
		// m_coi_face_amt = (hsmp.get("r_coi_face_amt") == null) ? "" :
		// hsmp.get("r_coi_face_amt").trim();
		// m_coi_amt2 = (hsmp.get("r_coi_amt2") == null) ? "" :
		// hsmp.get("r_coi_amt2").trim();
		// m_coi_amt_pay2 = (hsmp.get("r_coi_amt_pay2") == null) ? "" :
		// hsmp.get("r_coi_amt_pay2").trim();
		// m_seq_no = (hsmp.get("r_seq_no") == null) ? "" :
		// hsmp.get("r_seq_no").trim();
		// m_coverage_no = (hsmp.get("r_coverage_no") == null) ? "" :
		// hsmp.get("r_coverage_no").trim();
		// m_dur = (hsmp.get("r_dur") == null) ? "" : hsmp.get("r_dur").trim();
		// m_program_id = (hsmp.get("r_program_id") == null) ? "" :
		// hsmp.get("r_program_id").trim();
		// m_process_user = (hsmp.get("r_process_user") == null) ? "" :
		// hsmp.get("r_process_user").trim();
		// m_process_date = (hsmp.get("r_process_date") == null) ? "" :
		// hsmp.get("r_process_date").trim();
		// m_process_time = (hsmp.get("r_process_time") == null) ? "" :
		// hsmp.get("r_process_time").trim();
		// m_crt_date = (hsmp.get("r_crt_date") == null) ? "" :
		// hsmp.get("r_crt_date").trim();
	}

	public String getM_policy_no() {
		return m_policy_no;
	}

	public void setM_policy_no(String m_policy_no) {
		this.m_policy_no = m_policy_no;
	}

	public String getM_seq_no() {
		return m_seq_no;
	}

	public void setM_seq_no(String m_seq_no) {
		this.m_seq_no = m_seq_no;
	}

	public String getM_paid_to_date() {
		return m_paid_to_date;
	}

	public void setM_paid_to_date(String m_paid_to_date) {
		this.m_paid_to_date = m_paid_to_date;
	}

	public String getM_acct_fee() {
		return m_acct_fee;
	}

	public void setM_acct_fee(String m_acct_fee) {
		this.m_acct_fee = m_acct_fee;
	}

	public String getM_target_fee() {
		return m_target_fee;
	}

	public void setM_target_fee(String m_target_fee) {
		this.m_target_fee = m_target_fee;
	}

	public String getM_coi_amt_pay() {
		return m_coi_amt_pay;
	}

	public void setM_coi_amt_pay(String m_coi_amt_pay) {
		this.m_coi_amt_pay = m_coi_amt_pay;
	}

	public String getM_tran_date() {
		return m_tran_date;
	}

	public void setM_tran_date(String m_tran_date) {
		this.m_tran_date = m_tran_date;
	}

	public String getM_vcoid_sts() {
		return m_vcoid_sts;
	}

	public void setM_vcoid_sts(String m_vcoid_sts) {
		this.m_vcoid_sts = m_vcoid_sts;
	}

	public String getM_coi_amt() {
		return m_coi_amt;
	}

	public void setM_coi_amt(String m_coi_amt) {
		this.m_coi_amt = m_coi_amt;
	}

	public String getR_coi_seq_ind() {
		return r_coi_seq_ind;
	}

	public void setR_coi_seq_ind(String r_coi_seq_ind) {
		this.r_coi_seq_ind = r_coi_seq_ind;
	}

}
