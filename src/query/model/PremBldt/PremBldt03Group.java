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
 * 			送金記錄查詢－修改歷史群組(JavaBeanGroup)
 *
 * @since 1.0
 */
public class PremBldt03Group extends AbstractModelObject {
	private List<PremBldt03> premBldt03s = new ArrayList<PremBldt03>();
	
	public PremBldt03Group() {
	}
	
	public List<PremBldt03> getPremBldt03s() {
		return premBldt03s;
	}

	public void addPremBldt03(PremBldt03 premBldt03) {
		List<PremBldt03> oldValue = premBldt03s;
		premBldt03s = new ArrayList<PremBldt03>(premBldt03s);
		premBldt03s.add(premBldt03);

		firePropertyChange("premBldt03s", oldValue, premBldt03s);
	}

	public void removePremBldt03(PremBldt03 premBldt03) {
		premBldt03s.remove(premBldt03);
	}

	public void removeAll() {
		List<PremBldt03> oldValue = premBldt03s;
		premBldt03s = new ArrayList<PremBldt03>(premBldt03s);
		premBldt03s.clear();
		firePropertyChange("premBldt03s", oldValue, premBldt03s);
	}

	public int getPremBldt03Count() {
		return premBldt03s.size();
	}
}
