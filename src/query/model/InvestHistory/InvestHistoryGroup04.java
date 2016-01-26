package query.model.InvestHistory;

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;

public class InvestHistoryGroup04 extends AbstractModelObject {
	private List<InvestHistory04> investHistory04s = new ArrayList<InvestHistory04>();

	public InvestHistoryGroup04() {	
	}
	
	public List<InvestHistory04> getInvestHistory04s() {
		return investHistory04s;
	}
	public void addInvestHistory04(InvestHistory04 investHistory04) {
		List<InvestHistory04> oldValue = investHistory04s;
		investHistory04s = new ArrayList<InvestHistory04>(investHistory04s);
		investHistory04s.add(investHistory04);

		firePropertyChange("investHistory04s", oldValue, investHistory04s);
	}

	public void removeInvestHistory04(InvestHistory04 investHistory04) {
		investHistory04s.remove(investHistory04);
	}

	public void removeAll() {
		List<InvestHistory04> oldValue = investHistory04s;
		investHistory04s = new ArrayList<InvestHistory04>(investHistory04s);
		investHistory04s.clear();
		firePropertyChange("investHistory04s", oldValue, investHistory04s);
	}

	public int getInvestHistory04Count() {
		return investHistory04s.size();
	}


}
