package query.model.ClientInfo;

import java.util.HashMap;

/**
 * @ * @author cora
 * 
 * @version 100/11/18
 *          問題保單  cc231i
 * @since 1.0
 */
public class ClientInfo01 {
    private String result_ind;
    private String policy_no;
    private String restrained_code;
    private String restrained;
    private String restrained_desc;
    private String process_user;
    private String process_date;
    private String other_prob;
    
	public ClientInfo01(HashMap<String, String> hsmp) {
    result_ind = (hsmp.get("r_result_ind") == null) ? "" : hsmp.get("r_result_ind").trim();
    policy_no = (hsmp.get("r_policy_no") == null) ? "" : hsmp.get("r_policy_no").trim();
    restrained_code = (hsmp.get("r_restrained_code") == null) ? "" : hsmp.get("r_restrained_code").trim();
    restrained = (hsmp.get("r_restrained") == null) ? "" : hsmp.get("r_restrained").trim();
    restrained_desc = (hsmp.get("r_restrained_desc") == null) ? "" : hsmp.get("r_restrained_desc").trim();
    process_user = (hsmp.get("r_process_user") == null) ? "" : hsmp.get("r_process_user").trim();
    process_date = (hsmp.get("r_process_date") == null) ? "" : hsmp.get("r_process_date").trim();
    other_prob = (hsmp.get("r_other_prob") == null) ? "" : hsmp.get("r_other_prob").trim();
	}

public String getresult_ind() {
        return result_ind;
}
public void setresult_ind(String result_ind) {
        this.result_ind = result_ind;
}

public String getpolicy_no() {
        return policy_no;
}
public void setpolicy_no(String policy_no) {
        this.policy_no = policy_no;
}

public String getrestrained_code() {
        return restrained_code;
}
public void setrestrained_code(String restrained_code) {
        this.restrained_code = restrained_code;
}

public String getrestrained() {
        return restrained;
}
public void setrestrained(String restrained) {
        this.restrained = restrained;
}

public String getrestrained_desc() {
        return restrained_desc;
}
public void setrestrained_desc(String restrained_desc) {
        this.restrained_desc = restrained_desc;
}

public String getprocess_user() {
    return process_user;
}
public void setprocess_user(String process_user) {
    this.process_user = process_user;
}

public String getprocess_date() {
    return process_date;
}
public void setprocess_date(String process_date) {
    this.process_date = process_date;
}

public String getother_prob() {
    return other_prob;
}
public void setother_prob(String other_prob) {
    this.other_prob = other_prob;
}
}
