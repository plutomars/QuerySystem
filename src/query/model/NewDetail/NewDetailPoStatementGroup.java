package query.model.NewDetail;

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;

/**
 * 告知事項資料群組(JavaBean)
 * 
 * @author epf
 * 
 * @version 1.0<br>
 *          100/07/28<br>
 * 
 * @since 1.0
 */
public class NewDetailPoStatementGroup extends AbstractModelObject {
	private List<NewDetailPoStatement> newDetailPoStatements = new ArrayList<NewDetailPoStatement>();

	public NewDetailPoStatementGroup() {
	}

	public List<NewDetailPoStatement> getNewDetailPoStatements() {
		return newDetailPoStatements;
	}

	public void setNewDetailPoStatements(
			List<NewDetailPoStatement> newDetailPoStatements) {
		this.newDetailPoStatements = newDetailPoStatements;
	}

	public void addNewDetailPoStatement(
			NewDetailPoStatement newDetailPoStatement) {
		List<NewDetailPoStatement> oldValue = newDetailPoStatements;
		newDetailPoStatements = new ArrayList<NewDetailPoStatement>(
				newDetailPoStatements);
		newDetailPoStatements.add(newDetailPoStatement);

		firePropertyChange("newDetailPoStatements", oldValue,
				newDetailPoStatements);
	}

	public void removeNewDetailPoStatement(
			NewDetailPoStatement newDetailPoStatement) {
		newDetailPoStatements.remove(newDetailPoStatement);
	}

	public void removeAll() {
		List<NewDetailPoStatement> oldValue = newDetailPoStatements;
		newDetailPoStatements = new ArrayList<NewDetailPoStatement>(
				newDetailPoStatements);
		newDetailPoStatements.clear();
		firePropertyChange("newDetailPoStatements", oldValue,
				newDetailPoStatements);
	}

	public int getNewDetailPoStatementCount() {
		return newDetailPoStatements.size();
	}

}
