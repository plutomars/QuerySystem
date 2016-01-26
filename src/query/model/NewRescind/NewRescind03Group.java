package query.model.NewRescind;

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;
/**
 * @ * @author YIHUA
 * 
 * @version 1.0<br>
 *          100/09/01<br>
 *          契約撤銷-照會資料群組(JavaBean) 
 * @since 1.0
 */
public class NewRescind03Group extends AbstractModelObject {

	private List<NewRescind03> newrescind03group = new ArrayList<NewRescind03>();
	
	public NewRescind03Group() {
	}

	public List<NewRescind03> getNewrescind03group() {
		return newrescind03group;
	}

	public void setNewrescind03(List<NewRescind03> newrescind03) {
		this.newrescind03group = newrescind03;
	}
	
	public void addNewRescind03(NewRescind03 newrescind03) {
		List<NewRescind03> oldValue = newrescind03group;
		newrescind03group = new ArrayList<NewRescind03>(newrescind03group);
		newrescind03group.add(newrescind03);

		firePropertyChange("newrescind03group", oldValue, newrescind03group);
	}
	public void removeNewRescind03(NewRescind03 newrescind03) {
		newrescind03group.remove(newrescind03);
	}

	public void removeAll() {
		List<NewRescind03> oldValue = newrescind03group;
		newrescind03group = new ArrayList<NewRescind03>(newrescind03group);
		newrescind03group.clear();
//		System.out.println("03group");
		firePropertyChange("newrescind03group", oldValue, newrescind03group);
	}

	public int getNewRescind03Count() {
		return newrescind03group.size();
	
	}
}
