package query.model.InvestDeduction;
/**
 * @author swei
 * 
 * @version 1.0<br>
 *          101/03/28<br>
 *          投資交易_每月扣除額(GROUP)
 * @since 1.0
 */
import java.util.ArrayList;
import java.util.List;
import query.model.AbstractModelObject;
import query.model.InvestDeduction.InvestDeduction01;

public class InvestDeduction01Group extends AbstractModelObject {
	private List<InvestDeduction01> monthlydeduction01s = new ArrayList<InvestDeduction01>();
	
	    //add
			public InvestDeduction01Group() {
			}
			
			public List<InvestDeduction01> getMonthlydeduction01s() {
				return monthlydeduction01s;
			}

			public void addMonthlyDeduction01(InvestDeduction01 monthlydeduction01) {
				List<InvestDeduction01> oldValue =  monthlydeduction01s;
				monthlydeduction01s = new ArrayList<InvestDeduction01>(monthlydeduction01s);
				monthlydeduction01s.add(monthlydeduction01);
				
				firePropertyChange("monthlydeduction01s", oldValue, monthlydeduction01s);
			}


			public void removeMonthlyDeduction01(InvestDeduction01 monthlydeduction01) {
				monthlydeduction01s.remove(monthlydeduction01);
			}

			public void removeAll() {
				List<InvestDeduction01> oldValue = monthlydeduction01s;
				monthlydeduction01s = new ArrayList<InvestDeduction01>(monthlydeduction01s);
				monthlydeduction01s.clear();
				
				firePropertyChange("monthlydeduction01s", oldValue, monthlydeduction01s);
			}


			public int getMonthlyDeduction01Count() {
				return monthlydeduction01s.size();
			}
}
