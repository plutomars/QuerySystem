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

public class PremGBill03Group extends AbstractModelObject {
private List<PremGBill03> premgbill03s = new ArrayList<PremGBill03>();
	
	//add
	public PremGBill03Group() {
	}
	
	public List<PremGBill03> getPremGBill03() {
		return premgbill03s;
	}
	
	public void addPremGBill03(PremGBill03 premgbill03) {
		List<PremGBill03> oldValue =  premgbill03s;
		premgbill03s = new ArrayList<PremGBill03>(premgbill03s);
		premgbill03s.add(premgbill03);

		firePropertyChange("premGBill03", oldValue, premgbill03s);
	}

	public void removePremGBill03(PremGBill03 premgbill03) {
		premgbill03s.remove(premgbill03);
	}

	public void removeAll() {
		List<PremGBill03> oldValue = premgbill03s;
		premgbill03s = new ArrayList<PremGBill03>(premgbill03s);
		premgbill03s.clear();
		firePropertyChange("premGBill03", oldValue, premgbill03s);
	}

	public int getPremGBill03Count() {
		return premgbill03s.size();
	}
}
