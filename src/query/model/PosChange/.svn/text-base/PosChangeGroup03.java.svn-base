package query.model.PosChange;

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;

public class PosChangeGroup03 extends AbstractModelObject {
	private List<PosChange03> posChange03s = new ArrayList<PosChange03>();

	public PosChangeGroup03() {
	}

	public List<PosChange03> getPosChange03s() {
		return posChange03s;
	}

	public void addPosChange03(PosChange03 posChange03) {
		List<PosChange03> oldValue = posChange03s;
		posChange03s = new ArrayList<PosChange03>(posChange03s);
		posChange03s.add(posChange03);
		firePropertyChange("posChange03s", oldValue, posChange03);
	}

	public void removePosChange03(PosChange03 posChange03) {
		posChange03s.remove(posChange03);
	}

	public void removeAll() {
		List<PosChange03> oldValue = posChange03s;
		posChange03s = new ArrayList<PosChange03>(posChange03s);
		posChange03s.clear();
		firePropertyChange("posChange03s", oldValue, posChange03s);
	}


}
