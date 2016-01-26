package query.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.List;

import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;

import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.ELProperty;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

import query.controller.ClaimHistoryController;
import query.controller.MultiLineCellRenderer;
import query.model.ClaimHistory.ClaimHistory01;
import query.model.ClaimHistory.ClaimHistory01Group;
import query.model.ClaimHistory.ClaimHistory02;
import query.model.ClaimHistory.ClaimHistory02event;
import query.model.ClaimHistory.ClaimHistory02eventGroup;
import query.model.ClaimHistory.ClaimHistory03;
import query.model.ClaimHistory.ClaimHistory03Group;
import query.model.ClaimHistory.ClaimHistory04;
import query.model.ClaimHistory.ClaimHistory04Group;
import query.model.ClaimHistory.ClaimHistory05;
import query.model.ClaimHistory.ClaimHistory05Group;
import query.model.ClaimHistory.ClaimHistory06;
import query.model.ClaimHistory.ClaimHistory06Group;
import query.model.ClaimHistory.ClaimHistory07;
import query.model.ClaimHistory.ClaimHistory07Group;
import query.model.ClaimHistory.ClaimHistory08;
import query.model.ClaimHistory.ClaimHistory08Group;
import query.model.ClaimHistory.ClaimHistory09;
import query.model.ClaimHistory.ClaimHistory09Group;
import query.model.ClaimHistory.ClaimHistory10;
import query.model.ClaimHistory.ClaimHistory10Group;
import query.model.ClaimHistory.ClaimHistory11;

import query.model.ClaimHistory.ClaimHistory12;
import query.model.ClaimHistory.ClaimHistory12Group;
import query.model.ClaimHistory.ClaimHistoryQuery;
import database.connection.DBConnection;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import org.jdesktop.beansbinding.ObjectProperty;

/**
 * 
 * @author fyyang
 * 
 */
public class ClaimHistoryJPanel extends JPanel {

	/**
	 * 1000000045453
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTable table_3; // 受益人
	private JTable table_4;
	private JTable table_9; // 事故原因
	private VerticalPane verticalPane1, verticalPane2, verticalPane3,
			verticalPane4, verticalPane5, verticalPane6, verticalPane7;

	private ClaimHistory01Group history01Group = new ClaimHistory01Group();
	private ClaimHistory02 history02 = new ClaimHistory02();
	private ClaimHistory02eventGroup history02eventGroup = new ClaimHistory02eventGroup();
	private ClaimHistory02eventGroup history02sickGroup = new ClaimHistory02eventGroup();
	private ClaimHistory03Group history03Group = new ClaimHistory03Group();
	private ClaimHistory04Group history04Group = new ClaimHistory04Group();
	private ClaimHistory05Group history05Group = new ClaimHistory05Group();
	private ClaimHistory06Group history06Group = new ClaimHistory06Group();
	private ClaimHistory07Group history07Group = new ClaimHistory07Group(); // 項目明細
	private ClaimHistory08Group history08Group = new ClaimHistory08Group(); // 就診醫院
	private ClaimHistory09Group history09Group = new ClaimHistory09Group(); // 安寧緩和醫療
	private ClaimHistory10Group history10Group = new ClaimHistory10Group(); // 理賠註記

	private ClaimHistory11 history11 = new ClaimHistory11(); // 地檢署相驗明細
																// 101/04/18 new
																// by jnd115
	private ClaimHistory12Group history12Group = new ClaimHistory12Group(); // 就診明細
	private ClaimHistoryController historyController;

	private JTextField textField;

	private boolean isExtended = false; // 判斷是否已展開(下區TABBEDPANE)
	private JPanel panel_1;
	private JPanel panel_0;
	private JPanel panel;
	private JScrollPane scrollPane_5;
	private JTable table_5;
	private JScrollPane scrollPane_6;
	private JScrollPane scrollPane_7;
	private JTable table_6; // 就診醫院
	private JTable table_7; // 安寧緩和醫療
	private JScrollPane scrollPane_8;
	private JTable table_8;
	private JPanel panel_7;
	private JTextField textField_1; // 101/03/26 new by jnd115
	// private JScrollPane scrollPane_9; 101/03/26 mark by jnd115
	// private JTable table_9; 101/03/26 mark by jnd115
	private String[] headers = { "事故人ID", "事故人姓名", "保單關係人", "生效日期", "受理號碼",
			"櫃檯受理", "受理日期", "文件齊全日", "事故日期", "事故地區", "理賠型態", "副本" };
	private String[] headers2 = { "送件業務員姓名", "營業單位", "事故型態", "支票委託書", "差額證明",
			"審核員", "受理地區", "覆核員", "覆核地區", "理賠狀態", "結案型態", "覆核型態" };
	private String[] headers3 = { "受益人", "結案日期", "保險種類", "理賠給付", "紅利給付",
			"溢繳保費", "退整期保費", "未到期保費", "扣保單貸款本息", "扣保單墊繳本息", "扣應繳保費", "代扣其他款項" };
	private String[] headers4 = { "扣貸款本息", "扣欠繳保費", "解約金", "給付小計", "延息起算日",
			"延息結算日", "延滯利息", "扣所得稅", "扣健保補充保費", "給付金額", "幣別" };

	private String[] headersG1 = { "事故人ID", "事故人姓名", "學號", "生效日期", "受理號碼",
			"櫃檯受理", "受理日期", "文件齊全日", "事故日期", "事故地區", "理賠型態", "副本" };
	private String[] headersG2 = { "送件業務員姓名", "營業單位", "事故型態", "支票委託書", "差額證明",
			"審核員", "受理地區", "覆核員", "覆核地區", "理賠狀態", "結案型態", "覆核型態" };
	private String[] headersG3 = { "受益人", "結案日期", "給付小計", "代扣其他款項", "延滯息起算日",
			"延滯息結算日", "延滯利息", "扣所得稅", "扣健保補充保費", "給付金額", "", "" };
	private String[] headersG4 = { "", "", "", "", "", "", "", "", "", "", "",
			"" };

	private String[] headersT1 = { "事故人ID", "事故人姓名", "生效日期", "受理號碼", "受理日期",
			"文件齊全日", "事故日期", "事故地區", "理賠型態", "副本", "送件業務員", "營業單位" };
	private String[] headersT2 = { "支票委託書", "審核員", "受理地區", "覆核員", "覆核地區",
			"理賠狀態", "結案型態", "覆核型態", "受益人", "結案日期", "給付小計", "代扣其他款項" };
	private String[] headersT3 = { "延滯息起算日", "延滯息結算日", "延滯利息", "扣所得稅", "未到期保費",
			"扣健保補充保費", "給付金額", "", "", "", "", "" };
	private String[] headersT4 = { "", "", "", "", "", "", "", "", "", "", "",
			"" };
	private JScrollPane scrollPane_9;
	private JTextField txtInsured;
	private JTextField txtPolicy;
	private JLabel label_1;
	private JLabel lblid_1;
	private JLabel label_2;
	private JTextField txtClaimYear;
	private JButton btnNewButton_1;
	private JScrollPane scrollPane_10;
	private JTable table_10;

	private String PoNo, Insured;
	private JScrollPane scrollPane_11;
	private JTable table_11;

	// ,headersG1,headersG2,headersG3,headersG4,
	// headersG1,headersG2,headersG3,headersG4;

	/**
	 * Create the panel.
	 */
	public ClaimHistoryJPanel() {
		this.setSize(new Dimension(500, 500));
		PoNo = "";
		Insured = "";
		// headerb1 headerb2 101/03/26 new by jnd115
		String[] headerb1 = { "郵遞區號", "受益人地址", "聯絡電話", "手機號碼", "入出境日期" };

		String[] headerb2 = { "受款人英文名", "SWIFT CODE", "銀行名稱", "銀行地址", "匯款帳號" };

		// headerCled 101/04/18 new by jnd115
		String[] headerCled = { "死亡地點", "死亡場所", "死亡種類", "地檢署名稱", "檢察官姓名",
				"法醫師／檢驗員姓名", "證明書開立日期" };

		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);

		// panel_0 = new JPanel();
		// springLayout.putConstraint(SpringLayout.NORTH, panel_0, 0,
		// SpringLayout.NORTH, this);
		// springLayout.putConstraint(SpringLayout.SOUTH, panel_0, 30,
		// SpringLayout.NORTH, this);
		// springLayout.putConstraint(SpringLayout.EAST, panel_0, 0,
		// SpringLayout.EAST, this);
		// // springLayout.putConstraint(SpringLayout.SOUTH, panel_0, 0,
		// // SpringLayout.NORTH, panel_1);
		// springLayout.putConstraint(SpringLayout.WEST, panel_0, 0,
		// SpringLayout.WEST, this);
		// add(panel_0);

		panel_1 = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel_1, 0,
				SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, panel_1, 0,
				SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, panel_1, -369,
				SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, panel_1, 0,
				SpringLayout.EAST, this);
		add(panel_1);
		// add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));

		panel_0 = new JPanel();
		panel_1.add(panel_0, BorderLayout.NORTH);
		GridBagLayout gbl_panel_0 = new GridBagLayout();
		gbl_panel_0.columnWidths = new int[] { 68, 74, 77, 71, 0, 25, 96, 0, 0 };
		gbl_panel_0.rowHeights = new int[] { 21, 0 };
		gbl_panel_0.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel_0.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_0.setLayout(gbl_panel_0);

		label_1 = new JLabel("\u4FDD\u55AE\u865F\u78BC");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 0, 5);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 0;
		panel_0.add(label_1, gbc_label_1);

		txtPolicy = new JTextField();
		GridBagConstraints gbc_txtPolicy = new GridBagConstraints();
		gbc_txtPolicy.insets = new Insets(0, 0, 0, 5);
		gbc_txtPolicy.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPolicy.gridx = 1;
		gbc_txtPolicy.gridy = 0;
		panel_0.add(txtPolicy, gbc_txtPolicy);
		txtPolicy.setColumns(10);
		txtPolicy.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (txtPolicy.getText().length() == 0)
					txtPolicy.setText(PoNo);
			}
		});

		lblid_1 = new JLabel("\u88AB\u4FDD\u96AA\u4EBAID");
		GridBagConstraints gbc_lblid_1 = new GridBagConstraints();
		gbc_lblid_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblid_1.gridx = 2;
		gbc_lblid_1.gridy = 0;
		panel_0.add(lblid_1, gbc_lblid_1);

		txtInsured = new JTextField();
		GridBagConstraints gbc_txtInsured = new GridBagConstraints();
		gbc_txtInsured.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtInsured.insets = new Insets(0, 0, 0, 5);
		gbc_txtInsured.anchor = GridBagConstraints.NORTH;
		gbc_txtInsured.gridx = 3;
		gbc_txtInsured.gridy = 0;
		panel_0.add(txtInsured, gbc_txtInsured);
		txtInsured.setColumns(10);
		txtInsured.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (txtInsured.getText().length() == 0)
					txtInsured.setText(Insured);
			}
		});

		label_2 = new JLabel("\u5E74\u5EA6");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.anchor = GridBagConstraints.EAST;
		gbc_label_2.insets = new Insets(0, 0, 0, 5);
		gbc_label_2.gridx = 4;
		gbc_label_2.gridy = 0;
		panel_0.add(label_2, gbc_label_2);

		txtClaimYear = new JTextField();
		GridBagConstraints gbc_txtClaimYear = new GridBagConstraints();
		gbc_txtClaimYear.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtClaimYear.insets = new Insets(0, 0, 0, 5);
		gbc_txtClaimYear.gridx = 5;
		gbc_txtClaimYear.gridy = 0;
		panel_0.add(txtClaimYear, gbc_txtClaimYear);
		txtClaimYear.setColumns(10);

		btnNewButton_1 = new JButton("\u67E5\u8A62");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				historyController.executeMission(txtPolicy.getText(),
						txtInsured.getText(), txtClaimYear.getText());
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_1.gridx = 6;
		gbc_btnNewButton_1.gridy = 0;
		panel_0.add(btnNewButton_1, gbc_btnNewButton_1);

		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane);

		// scrollPane.setSize(new Dimension(10,700));
		// panel_1.setPreferredSize(new Dimension(10,700));
		// panel_1.setMinimumSize(new Dimension(10,700));
		table = new JTable();
		table.setToolTipText("點擊以顯示下方明細");
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setRowHeight(table.getRowHeight() * 2);
		table.setDefaultRenderer(String.class, new MultiLineCellRenderer());

		table.getSelectionModel().addListSelectionListener(
				new ListSelectionListener() {

					@Override
					public void valueChanged(ListSelectionEvent arg0) {
						// TODO Auto-generated method stub
						if (!((DefaultListSelectionModel) arg0.getSource())
								.getValueIsAdjusting()) {
							int row = table.getSelectedRow();

							textField.setText("");
							if (row != -1) {
								// test //DBConnection.user_dept.equals("90200")
								// ||
								clearPagesSub();
								if (DBConnection.user_dept
										.matches("9[A-Z0-9]42[0-9]*")
										|| history01Group.getClaimHistory01s()
												.get(row).getR_cl_sts_code()
												.toString().equals("8")) // CL)
								{
									historyController
											.executeInnerMission(
													history01Group
															.getClaimHistory01s()
															.get(row)
															.getR_policy_no(),
													history01Group
															.getClaimHistory01s()
															.get(row)
															.getR_claim_seq(),
													history01Group
															.getClaimHistory01s()
															.get(row)
															.getR_claim_year());

									historyController
											.executeInnerMission(
													history01Group
															.getClaimHistory01s()
															.get(row)
															.getR_policy_no(),
													history01Group
															.getClaimHistory01s()
															.get(row)
															.getR_claim_seq(),
													history01Group
															.getClaimHistory01s()
															.get(row)
															.getR_event_date(),
													history02
															.getR_client_ident(),
													history02.getR_type(),
													history01Group
															.getClaimHistory01s()
															.get(row)
															.getR_insured_id(),
													history01Group
															.getClaimHistory01s()
															.get(row)
															.getR_claim_year());

									historyController.executeInnerMission(
											history01Group.getClaimHistory01s()
													.get(row).getR_policy_no(),
											history01Group.getClaimHistory01s()
													.get(row).getR_claim_seq(),
											history02.getR_cl_examine_code(),
											ClaimHistoryQuery.CC174I);

									if (history01Group.getClaimHistory01s()
											.get(row).getR_clcm_ind()
											.endsWith("Y")) {
										historyController.executeInnerMission(
												history01Group
														.getClaimHistory01s()
														.get(row)
														.getR_policy_no(),
												history01Group
														.getClaimHistory01s()
														.get(row)
														.getR_claim_seq(), "",
												ClaimHistoryQuery.CLAIMMARK);
									}
									// 地檢署相驗明細 101/04/18 new by jnd115
									historyController
											.executeInnerMission(
													history01Group
															.getClaimHistory01s()
															.get(row)
															.getR_policy_no(),
													history01Group
															.getClaimHistory01s()
															.get(row)
															.getR_claim_seq(),
													history01Group
															.getClaimHistory01s()
															.get(row)
															.getR_claim_year(),
													ClaimHistoryQuery.DISPCLED);

									// 重設受益人資料,必須在cc175i(受益人取得procedure)之後
									if (!(history02.getR_type().equals("T") || history02
											.getR_type().equals("G"))) {
										String args[] = verticalPane3
												.getValues();
										// update 102.07.15 因新增調整欄位故重設定位置改變
										args[0] = history05Group.getBenfNames();
										verticalPane3.setValue(args);
									}

								}
							}
						}
					}
				});

		scrollPane.setViewportView(table);

		panel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel, 0,
				SpringLayout.SOUTH, panel_1);
		springLayout.putConstraint(SpringLayout.SOUTH, panel, 0,
				SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, panel, 0,
				SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.WEST, panel, 0,
				SpringLayout.WEST, this);
		add(panel);

		panel.setLayout(new BorderLayout(0, 0));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				if (arg0.getClickCount() == 2) {
					validate();
					setExtended();
				}
			}
		});
		panel.add(tabbedPane);

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("理賠基本資料", null, panel_2, null);
		panel_2.setLayout(new BorderLayout(0, 0));

		JPanel panel_6 = new JPanel();
		panel_2.add(panel_6);
		panel_6.setLayout(new GridLayout(0, 4, 0, 0));
		verticalPane1 = new VerticalPane(headers, "", 80, 25);

		panel_6.add(verticalPane1);
		verticalPane2 = new VerticalPane(headers2, "", 110, 25);
		panel_6.add(verticalPane2);
		verticalPane3 = new VerticalPane(headers3, "", 110, 25);
		panel_6.add(verticalPane3);
		verticalPane4 = new VerticalPane(headers4, "", 95, 25);
		panel_6.add(verticalPane4);

		textField = new JTextField();
		textField.setFont(new Font("細明體", Font.BOLD, 14));
		textField.setForeground(Color.BLUE);
		panel_2.add(textField, BorderLayout.NORTH);
		textField.setColumns(10);

		// 101/05/17 事故原因從主頁面分出來
		JPanel panel_11 = new JPanel();
		// panel_11.setBorder(new TitledBorder(null, "\u7406\u8CE0\u8CC7\u6599",
		// TitledBorder.LEADING, TitledBorder.TOP, null, null));
		tabbedPane.addTab("事故原因及註記病史", null, panel_11, null);
		panel_11.setLayout(new GridLayout(2, 0, 0, 0));

		scrollPane_9 = new JScrollPane();
		panel_11.add(scrollPane_9);
		table_9 = new JTable();
		scrollPane_9.setViewportView(table_9);

		scrollPane_10 = new JScrollPane();
		panel_11.add(scrollPane_10);

		table_10 = new JTable();
		scrollPane_10.setViewportView(table_10);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "\u7406\u8CE0\u8CC7\u6599",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		tabbedPane.addTab("給付資料", null, panel_3, null);
		panel_3.setLayout(new GridLayout(3, 0, 0, 0));

		JScrollPane scrollPane_1 = new JScrollPane();
		panel_3.add(scrollPane_1);

		table_1 = new JTable();// TipJTable("點擊以顯示下方明細").getTable();// JTable();
		table_1.setToolTipText("點擊以顯示下方明細");
		scrollPane_1.setViewportView(table_1);

		table_1.getSelectionModel().addListSelectionListener(
				new ListSelectionListener() {

					@Override
					public void valueChanged(ListSelectionEvent arg0) {

						// TODO Auto-generated method stub
						if (!((DefaultListSelectionModel) arg0.getSource())
								.getValueIsAdjusting()) {
							int row = table_1.getSelectedRow();

							if (row != -1) {
								clearPage2Sub();
								// System.out.println("row = "+row+
								// history03Group.getClaimHistory03s().get(row).getR_rate_scale());
								historyController.executeInnerMission(
										history01Group.getClaimHistory01s()
												.get(table.getSelectedRow())
												.getR_policy_no(),
										history01Group.getClaimHistory01s()
												.get(table.getSelectedRow())
												.getR_claim_seq(),
										history03Group.getClaimHistory03s()
												.get(row).getR_plan_code(),
										history03Group.getClaimHistory03s()
												.get(row).getR_rate_scale(),
										history03Group.getClaimHistory03s()
												.get(row).getR_co_issue_date(),
										Integer.parseInt(history03Group
												.getClaimHistory03s().get(row)
												.getR_coverage_no().toString()),
										history01Group.getClaimHistory01s()
												.get(table.getSelectedRow())
												.getR_claim_year().toString());

								historyController.executeInnerMission(
										history01Group.getClaimHistory01s()
												.get(table.getSelectedRow())
												.getR_policy_no(),
										history01Group.getClaimHistory01s()
												.get(table.getSelectedRow())
												.getR_claim_seq(),
										history03Group.getClaimHistory03s()
												.get(row).getR_plan_code(),
										history03Group.getClaimHistory03s()
												.get(row).getR_rate_scale(),
										history03Group.getClaimHistory03s()
												.get(row).getR_coverage_no(),
										history01Group.getClaimHistory01s()
												.get(table.getSelectedRow())
												.getR_claim_year().toString());
							}
						}
					}
				});

		JScrollPane scrollPane_2 = new JScrollPane();
		panel_3.add(scrollPane_2);
		table_2 = new JTable();
		table_2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_2.setViewportView(table_2);

		scrollPane_5 = new JScrollPane();
		panel_3.add(scrollPane_5);

		table_5 = new JTable();
		table_5.setRowHeight(table_5.getRowHeight() * 3);
		table_5.setDefaultRenderer(String.class, new MultiLineCellRenderer());
		scrollPane_5.setViewportView(table_5);

		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("受益人", null, panel_4, null);
		panel_4.setLayout(new GridLayout(2, 1, 0, 0));

		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBorder(new TitledBorder(new EtchedBorder(
				EtchedBorder.LOWERED, null, null),
				"\u53D7\u76CA\u4EBA\u5730\u5740\u53CA\u5E33\u865F",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 70,
						213)));
		panel_4.add(scrollPane_3);

		// 受益人
		table_3 = new JTable();
		table_3.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// 點選受益人帳戶選項時,將帳戶移除-,移除時加上-
		table_3.getColumnModel().getSelectionModel()
				.addListSelectionListener(new ListSelectionListener() {
					int preCol;
					int preRow;
					ClaimHistory05 prehistory05;

					@Override
					public void valueChanged(ListSelectionEvent arg0) {
						// TODO Auto-generated method stub
						// System.out.println(arg0);
						if (!((DefaultListSelectionModel) arg0.getSource())
								.getValueIsAdjusting()) {
							int row = table_3.getSelectedRow();
							int column = table_3.getSelectedColumn();

							if (row != -1 && column == 8) {
								ClaimHistory05 history05 = history05Group
										.getClaimHistory05s().get(row);
								history05.setR_remit_account(history05
										.getR_remit_account().replace("-", ""));
								prehistory05 = history05;
							}
							if (preRow != -1 && preCol == 8) {
								String account = prehistory05
										.getR_remit_account().replace("-", "");
								if (account.length() > 7) {
									account = account.substring(0, 3)
											+ "-"
											+ account.substring(3, 7)
											+ "-"
											+ account.substring(7,
													account.length());
									prehistory05.setR_remit_account(account);
								}

							}
							preRow = row;
							preCol = column;
						}
					}
				});
		scrollPane_3.setViewportView(table_3);

		// begin 101/03/26 by jnd115
		JPanel panel_8 = new JPanel();
		panel_4.add(panel_8);
		panel_8.setLayout(new BorderLayout(0, 0));

		textField_1 = new JTextField();
		textField_1.setForeground(Color.BLUE);
		textField_1.setFont(new Font("細明體", Font.BOLD, 14));
		panel_8.add(textField_1, BorderLayout.NORTH);
		textField_1.setColumns(10);

		JPanel panel_9 = new JPanel();
		panel_8.add(panel_9, BorderLayout.CENTER);
		panel_9.setLayout(new GridLayout(0, 2, 0, 0));

		verticalPane5 = new VerticalPane(headerb1, "", 80, 25);
		panel_9.add(verticalPane5);
		verticalPane6 = new VerticalPane(headerb2, "", 110, 25);
		panel_9.add(verticalPane6);

		// scrollPane_9 = new JScrollPane();
		// scrollPane_9.setBorder(new TitledBorder(null,
		// "\u53D7\u76CA\u4EBA(2)",
		// TitledBorder.LEADING, TitledBorder.TOP, null, null));
		// panel_4.add(scrollPane_9);

		// DefaultTableModel jTable1Model = new DefaultTableModel(
		// new String[5][0], new String[] { "郵遞區號", "受益人地址", "聯絡電話",
		// "手機號碼", "入出境日期" }) {
		//
		// private static final long serialVersionUID = 1L;
		//
		// public boolean isCellEditable(int row, int column) {
		// return false;
		// }
		// };
		// table_9 = new JTable(jTable1Model);
		// table_9.setCellSelectionEnabled(true);

		// table_9.setModel(jTable1Model);
		// scrollPane_9.setViewportView(table_9);
		// jTable1Model.setRowCount(0);
		// end 101/03/26 by jnd115

		table_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				int row = table_3.getSelectedRow();
				if (row != -1) {
					ClaimHistory05 history05 = history05Group
							.getClaimHistory05s().get(row);
					String context1[] = history05.getBenfAddr();
					String context2[] = history05.getBenfAcct();
					// begin 101/03/26 by jnd115
					// DefaultTableModel model = (DefaultTableModel)
					// table_9.getModel();
					// model.setRowCount(0);
					// model.addRow(context);
					verticalPane5.setValue(context1);
					verticalPane6.setValue(context2);
					// end 101/03/26 by jnd115
				}
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
			}
		});

		verticalPane5.setListSelectionListener(true, textField_1); // 101/03/26
																	// new by
																	// jnd115
		verticalPane6.setListSelectionListener(true, textField_1); // 101/03/26
																	// new by
																	// jnd115

		panel_7 = new JPanel();
		tabbedPane.addTab("就診醫院", null, panel_7, null);
		panel_7.setLayout(new GridLayout(0, 1, 0, 0));
		scrollPane_6 = new JScrollPane();
		panel_7.add(scrollPane_6);
		scrollPane_6.setBorder(new TitledBorder(null,
				"\u5C31\u8A3A\u91AB\u9662", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));

		// 就診醫院
		table_6 = new JTable();
		scrollPane_6.setViewportView(table_6);

		scrollPane_11 = new JScrollPane();
		panel_7.add(scrollPane_11);

		table_11 = new JTable();
		scrollPane_11.setViewportView(table_11);

		// add 102.06.20 就診明細
		scrollPane_11.setBorder(new TitledBorder(null, "就診明細",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));

		scrollPane_7 = new JScrollPane();
		panel_7.add(scrollPane_7);
		scrollPane_7.setBorder(new TitledBorder(null,
				"\u5B89\u5BE7\u7DE9\u548C\u91AB\u7642", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));

		table_7 = new JTable();
		scrollPane_7.setViewportView(table_7);

		// 安寧緩和醫院
		table_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				if (arg0.getClickCount() == 2) {
					int row = table_7.getSelectedRow();
					if (row != -1) {

						if (history09Group.getClaimHistory09s().get(row)
								.getRemark().equals("Y")) {
							historyController.showHospitalDetail(history09Group
									.getClaimHistory09s().get(row)
									.getHi_hospital_id());

						}

					}
				}

			}
		});

		table_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				// 就診明細(點擊就診醫院)
				if (arg0.getClickCount() == 1) {
					int row = table.getSelectedRow();
					int row1 = table_6.getSelectedRow();

					if (row != -1) {
						history12Group.removeAll();
						historyController.executeInnerMission2(
								history01Group.getClaimHistory01s().get(row)
										.getR_policy_no(), history01Group
										.getClaimHistory01s().get(row)
										.getR_claim_seq(), history01Group
										.getClaimHistory01s().get(row)
										.getR_claim_year(), history08Group
										.getClaimHistory08s().get(row1)
										.getClhn_seq());
						// System.out.println("888:"+history08Group.getClaimHistory08s().get(row).getClhn_seq());
						// System.out.println("888:"+history01Group.getClaimHistory01s().get(row).getR_policy_no());
					}

				}

				if (arg0.getClickCount() == 2) {
					int row = table_6.getSelectedRow();
					if (row != -1) {

						if (history08Group.getClaimHistory08s().get(row)
								.getRemark().equals("Y")) {
							historyController.showHospitalDetail(history08Group
									.getClaimHistory08s().get(row)
									.getHi_hospital_id());

						}

					}
				}

			}
		});

		// 地檢署相驗明細101/04/18 new by jnd115
		JPanel panel_10 = new JPanel();
		tabbedPane.addTab("地檢署相驗明細", null, panel_10, null);
		panel_10.setLayout(new GridLayout(0, 1, 0, 0));
		verticalPane7 = new VerticalPane(headerCled, "", 150, 30);
		panel_10.add(verticalPane7);

		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(null, "\u62D2\u8CE0\u539F\u56E0",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		tabbedPane.addTab("拒賠原因及理賠註記", null, panel_5, null);
		panel_5.setLayout(new GridLayout(2, 1, 0, 0));

		JScrollPane scrollPane_4 = new JScrollPane();
		panel_5.add(scrollPane_4);

		table_4 = new JTable();
		table_4.setRowHeight(table_4.getRowHeight() * 2);
		table_4.setDefaultRenderer(String.class, new MultiLineCellRenderer());
		table_4.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_4.setViewportView(table_4);

		scrollPane_8 = new JScrollPane();
		scrollPane_8.setBorder(new TitledBorder(null,
				"\u7406\u8CE0\u8A3B\u8A18", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel_5.add(scrollPane_8);

		table_8 = new JTable();
		scrollPane_8.setViewportView(table_8);

		initDataBindings();

		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

		// 就診醫院
		table_6.getColumnModel().getColumn(1).setPreferredWidth(150);
		table_6.getColumnModel().getColumn(2).setPreferredWidth(50);
		table_6.getColumnModel().getColumn(3).setPreferredWidth(110);
		table_6.getColumnModel().getColumn(4).setPreferredWidth(50);
		table_6.getColumnModel().getColumn(5).setPreferredWidth(100);

		table_4.getColumnModel().getColumn(0).setPreferredWidth(45);
		table_4.getColumnModel().getColumn(1).setPreferredWidth(20);
		table_4.getColumnModel().getColumn(2).setPreferredWidth(55);
		table_4.getColumnModel().getColumn(3).setPreferredWidth(570);
		table_2.getColumnModel().getColumn(0).setPreferredWidth(200);
		table_2.getColumnModel().getColumn(1).setPreferredWidth(100);
		table_2.getColumnModel().getColumn(2).setPreferredWidth(30);
		table_2.getColumnModel().getColumn(3).setPreferredWidth(25);
		table_2.getColumnModel().getColumn(4).setPreferredWidth(25);
		table_2.getColumnModel().getColumn(5).setPreferredWidth(25);
		table_2.getColumnModel().getColumn(6).setPreferredWidth(25);
		table_2.getColumnModel().getColumn(7).setPreferredWidth(25);
		table_2.getColumnModel().getColumn(8).setPreferredWidth(35);

		// 受益人
		table_3.getColumnModel().getColumn(0).setPreferredWidth(80);
		table_3.getColumnModel().getColumn(2).setPreferredWidth(50);
		table_3.getColumnModel().getColumn(3).setPreferredWidth(110);
		table_3.getColumnModel().getColumn(10).setPreferredWidth(125);

		// 設理賠歷史紀錄TABLE COLUMN SIZE
		table.getColumnModel().getColumn(0).setPreferredWidth(85);
		table.getColumnModel().getColumn(1).setPreferredWidth(25);
		table.getColumnModel().getColumn(2).setPreferredWidth(25);
		table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(3).setPreferredWidth(25);
		table.getColumnModel().getColumn(4).setPreferredWidth(65);
		table.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(5).setPreferredWidth(55);
		table.getColumnModel().getColumn(6).setPreferredWidth(65);
		table.getColumnModel().getColumn(7).setPreferredWidth(65);
		table.getColumnModel().getColumn(8).setPreferredWidth(65);
		table.getColumnModel().getColumn(9).setPreferredWidth(65);
		table.getColumnModel().getColumn(10).setPreferredWidth(70);
		table.getColumnModel().getColumn(10).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(11).setCellRenderer(rightRenderer);
		table.getColumnModel().getColumn(12).setPreferredWidth(190);

		table_5.getColumnModel().getColumn(0).setPreferredWidth(130);
		table_5.getColumnModel().getColumn(0).setMaxWidth(130);
		table_5.getColumnModel().getColumn(1).setPreferredWidth(60);
		table_5.getColumnModel().getColumn(1).setMaxWidth(60);
		table_5.getColumnModel().getColumn(3).setPreferredWidth(150);
		table_5.getColumnModel().getColumn(4).setPreferredWidth(130);
		table_5.getColumnModel().getColumn(3).setMaxWidth(170);
		table_5.getColumnModel().getColumn(4).setMaxWidth(170);

		// 就診明細
		table_11.getColumnModel().getColumn(0).setPreferredWidth(150);

		// 受益人地址 101/03/26 mark by jnd115
		// table_9.getColumnModel().getColumn(0).setPreferredWidth(40);
		// table_9.getColumnModel().getColumn(1).setPreferredWidth(350);
		// table_9.getColumnModel().getColumn(2).setPreferredWidth(30);
		// table_9.getColumnModel().getColumn(3).setPreferredWidth(30);
		// table_9.getColumnModel().getColumn(4).setPreferredWidth(80);

		// 就診醫院註記
		table_6.getColumnModel().getColumn(2)
				.setCellRenderer(new MultiLineCellRenderer() {

					private static final long serialVersionUID = 1L;

					public boolean condition(JTable table, Object value,
							int row, int column) {
						if (value.equals("Y"))
							return true;
						else
							return false;
					}

					public Color getColor() {
						return Color.RED;
					}

				});

		// 安寧醫院註記
		table_7.getColumnModel().getColumn(2)
				.setCellRenderer(new MultiLineCellRenderer() {
					/**
			 * 
			 */
					private static final long serialVersionUID = 1L;

					public boolean condition(JTable table, Object value,
							int row, int column) {
						if (value.equals("Y"))
							return true;
						else
							return false;
					}

					public Color getColor() {
						return Color.RED;
					}

				});
	}

	private void setExtended() {
		isExtended = !isExtended;
		if (isExtended) {
			((SpringLayout) this.getLayout()).putConstraint(SpringLayout.NORTH,
					panel, 0, SpringLayout.NORTH, this);
		} else {
			((SpringLayout) this.getLayout()).putConstraint(SpringLayout.NORTH,
					panel, -355, SpringLayout.SOUTH, this);

		}
		this.invalidate();
		this.validate();
	}

	public void setController(ClaimHistoryController controller) {
		historyController = controller;
	}

	public void addClaimHistory01(ClaimHistory01 history01) {
		history01Group.addClaimHistory01(history01);
	}

	public void addClaimHistory02event(ClaimHistory02event history02event) {
		history02eventGroup.addClaimHistory02event(history02event);
	}

	public void addClaimHistory02sick(ClaimHistory02event history02event) {
		history02sickGroup.addClaimHistory02event(history02event);
	}

	public void addClaimHistory03(ClaimHistory03 history03) {
		history03Group.addClaimHistory03(history03);
	}

	public void addClaimHistory04(ClaimHistory04 history04) {
		history04Group.addClaimHistory04(history04);
	}

	public void addClaimHistory05(ClaimHistory05 history05) {
		history05Group.addClaimHistory05(history05);
	}

	public void addClaimHistory06(ClaimHistory06 history06) {
		history06Group.addClaimHistory06(history06);
	}

	public void addClaimHistory07(ClaimHistory07 history07) {
		history07Group.addClaimHistory07(history07);
	}

	public void addClaimHistory08(ClaimHistory08 history08) {
		history08Group.addClaimHistory08(history08);
	}

	public void addClaimHistory09(ClaimHistory09 history09) {
		history09Group.addClaimHistory09(history09);
	}

	public void addClaimHistory10(ClaimHistory10 history10) {
		history10Group.addClaimHistory10(history10);
	}

	// add 102.06.20 就診明細
	public void addClaimHistory12(ClaimHistory12 history12) {
		history12Group.addClaimHistory12(history12);
	}

	public void setClaimHistory02(HashMap<String, String> hsmp) {
		history02.setValues(hsmp);
		if (history02.getR_type().equals("G")) {
			verticalPane1.setTableFormat(headersG1, "", 80, 25);
			verticalPane2.setTableFormat(headersG2, "", 110, 25);
			verticalPane3.setTableFormat(headersG3, "", 110, 25);
			verticalPane4.setTableFormat(headersG4, "", 95, 25);
		} else if (history02.getR_type().equals("T")) {
			verticalPane1.setTableFormat(headersT1, "", 90, 25);
			verticalPane2.setTableFormat(headersT2, "", 110, 25);
			verticalPane3.setTableFormat(headersT3, "", 110, 25);
			verticalPane4.setTableFormat(headersT4, "", 95, 25);
		} else {
			verticalPane1.setTableFormat(headers, "", 80, 25);
			verticalPane2.setTableFormat(headers2, "", 110, 25);
			verticalPane3.setTableFormat(headers3, "", 110, 25);
			verticalPane4.setTableFormat(headers4, "", 95, 25);
		}
		verticalPane1.setValue(history02.getColumn1());
		verticalPane2.setValue(history02.getColumn2());
		verticalPane3.setValue(history02.getColumn3());
		verticalPane4.setValue(history02.getColumn4());

		verticalPane1.setListSelectionListener(true, textField);
		verticalPane2.setListSelectionListener(true, textField);
		verticalPane3.setListSelectionListener(true, textField);
		verticalPane4.setListSelectionListener(true, textField);

	}

	// 101/04/18 new by jnd115
	public void setClaimHistory11(HashMap<String, String> hsmp) {
		history11.setValues(hsmp);
		verticalPane7.setValue(history11.getCledColumn());
	}

	public void clearAll() {
		history01Group.removeAll();
		clearPagesSub();
	}

	public void nullAll() {
		table = null;
		table_1 = null;
		table_2 = null;
		table_3 = null;
		table_4 = null;
		verticalPane1 = null;
		verticalPane2 = null;
		verticalPane3 = null;
		verticalPane4 = null;
		verticalPane5 = null; // 101/03/26 new by jnd115
		verticalPane6 = null; // 101/03/26 new by jnd115
		verticalPane7 = null; // 101/04/18 new by jnd115
		history01Group = null;
		history02 = null;
		history02eventGroup = null;
		history03Group = null;
		history04Group = null;
		history05Group = null;
		history06Group = null;
		history07Group = null;
		history08Group = null;
		history09Group = null;
		history10Group = null;
		history11 = null; // 101/04/18 new by jnd115
		historyController = null;
		textField = null;
		textField_1 = null; // 101/03/26 new by jnd115
		panel_1 = null;
		panel = null;
		scrollPane_5 = null;
		table_5 = null;
		scrollPane_6 = null;
		scrollPane_7 = null;
		table_6 = null;
		table_7 = null;
		scrollPane_8 = null;
		table_8 = null;
		panel_7 = null;

		table_11 = null;
		// scrollPane_9 = null; 101/03/26 mark by jnd115
		// table_9 = null; 101/03/26 mark by jnd115
	}

	public void clearPagesSub() {
		history02eventGroup.removeAll();
		history02sickGroup.removeAll();
		history03Group.removeAll();
		history04Group.removeAll();
		history05Group.removeAll();
		history06Group.removeAll();
		history07Group.removeAll();
		history08Group.removeAll();
		history09Group.removeAll();
		history10Group.removeAll();
		history12Group.removeAll();

		verticalPane1.clearValues();
		verticalPane2.clearValues();
		verticalPane3.clearValues();
		verticalPane4.clearValues();
		verticalPane5.clearValues(); // 101/03/26 new by jnd115
		verticalPane6.clearValues(); // 101/03/26 new by jnd115
		// DefaultTableModel model = (DefaultTableModel) table_9.getModel();
		// model.setRowCount(0);
		verticalPane7.clearValues(); // 101/04/18 new by jnd115
	}

	// 點選項目明細時需移除下面兩個TABLE資料
	public void clearPage2Sub() {
		history04Group.removeAll();
		history07Group.removeAll();
	}

	public void setPONO(String Policy, String Insured) {
		txtPolicy.setText(Policy);
		txtInsured.setText(Insured);
	}

	public void setPOID(String Policy, String Insured) {
		this.PoNo = Policy;
		this.Insured = Insured;
	}

	protected void initDataBindings() {
		BeanProperty<ClaimHistory01Group, List<ClaimHistory01>> claimHistory01GroupBeanProperty = BeanProperty
				.create("claimHistory01s");
		JTableBinding<ClaimHistory01, ClaimHistory01Group, JTable> jTableBinding = SwingBindings
				.createJTableBinding(UpdateStrategy.READ, history01Group,
						claimHistory01GroupBeanProperty, table);
		//
		BeanProperty<ClaimHistory01, String> claimHistory01BeanProperty = BeanProperty
				.create("r_policy_no");
		jTableBinding.addColumnBinding(claimHistory01BeanProperty)
				.setColumnName("\u4FDD\u55AE\u865F\u78BC");
		//
		BeanProperty<ClaimHistory01, String> claimHistory01BeanProperty_1 = BeanProperty
				.create("r_claim_year");
		jTableBinding.addColumnBinding(claimHistory01BeanProperty_1)
				.setColumnName("\u5E74");
		//
		BeanProperty<ClaimHistory01, String> claimHistory01BeanProperty_2 = BeanProperty
				.create("r_claim_seq");
		jTableBinding.addColumnBinding(claimHistory01BeanProperty_2)
				.setColumnName("\u5E8F");
		//
		BeanProperty<ClaimHistory01, String> claimHistory01BeanProperty_3 = BeanProperty
				.create("r_clcm_ind");
		jTableBinding.addColumnBinding(claimHistory01BeanProperty_3)
				.setColumnName("\u8A3B");
		//
		BeanProperty<ClaimHistory01, String> claimHistory01BeanProperty_4 = BeanProperty
				.create("r_event_date");
		jTableBinding.addColumnBinding(claimHistory01BeanProperty_4)
				.setColumnName("\u4E8B\u6545\u65E5\u671F");
		//
		BeanProperty<ClaimHistory01, String> claimHistory01BeanProperty_5 = BeanProperty
				.create("r_event_name");
		jTableBinding.addColumnBinding(claimHistory01BeanProperty_5)
				.setColumnName("\u4E8B\u6545\u4EBA");
		//
		BeanProperty<ClaimHistory01, String> claimHistory01BeanProperty_6 = BeanProperty
				.create("r_cl_sts_desc");
		jTableBinding.addColumnBinding(claimHistory01BeanProperty_6)
				.setColumnName("\u7406\u8CE0\u72C0\u614B");
		//
		BeanProperty<ClaimHistory01, String> claimHistory01BeanProperty_7 = BeanProperty
				.create("r_claim_desc");
		jTableBinding.addColumnBinding(claimHistory01BeanProperty_7)
				.setColumnName("\u7406\u8CE0\u578B\u614B");
		//
		BeanProperty<ClaimHistory01, String> claimHistory01BeanProperty_8 = BeanProperty
				.create("r_cl_examine_desc");
		jTableBinding.addColumnBinding(claimHistory01BeanProperty_8)
				.setColumnName("\u7D50\u6848\u578B\u614B");
		//
		BeanProperty<ClaimHistory01, String> claimHistory01BeanProperty_9 = BeanProperty
				.create("r_examine_name");
		jTableBinding.addColumnBinding(claimHistory01BeanProperty_9)
				.setColumnName("\u5BE9\u6838\u54E1");
		//
		BeanProperty<ClaimHistory01, String> claimHistory01BeanProperty_10 = BeanProperty
				.create("r_approve_date");
		jTableBinding.addColumnBinding(claimHistory01BeanProperty_10)
				.setColumnName("\u7D50\u6848\u65E5\u671F");
		//
		BeanProperty<ClaimHistory01, String> claimHistory01BeanProperty_11 = BeanProperty
				.create("r_claim_amt_d");
		jTableBinding.addColumnBinding(claimHistory01BeanProperty_11)
				.setColumnName("\u7D66\u4ED8\u91D1\u984D");
		//
		BeanProperty<ClaimHistory01, String> claimHistory01BeanProperty_12 = BeanProperty
				.create("r_cl_event_desc");
		jTableBinding.addColumnBinding(claimHistory01BeanProperty_12)
				.setColumnName("\u4E8B\u6545\u539F\u56E0")
				.setColumnClass(String.class);
		//
		jTableBinding.setEditable(false);
		jTableBinding.bind();
		//
		BeanProperty<ClaimHistory03Group, List<ClaimHistory03>> claimHistory03GroupBeanProperty = BeanProperty
				.create("claimHistory03s");
		JTableBinding<ClaimHistory03, ClaimHistory03Group, JTable> jTableBinding_1 = SwingBindings
				.createJTableBinding(UpdateStrategy.READ, history03Group,
						claimHistory03GroupBeanProperty, table_1);
		//
		BeanProperty<ClaimHistory03, String> claimHistory03BeanProperty = BeanProperty
				.create("r_plan_code");
		jTableBinding_1.addColumnBinding(claimHistory03BeanProperty)
				.setColumnName("\u4FDD\u96AA\u9805\u76EE");
		//
		BeanProperty<ClaimHistory03, String> claimHistory03BeanProperty_1 = BeanProperty
				.create("r_rate_scale");
		jTableBinding_1.addColumnBinding(claimHistory03BeanProperty_1)
				.setColumnName("\u7248\u6578");
		//
		BeanProperty<ClaimHistory03, String> claimHistory03BeanProperty_2 = BeanProperty
				.create("r_co_issue_date");
		jTableBinding_1.addColumnBinding(claimHistory03BeanProperty_2)
				.setColumnName("\u751F\u6548\u65E5\u671F");
		//
		BeanProperty<ClaimHistory03, String> claimHistory03BeanProperty_3 = BeanProperty
				.create("r_co_sts_code");
		jTableBinding_1.addColumnBinding(claimHistory03BeanProperty_3)
				.setColumnName("\u72C0\u614B");
		//
		BeanProperty<ClaimHistory03, String> claimHistory03BeanProperty_4 = BeanProperty
				.create("r_face_amt");
		jTableBinding_1.addColumnBinding(claimHistory03BeanProperty_4)
				.setColumnName("\u4FDD\u96AA\u91D1\u984D");
		//
		BeanProperty<ClaimHistory03, String> claimHistory03BeanProperty_5 = BeanProperty
				.create("r_claim_amt");
		jTableBinding_1.addColumnBinding(claimHistory03BeanProperty_5)
				.setColumnName("\u7406\u8CE0\u91D1\u984D");
		//
		jTableBinding_1.setEditable(false);
		jTableBinding_1.bind();
		//
		BeanProperty<ClaimHistory04Group, List<ClaimHistory04>> claimHistory04GroupBeanProperty = BeanProperty
				.create("claimHistory04s");
		JTableBinding<ClaimHistory04, ClaimHistory04Group, JTable> jTableBinding_2 = SwingBindings
				.createJTableBinding(UpdateStrategy.READ, history04Group,
						claimHistory04GroupBeanProperty, table_2);
		//
		BeanProperty<ClaimHistory04, String> claimHistory04BeanProperty = BeanProperty
				.create("r_cl_item_desc");
		jTableBinding_2.addColumnBinding(claimHistory04BeanProperty)
				.setColumnName("\u7406\u8CE0\u9805\u76EE");
		//
		BeanProperty<ClaimHistory04, String> claimHistory04BeanProperty_1 = BeanProperty
				.create("r_cl_unit_amt");
		jTableBinding_2.addColumnBinding(claimHistory04BeanProperty_1)
				.setColumnName(
						"\u55AE\u4F4D\u7533\u8ACB\u7406\u8CE0\u91D1\u984D");
		//
		BeanProperty<ClaimHistory04, String> claimHistory04BeanProperty_2 = BeanProperty
				.create("r_cl_deform_code");
		jTableBinding_2.addColumnBinding(claimHistory04BeanProperty_2)
				.setColumnName("\u9805\u76EE");
		//
		BeanProperty<ClaimHistory04, String> claimHistory04BeanProperty_3 = BeanProperty
				.create("r_cl_deform_perc");
		jTableBinding_2.addColumnBinding(claimHistory04BeanProperty_3)
				.setColumnName("\u6BD4\u4F8B");
		//
		BeanProperty<ClaimHistory04, String> claimHistory04BeanProperty_4 = BeanProperty
				.create("r_cl_days");
		jTableBinding_2.addColumnBinding(claimHistory04BeanProperty_4)
				.setColumnName("\u5929\u6578");
		//
		BeanProperty<ClaimHistory04, String> claimHistory04BeanProperty_5 = BeanProperty
				.create("r_cl_multiple");
		jTableBinding_2.addColumnBinding(claimHistory04BeanProperty_5)
				.setColumnName("\u500D\u6578");
		//
		BeanProperty<ClaimHistory04, String> claimHistory04BeanProperty_6 = BeanProperty
				.create("r_cl_dividend");
		jTableBinding_2.addColumnBinding(claimHistory04BeanProperty_6)
				.setColumnName("\u5206\u5B50");
		//
		BeanProperty<ClaimHistory04, String> claimHistory04BeanProperty_7 = BeanProperty
				.create("r_cl_divisor");
		jTableBinding_2.addColumnBinding(claimHistory04BeanProperty_7)
				.setColumnName("\u5206\u6BCD");
		//
		BeanProperty<ClaimHistory04, String> claimHistory04BeanProperty_8 = BeanProperty
				.create("r_cl_terms");
		jTableBinding_2.addColumnBinding(claimHistory04BeanProperty_8)
				.setColumnName("\u7B2C\u6B21");
		//
		BeanProperty<ClaimHistory04, String> claimHistory04BeanProperty_9 = BeanProperty
				.create("r_claim_amt");
		jTableBinding_2.addColumnBinding(claimHistory04BeanProperty_9)
				.setColumnName("\u7406\u8CE0\u91D1\u984D");
		//
		jTableBinding_2.setEditable(false);
		jTableBinding_2.bind();
		//
		BeanProperty<ClaimHistory05Group, List<ClaimHistory05>> claimHistory05GroupBeanProperty = BeanProperty
				.create("claimHistory05s");
		JTableBinding<ClaimHistory05, ClaimHistory05Group, JTable> jTableBinding_3 = SwingBindings
				.createJTableBinding(UpdateStrategy.READ, history05Group,
						claimHistory05GroupBeanProperty, table_3);
		//
		BeanProperty<ClaimHistory05, String> claimHistory05BeanProperty = BeanProperty
				.create("r_benf_id");
		jTableBinding_3.addColumnBinding(claimHistory05BeanProperty)
				.setColumnName("\u53D7\u76CA\u4EBAID");
		//
		BeanProperty<ClaimHistory05, String> claimHistory05BeanProperty_1 = BeanProperty
				.create("r_benf_name");
		jTableBinding_3.addColumnBinding(claimHistory05BeanProperty_1)
				.setColumnName("\u59D3\u540D");
		//
		BeanProperty<ClaimHistory05, String> claimHistory05BeanProperty_2 = BeanProperty
				.create("r_i1_rela_with_benf");
		jTableBinding_3.addColumnBinding(claimHistory05BeanProperty_2)
				.setColumnName("\u95DC\u4FC2").setEditable(false);
		//
		BeanProperty<ClaimHistory05, String> claimHistory05BeanProperty_3 = BeanProperty
				.create("r_country_desc");
		jTableBinding_3.addColumnBinding(claimHistory05BeanProperty_3)
				.setColumnName("\u570B\u7C4D");
		//
		ELProperty<ClaimHistory05, Object> claimHistory05EvalutionProperty = ELProperty
				.create("${r_cl_dividend} / ${r_cl_divisor}");
		jTableBinding_3.addColumnBinding(claimHistory05EvalutionProperty)
				.setColumnName("\u4FDD\u96AA\u91D1\u6BD4\u7387");
		//
		BeanProperty<ClaimHistory05, String> claimHistory05BeanProperty_4 = BeanProperty
				.create("r_claim_amt");
		jTableBinding_3.addColumnBinding(claimHistory05BeanProperty_4)
				.setColumnName("\u7D66\u4ED8\u5C0F\u8A08");
		//
		BeanProperty<ClaimHistory05, String> claimHistory05BeanProperty_5 = BeanProperty
				.create("r_defer_int");
		jTableBinding_3.addColumnBinding(claimHistory05BeanProperty_5)
				.setColumnName("\u5EF6\u6EEF\u5229\u606F");
		//
		BeanProperty<ClaimHistory05, String> claimHistory05BeanProperty_6 = BeanProperty
				.create("r_tax_withheld");
		jTableBinding_3.addColumnBinding(claimHistory05BeanProperty_6)
				.setColumnName("\u6240\u5F97\u7A05");
		//
		BeanProperty<ClaimHistory05, String> claimHistory05BeanProperty_7 = BeanProperty
				.create("r_addition_premium");
		jTableBinding_3.addColumnBinding(claimHistory05BeanProperty_7)
				.setColumnName("\u88DC\u5145\u4FDD\u8CBB");
		//
		BeanProperty<ClaimHistory05, String> claimHistory05BeanProperty_8 = BeanProperty
				.create("r_disb_amt");
		jTableBinding_3.addColumnBinding(claimHistory05BeanProperty_8)
				.setColumnName("\u7D66\u4ED8\u91D1\u984D");
		//
		BeanProperty<ClaimHistory05, String> claimHistory05BeanProperty_9 = BeanProperty
				.create("r_remit_account");
		jTableBinding_3.addColumnBinding(claimHistory05BeanProperty_9)
				.setColumnName("\u5E33\u865F");
		//
		jTableBinding_3.setEditable(false);
		jTableBinding_3.bind();
		//
		BeanProperty<ClaimHistory06Group, List<ClaimHistory06>> claimHistory06GroupBeanProperty = BeanProperty
				.create("claimHistory06s");
		JTableBinding<ClaimHistory06, ClaimHistory06Group, JTable> jTableBinding_4 = SwingBindings
				.createJTableBinding(UpdateStrategy.READ, history06Group,
						claimHistory06GroupBeanProperty, table_4);
		//
		BeanProperty<ClaimHistory06, String> claimHistory06BeanProperty = BeanProperty
				.create("r_plan_abbr_code");
		jTableBinding_4.addColumnBinding(claimHistory06BeanProperty)
				.setColumnName("\u96AA\u7A2E\u7C21\u7A31");
		//
		BeanProperty<ClaimHistory06, String> claimHistory06BeanProperty_1 = BeanProperty
				.create("r_rate_scale");
		jTableBinding_4.addColumnBinding(claimHistory06BeanProperty_1)
				.setColumnName("\u7248\u6578");
		//
		BeanProperty<ClaimHistory06, String> claimHistory06BeanProperty_2 = BeanProperty
				.create("r_cl_notice_code");
		jTableBinding_4.addColumnBinding(claimHistory06BeanProperty_2)
				.setColumnName("\u62D2\u8CE0\u539F\u56E0\u78BC");
		//
		BeanProperty<ClaimHistory06, String> claimHistory06BeanProperty_3 = BeanProperty
				.create("r_cl_notice_desc1");
		jTableBinding_4.addColumnBinding(claimHistory06BeanProperty_3)
				.setColumnName("\u62D2\u8CE0\u4EE3\u78BC\u63CF\u8FF0")
				.setColumnClass(String.class);
		//
		jTableBinding_4.setEditable(false);
		jTableBinding_4.bind();
		//
		BeanProperty<ClaimHistory07Group, List<ClaimHistory07>> claimHistory07GroupBeanProperty = BeanProperty
				.create("claimHistory07s");
		JTableBinding<ClaimHistory07, ClaimHistory07Group, JTable> jTableBinding_5 = SwingBindings
				.createJTableBinding(UpdateStrategy.READ, history07Group,
						claimHistory07GroupBeanProperty, table_5);
		//
		BeanProperty<ClaimHistory07, String> claimHistory07BeanProperty = BeanProperty
				.create("claim_item");
		jTableBinding_5.addColumnBinding(claimHistory07BeanProperty)
				.setColumnName("\u7406\u8CE0\u9805\u76EE");
		//
		BeanProperty<ClaimHistory07, String> claimHistory07BeanProperty_1 = BeanProperty
				.create("claim_code");
		jTableBinding_5.addColumnBinding(claimHistory07BeanProperty_1)
				.setColumnName("\u4EE3\u78BC");
		//
		ELProperty<ClaimHistory07, Object> claimHistory07EvalutionProperty = ELProperty
				.create("#{claim_desc}#{claim_desc2}#{claim_desc3}");
		jTableBinding_5.addColumnBinding(claimHistory07EvalutionProperty)
				.setColumnName("\u4EE3\u78BC\u63CF\u8FF0")
				.setColumnClass(String.class);
		//
		BeanProperty<ClaimHistory07, String> claimHistory07BeanProperty_2 = BeanProperty
				.create("claim_level1");
		jTableBinding_5.addColumnBinding(claimHistory07BeanProperty_2)
				.setColumnName(
						"%\uFF0F\u6E96\u5247\uFF0F\u71D2\u50B7\u7A0B\u5EA6");
		//
		BeanProperty<ClaimHistory07, String> claimHistory07BeanProperty_3 = BeanProperty
				.create("claim_level2");
		jTableBinding_5.addColumnBinding(claimHistory07BeanProperty_3)
				.setColumnName("\u6B98\u5EE2\u7B49\u7D1A\uFF0F\u500D\u6578");
		//
		jTableBinding_5.setEditable(false);
		jTableBinding_5.bind();
		//
		BeanProperty<ClaimHistory08Group, List<ClaimHistory08>> claimHistory08GroupBeanProperty = BeanProperty
				.create("claimHistory08s");
		JTableBinding<ClaimHistory08, ClaimHistory08Group, JTable> jTableBinding_6 = SwingBindings
				.createJTableBinding(UpdateStrategy.READ, history08Group,
						claimHistory08GroupBeanProperty, table_6);
		//
		BeanProperty<ClaimHistory08, String> claimHistory08BeanProperty = BeanProperty
				.create("hi_hospital_id");
		jTableBinding_6.addColumnBinding(claimHistory08BeanProperty)
				.setColumnName("\u91AB\u9662\u4EE3\u78BC");
		//
		BeanProperty<ClaimHistory08, String> claimHistory08BeanProperty_1 = BeanProperty
				.create("hi_hospital_name");
		jTableBinding_6.addColumnBinding(claimHistory08BeanProperty_1)
				.setColumnName("\u91AB\u9662\u540D\u7A31");
		//
		BeanProperty<ClaimHistory08, String> claimHistory08BeanProperty_2 = BeanProperty
				.create("remark");
		jTableBinding_6.addColumnBinding(claimHistory08BeanProperty_2)
				.setColumnName("\u8A3B\u8A18");
		//
		ELProperty<ClaimHistory08, Object> claimHistory08EvalutionProperty_2 = ELProperty
				.create("#{clmd_code}#{clmd_desc}");
		jTableBinding_6.addColumnBinding(claimHistory08EvalutionProperty_2)
				.setColumnName("\u79D1\u5225");
		//
		BeanProperty<ClaimHistory08, String> claimHistory08BeanProperty_3 = BeanProperty
				.create("doctor_name");
		jTableBinding_6.addColumnBinding(claimHistory08BeanProperty_3)
				.setColumnName("\u91AB\u5E2B\u59D3\u540D");
		//
		BeanProperty<ClaimHistory08, String> claimHistory08BeanProperty_4 = BeanProperty
				.create("doctor_id");
		jTableBinding_6.addColumnBinding(claimHistory08BeanProperty_4)
				.setColumnName("\u91AB\u5E2B\u8EAB\u5206\u8B49\u865F");
		//
		jTableBinding_6.setEditable(false);
		jTableBinding_6.bind();
		//
		BeanProperty<ClaimHistory09Group, List<ClaimHistory09>> claimHistory09GroupBeanProperty = BeanProperty
				.create("claimHistory09s");
		JTableBinding<ClaimHistory09, ClaimHistory09Group, JTable> jTableBinding_7 = SwingBindings
				.createJTableBinding(UpdateStrategy.READ, history09Group,
						claimHistory09GroupBeanProperty, table_7);
		//
		BeanProperty<ClaimHistory09, String> claimHistory09BeanProperty = BeanProperty
				.create("hi_hospital_id");
		jTableBinding_7.addColumnBinding(claimHistory09BeanProperty)
				.setColumnName("\u91AB\u9662\u4EE3\u78BC");
		//
		BeanProperty<ClaimHistory09, String> claimHistory09BeanProperty_1 = BeanProperty
				.create("hi_hospital_name");
		jTableBinding_7.addColumnBinding(claimHistory09BeanProperty_1)
				.setColumnName("\u91AB\u9662\u540D\u7A31");
		//
		BeanProperty<ClaimHistory09, String> claimHistory09BeanProperty_2 = BeanProperty
				.create("remark");
		jTableBinding_7.addColumnBinding(claimHistory09BeanProperty_2)
				.setColumnName("\u8A3B\u8A18");
		//
		ELProperty<ClaimHistory09, Object> claimHistory09EvalutionProperty = ELProperty
				.create("#{cl_hs_date_1}~#{cl_hs_date_2}");
		jTableBinding_7.addColumnBinding(claimHistory09EvalutionProperty)
				.setColumnName("\u4F4F\u9662\u8D77\u8A16");
		//
		BeanProperty<ClaimHistory09, Integer> claimHistory09BeanProperty_3 = BeanProperty
				.create("period");
		jTableBinding_7.addColumnBinding(claimHistory09BeanProperty_3)
				.setColumnName("\u5929\u6578");
		//
		jTableBinding_7.setEditable(false);
		jTableBinding_7.bind();
		//
		BeanProperty<ClaimHistory10Group, List<ClaimHistory10>> claimHistory10GroupBeanProperty = BeanProperty
				.create("claimHistory10s");
		JTableBinding<ClaimHistory10, ClaimHistory10Group, JTable> jTableBinding_8 = SwingBindings
				.createJTableBinding(UpdateStrategy.READ, history10Group,
						claimHistory10GroupBeanProperty, table_8);
		//
		BeanProperty<ClaimHistory10, String> claimHistory10BeanProperty = BeanProperty
				.create("cl_comment_code");
		jTableBinding_8.addColumnBinding(claimHistory10BeanProperty)
				.setColumnName("\u8A3B\u8A18\u4EE3\u78BC");
		//
		BeanProperty<ClaimHistory10, String> claimHistory10BeanProperty_1 = BeanProperty
				.create("cl_comment_desc");
		jTableBinding_8.addColumnBinding(claimHistory10BeanProperty_1)
				.setColumnName("\u8A3B\u8A18\u4EE3\u78BC\u63CF\u8FF0");
		//
		jTableBinding_8.setEditable(false);
		jTableBinding_8.bind();
		//
		BeanProperty<ClaimHistory02eventGroup, List<ClaimHistory02event>> claimHistory02eventGroupBeanProperty = BeanProperty
				.create("claimHistory02events");
		JTableBinding<ClaimHistory02event, ClaimHistory02eventGroup, JTable> jTableBinding_9 = SwingBindings
				.createJTableBinding(UpdateStrategy.READ, history02eventGroup,
						claimHistory02eventGroupBeanProperty, table_9);
		//
		BeanProperty<ClaimHistory02event, String> claimHistory02eventBeanProperty = BeanProperty
				.create("cl_event_code");
		jTableBinding_9.addColumnBinding(claimHistory02eventBeanProperty)
				.setColumnName("\u4E8B\u6545\u539F\u56E0");
		//
		BeanProperty<ClaimHistory02event, String> claimHistory02eventBeanProperty_1 = BeanProperty
				.create("cl_event_desc");
		jTableBinding_9.addColumnBinding(claimHistory02eventBeanProperty_1)
				.setColumnName("\u4EE3\u78BC\u63CF\u8FF0");
		//
		jTableBinding_9.bind();
		//
		JTableBinding<ClaimHistory02event, ClaimHistory02eventGroup, JTable> jTableBinding_10 = SwingBindings
				.createJTableBinding(UpdateStrategy.READ, history02sickGroup,
						claimHistory02eventGroupBeanProperty, table_10);
		//
		BeanProperty<ClaimHistory02event, String> claimHistory02eventBeanProperty_2 = BeanProperty
				.create("cl_event_code");
		jTableBinding_10.addColumnBinding(claimHistory02eventBeanProperty_2)
				.setColumnName("\u8A3B\u8A18\u75C5\u53F2");
		//
		BeanProperty<ClaimHistory02event, String> claimHistory02eventBeanProperty_3 = BeanProperty
				.create("cl_event_desc");
		jTableBinding_10.addColumnBinding(claimHistory02eventBeanProperty_3)
				.setColumnName("\u4EE3\u78BC\u63CF\u8FF0");
		//
		jTableBinding_10.bind();
		//
		BeanProperty<ClaimHistory12Group, List<ClaimHistory12>> claimHistory12GroupBeanProperty = BeanProperty
				.create("claimHistory12s");
		JTableBinding<ClaimHistory12, ClaimHistory12Group, JTable> jTableBinding_11 = SwingBindings
				.createJTableBinding(UpdateStrategy.READ, history12Group,
						claimHistory12GroupBeanProperty, table_11);
		//
		BeanProperty<ClaimHistory12, String> claimHistory12BeanProperty = BeanProperty
				.create("r_desc");
		jTableBinding_11.addColumnBinding(claimHistory12BeanProperty)
				.setColumnName("\u9805\u76EE");
		//
		BeanProperty<ClaimHistory12, String> claimHistory12BeanProperty_1 = BeanProperty
				.create("r_beg_date");
		jTableBinding_11.addColumnBinding(claimHistory12BeanProperty_1)
				.setColumnName("\u8D77\u65E5");
		//
		BeanProperty<ClaimHistory12, String> claimHistory12BeanProperty_2 = BeanProperty
				.create("r_beg_time");
		jTableBinding_11.addColumnBinding(claimHistory12BeanProperty_2)
				.setColumnName("\u6642\u9593");
		//
		BeanProperty<ClaimHistory12, String> claimHistory12BeanProperty_3 = BeanProperty
				.create("r_end_date");
		jTableBinding_11.addColumnBinding(claimHistory12BeanProperty_3)
				.setColumnName("\u8FC4\u65E5");
		//
		BeanProperty<ClaimHistory12, String> claimHistory12BeanProperty_7 = BeanProperty
				.create("r_end_time");
		jTableBinding_11.addColumnBinding(claimHistory12BeanProperty_7)
				.setColumnName("\u6642\u9593");
		//
		BeanProperty<ClaimHistory12, String> claimHistory12BeanProperty_4 = BeanProperty
				.create("r_clhd_day");
		jTableBinding_11.addColumnBinding(claimHistory12BeanProperty_4)
				.setColumnName("\u5929\u6578");
		//
		BeanProperty<ClaimHistory12, String> claimHistory12BeanProperty_5 = BeanProperty
				.create("r_clhd_hour");
		jTableBinding_11.addColumnBinding(claimHistory12BeanProperty_5)
				.setColumnName("\u6642\u6578");
		//
		BeanProperty<ClaimHistory12, String> claimHistory12BeanProperty_6 = BeanProperty
				.create("r_times");
		jTableBinding_11.addColumnBinding(claimHistory12BeanProperty_6)
				.setColumnName("\u6B21\u6578");
		//
		jTableBinding_11.bind();
	}
}
