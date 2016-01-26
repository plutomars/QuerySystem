package query.model.InvestAppoint;

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;

public class InvestWithdrawAppointGroup03 extends AbstractModelObject {

	private List<InvestWithdrawAppoint03> investWithdrawAppoint03s = new ArrayList<InvestWithdrawAppoint03>();

	public InvestWithdrawAppointGroup03() {

	}

	public List<InvestWithdrawAppoint03> getInvestWithdrawAppoint03s() {
		return investWithdrawAppoint03s;
	}

	public void addInvestAppoint03(InvestWithdrawAppoint03 investAppoiint03) {
		List<InvestWithdrawAppoint03> oldValue = investWithdrawAppoint03s;
		investWithdrawAppoint03s = new ArrayList<InvestWithdrawAppoint03>(
				investWithdrawAppoint03s);
		investWithdrawAppoint03s.add(investAppoiint03);

		firePropertyChange("investWithdrawAppoint03s", oldValue,
				investWithdrawAppoint03s);
	}

	public void removeInvestAppoint03(InvestWithdrawAppoint03 investAppiont03) {
		investWithdrawAppoint03s.remove(investAppiont03);
	}

	public void removeAll() {
		List<InvestWithdrawAppoint03> oldValue = investWithdrawAppoint03s;
		investWithdrawAppoint03s = new ArrayList<InvestWithdrawAppoint03>(
				investWithdrawAppoint03s);
		investWithdrawAppoint03s.clear();
		firePropertyChange("investWithdrawAppoint03s", oldValue,
				investWithdrawAppoint03s);
	}

	public int getInvestAppoint03sCount() {
		return investWithdrawAppoint03s.size();
	}

}
