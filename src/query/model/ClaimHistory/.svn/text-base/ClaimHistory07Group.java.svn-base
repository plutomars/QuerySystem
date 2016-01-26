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
public class ClaimHistory07Group extends AbstractModelObject {
	private List<ClaimHistory07> claimHistory07s = new ArrayList<ClaimHistory07>();

	public ClaimHistory07Group() {
	}

	public List<ClaimHistory07> getClaimHistory07s() {
		return claimHistory07s;
	}

	public void addClaimHistory07(ClaimHistory07 claimHistory07) {
		List<ClaimHistory07> oldValue = claimHistory07s;
		claimHistory07s = new ArrayList<ClaimHistory07>(claimHistory07s);
		claimHistory07s.add(claimHistory07);

		firePropertyChange("claimHistory07s", oldValue, claimHistory07s);
	}

	public void removeClaimHistory07(ClaimHistory07 claimHistory07) {
		claimHistory07s.remove(claimHistory07);
	}

	public void removeAll() {
		List<ClaimHistory07> oldValue = claimHistory07s;
		claimHistory07s = new ArrayList<ClaimHistory07>(claimHistory07s);
		claimHistory07s.clear();
		firePropertyChange("claimHistory07s", oldValue, claimHistory07s);
	}

}
