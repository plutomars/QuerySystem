package query.model.NewFaceAmount;

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;
/**
 * 
 * @author 陳冠瑜
 * 
 */
public class NewFaceAmount01Group extends AbstractModelObject {
	private List<NewFaceAmount01> newfaceamount01s = new ArrayList<NewFaceAmount01>();

	public NewFaceAmount01Group() {
	}

	public List<NewFaceAmount01> getNewFaceAmount01s() {
		return newfaceamount01s;
	}

	public void addNewFaceAmount01(NewFaceAmount01 newfaceamount01) {
		List<NewFaceAmount01> oldValue = newfaceamount01s;
		newfaceamount01s = new ArrayList<NewFaceAmount01>(newfaceamount01s);

		// 若值(累計保額、目前尚可投保額度)為空不顯示單位
//		if (newfaceamount01.getR_face_amt() == null
//				|| newfaceamount01.getR_face_amt().length() == 0)
//			newfaceamount01.setR_unit_1("");
//		if (newfaceamount01.getR_avail_amt() == null
//				|| newfaceamount01.getR_avail_amt().length() == 0)
//			newfaceamount01.setR_unit_2("");

		newfaceamount01s.add(newfaceamount01);

		firePropertyChange("newFaceAmount01s", oldValue, newfaceamount01s);
		// firePropertyChange的第一個參數為List的method名稱，要跟Binding的名稱相同
	}

	public void removeNewFaceAmount01(NewFaceAmount01 newfaceamount01) {
		newfaceamount01s.remove(newfaceamount01);
	}

	public void removeAll() {
		List<NewFaceAmount01> oldValue = newfaceamount01s;
		newfaceamount01s = new ArrayList<NewFaceAmount01>(newfaceamount01s);
		newfaceamount01s.clear();
		firePropertyChange("newFaceAmount01s", oldValue, newfaceamount01s);
	}

	public int getNewFaceAmount01Count() {
		return newfaceamount01s.size();
	}
}
