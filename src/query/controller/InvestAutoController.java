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
 * @author ���a��
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
	// ��J�۰��ഫ���
	public void executeMission() {
		// TODO Auto-generated method stub
		this.policy_no = policy_info[0];
		// �Yuser����J�O�檽���I���|�S�����O
		try {
			this.currency = policy_info[6].substring(0, 3);
		} catch (StringIndexOutOfBoundsException e) {
			e.printStackTrace();
		}

		// �M�ŵe��
		investautoPanel.clearInvestAuto01();
		investautoPanel.clearInvestAuto02();
		investautoPanel.clearInvestAuto03();

		Integer i = 1;
		List<HashMap<String, String>> list = setErrResultInd(rq.getResultList(
				policy_no, currency, InvestAutoQuery.INVESTAUTO), "cc150i");
		for (HashMap<String, String> hsmap : list) {
			InvestAuto01 investauto01 = new InvestAuto01(hsmap);
			investautoPanel.addInvestAuto01(investauto01);
			// ��J�U���۰��ഫ���(verticalPane)�Ȱ��@��
			if (i == 1) {
				investautoPanel.setInvestAuto01(hsmap);
			}
			i++;
		}
		investautoPanel.setDefaultRow();
		this.showMessageDialog(investautoPanel, "�۰��ഫ�d��", "�O�椣�ũεL���");
	}

	// ��J�[�X���Ӹ��
	public void executeInnerMission01(String auto_tr_date,
			String invs_avail_type) {
		investautoPanel.clearInvestAuto02();

		// �ȸ��I�ئ��[�X���Ӥ~��call cc151i ( String������n��equals )
		if (invs_avail_type.equals("3")) {
			List<HashMap<String, String>> list = setErrResultInd(
					rq.getResultList(policy_no, currency, auto_tr_date,
							InvestAutoQuery.INVESTAUTODETAIL), "cc151i");
			for (HashMap<String, String> hsmap : list) {
				InvestAuto02 investauto02 = new InvestAuto02(hsmap);
				investautoPanel.addInvestAuto02(investauto02);
			}

			// ��r_result_ind=1(�D���`)�~�|���X����(�Ӧ�DataControl)
			this.showMessageDialog(investautoPanel, "�[�X���Ӭd��", "�L�[�X���Ӹ��");
		} else
			// �L������X����
			JOptionPane.showMessageDialog(investautoPanel, "���I�صL�[�X����",
					"�[�X���Ӭd��", JOptionPane.INFORMATION_MESSAGE);
	}

	// ��J���Q���
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
		this.showMessageDialog(investautoPanel, "���Q�d��", "�O�椣�ũεL���");
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
