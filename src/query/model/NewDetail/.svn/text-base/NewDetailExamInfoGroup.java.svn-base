package query.model.NewDetail;

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;

/**
 * 新契約明細體檢資料群組(JavaBean)
 * 
 * @author epf
 * 
 * @version 1.0
 * 
 * @since 1.0
 */
public class NewDetailExamInfoGroup extends AbstractModelObject {
	private List<NewDetailExamInfo> newDetailExamInfos = new ArrayList<NewDetailExamInfo>();

	public NewDetailExamInfoGroup() {
	}

	public List<NewDetailExamInfo> getNewDetailExamInfos() {
		return newDetailExamInfos;
	}

	public void setNewDetailExamInfos(List<NewDetailExamInfo> newDetailExamInfos) {
		this.newDetailExamInfos = newDetailExamInfos;
	}

	public void addNewDetailExamInfo(NewDetailExamInfo newDetailComm) {
		List<NewDetailExamInfo> oldValue = newDetailExamInfos;
		newDetailExamInfos = new ArrayList<NewDetailExamInfo>(
				newDetailExamInfos);
		newDetailExamInfos.add(newDetailComm);

		firePropertyChange("newDetailExamInfos", oldValue, newDetailExamInfos);
	}

	public void removeNewDetailExamInfo(NewDetailExamInfo newDetailComm) {
		newDetailExamInfos.remove(newDetailComm);
	}

	public void removeAll() {
		List<NewDetailExamInfo> oldValue = newDetailExamInfos;
		newDetailExamInfos = new ArrayList<NewDetailExamInfo>(
				newDetailExamInfos);
		newDetailExamInfos.clear();
		firePropertyChange("newDetailExamInfos", oldValue, newDetailExamInfos);
	}

	public int getNewDetailExamInfoCount() {
		return newDetailExamInfos.size();
	}

}
