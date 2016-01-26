package query.model.PoExam;

/**
 * 
 * @author swei
 * @version 1.0
 * 體檢批註告知查詢群組(JavaBeanGroup)
 * 
 */

import java.util.ArrayList;
import java.util.List;
import query.model.AbstractModelObject;

public class PoExam00Group extends AbstractModelObject {

	private List<PoExam00> poExam00s = new ArrayList<PoExam00>();
	
	   //add
		public PoExam00Group() {
		}
		
		public List<PoExam00> getPoExam00() {
			return poExam00s;
		}
		
		public void addPoExam00(PoExam00 poexam00) {
			List<PoExam00> oldValue =  poExam00s;
			poExam00s = new ArrayList<PoExam00>(poExam00s);
			poExam00s.add(poexam00);
			firePropertyChange("poExam00", oldValue, poexam00);
		}

		public void removePoExam00(PoExam00 poexam00) {
			poExam00s.remove(poexam00);
		}

		public void removeAll() {
			List<PoExam00> oldValue = poExam00s;
			poExam00s = new ArrayList<PoExam00>(poExam00s);
			poExam00s.clear();
			firePropertyChange("poExam00", oldValue, poExam00s);
		}

		public int getPoExam00Count() {
			return poExam00s.size();
		}
}
