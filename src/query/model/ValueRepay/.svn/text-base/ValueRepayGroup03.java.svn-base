package query.model.ValueRepay;

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;

public class ValueRepayGroup03 extends AbstractModelObject {
	private List<ValueRepay03> valueRepay03s = new ArrayList<ValueRepay03>();

	public ValueRepayGroup03() {
	}

	public List<ValueRepay03> getValueRepay03s() {
		return valueRepay03s;
	}

	public void addValueRepay03(ValueRepay03 valueRepay03) {
		List<ValueRepay03> oldValue = valueRepay03s;
		valueRepay03s = new ArrayList<ValueRepay03>(valueRepay03s);
		valueRepay03s.add(valueRepay03);

		firePropertyChange("valueRepay03s", oldValue, valueRepay03s);
	}

	public void removeRelation(ValueRepay03 relation) {
		valueRepay03s.remove(relation);
	}

	public void removeAll() {
		List<ValueRepay03> oldValue = valueRepay03s;
		valueRepay03s = new ArrayList<ValueRepay03>(valueRepay03s);
		valueRepay03s.clear();
		firePropertyChange("valueRepay03s", oldValue, valueRepay03s);
	}

	public int getValueRepay03Count() {
		return valueRepay03s.size();
	}

}
