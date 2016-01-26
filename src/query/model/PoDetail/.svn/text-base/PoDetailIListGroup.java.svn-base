package query.model.PoDetail;

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;
/**
 * «O³æ©ú²Ó
 * @author cora
 * 100/08
 */

public class PoDetailIListGroup extends AbstractModelObject {
	private List<PoDetailIList> poDetailILists = new ArrayList<PoDetailIList>();
	
	public PoDetailIListGroup() {
	}

	public List<PoDetailIList> getPoDetailILists() {
		return poDetailILists;
	}

	public void addPoDetailIList(PoDetailIList poDetailILi) {
		List<PoDetailIList> oldValue = poDetailILists;
		poDetailILists = new ArrayList<PoDetailIList>(poDetailILists);
		poDetailILists.add(poDetailILi);

		firePropertyChange("poDetailILists", oldValue, poDetailILists);
	}

	public void removePoDetailIList(PoDetailIList poDetailILi) {
		poDetailILists.remove(poDetailILi);
	}

	public void removeAll() {
		List<PoDetailIList> oldValue = poDetailILists;
		poDetailILists = new ArrayList<PoDetailIList>(poDetailILists);
		poDetailILists.clear();
		firePropertyChange("poDetailILists", oldValue, poDetailILists);
	}

	public int  PoDetailIListCount() {
		return poDetailILists.size();
	}
}

