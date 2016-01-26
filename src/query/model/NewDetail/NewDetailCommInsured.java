package query.model.NewDetail;

import java.util.HashMap;

/**
 * 新契約查詢基本資料被保人部份(JavaBean)
 * 
 * @author epf
 * 
 * @version 1.0
 * 
 * @since 1.0
 */
public class NewDetailCommInsured {
	private String result_ind;
	private String client_ident;
	private String i1_id;
	private String i1_name;
	private String i1_birth;
	private String home_addr;
	private String i1_occu;
	private String height;
	private String weight;
	private String sign_ptn_card;

	public NewDetailCommInsured(HashMap<String, String> hsmp) {
		result_ind = (hsmp.get("r_result_ind") == null) ? "" : hsmp.get(
				"r_result_ind").trim();
		client_ident = (hsmp.get("r_relation") == null) ? "" : hsmp.get(
				"r_relation").trim();
		i1_id = (hsmp.get("r_client_id") == null) ? "" : hsmp
				.get("r_client_id").trim();
		i1_name = (hsmp.get("r_names") == null) ? "" : hsmp.get("r_names")
				.trim();
		i1_birth = (hsmp.get("r_birth_date") == null) ? "" : hsmp.get(
				"r_birth_date").trim();
		home_addr = (hsmp.get("home_addr") == null) ? "" : hsmp
				.get("home_addr").trim();
		i1_occu = (hsmp.get("r_occu_desc") == null) ? "" : hsmp.get(
				"r_occu_desc").trim();
		height = (hsmp.get("r_height") == null) ? "" : hsmp.get("r_height")
				.trim();
		weight = (hsmp.get("r_weight") == null) ? "" : hsmp.get("r_weight")
				.trim();
		sign_ptn_card = (hsmp.get("r_sign_ptn_card") == null) ? "" : hsmp.get(
				"r_sign_ptn_card").trim();
	}

	public String getResult_ind() {
		return result_ind;
	}

	public void setResult_ind(String result_ind) {
		this.result_ind = result_ind;
	}

	public String getClient_ident() {
		return client_ident;
	}

	public void setClient_ident(String client_ident) {
		this.client_ident = client_ident;
	}

	public String getI1_id() {
		return i1_id;
	}

	public void setI1_id(String i1_id) {
		this.i1_id = i1_id;
	}

	public String getI1_name() {
		return i1_name;
	}

	public void setI1_name(String i1_name) {
		this.i1_name = i1_name;
	}

	public String getI1_birth() {
		return i1_birth;
	}

	public void setI1_birth(String i1_birth) {
		this.i1_birth = i1_birth;
	}

	public String getHome_addr() {
		return home_addr;
	}

	public void setHome_addr(String home_addr) {
		this.home_addr = home_addr;
	}

	public String getI1_occu() {
		return i1_occu;
	}

	public void setI1_occu(String i1_occu) {
		this.i1_occu = i1_occu;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getSign_ptn_card() {
		return sign_ptn_card;
	}

	public void setSign_ptn_card(String sign_ptn_card) {
		this.sign_ptn_card = sign_ptn_card;
	}

}
