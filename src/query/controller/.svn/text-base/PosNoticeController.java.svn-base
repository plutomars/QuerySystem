package query.controller;

import java.util.HashMap;
import java.util.List;

import javax.swing.JPanel;

import query.model.PosNotice.PosNotice01;
import query.model.PosNotice.PosNotice02;
import query.model.PosNotice.PosNotice04;
import query.model.PosNotice.PosNotice03;
import query.model.PosNotice.PosNotice05;
import query.model.PosNotice.PosNoticeQuery;
import query.view.PosNoticeJPanel;
/**
 * 
 * @author cychu
 *
 * @version 1.0<br/>
 * 			100/09/07<br/>
 * 			照會記錄(Controller)
 * 
 * @since 1.0
 */
public class PosNoticeController extends DataControl {
	private String policy_no;
	private String po_chg_rece_no = "";
	private String notice_seq = "";
	private String policy_info[];
	private PosNoticeJPanel posNoticePanel;
	private PosNoticeQuery pq = new PosNoticeQuery();
	
	public PosNoticeController(){
		posNoticePanel = new PosNoticeJPanel();
		posNoticePanel.setController(this);
	}

	@Override
	public void executeMission() {
		this.policy_no = policy_info[0];
		executeInnerMission(policy_no, po_chg_rece_no, notice_seq);
	}
	
	public void executeInnerMission(String policy_no,
									String po_chg_rece_no,String notice_seq){
		this.policy_no = policy_info[0];
		//清除VerticalPane欄位資料
		posNoticePanel.clearVPane();
		// 塞入照會繳費欄位資料
		posNoticePanel.clearPosNotice01s();
		List<HashMap<String, String>> list01 = setErrResultInd(pq.getResultList(policy_no,
				po_chg_rece_no, notice_seq, PosNoticeQuery.POSNOTICE01),"cc140i");
		for (HashMap<String, String> hsmap1 : list01) {
			PosNotice01 posNotice01 = new PosNotice01(hsmap1);
			posNoticePanel.addPosNotice01(posNotice01);
			posNoticePanel.setReceField(posNotice01.getPo_chg_rece_no());
			posNoticePanel.setSeqField(posNotice01.getNotice_seq());
			posNoticePanel.insertValue();
		}
		// 塞入照會記錄欄位資料
		posNoticePanel.clearPosNotice02s();
		List<HashMap<String, String>> list02 = setErrResultInd(pq.getResultList(policy_no,
				po_chg_rece_no, notice_seq, PosNoticeQuery.POSNOTICE02),"cc141i");
		for (HashMap<String, String> hsmap2 : list02) {
			PosNotice02 posNotice02 = new PosNotice02(hsmap2);
			posNoticePanel.addPosNotice02(posNotice02);
		}
		// 塞入體檢原因欄位資料
		posNoticePanel.clearPosNotice03s();
		List<HashMap<String, String>> list03 = setErrResultInd(pq.getResultList(policy_no,
				po_chg_rece_no, notice_seq, PosNoticeQuery.POSNOTICE03),"cc143i");
		for (HashMap<String, String> hsmap3 : list03) {
			PosNotice03 posNotice03 = new PosNotice03(hsmap3);
			posNoticePanel.addPosNotice03(posNotice03);
		}
		// 塞入照會項目欄位資料
		posNoticePanel.clearPosNotice04s();
		List<HashMap<String, String>> list04 = setErrResultInd(pq.getResultList(policy_no,
				po_chg_rece_no, notice_seq, PosNoticeQuery.POSNOTICE04),"cc142i");
		for (HashMap<String, String> hsmap4 : list04) {
			PosNotice04 posNotice04 = new PosNotice04(hsmap4);
			posNoticePanel.addPosNotice04(posNotice04);
		}
		// 塞入體檢項目欄位資料
		posNoticePanel.clearPosNotice05s();
		List<HashMap<String, String>> list05 = setErrResultInd(pq.getResultList(policy_no,
				po_chg_rece_no, notice_seq, PosNoticeQuery.POSNOTICE05),"cc144i");
		for (HashMap<String, String> hsmap5 : list05) {
			PosNotice05 posNotice05 = new PosNotice05(hsmap5);
			posNoticePanel.addPosNotice05(posNotice05);
		}
		showMessageDialog(posNoticePanel, "照會記錄查詢", "保單不符或無資料");
	}
	
	@Override
	public String getOldPolicy_no() {
		return policy_no;
	}

	@Override
	public JPanel getPanel() {
		return posNoticePanel;
	}

	@Override
	public boolean isControllable() {
		return true;
	}

	@Override
	public void setPolicyInfo(String[] policy_info) {
		this.policy_info = policy_info;
		this.po_chg_rece_no = "";
		this.notice_seq = "";
		posNoticePanel.setReceField("");
		posNoticePanel.setSeqField("");
	}
	
	public void executeClearMission() {
		posNoticePanel.clearAll();
	}

	@Override
	public void executeNullMission() {
		posNoticePanel.nullAll();
	}
}
