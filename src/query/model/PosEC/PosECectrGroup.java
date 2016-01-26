package query.model.PosEC;

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;
//import query.model.PosEC.PosECectr;

public class PosECectrGroup extends AbstractModelObject {
	private List<PosECectr> posECectrs = new ArrayList<PosECectr>();
	
	public PosECectrGroup() {
	}

	public List<PosECectr> getPosECectrs() {
		return posECectrs;
	}

	public void addPosECectr(PosECectr posECectr) {
		List<PosECectr> oldValue = posECectrs;
		posECectrs = new ArrayList<PosECectr>(posECectrs);
		posECectrs.add(posECectr);

		firePropertyChange("posECectrs", oldValue, posECectrs);
	}

	public void removePosECectr(PosECectr posECectr) {
		posECectrs.remove(posECectr);
	}

	public void removeAll() {
		List<PosECectr> oldValue = posECectrs;
		posECectrs = new ArrayList<PosECectr>(posECectrs);
		posECectrs.clear();
		firePropertyChange("posECectrs", oldValue, posECectrs);
	}

	public int  PosECectrCount() {
		return posECectrs.size();
	}
}
