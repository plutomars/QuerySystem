package query.model.InvestHistory;

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;

public class InvestHistoryGroup01 extends AbstractModelObject {
	private List<InvestHistory01> investHistory01s = new ArrayList<InvestHistory01>();
	
	public InvestHistoryGroup01() {
	}
	public List<InvestHistory01> getInvestHistory01s() {
		return investHistory01s;
	}

	public void addInvestHistory01(InvestHistory01 investHistory01) {
		List<InvestHistory01> oldValue = investHistory01s;
		investHistory01s = new ArrayList<InvestHistory01>(investHistory01s);
		investHistory01s.add(investHistory01);

		firePropertyChange("investHistory01s", oldValue, investHistory01s);
	}

	public void removeRelation(InvestHistory01 investHistory01) {
		investHistory01s.remove(investHistory01);
	}

	public void removeAll() {
		List<InvestHistory01> oldValue = investHistory01s;
		investHistory01s = new ArrayList<InvestHistory01>(investHistory01s);
		investHistory01s.clear();
		firePropertyChange("investHistory01s", oldValue, investHistory01s);
	}

	public int getInvestHistory01Count() {
		return investHistory01s.size();
	}


}
