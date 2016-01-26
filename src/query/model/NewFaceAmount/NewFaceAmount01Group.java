package query.model.NewFaceAmount;

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;
/**
 * 
 * @author ���a��
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

		// �Y��(�֭p�O�B�B�ثe�|�i��O�B��)���Ť���ܳ��
//		if (newfaceamount01.getR_face_amt() == null
//				|| newfaceamount01.getR_face_amt().length() == 0)
//			newfaceamount01.setR_unit_1("");
//		if (newfaceamount01.getR_avail_amt() == null
//				|| newfaceamount01.getR_avail_amt().length() == 0)
//			newfaceamount01.setR_unit_2("");

		newfaceamount01s.add(newfaceamount01);

		firePropertyChange("newFaceAmount01s", oldValue, newfaceamount01s);
		// firePropertyChange���Ĥ@�ӰѼƬ�List��method�W�١A�n��Binding���W�٬ۦP
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
