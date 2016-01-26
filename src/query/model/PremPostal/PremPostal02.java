package query.model.PremPostal;
import java.util.HashMap;

public class PremPostal02 {
	private String result_ind;
	private String seq;
	private String source_desc;
	private String transfer_date;
	private String transfer_amt;
	private String bill_date_from;
	private String mode_prem;
	private String store_name;
	private String store_other;
	private String tran_date;
	private String tran_sts;
	private String pcrc_key;
    private String policy_no;
    private String postal_desc;
	
	public PremPostal02(HashMap<String, String> hsmp) {
		result_ind = (hsmp.get("r_result_ind") == null) ? "" : hsmp.get(
				"r_result_ind").trim();
		seq = (hsmp.get("r_seq") == null) ? "" : hsmp.get("r_seq").trim();
		source_desc = (hsmp.get("r_source_desc") == null) ? "" : hsmp.get(
				"r_source_desc").trim();
		transfer_date = (hsmp.get("r_transfer_date") == null) ? "" : hsmp.get(
				"r_transfer_date").trim();
		transfer_amt = (hsmp.get("r_transfer_amt") == null) ? "" : hsmp.get(
				"r_transfer_amt").trim();
		bill_date_from = (hsmp.get("r_bill_date_from") == null) ? "" : hsmp.get(
				"r_bill_date_from").trim();
		mode_prem = (hsmp.get("r_mode_prem") == null) ? "" : hsmp.get(
				"r_mode_prem").trim();
		store_name = (hsmp.get("r_store_name") == null) ? "" : hsmp.get(
				"r_store_name").trim();
		store_other = (hsmp.get("r_store_other") == null) ? "" : hsmp.get(
				"r_store_other").trim();
		tran_date = (hsmp.get("r_tran_date") == null) ? "" : hsmp.get(
				"r_tran_date").trim();
		tran_sts = (hsmp.get("r_tran_sts") == null) ? "" : hsmp.get(
				"r_tran_sts").trim();
		pcrc_key = (hsmp.get("r_pcrc_key") == null) ? "" : hsmp.get(
				"r_pcrc_key").trim();
	    policy_no = (hsmp.get("r_policy_no") == null) ? "" : hsmp.get("r_policy_no").trim();
	    postal_desc = (hsmp.get("r_postal_desc") == null) ? "" : hsmp.get("r_postal_desc").trim();

	}
	
	public String getResult_ind() {
		return result_ind;
	}

	public void setResult_ind(String result_ind) {
		this.result_ind = result_ind;
	}
	
    public String getseq() {
        return seq;
    }

    public void setseq(String seq) {
        this.seq = seq;
    }

    public String getsource_desc() {
        return source_desc;
    }

    public void setsource_desc(String source_desc) {
        this.source_desc = source_desc;
    }

    public String gettransfer_date() {
        return transfer_date;
    }

    public void settransfer_date(String transfer_date) {
        this.transfer_date = transfer_date;
    }

    public String gettransfer_amt() {
        return transfer_amt;
    }

    public void settransfer_amt(String transfer_amt) {
        this.transfer_amt = transfer_amt;
    }

    public String getbill_date_from() {
    	return bill_date_from;
    }

    public void setbill_date_from(String bill_date_from) {
    	this.bill_date_from = bill_date_from;
    }

    public String getmode_prem() {
    	return mode_prem;
    }

    public void setmode_prem(String mode_prem) {
    	this.mode_prem = mode_prem;
    }

    public String getstore_name() {
    	return store_name;
    }

    public void setstore_name(String store_name) {
    	this.store_name = store_name;
    }

    public String getstore_other() {
    	return store_other;
    }

    public void setstore_other(String store_other) {
    	this.store_other = store_other;
    }

    public String gettran_date() {
    	return tran_date;
    }

    public void settran_date(String tran_date) {
    	this.tran_date = tran_date;
    }

    public String gettran_sts() {
    	return tran_sts;
    }	

    public void settran_sts(String tran_sts) {
    	this.tran_sts = tran_sts;
    }

	public String getpcrc_key() {
		return pcrc_key;
	}

	public void setpcrc_key(String pcrc_key) {
		this.pcrc_key = pcrc_key;
	}
	
	public String getpolicy_no() {
        return policy_no;
	}
	public void setpolicy_no(String policy_no) {
        this.policy_no = policy_no;
	}

	public String getpostal_desc() {
        return postal_desc;
	}
	public void setpostal_desc(String postal_desc) {
        this.postal_desc = postal_desc;
	}
}
