package query.controller;

import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import query.model.Authority;
import query.model.AuthorityGroup;
import query.model.AuthorityQuery;
import query.model.SelectionTreeModel;
import query.view.QueryFrame;
import database.connection.DBConnection;

/**
 * @ * @author FYYANG
 * 
 * @version 1.0<br>
 *          100/07/28<br>
 *          控制jTree節點對應動作(Main Controller)
 * 
 * @since 1.0
 */
public class SelectionTreeController implements Runnable {
	private JPanel returnPanel;
	private HashMap<String, DataControl> controlMap;
	private DataControl dataControl, clientControl;
	private AuthorityGroup authorityGroup;
	private QueryFrame frame;
	private String[] policy_info = { "", "", "" };
	private String nodeName;
	private int mission = 0;
	private int tmp_mission = 0; // for execute 保戶訊息

	/**
	 * 建構子:建立存放各子Controller之HashMap<br>
	 * 以便能依節點名稱找出各對應之Controller
	 */
	public SelectionTreeController() {
		controlMap = new HashMap<String, DataControl>();
		authorityGroup = new AuthorityGroup();
	}

	public void setFrame(QueryFrame frame) {
		this.frame = frame;
	}

	/**
	 * 取得登入使用者的權限(有定義在AuthorityGroup中的節點)
	 * 
	 */
	public void getAuthority() {
		AuthorityQuery rq = new AuthorityQuery();

		HashMap<String, String> authorityMap;
		List<HashMap<String, String>> list;

		StringBuilder user_group_code;
		StringBuilder user_authority;

		for (int i = 0; i < SelectionTreeModel.lock_program.length; i++) {
			user_group_code = new StringBuilder();
			user_authority = new StringBuilder();

			Object[] program = SelectionTreeModel.lock_program[i];

			authorityMap = new HashMap<String, String>();

			list = rq.getResultList(DBConnection.getUser(),
					program[0].toString());

			// 塞入理賠欄位資料
			for (HashMap<String, String> hsmp : list) {
				user_group_code
						.append((hsmp.get("user_group_code") == null) ? ""
								: hsmp.get("user_group_code").trim() + "|");
				user_authority.append((hsmp.get("user_authority") == null) ? ""
						: hsmp.get("user_authority").trim());
			}

			// 只要有定義過ID就塞入USER權限表
			authorityMap.put("program_id", program[0].toString());
			authorityMap.put("system_id", program[1].toString());
			authorityMap.put("user_group_code", user_group_code.toString());
			authorityMap.put("user_authority", user_authority.toString());

			// 檢核是否有查詢權限,判斷取回來之USER權限當中是否有定義中之權限,
			// 有則塞Q,無值則為無權限執行此程式
			// System.out.println(user_authority.toString()+"="+program[2].toString());

			StringBuilder query_authority = new StringBuilder();
			if (user_authority.toString().contains(program[2].toString()))
				query_authority.append("Q");
			authorityMap.put("query_authority", query_authority.toString());
			authorityGroup.addAuthority(program[1].toString(), new Authority(
					authorityMap));
		}
	}

	public AuthorityGroup getAuthorityGroup() {
		return authorityGroup;
	}

	public boolean comparePolicy() {
		if (dataControl == null || dataControl.getOldPolicy_no() == null)
			return false;

		return policy_info[0].equals(dataControl.getOldPolicy_no());
	}

	/**
	 * 藉由各子Controller 所覆寫之executeMission方法(實做interface DataControl)<br>
	 * 執行各Controller所各自與生俱來之任務
	 * 
	 */
	public void executeMission(DataControl control) {
		if (mission == 2
				|| (policy_info[0] != null && !policy_info[0]
						.equals(dataControl.getOldPolicy_no())))
			control.executeMission();
		else
			System.out.println("號碼一樣");
	}

	public void setPolicyInfo(String[] policy_info) {
		if (dataControl != null) {
			dataControl.setPolicyInfo(policy_info);
			this.policy_info = policy_info;
		}
	}

	/**
	 * 藉由各子Controller 所覆寫之getPanel方法(實做interface DataControl)<br>
	 * 回傳所控制之對應查詢畫面(JPanel)
	 * 
	 * @param selection
	 *            節點名稱
	 * @return JPanel 節點對應查詢畫面
	 */
	public void setJPanel(String selection) {
		switch (SelectionTreeModel.getActionNodeValue(selection)) {

		// 新增PANEL時需在底下新增CASE
		case SelectionTreeModel.S_RELATION:
			if (!controlMap.containsKey(selection))
				controlMap.put(selection, new PoRelationController());
			break;
		case SelectionTreeModel.S_DRAWDETAIL:
			if (!controlMap.containsKey(selection))
				controlMap.put(selection, new ValueWithdrawController());
			break;
		case SelectionTreeModel.S_POEXAM:
			if (!controlMap.containsKey(selection))
				controlMap.put(selection, new PoExam01Controller());
			break;
		case SelectionTreeModel.S_POPLAN:
			if (!controlMap.containsKey(selection)) {
				controlMap.put(selection, new PoPlanController());
			}
			break;
		case SelectionTreeModel.S_INVESTHISTORY:
			if (!controlMap.containsKey(selection)) {
				controlMap.put(selection, new InvestHistoryController());
			}
			break;
		case SelectionTreeModel.S_PODETAIL:
			if (!controlMap.containsKey(selection)) {
				controlMap.put(selection, new PoDetailController());
			}
			break;
		case SelectionTreeModel.S_CLAIMHISTORY:
			if (!controlMap.containsKey(selection)) {
				controlMap.put(selection, new ClaimHistoryController());
			}
			break;
		case SelectionTreeModel.S_CLAIMASSO:
			if (!controlMap.containsKey(selection)) {
				controlMap.put(selection, new ClaimAssoController());
			}
			break;
		case SelectionTreeModel.S_DELEGATION:
			if (!controlMap.containsKey(selection))
				controlMap.put(selection, new PremProxyController());
			break;
		case SelectionTreeModel.S_PREMBILL:
			if (!controlMap.containsKey(selection)) {
				controlMap.put(selection, new PremBillController());
			}
			break;
		case SelectionTreeModel.S_VALUEREPAY:
			if (!controlMap.containsKey(selection)) {
				controlMap.put(selection, new ValueRepayController());
			}
			break;
		case SelectionTreeModel.S_POSCHANGE:
			if (!controlMap.containsKey(selection)) {
				controlMap.put(selection, new PosChangeController());
			}
			break;
		case SelectionTreeModel.S_PREMGBILL:
			if (!controlMap.containsKey(selection)) {
				controlMap.put(selection, new PremGBillController());
			}
			break;
		case SelectionTreeModel.S_PREMQUERY:
			if (!controlMap.containsKey(selection)) {
				controlMap.put(selection, new PayQueryController());
			}
			break;
		case SelectionTreeModel.S_PREMACCOUNT:
			if (!controlMap.containsKey(selection)) {
				controlMap.put(selection, new PayAccountController());
			}
			break;
		case SelectionTreeModel.S_PREMREJECT:
			if (!controlMap.containsKey(selection)) {
				controlMap.put(selection, new PremRejectController());
			}
			break;
		case SelectionTreeModel.S_PREMBLDT:
			if (!controlMap.containsKey(selection)) {
				controlMap.put(selection, new PremBldtController());
			}
			break;

		case SelectionTreeModel.S_PREMPOSTAL:
			if (!controlMap.containsKey(selection)) {
				controlMap.put(selection, new PremPostalController());
			}
			break;

		case SelectionTreeModel.S_POSNOTICE:
			if (!controlMap.containsKey(selection)) {
				controlMap.put(selection, new PosNoticeController());
			}
			break;

		case SelectionTreeModel.S_POBONUS:
			if (!controlMap.containsKey(selection)) {
				controlMap.put(selection, new PoBonusController());
			}
			break;
		case SelectionTreeModel.S_INVESTCODE:
			if (!controlMap.containsKey(selection)) {
				controlMap.put(selection, new InvestGoalController());
			}
			break;
		case SelectionTreeModel.S_CASHFLOW:
			if (!controlMap.containsKey(selection)) {
				controlMap.put(selection, new InvestCashController());
			}
		case SelectionTreeModel.S_INVESTAUTO:
			if (!controlMap.containsKey(selection)) {
				controlMap.put(selection, new InvestAutoController());
			}
			break;
		case SelectionTreeModel.S_NEWHOSPITAL:
			if (!controlMap.containsKey(selection)) {
				controlMap.put(selection, new NewHospitalController());
			}
			break;
		case SelectionTreeModel.S_NEWRESCIND:
			if (!controlMap.containsKey(selection)) {
				controlMap.put(selection, new NewRescindController());
			}
			break;
		case SelectionTreeModel.S_NEWFACEAMOUNT:
			if (!controlMap.containsKey(selection)) {
				controlMap.put(selection, new NewFaceAmountController());
			}
			break;

		case SelectionTreeModel.S_NEWSAMPLING:
			if (!controlMap.containsKey(selection)) {
				controlMap.put(selection, new NewSamplingRecordController());
			}
			break;
		case SelectionTreeModel.S_NEWDETAIL:
			if (!controlMap.containsKey(selection)) {
				controlMap.put(selection, new NewDetailController());
			}
			break;

		case SelectionTreeModel.S_POREASSOCIATE:
			if (!controlMap.containsKey(selection)) {
				controlMap.put(selection, new ValueReAssociateController());
			}
			break;

		case SelectionTreeModel.S_NEWPHYSICALEXAM:
			if (!controlMap.containsKey(selection)) {
				controlMap.put(selection, new NewPhysicalExamController());
			}
			break;

		case SelectionTreeModel.S_CLIENTINFO:
			if (!controlMap.containsKey(selection)) {
				controlMap.put(selection, new ClientInfoController());
				// 只有clientInfo需要這個
				clientControl = controlMap.get(selection);
			}
			break;
		case SelectionTreeModel.S_INVESTDEDUCTION:// 每月扣除
			if (!controlMap.containsKey(selection)) {
				controlMap.put(selection, new InvestDeductionController());
			}
			break;

		case SelectionTreeModel.S_POSECATM:// EC&ATM帳號申請記錄
			if (!controlMap.containsKey(selection)) {
				controlMap.put(selection, new PosECController());
			}
			break;
		case SelectionTreeModel.S_POVALUEADDSHARE:// 增值回饋分享金
			if (!controlMap.containsKey(selection)) {
				controlMap.put(selection, new PoValueAddShareController());
			}
			break;
		case SelectionTreeModel.S_INVESTAPPOINT: // 約定交易查詢
			if (!controlMap.containsKey(selection)) {
				controlMap.put(selection, new InvestAppointController());
			}
			break;
		default:
			JOptionPane.showMessageDialog(null, "此功能尚未實作", "未實作",
					JOptionPane.ERROR_MESSAGE);
			returnPanel = null;
			// return returnPanel;
		}
		dataControl = controlMap.get(selection);
		if (dataControl != null)
			returnPanel = dataControl.getPanel();
		else
			returnPanel = null;
		// return returnPanel;
	}

	public DataControl getControl(String selection) {
		return controlMap.get(selection);
	}

	public void removeController(String key, boolean clear) {
		if (controlMap.containsKey(key)) {
			DataControl control = controlMap.remove(key);
			if (clear) {
				control.clearMission();
				control = null;
			}

		}

	}

	public boolean isControllable() {
		if (dataControl == null)
			return false;
		return dataControl.isControllable();
	}

	public boolean isExist(String selection) {
		return controlMap.containsKey(selection);
	}

	public JPanel getReturnPanel() {
		return returnPanel;
	}

	// mission-1:get JPanel
	// mission-2:為直接執行不檢查保單號碼
	// mission-3:為檢查保單號碼執行
	public void setMission(int i) {
		mission = i;
	}

	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		// 第一個任務先取得畫面
		if (mission == 1) {
			setJPanel(nodeName);
			// check mission type
			// mission 2為直接執行不檢查保單號碼
			// mission 3為檢查保單號碼執行
			tmp_mission = frame.jobCheck(getReturnPanel(), comparePolicy());
			new Thread(new Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub

					setMission(3); // anyway 先執行保戶訊息就對了 fyyang 101/02/03
					if (clientControl.getOldPolicy_no() != null
							&& !dataControl.equals(clientControl)
							&& !clientControl.getOldPolicy_no().equals(
									QueryFrame.policy_info[0])) {
						clientControl.setPolicyInfo(QueryFrame.policy_info);
						executeMission(clientControl);
					}

					if (mission == 2 || mission == 3) {
						setMission(tmp_mission);
						executeMission(dataControl);
						if (controlMap.get("提示訊息").isControllable())
							frame.setFocusTAB(true);
						else
							frame.setFocusTAB(false);
					}
					frame.stopFlower();
				}

			}).start();

		}

	}

}
