/**
 * 
 */
package query.model.InvestCash;

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;

/**
 * @author F1256819
 * 
 */
public class InvestCash03Group extends AbstractModelObject {

	private List<InvestCash03> investCash03s = new ArrayList<InvestCash03>();

	public InvestCash03Group() {
	}

	public List<InvestCash03> getInvestCash03s() {
		return investCash03s;
	}

	public void addInvestCash03(InvestCash03 investCash03) {
		List<InvestCash03> oldValue = investCash03s;
		investCash03s = new ArrayList<InvestCash03>(investCash03s);
		investCash03s.add(investCash03);

		firePropertyChange("investCash03s", oldValue, investCash03s);
		// firePropertyChange的第一個參數為List的method名稱，要跟Binding的名稱相同
	}

	public void removeInvestCash03(InvestCash03 investCash03) {
		investCash03s.remove(investCash03);
	}

	public void removeAll() {
		List<InvestCash03> oldValue = investCash03s;
		investCash03s = new ArrayList<InvestCash03>(investCash03s);
		investCash03s.clear();
		firePropertyChange("investCash03s", oldValue, investCash03s);
	}

	public int getInvestCash03Count() {
		return investCash03s.size();
	}

}
