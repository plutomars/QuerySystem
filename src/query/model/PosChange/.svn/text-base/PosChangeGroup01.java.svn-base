package query.model.PosChange;

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;

public class PosChangeGroup01 extends AbstractModelObject {
	private List<PosChange01> posChange01s = new ArrayList<PosChange01>();

	public PosChangeGroup01() {
	}

	public List<PosChange01> getPosChange01s() {
		return posChange01s;
	}

	public void addPosChange01(PosChange01 posChange01) {
		List<PosChange01> oldValue = posChange01s;
		posChange01s = new ArrayList<PosChange01>(posChange01s);
		posChange01s.add(posChange01);
		firePropertyChange("posChange01s", oldValue, posChange01);
	}

	public void removePosChange01(PosChange01 posChange01) {
		posChange01s.remove(posChange01);
	}

	public void removeAll() {
		List<PosChange01> oldValue = posChange01s;
		posChange01s = new ArrayList<PosChange01>(posChange01s);
		posChange01s.clear();
		firePropertyChange("posChange01s", oldValue, posChange01s);
	}

}
