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

import query.model.ClientInfo.ClientInfoQuery;
import database.connection.DBConnection;

/**
 * @author F1256819
 * @category 保戶失聯測試
 */
@RunWith(value = Parameterized.class)
public class ClientInfo4test {
	private String client_id;

	public ClientInfo4test(String client_id) {
		this.client_id = client_id;
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		DBConnection.connect("mis", "fool01", DBConnection.DBSERVER);
	}

	/**
	 * @category 幾個確定失聯的保戶測試
	 * @return
	 */
	@Parameters
	public static Collection<String[]> data() {
		DBConnection.connect("mis", "fool01", DBConnection.DBSERVER);
		Statement st = DBConnection.createStatement();
		ClientInfoQuery cq = new ClientInfoQuery();

		List<HashMap<String, String>> resultlist = DBConnection
				.getResultList(DBConnection.executeQuery(st, "select client_id from aaqc where lost_ind = 'Y'"));
		ArrayList<String[]> result = new ArrayList<String[]>();
		for (HashMap<String, String> hmp : resultlist) {
			String[] tmp = { hmp.get("client_id") };
			result.add(tmp);
		}
		DBConnection.closeStatement(st);
		return result;
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		client_id = null;
		DBConnection.closeCon();
	}

	/**
	 * Test method for
	 * {@link query.model.ClientInfo.ClientInfoQuery#getLost_ind(java.lang.String)}
	 * .
	 */

	@Test
	public void testGetLost_ind() {
		// Statement st = DBConnection.createStatement();
		ClientInfoQuery cq = new ClientInfoQuery();

		assertEquals("Y", cq.getLost_ind(client_id));

	}

}
