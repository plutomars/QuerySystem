package query.model.InvestGoal;

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;

public class InvestGoal02Group extends AbstractModelObject {
	
	private List<InvestGoal02> investGoal02s = new ArrayList<InvestGoal02>();

	public List<InvestGoal02> getInvestGoal02s() {
		return investGoal02s;
	}

	public InvestGoal02Group() {
		// TODO Auto-generated constructor stub
	}

	public void addInvestGoal02(InvestGoal02 investGoal02) {
		List<InvestGoal02> oldValue = investGoal02s;
		investGoal02s = new ArrayList<InvestGoal02>(investGoal02s);
		investGoal02s.add(investGoal02);

		firePropertyChange("investGoal02s", oldValue, investGoal02s);
	}

	public void removeInvestGoal02(InvestGoal02 InvestGoal02) {
		investGoal02s.remove(InvestGoal02);
	}

	public void removeAll() {
		List<InvestGoal02> oldValue = investGoal02s;
		investGoal02s = new ArrayList<InvestGoal02>(investGoal02s);
		investGoal02s.clear();
		firePropertyChange("investGoal02s", oldValue, investGoal02s);
	}
}
