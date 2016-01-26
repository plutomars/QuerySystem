package query.model.ClaimHistory;

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;

/**
 * @ * @author FYYANG
 * 
 * @version 1.0<br>
 *          102/06/19<br>
 *          ИsВе(JavaBean)
 * @since 1.0
 */
public class ClaimHistory12Group extends AbstractModelObject {
	private List<ClaimHistory12> claimHistory12s = new ArrayList<ClaimHistory12>();

	public ClaimHistory12Group() {
	}

	public List<ClaimHistory12> getClaimHistory12s() {
		return claimHistory12s;
	}

	public void addClaimHistory12(ClaimHistory12 ClaimHistory12) {
		List<ClaimHistory12> oldValue = claimHistory12s;
		claimHistory12s = new ArrayList<ClaimHistory12>(claimHistory12s);
		claimHistory12s.add(ClaimHistory12);

		firePropertyChange("claimHistory12s", oldValue, claimHistory12s);
	}

	public void removeClaimHistory12(ClaimHistory12 ClaimHistory12) {
		claimHistory12s.remove(ClaimHistory12);
	}

	public void removeAll() {
		List<ClaimHistory12> oldValue = claimHistory12s;
		claimHistory12s = new ArrayList<ClaimHistory12>(claimHistory12s);
		claimHistory12s.clear();
		firePropertyChange("claimHistory12s", oldValue, claimHistory12s);
	}

}
