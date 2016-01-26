package query.model.PremBill;

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;
/**
 * 
 * @author cychu
 *
 * @version 1.0<br/>
 * 			100/08/17<br/>
 * 			目前扣款資料群組(JavaBeanGroup)
 * 
 * @since 1.0
 */
public class PremBillGroup extends AbstractModelObject {
	private List<PremBill> premBills = new ArrayList<PremBill>();
	
	public PremBillGroup() {
	}

	public List<PremBill> getPremBills() {
		return premBills;
	}

	public void addPremBill(PremBill premBill) {
		List<PremBill> oldValue = premBills;
		premBills = new ArrayList<PremBill>(premBills);
		premBills.add(premBill);

		firePropertyChange("premBills", oldValue, premBills);
	}

	public void removePremBill(PremBill premBill) {
		premBills.remove(premBill);
	}

	public void removeAll() {
		List<PremBill> oldValue = premBills;
		premBills = new ArrayList<PremBill>(premBills);
		premBills.clear();
		firePropertyChange("premBills", oldValue, premBills);
	}

	public int getPremBillCount() {
		return premBills.size();
	}
}
