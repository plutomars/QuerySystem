package query.model.PayQuery;

import java.util.ArrayList;
import java.util.HashMap;

import query.model.AbstractModelObject;

public class PayQuery06 extends AbstractModelObject {

	
	private String m_disb_no;                 //付款號碼                            
	private String m_program_id;              //程式代碼
	private String m_process_date;            //處理日期
	private String m_disb_sts_date;           //付款狀況日
	private String m_execute_date;            //執行日期
	private String m_remit_date;              //匯款日期
	private String m_remit_swift_code;	      //swift_code	   
	private String m_process_user;            //處理者
	private String m_disb_desc;               //付款摘要
	private String m_payee_id;                //受款人ID	
	private String m_remit_bank_name;         //銀行名稱
	private String m_remit_bank_address;      //銀行地址
	private String m_disb_note;               //付款備註
//	private String m_function_code;           //功能碼  --> 更新:101.04.06 替換成"銀行碼 " 
	private String m_bank_code;               //銀行碼 
	private String m_check_no;                //支票號碼
	private String m_check_date;              //支票日期
	private String m_voucher_no;              //傳票號碼
	private String m_honor_date;              //傳票日期
	private String m_remit_account;           //匯款帳號-
	
	public PayQuery06(){
	}
	
	public void setAttributes(HashMap<String, String> hsmp) {		
		setM_disb_no((hsmp.get("r_disb_no") == null) ? "" : hsmp.get("r_disb_no").trim());                        //1區 
		setM_program_id ((hsmp.get("r_program_id") == null) ? "" : hsmp.get("r_program_id").trim());
		setM_process_date ((hsmp.get("r_process_date") == null) ? "" : hsmp.get("r_process_date").trim());
		setM_disb_sts_date((hsmp.get("r_disb_sts_date") == null) ? "" : hsmp.get("r_disb_sts_date").trim());
		setM_execute_date((hsmp.get("r_execute_date") == null) ? "" : hsmp.get("r_execute_date").trim());
		setM_remit_date((hsmp.get("r_remit_date") == null) ? "" : hsmp.get("r_remit_date").trim());
		setM_remit_swift_code((hsmp.get("r_remit_swift_code") == null) ? "" : hsmp.get("r_remit_swift_code").trim());
		setM_process_user((hsmp.get("r_process_user") == null) ? "" : hsmp.get("r_process_user").trim());
		setM_disb_desc((hsmp.get("r_disb_desc") == null) ? "" : hsmp.get("r_disb_desc").trim());
		
		setM_payee_id((hsmp.get("r_payee_id") == null) ? "" : hsmp.get("r_payee_id").trim());                     //2區   
		setM_remit_bank_name((hsmp.get("r_remit_bank_name") == null) ? "" : hsmp.get("r_remit_bank_name").trim());
		setM_remit_bank_address((hsmp.get("r_remit_bank_address") == null) ? "" : hsmp.get("r_remit_bank_address").trim());
		setM_disb_note((hsmp.get("r_disb_note") == null) ? "" : hsmp.get("r_disb_note").trim());		
		setM_bank_code ((hsmp.get("r_bank_code") == null) ? "" : hsmp.get("r_bank_code").trim());     //2_0 
		setM_check_no((hsmp.get("r_check_no") == null) ? "" : hsmp.get("r_check_no").trim());
		setM_check_date((hsmp.get("r_check_date") == null) ? "" : hsmp.get("r_check_date").trim());
		setM_voucher_no ((hsmp.get("r_voucher_no") == null) ? "" : hsmp.get("r_voucher_no").trim());
		setM_honor_date ((hsmp.get("r_honor_date") == null) ? "" : hsmp.get("r_honor_date").trim());
		setM_remit_account((hsmp.get("r_remit_account") == null) ? "" : hsmp.get("r_remit_account").trim());
	}
	
	public PayQuery06(HashMap<String, String> hsmp) {	     
		m_disb_no = (hsmp.get("r_disb_no") == null) ? "" : hsmp.get("r_disb_no").trim();                            //1區 
		m_program_id = (hsmp.get("r_program_id") == null) ? "" : hsmp.get("r_program_id").trim();              
		m_process_date = (hsmp.get("r_process_date") == null) ? "" : hsmp.get("r_process_date").trim();            
		m_disb_sts_date = (hsmp.get("r_disb_sts_date") == null) ? "" : hsmp.get("r_disb_sts_date").trim();           
		m_execute_date = (hsmp.get("r_execute_date") == null) ? "" : hsmp.get("r_execute_date").trim();            
		m_remit_date = (hsmp.get("r_remit_date") == null) ? "" : hsmp.get("r_remit_date").trim();              
		m_remit_swift_code = (hsmp.get("r_remit_swift_code") == null) ? "" : hsmp.get("r_remit_swift_code").trim();        
		m_process_user = (hsmp.get("r_process_user") == null) ? "" : hsmp.get("r_process_user").trim();            
		m_disb_desc = (hsmp.get("r_disb_desc") == null) ? "" : hsmp.get("r_disb_desc").trim();               
		m_payee_id = (hsmp.get("r_payee_id") == null) ? "" : hsmp.get("r_payee_id").trim();
		
		m_remit_bank_name = (hsmp.get("r_remit_bank_name") == null) ? "" : hsmp.get("r_remit_bank_name").trim();     //2區     
		m_remit_bank_address = (hsmp.get("r_remit_bank_address") == null) ? "" : hsmp.get("r_remit_bank_address").trim();      
		m_disb_note = (hsmp.get("r_disb_note") == null) ? "" : hsmp.get("r_disb_note").trim();		
		m_bank_code = (hsmp.get("r_bank_code") == null) ? "" : hsmp.get("r_bank_code").trim();           //2_0      
		m_check_no = (hsmp.get("r_check_no") == null) ? "" : hsmp.get("r_check_no").trim();                
		m_check_date = (hsmp.get("r_check_date") == null) ? "" : hsmp.get("r_check_date").trim();              
		m_voucher_no = (hsmp.get("r_voucher_no") == null) ? "" : hsmp.get("r_voucher_no").trim();              
		m_honor_date = (hsmp.get("r_honor_date") == null) ? "" : hsmp.get("r_honor_date").trim();              
		m_remit_account = (hsmp.get("r_remit_account") == null) ? "" : hsmp.get("r_remit_account").trim();      
	}
	
	

	public String[] getValues(int type) {
		ArrayList<String> valueList = new ArrayList<String>();
		
		switch (type) {
		case 1:
			valueList.add(m_disb_no);          // 付款號碼         1  
			valueList.add(m_check_date);       // 支票日期         2
			valueList.add(m_remit_swift_code); // swift_code 3
			valueList.add(m_remit_account);    // 匯款帳號     4 
			valueList.add(m_process_date);     // 處理日期     5
			valueList.add(m_disb_sts_date);    // 付款狀況日6
			valueList.add(m_execute_date);	   // 執行日期     7
			valueList.add(m_remit_date);       // 匯款日期     8 
			valueList.add(m_bank_code);        // 功能碼          9--> 替換成"銀行碼 "
			break;                   
		
		case 2:
			valueList.add(m_payee_id);           // 受款人ID 10
			valueList.add(m_voucher_no);         // 傳票號碼   11 
			valueList.add(m_honor_date);         // 兌現日期   12			
			valueList.add(m_remit_bank_name);    // 銀行名稱   13                          
			valueList.add(m_remit_bank_address); // 銀行地址   14                          
			valueList.add(m_disb_note);          // 付款備註   15                           																		
			valueList.add(m_process_user);       // 處理者        16
			valueList.add(m_disb_desc);          // 付款摘要   17 
			valueList.add(m_program_id);         // 程式代碼   18   
			break;
	}
		
		String[] valueArray = new String[valueList.size()];
		valueList.toArray(valueArray);
		return valueArray;
	}

	public String getM_bank_code() {
		return m_bank_code;
	}

	public void setM_bank_code(String m_bank_code) {
		this.m_bank_code = m_bank_code;
	}

	public String getM_check_no() {
		return m_check_no;
	}

	public void setM_check_no(String m_check_no) {
		this.m_check_no = m_check_no;
	}

	public String getM_check_date() {
		return m_check_date;
	}

	public void setM_check_date(String m_check_date) {
		this.m_check_date = m_check_date;
	}

	public String getM_voucher_no() {
		return m_voucher_no;
	}

	public void setM_voucher_no(String m_voucher_no) {
		this.m_voucher_no = m_voucher_no;
	}

	public String getM_honor_date() {
		return m_honor_date;
	}

	public void setM_honor_date(String m_honor_date) {
		this.m_honor_date = m_honor_date;
	}

	public String getM_remit_account() {
		return m_remit_account;
	}

	public void setM_remit_account(String m_remit_account) {
		this.m_remit_account = m_remit_account;
	}

	public String getM_disb_no() {
		return m_disb_no;
	}

	public void setM_disb_no(String m_disb_no) {
		this.m_disb_no = m_disb_no;
	}

	public String getM_program_id() {
		return m_program_id;
	}

	public void setM_program_id(String m_program_id) {
		this.m_program_id = m_program_id;
	}

	public String getM_process_date() {
		return m_process_date;
	}

	public void setM_process_date(String m_process_date) {
		this.m_process_date = m_process_date;
	}

	public String getM_disb_sts_date() {
		return m_disb_sts_date;
	}

	public void setM_disb_sts_date(String m_disb_sts_date) {
		this.m_disb_sts_date = m_disb_sts_date;
	}

	public String getM_execute_date() {
		return m_execute_date;
	}

	public void setM_execute_date(String m_execute_date) {
		this.m_execute_date = m_execute_date;
	}

	public String getM_remit_date() {
		return m_remit_date;
	}

	public void setM_remit_date(String m_remit_date) {
		this.m_remit_date = m_remit_date;
	}

	public String getM_remit_swift_code() {
		return m_remit_swift_code;
	}

	public void setM_remit_swift_code(String m_remit_swift_code) {
		this.m_remit_swift_code = m_remit_swift_code;
	}

	public String getM_process_user() {
		return m_process_user;
	}

	public void setM_process_user(String m_process_user) {
		this.m_process_user = m_process_user;
	}

	public String getM_disb_desc() {
		return m_disb_desc;
	}

	public void setM_disb_desc(String m_disb_desc) {
		this.m_disb_desc = m_disb_desc;
	}

	public String getM_payee_id() {
		return m_payee_id;
	}

	public void setM_payee_id(String m_payee_id) {
		this.m_payee_id = m_payee_id;
	}

	public String getM_remit_bank_name() {
		return m_remit_bank_name;
	}

	public void setM_remit_bank_name(String m_remit_bank_name) {
		this.m_remit_bank_name = m_remit_bank_name;
	}

	public String getM_remit_bank_address() {
		return m_remit_bank_address;
	}

	public void setM_remit_bank_address(String m_remit_bank_address) {
		this.m_remit_bank_address = m_remit_bank_address;
	}

	public String getM_disb_note() {
		return m_disb_note;
	}

	public void setM_disb_note(String m_disb_note) {
		this.m_disb_note = m_disb_note;
	}
	
	
}
