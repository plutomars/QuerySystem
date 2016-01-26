package query.controller;

import java.util.HashMap;
import java.util.List;

import javax.swing.JPanel;

import query.model.NewRescind.NewRescind02;
import query.model.NewRescind.NewRescind03;
import query.model.NewRescind.NewRescind04;
import query.model.NewRescind.NewRescindQuery;
import query.view.NewRescindJPanel;

public class NewRescindController extends DataControl {
	private String policy_no;
	private String policy_info[];
	private NewRescindJPanel newRescindJPanel = new NewRescindJPanel();
	
    public NewRescindController() {
		newRescindJPanel.setController(this);
	}

	@Override
	public void executeMission() {
		this.policy_no = policy_info[0];
		NewRescindQuery pq = new NewRescindQuery();
		
		newRescindJPanel.cleanNewRescind();
		newRescindJPanel.cleanNewRescind04group();
				
// ------------基本資料
		List<HashMap<String, String>> list = setErrResultInd(
				pq.getResultList(policy_no, NewRescindQuery.NewRescind01),
				"cc118i");
		for (HashMap<String, String> hsmap : list) {
			newRescindJPanel.setNewRescind01(hsmap);
		}
// ------------契撤相關索引資料
		list = setErrResultInd(
				pq.getResultList(policy_no, NewRescindQuery.NewRescind02),
				"cc119i");

		for (HashMap<String, String> hsmap : list) {
			NewRescind02 rescind02 = new NewRescind02(hsmap);
			newRescindJPanel.cleanNewRescind04group();
			newRescindJPanel.addNewRescind02(rescind02);
		}
		// ------------照會資料 
		list = setErrResultInd(
				pq.getResultList(policy_no, NewRescindQuery.NewRescind03),
				"cc120i");
		for (HashMap<String, String> hsmap : list) {
			NewRescind03 rescind03 = new NewRescind03(hsmap);
			newRescindJPanel.addNewRescind03(rescind03);
		}
    }
	public void executeMissionRescind04 (String r_notify_date) {
		NewRescindQuery pq = new NewRescindQuery();
		newRescindJPanel.cleanNewRescind04group();
		List<HashMap<String, String>> list = setErrResultInd(
				pq.getResultList(policy_no, r_notify_date),
				"cc121i");
		
		for (HashMap<String, String> hsmap : list) {
		NewRescind04 rescind04 = new NewRescind04(hsmap);
		newRescindJPanel.addNewRescind04(rescind04);
	    }
	}
		
	
	@Override
	public String getOldPolicy_no() {
		return policy_no;
	}

	@Override
	public JPanel getPanel() {
		return newRescindJPanel;
	}

	@Override
	public boolean isControllable() {
		return false;
	}

	public void setPolicyInfo(String[] policy_info) {
		this.policy_info = policy_info;
	}
	
	@Override
	public void executeClearMission(){
		newRescindJPanel.cleanNewRescind();
	}
	@Override
	public void executeNullMission(){
		newRescindJPanel.nullAll();
	}
}
