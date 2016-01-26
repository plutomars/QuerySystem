package query.controller;

/**
 * 
 * @author swei
 * @version 1.0
 * 集體彙繳查詢(Controller)
 * 
 * 
 */
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import query.model.PremGBill.PremGBill01;
import query.model.PremGBill.PremGBill01Query;
import query.view.PremGBillJPanel;

public class PremGBillController extends DataControl {
	public String policy_no="";
	public String group_code;
	public String assigner;
	public String company_name;
	private String policy_info[];

	private PremGBillJPanel premgbill01Panel = new PremGBillJPanel();// add
	
	public PremGBillController() {
		premgbill01Panel.setController(this);
	}

	@Override
	public void executeMission() {
		// TODO Auto-generated method stub
		this.policy_no = policy_info[0];
	}

	public void executeMission(String group_code, String assigner,String company_name) {
		// TODO Auto-generated method stub
		this.group_code = group_code;
		this.assigner = assigner;
		this.company_name = company_name;
		
		if(group_code.isEmpty() == true && assigner.isEmpty() == true && company_name.isEmpty() == true)
		{
			JOptionPane.showMessageDialog(null, "請輸入查詢條件！");
			return;
		}
		else
		{
			PremGBill01Query rq = new PremGBill01Query();
			
			// 塞入"查詢彙繳人01"(premgbill_01)
			List<HashMap<String, String>> list = setErrResultInd(rq.getResultList(group_code,assigner, company_name,PremGBill01Query.Grouper),"cc133i");
			if(list.get(0).get("r_group_code") == null && list.get(0).get("r_assigner") == null && list.get(0).get("r_company_name") ==null)
			{
				JOptionPane.showMessageDialog(null, "無符合您查詢的有關資料！");
				return;
			}
			else
			{
				premgbill01Panel.clearPremGBill01s();
				for (HashMap<String, String> hsmap : list) {
					PremGBill01 premgbill01 = new PremGBill01(hsmap);
					premgbill01Panel.addPremGBill01(premgbill01);
				}
			}
		}
		showMessageDialog(premgbill01Panel, "集體彙繳查詢 ", "保單不符或無資料");
	}
	@Override
	public void executeClearMission(){
		premgbill01Panel.clearAll();
	}
	
	@Override
	public void executeNullMission(){
		premgbill01Panel.nullAll();
	}
		
	@Override
	public String getOldPolicy_no() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JPanel getPanel() {
		// TODO Auto-generated method stub
		return premgbill01Panel;// add
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
