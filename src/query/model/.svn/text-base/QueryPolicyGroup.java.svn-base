package query.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class QueryPolicyGroup extends AbstractModelObject {
	public List<QueryPolicy> querypolicy = new ArrayList<QueryPolicy>();
	private HashMap<String,QueryPolicy> hashmap = new HashMap<String,QueryPolicy>();
	public QueryPolicyGroup(){
		
	}
	public List<QueryPolicy> getQueryPolicy() {
		return querypolicy;
	}

	public void addQueryPolicy(QueryPolicy policy) {
		List<QueryPolicy> oldValue = querypolicy;
		querypolicy = new ArrayList<QueryPolicy>(querypolicy);
		querypolicy.add(policy);
		hashmap.put(policy.getPolicy_no(), policy);
		firePropertyChange("queryPolicy", oldValue, querypolicy);
	}

	public void removeQueryPolicy(QueryPolicy policy) {
		List<QueryPolicy> oldValue = querypolicy;
		querypolicy = new ArrayList<QueryPolicy>(querypolicy);
		querypolicy.remove(policy);
		firePropertyChange("queryPolicy", oldValue, querypolicy);
	}

	public void removeAll() {
		List<QueryPolicy> oldValue = querypolicy;
		querypolicy = new ArrayList<QueryPolicy>(querypolicy);
		querypolicy.clear();
		hashmap.clear();
		firePropertyChange("queryPolicy", oldValue, querypolicy);
	}
	public QueryPolicy searhQueryPolicy(String policy_no){
		return hashmap.get(policy_no);
	}

}
