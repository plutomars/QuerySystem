package query.model.InvestAuto;

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;
/**
 * 
 * @author ���a��
 * 
 */
public class InvestAuto01Group extends AbstractModelObject {
	private List<InvestAuto01> investauto01s = new ArrayList<InvestAuto01>();

	public InvestAuto01Group() {
	}

	public List<InvestAuto01> getInvestAuto01s() {
		return investauto01s;
	}

	public void addInvestAuto01(InvestAuto01 investauto01) {
		List<InvestAuto01> oldValue = investauto01s;
		investauto01s = new ArrayList<InvestAuto01>(investauto01s);
		investauto01s.add(investauto01);

		firePropertyChange("investAuto01s", oldValue, investauto01s);
		// firePropertyChange���Ĥ@�ӰѼƬ�List��method�W�١A�n��Binding���W�٬ۦP
	}

	public void removeInvestAuto01(InvestAuto01 investauto01) {
		investauto01s.remove(investauto01);
	}

	public void removeAll() {
		List<InvestAuto01> oldValue = investauto01s;
		investauto01s = new ArrayList<InvestAuto01>(investauto01s);
		investauto01s.clear();
		firePropertyChange("investAuto01s", oldValue, investauto01s);
	}

	public int getInvestAuto01Count() {
		return investauto01s.size();
	}
}
