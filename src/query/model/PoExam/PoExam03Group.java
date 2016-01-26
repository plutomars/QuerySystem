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

public class PoExam03Group extends AbstractModelObject {
	private List<PoExam03> poExam03s = new ArrayList<PoExam03>();
	
	//add

		public PoExam03Group() {
		}
		
		public List<PoExam03> getPoExam03() {
			return poExam03s;
		}
		
		public void addPoExam03(PoExam03 poexam03) {
			List<PoExam03> oldValue =  poExam03s;
			poExam03s = new ArrayList<PoExam03>(poExam03s);
			poExam03s.add(poexam03);
			firePropertyChange("poExam03", oldValue, poexam03);
		}

		public void removePoExam03(PoExam03 poexam03) {
			poExam03s.remove(poexam03);
		}

		public void removeAll() {
			List<PoExam03> oldValue = poExam03s;
			poExam03s = new ArrayList<PoExam03>(poExam03s);
			poExam03s.clear();
			firePropertyChange("poExam03", oldValue, poExam03s);
		}

		public int getPoExam03Count() {
			return poExam03s.size();
		}
}