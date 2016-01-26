package query.model.ClaimHistory;

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;

/**
 * @ * @author FYYANG
 * 
 * @version 1.0<br>
 *          100/09/26<br>
 *          ИsВе(JavaBean)
 * @since 1.0
 */
public class ClaimHistory08Group extends AbstractModelObject {
	private List<ClaimHistory08> claimHistory08s = new ArrayList<ClaimHistory08>();

	public ClaimHistory08Group() {
	}

	public List<ClaimHistory08> getClaimHistory08s() {
		return claimHistory08s;
	}

	public void addClaimHistory08(ClaimHistory08 claimHistory08) {
		List<ClaimHistory08> oldValue = claimHistory08s;
		claimHistory08s = new ArrayList<ClaimHistory08>(claimHistory08s);
		claimHistory08s.add(claimHistory08);

		firePropertyChange("claimHistory08s", oldValue, claimHistory08s);
	}

	public void removeClaimHistory08(ClaimHistory08 claimHistory08) {
		claimHistory08s.remove(claimHistory08);
	}

	public void removeAll() {
		List<ClaimHistory08> oldValue = claimHistory08s;
		claimHistory08s = new ArrayList<ClaimHistory08>(claimHistory08s);
		claimHistory08s.clear();
		firePropertyChange("claimHistory08s", oldValue, claimHistory08s);
	}

}
