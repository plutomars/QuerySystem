/**
 * 
 */
package test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

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

import query.model.PoValueAddShare.PoValueAddShareQuery;
import sqlj.runtime.profile.util.CustomizerHarness.Log;
import database.connection.DBConnection;

/**
 * @author F1256819
 * 
 */
@RunWith(value = Parameterized.class)
public class PoValueAddShareTest {
	private String policy_no;

	public PoValueAddShareTest(String policy_no) {
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
		DBConnection.connect("mis", "fool01", DBConnection.DBSERVER);
		Statement st = DBConnection.createStatement();
		List<HashMap<String, String>> countlist = DBConnection
				.getResultList(DBConnection.executeQuery(st,
						"select count(*) from psil where policy_no='"
								+ policy_no + "' and psil_code <> 'M0'"));
		int i = Integer.parseInt(countlist.get(0).get("(count(*))"));
		PoValueAddShareQuery pq = new PoValueAddShareQuery();
		List<HashMap<String, String>> list = pq.getResultList(policy_no, 1);
		assertTrue(list.size() > 0);
		List<HashMap<String, String>> list2 = pq.getResultList(policy_no, 2);
		if (list2.size() == 0 && i != 0)
			fail("policy_no:" + policy_no);

		List<HashMap<String, String>> list3 = pq.getResultList(policy_no, 3);
		assertTrue(list3.size() > 0);
	}

	@Test
	public void testThisInt() {
		DBConnection.connect("mis", "fool01", DBConnection.DBSERVER);
		Statement st = DBConnection.createStatement();
		List<HashMap<String, String>> countlist = DBConnection
				.getResultList(DBConnection.executeQuery(st,
						"select count(*) from psil where policy_no='"
								+ policy_no + "' and psil_code <> 'M0'"));
		int i = Integer.parseInt(countlist.get(0).get("(count(*))"));

		PoValueAddShareQuery pq = new PoValueAddShareQuery();
		List<HashMap<String, String>> list = pq.getResultList(policy_no, 1);
		assertTrue(list.get(0).get("r_this_int").toString().length() > 0);
		List<HashMap<String, String>> list2 = pq.getResultList(policy_no, 2);
		if (list2.size() == 0 && i != 0)
			assertTrue(list2.get(0).get("r_this_int").toString().length() > 0);				
			
	}

	@Test
	public void testResultInd() {
		PoValueAddShareQuery pq = new PoValueAddShareQuery();
		List<HashMap<String, String>> list = pq.getResultList(policy_no, 1);
		assertTrue(list.get(0).get("r_result_ind").toString().equals("0"));
	}

	@Parameters
	public static Collection<String[]> data() {

		DBConnection.connect("mis", "fool01", DBConnection.DBSERVER);
		Statement st = DBConnection.createStatement();
		PoValueAddShareQuery pq = new PoValueAddShareQuery();

		List<HashMap<String, String>> resultlist = DBConnection
				.getResultList(DBConnection.executeQuery(st,
						"select first 50 distinct policy_no from psil"));
		ArrayList<String[]> result = new ArrayList<String[]>();
		for (HashMap<String, String> hmp : resultlist) {
			String[] tmp = { hmp.get("policy_no") };
			result.add(tmp);
		}
		DBConnection.closeStatement(st);
		return result;
	}
}
