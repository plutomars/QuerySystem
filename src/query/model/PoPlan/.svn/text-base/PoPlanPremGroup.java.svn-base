package query.model.PoPlan;

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;
/**
 * 
 * @author cychu
 * 
 * @version 1.0<br/>
 * 			100/09/07<br/>
 * 			每期保費/原始保費群組(JavaBeanGroup)
 * 
 * @since 1.0
 */
public class PoPlanPremGroup extends AbstractModelObject {
	private List<PoPlanPrem> poPlanPrems = new ArrayList<PoPlanPrem>();

	public PoPlanPremGroup() {
	}

	public List<PoPlanPrem> getPoPlanPrems() {
		return poPlanPrems;
	}

	public void addPoPlanPrem(PoPlanPrem poPlanPrem) {
		List<PoPlanPrem> oldValue = poPlanPrems;
		poPlanPrems = new ArrayList<PoPlanPrem>(poPlanPrems);
		poPlanPrems.add(poPlanPrem);

		firePropertyChange("poPlans", oldValue, poPlanPrems);
	}

	public void removePoPlanPrems(PoPlanPrem poPlanPrem) {
		poPlanPrems.remove(poPlanPrem);
	}

	public void removeAll() {
		List<PoPlanPrem> oldValue = poPlanPrems;
		poPlanPrems = new ArrayList<PoPlanPrem>(poPlanPrems);
		poPlanPrems.clear();
		firePropertyChange("poPlanPrems", oldValue, poPlanPrems);
	}

	public int getPoPlanPremCount() {
		return poPlanPrems.size();
	}
}
