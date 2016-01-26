package query.model.ValueRepay;

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;

public class ValueRepayGroup04 extends AbstractModelObject {
	private List<ValueRepay04> valueRepay04s = new ArrayList<ValueRepay04>();

	public ValueRepayGroup04() {
	}

	public List<ValueRepay04> getValueRepay04s() {
		return valueRepay04s;
	}

	public void addValueRepay04(ValueRepay04 valueRepay04) {
		List<ValueRepay04> oldValue = valueRepay04s;
		valueRepay04s = new ArrayList<ValueRepay04>(valueRepay04s);
		valueRepay04s.add(valueRepay04);

		firePropertyChange("valueRepay04s", oldValue, valueRepay04s);
	}

	public void removeRelation(ValueRepay04 relation) {
		valueRepay04s.remove(relation);
	}

	public void removeAll() {
		List<ValueRepay04> oldValue = valueRepay04s;
		valueRepay04s = new ArrayList<ValueRepay04>(valueRepay04s);
		valueRepay04s.clear();
		firePropertyChange("valueRepay04s", oldValue, valueRepay04s);
	}

	public int getValueRepay04Count() {
		return valueRepay04s.size();
	}

}
