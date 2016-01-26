package query.model.NewDetail;

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;

/**
 * 新契約明細舊公會索引資料群組(JavaBean)
 * 
 * @author epf
 * 
 * @version 1.0<br>
 *          100/10/20<br>
 * 
 * @since 1.0
 */
public class NewDetailOldAssoIndexGroup extends AbstractModelObject {
	private List<NewDetailOldAssoIndex> newDetailOldAssoIndexs = new ArrayList<NewDetailOldAssoIndex>();

	public NewDetailOldAssoIndexGroup() {
	}

	public List<NewDetailOldAssoIndex> getNewDetailOldAssoIndexs() {
		return newDetailOldAssoIndexs;
	}

	public void setNewDetailOldAssoIndexs(
			List<NewDetailOldAssoIndex> newDetailOldAssoIndexs) {
		this.newDetailOldAssoIndexs = newDetailOldAssoIndexs;
	}

	public void addNewDetailOldAssoIndex(
			NewDetailOldAssoIndex newDetailOldAssoIndex) {
		List<NewDetailOldAssoIndex> oldValue = newDetailOldAssoIndexs;
		newDetailOldAssoIndexs = new ArrayList<NewDetailOldAssoIndex>(
				newDetailOldAssoIndexs);
		newDetailOldAssoIndexs.add(newDetailOldAssoIndex);

		firePropertyChange("newDetailOldAssoIndexs", oldValue,
				newDetailOldAssoIndexs);
	}

	public void removeNewDetailOldAssoIndex(
			NewDetailOldAssoIndex newDetailOldAssoIndex) {
		newDetailOldAssoIndexs.remove(newDetailOldAssoIndex);
	}

	public void removeAll() {
		List<NewDetailOldAssoIndex> oldValue = newDetailOldAssoIndexs;
		newDetailOldAssoIndexs = new ArrayList<NewDetailOldAssoIndex>(
				newDetailOldAssoIndexs);
		newDetailOldAssoIndexs.clear();
		firePropertyChange("newDetailOldAssoIndexs", oldValue,
				newDetailOldAssoIndexs);
	}

	public int getNewDetailOldAssoIndexCount() {
		return newDetailOldAssoIndexs.size();
	}

}
