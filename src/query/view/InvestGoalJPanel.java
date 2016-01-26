package query.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
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
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

import query.controller.InvestGoalController;
import query.model.InvestGoal.InvestGoal01;
import query.model.InvestGoal.InvestGoal02;
import query.model.InvestGoal.InvestGoal02Group;
import query.model.InvestGoal.InvestGoal04;
import query.model.InvestGoal.InvestGoal04Group;
import query.model.InvestGoal.InvestGoalInt;
import query.model.InvestGoal.InvestGoalIntGroup;

//修    改: 102.06.05 新增保單.投資標的報酬率上下限 by 冠瑜

public class InvestGoalJPanel extends JPanel implements ListSelectionListener {

	private static final long serialVersionUID = 1L;
	private VerticalPane investScrollPane1, investScrollPane2,
			investScrollPane3;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JTable table;
	private JTable table_1;
	private JTable tableInt;
	private InvestGoalController controller;

	private InvestGoal01 investGoal01 = new InvestGoal01();
	private InvestGoal02Group investGoal02Group = new InvestGoal02Group();
	private InvestGoal04Group investGoal04Group = new InvestGoal04Group();
	private InvestGoalIntGroup investGoalIntGroup = new InvestGoalIntGroup();
	private JTabbedPane tabbedPane;
	private JScrollPane scrollPane_2;
	private JPanel panel_2;
	private JLabel lblNewLabel;
	private JTextField txtCnt;
	private JTextField txtDividendDesc;
	private JLabel lblSumRate;
	private JTextField txtSumRate;
	private JLabel lblNewLabel_2;
	private JTextField txtSumAmt;
	private JPanel panel_3;
	private JPanel panel_4;
	private JScrollPane scrollPane_3;

	/**
	 * Create the panel.
	 */
	public InvestGoalJPanel() {
		setLayout(new BorderLayout(0, 0));
		// this.setSize(500, 600);
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u6295\u8CC7\u9918\u984D",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setPreferredSize(new Dimension(10, 186));
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 3, 0, 0));

		// 下左方Panel
		String[] headers1 = { "保單號碼", "SN報酬率", "帳戶報酬率", "待投入額", "贖回待付", "上下限%" };
		investScrollPane1 = new VerticalPane(headers1, "", 80, 25);
		panel.add(investScrollPane1);

		// 下右方Panel
		String[] headers2 = { "帳戶餘額", "總投入金額", "計算日期", "美元USD", "歐元EUR" };
		investScrollPane2 = new VerticalPane(headers2, "", 80, 25);
		panel.add(investScrollPane2);

		// 下右方Panel
		String[] headers3 = { "澳幣AUD", "紐幣NZD", "港幣HKD", "日圓JPY", "台幣TWD" };
		investScrollPane3 = new VerticalPane(headers3, "", 75, 25);
		panel.add(investScrollPane3);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\u6295\u8CC7\u6A19\u7684",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(2, 0, 0, 0));

		scrollPane = new JScrollPane();
		panel_1.add(scrollPane);

		// table = new TipJTable("點擊以顯示下方明細").getTable(); //JTable();
		table = new JTable();
		table.setToolTipText("點擊以顯示下方明細");

		table.setEnabled(true);
		scrollPane.setViewportView(table);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ListSelectionModel model = table.getSelectionModel();
		model.addListSelectionListener(this);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		panel_1.add(tabbedPane);
		scrollPane_1 = new JScrollPane();
		tabbedPane.addTab("\u6295\u8CC7\u9918\u984D", null, scrollPane_1, null);
		tabbedPane.setEnabledAt(0, true);
		// panel_1.add(scrollPane_1);

		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);

		panel_2 = new JPanel();
		scrollPane_2 = new JScrollPane();
		tabbedPane.addTab("\u6295\u8CC7\u6A19\u7684\u914D\u606F", null,
				scrollPane_2, null);
		tabbedPane.setEnabledAt(1, true);
		scrollPane_2.setViewportView(panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] { 0, 0 };
		gbl_panel_2.rowHeights = new int[] { 0, 202, 0 };
		gbl_panel_2.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel_2.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		panel_2.setLayout(gbl_panel_2);

		panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.anchor = GridBagConstraints.NORTH;
		gbc_panel_3.insets = new Insets(0, 0, 5, 0);
		gbc_panel_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 0;
		panel_2.add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[] { 24, 42, 42, 60, 96, 72, 96, 0 };
		gbl_panel_3.rowHeights = new int[] { 11, 0 };
		gbl_panel_3.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_3.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_3.setLayout(gbl_panel_3);

		lblNewLabel = new JLabel("\u7B46\u6578");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel_3.add(lblNewLabel, gbc_lblNewLabel);

		txtCnt = new JTextField();
		txtCnt.setEditable(false);
		GridBagConstraints gbc_txtCnt = new GridBagConstraints();
		gbc_txtCnt.anchor = GridBagConstraints.NORTHWEST;
		gbc_txtCnt.insets = new Insets(0, 0, 0, 5);
		gbc_txtCnt.gridx = 1;
		gbc_txtCnt.gridy = 0;
		panel_3.add(txtCnt, gbc_txtCnt);
		txtCnt.setColumns(4);

		txtDividendDesc = new JTextField();
		txtDividendDesc.setForeground(Color.BLUE);
		txtDividendDesc.setEditable(false);
		GridBagConstraints gbc_txtDividendDesc = new GridBagConstraints();
		gbc_txtDividendDesc.anchor = GridBagConstraints.NORTHWEST;
		gbc_txtDividendDesc.insets = new Insets(0, 0, 0, 5);
		gbc_txtDividendDesc.gridx = 2;
		gbc_txtDividendDesc.gridy = 0;
		panel_3.add(txtDividendDesc, gbc_txtDividendDesc);
		txtDividendDesc.setColumns(4);

		lblSumRate = new JLabel("\u7D2F\u7A4D\u914D\u606F\u7387");
		GridBagConstraints gbc_lblSumRate = new GridBagConstraints();
		gbc_lblSumRate.anchor = GridBagConstraints.WEST;
		gbc_lblSumRate.insets = new Insets(0, 0, 0, 5);
		gbc_lblSumRate.gridx = 3;
		gbc_lblSumRate.gridy = 0;
		panel_3.add(lblSumRate, gbc_lblSumRate);

		txtSumRate = new JTextField();
		txtSumRate.setEditable(false);
		GridBagConstraints gbc_txtSumRate = new GridBagConstraints();
		gbc_txtSumRate.anchor = GridBagConstraints.NORTHWEST;
		gbc_txtSumRate.insets = new Insets(0, 0, 0, 5);
		gbc_txtSumRate.gridx = 4;
		gbc_txtSumRate.gridy = 0;
		panel_3.add(txtSumRate, gbc_txtSumRate);
		txtSumRate.setColumns(10);

		lblNewLabel_2 = new JLabel("\u7D2F\u7A4D\u914D\u606F\u91D1\u984D");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_2.gridx = 5;
		gbc_lblNewLabel_2.gridy = 0;
		panel_3.add(lblNewLabel_2, gbc_lblNewLabel_2);

		txtSumAmt = new JTextField();
		txtSumAmt.setEditable(false);
		GridBagConstraints gbc_txtSumAmt = new GridBagConstraints();
		gbc_txtSumAmt.anchor = GridBagConstraints.NORTHWEST;
		gbc_txtSumAmt.gridx = 6;
		gbc_txtSumAmt.gridy = 0;
		panel_3.add(txtSumAmt, gbc_txtSumAmt);
		txtSumAmt.setColumns(10);

		panel_4 = new JPanel();
		panel_4.setPreferredSize(new Dimension(10, 150));
		panel_4.setMaximumSize(new Dimension(32767, 100));
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 0;
		gbc_panel_4.gridy = 1;
		panel_2.add(panel_4, gbc_panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));

		tableInt = new JTable();
		// panel_4.add(tableInt);

		scrollPane_3 = new JScrollPane();
		panel_4.add(scrollPane_3);
		scrollPane_3.setViewportView(tableInt);

		// tabbedPane.addTab("New tab", null, panel_2, null);
		tabbedPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				getNewData();
				// int rowSelect = tabbedPane.getSelectedIndex();
				// if (rowSelect >0 )
				// controller.executeMissionTabValues(rowSelect);
			}
		});

		// table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// ListSelectionModel model = table_1.getSelectionModel();
		// model.addListSelectionListener(this);

		initDataBindings();

		TableColumn headerCol;
		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		headerCol = table.getColumnModel().getColumn(0); // 序號欄位
		headerCol.setMaxWidth(50);

		headerCol = table.getColumnModel().getColumn(1); // 標的代碼欄位
		// headerCol.setMaxWidth(80);
		headerCol.setPreferredWidth(70);

		headerCol = table.getColumnModel().getColumn(2); // 投資標的欄位
		headerCol.setPreferredWidth(120);

		headerCol = table.getColumnModel().getColumn(8); // 報酬率欄位
		headerCol.setMaxWidth(80);

		headerCol = table.getColumnModel().getColumn(9); // 上限欄位
		headerCol.setMaxWidth(60);
		headerCol.setCellRenderer(centerRenderer);

		headerCol = table.getColumnModel().getColumn(10); // 下限欄位
		headerCol.setMaxWidth(60);
		headerCol.setCellRenderer(centerRenderer);

		headerCol = table.getColumnModel().getColumn(11); // 幣別
		headerCol.setMaxWidth(60);
		headerCol.setCellRenderer(centerRenderer);

		int i = 3;
		for (i = 3; i <= 8; i++) {
			headerCol = table.getColumnModel().getColumn(i);
			headerCol.setCellRenderer(rightRenderer);
			headerCol.setPreferredWidth(100);
			headerCol.setMaxWidth(120);
		}
		// 保單幣別欄位加黃底色
		table.getColumnModel().getColumn(6)
				.setCellRenderer(new DefaultTableCellRenderer() {

					@Override
					public Component getTableCellRendererComponent(
							JTable table, Object value, boolean isSelected,
							boolean hasFocus, int row, int column) {
						// TODO Auto-generated method stub
						setForeground(Color.black);
						// 再靠右
						setHorizontalAlignment(SwingConstants.RIGHT);
						setValue(value);
						setBackground(Color.yellow);
						if (isSelected){							
							setBackground(table.getSelectionBackground());
							setForeground(table.getSelectionForeground());
						}
						return this;
					}
				});

		// 投資餘額
		headerCol = table_1.getColumnModel().getColumn(0); //
		headerCol.setMaxWidth(85);
		headerCol = table_1.getColumnModel().getColumn(1); //
		headerCol.setMaxWidth(50);
		headerCol = table_1.getColumnModel().getColumn(2); //
		headerCol.setMaxWidth(85);
		headerCol = table_1.getColumnModel().getColumn(3); //
		headerCol.setPreferredWidth(90);
		headerCol.setMaxWidth(100);
		headerCol = table_1.getColumnModel().getColumn(4); //
		headerCol.setMaxWidth(95);
		headerCol = table_1.getColumnModel().getColumn(5); //
		headerCol.setMaxWidth(95);
		headerCol = table_1.getColumnModel().getColumn(6); //
		headerCol.setPreferredWidth(90);
		headerCol.setMaxWidth(100);
		for (i = 8; i <= 10; i++) {
			headerCol = table_1.getColumnModel().getColumn(i);
			headerCol.setCellRenderer(rightRenderer);
		}
		for (i = 4; i <= 7; i++) {
			headerCol = table_1.getColumnModel().getColumn(i);
			headerCol.setCellRenderer(centerRenderer);
		}

		// 配息
		for (i = 2; i <= 7; i++) {
			headerCol = tableInt.getColumnModel().getColumn(i);
			headerCol.setCellRenderer(rightRenderer);
		}
		// int i = 3;
		// for (i=3;i<=8;i++)
		// {
		// // table.getColumn(table.getColumnName(2)).setCellRenderer( 金錢靠右
		// table.getColumnModel().getColumn(i).setCellRenderer(
		// new DefaultTableCellRenderer() {
		//
		// private static final long serialVersionUID = 1L;
		//
		// public Component getTableCellRendererComponent(
		// JTable table, Object value, boolean isSelected,
		// boolean hasFocus, int row, int column) {
		// // Setup default cell attribute
		// setHorizontalAlignment(JLabel.RIGHT);
		// setValue(value==null?"":value.toString());
		// // setEnabled(true);
		// return this;
		// }
		// });
		// }

		table.setEnabled(true);
	}

	public void setController(InvestGoalController controller) {
		this.controller = controller;
	}

	public void addInvestGoal02(InvestGoal02 goal02) {
		investGoal02Group.addInvestGoal02(goal02);
	}

	public void addInvestGoal04(InvestGoal04 goal04) {
		investGoal04Group.addInvestGoal04(goal04);
	}

	public void addInvestGoalInt(InvestGoalInt goalInt) {
		investGoalIntGroup.addInvestGoalInt(goalInt);
	}

	public void clearAll() {
		investGoal02Group.removeAll();
		investGoal04Group.removeAll();
		investScrollPane1.setValue(new String[] { "", "", "", "", "", "" });
		investScrollPane2.setValue(new String[] { "", "", "", "", "" });
		investScrollPane3.setValue(new String[] { "", "", "", "" });
		tabbedPane.setEnabledAt(1, true);
		txtCnt.setText("");
		txtDividendDesc.setText("");
		txtSumRate.setText("");
		txtSumAmt.setText("");
	}

	public void setInvestGoal01(HashMap<String, String> hsmp) {
		investGoal01.setValues(hsmp);
		investScrollPane1.setValue(investGoal01.getColumn1Values());
		investScrollPane2.setValue(investGoal01.getColumn2Values());
		investScrollPane3.setValue(investGoal01.getColumn3Values());
	}

	public void setDefaultRow() {
		if (table.getRowCount() > 0) {
			ListSelectionModel selectionModel = table.getSelectionModel();
			selectionModel.setSelectionInterval(0, 0);
			// getNewData();
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// if (e.getValueIsAdjusting()) {
		if (!((DefaultListSelectionModel) e.getSource()).getValueIsAdjusting()) {
			getNewData();

			// // System.out.println("change");
			// int rowSelected = table.getSelectedRow();
			// if (rowSelected >= 0) {
			// int tabSelect = tabbedPane.getSelectedIndex(); //tab分頁
			// String invs_code = null, invs_name = null;
			// if (tabSelect == 0 ){
			// invs_code = investGoal02Group.getInvestGoal02s()
			// .get(rowSelected).getR_invs_code();
			// invs_name = investGoal02Group.getInvestGoal02s()
			// .get(rowSelected).getR_invs_name();
			// }
			// controller.executeMissionGoal03(invs_code, invs_name,tabSelect);
			// // System.out.println("change get");
			//
			// // System.out.println("change end");
			// }
		}
	}

	public void getNewData() {
		int rowSelected = table.getSelectedRow();
		if (rowSelected >= 0) {
			int tabSelect = tabbedPane.getSelectedIndex(); // tab分頁
			String invs_code = null, invs_name = null;
			// if (tabSelect == 0 ){
			invs_code = investGoal02Group.getInvestGoal02s().get(rowSelected)
					.getR_invs_code();
			invs_name = investGoal02Group.getInvestGoal02s().get(rowSelected)
					.getR_invs_name();

			if (investGoal02Group.getInvestGoal02s().get(rowSelected)
					.getR_dividend_calc().equals("N")) {
				tabbedPane.setSelectedIndex(0);
				tabbedPane.setEnabledAt(1, false);
			} else
				tabbedPane.setEnabledAt(1, true);
			// }
			controller.executeMissionGoal03(invs_code, invs_name, tabSelect);
		}
	}

	public void setSumData(String cnt, String dividend_desc, String sum_amt,
			String sum_rate) {
		txtCnt.setText(cnt);
		txtDividendDesc.setText(dividend_desc);
		txtSumAmt.setText(sum_amt);
		txtSumRate.setText(sum_rate);
		int rowSelected = table.getSelectedRow();
		System.out.println("sum"
				+ investGoal02Group.getInvestGoal02s().get(rowSelected)
						.getR_dividend_calc() + rowSelected);
		// if (dividend_desc.equals("除息")){
		if (investGoal02Group.getInvestGoal02s().get(rowSelected)
				.getR_dividend_calc().equals("2")) {
			lblSumRate.setText("累積配息率");
			tableInt.getColumnModel().getColumn(0).setHeaderValue("紅利周年日");
			// 隱藏 配息單位
			tableInt.getColumnModel().getColumn(7).setMinWidth(0);
			tableInt.getColumnModel().getColumn(7).setMaxWidth(0);

		} else if (investGoal02Group.getInvestGoal02s().get(rowSelected)
				.getR_dividend_calc().equals("3")) {
			lblSumRate.setText("累積配息率");
			tableInt.getColumnModel().getColumn(0).setHeaderValue("付息日");
			// 隱藏 配息單位
			tableInt.getColumnModel().getColumn(7).setMinWidth(0);
			tableInt.getColumnModel().getColumn(7).setMaxWidth(0);
		} else {
			lblSumRate.setText("累積配息單位");
			tableInt.getColumnModel().getColumn(0).setHeaderValue("交易編號");
			tableInt.getColumnModel().getColumn(7).setMinWidth(100);
			tableInt.getColumnModel().getColumn(7).setMaxWidth(250);
			tableInt.getColumnModel().getColumn(7).setPreferredWidth(130);
		}

	}

	public void cleanAllo4group() {
		investGoal04Group.removeAll();
		investGoalIntGroup.removeAll();
	}

	/**
	 * 將全域變數全部指向NULL,利於JAVA記憶體回收系統回收記憶體
	 */
	public void nullAll() {
		investGoal01 = null;
		investGoal02Group = null;
		investGoal04Group = null;
		investGoalIntGroup = null;
	}

	protected void initDataBindings() {
		BeanProperty<InvestGoal02Group, List<InvestGoal02>> investGoal02GroupBeanProperty = BeanProperty
				.create("investGoal02s");
		JTableBinding<InvestGoal02, InvestGoal02Group, JTable> jTableBinding = SwingBindings
				.createJTableBinding(UpdateStrategy.READ, investGoal02Group,
						investGoal02GroupBeanProperty, table);
		//
		BeanProperty<InvestGoal02, String> investGoal02BeanProperty = BeanProperty
				.create("r_seq");
		jTableBinding.addColumnBinding(investGoal02BeanProperty).setColumnName(
				"\u5E8F\u865F");
		//
		BeanProperty<InvestGoal02, String> investGoal02BeanProperty_1 = BeanProperty
				.create("r_invs_code");
		jTableBinding.addColumnBinding(investGoal02BeanProperty_1)
				.setColumnName("\u6A19\u7684\u4EE3\u78BC");
		//
		BeanProperty<InvestGoal02, String> investGoal02BeanProperty_2 = BeanProperty
				.create("r_invs_name");
		jTableBinding.addColumnBinding(investGoal02BeanProperty_2)
				.setColumnName("\u6295\u8CC7\u6A19\u7684");
		//
		BeanProperty<InvestGoal02, String> investGoal02BeanProperty_3 = BeanProperty
				.create("r_invs_units");
		jTableBinding.addColumnBinding(investGoal02BeanProperty_3)
				.setColumnName("\u55AE\u4F4D");
		//
		BeanProperty<InvestGoal02, String> investGoal02BeanProperty_4 = BeanProperty
				.create("r_invs_value");
		jTableBinding.addColumnBinding(investGoal02BeanProperty_4)
				.setColumnName("\u55AE\u4F4D\u6DE8\u503C");
		//
		BeanProperty<InvestGoal02, String> investGoal02BeanProperty_13 = BeanProperty
				.create("r_invs_amt");
		jTableBinding.addColumnBinding(investGoal02BeanProperty_13)
				.setColumnName("標的價值(原幣)");
		//
		BeanProperty<InvestGoal02, String> investGoal02BeanProperty_5 = BeanProperty
				.create("r_invs_amt_nt");
		jTableBinding.addColumnBinding(investGoal02BeanProperty_5)
				.setColumnName("\u6A19\u7684\u50F9\u503C(台幣)");
		//
		BeanProperty<InvestGoal02, String> investGoal02BeanProperty_6 = BeanProperty
				.create("r_invs_avg_cost");
		jTableBinding.addColumnBinding(investGoal02BeanProperty_6)
				.setColumnName("\u5E73\u5747\u6210\u672C");
		//
		BeanProperty<InvestGoal02, String> investGoal02BeanProperty_7 = BeanProperty
				.create("r_invs_amt_cost");
		jTableBinding.addColumnBinding(investGoal02BeanProperty_7)
				.setColumnName("\u6295\u5165\u91D1\u984D");
		//
		BeanProperty<InvestGoal02, String> investGoal02BeanProperty_8 = BeanProperty
				.create("r_invs_invs_rate");
		jTableBinding.addColumnBinding(investGoal02BeanProperty_8)
				.setColumnName("\u5831\u916C\u7387%");
		//
		BeanProperty<InvestGoal02, String> investGoal02BeanProperty_9 = BeanProperty
				.create("r_invs_upper");
		jTableBinding.addColumnBinding(investGoal02BeanProperty_9)
				.setColumnName("\u4E0A\u9650%");
		//
		BeanProperty<InvestGoal02, String> investGoal02BeanProperty_10 = BeanProperty
				.create("r_invs_lower");
		jTableBinding.addColumnBinding(investGoal02BeanProperty_10)
				.setColumnName("\u4E0B\u9650%");
		//
		BeanProperty<InvestGoal02, String> investGoal02BeanProperty_11 = BeanProperty
				.create("r_invs_currency");
		jTableBinding.addColumnBinding(investGoal02BeanProperty_11)
				.setColumnName("\u5E63\u5225");
		//
		BeanProperty<InvestGoal02, String> investGoal02BeanProperty_12 = BeanProperty
				.create("r_invs_risk_degree");
		jTableBinding.addColumnBinding(investGoal02BeanProperty_12)
				.setColumnName("風險等級");
		//
		jTableBinding.setEditable(false);
		jTableBinding.bind();
		//
		BeanProperty<InvestGoal04Group, List<InvestGoal04>> investGoal04GroupBeanProperty = BeanProperty
				.create("investGoal04s");
		JTableBinding<InvestGoal04, InvestGoal04Group, JTable> jTableBinding_1 = SwingBindings
				.createJTableBinding(UpdateStrategy.READ, investGoal04Group,
						investGoal04GroupBeanProperty, table_1);
		//
		BeanProperty<InvestGoal04, String> investGoal04BeanProperty = BeanProperty
				.create("r_invs_code");
		jTableBinding_1.addColumnBinding(investGoal04BeanProperty)
				.setColumnName("\u6A19\u7684\u4EE3\u78BC");
		//
		BeanProperty<InvestGoal04, String> investGoal04BeanProperty_1 = BeanProperty
				.create("r_seq");
		jTableBinding_1.addColumnBinding(investGoal04BeanProperty_1)
				.setColumnName("\u865F\u78BC");
		//
		BeanProperty<InvestGoal04, String> investGoal04BeanProperty_2 = BeanProperty
				.create("r_invs_bl_date");
		jTableBinding_1.addColumnBinding(investGoal04BeanProperty_2)
				.setColumnName("\u9918\u984D\u65E5");
		//
		BeanProperty<InvestGoal04, String> investGoal04BeanProperty_3 = BeanProperty
				.create("r_entry_no");
		jTableBinding_1.addColumnBinding(investGoal04BeanProperty_3)
				.setColumnName("\u767B\u5165\u5E8F\u865F");
		//
		BeanProperty<InvestGoal04, String> investGoal04BeanProperty_4 = BeanProperty
				.create("r_invs_ad_ind");
		jTableBinding_1.addColumnBinding(investGoal04BeanProperty_4)
				.setColumnName("\u7570\u52D5\u4EE3\u78BC");
		//
		BeanProperty<InvestGoal04, String> investGoal04BeanProperty_5 = BeanProperty
				.create("r_invs_ad_desc1");
		jTableBinding_1.addColumnBinding(investGoal04BeanProperty_5)
				.setColumnName("\u7570\u52D5\u6307\u793A");
		//
		BeanProperty<InvestGoal04, String> investGoal04BeanProperty_6 = BeanProperty
				.create("r_invs_ad_sub_ind");
		jTableBinding_1.addColumnBinding(investGoal04BeanProperty_6)
				.setColumnName("\u7570\u52D5\u6B21\u6307\u793A");
		//
		BeanProperty<InvestGoal04, String> investGoal04BeanProperty_7 = BeanProperty
				.create("r_invs_ad_desc2");
		jTableBinding_1.addColumnBinding(investGoal04BeanProperty_7)
				.setColumnName("\u7570\u52D5\u6B21\u6307\u793A\u4EE3\u78BC");
		//
		BeanProperty<InvestGoal04, String> investGoal04BeanProperty_8 = BeanProperty
				.create("r_invs_units");
		jTableBinding_1.addColumnBinding(investGoal04BeanProperty_8)
				.setColumnName("\u55AE\u4F4D\u6578");
		//
		BeanProperty<InvestGoal04, String> investGoal04BeanProperty_9 = BeanProperty
				.create("r_invs_value");
		jTableBinding_1.addColumnBinding(investGoal04BeanProperty_9)
				.setColumnName("\u55AE\u4F4D\u6DE8\u503C");
		//
		BeanProperty<InvestGoal04, String> investGoal04BeanProperty_10 = BeanProperty
				.create("r_invs_avg_cost");
		jTableBinding_1.addColumnBinding(investGoal04BeanProperty_10)
				.setColumnName("\u5E73\u5747\u6210\u672C");
		//
		jTableBinding_1.setEditable(false);
		jTableBinding_1.bind();
		//
		BeanProperty<InvestGoalIntGroup, List<InvestGoalInt>> investGoalIntGroupBeanProperty = BeanProperty
				.create("investGoalInts");
		JTableBinding<InvestGoalInt, InvestGoalIntGroup, JTable> jTableBinding_2 = SwingBindings
				.createJTableBinding(UpdateStrategy.READ, investGoalIntGroup,
						investGoalIntGroupBeanProperty, tableInt, "tableInt");
		//
		BeanProperty<InvestGoalInt, String> investGoalIntBeanProperty_7 = BeanProperty
				.create("invs_ad_no");
		jTableBinding_2.addColumnBinding(investGoalIntBeanProperty_7)
				.setColumnName("\u7D05\u5229\u9031\u5E74\u65E5");
		//
		BeanProperty<InvestGoalInt, String> investGoalIntBeanProperty = BeanProperty
				.create("invs_base_date");
		jTableBinding_2.addColumnBinding(investGoalIntBeanProperty)
				.setColumnName("\u914D\u606F\u65E5");
		//
		BeanProperty<InvestGoalInt, String> investGoalIntBeanProperty_1 = BeanProperty
				.create("invs_base_rate");
		jTableBinding_2.addColumnBinding(investGoalIntBeanProperty_1)
				.setColumnName("\u914D\u606F\u7387");
		//
		BeanProperty<InvestGoalInt, String> investGoalIntBeanProperty_2 = BeanProperty
				.create("exrt_rate");
		jTableBinding_2.addColumnBinding(investGoalIntBeanProperty_2)
				.setColumnName("\u532F\u7387");
		//
		BeanProperty<InvestGoalInt, String> investGoalIntBeanProperty_3 = BeanProperty
				.create("invs_value");
		jTableBinding_2.addColumnBinding(investGoalIntBeanProperty_3)
				.setColumnName("\u6DE8\u503C");
		//
		BeanProperty<InvestGoalInt, String> investGoalIntBeanProperty_4 = BeanProperty
				.create("invs_units");
		jTableBinding_2.addColumnBinding(investGoalIntBeanProperty_4)
				.setColumnName("\u6301\u6709\u55AE\u4F4D\u6578");
		//
		BeanProperty<InvestGoalInt, String> investGoalIntBeanProperty_5 = BeanProperty
				.create("invs_ad_amt");
		jTableBinding_2.addColumnBinding(investGoalIntBeanProperty_5)
				.setColumnName("\u914D\u606F\u91D1\u984D");
		//
		BeanProperty<InvestGoalInt, String> investGoalIntBeanProperty_6 = BeanProperty
				.create("diff_units");
		jTableBinding_2.addColumnBinding(investGoalIntBeanProperty_6)
				.setColumnName("\u914D\u606F\u55AE\u4F4D");
		//
		jTableBinding_2.setEditable(false);
		jTableBinding_2.bind();
	}
}
