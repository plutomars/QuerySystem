package query.controller;

import java.util.HashMap;
import java.util.List;

import javax.swing.JPanel;

import query.model.PoDetail.PoDetailQuery;
import query.model.PosEC.PosECQuery;
import query.view.PosECJPanel;

public class PosECController extends DataControl {
    private PosECJPanel posECJPanel = new PosECJPanel();
    private String policy_info[];
	private String policy_no;
	private String client_id;
	
//	private String mission0; // 0號頁籤 建檔明細 當畫面停留在1號頁籤 換查詢保單使用  因為1號上半部與0號下半部資料共用
	private String mission1; // 1號頁籤控制 列印紀錄
	
	private PoDetailQuery rq;  //帳號明細頁籤由保單明細移過來PoDetail
	private PosECQuery rqEC;
	private List<HashMap<String, String>> list ;
	
	public PosECController() {
		posECJPanel.setController(this);
//		PoDetailPanel.clearAll();
		rq = new PoDetailQuery();
		rqEC = new PosECQuery();
    	posECJPanel.chkAuthority();
	}
	
	@Override
	public void executeMission() {
		// TODO Auto-generated method stub
//		posECJPanel = new PosECJPanel();
		this.policy_no = policy_info[0];
		this.client_id = policy_info[1];
//		this.mission0 = "0";
		this.mission1 = "0";
		posECJPanel.clearAll();
    	list = setErrResultInd(rq.getResultList(client_id,PoDetailQuery.PODETAIL_ECO),"cc192i");
    	for (HashMap<String, String> hsmap : list) {
    		posECJPanel.addECacctGroup(hsmap);
    	}
    	posECJPanel.setDefaultRow();
    	posECJPanel.setDefaultID(client_id);
	}
	
	// 抓密碼等級與登記的保單or被保險人
	public void executeMission(String acct_source,
								   String bank_id,
								   String account_no,String lcnt) {
			list = setErrResultInd(rq.getResultList(client_id,acct_source,bank_id,account_no,lcnt),"cc193i");		
		       for (HashMap<String, String> hsmap : list) {
			   posECJPanel.setValues(hsmap,1);
			   }   
		       
			list = setErrResultInd(rq.getResultList(client_id,acct_source,bank_id,account_no),"cc194i");		
			   for (HashMap<String, String> hsmap : list) {
			   posECJPanel.setValues(hsmap,2);
			   }    
	}  

	//交易歷史
	public void executeMission(String client_id,String date_beg,String date_end,String txn_code,String policy_no){
    	list = setErrResultInd(rqEC.getResultList(client_id,date_beg,date_end,txn_code,policy_no),"cc196i");
    	for (HashMap<String, String> hsmap : list) {
    		posECJPanel.addECectrGroup(hsmap);
    	}
	}

	//交易歷史明細
	public void executeMission(String txn_seq,String txn_code){
    	list = setErrResultInd(rqEC.getResultList(txn_seq,txn_code),"cc197i");
    	for (HashMap<String, String> hsmap : list) {
    		posECJPanel.addECeclpGroup(hsmap);
    	}
	}
	
	public void executeMissionTabValues() {
	if (this.mission1=="0"){
	    this.mission1 = "1";	
	    list = setErrResultInd(rq.getResultList(client_id,PoDetailQuery.PODETAIL_PWD),"cc195i");
	    for (HashMap<String, String> hsmap : list) {
		posECJPanel.setValues(hsmap,3);
	    }
	}    
}
	
	@Override
	public void executeNullMission() {
		// TODO Auto-generated method stub
		posECJPanel.nullAll();
	}

	@Override
	public void executeClearMission() {
		posECJPanel.clearAll();
		// TODO Auto-generated method stub

	}
	@Override
	public String getOldPolicy_no() {
		// TODO Auto-generated method stub
		return policy_no;
	}

	@Override
	public JPanel getPanel() {
		// TODO Auto-generated method stub
		return posECJPanel;
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
