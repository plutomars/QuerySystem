package query.model.NewDetail;

import java.util.HashMap;

/**
 * 列管地址資料Query(JavaBean)
 * 顯示稽核地址資料 (相同地址的保單) cc235i
 * @author cora
 * 
 * @version 1.0<br>
 *          100/11/22<br>
 * @since 1.0
 */
public class NewDetailIllegalAddrPo {
    private String result_ind;
    private String policy_no;
    private String client_id;
    private String owner_name;
    private String pool_type;
    private String pool_desc;
    private String addr_ind;
    
	public NewDetailIllegalAddrPo(HashMap<String, String> hsmp) {
    result_ind = (hsmp.get("r_result_ind") == null) ? "" : hsmp.get("r_result_ind").trim();
    policy_no = (hsmp.get("r_policy_no") == null) ? "" : hsmp.get("r_policy_no").trim();
    client_id = (hsmp.get("r_client_id") == null) ? "" : hsmp.get("r_client_id").trim();
    owner_name = (hsmp.get("r_owner_name") == null) ? "" : hsmp.get("r_owner_name").trim();
    pool_type = (hsmp.get("r_pool_type") == null) ? "" : hsmp.get("r_pool_type").trim();
    pool_desc = (hsmp.get("r_pool_desc") == null) ? "" : hsmp.get("r_pool_desc").trim();
    addr_ind = (hsmp.get("r_addr_ind") == null) ? "" : hsmp.get("r_addr_ind").trim();
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

public String getclient_id() {
        return client_id;
}
public void setclient_id(String client_id) {
        this.client_id = client_id;
}

public String getowner_name() {
        return owner_name;
}
public void setowner_name(String owner_name) {
        this.owner_name = owner_name;
}

public String getpool_type() {
        return pool_type;
}
public void setpool_type(String pool_type) {
        this.pool_type = pool_type;
}

public String getpool_desc() {
    return pool_desc;
}
public void setpool_desc(String pool_desc) {
    this.pool_desc = pool_desc;
}

public String getaddr_ind() {
    return addr_ind;
}
public void setaddr_ind(String addr_ind) {
    this.addr_ind = addr_ind;
}

}
