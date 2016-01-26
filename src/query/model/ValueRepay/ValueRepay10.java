package query.model.ValueRepay;

import java.util.HashMap;

/**
 * @author F1256819
 * @category �٥����^�^�� ���I����
 */
public class ValueRepay10 {
	private String r_result_ind;// ���~����
	private String r_check_no;// �䲼���X
	private String r_payee_id_ori;// �����HID
	private String r_payee_name_ori;// �����H�m�W
	private String r_payee_id_new;// �s����HID
	private String r_payee_name_new;// �s����H�m�W
	private String r_remit_title;// �״ڻȦ�
	private String r_remit_account;// �״ڱb��
	private String r_pay_desc;// ����

	public ValueRepay10(HashMap<String, String> hsmp) {
		r_result_ind = (hsmp.get("r_result_ind") == null) ? "" : hsmp.get(
				"r_result_ind").trim();
		r_check_no = (hsmp.get("r_check_no") == null) ? "" : hsmp.get(
				"r_check_no").trim();
		r_payee_id_ori = (hsmp.get("r_payee_id_ori") == null) ? "" : hsmp.get(
				"r_payee_id_ori").trim();
		r_payee_name_ori = (hsmp.get("r_payee_name_ori") == null) ? "" : hsmp
				.get("r_payee_name_ori").trim();
		r_payee_id_new = (hsmp.get("r_payee_id_new") == null) ? "" : hsmp.get(
				"r_payee_id_new").trim();
		r_payee_name_new = (hsmp.get("r_payee_name_new") == null) ? "" : hsmp
				.get("r_payee_name_new").trim();
		r_remit_title = (hsmp.get("r_remit_title") == null) ? "" : hsmp.get(
				"r_remit_title").trim();
		r_remit_account = (hsmp.get("r_remit_account") == null) ? "" : hsmp
				.get("r_remit_account").trim();
		r_pay_desc = (hsmp.get("r_pay_desc") == null) ? "" : hsmp.get(
				"r_pay_desc").trim();

	}

	public String getR_result_ind() {
		return r_result_ind;
	}

	public void setR_result_ind(String r_result_ind) {
		this.r_result_ind = r_result_ind;
	}

	public String getR_check_no() {
		return r_check_no;
	}

	public void setR_check_no(String r_check_no) {
		this.r_check_no = r_check_no;
	}

	public String getR_payee_id_ori() {
		return r_payee_id_ori;
	}

	public void setR_payee_id_ori(String r_payee_id_ori) {
		this.r_payee_id_ori = r_payee_id_ori;
	}

	public String getR_payee_name_ori() {
		return r_payee_name_ori;
	}

	public void setR_payee_name_ori(String r_payee_name_ori) {
		this.r_payee_name_ori = r_payee_name_ori;
	}

	public String getR_payee_id_new() {
		return r_payee_id_new;
	}

	public void setR_payee_id_new(String r_payee_id_new) {
		this.r_payee_id_new = r_payee_id_new;
	}

	public String getR_payee_name_new() {
		return r_payee_name_new;
	}

	public void setR_payee_name_new(String r_payee_name_new) {
		this.r_payee_name_new = r_payee_name_new;
	}

	public String getR_remit_title() {
		return r_remit_title;
	}

	public void setR_remit_title(String r_remit_title) {
		this.r_remit_title = r_remit_title;
	}

	public String getR_remit_account() {
		return r_remit_account;
	}

	public void setR_remit_account(String r_remit_account) {
		this.r_remit_account = r_remit_account;
	}

	public String getR_pay_desc() {
		return r_pay_desc;
	}

	public void setR_pay_desc(String r_pay_desc) {
		this.r_pay_desc = r_pay_desc;
	}

}
