package query.model.PoDetail;

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;

public class PoDetailECacctGroup extends AbstractModelObject {
	private List<PoDetailECacct> poDetailECaccts = new ArrayList<PoDetailECacct>();
	
	public PoDetailECacctGroup() {
	}

	public List<PoDetailECacct> getPoDetailECaccts() {
		return poDetailECaccts;
	}

	public void addPoDetailECacct(PoDetailECacct poDetailECacct) {
		List<PoDetailECacct> oldValue = poDetailECaccts;
		poDetailECaccts = new ArrayList<PoDetailECacct>(poDetailECaccts);
		poDetailECaccts.add(poDetailECacct);

		firePropertyChange("poDetailECaccts", oldValue, poDetailECaccts);
	}

	public void removePoDetailECacct(PoDetailECacct poDetailECacct) {
		poDetailECaccts.remove(poDetailECacct);
	}

	public void removeAll() {
		List<PoDetailECacct> oldValue = poDetailECaccts;
		poDetailECaccts = new ArrayList<PoDetailECacct>(poDetailECaccts);
		poDetailECaccts.clear();
		firePropertyChange("poDetailECaccts", oldValue, poDetailECaccts);
	}

	public int  PoDetailECacctCount() {
		return poDetailECaccts.size();
	}
}
