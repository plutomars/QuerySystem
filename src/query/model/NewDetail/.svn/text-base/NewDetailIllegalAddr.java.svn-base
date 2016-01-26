package query.model.NewDetail;

import java.util.HashMap;

/**
 * 新契約查詢列管地址資料(JavaBean)
 * 
 * @author epf
 * 
 * @version 1.0
 * 
 * @since 1.0
 */

public class NewDetailIllegalAddr {
	private String ind_desc; // 地址種類
	private String addr_type; // 檢核分類代碼
	private String address;  //地址

	public NewDetailIllegalAddr(HashMap<String, String> hsmp) {
		ind_desc = (hsmp.get("ind_desc") == null) ? "" : hsmp.get("ind_desc")
				.trim();
		addr_type = (hsmp.get("addr_type") == null) ? "" : hsmp
				.get("addr_type").trim();
		
		address = (hsmp.get("address") == null) ? "" : hsmp
				.get("address").trim();
	}

	public String getInd_desc() {
		return ind_desc;
	}

	public void setInd_desc(String ind_desc) {
		this.ind_desc = ind_desc;
	}

	public String getAddr_type() {
		return addr_type;
	}

	public void setAddr_type(String addr_type) {
		this.addr_type = addr_type;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
