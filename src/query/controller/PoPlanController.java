package query.controller;

import java.util.HashMap;
import java.util.List;

import javax.swing.JPanel;

import query.model.PoPlan.PoPlan;
import query.model.PoPlan.PoPlanPrem;
import query.model.PoPlan.PoPlanQuery;
import query.view.PoPlanJPanel;
/**
 * 
 * @author cychu
 *
 * @version 1.0<br/>
 * 			100/08/30<br/>
 * 			保障險種資料(Controller)
 * 
 * @since 1.0
 */
public class PoPlanController extends DataControl {
	private String policy_no;
	private String policy_info[];
	private PoPlanJPanel poPlanPanel = new PoPlanJPanel();
	
	@Override
	public void executeMission() {
		PoPlanPrem poPlanPrem = null;
		PoPlanQuery pq = new PoPlanQuery();
		String coverage_no, nc_str, init_mode_prem, co_mode_prem;
		
		this.policy_no = policy_info[0];
		poPlanPanel.clearAll();

		List<HashMap<String, String>> list = setErrResultInd(pq.getResultList(policy_no,
				PoPlanQuery.POPLAN),"cc112i");
		List<HashMap<String, String>> listPrem = setErrResultInd(pq.getResultList(policy_no,
				PoPlanQuery.POPLANPREM),"cc112i_ad");
		// 塞入保障險種欄位資料
		for (HashMap<String, String> hsmap : list) {
			PoPlan poPlan = new PoPlan(hsmap);
			coverage_no = poPlan.getCoverage_no();
			//塞入保障保費欄位資料
			if (policy_no.charAt(0)!= '9'&&policy_no.charAt(0)!='8'){ // 9與8開頭的不計算 直接用mode_prem
			for (HashMap<String, String> hsmap2 : listPrem) {
				poPlanPrem = new PoPlanPrem(hsmap2);
			}
			nc_str = poPlanPrem.getNc_str();
			init_mode_prem = poPlanPrem.getCoveragePrem(coverage_no, nc_str, "init_prem").trim();

			co_mode_prem = poPlanPrem.getCoveragePrem(coverage_no, nc_str, "mode_prem").trim();
			poPlan.setCo_mode_prem(co_mode_prem);
			poPlan.setInit_mode_prem(init_mode_prem);
			};
			poPlanPanel.addPoPlan(poPlan);
		}
		poPlanPanel.setDefaultRow();
		showMessageDialog(poPlanPanel, "保障內容查詢", "保單不符或無資料");
	}

	@Override
	public String getOldPolicy_no() {
		return policy_no;
	}

	@Override
	public JPanel getPanel() {
		return poPlanPanel;
	}

	@Override
	public boolean isControllable() {
		return false;
	}

	@Override
	public void setPolicyInfo(String[] policy_info) {
		this.policy_info = policy_info;
	}
	
	public void executeClearMission() {
		poPlanPanel.clearAll();
	}

	public void executeNullMission() {
		poPlanPanel.nullAll();
	}
}
