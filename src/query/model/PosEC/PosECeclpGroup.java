package query.model.PosEC;

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;

public class PosECeclpGroup extends AbstractModelObject {
	private List<PosECeclp> posECeclps = new ArrayList<PosECeclp>();
	
	public PosECeclpGroup() {
	}

	public List<PosECeclp> getPosECeclps() {
		return posECeclps;
	}

	public void addPosECeclp(PosECeclp posECeclp) {
		List<PosECeclp> oldValue = posECeclps;
		posECeclps = new ArrayList<PosECeclp>(posECeclps);
		posECeclps.add(posECeclp);

		firePropertyChange("posECeclps", oldValue, posECeclps);
	}

	public void removePosECeclp(PosECeclp posECeclp) {
		posECeclps.remove(posECeclp);
	}

	public void removeAll() {
		List<PosECeclp> oldValue = posECeclps;
		posECeclps = new ArrayList<PosECeclp>(posECeclps);
		posECeclps.clear();
		firePropertyChange("posECeclps", oldValue, posECeclps);
	}

	public int  PosECeclpCount() {
		return posECeclps.size();
	}
}
