package query.model.ValueRepay;

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;

/**
 * @author F1256819
 * @category 還本未回回覆 回覆明細
 */
public class ValueRepayGroup09 extends AbstractModelObject {
	private List<ValueRepay09> valueRepay09s = new ArrayList<ValueRepay09>();

	public ValueRepayGroup09() {
	}

	public List<ValueRepay09> getValueRepay09s() {
		return valueRepay09s;
	}

	public void addValueRepay09(ValueRepay09 valueRepay09) {
		List<ValueRepay09> oldValue = valueRepay09s;
		valueRepay09s = new ArrayList<ValueRepay09>(valueRepay09s);
		valueRepay09s.add(valueRepay09);

		firePropertyChange("valueRepay09s", oldValue, valueRepay09s);
	}

	public void removeRelation(ValueRepay09 relation) {
		valueRepay09s.remove(relation);
	}

	public void removeAll() {
		List<ValueRepay09> oldValue = valueRepay09s;
		valueRepay09s = new ArrayList<ValueRepay09>(valueRepay09s);
		valueRepay09s.clear();
		firePropertyChange("valueRepay09s", oldValue, valueRepay09s);
	}

	public int getValueRepay09Count() {
		return valueRepay09s.size();
	}
}
