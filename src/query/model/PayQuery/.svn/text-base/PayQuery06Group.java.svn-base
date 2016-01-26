package query.model.PayQuery;

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;

public class PayQuery06Group extends AbstractModelObject {

private List<PayQuery06> payquery06s = new ArrayList<PayQuery06>();
	
	//add
	public PayQuery06Group() {
	}
	
	public List<PayQuery06> getPayQuery06() {
		return payquery06s;
	}
	public void addPayQuery06(PayQuery06 payquery06) {
		List<PayQuery06> oldValue =  payquery06s;
		payquery06s = new ArrayList<PayQuery06>(payquery06s);
		payquery06s.add(payquery06);		
		firePropertyChange("payQuery06", oldValue, payquery06s);
		// 第一個參數要跟Binding的名稱相同
	}
	
	public void removePayQuery06(PayQuery06 payquery06) {
		payquery06s.remove(payquery06);
	}
	
	public void removeAll() {
		List<PayQuery06> oldValue = payquery06s;
		payquery06s = new ArrayList<PayQuery06>(payquery06s);
		payquery06s.clear();		
		firePropertyChange("payQuery06", oldValue, payquery06s);
	}
	
	public int getPayQuery06Count() {
		return payquery06s.size();
	}
}
