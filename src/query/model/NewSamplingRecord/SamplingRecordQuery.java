package query.model.NewSamplingRecord;

import java.sql.Statement;
import java.util.HashMap;
import java.util.List;

import database.connection.DBConnection;

public class SamplingRecordQuery  { //implements Query

	public final static int SAMPLING_RECORD = 1;
//	public final static int SAMPLING_RECORD_LIST = 2;
	public int exam_cnt, exam_max_cnt;
	public String r_immune;
	private String agent_code;
	
	
	public List<HashMap<String, String>> getResultList(String agent_code) {
		Statement st = DBConnection.createStatement();
		List<HashMap<String, String>> list = null;
		String cmd = null;
		//this.agent_code = agent_code; 
		list = DBConnection.getResultList(DBConnection.executeQuery(st,
	 			"execute procedure cc220i('" + agent_code + "')"));
		DBConnection.closeStatement(st);
	return list;
	}
	public String getAGname(String agent_code)
	{  
		Statement st = DBConnection.createStatement();
		List<HashMap<String, String>> list = null;
		list = DBConnection.getResultList(DBConnection.executeQuery(st,"SELECT names name FROM clnt WHERE client_id = '" + agent_code + "'"));
//		String agent_name = "";
        System.out.println(list.get(0).get("name"));
		return (list.get(0).get("name")== null) ? "" :list.get(0).get("name").trim();
	}
	
	}
	
	
	

//	private List<HashMap<String, String>> getOtherFileds(List<HashMap<String, String>> list, Statement st) {
//	
//		String f_cmd = null;
//		List<HashMap<String, String>> Qlist = null;
//		
//		//Statement st2 = DBConnection.createStatement();
//		
//		for (HashMap<String, String> hsmap : list) {
//			// 判斷是否豁免繳費 
//			// 業務員新契約抽檢檔最大的抽檢日期
//			Qlist = DBConnection.getResultList(DBConnection.executeQuery(
//					st,
//					"SELECT MAX(random_exam_date) random_exam_date"
//							+ "FROM mdra WHERE agent_code = '" + agent_code + "' "));
//
//			for (HashMap<String, String> Qhsmap : Qlist) {
//				// 如果抽檢日期有值則計算一年前日期
//				if (Qhsmap.get("random_exam_date").toString().equals("")
//						|| Qhsmap.get("random_exam_date") != null) {
//					Qlist = DBConnection
//							.getResultList(DBConnection
//									.executeQuery(st,
//											"execute procedure caculYMD( tdate(), 'Y', '-1')"));
//					String r_one_year_ago = Qlist.get(0).get("r_date").toString(); // 一年前的日期
//
//					// 計算完畢後，再利用今天日期減去最大抽檢日期，算出總共多少天
//					Qlist = DBConnection.getResultList(DBConnection
//							.executeQuery(st, "execute procedure diffDay( '"
//									+ Qhsmap.get("random_exam_date")+ "' , tdate()"));
//					String r_priord_days = Qlist.get(0).get(0).toString(); // 今天日期減去最大抽檢日期之天數
//
//					
//					f_cmd = " SELECT COUNT(disci_point) r_disci_cnt FROM aadi"
//							+ " WHERE agent_code = '"
//							+ hsmap.get("r_agent_code") + "' "
//							+ " AND disci_class MATCHES '[12BHQAEFGIJPRST]' "
//							+ " AND occur_date >= '" + r_one_year_ago + "' ";
//					Qlist = DBConnection.getResultList(DBConnection
//							.executeQuery(st, f_cmd));
//					
//					for (HashMap<String, String> Shsmap : Qlist) {
//										
//						if (Integer.parseInt(r_priord_days) > 90
//								|| Integer.parseInt(Shsmap.get("r_disci_cnt").toString()) > 0)
//							hsmap.put("r_immune", "N");
//						else
//							hsmap.put("r_immune", "Y");
//					}
//				}
//
//				else
//					hsmap.put("r_immune", "N");
//			}
//
//		}
//		DBConnection.closeStatement(st);
//		return list;
//	}
 

