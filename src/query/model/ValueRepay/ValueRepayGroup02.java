package query.model.ValueRepay;

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;
import query.model.ValueRepay.ValueRepay02;

public class ValueRepayGroup02 extends AbstractModelObject {
	private List<ValueRepay02> valueRepay02s = new ArrayList<ValueRepay02>();

	public ValueRepayGroup02() {
	}

	public List<ValueRepay02> getValueRepay02s() {
		return valueRepay02s;
	}

	public void addValueRepay02(ValueRepay02 valueRepay02) {
		List<ValueRepay02> oldValue = valueRepay02s;
		valueRepay02s = new ArrayList<ValueRepay02>(valueRepay02s);
		valueRepay02s.add(valueRepay02);

		firePropertyChange("valueRepay02s", oldValue, valueRepay02s);
	}

	public void removeRelation(ValueRepay02 relation) {
		valueRepay02s.remove(relation);
	}

	public void removeAll() {
		List<ValueRepay02> oldValue = valueRepay02s;
		valueRepay02s = new ArrayList<ValueRepay02>(valueRepay02s);
		valueRepay02s.clear();
		firePropertyChange("valueRepay02s", oldValue, valueRepay02s);
	}

	public int getValueRepay02Count() {
		return valueRepay02s.size();
	}

}
