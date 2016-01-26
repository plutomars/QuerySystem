/**
 * 
 */
package query.model.PosChange;

import java.util.ArrayList;
import java.util.List;
import query.model.PosChange.PosChange05;

import query.model.AbstractModelObject;

/**
 * @author F1256819
 * @category 其它契變保單
 *
 */
public class PosChangeGroup05 extends AbstractModelObject {

	/**
	 * 
	 */
	private List<PosChange05> posChange05s = new ArrayList<PosChange05>();
	
	public PosChangeGroup05() {
	}

	public List<PosChange05> getPosChange05s() {
		return posChange05s;
	}

	public void addPosChange05(PosChange05 PosChange05) {
		List<PosChange05> oldValue = posChange05s;
		posChange05s = new ArrayList<PosChange05>(posChange05s);
		posChange05s.add(PosChange05);
		firePropertyChange("posChange05s", oldValue, PosChange05);
	}

	public void removePosChange05(PosChange05 PosChange05) {
		posChange05s.remove(PosChange05);
	}

	public void removeAll() {
		List<PosChange05> oldValue = posChange05s;
		posChange05s = new ArrayList<PosChange05>(posChange05s);
		posChange05s.clear();
		firePropertyChange("posChange05s", oldValue, posChange05s);
	}
	public int getPosChange05sCount(){
		return posChange05s.size();
	}


}
