package query.model.PremReject;

import java.util.ArrayList;
import java.util.List;
import query.model.AbstractModelObject;

/**
 * 
 * @author cychu
 *
 * @version 1.0<br/>
 * 			101/03/21<br/>
 * 			授權書、委託書退件資料群組(JavaBeanGroup)
 * 
 * @since 1.0
 */
public class PremRejectGroup extends AbstractModelObject {
	private List<PremReject> premRejects = new ArrayList<PremReject>();
	
	public PremRejectGroup() {
	}
	
	public List<PremReject> getPremRejects() {
		return premRejects;
	}

	public void addPremReject(PremReject premReject) {
		List<PremReject> oldValue = premRejects;
		premRejects = new ArrayList<PremReject>(premRejects);
		premRejects.add(premReject);

		firePropertyChange("premRejects", oldValue, premRejects);
	}

	public void removePremReject(PremReject premReject) {
		premRejects.remove(premReject);
	}

	public void removeAll() {
		List<PremReject> oldValue = premRejects;
		premRejects = new ArrayList<PremReject>(premRejects);
		premRejects.clear();
		firePropertyChange("premRejects", oldValue, premRejects);
	}

	public int getPremRejectCount() {
		return premRejects.size();
	}
}
