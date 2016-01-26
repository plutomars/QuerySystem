package query.model.ClientInfo;

import java.util.HashMap;

public class ClientInfo03 {
    private String policy_no;
    private String po_sts_desc;    
    private String i1_id;
    private String i1_name;
    private String home_addr;
    private String home_zip;
    private String home_sts;
    private String mail_addr;
    private String mail_sts;
    private String mail_addr_ind;
    private String home_addr_ind;
	private String pmia_sts;
    
	public ClientInfo03(HashMap<String, String> hsmp) {
	    policy_no     = (hsmp.get("policy_no") == null) ? "" : hsmp.get("policy_no").trim();
	    po_sts_desc   = (hsmp.get("po_sts_desc") == null) ? "" : hsmp.get("po_sts_desc").trim();
	    i1_id 	      = (hsmp.get("i1_id") == null) ? "" : hsmp.get("i1_id").trim();
	    i1_name 	  = (hsmp.get("i1_name") == null) ? "" : hsmp.get("i1_name").trim();
	    home_addr 	  = (hsmp.get("home_addr") == null) ? "" : hsmp.get("home_addr").trim();
	    home_zip 	  = (hsmp.get("home_zip") == null) ? "" : hsmp.get("home_zip").trim();
	    home_sts 	  = (hsmp.get("home_sts") == null) ? "" : hsmp.get("home_sts").trim();
	    mail_addr 	  = (hsmp.get("mail_addr") == null) ? "" : hsmp.get("mail_addr").trim();
	    mail_sts 	  = (hsmp.get("mail_sts") == null) ? "" : hsmp.get("mail_sts").trim();
	    mail_addr_ind = (hsmp.get("mail_addr_ind") == null) ? "" : hsmp.get("mail_addr_ind").trim();
	    home_addr_ind = (hsmp.get("home_addr_ind") == null) ? "" : hsmp.get("home_addr_ind").trim();
	    pmia_sts 	  = (hsmp.get("pmia_sts") == null) ? "" : hsmp.get("pmia_sts").trim();
//	    other_prob = (hsmp.get("r_other_prob") == null) ? "" : hsmp.get("r_other_prob").trim();
	}
	
	public String getpolicy_no() {
        return policy_no;
    }
	public void setpolicy_no(String policy_no) {
        this.policy_no = policy_no;
	}

	public String getpo_sts_desc() {
	    return po_sts_desc;
	}
	public void setpo_sts_desc(String po_sts_desc) {
	    this.po_sts_desc = po_sts_desc;
	}
	
	public String geti1_id() {
	    return i1_id;
	}
	public void seti1_id(String i1_id) {
	    this.i1_id = i1_id;
	}
	
	public String geti1_name() {
	    return i1_name;
	}
	public void seti1_name(String i1_name) {
	    this.i1_name = i1_name;
	}
	
	public String gethome_addr() {
	    return home_addr;
	}
	public void sethome_addr(String home_addr) {
	    this.home_addr = home_addr;
	}
	
	public String gethome_zip() {
	    return home_zip;
	}
	public void sethome_zip(String home_zip) {
	    this.home_zip = home_zip;
	}
	
	public String gethome_sts() {
	    return home_sts;
	}
	public void sethome_sts(String home_sts) {
	    this.home_sts = home_sts;
	}
	
	public String getmail_addr() {
	    return mail_addr;
	}
	public void setmail_addr(String mail_addr) {
	    this.mail_addr = mail_addr;
	}
	
	public String getmail_sts() {
	    return mail_sts;
	}
	public void setmail_sts(String mail_sts) {
	    this.mail_sts = mail_sts;
	}
	
	public String getmail_addr_ind() {
	    return mail_addr_ind;
	}
	public void setmail_addr_ind(String mail_addr_ind) {
	    this.mail_addr_ind = mail_addr_ind;
	}
	
	public String gethome_addr_ind() {
	    return home_addr_ind;
	}
	public void sethome_addr_ind(String home_addr_ind) {
	    this.home_addr_ind = home_addr_ind;
	}
	
	public String getpmia_sts() {
		return pmia_sts;
	}

	public void setpmia_sts(String pmia_sts) {
		this.pmia_sts = pmia_sts;
	}
	
//	public String getother_prob() {
//	    return other_prob;
//	}
//	public void setother_prob(String other_prob) {
//	    this.other_prob = other_prob;
//	}
	
}
