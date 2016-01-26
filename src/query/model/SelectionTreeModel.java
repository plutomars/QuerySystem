package query.model;

import java.util.HashMap;

import javax.swing.tree.DefaultMutableTreeNode;

/**
 * @ * @author FYYANG
 * 
 * @version 1.0<br>
 *          100/07/28<br>
 *          主機交易查詢系統JTree節點產生及各對應之值
 * 
 * @since 1.0
 * 
 */
public class SelectionTreeModel {

	private static HashMap<String, Integer> map = new HashMap<String, Integer>(); // 儲存子節點對應數值
	private static DefaultMutableTreeNode rootnode = new DefaultMutableTreeNode(
			" ");
	private static HashMap<String, Authority> authorities;

	// 需要做權限控管之程式列於此,前面是9000對應program_id,後為節點對應值
	public static Object[][] lock_program = { { "nba09i", "nba09i", "1A" }, // 契約公會索引
																			// NewDetailJPanel用
																			// 101/10/24改用nba09i
			{ "psg07m", "psg07m", "1" }, // EC交易紀錄
			{ "clf02i", SelectionTreeModel.S_CLAIMASSO, "1" } };// 理賠公會索引

	// { "db005i", SelectionTreeModel.S_RELATION, "M" }};
	// { "mc002m", SelectionTreeModel.S_CASHFLOW, "4" } };

	public static void setAuthorities(HashMap<String, Authority> authoritity) {
		authorities = authoritity;
	}

	/**
	 * 產生JTree要用之節點Hashtable<String,Object>
	 * 
	 * @return Hashtable <String,Object>
	 */
	public static DefaultMutableTreeNode getInstance() {
		addPoValueNodes();
		addInvestNodes();
		addPosNodes();
		addAccountNodes();
		addPaymentNodes();
		addNBNodes();
		addNetTermNodes();

		return rootnode;
	}

	// 保單內容
	public final static int S_PODETAIL = 111;
	public final static int S_POEXAM = 112;
	public final static int S_RELATION = 113;
	public final static int S_POPLAN = 114;
	public final static int S_POBONUS = 115;
	public final static int S_CLIENTINFO = 130;
	public final static int S_POVALUEADDSHARE = 131;
	// 保單價值
	public final static int S_DRAWDETAIL = 121;
	public final static int S_VALUEREPAY = 122;
	public final static int S_POREASSOCIATE = 123;

	private static void addPoValueNodes() {
		// addChildNode(rootnode, "提示訊息", SelectionTreeModel.S_CLIENTINFO);
		map.put("提示訊息", SelectionTreeModel.S_CLIENTINFO);
		DefaultMutableTreeNode parentnode = addParentNode(rootnode, "保單價值/內容");

		DefaultMutableTreeNode parentnode2 = addParentNode(parentnode, "保單內容");
		addChildNode(parentnode2, "保單明細", SelectionTreeModel.S_PODETAIL);
		addChildNode(parentnode2, "體檢批註告知", SelectionTreeModel.S_POEXAM);
		addChildNode(parentnode2, "關係人資料", SelectionTreeModel.S_RELATION);
		addChildNode(parentnode2, "保障險種資料", SelectionTreeModel.S_POPLAN);
		addChildNode(parentnode2, "紅利資料", SelectionTreeModel.S_POBONUS);
		addChildNode(parentnode2, "增值回饋分享金",
				SelectionTreeModel.S_POVALUEADDSHARE);

		DefaultMutableTreeNode parentnode3 = addParentNode(parentnode, "保單價值");
		addChildNode(parentnode3, "年金提存明細", SelectionTreeModel.S_DRAWDETAIL);
		addChildNode(parentnode3, "還本金", SelectionTreeModel.S_VALUEREPAY);
		addChildNode(parentnode3, "回流關聯查詢", SelectionTreeModel.S_POREASSOCIATE);
	}

	// 投資交易
	public final static int S_INVESTCODE = 301;
	public final static int S_INVESTHISTORY = 302;
	public final static int S_CASHFLOW = 303;
	public final static int S_INVESTAUTO = 304;
	public final static int S_INVESTDEDUCTION = 305;
	public final static int S_INVESTAPPOINT = 306;

	private static void addInvestNodes() {
		DefaultMutableTreeNode parentnode = addParentNode(rootnode, "投資交易");

		addChildNode(parentnode, "投資標的、餘額", SelectionTreeModel.S_INVESTCODE);
		addChildNode(parentnode, "交易記錄", SelectionTreeModel.S_INVESTHISTORY);
		addChildNode(parentnode, "現金流量", SelectionTreeModel.S_CASHFLOW);
		addChildNode(parentnode, "自動轉換與停利查詢", SelectionTreeModel.S_INVESTAUTO);
		addChildNode(parentnode, "每月扣除額查詢",
				SelectionTreeModel.S_INVESTDEDUCTION);
		addChildNode(parentnode, "約定轉換/提領查詢",
				SelectionTreeModel.S_INVESTAPPOINT);

	}

	// 新契約
	// public final static int S_NEWRESCIND = 411;
	// public final static int S_NEWHOSPITAL = 412;
	// 保戶服務
	public final static int S_POSCHANGE = 421;
	public final static int S_POSNOTICE = 422;
	public final static int S_POSECATM = 423;

	private static void addPosNodes() {
		DefaultMutableTreeNode parentnode = addParentNode(rootnode, "保戶服務資料");
		// 新契約
		// DefaultMutableTreeNode parentnode2 = addParentNode(parentnode,
		// "新契約");
		// addChildNode(parentnode2, "契約撤銷", SelectionTreeModel.S_NEWRESCIND);
		// addChildNode(parentnode2, "體檢醫院", SelectionTreeModel.S_NEWHOSPITAL);

		// 保戶服務
		// DefaultMutableTreeNode parentnode2 = addParentNode(parentnode,
		// //101/07/10與麗娟協議可拿掉資料夾
		// "保戶服務受理/照會");
		addChildNode(parentnode, "契約變更記錄", SelectionTreeModel.S_POSCHANGE);
		addChildNode(parentnode, "照會記錄", SelectionTreeModel.S_POSNOTICE);
		addChildNode(parentnode, "自動化查詢", SelectionTreeModel.S_POSECATM);

		// DefaultMutableTreeNode parentnode3 = addParentNode(parentnode,
		// "保單借款/還款查詢");
		// addChildNode(parentnode3, "傳統/投資借款", 0);
		// addChildNode(parentnode3, "年金借款", 0);
		// addChildNode(parentnode3, "遠端借還款查詢", 0);
		//
		// DefaultMutableTreeNode parentnode4 = addParentNode(parentnode,
		// "保單終止查詢");
		// addChildNode(parentnode4, "保單終止(傳統)", 0);
		// addChildNode(parentnode4, "年金終止契約", 0);
		// addChildNode(parentnode4, "投資型終止契約", 0);

		// addChildNode(parentnode, "年金給付查詢", 0);
	}

	// 理賠資料
	public final static int S_CLAIMHISTORY = 211;
	public final static int S_CLAIMASSO = 212;
	// 收費資料
	public final static int S_DELEGATION = 221;
	public final static int S_PREMBILL = 222;
	public final static int S_PREMGBILL = 223;
	public final static int S_PREMQUERY = 224;
	public final static int S_PREMACCOUNT = 225;
	public final static int S_PREMREJECT = 226;
	public final static int S_PREMBLDT = 227;
	public final static int S_PREMPOSTAL = 228;

	private static void addAccountNodes() {
		DefaultMutableTreeNode parentnode = addParentNode(rootnode, "理賠/收費");

		DefaultMutableTreeNode parentnode2 = addParentNode(parentnode, "理賠資料");
		addChildNode(parentnode2, "理賠記錄", SelectionTreeModel.S_CLAIMHISTORY);
		addChildNode(parentnode2, "公會投保資料查詢", SelectionTreeModel.S_CLAIMASSO);

		DefaultMutableTreeNode parentnode3 = addParentNode(parentnode, "收費資料");
		addChildNode(parentnode3, "授權、委託書明細", SelectionTreeModel.S_DELEGATION);
		addChildNode(parentnode3, "扣款明細", SelectionTreeModel.S_PREMBILL);
		addChildNode(parentnode3, "集體彙繳查詢", SelectionTreeModel.S_PREMGBILL);
		addChildNode(parentnode3, "退件查詢", SelectionTreeModel.S_PREMREJECT);
		addChildNode(parentnode3, "送金記錄查詢", SelectionTreeModel.S_PREMBLDT);
		addChildNode(parentnode3, "媒體繳款查詢", SelectionTreeModel.S_PREMPOSTAL);
		// DefaultMutableTreeNode parentnode4 = addParentNode(parentnode,
		// "帳務資料");
		// addChildNode(parentnode4, "付款資料查詢", SelectionTreeModel.S_PREMQUERY);
		// addChildNode(parentnode4, "指定帳戶查詢",
		// SelectionTreeModel.S_PREMACCOUNT);
	}

	private static void addPaymentNodes() {
		DefaultMutableTreeNode parentnode4 = addParentNode(rootnode,
				"付款/指定匯款帳戶查詢");
		addChildNode(parentnode4, "付款資料查詢", SelectionTreeModel.S_PREMQUERY);
		addChildNode(parentnode4, "指定匯款帳戶查詢", SelectionTreeModel.S_PREMACCOUNT);
	}

	// 新契約
	public final static int S_NEWDETAIL = 511;
	public final static int S_NEWRESCIND = 512;
	public final static int S_NEWHOSPITAL = 513;
	public final static int S_NEWFACEAMOUNT = 514;
	public final static int S_NEWSAMPLING = 515;
	public final static int S_NEWPHYSICALEXAM = 516;

	private static void addNBNodes() {
		DefaultMutableTreeNode parentnode = addParentNode(rootnode, "新契約資料");
		// DefaultMutableTreeNode parentnode2 = addParentNode(parentnode,
		// "新契約");
		// addChildNode(parentnode, "新契約明細", SelectionTreeModel.S_NEWDETAIL);
		// addChildNode(parentnode, "契約撤銷", SelectionTreeModel.S_NEWRESCIND);
		addChildNode(parentnode, "新契約查詢", SelectionTreeModel.S_NEWDETAIL);
		addChildNode(parentnode, "投保記錄查詢", SelectionTreeModel.S_NEWFACEAMOUNT);
		addChildNode(parentnode, "抽檢記錄查詢", SelectionTreeModel.S_NEWSAMPLING);
		addChildNode(parentnode, "體檢費扣佣查詢",
				SelectionTreeModel.S_NEWPHYSICALEXAM);
		addChildNode(parentnode, "體檢醫院", SelectionTreeModel.S_NEWHOSPITAL);
	}

	public final static int S_NETTERM_11 = 9911;
	public final static int S_NETTERM_12 = 9912;
	// public final static int S_NETTERM_13 = 9913;
	// public final static int S_NETTERM_14 = 9914;
	public final static int S_NETTERM_15 = 9915;
	public final static int S_NETTERM_16 = 9916;
	public final static int S_NETTERM_17 = 9917;
	public final static int S_NETTERM_18 = 9918;
	public final static int S_NETTERM_19 = 9919;

	public final static int S_NETTERM_21 = 9921;

	public final static int S_NETTERM_31 = 9931;
	public final static int S_NETTERM_32 = 9932;

	public final static int S_NETTERM_41 = 9941;
	public final static int S_NETTERM_42 = 9942;
	public final static int S_NETTERM_43 = 9943;
	public final static int S_NETTERM_44 = 9944;

	public final static int S_NETTERM_51 = 9951;
	public final static int S_NETTERM_52 = 9952;
	public final static int S_NETTERM_53 = 9953;

	public final static int S_NETTERM_61 = 9961;
	public final static int S_NETTERM_62 = 9962;
	public final static int S_NETTERM_63 = 9963;
	public final static int S_NETTERM_64 = 9964;
	public final static int S_NETTERM_65 = 9965;

	public final static int S_NETTERM_71 = 9971;
	public final static int S_NETTERM_72 = 9972;
	public final static int S_NETTERM_73 = 9973;

	public final static int S_NETTERM_81 = 9981;
	public final static int S_NETTERM_82 = 9982;

	public final static int S_NETTERM_91 = 9991;
	public final static int S_NETTERM_92 = 9992;
	public final static int S_NETTERM_93 = 9993;
	public final static int S_NETTERM_94 = 9994;
	public final static int S_NETTERM_95 = 9995;

	public final static int S_NETTERM_101 = 99101;

	public final static int S_NETTERM_102 = 99102;
	public final static int S_NETTERM_103 = 99103;
	public final static int S_NETTERM_104 = 99104;

	public final static int S_NETTERM_111 = 99111;
	public final static int S_NETTERM_112 = 99112;
	public final static int S_NETTERM_113 = 99113;

	public final static int S_NETTERM_121 = 99121;

	private static void addNetTermNodes() {
		DefaultMutableTreeNode parnetnode = addParentNode(rootnode, "連結NETTERM");
		// 19------------------------------------------------------------------------
		DefaultMutableTreeNode parnetnode2 = addParentNode(parnetnode,
				"借款/ 終止/ ETI /RPU");
		addChildNode(parnetnode2, "借款試算-非年金", SelectionTreeModel.S_NETTERM_11);
		addChildNode(parnetnode2, "借款試算-年金", SelectionTreeModel.S_NETTERM_12);
		// addChildNode(parnetnode2, "還款試算-非年金",
		// SelectionTreeModel.S_NETTERM_13);
		// addChildNode(parnetnode2, "還款試算-年金",
		// SelectionTreeModel.S_NETTERM_14);
		addChildNode(parnetnode2, "解約試算-一般", SelectionTreeModel.S_NETTERM_15);
		addChildNode(parnetnode2, "解約試算-投資", SelectionTreeModel.S_NETTERM_16);
		addChildNode(parnetnode2, "解約試算-年金", SelectionTreeModel.S_NETTERM_17);
		addChildNode(parnetnode2, "減額繳清/展期", SelectionTreeModel.S_NETTERM_18);
		addChildNode(parnetnode2, "年金身故退費", SelectionTreeModel.S_NETTERM_19);

		//
		DefaultMutableTreeNode parnetnode12 = addParentNode(parnetnode,
				"保單帳戶價值減少/部分終止");
		addChildNode(parnetnode12, "投資標的提領", SelectionTreeModel.S_NETTERM_111);
		addChildNode(parnetnode12, "UL提領", SelectionTreeModel.S_NETTERM_112);
		addChildNode(parnetnode12, "年金部分終止", SelectionTreeModel.S_NETTERM_113);

		// 21------------------------------------------------------------------------
		DefaultMutableTreeNode parnetnode3 = addParentNode(parnetnode, "帳務資料");
		addChildNode(parnetnode3, "繳費紀錄", SelectionTreeModel.S_NETTERM_21);

		// 32------------------------------------------------------------------------
		DefaultMutableTreeNode parnetnode4 = addParentNode(parnetnode, "理賠資料");
		addChildNode(parnetnode4, "團險理賠歷史", SelectionTreeModel.S_NETTERM_31);
		addChildNode(parnetnode4, "團險理賠受理", SelectionTreeModel.S_NETTERM_32);

		// 44------------------------------------------------------------------------
		DefaultMutableTreeNode parnetnode5 = addParentNode(parnetnode, "收費資料");
		addChildNode(parnetnode5, "授權、委託書退件", SelectionTreeModel.S_NETTERM_41);
		addChildNode(parnetnode5, "送金記錄", SelectionTreeModel.S_NETTERM_42);
		addChildNode(parnetnode5, "延滯利息試算", SelectionTreeModel.S_NETTERM_43);
		addChildNode(parnetnode5, "更改信用卡有效期", SelectionTreeModel.S_NETTERM_44);

		// 53------------------------------------------------------------------------
		DefaultMutableTreeNode parnetnode6 = addParentNode(parnetnode, "投資交易");
		addChildNode(parnetnode6, "保費明細", SelectionTreeModel.S_NETTERM_51);
		addChildNode(parnetnode6, "每月扣除額", SelectionTreeModel.S_NETTERM_52);
		addChildNode(parnetnode6, "門檻保費保額", SelectionTreeModel.S_NETTERM_53);

		// 65------------------------------------------------------------------------
		DefaultMutableTreeNode parnetnode7 = addParentNode(parnetnode, "保戶服務");
		addChildNode(parnetnode7, "繳費證明補發", SelectionTreeModel.S_NETTERM_61);
		addChildNode(parnetnode7, "三年免費健檢", SelectionTreeModel.S_NETTERM_62);
		// addChildNode(parnetnode7, "修改收費地址", SelectionTreeModel.S_NETTERM_63);
		// addChildNode(parnetnode7, "修改手機/MAIL",
		// SelectionTreeModel.S_NETTERM_64);
		addChildNode(parnetnode7, "保額選擇權查詢", SelectionTreeModel.S_NETTERM_65);

		// 73------------------------------------------------------------------------
		DefaultMutableTreeNode parnetnode8 = addParentNode(parnetnode, "業務行政");
		addChildNode(parnetnode8, "保戶園地", SelectionTreeModel.S_NETTERM_71);
		addChildNode(parnetnode8, "險種費率查詢", SelectionTreeModel.S_NETTERM_72);
		addChildNode(parnetnode8, "險種描述", SelectionTreeModel.S_NETTERM_73);

		// 82------------------------------------------------------------------------
		DefaultMutableTreeNode parnetnode9 = addParentNode(parnetnode, "團險");
		addChildNode(parnetnode9, "團險查詢", SelectionTreeModel.S_NETTERM_81);
		addChildNode(parnetnode9, "業務員資料查詢", SelectionTreeModel.S_NETTERM_82);

		// 93------------------------------------------------------------------------
		DefaultMutableTreeNode parnetnode10 = addParentNode(parnetnode,
				"借還款歷史查詢");
		addChildNode(parnetnode10, "非年金", SelectionTreeModel.S_NETTERM_91);
		addChildNode(parnetnode10, "年金", SelectionTreeModel.S_NETTERM_92);
		addChildNode(parnetnode10, "ATM虛擬帳號", SelectionTreeModel.S_NETTERM_93);
		addChildNode(parnetnode10, "還款試算-非年金", SelectionTreeModel.S_NETTERM_94);
		addChildNode(parnetnode10, "還款試算-年金", SelectionTreeModel.S_NETTERM_95);

		DefaultMutableTreeNode parnetnode13 = addParentNode(parnetnode, "新契約查詢");
		addChildNode(parnetnode13, "投保記錄", SelectionTreeModel.S_NETTERM_121);

		// 103------------------------------------------------------------------------
		DefaultMutableTreeNode parnetnode11 = addParentNode(parnetnode, "TA");
		addChildNode(parnetnode11, "TA要保資料", SelectionTreeModel.S_NETTERM_101);

		addChildNode(parnetnode, "電銷免費", SelectionTreeModel.S_NETTERM_102);
		addChildNode(parnetnode, "紅利線上作業", SelectionTreeModel.S_NETTERM_103);
		addChildNode(parnetnode, "回主畫面", SelectionTreeModel.S_NETTERM_104);
	}

	private static DefaultMutableTreeNode addParentNode(
			DefaultMutableTreeNode parentnode, String nodename) {
		DefaultMutableTreeNode childnode = new DefaultMutableTreeNode(nodename);
		parentnode.add(childnode);
		return childnode;
	}

	private static void addChildNode(DefaultMutableTreeNode parentnode,
			String nodename, int nodevalue) {

		if (getAuthority(String.valueOf(nodevalue)).trim().length() != 0) {
			DefaultMutableTreeNode childnode = new DefaultMutableTreeNode(
					nodename);
			parentnode.add(childnode);
			map.put(nodename, nodevalue);
		} else {
			System.out.println(nodename + " has no right to query");
		}

	}

	// A:add,Q:query,D:delete
	private static String getAuthority(String nodeValue) {
		if (authorities.containsKey(String.valueOf(nodeValue))) {
			return authorities.get(String.valueOf(nodeValue))
					.getQuery_authority();

		} else {
			return "Q";
		}
	}

	public static boolean getTabAuthority(String program_id, String type) {
		// return true = 有權限
		if (authorities.containsKey(program_id)) {
			int i = type.length();
			int j;
			if (i > 0) {
				for (j = 0; j < i; j++) {
					if (authorities.get(program_id).getUser_authority()
							.contains(type.substring(j, j + 1)))
						return true;
				}
			}
		}
		return false;
	}

	/**
	 * 取得jTree關鍵節點對應之值 <br>
	 * 給SelectionTreeControl用來做Switch比對用
	 * 
	 * @reutrn HashMap<String,Integer>
	 */
	public static HashMap<String, Integer> getTreeMapValue() {
		return map;
	}

	/**
	 * 和getTreeMapValue並用 取得<br>
	 * jTree關鍵節點對應之值 <br>
	 * 給SelectionTreeControl用來做Switch比對用
	 * 
	 * @param nodename
	 *            (節點KEY值)用來尋找的節點對應值ex,getActionNodeValue("保單明細")
	 * @return int 節點KEY對之之值
	 */
	public static int getActionNodeValue(String nodename) {
		return SelectionTreeModel.getTreeMapValue().get(nodename);
	}
}
