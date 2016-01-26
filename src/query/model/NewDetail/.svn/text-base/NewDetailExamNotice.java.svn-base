package query.model.NewDetail;

import java.util.HashMap;

/**
 * 新契約明細體檢照會部份(JavaBean)
 * 
 * @author epf
 * 
 * @version 1.0
 * 
 * @since 1.0
 */
public class NewDetailExamNotice {
	private String client_ident;
	private String exam_item_desc;
	private String exam_required_ind;

	public NewDetailExamNotice(HashMap<String, String> hsmp) {
		client_ident = (hsmp.get("client_ident") == null) ? "" : hsmp.get(
				"client_ident").trim();
		exam_item_desc = (hsmp.get("exam_item_desc") == null) ? "" : hsmp.get(
				"exam_item_desc").trim();
		exam_required_ind = (hsmp.get("exam_required_ind") == null) ? "" : hsmp
				.get("exam_required_ind").trim();
	}

	public String getClient_ident() {
		return client_ident;
	}

	public void setClient_ident(String client_ident) {
		this.client_ident = client_ident;
	}

	public String getExam_item_desc() {
		return exam_item_desc;
	}

	public void setExam_item_desc(String exam_item_desc) {
		this.exam_item_desc = exam_item_desc;
	}

	public String getExam_required_ind() {
		return exam_required_ind;
	}

	public void setExam_required_ind(String exam_required_ind) {
		this.exam_required_ind = exam_required_ind;
	}

}
