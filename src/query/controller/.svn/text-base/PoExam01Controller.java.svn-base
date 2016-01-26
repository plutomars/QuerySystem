package query.controller;
/**
 * 
 * @author swei
 * @version 1.0
 * 體檢批註告知查詢(Controller)
 * 
 * 
 */
import java.util.HashMap;
import java.util.List;

import javax.swing.JPanel;

import query.controller.DataControl;
import query.model.PoExam.PoExam01;
import query.model.PoExam.PoExam01Query;
import query.model.PoExam.PoExam02;
import query.model.PoExam.PoExam03;
import query.model.PoExam.PoExam00;
import query.view.PoExam01JPanel;

public class PoExam01Controller extends DataControl {
	public String policy_no;
	private PoExam01JPanel poexam01Panel = new PoExam01JPanel();//add
	private String policy_info[];
	private String owner_id;
	private String owner_name;
	private String class_type;
	private String insured_id;
	private String insured_name;
	private String currency;
	
	@Override
	public void executeMission() {
		this.policy_no     = policy_info[0];//add
		this.owner_id      = policy_info[1];
		this.owner_name    = policy_info[2];
		this.class_type    = policy_info[3];
		this.insured_id    = policy_info[4];
		this.insured_name  = policy_info[5];
		this.currency      = policy_info[6];
		
		PoExam01Query rq = new PoExam01Query();
		// 塞入"體檢原因欄位資料"(popxam01)
		List<HashMap<String, String>> list = setErrResultInd(rq.getResultList(policy_no,PoExam01Query.Reason),"cc106i");//將執行結果存入list
		
		poexam01Panel.clearPoExam01s();
		for (HashMap<String, String> hsmap : list) 
		{
			PoExam01 popxam01 = new PoExam01(hsmap);
			poexam01Panel.addPoExam01(popxam01);//從list塞入addPoExam01自設定欄位
		}
		
		// 塞入"告知資料"(popxam02)
		list = rq.getResultList(policy_no, PoExam01Query.Told);
		poexam01Panel.clearPoExam02s();
		for (HashMap<String, String> hsmap2 : list) 
		{
			PoExam02 popxam02 = new PoExam02(hsmap2);
			poexam01Panel.addPoExam02(popxam02);//從list塞入addPoExam02自設定欄位
		}
		
		// 塞入"批註資料"(popxam03)
		list = rq.getResultList(policy_no, PoExam01Query.Comments);
		poexam01Panel.clearPoExam03s();
		for (HashMap<String, String> hsmap3 : list) 
		{
			PoExam03 popxam03 = new PoExam03(hsmap3);
			poexam01Panel.addPoExam03(popxam03);//從list塞入addPoExam03自設定欄位
		}
		this.showMessageDialog(poexam01Panel, "體檢批註告知", "");
		
		// 塞入"弱體：被保險人補告知"(popxam00)
		list = rq.getResultList(policy_no, PoExam01Query.Supplement);
		poexam01Panel.clearPoExam00s();
	
		for (HashMap<String, String> hsmap4 : list)
		{
				PoExam00 popxam00 = new PoExam00(hsmap4);
				poexam01Panel.addPoExam00(popxam00);//從list塞入addPoExam00自設定欄位 146800103616
		}
		this.showMessageDialog(poexam01Panel, "弱體", "");
	}
	@Override
	public void executeClearMission(){
		poexam01Panel.clearAll();
	}
	
	@Override
	public void executeNullMission(){
		poexam01Panel.nullAll();
	}
	
	@Override
	public String getOldPolicy_no() {
		// TODO Auto-generated method stub
		return this.policy_no;
	}

	@Override
	public JPanel getPanel() {
		// TODO Auto-generated method stub
		return poexam01Panel;//add
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
