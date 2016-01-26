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
import query.model.InvestDeduction.InvestDeduction02;

public class InvestDeduction02Group extends AbstractModelObject {
	private List<InvestDeduction02> monthlydeduction02s = new ArrayList<InvestDeduction02>();
	
	    //add
			public InvestDeduction02Group() {
			}
			
			public List<InvestDeduction02> getMonthlydeduction02s() {
				return monthlydeduction02s; //自動產生
			}

			public void addMonthlyDeduction02(InvestDeduction02 monthlydeduction02) {
				List<InvestDeduction02> oldValue =  monthlydeduction02s;
				monthlydeduction02s = new ArrayList<InvestDeduction02>(monthlydeduction02s);
				monthlydeduction02s.add(monthlydeduction02);
				
				firePropertyChange("monthlydeduction02s", oldValue, monthlydeduction02s);
			}


			public void removeMonthlyDeduction02(InvestDeduction02 monthlydeduction02) {
				monthlydeduction02s.remove(monthlydeduction02);
			}

			public void removeAll() {
				List<InvestDeduction02> oldValue = monthlydeduction02s;
				monthlydeduction02s = new ArrayList<InvestDeduction02>(monthlydeduction02s);
				monthlydeduction02s.clear();
				
				firePropertyChange("monthlydeduction02s", oldValue, monthlydeduction02s);
			}


			public int getMonthlyDeduction02Count() {
				return monthlydeduction02s.size();
			}
}
