package query.model.ClaimHistory;

import java.util.HashMap;

import query.model.AbstractModelObject;

/**
 * @ * @author FYYANG
 * 
 * @version 1.0<br>
 *          100/08/23<br>
 *          受益人(JavaBean)
 * @since 1.0
 */
public class ClaimHistory05 extends AbstractModelObject {
	private String r_result_ind;
	private String r_benf_id;
	private String r_benf_name;
	private String r_cl_divisor;
	private String r_cl_ratio;
	private String r_cl_dividend;
	private String r_claim_amt;
	private String r_defer_int;
	private String r_tax_withheld;
	private String r_disb_amt;
	private String r_remit_account;// 帳號
	private String r_country_desc;
	private String r_addition_premium; // ADD 102.06.19 補充保費
	
	private String zip_code = "";
	private String address = "";
	private String r_i1_rela_with_benf;
	// 受益人地址
	private String tel_1 = "";
	private String hand_tel = "";
	private String beg_date = "";
	private String end_date = "";
	// 受益人外幣帳戶 101/03/26 new by jnd115
	private String r_result_ind1 = ""; // 查詢結果
	private String r_payee_id = ""; // 受款人ID
	private String r_payee_cht = ""; // 受款人中文名
	private String r_payee = ""; // 受款人英文名
	private String r_swift_code = ""; // SWIFT CODE
	private String r_bank_code = ""; // 銀行代碼
	private String r_bank_name = ""; // 銀行中文名稱
	private String r_bank_name_e = ""; // 銀行英文名稱
	private String r_bank_address_e = ""; // 銀行地址
	private String r_remit_account_e = "";// 匯款帳號
	private String r_disb_fee = ""; // 手續費(含說明)
	

	public ClaimHistory05(HashMap<String, String> hsmp) {
		r_result_ind = (hsmp.get("r_result_ind") == null) ? "" : hsmp.get(
				"r_result_ind").trim();
		r_benf_id = (hsmp.get("r_benf_id") == null) ? "" : hsmp
				.get("r_benf_id").trim();
		r_benf_name = (hsmp.get("r_benf_name") == null) ? "" : hsmp.get(
				"r_benf_name").trim();
		r_cl_dividend = (hsmp.get("r_cl_dividend") == null) ? "" : hsmp.get(
				"r_cl_dividend").trim();
		r_cl_divisor = (hsmp.get("r_cl_divisor") == null) ? "" : hsmp.get(
				"r_cl_divisor").trim();
		r_cl_ratio = (hsmp.get("r_cl_ratio") == null) ? "" : hsmp.get(
				"r_cl_ratio").trim();
		r_claim_amt = (hsmp.get("r_claim_amt") == null) ? "" : hsmp.get(
				"r_claim_amt").trim();
		r_defer_int = (hsmp.get("r_defer_int") == null) ? "" : hsmp.get(
				"r_defer_int").trim();
		r_tax_withheld = (hsmp.get("r_tax_withheld") == null) ? "" : hsmp.get(
				"r_tax_withheld").trim();
		r_disb_amt = (hsmp.get("r_disb_amt") == null) ? "" : hsmp.get(
				"r_disb_amt").trim();
		r_remit_account = (hsmp.get("r_remit_account") == null) ? "" : hsmp
				.get("r_remit_account").trim();
		r_country_desc = (hsmp.get("r_country_desc") == null) ? "" : hsmp.get(
				"r_country_desc").trim();
		r_i1_rela_with_benf = (hsmp.get("r_i1_rela_with_benf") == null ? "" : hsmp.get(
				"r_i1_rela_with_benf").trim());
		r_addition_premium = (hsmp.get("r_addition_premium") == null) ? "" : hsmp.get(
				"r_addition_premium").trim(); // ADD 102.06.19 補充保費
		
       
		
		// 依理賠要求,帳號初始值加上-
		if (r_remit_account.length() > 7) {
			r_remit_account = r_remit_account.substring(0, 3) + "-"
					+ r_remit_account.substring(3, 7) + "-"
					+ r_remit_account.substring(7, r_remit_account.length());
		}

	}

	public void setBenfAddr(HashMap<String, String> hsmp) {
		zip_code = (hsmp.get("zip_code") == null) ? "" : hsmp.get("zip_code")
				.trim();
		address = (hsmp.get("address") == null) ? "" : hsmp.get("address")
				.trim();
		tel_1 = (hsmp.get("tel_1") == null) ? "" : hsmp.get("tel_1").trim();
		hand_tel = (hsmp.get("hand_tel") == null) ? "" : hsmp.get("hand_tel")
				.trim();
		beg_date = (hsmp.get("beg_date") == null) ? "" : hsmp.get("beg_date")
				.trim();
		end_date = (hsmp.get("end_date") == null) ? "" : hsmp.get("end_date")
				.trim();
//		System.out.print(zip_code + "\t");
//		System.out.print(address + "\t");
//		System.out.print(tel_1 + "\t");
//		System.out.print(hand_tel + "\t");
	}
	
	public String[] getBenfAddr() {
		String combineDate = "";
		if (beg_date.length() != 0 && end_date.length() != 0)
			combineDate = beg_date + " ~ " + end_date;
		return new String[] { zip_code, address, tel_1, hand_tel, combineDate };
	}
	// 101/03/26 new by jnd115
	public void setBenfAcct(HashMap<String, String> hsmp) {
		r_result_ind1 = (hsmp.get("r_result_ind") == null) ? "" : hsmp.get(
				"r_result_ind").trim();
		r_payee_id = (hsmp.get("r_payee_id") == null) ? "" : hsmp.get(
				"r_payee_id").trim();
		r_payee_cht = (hsmp.get("r_payee_cht") == null) ? "" : hsmp.get(
				"r_payee_cht").trim();
		r_payee = (hsmp.get("r_payee") == null) ? "" : hsmp.get("r_payee")
				.trim();
		r_swift_code = (hsmp.get("r_swift_code") == null) ? "" : hsmp.get(
				"r_swift_code").trim();
		r_bank_code = (hsmp.get("r_bank_code") == null) ? "" : hsmp.get(
				"r_bank_code").trim();
		r_bank_name = (hsmp.get("r_bank_name") == null) ? "" : hsmp.get(
				"r_bank_name").trim();
		r_bank_name_e = (hsmp.get("r_bank_name_e") == null) ? "" : hsmp.get(
				"r_bank_name_e").trim();
		r_bank_address_e = (hsmp.get("r_bank_address_e") == null) ? "" : hsmp
				.get("r_bank_address_e").trim();
		r_remit_account_e = (hsmp.get("r_remit_account") == null) ? "" : hsmp
				.get("r_remit_account").trim();
		r_disb_fee = (hsmp.get("r_disb_fee") == null) ? "" : hsmp.get(
				"r_disb_fee").trim();
	}
	
	
	// 101/03/26 new by jnd115
	public String[] getBenfAcct() {
		return new String[] { r_payee, r_swift_code + "  " + r_bank_name,
				r_bank_code + "  " + r_bank_name_e, r_bank_address_e,
				r_remit_account_e };
	}
	
	public String getR_result_ind() {
		return r_result_ind;
	}

	public void setR_result_ind(String r_result_ind) {
		this.r_result_ind = r_result_ind;
	}

	public String getR_benf_id() {
		return r_benf_id;
	}

	public void setR_benf_id(String r_benf_id) {
		this.r_benf_id = r_benf_id;
	}

	public String getR_benf_name() {
		return r_benf_name;
	}

	public void setR_benf_name(String r_benf_name) {
		this.r_benf_name = r_benf_name;
	}

	public String getR_cl_ratio() {
		return r_cl_ratio;
	}

	public void setR_cl_ratio(String r_cl_ratio) {
		this.r_cl_ratio = r_cl_ratio;
	}

	public String getR_claim_amt() {
		return r_claim_amt;
	}

	public void setR_claim_amt(String r_claim_amt) {
		this.r_claim_amt = r_claim_amt;
	}

	public String getR_defer_int() {
		return r_defer_int;
	}

	public void setR_defer_int(String r_defer_int) {
		this.r_defer_int = r_defer_int;
	}

	public String getR_tax_withheld() {
		return r_tax_withheld;
	}

	public void setR_tax_withheld(String r_tax_withheld) {
		this.r_tax_withheld = r_tax_withheld;
	}
	public String getR_addition_premium() { // ADD 102.06.19 補充保費
		return r_addition_premium;
	}
	public void setR_addition_premium(String r_addition_premium) {
		this.r_addition_premium = r_addition_premium;
	}
	
	public String getR_disb_amt() {
		return r_disb_amt;
	}

	public void setR_disb_amt(String r_disb_amt) {
		this.r_disb_amt = r_disb_amt;
	}

	public String getR_remit_account() {
		return r_remit_account;
	}

	public void setR_remit_account(String r_remit_account) {
		// this.r_remit_account = r_remit_account;.
		String oldValue = this.r_remit_account;
		this.r_remit_account = r_remit_account;
		// claimHistory05s = new ArrayList<ClaimHistory05>(claimHistory05s);
		// claimHistory05s.add(claimHistory05);

		firePropertyChange("r_remit_account", oldValue, r_remit_account);
	}

	public String getR_cl_divisor() {
		return r_cl_divisor;
	}

	public void setR_cl_divisor(String r_cl_divisor) {
		this.r_cl_divisor = r_cl_divisor;
	}

	public String getR_cl_dividend() {
		return r_cl_dividend;
	}

	public void setR_cl_dividend(String r_cl_dividend) {
		this.r_cl_dividend = r_cl_dividend;
	}

	public String getR_country_desc() {
		return r_country_desc;
	}

	public void setR_country_desc(String r_country_desc) {
		this.r_country_desc = r_country_desc;
	}

	public String getZip_code() {
		return zip_code;
	}

	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel_1() {
		return tel_1;
	}

	public void setTel_1(String tel_1) {
		this.tel_1 = tel_1;
	}

	public String getHand_tel() {
		return hand_tel;
	}

	public void setHand_tel(String hand_tel) {
		this.hand_tel = hand_tel;
	}

	public String getBeg_date() {
		return beg_date;
	}

	public void setBeg_date(String beg_date) {
		this.beg_date = beg_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public String getR_result_ind1() {
		return r_result_ind1;
	}

	public void setR_result_ind1(String r_result_ind1) {
		this.r_result_ind1 = r_result_ind1;
	}

	public String getR_payee_id() {
		return r_payee_id;
	}

	public void setR_payee_id(String r_payee_id) {
		this.r_payee_id = r_payee_id;
	}

	public String getR_payee_cht() {
		return r_payee_cht;
	}

	public void setR_payee_cht(String r_payee_cht) {
		this.r_payee_cht = r_payee_cht;
	}

	public String getR_payee() {
		return r_payee;
	}

	public void setR_payee(String r_payee) {
		this.r_payee = r_payee;
	}

	public String getR_swift_code() {
		return r_swift_code;
	}

	public void setR_swift_code(String r_swift_code) {
		this.r_swift_code = r_swift_code;
	}

	public String getR_bank_code() {
		return r_bank_code;
	}

	public void setR_bank_code(String r_bank_code) {
		this.r_bank_code = r_bank_code;
	}

	public String getR_bank_name() {
		return r_bank_name;
	}

	public void setR_bank_name(String r_bank_name) {
		this.r_bank_name = r_bank_name;
	}

	public String getR_bank_name_e() {
		return r_bank_name_e;
	}

	public void setR_bank_name_e(String r_bank_name_e) {
		this.r_bank_name_e = r_bank_name_e;
	}

	public String getR_bank_address_e() {
		return r_bank_address_e;
	}

	public void setR_bank_address_e(String r_bank_address_e) {
		this.r_bank_address_e = r_bank_address_e;
	}

	public String getR_remit_account_e() {
		return r_remit_account_e;
	}

	public void setR_remit_account_e(String r_remit_account_e) {
		this.r_remit_account_e = r_remit_account_e;
	}

	public String getR_disb_fee() {
		return r_disb_fee;
	}

	public void setR_disb_fee(String r_disb_fee) {
		this.r_disb_fee = r_disb_fee;
	}

	public String getR_i1_rela_with_benf() {
		return r_i1_rela_with_benf;
	}

	public void setR_i1_rela_with_benf(String i1_rela_with_benf) {
		this.r_i1_rela_with_benf = i1_rela_with_benf;
	}
}
