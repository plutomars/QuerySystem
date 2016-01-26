package query.model.PoBonus;

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;


/**
 * @ * @author YIHUA
 * 
 * @version 1.0<br>
 *          100/08/15<br>
 *          紅利明細資料群組(JavaBean) 
 * @since 1.0
 */

public class PoBonusListGroup extends AbstractModelObject {
	
	private List<PoBonusList> bonuslists = new ArrayList<PoBonusList>();
	
	public PoBonusListGroup() {
	}

    // 右鍵-> source -> generate getter and setter
	public List<PoBonusList> getBonuslists() {
		return bonuslists;
	}

	public void addPoBonusList(PoBonusList bonuslist) {
		List<PoBonusList> oldValue = bonuslists;
		bonuslists = new ArrayList<PoBonusList>(bonuslists);
		bonuslists.add(bonuslist);

		firePropertyChange("bonuslists", oldValue, bonuslists);
	}

	public void removePoBonusList(PoBonusList bonuslist) {
		bonuslists.remove(bonuslist);
	}

	public void removeAll() {
		List<PoBonusList> oldValue = bonuslists;
		bonuslists = new ArrayList<PoBonusList>(bonuslists);
		bonuslists.clear();
		firePropertyChange("bonuslists", oldValue, bonuslists);
	}

	public int getPoBonusListCount() {
		return bonuslists.size();
	}
}
