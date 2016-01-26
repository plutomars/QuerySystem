package query.model.PoDetail;
/**
 * @ * @author cora
 * 
 * @version 1.0<br>
 *          100/11/11<br>
 *          EC ATM帳戶查詢--被保險人or保單list cc194i
 * @since 1.0
 */
import java.util.HashMap;


public class PoDetailECinsured {
    private String result_ind;
    private String insured_id;
    private String insured_name;
    private String policy_no;
    private String po_sts_code;
    private String active_sw;
    private String bank_id;
    private String account_no;

	public PoDetailECinsured(HashMap<String, String> hsmp) {
		result_ind = (hsmp.get("r_result_ind") == null) ? "" : hsmp.get(
				"r_result_ind").trim();
		insured_id = (hsmp.get("r_insured_id") == null) ? "" : hsmp.get("r_insured_id").trim();
		insured_name = (hsmp.get("r_insured_name") == null) ? "" : hsmp.get("r_insured_name").trim();
		policy_no = (hsmp.get("r_policy_no") == null) ? "" : hsmp.get("r_policy_no").trim();
		po_sts_code = (hsmp.get("r_po_sts_code") == null) ? "" : hsmp.get("r_po_sts_code").trim();
		active_sw = (hsmp.get("r_active_sw") == null) ? "" : hsmp.get("r_active_sw").trim();
		bank_id = (hsmp.get("r_bank_id") == null) ? "" : hsmp.get("r_bank_id").trim();
		account_no = (hsmp.get("r_account_no") == null) ? "" : hsmp.get("r_account_no").trim();
	}
	public String getResult_ind() {
		return result_ind;
	}

	public void setResult_ind(String result_ind) {
		this.result_ind = result_ind;
	}
	public String getinsured_id() {
        return insured_id; }
	public void setinsured_id(String insured_id) {

        this.insured_id = insured_id; }
	public String getinsured_name() {
        return insured_name; }
	public void setinsured_name(String insured_name) {

        this.insured_name = insured_name; }
	public String getpolicy_no() {
        return policy_no; }
	public void setpolicy_no(String policy_no) {

        this.policy_no = policy_no; }
	public String getpo_sts_code() {
        return po_sts_code; }
	public void setpo_sts_code(String po_sts_code) {
        this.po_sts_code = po_sts_code; }

	public String getactive_sw() {
        return active_sw; }
	public void setactive_sw(String active_sw) {
        this.active_sw = active_sw; }

	public String getbank_id() {
        return bank_id; }
	public void setbank_id(String bank_id) {
        this.bank_id = bank_id; }

	public String getaccount_no() {
        return account_no; }
	public void setaccount_no(String account_no) {
        this.account_no = account_no; }
}
