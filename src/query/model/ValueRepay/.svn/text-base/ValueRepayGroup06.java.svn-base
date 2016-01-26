package query.model.ValueRepay;

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;

public class ValueRepayGroup06 extends AbstractModelObject {
	private List<ValueRepay06> valueRepay06s = new ArrayList<ValueRepay06>();

	public ValueRepayGroup06() {
	}

	public List<ValueRepay06> getValueRepay06s() {
		return valueRepay06s;
	}

	public void addValueRepay06(ValueRepay06 valueRepay06) {
		List<ValueRepay06> oldValue = valueRepay06s;
		valueRepay06s = new ArrayList<ValueRepay06>(valueRepay06s);
		valueRepay06s.add(valueRepay06);

		firePropertyChange("valueRepay06s", oldValue, valueRepay06s);
	}

	public void removeRelation(ValueRepay06 relation) {
		valueRepay06s.remove(relation);
	}

	public void removeAll() {
		List<ValueRepay06> oldValue = valueRepay06s;
		valueRepay06s = new ArrayList<ValueRepay06>(valueRepay06s);
		valueRepay06s.clear();
		firePropertyChange("valueRepay06s", oldValue, valueRepay06s);
	}

	public int getValueRepay06Count() {
		return valueRepay06s.size();
	}


}
