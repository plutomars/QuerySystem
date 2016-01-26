package query.model.ValueRepay;

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;

public class ValueRepayGroup08 extends AbstractModelObject {
	private List<ValueRepay08> valueRepay08s = new ArrayList<ValueRepay08>();

	public ValueRepayGroup08() {
	}

	public List<ValueRepay08> getValueRepay08s() {
		return valueRepay08s;
	}

	public void addValueRepay08(ValueRepay08 valueRepay08) {
		List<ValueRepay08> oldValue = valueRepay08s;
		valueRepay08s = new ArrayList<ValueRepay08>(valueRepay08s);
		valueRepay08s.add(valueRepay08);

		firePropertyChange("valueRepay08s", oldValue, valueRepay08s);
	}

	public void removeRelation(ValueRepay08 relation) {
		valueRepay08s.remove(relation);
	}

	public void removeAll() {
		List<ValueRepay08> oldValue = valueRepay08s;
		valueRepay08s = new ArrayList<ValueRepay08>(valueRepay08s);
		valueRepay08s.clear();
		firePropertyChange("valueRepay08s", oldValue, valueRepay08s);
	}

	public int getValueRepay08Count() {
		return valueRepay08s.size();
	}

}
