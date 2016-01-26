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

public class PoExam01Group extends AbstractModelObject {
	private List<PoExam01> poExam01s = new ArrayList<PoExam01>();
	
	//add
	public PoExam01Group() {
	}
	
	public List<PoExam01> getPoExam01s() {
		return poExam01s;
	}

	public void addPoExam01(PoExam01 poexam01) {
		List<PoExam01> oldValue =  poExam01s;
		poExam01s = new ArrayList<PoExam01>(poExam01s);
		poExam01s.add(poexam01);		
		firePropertyChange("poExam01s", oldValue, poExam01s);
	}

	public void removePoExam01(PoExam01 poexam01) {
		poExam01s.remove(poexam01);
	}

	public void removeAll() {
		List<PoExam01> oldValue = poExam01s;
		poExam01s = new ArrayList<PoExam01>(poExam01s);
		poExam01s.clear();		
		firePropertyChange("poExam01s", oldValue, poExam01s);
	}

	public int getPoExam01Count() {
		return poExam01s.size();
	}
	
	
}
