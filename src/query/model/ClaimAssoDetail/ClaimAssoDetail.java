package query.model.ClaimAssoDetail;

import java.util.HashMap;

/**
 * @author cychu
 *
 * @version 1.0<br/>
 * 			101/04/24<br/>
 * 			公會投保資料查詢－明細(JavaBean)
 * 
 * @since 1.0
 */
public class ClaimAssoDetail {
	private String result_ind;			//0_查詢結果
	private String nbui_pno;			//1_別公司保單號碼
	private String nbni_amt;			//2_保額
	private String mode_prem;			//3_保費
	private String un_modx_desc;		//4_繳別描述
	private String po_sts_date;			//5_保單狀況改變日
	private String po_issue_date;		//6_保單生效日
	private String o1_id;				//7_要保人ID
	private String o1_un_name;			//8_公會通報要保人姓名
	private String o1_rela;				//9_公會通報要被保人關係
	private String un_po_sts;			//10_公會通報保單狀況
	private String expired_date;		//11_滿期日期
	
	public ClaimAssoDetail(HashMap<String, String> hsmp) {
		result_ind = (hsmp.get("r_result_ind") == null) ? "" : hsmp.get(
		"r_result_ind").trim();
		nbui_pno = (hsmp.get("r_nbui_pno") == null) ? "" : hsmp.get(
		"r_nbui_pno").trim();
		nbni_amt = (hsmp.get("r_nbni_amt") == null) ? "" : hsmp.get(
		"r_nbni_amt").trim();
		mode_prem = (hsmp.get("r_mode_prem") == null) ? "" : hsmp.get(
		"r_mode_prem").trim();
		un_modx_desc = (hsmp.get("r_un_modx_desc") == null) ? "" : hsmp.get(
		"r_un_modx_desc").trim();
		po_sts_date = (hsmp.get("r_po_sts_date") == null) ? "" : hsmp.get(
		"r_po_sts_date").trim();
		po_issue_date = (hsmp.get("r_po_issue_date") == null) ? "" : hsmp.get(
		"r_po_issue_date").trim();
		o1_id = (hsmp.get("r_o1_id") == null) ? "" : hsmp.get(
		"r_o1_id").trim();
		o1_un_name = (hsmp.get("r_o1_un_name") == null) ? "" : hsmp.get(
		"r_o1_un_name").trim();
		o1_rela = (hsmp.get("r_o1_rela") == null) ? "" : hsmp.get(
		"r_o1_rela").trim();
		un_po_sts = (hsmp.get("r_un_po_sts") == null) ? "" : hsmp.get(
		"r_un_po_sts").trim();
		expired_date = (hsmp.get("r_expired_date") == null) ? "" : hsmp.get(
		"r_expired_date").trim();
	}

	public String getResult_ind() {
		return result_ind;
	}

	public void setResult_ind(String result_ind) {
		this.result_ind = result_ind;
	}

	public String getNbui_pno() {
		return nbui_pno;
	}

	public void setNbui_pno(String nbui_pno) {
		this.nbui_pno = nbui_pno;
	}

	public String getNbni_amt() {
		return nbni_amt;
	}

	public void setNbni_amt(String nbni_amt) {
		this.nbni_amt = nbni_amt;
	}

	public String getMode_prem() {
		return mode_prem;
	}

	public void setMode_prem(String mode_prem) {
		this.mode_prem = mode_prem;
	}

	public String getUn_modx_desc() {
		return un_modx_desc;
	}

	public void setUn_modx_desc(String un_modx_desc) {
		this.un_modx_desc = un_modx_desc;
	}

	public String getPo_sts_date() {
		return po_sts_date;
	}

	public void setPo_sts_date(String po_sts_date) {
		this.po_sts_date = po_sts_date;
	}

	public String getPo_issue_date() {
		return po_issue_date;
	}

	public void setPo_issue_date(String po_issue_date) {
		this.po_issue_date = po_issue_date;
	}

	public String getO1_id() {
		return o1_id;
	}

	public void setO1_id(String o1_id) {
		this.o1_id = o1_id;
	}

	public String getO1_un_name() {
		return o1_un_name;
	}

	public void setO1_un_name(String o1_un_name) {
		this.o1_un_name = o1_un_name;
	}

	public String getO1_rela() {
		return o1_rela;
	}

	public void setO1_rela(String o1_rela) {
		this.o1_rela = o1_rela;
	}

	public String getUn_po_sts() {
		return un_po_sts;
	}

	public void setUn_po_sts(String un_po_sts) {
		this.un_po_sts = un_po_sts;
	}

	public String getExpired_date() {
		return expired_date;
	}

	public void setExpired_date(String expired_date) {
		this.expired_date = expired_date;
	}
}
