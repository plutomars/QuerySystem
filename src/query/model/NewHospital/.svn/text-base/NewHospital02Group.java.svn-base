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

public class NewHospital02Group extends AbstractModelObject {
	private List<NewHospital02> NewHospital02s = new ArrayList<NewHospital02>();

	//add
		public NewHospital02Group() {
		}

		
		public List<NewHospital02> getNewHospital02() {
			return NewHospital02s;
		}

		public void addNewHospital02(NewHospital02 newhospital02) {
			List<NewHospital02> oldValue =  NewHospital02s;
			NewHospital02s = new ArrayList<NewHospital02>(NewHospital02s);
			NewHospital02s.add(newhospital02);
			firePropertyChange("newHospital02", oldValue, NewHospital02s);
			
		}

		public void removeNewHospital02(NewHospital02 newhospital02) {
			NewHospital02s.remove(newhospital02);
		}

		public void removeAll() {
			List<NewHospital02> oldValue = NewHospital02s;
			NewHospital02s = new ArrayList<NewHospital02>(NewHospital02s);
			NewHospital02s.clear();		
			firePropertyChange("newHospital02", oldValue, NewHospital02s);
		}

		public int getNewHospital02Count() {
			return NewHospital02s.size();
		}
}
