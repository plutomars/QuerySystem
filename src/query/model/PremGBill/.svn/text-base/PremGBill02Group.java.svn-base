package query.model.PremGBill;

/**
 * 
 * @author swei
 * @version 1.0
 * 集體彙繳查詢群組(JavaBeanGroup)
 * 
 */

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;

public class PremGBill02Group extends AbstractModelObject {
	private List<PremGBill02> premgbill02s = new ArrayList<PremGBill02>();
	
	//add
	public PremGBill02Group() {
	}
	
	public List<PremGBill02> getPremGBill02() {
		return premgbill02s;
	}
	
	public void addPremGBill02(PremGBill02 premgbill02) {
		List<PremGBill02> oldValue =  premgbill02s;
		premgbill02s = new ArrayList<PremGBill02>(premgbill02s);
		premgbill02s.add(premgbill02);

		firePropertyChange("premGBill02", oldValue, premgbill02s);
	}

	public void removePremGBill02(PremGBill02 premgbill02) {
		premgbill02s.remove(premgbill02);
	}

	public void removeAll() {
		List<PremGBill02> oldValue = premgbill02s;
		premgbill02s = new ArrayList<PremGBill02>(premgbill02s);
		premgbill02s.clear();
		firePropertyChange("premGBill02", oldValue, premgbill02s);
	}

	public int getPremGBill02Count() {
		return premgbill02s.size();
	}
}
