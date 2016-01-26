package query.model.NewHospital;

/**
 * 
 * @author swei
 * @version 1.0
 * 體檢醫院群組(JavaBeanGroup)
 * 
 */

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;
import query.model.NewHospital.NewHospital01;


public class NewHospital01Group extends AbstractModelObject {
	private List<NewHospital01> NewHospital01s = new ArrayList<NewHospital01>();

	//add
		public NewHospital01Group() {
		}

		
		public List<NewHospital01> getNewHospital01() {
			return NewHospital01s;
		}

		public void addNewHospital01(NewHospital01 newhospital01) {
			List<NewHospital01> oldValue =  NewHospital01s;
			NewHospital01s = new ArrayList<NewHospital01>(NewHospital01s);
			NewHospital01s.add(newhospital01);
			firePropertyChange("newHospital01", oldValue, NewHospital01s);
			
		}

		public void removeNewHospital01(NewHospital01 newhospital01) {
			NewHospital01s.remove(newhospital01);
		}

		public void removeAll() {
			List<NewHospital01> oldValue = NewHospital01s;
			NewHospital01s = new ArrayList<NewHospital01>(NewHospital01s);
			NewHospital01s.clear();		
			firePropertyChange("newHospital01", oldValue, NewHospital01s);
		}

		public int getNewHospital01Count() {
			return NewHospital01s.size();
		}
}
	
	

	

