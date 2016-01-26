package query.model.PayAccount;

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;
/**
 * 
 * @author 陳冠瑜
 * 
 */
public class PayAccount02Group extends AbstractModelObject {
	private List<PayAccount02> premaccount02s = new ArrayList<PayAccount02>();

	public PayAccount02Group() {
	}

	public List<PayAccount02> getPremAccount02s() {
		return premaccount02s;
	}

	public void addPremAccount02(PayAccount02 premaccount02) {
		List<PayAccount02> oldValue = premaccount02s;
		premaccount02s = new ArrayList<PayAccount02>(premaccount02s);
		premaccount02s.add(premaccount02);

		firePropertyChange("premAccount02s", oldValue, premaccount02s);
		// firePropertyChange的第一個參數為List的method名稱，要跟Binding的名稱相同
	}

	public void removePremAccount02(PayAccount02 premaccount02) {
		premaccount02s.remove(premaccount02);
	}

	public void removeAll() {
		List<PayAccount02> oldValue = premaccount02s;
		premaccount02s = new ArrayList<PayAccount02>(premaccount02s);
		premaccount02s.clear();
		firePropertyChange("premAccount02s", oldValue, premaccount02s);
	}

	public int getPremAccount02Count() {
		return premaccount02s.size();
	}
}
