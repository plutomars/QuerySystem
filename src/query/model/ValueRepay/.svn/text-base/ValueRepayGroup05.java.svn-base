package query.model.ValueRepay;

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;

public class ValueRepayGroup05 extends AbstractModelObject {
	private List<ValueRepay05> valueRepay05s = new ArrayList<ValueRepay05>();

	public ValueRepayGroup05() {
	}

	public List<ValueRepay05> getValueRepay05s() {
		return valueRepay05s;
	}

	public void addValueRepay05(ValueRepay05 valueRepay05) {
		List<ValueRepay05> oldValue = valueRepay05s;
		valueRepay05s = new ArrayList<ValueRepay05>(valueRepay05s);
		valueRepay05s.add(valueRepay05);

		firePropertyChange("valueRepay05s", oldValue, valueRepay05s);
	}

	public void removeRelation(ValueRepay05 relation) {
		valueRepay05s.remove(relation);
	}

	public void removeAll() {
		List<ValueRepay05> oldValue = valueRepay05s;
		valueRepay05s = new ArrayList<ValueRepay05>(valueRepay05s);
		valueRepay05s.clear();
		firePropertyChange("valueRepay05s", oldValue, valueRepay05s);
	}

	public int getValueRepay05Count() {
		return valueRepay05s.size();
	}

}
