package query.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JPanel;

import query.model.PayAccount.PayAccount01;
import query.model.PayAccount.PayAccount02;
import query.model.PayAccount.PayAccountQuery;
import query.view.PayAccountJPanel;
/**
 * 
 * @author ���a��
 * 
 */
public class PayAccountController extends DataControl {
	private String policy_no;
	private String client_id;
	private String client_name;
	private String policy_info[];
	private PayAccountJPanel premaccountPanel;
	private PayAccountQuery rq = new PayAccountQuery();

	public PayAccountController() {
		premaccountPanel = new PayAccountJPanel();
	}

	@Override
	public void executeMission() {
		
		this.policy_no = policy_info[0];
		this.client_id = policy_info[1];
		this.client_name = policy_info[2];

		// �M�ŵe��
		premaccountPanel.clearPremAccount01();
		premaccountPanel.clearPremAccount02();
//		System.out.println(client_id+"**"+client_name);
		// ��J�״ڬ��w�b���ƺ[���ʸ��
		List<HashMap<String, String>> list = setErrResultInd(rq.getResultList(
				client_id, client_name, PayAccountQuery.PREMACCOUNT), "cc190i");
		
		for (HashMap<String, String> hsmap : list) {
			// �]�nbinding���JTable�A�G�����bean(�]�n���group)
			PayAccount01 premaccount01 = new PayAccount01(hsmap);
			PayAccount02 premaccount02 = new PayAccount02(hsmap);
			
			// �̱����group
			if (hsmap.get("r_data_ind").equals("1")) {
				premaccountPanel.addPremAccount01(premaccount01);
			    String[] Sid = {client_id};
				premaccountPanel.setClientID( Sid);}
			else if (hsmap.get("r_data_ind").equals("2")) 
				premaccountPanel.addPremAccount02(premaccount02);
		}
		this.showMessageDialog(premaccountPanel, "�״ڬ��w�b��d��", "�Ȥ��Ҹ����ũεL���");
	}

	@Override
	public void executeClearMission(){
		premaccountPanel.clearPremAccount01();
		premaccountPanel.clearPremAccount02();
	}
	
	@Override
	public void executeNullMission(){
		premaccountPanel.nullAll();
	}
	
	@Override
	public String getOldPolicy_no() {
		// TODO Auto-generated method stub
		return policy_no;
	}

	@Override
	public JPanel getPanel() {
		// TODO Auto-generated method stub
		return premaccountPanel;
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
