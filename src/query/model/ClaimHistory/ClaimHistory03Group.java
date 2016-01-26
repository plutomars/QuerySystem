package query.model.ClaimHistory;

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;
/**
 * @ * @author FYYANG
 * 
 * @version 1.0<br>
 *          100/08/22<br>
 *          ИsВе(JavaBean) 
 * @since 1.0
 */
public class ClaimHistory03Group extends AbstractModelObject {
	private List<ClaimHistory03> claimHistory03s = new ArrayList<ClaimHistory03>();

	public ClaimHistory03Group() {
	}


	public List<ClaimHistory03> getClaimHistory03s() {
		return claimHistory03s;
	}

	public void addClaimHistory03(ClaimHistory03 claimHistory03) {
		List<ClaimHistory03> oldValue = claimHistory03s;
		claimHistory03s = new ArrayList<ClaimHistory03>(claimHistory03s);
		claimHistory03s.add(claimHistory03);

		firePropertyChange("claimHistory03s", oldValue, claimHistory03s);
	}

	public void removeClaimHistory03(ClaimHistory03 claimHistory03) {
		claimHistory03s.remove(claimHistory03);
	}

	public void removeAll() {
		List<ClaimHistory03> oldValue = claimHistory03s;
		claimHistory03s = new ArrayList<ClaimHistory03>(claimHistory03s);
		claimHistory03s.clear();
		firePropertyChange("claimHistory03s", oldValue, claimHistory03s);
	}

}
