package query.model.NewPhysicalExam;
/**
 * ≈È¿À∂O¶©¶˛
 * @author cora
 * 100/11/11
 */
import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;
import query.model.NewPhysicalExam.NewPhysicalExam;

public class NewPhysicalExamGroup extends AbstractModelObject {
	private List<NewPhysicalExam> NewPhysicalExams = new ArrayList<NewPhysicalExam>();

	//add
		public NewPhysicalExamGroup() {
		}

		
		public List<NewPhysicalExam> getNewPhysicalExam() {
			return NewPhysicalExams;
		}

		public void addNewPhysicalExam(NewPhysicalExam newPhysicalExam) {
			List<NewPhysicalExam> oldValue =  NewPhysicalExams;
			NewPhysicalExams = new ArrayList<NewPhysicalExam>(NewPhysicalExams);
			NewPhysicalExams.add(newPhysicalExam);
			firePropertyChange("newPhysicalExam", oldValue, NewPhysicalExams);
			
		}

		public void removeNewPhysicalExam(NewPhysicalExam newPhysicalExam) {
			NewPhysicalExams.remove(newPhysicalExam);
		}

		public void removeAll() {
			List<NewPhysicalExam> oldValue = NewPhysicalExams;
			NewPhysicalExams = new ArrayList<NewPhysicalExam>(NewPhysicalExams);
			NewPhysicalExams.clear();		
			firePropertyChange("newPhysicalExam", oldValue, NewPhysicalExams);
		}

		public int getNewPhysicalExamCount() {
			return NewPhysicalExams.size();
		}
}
