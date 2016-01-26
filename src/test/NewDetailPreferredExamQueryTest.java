/**
 * 
 */
package test;

import static org.junit.Assert.*;

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

import query.model.Query;
import query.model.QueryPolicyQuery;
import query.model.NewDetail.NewDetailPreferredExamQuery;
import database.connection.DBConnection;
import database.connection.DBLiteConnection;

/**
 * @author F1256819
 * @category �����魫�令float �ҥH�|�y���u��O�歶�ҭp��BMI��parseInt���~
 *           �D�{���令�����魫��Number���N�å�double�p��
 */
@RunWith(value = Parameterized.class)
public class NewDetailPreferredExamQueryTest {
	private String policy_no;
	private List<HashMap<String, String>> dataList;
	private NewDetailPreferredExamQuery dataQuery;

	public NewDetailPreferredExamQueryTest(String policy_no) {
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
						"SELECT first 50 distinct a.policy_no"
								+ " FROM nbxv a,nbxc b,nbux c "
								+ "WHERE a.exam_item_code = b.exam_item_code "
								+ "AND a.exam_item_code = c.exam_item_code;"));
		ArrayList<String[]> result = new ArrayList<String[]>();
		for (HashMap<String, String> hmp : resultlist) {
			String[] tmp = { hmp.get("policy_no") };
			result.add(tmp);
		}
		return result;
	}

	/**
	 * @category ���լO�_�i���T�p��bmi
	 */
	@Test
	public void test() {
		DBConnection.connect("mis", "fool01", DBConnection.DBSERVER);
		dataQuery = new NewDetailPreferredExamQuery();
		QueryPolicyQuery qq = new QueryPolicyQuery();
		qq.getResultList(policy_no, QueryPolicyQuery.POLICY_NO);
		dataList = dataQuery.getResultList(policy_no, Query.NOTYPE);
		if (dataList.size() > 0) {
			assertTrue(Double
					.parseDouble(dataList.get(0).get("bmi").toString()) > 0);
		} else
			fail("fail po:" + policy_no);

	}

}
