package query.controller;

import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import query.model.NewFaceAmount.NewFaceAmount01;
import query.model.NewFaceAmount.NewFaceAmountIPA;
import query.model.NewFaceAmount.NewFaceAmountQuery;
import query.view.NewFaceAmountJPanel;
/**
 * 
 * @author ���a��
 * 
 */
public class NewFaceAmountController extends DataControl {
	private String policy_no;
	private String client_id;
	private String policy_info[];
	private NewFaceAmountJPanel newfaceamountPanel;
	private NewFaceAmountQuery rq = new NewFaceAmountQuery();
	private String mission1; // 1�����ұ��� �O�渹�X
	private String mission2; // 2�����ұ��� �I�����O
//	private String mission3; // 3�����ұ��� �۰ʤƬd��
	
	public NewFaceAmountController() {
		newfaceamountPanel = new NewFaceAmountJPanel();
		newfaceamountPanel.setController(this);
	}

	@Override
	public void executeMission() {
		// TODO Auto-generated method stub
		this.policy_no = policy_info[0];
		this.client_id = policy_info[4]; // �Q�O�Hid
		String occu_code;

		// �M�ŵe��
		newfaceamountPanel.clearAll();
		newfaceamountPanel.setDefaultValue();
		
		mission1 = "0";
		mission2 = "0";
		
		// ���o�Q�O�H�ͤ�M¾�~�N�X
		List<HashMap<String, String>> list = setErrResultInd(
				rq.getResultList(client_id, NewFaceAmountQuery.NEWFACEBIRTH),
				"�ͤ�M¾�~�N�X");
		for (HashMap<String, String> hsmap : list) {
			newfaceamountPanel.setNewFaceAmount02(hsmap);

			// ���o¾�~�N�X����
			occu_code = hsmap.get("r_occu_code");
			list = setErrResultInd(rq.getResultList(occu_code,
					NewFaceAmountQuery.NEWFACEOCCUP), "¾�~�N�X����");
			for (HashMap<String, String> hsmap02 : list) {
				newfaceamountPanel.setNewFaceAmount03(hsmap02);
				break;
			}
			break;
		}
		
		executeMissionTabValues(0);
//		executeMissionTabValues(1);
		
	}

	public void executeInnerMssion(String occu_code) {
		String occupation = null;
		
		// ���o¾�~�N�X����
		List<HashMap<String, String>> list = setErrResultInd(
				rq.getResultList(occu_code, NewFaceAmountQuery.NEWFACEOCCUP),
				"¾�~�N�X����");
		for (HashMap<String, String> hsmap : list) {
			newfaceamountPanel.setNewFaceAmount03(hsmap);
			occupation = hsmap.get("r_occupation");
			break;		
		}
		// �L��¾�~�N�X�����B�z
		if (occupation==null || occupation.length()==0)
			JOptionPane.showMessageDialog(newfaceamountPanel, "¾�~�N�X��J���~",
					"¾�~�N�X�d��", JOptionPane.INFORMATION_MESSAGE);
		
	}

	public void executeInnerMission(String ag_ind, String occu_code) {
		// �M�Ÿ��
		newfaceamountPanel.clearNewFaceAmount01();

		// ��J�֭p�O�Btable������
		List<HashMap<String, String>> list = setErrResultInd(
				rq.getResultList(client_id, ag_ind, occu_code,
						NewFaceAmountQuery.NEWFACEAMOUNT), "cc014i");
		for (HashMap<String, String> hsmap : list) {
			NewFaceAmount01 newfaceamount01 = new NewFaceAmount01(hsmap);
			newfaceamountPanel.addNewFaceAmount01(newfaceamount01);				
		}
		this.showMessageDialog(newfaceamountPanel, "�֭p�O�B�d��", "�Ȥ��Ҹ����ũεL���");
	}

	public void executeIPAMission(String policy_no) {
		// �M�Ÿ��
		newfaceamountPanel.clearNewIPA();

		// ��J�֭p�O�Btable������
		List<HashMap<String, String>> list = setErrResultInd(
				rq.getResultList(policy_no,
						NewFaceAmountQuery.NEWFACEIPA), "cc014i01");
		for (HashMap<String, String> hsmap : list) {
			NewFaceAmountIPA newfaceamountIPA = new NewFaceAmountIPA(hsmap);
			newfaceamountPanel.addNewIPA(newfaceamountIPA);				
		}
		this.showMessageDialog(newfaceamountPanel, "�֭p�O�B�d��", "�Ȥ��Ҹ����ũεL���");
	}
	
	public void executeMissionTabValues(int tabSelect){
		if ( tabSelect == 0 && mission1.equals("0")){
			mission1 = "1";
			newfaceamountPanel.clearNewPONO();
			List<HashMap<String, String>> list = setErrResultInd(
					rq.getResultList(client_id, "", "",tabSelect), "cc014i");
			
			for (HashMap<String, String> hsmap : list) {
				NewFaceAmount01 newPONO = new NewFaceAmount01(hsmap);
				newfaceamountPanel.addNewPONO(newPONO);				
			}
			this.showMessageDialog(newfaceamountPanel, "�O�B�d��", "�Ȥ��Ҹ����ũεL���");
		}
		
		if ( tabSelect == 1 && mission2.equals("0")){
			mission2 = "1";
			newfaceamountPanel.clearNewPLAN();
			List<HashMap<String, String>> list = setErrResultInd(
					rq.getResultList(client_id, "", "",tabSelect), "cc014i");
			
			for (HashMap<String, String> hsmap : list) {
				NewFaceAmount01 newPLAN = new NewFaceAmount01(hsmap);
				newfaceamountPanel.addNewPLAN(newPLAN);				
			}
			this.showMessageDialog(newfaceamountPanel, "�O�B�d��", "�Ȥ��Ҹ����ũεL���");
		}	
	}
	
	@Override
	public void executeClearMission(){
		newfaceamountPanel.clearNewFaceAmount01();
	}
	
	@Override
	public void executeNullMission(){
		newfaceamountPanel.nullAll();
	}
	
	@Override
	public String getOldPolicy_no() {
		// TODO Auto-generated method stub
		return policy_no;
	}

	@Override
	public JPanel getPanel() {
		// TODO Auto-generated method stub
		return newfaceamountPanel;
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
