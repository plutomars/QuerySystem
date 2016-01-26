package query.model.PremProxy;

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;
/**
 * 
 * @author 陳冠瑜
 * 
 */
public class PremProxy02Group extends AbstractModelObject {
	private List<PremProxy02> premproxy02s = new ArrayList<PremProxy02>();

	public PremProxy02Group() {
	}

	public List<PremProxy02> getPremproxy02s() {
		return premproxy02s;
	}

	public void addPremProxy02(PremProxy02 premproxy02) {
		List<PremProxy02> oldValue = premproxy02s;
		premproxy02s = new ArrayList<PremProxy02>(premproxy02s);
		premproxy02s.add(premproxy02);

		firePropertyChange("premproxy02s", oldValue, premproxy02s);
		// firePropertyChange的第一個參數為List的method名稱，要跟Binding的名稱相同
		
	}

	public void removePremProxy02(PremProxy02 premproxy02) {
		premproxy02s.remove(premproxy02);
	}

	public void removeAll() {
		List<PremProxy02> oldValue = premproxy02s;
		premproxy02s = new ArrayList<PremProxy02>(premproxy02s);
		premproxy02s.clear();
		firePropertyChange("premproxy02s", oldValue, premproxy02s);
	}

	public int getPremProxy02Count() {
		return premproxy02s.size();
	}

}
