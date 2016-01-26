package query.model.PayQuery;

import java.util.HashMap;

import query.model.AbstractModelObject;

public class PayQuery01 extends AbstractModelObject {

	private String m_reference_code;  //相關號碼
	private String m_disb_no;         //付款號碼
	private String m_disb_type;       //付款型態
	private String m_disb_method;     //付款方式
	private String m_disb_sts_code;   //付款狀況
	private String m_currency;        //幣別
	private String m_disb_amt;        //付款金額
	//private String m_bank_code;     //銀行碼 <--> 更新:101.04.06 替換成"功能碼 "
	private String m_function_code;   //功能碼
	private String m_payee;           //受款人	
	private String m_payee_cht;       //受款人(中)
	private String m_check_no;        //支票號碼

	public PayQuery01(){
	}
	
	public PayQuery01(HashMap<String, String> hsmp) {		
		m_reference_code = (hsmp.get("r_reference_code") == null) ? "" : hsmp.get("r_reference_code").trim();
		m_disb_no = (hsmp.get("r_disb_no") == null) ? "" : hsmp.get("r_disb_no").trim();
		m_disb_type = (hsmp.get("r_disb_type") == null) ? "" : hsmp.get("r_disb_type").trim();
		m_disb_method = (hsmp.get("r_disb_method") == null) ? "" : hsmp.get("r_disb_method").trim();
        m_disb_sts_code = (hsmp.get("r_disb_sts_code") == null) ? "" : hsmp.get("r_disb_sts_code").trim();
        m_currency = (hsmp.get("r_currency") == null) ? "" : hsmp.get("r_currency").trim();
        m_disb_amt = (hsmp.get("r_disb_amt") == null) ? "" : hsmp.get("r_disb_amt").trim();
//        m_bank_code = (hsmp.get("r_bank_code") == null) ? "" : hsmp.get("r_bank_code").trim();
        m_function_code = (hsmp.get("r_function_code") == null) ? "" : hsmp.get("r_function_code").trim();
        m_payee = (hsmp.get("r_payee") == null) ? "" : hsmp.get("r_payee").trim();
        m_payee_cht = (hsmp.get("r_payee_cht") == null) ? "" : hsmp.get("r_payee_cht").trim();
        m_check_no = (hsmp.get("r_check_no") == null) ? "" : hsmp.get("r_check_no").trim();
	}

	
	public String getM_payee_cht() {
		return m_payee_cht;
	}

	public void setM_payee_cht(String m_payee_cht) {
		this.m_payee_cht = m_payee_cht;
	}

	public String getM_check_no() {
		return m_check_no;
	}

	public void setM_check_no(String m_check_no) {
		this.m_check_no = m_check_no;
	}

	public String getM_reference_code() {
		return m_reference_code;
	}

	public void setM_reference_code(String m_reference_code) {
		this.m_reference_code = m_reference_code;
	}

	public String getM_disb_no() {
		return m_disb_no;
	}

	public void setM_disb_no(String m_disb_no) {
		this.m_disb_no = m_disb_no;
	}

	public String getM_disb_type() {
		return m_disb_type;
	}

	public void setM_disb_type(String m_disb_type) {
		this.m_disb_type = m_disb_type;
	}

	public String getM_disb_method() {
		return m_disb_method;
	}

	public void setM_disb_method(String m_disb_method) {
		this.m_disb_method = m_disb_method;
	}

	public String getM_disb_sts_code() {
		return m_disb_sts_code;
	}

	public void setM_disb_sts_code(String m_disb_sts_code) {
		this.m_disb_sts_code = m_disb_sts_code;
	}

	public String getM_currency() {
		return m_currency;
	}

	public void setM_currency(String m_currency) {
		this.m_currency = m_currency;
	}

	public String getM_disb_amt() {
		return m_disb_amt;
	}

	public void setM_disb_amt(String m_disb_amt) {
		this.m_disb_amt = m_disb_amt;
	}

	

	public String getM_function_code() {
		return m_function_code;
	}

	public void setM_function_code(String m_function_code) {
		this.m_function_code = m_function_code;
	}

	public String getM_payee() {
		return m_payee;
	}

	public void setM_payee(String m_payee) {
		this.m_payee = m_payee;
	}
	
	
}

	
