package query.model.PremProxy;

import java.util.HashMap;

public class PremProxy04 {
	private String result_ind;   // 查詢結果
	private String trf_end_date; // 暫停扣款迄月
	private String process_date; // 處理日期
	private String process_time; // 處理時間
	private String process_user; // 處理者(中文)

	public PremProxy04(HashMap<String, String> hsmp) {
		result_ind = (hsmp.get("r_result_ind") == null) ? "" : hsmp.get(
				"r_result_ind").trim();
		trf_end_date = (hsmp.get("r_trf_end_date") == null) ? "" : hsmp.get(
				"r_trf_end_date").trim();
		process_date = (hsmp.get("r_process_date") == null) ? "" : hsmp.get(
				"r_process_date").trim();
		process_time = (hsmp.get("r_process_time") == null) ? "" : hsmp.get(
				"r_process_time").trim();
		process_user = (hsmp.get("r_process_user") == null) ? "" : hsmp.get(
				"r_process_user").trim();
	}

	public String getResult_ind() {
		return result_ind;
	}

	public void setResult_ind(String result_ind) {
		this.result_ind = result_ind;
	}

	public String getTrf_end_date() {
		return trf_end_date;
	}

	public void setTrf_end_date(String trf_end_date) {
		this.trf_end_date = trf_end_date;
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

	public String getProcess_user() {
		return process_user;
	}

	public void setProcess_user(String process_user) {
		this.process_user = process_user;
	}


}
