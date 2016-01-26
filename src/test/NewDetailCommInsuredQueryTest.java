/**
 * 
 */
package test;

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

import query.model.NewDetail.NewDetailCommInsuredQuery;
import database.connection.DBConnection;
import database.connection.DBLiteConnection;

/**
 * @author F1256819
 * @category 身高體重DB改成float
 * 
 */
@RunWith(value = Parameterized.class)
public class NewDetailCommInsuredQueryTest {
	private String policy_no;
	private List<HashMap<String, String>> dataList;
	private NewDetailCommInsuredQuery dataQuery;

	public NewDetailCommInsuredQueryTest(String policy_no) {
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

	@Parameters
	public static Collection<String[]> data() {
		DBConnection.connect("mis", "fool01", DBConnection.DBSERVER);
		Statement st = DBConnection.createStatement();
		List<HashMap<String, String>> resultlist = DBConnection
				.getResultList(DBConnection.executeQuery(st,
						"SELECT first 50 policy_no" + " FROM post"));
		ArrayList<String[]> result = new ArrayList<String[]>();
		for (HashMap<String, String> hmp : resultlist) {
			String[] tmp = { hmp.get("policy_no") };
			result.add(tmp);
		}
		return result;
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

	/**
	 * @category 測試是否抓取出來都是小數
	 */
	@Test(expected = NumberFormatException.class)
	public void test() {
		DBConnection.connect("mis", "fool01", DBConnection.DBSERVER);
		dataQuery = new NewDetailCommInsuredQuery();
		dataList = dataQuery.getResultList(policy_no);
		if (dataList.size() > 0) {
			Integer.parseInt(dataList.get(0).get("r_height").toString());
		} else
			fail("fail po:" + policy_no);
	}
	
}
