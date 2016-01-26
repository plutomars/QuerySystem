package query.controller;

import java.util.HashMap;
import java.util.List;

import javax.swing.JPanel;

import query.model.ClaimAssoDetail.ClaimAssoDetail;
import query.model.ClaimAssoDetail.ClaimAssoDetailQuery;
import query.model.NewDetail.NewDetailCommInsured;
import query.model.NewDetail.NewDetailCommInsuredQuery;
import query.model.NewDetail.NewDetailNewAssoIndex;
import query.model.NewDetail.NewDetailNewAssoIndexQuery;
import query.view.ClaimAssoJPanel;
/**
 * 
 * @author cychu
 *
 * @version 1.0<br/>
 * 			101/04/24<br/>
 * 			公會投保資料(Controller)
 * 
 * @since 1.0
 */
public class ClaimAssoController extends DataControl {
	private String policy_no;
	private String policy_info[];
	private ClaimAssoJPanel claimAssoPanel;
	
	public ClaimAssoController() {
		claimAssoPanel = new ClaimAssoJPanel();
		claimAssoPanel.setController(this);
	}
	
	@Override
	public void executeMission() {
		String authInd = "";
		String authErrDesc = "";
		
		NewDetailNewAssoIndexQuery naiq = new NewDetailNewAssoIndexQuery();
		NewDetailCommInsuredQuery ciq = new NewDetailCommInsuredQuery();
		ClaimAssoDetailQuery cadq = new ClaimAssoDetailQuery();
		
		this.policy_no = policy_info[0];

		claimAssoPanel.clearNewAssoIndex();
		claimAssoPanel.clearClaimAssoDetail();
		
		List<HashMap<String, String>> authList = setErrResultInd(
				cadq.getAuthResult(policy_info[4]), "chkClaim");
		authInd = authList.get(0).get("r_result_ind").trim();
		authErrDesc = authList.get(0).get("r_err_desc").trim();
		if (authInd.equals("1")) {
			this.showMessageDialog(claimAssoPanel, "公會投保資料查詢", authErrDesc);
		} else {
			List<HashMap<String, String>> list = setErrResultInd(
					ciq.getResultList(policy_no), "NewDetailCommInsured-cc111i");
			//塞入被保險人資料欄位
			for (HashMap<String, String> hsmap : list) {
				NewDetailCommInsured ndci = new NewDetailCommInsured(hsmap);
				claimAssoPanel.addCommInsured(ndci);
				claimAssoPanel.insertTopValue();
			}
		
			List<HashMap<String, String>> list2 = setErrResultInd(
					naiq.getResultList(policy_no), "cc225i");
			//塞入公會投保資料欄位
			for (HashMap<String, String> hsmap : list2) {
				NewDetailNewAssoIndex ndnai = new NewDetailNewAssoIndex(hsmap);
				if (ndnai.getR_insured_id().substring(0, 1).equals("-")) {
					break;
				} else {
					claimAssoPanel.addNewAssoIndex(ndnai);
				}
			}
		}
	}
	
	public void executeInnerMission(String client_id, String nbui_industry,
			String policy_type, String un_ins_type, String un_plan_type,
			String un_rpt_item, String nbui_company_code) {
		ClaimAssoDetailQuery cadq = new ClaimAssoDetailQuery();
		claimAssoPanel.clearClaimAssoDetail();
		
		List<HashMap<String, String>> list = setErrResultInd(
				cadq.getResultList(client_id, nbui_industry, 
				policy_type, un_ins_type, un_plan_type, un_rpt_item, 
				nbui_company_code), "cc226i");
		//塞入公會投保資料明細欄位
		for (HashMap<String, String> hsmap : list) {
			ClaimAssoDetail cad = new ClaimAssoDetail(hsmap);
			claimAssoPanel.addClaimAssoDetail(cad);
		}
	}
	
	@Override
	public void executeClearMission() {
		claimAssoPanel.clearAll();
	}

	@Override
	public void executeNullMission() {
		claimAssoPanel.nullAll();
	}

	@Override
	public String getOldPolicy_no() {
		return policy_no;
	}

	@Override
	public JPanel getPanel() {
		return claimAssoPanel;
	}

	@Override
	public boolean isControllable() {
		return false;
	}

	@Override
	public void setPolicyInfo(String[] policy_info) {
		this.policy_info = policy_info;
	}

}
