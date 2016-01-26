package query.model.ValueWithdraw;

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;
/**
 * @ * @author 陳冠瑜
 * 
 * @version 1.0<br>
 *          100/08/10<br>
 *          提存明細群組(JavaBean) 
 * @since 1.0
 */
public class ValueWithdrawGroup extends AbstractModelObject {
	
	private List<ValueWithdraw> valuewithdraws = new ArrayList<ValueWithdraw>();
	
	public ValueWithdrawGroup() {
	}
	
	public List<ValueWithdraw> getValueWithdraws() {
		return valuewithdraws;
	}
	
	public void addValueWithdraws(ValueWithdraw valuewithdraw) {
		List<ValueWithdraw> oldValue = valuewithdraws;
		valuewithdraws = new ArrayList<ValueWithdraw>(valuewithdraws);
		valuewithdraws.add(valuewithdraw);

		firePropertyChange("valueWithdraws", oldValue, valuewithdraws);  
		//firePropertyChange的第一個參數為List的method名稱，要跟Binding的名稱相同
	}
	public void removeValueWithdraw(ValueWithdraw valuewithdraw) {
		valuewithdraws.remove(valuewithdraw);
	}

	public void removeAll() {
		List<ValueWithdraw> oldValue = valuewithdraws;
		valuewithdraws = new ArrayList<ValueWithdraw>(valuewithdraws);
		valuewithdraws.clear();
		firePropertyChange("valueWithdraws", oldValue, valuewithdraws);
	}

	public int getValueWithdrawCount() {
		return valuewithdraws.size();
	}
}
