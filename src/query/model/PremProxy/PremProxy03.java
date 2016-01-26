package query.model.PremProxy;

import java.util.HashMap;

import query.model.AbstractModelObject;
/**
 * 
 * @author 陳冠瑜
 * 
 */
public class PremProxy03 extends AbstractModelObject {
	private String result_ind; // 查詢結果
	private String return_no; // 歸檔號碼
	private String return_type; // 歸檔類別
	private String return_date; // 歸檔日期
	private String return_user; // 歸檔者(user)
	private String receive_no; // 受理號碼 101-10-03新增
	private String return_reason; //歸檔原因 101-10-03新增

	public PremProxy03(HashMap<String, String> hsmp) {
		result_ind = (hsmp.get("r_result_ind") == null) ? "" : hsmp.get(
				"r_result_ind").trim();
		return_no = (hsmp.get("r_return_no") == null) ? "" : hsmp.get(
				"r_return_no").trim();
		return_type = (hsmp.get("r_return_type") == null) ? "" : hsmp.get(
				"r_return_type").trim();
		return_date = (hsmp.get("r_return_date") == null) ? "" : hsmp.get(
				"r_return_date").trim();
		return_user = (hsmp.get("r_return_user") == null) ? "" : hsmp.get(
				"r_return_user").trim();
		receive_no = (hsmp.get("r_receive_no") == null) ? "" : hsmp.get(
				"r_receive_no").trim();
		return_reason = (hsmp.get("r_return_reason") == null) ? "" : hsmp.get(
				"r_return_reason").trim();
		
	}

	public String getReceive_no() {
		return receive_no;
	}

	public void setReceive_no(String receive_no) {
		this.receive_no = receive_no;
	}

	public String getReturn_reason() {
		return return_reason;
	}

	public void setReturn_reason(String return_reason) {
		this.return_reason = return_reason;
	}

	public String getResult_ind() {
		return result_ind;
	}

	public void setResult_ind(String result_ind) {
		this.result_ind = result_ind;
	}

	public String getReturn_no() {
		return return_no;
	}

	public void setReturn_no(String return_no) {
		this.return_no = return_no;
	}

	public String getReturn_type() {
		return return_type;
	}

	public void setReturn_type(String return_type) {
		this.return_type = return_type;
	}

	public String getReturn_date() {
		return return_date;
	}

	public void setReturn_date(String return_date) {
		this.return_date = return_date;
	}

	public String getReturn_user() {
		return return_user;
	}

	public void setReturn_user(String return_user) {
		this.return_user = return_user;
	}

}
