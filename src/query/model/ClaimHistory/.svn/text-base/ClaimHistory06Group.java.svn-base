package query.model.ClaimHistory;

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;

/**
 * @ * @author FYYANG
 * 
 * @version 1.0<br>
 *          100/08/23<br>
 *          ИsВе(JavaBean)
 * @since 1.0
 */
public class ClaimHistory06Group extends AbstractModelObject {
	private List<ClaimHistory06> claimHistory06s = new ArrayList<ClaimHistory06>();

	public ClaimHistory06Group() {
	}

	public List<ClaimHistory06> getClaimHistory06s() {
		return claimHistory06s;
	}

	public void addClaimHistory06(ClaimHistory06 claimHistory06) {
		List<ClaimHistory06> oldValue = claimHistory06s;
		claimHistory06s = new ArrayList<ClaimHistory06>(claimHistory06s);
		claimHistory06s.add(claimHistory06);

		firePropertyChange("claimHistory06s", oldValue, claimHistory06s);
	}

	public void removeClaimHistory06(ClaimHistory06 claimHistory06) {
		claimHistory06s.remove(claimHistory06);
	}

	public void removeAll() {
		List<ClaimHistory06> oldValue = claimHistory06s;
		claimHistory06s = new ArrayList<ClaimHistory06>(claimHistory06s);
		claimHistory06s.clear();
		firePropertyChange("claimHistory06s", oldValue, claimHistory06s);
	}

}
