package query.model.PoDetail;

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;

public class PoDetailECinsuredGroup extends AbstractModelObject {
	private List<PoDetailECinsured> poDetailECinsureds = new ArrayList<PoDetailECinsured>();
	
	public PoDetailECinsuredGroup() {
	}

	public List<PoDetailECinsured> getPoDetailECinsureds() {
		return poDetailECinsureds;
	}

	public void addPoDetailECinsured(PoDetailECinsured poDetailECinsured) {
		List<PoDetailECinsured> oldValue = poDetailECinsureds;
		poDetailECinsureds = new ArrayList<PoDetailECinsured>(poDetailECinsureds);
		poDetailECinsureds.add(poDetailECinsured);

		firePropertyChange("poDetailECinsureds", oldValue, poDetailECinsureds);
	}

	public void removePoDetailECinsured(PoDetailECinsured poDetailECinsured) {
		poDetailECinsureds.remove(poDetailECinsured);
	}

	public void removeAll() {
		List<PoDetailECinsured> oldValue = poDetailECinsureds;
		poDetailECinsureds = new ArrayList<PoDetailECinsured>(poDetailECinsureds);
		poDetailECinsureds.clear();
		firePropertyChange("poDetailECinsureds", oldValue, poDetailECinsureds);
	}

	public int  PoDetailECinsuredCount() {
		return poDetailECinsureds.size();
	}
}
