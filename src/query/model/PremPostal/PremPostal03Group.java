package query.model.PremPostal;

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;

public class PremPostal03Group extends AbstractModelObject {
private List<PremPostal03> premPostal03s = new ArrayList<PremPostal03>();
	
	public PremPostal03Group() {
	}

	public List<PremPostal03> getPremPostal03s() {
		return premPostal03s;
	}

	public void addPremPostal03(PremPostal03 premPostal03) {
		List<PremPostal03> oldValue = premPostal03s;
		premPostal03s = new ArrayList<PremPostal03>(premPostal03s);
		premPostal03s.add(premPostal03);
		firePropertyChange("premPostal03s", oldValue, premPostal03s);
	}

	public void removePremPostal03(PremPostal03 premPostal03) {
		premPostal03s.remove(premPostal03);
	}

	public void removeAll() {
		List<PremPostal03> oldValue = premPostal03s;
		premPostal03s = new ArrayList<PremPostal03>(premPostal03s);
		premPostal03s.clear();
		firePropertyChange("premPostal03s", oldValue, premPostal03s);
	}

	public int  PremPostal03Count() {
		return premPostal03s.size();
	}
}
