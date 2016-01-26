package query.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.DefaultListSelectionModel;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.ELProperty;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

import query.controller.NewDetailController;
import query.model.SelectionTreeModel;
import query.model.NewDetail.NewDetailClaimHistory;
import query.model.NewDetail.NewDetailClaimHistoryGroup;
import query.model.NewDetail.NewDetailComm;
import query.model.NewDetail.NewDetailCommCmnt;
import query.model.NewDetail.NewDetailCommCmntGroup;
import query.model.NewDetail.NewDetailCommGroup;
import query.model.NewDetail.NewDetailCommInsured;
import query.model.NewDetail.NewDetailCommInsuredGroup;
import query.model.NewDetail.NewDetailDeny;
import query.model.NewDetail.NewDetailExamInfo;
import query.model.NewDetail.NewDetailExamInfoGroup;
import query.model.NewDetail.NewDetailExamNotice;
import query.model.NewDetail.NewDetailExamNoticeGroup;
import query.model.NewDetail.NewDetailIllegalAddr;
import query.model.NewDetail.NewDetailIllegalAddrAg;
import query.model.NewDetail.NewDetailIllegalAddrAgGroup;
import query.model.NewDetail.NewDetailIllegalAddrGroup;
import query.model.NewDetail.NewDetailIllegalAddrPo;
import query.model.NewDetail.NewDetailIllegalAddrPoGroup;
import query.model.NewDetail.NewDetailNewAssoIndex;
import query.model.NewDetail.NewDetailNewAssoIndexGroup;
import query.model.NewDetail.NewDetailNotice;
import query.model.NewDetail.NewDetailNoticeGroup;
import query.model.NewDetail.NewDetailOldAssoIndex;
import query.model.NewDetail.NewDetailOldAssoIndexGroup;
import query.model.NewDetail.NewDetailPoStatement;
import query.model.NewDetail.NewDetailPoStatementGroup;
import query.model.NewDetail.NewDetailPosChange;
import query.model.NewDetail.NewDetailPosChangeGroup;
import query.model.NewDetail.NewDetailPreferredExam;
import query.model.NewDetail.NewDetailPreferredExamGroup;
import query.model.NewDetail.NewDetailSignPaper;
import query.model.NewDetail.NewDetailSignPaperGroup;
import query.model.NewDetail.NewDetailUwErrCode;
import query.model.NewDetail.NewDetailUwErrCodeGroup;
import query.model.NewRescind.NewRescind01;
import query.model.PoExam.PoExam00;
import query.model.PoExam.PoExam00Group;
import query.model.PoPlan.PoPlan;
import query.model.PoPlan.PoPlanGroup;

/**
 * 新契約查詢基本資料畫面。
 * 
 * @author cychu
 */
public class NewDetailJPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private static final String program_id = "nba09i";//"nb301m"; //程式ID,用來做權限相關檢核用-add by fyyang
	// private SpringLayout slMain = new SpringLayout();
	private SpringLayout slTab1 = new SpringLayout();
	private SpringLayout slTab2 = new SpringLayout();
	private SpringLayout slTab4 = new SpringLayout();
	private VerticalPane vpane_top1, vpane_top2, vpane_top3, vpane_top4,
			tab2_vpane1, tab2_vpane2, tab4_vpane1, tab4_vpane2,tab5_vpane1;
	private JTextField fieldAddr;

	private NewDetailCommGroup newDetailCommGroup = new NewDetailCommGroup(); // 基本資料要保人
	private NewDetailCommInsuredGroup newDetailCommInsuredGroup = new NewDetailCommInsuredGroup(); // 被保人
	private PoPlanGroup poPlanGroup = new PoPlanGroup(); // 保障資料
	private NewDetailCommCmntGroup newDetailCommCmntGroup = new NewDetailCommCmntGroup(); // 批註
	private PoExam00Group poExam00Group = new PoExam00Group(); // 弱體用體檢批註的model
	private NewDetailExamInfoGroup newDetailExamInfoGroup = new NewDetailExamInfoGroup(); // 體檢資料
	private NewDetailPreferredExamGroup newDetailPreferredExamGroup = new NewDetailPreferredExamGroup(); // 優體保單
	private NewDetailOldAssoIndexGroup newDetailOldAssoIndexGroup = new NewDetailOldAssoIndexGroup(); // 舊公會索引
	private NewDetailClaimHistoryGroup newDetailClaimHistoryGroup = new NewDetailClaimHistoryGroup(); // 理賠記錄
	private NewDetailPosChangeGroup newDetailPosChangeGroup = new NewDetailPosChangeGroup(); // 契變記錄
	private NewDetailPoStatementGroup newDetailPoStatementGroup = new NewDetailPoStatementGroup(); // 告知事項
	private NewDetailUwErrCodeGroup newDetailUwErrCodeGroup = new NewDetailUwErrCodeGroup(); // 核保訊息
	private NewDetailIllegalAddrGroup newDetailIllegalAddrGroup = new NewDetailIllegalAddrGroup(); // 列管地址
	private NewDetailIllegalAddrPoGroup newDetailIllegalAddrPoGroup = new NewDetailIllegalAddrPoGroup();
	private NewDetailIllegalAddrAgGroup newDetailIllegalAddrAgGroup = new NewDetailIllegalAddrAgGroup();

	private NewDetailExamNoticeGroup newDetailExamNoticeGroup = new NewDetailExamNoticeGroup(); // 體檢照會
	private NewDetailSignPaperGroup newDetailSignPaperGroup = new NewDetailSignPaperGroup(); // 簽收單查詢
	private NewDetailNewAssoIndexGroup newDetailNewAssoIndexGroup = new NewDetailNewAssoIndexGroup(); // 新公會索引
	private NewDetailNoticeGroup newDetailNoticeGroup = new NewDetailNoticeGroup(); // 照會項目
	private List<NewRescind01> newRescind01List = new ArrayList<NewRescind01>(); // 契約撤銷

	private JTable tbl_mid, tbl_btm, tab1_tbl1, tab1_tbl2, tab1_tbl3,
			tab1_tbl4, tab1_tbl5, tab1_tbl6, tab1_tbl9, tab1_tbl7, tab1_tbl8,
			tab1_tbl10, tab1_tbl11, tab3_tbl, tab2_tbl3;

	private JTabbedPane main_tab_pane;
	public JTabbedPane tab1_btm_pane;  // 公會索引在controll檢查權限
	private JScrollPane tab1_pane6;
	private JPanel tab1_top_panel2;

	// 記錄main_tab index的hashmap
	private HashMap<String, Integer> tabIndexMap = new HashMap<String, Integer>();
	private JTable tab1_tbl10_2;
	private JTable tab1_tbl10_3;

	private NewDetailController newDetailController;
	private JTextField txtHight;
	private JTextField txtWeight;
	private JTextField txtBMI;
	private JTextField txtCHO;
	private JTextField txtExamInd;

	public NewDetailJPanel() {
		setLayout(new BorderLayout());
		this.setSize(500, 600);
		// 基本資料
		JPanel tab1_panel = new JPanel(slTab1);

		// 要保人資料
		JPanel tab1_top_panel1_1 = new JPanel(new BorderLayout());
		JPanel panel_mid_addr = new JPanel();
		panel_mid_addr.setLayout(new FlowLayout(FlowLayout.LEADING));
		
		// JLabel lblAddr = new JLabel("主被保險人住所：");
		fieldAddr = new JTextField();
		fieldAddr.setColumns(500);
		fieldAddr.setEditable(false);
		// panel_mid_addr.add(lblAddr);
		panel_mid_addr.add(fieldAddr);
		// 允許保單欄位使用剪下貼上
		fieldAddr.addMouseListener(new MouseAdapter() {
					public void mousePressed(MouseEvent e) {

						QueryFrame.showPopmenu(true, e);
					}
				});
		tab1_top_panel1_1.add(panel_mid_addr, BorderLayout.NORTH);

		JPanel tab1_top_panel1 = new JPanel(new GridLayout(0, 4));
		tab1_top_panel1.setBorder(new TitledBorder(null, "要保人資料",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));

		String[] tbl_top_head1 = { " ID", " 姓名/簽樣卡", " 出生日期", " 序號/住所", " 序號/收費" };
		vpane_top1 = new VerticalPane(tbl_top_head1, "", 90, 20);
		tab1_top_panel1.add(vpane_top1);

		String[] tbl_top_head2 = { " 保單號碼", " 狀態", " 繳法/每期保費", " 收費方式", " 定期繳費約定" };
		vpane_top2 = new VerticalPane(tbl_top_head2, "", 105, 20);
		tab1_top_panel1.add(vpane_top2);

		String[] tbl_top_head3 = { " 要保日", " 生效日", " 核定日", " 承保日", " 製單日" };
		vpane_top3 = new VerticalPane(tbl_top_head3, "", 60, 20);
		tab1_top_panel1.add(vpane_top3);

		String[] tbl_top_head4 = { " 住所電話", " 收費電話", " 行動電話", " e-mail",
				" 職業代碼/職級" };
		vpane_top4 = new VerticalPane(tbl_top_head4, "", 105, 20);
		tab1_top_panel1.add(vpane_top4);

		slTab1.putConstraint(SpringLayout.NORTH, tab1_top_panel1_1, 0,
				SpringLayout.NORTH, tab1_panel);
		slTab1.putConstraint(SpringLayout.WEST, tab1_top_panel1_1, 0,
				SpringLayout.WEST, tab1_panel);
		slTab1.putConstraint(SpringLayout.SOUTH, tab1_top_panel1_1, 177,
				SpringLayout.NORTH, this);
		slTab1.putConstraint(SpringLayout.EAST, tab1_top_panel1_1, 0,
				SpringLayout.EAST, tab1_panel);

		tab1_top_panel1_1.add(tab1_top_panel1, BorderLayout.CENTER);
		tab1_panel.add(tab1_top_panel1_1);

		vpane_top1.setListSelectionListener(true, fieldAddr);
		vpane_top2.setListSelectionListener(true, fieldAddr);
		vpane_top3.setListSelectionListener(true, fieldAddr);
		vpane_top4.setListSelectionListener(true, fieldAddr);

		// 關係人資料
		tab1_top_panel2 = new JPanel(new BorderLayout());
		tab1_top_panel2.setBorder(new TitledBorder(null, "被保險人資料",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));

		// JPanel panel_mid_addr = new JPanel();
		// panel_mid_addr.setLayout(new FlowLayout(FlowLayout.LEFT));
		// JLabel lblAddr = new JLabel("主被保險人住所：");
		// fieldAddr = new JTextField();
		// fieldAddr.setColumns(50);
		// fieldAddr.setEditable(true);
		// panel_mid_addr.add(lblAddr);
		// panel_mid_addr.add(fieldAddr);
		// tab1_top_panel2.add(panel_mid_addr, BorderLayout.NORTH);

		String[][] tblData1 = new String[4][5];
		String[] tblName1 = { "關係", "ID", "姓名", "出生日期", "職業代碼/職級" };
		tbl_mid = new JTable(tblData1, tblName1);

		JScrollPane pane_mid = new JScrollPane(tbl_mid);
		tbl_mid.setFillsViewportHeight(true);
		tab1_top_panel2.add(pane_mid, BorderLayout.CENTER);
		pane_mid.setViewportView(tbl_mid);
		slTab1.putConstraint(SpringLayout.NORTH, tab1_top_panel2, 0,
				SpringLayout.SOUTH, tab1_top_panel1_1);
		slTab1.putConstraint(SpringLayout.WEST, tab1_top_panel2, 0,
				SpringLayout.WEST, tab1_panel);
		slTab1.putConstraint(SpringLayout.SOUTH, tab1_top_panel2, 110,
				SpringLayout.SOUTH, tab1_top_panel1_1);
		slTab1.putConstraint(SpringLayout.EAST, tab1_top_panel2, 0,
				SpringLayout.EAST, tab1_panel);
		tab1_panel.add(tab1_top_panel2);

		// 保障內容
		JPanel tab1_top_panel3 = new JPanel(new BorderLayout());
		tab1_top_panel3.setBorder(new TitledBorder(null, "保障內容",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));

		String[][] tblData2 = new String[5][17];
		String[] tblName2 = { "關係", "險種", "版數", "社保", "保額", "狀態", "職級", "保險年齡",
				"性別", "年度", "生效日期", "每期保費", "變更生效日", "體位", "定額加費", "比例加費",
				"加費年期" };

		tbl_btm = new JTable(tblData2, tblName2) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int rowIdx, int colIdx) {
				return false;
			}
		};
		JScrollPane pane_btm = new JScrollPane(tbl_btm);
		tbl_btm.setFillsViewportHeight(true);
		tab1_top_panel3.add(pane_btm, BorderLayout.CENTER);

		slTab1.putConstraint(SpringLayout.NORTH, tab1_top_panel3, 0,
				SpringLayout.SOUTH, tab1_top_panel2);
		slTab1.putConstraint(SpringLayout.WEST, tab1_top_panel3, 0,
				SpringLayout.WEST, tab1_panel);
		slTab1.putConstraint(SpringLayout.SOUTH, tab1_top_panel3, 153,
				SpringLayout.SOUTH, tab1_top_panel2);
		slTab1.putConstraint(SpringLayout.EAST, tab1_top_panel3, 0,
				SpringLayout.EAST, tab1_panel);
		tab1_panel.add(tab1_top_panel3);

		// 批註
		JPanel tab1_panel1 = new JPanel(new BorderLayout());
		String[][] tab1_data1 = new String[15][8];
		String[] tab1_head1 = { "關係", "批註日期", "取消日期", "類別", "批註內容", "批註年限",
				"弱體代碼", "批註險種" };
		tab1_tbl1 = new JTable(tab1_data1, tab1_head1);
		JScrollPane tab1_pane = new JScrollPane(tab1_tbl1);
		tab1_panel1.add(tab1_pane, BorderLayout.CENTER);

		// 弱體代碼
		JPanel tab1_panel2 = new JPanel(new BorderLayout());
		String[][] tab1_data2 = new String[15][4];
		String[] tab1_head2 = { "被保人", "受理日期", "保單號碼", "弱體" };
		tab1_tbl2 = new JTable(tab1_data2, tab1_head2);
		JScrollPane tab1_pane2 = new JScrollPane(tab1_tbl2);
		tab1_panel2.add(tab1_pane2, BorderLayout.CENTER);

		// 體檢資料
		JPanel tab1_panel3 = new JPanel(new BorderLayout());
		String[][] tab1_data3 = new String[15][5];
		String[] tab1_head3 = { "被保人ID", "體檢項目", "體檢日期", "體檢結果", "體檢醫院" };
		tab1_tbl3 = new JTable(tab1_data3, tab1_head3);
		JScrollPane tab1_pane3 = new JScrollPane(tab1_tbl3);
		tab1_panel3.add(tab1_pane3, BorderLayout.CENTER);

		// 優體保單
		JPanel tab1_panel4 = new JPanel(new BorderLayout());
		String[][] tab1_data4 = new String[15][9];
		String[] tab1_head4 = { "體檢項目", "檢驗值", "正常(Y/N)", "N/P", "身高", "體重",
				"BMI", "CHO/HDL ratio", "優體壽險等級" };
		tab1_tbl4 = new JTable(tab1_data4, tab1_head4);
		JScrollPane tab1_pane4 = new JScrollPane(tab1_tbl4);
		tab1_panel4.add(tab1_pane4, BorderLayout.CENTER);

		JPanel tab1_panel4_1 = new JPanel();
		tab1_panel4.add(tab1_panel4_1, BorderLayout.NORTH);
		GridBagLayout gbl_tab1_panel4_1 = new GridBagLayout();
		gbl_tab1_panel4_1.columnWidths = new int[]{0, 0, 19, 37, 40, 33, 38, 89, 34, 0, 39, 0};
		gbl_tab1_panel4_1.rowHeights = new int[]{0, 0};
		gbl_tab1_panel4_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_tab1_panel4_1.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		tab1_panel4_1.setLayout(gbl_tab1_panel4_1);
		
		JLabel lblHight = new JLabel("\u8EAB\u9AD8");
		GridBagConstraints gbc_lblHight = new GridBagConstraints();
		gbc_lblHight.insets = new Insets(0, 0, 0, 5);
		gbc_lblHight.anchor = GridBagConstraints.EAST;
		gbc_lblHight.gridx = 0;
		gbc_lblHight.gridy = 0;
		tab1_panel4_1.add(lblHight, gbc_lblHight);
		
		txtHight = new JTextField();
		txtHight.setEditable(false);
		GridBagConstraints gbc_txtHight = new GridBagConstraints();
		gbc_txtHight.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtHight.insets = new Insets(0, 0, 0, 5);
		gbc_txtHight.gridx = 2;
		gbc_txtHight.gridy = 0;
		tab1_panel4_1.add(txtHight, gbc_txtHight);
		txtHight.setColumns(10);
		
		JLabel lblWeight = new JLabel("\u9AD4\u91CD");
		GridBagConstraints gbc_lblWeight = new GridBagConstraints();
		gbc_lblWeight.anchor = GridBagConstraints.EAST;
		gbc_lblWeight.insets = new Insets(0, 0, 0, 5);
		gbc_lblWeight.gridx = 3;
		gbc_lblWeight.gridy = 0;
		tab1_panel4_1.add(lblWeight, gbc_lblWeight);
		
		txtWeight = new JTextField();
		txtWeight.setEditable(false);
		GridBagConstraints gbc_txtWeight = new GridBagConstraints();
		gbc_txtWeight.insets = new Insets(0, 0, 0, 5);
		gbc_txtWeight.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtWeight.gridx = 4;
		gbc_txtWeight.gridy = 0;
		tab1_panel4_1.add(txtWeight, gbc_txtWeight);
		txtWeight.setColumns(10);
		
		JLabel lblBMI = new JLabel("BMI");
		GridBagConstraints gbc_lblBMI = new GridBagConstraints();
		gbc_lblBMI.anchor = GridBagConstraints.EAST;
		gbc_lblBMI.insets = new Insets(0, 0, 0, 5);
		gbc_lblBMI.gridx = 5;
		gbc_lblBMI.gridy = 0;
		tab1_panel4_1.add(lblBMI, gbc_lblBMI);
		
		txtBMI = new JTextField();
		txtBMI.setEditable(false);
		GridBagConstraints gbc_txtBMI = new GridBagConstraints();
		gbc_txtBMI.insets = new Insets(0, 0, 0, 5);
		gbc_txtBMI.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtBMI.gridx = 6;
		gbc_txtBMI.gridy = 0;
		tab1_panel4_1.add(txtBMI, gbc_txtBMI);
		txtBMI.setColumns(10);
		
		JLabel lblCHO = new JLabel("CHO/HDL ratio");
		GridBagConstraints gbc_lblCHO = new GridBagConstraints();
		gbc_lblCHO.anchor = GridBagConstraints.EAST;
		gbc_lblCHO.insets = new Insets(0, 0, 0, 5);
		gbc_lblCHO.gridx = 7;
		gbc_lblCHO.gridy = 0;
		tab1_panel4_1.add(lblCHO, gbc_lblCHO);
		
		txtCHO = new JTextField();
		txtCHO.setEditable(false);
		GridBagConstraints gbc_txtCHO = new GridBagConstraints();
		gbc_txtCHO.insets = new Insets(0, 0, 0, 5);
		gbc_txtCHO.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCHO.gridx = 8;
		gbc_txtCHO.gridy = 0;
		tab1_panel4_1.add(txtCHO, gbc_txtCHO);
		txtCHO.setColumns(10);
		
		JLabel lblExamInd = new JLabel("\u512A\u9AD4\u58FD\u96AA\u7B49\u7D1A");
		GridBagConstraints gbc_lblExamInd = new GridBagConstraints();
		gbc_lblExamInd.anchor = GridBagConstraints.EAST;
		gbc_lblExamInd.insets = new Insets(0, 0, 0, 5);
		gbc_lblExamInd.gridx = 9;
		gbc_lblExamInd.gridy = 0;
		tab1_panel4_1.add(lblExamInd, gbc_lblExamInd);
		
		txtExamInd = new JTextField();
		txtExamInd.setEditable(false);
		GridBagConstraints gbc_txtExamInd = new GridBagConstraints();
		gbc_txtExamInd.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtExamInd.gridx = 10;
		gbc_txtExamInd.gridy = 0;
		tab1_panel4_1.add(txtExamInd, gbc_txtExamInd);
		txtExamInd.setColumns(10);
		
		// 公會索引
		JPanel tab1_panel5 = new JPanel(new BorderLayout());
		String[][] tab1_data5 = new String[15][7];
		String[] tab1_head5 = { "類別", "被保險人ID", "姓名", "保額", "通報表別", "公司",
				"生效日期" };
		tab1_tbl5 = new JTable(tab1_data5, tab1_head5);
		JScrollPane tab1_pane5 = new JScrollPane(tab1_tbl5);
		tab1_panel5.add(tab1_pane5, BorderLayout.CENTER);

		// 理賠記錄
		JPanel tab1_panel6 = new JPanel(new BorderLayout());
		/*
		 * String[][] tab1_data6 = new String[15][8]; String[] tab1_head6 = {
		 * "事故人姓名", "序號", "年度", "理賠型態", "事故型態", "事故原因", "結案日期", "結案型態" };
		 * tab1_tbl6 = new JTable(tab1_data6, tab1_head6);
		 */
		tab1_tbl6 = new JTable();
		tab1_pane6 = new JScrollPane(tab1_tbl6);
		tab1_panel6.add(tab1_pane6, BorderLayout.CENTER);

		// 顯示全部事故原因
		tab1_tbl6.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					int row = tab1_tbl6.getSelectedRow();
					if (row != -1) {
						NewDetailClaimHistory data = newDetailClaimHistoryGroup
								.getNewDetailClaimHistorys().get(row);
						newDetailController.showEventCode(data);
					}
				}
			}

		});

		// 告知事項
		JPanel tab1_panel7 = new JPanel(new BorderLayout());
		String[][] tab1_data7 = new String[15][4];
		String[] tab1_head7 = { "被保人", "受理日期", "保單號碼", "告知" };
		tab1_tbl7 = new JTable(tab1_data7, tab1_head7);
		JScrollPane tab1_pane7 = new JScrollPane(tab1_tbl7);
		tab1_panel7.add(tab1_pane7, BorderLayout.CENTER);

		// 核保訊息
		JPanel tab1_panel8 = new JPanel(new BorderLayout());
		String[][] tab1_data8 = new String[15][2];
		String[] tab1_head8 = { "訊息代碼", "核保訊息" };
		tab1_tbl8 = new JTable(tab1_data8, tab1_head8);
		JScrollPane tab1_pane8 = new JScrollPane(tab1_tbl8);
		tab1_panel8.add(tab1_pane8, BorderLayout.CENTER);

		// 顯示舊保單職級，只有點UA21有用
//		tab1_tbl8.setToolTipText("連擊兩下以顯示UA21舊保單職級");
		tab1_tbl8.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (arg0.getClickCount() == 2) {
					int row = tab1_tbl8.getSelectedRow();
					if (row != -1) {
						NewDetailUwErrCode data = newDetailUwErrCodeGroup
								.getNewDetailUwErrCodes().get(row);
						if (data.getNb_err_code().trim().compareTo("UA21") == 0) {
							newDetailController.showOldOccu(data);
						}
					}
				}
			}

		});

		// 契變受理
		JPanel tab1_panel9 = new JPanel(new BorderLayout());
		String[][] tab1_data9 = new String[15][3];
		String[] tab1_head9 = { "受理號碼", "受理日期", "受理狀況" };
		tab1_tbl9 = new JTable(tab1_data9, tab1_head9);
		JScrollPane tab1_pane9 = new JScrollPane(tab1_tbl9);
		tab1_panel9.add(tab1_pane9, BorderLayout.CENTER);

		tab1_tbl9.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (arg0.getClickCount() == 2) {
					int row = tab1_tbl9.getSelectedRow();
					if (row != -1) {
						newDetailController
								.showPosChangeJPanel(newDetailPosChangeGroup
										.getNewDetailPosChanges().get(row)
										.getPolicy_no());
					}
				}
			}

		});

		// 列管地址

		// tab1_panel10.add(scrollPane, gbc_scrollPane);
		JPanel tab1_panel10 = new JPanel();
		tab1_panel10.setPreferredSize(new Dimension(10, 250));
		tab1_panel10.setMaximumSize(new Dimension(32767, 510));
		String[][] tab1_data10 = new String[15][2];
		String[] tab1_head10 = { "地址種類", "檢核分類代碼" };
		GridBagLayout gbl_tab1_panel10 = new GridBagLayout();
		gbl_tab1_panel10.columnWidths = new int[] { 440, 0 };
		gbl_tab1_panel10.rowHeights = new int[] { 77, 459, 64, 0 };
		gbl_tab1_panel10.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_tab1_panel10.rowWeights = new double[] { 0.0, 1.0, 0.0,
				Double.MIN_VALUE };
		tab1_panel10.setLayout(gbl_tab1_panel10);

		// 新公會索引
		JPanel tab1_panel11 = new JPanel(new BorderLayout());
		tab1_tbl11 = new JTable();
		tab1_tbl11.setToolTipText("連擊兩下以顯示明細");
		JScrollPane tab1_pane11 = new JScrollPane(tab1_tbl11);
		tab1_panel11.add(tab1_pane11, BorderLayout.CENTER);
		tab1_tbl11.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (arg0.getClickCount() == 2) {
					int row = tab1_tbl11.getSelectedRow();
					if (row != -1) {
						if (!(newDetailNewAssoIndexGroup
								.getNewDetailNewAssoIndexs().get(row)
								.getR_nbui_indu_desc().trim().compareTo("sum") == 0)) {
							newDetailController
									.showNewAssoIndexDetail(newDetailNewAssoIndexGroup
											.getNewDetailNewAssoIndexs().get(
													row));
						}
					}
				}
			}

		});

		// 基本資料 - Tab分頁
		tab1_btm_pane = new JTabbedPane();
		tab1_btm_pane.addTab(" 批註 ", tab1_panel1);
		tab1_btm_pane.addTab(" 弱體代碼 ", tab1_panel2);
		tab1_btm_pane.addTab(" 體檢資料 ", tab1_panel3);
		tab1_btm_pane.addTab(" 優體保單 ", tab1_panel4);
		tab1_btm_pane.addTab(" 公會索引 ", tab1_panel5);
		tab1_btm_pane.addTab(" 新公會索引 ", tab1_panel11);
		tab1_btm_pane.addTab(" 理賠記錄 ", tab1_panel6);
		tab1_btm_pane.addTab(" 契變受理 ", tab1_panel9);
		tab1_btm_pane.addTab(" 告知事項 ", tab1_panel7);
		tab1_btm_pane.addTab(" 核保訊息 ", tab1_panel8);
		// tab1_btm_pane.addTab(" 列管地址 ", tab1_panel10);

		// * cora
		JScrollPane scrollPane = new JScrollPane(tab1_panel10);
		tab1_btm_pane.addTab(" 列管地址 ", null, scrollPane, null);
		tab1_tbl10 = new JTable(tab1_data10, tab1_head10);
		JScrollPane tab1_pane10 = new JScrollPane(tab1_tbl10);
		GridBagConstraints gbc_tab1_pane10 = new GridBagConstraints();
		gbc_tab1_pane10.insets = new Insets(0, 0, 5, 0);
		gbc_tab1_pane10.fill = GridBagConstraints.BOTH;
		gbc_tab1_pane10.gridx = 0;
		gbc_tab1_pane10.gridy = 0;
		tab1_tbl10.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tab1_tbl10.getSelectionModel().addListSelectionListener(
				new ListSelectionListener() {

					@Override
					public void valueChanged(ListSelectionEvent arg0) {
						// System.out.println(arg0);
						if (!((DefaultListSelectionModel) arg0.getSource())
								.getValueIsAdjusting()) {
							int row = tab1_tbl10.getSelectedRow();
							if (row != -1) {
								newDetailIllegalAddrPoGroup.removeAll();
								newDetailController
										.showAddrPo(newDetailIllegalAddrGroup
												.getNewDetailIllegalAddrs()
												.get(row).getAddress());
								// newDetailController.showAddrPo("台北市信義區信義路五段150巷22弄4號2樓");
							}
						}
					}
				});
		tab1_panel10.add(tab1_pane10, gbc_tab1_pane10);

		tab1_tbl10_2 = new JTable();
		JScrollPane tab1_pane10_2 = new JScrollPane(tab1_tbl10_2);
		GridBagConstraints gbc_tab1_pane10_2 = new GridBagConstraints();
		gbc_tab1_pane10_2.insets = new Insets(0, 0, 5, 0);
		gbc_tab1_pane10_2.fill = GridBagConstraints.BOTH;
		gbc_tab1_pane10_2.gridx = 0;
		gbc_tab1_pane10_2.gridy = 1;
		tab1_tbl10_2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tab1_tbl10_2.getSelectionModel().addListSelectionListener(
				new ListSelectionListener() {

					@Override
					public void valueChanged(ListSelectionEvent arg0) {
						// System.out.println(arg0);
						if (!((DefaultListSelectionModel) arg0.getSource())
								.getValueIsAdjusting()) {
							int row = tab1_tbl10_2.getSelectedRow();
							if (row != -1) {
								newDetailIllegalAddrAgGroup.removeAll();
								newDetailController
										.showAddrAg(newDetailIllegalAddrPoGroup
												.getNewDetailIllegalAddrPos()
												.get(row).getpolicy_no());
							}
						}
					}
				});
		tab1_panel10.add(tab1_pane10_2, gbc_tab1_pane10_2);

		tab1_tbl10_3 = new JTable();
		JScrollPane tab1_pane10_3 = new JScrollPane(tab1_tbl10_3);
		GridBagConstraints gbc_tab1_pane10_3 = new GridBagConstraints();
		gbc_tab1_pane10_3.fill = GridBagConstraints.BOTH;
		gbc_tab1_pane10_3.gridx = 0;
		gbc_tab1_pane10_3.gridy = 2;
		tab1_panel10.add(tab1_pane10_3, gbc_tab1_pane10_3);
		// cora end

		slTab1.putConstraint(SpringLayout.NORTH, tab1_btm_pane, 0,
				SpringLayout.SOUTH, tab1_top_panel3);
		slTab1.putConstraint(SpringLayout.WEST, tab1_btm_pane, 0,
				SpringLayout.WEST, tab1_panel);
		slTab1.putConstraint(SpringLayout.EAST, tab1_btm_pane, 0,
				SpringLayout.EAST, tab1_panel);
		slTab1.putConstraint(SpringLayout.SOUTH, tab1_btm_pane, 0,
				SpringLayout.SOUTH, tab1_panel);
		tab1_panel.add(tab1_btm_pane);

		// 照會項目查詢
		JPanel tab2_panel = new JPanel(slTab2);
		JPanel tab2_panel_top = new JPanel(new GridLayout(0, 2));
		String[] tab2_head1 = { "要保日期", "照會對象", " " };
		tab2_vpane1 = new VerticalPane(tab2_head1, "", 70, 25);
		tab2_panel_top.add(tab2_vpane1);
		String[] tab2_head2 = { "核保人員", "照會應回覆日期", "列印取消通知書日期" };
		tab2_vpane2 = new VerticalPane(tab2_head2, "", 150, 25);
		tab2_panel_top.add(tab2_vpane2);

		slTab2.putConstraint(SpringLayout.NORTH, tab2_panel_top, 0,
				SpringLayout.NORTH, tab2_panel);
		slTab2.putConstraint(SpringLayout.WEST, tab2_panel_top, 0,
				SpringLayout.WEST, tab2_panel);
		slTab2.putConstraint(SpringLayout.EAST, tab2_panel_top, 0,
				SpringLayout.EAST, tab2_panel);
		slTab2.putConstraint(SpringLayout.SOUTH, tab2_panel_top, 77,
				SpringLayout.NORTH, tab2_panel);
		tab2_panel.add(tab2_panel_top);

		String[][] tab2_data3 = new String[10][4];
		String[] tab2_head3 = { "照會日期", "照會碼", "照會內容", "回覆日期" };
		tab2_tbl3 = new JTable(tab2_data3, tab2_head3);
		JScrollPane tab2_pane3 = new JScrollPane(tab2_tbl3);
		tab2_pane3.setViewportView(tab2_tbl3);

		ListSelectionModel tab2_tbl3_model = tab2_tbl3.getSelectionModel();
		tab2_tbl3_model.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				if (arg0.getValueIsAdjusting()) {
					int row = tab2_tbl3.getSelectedRow();
					if (row != -1) {
						tab2_vpane1.setValue(newDetailNoticeGroup
								.getNewDetailNotices().get(row).getColumn1());
						tab2_vpane2.setValue(newDetailNoticeGroup
								.getNewDetailNotices().get(row).getColumn2());
					}
				}
			}

		});
		tab2_tbl3.setSelectionModel(tab2_tbl3_model);

		slTab2.putConstraint(SpringLayout.NORTH, tab2_pane3, 0,
				SpringLayout.SOUTH, tab2_panel_top);
		slTab2.putConstraint(SpringLayout.WEST, tab2_pane3, 0,
				SpringLayout.WEST, tab2_panel);
		slTab2.putConstraint(SpringLayout.SOUTH, tab2_pane3, 0,
				SpringLayout.SOUTH, tab2_panel);
		slTab2.putConstraint(SpringLayout.EAST, tab2_pane3, 0,
				SpringLayout.EAST, tab2_panel);
		tab2_panel.add(tab2_pane3);

		// 體檢照會查詢
		JPanel tab3_panel = new JPanel();
		String[][] tab3_data = new String[15][3];
		String[] tab3_head = { "關係", "體檢項目", "類別" };
		JScrollPane tab3_pane = new JScrollPane(tab3_panel);
		tab3_tbl = new JTable(tab3_data, tab3_head);
		tab3_pane.setViewportView(tab3_tbl);

		// 簽收單查詢
		JPanel tab4_panel = new JPanel(slTab4);
		JPanel tab4_inner_panel = new JPanel(new GridLayout(0, 2));
		JScrollPane tab4_pane = new JScrollPane(tab4_panel);
		String[] tab4_head1 = { "保單狀態", "承保日期", "製單日期", "郵寄日期", "催繳日期", "扣款記錄",
				"扣款日期" };
		tab4_vpane1 = new VerticalPane(tab4_head1, "", 70, 25);
		tab4_inner_panel.add(tab4_vpane1);
		String[] tab4_head2 = { "簽收日期", "簽收輸入日期", "簽收輸入人員", "回執日期", "回執輸入日期",
				"回執輸入人員", "保單重製日期", "系統抽查日期" };
		tab4_vpane2 = new VerticalPane(tab4_head2, "", 100, 25);
		tab4_inner_panel.add(tab4_vpane2);
		slTab4.putConstraint(SpringLayout.NORTH, tab4_inner_panel, 0,
				SpringLayout.NORTH, tab4_panel);
		slTab4.putConstraint(SpringLayout.WEST, tab4_inner_panel, 0,
				SpringLayout.WEST, tab4_panel);
		slTab4.putConstraint(SpringLayout.SOUTH, tab4_inner_panel, 202,
				SpringLayout.NORTH, tab4_panel);
		slTab4.putConstraint(SpringLayout.EAST, tab4_inner_panel, 0,
				SpringLayout.EAST, tab4_panel);
		tab4_panel.add(tab4_inner_panel);

		//未承保原因
		JPanel tab5_panel = new JPanel();
		String[] tab5_head1 = { "未承保原因", "取 消 說 明" };
		tab5_panel.setLayout(new GridLayout(0, 1, 0, 0));
		tab5_vpane1 = new VerticalPane(tab5_head1, "", 100, 25);
		tab5_panel.add(tab5_vpane1);
		
		// Tab分頁
		main_tab_pane = new JTabbedPane();
		main_tab_pane.addTab("基本資料", tab1_panel);
		main_tab_pane.addTab("照會項目查詢", tab2_panel);
		main_tab_pane.addTab("體檢照會查詢", tab3_pane);
		main_tab_pane.addTab("簽收單查詢", tab4_pane);
		main_tab_pane.addTab("未承保原因",tab5_panel);
		JPanel rescindPanel;
		main_tab_pane.addTab("契約撤銷查詢", rescindPanel = new NewRescindJPanel());

		// 設定main_tab的indexMap
		tabIndexMap
				.put("基本資料", getComponentTabIndex(tab1_panel, main_tab_pane));
		tabIndexMap.put("照會項目查詢",
				getComponentTabIndex(tab2_panel, main_tab_pane));
		tabIndexMap.put("體檢照會查詢",
				getComponentTabIndex(tab3_pane, main_tab_pane));
		tabIndexMap
				.put("簽收單查詢", getComponentTabIndex(tab4_pane, main_tab_pane));
		tabIndexMap
				.put("未承保原因", getComponentTabIndex(tab5_panel, main_tab_pane));
		tabIndexMap.put("契約撤銷查詢",
				getComponentTabIndex(rescindPanel, main_tab_pane));

		// slMain.putConstraint(SpringLayout.NORTH, main_tab_pane, 0,
		// SpringLayout.NORTH, this);
		// slMain.putConstraint(SpringLayout.WEST, main_tab_pane, 0,
		// SpringLayout.WEST, this);
		// slMain.putConstraint(SpringLayout.SOUTH, main_tab_pane, 0,
		// SpringLayout.SOUTH, this);
		// slMain.putConstraint(SpringLayout.EAST, main_tab_pane, 0,
		// SpringLayout.EAST, this);
		add(main_tab_pane, BorderLayout.CENTER);
		
		initDataBindings();

		TableColumn headerCol;
		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		//被保險人tbl_mid欄位
		headerCol = tbl_mid.getColumnModel().getColumn(0); // 關係
		headerCol.setCellRenderer(centerRenderer);
		headerCol.setMaxWidth(60);
		tbl_mid.getColumnModel().getColumn(5).setPreferredWidth(20); // 關係
		tbl_mid.getColumnModel().getColumn(6).setPreferredWidth(20); // 關係
		tbl_mid.getColumnModel().getColumn(7).setPreferredWidth(20); // 關係
		
		//保障tbl_btm欄位
		headerCol = tbl_btm.getColumnModel().getColumn(0); // 關係
		headerCol.setCellRenderer(centerRenderer);
		headerCol.setMaxWidth(55);
		headerCol = tbl_btm.getColumnModel().getColumn(2); // 版數
		headerCol.setCellRenderer(centerRenderer);
		headerCol.setMaxWidth(55);
		headerCol = tbl_btm.getColumnModel().getColumn(3); // 社保
		headerCol.setCellRenderer(centerRenderer);
		headerCol.setMaxWidth(55);
		headerCol = tbl_btm.getColumnModel().getColumn(4); // 保額
		headerCol.setCellRenderer(rightRenderer);
		headerCol = tbl_btm.getColumnModel().getColumn(5); // 狀態
		headerCol.setCellRenderer(centerRenderer);
		headerCol.setMaxWidth(55);
		headerCol = tbl_btm.getColumnModel().getColumn(6); // 職級
		headerCol.setCellRenderer(centerRenderer);
		headerCol.setMaxWidth(55);
		headerCol = tbl_btm.getColumnModel().getColumn(7); // 年齡
		headerCol.setCellRenderer(centerRenderer);
		headerCol = tbl_btm.getColumnModel().getColumn(8); // 性別
		headerCol.setCellRenderer(centerRenderer);
		headerCol.setMaxWidth(55);
		headerCol = tbl_btm.getColumnModel().getColumn(9); // 年度
		headerCol.setCellRenderer(centerRenderer);
		headerCol.setMaxWidth(55);
		headerCol = tbl_btm.getColumnModel().getColumn(10); // 生效日
		headerCol.setCellRenderer(centerRenderer);
		headerCol.setMaxWidth(90);
		headerCol = tbl_btm.getColumnModel().getColumn(11); // 保費
		headerCol.setCellRenderer(rightRenderer);
		headerCol = tbl_btm.getColumnModel().getColumn(13); // 體位
		headerCol.setCellRenderer(centerRenderer);
		headerCol.setMaxWidth(55);
		headerCol = tbl_btm.getColumnModel().getColumn(14); // 定額
		headerCol.setCellRenderer(centerRenderer);
		headerCol = tbl_btm.getColumnModel().getColumn(15); // 比例
		headerCol.setCellRenderer(centerRenderer);
		headerCol.setMaxWidth(80);
		headerCol = tbl_btm.getColumnModel().getColumn(16); // 加費
		headerCol.setCellRenderer(centerRenderer);
		headerCol.setPreferredWidth(83);
		// 調整tbl_mid欄位(關係人資料)
		headerCol = tbl_mid.getColumnModel().getColumn(0); // 關係
		headerCol.setPreferredWidth(70);
		headerCol.setMaxWidth(70);
		headerCol = tbl_mid.getColumnModel().getColumn(1); // ID
		headerCol.setPreferredWidth(100);
		headerCol.setMaxWidth(100);
		headerCol = tbl_mid.getColumnModel().getColumn(2); // 姓名
		headerCol.setPreferredWidth(200);
		headerCol.setMaxWidth(200);
		headerCol = tbl_mid.getColumnModel().getColumn(3); // 出生日期
		headerCol.setPreferredWidth(110);
		headerCol.setMaxWidth(110);

		// 調整tab1_tbl1欄位(批註)
		headerCol = tab1_tbl1.getColumnModel().getColumn(0); // 關係
		headerCol.setPreferredWidth(100);
		headerCol.setMaxWidth(100);
		headerCol = tab1_tbl1.getColumnModel().getColumn(1); // 批註日期
		headerCol.setPreferredWidth(130);
		headerCol.setMaxWidth(130);
		headerCol = tab1_tbl1.getColumnModel().getColumn(2); // 取消日期
		headerCol.setPreferredWidth(130);
		headerCol.setMaxWidth(130);
		headerCol = tab1_tbl1.getColumnModel().getColumn(3); // 類別
		headerCol.setPreferredWidth(150);
		headerCol.setMaxWidth(150);

		// 調整tab1_tbl2欄位(弱體代碼)
		headerCol = tab1_tbl2.getColumnModel().getColumn(0); // 被保人
		headerCol.setPreferredWidth(150);
		headerCol.setMaxWidth(150);
		headerCol = tab1_tbl2.getColumnModel().getColumn(1); // 受理日期
		headerCol.setPreferredWidth(150);
		headerCol.setMaxWidth(150);
		headerCol = tab1_tbl2.getColumnModel().getColumn(2); // 受理號碼
		headerCol.setPreferredWidth(150);
		headerCol.setMaxWidth(150);
		headerCol = tab1_tbl2.getColumnModel().getColumn(4); // 保單號碼
		headerCol.setPreferredWidth(150);
		headerCol.setMaxWidth(150);

		// 調整tab1_tbl3欄位(體檢資料)
		headerCol = tab1_tbl3.getColumnModel().getColumn(0); // 被保人ID
		headerCol.setPreferredWidth(110);
		headerCol.setMaxWidth(110);
		headerCol = tab1_tbl3.getColumnModel().getColumn(1); // 體檢項目
		headerCol.setPreferredWidth(350);
		headerCol.setMaxWidth(350);
		headerCol = tab1_tbl3.getColumnModel().getColumn(2); // 體檢日期
		headerCol.setPreferredWidth(110);
		headerCol.setMaxWidth(110);

		// 調整tab1_tbl4欄位(優體保單)
		headerCol = tab1_tbl4.getColumnModel().getColumn(1); // 檢驗值
		headerCol.setPreferredWidth(130);
		headerCol.setMaxWidth(150);
		headerCol.setCellRenderer(rightRenderer);
		headerCol = tab1_tbl4.getColumnModel().getColumn(2); // 正常(Y/N)
		headerCol.setPreferredWidth(130);
		headerCol.setMaxWidth(150);
		headerCol.setCellRenderer(centerRenderer);
		headerCol = tab1_tbl4.getColumnModel().getColumn(3); // N/P
		headerCol.setPreferredWidth(100);
		headerCol.setMaxWidth(130);
		headerCol.setCellRenderer(centerRenderer);
//		headerCol = tab1_tbl4.getColumnModel().getColumn(4); // 身高
//		headerCol.setPreferredWidth(50);
//		headerCol.setMaxWidth(50);
//		headerCol = tab1_tbl4.getColumnModel().getColumn(5); // 體重
//		headerCol.setPreferredWidth(50);
//		headerCol.setMaxWidth(50);
//		headerCol = tab1_tbl4.getColumnModel().getColumn(6); // BMI
//		headerCol.setPreferredWidth(50);
//		headerCol.setMaxWidth(50);
//		headerCol = tab1_tbl4.getColumnModel().getColumn(7); // CHO/HDL ratio
//		headerCol.setPreferredWidth(130);
//		headerCol.setMaxWidth(130);
//		headerCol = tab1_tbl4.getColumnModel().getColumn(8); // 優體壽險等級
//		headerCol.setPreferredWidth(130);
//		headerCol.setMaxWidth(130);

		// 調整tab1_tbl5欄位(公會索引)
		headerCol = tab1_tbl5.getColumnModel().getColumn(0); // 類別
		headerCol.setCellRenderer(centerRenderer);
		headerCol.setPreferredWidth(45);
		headerCol.setMaxWidth(50);
		headerCol = tab1_tbl5.getColumnModel().getColumn(1); // 
		headerCol.setCellRenderer(centerRenderer);
//		headerCol = tab1_tbl5.getColumnModel().getColumn(3); // 保單號碼
//		headerCol.setPreferredWidth(100);
//		headerCol.setMaxWidth(100);
		headerCol = tab1_tbl5.getColumnModel().getColumn(3); // 保額
		headerCol.setCellRenderer(rightRenderer);
		headerCol = tab1_tbl5.getColumnModel().getColumn(4); // 通報表別
		headerCol.setPreferredWidth(120);
		headerCol.setMaxWidth(120);
		headerCol = tab1_tbl5.getColumnModel().getColumn(6); // 
		headerCol.setCellRenderer(centerRenderer);
		headerCol = tab1_tbl5.getColumnModel().getColumn(8); // 
		headerCol.setCellRenderer(centerRenderer);
		headerCol.setPreferredWidth(75);
		headerCol.setMaxWidth(120);
		headerCol = tab1_tbl5.getColumnModel().getColumn(9); // 
		headerCol.setCellRenderer(centerRenderer);
		headerCol.setPreferredWidth(75);
		headerCol.setMaxWidth(120);
		headerCol = tab1_tbl5.getColumnModel().getColumn(10); // 
		headerCol.setPreferredWidth(50);
		headerCol.setMaxWidth(150);
		headerCol = tab1_tbl5.getColumnModel().getColumn(11); //
		headerCol.setCellRenderer(centerRenderer);
		headerCol.setPreferredWidth(75);
		headerCol.setMaxWidth(120);

		// 調整tab1_tbl7欄位(告知事項)
		headerCol = tab1_tbl7.getColumnModel().getColumn(0); // 被保人
		headerCol.setPreferredWidth(130);
		headerCol.setMaxWidth(130);
		headerCol = tab1_tbl7.getColumnModel().getColumn(1); // 受理日期
		headerCol.setPreferredWidth(130);
		headerCol.setMaxWidth(130);
		headerCol = tab1_tbl7.getColumnModel().getColumn(2); // 保單號碼
		headerCol.setPreferredWidth(150);
		headerCol.setMaxWidth(150);

		// 調整tab1_tbl8欄位(核保訊息)
		headerCol = tab1_tbl8.getColumnModel().getColumn(0); // 訊息代碼
		headerCol.setPreferredWidth(150);
		headerCol.setMaxWidth(150);

		// 調整tab1_tbl9欄位(契變受理)
		headerCol = tab1_tbl9.getColumnModel().getColumn(0); // 保單號碼
		headerCol.setPreferredWidth(160);
		headerCol.setMaxWidth(160);
		headerCol = tab1_tbl9.getColumnModel().getColumn(1); // 受理號碼
		headerCol.setPreferredWidth(160);
		headerCol.setMaxWidth(160);
		headerCol = tab1_tbl9.getColumnModel().getColumn(2); // 受理日期
		headerCol.setPreferredWidth(160);
		headerCol.setMaxWidth(160);

		// 調整tab1_tbl10欄位(列管地址)
		headerCol = tab1_tbl10.getColumnModel().getColumn(0); // 地址種類
		headerCol.setPreferredWidth(150);
		headerCol.setMaxWidth(150);
		headerCol = tab1_tbl10.getColumnModel().getColumn(1); // 檢核分類代碼
		headerCol.setPreferredWidth(150);
		headerCol.setMaxWidth(150);

		// 調整tab1_panel11欄位(新公會索引)
		headerCol = tab1_tbl11.getColumnModel().getColumn(1); // 業別
		headerCol.setPreferredWidth(80);
		headerCol.setMaxWidth(80);
		headerCol = tab1_tbl11.getColumnModel().getColumn(2); // 分類
		headerCol.setPreferredWidth(80);
		headerCol.setMaxWidth(80);
		headerCol = tab1_tbl11.getColumnModel().getColumn(3); // 險種類別
		headerCol.setPreferredWidth(100);
		headerCol.setMaxWidth(100);

		// 調整tab2_tbl3欄位(照會項目查詢)
		headerCol = tab2_tbl3.getColumnModel().getColumn(0); // 照會日期
		headerCol.setPreferredWidth(90);
		headerCol.setMaxWidth(90);
		headerCol = tab2_tbl3.getColumnModel().getColumn(1); // 照會碼
		headerCol.setPreferredWidth(80);
		headerCol.setMaxWidth(80);
		headerCol = tab2_tbl3.getColumnModel().getColumn(3); // 回覆日期
		headerCol.setPreferredWidth(90);
		headerCol.setMaxWidth(90);

		// 調整tab3_tbl欄位(體檢照會查詢)
		headerCol = tab3_tbl.getColumnModel().getColumn(0); // 照會日期
		headerCol.setPreferredWidth(80);
		headerCol.setMaxWidth(80);
		headerCol = tab3_tbl.getColumnModel().getColumn(2); // 類別
		headerCol.setPreferredWidth(100);
		headerCol.setMaxWidth(100);
	}

	/**
	 * 設定tabPane全設為可選取
	 * 
	 * @author epf
	 */
	public void setTabPaneEnable() {
		for (int i = 0; i < tab1_btm_pane.getComponentCount(); i++) {
			tab1_btm_pane.setEnabledAt(i, true);
		}
		for (int i = 0; i < main_tab_pane.getComponentCount(); i++) {
			main_tab_pane.setEnabledAt(i, true);
		}
	}

	/**
	 * 設定tabPane無資料不可選取 使用table及beans的對應如果table的binding對象有改就改這裡
	 * 最上層的tab用tabIndexMap控制
	 * 
	 * @author epf
	 */
	public void setTabPaneDisable() {
		
		chkAuthority(); //確認使用者權限
		
		if (newDetailCommCmntGroup.getNewDetailCommCmntCount() == 0) {
			tab1_btm_pane.setEnabledAt(
					getComponentTabIndex(tab1_tbl1, tab1_btm_pane), false);
		}
		if (poExam00Group.getPoExam00Count() == 0) {
			tab1_btm_pane.setEnabledAt(
					getComponentTabIndex(tab1_tbl2, tab1_btm_pane), false);
		}
		if (newDetailExamInfoGroup.getNewDetailExamInfoCount() == 0) {
			tab1_btm_pane.setEnabledAt(
					getComponentTabIndex(tab1_tbl3, tab1_btm_pane), false);
		}
		if (newDetailPreferredExamGroup.getNewDetailPreferredExamCount() == 0) {
			tab1_btm_pane.setEnabledAt(
					getComponentTabIndex(tab1_tbl4, tab1_btm_pane), false);
		}
		if (newDetailOldAssoIndexGroup.getNewDetailOldAssoIndexCount() == 0) {
			tab1_btm_pane.setEnabledAt(
					getComponentTabIndex(tab1_tbl5, tab1_btm_pane), false);
		}
		if (newDetailClaimHistoryGroup.getNewDetailClaimHistoryCount() == 0) {
			tab1_btm_pane.setEnabledAt(
					getComponentTabIndex(tab1_pane6, tab1_btm_pane), false);
		}
		if (newDetailPoStatementGroup.getNewDetailPoStatementCount() == 0) {
			tab1_btm_pane.setEnabledAt(
					getComponentTabIndex(tab1_tbl7, tab1_btm_pane), false);
		}
		if (newDetailPosChangeGroup.getNewDetailPosChangeCount() == 0) {
			tab1_btm_pane.setEnabledAt(
					getComponentTabIndex(tab1_tbl9, tab1_btm_pane), false);
		}
		if (newDetailUwErrCodeGroup.getNewDetailUwErrCodeCount() == 0) {
			tab1_btm_pane.setEnabledAt(
					getComponentTabIndex(tab1_tbl8, tab1_btm_pane), false);
		}
		if (newDetailIllegalAddrGroup.getNewDetailIllegalAddrCount() == 0) {
			tab1_btm_pane.setEnabledAt(
					getComponentTabIndex(tab1_tbl10, tab1_btm_pane), false);
		}

		if (newDetailExamNoticeGroup.getNewDetailExamNoticeCount() == 0) {
			main_tab_pane.setEnabledAt(tabIndexMap.get("體檢照會查詢"), false);
		}
		if (newDetailNewAssoIndexGroup.getNewDetailNewAssoIndexCount() == 0) {
			tab1_btm_pane.setEnabledAt(
					getComponentTabIndex(tab1_tbl11, tab1_btm_pane), false);
		}
		if (newDetailNoticeGroup.getNewDetailNoticeCount() == 0) {
			main_tab_pane.setEnabledAt(tabIndexMap.get("照會項目查詢"), false);
		}
		if (newRescind01List.size() == 0) {
			main_tab_pane.setEnabledAt(tabIndexMap.get("契約撤銷查詢"), false);
		}
        if (Integer.parseInt(newDetailCommGroup.getNewDetailComms().get(0).getPo_sts_code().substring(0, 2))< 31 || 
        	Integer.parseInt(newDetailCommGroup.getNewDetailComms().get(0).getPo_sts_code().substring(0, 2))> 33){
        	main_tab_pane.setEnabledAt(tabIndexMap.get("未承保原因"), false);
		}
        
		// 將tab設定在最前面可選取的
		// 如果都沒有就設定至第一頁籤
		main_tab_pane.setSelectedIndex(0);
		tab1_btm_pane.setSelectedIndex(0);

		for (int i = 0; i < tab1_btm_pane.getComponentCount(); i++) {
			if (tab1_btm_pane.isEnabledAt(i)) {
				tab1_btm_pane.setSelectedIndex(i);
				break;
			}
		}

	}
	
	/**
	 * 檢查USER是否有權限使用某些tab
	 * @author fyyang
	 */
	private void chkAuthority(){
		//舊公會索引
        tab1_btm_pane.setEnabledAt(
        		getComponentTabIndex(tab1_tbl5, tab1_btm_pane), SelectionTreeModel.getTabAuthority(program_id,"1A"));
        //新公會索引
		tab1_btm_pane.setEnabledAt(
				getComponentTabIndex(tab1_tbl11, tab1_btm_pane), SelectionTreeModel.getTabAuthority(program_id,"1A"));
	}
	//
	/**
	 * 取得JTable或其它控制項在JTabbedPane的index
	 * 
	 * @author epf
	 * @param component
	 *            tab中的Component,tab中的任一Component即可,會自動往上尋找
	 * @param tabbedPane
	 *            要取得index的JTabbedPane
	 * @return index component在tabbedPane中的index
	 */
	public int getComponentTabIndex(Component component, JTabbedPane tabbedPane) {
		Component tmp; // 上一層Component
		while (true) {
			tmp = component.getParent();
			if (tmp instanceof JTabbedPane) {
				break;
			} else if (tmp instanceof NewDetailJPanel) // 到達最上層表示沒找到
				return -1;
			else
				component = tmp;
		}
		for (int i = 0; i < tabbedPane.getComponentCount(); i++) {
			if (tabbedPane.getComponent(i) == component) {
				return i;
			}
		}
		return -1;
	}

	public void setController(NewDetailController controller) {
		newDetailController = controller;
	}

	/**
	 * 設定理賠記錄的panel
	 * 
	 * @author epf
	 * @param panel
	 *            要設定的JPanel
	 */
	public void setClaimHistoryJPanel(JPanel panel) {
		panel.setPreferredSize(new Dimension(400, 700));
		tab1_pane6.setViewportView(panel);
	}

	/**
	 * 設定契約撤銷查詢panel
	 * 
	 * @author epf
	 * @param panel
	 *            要設定的JPanel
	 */
	public void setNewRescindJPanel(JPanel panel) {
		main_tab_pane.setComponentAt(tabIndexMap.get("契約撤銷查詢"), panel);
	}

	public void addNewDetailComm(NewDetailComm newDetailComm) {
		newDetailCommGroup.addNewDetailComm(newDetailComm);
		vpane_top1.setValue(newDetailComm.getColumn1());
		vpane_top2.setValue(newDetailComm.getColumn2());
		vpane_top3.setValue(newDetailComm.getColumn3());
		vpane_top4.setValue(newDetailComm.getColumn4());
	}

	public void clearNewDetailComm() {
		newDetailCommGroup.removeAll();
		vpane_top1.setValue(new String[5]);
		vpane_top2.setValue(new String[5]);
		vpane_top3.setValue(new String[5]);
		vpane_top4.setValue(new String[5]);
	}

	public void addNewDetailCommInsured(
			NewDetailCommInsured newDetailCommInsured) {
		newDetailCommInsuredGroup.addNewDetailCommInsured(newDetailCommInsured);
		if (newDetailCommInsured.getHome_addr().trim().compareTo("") != 0) {
			// fieldAddr.setText(newDetailCommInsured.getHome_addr());
			tab1_top_panel2.setBorder(new TitledBorder(null, "被保險人資料/主被保險人地址："
					+ newDetailCommInsured.getHome_addr(),
					TitledBorder.LEADING, TitledBorder.TOP, null, null));
		}else
		{
			tab1_top_panel2.setBorder(new TitledBorder(null, "被保險人資料",
					TitledBorder.LEADING, TitledBorder.TOP, null, null));
		}	
		
	}

	public void clearNewDetailCommInsured() {
		newDetailCommInsuredGroup.removeAll();
	}

	public void addPoPlan(PoPlan poPlan) {
		poPlanGroup.addPoPlan(poPlan);
	}

	public void clearPoPlan() {
		poPlanGroup.removeAll();
	}

	public void addNewDetailCommCmnt(NewDetailCommCmnt cmnt) {
		newDetailCommCmntGroup.addNewDetailCommCmnt(cmnt);
	}

	public void clearNewDetailCommCmnt() {
		newDetailCommCmntGroup.removeAll();
	}

	public void addPoExam00(PoExam00 poExam) {
		poExam00Group.addPoExam00(poExam);
	}

	public void clearPoExam00() {
		poExam00Group.removeAll();
	}

	public void addNewDetailExamInfo(NewDetailExamInfo examInfo) {
		newDetailExamInfoGroup.addNewDetailExamInfo(examInfo);
	}

	public void clearNewDetailExamInfo() {
		newDetailExamInfoGroup.removeAll();
	}

	public void addNewDetailPreferredExam(NewDetailPreferredExam pExam) {
		newDetailPreferredExamGroup.addNewDetailPreferredExam(pExam);
		txtHight.setText(pExam.getHeight());
		txtWeight.setText(pExam.getWeight());
		txtBMI.setText(pExam.getBmi());
		txtCHO.setText(pExam.getCho_hdl_ratio());
		txtExamInd.setText(pExam.getPreferred_Exam_Ind());
	}

	public void clearNewDetailPreferredExam() {
		newDetailPreferredExamGroup.removeAll();
		txtHight.setText("");
		txtWeight.setText("");
		txtBMI.setText("");
		txtCHO.setText("");
		txtExamInd.setText("");
	}

	public void addNewDetailOldAssoIndex(
			NewDetailOldAssoIndex newDetailOldAssoIndex) {
		newDetailOldAssoIndexGroup
				.addNewDetailOldAssoIndex(newDetailOldAssoIndex);
	}

	public void clearNewDetailOldAssoIndex() {
		newDetailOldAssoIndexGroup.removeAll();
	}

	public void addNewDetailClaimHistory(
			NewDetailClaimHistory newDetailClaimHistory) {
		newDetailClaimHistoryGroup
				.addNewDetailClaimHistory(newDetailClaimHistory);
	}

	public void clearNewDetailClaimHistory() {
		newDetailClaimHistoryGroup.removeAll();
	}

	public void addNewDetailPosChange(NewDetailPosChange newDetailPosChange) {
		newDetailPosChangeGroup.addNewDetailPosChange(newDetailPosChange);
	}

	public void clearNewDetailPosChange() {
		newDetailPosChangeGroup.removeAll();
	}

	public void addNewDetailPoStatement(
			NewDetailPoStatement newDetailPoStatement) {
		newDetailPoStatementGroup.addNewDetailPoStatement(newDetailPoStatement);
	}

	public void clearNewDetailPoStatement() {
		newDetailPoStatementGroup.removeAll();
	}

	public void addNewDetailUwErrCode(NewDetailUwErrCode newDetailUwErrCode) {
		newDetailUwErrCodeGroup.addNewDetailUwErrCode(newDetailUwErrCode);
	}

	public void clearNewDetailUwErrCode() {
		newDetailUwErrCodeGroup.removeAll();
	}

	public void addNewDetailIllegalAddr(
			NewDetailIllegalAddr newDetailIllegalAddr) {
		newDetailIllegalAddrGroup.addNewDetailIllegalAddr(newDetailIllegalAddr);
	}

	public void clearNewDetailIllegalAddr() {
		newDetailIllegalAddrGroup.removeAll();
	}

	public void addNewDetailIllegalAddrPo(
			NewDetailIllegalAddrPo newDetailIllegalAddrPo) {
		newDetailIllegalAddrPoGroup
				.addNewDetailIllegalAddrPo(newDetailIllegalAddrPo);
	}

	public void clearNewDetailIllegalAddrPo() {
		newDetailIllegalAddrPoGroup.removeAll();
	}

	public void addNewDetailIllegalAddrAg(
			NewDetailIllegalAddrAg newDetailIllegalAddrAg) {
		newDetailIllegalAddrAgGroup
				.addNewDetailIllegalAddrAg(newDetailIllegalAddrAg);
	}

	public void clearNewDetailIllegalAddrAg() {
		newDetailIllegalAddrAgGroup.removeAll();
	}

	public void addNewDetailExamNotice(NewDetailExamNotice newDetailExamNotice) {
		newDetailExamNoticeGroup.addNewDetailExamNotice(newDetailExamNotice);
	}

	public void clearNewDetailExamNotice() {
		newDetailExamNoticeGroup.removeAll();
	}

	public void addNewDetailDeny(NewDetailDeny newDetailDeny) {
		String[] tab5_value = {newDetailDeny.getNbdl_reason()+" "+newDetailDeny.getNbdl_reason_c(),
				newDetailDeny.getNbdl_cc_reason()+" "+newDetailDeny.getNbdl_cc_reason_c()};
		tab5_vpane1.setValue(tab5_value);
	}

	public void clearNewDetailDeny() {
		tab5_vpane1.setValue(new String[2]);
	}
	
	public void addNewDetailSignPaper(NewDetailSignPaper newDetailSignPaper) {
		newDetailSignPaperGroup.addNewDetailSignPaper(newDetailSignPaper);
		tab4_vpane1.setValue(newDetailSignPaper.getColumn1());
		tab4_vpane2.setValue(newDetailSignPaper.getColumn2());
	}

	public void clearNewDetailSignPaper() {
		newDetailSignPaperGroup.removeAll();
		tab4_vpane1.setValue(new String[7]);
		tab4_vpane2.setValue(new String[8]);
	}

	public void addNewDetailNewAssoIndex(
			NewDetailNewAssoIndex newDetailNewAssoIndex) {
		newDetailNewAssoIndexGroup
				.addNewDetailNewAssoIndex(newDetailNewAssoIndex);
	}

	public void clearNewDetailNewAssoIndex() {
		newDetailNewAssoIndexGroup.removeAll();
	}

	public void addNewDetailNotice(NewDetailNotice newDetailNotice) {
		newDetailNoticeGroup.addNewDetailNotice(newDetailNotice);
		tab2_vpane1.setValue(newDetailNotice.getColumn1());
		tab2_vpane2.setValue(newDetailNotice.getColumn2());
	}

	public void clearNewDetailNotice() {
		newDetailNoticeGroup.removeAll();
		tab2_vpane1.setValue(new String[3]);
		tab2_vpane2.setValue(new String[3]);
	}

	public void addNewRescind01(NewRescind01 newRescind01) {
		newRescind01List.add(newRescind01);
	}

	public void clearNewRescind01() {
		newRescind01List.clear();
	}

	public void setUA21tooltip(String open) {
		if ( open.equals("1"))
		    tab1_tbl8.setToolTipText("連擊兩下以顯示UA21舊保單職級");
		else
			tab1_tbl8.setToolTipText("");
	}
	/**
	 * 清除binding資料
	 * 
	 * @author epf
	 */
	public void clearAll() {
		fieldAddr.setText("");
		clearNewDetailComm();
		clearNewDetailCommInsured();
		clearPoPlan();
		clearNewDetailCommCmnt();
		clearPoExam00();
		clearNewDetailExamInfo();
		clearNewDetailPreferredExam();
		clearNewDetailClaimHistory();
		clearNewDetailOldAssoIndex();
		clearNewDetailPosChange();
		clearNewDetailPoStatement();
		clearNewDetailUwErrCode();
		clearNewDetailIllegalAddr();
		clearNewDetailExamNotice();
		clearNewDetailSignPaper();
		clearNewDetailNewAssoIndex();
		clearNewDetailNotice();
		clearNewDetailDeny();
		clearNewRescind01();
		newDetailIllegalAddrPoGroup.removeAll();
		newDetailIllegalAddrAgGroup.removeAll();
	}

	public void nullAll() {
		newDetailCommGroup = null;
		newDetailCommInsuredGroup = null;
		poPlanGroup = null;
		newDetailCommCmntGroup = null;
		poExam00Group = null;
		newDetailExamInfoGroup = null;
		newDetailPreferredExamGroup = null;
		newDetailOldAssoIndexGroup = null;
		newDetailClaimHistoryGroup = null;
		newDetailPosChangeGroup = null;
		newDetailPoStatementGroup = null;
		newDetailUwErrCodeGroup = null;
		newDetailIllegalAddrGroup = null;
		newDetailIllegalAddrPoGroup = null;
		newDetailIllegalAddrAgGroup = null;
		newDetailExamNoticeGroup = null;
		newDetailSignPaperGroup = null;
		newDetailNewAssoIndexGroup = null;
		newDetailNoticeGroup = null;
		newRescind01List = null;
		newDetailIllegalAddrPoGroup = null;
		newDetailIllegalAddrAgGroup = null;
		tbl_mid = null;
		tbl_btm = null;
		tab1_tbl1 = null;
		tab1_tbl2 = null;
		tab1_tbl3 = null;
		tab1_tbl4 = null;
		tab1_tbl5 = null;
		tab1_tbl6 = null;
		tab1_tbl9 = null;
		tab1_tbl7 = null;
		tab1_tbl8 = null;
		tab1_tbl10 = null;
		tab1_tbl11 = null;
		tab3_tbl = null;
		tab2_tbl3 = null;
	}
	
	public void setDefaultRow()
	{
//		System.out.println("setDefault");
		if (tab1_tbl10.getRowCount() > 0)
		{	
		ListSelectionModel selectionModel =    tab1_tbl10.getSelectionModel(); 
		selectionModel.setSelectionInterval(0, 0);
//		getNewData();
		}
	}
	protected void initDataBindings() {
		BeanProperty<NewDetailCommInsuredGroup, List<NewDetailCommInsured>> newDetailCommInsuredGroupBeanProperty = BeanProperty.create("newDetailCommInsureds");
		JTableBinding<NewDetailCommInsured, NewDetailCommInsuredGroup, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, newDetailCommInsuredGroup, newDetailCommInsuredGroupBeanProperty, tbl_mid);
		//
		BeanProperty<NewDetailCommInsured, String> newDetailCommInsuredBeanProperty = BeanProperty.create("client_ident");
		jTableBinding.addColumnBinding(newDetailCommInsuredBeanProperty).setColumnName("\u95DC\u4FC2").setEditable(false);
		//
		BeanProperty<NewDetailCommInsured, String> newDetailCommInsuredBeanProperty_1 = BeanProperty.create("i1_id");
		jTableBinding.addColumnBinding(newDetailCommInsuredBeanProperty_1).setColumnName("ID").setEditable(false);
		//
		BeanProperty<NewDetailCommInsured, String> newDetailCommInsuredBeanProperty_2 = BeanProperty.create("i1_name");
		jTableBinding.addColumnBinding(newDetailCommInsuredBeanProperty_2).setColumnName("\u59D3\u540D").setEditable(false);
		//
		BeanProperty<NewDetailCommInsured, String> newDetailCommInsuredBeanProperty_3 = BeanProperty.create("i1_birth");
		jTableBinding.addColumnBinding(newDetailCommInsuredBeanProperty_3).setColumnName("\u51FA\u751F\u65E5\u671F").setEditable(false);
		//
		BeanProperty<NewDetailCommInsured, String> newDetailCommInsuredBeanProperty_4 = BeanProperty.create("i1_occu");
		jTableBinding.addColumnBinding(newDetailCommInsuredBeanProperty_4).setColumnName("\u8077\u696D\u4EE3\u78BC/\u8077\u7D1A").setEditable(false);
		//
		BeanProperty<NewDetailCommInsured, String> newDetailCommInsuredBeanProperty_5 = BeanProperty.create("height");
		jTableBinding.addColumnBinding(newDetailCommInsuredBeanProperty_5).setColumnName("\u8EAB\u9AD8");
		//
		BeanProperty<NewDetailCommInsured, String> newDetailCommInsuredBeanProperty_6 = BeanProperty.create("weight");
		jTableBinding.addColumnBinding(newDetailCommInsuredBeanProperty_6).setColumnName("\u9AD4\u91CD");
		//
		BeanProperty<NewDetailCommInsured, String> newDetailCommInsuredBeanProperty_7 = BeanProperty.create("sign_ptn_card");
		jTableBinding.addColumnBinding(newDetailCommInsuredBeanProperty_7).setColumnName("\u7C3D\u6A23\u5361");
		//
		jTableBinding.bind();
		//
		BeanProperty<PoPlanGroup, List<PoPlan>> poPlanGroupBeanProperty = BeanProperty.create("poPlans");
		JTableBinding<PoPlan, PoPlanGroup, JTable> jTableBinding_1 = SwingBindings.createJTableBinding(UpdateStrategy.READ, poPlanGroup, poPlanGroupBeanProperty, tbl_btm);
		//
		BeanProperty<PoPlan, String> poPlanBeanProperty = BeanProperty.create("client_ident");
		jTableBinding_1.addColumnBinding(poPlanBeanProperty).setColumnName("\u95DC\u4FC2").setEditable(false);
		//
		BeanProperty<PoPlan, String> poPlanBeanProperty_1 = BeanProperty.create("plan_code");
		jTableBinding_1.addColumnBinding(poPlanBeanProperty_1).setColumnName("\u96AA\u7A2E").setEditable(false);
		//
		BeanProperty<PoPlan, String> poPlanBeanProperty_2 = BeanProperty.create("rate_scale");
		jTableBinding_1.addColumnBinding(poPlanBeanProperty_2).setColumnName("\u7248\u6578").setEditable(false);
		//
		BeanProperty<PoPlan, String> poPlanBeanProperty_3 = BeanProperty.create("rate_insu");
		jTableBinding_1.addColumnBinding(poPlanBeanProperty_3).setColumnName("\u793E\u4FDD").setEditable(false);
		//
		BeanProperty<PoPlan, String> poPlanBeanProperty_4 = BeanProperty.create("face_amt");
		jTableBinding_1.addColumnBinding(poPlanBeanProperty_4).setColumnName("\u4FDD\u984D").setEditable(false);
		//
		BeanProperty<PoPlan, String> poPlanBeanProperty_5 = BeanProperty.create("co_sts_desc");
		jTableBinding_1.addColumnBinding(poPlanBeanProperty_5).setColumnName("\u72C0\u614B").setEditable(false);
		//
		BeanProperty<PoPlan, String> poPlanBeanProperty_6 = BeanProperty.create("rate_occu");
		jTableBinding_1.addColumnBinding(poPlanBeanProperty_6).setColumnName("\u8077\u7D1A").setEditable(false);
		//
		BeanProperty<PoPlan, String> poPlanBeanProperty_7 = BeanProperty.create("rate_age");
		jTableBinding_1.addColumnBinding(poPlanBeanProperty_7).setColumnName("\u4FDD\u96AA\u5E74\u9F61").setEditable(false);
		//
		BeanProperty<PoPlan, String> poPlanBeanProperty_8 = BeanProperty.create("rate_sex");
		jTableBinding_1.addColumnBinding(poPlanBeanProperty_8).setColumnName("\u6027\u5225").setEditable(false);
		//
		BeanProperty<PoPlan, String> poPlanBeanProperty_9 = BeanProperty.create("dur");
		jTableBinding_1.addColumnBinding(poPlanBeanProperty_9).setColumnName("\u5E74\u5EA6").setEditable(false);
		//
		BeanProperty<PoPlan, String> poPlanBeanProperty_10 = BeanProperty.create("co_issue_date");
		jTableBinding_1.addColumnBinding(poPlanBeanProperty_10).setColumnName("\u751F\u6548\u65E5\u671F").setEditable(false);
		//
		BeanProperty<PoPlan, String> poPlanBeanProperty_11 = BeanProperty.create("co_mode_prem");
		jTableBinding_1.addColumnBinding(poPlanBeanProperty_11).setColumnName("\u6BCF\u671F\u4FDD\u8CBB").setEditable(false);
		//
		BeanProperty<PoPlan, String> poPlanBeanProperty_12 = BeanProperty.create("co_chg_date");
		jTableBinding_1.addColumnBinding(poPlanBeanProperty_12).setColumnName("\u8B8A\u66F4\u751F\u6548\u65E5").setEditable(false);
		//
		BeanProperty<PoPlan, String> poPlanBeanProperty_13 = BeanProperty.create("rate_medi");
		jTableBinding_1.addColumnBinding(poPlanBeanProperty_13).setColumnName("\u9AD4\u4F4D").setEditable(false);
		//
		BeanProperty<PoPlan, String> poPlanBeanProperty_14 = BeanProperty.create("flat_rating_amt");
		jTableBinding_1.addColumnBinding(poPlanBeanProperty_14).setColumnName("\u5B9A\u984D\u52A0\u8CBB").setEditable(false);
		//
		BeanProperty<PoPlan, String> poPlanBeanProperty_15 = BeanProperty.create("multi_rating_1");
		jTableBinding_1.addColumnBinding(poPlanBeanProperty_15).setColumnName("\u6BD4\u4F8B\u52A0\u8CBB").setEditable(false);
		//
		BeanProperty<PoPlan, String> poPlanBeanProperty_16 = BeanProperty.create("flat_rating_year");
		jTableBinding_1.addColumnBinding(poPlanBeanProperty_16).setColumnName("\u52A0\u8CBB\u5E74\u671F").setEditable(false);
		//
		jTableBinding_1.setEditable(false);
		jTableBinding_1.bind();
		//
		BeanProperty<NewDetailCommCmntGroup, List<NewDetailCommCmnt>> newDetailCommCmntGroupBeanProperty = BeanProperty.create("newDetailCommCmnts");
		JTableBinding<NewDetailCommCmnt, NewDetailCommCmntGroup, JTable> jTableBinding_2 = SwingBindings.createJTableBinding(UpdateStrategy.READ, newDetailCommCmntGroup, newDetailCommCmntGroupBeanProperty, tab1_tbl1);
		//
		BeanProperty<NewDetailCommCmnt, String> newDetailCommCmntBeanProperty = BeanProperty.create("r_client_ident");
		jTableBinding_2.addColumnBinding(newDetailCommCmntBeanProperty).setColumnName("\u95DC\u4FC2").setEditable(false);
		//
		BeanProperty<NewDetailCommCmnt, String> newDetailCommCmntBeanProperty_1 = BeanProperty.create("r_process_date");
		jTableBinding_2.addColumnBinding(newDetailCommCmntBeanProperty_1).setColumnName("\u6279\u8A3B\u65E5\u671F").setEditable(false);
		//
		BeanProperty<NewDetailCommCmnt, String> newDetailCommCmntBeanProperty_2 = BeanProperty.create("r_cancel_date");
		jTableBinding_2.addColumnBinding(newDetailCommCmntBeanProperty_2).setColumnName("\u53D6\u6D88\u65E5\u671F").setEditable(false);
		//
		BeanProperty<NewDetailCommCmnt, String> newDetailCommCmntBeanProperty_3 = BeanProperty.create("r_cmnt_class");
		jTableBinding_2.addColumnBinding(newDetailCommCmntBeanProperty_3).setColumnName("\u985E\u5225").setEditable(false);
		//
		BeanProperty<NewDetailCommCmnt, String> newDetailCommCmntBeanProperty_4 = BeanProperty.create("r_comments");
		jTableBinding_2.addColumnBinding(newDetailCommCmntBeanProperty_4).setColumnName("\u6279\u8A3B\u5167\u5BB9").setEditable(false);
		//
		BeanProperty<NewDetailCommCmnt, String> newDetailCommCmntBeanProperty_5 = BeanProperty.create("r_cmnt_year");
		jTableBinding_2.addColumnBinding(newDetailCommCmntBeanProperty_5).setColumnName("\u6279\u8A3B\u5E74\u9650").setEditable(false);
		//
		jTableBinding_2.bind();
		//
		BeanProperty<PoExam00Group, List<PoExam00>> poExam00GroupBeanProperty = BeanProperty.create("poExam00");
		JTableBinding<PoExam00, PoExam00Group, JTable> jTableBinding_3 = SwingBindings.createJTableBinding(UpdateStrategy.READ, poExam00Group, poExam00GroupBeanProperty, tab1_tbl2);
		//
		BeanProperty<PoExam00, String> poExam00BeanProperty = BeanProperty.create("m_client_id");
		jTableBinding_3.addColumnBinding(poExam00BeanProperty).setColumnName("\u88AB\u4FDD\u4EBA").setEditable(false);
		//
		BeanProperty<PoExam00, String> poExam00BeanProperty_1 = BeanProperty.create("m_receive_date");
		jTableBinding_3.addColumnBinding(poExam00BeanProperty_1).setColumnName("\u53D7\u7406\u65E5\u671F").setEditable(false);
		//
		BeanProperty<PoExam00, String> poExam00BeanProperty_2 = BeanProperty.create("m_receive_no");
		jTableBinding_3.addColumnBinding(poExam00BeanProperty_2).setColumnName("\u53D7\u7406\u865F\u78BC").setEditable(false);
		//
		BeanProperty<PoExam00, String> poExam00BeanProperty_3 = BeanProperty.create("m_statement");
		jTableBinding_3.addColumnBinding(poExam00BeanProperty_3).setColumnName("\u5F31\u9AD4").setEditable(false);
		//
		BeanProperty<PoExam00, String> poExam00BeanProperty_4 = BeanProperty.create("m_policy_no");
		jTableBinding_3.addColumnBinding(poExam00BeanProperty_4).setColumnName("\u4FDD\u55AE\u865F\u78BC");
		//
		jTableBinding_3.setEditable(false);
		jTableBinding_3.bind();
		//
		BeanProperty<NewDetailExamInfoGroup, List<NewDetailExamInfo>> newDetailExamInfoGroupBeanProperty = BeanProperty.create("newDetailExamInfos");
		JTableBinding<NewDetailExamInfo, NewDetailExamInfoGroup, JTable> jTableBinding_4 = SwingBindings.createJTableBinding(UpdateStrategy.READ, newDetailExamInfoGroup, newDetailExamInfoGroupBeanProperty, tab1_tbl3);
		//
		BeanProperty<NewDetailExamInfo, String> newDetailExamInfoBeanProperty = BeanProperty.create("insured_id");
		jTableBinding_4.addColumnBinding(newDetailExamInfoBeanProperty).setColumnName("\u88AB\u4FDD\u4EBAID");
		//
		ELProperty<NewDetailExamInfo, Object> newDetailExamInfoEvalutionProperty = ELProperty.create("${exam_item_code} ${exam_item_desc}");
		jTableBinding_4.addColumnBinding(newDetailExamInfoEvalutionProperty).setColumnName("\u9AD4\u6AA2\u9805\u76EE").setEditable(false);
		//
		BeanProperty<NewDetailExamInfo, String> newDetailExamInfoBeanProperty_1 = BeanProperty.create("exam_date");
		jTableBinding_4.addColumnBinding(newDetailExamInfoBeanProperty_1).setColumnName("\u9AD4\u6AA2\u65E5\u671F").setEditable(false);
		//
		ELProperty<NewDetailExamInfo, Object> newDetailExamInfoEvalutionProperty_1 = ELProperty.create("${exam_result_ind} ${exam_result}");
		jTableBinding_4.addColumnBinding(newDetailExamInfoEvalutionProperty_1).setColumnName("\u9AD4\u6AA2\u7D50\u679C").setEditable(false);
		//
		BeanProperty<NewDetailExamInfo, String> newDetailExamInfoBeanProperty_2 = BeanProperty.create("hospital_name");
		jTableBinding_4.addColumnBinding(newDetailExamInfoBeanProperty_2).setColumnName("\u9AD4\u6AA2\u91AB\u9662").setEditable(false);
		//
		BeanProperty<NewDetailExamInfo, String> newDetailExamInfoBeanProperty_3 = BeanProperty.create("policy_no");
		jTableBinding_4.addColumnBinding(newDetailExamInfoBeanProperty_3).setColumnName("\u4FDD\u55AE\u865F\u78BC");
		//
		jTableBinding_4.bind();
		//
		BeanProperty<NewDetailPreferredExamGroup, List<NewDetailPreferredExam>> newDetailPreferredExamGroupBeanProperty = BeanProperty.create("newDetailPreferredExams");
		JTableBinding<NewDetailPreferredExam, NewDetailPreferredExamGroup, JTable> jTableBinding_5 = SwingBindings.createJTableBinding(UpdateStrategy.READ, newDetailPreferredExamGroup, newDetailPreferredExamGroupBeanProperty, tab1_tbl4);
		//
		BeanProperty<NewDetailPreferredExam, String> newDetailPreferredExamBeanProperty = BeanProperty.create("exam_item_code_desc");
		jTableBinding_5.addColumnBinding(newDetailPreferredExamBeanProperty).setColumnName("\u9AD4\u6AA2\u9805\u76EE").setEditable(false);
		//
		BeanProperty<NewDetailPreferredExam, String> newDetailPreferredExamBeanProperty_1 = BeanProperty.create("exam_value");
		jTableBinding_5.addColumnBinding(newDetailPreferredExamBeanProperty_1).setColumnName("\u6AA2\u9A57\u503C").setEditable(false);
		//
		BeanProperty<NewDetailPreferredExam, String> newDetailPreferredExamBeanProperty_2 = BeanProperty.create("exam_value_rank");
		jTableBinding_5.addColumnBinding(newDetailPreferredExamBeanProperty_2).setColumnName("\u6B63\u5E38(Y/N)").setEditable(false);
		//
		BeanProperty<NewDetailPreferredExam, String> newDetailPreferredExamBeanProperty_3 = BeanProperty.create("exam_respond_value");
		jTableBinding_5.addColumnBinding(newDetailPreferredExamBeanProperty_3).setColumnName("N/P").setEditable(false);
		//
		jTableBinding_5.bind();
		//
		BeanProperty<NewDetailOldAssoIndexGroup, List<NewDetailOldAssoIndex>> newDetailOldAssoIndexGroupBeanProperty = BeanProperty.create("newDetailOldAssoIndexs");
		JTableBinding<NewDetailOldAssoIndex, NewDetailOldAssoIndexGroup, JTable> jTableBinding_6 = SwingBindings.createJTableBinding(UpdateStrategy.READ, newDetailOldAssoIndexGroup, newDetailOldAssoIndexGroupBeanProperty, tab1_tbl5);
		//
		BeanProperty<NewDetailOldAssoIndex, String> newDetailOldAssoIndexBeanProperty = BeanProperty.create("nbui_industry_desc");
		jTableBinding_6.addColumnBinding(newDetailOldAssoIndexBeanProperty).setColumnName("\u985E\u5225").setEditable(false);
		//
		BeanProperty<NewDetailOldAssoIndex, String> newDetailOldAssoIndexBeanProperty_1 = BeanProperty.create("client_id");
		jTableBinding_6.addColumnBinding(newDetailOldAssoIndexBeanProperty_1).setColumnName("\u88AB\u4FDD\u4EBAID").setEditable(false);
		//
		BeanProperty<NewDetailOldAssoIndex, String> newDetailOldAssoIndexBeanProperty_2 = BeanProperty.create("nbui_name");
		jTableBinding_6.addColumnBinding(newDetailOldAssoIndexBeanProperty_2).setColumnName("\u59D3\u540D").setEditable(false);
		//
		BeanProperty<NewDetailOldAssoIndex, String> newDetailOldAssoIndexBeanProperty_3 = BeanProperty.create("face_amt");
		jTableBinding_6.addColumnBinding(newDetailOldAssoIndexBeanProperty_3).setColumnName("\u4FDD\u984D").setEditable(false);
		//
		BeanProperty<NewDetailOldAssoIndex, String> newDetailOldAssoIndexBeanProperty_4 = BeanProperty.create("nbui_type_desc");
		jTableBinding_6.addColumnBinding(newDetailOldAssoIndexBeanProperty_4).setColumnName("\u901A\u5831\u8868\u5225").setEditable(false);
		//
		BeanProperty<NewDetailOldAssoIndex, String> newDetailOldAssoIndexBeanProperty_5 = BeanProperty.create("nbui_company_name");
		jTableBinding_6.addColumnBinding(newDetailOldAssoIndexBeanProperty_5).setColumnName("\u516C\u53F8").setEditable(false);
		//
		BeanProperty<NewDetailOldAssoIndex, String> newDetailOldAssoIndexBeanProperty_6 = BeanProperty.create("effect_date");
		jTableBinding_6.addColumnBinding(newDetailOldAssoIndexBeanProperty_6).setColumnName("\u751F\u6548\u65E5\u671F").setEditable(false);
		//
		BeanProperty<NewDetailOldAssoIndex, String> newDetailOldAssoIndexBeanProperty_7 = BeanProperty.create("nbui_pno");
		jTableBinding_6.addColumnBinding(newDetailOldAssoIndexBeanProperty_7).setColumnName("\u4FDD\u55AE\u865F\u78BC").setEditable(false);
		//
		BeanProperty<NewDetailOldAssoIndex, String> newDetailOldAssoIndexBeanProperty_8 = BeanProperty.create("process_date");
		jTableBinding_6.addColumnBinding(newDetailOldAssoIndexBeanProperty_8).setColumnName("\u7570\u52D5\u65E5\u671F");
		//
		BeanProperty<NewDetailOldAssoIndex, String> newDetailOldAssoIndexBeanProperty_9 = BeanProperty.create("expired_date");
		jTableBinding_6.addColumnBinding(newDetailOldAssoIndexBeanProperty_9).setColumnName("\u6EFF\u671F\u65E5\u671F");
		//
		BeanProperty<NewDetailOldAssoIndex, String> newDetailOldAssoIndexBeanProperty_10 = BeanProperty.create("r_clnt_type_desc");
		jTableBinding_6.addColumnBinding(newDetailOldAssoIndexBeanProperty_10).setColumnName("\u88AB\u4FDD\u96AA\u4EBA\u985E\u5225");
		//
		BeanProperty<NewDetailOldAssoIndex, String> newDetailOldAssoIndexBeanProperty_11 = BeanProperty.create("app_apply_date");
		jTableBinding_6.addColumnBinding(newDetailOldAssoIndexBeanProperty_11).setColumnName("\u8981\u4FDD\u65E5\u671F");
		//
		jTableBinding_6.setEditable(false);
		jTableBinding_6.bind();
		//
		BeanProperty<NewDetailClaimHistoryGroup, List<NewDetailClaimHistory>> newDetailClaimHistoryGroupBeanProperty = BeanProperty.create("newDetailClaimHistorys");
		JTableBinding<NewDetailClaimHistory, NewDetailClaimHistoryGroup, JTable> jTableBinding_7 = SwingBindings.createJTableBinding(UpdateStrategy.READ, newDetailClaimHistoryGroup, newDetailClaimHistoryGroupBeanProperty, tab1_tbl6);
		//
		BeanProperty<NewDetailClaimHistory, String> newDetailClaimHistoryBeanProperty = BeanProperty.create("r_event_name");
		jTableBinding_7.addColumnBinding(newDetailClaimHistoryBeanProperty).setColumnName("\u4E8B\u6545\u4EBA\u59D3\u540D").setEditable(false);
		//
		BeanProperty<NewDetailClaimHistory, String> newDetailClaimHistoryBeanProperty_1 = BeanProperty.create("r_claim_seq");
		jTableBinding_7.addColumnBinding(newDetailClaimHistoryBeanProperty_1).setColumnName("\u5E8F\u865F").setEditable(false);
		//
		BeanProperty<NewDetailClaimHistory, String> newDetailClaimHistoryBeanProperty_2 = BeanProperty.create("r_claim_year");
		jTableBinding_7.addColumnBinding(newDetailClaimHistoryBeanProperty_2).setColumnName("\u5E74\u5EA6").setEditable(false);
		//
		BeanProperty<NewDetailClaimHistory, String> newDetailClaimHistoryBeanProperty_3 = BeanProperty.create("r_claim_desc");
		jTableBinding_7.addColumnBinding(newDetailClaimHistoryBeanProperty_3).setColumnName("\u7406\u8CE0\u578B\u614B").setEditable(false);
		//
		BeanProperty<NewDetailClaimHistory, String> newDetailClaimHistoryBeanProperty_4 = BeanProperty.create("r_cl_event_desc");
		jTableBinding_7.addColumnBinding(newDetailClaimHistoryBeanProperty_4).setColumnName("\u4E8B\u6545\u578B\u614B").setEditable(false);
		//
		BeanProperty<NewDetailClaimHistory, String> newDetailClaimHistoryBeanProperty_5 = BeanProperty.create("r_cl_event_desc_1");
		jTableBinding_7.addColumnBinding(newDetailClaimHistoryBeanProperty_5).setColumnName("\u4E8B\u6545\u539F\u56E0").setEditable(false);
		//
		BeanProperty<NewDetailClaimHistory, String> newDetailClaimHistoryBeanProperty_6 = BeanProperty.create("r_approve_date");
		jTableBinding_7.addColumnBinding(newDetailClaimHistoryBeanProperty_6).setColumnName("\u7D50\u6848\u65E5\u671F").setEditable(false);
		//
		BeanProperty<NewDetailClaimHistory, String> newDetailClaimHistoryBeanProperty_7 = BeanProperty.create("r_cl_examine_desc");
		jTableBinding_7.addColumnBinding(newDetailClaimHistoryBeanProperty_7).setColumnName("\u7D50\u6848\u578B\u614B").setEditable(false);
		//
		jTableBinding_7.bind();
		//
		BeanProperty<NewDetailPosChangeGroup, List<NewDetailPosChange>> newDetailPosChangeGroupBeanProperty = BeanProperty.create("newDetailPosChanges");
		JTableBinding<NewDetailPosChange, NewDetailPosChangeGroup, JTable> jTableBinding_8 = SwingBindings.createJTableBinding(UpdateStrategy.READ, newDetailPosChangeGroup, newDetailPosChangeGroupBeanProperty, tab1_tbl9);
		//
		BeanProperty<NewDetailPosChange, String> newDetailPosChangeBeanProperty = BeanProperty.create("policy_no");
		jTableBinding_8.addColumnBinding(newDetailPosChangeBeanProperty).setColumnName("\u4FDD\u55AE\u865F\u78BC");
		//
		BeanProperty<NewDetailPosChange, String> newDetailPosChangeBeanProperty_1 = BeanProperty.create("receive_no");
		jTableBinding_8.addColumnBinding(newDetailPosChangeBeanProperty_1).setColumnName("\u53D7\u7406\u865F\u78BC").setEditable(false);
		//
		BeanProperty<NewDetailPosChange, String> newDetailPosChangeBeanProperty_2 = BeanProperty.create("receive_date");
		jTableBinding_8.addColumnBinding(newDetailPosChangeBeanProperty_2).setColumnName("\u53D7\u7406\u65E5\u671F").setEditable(false);
		//
		BeanProperty<NewDetailPosChange, String> newDetailPosChangeBeanProperty_3 = BeanProperty.create("po_chg_sts_code");
		jTableBinding_8.addColumnBinding(newDetailPosChangeBeanProperty_3).setColumnName("\u53D7\u7406\u72C0\u6CC1").setEditable(false);
		//
		jTableBinding_8.bind();
		//
		BeanProperty<NewDetailPoStatementGroup, List<NewDetailPoStatement>> newDetailPoStatementGroupBeanProperty = BeanProperty.create("newDetailPoStatements");
		JTableBinding<NewDetailPoStatement, NewDetailPoStatementGroup, JTable> jTableBinding_9 = SwingBindings.createJTableBinding(UpdateStrategy.READ, newDetailPoStatementGroup, newDetailPoStatementGroupBeanProperty, tab1_tbl7);
		//
		BeanProperty<NewDetailPoStatement, String> newDetailPoStatementBeanProperty = BeanProperty.create("r_client_id");
		jTableBinding_9.addColumnBinding(newDetailPoStatementBeanProperty).setColumnName("\u88AB\u4FDD\u4EBA").setEditable(false);
		//
		BeanProperty<NewDetailPoStatement, String> newDetailPoStatementBeanProperty_1 = BeanProperty.create("r_receive_date");
		jTableBinding_9.addColumnBinding(newDetailPoStatementBeanProperty_1).setColumnName("\u53D7\u7406\u65E5\u671F").setEditable(false);
		//
		BeanProperty<NewDetailPoStatement, String> newDetailPoStatementBeanProperty_2 = BeanProperty.create("r_policy_no");
		jTableBinding_9.addColumnBinding(newDetailPoStatementBeanProperty_2).setColumnName("\u4FDD\u55AE\u865F\u78BC").setEditable(false);
		//
		BeanProperty<NewDetailPoStatement, String> newDetailPoStatementBeanProperty_3 = BeanProperty.create("r_statement");
		jTableBinding_9.addColumnBinding(newDetailPoStatementBeanProperty_3).setColumnName("\u544A\u77E5").setEditable(false);
		//
		jTableBinding_9.bind();
		//
		BeanProperty<NewDetailUwErrCodeGroup, List<NewDetailUwErrCode>> newDetailUwErrCodeGroupBeanProperty = BeanProperty.create("newDetailUwErrCodes");
		JTableBinding<NewDetailUwErrCode, NewDetailUwErrCodeGroup, JTable> jTableBinding_10 = SwingBindings.createJTableBinding(UpdateStrategy.READ, newDetailUwErrCodeGroup, newDetailUwErrCodeGroupBeanProperty, tab1_tbl8);
		//
		BeanProperty<NewDetailUwErrCode, String> newDetailUwErrCodeBeanProperty = BeanProperty.create("nb_err_code");
		jTableBinding_10.addColumnBinding(newDetailUwErrCodeBeanProperty).setColumnName("\u8A0A\u606F\u4EE3\u78BC").setEditable(false);
		//
		BeanProperty<NewDetailUwErrCode, String> newDetailUwErrCodeBeanProperty_1 = BeanProperty.create("nb_err_desc");
		jTableBinding_10.addColumnBinding(newDetailUwErrCodeBeanProperty_1).setColumnName("\u6838\u4FDD\u8A0A\u606F").setEditable(false);
		//
		jTableBinding_10.bind();
		//
		BeanProperty<NewDetailIllegalAddrGroup, List<NewDetailIllegalAddr>> newDetailIllegalAddrGroupBeanProperty = BeanProperty.create("newDetailIllegalAddrs");
		JTableBinding<NewDetailIllegalAddr, NewDetailIllegalAddrGroup, JTable> jTableBinding_11 = SwingBindings.createJTableBinding(UpdateStrategy.READ, newDetailIllegalAddrGroup, newDetailIllegalAddrGroupBeanProperty, tab1_tbl10);
		//
		BeanProperty<NewDetailIllegalAddr, String> newDetailIllegalAddrBeanProperty = BeanProperty.create("ind_desc");
		jTableBinding_11.addColumnBinding(newDetailIllegalAddrBeanProperty).setColumnName("\u5730\u5740\u7A2E\u985E").setEditable(false);
		//
		BeanProperty<NewDetailIllegalAddr, String> newDetailIllegalAddrBeanProperty_1 = BeanProperty.create("addr_type");
		jTableBinding_11.addColumnBinding(newDetailIllegalAddrBeanProperty_1).setColumnName("\u6AA2\u6838\u5206\u985E\u4EE3\u78BC").setEditable(false);
		//
		BeanProperty<NewDetailIllegalAddr, String> newDetailIllegalAddrBeanProperty_2 = BeanProperty.create("address");
		jTableBinding_11.addColumnBinding(newDetailIllegalAddrBeanProperty_2).setColumnName("\u5730\u5740");
		//
		jTableBinding_11.bind();
		//
		BeanProperty<NewDetailExamNoticeGroup, List<NewDetailExamNotice>> newDetailExamNoticeGroupBeanProperty = BeanProperty.create("newDetailExamNotices");
		JTableBinding<NewDetailExamNotice, NewDetailExamNoticeGroup, JTable> jTableBinding_12 = SwingBindings.createJTableBinding(UpdateStrategy.READ, newDetailExamNoticeGroup, newDetailExamNoticeGroupBeanProperty, tab3_tbl);
		//
		BeanProperty<NewDetailExamNotice, String> newDetailExamNoticeBeanProperty = BeanProperty.create("client_ident");
		jTableBinding_12.addColumnBinding(newDetailExamNoticeBeanProperty).setColumnName("\u95DC\u4FC2").setEditable(false);
		//
		BeanProperty<NewDetailExamNotice, String> newDetailExamNoticeBeanProperty_1 = BeanProperty.create("exam_item_desc");
		jTableBinding_12.addColumnBinding(newDetailExamNoticeBeanProperty_1).setColumnName("\u9AD4\u6AA2\u9805\u76EE").setEditable(false);
		//
		BeanProperty<NewDetailExamNotice, String> newDetailExamNoticeBeanProperty_2 = BeanProperty.create("exam_required_ind");
		jTableBinding_12.addColumnBinding(newDetailExamNoticeBeanProperty_2).setColumnName("\u985E\u5225").setEditable(false);
		//
		jTableBinding_12.bind();
		//
		BeanProperty<NewDetailNewAssoIndexGroup, List<NewDetailNewAssoIndex>> newDetailNewAssoIndexGroupBeanProperty = BeanProperty.create("newDetailNewAssoIndexs");
		JTableBinding<NewDetailNewAssoIndex, NewDetailNewAssoIndexGroup, JTable> jTableBinding_13 = SwingBindings.createJTableBinding(UpdateStrategy.READ, newDetailNewAssoIndexGroup, newDetailNewAssoIndexGroupBeanProperty, tab1_tbl11);
		//
		BeanProperty<NewDetailNewAssoIndex, String> newDetailNewAssoIndexBeanProperty = BeanProperty.create("r_insured_id");
		jTableBinding_13.addColumnBinding(newDetailNewAssoIndexBeanProperty).setColumnName("\u88AB\u4FDD\u4EBAID").setEditable(false);
		//
		BeanProperty<NewDetailNewAssoIndex, String> newDetailNewAssoIndexBeanProperty_1 = BeanProperty.create("r_nbui_indu_desc");
		jTableBinding_13.addColumnBinding(newDetailNewAssoIndexBeanProperty_1).setColumnName("\u696D\u5225").setEditable(false);
		//
		BeanProperty<NewDetailNewAssoIndex, String> newDetailNewAssoIndexBeanProperty_2 = BeanProperty.create("r_policy_type_desc");
		jTableBinding_13.addColumnBinding(newDetailNewAssoIndexBeanProperty_2).setColumnName("\u5206\u985E").setEditable(false);
		//
		BeanProperty<NewDetailNewAssoIndex, String> newDetailNewAssoIndexBeanProperty_3 = BeanProperty.create("r_un_ins_type_desc");
		jTableBinding_13.addColumnBinding(newDetailNewAssoIndexBeanProperty_3).setColumnName("\u96AA\u7A2E\u985E\u5225").setEditable(false);
		//
		BeanProperty<NewDetailNewAssoIndex, String> newDetailNewAssoIndexBeanProperty_4 = BeanProperty.create("r_un_plan_type_desc");
		jTableBinding_13.addColumnBinding(newDetailNewAssoIndexBeanProperty_4).setColumnName("\u96AA\u7A2E").setEditable(false);
		//
		BeanProperty<NewDetailNewAssoIndex, String> newDetailNewAssoIndexBeanProperty_5 = BeanProperty.create("r_un_rpt_item_desc");
		jTableBinding_13.addColumnBinding(newDetailNewAssoIndexBeanProperty_5).setColumnName("\u7D66\u4ED8\u9805\u76EE").setEditable(false);
		//
		BeanProperty<NewDetailNewAssoIndex, String> newDetailNewAssoIndexBeanProperty_6 = BeanProperty.create("r_un_rpt_value");
		jTableBinding_13.addColumnBinding(newDetailNewAssoIndexBeanProperty_6).setColumnName("\u4FDD\u984D").setEditable(false);
		//
		BeanProperty<NewDetailNewAssoIndex, String> newDetailNewAssoIndexBeanProperty_7 = BeanProperty.create("r_company_name");
		jTableBinding_13.addColumnBinding(newDetailNewAssoIndexBeanProperty_7).setColumnName("\u516C\u53F8").setEditable(false);
		//
		jTableBinding_13.setEditable(false);
		jTableBinding_13.bind();
		//
		BeanProperty<NewDetailNoticeGroup, List<NewDetailNotice>> newDetailNoticeGroupBeanProperty = BeanProperty.create("newDetailNotices");
		JTableBinding<NewDetailNotice, NewDetailNoticeGroup, JTable> jTableBinding_14 = SwingBindings.createJTableBinding(UpdateStrategy.READ, newDetailNoticeGroup, newDetailNoticeGroupBeanProperty, tab2_tbl3);
		//
		BeanProperty<NewDetailNotice, String> newDetailNoticeBeanProperty = BeanProperty.create("r_notify_date");
		jTableBinding_14.addColumnBinding(newDetailNoticeBeanProperty).setColumnName("\u7167\u6703\u65E5\u671F").setEditable(false);
		//
		BeanProperty<NewDetailNotice, String> newDetailNoticeBeanProperty_1 = BeanProperty.create("r_nb_notify_code");
		jTableBinding_14.addColumnBinding(newDetailNoticeBeanProperty_1).setColumnName("\u7167\u6703\u78BC").setEditable(false);
		//
		BeanProperty<NewDetailNotice, String> newDetailNoticeBeanProperty_2 = BeanProperty.create("r_nb_notify_desc");
		jTableBinding_14.addColumnBinding(newDetailNoticeBeanProperty_2).setColumnName("\u7167\u6703\u5167\u5BB9").setEditable(false);
		//
		BeanProperty<NewDetailNotice, String> newDetailNoticeBeanProperty_3 = BeanProperty.create("r_act_return_date");
		jTableBinding_14.addColumnBinding(newDetailNoticeBeanProperty_3).setColumnName("\u56DE\u8986\u65E5\u671F").setEditable(false);
		//
		jTableBinding_14.setEditable(false);
		jTableBinding_14.bind();
		//
		BeanProperty<NewDetailIllegalAddrPoGroup, List<NewDetailIllegalAddrPo>> newDetailIllegalAddrPoGroupBeanProperty = BeanProperty.create("newDetailIllegalAddrPos");
		JTableBinding<NewDetailIllegalAddrPo, NewDetailIllegalAddrPoGroup, JTable> jTableBinding15 = SwingBindings.createJTableBinding(UpdateStrategy.READ, newDetailIllegalAddrPoGroup, newDetailIllegalAddrPoGroupBeanProperty, tab1_tbl10_2);
		//
		ELProperty<NewDetailIllegalAddrPo, Object> newDetailIllegalAddrPoEvalutionProperty = ELProperty.create("${pool_type} ${pool_desc}");
		jTableBinding15.addColumnBinding(newDetailIllegalAddrPoEvalutionProperty).setColumnName("\u5206\u985E\u4EE3\u78BC");
		//
		BeanProperty<NewDetailIllegalAddrPo, String> newDetailIllegalAddrPoBeanProperty = BeanProperty.create("client_id");
		jTableBinding15.addColumnBinding(newDetailIllegalAddrPoBeanProperty).setColumnName("\u8B58\u5225\u78BC");
		//
		BeanProperty<NewDetailIllegalAddrPo, String> newDetailIllegalAddrPoBeanProperty_1 = BeanProperty.create("addr_ind");
		jTableBinding15.addColumnBinding(newDetailIllegalAddrPoBeanProperty_1).setColumnName("\u5730\u5740\u6307\u793A");
		//
		BeanProperty<NewDetailIllegalAddrPo, String> newDetailIllegalAddrPoBeanProperty_2 = BeanProperty.create("owner_name");
		jTableBinding15.addColumnBinding(newDetailIllegalAddrPoBeanProperty_2).setColumnName("\u59D3\u540D");
		//
		BeanProperty<NewDetailIllegalAddrPo, String> newDetailIllegalAddrPoBeanProperty_3 = BeanProperty.create("policy_no");
		jTableBinding15.addColumnBinding(newDetailIllegalAddrPoBeanProperty_3).setColumnName("\u4FDD\u55AE\u865F\u78BC");
		//
		jTableBinding15.bind();
		//
		BeanProperty<NewDetailIllegalAddrAgGroup, List<NewDetailIllegalAddrAg>> newDetailIllegalAddrAgGroupBeanProperty = BeanProperty.create("newDetailIllegalAddrAgs");
		JTableBinding<NewDetailIllegalAddrAg, NewDetailIllegalAddrAgGroup, JTable> jTableBinding_16 = SwingBindings.createJTableBinding(UpdateStrategy.READ, newDetailIllegalAddrAgGroup, newDetailIllegalAddrAgGroupBeanProperty, tab1_tbl10_3);
		//
		BeanProperty<NewDetailIllegalAddrAg, String> newDetailIllegalAddrAgBeanProperty = BeanProperty.create("client_ident");
		jTableBinding_16.addColumnBinding(newDetailIllegalAddrAgBeanProperty).setColumnName("\u95DC\u4FC2\u4EBA");
		//
		BeanProperty<NewDetailIllegalAddrAg, String> newDetailIllegalAddrAgBeanProperty_1 = BeanProperty.create("client_id");
		jTableBinding_16.addColumnBinding(newDetailIllegalAddrAgBeanProperty_1).setColumnName("\u696D\u52D9\u54E1\u4EE3\u78BC");
		//
		BeanProperty<NewDetailIllegalAddrAg, String> newDetailIllegalAddrAgBeanProperty_2 = BeanProperty.create("name");
		jTableBinding_16.addColumnBinding(newDetailIllegalAddrAgBeanProperty_2).setColumnName("\u59D3\u540D");
		//
		BeanProperty<NewDetailIllegalAddrAg, String> newDetailIllegalAddrAgBeanProperty_3 = BeanProperty.create("dept_code");
		jTableBinding_16.addColumnBinding(newDetailIllegalAddrAgBeanProperty_3).setColumnName("\u901A\u8A0A\u8655");
		//
		BeanProperty<NewDetailIllegalAddrAg, String> newDetailIllegalAddrAgBeanProperty_4 = BeanProperty.create("level_title");
		jTableBinding_16.addColumnBinding(newDetailIllegalAddrAgBeanProperty_4).setColumnName("\u8077\u7D1A");
		//
		jTableBinding_16.bind();
	}
}
