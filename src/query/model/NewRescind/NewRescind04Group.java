package query.model.NewRescind;

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;
/**
 * @ * @author YIHUA
 * 
 * @version 1.0<br>
 *          100/08/30<br>
 *          契約撤銷-回覆資料群組(JavaBean) 
 * @since 1.0
 */
public class NewRescind04Group extends AbstractModelObject {
	
private List<NewRescind04> newrescind04group = new ArrayList<NewRescind04>();
	
	public NewRescind04Group() {
	}

	public List<NewRescind04> getNewrescind04group() {
		return newrescind04group;
	}

	public void setNewrescind04(List<NewRescind04> newrescind04) {
		this.newrescind04group = newrescind04;
	}
	
	public void addNewRescind04(NewRescind04 newrescind04) {
		List<NewRescind04> oldValue = newrescind04group;
		newrescind04group = new ArrayList<NewRescind04>(newrescind04group);
		newrescind04group.add(newrescind04);

		firePropertyChange("newrescind04group", oldValue, newrescind04group);
	}

	public void removeNewRescind04(NewRescind04 newrescind04) {
		newrescind04group.remove(newrescind04);
	}

	public void removeAll() {
		List<NewRescind04> oldValue = newrescind04group;
		newrescind04group = new ArrayList<NewRescind04>(newrescind04group);
		newrescind04group.clear();
		firePropertyChange("newrescind04group", oldValue, newrescind04group);
	}

	public int getNewRescind04Count() {
		return newrescind04group.size();
	
	}

	
}
