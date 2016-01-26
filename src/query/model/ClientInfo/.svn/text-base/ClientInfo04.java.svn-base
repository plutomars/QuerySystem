package query.model.ClientInfo;

import java.util.ArrayList;
import java.util.HashMap;

public class ClientInfo04 {
	private String mobil_no;
	private String e_mail;
	private String o1_sign_ptn_card;
	private String mail_sts; // EBilling啟用狀態
	private String home_sts;
	private String ec_acct;
	private String twd_acct; // 有無台幣匯款約定帳戶
	private String foreign_acct; // 外幣
	private String lost_ind; // SR130700054 保戶失聯指示
	private String risk_suit_desc; // SR140100176 風險屬性等級
	private String fatca_ind_desc; // FATCA指示
	private String r_psck_sw;   //還本註記指示

	public ClientInfo04(HashMap<String, String> hsmp) {
		mobil_no = ((hsmp.get("r_mobil_no") == null) ? "" : hsmp.get(
				"r_mobil_no").trim());
		mail_sts = ((hsmp.get("r_mail_sts") == null) ? "" : hsmp.get(
				"r_mail_sts").trim());
		home_sts = (hsmp.get("r_home_sts") == null) ? "" : hsmp.get(
				"r_home_sts").trim();
		o1_sign_ptn_card = ((hsmp.get("o1_sign_ptn_card") == null) ? "" : hsmp
				.get("o1_sign_ptn_card").trim());
		e_mail = ((hsmp.get("r_e_mail") == null) ? "" : hsmp.get("r_e_mail")
				.trim());
		ec_acct = ((hsmp.get("ec_acct") == null) ? "" : hsmp.get("ec_acct")
				.trim());
		twd_acct = ((hsmp.get("twd_acct") == null) ? "" : hsmp.get("twd_acct")
				.trim());
		foreign_acct = ((hsmp.get("foreign_acct") == null) ? "" : hsmp.get(
				"foreign_acct").trim());
		lost_ind = ((hsmp.get("lost_ind") == null) ? "" : hsmp.get("lost_ind")
				.trim());
		risk_suit_desc = ((hsmp.get("risk_suit_desc") == null) ? "" : hsmp.get(
				"risk_suit_desc").trim());
		fatca_ind_desc = ((hsmp.get("fatca_ind_desc") == null) ? "" : hsmp.get(
				"fatca_ind_desc").trim());
		r_psck_sw = ((hsmp.get("r_psck_sw") == null) ? "" : hsmp.get(
				"r_psck_sw").trim());

	}

	public String[] getValues(int type) {
		ArrayList<String> valueList = new ArrayList<String>();

		switch (type) {
		case 1:
			valueList.add(mobil_no);
			valueList.add(e_mail);
			valueList.add(twd_acct);
			valueList.add(lost_ind); // SR130700054 保戶失聯指示
			valueList.add(fatca_ind_desc);
			valueList.add(o1_sign_ptn_card);
			break;
		case 2:
			valueList.add(mail_sts + " / " + home_sts);
			valueList.add(ec_acct);
			valueList.add(foreign_acct);
			valueList.add(risk_suit_desc);
			valueList.add(r_psck_sw);
			break;
		}
		String[] valueArray = new String[valueList.size()];
		valueList.toArray(valueArray);

		return valueArray;
	}

	public String getmail_sts() {
		return mail_sts;
	}

	public void setmail_sts(String mail_sts) {
		this.mail_sts = mail_sts;
	}

	public String gethome_sts() {
		return home_sts;
	}

	public void sethome_sts(String home_sts) {
		this.home_sts = home_sts;
	}

	public String getmobil_no() {
		return mobil_no;
	}

	public void setmobil_no(String mobil_no) {
		this.mobil_no = mobil_no;
	}

	public String geto1_sign_ptn_card() {
		return o1_sign_ptn_card;
	}

	public void seto1_sign_ptn_card(String o1_sign_ptn_card) {
		this.o1_sign_ptn_card = o1_sign_ptn_card;
	}

	public String gete_mail() {
		return e_mail;
	}

	public void sete_mail(String e_mail) {
		this.e_mail = e_mail;
	}

	public String getec_acct() {
		return ec_acct;
	}

	public void setec_acct(String ec_acct) {
		this.ec_acct = ec_acct;
	}

	public String gettwd_acct() {
		return twd_acct;
	}

	public void settwd_acct(String twd_acct) {
		this.twd_acct = twd_acct;
	}

	public String getforeign_acct() {
		return foreign_acct;
	}

	public void setforeign_acct(String foreign_acct) {
		this.foreign_acct = foreign_acct;
	}

	public String getLost_ind() {
		return lost_ind;
	}

	public void setLost_ind(String lost_ind) {
		this.lost_ind = lost_ind;
	}

	public String getRisk_suit_desc() {
		return risk_suit_desc;
	}

	public void setRisk_suit_desc(String risk_suit_desc) {
		this.risk_suit_desc = risk_suit_desc;
	}

	public String getFatca_ind_desc() {
		return fatca_ind_desc;
	}

	public void setFatca_ind_desc(String fatca_ind_desc) {
		this.fatca_ind_desc = fatca_ind_desc;
	}

	public String getR_psck_sw() {
		return r_psck_sw;
	}

	public void setR_psck_sw(String r_psck_sw) {
		this.r_psck_sw = r_psck_sw;
	}

}
