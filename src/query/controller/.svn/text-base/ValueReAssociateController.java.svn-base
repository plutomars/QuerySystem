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
 * 回流關聯查詢PoReAssociate_controller
 * 
 */
public class ValueReAssociateController extends DataControl {

	private ValueReAssociateJPanel poreassociate01Panel = new ValueReAssociateJPanel();//add
	private String policy_info[];
	public String New_policy;
	public String Old_policy;
	public String Anniv_date;
	public String policy_no;
	private ValueReAssociate01Group group01 = new ValueReAssociate01Group();//add 主畫面索引
	private ValueReAssociate02Group group02 = new ValueReAssociate02Group();//add 分錄
	
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
			JOptionPane.showMessageDialog(null, "還本週年日不可單一查詢，請附加保單號碼條件！");
			return;
		}
		else
		{
			if(New_policy.isEmpty() == true && Old_policy.isEmpty() == true && Anniv_date.isEmpty() == true )
			{
				JOptionPane.showMessageDialog(null, "請輸入查詢條件！");
				return;
			}
			else
			{
				
				// 塞入"付款資料查詢01"(PoReAssociate_01)
				ValueReAssociate01Query rq = new ValueReAssociate01Query();
				List<HashMap<String, String>> list = rq.getResultList(New_policy, Old_policy, Anniv_date ,ValueReAssociate01Query.PoReQ01);
				if(list.size() == 0 )
				{
					JOptionPane.showMessageDialog(null, "無符合的資料！");
					return;
				}
				if(New_policy.isEmpty() == true && Old_policy.isEmpty() != true && Anniv_date.isEmpty() == true)
				{
					group01.removeAll();
					group02.removeAll();
					JOptionPane.showMessageDialog(null, "舊件保單號碼，請多加還本週年日的條件 ！");
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
		showMessageDialog(poreassociate01Panel, "回流關聯查詢", "保單不符或無資料");
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
