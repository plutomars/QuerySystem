package query.model.PoDetail;
/**
* @ * @author cora
* 
* @version 1.0<br>
*          100/11/11<br>
*          EC ATM±b¤á¬d¸ß ±K½X¦C¦L¬ö¿ý cc195i
* @since 1.0
*/
import java.util.HashMap;


public class PoDetailECprint {
	private String result_ind;
	private String print_style_desc;
	private String prt_op_desc;
	private String print_date;
	private String overdue_date;
	private String user_name;
	private String address;

	public PoDetailECprint(HashMap<String, String> hsmp) {
		result_ind = (hsmp.get("r_result_ind") == null) ? "" : hsmp.get(
				"r_result_ind").trim();
		print_style_desc = (hsmp.get("r_print_style_desc") == null) ? "" : hsmp.get("r_print_style_desc").trim();
		prt_op_desc = (hsmp.get("r_prt_op_desc") == null) ? "" : hsmp.get("r_prt_op_desc").trim();
		print_date = (hsmp.get("r_print_date") == null) ? "" : hsmp.get("r_print_date").trim();
		overdue_date = (hsmp.get("r_overdue_date") == null) ? "" : hsmp.get("r_overdue_date").trim();
		user_name = (hsmp.get("r_user_name") == null) ? "" : hsmp.get("r_user_name").trim();
		address = (hsmp.get("r_address") == null) ? "" : hsmp.get("r_address").trim();
	}
	
	public String getResult_ind() {
		return result_ind;
	}

	public void setResult_ind(String result_ind) {
		this.result_ind = result_ind;
	}
    public String getprint_style_desc() {
        return print_style_desc; }
    public void setprint_style_desc(String print_style_desc) {
        this.print_style_desc = print_style_desc; }

    public String getprt_op_desc() {
        return prt_op_desc; }
    public void setprt_op_desc(String prt_op_desc) {
        this.prt_op_desc = prt_op_desc; }

    public String getprint_date() {
        return print_date; }
    public void setprint_date(String print_date) {
        this.print_date = print_date; }

    public String getoverdue_date() {
        return overdue_date; }
    public void setoverdue_date(String overdue_date) {
        this.overdue_date = overdue_date; }

    public String getuser_name() {
        return user_name; }
    public void setuser_name(String user_name) {
        this.user_name = user_name; }

    public String getaddress() {
        return address; }
    public void setaddress(String address) {
        this.address = address; }

}
