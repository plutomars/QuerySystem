package query.view;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.HashMap;
import java.util.List;

import javax.swing.DefaultListSelectionModel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

import query.controller.InvestCashController;
import query.model.InvestCash.InvestCash01;
import query.model.InvestCash.InvestCash01Group;
import query.model.InvestCash.InvestCash02;
import query.model.InvestCash.InvestCash02Group;
import query.model.InvestCash.InvestCash03;
import query.model.InvestCash.InvestCash03Group;
import query.model.InvestCash.InvestCash04;
import query.model.InvestCash.InvestCash04Group;
import query.model.InvestCash.InvestCash05;
import query.model.InvestCash.InvestCash05Group;
import org.jdesktop.beansbinding.ObjectProperty;

/**
 * 現金流量
 * 
 * @author 陳冠瑜
 * 
 */
public class InvestCashJPanel extends JPanel { // implements
												// ListSelectionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTable table_1;
	private InvestCash01Group group01 = new InvestCash01Group();
	private InvestCash02Group group02 = new InvestCash02Group();
	private InvestCash03Group investcash03 = new InvestCash03Group();
	private InvestCash04Group investcash04group = new InvestCash04Group();
	private InvestCash05Group investcash05group = new InvestCash05Group();
	private InvestCashController controller;
	public String entry_no;
	public String currency;
	private JTable table_2;
	private JTable table_3;
	private JTabbedPane tabbedPane;
	private JTable table_4;

	/**
	 * Create the panel.
	 */

	public InvestCashJPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		// 原來layout數值
		// 示範條款修改版面
		// gridBagLayout.rowHeights = new int[] { 268, 0, 0, 207, 0 };
		// gridBagLayout.rowWeights = new double[] { 1.0, 0.0, 0.0, 0.0,
		// Double.MIN_VALUE };
		gridBagLayout.columnWidths = new int[] { 250, 250, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 1.0, 1.0, 1.0,
				Double.MIN_VALUE };
		setLayout(gridBagLayout);
		// 上區Panel(入帳資料)
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u5165\u5E33\u8CC7\u6599",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridheight = 2;
		gbc_panel.gridwidth = 2;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);
		panel.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		table.setToolTipText("點擊以顯示下方明細");
		scrollPane.setViewportView(table);
		// ListSelectionListener用法
		// table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// ListSelectionModel model = table.getSelectionModel();
		// model.addListSelectionListener(this);

		// 滑鼠點一下選擇欲查詢明細之列
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getSelectionModel().addListSelectionListener(
				new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent e) {
						// if (e.getClickCount() == 1) {
						clearInvestCashDetail();
						if (!((DefaultListSelectionModel) e.getSource())
								.getValueIsAdjusting()) {
							setTabPaneEnable();
							int rowSelected = table.getSelectedRow();
							if (rowSelected != -1) {
								entry_no = group01.getInvestCash01s()
										.get(rowSelected).getEntry_no();
								currency = group01.getInvestCash01s()
										.get(rowSelected).getCurrency();
								controller.executeInnerMission(entry_no,
										currency);
							}
							setTabPaneDisable();
						}
					}
				});

		// 下左區Panel(入帳明細)
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\u5165\u5E33\u660E\u7D30",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 2;
		gbc_panel_1.gridwidth = 2;
		gbc_panel_1.gridheight = 1;
		add(panel_1, gbc_panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane_1 = new JScrollPane();
		panel_1.add(scrollPane_1, BorderLayout.CENTER);

		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);

		// 下右區Panel(保費明細)
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "\u4FDD\u8CBB\u660E\u7D30",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.gridwidth = 2;
		gbc_panel_2.gridheight = 1;
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 3;
		add(panel_2, gbc_panel_2);

		// VerticalPane
		// String[] headers1 = { "保費-目標(基本)", "保費-額外", "保費-投資", "保費-壽險", "保費-附約"
		// };
		panel_2.setLayout(new BorderLayout(0, 0));

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		panel_2.add(tabbedPane, BorderLayout.CENTER);

		JScrollPane scrollPane_2 = new JScrollPane();
		tabbedPane.addTab("保費明細", null, scrollPane_2, null);
		scrollPane_2.setViewportBorder(new TitledBorder(null, "",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));

		table_2 = new JTable();
		scrollPane_2.setViewportView(table_2);

		JScrollPane scrollPane_3 = new JScrollPane();
		tabbedPane.addTab("目標堆疊", null, scrollPane_3, null);

		table_3 = new JTable();
		scrollPane_3.setViewportView(table_3);

		JScrollPane scrollPane_4 = new JScrollPane();
		tabbedPane.addTab("\u7ACB\u6295\u8CBB\u7528", null, scrollPane_4, null);

		table_4 = new JTable();
		scrollPane_4.setViewportView(table_4);
		initDataBindings();

		// 調整table欄位寬度
		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

		TableColumn headerCol = table_1.getColumnModel().getColumn(1);
		headerCol.setPreferredWidth(10);

		// 調整內容靠右
		int i = 2;
		for (i = 2; i <= 7; i++) {
			headerCol = table.getColumnModel().getColumn(i);
			headerCol.setCellRenderer(rightRenderer);
		}
		i = 3;
		for (i = 2; i < table_3.getColumnCount(); i++) {
			headerCol = table_3.getColumnModel().getColumn(i);
			headerCol.setCellRenderer(rightRenderer);
		}
	}

	public void addInvestCash01(InvestCash01 investcash01) {
		group01.addInvestCash01(investcash01);
	}

	public void addInvestCash02(InvestCash02 investcash02) {
		group02.addInvestCash02(investcash02);
	}

	public void addInvestCash04(InvestCash04 investcash04) {
		investcash04group.addInvestCash04(investcash04);
	}

	public void addInvestCash05(InvestCash05 investcash05) {
		investcash05group.addInvestCash05(investcash05);
	}

	public void setInvestCash03(HashMap<String, String> hsmap) {
		InvestCash03 tmp = new InvestCash03();
		tmp.setValues(hsmap);
		investcash03.addInvestCash03(tmp);
	}

	public void setDefaultRow() // 預設出現第一筆資料的明細
	{
		if (table.getRowCount() > 0) {
			ListSelectionModel selectionModel = table.getSelectionModel();
			selectionModel.setSelectionInterval(0, 0);
		}
	}

	// 清空所有資料
	public void clearAll() {
		group01.removeAll();
		group02.removeAll();
		investcash03.removeAll();
		investcash04group.removeAll();
		investcash05group.removeall();
	}

	// 將全域變數全部指向NULL
	public void nullAll() {
		table = null;
		table_1 = null;
		group01 = null;
		group02 = null;
		investcash03 = null;
		investcash04group = null;
		investcash05group = null;
		controller = null;
		entry_no = null;
		currency = null;
	}

	// 清空下區資料
	public void clearInvestCashDetail() {
		group02.removeAll();
		investcash03.removeAll();
		investcash04group.removeAll();
		investcash05group.removeall();
	}

	public void setTabPaneEnable() {
		for (int i = 0; i < tabbedPane.getComponentCount(); i++) {
			tabbedPane.setEnabledAt(i, true);
		}
	}

	public void setTabPaneDisable() {
		// 無資料會有一列result_ind = '1'
		if (investcash04group.getInvestCash04Count() < 1
				|| investcash04group.getInvestCash04s().get(0)
						.getR_result_ind().equals("1"))
			tabbedPane.setEnabledAt(1, false);
		if (investcash05group.getInvestCash05Count() < 1)
			tabbedPane.setEnabledAt(tabbedPane.indexOfTab("立投費用"), false);

		for (int i = 0; i < tabbedPane.getComponentCount(); i++) {
			if (tabbedPane.isEnabledAt(i)) {
				tabbedPane.setSelectedIndex(i);
				break;
			}
		}
	}

	public void setController(InvestCashController controller) {
		this.controller = controller;
	}
	protected void initDataBindings() {
		BeanProperty<InvestCash01Group, List<InvestCash01>> investCash01GroupBeanProperty = BeanProperty.create("investCash01s");
		JTableBinding<InvestCash01, InvestCash01Group, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, group01, investCash01GroupBeanProperty, table);
		//
		BeanProperty<InvestCash01, String> investCash01BeanProperty = BeanProperty.create("tran_date");
		jTableBinding.addColumnBinding(investCash01BeanProperty).setColumnName("\u4EA4\u6613\u65E5\u671F");
		//
		BeanProperty<InvestCash01, String> investCash01BeanProperty_1 = BeanProperty.create("function_code");
		jTableBinding.addColumnBinding(investCash01BeanProperty_1).setColumnName("\u529F\u80FD");
		//
		BeanProperty<InvestCash01, String> investCash01BeanProperty_2 = BeanProperty.create("receive_amt");
		jTableBinding.addColumnBinding(investCash01BeanProperty_2).setColumnName("\u6536\u5165\u91D1\u984D");
		//
		BeanProperty<InvestCash01, String> investCash01BeanProperty_3 = BeanProperty.create("payout_amt");
		jTableBinding.addColumnBinding(investCash01BeanProperty_3).setColumnName("\u7D66\u4ED8\u91D1\u984D");
		//
		BeanProperty<InvestCash01, String> investCash01BeanProperty_4 = BeanProperty.create("fee_amt");
		jTableBinding.addColumnBinding(investCash01BeanProperty_4).setColumnName("\u7BA1\u7406\u8CBB\u7528");
		//
		BeanProperty<InvestCash01, String> investCash01BeanProperty_5 = BeanProperty.create("charge_amt");
		jTableBinding.addColumnBinding(investCash01BeanProperty_5).setColumnName("\u624B\u7E8C\u8CBB");
		//
		BeanProperty<InvestCash01, String> investCash01BeanProperty_6 = BeanProperty.create("entry_no");
		jTableBinding.addColumnBinding(investCash01BeanProperty_6).setColumnName("\u5165\u5E33\u865F\u78BC");
		//
		BeanProperty<InvestCash01, String> investCash01BeanProperty_7 = BeanProperty.create("invs_ad_no");
		jTableBinding.addColumnBinding(investCash01BeanProperty_7).setColumnName("\u4EA4\u6613\u7DE8\u865F");
		//
		jTableBinding.setEditable(false);
		jTableBinding.bind();
		//
		BeanProperty<InvestCash02Group, List<InvestCash02>> investCash02GroupBeanProperty = BeanProperty.create("investCash02s");
		JTableBinding<InvestCash02, InvestCash02Group, JTable> jTableBinding_1 = SwingBindings.createJTableBinding(UpdateStrategy.READ, group02, investCash02GroupBeanProperty, table_1);
		//
		BeanProperty<InvestCash02, String> investCash02BeanProperty = BeanProperty.create("cash_flow_type_d");
		jTableBinding_1.addColumnBinding(investCash02BeanProperty).setColumnName("\u8CBB\u7528\u7A2E\u985E");
		//
		BeanProperty<InvestCash02, String> investCash02BeanProperty_1 = BeanProperty.create("amt");
		jTableBinding_1.addColumnBinding(investCash02BeanProperty_1).setColumnName("\u8CBB\u7528\u91D1\u984D");
		//
		jTableBinding_1.setEditable(false);
		jTableBinding_1.bind();
		//
		BeanProperty<InvestCash03Group, List<InvestCash03>> investCash03GroupBeanProperty = BeanProperty.create("investCash03s");
		JTableBinding<InvestCash03, InvestCash03Group, JTable> jTableBinding_2 = SwingBindings.createJTableBinding(UpdateStrategy.READ, investcash03, investCash03GroupBeanProperty, table_2);
		//
		BeanProperty<InvestCash03, String> investCash03BeanProperty = BeanProperty.create("target_prem");
		jTableBinding_2.addColumnBinding(investCash03BeanProperty).setColumnName("\u4FDD\u8CBB-\u76EE\u6A19(\u57FA\u672C)");
		//
		BeanProperty<InvestCash03, String> investCash03BeanProperty_1 = BeanProperty.create("excess_prem");
		jTableBinding_2.addColumnBinding(investCash03BeanProperty_1).setColumnName("\u4FDD\u8CBB-\u984D\u5916(\u8D85\u984D)");
		//
		BeanProperty<InvestCash03, String> investCash03BeanProperty_2 = BeanProperty.create("invest_prem");
		jTableBinding_2.addColumnBinding(investCash03BeanProperty_2).setColumnName("\u4FDD\u8CBB-\u6295\u8CC7");
		//
		BeanProperty<InvestCash03, String> investCash03BeanProperty_3 = BeanProperty.create("term_prem");
		jTableBinding_2.addColumnBinding(investCash03BeanProperty_3).setColumnName("\u4FDD\u8CBB-\u58FD\u96AA");
		//
		BeanProperty<InvestCash03, String> investCash03BeanProperty_4 = BeanProperty.create("rider_prem");
		jTableBinding_2.addColumnBinding(investCash03BeanProperty_4).setColumnName("\u4FDD\u8CBB-\u9644\u7D04");
		//
		BeanProperty<InvestCash03, String> investCash03BeanProperty_5 = BeanProperty.create("r_due_date_to");
		jTableBinding_2.addColumnBinding(investCash03BeanProperty_5).setColumnName("\u76EE\u6A19\u4FDD\u8CBB\u5806\u758A\u8FC4\u65E5");
		//
		jTableBinding_2.setEditable(false);
		jTableBinding_2.bind();
		//
		BeanProperty<InvestCash04Group, List<InvestCash04>> investCash04GroupBeanProperty = BeanProperty.create("investCash04s");
		JTableBinding<InvestCash04, InvestCash04Group, JTable> jTableBinding_3 = SwingBindings.createJTableBinding(UpdateStrategy.READ, investcash04group, investCash04GroupBeanProperty, table_3);
		//
		BeanProperty<InvestCash04, String> investCash04BeanProperty = BeanProperty.create("r_policy_year");
		jTableBinding_3.addColumnBinding(investCash04BeanProperty).setColumnName("\u4FDD\u55AE\u5E74\u5EA6");
		//
		BeanProperty<InvestCash04, String> investCash04BeanProperty_1 = BeanProperty.create("r_prem_year");
		jTableBinding_3.addColumnBinding(investCash04BeanProperty_1).setColumnName("\u4FDD\u8CBB\u5E74\u5EA6");
		//
		BeanProperty<InvestCash04, String> investCash04BeanProperty_3 = BeanProperty.create("r_target_prem");
		jTableBinding_3.addColumnBinding(investCash04BeanProperty_3).setColumnName("\u76EE\u6A19(\u57FA\u672C)\u4FDD\u8CBB");
		//
		BeanProperty<InvestCash04, String> investCash04BeanProperty_4 = BeanProperty.create("r_excess_prem");
		jTableBinding_3.addColumnBinding(investCash04BeanProperty_4).setColumnName("\u984D\u5916(\u8D85\u984D)\u4FDD\u8CBB");
		//
		BeanProperty<InvestCash04, String> investCash04BeanProperty_5 = BeanProperty.create("r_feld_expn_tgpm");
		jTableBinding_3.addColumnBinding(investCash04BeanProperty_5).setColumnName("\u8CBB\u7528-\u76EE\u6A19(\u57FA\u672C)");
		//
		BeanProperty<InvestCash04, String> investCash04BeanProperty_6 = BeanProperty.create("r_feld_expn_espm");
		jTableBinding_3.addColumnBinding(investCash04BeanProperty_6).setColumnName("\u8CBB\u7528-\u984D\u5916(\u8D85\u984D)");
		//
		jTableBinding_3.setEditable(false);
		jTableBinding_3.bind();
		//
		BeanProperty<InvestCash05Group, List<InvestCash05>> investCash05GroupBeanProperty = BeanProperty.create("investCash05s");
		JTableBinding<InvestCash05, InvestCash05Group, JTable> jTableBinding_4 = SwingBindings.createJTableBinding(UpdateStrategy.READ, investcash05group, investCash05GroupBeanProperty, table_4);
		//
		BeanProperty<InvestCash05, String> investCash05BeanProperty = BeanProperty.create("r_net_prem");
		jTableBinding_4.addColumnBinding(investCash05BeanProperty).setColumnName("\u6DE8\u4FDD\u96AA\u8CBB").setEditable(false);
		//
		BeanProperty<InvestCash05, String> investCash05BeanProperty_1 = BeanProperty.create("r_immed_inv_expn");
		jTableBinding_4.addColumnBinding(investCash05BeanProperty_1).setColumnName("\u7ACB\u6295\u8CBB\u7528").setEditable(false);
		//
		jTableBinding_4.setEditable(false);
		jTableBinding_4.bind();
	}
}
