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
public class ClaimHistory04Group extends AbstractModelObject {
	private List<ClaimHistory04> claimHistory04s = new ArrayList<ClaimHistory04>();

	public ClaimHistory04Group() {
	}

	public List<ClaimHistory04> getClaimHistory04s() {
		return claimHistory04s;
	}

	public void addClaimHistory04(ClaimHistory04 claimHistory04) {
		List<ClaimHistory04> oldValue = claimHistory04s;
		claimHistory04s = new ArrayList<ClaimHistory04>(claimHistory04s);
		claimHistory04s.add(claimHistory04);

		firePropertyChange("claimHistory04s", oldValue, claimHistory04s);
	}

	public void removeClaimHistory04(ClaimHistory04 claimHistory04) {
		claimHistory04s.remove(claimHistory04);
	}

	public void removeAll() {
		List<ClaimHistory04> oldValue = claimHistory04s;
		claimHistory04s = new ArrayList<ClaimHistory04>(claimHistory04s);
		claimHistory04s.clear();
		firePropertyChange("claimHistory04s", oldValue, claimHistory04s);
	}

}
