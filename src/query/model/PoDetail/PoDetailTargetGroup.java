package query.model.PoDetail;

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;
/**
 * 保單明細 cc010i
 * @author cora
 * 100/08
 */
public class PoDetailTargetGroup extends AbstractModelObject {

	  private List<PoDetailTarget> poDetailTargets = new ArrayList<PoDetailTarget>();

	  public PoDetailTargetGroup() {
	  }

	  public List<PoDetailTarget> getPoDetailTargets() {
	          return poDetailTargets;
	  }

	  public void addPoDetailTarget(PoDetailTarget poDetailTar) {
	          List<PoDetailTarget> oldValue = poDetailTargets;
	          poDetailTargets = new ArrayList<PoDetailTarget>(poDetailTargets);
//				System.out.println(poDatailTarget.getpolicy_year());
	          if (poDetailTar.getpolicy_year().equals("-1"))
	          {
	        	  poDetailTar.setpolicy_year("");
	        	  poDetailTar.setprem_year("");
	        	  poDetailTar.setPrem_month("");
	        	  poDetailTar.settarget_prem_diff("");
	        	  poDetailTar.settarget_prem("合計");
	        	  poDetailTar.settarget_prem_accu(poDetailTar.gettg_accu_tot());
	        	  poDetailTar.settarget_prem_diff(poDetailTar.gettg_diff_tot());
	          }
	          poDetailTargets.add(poDetailTar);
	          
	          firePropertyChange("poDetailTargets", oldValue, poDetailTargets);
	  }

	  public void removePoDetailTarget(PoDetailTarget poDetailTar) {
	          poDetailTargets.remove(poDetailTar);
	  }

	  public void removeAll() {
	          List<PoDetailTarget> oldValue = poDetailTargets;
	          poDetailTargets = new ArrayList<PoDetailTarget>(poDetailTargets);
	          poDetailTargets.clear();
	          firePropertyChange("poDetailTargets", oldValue, poDetailTargets);
	  }

	  public int  PoDetailTargetCount() {
	          return poDetailTargets.size();
	  }


	
}
