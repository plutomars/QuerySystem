package query.controller;

import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import query.controller.DataControl;
import query.model.NewPhysicalExam.NewPhysicalExam;
import query.model.NewPhysicalExam.NewPhysicalExamQuery;
import query.view.NewPhysicalExamJPanel;


public class NewPhysicalExamController extends DataControl {
	private String agent_code;
	private String policy_info[];
	private NewPhysicalExamJPanel PhysicalExamJPanel = new NewPhysicalExamJPanel();
	private NewPhysicalExam physicalExam;

	public NewPhysicalExamController()
	{
		PhysicalExamJPanel.setController(this);


	}
	public void executeMission()
	{
//		System.out.println("control miss = "+policy_info[4]);

//		executeMission(this.agent_code,"100/05");
	}
	public void executeMission(String agent_code,String date_yymm) {
		// TODO Auto-generated method stub
		this.agent_code = agent_code;
		PhysicalExamJPanel.clearAll();
		if(agent_code.isEmpty() == true ){
			JOptionPane.showMessageDialog(null, "請輸入查詢條件！");
		}
		else{
			NewPhysicalExamQuery pq = new NewPhysicalExamQuery();
	        List<HashMap<String, String>> list = setErrResultInd(pq.getResultList(this.agent_code,date_yymm),"cc221i");
	        if(list.size() == 0){
	        
	        	JOptionPane.showMessageDialog(null, "無符合您查詢的有關資料！");
				return;
				
			}else{

				PhysicalExamJPanel.setValues(pq.getAGname(this.agent_code));
				for (HashMap<String, String> hsmap : list) {
//					System.out.println("get data");
					physicalExam= new NewPhysicalExam(hsmap);	
					PhysicalExamJPanel.addNewPhysicalExampanel(physicalExam);

//					SamplingRecordList samplingrecordlist = new SamplingRecordList(hsmap);
//					samplingrecordpanel.addsamplingRecordpanel(samplingrecordlist);
//				
//					count++;
//	        		if (count > 200);
//	          			break;
	          	}
			}
		}
		showMessageDialog(PhysicalExamJPanel, "體檢費扣佣查詢", "無資料");
		
	}

	@Override
	public String getOldPolicy_no() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JPanel getPanel() {
		// TODO Auto-generated method stub
		return PhysicalExamJPanel;
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
		this.agent_code = "";//policy_info[4];
		PhysicalExamJPanel.setAG(this.agent_code);
	}
	
	@Override
	public void executeClearMission(){
		PhysicalExamJPanel.clearAll();
	}
	@Override
	public void executeNullMission(){
		PhysicalExamJPanel.nullAll();
	}

}
