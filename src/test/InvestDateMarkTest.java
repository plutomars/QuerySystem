/**
 * 
 */
package test;

import static org.junit.Assert.assertEquals;

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
import sqlj.runtime.profile.util.CustomizerHarness.Log;
import database.connection.DBConnection;
import database.connection.DBLiteConnection;

/**
 * @author F1256819
 * 
 */
@RunWith(value = Parameterized.class)
public class InvestDateMarkTest {
	private String policy_no;
	private List<HashMap<String, String>> dataList;
	private PoDetailQuery dataQuery;

	public InvestDateMarkTest(String policy_no) {
		DBConnection.connect("mis", "fool01", DBConnection.DBSERVER);
		DBLiteConnection.connect();
		this.policy_no = policy_no;
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
				.getResultList(DBConnection.executeQuery(st,
						"SELECT first 50 distinct policy_no" + " FROM polf"
								+ " where substr(policy_no,1,1)='6'"
								+ " and invest_date_mark > '0'"));
		ArrayList<String[]> result = new ArrayList<String[]>();
		for (HashMap<String, String> hmp : resultlist) {
			String[] tmp = { hmp.get("policy_no") };
			result.add(tmp);
		}
		return result;
	}

	@Test
	public void testGet_invest_date_mark() {
		DBConnection.connect("mis", "fool01", DBConnection.DBSERVER);
		dataQuery = new PoDetailQuery();
		dataList = dataQuery.getResultList(policy_no, PoDetailQuery.PODETAIL_I);		
		assertEquals("Y", dataList.get(0).get("r_invest_date_mark"));
	}

}
