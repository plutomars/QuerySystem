package query.model.InvestGoal;
/**
 * 投資標的配息
 * @author cora
 * 100/10
 */
import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;

public class InvestGoalIntGroup extends AbstractModelObject {
	private List<InvestGoalInt> investGoalInts = new ArrayList<InvestGoalInt>();

	public List<InvestGoalInt> getInvestGoalInts() {
		return investGoalInts;
	}

	public InvestGoalIntGroup() {
		// TODO Auto-generated constructor stub
	}

	public void addInvestGoalInt(InvestGoalInt investGoalInt) {
		List<InvestGoalInt> oldValue = investGoalInts;
		investGoalInts = new ArrayList<InvestGoalInt>(investGoalInts);
		investGoalInts.add(investGoalInt);

		firePropertyChange("investGoalInts", oldValue, investGoalInts);
	}

	public void removeInvestGoalInt(InvestGoalInt InvestGoalInt) {
		investGoalInts.remove(InvestGoalInt);
	}

	public void removeAll() {
		List<InvestGoalInt> oldValue = investGoalInts;
		investGoalInts = new ArrayList<InvestGoalInt>(investGoalInts);
		investGoalInts.clear();
		firePropertyChange("investGoalInts", oldValue, investGoalInts);
	}
}
