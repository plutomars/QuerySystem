package query.model.ValueRepay;

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;

/**
 * @author F1256819
 * @category 還本未回回覆 抵繳保單
 */
public class ValueRepayGroup11 extends AbstractModelObject {

	private List<ValueRepay11> valueRepay11s = new ArrayList<ValueRepay11>();

	public ValueRepayGroup11() {
	}

	public List<ValueRepay11> getValueRepay11s() {
		return valueRepay11s;
	}

	public void addValueRepay11(ValueRepay11 valueRepay11) {
		List<ValueRepay11> oldValue = valueRepay11s;
		valueRepay11s = new ArrayList<ValueRepay11>(valueRepay11s);
		valueRepay11s.add(valueRepay11);

		firePropertyChange("valueRepay11s", oldValue, valueRepay11s);
	}

	public void removeRelation(ValueRepay11 relation) {
		valueRepay11s.remove(relation);
	}

	public void removeAll() {
		List<ValueRepay11> oldValue = valueRepay11s;
		valueRepay11s = new ArrayList<ValueRepay11>(valueRepay11s);
		valueRepay11s.clear();
		firePropertyChange("valueRepay11s", oldValue, valueRepay11s);
	}

	public int getValueRepay11Count() {
		return valueRepay11s.size();
	}
}
