package query.model.PremReject;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 
 * @author cychu
 *
 * @version 1.0
 *          101/03/21
 *          授權書、委託書退件明細查詢(JavaBean)
 *          
 * @since 1.0
 */

public class PremReject01 {
	private String result_ind;			//0_查詢結果
	private String policy_no;			//1_保單號碼
	private String group_desc;			//2_[新集彙件]描述
	private String reject_desc;			//3_退件狀態描述
	private String process_date;		//4_處理日期
	private String process_time;		//5_處理時間
	private String pcce_sts_desc;		//6_退件類別訊息
	
	private String attention_ind;		//7_要保人指示
	private String o1_name;				//8_要保人姓名
	private String o1_id;				//9_要保人ID
	
	private String agent_ind;			//10_業務員指示
	private String agent_name;			//11_業務員姓名
	private String agent_code;			//12_業務員代碼
	private String agent_dept;			//13_業務員營業處代碼
	
	private String send_user_ind;		//14_代辦人指示
	private String send_user_name;		//15_代辦人姓名
	private String send_user_id;		//16_代辦人ID
	private String send_user_dept;		//17_代辦人營業處代碼
	private String send_user_desc;		//18_代辦人狀態描述
	
	public PremReject01(HashMap<String, String> hsmp) {
		result_ind = (hsmp.get("r_result_ind") == null) ? "" : hsmp.get(
		"r_result_ind").trim();
		policy_no = (hsmp.get("r_policy_no") == null) ? "" : hsmp.get(
		"r_policy_no").trim();
		group_desc = (hsmp.get("r_group_desc") == null) ? "" : hsmp.get(
		"r_group_desc").trim();
		reject_desc = (hsmp.get("r_reject_desc") == null) ? "" : hsmp.get(
		"r_reject_desc").trim();
		process_date = (hsmp.get("r_process_date") == null) ? "" : hsmp.get(
		"r_process_date").trim();
		process_time = (hsmp.get("r_process_timed") == null) ? "" : hsmp.get(
		"r_process_time").trim();
		pcce_sts_desc = (hsmp.get("r_pcce_sts_desc") == null) ? "" : hsmp.get(
		"r_pcce_sts_desc").trim();
		
		attention_ind = (hsmp.get("r_attention_ind") == null) ? "" : hsmp.get(
		"r_attention_ind").trim();
		o1_name = (hsmp.get("r_o1_name") == null) ? "" : hsmp.get(
		"r_o1_name").trim();
		o1_id = (hsmp.get("r_o1_id") == null) ? "" : hsmp.get(
		"r_o1_id").trim();
		
		agent_ind = (hsmp.get("r_agent_ind") == null) ? "" : hsmp.get(
		"r_agent_ind").trim();
		agent_name = (hsmp.get("r_agent_name") == null) ? "" : hsmp.get(
		"r_agent_name").trim();
		agent_code = (hsmp.get("r_agent_code") == null) ? "" : hsmp.get(
		"r_agent_code").trim();
		agent_dept = (hsmp.get("r_agent_dept") == null) ? "" : hsmp.get(
		"r_agent_dept").trim();
		
		send_user_ind = (hsmp.get("r_send_user_ind") == null) ? "" : hsmp.get(
		"r_send_user_ind").trim();
		send_user_name = (hsmp.get("r_send_user_name") == null) ? "" : hsmp.get(
		"r_send_user_name").trim();
		send_user_id = (hsmp.get("r_send_user_id") == null) ? "" : hsmp.get(
		"r_send_user_id").trim();
		send_user_dept = (hsmp.get("r_send_user_dept") == null) ? "" : hsmp.get(
		"r_send_user_dept").trim();
		send_user_desc = (hsmp.get("r_send_user_desc") == null) ? "" : hsmp.get(
		"r_send_user_desc").trim();
	}
	
	public String[] getValues(int type) {
		ArrayList<String> valueList = new ArrayList<String>();

		switch (type) {
			case 1:
				valueList.add(attention_ind);
				valueList.add(o1_name);
				valueList.add(o1_id);
				break;
			case 2:
				valueList.add(agent_ind);
				valueList.add(agent_name);
				valueList.add(agent_code);
				valueList.add(agent_dept);
				break;
			case 3:
				valueList.add(send_user_ind);
				valueList.add(send_user_name);
				valueList.add(send_user_id);
				valueList.add(send_user_dept);
				valueList.add(send_user_desc);
				break;
		}
		String[] valueArray = new String[valueList.size()];
		valueList.toArray(valueArray);
		return valueArray;
	}

	public String getResult_ind() {
		return result_ind;
	}

	public void setResult_ind(String result_ind) {
		this.result_ind = result_ind;
	}

	public String getPolicy_no() {
		return policy_no;
	}

	public void setPolicy_no(String policy_no) {
		this.policy_no = policy_no;
	}

	public String getGroup_desc() {
		return group_desc;
	}

	public void setGroup_desc(String group_desc) {
		this.group_desc = group_desc;
	}

	public String getReject_desc() {
		return reject_desc;
	}

	public void setReject_desc(String reject_desc) {
		this.reject_desc = reject_desc;
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

	public String getPcce_sts_desc() {
		return pcce_sts_desc;
	}

	public void setPcce_sts_desc(String pcce_sts_desc) {
		this.pcce_sts_desc = pcce_sts_desc;
	}

	public String getAttention_ind() {
		return attention_ind;
	}

	public void setAttention_ind(String attention_ind) {
		this.attention_ind = attention_ind;
	}

	public String getO1_name() {
		return o1_name;
	}

	public void setO1_name(String o1_name) {
		this.o1_name = o1_name;
	}

	public String getO1_id() {
		return o1_id;
	}

	public void setO1_id(String o1_id) {
		this.o1_id = o1_id;
	}

	public String getAgent_ind() {
		return agent_ind;
	}

	public void setAgent_ind(String agent_ind) {
		this.agent_ind = agent_ind;
	}

	public String getAgent_name() {
		return agent_name;
	}

	public void setAgent_name(String agent_name) {
		this.agent_name = agent_name;
	}

	public String getAgent_code() {
		return agent_code;
	}

	public void setAgent_code(String agent_code) {
		this.agent_code = agent_code;
	}

	public String getAgent_dept() {
		return agent_dept;
	}

	public void setAgent_dept(String agent_dept) {
		this.agent_dept = agent_dept;
	}

	public String getSend_user_ind() {
		return send_user_ind;
	}

	public void setSend_user_ind(String send_user_ind) {
		this.send_user_ind = send_user_ind;
	}

	public String getSend_user_name() {
		return send_user_name;
	}

	public void setSend_user_name(String send_user_name) {
		this.send_user_name = send_user_name;
	}

	public String getSend_user_id() {
		return send_user_id;
	}

	public void setSend_user_id(String send_user_id) {
		this.send_user_id = send_user_id;
	}

	public String getSend_user_dept() {
		return send_user_dept;
	}

	public void setSend_user_dept(String send_user_dept) {
		this.send_user_dept = send_user_dept;
	}

	public String getSend_user_desc() {
		return send_user_desc;
	}

	public void setSend_user_desc(String send_user_desc) {
		this.send_user_desc = send_user_desc;
	}
}
