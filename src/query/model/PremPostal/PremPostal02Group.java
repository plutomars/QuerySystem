package query.model.PremPostal;

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;

public class PremPostal02Group extends AbstractModelObject {
	private List<PremPostal02> premPostal02s = new ArrayList<PremPostal02>();
	
	public PremPostal02Group() {
	}

	public List<PremPostal02> getPremPostal02s() {
		return premPostal02s;
	}

	public void addPremPostal02(PremPostal02 premPostal02) {
		List<PremPostal02> oldValue = premPostal02s;
		premPostal02s = new ArrayList<PremPostal02>(premPostal02s);
		premPostal02s.add(premPostal02);
		firePropertyChange("premPostal02s", oldValue, premPostal02s);
	}

	public void removePremPostal02(PremPostal02 premPostal02) {
		premPostal02s.remove(premPostal02);
	}

	public void removeAll() {
		List<PremPostal02> oldValue = premPostal02s;
		premPostal02s = new ArrayList<PremPostal02>(premPostal02s);
		premPostal02s.clear();
		firePropertyChange("premPostal02s", oldValue, premPostal02s);
	}

	public int  PremPostal02Count() {
		return premPostal02s.size();
	}
}
