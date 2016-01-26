package query.model.PoRelation;

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;

/**
 * @ * @author FYYANG
 * 
 * @version 1.0<br>
 *          101/03/20<br>
 *          代理投保群組(JavaBean)
 * @since 1.0
 */
public class PoRelationPAGroup extends AbstractModelObject {
	private List<PoRelationPA> relationPAs = new ArrayList<PoRelationPA>();

	public PoRelationPAGroup() {
	}

	public List<PoRelationPA> getRelationPAs() {
		return relationPAs;
	}

	public void addRelationPA(PoRelationPA relation) {
		List<PoRelationPA> oldValue = relationPAs;
		relationPAs = new ArrayList<PoRelationPA>(relationPAs);
		relationPAs.add(relation);
		firePropertyChange("relationPAs", oldValue, relationPAs);
	}

	public void removeRelationPA(PoRelationPA relation) {
		relationPAs.remove(relation);
	}

	public void removeAll() {
		List<PoRelationPA> oldValue = relationPAs;
		relationPAs = new ArrayList<PoRelationPA>(relationPAs);
		relationPAs.clear();
		firePropertyChange("relationPAs", oldValue, relationPAs);
	}

	public int getRelationCount() {
		return relationPAs.size();
	}
}
