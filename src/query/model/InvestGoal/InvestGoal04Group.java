package query.model.InvestGoal;

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;

public class InvestGoal04Group extends AbstractModelObject {

	private List<InvestGoal04> investGoal04s = new ArrayList<InvestGoal04>();

	public List<InvestGoal04> getInvestGoal04s() {
		return investGoal04s;
	}

	public InvestGoal04Group() {
		// TODO Auto-generated constructor stub
	}

	public void addInvestGoal04(InvestGoal04 investGoal04) {
		List<InvestGoal04> oldValue = investGoal04s;
		investGoal04s = new ArrayList<InvestGoal04>(investGoal04s);
		investGoal04s.add(investGoal04);

		firePropertyChange("investGoal04s", oldValue, investGoal04s);
	}

	public void removeInvestGoal04(InvestGoal04 investGoal04) {
		investGoal04s.remove(investGoal04);
	}

	public void removeAll() {
		List<InvestGoal04> oldValue = investGoal04s;
		investGoal04s = new ArrayList<InvestGoal04>(investGoal04s);
		investGoal04s.clear();
		firePropertyChange("investGoal04s", oldValue, investGoal04s);
	}

}
