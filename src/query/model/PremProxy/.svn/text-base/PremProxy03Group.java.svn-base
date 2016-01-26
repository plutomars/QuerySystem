package query.model.PremProxy;

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;
/**
 * 
 * @author 陳冠瑜
 * 
 */
public class PremProxy03Group extends AbstractModelObject {
	private List<PremProxy03> premproxy03s = new ArrayList<PremProxy03>();

	public PremProxy03Group() {
	}

	public List<PremProxy03> getPremproxy03s() {
		return premproxy03s;
	}

	public void addPremProxy03(PremProxy03 premproxy03) {
		List<PremProxy03> oldValue = premproxy03s;
		premproxy03s = new ArrayList<PremProxy03>(premproxy03s);
		premproxy03s.add(premproxy03);

		firePropertyChange("premproxy03s", oldValue, premproxy03s);
		// firePropertyChange的第一個參數為List的method名稱，要跟Binding的名稱相同
	}

	public void removePremProxy03(PremProxy03 premproxy03) {
		premproxy03s.remove(premproxy03);
	}

	public void removeAll() {
		List<PremProxy03> oldValue = premproxy03s;
		premproxy03s = new ArrayList<PremProxy03>(premproxy03s);
		premproxy03s.clear();
		firePropertyChange("premproxy03s", oldValue, premproxy03s);
	}

	public int getPremProxy03Count() {
		return premproxy03s.size();
	}

}
