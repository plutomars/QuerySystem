package query.model.ValueRepay;

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;

public class ValueRepayGroup07 extends AbstractModelObject {
	private List<ValueRepay07> valueRepay07s = new ArrayList<ValueRepay07>();

	public ValueRepayGroup07() {
	}

	public List<ValueRepay07> getValueRepay07s() {
		return valueRepay07s;
	}

	public void addValueRepay07(ValueRepay07 valueRepay07) {
		List<ValueRepay07> oldValue = valueRepay07s;
		valueRepay07s = new ArrayList<ValueRepay07>(valueRepay07s);
		valueRepay07s.add(valueRepay07);

		firePropertyChange("valueRepay07s", oldValue, valueRepay07s);
	}

	public void removeRelation(ValueRepay07 relation) {
		valueRepay07s.remove(relation);
	}

	public void removeAll() {
		List<ValueRepay07> oldValue = valueRepay07s;
		valueRepay07s = new ArrayList<ValueRepay07>(valueRepay07s);
		valueRepay07s.clear();
		firePropertyChange("valueRepay07s", oldValue, valueRepay07s);
	}

	public int getValueRepay07Count() {
		return valueRepay07s.size();
	}

}
