package query.model.NewDetail;

import java.util.HashMap;

/**
 * 列管地址資料Query(JavaBean)
 * 顯示相關業務員資料 cc236i
 * @author cora
 * 
 * @version 1.0<br>
 *          100/11/22<br>
 * @since 1.0
 */
public class NewDetailIllegalAddrAg {
    private String result_ind;
    private String client_ident;
    private String client_id;
    private String name;
    private String dept_code;
    private String level_title;
    
	public NewDetailIllegalAddrAg(HashMap<String, String> hsmp) {
	    result_ind = (hsmp.get("r_result_ind") == null) ? "" : hsmp.get("r_result_ind").trim();
	    client_ident = (hsmp.get("r_client_ident") == null) ? "" : hsmp.get("r_client_ident").trim();
	    client_id = (hsmp.get("r_client_id") == null) ? "" : hsmp.get("r_client_id").trim();
	    name = (hsmp.get("r_name") == null) ? "" : hsmp.get("r_name").trim();
	    dept_code = (hsmp.get("r_dept_code") == null) ? "" : hsmp.get("r_dept_code").trim();
	    level_title = (hsmp.get("r_level_title") == null) ? "" : hsmp.get("r_level_title").trim();
		}
	public String getresult_ind() {
        return result_ind;
}
public void setresult_ind(String result_ind) {
        this.result_ind = result_ind;
}

public String getclient_ident() {
        return client_ident;
}
public void setclient_ident(String client_ident) {
        this.client_ident = client_ident;
}

public String getclient_id() {
        return client_id;
}
public void setclient_id(String client_id) {
        this.client_id = client_id;
}

public String getname() {
        return name;
}
public void setname(String name) {
        this.name = name;
}

public String getdept_code() {
        return dept_code;
}
public void setdept_code(String dept_code) {
        this.dept_code = dept_code;
}

public String getlevel_title() {
    return level_title;
}
public void setlevel_title(String level_title) {
    this.level_title = level_title;
}

}
