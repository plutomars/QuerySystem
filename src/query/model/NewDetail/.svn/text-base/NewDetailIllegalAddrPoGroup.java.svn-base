package query.model.NewDetail;

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;

public class NewDetailIllegalAddrPoGroup extends AbstractModelObject {
	private List<NewDetailIllegalAddrPo> newDetailIllegalAddrPos = new ArrayList<NewDetailIllegalAddrPo>();

	public NewDetailIllegalAddrPoGroup() {
	}

	public List<NewDetailIllegalAddrPo> getNewDetailIllegalAddrPos() {
		return newDetailIllegalAddrPos;
	}

	public void setNewDetailIllegalAddrPos(List<NewDetailIllegalAddrPo> newDetailIllegalAddrPos) {
		this.newDetailIllegalAddrPos = newDetailIllegalAddrPos;
	}

	public void addNewDetailIllegalAddrPo(NewDetailIllegalAddrPo newDetailIllegalAddrPo) {
		List<NewDetailIllegalAddrPo> oldValue = newDetailIllegalAddrPos;
		newDetailIllegalAddrPos = new ArrayList<NewDetailIllegalAddrPo>(
				newDetailIllegalAddrPos);
		newDetailIllegalAddrPos.add(newDetailIllegalAddrPo);

		firePropertyChange("newDetailIllegalAddrPos", oldValue, newDetailIllegalAddrPos);
	}

	public void removeNewDetailIllegalAddrPo(NewDetailIllegalAddrPo newDetailIllegalAddrPo) {
		newDetailIllegalAddrPos.remove(newDetailIllegalAddrPo);
	}

	public void removeAll() {
		List<NewDetailIllegalAddrPo> oldValue = newDetailIllegalAddrPos;
		newDetailIllegalAddrPos = new ArrayList<NewDetailIllegalAddrPo>(
				newDetailIllegalAddrPos);
		newDetailIllegalAddrPos.clear();
		firePropertyChange("newDetailIllegalAddrPos", oldValue, newDetailIllegalAddrPos);
	}

	public int getNewDetailIllegalAddrPoCount() {
		return newDetailIllegalAddrPos.size();
	}


}
