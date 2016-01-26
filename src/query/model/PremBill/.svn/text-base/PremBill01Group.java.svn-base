package query.model.PremBill;

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;
/**
 * 
 * @author cychu
 *
 * @version 1.0<br/>
 * 			100/08/17<br/>
 * 			¦©´Ú©ú²Ó¸s²Õ(JavaBeanGroup)
 * 
 * @since 1.0
 */
public class PremBill01Group extends AbstractModelObject {
	private List<PremBill01> premBill01s = new ArrayList<PremBill01>();
	
	public PremBill01Group() {
	}

	public List<PremBill01> getPremBill01s() {
		return premBill01s;
	}

	public void addPremBill01(PremBill01 premBill01) {
		List<PremBill01> oldValue = premBill01s;
		premBill01s = new ArrayList<PremBill01>(premBill01s);
		premBill01s.add(premBill01);
		firePropertyChange("premBill01s", oldValue, premBill01s);
	}

	public void removePremBill01(PremBill01 premBill01) {
		premBill01s.remove(premBill01);
	}

	public void removeAll() {
		List<PremBill01> oldValue = premBill01s;
		premBill01s = new ArrayList<PremBill01>(premBill01s);
		premBill01s.clear();
		firePropertyChange("premBill01s", oldValue, premBill01s);
	}

	public int getPremBill01Count() {
		return premBill01s.size();
	}
}
