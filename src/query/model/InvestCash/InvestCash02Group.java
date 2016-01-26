package query.model.InvestCash;

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;
/**
 * 
 * @author ���a��
 * 
 */
public class InvestCash02Group extends AbstractModelObject {
	private List<InvestCash02> investcash02s = new ArrayList<InvestCash02>();
	
	public InvestCash02Group() {
	}
	
	public List<InvestCash02> getInvestCash02s() {
		return investcash02s;
	}
	
	public void addInvestCash02(InvestCash02 investcash02) {
		List<InvestCash02> oldValue = investcash02s;
		investcash02s = new ArrayList<InvestCash02>(investcash02s);
		investcash02s.add(investcash02);
		
		firePropertyChange("investCash02s",oldValue,investcash02s);
		// firePropertyChange���Ĥ@�ӰѼƬ�List��method�W�١A�n��Binding���W�٬ۦP
	}
	
	public void removeInvestCash02(InvestCash02 investcash02) {
		investcash02s.remove(investcash02);
	}

	public void removeAll() {
		List<InvestCash02> oldValue = investcash02s;
		investcash02s = new ArrayList<InvestCash02>(investcash02s);
		investcash02s.clear();
		firePropertyChange("investCash02s",oldValue,investcash02s);
	}
	
	public int getInvestCash02Count() {
		return investcash02s.size();
	}
}
