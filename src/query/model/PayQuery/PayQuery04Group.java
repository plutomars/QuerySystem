package query.model.PayQuery;

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;

public class PayQuery04Group extends AbstractModelObject {

private List<PayQuery04> payquery04s = new ArrayList<PayQuery04>();
	
	//add
	public PayQuery04Group() {
	}
	
	public List<PayQuery04> getPayQuery04() {
		return payquery04s;
	}
	
	public void addPayQuery04(PayQuery04 payquery04) {
		List<PayQuery04> oldValue =  payquery04s;
		payquery04s = new ArrayList<PayQuery04>(payquery04s);
		payquery04s.add(payquery04);		
		firePropertyChange("payQuery04", oldValue, payquery04s);
		// 第一個參數要跟Binding的名稱相同
	}
	
	public void removePayQuery04(PayQuery04 payquery04) {
		payquery04s.remove(payquery04);
	}
	
	public void removeAll() {
		List<PayQuery04> oldValue = payquery04s;
		payquery04s = new ArrayList<PayQuery04>(payquery04s);
		payquery04s.clear();		
		firePropertyChange("payQuery04", oldValue, payquery04s);
	}
	
	public int getPayQuery04Count() {
		return payquery04s.size();
	}
}
