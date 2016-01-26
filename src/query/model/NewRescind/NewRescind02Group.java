package query.model.NewRescind;


import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;

/**
 * @ * @author YIHUA
 * 
 * @version 1.0<br>
 *          100/08/30<br>
 *          契約撤銷-索引資料群組(JavaBean) 
 * @since 1.0
 */

public class NewRescind02Group extends AbstractModelObject {
	
	private List<NewRescind02> newrescind02group = new ArrayList<NewRescind02>();
	
	public NewRescind02Group() {
	}

	public List<NewRescind02> getNewrescind02group() {
		return newrescind02group;
	}

	public void setNewrescind02(List<NewRescind02> newrescind02) {
		this.newrescind02group = newrescind02;
	}
	
	public void addNewRescind02(NewRescind02 newrescind02) {
		List<NewRescind02> oldValue = newrescind02group;
		newrescind02group = new ArrayList<NewRescind02>(newrescind02group);
		newrescind02group.add(newrescind02);

		firePropertyChange("newrescind02group", oldValue, newrescind02group);
	}

	public void removeNewRescind02(NewRescind02 newrescind02) {
		newrescind02group.remove(newrescind02);
	}

	public void removeAll() {
		List<NewRescind02> oldValue = newrescind02group;
		newrescind02group = new ArrayList<NewRescind02>(newrescind02group);
		newrescind02group.clear();
		firePropertyChange("newrescind02", oldValue, newrescind02group);
	}

	public int getNewRescind02Count() {
		return newrescind02group.size();
	
	}

}
