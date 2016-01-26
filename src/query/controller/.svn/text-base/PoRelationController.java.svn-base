package query.controller;

import java.util.HashMap;
import java.util.List;

import javax.swing.JPanel;

import query.model.PoRelation.PoRelation;
import query.model.PoRelation.PoRelationAG;
import query.model.PoRelation.PoRelationPA;
import query.model.PoRelation.PoRelationQuery;
import query.view.PoRelationJPanel;

public class PoRelationController extends DataControl {
	private String policy_no;
	private String policy_info[];
	private PoRelationJPanel relationPanel;

	public PoRelationController() {
		relationPanel = new PoRelationJPanel();
	}

	public void executeMission() {
		this.policy_no = policy_info[0];
		PoRelationQuery rq = new PoRelationQuery();
		relationPanel.clearAll();

		List<HashMap<String, String>> list = setErrResultInd(
				rq.getResultList(policy_no, PoRelationQuery.RELATION), "cc111i");

		// 塞入關係人欄位資料
		for (HashMap<String, String> hsmap : list) {
			PoRelation relation = new PoRelation(hsmap);
			relationPanel.addRelation(relation);
		}
		// 當class_type = P時才做執行
		if ("P".equals(policy_info[3])) {
			list = setErrResultInd(
					rq.getResultList(policy_no, PoRelationQuery.PARELATION),
					"papuData");

			// 塞入投保資料
			for (HashMap<String, String> hsmap : list) {
				PoRelationPA relation = new PoRelationPA(hsmap);
				relationPanel.addRelationPA(relation);
			}
		}

		List<HashMap<String, String>> agList = setErrResultInd(
				rq.getResultList(policy_no, PoRelationQuery.AGENT), "cc110i");
				
		for(HashMap<String,String> ag:agList){
			if(ag.get("r_relation_desc").trim().equals("collector")){
				String collector = "";
			if(ag.get("r_agent_code") != null){		
				String agName = ag.get("r_agent_name").trim();
				String agCode = ag.get("r_agent_code").trim();
				collector = agName;
				collector = collector.concat(" / "+agCode);
			}
				relationPanel.setCollector(collector);
			}	
			else{
				PoRelationAG relation = new PoRelationAG(ag);
				relationPanel.addRelationAG(relation);
			}
		}
		
		
//		list = setErrResultInd(
//				rq.getResultList(policy_no, PoRelationQuery.AGENT), "cc110i");
//
//		// 塞入業務員欄位資料
//		for (HashMap<String, String> hsmap : list) {
//			HashMap<String, String> ag;
//			PoRelationAG relation;
//
//			// 招攬業務員1
//			ag = new HashMap<String, String>();
//			ag.put("relation", "招攬業務員1");
//			ag.put("agent_code", hsmap.get("r_w_agent_code1"));
//			ag.put("dept_code", hsmap.get("r_w_dept_code1"));
//			ag.put("level", hsmap.get("r_w_level1"));
//			ag.put("mobile", hsmap.get("r_w_mobile1"));
//			ag.put("tel1", hsmap.get("r_w_tel11"));
//			ag.put("tel2", hsmap.get("r_w_tel12"));
//			ag.put("address", "");
//			ag.put("agent_name", hsmap.get("r_w_agent_name1"));
//			ag.put("comm_share", hsmap.get("r_w_comm_share1"));
//			relation = new PoRelationAG(ag);
//			relationPanel.addRelationAG(relation);
//
//			// 服務業務員1
//			ag = new HashMap<String, String>();
//			ag.put("relation", "服務業務員1");
//			ag.put("agent_code", hsmap.get("r_s_agent_code1"));
//			ag.put("dept_code", hsmap.get("r_s_dept_code1"));
//			ag.put("level", hsmap.get("r_s_level1"));
//			ag.put("mobile", hsmap.get("r_s_mobile1"));
//			ag.put("tel1", hsmap.get("r_s_tel11"));
//			ag.put("tel2", hsmap.get("r_s_tel12"));
//			ag.put("address", hsmap.get("r_s_address1"));
//			ag.put("agent_name", hsmap.get("r_s_agent_name1"));
//			ag.put("comm_share", hsmap.get("r_s_comm_share1"));
//			relation = new PoRelationAG(ag);
//			relationPanel.addRelationAG(relation);
//
//			// 主管1
//			ag = new HashMap<String, String>();
//			ag.put("relation", "主管1");
//			ag.put("agent_code", hsmap.get("r_v_agent_code1"));
//			ag.put("dept_code", hsmap.get("r_v_dept_code1"));
//			ag.put("level", hsmap.get("r_v_level1"));
//			ag.put("mobile", hsmap.get("r_v_mobile1"));
//			ag.put("tel1", hsmap.get("r_v_tel11"));
//			ag.put("tel2", hsmap.get("r_v_tel12"));
//			ag.put("address", "");
//			ag.put("agent_name", hsmap.get("r_v_agent_name1"));
//			ag.put("comm_share", hsmap.get(""));
//			relation = new PoRelationAG(ag);
//			relationPanel.addRelationAG(relation);
//
//			// 招攬業務員2
//			ag = new HashMap<String, String>();
//			ag.put("relation", "招攬業務員2");
//			ag.put("agent_code", hsmap.get("r_w_agent_code2"));
//			ag.put("dept_code", hsmap.get("r_w_dept_code2"));
//			ag.put("level", hsmap.get("r_w_level2"));
//			ag.put("mobile", hsmap.get("r_w_mobile2"));
//			ag.put("tel1", hsmap.get("r_w_tel21"));
//			ag.put("tel2", hsmap.get("r_w_tel22"));
//			ag.put("address", "");
//			ag.put("agent_name", hsmap.get("r_w_agent_name2"));
//			ag.put("comm_share", hsmap.get("r_w_comm_share2"));
//			relation = new PoRelationAG(ag);
//			relationPanel.addRelationAG(relation);
//
//			// 服務業務員2
//			ag = new HashMap<String, String>();
//			ag.put("relation", "服務業務員2");
//			ag.put("agent_code", hsmap.get("r_s_agent_code2"));
//			ag.put("dept_code", hsmap.get("r_s_dept_code2"));
//			ag.put("level", hsmap.get("r_s_level2"));
//			ag.put("mobile", hsmap.get("r_s_mobile2"));
//			ag.put("tel1", hsmap.get("r_s_tel21"));
//			ag.put("tel2", hsmap.get("r_s_tel22"));
//			ag.put("address", hsmap.get("r_s_address2"));
//			ag.put("agent_name", hsmap.get("r_s_agent_name2"));
//			ag.put("comm_share", hsmap.get("r_s_comm_share2"));
//			relation = new PoRelationAG(ag);
//			relationPanel.addRelationAG(relation);
//
//			// 主管2
//			ag = new HashMap<String, String>();
//			ag.put("relation", "主管2");
//			ag.put("agent_code", hsmap.get("r_v_agent_code2"));
//			ag.put("dept_code", hsmap.get("r_v_dept_code2"));
//			ag.put("level", hsmap.get("r_v_level2"));
//			ag.put("mobile", hsmap.get("r_v_mobile2"));
//			ag.put("tel1", hsmap.get("r_v_tel21"));
//			ag.put("tel2", hsmap.get("r_v_tel22"));
//			ag.put("address", "");
//			ag.put("agent_name", hsmap.get("r_v_agent_name2"));
//			ag.put("comm_share", hsmap.get(""));
//			relation = new PoRelationAG(ag);
//			relationPanel.addRelationAG(relation);
//
//			String collector = (hsmap.get("r_collector_no") == null) ? ""
//					: hsmap.get("r_collector_no").trim() + "/";
//			String collector2 = (hsmap.get("r_collector_name") == null) ? ""
//					: hsmap.get("r_collector_name").trim();
//			relationPanel.setCollector(collector + collector2);
//
//		}
		showMessageDialog(relationPanel, "關係人資料查詢", "保單不符或無資料");
	}

	@Override
	public void executeClearMission() {
		relationPanel.clearAll();
	}

	@Override
	public void executeNullMission() {
		relationPanel.nullAll();
	}

	@Override
	public String getOldPolicy_no() {
		// TODO Auto-generated method stub
		return policy_no;
	}

	@Override
	public JPanel getPanel() {
		// TODO Auto-generated method stub
		return relationPanel;
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
