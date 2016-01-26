package query.controller;

import java.util.HashMap;
import java.util.List;

import javax.swing.JPanel;

import query.model.PoBonus.PoBonusList;
import query.model.PoBonus.PoBonusQuery;
import query.view.PoBonusJPanel;

public class PoBonusController extends DataControl {
	private String policy_no;
	private String policy_info[];
	private PoBonusJPanel poBonusJPanel = new PoBonusJPanel();
	private String bonus_type;
		
	public void executeMission() {
		this.policy_no = policy_info[0];
		this.bonus_type = "";
		PoBonusQuery rq = new PoBonusQuery();
		poBonusJPanel.clearPoBonus();
		poBonusJPanel.clearPoBonusLists();
		
		List<HashMap<String, String>> list = setErrResultInd(rq.getResultList(policy_no,PoBonusQuery.BONUS),"cc113i");
	
		// 塞入紅利查詢欄位資料
		for (HashMap<String, String> hsmap : list) {
//			System.out.println(hsmap.get("r_result_ind"));
			if (!hsmap.get("r_result_ind").equals("0"))
				this.bonus_type = "";
			else
			    this.bonus_type = hsmap.get("r_div_option").toString();
			poBonusJPanel.setPoBonus(hsmap);
		}
		System.out.println("bonus"+this.bonus_type);
		if (!this.bonus_type.isEmpty()) {
		list = setErrResultInd(rq.getResultList(policy_no,this.bonus_type,PoBonusQuery.BONUSLIST ),"cc114i");
		
		for (HashMap<String, String> hsmap : list) {
			PoBonusList bonus = new PoBonusList(hsmap);
			poBonusJPanel.addPoBonusLists(bonus);
		}}
		showMessageDialog(poBonusJPanel, "紅利資料", "此保單無分紅設定");
		
	}
	

	public String getOldPolicy_no() {
		// TODO Auto-generated method stub
		return policy_no;
	}


	public JPanel getPanel() {
		// TODO Auto-generated method stub
		return poBonusJPanel;
	}


	@Override
	public boolean isControllable() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public void setPolicyInfo(String[] arg0) {
		// TODO Auto-generated method stub
		this.policy_info = arg0;
		
	}
	
	@Override
	 public void executeClearMission(){
	  poBonusJPanel.clearPoBonusLists();
	  poBonusJPanel.clearPoBonus();
	 }
	 @Override
	 public void executeNullMission(){
	  poBonusJPanel.nullAll();
	  
	 }



}
