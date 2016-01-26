package query.model.PayQuery;

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;

public class PayQuery03Group extends AbstractModelObject {

private List<PayQuery03> payquery03s = new ArrayList<PayQuery03>();
	
	//add
	public PayQuery03Group() {
	}
	
	public List<PayQuery03> getPayQuery03() {
		return payquery03s;
	}
	
	public void addPayQuery03(PayQuery03 payquery03) {
		List<PayQuery03> oldValue =  payquery03s;
		payquery03s = new ArrayList<PayQuery03>(payquery03s);
		payquery03s.add(payquery03);		
		firePropertyChange("payQuery03", oldValue, payquery03s);
		// 第一個參數要跟Binding的名稱相同
	}
	
	public void removePayQuery03(PayQuery03 payquery03) {
		payquery03s.remove(payquery03);
	}
	
	public void removeAll() {
		List<PayQuery03> oldValue = payquery03s;
		payquery03s = new ArrayList<PayQuery03>(payquery03s);
		payquery03s.clear();		
		firePropertyChange("payQuery03", oldValue, payquery03s);
	}
	
	public int getPayQuery03Count() {
		return payquery03s.size();
	}
}
