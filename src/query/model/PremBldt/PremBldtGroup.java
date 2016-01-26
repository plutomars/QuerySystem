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
 * 			送金記錄查詢－基本資料群組(JavaBeanGroup)
 *
 * @since 1.0
 */
public class PremBldtGroup extends AbstractModelObject {
	private List<PremBldt> premBldts = new ArrayList<PremBldt>();
	
	public PremBldtGroup() {
	}
	
	public List<PremBldt> getPremBldts() {
		return premBldts;
	}

	public void addPremBldt(PremBldt premBldt) {
		List<PremBldt> oldValue = premBldts;
		premBldts = new ArrayList<PremBldt>(premBldts);
		premBldts.add(premBldt);

		firePropertyChange("premBldts", oldValue, premBldts);
	}

	public void removePremBldt(PremBldt premBldt) {
		premBldts.remove(premBldt);
	}

	public void removeAll() {
		List<PremBldt> oldValue = premBldts;
		premBldts = new ArrayList<PremBldt>(premBldts);
		premBldts.clear();
		firePropertyChange("premBldts", oldValue, premBldts);
	}

	public int getPremBldtCount() {
		return premBldts.size();
	}
}
