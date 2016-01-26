package query.model.ClaimHistory;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;

import query.model.Query;
import database.connection.DBConnection;

/**
 * 
 * @author fyyang
 * 
 */
public class ClaimHistoryQuery implements Query {
	public final static int CLAIMHISTORY = 1;
	public final static int NEWCLAIMHISTORY = 11;
	public final static int CLAIMDETAIL = 2; // �򥻸��
	public final static int BENIFIT = 3;
	public final static int CC174I = 4;
	public final static int DETAILITEM = 5;
	public final static int HOSPITAL = 6;     // �N�E��|
	public final static int RELEASE = 7;      // �w��w�M����
	public final static int HOSPIMARK = 8;    // ��|���O
	public final static int BENFADDR = 9;     // ���q�H�a�}
	public final static int CLAIMMARK = 10;   // �z�ߵ��O
	public final static int BENFACCTE = 11;   // ���q�H�~���b�� 101/03/26 new by jnd115
	public final static int DISPCLED = 12;    // �a�˸p������� 101/04/18 new by jnd115
	public final static int CLAIMEVENT = 13;  // �ƬG�N�X  101/06/21 new by cora
	public final static int HOSDETAILS = 14;  // �N�E���� 101/06/19 new by swei
	
	private String insured; // cc170i�ϥ�
	
	@Override
	public List<HashMap<String, String>> getResultList(String policy_no,
			int type) {
		// TODO Auto-generated method stub
		Statement st = DBConnection.createStatement();
		List<HashMap<String, String>> list = null;

		if (type == ClaimHistoryQuery.CLAIMHISTORY)
			list = DBConnection.getResultList(DBConnection.executeQuery(st,
					"execute procedure cc170i('" + policy_no + "')"));
		if (type == ClaimHistoryQuery.NEWCLAIMHISTORY) // �s������
			list = DBConnection.getResultList(DBConnection.executeQuery(st,
					"execute procedure cc170i('" + policy_no + "','I')"));
		else if (type == ClaimHistoryQuery.HOSPIMARK)
			list = DBConnection.getResultList(DBConnection.executeQuery(st,
					"SELECT *,0 r_result_ind FROM hicm WHERE hi_hospital_id = '"
							+ policy_no + "' ORDER BY hicm_seq ASC;"));

		DBConnection.closeStatement(st);
		return list;
	}

	public List<HashMap<String, String>> getResultList(String policy_no,
			String insured_id,int type) {
		Statement st = DBConnection.createStatement();
		List<HashMap<String, String>> list = null;

		if (type == ClaimHistoryQuery.CLAIMHISTORY)
			list = DBConnection.getResultList(DBConnection.executeQuery(st,
					"execute procedure cc170i('" + policy_no + "','" + insured_id + "')"));

		DBConnection.closeStatement(st);
		return list;
	}
	
	//�N�E����
	//getResultList2(policy_no, claim_seq,query.model.ClaimHistory.ClaimHistoryQuery.HOSDETAILS,claim_year,clhn_seq)
	public List<HashMap<String, String>> getResultList2(String policy_no,
														String claim_seq,
														String claim_year,
														String clhn_seq){
		
		  
//		  List<HashMap<String, String>> list2 = null;
//		  PreparedStatement ps2 = null;
//		  ps2 = DBConnection.createPreparedStatement(  " select clhn_seq "
//													  +" from clhn "
//													  +" where policy_no = '"+ policy_no+ "' "
//													  +" AND claim_seq = '"+ claim_seq+ "'   "
//													  +" AND claim_year = '"+ claim_year+ "' ");
//		  
//		  list2 = DBConnection.getResultList(DBConnection.executeQuery(ps2));
//		  String f_clhn_seq1 = list2.get(0).get("clhn_seq").trim();
		 
		  
		    // ADD 102.06.20 �s�W�N�E����
		   List<HashMap<String, String>> list = null;
			PreparedStatement ps = null;
			ps = DBConnection.createPreparedStatement(  
							  " select "
							+ " a.desc  ,                         " //����
							+ " b.beg_date,                       "
							+ " b.beg_time,                       "
							+ " b.end_date,                       "
							+ " b.end_time,                       " 
							+ " b.clhd_day,                       "
							+ " b.clhd_hour,                      "
							+ " b.times                           "
							+ " from clhc a,clhd b                "
							+ " where a.clhd_code = b.clhd_code   "
							+ " and b.policy_no  = '"+ policy_no  + "' "
							+ " and b.claim_seq  = '"+ claim_seq  + "' "
							+ " and b.claim_year = '"+ claim_year + "' "
							+ " and b.clhn_seq   = '"+ clhn_seq+ "' "
							);

			list = DBConnection.getResultList(DBConnection.executeQuery(ps));
//			System.out.println("����:"+list.size());
//			System.out.println("�O��:"+policy_no);
//			System.out.println("�Ǹ�:"+claim_seq);
//			System.out.println("�~��:"+claim_year);
//			System.out.println("�Ǹ�:"+f_clhn_seq1);
//			System.out.println("�^��:"+list);
//			System.out.println("----->:"+clhn_seq);
		
			
		return list;
	}

	public List<HashMap<String, String>> getResultList(String policy_no,
			String claim_seq, int type,String claim_year) {
		Statement st = DBConnection.createStatement();
		List<HashMap<String, String>> list = null;
		

		
		if (type == ClaimHistoryQuery.CLAIMHISTORY)
			{this.insured = claim_seq;
			list = DBConnection.getResultList(DBConnection.executeQuery(st,
					"execute procedure cc170i('" + policy_no + "','" + this.insured + "','"+ claim_year+ "')"));
			}
		else if (type == ClaimHistoryQuery.CLAIMEVENT)
		{
			list = DBConnection.getResultList(DBConnection.executeQuery(st,
					"execute procedure cc178i('" + policy_no + "','"
							+ claim_seq + "','"+ claim_year+ "')"));
		}	
		else if (type == ClaimHistoryQuery.CLAIMDETAIL)
			list = DBConnection.getResultList(DBConnection.executeQuery(st,
					"execute procedure cc171i('" + policy_no + "','"
							+ claim_seq + "','"+ claim_year+ "')"));
		
		else if (type == ClaimHistoryQuery.BENIFIT)
			list = DBConnection.getResultList(DBConnection.executeQuery(st,
					"execute procedure cc175i('" + policy_no + "','"
							+ claim_seq + "','"+ claim_year+ "')"));
		
		// �N�E��|  T0722208
		else if (type == ClaimHistoryQuery.HOSPITAL)
			list = DBConnection.getResultList(DBConnection.executeQuery(st,
					"execute procedure cc179i('" + policy_no + "','"
							+ claim_seq + "','"+ claim_year+ "')"));
		
  
			
//System.out.println("execute procedure cc179i('" + policy_no + "','"
//					+ claim_seq + "','"+ claim_year+ "')");
//			PreparedStatement ps = null;
//			ps = DBConnection
//					.createPreparedStatement("SELECT "
//							+ " a.hi_hospital_id, b.hi_hospital_name,'Y' remark,"
//							+ " cl_hs_date_1,cl_hs_date_2,"
//							+ " c.clmd_code,c.clmd_desc,a.doctor_name,a.doctor_id,"
//							+ "        0 r_result_ind"
//							+ " FROM clhp a, hihp b, outer clmd c"
//							+ " WHERE a.hi_hospital_id=b.hi_hospital_id"
//							+ " AND a.clmd_code = c.clmd_code"
//							+ " AND a.policy_no = ?"
//							+ " AND a.claim_seq = ?"
//							+ " AND (SELECT COUNT(*) FROM hicm"
//							+ " WHERE hi_hospital_id = a.hi_hospital_id)>0"
//							+ " UNION       "
//							+ " SELECT a.hi_hospital_id, b.hi_hospital_name,'N' remark,"
//							+ " cl_hs_date_1,cl_hs_date_2,"
//							+ " c.clmd_code,c.clmd_desc,a.doctor_name,a.doctor_id,"
//							+ "        0 r_result_ind"
//							+ " FROM clhp a, hihp b, outer clmd c"
//							+ " WHERE a.hi_hospital_id=b.hi_hospital_id"
//							+ " AND a.clmd_code = c.clmd_code"
//							+ " AND a.policy_no = ?    "
//							+ " AND a.claim_seq = ?    "
//							+ " AND (SELECT COUNT(*) FROM hicm"
//							+ " WHERE hi_hospital_id = a.hi_hospital_id)=0 ORDER BY 4 DESC,1");
//			int j = 1;
//			for (int i = 0; i < 2; i++) {
//				DBConnection.setPreparedStatementString(ps, j++, policy_no);
//				DBConnection.setPreparedStatementString(ps, j++, claim_seq);
//			}
//			list = DBConnection.getResultList(DBConnection.executeQuery(ps));
			  
		
		
	
		
		// �w��w�M����
		else if (type == ClaimHistoryQuery.RELEASE) {
			PreparedStatement ps = null;
			ps = DBConnection
					.createPreparedStatement("SELECT "
							+ " a.hi_hospital_id, b.hi_hospital_name,'Y' remark,"
							+ " cl_hs_date_1,cl_hs_date_2,"
							+ "        0 r_result_ind"
							+ " FROM clho a, hihp b"
							+ " WHERE a.hi_hospital_id=b.hi_hospital_id"
							+ " AND a.policy_no = ?"
							+ " AND a.claim_seq = ?"
							+ " AND (SELECT COUNT(*) FROM hicm"
							+ " WHERE hi_hospital_id = a.hi_hospital_id)>0"
							+ " UNION       "
							+ " SELECT a.hi_hospital_id, b.hi_hospital_name,'N' remark,"
							+ " cl_hs_date_1,cl_hs_date_2,"
							+ "        0 r_result_ind" + " FROM clho a, hihp b"
							+ " WHERE a.hi_hospital_id=b.hi_hospital_id"
							+ " AND a.policy_no = ?    "
							+ " AND a.claim_seq = ?    "
							+ " AND (SELECT COUNT(*) FROM hicm"
							+ " WHERE hi_hospital_id = a.hi_hospital_id)=0");
			int j = 1;
			for (int i = 0; i < 2; i++) {
				DBConnection.setPreparedStatementString(ps, j++, policy_no);
				DBConnection.setPreparedStatementString(ps, j++, claim_seq);
			}
			list = DBConnection.getResultList(DBConnection.executeQuery(ps));
		}
		// �z�ߵ��O
		else if (type == ClaimHistoryQuery.CLAIMMARK) {
			PreparedStatement ps = null;
			ps = DBConnection.createPreparedStatement("SELECT    "
					+ " b.cl_comment_code,b.cl_comment_desc,     "
					+ " 0 r_result_ind                           "
					+ " FROM clcm a, outer clci b                "
					+ " WHERE a.policy_no = ?                    "
					+ " AND   a.claim_seq   = ?                  "
					+ " AND a.cl_comment_code = b.cl_comment_code");

			DBConnection.setPreparedStatementString(ps, 1, policy_no);
			DBConnection.setPreparedStatementString(ps, 2, claim_seq);
			list = DBConnection.getResultList(DBConnection.executeQuery(ps));
		}
		DBConnection.closeStatement(st);
		
		return list;
	}

	@SuppressWarnings("null")
	public List<HashMap<String, String>> getResultList(String policy_no,
			String claim_seq, String type_code, int type) {
		List<HashMap<String, String>> list = null;
		if (type == CC174I) {
			String cl_examine_code = type_code;
			Statement st = DBConnection.createStatement();
			list = DBConnection.getResultList(DBConnection.executeQuery(st,
					"execute procedure cc174i('" + policy_no + "','"
							+ claim_seq + "','" + cl_examine_code + "')"));
			DBConnection.closeStatement(st);
		}
		// �z�߶��ة���
		else if (type == DETAILITEM) {
			String coverage_no = type_code;
			PreparedStatement ps = null;
			ps = DBConnection
					.createPreparedStatement("SELECT '���j�N�S�˫O�I��' claim_item,"
							+ "       b.cl_burn_code claim_code ,"
							+ "       b.cl_burn_desc claim_desc ,"
							+ "       b.cl_burn_level||'' claim_level1,"
							+ "       '' claim_level2,"
							+ "        0 r_result_ind,"
							+ "       '' claim_desc2,"
							+ "       '' claim_desc3"
							+ " FROM clbi a,clbr b"
							+ " WHERE a.cl_burn_code = b.cl_burn_code"
							+ " AND   a.policy_no = ?"
							+ " AND   a.claim_seq = ?"
							+ " AND   a.coverage_no = ?"
							+ " UNION"
							+ " SELECT '��N' claim_item,"
							+ "       b.cl_surg_item claim_code,"
							+ "       b.cl_surg_desc_1 claim_desc,"
							+ "       b.suit_desc_1 || b.suit_desc_2 || b.suit_desc_3 claim_level1,"
							+ "       tranCurr(b.cl_multiple,2)||'' claim_level2,"
							+ "        0 r_result_ind,"
							+ "       b.cl_surg_desc_2 claim_desc2,"
							+ "       b.cl_surg_desc_3 claim_desc3"
							+ " FROM   cldl a, clis b"
							+ " WHERE  a.cl_surg_item = b.cl_surg_item"
							+ " AND    a.policy_no = ?"
							+ " AND    a.claim_seq = ?"
							+ " AND    a.coverage_no = ?"
							+ " UNION                   "
							+ " SELECT '�ݼo�O�I��' claim_item,"
							+ "       b.cl_deform_code_n claim_code,"
							+ "       b.cl_deform_desc_n claim_desc,"
							+ "       b.cl_deform_perc||'' claim_level1,"
							+ "       b.cl_deform_level||'' claim_level2,"
							+ "        0 r_result_ind,"
							+ "       '' claim_desc2,"
							+ "       '' claim_desc3"
							+ " FROM    cldi a,cldr b"
							+ " WHERE  a.cl_deform_code_n = b.cl_deform_code_n"
							+ " AND    a.policy_no = ?"
							+ " AND    a.claim_seq = ?"
							+ " AND    a.coverage_no = ?"
							+ " UNION                   "
							+ " SELECT '�ݼo�O�I��' claim_item,"
							+ "       b.cl_deform_code claim_code,"
							+ "       b.cl_deform_desc claim_desc,"
							+ "       b.cl_deform_perc||'' claim_level1,"
							+ "       '' claim_level2,"
							+ "        0 r_result_ind,"
							+ "       '' claim_desc2,"
							+ "       '' claim_desc3"
							+ " FROM    cldi a,cldm b"
							+ " WHERE  a.cl_deform_code_n = b.cl_deform_code"
							+ " AND    a.policy_no = ?"
							+ " AND    a.claim_seq = ?"
							+ " AND    a.coverage_no = ?"
							+ " UNION                   "
							+ " SELECT '����' claim_item,"
							+ "       b.cl_deform_code_n claim_code,"
							+ "       b.cl_deform_desc_n claim_desc,"
							+ "       b.cl_deform_perc||'' claim_level1,"
							+ "       b.cl_deform_level||'' claim_level2,"
							+ "        0 r_result_ind,"
							+ "       '' claim_desc2,"
							+ "       '' claim_desc3" + " FROM   cldc a,cldr b"
							+ " WHERE  a.cl_deform_code_n = b.cl_deform_code_n"
							+ " AND    a.policy_no = ?"
							+ " AND    a.claim_seq = ?"
							+ " AND    a.coverage_no = ?");
			int j = 1;
			for (int i = 0; i < 5; i++) {
				DBConnection.setPreparedStatementString(ps, j++, policy_no);
				DBConnection.setPreparedStatementString(ps, j++, claim_seq);
				DBConnection.setPreparedStatementString(ps, j++, coverage_no);
			}
			list = DBConnection.getResultList(DBConnection.executeQuery(ps));
			DBConnection.closeStatement(ps);
		}
		// ���q�H�a�}
		else if (type == ClaimHistoryQuery.BENFADDR) {
			String client_id = type_code;
			List<HashMap<String, String>> listB = null;
			PreparedStatement ps = null;
			ps = DBConnection.createPreparedStatement("SELECT "
					+ " zip_code,address,tel_1,hand_tel,   "
					+ " b.beg_date,b.end_date              "
					+ " FROM clba a,clbc b                 "
					+ " WHERE a.policy_no = ?              "
					+ " AND a.claim_seq   = ?              "
					+ " AND a.client_id   = ?              "
					+ " AND a.claim_seq   = b.claim_seq    "
					+ " AND a.policy_no   = b.policy_no    "
					+ " AND a.client_id   = b.client_id    ");

			DBConnection.setPreparedStatementString(ps, 1, policy_no);
			DBConnection.setPreparedStatementString(ps, 2, claim_seq);
			DBConnection.setPreparedStatementString(ps, 3, client_id);
			list = DBConnection.getResultList(DBConnection.executeQuery(ps));
			if (list.size()== 0 || (list.size()>0 && list.get(0).get("address").toString().trim().length()<5 )){
				ps = DBConnection.createPreparedStatement("SELECT "
						+ " zip_code,address   "
						+ " FROM ctmf a,addr b                 "
						+ " WHERE a.policy_no = ?              "
						+ " AND a.claim_seq   = ?              "
						+ " AND a.client_id   = ?              "
						+ " AND a.mail_addr_ind    = b.addr_ind"
						+ " AND a.client_id   = b.client_id    ");

				DBConnection.setPreparedStatementString(ps, 1, policy_no);
				DBConnection.setPreparedStatementString(ps, 2, claim_seq);
				DBConnection.setPreparedStatementString(ps, 3, client_id);
				listB = DBConnection.getResultList(DBConnection.executeQuery(ps));
				if (listB.size()>0){
				list = listB;//��list����,�|�ɭPlist.get(0)���ޤ���ȬG�s�W���q upd 107.07.29
				list.get(0).put("address", listB.get(0).get("address"));
				list.get(0).put("zip_code", listB.get(0).get("zip_code"));
				}
			}
				
		}
		// ���q�H�~���b�� 101/03/26 new by jnd115
		else if (type == ClaimHistoryQuery.BENFACCTE) {
			String client_id = type_code;
			Statement st = DBConnection.createStatement();
			list = DBConnection.getResultList(DBConnection.executeQuery(st,
					"execute procedure cc176i('" + policy_no + "','"
							+ claim_seq + "','" + client_id + "')"));
			DBConnection.closeStatement(st);
		}
		return list;
	}

	// �a�˸p������� 101/04/18 new by jnd115
	public List<HashMap<String, String>> getResultList(String policy_no,
			String claim_seq, String clpm_type, String claim_year, int type) {

		Statement st = DBConnection.createStatement();
		List<HashMap<String, String>> list = null;

		if (type == ClaimHistoryQuery.DISPCLED)
			list = DBConnection.getResultList(DBConnection.executeQuery(st,
					"execute procedure cc177i('" + policy_no + "','"
							+ claim_seq + "','" + clpm_type + "','"
							+ claim_year + "')"));

		DBConnection.closeStatement(st);
		return list;
	}

	public List<HashMap<String, String>> getResultList(String policy_no,
			String claim_seq, String event_date, String client_ident,
			String type,String client_id,String claim_year) {

		Statement st = DBConnection.createStatement();
		List<HashMap<String, String>> list = DBConnection
				.getResultList(DBConnection.executeQuery(st,
						"execute procedure cc172i('" + policy_no + "','"
								+ claim_seq + "','" + event_date + "','"
								+ client_ident + "','" + type+ "','" + client_id+ "','" +claim_year+ "')"));
		DBConnection.closeStatement(st);
		return list;
	}

	public List<HashMap<String, String>> getResultList(String policy_no,
			String claim_seq, String plan_code, String rate_scale,
			String co_issue_date, Integer coverage_no,String claim_year) {
//System.out.println("execute procedure cc173i('" + policy_no + "','"
//		+ claim_seq + "','" + plan_code + "','"
//		+ rate_scale + "','" + co_issue_date + "','"
//		+ coverage_no + "')");
		Statement st = DBConnection.createStatement();
		List<HashMap<String, String>> list = DBConnection
				.getResultList(DBConnection.executeQuery(st,
						"execute procedure cc173i('" + policy_no + "','"
								+ claim_seq + "','" + plan_code + "','"
								+ rate_scale + "','" + co_issue_date + "','"
								+ coverage_no + "','"+ claim_year+ "')"));
		DBConnection.closeStatement(st);
		return list;
	}
	
	public List<HashMap<String, String>> getResultList(String policy_no,
			String claim_seq, String plan_code, String rate_scale,
			String coverage_no,String claim_year) {
//System.out.println("execute procedure cc173i01('" + policy_no + "','"
//		+ claim_seq + "','" + plan_code + "','"
//		+ rate_scale + "','"
//		+ coverage_no+ "','"+ claim_year+ "')");
		Statement st = DBConnection.createStatement();
		List<HashMap<String, String>> list = DBConnection
				.getResultList(DBConnection.executeQuery(st,
						"execute procedure cc173i01('" + policy_no + "','"
								+ claim_seq + "','" + plan_code + "','"
								+ rate_scale + "','" 
								+ coverage_no + "','"+ claim_year+ "')"));
		DBConnection.closeStatement(st);
//System.out.println("item="+list.get(0).get("r_claim_item"));		
		return list;
	}
}
