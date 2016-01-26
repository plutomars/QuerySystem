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


public class PremGBill01Group extends AbstractModelObject {
	private List<PremGBill01> premgbill01s = new ArrayList<PremGBill01>();
	
	       //add
			public PremGBill01Group() {
			}
			
			public List<PremGBill01> getPremGBill01() {
				return premgbill01s;
			}
			
			public void addPremGBill01(PremGBill01 premgbill01) {
				List<PremGBill01> oldValue =  premgbill01s;
				premgbill01s = new ArrayList<PremGBill01>(premgbill01s);
				premgbill01s.add(premgbill01);
				
				firePropertyChange("premGBill01", oldValue, premgbill01s);
			}


			public void removePremGBill01(PremGBill01 premgbill01) {
				premgbill01s.remove(premgbill01);
			}

			public void removeAll() {
				List<PremGBill01> oldValue = premgbill01s;
				premgbill01s = new ArrayList<PremGBill01>(premgbill01s);
				premgbill01s.clear();
				
				firePropertyChange("premgbill01", oldValue, premgbill01s);
			}


			public int getPremGBill01Count() {
				return premgbill01s.size();
			}
}
