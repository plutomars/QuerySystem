package query.model.PayQuery;

import java.util.HashMap;

import query.model.AbstractModelObject;

public class PayQuery03 extends AbstractModelObject {

	private String m_voucher_no;   // 傳票號碼
	private String m_journal_seq;  // 序號
	private String m_disb_amt;     // 付款金額
	private String m_acct_no;      // 會計科目
	private String m_journal_desc; // 分錄摘要

	public PayQuery03(){
	}
	
	public PayQuery03(HashMap<String, String> hsmp) {		
		m_voucher_no = (hsmp.get("r_voucher_no") == null) ? "" : hsmp.get("r_voucher_no").trim();
		m_journal_seq = (hsmp.get("r_journal_seq") == null) ? "" : hsmp.get("r_journal_seq").trim();
		m_disb_amt = (hsmp.get("r_disb_amt") == null) ? "" : hsmp.get("r_disb_amt").trim();		
		m_acct_no = (hsmp.get("r_acct_no") == null) ? "" : hsmp.get("r_acct_no").trim();
		m_journal_desc = (hsmp.get("r_journal_desc") == null) ? "" : hsmp.get("r_journal_desc").trim();	
	}

	public String getM_voucher_no() {
		return m_voucher_no;
	}

	public void setM_voucher_no(String m_voucher_no) {
		this.m_voucher_no = m_voucher_no;
	}

	public String getM_journal_seq() {
		return m_journal_seq;
	}

	public void setM_journal_seq(String m_journal_seq) {
		this.m_journal_seq = m_journal_seq;
	}

	public String getM_disb_amt() {
		return m_disb_amt;
	}

	public void setM_disb_amt(String m_disb_amt) {
		this.m_disb_amt = m_disb_amt;
	}

	public String getM_acct_no() {
		return m_acct_no;
	}

	public void setM_acct_no(String m_acct_no) {
		this.m_acct_no = m_acct_no;
	}

	public String getM_journal_desc() {
		return m_journal_desc;
	}

	public void setM_journal_desc(String m_journal_desc) {
		this.m_journal_desc = m_journal_desc;
	}
	
	
}
