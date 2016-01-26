package query.model.ValueRepay;

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;

/**
 * @author F1256819
 * @category 還本未回回覆 給付明細
 */
public class ValueRepayGroup10 extends AbstractModelObject {

	private List<ValueRepay10> valueRepay10s = new ArrayList<ValueRepay10>();

	public ValueRepayGroup10() {
	}

	public List<ValueRepay10> getValueRepay10s() {
		return valueRepay10s;
	}

	public void addValueRepay10(ValueRepay10 valueRepay10) {
		List<ValueRepay10> oldValue = valueRepay10s;
		valueRepay10s = new ArrayList<ValueRepay10>(valueRepay10s);
		valueRepay10s.add(valueRepay10);

		firePropertyChange("valueRepay10s", oldValue, valueRepay10s);
	}

	public void removeRelation(ValueRepay10 relation) {
		valueRepay10s.remove(relation);
	}

	public void removeAll() {
		List<ValueRepay10> oldValue = valueRepay10s;
		valueRepay10s = new ArrayList<ValueRepay10>(valueRepay10s);
		valueRepay10s.clear();
		firePropertyChange("valueRepay10s", oldValue, valueRepay10s);
	}

	public int getValueRepay10Count() {
		return valueRepay10s.size();
	}
}
