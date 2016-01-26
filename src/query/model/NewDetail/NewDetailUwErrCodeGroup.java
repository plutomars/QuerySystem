package query.model.NewDetail;

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;

/**
 * ®Ö«O°T®§¸s²Õ(JavaBean)
 * 
 * @author epf
 * 
 * @version 1.0<br>
 *          100/07/28<br>
 * 
 * @since 1.0
 */
public class NewDetailUwErrCodeGroup extends AbstractModelObject {
	private List<NewDetailUwErrCode> newDetailUwErrCodes = new ArrayList<NewDetailUwErrCode>();

	public NewDetailUwErrCodeGroup() {
	}

	public List<NewDetailUwErrCode> getNewDetailUwErrCodes() {
		return newDetailUwErrCodes;
	}

	public void setNewDetailUwErrCodes(
			List<NewDetailUwErrCode> newDetailUwErrCodes) {
		this.newDetailUwErrCodes = newDetailUwErrCodes;
	}

	public void addNewDetailUwErrCode(NewDetailUwErrCode newDetailUwErrCode) {
		List<NewDetailUwErrCode> oldValue = newDetailUwErrCodes;
		newDetailUwErrCodes = new ArrayList<NewDetailUwErrCode>(
				newDetailUwErrCodes);
		newDetailUwErrCodes.add(newDetailUwErrCode);

		firePropertyChange("newDetailUwErrCodes", oldValue, newDetailUwErrCodes);
	}

	public void removeNewDetailUwErrCode(NewDetailUwErrCode newDetailUwErrCode) {
		newDetailUwErrCodes.remove(newDetailUwErrCode);
	}

	public void removeAll() {
		List<NewDetailUwErrCode> oldValue = newDetailUwErrCodes;
		newDetailUwErrCodes = new ArrayList<NewDetailUwErrCode>(
				newDetailUwErrCodes);
		newDetailUwErrCodes.clear();
		firePropertyChange("newDetailUwErrCodes", oldValue, newDetailUwErrCodes);
	}

	public int getNewDetailUwErrCodeCount() {
		return newDetailUwErrCodes.size();
	}

}
