package query.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JPanel;

import query.model.Query;
import query.model.NewDetail.NewDetailClaimHistory;
import query.model.NewDetail.NewDetailClaimHistoryQuery;
import query.model.NewDetail.NewDetailComm;
import query.model.NewDetail.NewDetailCommCmnt;
import query.model.NewDetail.NewDetailCommCmntQuery;
import query.model.NewDetail.NewDetailCommInsured;
import query.model.NewDetail.NewDetailCommInsuredQuery;
import query.model.NewDetail.NewDetailCommQuery;
import query.model.NewDetail.NewDetailDeny;
import query.model.NewDetail.NewDetailDenyQuery;
import query.model.NewDetail.NewDetailExamInfo;
import query.model.NewDetail.NewDetailExamInfoQuery;
import query.model.NewDetail.NewDetailExamNotice;
import query.model.NewDetail.NewDetailExamNoticeQuery;
import query.model.NewDetail.NewDetailIllegalAddr;
import query.model.NewDetail.NewDetailIllegalAddrAg;
import query.model.NewDetail.NewDetailIllegalAddrPo;
import query.model.NewDetail.NewDetailIllegalAddrQuery;
import query.model.NewDetail.NewDetailNewAssoIndex;
import query.model.NewDetail.NewDetailNewAssoIndexQuery;
import query.model.NewDetail.NewDetailNotice;
import query.model.NewDetail.NewDetailNoticeQuery;
import query.model.NewDetail.NewDetailOldAssoIndex;
import query.model.NewDetail.NewDetailOldAssoIndexQuery;
import query.model.NewDetail.NewDetailPoStatement;
import query.model.NewDetail.NewDetailPoStatementQuery;
import query.model.NewDetail.NewDetailPosChange;
import query.model.NewDetail.NewDetailPosChangeQuery;
import query.model.NewDetail.NewDetailPreferredExam;
import query.model.NewDetail.NewDetailPreferredExamQuery;
import query.model.NewDetail.NewDetailSignPaper;
import query.model.NewDetail.NewDetailSignPaperQuery;
import query.model.NewDetail.NewDetailUwErrCode;
import query.model.NewDetail.NewDetailUwErrCodeQuery;
import query.model.NewRescind.NewRescind01;
import query.model.NewRescind.NewRescindQuery;
import query.model.PoDetail.PoDetailPrem;
import query.model.PoDetail.PoDetailQuery;
import query.model.PoExam.PoExam00;
import query.model.PoExam.PoExam01Query;
import query.model.PoPlan.PoPlan;
import query.model.PoPlan.PoPlanPrem;
import query.model.PoPlan.PoPlanQuery;
import query.view.NewDetailJPanel;
import query.view.PanelTipFrame;
import query.view.ToolTipFrame;

/**
 * 新契約明細查詢controller
 * 
 * @author epf
 */
public class NewDetailController extends DataControl {
	private String[] policy_info;
	private String policy_no;
	private NewDetailJPanel newDetailJPanel;

	public NewDetailController() {
		newDetailJPanel = new NewDetailJPanel();
		newDetailJPanel.setController(this);
	}

	@Override
	public void executeClearMission() {
		newDetailJPanel.clearAll();
	}

	@Override
	public void executeNullMission() {
		newDetailJPanel.nullAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see query.controller.DataControl#executeMission() 呼叫各查詢撈取資料
	 * 單純使用dataQuery參考故各查詢必須實作Query介面
	 */
	@Override
	public void executeMission() {
		this.policy_no = policy_info[0];
		Query dataQuery = null;
		Query poPremQuery = null;
		NewDetailComm newDetailComm = null;
		List<HashMap<String, String>> dataList = new ArrayList<HashMap<String, String>>();

		// 先清空資料
		newDetailJPanel.clearAll();
		if (policy_info[3].isEmpty()) //不存在保單,不做交易
			return;
			
		// 要保人資料
		dataQuery = new NewDetailCommQuery();
		poPremQuery = new PoDetailQuery();
		dataList = this.setErrResultInd(
				dataQuery.getResultList(policy_no, Query.NOTYPE),
				"NewDetailComm");
		for (HashMap<String, String> hsmap : dataList) {
			newDetailComm = new NewDetailComm(hsmap);
			if (newDetailComm.getClass_type().toString().equals("L")||newDetailComm.getClass_type().toString().equals("A")
				||newDetailComm.getClass_type().toString().startsWith("I")	) { // 保費計算
																		// hsmap多插入6個欄位以便model裡保費計算用
				List<HashMap<String, String>> list2 = poPremQuery
						.getResultList(policy_no, PoDetailQuery.PODETAIL_PREM);
				for (HashMap<String, String> hsmap2 : list2) {
					PoDetailPrem poDetailPrem = new PoDetailPrem(hsmap2);
					if (hsmap2.get("r_result_ind").trim().equals("0")) {
						newDetailComm.setMode_prem(poDetailPrem.getmode_prem_h());
					} else {
						hsmap.put("mode_prem", "無法計算");
					}
				}
			}
			newDetailJPanel.addNewDetailComm(newDetailComm);
		}
		dataList.clear();
		poPremQuery = null;

		// 被保人資料
		dataQuery = new NewDetailCommInsuredQuery();
		dataList = this.setErrResultInd(
				dataQuery.getResultList(policy_no, Query.NOTYPE),
				"NewDetailCommInsured-cc111i");
		for (HashMap<String, String> hsmap : dataList) {
			NewDetailCommInsured newDetailCommInsured = new NewDetailCommInsured(
					hsmap);
			newDetailJPanel.addNewDetailCommInsured(newDetailCommInsured);
		}
//		dataQuery = null;
		dataList.clear();

		// 保障內容
		dataQuery = new PoPlanQuery();
		String coverage_no, nc_str, init_mode_prem, co_mode_prem;
		Integer po_mode_prem = 0;
		PoPlanPrem poPlanPrem = null;
		
		if (policy_no.charAt(0)!= '9'&&policy_no.charAt(0)!='8'){ // 9與8開頭的不計算 直接用mode_prem
		List<HashMap<String, String>> listPrem = setErrResultInd(
				dataQuery.getResultList(policy_no, PoPlanQuery.POPLANPREM),
				"cc112i_ad");
		for (HashMap<String, String> hsmap2 : listPrem) {
			poPlanPrem = new PoPlanPrem(hsmap2);
		}
		}
		
		dataList = this.setErrResultInd(
				dataQuery.getResultList(policy_no, PoPlanQuery.POPLAN),
				"PoPlans");
	
		for (HashMap<String, String> hsmap : dataList) {
			PoPlan poPlan = new PoPlan(hsmap);
			coverage_no = poPlan.getCoverage_no();
			if (policy_no.charAt(0)!= '9'&&policy_no.charAt(0)!='8'){ // 9與8開頭的不計算 直接用mode_prem
				nc_str = poPlanPrem.getNc_str();
				init_mode_prem = poPlanPrem.getCoveragePrem(coverage_no, nc_str,
					"init_prem").trim();

				co_mode_prem = poPlanPrem.getCoveragePrem(coverage_no, nc_str,
					"mode_prem").trim();
				poPlan.setCo_mode_prem(co_mode_prem);
				poPlan.setInit_mode_prem(init_mode_prem);
			}
			
			if (policy_no.charAt(0)== '9'){
				po_mode_prem = po_mode_prem + Integer.parseInt(poPlan.getCo_mode_prem());
				newDetailComm.setMode_prem(po_mode_prem.toString());
				newDetailJPanel.addNewDetailComm(newDetailComm);
			}
				
			poPlan.setCo_sts_desc(poPlan.getCo_sts_desc().substring(0, 2));
			newDetailJPanel.addPoPlan(poPlan);
		}
		dataList.clear();

		// 批註
		dataQuery = new NewDetailCommCmntQuery();
		dataList = this.setErrResultInd(
				dataQuery.getResultList(policy_no, Query.NOTYPE),
				"NewDetailCommCmnt");
		for (HashMap<String, String> hsmap : dataList) {
			NewDetailCommCmnt newDetailCommCmnt = new NewDetailCommCmnt(hsmap);
			newDetailJPanel.addNewDetailCommCmnt(newDetailCommCmnt);
		}
		dataList.clear();

		// 弱體代碼
		dataQuery = new PoExam01Query();
		dataList = this.setErrResultInd(
				dataQuery.getResultList(policy_no, PoExam01Query.Supplement),
				"PoExam01QuerySupplement");
		for (HashMap<String, String> hsmap : dataList) {
			PoExam00 poExam00 = new PoExam00(hsmap);
			newDetailJPanel.addPoExam00(poExam00);
		}
		dataList.clear();

		// 體檢資料
		dataQuery = new NewDetailExamInfoQuery();
		dataList = this.setErrResultInd(
				dataQuery.getResultList(policy_no, Query.NOTYPE),
				"NewDetailExamInfoQuery");
		for (HashMap<String, String> hsmap : dataList) {
			NewDetailExamInfo newDetailExamInfo = new NewDetailExamInfo(hsmap);
			newDetailJPanel.addNewDetailExamInfo(newDetailExamInfo);
		}
		dataList.clear();

		// 優體保單
		dataQuery = new NewDetailPreferredExamQuery();
		dataList = this.setErrResultInd(
				dataQuery.getResultList(policy_no, Query.NOTYPE),
				"NewDetailPreferredExamQuery");
		for (HashMap<String, String> hsmap : dataList) {
			NewDetailPreferredExam newDetailPreferredExam = new NewDetailPreferredExam(
					hsmap);
			newDetailJPanel.addNewDetailPreferredExam(newDetailPreferredExam);
		}
		dataList.clear();

		
//		if (DBConnection.user_dept.matches("9[A-Z0-9]4[123][0-9]*")||DBConnection.user_dept.equals("90200")) //契約及POS可看
//		{	
		// 公會索引
		dataQuery = new NewDetailOldAssoIndexQuery();
		dataList = this.setErrResultInd(
				dataQuery.getResultList(policy_no, Query.NOTYPE),
				"NewDetailOldAssoIndex");
		for (HashMap<String, String> hsmap : dataList) {
			NewDetailOldAssoIndex newDetailOldAssoIndex = new NewDetailOldAssoIndex(
					hsmap);
			newDetailJPanel.addNewDetailOldAssoIndex(newDetailOldAssoIndex);
		}
		dataList.clear();

		// 新公會索引
		dataQuery = new NewDetailNewAssoIndexQuery();
		dataList = this.setErrResultInd(
				dataQuery.getResultList(policy_no, Query.NOTYPE),
				"NewDetailNewAssoIndex-cc225i");
		for (HashMap<String, String> hsmap : dataList) {
			NewDetailNewAssoIndex newDetailNewAssoIndex = new NewDetailNewAssoIndex(
					hsmap);
			newDetailJPanel.addNewDetailNewAssoIndex(newDetailNewAssoIndex);
		}
		dataList.clear();
//		} else
//		{
//			newDetailJPanel.tab1_btm_pane.setEnabledAt(3,false);
//		}	
		
		// 理賠記錄
		// 顯示panel部份
		ClaimHistoryController chController = new ClaimHistoryController();
		chController.setPolicyInfo(policy_info);
		chController.executeNewDetailMission();
		newDetailJPanel.setClaimHistoryJPanel(chController.getPanel());
		chController = null;

		// 作出理賠記錄查詢用來判斷有無資料只需要作一筆來判斷
		dataQuery = new NewDetailClaimHistoryQuery();
		dataList = this.setErrResultInd(dataQuery.getResultList(policy_no,
				NewDetailClaimHistoryQuery.NEWHISTORY),
				"NewDetailClaimHistory-cc170i");
		for (HashMap<String, String> hsmap : dataList) {
			NewDetailClaimHistory newDetailClaimHistory = new NewDetailClaimHistory(
					hsmap);
			newDetailJPanel.addNewDetailClaimHistory(newDetailClaimHistory);
			break;
		}
		dataList.clear();

		// 契變記錄
		dataQuery = new NewDetailPosChangeQuery();
		dataList = this.setErrResultInd(
				dataQuery.getResultList(policy_no, Query.NOTYPE),
				"NewDetailPosChagne");
		for (HashMap<String, String> hsmap : dataList) {
			NewDetailPosChange newDetailPosChange = new NewDetailPosChange(
					hsmap);
			newDetailJPanel.addNewDetailPosChange(newDetailPosChange);
		}
		dataList.clear();

		// 告知事項
		dataQuery = new NewDetailPoStatementQuery();
		dataList = this.setErrResultInd(
				dataQuery.getResultList(policy_no, Query.NOTYPE),
				"NewDetailPoStatement-cc107i-I");
		for (HashMap<String, String> hsmap : dataList) {
			NewDetailPoStatement newDetailPoStatement = new NewDetailPoStatement(
					hsmap);
			newDetailJPanel.addNewDetailPoStatement(newDetailPoStatement);
		}
		dataList.clear();

		// 核保訊息
		dataQuery = new NewDetailUwErrCodeQuery();
		newDetailJPanel.setUA21tooltip("0");
		dataList = this.setErrResultInd(
				dataQuery.getResultList(policy_no, Query.NOTYPE),
				"NewDetailUwErrCode");
		for (HashMap<String, String> hsmap : dataList) {
			NewDetailUwErrCode newDetailUwErrCode = new NewDetailUwErrCode(
					hsmap);
			newDetailJPanel.addNewDetailUwErrCode(newDetailUwErrCode);
			if (hsmap.get("nb_err_code").trim().compareTo("UA21") == 0) { //有UA21才顯示tooltip
				newDetailJPanel.setUA21tooltip("1");
			}
		}
		dataList.clear();

		// 列管地址
		dataQuery = new NewDetailIllegalAddrQuery();
		dataList = this.setErrResultInd(
				dataQuery.getResultList(policy_no, Query.NOTYPE),
				"NewDetailIllegalAddr");
		for (HashMap<String, String> hsmap : dataList) {
			NewDetailIllegalAddr newDetailIllegalAddr = new NewDetailIllegalAddr(
					hsmap);
			newDetailJPanel.addNewDetailIllegalAddr(newDetailIllegalAddr);
		}
		newDetailJPanel.setDefaultRow();
		dataList.clear();

		// 體檢照會
		dataQuery = new NewDetailExamNoticeQuery();
		dataList = this.setErrResultInd(
				dataQuery.getResultList(policy_no, Query.NOTYPE),
				"NewDetailExamNotice");
		for (HashMap<String, String> hsmap : dataList) {
			NewDetailExamNotice newDetailExamNotice = new NewDetailExamNotice(
					hsmap);
			newDetailJPanel.addNewDetailExamNotice(newDetailExamNotice);
		}
		dataList.clear();

		// 簽收單查詢
		dataQuery = new NewDetailSignPaperQuery();
		dataList = this.setErrResultInd(
				dataQuery.getResultList(policy_no, Query.NOTYPE),
				"NewDetailExamNotice");
		for (HashMap<String, String> hsmap : dataList) {
			NewDetailSignPaper newDetailSignPaper = new NewDetailSignPaper(
					hsmap);
			newDetailJPanel.addNewDetailSignPaper(newDetailSignPaper);
		}
		dataList.clear();

		// 照會項目
		dataQuery = new NewDetailNoticeQuery();
		dataList = this.setErrResultInd(
				dataQuery.getResultList(policy_no, Query.NOTYPE),
				"NewDetailNotice-cc215i");
		for (HashMap<String, String> hsmap : dataList) {
			NewDetailNotice newDetailNotice = new NewDetailNotice(hsmap);
			newDetailJPanel.addNewDetailNotice(newDetailNotice);
		}
		dataList.clear();
		
		//未承保原因
		if (Integer.parseInt(newDetailComm.getPo_sts_code().substring(0, 2))>= 31 &&
			Integer.parseInt(newDetailComm.getPo_sts_code().substring(0, 2))<= 33){
			dataQuery = new NewDetailDenyQuery();
			dataList = this.setErrResultInd(
			dataQuery.getResultList(policy_no, Query.NOTYPE),"NewDetailNotice-cc212i");
			for (HashMap<String, String> hsmap : dataList) {
				NewDetailDeny newDetailDeny = new NewDetailDeny(hsmap);
				newDetailJPanel.addNewDetailDeny(newDetailDeny);
			}
		}
		
		// 契約撤銷
		NewRescindController newRescindController = new NewRescindController();
		newRescindController.setPolicyInfo(policy_info);
		newRescindController.executeMission();
		newDetailJPanel.setNewRescindJPanel(newRescindController.getPanel());
		// 作出契約撤銷查詢用來判斷有無資料只需要作一筆來判斷
		dataQuery = new NewRescindQuery();
		dataList = this.setErrResultInd(dataQuery.getResultList(policy_info[0],
				NewRescindQuery.NewRescind01), "NewRescind-cc118i");
		for (HashMap<String, String> hsmp : dataList) {
			NewRescind01 data01 = new NewRescind01();
			data01.setValues(hsmp);
			newDetailJPanel.addNewRescind01(data01);
			break;
		}

		// 設定無資料的tab disable
		newDetailJPanel.setTabPaneEnable();
		newDetailJPanel.setTabPaneDisable();
		dataQuery = null;
		dataList = null;
	}

	/**
	 * 顯示新公會索引的明細
	 * 
	 * @param newAssoIndex
	 *            新公會索引bean
	 */
	public void showNewAssoIndexDetail(NewDetailNewAssoIndex newAssoIndex) {
		NewDetailNewAssoIndexQuery q = new NewDetailNewAssoIndexQuery();
		String title[] = new String[] { "保單號碼", "保額", "保費", "繳別", "狀況日期",
				"生效日期", "要保人ID", "要保人姓名", "與被保險人關係", "狀況", "滿期日期" };
		List<HashMap<String, String>> list = q.getResultList(
				newAssoIndex.getR_insured_id(),
				newAssoIndex.getR_nbui_industry(),
				newAssoIndex.getR_policy_type(),
				newAssoIndex.getR_un_ins_type(),
				newAssoIndex.getR_un_plan_type(),
				newAssoIndex.getR_un_rpt_item(),
				newAssoIndex.getR_nbui_company_code());

		String[][] context = new String[list.size()][];
		int i = 0;
		for (HashMap<String, String> hsmp : list) {
			String detail[] = new String[] { hsmp.get("r_nbui_pno"),
					hsmp.get("r_nbni_amt"), hsmp.get("r_mode_prem"),
					hsmp.get("r_un_modx_desc"), hsmp.get("r_po_sts_date"),
					hsmp.get("r_po_issue_date"), hsmp.get("r_o1_id"),
					hsmp.get("r_o1_un_name"), hsmp.get("r_o1_rela"),
					hsmp.get("r_un_po_sts"), hsmp.get("r_expired_date") };
			context[i++] = detail;
		}

		ToolTipFrame.setTable(title, context, true,new int[]{1});
		ToolTipFrame.setSizeAndLocation(700, newDetailJPanel);

	}

	/**
	 * 顯示契變受理明細Panel 使用PanelTipFrame
	 */
	public void showPosChangeJPanel(String policy_no) {
		PosChangeController psController = new PosChangeController();
		String[] policy_info = this.policy_info;
		policy_info[0]= policy_no;
		psController.setPolicyInfo(policy_info);
		psController.executeMission("I");
		PanelTipFrame.setPanel(psController);
		PanelTipFrame.setSizeAndLocation(700, newDetailJPanel);
	}

	/**
	 * 核保訊息UA21點兩下顯示舊保單職級
	 * 
	 * @param newDetailUwErrCode
	 *            核保訊息bean
	 */
	public void showOldOccu(NewDetailUwErrCode newDetailUwErrCode) {
		NewDetailUwErrCodeQuery q = new NewDetailUwErrCodeQuery();
		List<HashMap<String, String>> list = q.getToolTipResultList(
				newDetailUwErrCode.getClient_id(),
				newDetailUwErrCode.getOccupation_level(),
				newDetailUwErrCode.getPolicy_no());
		String title[] = new String[] { "舊保單號碼", "職級" };
		String[][] context = new String[list.size()][];
		int i = 0;

		for (HashMap<String, String> hsmap : list) {
			String detail[] = new String[] { hsmap.get("policy_no"),
					hsmap.get("rate_occu") };
			context[i++] = detail;
		}
		ToolTipFrame.setTable(title, context, true);
		ToolTipFrame.setSizeAndLocation(700, newDetailJPanel);
	}

	/**
	 * 點兩下顯示理賠記錄事故原因
	 * 
	 * @param newDetailClaimHistory
	 *            理賠記錄bean
	 */
	public void showEventCode(NewDetailClaimHistory newDetailClaimHistory) {
		String title[] = new String[] { "事故原因" };
		String[][] context = new String[4][];
		int i = 0;
		for (i = 0; i < 4; i++) {
			String detail[] = new String[1];
			switch (i) {
			case 0:
				detail = new String[] { newDetailClaimHistory
						.getR_cl_event_desc_1() };
				break;
			case 1:
				detail = new String[] { newDetailClaimHistory
						.getR_cl_event_desc_2() };
				break;
			case 2:
				detail = new String[] { newDetailClaimHistory
						.getR_cl_event_desc_3() };
				break;
			case 3:
				detail = new String[] { newDetailClaimHistory
						.getR_cl_event_desc_4() };
				break;
			}
			context[i] = detail;
		}

		ToolTipFrame.setTable(title, context, true);
		ToolTipFrame.setSizeAndLocation(700, newDetailJPanel);

	}

	/**
	 * 點一下顯示相同地址的所有保單
	 * 
	 * @param 列管地址bean
	 */
	public void showAddrPo(String address) {
		Query pq = new NewDetailIllegalAddrQuery();
		List<HashMap<String, String>> list = setErrResultInd(pq.getResultList(
				address, NewDetailIllegalAddrQuery.IllegalAddrPo), "cc235i");
		for (HashMap<String, String> hsmap : list) {
			NewDetailIllegalAddrPo newDetailIllegalAddrPo = new NewDetailIllegalAddrPo(
					hsmap);
			newDetailJPanel.addNewDetailIllegalAddrPo(newDetailIllegalAddrPo);
		}
	}

	/**
	 * 點一下顯示該保單要被保人為ag的資料
	 * 
	 * @param 列管地址bean
	 */
	public void showAddrAg(String policy_no) {
		Query pq = new NewDetailIllegalAddrQuery();
		List<HashMap<String, String>> list = setErrResultInd(pq.getResultList(
				policy_no, NewDetailIllegalAddrQuery.IllegalAddrAg), "cc236i");
		for (HashMap<String, String> hsmap : list) {
			NewDetailIllegalAddrAg newDetailIllegalAddrAg = new NewDetailIllegalAddrAg(
					hsmap);
			newDetailJPanel.addNewDetailIllegalAddrAg(newDetailIllegalAddrAg);
		}
	}

	@Override
	public String getOldPolicy_no() {
		return policy_no;
	}

	@Override
	public JPanel getPanel() {
		return newDetailJPanel;
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
