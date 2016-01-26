package query.model.PremBldt;

import java.util.ArrayList;
import java.util.HashMap;
/**
 * 
 * @author cychu
 * 
 * @version 1.0<br/>
 * 			101/04/11<br/>
 * 			送金記錄查詢－送金明細(JavaBean)
 *
 * @since 1.0
 */
public class PremBldt01 {
	private String result_ind;				//0_結果
	private String bill_no;					//1_送金單號
	private String bldt_sts_desc;			//2_送金媒體資料狀況描述
	private String bill_date_from;			//3_送金單起日
	private String collector;				//4_收費員代碼
	private String collector_name;			//5_收費員姓名
	private String mode_prem;				//6_入帳保費
	private String related_key;				//7_Related Key
	private String seqno;					//8_序號
	private String gross_mode_prem;			//9_原始保費
	private String process_date;			//10_初始出單日
	private String high_remark;				//11_高保費指示
	private String mode_prem_h;				//12_高保費折扣後繳別保費
	private String bill_return_no;			//13_歸檔批次
	private String coll_rate_ind;			//14_收費率指示
	private String bldt_sts_date;			//15_狀態日期
	private String last_check_date;			//16_最遠支票日
	private String fixed_ind;				//17_定期保費指示
	private String pceb_sts_code;			//18_送金單E-Billing狀態
	
	public PremBldt01(HashMap<String, String> hsmp) {
		result_ind = (hsmp.get("r_result_ind") == null) ? "" : hsmp.get(
		"r_result_ind").trim();
		bill_no = (hsmp.get("r_bill_no") == null) ? "" : hsmp.get(
		"r_bill_no").trim();
		bldt_sts_desc = (hsmp.get("r_bldt_sts_desc") == null) ? "" : hsmp.get(
		"r_bldt_sts_desc").trim();
		bill_date_from = (hsmp.get("r_bill_date_from") == null) ? "" : hsmp.get(
		"r_bill_date_from").trim();
		collector = (hsmp.get("r_collector") == null) ? "" : hsmp.get(
		"r_collector").trim();
		collector_name = (hsmp.get("r_collector_name") == null) ? "" : hsmp.get(
		"r_collector_name").trim();
		mode_prem = (hsmp.get("r_mode_prem") == null) ? "" : hsmp.get(
		"r_mode_prem").trim();
		related_key = (hsmp.get("r_related_key") == null) ? "" : hsmp.get(
		"r_related_key").trim();
		seqno = (hsmp.get("r_seqno") == null) ? "" : hsmp.get(
		"r_seqno").trim();
		gross_mode_prem = (hsmp.get("r_gross_mode_prem") == null) ? "" : hsmp.get(
		"r_gross_mode_prem").trim();
		process_date = (hsmp.get("r_process_date") == null) ? "" : hsmp.get(
		"r_process_date").trim();
		high_remark = (hsmp.get("r_high_remark") == null) ? "" : hsmp.get(
		"r_high_remark").trim();
		mode_prem_h = (hsmp.get("r_mode_prem_h") == null) ? "" : hsmp.get(
		"r_mode_prem_h").trim();
		bill_return_no = (hsmp.get("r_bill_return_no") == null) ? "" : hsmp.get(
		"r_bill_return_no").trim();
		coll_rate_ind = (hsmp.get("r_coll_rate_ind") == null) ? "" : hsmp.get(
		"r_coll_rate_ind").trim();
		bldt_sts_date = (hsmp.get("r_bldt_sts_date") == null) ? "" : hsmp.get(
		"r_bldt_sts_date").trim();
		last_check_date = (hsmp.get("r_last_check_date") == null) ? "" : hsmp.get(
		"r_last_check_date").trim();
		fixed_ind = (hsmp.get("r_fixed_ind") == null) ? "" : hsmp.get(
		"r_fixed_ind").trim();
		pceb_sts_code = (hsmp.get("r_pceb_sts_code") == null) ? "" : hsmp.get(
		"r_pceb_sts_code").trim();
	}

	public String[] getValues() {
		ArrayList<String> valueList = new ArrayList<String>();

		valueList.add(gross_mode_prem);
		valueList.add(high_remark);
		valueList.add(mode_prem_h);
		valueList.add(bill_return_no);
		valueList.add(coll_rate_ind);
		valueList.add(fixed_ind);
		valueList.add(pceb_sts_code);

		String[] valueArray = new String[valueList.size()];
		valueList.toArray(valueArray);
		return valueArray;
	}
	
	public String getResult_ind() {
		return result_ind;
	}

	public void setResult_ind(String result_ind) {
		this.result_ind = result_ind;
	}

	public String getBill_no() {
		return bill_no;
	}

	public void setBill_no(String bill_no) {
		this.bill_no = bill_no;
	}

	public String getBldt_sts_desc() {
		return bldt_sts_desc;
	}

	public void setBldt_sts_desc(String bldt_sts_desc) {
		this.bldt_sts_desc = bldt_sts_desc;
	}

	public String getBill_date_from() {
		return bill_date_from;
	}

	public void setBill_date_from(String bill_date_from) {
		this.bill_date_from = bill_date_from;
	}

	public String getCollector() {
		return collector;
	}

	public void setCollector(String collector) {
		this.collector = collector;
	}

	public String getCollector_name() {
		return collector_name;
	}

	public void setCollector_name(String collector_name) {
		this.collector_name = collector_name;
	}

	public String getMode_prem() {
		return mode_prem;
	}

	public void setMode_prem(String mode_prem) {
		this.mode_prem = mode_prem;
	}

	public String getRelated_key() {
		return related_key;
	}

	public void setRelated_key(String related_key) {
		this.related_key = related_key;
	}

	public String getSeqno() {
		return seqno;
	}

	public void setSeqno(String seqno) {
		this.seqno = seqno;
	}

	public String getGross_mode_prem() {
		return gross_mode_prem;
	}

	public void setGross_mode_prem(String gross_mode_prem) {
		this.gross_mode_prem = gross_mode_prem;
	}

	public String getProcess_date() {
		return process_date;
	}

	public void setProcess_date(String process_date) {
		this.process_date = process_date;
	}

	public String getHigh_remark() {
		return high_remark;
	}

	public void setHigh_remark(String high_remark) {
		this.high_remark = high_remark;
	}

	public String getMode_prem_h() {
		return mode_prem_h;
	}

	public void setMode_prem_h(String mode_prem_h) {
		this.mode_prem_h = mode_prem_h;
	}

	public String getBill_return_no() {
		return bill_return_no;
	}

	public void setBill_return_no(String bill_return_no) {
		this.bill_return_no = bill_return_no;
	}

	public String getColl_rate_ind() {
		return coll_rate_ind;
	}

	public void setColl_rate_ind(String coll_rate_ind) {
		this.coll_rate_ind = coll_rate_ind;
	}

	public String getBldt_sts_date() {
		return bldt_sts_date;
	}

	public void setBldt_sts_date(String bldt_sts_date) {
		this.bldt_sts_date = bldt_sts_date;
	}

	public String getLast_check_date() {
		return last_check_date;
	}

	public void setLast_check_date(String last_check_date) {
		this.last_check_date = last_check_date;
	}

	public String getFixed_ind() {
		return fixed_ind;
	}

	public void setFixed_ind(String fixed_ind) {
		this.fixed_ind = fixed_ind;
	}

	public String getPceb_sts_code() {
		return pceb_sts_code;
	}

	public void setPceb_sts_code(String pceb_sts_code) {
		this.pceb_sts_code = pceb_sts_code;
	}
}
