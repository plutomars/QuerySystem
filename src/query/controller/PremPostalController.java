package query.controller;
/**
 * @author cora
 *
 * @version 1.0<br/>
 * 			101/11/07<br/>
 * 			劃撥/ATM/便利商店繳費查詢(Query)
 * 
 * @since 1.0
 */
import java.util.HashMap;
import java.util.List;
import javax.swing.JPanel;
import query.model.PremPostal.PremPostal02;
import query.model.PremPostal.PremPostal03;
import query.model.PremPostal.PremPostalQuery;
import query.view.PremPostalJPanel;

public class PremPostalController extends DataControl {
	private String policy_no;
	private String currency;
	private String policy_info[];
	private PremPostalJPanel premPostalPanel;
	PremPostalQuery rq;
	List<HashMap<String, String>> list;
//	private PremPostal01 premPostal01;
	
	public PremPostalController() {
		rq = new PremPostalQuery();
		premPostalPanel = new PremPostalJPanel();
		premPostalPanel.setController(this);
		premPostalPanel.clearAll();		
	}
	
	@Override
	public void executeMission() {
		// TODO Auto-generated method stub
//		System.out.println("null");
		this.policy_no = policy_info[0];
		this.currency = policy_info[6];
		premPostalPanel.clearAll();
	    list = setErrResultInd(rq.getResultList(policy_no,1),"PremPostal-Jpolf");// 將執行結果存入list

		for (HashMap<String, String> hsmap : list) {
			premPostalPanel.setValues(hsmap);
		}
	}

	public void executeInnerMission(String type) {
//		System.out.println("beg"+policy_no+" *"+currency+" **"+premPostalPanel.pcrc_kind);
		if (type.equals("0")){
		   premPostalPanel.clearPagesSub();
		  list = setErrResultInd(rq.getResultList(policy_no,currency,premPostalPanel.pcrc_kind),"cc245i");// 將執行結果存入list
		   for (HashMap<String, String> hsmap : list) {
			   PremPostal02 postal02 = new PremPostal02(hsmap); 
			   premPostalPanel.addPremPostal02(postal02);
		}}else{
			premPostalPanel.clearPostal03Group();
			list = setErrResultInd(rq.getResultList(policy_no,type),"cc245i02");// 將執行結果存入list
			for (HashMap<String, String> hsmap : list) {
				PremPostal03 postal03 = new PremPostal03(hsmap); 
				premPostalPanel.addPremPostal03(postal03);
			}
		}
		
		
	}
	
	@Override
	public void executeClearMission() {
		// TODO Auto-generated method stub
		premPostalPanel.clearAll();

	}
	
	@Override
	public void executeNullMission() {
		// TODO Auto-generated method stub
		premPostalPanel.nullAll();
	}

	@Override
	public String getOldPolicy_no() {
		// TODO Auto-generated method stub
		return policy_no;
	}

	@Override
	public JPanel getPanel() {
		// TODO Auto-generated method stub
		return premPostalPanel;
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
