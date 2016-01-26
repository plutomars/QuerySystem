package query.controller;

import java.util.HashMap;
import java.util.List;

import javax.swing.JPanel;

import query.model.PremBill.PremBill;
import query.model.PremBill.PremBill01;
import query.model.PremBill.PremBillQuery;
import query.view.PremBillJPanel;
/**
 * 
 * @author cychu
 *
 * @version 1.0<br/>
 * 			100/09/06<br/>
 * 			���ک���(Controller)
 * 
 * @since 1.0
 */
public class PremBillController extends DataControl {
	private String policy_no;
	private String policy_info[];
	private PremBillJPanel premBillPanel = new PremBillJPanel();
	
	@Override
	public void executeMission() {
		this.policy_no = policy_info[0];
		PremBillQuery pq = new PremBillQuery();
		
		premBillPanel.clearPremBills();
		premBillPanel.clearPremBill01s();

		List<HashMap<String, String>> list = setErrResultInd(pq.getResultList(policy_no,
				PremBillQuery.PREMBILL), "cc131i");
		List<HashMap<String, String>> listPrem = setErrResultInd(pq.getResultList(policy_no,
				PremBillQuery.PREMBILL01), "cc132i");
		// ��J�ثe���ڸ�������
		for (HashMap<String, String> hsmap : list) {
			PremBill premBill = new PremBill(hsmap);
			premBillPanel.addPremBill(premBill);
			premBillPanel.insertValue();
			//��J���ک��������
			for (HashMap<String, String> hsmap2 : listPrem) {
				PremBill01 premBill01 = new PremBill01(hsmap2);
				premBillPanel.addPremBill01(premBill01);
			}
		}
		showMessageDialog(premBillPanel, "���ک��Ӭd��", "�O�椣�ũεL���");
	}

	@Override
	public String getOldPolicy_no() {
		return policy_no;
	}

	@Override
	public JPanel getPanel() {
		return premBillPanel;
	}

	@Override
	public boolean isControllable() {
		return false;
	}

	@Override
	public void setPolicyInfo(String[] policy_info) {
		this.policy_info = policy_info;
	}

	@Override
	public void executeClearMission() {
		premBillPanel.clearAll();
	}

	@Override
	public void executeNullMission() {
		premBillPanel.nullAll();
	}
}
