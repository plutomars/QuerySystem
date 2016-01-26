package query.controller;

import java.util.HashMap;
import java.util.List;

import javax.swing.JPanel;

import query.model.PremProxy.PremProxy02;
import query.model.PremProxy.PremProxy03;
import query.model.PremProxy.PremProxy04;
import query.model.PremProxy.PremProxyQuery;
import query.view.PremProxyJPanel;
/**
 * 
 * @author 陳冠瑜
 * 
 */
public class PremProxyController extends DataControl {
	public String policy_no;
	public String bank_op_ind;
	private String policy_info[];
	public PremProxyJPanel premproxyPanel = new PremProxyJPanel();

	public PremProxyController() {
		premproxyPanel.setController(this);
	}

	@Override
	public void executeMission() {
	}

	public void executeInnerMission(String bank_op_ind) {
		this.policy_no = policy_info[0];
		PremProxyQuery rq = new PremProxyQuery();

		premproxyPanel.clearAll(); // 清空資料

		// 塞入主要資料欄位
		List<HashMap<String, String>> list = setErrResultInd(rq.getResultList(
				policy_no, bank_op_ind, PremProxyQuery.PREMPROXYMAIN), "cc124i");
		for (HashMap<String, String> hsmap : list) {
			premproxyPanel.setPremProxy01(hsmap);
		}

		// 塞入異動資料欄位
		list = setErrResultInd(rq.getResultList(policy_no, bank_op_ind,
				PremProxyQuery.PREMPROXYCHANGE), "cc125i");
		for (HashMap<String, String> hsmap : list) {
			PremProxy02 premproxy02 = new PremProxy02(hsmap);
			premproxyPanel.addPremProxy02(premproxy02);
		}

		// 塞入歸檔資料欄位
		list = setErrResultInd(rq.getResultList(policy_no, bank_op_ind,
				PremProxyQuery.PREMPROXYBACK), "cc126i");
		for (HashMap<String, String> hsmap : list) {
			PremProxy03 premproxy03 = new PremProxy03(hsmap);
			premproxyPanel.addPremProxy03(premproxy03);
		}

		// 塞入暫停扣款資料欄位
		list = setErrResultInd(rq.getResultList(policy_no, bank_op_ind,
				PremProxyQuery.PREMPROXYSTOP), "cc129i");
		for (HashMap<String, String> hsmap : list) {
			PremProxy04 premproxy04 = new PremProxy04(hsmap);
			premproxyPanel.addPremProxy04(premproxy04);
		}
		this.showMessageDialog(premproxyPanel, "授權、委託書明細查詢", "保單或銀行作業代碼不符或無資料");
	}

	@Override
	public void executeClearMission(){
		premproxyPanel.clearAll();
	}
	
	@Override
	public void executeNullMission(){
		premproxyPanel.nullAll();
	}
	
	@Override
	public String getOldPolicy_no() {
		// TODO Auto-generated method stub
		return policy_no;
	}

	@Override
	public JPanel getPanel() {
		// TODO Auto-generated method stub
		return premproxyPanel;
	}

	@Override
	public boolean isControllable() {
		// TODO Auto-generated method stub
		return true; // 將原來的查詢按鈕隱藏
	}

	@Override
	public void setPolicyInfo(String[] policy_info) {
		// TODO Auto-generated method stub
		this.policy_info = policy_info;

	}
}
