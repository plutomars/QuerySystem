package query.model.InvestAppoint;

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;

public class InvestWithdrawAppointGroup02 extends AbstractModelObject {
	private List<InvestWithdrawAppoint02> investWithdrawAppoint02s = new ArrayList<InvestWithdrawAppoint02>();

	public InvestWithdrawAppointGroup02() {

	}

	public List<InvestWithdrawAppoint02> getInvestWithdrawAppoint02s() {
		return investWithdrawAppoint02s;
	}

	public void addInvestAppoint02(InvestWithdrawAppoint02 investAppoiint02) {
		List<InvestWithdrawAppoint02> oldValue = investWithdrawAppoint02s;
		investWithdrawAppoint02s = new ArrayList<InvestWithdrawAppoint02>(
				investWithdrawAppoint02s);
		investWithdrawAppoint02s.add(investAppoiint02);

		firePropertyChange("investWithdrawAppoint02s", oldValue,
				investWithdrawAppoint02s);
	}

	public void removeInvestAppoint02(InvestWithdrawAppoint02 investAppiont02) {
		investWithdrawAppoint02s.remove(investAppiont02);
	}

	public void removeAll() {
		List<InvestWithdrawAppoint02> oldValue = investWithdrawAppoint02s;
		investWithdrawAppoint02s = new ArrayList<InvestWithdrawAppoint02>(
				investWithdrawAppoint02s);
		investWithdrawAppoint02s.clear();
		firePropertyChange("investWithdrawAppoint02s", oldValue,
				investWithdrawAppoint02s);
	}

	public int getInvestAppoint02sCount() {
		return investWithdrawAppoint02s.size();
	}

}
