package query.controller;

import java.util.HashMap;
import java.util.List;

import javax.swing.JPanel;

import query.model.ValueWithdraw.ValueWithdraw;
import query.model.ValueWithdraw.ValueWithdrawQuery;
import query.view.ValueWithdrawJPanel;
/**
 * 年金提存明細
 * @author 陳冠瑜
 * 
 */
public class ValueWithdrawController extends DataControl {
	public String policy_no;
	private String policy_info[];
	public ValueWithdrawJPanel valuewithdrawPanel= new ValueWithdrawJPanel();
	
	@Override
	public void executeMission() {
		this.policy_no = policy_info[0];
//		valuewithdrawPanel.resetScrollPanes();
		ValueWithdrawQuery rq = new ValueWithdrawQuery();
		valuewithdrawPanel.clearAll();

		List<HashMap<String, String>> list = setErrResultInd(rq.getResultList(policy_no,
				ValueWithdrawQuery.VALUEWITHDRAW),"cc149i");
		// 塞入提存明細欄位資料
		for (HashMap<String, String> hsmap : list) {
			ValueWithdraw valuewithdraw = new ValueWithdraw(hsmap);
			valuewithdrawPanel.addValueWithdraw(valuewithdraw);
		}
		this.showMessageDialog(valuewithdrawPanel, "提存明細資料查詢", "保單不符或無資料");
		valuewithdrawPanel.setDefaultRow();
		
	}
	
	@Override
	public void executeClearMission(){
		valuewithdrawPanel.clearAll();
	}
	
	@Override
	public void executeNullMission(){
		valuewithdrawPanel.nullAll();
	}
	
	@Override
	public String getOldPolicy_no() {
		// TODO Auto-generated method stub
		return policy_no;
	}

	@Override
	public JPanel getPanel() {
		// TODO Auto-generated method stub
		return valuewithdrawPanel;
	}
	@Override
	public boolean isControllable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setPolicyInfo(String[] policy_info) {
		// TODO Auto-generated method stub
		this.policy_info = policy_info; 
		
	}
}
