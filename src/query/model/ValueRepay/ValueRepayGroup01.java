package query.model.ValueRepay;

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;

public class ValueRepayGroup01 extends AbstractModelObject {
	private List<ValueRepay01> valueRepay01s = new ArrayList<ValueRepay01>();
	
	public ValueRepayGroup01() {
	}
	public List<ValueRepay01> getValueRepay01s() {
		return valueRepay01s;
	}

	public void addValueRepay01(ValueRepay01 valueRepay01) {
		List<ValueRepay01> oldValue = valueRepay01s;
		valueRepay01s = new ArrayList<ValueRepay01>(valueRepay01s);
		valueRepay01s.add(valueRepay01);

		firePropertyChange("valueRepay01s", oldValue, valueRepay01s);
	}

	public void removeRelation(ValueRepay01 relation) {
		valueRepay01s.remove(relation);
	}

	public void removeAll() {
		List<ValueRepay01> oldValue = valueRepay01s;
		valueRepay01s = new ArrayList<ValueRepay01>(valueRepay01s);
		valueRepay01s.clear();
		firePropertyChange("valueRepay01s", oldValue, valueRepay01s);
	}

	public int getValueRepay01Count() {
		return valueRepay01s.size();
	}


}
