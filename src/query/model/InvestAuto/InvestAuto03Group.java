package query.model.InvestAuto;

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;
/**
 * 
 * @author 陳冠瑜
 * 
 */
public class InvestAuto03Group extends AbstractModelObject {
	private List<InvestAuto03> investauto03s = new ArrayList<InvestAuto03>();

	public InvestAuto03Group() {
	}

	public List<InvestAuto03> getInvestAuto03s() {
		return investauto03s;
	}

	public void addInvestAuto03(InvestAuto03 investauto03) {
		List<InvestAuto03> oldValue = investauto03s;
		investauto03s = new ArrayList<InvestAuto03>(investauto03s);
		investauto03s.add(investauto03);

		firePropertyChange("investAuto03s", oldValue, investauto03s);
		// firePropertyChange的第一個參數為List的method名稱，要跟Binding的名稱相同
	}

	public void removeInvestAuto03(InvestAuto03 investauto03) {
		investauto03s.remove(investauto03);
	}

	public void removeAll() {
		List<InvestAuto03> oldValue = investauto03s;
		investauto03s = new ArrayList<InvestAuto03>(investauto03s);
		investauto03s.clear();
		firePropertyChange("investAuto03s", oldValue, investauto03s);
	}

	public int getInvestAuto03Count() {
		return investauto03s.size();
	}
}
