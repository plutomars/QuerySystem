package query.model.PosChange;

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;

public class PosChangeGroup02 extends AbstractModelObject {
	private List<PosChange02> posChange02s = new ArrayList<PosChange02>();

	public PosChangeGroup02() {
	}

	public List<PosChange02> getPosChange02s() {
		return posChange02s;
	}

	public void addPosChange02(PosChange02 posChange02) {
		List<PosChange02> oldValue = posChange02s;
		posChange02s = new ArrayList<PosChange02>(posChange02s);
		posChange02s.add(posChange02);
		firePropertyChange("posChange02s", oldValue, posChange02);
	}

	public void removePosChange02(PosChange02 posChange02) {
		posChange02s.remove(posChange02);
	}

	public void removeAll() {
		List<PosChange02> oldValue = posChange02s;
		posChange02s = new ArrayList<PosChange02>(posChange02s);
		posChange02s.clear();
		firePropertyChange("posChange02s", oldValue, posChange02s);
	}

}
