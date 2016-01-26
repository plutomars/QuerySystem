package query.model.PosNotice;

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;
/**
 * @author cychu
 * 
 * @version 1.0<br/>
 * 			100/09/07<br/>
 * 			照會補件群組(JavaBeanGroup)
 * 
 * @since 1.0
 */
public class PosNotice02Group extends AbstractModelObject {
	private List<PosNotice02> posNotice02s = new ArrayList<PosNotice02>();
	
	public PosNotice02Group() {
	}

	public List<PosNotice02> getPosNotice02s() {
		return posNotice02s;
	}

	public void addPosNotice02(PosNotice02 posNotice02) {
		List<PosNotice02> oldValue = posNotice02s;
		posNotice02s = new ArrayList<PosNotice02>(posNotice02s);
		posNotice02s.add(posNotice02);

		firePropertyChange("posNotice02s", oldValue, posNotice02s);
	}

	public void removePosNotice02(PosNotice02 posNotice02) {
		posNotice02s.remove(posNotice02);
	}

	public void removeAll() {
		List<PosNotice02> oldValue = posNotice02s;
		posNotice02s = new ArrayList<PosNotice02>(posNotice02s);
		posNotice02s.clear();
		firePropertyChange("posNotice02s", oldValue, posNotice02s);
	}

	public int getPosNotice02Count() {
		return posNotice02s.size();
	}
}
