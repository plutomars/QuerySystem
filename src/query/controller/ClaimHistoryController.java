package query.controller;

import java.util.HashMap;
import java.util.List;

import javax.swing.JPanel;

import query.model.ClaimHistory.ClaimHistory01;
import query.model.ClaimHistory.ClaimHistory02event;
import query.model.ClaimHistory.ClaimHistory03;
import query.model.ClaimHistory.ClaimHistory04;
import query.model.ClaimHistory.ClaimHistory05;
import query.model.ClaimHistory.ClaimHistory06;
import query.model.ClaimHistory.ClaimHistory07;
import query.model.ClaimHistory.ClaimHistory08;
import query.model.ClaimHistory.ClaimHistory09;
import query.model.ClaimHistory.ClaimHistory10;
import query.model.ClaimHistory.ClaimHistory12;
import query.model.ClaimHistory.ClaimHistoryQuery;
import query.view.ClaimHistoryJPanel;
import query.view.ToolTipFrame;

/**
 * 
 * @author fyyang
 * 
 */
public class ClaimHistoryController extends DataControl {
	private String policy_no;
	private String class_type; // 101/04/18
	private String policy_info[];
	private ClaimHistoryJPanel claimHistoryPanel;
	private ClaimHistoryQuery rq = new ClaimHistoryQuery();

	public ClaimHistoryController() {
		claimHistoryPanel = new ClaimHistoryJPanel();
		claimHistoryPanel.setController(this);
	}

	public void executeMission() {
		this.policy_no = policy_info[0];
		// ClaimHistoryQuery rq = new ClaimHistoryQuery();
		claimHistoryPanel.clearAll();
		if (this.policy_no.endsWith("-----"))
			this.policy_no = "";

		// claimHistoryPanel.setPONO(this.policy_no, policy_info[4]); 101/08/06
		// 姵如取消自動帶I1
		claimHistoryPanel.setPONO(this.policy_no, "");
		claimHistoryPanel.setPOID(this.policy_no, policy_info[4]);
		List<HashMap<String, String>> list = setErrResultInd(rq.getResultList(
				policy_no, "",
				query.model.ClaimHistory.ClaimHistoryQuery.CLAIMHISTORY, ""),
				"cc170i");

		// 塞入理賠欄位資料
		for (HashMap<String, String> hsmap : list) {
			ClaimHistory01 claimHistory = new ClaimHistory01(hsmap);
			claimHistoryPanel.addClaimHistory01(claimHistory);
		}

		showMessageDialog(claimHistoryPanel, "理賠紀錄查詢", "保單不符或無資料");
	}

	public void executeMission(String policy_no, String insured_id,
			String claim_year) {
		claimHistoryPanel.clearAll();

		List<HashMap<String, String>> list = setErrResultInd(rq.getResultList(
				policy_no, insured_id,
				query.model.ClaimHistory.ClaimHistoryQuery.CLAIMHISTORY,
				claim_year), "cc170i");

		// 塞入理賠欄位資料
		for (HashMap<String, String> hsmap : list) {
			ClaimHistory01 claimHistory = new ClaimHistory01(hsmap);
			claimHistoryPanel.addClaimHistory01(claimHistory);
		}

		showMessageDialog(claimHistoryPanel, "理賠紀錄查詢", "保單不符或無資料");
	}

	/**
	 * @author epf
	 * @category 新契約查詢使用 複製executeMission而來
	 */
	public void executeNewDetailMission() {
		this.policy_no = policy_info[0];
		claimHistoryPanel.clearAll();

		List<HashMap<String, String>> list = setErrResultInd(rq.getResultList(
				policy_no,
				query.model.ClaimHistory.ClaimHistoryQuery.NEWCLAIMHISTORY),
				"cc170i-I");

		// 塞入理賠欄位資料
		for (HashMap<String, String> hsmap : list) {
			ClaimHistory01 claimHistory = new ClaimHistory01(hsmap);
			claimHistoryPanel.addClaimHistory01(claimHistory);
		}

		showMessageDialog(claimHistoryPanel, "新契約理賠紀錄查詢", "保單不符或無資料");

	}

	public void executeInnerMission(String policy_no, String claim_seq,
			String claim_year) {

		List<HashMap<String, String>> list = setErrResultInd(rq.getResultList(
				policy_no, claim_seq,
				query.model.ClaimHistory.ClaimHistoryQuery.CLAIMDETAIL,
				claim_year), "cc171i");

		// 塞入欄位資料
		for (HashMap<String, String> hsmap : list) {
			// HashMap<String, String> event;
			// ClaimHistory02event claimHistory02event;
			//
			// event = new HashMap<String, String>();
			// event.put("cl_event_code", hsmap.get("r_cl_event_code_1"));
			// event.put("cl_event_desc", hsmap.get("r_cl_event_desc_1"));
			// claimHistory02event = new ClaimHistory02event(event);
			// claimHistoryPanel.addClaimHistory02event(claimHistory02event);
			//
			// event = new HashMap<String, String>();
			// event.put("cl_event_code", hsmap.get("r_cl_event_code_2"));
			// event.put("cl_event_desc", hsmap.get("r_cl_event_desc_2"));
			// claimHistory02event = new ClaimHistory02event(event);
			// claimHistoryPanel.addClaimHistory02event(claimHistory02event);
			//
			// event = new HashMap<String, String>();
			// event.put("cl_event_code", hsmap.get("r_cl_event_code_3"));
			// event.put("cl_event_desc", hsmap.get("r_cl_event_desc_3"));
			// claimHistory02event = new ClaimHistory02event(event);
			// claimHistoryPanel.addClaimHistory02event(claimHistory02event);
			//
			// event = new HashMap<String, String>();
			// event.put("cl_event_code", hsmap.get("r_cl_event_code_4"));
			// event.put("cl_event_desc", hsmap.get("r_cl_event_desc_4"));
			// claimHistory02event = new ClaimHistory02event(event);
			// claimHistoryPanel.addClaimHistory02event(claimHistory02event);

			claimHistoryPanel.setClaimHistory02(hsmap);
		}

		list = setErrResultInd(rq.getResultList(policy_no, claim_seq,
				query.model.ClaimHistory.ClaimHistoryQuery.CLAIMEVENT,
				claim_year), "cc178i");

		// 塞入欄位資料
		for (HashMap<String, String> hsmap : list) {
			ClaimHistory02event claimHistory02event = new ClaimHistory02event(
					hsmap);
			if (claimHistory02event.getcl_code_type().equals("1"))
				claimHistoryPanel.addClaimHistory02event(claimHistory02event);
			else
				claimHistoryPanel.addClaimHistory02sick(claimHistory02event);
		}

		// 受益人
		list = setErrResultInd(
				rq.getResultList(policy_no, claim_seq,
						query.model.ClaimHistory.ClaimHistoryQuery.BENIFIT,
						claim_year), "cc175i");

		// 塞入欄位資料
		for (HashMap<String, String> hsmap : list) {
			ClaimHistory05 claimHistory = new ClaimHistory05(hsmap);

			// 受益人新增郵遞區號,受益人地址,聯絡電話,手機號碼,國籍欄位
			List<HashMap<String, String>> list2 = setErrResultInd(
					rq.getResultList(
							policy_no,
							claim_seq,
							(hsmap.get("r_benf_id") == null) ? "" : hsmap.get(
									"r_benf_id").trim(),
							query.model.ClaimHistory.ClaimHistoryQuery.BENFADDR),
					"受益人地址");

			if (list2.size() != 0)
				claimHistory.setBenfAddr(list2.get(0));
			// 加上受益人外幣帳戶欄位 101/03/26 new by jnd115
			List<HashMap<String, String>> list3 = setErrResultInd(
					rq.getResultList(
							policy_no,
							claim_seq,
							(hsmap.get("r_benf_id") == null) ? "" : hsmap.get(
									"r_benf_id").trim(),
							query.model.ClaimHistory.ClaimHistoryQuery.BENFACCTE),
					"cc176i");
			if (list3.size() != 0)
				claimHistory.setBenfAcct(list3.get(0));
              claimHistoryPanel.addClaimHistory05(claimHistory);
		}

		// 就診醫院
		list = setErrResultInd(
				rq.getResultList(policy_no, claim_seq,
						query.model.ClaimHistory.ClaimHistoryQuery.HOSPITAL,
						claim_year), "就診醫院");

		// 塞入欄位資料
		for (HashMap<String, String> hsmap : list) {
			ClaimHistory08 claimHistory = new ClaimHistory08(hsmap);
			claimHistoryPanel.addClaimHistory08(claimHistory);
		}

		list = setErrResultInd(rq.getResultList(policy_no, claim_seq,
				query.model.ClaimHistory.ClaimHistoryQuery.RELEASE, ""),
				"安寧緩和醫療");

		// 塞入欄位資料
		for (HashMap<String, String> hsmap : list) {
			ClaimHistory09 claimHistory = new ClaimHistory09(hsmap);
			claimHistoryPanel.addClaimHistory09(claimHistory);
		}

		// showMessageDialog(claimHistoryPanel, "理賠紀錄查詢", "保單不符或無資料");
	}

	public void executeInnerMission2(String policy_no, String claim_seq,
			String claim_year, String clhn_seq) {

		// System.out.println(policy_no);
		// System.out.println(claim_seq);
		// System.out.println(claim_year);
		// System.out.println(clhn_seq);

		// ADD 102.06.20 就診明細
		List<HashMap<String, String>> list = rq.getResultList2(policy_no,
				claim_seq, claim_year, clhn_seq);

		// 塞入欄位資料
		for (HashMap<String, String> hsmap : list) {
			ClaimHistory12 claimHistory = new ClaimHistory12(hsmap);
			claimHistoryPanel.addClaimHistory12(claimHistory);
		}

	}

	// 拒賠原因及理賠註記查詢
	public void executeInnerMission(String policy_no, String claim_seq,
			String cl_examine_code, int type) {

		this.class_type = policy_info[3]; // 101/04/18

		// if (type == ClaimHistoryQuery.DETAILITEM) {
		// List<HashMap<String, String>> list = setErrResultInd(
		// rq.getResultList(policy_no, claim_seq, cl_examine_code,
		// ClaimHistoryQuery.DETAILITEM), "項目明細");
		//
		// // 塞入欄位資料
		// for (HashMap<String, String> hsmap : list) {
		// ClaimHistory07 claimHistory = new ClaimHistory07(hsmap);
		// claimHistoryPanel.addClaimHistory07(claimHistory);
		// }
		//
		// // showMessageDialog(claimHistoryPanel, "理賠紀錄查詢", "保單不符或無資料");
		// } else
		if (type == ClaimHistoryQuery.CC174I) {
			List<HashMap<String, String>> list = setErrResultInd(
					rq.getResultList(policy_no, claim_seq, cl_examine_code,
							ClaimHistoryQuery.CC174I), "cc174i");

			// 塞入欄位資料
			for (HashMap<String, String> hsmap : list) {
				ClaimHistory06 claimHistory = new ClaimHistory06(hsmap);
				claimHistoryPanel.addClaimHistory06(claimHistory);
			}

			showMessageDialog(claimHistoryPanel, "理賠紀錄查詢", "保單不符或無資料");
		}
		// 理賠註記
		else if (type == ClaimHistoryQuery.CLAIMMARK) {
			List<HashMap<String, String>> list = setErrResultInd(
					rq.getResultList(policy_no, claim_seq,
							ClaimHistoryQuery.CLAIMMARK, ""), "理賠註記");

			// 塞入欄位資料
			for (HashMap<String, String> hsmap : list) {
				ClaimHistory10 claimHistory = new ClaimHistory10(hsmap);
				claimHistoryPanel.addClaimHistory10(claimHistory);
			}

			showMessageDialog(claimHistoryPanel, "理賠紀錄查詢", "保單不符或無資料");
		}
		// 地檢署相驗明細 101/04/18 new by jnd115
		else if (type == ClaimHistoryQuery.DISPCLED) {
			String claim_year = cl_examine_code;
			String clpm_type = "L"; // L:個人險
			if (class_type.equals("G") || class_type.equals("T")) { // G:團險
																	// T:旅平險
				clpm_type = "G";
			}
			List<HashMap<String, String>> list = rq.getResultList(policy_no,
					claim_seq, clpm_type, claim_year,
					query.model.ClaimHistory.ClaimHistoryQuery.DISPCLED);
			for (HashMap<String, String> hashmap : list) {
				hashmap.put("r_result_ind", "0");
			}
			list = setErrResultInd(list, "cc177i");

			// 塞入欄位資料
			for (HashMap<String, String> hsmap : list) {
				claimHistoryPanel.setClaimHistory11(hsmap);
			}
			showMessageDialog(claimHistoryPanel, "地檢署相驗明細", "保單不符或無資料");
		}

	}

	public void executeInnerMission(String policy_no, String claim_seq,
			String event_date, String client_ident, String type,
			String client_id, String claim_year) {
		List<HashMap<String, String>> list = rq.getResultList(policy_no,
				claim_seq, event_date, client_ident, type, client_id,
				claim_year);

		// 塞入欄位資料
		for (HashMap<String, String> hsmap : list) {
			ClaimHistory03 claimHistory = new ClaimHistory03(hsmap);
			claimHistoryPanel.addClaimHistory03(claimHistory);
		}

		// showMessageDialog(claimHistoryPanel, "理賠紀錄查詢", "保單不符或無資料");
	}

	public void executeInnerMission(String policy_no, String claim_seq,
			String plan_code, String rate_scale, String co_issue_date,
			Integer coverage_no, String claim_year) {

		List<HashMap<String, String>> list = setErrResultInd(rq.getResultList(
				policy_no, claim_seq, plan_code, rate_scale, co_issue_date,
				coverage_no, claim_year), "cc173i");

		// 塞入理賠欄位資料
		for (HashMap<String, String> hsmap : list) {
			ClaimHistory04 claimHistory = new ClaimHistory04(hsmap);
			claimHistoryPanel.addClaimHistory04(claimHistory);
		}

		// showMessageDialog(claimHistoryPanel, "理賠紀錄查詢", "保單不符或無資料");
	}

	public void executeInnerMission(String policy_no,
			String claim_seq, // 項目明細
			String plan_code, String rate_scale, String coverage_no,
			String claim_year) {

		List<HashMap<String, String>> list = setErrResultInd(rq.getResultList(
				policy_no, claim_seq, plan_code, rate_scale, coverage_no,
				claim_year), "cc173i01");

		// 項目明細
		for (HashMap<String, String> hsmap : list) {
			ClaimHistory07 claimHistory = new ClaimHistory07(hsmap);
			claimHistoryPanel.addClaimHistory07(claimHistory);
		}

		// showMessageDialog(claimHistoryPanel, "理賠紀錄查詢", "保單不符或無資料");
	}

	// 取得醫院註記並秀出
	public void showHospitalDetail(String hospital_id) {
		List<HashMap<String, String>> list = setErrResultInd(rq.getResultList(
				hospital_id,
				query.model.ClaimHistory.ClaimHistoryQuery.HOSPIMARK), "醫院註記");

		String title[] = new String[] { "醫院代碼", "序號", "註記內容", "處理者", "處理時間" };
		String[][] context = new String[list.size()][];
		int i = 0;
		// 塞入理賠欄位資料
		for (HashMap<String, String> hsmap : list) {
			String detail[] = new String[] { hsmap.get("hi_hospital_id"),
					hsmap.get("hicm_seq"), hsmap.get("hicm_desc"),
					hsmap.get("process_user"), hsmap.get("process_date") };
			context[i++] = detail;
			// ClaimHistory01 claimHistory = new ClaimHistory01(hsmap);
			// claimHistoryPanel.addClaimHistory01(claimHistory);
		}
		ToolTipFrame.setTable(title, context,
				new int[] { 50, 20, 350, 40, 40 }, true);
		// ToolTipFrame.setBounds(150, 600, 700);
		ToolTipFrame.setSizeAndLocation(700, claimHistoryPanel);
	}

	// 取得醫院註記並秀出
	public void showBenfAddr(ClaimHistory05 claimHistory) {

		ToolTipFrame.setTable(new String[] { "郵遞區號", "受益人地址", "聯絡電話", "手機號碼" },
				new String[][] { claimHistory.getBenfAddr() }, new int[] { 40,
						400, 30, 30 }, false);
		// ToolTipFrame.setBounds(150, 600, 700);
		ToolTipFrame.setSizeAndLocation(700, claimHistoryPanel);
	}

	@Override
	public void executeClearMission() {
		claimHistoryPanel.clearAll();
	}

	@Override
	public void executeNullMission() {
		claimHistoryPanel.nullAll();
	}

	@Override
	public String getOldPolicy_no() {
		// TODO Auto-generated method stub
		return policy_no;
	}

	@Override
	public JPanel getPanel() {
		// TODO Auto-generated method stub
		return claimHistoryPanel;
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
