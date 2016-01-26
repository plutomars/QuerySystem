package query.controller;

import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import query.model.PosChange.PosChange01;
import query.model.PosChange.PosChange02;
import query.model.PosChange.PosChange03;
import query.model.PosChange.PosChange04;
import query.model.PosChange.PosChange05;
import query.model.PosChange.PosChangeQuery01;
import query.model.PosChange.PosChangeQuery02;
import query.model.PosChange.PosChangeQuery03;
import query.model.PosChange.PosChangeQuery04;
import query.model.PosChange.PosChangeQuery05;
import query.view.PosChangeJPanel;

public class PosChangeController extends DataControl {
	private String policy_info[];
	private String policy_no;

	private PosChangeJPanel posChangeJPanel;

	public PosChangeController() {
		posChangeJPanel = new PosChangeJPanel();
		posChangeJPanel.setController(this);
	}

	@Override
	public void executeMission() {
		// TODO Auto-generated method stub
		this.policy_no = policy_info[0];
		posChangeJPanel.setPONO(policy_no);
		posChangeJPanel.clearAll();
		executeMission(this.policy_no, "", "", "");
	}

	// 101.04.02 新增保單號碼/申請人ID/受理號碼 之索引
	public void executeMission(String policy_no, String client_ind,
			String applicant_id, String rece_no) {
		// TODO Auto-generated method stub
		if (policy_no.isEmpty() == true && client_ind.isEmpty() == true
				&& applicant_id.isEmpty() == true && rece_no.isEmpty() == true) {
			JOptionPane.showMessageDialog(null, "請輸入查詢條件！");
			return;
		} else {
			// for 新契約用, 只show未結案件
			client_ind = ""; // 設預設空值
			executeClearMission();
			PosChangeQuery01 pcq = new PosChangeQuery01();
			List<HashMap<String, String>> list = setErrResultInd(
					pcq.getResultList(policy_no, client_ind, applicant_id,
							rece_no), "cc136i");

			if (list.size() == 0) {
				JOptionPane.showMessageDialog(null, "無符合您查詢的有關資料！");
				return;
			} else {
				posChangeJPanel.clearPosChange01();
				for (HashMap<String, String> hsmp : list) {
					PosChange01 posChange01 = new PosChange01(hsmp);
					posChangeJPanel.addPosChange01(posChange01);
				}
				posChangeJPanel.setDefaultRow();
				showMessageDialog(posChangeJPanel, "契變內容查詢", "保單不符或無資料");
			}
		}
	}

	// (預留給NewDetailController) 101.04.02
	public void executeMission(String client_ind) {
		// TODO Auto-generated method stub // for 新契約用, 只show未結案件
		this.policy_no = policy_info[0];
		executeClearMission();
		PosChangeQuery01 pcq = new PosChangeQuery01();
		List<HashMap<String, String>> list = setErrResultInd(
				pcq.getResultList(policy_no, client_ind), "cc136i");
		posChangeJPanel.clearPosChange01();
		for (HashMap<String, String> hsmp : list) {
			PosChange01 posChange01 = new PosChange01(hsmp);
			posChangeJPanel.addPosChange01(posChange01);
		}
		posChangeJPanel.setDefaultRow();
		showMessageDialog(posChangeJPanel, "契變內容查詢", "保單不符或無資料");
	}

	public void executeInnerMission02(String receive_no) {
		PosChangeQuery02 pcq02 = new PosChangeQuery02();
		List<HashMap<String, String>> pcq02list = setErrResultInd(
				pcq02.getResultList(receive_no), "cc137i");
		for (HashMap<String, String> hsmp : pcq02list) {
			PosChange02 posChange02 = new PosChange02(hsmp);
			posChangeJPanel.addPosChange02(posChange02);
		}
	}

	public void executeInnerMission03(String receive_no) {
		PosChangeQuery03 pcq03 = new PosChangeQuery03();
		List<HashMap<String, String>> pcq03list = setErrResultInd(
				pcq03.getResultList(receive_no), "cc138i");
		for (HashMap<String, String> hsmp : pcq03list) {
			PosChange03 posChange03 = new PosChange03(hsmp);
			posChangeJPanel.addPosChange03(posChange03);
		}
	}

	public void executeInnerMission04(String receive_no) {
		PosChangeQuery04 pcq04 = new PosChangeQuery04();
		List<HashMap<String, String>> pcq04list = setErrResultInd(
				pcq04.getResultList(receive_no), "cc139i");
		for (HashMap<String, String> hsmp : pcq04list) {
			PosChange04 posChange04 = new PosChange04(hsmp);
			posChangeJPanel.addPosChange04(posChange04);
		}
	}

	public void executeInnerMission05(String receive_no) {
		PosChangeQuery05 pcq05 = new PosChangeQuery05();
		List<HashMap<String, String>> pcq05list = setErrResultInd(
				pcq05.getResultList(receive_no), "psg84i01");
		for (HashMap<String, String> hsmp : pcq05list) {
			PosChange05 posChange05 = new PosChange05(hsmp);
			posChangeJPanel.addPosChange05(posChange05);
		}
	}

	@Override
	public void executeNullMission() {
		posChangeJPanel.nullAll();
	}

	@Override
	public String getOldPolicy_no() {
		// TODO Auto-generated method stub
		return policy_no;
	}

	@Override
	public JPanel getPanel() {
		// TODO Auto-generated method stub
		return posChangeJPanel;
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

	public void executeClearMission() {
		posChangeJPanel.clearAll();
	}
}
