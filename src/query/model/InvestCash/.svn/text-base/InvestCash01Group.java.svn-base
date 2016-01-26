package query.model.InvestCash;

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;
/**
 * 
 * @author 陳冠瑜
 * 
 */
public class InvestCash01Group extends AbstractModelObject {
	private List<InvestCash01> investcash01s = new ArrayList<InvestCash01>();
	
	public InvestCash01Group() {
	}
	
	public List<InvestCash01> getInvestCash01s() {
		return investcash01s;
	}
	
	public void addInvestCash01(InvestCash01 investcash01) {
		List<InvestCash01> oldValue = investcash01s;
		investcash01s = new ArrayList<InvestCash01>(investcash01s);
		investcash01s.add(investcash01);
		
		firePropertyChange("investCash01s",oldValue,investcash01s);
		// firePropertyChange的第一個參數為List的method名稱，要跟Binding的名稱相同
	}
	
	public void removeInvestCash01(InvestCash01 investcash01) {
		investcash01s.remove(investcash01);
	}

	public void removeAll() {
		List<InvestCash01> oldValue = investcash01s;
		investcash01s = new ArrayList<InvestCash01>(investcash01s);
		investcash01s.clear();
		firePropertyChange("investCash01s",oldValue,investcash01s);
	}
	
	public int getInvestCash01Count() {
		return investcash01s.size();
	}
}
