package query.model.ClaimHistory;

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;

public class ClaimHistory02eventGroup extends AbstractModelObject {
	private List<ClaimHistory02event> claimHistory02events = new ArrayList<ClaimHistory02event>();

	public ClaimHistory02eventGroup() {
	}

	public List<ClaimHistory02event> getClaimHistory02events() {
		return claimHistory02events;
	}

	public void addClaimHistory02event(ClaimHistory02event claimHistory02event) {
		List<ClaimHistory02event> oldValue = claimHistory02events;
		claimHistory02events = new ArrayList<ClaimHistory02event>(claimHistory02events);
		claimHistory02events.add(claimHistory02event);

		firePropertyChange("claimHistory02events", oldValue, claimHistory02events);
	}

	public void removeClaimHistory02event(ClaimHistory02event claimHistory02event) {
		claimHistory02events.remove(claimHistory02event);
	}

	public void removeAll() {
		List<ClaimHistory02event> oldValue = claimHistory02events;
		claimHistory02events = new ArrayList<ClaimHistory02event>(claimHistory02events);
		claimHistory02events.clear();
		firePropertyChange("claimHistory02events", oldValue, claimHistory02events);
	}
}
