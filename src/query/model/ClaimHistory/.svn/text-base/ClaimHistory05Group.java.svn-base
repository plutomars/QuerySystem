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
public class ClaimHistory05Group extends AbstractModelObject {
	private List<ClaimHistory05> claimHistory05s = new ArrayList<ClaimHistory05>();

	public ClaimHistory05Group() {
	}

	public List<ClaimHistory05> getClaimHistory05s() {
		return claimHistory05s;
	}

	public String getBenfNames() {
		StringBuilder names = new StringBuilder();
		for (int i = 0; i < claimHistory05s.size(); i++) {
			names.append(claimHistory05s.get(i).getR_benf_name() + ",");
		}
		if (names.length()>1)
			return names.substring(0, names.length() - 1);
		else
			return "";

	}

	public void addClaimHistory05(ClaimHistory05 claimHistory05) {
		List<ClaimHistory05> oldValue = claimHistory05s;
		claimHistory05s = new ArrayList<ClaimHistory05>(claimHistory05s);
		claimHistory05s.add(claimHistory05);

		firePropertyChange("claimHistory05s", oldValue, claimHistory05s);
	}

	public void removeClaimHistory05(ClaimHistory05 claimHistory05) {
		claimHistory05s.remove(claimHistory05);
	}

	public void removeAll() {
		List<ClaimHistory05> oldValue = claimHistory05s;
		claimHistory05s = new ArrayList<ClaimHistory05>(claimHistory05s);
		claimHistory05s.clear();
		firePropertyChange("claimHistory05s", oldValue, claimHistory05s);
	}

}
