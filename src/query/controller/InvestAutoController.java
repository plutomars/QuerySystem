package query.controller;

import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import query.model.InvestAuto.InvestAuto01;
import query.model.InvestAuto.InvestAuto02;
import query.model.InvestAuto.InvestAuto03;
import query.model.InvestAuto.InvestAutoQuery;
import query.view.InvestAutoJPanel;

/**
 * 
 * @author 陳冠瑜
 * 
 */
public class InvestAutoController extends DataControl {
	private String policy_no;
	private String currency;
	private String policy_info[];
	private InvestAutoJPanel investautoPanel;
	private InvestAutoQuery rq = new InvestAutoQuery();

	public InvestAutoController() {
		investautoPanel = new InvestAutoJPanel();
		investautoPanel.setController(this);
	}

	@Override
	// 塞入自動轉換資料
	public void executeMission() {
		// TODO Auto-generated method stub
		this.policy_no = policy_info[0];
		// 若user未輸入保單直接點擊會沒有幣別
		try {
			this.currency = policy_info[6].substring(0, 3);
		} catch (StringIndexOutOfBoundsException e) {
			e.printStackTrace();
		}

		// 清空畫面
		investautoPanel.clearInvestAuto01();
		investautoPanel.clearInvestAuto02();
		investautoPanel.clearInvestAuto03();

		Integer i = 1;
		List<HashMap<String, String>> list = setErrResultInd(rq.getResultList(
				policy_no, currency, InvestAutoQuery.INVESTAUTO), "cc150i");
		for (HashMap<String, String> hsmap : list) {
			InvestAuto01 investauto01 = new InvestAuto01(hsmap);
			investautoPanel.addInvestAuto01(investauto01);
			// 塞入下次自動轉換日期(verticalPane)僅做一次
			if (i == 1) {
				investautoPanel.setInvestAuto01(hsmap);
			}
			i++;
		}
		investautoPanel.setDefaultRow();
		this.showMessageDialog(investautoPanel, "自動轉換查詢", "保單不符或無資料");
	}

	// 塞入加碼明細資料
	public void executeInnerMission01(String auto_tr_date,
			String invs_avail_type) {
		investautoPanel.clearInvestAuto02();

		// 僅該險種有加碼明細才需call cc151i ( String的比較要用equals )
		if (invs_avail_type.equals("3")) {
			List<HashMap<String, String>> list = setErrResultInd(
					rq.getResultList(policy_no, currency, auto_tr_date,
							InvestAutoQuery.INVESTAUTODETAIL), "cc151i");
			for (HashMap<String, String> hsmap : list) {
				InvestAuto02 investauto02 = new InvestAuto02(hsmap);
				investautoPanel.addInvestAuto02(investauto02);
			}

			// 當r_result_ind=1(非正常)才會跳出視窗(來自DataControl)
			this.showMessageDialog(investautoPanel, "加碼明細查詢", "無加碼明細資料");
		} else
			// 無條件跳出視窗
			JOptionPane.showMessageDialog(investautoPanel, "該險種無加碼機制",
					"加碼明細查詢", JOptionPane.INFORMATION_MESSAGE);
	}

	// 塞入停利資料
	public void executeInnerMission(String beg_date, String end_date,
			String invs_code) {
		investautoPanel.clearInvestAuto03();

		List<HashMap<String, String>> list = setErrResultInd(rq.getResultList(
				policy_no, currency, beg_date, end_date, invs_code,
				InvestAutoQuery.INVESTAUTOSTOP), "cc152i");
		for (HashMap<String, String> hsmap : list) {
			InvestAuto03 investauto03 = new InvestAuto03(hsmap);
			investautoPanel.addInvestAuto03(investauto03);
		}
		this.showMessageDialog(investautoPanel, "停利查詢", "保單不符或無資料");
	}

	@Override
	public void executeClearMission() {
		investautoPanel.clearInvestAuto01();
		investautoPanel.clearInvestAuto02();
		investautoPanel.clearInvestAuto03();
	}

	@Override
	public void executeNullMission() {
		investautoPanel.nullAll();
	}

	@Override
	public String getOldPolicy_no() {
		// TODO Auto-generated method stub
		return policy_no;
	}

	@Override
	public JPanel getPanel() {
		// TODO Auto-generated method stub
		return investautoPanel;
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
