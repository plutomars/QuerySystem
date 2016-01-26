package query.controller;

import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import query.model.NewSamplingRecord.SamplingRecord;
import query.model.NewSamplingRecord.SamplingRecordList;
import query.model.NewSamplingRecord.SamplingRecordListGroup;
import query.model.NewSamplingRecord.SamplingRecordQuery;
import query.view.NewSamplingRecordJPanel;

public class NewSamplingRecordController extends DataControl {

	private String agent_code;
	private String policy_info[];
	private NewSamplingRecordJPanel samplingRecordpanel; // = new SamplingRecordJPanel();
	private SamplingRecordList samplingRecordList;
//	private SamplingRecordListGroup samplingRecordListGroup;
//	private NewSamplingRecordJPanel samplingrecordpanel ;
	
	
	int count = 0;
	
	public NewSamplingRecordController() {
		samplingRecordpanel = new NewSamplingRecordJPanel();
		samplingRecordpanel.setController(this);
	}
	
	
	@Override
	public void executeMission() {
 	
	}
	
	public void executeMission(String agent_code){
		this.agent_code = agent_code;
		samplingRecordpanel.clearAll();
//		System.out.println("bf mission "+agent_code);
		if(agent_code.isEmpty() == true ){
			JOptionPane.showMessageDialog(null, "請輸入查詢條件！");
		}
		else{
			SamplingRecordQuery pq = new SamplingRecordQuery();

	        List<HashMap<String, String>> list = setErrResultInd(pq.getResultList(this.agent_code),"cc220i");
	        if(list.size() == 0){
	        
	        	JOptionPane.showMessageDialog(null, "無符合您查詢的有關資料！");
				return;
				
			}else{
				
				samplingRecordpanel.setValues(list.get(0).get("r_immune"),pq.getAGname(this.agent_code));
				for (HashMap<String, String> hsmap : list) {
					samplingRecordList = new SamplingRecordList(hsmap);	
					samplingRecordpanel.addsamplingRecordpanel(samplingRecordList);

//					SamplingRecordList samplingrecordlist = new SamplingRecordList(hsmap);
//					samplingrecordpanel.addsamplingRecordpanel(samplingrecordlist);
//				
//					count++;
//	        		if (count > 200);
//	          			break;
	          	}
			}
		}
		showMessageDialog(samplingRecordpanel, "抽樣資料查詢", "業務員ID錯誤或無資料");
	}

	
//	public String getOldAgent_no() {
//		// TODO Auto-generated method stub
//		return agent_code;
//	}

	@Override
	public JPanel getPanel() {
		// TODO Auto-generated method stub
		return samplingRecordpanel;
	}

	@Override
	public boolean isControllable() {
		// TODO Auto-generated method stub
		return false;
	}
	
//	public void setAgentInfo(String[] arg0) {
//		// TODO Auto-generated method stub
//		agent_info = arg0;
//	}


	@Override
	public String getOldPolicy_no() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void setPolicyInfo(String[] policy_info) {
		// TODO Auto-generated method stub
		this.policy_info = policy_info;
		this.agent_code = "";//policy_info[4]; 
		samplingRecordpanel.setAG(this.agent_code);    
	}
	
	@Override
	public void executeClearMission(){
		samplingRecordpanel.clearAll();
	}
	@Override
	public void executeNullMission(){
		samplingRecordpanel.nullAll();
	}
	
	
}
