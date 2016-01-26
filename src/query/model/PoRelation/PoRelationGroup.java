package query.model.PoRelation;

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;
/**
 * @ * @author FYYANG
 * 
 * @version 1.0<br>
 *          100/07/28<br>
 *          Ãö«Y¤H¸s²Õ(JavaBean) 
 * @since 1.0
 */
public class PoRelationGroup extends AbstractModelObject {
	private List<PoRelation> relations = new ArrayList<PoRelation>();

	public PoRelationGroup() {
	}

	public List<PoRelation> getRelations() {
		return relations;
	}

	public void addRelation(PoRelation relation) {
		List<PoRelation> oldValue = relations;
		relations = new ArrayList<PoRelation>(relations);
		relations.add(relation);

		firePropertyChange("relations", oldValue, relations);
	}

	public void removeRelation(PoRelation relation) {
		relations.remove(relation);
	}

	public void removeAll() {
		List<PoRelation> oldValue = relations;
		relations = new ArrayList<PoRelation>(relations);
		relations.clear();
		firePropertyChange("relations", oldValue, relations);
	}

	public int getRelationCount() {
		return relations.size();
	}
}
