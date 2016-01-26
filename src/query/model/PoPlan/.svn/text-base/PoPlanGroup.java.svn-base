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
 * 			保障險種資料群組(JavaBeanGroup)
 * 
 * @since 1.0
 */
public class PoPlanGroup extends AbstractModelObject {
	private List<PoPlan> poPlans = new ArrayList<PoPlan>();

	public PoPlanGroup() {
	}

	public List<PoPlan> getPoPlans() {
		return poPlans;
	}

	public void addPoPlan(PoPlan poPlan) {
		List<PoPlan> oldValue = poPlans;
		poPlans = new ArrayList<PoPlan>(poPlans);
		poPlans.add(poPlan);

		firePropertyChange("poPlans", oldValue, poPlans);
	}

	public void removePoPlan(PoPlan poPlan) {
		poPlans.remove(poPlan);
	}

	public void removeAll() {
		List<PoPlan> oldValue = poPlans;
		poPlans = new ArrayList<PoPlan>(poPlans);
		poPlans.clear();
		firePropertyChange("poPlans", oldValue, poPlans);
	}

	public int getPoPlanCount() {
		return poPlans.size();
	}
}
