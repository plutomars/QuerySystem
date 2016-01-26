package query.controller;

import java.util.HashMap;
import java.util.List;

import javax.swing.JPanel;

import query.model.PremBldt.PremBldt;
import query.model.PremBldt.PremBldt01;
import query.model.PremBldt.PremBldt02;
import query.model.PremBldt.PremBldt03;
import query.model.PremBldt.PremBldtQuery;
import query.model.PremBldt.PremBldtQuery01;
import query.view.PremBldtJPanel;

/**
 * 
 * @author cychu
 * 
 * @version 1.0<br/>
 *          101/04/11<br/>
 *          送金記錄查詢(Controller)
 * 
 * @since 1.0
 */
public class PremBldtController extends DataControl {
	private String policy_no;
	private String policy_info[];
	private PremBldtJPanel premBldtPanel;

	public PremBldtController() {
		premBldtPanel = new PremBldtJPanel();
		premBldtPanel.setController(this);
	}

	@Override
	public void executeMission() {
		this.policy_no = policy_info[0];
		PremBldtQuery pbq = new PremBldtQuery();

		premBldtPanel.clearPremBldts();
		premBldtPanel.clearPremBldt01s();
		premBldtPanel.clearPremBldt02s();
		premBldtPanel.clearPremBldt03s();

		List<HashMap<String, String>> list = setErrResultInd(
				pbq.getResultList(policy_no, PremBldtQuery.PREMBLDT), "cc240i");
		// 塞入送金記錄－基本資料欄位
		for (HashMap<String, String> hsmap : list) {
			PremBldt premBldt = new PremBldt(hsmap);
			premBldtPanel.addPremBldt(premBldt);
			premBldtPanel.insertPanelTopValue();
		}

		List<HashMap<String, String>> list2 = setErrResultInd(
				pbq.getResultList(policy_no, PremBldtQuery.PREMBLDT01),
				"cc241i");
		// 塞入送金記錄－送金資料欄位
		for (HashMap<String, String> hsmap : list2) {
			PremBldt01 premBldt01 = new PremBldt01(hsmap);
			premBldtPanel.addPremBldt01(premBldt01);
		}
		premBldtPanel.setDefaultRow();
		showMessageDialog(premBldtPanel, "送金記錄查詢", "保單不符或無資料");
	}

	public void executeInnerMission(String bill_no, String related_key, int type) {
		PremBldtQuery01 pbq01 = new PremBldtQuery01();

		List<HashMap<String, String>> list = setErrResultInd(
				pbq01.getResultList(bill_no, related_key,
						PremBldtQuery01.PREMBLDT02), "cc242i");
		// 塞入入帳資料欄位資料
		for (HashMap<String, String> hsmap : list) {
			PremBldt02 premBldt02 = new PremBldt02(hsmap);
			premBldtPanel.addPremBldt02(premBldt02);
		}
		if (type == PremBldtQuery01.PREMBLDT03) {
			List<HashMap<String, String>> list2 = setErrResultInd(
					pbq01.getResultList(bill_no, related_key,
							PremBldtQuery01.PREMBLDT03), "cc243i");
			// 塞入修改歷史欄位資料
			for (HashMap<String, String> hsmap : list2) {
				PremBldt03 premBldt03 = new PremBldt03(hsmap);
				premBldtPanel.addPremBldt03(premBldt03);
			}
		}
		showMessageDialog(premBldtPanel, "送金記錄查詢", "保單不符或無資料");
	}

	@Override
	public void executeClearMission() {
		premBldtPanel.clearAll();
	}

	@Override
	public void executeNullMission() {
		premBldtPanel.nullAll();
	}

	@Override
	public String getOldPolicy_no() {
		return policy_no;
	}

	@Override
	public JPanel getPanel() {
		return premBldtPanel;
	}

	@Override
	public boolean isControllable() {
		return false;
	}

	@Override
	public void setPolicyInfo(String[] policy_info) {
		this.policy_info = policy_info;
	}
}
