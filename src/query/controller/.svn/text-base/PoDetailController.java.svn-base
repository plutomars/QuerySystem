package query.controller;

import java.sql.Statement;
import java.util.HashMap;
import java.util.List;

import javax.swing.JPanel;

import database.connection.DBConnection;

import query.model.PoDetail.PoDetailPrem;
import query.model.PoDetail.PoDetailQuery;
import query.view.PoDetailJPanel;

/**
 * 保單明細
 * 
 * @author cora 100/08
 * @category SR140200243 新增class_type I5 代表UVUL 一般停泊停利
 */
public class PoDetailController extends DataControl {
	private String policy_no;
	private String client_id;
	private String class_type; // 控制不同險種panel種類
	private String policy_info[];
	private PoDetailJPanel PoDetailPanel;
	private int BlockType;
	private String SPname;
	private String mission0; // 0號頁籤 保單明細 當畫面停留在1號頁籤 換查詢保單使用 因為1號上半部與0號下半部資料共用
	private String mission1; // 1號頁籤控制 投資標的比例分配
	private String mission2; // 2號頁籤控制 目標堆疊查詢
	private String mission3; // 3號頁籤控制 自動化查詢
	private String mission4; // 4號頁籤控制 密碼列印記錄
	private PoDetailQuery rq;
	private List<HashMap<String, String>> list;

	public PoDetailController() {
		PoDetailPanel = new PoDetailJPanel();
		PoDetailPanel.setController(this);
		// PoDetailPanel.clearAll();
		rq = new PoDetailQuery();
		// System.out.println("PoDetailController:panel start");
	}

	// System.out.println("PoDetailController:panel start");//+policy_info[3]);
	// PoDetailPanel = new PoDetailJPanel(BlockType);
	// }
	@Override
	public void executeMission() {
		// TODO Auto-generated method stub
		// System.out.println("PoDetailController:xecuteMission");
		this.policy_no = policy_info[0];
		this.client_id = policy_info[1];
		this.class_type = policy_info[3];
		this.mission0 = "0";
		this.mission1 = "0";
		this.mission2 = "0";
		this.mission3 = "0";
		this.mission4 = "0";
		PoDetailPanel.clearAll();

		if (this.policy_no.length() != 12 || this.class_type.isEmpty()) // 不存在的保單號碼不往下做
		{
			PoDetailPanel.clearVer();
			return;
		}

		// System.out.println("[6]"+policy_info[6]);
		// PoDetailQuery rq = new PoDetailQuery();
		// PoDetailPanel.clearAll();
		PoDetailPanel.preBinding(class_type);
		PoDetailPanel.setTabbedPaneEnable(3, false); // 自動化查詢
		// 先抓取insurance_type
		Statement stLite = DBConnection.createLiteStatement();

		String cmd = "select insurance_type"
				+ " from jpolf where policy_no = '" + policy_no + "'";

		list = DBConnection.getResultList(DBConnection
				.executeQuery(stLite, cmd));
		DBConnection.closeStatement(stLite);
		String insurance_type = list.get(0).get("insurance_type");
		list = null;
		// switch (class_type.charAt(0)) {
		// 改用insurance_type判斷block type
		switch (insurance_type.charAt(0)) {
		case 'A':
		case 'B':
			this.BlockType = PoDetailQuery.PODETAIL_A;
			this.SPname = "cc002i";
			PoDetailPanel.setTabbedPaneEnable(1, false); // tab 金額明細及分配比例關掉
			PoDetailPanel.setTabbedPaneEnable(2, false); // tab 目標堆疊關掉
			if (PoDetailPanel.getTabbedPaneSelectedIndex() > 0)
				PoDetailPanel.setTabbedPaneSelectedIndex(0);
			break;

		case 'U':
			this.BlockType = PoDetailQuery.PODETAIL_U;
			this.SPname = "cc001i_ul";
			PoDetailPanel.setTabbedPaneEnable(1, true);
			PoDetailPanel.setTabbedPaneEnable(2, true);
			if (PoDetailPanel.getTabbedPaneSelectedIndex() > 0)
				executeMissionTabValues(PoDetailPanel
						.getTabbedPaneSelectedIndex());
			break;
		case 'G':
		case 'V':
			this.BlockType = PoDetailQuery.PODETAIL_I;
			PoDetailPanel.setTabbedPaneEnable(1, true);
			PoDetailPanel.setTabbedPaneEnable(2, true);
			break;
		case 'N':
			this.BlockType = PoDetailQuery.PODETAIL_N;
			this.SPname = "cc003i";
			PoDetailPanel.setTabbedPaneEnable(1, true);
			PoDetailPanel.setTabbedPaneEnable(2, true);
			if (PoDetailPanel.getTabbedPaneSelectedIndex() > 0)
				executeMissionTabValues(PoDetailPanel
						.getTabbedPaneSelectedIndex());
			break;
		case 'I': // 即期年金
			this.BlockType = PoDetailQuery.PODETAIL_A;
			this.SPname = "cc001i";
			this.mission0 = "0"; // 不必執行cc001i
			PoDetailPanel.setTabbedPaneEnable(1, false); // tab 金額明細及分配比例關掉
			PoDetailPanel.setTabbedPaneEnable(2, false); // tab 目標堆疊關掉
			if (PoDetailPanel.getTabbedPaneSelectedIndex() > 0) // 若非投資型 跳回第一頁
				PoDetailPanel.setTabbedPaneSelectedIndex(0);
			break;
		default: // P,L
			this.BlockType = PoDetailQuery.PODETAIL_PL;
			this.SPname = "cc001i";
			PoDetailPanel.setTabbedPaneEnable(1, false); // tab 金額明細及分配比例關掉
			PoDetailPanel.setTabbedPaneEnable(2, false); // tab 目標堆疊關掉
			if (PoDetailPanel.getTabbedPaneSelectedIndex() > 0) // 若非投資型 跳回第一頁
				PoDetailPanel.setTabbedPaneSelectedIndex(0);
		}

		if (this.mission0 == "0") {
			this.mission0 = "1";
			executeMissionCommBasic(); // 畫面下半部資料
		}

		list = rq.getResultList(policy_no, PoDetailQuery.COMMBASIC);
		// System.out.print("after lite con:");
		// 塞入共通基本欄位資料
		for (HashMap<String, String> hsmap : list) {
			PoDetailPanel.setValues(hsmap, PoDetailQuery.COMMBASIC, class_type);
		}
	}

	public void executeMissionCommBasic() {
		// PoDetailQuery rq = new PoDetailQuery();
		// List<HashMap<String, String>> list ;
		list = setErrResultInd(rq.getResultList(policy_no, BlockType), SPname);
		showMessageDialog(PoDetailPanel, "保單明細查詢", "保單不符或無資料");
		for (HashMap<String, String> hsmap : list) {
			// 保費計算 hsmap多插入6個欄位以便model裡保費計算用
			hsmap.put("r_group_code", "");
			hsmap.put("r_prem_disc_perc", "");
			hsmap.put("r_group_ind", "");
			hsmap.put("r_mode_prem_h", hsmap.get("r_mode_prem"));
			hsmap.put("r_prem_disc_perc_h", "");
			hsmap.put("r_accu_prem", hsmap.get("r_mode_prem"));
			if (class_type.equals("L")) {
				// System.out.println("class_type="+hsmap.get("r_mode_prem_h").trim());
				List<HashMap<String, String>> list2 = setErrResultInd(
						rq.getResultList(policy_no, PoDetailQuery.PODETAIL_PREM),
						"cc001i_ad");
				for (HashMap<String, String> hsmap2 : list2) {
					PoDetailPrem poDetailPrem = new PoDetailPrem(hsmap2);
					if (hsmap2.get("r_result_ind").trim().equals("0")) {
						hsmap.put("r_mode_prem", poDetailPrem.getmode_prem());
						hsmap.put("r_gross_mode_prem",
								poDetailPrem.getgross_mode_prem());
						hsmap.put("r_group_code", poDetailPrem.getgroup_code());
						hsmap.put("r_prem_disc_perc",
								poDetailPrem.getprem_disc_perc());
						hsmap.put("r_group_ind", poDetailPrem.getgroup_ind());
						hsmap.put("r_prem_disc_perc_h",
								poDetailPrem.getprem_disc_perc_h());
						hsmap.put("r_mode_prem_h",
								poDetailPrem.getmode_prem_h());
						hsmap.put("r_accu_prem", poDetailPrem.getaccu_prem());
					} else {
						hsmap.put("r_mode_prem", "無法計算");
						hsmap.put("r_gross_mode_prem", "無法計算");
						hsmap.put("r_prem_disc_perc", "無法計算");
						hsmap.put("r_prem_disc_perc_h", "無法計算");
						hsmap.put("r_mode_prem_h", "無法計算");
						hsmap.put("r_accu_prem", "無法計算");
					}
				}
			}

			PoDetailPanel.setValues(hsmap, BlockType, class_type);
		}
		// showMessageDialog(PoDetailPanel, "保單明細查詢", "保單不符或無資料");

	}

	// 抓密碼等級與登記的保單or被保險人
	public void executeMission(String acct_source, String bank_id,
			String account_no, String lcnt) {
		list = setErrResultInd(rq.getResultList(client_id, acct_source,
				bank_id, account_no, lcnt), "cc193i");
		for (HashMap<String, String> hsmap : list) {
			PoDetailPanel.setValues(hsmap, 1);
		}

		list = setErrResultInd(
				rq.getResultList(client_id, acct_source, bank_id, account_no),
				"cc194i");
		for (HashMap<String, String> hsmap : list) {
			PoDetailPanel.setValues(hsmap, 2);
		}
	}

	public void executeMissionTabValues(int tabSelect) // 點選頁籤
	{

		switch (tabSelect) {
		case 1: // 投資標的內容分配
			if (this.mission1 == "0") { // 已經執行過的就不重複執行
				this.mission1 = "1";
				if (this.mission0 == "0") {
					this.mission0 = "1";
					executeMissionCommBasic(); // 第0畫面下半部資料
				}

				PoDetailPanel.setValues(null, PoDetailQuery.PODETAIL_PG2,
						class_type); // 上半部

				if (class_type.equals("I2") || class_type.equals("I4")
						|| class_type.equals("I5") || class_type.equals("I6")) { // VA
					list = setErrResultInd(rq.getResultList(policy_no,
							PoDetailQuery.PODETAIL_VALIST), "cc004i_va");
					for (HashMap<String, String> hsmap : list) {
						PoDetailPanel.setValues(hsmap,
								PoDetailQuery.PODETAIL_ILIST, class_type);
					}
				} else {
					if (!class_type.equals("U")) {
						// System.out.println("!U"+class_type);
						list = setErrResultInd(rq.getResultList(policy_no,
								PoDetailQuery.PODETAIL_ILIST), "cc004i");
						for (HashMap<String, String> hsmap : list) {
							PoDetailPanel.setValues(hsmap,
									PoDetailQuery.PODETAIL_ILIST, class_type);
						}
					}
				}
			}
			break;
		case 2: // 目標堆疊查詢
			if (this.mission2 == "0") {
				this.mission2 = "1";
				list = setErrResultInd(rq.getResultList(policy_no,
						PoDetailQuery.PODETAIL_TARGET), "cc010i");
				for (HashMap<String, String> hsmap : list) {

					PoDetailPanel.setValues(hsmap,
							PoDetailQuery.PODETAIL_TARGET, class_type);
				}
			}
			break;
		case 3:
			if (this.mission3 == "0") {
				this.mission3 = "1";
				list = setErrResultInd(
						rq.getResultList(client_id, PoDetailQuery.PODETAIL_ECO),
						"cc192i");
				for (HashMap<String, String> hsmap : list) {
					PoDetailPanel.setValues(hsmap, PoDetailQuery.PODETAIL_ECO,
							class_type);
				}
			}
			break;
		case 4:
			if (this.mission4 == "0") {
				this.mission4 = "1";
				list = setErrResultInd(
						rq.getResultList(client_id, PoDetailQuery.PODETAIL_PWD),
						"cc195i");
				for (HashMap<String, String> hsmap : list) {
					PoDetailPanel.setValues(hsmap, 3);
				}
			}
			break;
		}
	}

	@Override
	public void executeClearMission() {
		PoDetailPanel.clearAll();
	}

	@Override
	public void executeNullMission() {
		PoDetailPanel.nullAll();
	}

	@Override
	public String getOldPolicy_no() {
		// TODO Auto-generated method stub
		return policy_no;
	}

	@Override
	public JPanel getPanel() {
		// TODO Auto-generated method stub
		return PoDetailPanel;
	}

	@Override
	public void setPolicyInfo(String[] policy_info) {
		this.policy_info = policy_info;
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isControllable() {
		// TODO Auto-generated method stub
		return false;
	}

}
