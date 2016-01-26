package query.controller;

import java.util.HashMap;
import java.util.List;

import javax.swing.JPanel;

import query.model.InvestHistory.InvestHistory01;
import query.model.InvestHistory.InvestHistory02;
import query.model.InvestHistory.InvestHistory03;
import query.model.InvestHistory.InvestHistory04;
import query.model.InvestHistory.InvestHistory05;
import query.model.InvestHistory.InvestHistoryQuery01;
import query.model.InvestHistory.InvestHistoryQuery02;
import query.model.InvestHistory.InvestHistoryQuery03;
import query.model.InvestHistory.InvestHistoryQuery04;
import query.model.InvestHistory.InvestHistoryQuery05;
import query.view.InvestHistoryJPanel;

public class InvestHistoryController extends DataControl {
	private String[] policy_info;
	private String policy_no;
	private InvestHistoryJPanel investHistoryJPanel;

	public InvestHistoryController() {
		investHistoryJPanel = new InvestHistoryJPanel();
		investHistoryJPanel.setController(this);
	}

	@Override
	public void executeMission() {
		// TODO Auto-generated method stub
		this.policy_no = policy_info[0];
		investHistoryJPanel.clearInvestHistory01();
		// 區域1
		InvestHistoryQuery01 ihq01 = new InvestHistoryQuery01();
		List<HashMap<String, String>> ihq01list = ihq01.getResultList(
				policy_no, 0);
		this.setErrResultInd(ihq01list, "cc156i");
		for (HashMap<String, String> hsmap : ihq01list) {
			InvestHistory01 investHistory01 = new InvestHistory01(hsmap);
			investHistoryJPanel.addInvestHistory01(investHistory01);
		}
		investHistoryJPanel.setDefaultRow();
		this.showMessageDialog(investHistoryJPanel, "投資明細", "cc156i");
	}

	public void executeInnerMission(String invs_ad_no, String currency,
			String invs_tr_date, String invs_ivtr_code, String check_info_join,
			String exsrc, String exprc) { // 1:投資標的交易編號 2:幣別

		InvestHistoryQuery02 ihq02 = new InvestHistoryQuery02();
		// List<HashMap<String, String>> ihq02list = ihq02.getResultList(
		// invs_ad_no, currency);
		List<HashMap<String, String>> ihq02list = ihq02.getResultList(
				invs_ad_no, currency, invs_tr_date,
				invs_ivtr_code.substring(0, 1).toString(), check_info_join,
				exsrc, exprc);// 新增參數
		this.setErrResultInd(ihq02list, "cc157i");
		for (HashMap<String, String> hsmp : ihq02list) {
			InvestHistory02 investHistory02 = new InvestHistory02(hsmp);
			investHistoryJPanel.addInvestHistory02(investHistory02);
		}
		this.showMessageDialog(investHistoryJPanel, "投資明細", "cc157i");
	}

	public void executeInnerMission(String policy_no) { // 保單號碼
		InvestHistoryQuery03 ihq03 = new InvestHistoryQuery03();
		List<HashMap<String, String>> ihq03list = ihq03.getResultList(
				policy_no, 0);// 新增參數
		this.setErrResultInd(ihq03list, "cc246i");
		for (HashMap<String, String> hsmp : ihq03list) {
			InvestHistory03 investHistory03 = new InvestHistory03(hsmp);
			investHistoryJPanel.addInvestHistory03(investHistory03);
		}
		this.showMessageDialog(investHistoryJPanel, "無首期投入前利息資料", "無首期投入前利息資料");
	}

	public void executeInnerMission(String invs_ad_no, int arg1) {
		InvestHistoryQuery04 ihq04 = new InvestHistoryQuery04();
		List<HashMap<String, String>> ihq04list = ihq04.getResultList(
				invs_ad_no, arg1);// 新增參數
		for (HashMap<String, String> hsmp : ihq04list) {
			InvestHistory04 investHistory04 = new InvestHistory04(hsmp);
			investHistoryJPanel.addInvestHistory04(investHistory04);
		}		
		
		InvestHistoryQuery05 ihq05 = new InvestHistoryQuery05();
		List<HashMap<String, String>> ihq05list = ihq05.getResultList(
				invs_ad_no, arg1);// 新增參數
		for (HashMap<String, String> hsmp : ihq05list) {
			InvestHistory05 investHistory05 = new InvestHistory05(hsmp);
			investHistoryJPanel.addInvestHistory05(investHistory05);
		}		
	}

	@Override
	public void executeClearMission() {
		investHistoryJPanel.clearAll();
	}

	@Override
	public void executeNullMission() {
		investHistoryJPanel.nullAll();
	}

	@Override
	public String getOldPolicy_no() {
		// TODO Auto-generated method stub
		return policy_no;
	}

	@Override
	public JPanel getPanel() {
		// TODO Auto-generated method stub
		return investHistoryJPanel;
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
