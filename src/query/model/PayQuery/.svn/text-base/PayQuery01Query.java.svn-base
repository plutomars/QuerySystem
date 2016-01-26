package query.model.PayQuery;

import java.sql.Statement;
import java.util.HashMap;
import java.util.List;

import database.connection.DBConnection;

import query.model.AbstractModelObject;
import query.model.PayQuery.PayQuery01Query;

public class PayQuery01Query extends AbstractModelObject {
	public final static int PayQ01 = 1;   // [主畫面索引]
	public final static int PayQ02 = 2;   // 分錄查詢
	public final static int PayQ03 = 3;   // 傳票查詢
	public final static int PayQ04 = 4;   // 重開註記查詢
	public final static int PayQ05 = 5;   // 重開註記查詢
	public final static int PayQ06 = 6;   // 其他查詢
	
	public List<HashMap<String, String>> getResultList(String reference_code, String disb_no,String check_date,int type) 
    {	
		Statement st = DBConnection.createStatement();
		List<HashMap<String, String>> list = null;
		String Q1 = "";
		String Q2 = "";
		String Q3 = "";
		
		if(reference_code.isEmpty() == false)
		{
			Q1 =   " AND a.reference_code = '" + reference_code + "'  ";
		}
		if(disb_no.isEmpty() == false)
		{
			Q2 =  " AND a.disb_no = '" + disb_no + "'  ";
		}
		if(check_date.isEmpty() == false)
		{
			Q3 =  " AND a.check_date = '" + check_date + "'  ";
		}
		
		if (type == PayQuery01Query.PayQ01) //-----------------------<主查詢> 171500041601  -- 3750335
		{
			list = DBConnection.getResultList(DBConnection.executeQuery(st,
					  " SELECT  "
					 +" a.disb_no r_disb_no, "
					 +" getDesc('disb_type',a.disb_type) r_disb_type, "
					 +" a.dept_code r_dept_code,  "
					 +" getDesc('disb_method',a.disb_method) r_disb_method,  "
					 +" a.reference_code r_reference_code, "
					 +" a.currency r_currency,  "
					 +" round(a.disb_amt,2) r_disb_amt,  "
					 +" a.bank_code r_bank_code,"           //銀行碼 
					 +" a.check_no r_check_no,  "
					 +" a.function_code||':'||getDesc('function_code',function_code) r_function_code, "   // 更新:101.04.06 替換成"功能碼 "
					 +" a.disb_sts_code||' '||nvl(getDesc('disb_sts_code',a.disb_sts_code),'') r_disb_sts_code,  "
					 +" a.check_date r_check_date,  "
					 +" a.voucher_no r_voucher_no,  "
					 +" a.honor_date r_honor_date,  "
					 +" a.remit_bank r_remit_bank,  "
					 +" a.remit_branch r_remit_branch,  "
					 +" a.remit_account r_remit_account,"
					 +" a.payee r_payee, "
					 +" a.payee_cht r_payee_cht,  "
					 +" a.check_no  r_check_no, "
					 +" a.disb_sts_date "
					 +" FROM dbdd a, OUTER dbjn b "
					 +" WHERE a.disb_no = b.disb_no"
					 +" AND b.journal_seq = 1 " + Q1 + " " + Q2 + " " + Q3 + " order by a.disb_sts_date desc"  ) );
	    }
		DBConnection.closeStatement(st);		
		return list;
	}
	
	public List<HashMap<String, String>> getResultList2(String k_currency,String k_reference_code,String disb_no, int type)
    {	
		Statement st2 = DBConnection.createStatement();
		List<HashMap<String, String>> list2 = null;
		
		if (type == PayQuery01Query.PayQ02)  //-----------------------<分錄>
		{
			list2 = DBConnection.getResultList(DBConnection.executeQuery(st2,
					 " SELECT "
					+" voucher_no r_voucher_no," 
					+" voucher_seq r_voucher_seq, "
					+" acct_no r_acct_no, "
					+" dept_code r_dept_code, "
					+" journal_amt r_journal_amt,"
					+" recn_code r_recn_code, "
					+" policy_no r_policy_no, "
					+" agent_code r_agent_code, "
					+" reason_code r_reason_code, "
					+" journal_desc r_journal_desc "
					+" FROM dbjn "
					+" WHERE disb_no = '" + disb_no + "' "
					+" ORDER BY voucher_seq"  ));
		}
		
		if (type == PayQuery01Query.PayQ03) //-----------------------<傳票>
		{
			list2 = DBConnection.getResultList(DBConnection.executeQuery(st2,
					 " SELECT "
					+" a.voucher_no r_voucher_no," 
					+" a.journal_seq r_journal_seq, "
					+" a.disb_amt r_disb_amt,"
					+" b.acct_no r_acct_no, "
					+" b.journal_desc r_journal_desc"
					+" FROM gldd a, gljn b"
					+" WHERE a.voucher_no  = b.voucher_no"
					+" AND a.journal_seq = b.journal_seq"
					+" AND a.disb_no = '" + disb_no + "' "// '3750335'
					+" ORDER BY 1, 2"   ));
		}
		if (type == PayQuery01Query.PayQ05) //-----------------------<歷史>
		{
			list2 = DBConnection.getResultList(DBConnection.executeQuery(st2,
				  " SELECT "                                      
				 +" disb_no r_disb_no, "                                    
				 +" disb_sts_code||' '||getDesc('disb_sts_code',disb_sts_code)  r_disb_sts_code, "                              
				 +" disb_sts_date  r_disb_sts_date, "                              
				 +" dept_code r_dept_code,"                                   
				 +" voucher_no  r_voucher_no, "                                 
				 +" process_date r_process_date, "                               
				 +" process_time r_process_time, "                               
				 +" getDesc('user_code',process_user) r_process_user"                                
				 +" FROM dbdg "                                 
				 +" WHERE disb_no = '" + disb_no + "' "  //'4744897' "           
				 +" ORDER BY disb_no, process_date, process_time " ));
		}
		
		
		
		if (type == PayQuery01Query.PayQ06) //-----------------------其他
		{
			list2 = DBConnection.getResultList(DBConnection.executeQuery(st2,
					  " SELECT "
					 //+" a.function_code||':'||getDesc('function_code',function_code) r_function_code, "           //功能碼
					 +" a.bank_code r_bank_code,"                    //銀行碼         更新:101.04.06 替換成"銀行碼 "
					 +" a.check_no r_check_no,  "                    //支票號碼
					 +" a.check_date r_check_date, "                 //支票日期
					 +" a.voucher_no r_voucher_no,  "                //傳票號碼
					 +" a.honor_date r_honor_date,   "               //傳票日期
					 +" a.remit_account r_remit_account, "           //匯款帳號
					 +" a.disb_no  r_disb_no,    "                   //付款號碼                            
					 +" a.program_id r_program_id,   "               //程式代碼
					 +" a.process_date r_process_date, "             //處理日期
					 +" a.disb_sts_date r_disb_sts_date,  "          //付款狀況日
					 +" a.execute_date r_execute_date,     "         //執行日期
					 +" a.remit_date r_remit_date,       "           //匯款日期
					 +" a.remit_swift_code r_remit_swift_code,	 " //Sswift_Code	   
					 +" getDesc('user_code',process_user) r_process_user,     "  //處理者
					 +" a.disb_desc r_disb_desc,        "            //付款地址
					 +" a.payee_id r_payee_id,            "          //受款人ID
					 +" nvl(a.remit_bank,'')||nvl(a.remit_branch,'')||'-'||TRIM(nvl(a.remit_bank_name,''))|| getBankname(a.remit_bank||a.remit_branch) r_remit_bank_name,"
//					 +" case  when a.currency  = 'USD' THEN (select  distinct TRIM(c.remit_bank_name) || getBankname(c.remit_bank) from dbdd c where c.reference_code = a.reference_code and (c.remit_bank) <> '')  "
//					 +"       when a.currency  = 'TWD' THEN (select b.bank_name from bank b where b.bank_code = a.bank_code ) ELSE  "//銀行名稱
//					 +" (select  distinct TRIM(c.remit_bank_name) || getBankname(c.remit_bank) from dbdd c where c.reference_code = a.reference_code and (c.remit_bank) <> '') END as r_remit_bank_name,   "
					 +" a.remit_bank_address r_remit_bank_address, " //銀行地址					 
					 +" a.disb_note r_disb_note   "                  //付款備註
					 +" FROM dbdd a"
					 +" WHERE a.disb_no = '" + disb_no + "' " )); 	
		}

//		select remit_bank_name||getBankname(remit_bank) from dbdd
//		where reference_code = '151500018715'

		
 		DBConnection.closeStatement(st2);		
		return list2;
    }
	
	public List<HashMap<String, String>> getResultList4(String check_no, int type)
    {	
		Statement st4 = DBConnection.createStatement();
		List<HashMap<String, String>> list4 = null;
		
		if (type == PayQuery01Query.PayQ04) //註記
		{
			list4 = DBConnection.getResultList(DBConnection.executeQuery(st4,
					 " SELECT dbdi_desc r_dbdi_desc"
					+" FROM   dbdi "
					+" WHERE  check_no = '" + check_no + "' " )); //AA0004623 / GA0002679
		}
		DBConnection.closeStatement(st4);
		return list4;
    }
	
//保單:143600138401
//	141100088033
//	170900040621
//	171500041601
//	173800030200
//	174200021500
//	174300013853
//	141100078262
//	147700022944
//	149900027834
//	149900027954
//	170700046798
//	172900045948
//	174600006907
//	116500012874
//	140200062818
//	173200021290
//	173300019834
//	174100023400
//	174100023424
	
	
}
