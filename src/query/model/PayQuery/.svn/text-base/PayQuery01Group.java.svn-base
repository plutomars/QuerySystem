package query.model.PayQuery;

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;
import query.model.PayQuery.PayQuery01;

public class PayQuery01Group extends AbstractModelObject {
	private List<PayQuery01> payquery01s = new ArrayList<PayQuery01>();
	
	//add
	public PayQuery01Group() {
	}
	
	public List<PayQuery01> getPayQuery01() {
		return payquery01s;
	}
	
	public void addPayQuery01(PayQuery01 payquery01) {
		List<PayQuery01> oldValue =  payquery01s;
		payquery01s = new ArrayList<PayQuery01>(payquery01s);
		payquery01s.add(payquery01);		
		firePropertyChange("payQuery01", oldValue, payquery01s);
		// 第一個參數要跟Binding的名稱相同
	}
	
	public void removePayQuery01(PayQuery01 payquery01) {
		payquery01s.remove(payquery01);
	}
	
	public void removeAll() {
		List<PayQuery01> oldValue = payquery01s;
		payquery01s = new ArrayList<PayQuery01>(payquery01s);
		payquery01s.clear();		
		firePropertyChange("payQuery01", oldValue, payquery01s);
	}
	
	public int getPayQuery01Count() {
		return payquery01s.size();
	}
	
}
