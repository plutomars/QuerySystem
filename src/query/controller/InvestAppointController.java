package query.controller;

import java.util.HashMap;
import java.util.List;

import javax.swing.JPanel;

import query.model.InvestAppoint.InvestAppointQuery;
import query.model.InvestAppoint.InvestSwitchAppoint01;
import query.model.InvestAppoint.InvestSwitchAppoint02;
import query.model.InvestAppoint.InvestSwitchBuyAppoint03;
import query.model.InvestAppoint.InvestSwitchSellAppoint03;
import query.model.InvestAppoint.InvestWithdrawAppoint01;
import query.model.InvestAppoint.InvestWithdrawAppoint02;
import query.model.InvestAppoint.InvestWithdrawAppoint03;
import query.view.InvestAppointJPanel;

public class InvestAppointController extends DataControl {
	private String[] policy_info;
	private String policy_no;
	private InvestAppointJPanel investAppointJPanel;

	public InvestAppointController() {
		// TODO Auto-generated constructor stub
		investAppointJPanel = new InvestAppointJPanel();
		investAppointJPanel.setController(this);
	}

	@Override
	public void executeClearMission() {
		investAppointJPanel.clearAll();

	}

	@Override
	public void executeMission() {
		// TODO Auto-generated method stub
		this.policy_no = policy_info[0];
		investAppointJPanel.clearAll();

		InvestAppointQuery aq = new InvestAppointQuery();

		// 約定提領
		List<HashMap<String, String>> list = aq.getResultList(policy_no, 2);

		for (HashMap<String, String> hsmp : list) {
			InvestWithdrawAppoint01 vmap = new InvestWithdrawAppoint01(hsmp);
			investAppointJPanel.addInvestWithdraw01(vmap);
		}

		// 約定轉換
		list = aq.getResultList(policy_no, 1);

		for (HashMap<String, String> hsmp : list) {
			InvestSwitchAppoint01 vmap = new InvestSwitchAppoint01(hsmp);
			investAppointJPanel.addInvestSwitchAppoint01(vmap);
		}

		investAppointJPanel.setDefaultRow();
		investAppointJPanel.setTabPaneEnable();
		investAppointJPanel.setTabPaneDisable();
	}

	public void executeWithdrawInnerMission(int chah_seq) {

		investAppointJPanel.clearInvestWithdraw02();
		InvestAppointQuery aq = new InvestAppointQuery();

		List<HashMap<String, String>> list = aq.getResultList(chah_seq);

		for (HashMap<String, String> hsmp : list) {
			InvestWithdrawAppoint02 vmap = new InvestWithdrawAppoint02(hsmp);
			investAppointJPanel.addInvestWithdraw02(vmap);
		}
	}

	public void executeWithdrawInnerMission(int chah_seq, int chlh_seq) {
		investAppointJPanel.clearInvestWithdraw03();
		InvestAppointQuery aq = new InvestAppointQuery();
		List<HashMap<String, String>> list = aq.getResultList(chah_seq,
				chlh_seq);
		for (HashMap<String, String> hsmp : list) {
			InvestWithdrawAppoint03 vmap = new InvestWithdrawAppoint03(hsmp);
			investAppointJPanel.addInvestWithdraw03(vmap);
		}
	}

	public void executeSwitchInnerMission(int chah_seq) {
		investAppointJPanel.clearInvestSwitch02();
		InvestAppointQuery aq = new InvestAppointQuery();

		List<HashMap<String, String>> list = aq.getResultList(chah_seq);

		for (HashMap<String, String> hsmp : list) {
			InvestSwitchAppoint02 vmap = new InvestSwitchAppoint02(hsmp);
			investAppointJPanel.addInvestSwitchAppoint02(vmap);
		}
	}

	public void executeSwitchInnerMission(int chah_seq, int chlh_seq) {
		investAppointJPanel.clearInvestSwitch03();
		InvestAppointQuery aq = new InvestAppointQuery();

		List<HashMap<String, String>> list = aq.getResultList(chah_seq,
				chlh_seq);

		for (HashMap<String, String> hsmp : list) {
			if (hsmp.get("r_invs_ad_sub_ind").toString().equals("2")) {
				InvestSwitchSellAppoint03 vmap = new InvestSwitchSellAppoint03(
						hsmp);
				investAppointJPanel.addInvestSwitchSellAppoint(vmap);
			} else {
				InvestSwitchBuyAppoint03 vmap = new InvestSwitchBuyAppoint03(
						hsmp);
				investAppointJPanel.addInvestSwitchBuyAppoint(vmap);
			}

		}
	}

	@Override
	public void executeNullMission() {
		// TODO Auto-generated method stub
		investAppointJPanel.nullAll();
	}

	@Override
	public String getOldPolicy_no() {
		// TODO Auto-generated method stub
		return policy_no;
	}

	@Override
	public JPanel getPanel() {
		// TODO Auto-generated method stub
		return investAppointJPanel;
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
