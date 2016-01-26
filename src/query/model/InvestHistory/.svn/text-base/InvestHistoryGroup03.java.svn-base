/**
 * 
 */
package query.model.InvestHistory;

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;

/**
 * @author F1256819
 * 
 */
public class InvestHistoryGroup03 extends AbstractModelObject {
	private List<InvestHistory03> investHistory03s = new ArrayList<InvestHistory03>();

	public InvestHistoryGroup03() {
	}

	public List<InvestHistory03> getInvestHistory03s() {
		return investHistory03s;
	}

	public void addInvestHistory03(InvestHistory03 investHistory03) {
		List<InvestHistory03> oldValue = investHistory03s;
		investHistory03s = new ArrayList<InvestHistory03>(investHistory03s);
		investHistory03s.add(investHistory03);

		firePropertyChange("investHistory03s", oldValue, investHistory03s);
	}

	public void removeInvestHistory03(InvestHistory03 investHistory03) {
		investHistory03s.remove(investHistory03);
	}

	public void removeAll() {
		List<InvestHistory03> oldValue = investHistory03s;
		investHistory03s = new ArrayList<InvestHistory03>(investHistory03s);
		investHistory03s.clear();
		firePropertyChange("investHistory03s", oldValue, investHistory03s);
	}

	public int getInvestHistory03Count() {
		return investHistory03s.size();
	}

}
