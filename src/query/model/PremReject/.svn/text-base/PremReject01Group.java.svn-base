package query.model.PremReject;

import java.util.ArrayList;
import java.util.List;
import query.model.AbstractModelObject;

/**
 * 
 * @author cychu
 *
 * @version 1.0<br/>
 * 			101/03/20<br/>
 * 			授權書、委託書退件明細群組(JavaBeanGroup)
 * 
 * @since 1.0
 */
public class PremReject01Group extends AbstractModelObject {
private List<PremReject01> premReject01s = new ArrayList<PremReject01>();
	
	public PremReject01Group() {
	}

	public List<PremReject01> getPremReject01s() {
		return premReject01s;
	}

	public void addPremReject01(PremReject01 premReject01) {
		List<PremReject01> oldValue = premReject01s;
		premReject01s = new ArrayList<PremReject01>(premReject01s);
		premReject01s.add(premReject01);
		firePropertyChange("premReject01s", oldValue, premReject01s);
	}

	public void removePremReject01(PremReject01 premReject01) {
		premReject01s.remove(premReject01);
	}

	public void removeAll() {
		List<PremReject01> oldValue = premReject01s;
		premReject01s = new ArrayList<PremReject01>(premReject01s);
		premReject01s.clear();
		firePropertyChange("premReject01s", oldValue, premReject01s);
	}

	public int getPremReject01Count() {
		return premReject01s.size();
	}
}
