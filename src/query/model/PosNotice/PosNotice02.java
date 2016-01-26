package query.model.PosNotice;

import java.util.HashMap;
/**
 * @author cychu
 * 
 * @version 1.0<br/>
 * 			100/09/07<br/>
 * 			照會補件(JavaBean)
 * 
 * @since 1.0
 */
public class PosNotice02 {
	private String result_ind;				//0_查詢結果
	private String po_chg_note_code;		//1_照會代碼
	private String po_chg_note_desc;		//2_照會代碼說明
	private String po_chg_doc_code;		    //3_保單變更檢附文件代碼
	
	public PosNotice02(HashMap<String, String> hsmp) {
		result_ind = (hsmp.get("r_result_ind") == null) ? "" : hsmp.get(
			"r_result_ind").trim();
		po_chg_note_code = (hsmp.get("r_po_chg_note_code") == null) ? "" : hsmp.get(
			"r_po_chg_note_code").trim();
		po_chg_note_desc = (hsmp.get("r_po_chg_note_desc") == null) ? "" : hsmp.get(
			"r_po_chg_note_desc").trim();
		po_chg_doc_code = (hsmp.get("r_po_chg_doc_code") == null) ? "" : hsmp.get(
				"r_po_chg_doc_code").trim();
	}

	public String getResult_ind() {
		return result_ind;
	}

	public void setResult_ind(String result_ind) {
		this.result_ind = result_ind;
	}

	public String getPo_chg_note_code() {
		return po_chg_note_code;
	}

	public void setPo_chg_note_code(String po_chg_note_code) {
		this.po_chg_note_code = po_chg_note_code;
	}

	public String getPo_chg_note_desc() {
		return po_chg_note_desc;
	}

	public void setPo_chg_note_desc(String po_chg_note_desc) {
		this.po_chg_note_desc = po_chg_note_desc;
	}
	
	public String getPo_chg_doc_code() {
		return po_chg_doc_code;
	}

	public void setPo_chg_doc_code(String po_chg_doc_code) {
		this.po_chg_doc_code = po_chg_doc_code;
	}
}
