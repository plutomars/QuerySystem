package query.model.ClaimHistory;

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;
/**
 * @ * @author FYYANG
 * 
 * @version 1.0<br>
 *          100/07/28<br>
 *          Ãö«Y¤H¸s²Õ(JavaBean) 
 * @since 1.0
 */
public class ClaimHistory01Group extends AbstractModelObject {
	private List<ClaimHistory01> claimHistory01s = new ArrayList<ClaimHistory01>();

	public ClaimHistory01Group() {
	}

	public List<ClaimHistory01> getClaimHistory01s() {
		return claimHistory01s;
	}

	public void addClaimHistory01(ClaimHistory01 claimHistory01) {
		List<ClaimHistory01> oldValue = claimHistory01s;
		claimHistory01s = new ArrayList<ClaimHistory01>(claimHistory01s);
		claimHistory01s.add(claimHistory01);

		firePropertyChange("claimHistory01s", oldValue, claimHistory01s);
	}

	public void removeClaimHistory01(ClaimHistory01 claimHistory01) {
		claimHistory01s.remove(claimHistory01);
	}

	public void removeAll() {
		List<ClaimHistory01> oldValue = claimHistory01s;
		claimHistory01s = new ArrayList<ClaimHistory01>(claimHistory01s);
		claimHistory01s.clear();
		firePropertyChange("claimHistory01s", oldValue, claimHistory01s);
	}

}
