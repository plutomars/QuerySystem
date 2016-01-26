package query.model.PayAccount;

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;
/**
 * 
 * @author 陳冠瑜
 * 
 */
public class PayAccount01Group extends AbstractModelObject {
	private List<PayAccount01> premaccount01s = new ArrayList<PayAccount01>();

	public PayAccount01Group() {
	}

	public List<PayAccount01> getPremAccount01s() {
		return premaccount01s;
	}

	public void addPremAccount01(PayAccount01 premaccount01) {
		List<PayAccount01> oldValue = premaccount01s;
		premaccount01s = new ArrayList<PayAccount01>(premaccount01s);
		premaccount01s.add(premaccount01);

		firePropertyChange("premAccount01s", oldValue, premaccount01s);
		// firePropertyChange的第一個參數為List的method名稱，要跟Binding的名稱相同
	}

	public void removePremAccount01(PayAccount01 premaccount01) {
		premaccount01s.remove(premaccount01);
	}

	public void removeAll() {
		List<PayAccount01> oldValue = premaccount01s;
		premaccount01s = new ArrayList<PayAccount01>(premaccount01s);
		premaccount01s.clear();
		firePropertyChange("premAccount01s", oldValue, premaccount01s);
	}

	public int getPremAccount01Count() {
		return premaccount01s.size();
	}
}
