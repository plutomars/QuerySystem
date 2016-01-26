package query.model.PoDetail;

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;

public class PoDetailECpasswdGroup extends AbstractModelObject {
	private List<PoDetailECpasswd> poDetailECpasswds = new ArrayList<PoDetailECpasswd>();
	
	public PoDetailECpasswdGroup() {
	}

	public List<PoDetailECpasswd> getPoDetailECpasswds() {
		return poDetailECpasswds;
	}

	public void addPoDetailECpasswd(PoDetailECpasswd poDetailECpasswd) {
		List<PoDetailECpasswd> oldValue = poDetailECpasswds;
		poDetailECpasswds = new ArrayList<PoDetailECpasswd>(poDetailECpasswds);
		poDetailECpasswds.add(poDetailECpasswd);

		firePropertyChange("poDetailECpasswds", oldValue, poDetailECpasswds);
	}

	public void removePoDetailECpasswd(PoDetailECpasswd poDetailECpasswd) {
		poDetailECpasswds.remove(poDetailECpasswd);
	}

	public void removeAll() {
		List<PoDetailECpasswd> oldValue = poDetailECpasswds;
		poDetailECpasswds = new ArrayList<PoDetailECpasswd>(poDetailECpasswds);
		poDetailECpasswds.clear();
		firePropertyChange("poDetailECpasswds", oldValue, poDetailECpasswds);
	}

	public int  PoDetailECpasswdCount() {
		return poDetailECpasswds.size();
	}
}
