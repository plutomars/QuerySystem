package query.model.NewDetail;

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;

/**
 * 新契約查詢基本資料 被保人部份群組(JavaBean)
 * 
 * @author epf
 * 
 * @version 1.0
 * 
 * @since 1.0
 */

public class NewDetailCommInsuredGroup extends AbstractModelObject {
	private List<NewDetailCommInsured> newDetailCommInsureds = new ArrayList<NewDetailCommInsured>();

	public NewDetailCommInsuredGroup() {
	}

	public List<NewDetailCommInsured> getNewDetailCommInsureds() {
		return newDetailCommInsureds;
	}

	public void setNewDetailCommInsureds(
			List<NewDetailCommInsured> newDetailCommInsureds) {
		this.newDetailCommInsureds = newDetailCommInsureds;
	}

	public void addNewDetailCommInsured(
			NewDetailCommInsured newDetailCommInsured) {
		List<NewDetailCommInsured> oldValue = newDetailCommInsureds;
		newDetailCommInsureds = new ArrayList<NewDetailCommInsured>(
				newDetailCommInsureds);
		newDetailCommInsureds.add(newDetailCommInsured);

		firePropertyChange("newDetailCommInsureds", oldValue,
				newDetailCommInsureds);
	}

	public void removeNewDetailCommInsured(
			NewDetailCommInsured newDetailCommInsured) {
		newDetailCommInsureds.remove(newDetailCommInsured);
	}

	public void removeAll() {
		List<NewDetailCommInsured> oldValue = newDetailCommInsureds;
		newDetailCommInsureds = new ArrayList<NewDetailCommInsured>(
				newDetailCommInsureds);
		newDetailCommInsureds.clear();
		firePropertyChange("newDetailCommInsureds", oldValue,
				newDetailCommInsureds);
	}

	public int getNewDetailCommCount() {
		return newDetailCommInsureds.size();
	}

}
