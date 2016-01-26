package query.model.PoDetail;

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;

public class PoDetailECprintGroup extends AbstractModelObject {
	private List<PoDetailECprint> poDetailECprints = new ArrayList<PoDetailECprint>();
	
	public PoDetailECprintGroup() {
	}

	public List<PoDetailECprint> getPoDetailECprints() {
		return poDetailECprints;
	}

	public void addPoDetailECprint(PoDetailECprint poDetailECprint) {
		List<PoDetailECprint> oldValue = poDetailECprints;
		poDetailECprints = new ArrayList<PoDetailECprint>(poDetailECprints);
		poDetailECprints.add(poDetailECprint);

		firePropertyChange("poDetailECprints", oldValue, poDetailECprints);
	}

	public void removePoDetailECprint(PoDetailECprint poDetailECprint) {
		poDetailECprints.remove(poDetailECprint);
	}

	public void removeAll() {
		List<PoDetailECprint> oldValue = poDetailECprints;
		poDetailECprints = new ArrayList<PoDetailECprint>(poDetailECprints);
		poDetailECprints.clear();
		firePropertyChange("poDetailECprints", oldValue, poDetailECprints);
	}

	public int  PoDetailECprintCount() {
		return poDetailECprints.size();
	}
}
