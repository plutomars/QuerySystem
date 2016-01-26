package query.model.PosNotice;

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;
/**
 * @author cychu
 * 
 * @version 1.0<br/>
 * 			100/09/07<br/>
 * 			照會繳費群組(JavaBeanGroup)
 * 
 * @since 1.0
 */
public class PosNotice01Group extends AbstractModelObject {
	private List<PosNotice01> posNotice01s = new ArrayList<PosNotice01>();

	public PosNotice01Group() {
	}

	public List<PosNotice01> getPosNotice01s() {
		return posNotice01s;
	}

	public void addPosNotice01(PosNotice01 posNotice01) {
		List<PosNotice01> oldValue = posNotice01s;
		posNotice01s = new ArrayList<PosNotice01>(posNotice01s);
		posNotice01s.add(posNotice01);

		firePropertyChange("posNotice01s", oldValue, posNotice01s);
	}

	public void removePosNotice01(PosNotice01 posNotice01) {
		posNotice01s.remove(posNotice01);
	}

	public void removeAll() {
		List<PosNotice01> oldValue = posNotice01s;
		posNotice01s = new ArrayList<PosNotice01>(posNotice01s);
		posNotice01s.clear();
		firePropertyChange("posNotice01s", oldValue, posNotice01s);
	}

	public int getPosNotice01Count() {
		return posNotice01s.size();
	}
}
