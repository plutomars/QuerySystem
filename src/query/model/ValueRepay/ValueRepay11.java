package query.model.ValueRepay;

import java.util.HashMap;

/**
 * @author F1256819
 * @category �٥����^�^�� ��ú�O��
 */
public class ValueRepay11 {
	private String r_policy_no;// ���~����

	public ValueRepay11(HashMap<String, String> hsmp) {
		r_policy_no = (hsmp.get("r_policy_no") == null) ? "" : hsmp.get(
				"r_policy_no").trim();
	}

	public String getR_policy_no() {
		return r_policy_no;
	}

	public void setR_policy_no(String r_policy_no) {
		this.r_policy_no = r_policy_no;
	}

}
