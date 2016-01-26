package query.controller;

import java.util.HashMap;
import java.util.List;

import javax.swing.JPanel;

import query.model.PremReject.PremReject;
import query.model.PremReject.PremReject01;
import query.model.PremReject.PremRejectQuery;
import query.model.PremReject.PremRejectQuery01;
import query.view.PremRejectJPanel;
/**
 * 
 * @author cychu
 *
 * @version 1.0<br/>
 * 			101/03/23<br/>
 * 			退件明細(Controller)
 * 
 * @since 1.0
 */
public class PremRejectController extends DataControl {
	private String policy_no;
	private String policy_info[];
	private PremRejectJPanel premRejectPanel;

	public PremRejectController() {
		premRejectPanel = new PremRejectJPanel();
		premRejectPanel.setController(this);
	}
	
	@Override
	public void executeMission() {
		this.policy_no = policy_info[0];
		PremRejectQuery prq = new PremRejectQuery();
		
		premRejectPanel.clearPremRejects();
		premRejectPanel.clearPremReject01s();
		
		List<HashMap<String, String>> list = setErrResultInd(
				prq.getResultList(policy_no, 0), "cc127i");
		//塞入退件資料欄位資料
		for (HashMap<String, String> hsmap : list) {
			PremReject premReject = new PremReject(hsmap);
			premRejectPanel.addPremReject(premReject);
		}
		premRejectPanel.setDefaultRow();
		showMessageDialog(premRejectPanel, "退件資料查詢", "保單不符或無資料");
	}
	
	public void executeInnerMission(String policy_no, String bank_op_ind, 
			String process_date) {
		PremRejectQuery01 prq01 = new PremRejectQuery01();
		List<HashMap<String, String>> list = setErrResultInd(
				prq01.getResultList(policy_no, bank_op_ind, process_date), "cc128i");
		//塞入退件明細欄位資料
		for (HashMap<String, String> hsmap : list) {
			PremReject01 premReject01 = new PremReject01(hsmap);
			premRejectPanel.addPremReject01(premReject01);
		}
		showMessageDialog(premRejectPanel, "退件明細查詢", "保單不符或無資料");
	}

	@Override
	public String getOldPolicy_no() {
		return policy_no;
	}
	
	@Override
	public JPanel getPanel() {
		return premRejectPanel;
	}
	
	@Override
	public boolean isControllable() {
		return false;
	}
	
	@Override
	public void setPolicyInfo(String[] policy_info) {
		this.policy_info = policy_info;
	}
	
	@Override
	public void executeNullMission() {
		premRejectPanel.nullAll();
	}
	
	@Override
	public void executeClearMission() {
		premRejectPanel.clearAll();
	}
}
