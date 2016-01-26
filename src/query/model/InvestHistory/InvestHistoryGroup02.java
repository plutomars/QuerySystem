package query.model.InvestHistory;

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;

public class InvestHistoryGroup02 extends AbstractModelObject {
	private List<InvestHistory02> investHistory02s = new ArrayList<InvestHistory02>();

	public InvestHistoryGroup02() {
	}

	public List<InvestHistory02> getInvestHistory02s() {
		return investHistory02s;
	}

	public void addInvestHistory02(InvestHistory02 investHistory02) {
		List<InvestHistory02> oldValue = investHistory02s;
		investHistory02s = new ArrayList<InvestHistory02>(investHistory02s);
		investHistory02s.add(investHistory02);

		firePropertyChange("investHistory02s", oldValue, investHistory02s);
	}

	public void removeRelation(InvestHistory02 investHistory02) {
		investHistory02s.remove(investHistory02);
	}

	public void removeAll() {
		List<InvestHistory02> oldValue = investHistory02s;
		investHistory02s = new ArrayList<InvestHistory02>(investHistory02s);
		investHistory02s.clear();
		firePropertyChange("investHistory02s", oldValue, investHistory02s);
	}

	public int getInvestHistory02Count() {
		return investHistory02s.size();
	}

}
