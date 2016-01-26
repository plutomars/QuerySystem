package query.controller;

import java.util.HashMap;
import java.util.List;

import javax.swing.JPanel;

import query.model.InvestCash.InvestCash01;
import query.model.InvestCash.InvestCash02;
import query.model.InvestCash.InvestCash04;
import query.model.InvestCash.InvestCash05;
import query.model.InvestCash.InvestCashQuery;
import query.view.InvestCashJPanel;

/**
 * 
 * @author 陳冠瑜
 * 
 */
public class InvestCashController extends DataControl {
	public String policy_no;
	public String entry_no;
	public String currency;
	private String policy_info[];
	public InvestCashJPanel investcashPanel;
	private InvestCashQuery rq = new InvestCashQuery();

	public InvestCashController() {
		investcashPanel = new InvestCashJPanel();
		investcashPanel.setController(this);
	}

	@Override
	public void executeMission() {

		this.policy_no = policy_info[0];
		investcashPanel.clearAll(); // 清空全部資料

		// 塞入入帳資料
		List<HashMap<String, String>> list = setErrResultInd(
				rq.getResultList(policy_no, InvestCashQuery.INVESTCASH),
				"cc158i");
		for (HashMap<String, String> hsmap : list) {
			InvestCash01 investcash01 = new InvestCash01(hsmap);
			investcashPanel.addInvestCash01(investcash01);
		}
		investcashPanel.setDefaultRow();
		this.showMessageDialog(investcashPanel, "投資現金流量查詢", "保單不符或無資料");
	}

	public void executeInnerMission(String entry_no, String currency) {

		investcashPanel.clearInvestCashDetail(); // 清空下區資料

		// 塞入入帳明細
		List<HashMap<String, String>> list = setErrResultInd(
				rq.getResultList(policy_no, entry_no, currency,
						InvestCashQuery.INVESTCASHDETAIL), "cc159i");
		for (HashMap<String, String> hsmap : list) {
			InvestCash02 investcash02 = new InvestCash02(hsmap);
			investcashPanel.addInvestCash02(investcash02);
		}

		// 塞入保費明細(使用VerticalPane)(現已未使用VerticalPane)
		list = setErrResultInd(rq.getResultList(policy_no, entry_no, currency,
				InvestCashQuery.INVESTCASHPOS), "cc160i");
		for (HashMap<String, String> hsmap : list) {
			investcashPanel.setInvestCash03(hsmap);
		}
		// 塞入目標堆疊
		list = rq.getResultList(policy_no, entry_no,
				InvestCashQuery.INVESTCASHENTRY);
		for (HashMap<String, String> hsmap : list) {
			InvestCash04 investCash04 = new InvestCash04(hsmap);
			investcashPanel.addInvestCash04(investCash04);
		}
		// 塞入立投費用
		list = rq.getResultList(policy_no, entry_no,
				InvestCashQuery.INVESTCASHIMMED);
		for (HashMap<String, String> hsmap : list) {
			InvestCash05 investCash05 = new InvestCash05(hsmap);
			investcashPanel.addInvestCash05(investCash05);
		}

	}

	@Override
	public void executeClearMission() {
		investcashPanel.clearAll();
	}

	@Override
	public void executeNullMission() {
		investcashPanel.nullAll();
	}

	@Override
	public String getOldPolicy_no() {
		// TODO Auto-generated method stub
		return policy_no;
	}

	@Override
	public JPanel getPanel() {
		// TODO Auto-generated method stub
		return investcashPanel;
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
