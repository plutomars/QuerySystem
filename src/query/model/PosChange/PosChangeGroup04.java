package query.model.PosChange;

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;

public class PosChangeGroup04 extends AbstractModelObject {
	private List<PosChange04> posChange04s = new ArrayList<PosChange04>();

	public PosChangeGroup04() {
	}

	public List<PosChange04> getPosChange04s() {
		return posChange04s;
	}

	public void addPosChange04(PosChange04 posChange04) {
		List<PosChange04> oldValue = posChange04s;
		posChange04s = new ArrayList<PosChange04>(posChange04s);
		posChange04s.add(posChange04);
		firePropertyChange("posChange04s", oldValue, posChange04);
	}

	public void removePosChange04(PosChange04 posChange04) {
		posChange04s.remove(posChange04);
	}

	public void removeAll() {
		List<PosChange04> oldValue = posChange04s;
		posChange04s = new ArrayList<PosChange04>(posChange04s);
		posChange04s.clear();
		firePropertyChange("posChange04s", oldValue, posChange04s);
	}

}
