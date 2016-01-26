package query.controller;

import java.util.HashMap;
import java.util.List;

import javax.swing.JPanel;

import query.model.InvestGoal.InvestGoal02;
import query.model.InvestGoal.InvestGoal04;
import query.model.InvestGoal.InvestGoalInt;
import query.model.InvestGoal.InvestGoalQuery;
import query.view.InvestGoalJPanel;

public class InvestGoalController extends DataControl {
	private String policy_no;
	private String policy_info[];
	private InvestGoalJPanel investGoalPanel = new InvestGoalJPanel();
    private String pv_calc_date;
    private String pv_calc_type;
    private String exsrc;
    private String exprc;
    private String currency;
	
	public InvestGoalController(){
		investGoalPanel.setController(this);
	}
	
	@Override
	public void executeMission() {
		this.policy_no = policy_info[0];
		InvestGoalQuery pq = new InvestGoalQuery();

		investGoalPanel.clearAll();
		investGoalPanel.cleanAllo4group();

//------------
		List<HashMap<String, String>> list = setErrResultInd(
				pq.getResultList(policy_no, InvestGoalQuery.INVEST_LEFT),
				"cc145i");
		for (HashMap<String, String> hsmap : list) {
			investGoalPanel.setInvestGoal01(hsmap);
			this.pv_calc_date = hsmap.get("r_pv_calc_date");
			this.pv_calc_type = hsmap.get("r_pv_calc_type");
			this.exsrc = hsmap.get("r_exsrc");
			this.exprc = hsmap.get("r_exprc");
			this.currency = hsmap.get("r_currency");
//			list = setErrResultInd(
//					pq.getResultList(policy_no,hsmap.get("r_pv_calc_date"),hsmap.get("r_pv_calc_type"),hsmap.get("r_exsrc"),hsmap.get("r_exprc"),hsmap.get("r_currency"), InvestGoalQuery.INVEST_GOAL1),
//					"cc146i");
		}

		if (this.pv_calc_date.trim().length()>8 )
		{	
//			System.out.println("---"+this.pv_calc_date.length());
		list = setErrResultInd(
				pq.getResultList(policy_no,pv_calc_date,pv_calc_type,exsrc,exprc,currency, InvestGoalQuery.INVEST_GOAL1),
				"cc146i");
		for (HashMap<String, String> hsmap : list) {
			InvestGoal02 goal02 = new InvestGoal02(hsmap);
			investGoalPanel.cleanAllo4group();
			investGoalPanel.addInvestGoal02(goal02);
			}
		investGoalPanel.setDefaultRow();
		}
		showMessageDialog(investGoalPanel, "投資標的、餘額", "保單不符或無資料");
	}
	
	
	public void executeMissionGoal03 (String invs_code, String invs_name,int tabSelect){
		InvestGoalQuery pq = new InvestGoalQuery();
		investGoalPanel.cleanAllo4group();
//		System.out.println("MissionGoal04 beg");
		if (tabSelect == 0) {
			List<HashMap<String, String>> list = setErrResultInd(
				pq.getResultList(policy_no, invs_code, invs_name,InvestGoalQuery.INVEST_GOAL3 ),
				"cc148i");
			for (HashMap<String, String> hsmap : list) {
			InvestGoal04 goal04 = new InvestGoal04(hsmap);
			investGoalPanel.addInvestGoal04(goal04);   }
		}else
		{
//			System.out.println(invs_code + " src=" + exsrc+" prc="+exprc+" curr="+currency);
			List<HashMap<String, String>> list = setErrResultInd(
					pq.getResultList(policy_no, invs_code,exsrc,exprc,currency ),
					"cc155i");
				for (HashMap<String, String> hsmap : list) {
				InvestGoalInt goalInt = new InvestGoalInt(hsmap);
//				System.out.println(goalInt.getinvs_base_date());
				if (goalInt.getinvs_base_date().equals("sum"))
					investGoalPanel.setSumData(goalInt.getexrt_rate(), goalInt.getinvs_ad_no(), goalInt.getinvs_ad_amt(), goalInt.getinvs_base_rate());
				else	
				investGoalPanel.addInvestGoalInt(goalInt);   }
			
		}
		
    }

	@Override
	public String getOldPolicy_no() {
		// TODO Auto-generated method stub
		return policy_no;
	}

	@Override
	public JPanel getPanel() {
		// TODO Auto-generated method stub
		return investGoalPanel;
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
	
	@Override
	public void executeClearMission(){
		investGoalPanel.clearAll();
	}
	@Override
	public void executeNullMission(){
		investGoalPanel.nullAll();
	}
	

}
