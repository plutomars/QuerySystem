/**
 * 
 */
package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import query.model.ValueRepay.ValueRepayQuery02;
import database.connection.DBConnection;
import database.connection.DBLiteConnection;

/**
 * @author F1256819
 * 
 */
@RunWith(value = Parameterized.class)
public class ValueReapayQueryTest {
	private String policy_no;
	private String cp_anniv_date;
	private List<HashMap<String, String>> dataList;
	private ValueRepayQuery02 dataQuery;

	public ValueReapayQueryTest(String policy_no, String cp_anniv_date) {
		DBConnection.connect("mis", "fool01", DBConnection.DBSERVER);
		DBLiteConnection.connect();
		this.policy_no = policy_no;
		this.cp_anniv_date = cp_anniv_date;
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		DBConnection.connect("mis", "fool01", DBConnection.DBSERVER);
		DBLiteConnection.connect();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		policy_no = null;
		dataList = null;
		dataQuery = null;
		DBConnection.closeCon();
		DBLiteConnection.closeCon();
	}

	@Parameters
	public static Collection<String[]> data() {
		DBConnection.connect("mis", "fool01", DBConnection.DBSERVER);
		DBLiteConnection.connect();
		Statement st = DBConnection.createStatement();
		List<HashMap<String, String>> resultlist = DBConnection
				.getResultList(DBConnection
						.executeQuery(
								st,
								"SELECT first 50 distinct a.policy_no,a.cp_anniv_date"
										+ " FROM psck a,psc0 b"
										+ " WHERE a.nonresp_sw='Y' "+"and a.policy_no = b.policy_no"
										+ " and a.cp_anniv_date = b.cp_anniv_date;"));
		ArrayList<String[]> result = new ArrayList<String[]>();
		for (HashMap<String, String> hmp : resultlist) {
			String[] tmp = { hmp.get("policy_no"), hmp.get("cp_anniv_date") };
			result.add(tmp);
		}
		return result;
	}

	@Test
	public void testGetCpReturnDate() {
		DBConnection.connect("mis", "fool01", DBConnection.DBSERVER);
		dataQuery = new ValueRepayQuery02();
		assertTrue(dataQuery.getCpReturn_date(policy_no, cp_anniv_date)
				.length() > 0);
	}

	@Test
	public void testGetNonResp_sw() {
		DBConnection.connect("mis", "fool01", DBConnection.DBSERVER);
		dataQuery = new ValueRepayQuery02();
		assertEquals("¡¯", dataQuery.getNonresp_sw(policy_no, cp_anniv_date));
	}

}
