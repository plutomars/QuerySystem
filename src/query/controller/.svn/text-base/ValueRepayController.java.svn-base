package query.controller;

import java.util.HashMap;
import java.util.List;

import javax.swing.JPanel;

import query.model.ValueRepay.ValueRepay01;
import query.model.ValueRepay.ValueRepay02;
import query.model.ValueRepay.ValueRepay03;
import query.model.ValueRepay.ValueRepay04;
import query.model.ValueRepay.ValueRepay05;
import query.model.ValueRepay.ValueRepay06;
import query.model.ValueRepay.ValueRepay07;
import query.model.ValueRepay.ValueRepay08;
import query.model.ValueRepay.ValueRepay09;
import query.model.ValueRepay.ValueRepay10;
import query.model.ValueRepay.ValueRepay11;
import query.model.ValueRepay.ValueRepayQuery01;
import query.model.ValueRepay.ValueRepayQuery02;
import query.model.ValueRepay.ValueRepayQuery03;
import query.model.ValueRepay.ValueRepayQuery04;
import query.model.ValueRepay.ValueRepayQuery05;
import query.model.ValueRepay.ValueRepayQuery06;
import query.model.ValueRepay.ValueRepayQuery07;
import query.model.ValueRepay.ValueRepayQuery08;
import query.model.ValueRepay.ValueRepayQuery09;
import query.model.ValueRepay.ValueRepayQuery10;
import query.model.ValueRepay.ValueRepayQuery11;
import query.view.ValueRepayJPanel;

public class ValueRepayController extends DataControl {
	private String[] policy_info;
	private String policy_no;
	private ValueRepayJPanel valueRepayPanel;

	public ValueRepayController() {
		valueRepayPanel = new ValueRepayJPanel();
		valueRepayPanel.setController(this);
	}

	public String getOldPolicy_no() {
		// TODO Auto-generated method stub
		return policy_no;
	}

	public JPanel getPanel() {
		// TODO Auto-generated method stub
		return valueRepayPanel;
	}

	@Override
	public void executeMission() { //
		// TODO Auto-generated method stub
		// 先清空資料
		this.policy_no = policy_info[0];
		valueRepayPanel.clearValueRepay01();
		valueRepayPanel.clearValueRepay02();
		valueRepayPanel.clearValueRepay03();
		valueRepayPanel.clearValueRepay04();
		valueRepayPanel.clearValueRepay05();
		valueRepayPanel.clearValueRepay06();
		valueRepayPanel.clearValueRepay07();
		valueRepayPanel.clearValueRepay08();
		valueRepayPanel.clearValueRepay09();
		valueRepayPanel.clearValueRepay10();
		valueRepayPanel.clearValueRepay11();

		// 區域1
		ValueRepayQuery01 vrq01 = new ValueRepayQuery01();
		List<HashMap<String, String>> vrq01list = vrq01.getResultList(
				policy_info[0], 0);
		vrq01list = setErrResultInd(vrq01list, "cc162i");
		for (HashMap<String, String> hsmap : vrq01list) {
			ValueRepay01 valueRepay01 = new ValueRepay01(hsmap);
			valueRepayPanel.addValueRepay01(valueRepay01);
		}

		// 區域2
		ValueRepayQuery02 vrq02 = new ValueRepayQuery02();

		List<HashMap<String, String>> vrq02list = vrq02.getResultList(
				policy_info[0], 0);
		vrq02list = setErrResultInd(vrq02list, "cc163i");
		for (HashMap<String, String> hsmap : vrq02list) {
			ValueRepay02 valueRepay02 = new ValueRepay02(hsmap);
			// 還本註記
			valueRepay02.setR_nonresp_sw(vrq02.getNonresp_sw(policy_info[0],
					valueRepay02.getR_cp_anniv_date()));
			// 還本回流回覆期間
			valueRepay02.setR_cp_return_date_interval(vrq02.getCpReturn_date(
					policy_info[0], valueRepay02.getR_cp_anniv_date()));
			valueRepayPanel.addValueRepay02(valueRepay02);
		}
		if (this.isErr) {
			valueRepayPanel.clearValueRepay03();
			valueRepayPanel.clearValueRepay04();
			valueRepayPanel.clearValueRepay05();
			valueRepayPanel.clearValueRepay06();
			valueRepayPanel.clearValueRepay07();
			valueRepayPanel.clearValueRepay08();
			valueRepayPanel.clearValueRepay09();
			valueRepayPanel.clearValueRepay10();
			valueRepayPanel.clearValueRepay11();
		}
		valueRepayPanel.setDefaultRow();
		this.showMessageDialog(valueRepayPanel, "還本金", "此保單非還本保單");

	}

	public void executeInnerMission03(String policy_no, String cp_anniv_date) {
		ValueRepayQuery03 vrq03 = new ValueRepayQuery03();
		List<HashMap<String, String>> vrqlist03 = vrq03.getResultList(
				policy_no, cp_anniv_date);
		vrqlist03 = setErrResultInd(vrqlist03, "cc164i");
		for (HashMap<String, String> hsmp : vrqlist03) {
			ValueRepay03 vp03 = new ValueRepay03(hsmp);
			valueRepayPanel.addValueRepay03(vp03);
		}
	}

	public void executeInnerMission04(String policy_no, String cp_anniv_date,
			String disb_spec_ind, String relation) {
		ValueRepayQuery04 vrq04 = new ValueRepayQuery04();
		List<HashMap<String, String>> vrq04list = vrq04.getResultList(
				policy_no, cp_anniv_date, disb_spec_ind, relation,
				policy_info[6]);
		vrq04list = setErrResultInd(vrq04list, "cc165i");
		for (HashMap<String, String> hsmap : vrq04list) {
			ValueRepay04 valueRepay04 = new ValueRepay04(hsmap);
			valueRepayPanel.addValueRepay04(valueRepay04);
		}

	}

	public void executeInnerMission05(String policy_no, String cp_anniv_date) {
		ValueRepayQuery05 vrq05 = new ValueRepayQuery05();
		List<HashMap<String, String>> vrq05list = vrq05.getResultList(
				policy_no, cp_anniv_date);
		vrq05list = setErrResultInd(vrq05list, "cc166i");
		for (HashMap<String, String> hsmap : vrq05list) {
			ValueRepay05 valueRepay05 = new ValueRepay05(hsmap);
			valueRepayPanel.addValueRepay05(valueRepay05);
		}
	}

	public void executeInnerMission06(String policy_no, String cp_anniv_date) {
		ValueRepayQuery06 vrq06 = new ValueRepayQuery06();
		List<HashMap<String, String>> vrq06list = vrq06.getResultList(
				policy_no, cp_anniv_date);
		vrq06list = setErrResultInd(vrq06list, "cc167i");
		for (HashMap<String, String> hsmap : vrq06list) {
			ValueRepay06 valueRepay06 = new ValueRepay06(hsmap);
			valueRepayPanel.addValueRepay06(valueRepay06);
		}
	}

	public void executeInnerMission07(String policy_no, String cp_anniv_date,
			int serial) {
		ValueRepayQuery07 vrq07 = new ValueRepayQuery07();
		List<HashMap<String, String>> vrq07list = vrq07.getResultList(
				policy_no, cp_anniv_date, serial);
		vrq07list = setErrResultInd(vrq07list, "cc168i");
		for (HashMap<String, String> hsmap : vrq07list) {
			ValueRepay07 valueRepay07 = new ValueRepay07(hsmap);
			valueRepayPanel.addValueRepay07(valueRepay07);
		}
		valueRepayPanel.setDefaultRow();
	}

	public void executeInnerMission08(String policy_no, String cp_anniv_date) {
		ValueRepayQuery08 vrq08 = new ValueRepayQuery08();
		List<HashMap<String, String>> vrq08list = vrq08.getResultList(
				policy_no, cp_anniv_date);
		vrq08list = setErrResultInd(vrq08list, "cc169i");
		for (HashMap<String, String> hsmap : vrq08list) {
			ValueRepay08 valueRepay08 = new ValueRepay08(hsmap);
			valueRepayPanel.addValueRepay08(valueRepay08);
		}
	}

	public void executeInnerMission09(String policy_no, String cp_anniv_date) {
		ValueRepayQuery09 vrq09 = new ValueRepayQuery09();
		List<HashMap<String, String>> vrq09list = vrq09.getResultList(
				policy_no, cp_anniv_date);
		// vrq09list = setErrResultInd(vrq09list, "psca_disb_type");
		for (HashMap<String, String> hsmap : vrq09list) {
			ValueRepay09 valueRepay09 = new ValueRepay09(hsmap);
			valueRepayPanel.addValueRepay09(valueRepay09);
		}
	}

	public void executeInnerMission10(String policy_no, String cp_anniv_date) {
		ValueRepayQuery10 vrq10 = new ValueRepayQuery10();
		List<HashMap<String, String>> vrq10list = vrq10.getResultList(
				policy_no, cp_anniv_date);
		// vrq10list = setErrResultInd(vrq10list, "psca_pay");
		for (HashMap<String, String> hsmap : vrq10list) {
			ValueRepay10 valueRepay10 = new ValueRepay10(hsmap);
			valueRepayPanel.addValueRepay10(valueRepay10);
		}
	}

	public void executeInnerMission11(String policy_no, String cp_anniv_date) {
		ValueRepayQuery11 vrq11 = new ValueRepayQuery11();
		List<HashMap<String, String>> vrq11list = vrq11.getResultList(
				policy_no, cp_anniv_date);
		// vrq11list = setErrResultInd(vrq11list, "psca_premium_pay");
		for (HashMap<String, String> hsmap : vrq11list) {
			ValueRepay11 valueRepay11 = new ValueRepay11(hsmap);
			valueRepayPanel.addValueRepay11(valueRepay11);
		}
	}

	@Override
	public void executeClearMission() {
		valueRepayPanel.clearAll();
	}

	@Override
	public void executeNullMission() {
		valueRepayPanel.nullAll();
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
