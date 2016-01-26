package query.model.NewFaceAmount;

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;

public class NewFaceAmountIPAGroup extends AbstractModelObject {
	private List<NewFaceAmountIPA> newfaceamountIPAs = new ArrayList<NewFaceAmountIPA>();

	public NewFaceAmountIPAGroup() {
	}

	public List<NewFaceAmountIPA> getNewFaceAmountIPAs() {
		return newfaceamountIPAs;
	}

	public void addNewFaceAmountIPA(NewFaceAmountIPA newfaceamountIPA) {
		List<NewFaceAmountIPA> oldValue = newfaceamountIPAs;
		newfaceamountIPAs = new ArrayList<NewFaceAmountIPA>(newfaceamountIPAs);
		newfaceamountIPAs.add(newfaceamountIPA);

		firePropertyChange("newFaceAmountIPAs", oldValue, newfaceamountIPAs);
		// firePropertyChange的第一個參數為List的method名稱，要跟Binding的名稱相同
	}

	public void removeNewFaceAmountIPA(NewFaceAmountIPA newfaceamountIPA) {
		newfaceamountIPAs.remove(newfaceamountIPA);
	}

	public void removeAll() {
		List<NewFaceAmountIPA> oldValue = newfaceamountIPAs;
		newfaceamountIPAs = new ArrayList<NewFaceAmountIPA>(newfaceamountIPAs);
		newfaceamountIPAs.clear();
		firePropertyChange("newFaceAmountIPAs", oldValue, newfaceamountIPAs);
	}

	public int getNewFaceAmountIPACount() {
		return newfaceamountIPAs.size();
	}
}
