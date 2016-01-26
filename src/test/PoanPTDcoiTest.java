/**
 * 
 */
package test;

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

import query.model.PoDetail.PoDetailQuery;
import query.model.PoValueAddShare.PoValueAddShareQuery;
import database.connection.DBConnection;

/**
 * @author F1256819
 * 
 */
@RunWith(value = Parameterized.class)
public class PoanPTDcoiTest {
	private String policy_no;

	public PoanPTDcoiTest(String policy_no) {
		this.policy_no = policy_no;
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		DBConnection.connect("mis", "fool01", DBConnection.DBSERVER);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		policy_no = null;
		DBConnection.closeCon();
	}

	@Test
	public void test() {
		PoDetailQuery pq = new PoDetailQuery();
		List<HashMap<String, String>> list = pq.getResultList(policy_no,
				PoDetailQuery.PODETAIL_A);
		assertTrue(list.get(0).get("r_paid_to_date_coi").length() > 0);
	}

	@Parameters
	public static Collection<String[]> data() {
		DBConnection.connect("mis", "fool01", DBConnection.DBSERVER);
		Statement st = DBConnection.createStatement();
		PoValueAddShareQuery pq = new PoValueAddShareQuery();

		List<HashMap<String, String>> resultlist = DBConnection
				.getResultList(DBConnection.executeQuery(st,
						"select first 50 distinct policy_no from poan"));
		ArrayList<String[]> result = new ArrayList<String[]>();
		for (HashMap<String, String> hmp : resultlist) {
			String[] tmp = { hmp.get("policy_no") };
			result.add(tmp);
		}
		DBConnection.closeStatement(st);
		return result;
	}

}
