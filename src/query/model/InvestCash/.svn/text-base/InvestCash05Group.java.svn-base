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
public class InvestCash05Group extends AbstractModelObject {
	private List<InvestCash05> investCash05s = new ArrayList<InvestCash05>();

	/**
	 * 
	 */
	public InvestCash05Group() {
		// TODO Auto-generated constructor stub
	}

	public List<InvestCash05> getInvestCash05s() {
		return investCash05s;
	}

	public void addInvestCash05(InvestCash05 investCash05) {
		List<InvestCash05> oldValue = investCash05s;
		investCash05s = new ArrayList<InvestCash05>(investCash05s);
		investCash05s.add(investCash05);

		firePropertyChange("investCash05s", oldValue, investCash05s);
		// firePropertyChange的第一個參數為List的method名稱，要跟Binding的名稱相同
	}

	public void removeInvestCash05(InvestCash05 investCash05) {
		investCash05s.remove(investCash05);
	}

	public void removeall() {
		List<InvestCash05> oldValue = investCash05s;
		investCash05s = new ArrayList<InvestCash05>(investCash05s);
		investCash05s.clear();

		firePropertyChange("investCash05s", oldValue, investCash05s);

	}

	public int getInvestCash05Count() {
		return investCash05s.size();
	}

}
