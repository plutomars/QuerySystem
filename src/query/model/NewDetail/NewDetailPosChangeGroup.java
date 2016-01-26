package query.model.NewDetail;

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;

/**
 * 新契約明細契變受理群組(JavaBean)
 * 
 * @author epf
 * 
 * @version 1.0<br>
 *          100/07/28<br>
 * 
 * @since 1.0
 */
public class NewDetailPosChangeGroup extends AbstractModelObject {
	private List<NewDetailPosChange> newDetailPosChanges = new ArrayList<NewDetailPosChange>();

	public NewDetailPosChangeGroup() {
	}

	public List<NewDetailPosChange> getNewDetailPosChanges() {
		return newDetailPosChanges;
	}

	public void setNewDetailPosChanges(
			List<NewDetailPosChange> newDetailPosChanges) {
		this.newDetailPosChanges = newDetailPosChanges;
	}

	public void addNewDetailPosChange(NewDetailPosChange newDetailPosChange) {
		List<NewDetailPosChange> oldValue = newDetailPosChanges;
		newDetailPosChanges = new ArrayList<NewDetailPosChange>(
				newDetailPosChanges);
		newDetailPosChanges.add(newDetailPosChange);

		firePropertyChange("newDetailPosChanges", oldValue, newDetailPosChanges);
	}

	public void removeNewDetailPosChange(NewDetailPosChange newDetailPosChange) {
		newDetailPosChanges.remove(newDetailPosChange);
	}

	public void removeAll() {
		List<NewDetailPosChange> oldValue = newDetailPosChanges;
		newDetailPosChanges = new ArrayList<NewDetailPosChange>(
				newDetailPosChanges);
		newDetailPosChanges.clear();
		firePropertyChange("newDetailPosChanges", oldValue, newDetailPosChanges);
	}

	public int getNewDetailPosChangeCount() {
		return newDetailPosChanges.size();
	}

}
