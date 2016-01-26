package query.model.InvestAuto;

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;
/**
 * 
 * @author 陳冠瑜
 * 
 */
public class InvestAuto02Group extends AbstractModelObject{
	private List<InvestAuto02> investauto02s = new ArrayList<InvestAuto02>();
	
	public InvestAuto02Group() {
	}

	public List<InvestAuto02> getInvestAuto02s() {
		return investauto02s;
	}

	public void addInvestAuto02(InvestAuto02 investauto02) {
		List<InvestAuto02> oldValue = investauto02s;
		investauto02s = new ArrayList<InvestAuto02>(investauto02s);
		
		//合計處理
		if(investauto02.getR_over_feed_desc().equals("sum")){
			investauto02.setR_gain_rate("");
			investauto02.setR_over_feed_desc("");
			investauto02.setR_over_multiple("");
		}
		
		investauto02s.add(investauto02);

		firePropertyChange("investAuto02s", oldValue, investauto02s);
		// firePropertyChange的第一個參數為List的method名稱，要跟Binding的名稱相同
	}

	public void removeInvestAuto02(InvestAuto02 investauto02) {
		investauto02s.remove(investauto02);
	}

	public void removeAll() {
		List<InvestAuto02> oldValue = investauto02s;
		investauto02s = new ArrayList<InvestAuto02>(investauto02s);
		investauto02s.clear();
		firePropertyChange("investAuto02s", oldValue, investauto02s);
	}

	public int getInvestAuto02Count() {
		return investauto02s.size();
	}
}
