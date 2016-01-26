package query.model.PosEC;
import java.util.ArrayList;
import java.util.HashMap;
/**
 * 
 * @author cora 101/07/13
 * 
 */
public class PosECeclp {
	private String r_result_ind;     // ¬d¸ßµ²ªG
	private String r_policy_no;
	private String 	r_receive_no;
	private String 	r_txn_detail_old;
	private String 	r_txn_detail_new;

	public PosECeclp(HashMap<String, String> hsmp) {
		r_result_ind = (hsmp.get("r_result_ind") == null) ? "" : hsmp.get(
				"r_result_ind").trim();
		r_policy_no = (hsmp.get("r_policy_no") == null) ? "" : hsmp.get(
				"r_policy_no").trim();
		r_receive_no = (hsmp.get("r_receive_no") == null) ? "" : hsmp.get(
				"r_receive_no").trim();
		r_txn_detail_old = (hsmp.get("r_txn_detail_old") == null) ? "" : hsmp.get(
				"r_txn_detail_old").trim();
		r_txn_detail_new = (hsmp.get("r_txn_detail_new") == null) ? "" : hsmp.get(
				"r_txn_detail_new").trim();
	}
	
	public String getR_result_ind() {
		return r_result_ind;
	}

	public void setR_result_ind(String r_result_ind) {
		this.r_result_ind = r_result_ind;
	}
	
	public String getR_policy_no() {
		return r_policy_no;
	}

	public void setR_policy_no(String r_policy_no) {
		this.r_policy_no = r_policy_no;
	}
	
	public String getR_receive_no() {
		return r_receive_no;
	}

	public void setR_receive_no(String r_receive_no) {
		this.r_receive_no = r_receive_no;
	}
	
	public String getR_txn_detail_old() {
		return r_txn_detail_old;
	}

	public void setR_txn_detail_old(String r_txn_detail_old) {
		this.r_txn_detail_old = r_txn_detail_old;
	}
	
	public String getR_txn_detail_new() {
		return r_txn_detail_new;
	}

	public void setR_txn_detail_new(String r_txn_detail_new) {
		this.r_txn_detail_new = r_txn_detail_new;
	}
}
