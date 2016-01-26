package query.controller;

import java.util.HashMap;
import java.util.List;

import javax.swing.JPanel;

import query.model.ClientInfo.ClientInfo01;
import query.model.ClientInfo.ClientInfo02;
import query.model.ClientInfo.ClientInfo03;
import query.model.ClientInfo.ClientInfo04;
import query.model.ClientInfo.ClientInfoQuery;
import query.model.PoDetail.PoDetailQuery;
import query.view.ClientInfoJPanel;

public class ClientInfoController extends DataControl {
	private String client_id;
	private String policy_no;
	private String policy_info[];
	private ClientInfoJPanel clientInfoJPanel = new ClientInfoJPanel();
	private ClientInfo01 clientInfo01;
	private ClientInfo02 clientInfo02;
	private ClientInfo03 clientInfo03;
	private ClientInfo04 clientInfo04;
	ClientInfoQuery pq;
	PoDetailQuery comm_pq;

	public String focus_ind = "0"; // 0號頁籤控制 訊息 不重複執行
	private String mission1; // 1號頁籤控制 要保人資訊

	@Override
	public void executeMission() {
		// TODO Auto-generated method stub
		this.client_id = policy_info[1];
		this.policy_no = policy_info[0];
		clientInfoJPanel.setController(this);
		clientInfoJPanel.clearAll();
		clientInfo01 = null;
		clientInfo02 = null;
		focus_ind = "0";
		this.mission1 = "0";

		// System.out.println("b get data:"+this.policy_no);

		if (this.client_id.isEmpty())
			this.mission1 = "1";
		else { // 正確的id才要作後面交易
			pq = new ClientInfoQuery();
			List<HashMap<String, String>> list = setErrResultInd(
					pq.getResultList(this.client_id, "cc232i"), "cc232i");
			for (HashMap<String, String> hsmap : list) {
				// System.out.println("get data");
				clientInfo02 = new ClientInfo02(hsmap);
				clientInfoJPanel.addClientInfopanel(clientInfo02);
				focus_ind = "1";
			}

			list = pq.getResultList(this.policy_no, "cc231i");
			for (HashMap<String, String> hsmap : list) {
				clientInfo01 = new ClientInfo01(hsmap);
				// clientInfoJPanel.addClientInfopanel(clientInfo01);
			}
			if (clientInfo01 == null)
				clientInfoJPanel.setProblem("", "", "", "無問題", "");
			else {
				clientInfoJPanel.setProblem(clientInfo01.getrestrained_code()
						+ clientInfo01.getrestrained(),
						clientInfo01.getprocess_user(),
						clientInfo01.getprocess_date(),
						clientInfo01.getrestrained_desc(),
						clientInfo01.getother_prob());
				focus_ind = "1";
			}
		}

		if (clientInfoJPanel.tabbedPane.getSelectedIndex() > 0)
			clientInfoJPanel.tabbedPane.setSelectedIndex(0);

		// if (focus_ind.endsWith("1"))
		// QueryFrame
	}

	public void executeMissionTabValues(int tabSelect) // 點選頁籤
	{
		if (tabSelect == 1 && this.mission1.equals("0")) {
			clientInfoJPanel.setO1name(policy_info[1], policy_info[2]);
			comm_pq = new PoDetailQuery();
			// System.out.println("--*-*--");
			List<HashMap<String, String>> list = setErrResultInd(
					pq.getResultList(this.client_id), "cc000s");
			for (HashMap<String, String> hsmap : list) {
				clientInfo03 = new ClientInfo03(hsmap);

				if (!clientInfo03.getmail_addr_ind().equals(
						clientInfo03.gethome_addr_ind())) {
					List<HashMap<String, String>> listQ = pq.getHomeAddr(
							this.client_id, clientInfo03.gethome_addr_ind());
					if (listQ != null)
						clientInfo03.sethome_addr(listQ.get(0).get("address")
								.toString());
				} else
					clientInfo03.sethome_addr("同收費");

				if (comm_pq.getAddrSts(this.client_id,
						clientInfo03.getpolicy_no(),
						clientInfo03.getmail_addr_ind()).equals("Y"))
					clientInfo03.setpmia_sts("◎");

				clientInfoJPanel.addClientInfoTab(clientInfo03);
			}
			this.mission1 = "1";
			// System.out.println("--**--");
			List<HashMap<String, String>> listComm = comm_pq.getResultList(
					this.policy_no, PoDetailQuery.COMMBASIC);
			for (HashMap<String, String> hsmap : listComm) {
				clientInfo04 = new ClientInfo04(hsmap);
				clientInfo04.setec_acct(pq.getEC_acct(this.client_id));
				clientInfo04.settwd_acct(pq.getRemit_acct(this.client_id, "0"));

				clientInfo04.setforeign_acct(pq.getRemit_acct(this.client_id,
						"1"));
				// SR130700054新增保戶失聯指示
				clientInfo04.setLost_ind(pq.getLost_ind(this.client_id));
				// SR140100176新增投資風險屬性
				clientInfo04.setRisk_suit_desc(pq.getRisk_suit_ind(client_id));
				// 新增fatca指示
				clientInfo04.setFatca_ind_desc(pq.getFatac_ind(client_id));
				// 新增還本註記指示
				clientInfo04.setR_psck_sw(pq.getPsckSw(client_id));
			}
			clientInfoJPanel.setValues(clientInfo04);
		}
	}

	@Override
	public void executeClearMission() {
		clientInfoJPanel.clearAll();
	}

	@Override
	public void executeNullMission() {
		clientInfoJPanel.nullAll();
	}

	@Override
	public String getOldPolicy_no() {
		// TODO Auto-generated method stub
		return policy_no;
	}

	@Override
	public JPanel getPanel() {
		// TODO Auto-generated method stub
		return clientInfoJPanel;
	}

	@Override
	public boolean isControllable() {
		// TODO Auto-generated method stub
		if (focus_ind.equals("0"))
			return false;
		else {
			return true;
		}
	}

	@Override
	public void setPolicyInfo(String[] policy_info) {
		// TODO Auto-generated method stub
		this.policy_info = policy_info;
	}

}
