package query.model.InvestCash;

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;

public class InvestCash04Group extends AbstractModelObject {
	private List<InvestCash04> investCash04s = new ArrayList<InvestCash04>();

	public InvestCash04Group() {
		// TODO Auto-generated constructor stub
	}

	public List<InvestCash04> getInvestCash04s() {
		return investCash04s;
	}
	
	public void addInvestCash04(InvestCash04 investCash04) {
		List<InvestCash04> oldValue = investCash04s;
		investCash04s = new ArrayList<InvestCash04>(investCash04s);
		investCash04s.add(investCash04);

		firePropertyChange("investCash04s", oldValue, investCash04s);
		// firePropertyChange的第一個參數為List的method名稱，要跟Binding的名稱相同
	}

	public void removeInvestCash04(InvestCash04 investCash04) {
		investCash04s.remove(investCash04);
	}

	public void removeAll() {
		List<InvestCash04> oldValue = investCash04s;
		investCash04s = new ArrayList<InvestCash04>(investCash04s);
		investCash04s.clear();
		firePropertyChange("investCash04s", oldValue, investCash04s);
	}

	public int getInvestCash04Count() {
		return investCash04s.size();
	}

	

}
