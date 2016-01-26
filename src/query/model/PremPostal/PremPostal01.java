package query.model.PremPostal;
import java.util.ArrayList;
import java.util.HashMap;

public class PremPostal01 {
    private String policy_no;
    private String po_sts_desc;
    private String method_desc;
    private String prem_susp;
    private String owner_name;
    private String insured_name;
    private String modx_desc;
    private String po_issue_date;
    private String paid_to_date;
    private String gross_mode_prem;
    private String div_amt;
	private String currency;

	public PremPostal01(){
		
	}
	
	public void setValues(HashMap<String, String> hsmp) {
		policy_no = (hsmp.get("policy_no") == null) ? "" : hsmp.get(
                "policy_no").trim();
		po_sts_desc = (hsmp.get("po_sts_desc") == null) ? "" : hsmp.get(
                "po_sts_desc").trim();
		method_desc = (hsmp.get("method_desc") == null) ? "" : hsmp.get(
                "method_desc").trim();
		prem_susp = (hsmp.get("prem_susp") == null) ? "" : hsmp.get(
                "prem_susp").trim();
		owner_name = (hsmp.get("owner_name") == null) ? "" : hsmp.get(
                "owner_name").trim();
		insured_name = (hsmp.get("insured_name") == null) ? "" : hsmp.get(
                "insured_name").trim();
		modx_desc = (hsmp.get("modx_desc") == null) ? "" : hsmp.get(
                "modx_desc").trim();
		po_issue_date = (hsmp.get("po_issue_date") == null) ? "" : hsmp.get(
                "po_issue_date").trim();
		paid_to_date = (hsmp.get("paid_to_date") == null) ? "" : hsmp.get(
                "paid_to_date").trim();
		gross_mode_prem = (hsmp.get("gross_mode_prem") == null) ? "" : hsmp.get(
                "gross_mode_prem").trim();
		div_amt = (hsmp.get("div_amt") == null) ? "" : hsmp.get("div_amt").trim();
		currency = (hsmp.get("r_currency") == null) ? "" : hsmp.get("r_currency").trim();

	}
	
	public String[] getValues(int type) {
		ArrayList<String> valueList = new ArrayList<String>();

		switch (type) {
			case 1:
				valueList.add(policy_no);
				valueList.add(po_sts_desc);
				valueList.add(method_desc);
				valueList.add(prem_susp);
				break;
			case 2:
				valueList.add(owner_name);
				valueList.add(insured_name);
				valueList.add(modx_desc);
				valueList.add("");
				break;
			case 3:
				valueList.add(po_issue_date);
				valueList.add(paid_to_date);
				valueList.add(gross_mode_prem);
				valueList.add(div_amt);
				break;
		}
		String[] valueArray = new String[valueList.size()];
		valueList.toArray(valueArray);
		
		return valueArray;
	}
	
	public String[] clearAll()	{
		String[] valueArray = {"","","",""};
		return valueArray ;
		
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

    public String getmethod_desc() {
        return method_desc;
    }

    public void setmethod_desc(String method_desc) {
        this.method_desc = method_desc;
    }

    public String getprem_susp() {
        return prem_susp;
    }

    public void setprem_susp(String prem_susp) {
        this.prem_susp = prem_susp;
    }

    public String getowner_name() {
    	return owner_name;
    }

    public void setowner_name(String owner_name) {
    	this.owner_name = owner_name;
    }

    public String getinsured_name() {
    	return insured_name;
    }

    public void setinsured_name(String insured_name) {
    	this.insured_name = insured_name;
    }

    public String getmodx_desc() {
    	return modx_desc;
    }

    public void setmodx_desc(String modx_desc) {
    	this.modx_desc = modx_desc;
    }

    public String getpo_issue_date() {
    	return po_issue_date;
    }

    public void setpo_issue_date(String po_issue_date) {
    	this.po_issue_date = po_issue_date;
    }
    
    public String getpaid_to_date() {
    	return paid_to_date;
    }

    public void setpaid_to_date(String paid_to_date) {
    	this.paid_to_date = paid_to_date;
    }

    public String getgross_mode_prem() {
    	return gross_mode_prem;
    }

    public void setgross_mode_prem(String gross_mode_prem) {
    	this.gross_mode_prem = gross_mode_prem;
    }

    public String getdiv_amt() {
    	return div_amt;
    }

    public void setdiv_amt(String div_amt) {
    	this.div_amt = div_amt;
    }
    
	public String getcurrency() {
		return currency;
	}

	public void setcurrency(String currency) {
		this.currency = currency;
	}
}
