package query.model.PosNotice;

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;
/**
 * @author cychu
 * 
 * @version 1.0<br/>
 * 			100/09/07<br/>
 * 			照會項目群組(JavaBeanGroup)
 * 
 * @since 1.0
 */
public class PosNotice03Group extends AbstractModelObject {
	private List<PosNotice03> posNotice03s = new ArrayList<PosNotice03>();
	
	public PosNotice03Group() {
	}

	public List<PosNotice03> getposNotice03s() {
		return posNotice03s;
	}

	public void addPosNotice03(PosNotice03 posNotice03) {
		List<PosNotice03> oldValue = posNotice03s;
		posNotice03s = new ArrayList<PosNotice03>(posNotice03s);
		posNotice03s.add(posNotice03);

		firePropertyChange("posNotice03s", oldValue, posNotice03s);
	}

	public void removePosNotice03(PosNotice03 posNotice03) {
		posNotice03s.remove(posNotice03);
	}

	public void removeAll() {
		List<PosNotice03> oldValue = posNotice03s;
		posNotice03s = new ArrayList<PosNotice03>(posNotice03s);
		posNotice03s.clear();
		firePropertyChange("posNotice03s", oldValue, posNotice03s);
	}

	public int getPosNotice03Count() {
		return posNotice03s.size();
	}
}
