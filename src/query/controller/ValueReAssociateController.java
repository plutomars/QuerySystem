package query.controller;

import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import query.model.ValueReAssociate.ValueReAssociate01;
import query.model.ValueReAssociate.ValueReAssociate01Group;
import query.model.ValueReAssociate.ValueReAssociate01Query;
import query.model.ValueReAssociate.ValueReAssociate02Group;
import query.view.ValueReAssociateJPanel;
import query.view.PremProxyJPanel;
/**
 * @version 1.0
 * @author swei
 * �^�y���p�d��PoReAssociate_controller
 * 
 */
public class ValueReAssociateController extends DataControl {

	private ValueReAssociateJPanel poreassociate01Panel = new ValueReAssociateJPanel();//add
	private String policy_info[];
	public String New_policy;
	public String Old_policy;
	public String Anniv_date;
	public String policy_no;
	private ValueReAssociate01Group group01 = new ValueReAssociate01Group();//add �D�e������
	private ValueReAssociate02Group group02 = new ValueReAssociate02Group();//add ����
	
	public ValueReAssociateJPanel PoReAssociatePanel = new ValueReAssociateJPanel();

	@Override
	public void executeMission() {
		// TODO Auto-generated method stub
 		this.policy_no = policy_info[0];
	}
	
	public ValueReAssociateController() {
		poreassociate01Panel.setController(this);
	}

	public void executeMission(String New_policy, String Old_policy,String Anniv_date) {
		this.New_policy = New_policy;
		this.Old_policy = Old_policy;
		this.Anniv_date = Anniv_date;

		
		if(New_policy.isEmpty() == true && Old_policy.isEmpty() == true && Anniv_date.isEmpty() != true)
		{
			group01.removeAll();
			group02.removeAll();
			JOptionPane.showMessageDialog(null, "�٥��g�~�餣�i��@�d�ߡA�Ъ��[�O�渹�X����I");
			return;
		}
		else
		{
			if(New_policy.isEmpty() == true && Old_policy.isEmpty() == true && Anniv_date.isEmpty() == true )
			{
				JOptionPane.showMessageDialog(null, "�п�J�d�߱���I");
				return;
			}
			else
			{
				
				// ��J"�I�ڸ�Ƭd��01"(PoReAssociate_01)
				ValueReAssociate01Query rq = new ValueReAssociate01Query();
				List<HashMap<String, String>> list = rq.getResultList(New_policy, Old_policy, Anniv_date ,ValueReAssociate01Query.PoReQ01);
				if(list.size() == 0 )
				{
					JOptionPane.showMessageDialog(null, "�L�ŦX����ơI");
					return;
				}
				if(New_policy.isEmpty() == true && Old_policy.isEmpty() != true && Anniv_date.isEmpty() == true)
				{
					group01.removeAll();
					group02.removeAll();
					JOptionPane.showMessageDialog(null, "�¥�O�渹�X�A�Цh�[�٥��g�~�骺���� �I");
					return;
				}
				else
				{
					group01.removeAll();
					group02.removeAll();
					poreassociate01Panel.clearPoReAssociate01s();
					for (HashMap<String, String> hsmap : list) {
						ValueReAssociate01 poreassociate01 = new ValueReAssociate01(hsmap);
						poreassociate01Panel.addPoReAssociate01(poreassociate01);
					}
					poreassociate01Panel.setDefaultRow();
				}
			}
		}
		showMessageDialog(poreassociate01Panel, "�^�y���p�d��", "�O�椣�ũεL���");
	}
	
	@Override
	public void executeClearMission(){
		PoReAssociatePanel.clearAll();
	}
	
	@Override
	public void executeNullMission(){
		PoReAssociatePanel.nullAll();
	}
	
	@Override
	public String getOldPolicy_no() {
		// TODO Auto-generated method stub
		return this.policy_no;
	}

	@Override
	public JPanel getPanel() {
		// TODO Auto-generated method stub
		return poreassociate01Panel;//add
	}

	@Override
	public boolean isControllable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setPolicyInfo(String[] arg0) {
		// TODO Auto-generated method stub
		policy_info = arg0;
	}


}
