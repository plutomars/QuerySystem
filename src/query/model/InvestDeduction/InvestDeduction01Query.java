package query.model.InvestDeduction;

/**
 * @author swei
 * 
 * @version 1.0<br>
 *          101/03/28<br>
 *          �����_�C�릩���B(QUERY)
 * @since 1.0
 */
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;

import database.connection.DBConnection;
import query.model.AbstractModelObject;

public class InvestDeduction01Query extends AbstractModelObject {
	public final static int MonthlyD01 = 1; // [�D�e������]
	public final static int MonthlyD02 = 1; // [���ީ���]

	public List<HashMap<String, String>> getResultList(String policy_no,
			int Type) {
		Statement st = DBConnection.createStatement();
		List<HashMap<String, String>> list = null;

		if (Type == InvestDeduction01Query.MonthlyD01) // --<�D�d��>
		{
			list = DBConnection.getResultList(DBConnection.executeQuery(st,
					"execute procedure cc153i('" + policy_no + "')"));
		}
		DBConnection.closeStatement(st);
		return list;

	}

	// [���޲Ӷ�]
	public List<HashMap<String, String>> getResultList(String policy_no,
			String paid_to_date, String seq_no, int Type) {
		Statement st2 = DBConnection.createStatement();
		List<HashMap<String, String>> list2 = null;

		if (Type == InvestDeduction01Query.MonthlyD02) // --<�D�d��>
		{
			list2 = DBConnection.getResultList(DBConnection.executeQuery(st2,
					"execute procedure cc154i('" + policy_no + "','"
							+ paid_to_date + "','" + seq_no + "')"));
		}

		DBConnection.closeStatement(st2);
		return list2;

	}

}
