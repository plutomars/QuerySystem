package query.model.ClaimAssoDetail;

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;
/**
 * @author cychu
 * 
 * @version 1.0<br/>
 * 			101/04/24<br/>
 * 			公會投保資料查詢－明細(JavaBeanGroup)
 *
 * @since 1.0
 */
public class ClaimAssoDetailGroup extends AbstractModelObject {
	private List<ClaimAssoDetail> claimAssoDetails = new ArrayList<ClaimAssoDetail>();
	
	public ClaimAssoDetailGroup() {
	}

	public List<ClaimAssoDetail> getClaimAssoDetails() {
		return claimAssoDetails;
	}

	public void addClaimAssoDetail(ClaimAssoDetail claimAssoDetail) {
		List<ClaimAssoDetail> oldValue = claimAssoDetails;
		claimAssoDetails = new ArrayList<ClaimAssoDetail>(claimAssoDetails);
		claimAssoDetails.add(claimAssoDetail);

		firePropertyChange("claimAssoDetails", oldValue, claimAssoDetails);
	}

	public void removeClaimAssoDetail(ClaimAssoDetail claimAssoDetail) {
		claimAssoDetails.remove(claimAssoDetail);
	}

	public void removeAll() {
		List<ClaimAssoDetail> oldValue = claimAssoDetails;
		claimAssoDetails = new ArrayList<ClaimAssoDetail>(claimAssoDetails);
		claimAssoDetails.clear();
		firePropertyChange("claimAssoDetails", oldValue, claimAssoDetails);
	}

	public int getClaimAssoDetailCount() {
		return claimAssoDetails.size();
	}
}
