package query.model.PremBldt;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 
 * @author cychu
 * 
 * @version 1.0<br/>
 * 			101/04/11<br/>
 * 			�e���O���d�ߡФJ�b���(JavaBean)
 * 
 * @since 1.0
 *
 */

public class PremBldt02 {
	private String result_ind;				//0_���G
	private String bill_no;					//1_�e���渹
	private String bill_date_from;			//2_��ú�O��
	private String modx_sequence;			//3_ú��
	private String gross_mode_prem;			//4_��l�O�O
	private String bldt_sts_date;			//5_�J�b���
	private String prem_disc;				//6_�O�O�馩
	private String prem_disc_perc;			//7_�馩�v
	
	public PremBldt02(HashMap<String, String> hsmp) {
		result_ind = (hsmp.get("r_result_ind") == null) ? "" : hsmp.get(
		"r_result_ind").trim();
		bill_no = (hsmp.get("r_bill_no") == null) ? "" : hsmp.get(
		"r_bill_no").trim();
		bill_date_from = (hsmp.get("r_bill_date_from") == null) ? "" : hsmp.get(
		"r_bill_date_from").trim();
		modx_sequence = (hsmp.get("r_modx_sequence") == null) ? "" : hsmp.get(
		"r_modx_sequence").trim();
		gross_mode_prem = (hsmp.get("r_gross_mode_prem") == null) ? "" : hsmp.get(
		"r_gross_mode_prem").trim();
		bldt_sts_date = (hsmp.get("r_bldt_sts_date") == null) ? "" : hsmp.get(
		"r_bldt_sts_date").trim();
		prem_disc = (hsmp.get("r_prem_disc") == null) ? "" : hsmp.get(
		"r_prem_disc").trim();
		prem_disc_perc = (hsmp.get("r_prem_disc_perc") == null) ? "" : hsmp.get(
		"r_prem_disc_perc").trim();
		
	}
	
	public String[] getValues() {
		ArrayList<String> valueList = new ArrayList<String>();

		valueList.add(bill_date_from);
		valueList.add(modx_sequence);
		valueList.add(gross_mode_prem);
		valueList.add(bldt_sts_date);
		valueList.add(prem_disc);
		valueList.add(prem_disc_perc);

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

	public String getBill_no() {
		return bill_no;
	}

	public void setBill_no(String bill_no) {
		this.bill_no = bill_no;
	}

	public String getBill_date_from() {
		return bill_date_from;
	}

	public void setBill_date_from(String bill_date_from) {
		this.bill_date_from = bill_date_from;
	}

	public String getModx_sequence() {
		return modx_sequence;
	}

	public void setModx_sequence(String modx_sequence) {
		this.modx_sequence = modx_sequence;
	}

	public String getGross_mode_prem() {
		return gross_mode_prem;
	}

	public void setGross_mode_prem(String gross_mode_prem) {
		this.gross_mode_prem = gross_mode_prem;
	}

	public String getBldt_sts_date() {
		return bldt_sts_date;
	}

	public void setBldt_sts_date(String bldt_sts_date) {
		this.bldt_sts_date = bldt_sts_date;
	}

	public String getPrem_disc() {
		return prem_disc;
	}

	public void setPrem_disc(String prem_disc) {
		this.prem_disc = prem_disc;
	}

	public String getPrem_disc_perc() {
		return prem_disc_perc;
	}

	public void setPrem_disc_perc(String prem_disc_perc) {
		this.prem_disc_perc = prem_disc_perc;
	}
}
