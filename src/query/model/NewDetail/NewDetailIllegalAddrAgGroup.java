package query.model.NewDetail;

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;

public class NewDetailIllegalAddrAgGroup extends AbstractModelObject {
	private List<NewDetailIllegalAddrAg> newDetailIllegalAddrAgs = new ArrayList<NewDetailIllegalAddrAg>();

	public NewDetailIllegalAddrAgGroup() {
	}

	public List<NewDetailIllegalAddrAg> getNewDetailIllegalAddrAgs() {
		return newDetailIllegalAddrAgs;
	}

	public void setNewDetailIllegalAddrAgs(List<NewDetailIllegalAddrAg> newDetailIllegalAddrAgs) {
		this.newDetailIllegalAddrAgs = newDetailIllegalAddrAgs;
	}

	public void addNewDetailIllegalAddrAg(NewDetailIllegalAddrAg newDetailIllegalAddrAg) {
		List<NewDetailIllegalAddrAg> oldValue = newDetailIllegalAddrAgs;
		newDetailIllegalAddrAgs = new ArrayList<NewDetailIllegalAddrAg>(
				newDetailIllegalAddrAgs);
		newDetailIllegalAddrAgs.add(newDetailIllegalAddrAg);

		firePropertyChange("newDetailIllegalAddrAgs", oldValue, newDetailIllegalAddrAgs);
	}

	public void removeNewDetailIllegalAddrAg(NewDetailIllegalAddrAg newDetailIllegalAddrAg) {
		newDetailIllegalAddrAgs.remove(newDetailIllegalAddrAg);
	}

	public void removeAll() {
		List<NewDetailIllegalAddrAg> oldValue = newDetailIllegalAddrAgs;
		newDetailIllegalAddrAgs = new ArrayList<NewDetailIllegalAddrAg>(
				newDetailIllegalAddrAgs);
		newDetailIllegalAddrAgs.clear();
		firePropertyChange("newDetailIllegalAddrAgs", oldValue, newDetailIllegalAddrAgs);
	}

	public int getNewDetailIllegalAddrAgCount() {
		return newDetailIllegalAddrAgs.size();
	}

}
