package query.model.PoDetail;

import java.util.HashMap;

import query.model.AbstractModelObject;

/**
 * 保單明細
 * 
 * @author cora 100/08 101/01/10 新增e_mail_first:是否首次啟用ebilling
 */
public class PoDetailComm extends AbstractModelObject {
	private String result_ind;
	private String policy_no;
	private String po_sts_desc;
	private String modx_desc;
	private String method_desc;
	private String o1_id;
	private String o1_name;
	private String i1_id;
	private String i1_name;
	private String app_apply_date;
	private String po_issue_date;
	private String in_force_date;
	private String image_prn_date;
	private String home_addr;
	private String home_zip;
	private String home_tel;
	private String home_fax;
	private String home_sts; // 驗證狀態
	private String mail_addr;
	private String mail_zip;
	private String mail_tel;
	private String pmia_desc;
	private String mail_sts; // EBilling啟用狀態
	private String mobil_no;
	private String e_mail;
	private String e_mail_first;
	private String o1_birth;
	private String i1_birth;
	private String corridor_ind;
	private String rate_scale;
	private String currency;
	private String o1_occu;
	private String i1_occu;
	private String o1_sex;
	private String i1_sex;
	private String o1_rfm;
	private String i1_rfm;
	private String o1_sign_ptn_card;
	private String i1_sign_ptn_card;
	private String home_addr_ind; // 101/08/21 新增
	private String mail_addr_ind;

	private String income_o;
	private String income_i;
	private String income_f; // 105/01/12新增

	public PoDetailComm() {

	}

	/*
	 * public PoDetail(HashMap<String, String> hsmp) {
	 * setResult_ind((hsmp.get("r_result_ind") == null) ? "" : hsmp.get(
	 * "r_result_ind").trim()); setPolicy_no((hsmp.get("r_policy_no") == null) ?
	 * "" : hsmp.get( "r_policy_no").trim());
	 * setPo_sts_desc((hsmp.get("r_po_sts_desc") == null) ? "" : hsmp.get(
	 * "r_po_sts_desc").trim()); setModx_desc((hsmp.get("r_modx_desc") == null)
	 * ? "" : hsmp.get( "r_modx_desc").trim());
	 * setMethod_desc((hsmp.get("r_method_desc") == null) ? "" : hsmp.get(
	 * "r_method_desc").trim()); seto1_id((hsmp.get("r_O1_id") == null) ? "" :
	 * hsmp.get("r_O1_id") .trim()); seto1_name((hsmp.get("r_O1_name") == null)
	 * ? "" : hsmp.get("r_O1_name") .trim()); seti1_id((hsmp.get("r_I1_id") ==
	 * null) ? "" : hsmp.get("r_I1_id") .trim());
	 * seti1_name((hsmp.get("r_I1_name") == null) ? "" : hsmp.get("r_I1_name")
	 * .trim()); }
	 */

	public void setValues(HashMap<String, String> hsmp) {
		// public PoDetail(HashMap<String, String> hsmp) {
		setResult_ind((hsmp.get("r_result_ind") == null) ? "" : hsmp.get(
				"r_result_ind").trim());
		setPolicy_no((hsmp.get("r_policy_no") == null) ? "" : hsmp.get(
				"r_policy_no").trim());
		setPo_sts_desc((hsmp.get("r_po_sts_desc") == null) ? "" : hsmp.get(
				"r_po_sts_desc").trim());
		setModx_desc((hsmp.get("r_modx_desc") == null) ? "" : hsmp.get(
				"r_modx_desc").trim());
		setMethod_desc((hsmp.get("r_method_desc") == null) ? "" : hsmp.get(
				"r_method_desc").trim());
		seto1_id((hsmp.get("r_o1_id") == null) ? "" : hsmp.get("r_o1_id")
				.trim());
		seto1_sex((hsmp.get("o1_sex") == null) ? "" : hsmp.get("o1_sex").trim());
		seto1_name((hsmp.get("r_o1_name") == null) ? "" : hsmp.get("r_o1_name")
				.trim());
		seti1_id((hsmp.get("r_i1_id") == null) ? "" : hsmp.get("r_i1_id")
				.trim());
		seti1_sex((hsmp.get("i1_sex") == null) ? "" : hsmp.get("i1_sex").trim());
		seti1_name((hsmp.get("r_i1_name") == null) ? "" : hsmp.get("r_i1_name")
				.trim());
		setapp_apply_date((hsmp.get("r_app_apply_date") == null) ? "" : hsmp
				.get("r_app_apply_date").trim());
		setpo_issue_date((hsmp.get("r_po_issue_date") == null) ? "" : hsmp.get(
				"r_po_issue_date").trim());
		setin_force_date((hsmp.get("r_in_force_date") == null) ? "" : hsmp.get(
				"r_in_force_date").trim());
		setimage_prn_date((hsmp.get("r_image_prn_date") == null) ? "" : hsmp
				.get("r_image_prn_date").trim());
		sethome_addr((hsmp.get("r_home_addr") == null) ? "" : hsmp.get(
				"r_home_addr").trim());
		sethome_zip((hsmp.get("r_home_zip") == null) ? "" : hsmp.get(
				"r_home_zip").trim());
		sethome_tel((hsmp.get("r_home_tel") == null) ? "" : hsmp.get(
				"r_home_tel").trim());
		sethome_fax((hsmp.get("r_home_fax") == null) ? "" : hsmp.get(
				"r_home_fax").trim());
		sethome_sts((hsmp.get("r_home_sts") == null) ? "" : hsmp.get(
				"r_home_sts").trim());

		setmail_addr((hsmp.get("r_mail_addr") == null) ? "" : hsmp.get(
				"r_mail_addr").trim());
		setmail_zip((hsmp.get("r_mail_zip") == null) ? "" : hsmp.get(
				"r_mail_zip").trim());
		setmail_tel((hsmp.get("r_mail_tel") == null) ? "" : hsmp.get(
				"r_mail_tel").trim());
		setpmia_desc((hsmp.get("r_pmia_desc") == null) ? "" : hsmp.get(
				"r_pmia_desc").trim());
		sete_mail_first((hsmp.get("r_e_mail_first") == null) ? "" : hsmp.get(
				"r_e_mail_first").trim());
		setmail_sts((hsmp.get("r_mail_sts") == null) ? "" : hsmp.get(
				"r_mail_sts").trim());
		setmobil_no((hsmp.get("r_mobil_no") == null) ? "" : hsmp.get(
				"r_mobil_no").trim());
		sete_mail((hsmp.get("r_e_mail") == null) ? "" : hsmp.get("r_e_mail")
				.trim());
		seto1_birth((hsmp.get("r_o1_birth") == null) ? "" : hsmp.get(
				"r_o1_birth").trim());
		seti1_birth((hsmp.get("r_i1_birth") == null) ? "" : hsmp.get(
				"r_i1_birth").trim());
		setcorridor_ind((hsmp.get("r_corridor_ind") == null) ? "" : hsmp.get(
				"r_corridor_ind").trim());
		setrate_scale((hsmp.get("r_rate_scale") == null) ? "" : hsmp.get(
				"r_rate_scale").trim());
		setcurrency((hsmp.get("currency") == null) ? "" : hsmp.get("currency")
				.trim());
		seto1_occu((hsmp.get("o1_occu") == null) ? "" : hsmp.get("o1_occu")
				.trim());
		seti1_occu((hsmp.get("i1_occu") == null) ? "" : hsmp.get("i1_occu")
				.trim());
		seto1_rfm((hsmp.get("o1_rfm") == null) ? "" : hsmp.get("o1_rfm").trim());
		seti1_rfm((hsmp.get("i1_rfm") == null) ? "" : hsmp.get("i1_rfm").trim());
		seto1_sign_ptn_card((hsmp.get("o1_sign_ptn_card") == null) ? "" : hsmp
				.get("o1_sign_ptn_card").trim());
		seti1_sign_ptn_card((hsmp.get("i1_sign_ptn_card") == null) ? "" : hsmp
				.get("i1_sign_ptn_card").trim());
		sethome_addr_ind((hsmp.get("home_addr_ind") == null) ? "" : hsmp.get(
				"home_addr_ind").trim());
		setmail_addr_ind((hsmp.get("mail_addr_ind") == null) ? "" : hsmp.get(
				"mail_addr_ind").trim());
		setIncome_f((hsmp.get("income_f") == null) ? "" : hsmp.get("income_f")
				.trim());
		setIncome_o((hsmp.get("income_o") == null) ? "" : hsmp.get("income_o")
				.trim());
		setIncome_i((hsmp.get("income_i") == null) ? "" : hsmp.get("income_i")
				.trim());
	}

	public String getResult_ind() {
		return result_ind;
	}

	public void setResult_ind(String result_ind) {
		String oldValue = this.result_ind;
		this.result_ind = result_ind;
		firePropertyChange("result_ind", oldValue, this.result_ind);
	}

	public String getPolicy_no() {
		return policy_no;
	}

	public void setPolicy_no(String policy_no) {
		String oldValue = this.policy_no;
		this.policy_no = policy_no;
		firePropertyChange("policy_no", oldValue, this.policy_no);
	}

	public String getPo_sts_desc() {
		return po_sts_desc;
	}

	public void setPo_sts_desc(String po_sts_desc) {
		String oldValue = this.po_sts_desc;
		this.po_sts_desc = po_sts_desc;
		firePropertyChange("po_sts_desc", oldValue, this.po_sts_desc);
	}

	public String getModx_desc() {
		return modx_desc;
	}

	public void setModx_desc(String modx_desc) {
		String oldValue = this.modx_desc;
		this.modx_desc = modx_desc;
		firePropertyChange("modx_desc", oldValue, this.modx_desc);
	}

	public String getMethod_desc() {
		return method_desc;
	}

	public void setMethod_desc(String method_desc) {
		String oldValue = this.method_desc;
		this.method_desc = method_desc;
		// System.out.println(this.method_desc);
		firePropertyChange("method_desc", oldValue, this.method_desc);
	}

	public String geto1_id() {
		return o1_id;
	}

	public void seto1_id(String o1_id) {
		String oldValue = this.o1_id;
		this.o1_id = o1_id;
		// System.out.println(this.o1_id);
		firePropertyChange("o1_id", oldValue, this.o1_id);
	}

	public String geto1_name() {
		return o1_name;
	}

	public void seto1_name(String o1_name) {
		String oldValue = this.o1_name;
		this.o1_name = o1_name; // + " / "+ this.o1_sex;
		// System.out.println(this.o1_name);
		firePropertyChange("o1_name", oldValue, this.o1_name);
	}

	public String geti1_id() {
		return i1_id;
	}

	public void seti1_id(String i1_id) {
		String oldValue = this.i1_id;
		this.i1_id = i1_id;
		// System.out.println(this.i1_id);
		firePropertyChange("i1_id", oldValue, this.i1_id);
	}

	public String geti1_name() {
		return i1_name;
	}

	public void seti1_name(String i1_name) {
		String oldValue = this.i1_name;
		this.i1_name = i1_name; // + " / "+ this.i1_sex;
		firePropertyChange("i1_name", oldValue, this.i1_name);
	}

	public String getapp_apply_date() {
		return app_apply_date;
	}

	public void setapp_apply_date(String app_apply_date) {
		String oldValue = this.app_apply_date;
		this.app_apply_date = app_apply_date;
		firePropertyChange("app_apply_date", oldValue, this.app_apply_date);
	}

	public String getpo_issue_date() {
		return po_issue_date;
	}

	public void setpo_issue_date(String po_issue_date) {
		String oldValue = this.po_issue_date;
		this.po_issue_date = po_issue_date;
		firePropertyChange("po_issue_date", oldValue, this.po_issue_date);
	}

	public String getin_force_date() {
		return in_force_date;
	}

	public void setin_force_date(String in_force_date) {
		String oldValue = this.in_force_date;
		this.in_force_date = in_force_date;
		firePropertyChange("in_force_date", oldValue, this.in_force_date);
	}

	public String getimage_prn_date() {
		return image_prn_date;
	}

	public void setimage_prn_date(String image_prn_date) {
		String oldValue = this.image_prn_date;
		this.image_prn_date = image_prn_date;
		firePropertyChange("image_prn_date", oldValue, this.image_prn_date);
	}

	public String gethome_addr() {
		return home_addr;
	}

	public void sethome_addr(String home_addr) {
		String oldValue = this.home_addr;
		this.home_addr = home_addr;
		firePropertyChange("home_addr", oldValue, this.home_addr);
	}

	public String gethome_zip() {
		return home_zip;
	}

	public void sethome_zip(String home_zip) {
		String oldValue = this.home_zip;
		this.home_zip = home_zip;
		firePropertyChange("home_zip", oldValue, this.home_zip);
	}

	public String gethome_tel() {
		return home_tel;
	}

	public void sethome_tel(String home_tel) {
		String oldValue = this.home_tel;
		this.home_tel = home_tel;
		firePropertyChange("home_tel", oldValue, this.home_tel);
	}

	public String gethome_fax() {
		return home_fax;
	}

	public void sethome_fax(String home_fax) {
		String oldValue = this.home_fax;
		this.home_fax = home_fax;
		firePropertyChange("home_fax", oldValue, this.home_fax);
	}

	public String gethome_sts() {
		return home_sts;
	}

	public void sethome_sts(String home_sts) {
		String oldValue = this.home_sts;
		this.home_sts = home_sts;
		firePropertyChange("home_sts", oldValue, this.home_sts);
	}

	public String getmail_addr() {
		return mail_addr;
	}

	public void setmail_addr(String mail_addr) {
		String oldValue = this.mail_addr;
		this.mail_addr = mail_addr;
		firePropertyChange("mail_addr", oldValue, this.mail_addr);
	}

	public String getmail_zip() {
		return mail_zip;
	}

	public void setmail_zip(String mail_zip) {
		String oldValue = this.mail_zip;
		this.mail_zip = mail_zip;
		firePropertyChange("mail_zip", oldValue, this.mail_zip);
	}

	public String getmail_tel() {
		return mail_tel;
	}

	public void setmail_tel(String mail_tel) {
		String oldValue = this.mail_tel;
		this.mail_tel = mail_tel;
		firePropertyChange("mail_tel", oldValue, this.mail_tel);
	}

	public String getpmia_desc() {
		return pmia_desc;
	}

	public void setpmia_desc(String pmia_desc) {
		String oldValue = this.pmia_desc;
		this.pmia_desc = pmia_desc;
		firePropertyChange("pmia_desc", oldValue, this.pmia_desc);
	}

	public String getmobil_no() {
		return mobil_no;
	}

	public void setmobil_no(String mobil_no) {
		String oldValue = this.mobil_no;
		this.mobil_no = mobil_no;
		firePropertyChange("mobil_no", oldValue, this.mobil_no);
	}

	public String gete_mail() {
		return e_mail;
	}

	public void sete_mail(String e_mail) {
		String oldValue = this.e_mail;
		this.e_mail = e_mail;
		firePropertyChange("e_mail", oldValue, this.e_mail);
	}

	public String gete_mail_first() {
		return e_mail_first;
	}

	public void sete_mail_first(String e_mail_first) {
		// String oldValue = this.e_mail_first;
		this.e_mail_first = e_mail_first;
		// firePropertyChange("e_mail", oldValue, this.e_mail);
	}

	public String getmail_sts() {
		return mail_sts;
	}

	public void setmail_sts(String mail_sts) {
		String oldValue = this.mail_sts;
		this.mail_sts = mail_sts + "/" + this.home_sts + "/"
				+ this.e_mail_first;
		firePropertyChange("mail_sts", oldValue, this.mail_sts);
	}

	public String geto1_birth() {
		return o1_birth;
	}

	public void seto1_birth(String o1_birth) {
		String oldValue = this.o1_birth;
		this.o1_birth = this.o1_id + " / " + o1_birth;
		firePropertyChange("o1_birth", oldValue, this.o1_birth);
	}

	public String geti1_birth() {
		return i1_birth;
	}

	public void seti1_birth(String i1_birth) {
		String oldValue = this.i1_birth;
		this.i1_birth = this.i1_id + " / " + i1_birth;
		firePropertyChange("i1_birth", oldValue, this.i1_birth);
	}

	public String getcorridor_ind() {
		return corridor_ind;
	}

	public void setcorridor_ind(String corridor_ind) {
		String oldValue = this.corridor_ind;
		this.corridor_ind = corridor_ind;
		firePropertyChange("corridor_ind", oldValue, this.corridor_ind);
	}

	public String getrate_scale() {
		return rate_scale;
	}

	public void setrate_scale(String rate_scale) {
		String oldValue = this.rate_scale;
		this.rate_scale = rate_scale;
		firePropertyChange("rate_scale", oldValue, this.rate_scale);
	}

	public String getcurrency() {
		return currency;
	}

	public void setcurrency(String currency) {
		String oldValue = this.currency;
		this.currency = currency;
		firePropertyChange("currency", oldValue, this.currency);
	}

	public String geto1_occu() {
		return o1_occu;
	}

	public void seto1_occu(String o1_occu) {
		String oldValue = this.o1_occu;
		this.o1_occu = o1_occu;
		firePropertyChange("o1_occu", oldValue, this.o1_occu);
	}

	public String geti1_occu() {
		return i1_occu;
	}

	public void seti1_occu(String i1_occu) {
		String oldValue = this.i1_occu;
		this.i1_occu = i1_occu;
		firePropertyChange("i1_occu", oldValue, this.i1_occu);
	}

	public String geto1_sex() {
		return o1_sex;
	}

	public void seto1_sex(String o1_sex) {
		String oldValue = this.o1_sex;
		this.o1_sex = o1_sex;
		firePropertyChange("o1_sex", oldValue, this.o1_sex);
	}

	public String geti1_sex() {
		return i1_sex;
	}

	public void seti1_sex(String i1_sex) {
		String oldValue = this.i1_sex;
		this.i1_sex = i1_sex;
		firePropertyChange("i1_sex", oldValue, this.i1_sex);
	}

	public String geto1_rfm() {
		return o1_rfm;
	}

	public void seto1_rfm(String o1_rfm) {
		String oldValue = this.o1_rfm;
		this.o1_rfm = o1_rfm;
		// System.out.println(this.o1_rmf);
		firePropertyChange("o1_rfm", oldValue, this.o1_rfm);
	}

	public String geti1_rfm() {
		return i1_rfm;
	}

	public void seti1_rfm(String i1_rfm) {
		String oldValue = this.i1_rfm;
		this.i1_rfm = i1_rfm;
		// System.out.println(this.i1_rfm);
		firePropertyChange("i1_rfm", oldValue, this.i1_rfm);
	}

	public String geto1_sign_ptn_card() {
		return o1_sign_ptn_card;
	}

	public void seto1_sign_ptn_card(String o1_sign_ptn_card) {
		String oldValue = this.o1_sign_ptn_card;
		this.o1_sign_ptn_card = o1_sign_ptn_card;
		// System.out.println("sign"+this.o1_sign_ptn_card);
		firePropertyChange("o1_sign_ptn_card", oldValue, this.o1_sign_ptn_card);
	}

	public String geti1_sign_ptn_card() {
		return i1_sign_ptn_card;
	}

	public void seti1_sign_ptn_card(String i1_sign_ptn_card) {
		String oldValue = this.i1_sign_ptn_card;
		this.i1_sign_ptn_card = i1_sign_ptn_card;
		// System.out.println("sign"+this.i1_sign_ptn_card);
		firePropertyChange("i1_sign_ptn_card", oldValue, this.i1_sign_ptn_card);
	}

	public String gethome_addr_ind() {
		return home_addr_ind;
	}

	public void sethome_addr_ind(String home_addr_ind) {
		String oldValue = this.home_addr_ind;
		this.home_addr_ind = home_addr_ind;
		firePropertyChange("home_addr_ind", oldValue, this.home_addr_ind);
	}

	public String getmail_addr_ind() {
		return mail_addr_ind;
	}

	public void setmail_addr_ind(String mail_addr_ind) {
		String oldValue = this.mail_addr_ind;
		this.mail_addr_ind = mail_addr_ind;
		firePropertyChange("mail_addr_ind", oldValue, this.mail_addr_ind);
	}

	/**
	 * @return the income_o
	 */
	public String getIncome_o() {
		return income_o;
	}

	/**
	 * @param income_o
	 *            the income_o to set
	 */
	public void setIncome_o(String income_o) {
		String oldValue = this.income_o;
		this.income_o = income_o;
		firePropertyChange("income_o", oldValue, this.income_o);
	}

	/**
	 * @return the income_i
	 */
	public String getIncome_i() {
		return income_i;
	}

	/**
	 * @param income_i
	 *            the income_i to set
	 */
	public void setIncome_i(String income_i) {
		String oldValue = this.income_i;
		this.income_i = income_i;
		firePropertyChange("income_i", oldValue, this.income_i);
	}

	/**
	 * @return the income_f
	 */
	public String getIncome_f() {
		return income_f;
	}

	/**
	 * @param income_f
	 *            the income_f to set
	 */
	public void setIncome_f(String income_f) {
		String oldValue = this.income_f;
		this.income_f = income_f;
		firePropertyChange("income_f", oldValue, this.income_f);
	}
}
