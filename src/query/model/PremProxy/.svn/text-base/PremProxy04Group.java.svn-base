package query.model.PremProxy;

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;
/**
 * 
 * @author 陳冠瑜 101-10-03
 * 
 */
public class PremProxy04Group extends AbstractModelObject {
	private List<PremProxy04> premproxy04s = new ArrayList<PremProxy04>();

	public PremProxy04Group() {
	}

	public List<PremProxy04> getPremproxy04s() {
		return premproxy04s;
	}

	public void addPremProxy04(PremProxy04 premproxy04) {
		List<PremProxy04> oldValue = premproxy04s;
		premproxy04s = new ArrayList<PremProxy04>(premproxy04s);
		premproxy04s.add(premproxy04);

		firePropertyChange("premproxy04s", oldValue, premproxy04s);
		// firePropertyChange的第一個參數為List的method名稱，要跟Binding的名稱相同		
	}

	public void removePremProxy04(PremProxy04 premproxy04) {
		premproxy04s.remove(premproxy04);
	}

	public void removeAll() {
		List<PremProxy04> oldValue = premproxy04s;
		premproxy04s = new ArrayList<PremProxy04>(premproxy04s);
		premproxy04s.clear();
		firePropertyChange("premproxy04s", oldValue, premproxy04s);
	}

	public int getPremProxy04Count() {
		return premproxy04s.size();
	}

}
