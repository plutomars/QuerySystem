package query.model.ValueReAssociate;

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;
/**
 * @version 1.0
 * @author swei
 * 回流關聯查詢PoReAssociate_model
 * 
 */
public class ValueReAssociate02Group extends AbstractModelObject {
	private List<ValueReAssociate02> poreassociate02s = new ArrayList<ValueReAssociate02>();
	
	    //add
		public ValueReAssociate02Group() {
		}
		
		public List<ValueReAssociate02> getPoReAssociate02() {
			return poreassociate02s;
		}
		
		public void addPoReAssociate02(ValueReAssociate02 poreassociate02) {
			                            
			List<ValueReAssociate02> oldValue =  poreassociate02s;
			poreassociate02s = new ArrayList<ValueReAssociate02>(poreassociate02s);
			poreassociate02s.add(poreassociate02);		
			firePropertyChange("poReAssociate02", oldValue, poreassociate02s);
			// 第一個參數要跟Binding的名稱相同
		}
		
		public void removePoReAssociate02(ValueReAssociate02 poreassociate02) {
			poreassociate02s.remove(poreassociate02);
		}
		
		public void removeAll() {
			List<ValueReAssociate02> oldValue = poreassociate02s;
			poreassociate02s = new ArrayList<ValueReAssociate02>(poreassociate02s);
			poreassociate02s.clear();		
			firePropertyChange("poReAssociate02", oldValue, poreassociate02s);
		}
		
		public int getPoReAssociate02Count() {
			return poreassociate02s.size();
		}
}
