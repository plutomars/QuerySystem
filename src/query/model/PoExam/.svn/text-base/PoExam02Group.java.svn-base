package query.model.PoExam;

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;

/**
 * 
 * @author swei
 * @version 1.0
 * 體檢批註告知查詢群組(JavaBeanGroup)
 * 
 */

public class PoExam02Group extends AbstractModelObject {
	private List<PoExam02> poExam02s = new ArrayList<PoExam02>();
	
	//add

		public PoExam02Group() {
		}
		
		public List<PoExam02> getPoExam02() {//
			return poExam02s;
		}
		
		public void addPoExam02(PoExam02 poexam02) {
			List<PoExam02> oldValue =  poExam02s;
			poExam02s = new ArrayList<PoExam02>(poExam02s);
			poExam02s.add(poexam02);
			firePropertyChange("poExam02", oldValue, poexam02);
		}

		public void removePoExam02(PoExam02 poexam02) {
			poExam02s.remove(poexam02);
		}

		public void removeAll() {
			List<PoExam02> oldValue = poExam02s;
			poExam02s = new ArrayList<PoExam02>(poExam02s);
			poExam02s.clear();
			firePropertyChange("poExam02", oldValue, poExam02s);
		}

		public int getPoExam02Count() {
			return poExam02s.size();
		}
}
