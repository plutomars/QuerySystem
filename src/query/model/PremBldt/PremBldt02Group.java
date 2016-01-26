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
 * 			送金記錄查詢－入帳資料群組(JavaBeanGroup)
 *
 * @since 1.0
 */
public class PremBldt02Group extends AbstractModelObject {
	private List<PremBldt02> premBldt02s = new ArrayList<PremBldt02>();
	
	public PremBldt02Group() {
	}
	
	public List<PremBldt02> getPremBldt02s() {
		return premBldt02s;
	}

	public void addPremBldt02(PremBldt02 premBldt02) {
		List<PremBldt02> oldValue = premBldt02s;
		premBldt02s = new ArrayList<PremBldt02>(premBldt02s);
		premBldt02s.add(premBldt02);

		firePropertyChange("premBldt02s", oldValue, premBldt02s);
	}

	public void removePremBldt02(PremBldt02 premBldt02) {
		premBldt02s.remove(premBldt02);
	}

	public void removeAll() {
		List<PremBldt02> oldValue = premBldt02s;
		premBldt02s = new ArrayList<PremBldt02>(premBldt02s);
		premBldt02s.clear();
		firePropertyChange("premBldt02s", oldValue, premBldt02s);
	}

	public int getPremBldt02Count() {
		return premBldt02s.size();
	}
}
