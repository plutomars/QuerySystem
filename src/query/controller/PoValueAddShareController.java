/**
 * 
 */
package query.controller;

import java.util.HashMap;
import java.util.List;

import javax.swing.JPanel;

import query.model.PoValueAddShare.PoValueAddShare01;
import query.model.PoValueAddShare.PoValueAddShare02;
import query.model.PoValueAddShare.PoValueAddShare03;
import query.model.PoValueAddShare.PoValueAddShareQuery;
import query.view.PoValueAddShareJPanel;

/**
 * @author F1256819
 * @category 增值回饋分享金controller
 * 
 */
public class PoValueAddShareController extends DataControl {
	private String[] policy_info;
	private String policy_no;
	private PoValueAddShareJPanel poValueAddShareJPanel;

	/**
	 * 
	 */
	public PoValueAddShareController() {
		poValueAddShareJPanel = new PoValueAddShareJPanel();
		poValueAddShareJPanel.setController(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see query.controller.DataControl#executeClearMission()
	 */
	@Override
	public void executeClearMission() {
		poValueAddShareJPanel.clearAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see query.controller.DataControl#executeMission()
	 */
	@Override
	public void executeMission() {
		// TODO Auto-generated method stub
		this.policy_no = policy_info[0];
		poValueAddShareJPanel.clearAll();

		// 第一區資料
		PoValueAddShareQuery poValueAddShareQuery = new PoValueAddShareQuery();
		List<HashMap<String, String>> list = this.setErrResultInd(
				poValueAddShareQuery.getResultList(policy_no, 1), "ccpsk1");
		for (HashMap<String, String> hsmp : list) {
			PoValueAddShare01 share01 = new PoValueAddShare01(hsmp);
			poValueAddShareJPanel.addPoValueAddShare01(share01);
		}

		// 第二區資料
		List<HashMap<String, String>> secList = this.setErrResultInd(
				poValueAddShareQuery.getResultList(policy_no, 2), "ccpsk2");
		for (HashMap<String, String> hsmp : secList) {
			PoValueAddShare02 share02 = new PoValueAddShare02(hsmp);
			poValueAddShareJPanel.addPoValueAddShare02(share02);
		}
		// 第三區資料
		List<HashMap<String, String>> thirdList = this.setErrResultInd(
				poValueAddShareQuery.getResultList(policy_no, 3), "ccpsk3");
		for (HashMap<String, String> hsmp : thirdList) {
			PoValueAddShare03 poValueAddShare03 = new PoValueAddShare03(hsmp);
			poValueAddShareJPanel.addPoValueAddShare03(poValueAddShare03);
		}
		if (this.isErr) {
			poValueAddShareJPanel.clearAll();
		}
		this.showMessageDialog(poValueAddShareJPanel, "增值回饋分享金",
				"此保單非增值回饋分享金保單");

	}

	/*
	 * 
	 * (non-Javadoc)
	 * 
	 * @see query.controller.DataControl#executeNullMission()
	 */
	@Override
	public void executeNullMission() {
		poValueAddShareJPanel.nullAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see query.controller.DataControl#getOldPolicy_no()
	 */
	@Override
	public String getOldPolicy_no() {
		return policy_no;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see query.controller.DataControl#getPanel()
	 */
	@Override
	public JPanel getPanel() {
		return poValueAddShareJPanel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see query.controller.DataControl#isControllable()
	 */
	@Override
	public boolean isControllable() {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see query.controller.DataControl#setPolicyInfo(java.lang.String[])
	 */
	@Override
	public void setPolicyInfo(String[] policy_info) {
		// TODO Auto-generated method stub
		this.policy_info = policy_info;
	}

}
