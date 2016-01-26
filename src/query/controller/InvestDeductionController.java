package query.controller;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;

import javax.swing.JPanel;

import query.model.InvestDeduction.InvestDeduction01;
import query.model.InvestDeduction.InvestDeduction01Query;
import query.model.InvestDeduction.InvestDeduction02;
import query.view.InvestDeductionJPanel;
import database.connection.DBConnection;

/**
 * 
 * @author swei
 * 
 * @version 1.0 �C�馩���B(Controller)
 * 
 * @since 1.0
 * @version 1.1 �ק�����ƨS���ɦA�P�_�I�إXĵ�ܰT��
 */

public class InvestDeductionController extends DataControl {
	private String policy_info[];
	public String policy_no = "";
	public String paid_to_date = "";
	public String seq_no = "";
	private InvestDeductionJPanel monthlydeduction01Panel;

	public InvestDeductionController() {
		monthlydeduction01Panel = new InvestDeductionJPanel();
		monthlydeduction01Panel.setController(this);
	}

	@Override
	public void executeMission() {
		// TODO Auto-generated method stub
		this.policy_no = policy_info[0];
		monthlydeduction01Panel.clearAll(); // �M�ť������

		InvestDeduction01Query rq = new InvestDeduction01Query();
		// store procedure�u��vcoid�����B���
		// �A�G�אּ��resultset���S����ơA�S�����ܦA�P�_�O�_���������B���~���I��
		// �A�Y���O�������B���I�ثh�[�Jresult_ind <> '0'
		List<HashMap<String, String>> list = setErrResultInd(
				rq.getResultList(policy_no, InvestDeduction01Query.MonthlyD01),
				"cc153i");
		// ��ܵL��ơA�}�l��month_beg_ind
		if (list.size() == 0) {
			Statement statement = DBConnection.createLiteStatement();
			List<HashMap<String, String>> tmplist = DBConnection
					.getResultList(DBConnection.executeQuery(statement,
							"select basic_plan_code from jpolf where policy_no='"
									+ policy_no + "'"));
			DBConnection.closeStatement(statement);
			String basic_plan_code = tmplist.get(0).get("basic_plan_code");
			if (basic_plan_code.length() > 0) {
				PreparedStatement stmt = DBConnection
						.createPreparedStatement("select month_beg_ind from pldf where plan_code = '"
								+ basic_plan_code + "'");
				tmplist = DBConnection.getResultList(DBConnection
						.executeQuery(stmt));
				DBConnection.closeStatement(stmt);
				if (tmplist.get(0).get("month_beg_ind").equals("0")) {
					HashMap<String, String> temp = new HashMap<String, String>();
					temp.put("r_result_ind", "-100");
					list.add(temp);
				}
			}
		}
		list = setErrResultInd(list, "�����B����0");

		for (HashMap<String, String> hsmap : list) {
			InvestDeduction01 monthlydeduction01 = new InvestDeduction01(hsmap);
			monthlydeduction01Panel.addMonthlyDeduction01(monthlydeduction01);
		}
		monthlydeduction01Panel.setDefaultRow();
		if (this.isErr) {
			monthlydeduction01Panel.clearAll();
		}
		showMessageDialog(monthlydeduction01Panel, "�C�릩���B�d�� ", "���I�صL�C�릩���B���");

	}

	// [���޲Ӷ�]
	public void executeMission(String policy_no, String paid_to_date,
			String seq_no) {
		// TODO Auto-generated method stub
		this.policy_no = policy_no;
		this.paid_to_date = paid_to_date;
		this.seq_no = seq_no;

		InvestDeduction01Query rq = new InvestDeduction01Query();
		List<HashMap<String, String>> list2 = setErrResultInd(rq.getResultList(
				policy_no, paid_to_date, seq_no,
				InvestDeduction01Query.MonthlyD02), "cc154i");

		monthlydeduction01Panel.clearMonthlyDeduction02s();
		for (HashMap<String, String> hsmap : list2) {
			InvestDeduction02 monthlydeduction02 = new InvestDeduction02(hsmap);
			monthlydeduction01Panel.addMonthlyDeduction02(monthlydeduction02);
		}
		showMessageDialog(monthlydeduction01Panel, "�C�릩���B���� ", "���I�صL�C�릩���B���");
	}

	@Override
	public void executeClearMission() {
		// TODO Auto-generated method stub
		monthlydeduction01Panel.clearAll();
	}

	@Override
	public void executeNullMission() {
		// TODO Auto-generated method stub
		monthlydeduction01Panel.nullAll();
	}

	@Override
	public String getOldPolicy_no() {
		// TODO Auto-generated method stub
		// return null;
		return policy_no;
	}

	@Override
	public JPanel getPanel() {
		// TODO Auto-generated method stub
		return monthlydeduction01Panel;
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
