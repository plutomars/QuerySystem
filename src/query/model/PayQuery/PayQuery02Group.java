package query.model.PayQuery;

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;

public class PayQuery02Group extends AbstractModelObject {

private List<PayQuery02> payquery02s = new ArrayList<PayQuery02>();
	
	//add
	public PayQuery02Group() {
	}
	
	public List<PayQuery02> getPayQuery02() {
		return payquery02s;
	}
	
	public void addPayQuery02(PayQuery02 payquery02) {
		List<PayQuery02> oldValue =  payquery02s;
		payquery02s = new ArrayList<PayQuery02>(payquery02s);
		payquery02s.add(payquery02);		
		firePropertyChange("payQuery02", oldValue, payquery02s);
		// 第一個參數要跟Binding的名稱相同
	}
	
	public void removePayQuery02(PayQuery02 payquery02) {
		payquery02s.remove(payquery02);
	}
	
	public void removeAll() {
		List<PayQuery02> oldValue = payquery02s;
		payquery02s = new ArrayList<PayQuery02>(payquery02s);
		payquery02s.clear();		
		firePropertyChange("payQuery02", oldValue, payquery02s);
	}
	
	public int getPayQuery02Count() {
		return payquery02s.size();
	}
}
