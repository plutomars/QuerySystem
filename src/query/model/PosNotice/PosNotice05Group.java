package query.model.PosNotice;

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;
/**
 * @author cychu
 * 
 * @version 1.0<br/>
 * 			100/09/07<br/>
 * 			體檢項目群組(JavaBeanGroup)
 * 
 * @since 1.0
 */
public class PosNotice05Group extends AbstractModelObject {
	private List<PosNotice05> posNotice05s = new ArrayList<PosNotice05>();
	
	public PosNotice05Group() {
	}

	public List<PosNotice05> getposNotice05s() {
		return posNotice05s;
	}

	public void addPosNotice05(PosNotice05 posNotice05) {
		List<PosNotice05> oldValue = posNotice05s;
		posNotice05s = new ArrayList<PosNotice05>(posNotice05s);
		posNotice05s.add(posNotice05);

		firePropertyChange("posNotice05s", oldValue, posNotice05s);
	}

	public void removePosNotice05(PosNotice05 posNotice05) {
		posNotice05s.remove(posNotice05);
	}

	public void removeAll() {
		List<PosNotice05> oldValue = posNotice05s;
		posNotice05s = new ArrayList<PosNotice05>(posNotice05s);
		posNotice05s.clear();
		firePropertyChange("posNotice04s", oldValue, posNotice05s);
	}

	public int getPosNotice05Count() {
		return posNotice05s.size();
	}
}
