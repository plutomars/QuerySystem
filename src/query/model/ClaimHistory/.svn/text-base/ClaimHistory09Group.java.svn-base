package query.model.ClaimHistory;

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;

/**
 * @ * @author FYYANG
 * 
 * @version 1.0<br>
 *          100/09/27<br>
 *          ИsВе(JavaBean)
 * @since 1.0
 */
public class ClaimHistory09Group extends AbstractModelObject {
	private List<ClaimHistory09> claimHistory09s = new ArrayList<ClaimHistory09>();

	public ClaimHistory09Group() {
	}

	public List<ClaimHistory09> getClaimHistory09s() {
		return claimHistory09s;
	}

	public void addClaimHistory09(ClaimHistory09 claimHistory09) {
		List<ClaimHistory09> oldValue = claimHistory09s;
		claimHistory09s = new ArrayList<ClaimHistory09>(claimHistory09s);
		claimHistory09s.add(claimHistory09);

		firePropertyChange("claimHistory09s", oldValue, claimHistory09s);
	}

	public void removeClaimHistory09(ClaimHistory09 claimHistory09) {
		claimHistory09s.remove(claimHistory09);
	}

	public void removeAll() {
		List<ClaimHistory09> oldValue = claimHistory09s;
		claimHistory09s = new ArrayList<ClaimHistory09>(claimHistory09s);
		claimHistory09s.clear();
		firePropertyChange("claimHistory09s", oldValue, claimHistory09s);
	}

}
