package query.model.PosNotice;

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;
/**
 * @author cychu
 * 
 * @version 1.0<br/>
 * 			100/09/07<br/>
 * 			體檢原因群組(JavaBeanGroup)
 * 
 * @since 1.0
 */
public class PosNotice04Group extends AbstractModelObject {
	private List<PosNotice04> posNotice04s = new ArrayList<PosNotice04>();
	
	public PosNotice04Group() {
	}

	public List<PosNotice04> getposNotice04s() {
		return posNotice04s;
	}

	public void addPosNotice04(PosNotice04 posNotice04) {
		List<PosNotice04> oldValue = posNotice04s;
		posNotice04s = new ArrayList<PosNotice04>(posNotice04s);
		posNotice04s.add(posNotice04);

		firePropertyChange("posNotice04s", oldValue, posNotice04s);
	}

	public void removePosNotice04(PosNotice04 posNotice04) {
		posNotice04s.remove(posNotice04);
	}

	public void removeAll() {
		List<PosNotice04> oldValue = posNotice04s;
		posNotice04s = new ArrayList<PosNotice04>(posNotice04s);
		posNotice04s.clear();
		firePropertyChange("posNotice04s", oldValue, posNotice04s);
	}

	public int getPosNotice04Count() {
		return posNotice04s.size();
	}
}
