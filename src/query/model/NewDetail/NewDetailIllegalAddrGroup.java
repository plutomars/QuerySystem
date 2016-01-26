package query.model.NewDetail;

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;

/**
 * 新契約明細列管地址群組(JavaBean)
 * 
 * @author epf
 * 
 * @version 1.0<br>
 *          100/10/24<br>
 * @since 1.0
 */
public class NewDetailIllegalAddrGroup extends AbstractModelObject {
	private List<NewDetailIllegalAddr> newDetailIllegalAddrs = new ArrayList<NewDetailIllegalAddr>();

	public NewDetailIllegalAddrGroup() {
	}

	public List<NewDetailIllegalAddr> getNewDetailIllegalAddrs() {
		return newDetailIllegalAddrs;
	}

	public void setNewDetailIllegalAddrs(
			List<NewDetailIllegalAddr> newDetailIllegalAddrs) {
		this.newDetailIllegalAddrs = newDetailIllegalAddrs;
	}

	public void addNewDetailIllegalAddr(
			NewDetailIllegalAddr newDetailIllegalAddr) {
		List<NewDetailIllegalAddr> oldValue = newDetailIllegalAddrs;
		newDetailIllegalAddrs = new ArrayList<NewDetailIllegalAddr>(
				newDetailIllegalAddrs);
		newDetailIllegalAddrs.add(newDetailIllegalAddr);

		firePropertyChange("newDetailIllegalAddrs", oldValue,
				newDetailIllegalAddrs);
	}

	public void removeNewDetailIllegalAddr(
			NewDetailIllegalAddr newDetailIllegalAddr) {
		newDetailIllegalAddrs.remove(newDetailIllegalAddr);
	}

	public void removeAll() {
		List<NewDetailIllegalAddr> oldValue = newDetailIllegalAddrs;
		newDetailIllegalAddrs = new ArrayList<NewDetailIllegalAddr>(
				newDetailIllegalAddrs);
		newDetailIllegalAddrs.clear();
		firePropertyChange("newDetailIllegalAddrs", oldValue,
				newDetailIllegalAddrs);
	}

	public int getNewDetailIllegalAddrCount() {
		return newDetailIllegalAddrs.size();
	}

}
