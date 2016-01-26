package query.controller;
/**
 * 
 * @author swei
 * @version 1.0
 * 體檢批註告知查詢(Controller)
 * 
 * 
 */
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import query.model.PayQuery.PayQuery01;
import query.model.PayQuery.PayQuery01Group;
import query.model.PayQuery.PayQuery01Query;
import query.model.PayQuery.PayQuery02;
import query.model.PayQuery.PayQuery02Group;
import query.model.PayQuery.PayQuery03;
import query.model.PayQuery.PayQuery03Group;
import query.model.PayQuery.PayQuery04;
import query.model.PayQuery.PayQuery04Group;
import query.model.PayQuery.PayQuery05;
import query.model.PayQuery.PayQuery05Group;
import query.model.PoDetail.PoDetailQuery;
import query.model.PoExam.PoExam00;
import query.model.PoExam.PoExam01Query;
import query.model.PremGBill.PremGBill01;
import query.model.PremGBill.PremGBill01Query;
import query.view.PremGBillJPanel;
import query.view.PayQueryJPanel;

public class PayQueryController  extends DataControl {
	private String policy_info[];
	public String policy_no;
	public String reference_code;
	public String disb_no;
	public String disb_type;
	public String check_date;
	public String disb_method;
	public String disb_sts_code;
	public String currency;
	public String disb_amt;
	public String bank_code;
	public String payee;
	
	public String check_no;
	public int rowSelect;
	
	private PayQueryJPanel payquery01Panel;// = new payQueryJPanel();// add
	
	public PayQueryController() {
		payquery01Panel = new PayQueryJPanel();
		payquery01Panel.setController(this);
	}
   

	@Override
	public void executeMission() {
		// TODO Auto-generated method stub
		this.policy_no = policy_info[0];
		payquery01Panel.setPONO(policy_no);
		payquery01Panel.clearAll();
		executeMission(this.policy_no, "", "");//查詢
	}
	
	public void executeMission(String reference_code, String disb_no,String check_date) {
	
	this.reference_code = reference_code;
	this.disb_no = disb_no;
	this.check_date = check_date;
		
		if(reference_code.isEmpty() == true && disb_no.isEmpty() == true && check_date.isEmpty() == true )
		{
			JOptionPane.showMessageDialog(null, "請輸入查詢條件！");
			return;
		}
		if(reference_code.isEmpty() == true && disb_no.isEmpty() == true && check_date.isEmpty() != true)
		{
			JOptionPane.showMessageDialog(null, "無法單一查詢(支票日期)，請附加其他條件查詢！");
			return;
		}		
		else
		{			
			PayQuery01Query rq = new PayQuery01Query();
			// 塞入"付款資料查詢01"(payQuery_01)
			List<HashMap<String, String>> list = rq.getResultList(reference_code, disb_no, check_date ,PayQuery01Query.PayQ01);
			
			if(list.size() == 0)
			{
				JOptionPane.showMessageDialog(null, "無符合的資料！");
				return;
			}
			else
			{
				payquery01Panel.clearPayQuery01s();
				for (HashMap<String, String> hsmap : list) {
					PayQuery01 payquery01 = new PayQuery01(hsmap);
					payquery01Panel.addPayQuery01(payquery01);
				}
				payquery01Panel.setDefaultRow();
			}		
		}
		showMessageDialog(payquery01Panel, "付款資料查詢", "保單不符或無資料");
	}
	@Override
	public void executeClearMission() {
		// TODO Auto-generated method stub
		payquery01Panel.clearAll();
	}

	@Override
	public void executeNullMission() {
		// TODO Auto-generated method stub
		payquery01Panel.nullAll();
	}
	
	@Override
	public String getOldPolicy_no() {
		// TODO Auto-generated method stub
		return policy_no;
	}
	
	@Override
	public JPanel getPanel() {
		// TODO Auto-generated method stub
		return payquery01Panel;// add
	}
	
	@Override
	public void setPolicyInfo(String[] arg0) {
		// TODO Auto-generated method stub
		policy_info = arg0;
	}

	@Override
	public boolean isControllable() {
		// TODO Auto-generated method stub
		return false;
	}

}
