package query.controller;

/**
 * 
 * @author swei
 * @version 1.0
 * 體檢醫院查詢(Controller)
 * 
 * 
 */

import java.util.HashMap;
import java.util.List;

import javax.swing.JPanel;

import query.model.NewHospital.NewHospital01;
import query.model.NewHospital.NewHospitalQuery;
import query.view.NewHospitalJPanel;
import query.view.PremProxyJPanel;

public class NewHospitalController extends DataControl {
	public String policy_no = "";
	public int a;
	public String area_code="";	
	public String txt_search="";
	private NewHospitalJPanel newhospital01panel = new NewHospitalJPanel();// add
	
	@Override
	public void executeMission() {
		// TODO Auto-generated method stub
		NewHospitalQuery rq = new NewHospitalQuery();
		// 塞入"體檢醫院資料-體檢醫療院所"(NewHospital01)
		List<HashMap<String, String>> list = setErrResultInd(rq.getResultList(area_code,txt_search,NewHospitalQuery.NewHospital_HM),"cc122i");// 將執行結果存入list
		
		newhospital01panel.clearNewHospital01s();
		for (HashMap<String, String> hsmap : list) {
			NewHospital01 newhospital01 = new NewHospital01(hsmap);
			newhospital01panel.addNewHospital01(newhospital01);
		}
	}

	public void executeMission(String area_code,int a) {
		// TODO Auto-generated method stub
		this.area_code = area_code;
		this.a = a;
		NewHospitalQuery rq = new NewHospitalQuery();
		// 塞入"體檢醫院資料-體檢項目"(NewHospital02)
		List<HashMap<String, String>> list2 = setErrResultInd(rq.getResultList(area_code,txt_search, NewHospitalQuery.NewHospital_HM),"cc123i");// 將執行結果存入list
		
		newhospital01panel.clearNewHospital01s();
		for (HashMap<String, String> hsmap : list2) {
			NewHospital01 newhospital01 = new NewHospital01(hsmap);
			newhospital01panel.addNewHospital01(newhospital01);
		}
		 showMessageDialog(newhospital01panel, "體檢醫院資料查詢", "保單不符或無資料");
	}
	
	@Override
	public String getOldPolicy_no() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JPanel getPanel() {
		// TODO Auto-generated method stub
		return newhospital01panel;//add
	}

	@Override
	public boolean isControllable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setPolicyInfo(String[] arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void executeClearMission() {
		// TODO Auto-generated method stub
		newhospital01panel.clearAll();
	}

	@Override
	public void executeNullMission() {
		// TODO Auto-generated method stub
		newhospital01panel.nullAll();
	}
	
}
