package query.model.PremBldt;

import java.util.ArrayList;
import java.util.List;
import query.model.AbstractModelObject;

/**
 * 
 * @author cychu
 * 
 * @version 1.0<br/>
 * 			101/04/11<br/>
 * 			送金記錄查詢－送金明細群組(JavaBeanGroup)
 *
 * @since 1.0
 */
public class PremBldt01Group extends AbstractModelObject {
	private List<PremBldt01> premBldt01s = new ArrayList<PremBldt01>();
	
	public PremBldt01Group() {
	}
	
	public List<PremBldt01> getPremBldt01s() {
		return premBldt01s;
	}

	public void addPremBldt01(PremBldt01 premBldt01) {
		List<PremBldt01> oldValue = premBldt01s;
		premBldt01s = new ArrayList<PremBldt01>(premBldt01s);
		premBldt01s.add(premBldt01);

		firePropertyChange("premBldt01s", oldValue, premBldt01s);
	}

	public void removePremBldt01(PremBldt01 premBldt01) {
		premBldt01s.remove(premBldt01);
	}

	public void removeAll() {
		List<PremBldt01> oldValue = premBldt01s;
		premBldt01s = new ArrayList<PremBldt01>(premBldt01s);
		premBldt01s.clear();
		firePropertyChange("premBldt01s", oldValue, premBldt01s);
	}

	public int getPremBldt01Count() {
		return premBldt01s.size();
	}
}
