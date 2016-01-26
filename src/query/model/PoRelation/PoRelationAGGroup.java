package query.model.PoRelation;

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;
/**
 * @ * @author FYYANG
 * 
 * @version 1.0<br>
 *          100/07/28<br>
 *          業務員群組(JavaBean) 
 * @since 1.0
 */
public class PoRelationAGGroup extends AbstractModelObject {
	private List<PoRelationAG> relationAGs = new ArrayList<PoRelationAG>();
	
	public PoRelationAGGroup() {
	}

	public List<PoRelationAG> getRelationAGs() {
		return relationAGs;
	}

	public void addRelationAG(PoRelationAG relation) {
		List<PoRelationAG> oldValue = relationAGs;
		relationAGs = new ArrayList<PoRelationAG>(relationAGs);
		relationAGs.add(relation);

		firePropertyChange("relationAGs", oldValue, relationAGs);
	}

	public void removeRelationAG(PoRelationAG relation) {
		relationAGs.remove(relation);
	}

	public void removeAll() {
		List<PoRelationAG> oldValue = relationAGs;
		relationAGs = new ArrayList<PoRelationAG>(relationAGs);
		relationAGs.clear();
		firePropertyChange("relationAGs", oldValue, relationAGs);
	}

	public int getRelationAGCount() {
		return relationAGs.size();
	}
}
