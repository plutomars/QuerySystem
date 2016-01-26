package query.model.NewDetail;

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;

/**
 * 新契約查詢基本資料要保人部份群組(JavaBean)
 * 
 * @author epf
 * 
 * @version 1.0
 * 
 * @since 1.0
 */
public class NewDetailCommGroup extends AbstractModelObject {
	private List<NewDetailComm> newDetailComms = new ArrayList<NewDetailComm>();

	public NewDetailCommGroup() {
	}

	public List<NewDetailComm> getNewDetailComms() {
		return newDetailComms;
	}

	public void addNewDetailComm(NewDetailComm newDetailComm) {
		List<NewDetailComm> oldValue = newDetailComms;
		newDetailComms = new ArrayList<NewDetailComm>(newDetailComms);
		newDetailComms.add(newDetailComm);

		firePropertyChange("newDetailComms", oldValue, newDetailComms);
	}

	public void removeNewDetailComm(NewDetailComm newDetailComm) {
		newDetailComms.remove(newDetailComm);
	}

	public void removeAll() {
		List<NewDetailComm> oldValue = newDetailComms;
		newDetailComms = new ArrayList<NewDetailComm>(newDetailComms);
		newDetailComms.clear();
		firePropertyChange("newDetailComms", oldValue, newDetailComms);
	}

	public int getNewDetailCommCount() {
		return newDetailComms.size();
	}

}
