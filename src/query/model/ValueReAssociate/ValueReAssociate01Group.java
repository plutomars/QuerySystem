package query.model.ValueReAssociate;

import java.util.ArrayList;
import java.util.List;
import query.model.AbstractModelObject;
/**
 * @version 1.0
 * @author swei
 * �^�y���p�d��PoReAssociate_model
 * 
 */

public class ValueReAssociate01Group extends AbstractModelObject {
	private List<ValueReAssociate01> poreassociate01s = new ArrayList<ValueReAssociate01>();
	
	//add
		public ValueReAssociate01Group() {
		}
		
		public List<ValueReAssociate01> getPoReAssociate01() {
			return poreassociate01s;
		}
		
		public void addPoReAssociate01(ValueReAssociate01 poreassociate01) {
			                            
			List<ValueReAssociate01> oldValue =  poreassociate01s;
			poreassociate01s = new ArrayList<ValueReAssociate01>(poreassociate01s);
			poreassociate01s.add(poreassociate01);		
			firePropertyChange("poReAssociate01", oldValue, poreassociate01s);
			// �Ĥ@�ӰѼƭn��Binding���W�٬ۦP
		}
		
		public void removePoReAssociate01(ValueReAssociate01 poreassociate01) {
			poreassociate01s.remove(poreassociate01);
		}
		
		public void removeAll() {
			List<ValueReAssociate01> oldValue = poreassociate01s;
			poreassociate01s = new ArrayList<ValueReAssociate01>(poreassociate01s);
			poreassociate01s.clear();		
			firePropertyChange("poReAssociate01", oldValue, poreassociate01s);
		}
		
		public int getPoReAssociate01Count() {
			return poreassociate01s.size();
		}
}
