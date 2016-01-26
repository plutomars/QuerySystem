package query.model.PayQuery;

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;

public class PayQuery05Group extends AbstractModelObject {

private List<PayQuery05> payquery05s = new ArrayList<PayQuery05>();
	
	//add
	public PayQuery05Group() {
	}
	
	public List<PayQuery05> getPayQuery05() {
		return payquery05s;
	}
	
	public void addPayQuery05(PayQuery05 payquery05) {
		List<PayQuery05> oldValue =  payquery05s;
		payquery05s = new ArrayList<PayQuery05>(payquery05s);
		payquery05s.add(payquery05);		
		firePropertyChange("payQuery05", oldValue, payquery05s);
		// 第一個參數要跟Binding的名稱相同
	}
	
	public void removePayQuery05(PayQuery05 payquery05) {
		payquery05s.remove(payquery05);
	}
	
	public void removeAll() {
		List<PayQuery05> oldValue = payquery05s;
		payquery05s = new ArrayList<PayQuery05>(payquery05s);
		payquery05s.clear();
		firePropertyChange("payQuery05", oldValue, payquery05s);
	}
	
	public int getPayQuery05Count() {
		return payquery05s.size();
	}
}
