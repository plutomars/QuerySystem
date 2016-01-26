package query.model.NewDetail;

import java.util.HashMap;
import java.util.List;

import query.model.Query;
import query.model.ClaimHistory.ClaimHistoryQuery;

/**
 * 新契約明細理賠記錄(JavaBean)的Query 使用理賠資料的Query即可
 * 
 * @author epf
 * 
 * @version 1.0<br>
 * 
 * @since 1.0
 */
public class NewDetailClaimHistoryQuery implements Query {
	public final static int NEWHISTORY = ClaimHistoryQuery.NEWCLAIMHISTORY;

	@Override
	public List<HashMap<String, String>> getResultList(String policy_no,
			int type) {
		if (type == NEWHISTORY) {
			List<HashMap<String, String>> list = getResultList(policy_no);
			return list;
		}
		return null;

	}

	public List<HashMap<String, String>> getResultList(String policy_no) {
		ClaimHistoryQuery chq = new ClaimHistoryQuery();
		List<HashMap<String, String>> list = null;
		list = chq.getResultList(policy_no, ClaimHistoryQuery.NEWCLAIMHISTORY);
		for (HashMap<String, String> hsmp : list) {
			List<HashMap<String, String>> tmplist = null;
			tmplist = chq.getResultList(hsmp.get("r_policy_no"),
					hsmp.get("r_claim_seq"), ClaimHistoryQuery.CLAIMDETAIL,"");
			for (HashMap<String, String> tmphsmp : tmplist) {
				hsmp.putAll(tmphsmp);
			}
			list.set(list.indexOf(hsmp), hsmp);
		}
		return list;
	}

}
