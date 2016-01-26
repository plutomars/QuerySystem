package query.model.PoPlan;

import java.util.HashMap;
/**
 * 
 * @author cychu
 *
 * @version 1.0<br/>
 * 			100/09/07<br/>
 * 			每期保費/原始保費(JavaBean)
 * 
 * @since 1.0
 */
public class PoPlanPrem {
	private String result_ind;
	private String nc_str;
	
	public PoPlanPrem(HashMap<String, String> hsmp) {
		result_ind = (hsmp.get("r_result_ind") == null) ? "" : hsmp.get(
				"r_result_ind").trim();
		nc_str = (hsmp.get("r_nc_str") == null) ? "" : hsmp.get(
				"r_nc_str").trim();
	}

	public String getResult_ind() {
		return result_ind;
	}

	public void setResult_ind(String result_ind) {
		this.result_ind = result_ind;
	}

	public String getNc_str() {
		return nc_str;
	}

	public void setNc_str(String nc_str) {
		this.nc_str = nc_str;
	}
	
	public String getCoveragePrem(String covNo, String nc_str, String type) {
		String coveragePrem = "";
		String[] allCoverages = nc_str.split("[|]");
		
		int coverage_no = Integer.parseInt(covNo);
		if ( coverage_no <= 50){
		//原始保費
		if (type.compareTo("mode_prem") == 0) {
//			coveragePrem = allCoverages[(coverage_no-1)*3+2];
			coveragePrem = allCoverages[coverage_no*3];
		}
		//保障繳別保費
		if (type.compareTo("init_prem") == 0) {
//			coveragePrem = allCoverages[coverage_no*3];
			coveragePrem = allCoverages[(coverage_no-1)*3+2];
		}
		}
		return coveragePrem;
	}
}
