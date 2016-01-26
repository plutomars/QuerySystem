package query.model.ClaimHistory;

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;

/**
 * @ * @author FYYANG
 * 
 * @version 1.0<br>
 *          100/09/28<br>
 *          ²z½ßµù°O¸s²Õ(JavaBean)
 * @since 1.0
 */
public class ClaimHistory10Group extends AbstractModelObject {
	private List<ClaimHistory10> claimHistory10s = new ArrayList<ClaimHistory10>();

	public ClaimHistory10Group() {
	}

	public List<ClaimHistory10> getClaimHistory10s() {
		return claimHistory10s;
	}

	public void addClaimHistory10(ClaimHistory10 claimHistory10) {
		List<ClaimHistory10> oldValue = claimHistory10s;
		claimHistory10s = new ArrayList<ClaimHistory10>(claimHistory10s);
		claimHistory10s.add(claimHistory10);

		firePropertyChange("claimHistory10s", oldValue, claimHistory10s);
	}

	public void removeClaimHistory10(ClaimHistory10 claimHistory10) {
		claimHistory10s.remove(claimHistory10);
	}

	public void removeAll() {
		List<ClaimHistory10> oldValue = claimHistory10s;
		claimHistory10s = new ArrayList<ClaimHistory10>(claimHistory10s);
		claimHistory10s.clear();
		firePropertyChange("claimHistory10s", oldValue, claimHistory10s);
	}

}
