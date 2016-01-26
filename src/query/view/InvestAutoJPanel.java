package query.view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.List;

import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

import query.controller.InvestAutoController;
import query.model.InvestAuto.InvestAuto01;
import query.model.InvestAuto.InvestAuto01Group;
import query.model.InvestAuto.InvestAuto02;
import query.model.InvestAuto.InvestAuto02Group;
import query.model.InvestAuto.InvestAuto03;
import query.model.InvestAuto.InvestAuto03Group;
/**
 * 
 * @author 陳冠瑜
 * 
 */
public class InvestAutoJPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTable table_1;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table_2;
	private JTextField textField_2;
	private InvestAutoController controller;
	private InvestAuto01Group group01 = new InvestAuto01Group();
	private InvestAuto02Group group02 = new InvestAuto02Group();
	private InvestAuto03Group group03 = new InvestAuto03Group();
	private InvestAuto01 investauto01 = new InvestAuto01();
	private VerticalPane verticalPane1;
	public String auto_tr_date, invs_avail_type;
	public String beg_date, end_date, invs_code, invs_tilte;
	private JLabel displbl;

	/**
	 * Create the panel.
	 */
	public InvestAutoJPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0 };
		gridBagLayout.rowHeights = new int[] { 166, 71, 160, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 1.0, 1.0,
				Double.MIN_VALUE };
		setLayout(gridBagLayout);

		// 上區Panel(自動轉換)
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "\u81EA\u52D5\u8F49\u63DB",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 70,
						213)));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 2, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 250, 2, 0 };
		gbl_panel.rowHeights = new int[] { 28, 2, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		// 下次自動轉換日期verticalPane
		String[] headers1 = { "下次自動轉換日期" };
		verticalPane1 = new VerticalPane(headers1, "", 140, 26);
		GridBagConstraints gbc_scrollPane1 = new GridBagConstraints();
		gbc_scrollPane1.fill = GridBagConstraints.BOTH;
		panel.add(verticalPane1, gbc_scrollPane1);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(5, 0, 0, 0);
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		panel.add(scrollPane, gbc_scrollPane);

		table = new JTable();
		table.setToolTipText("點擊以顯示下方明細");
		scrollPane.setViewportView(table);
		
		// 滑鼠點一下自動轉帳資料列，顯示欲查詢之加碼明細
//		table.addMouseListener(new MouseAdapter() {
//			public void mouseClicked(MouseEvent e) {
//				if (e.getClickCount() == 1) {
		table.getSelectionModel().addListSelectionListener(
				new ListSelectionListener() {
					
				public void valueChanged(ListSelectionEvent arg0) {
				if (!((DefaultListSelectionModel) arg0.getSource())
						.getValueIsAdjusting()) {
					int rowSelected = table.getSelectedRow();
					if (rowSelected != -1) {
						auto_tr_date = group01.getInvestAuto01s()
								.get(rowSelected).getR_auto_tr_date();
						invs_avail_type = group01.getInvestAuto01s()
								.get(rowSelected).getR_invs_avail_type();
						controller.executeInnerMission01(auto_tr_date, invs_avail_type);
					}
				}
			}
		});
		
		// 中區Panel(加碼明細)
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\u52A0\u78BC\u660E\u7D30",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 3, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 1;
		add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 0, 0 };
		gbl_panel_1.rowHeights = new int[] { 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 0;
		panel_1.add(scrollPane_1, gbc_scrollPane_1);

		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);

		// 下區Panel(停利明細)
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "\u505C\u5229\u660E\u7D30",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 2;
		add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] { 63, 80, 26, 80, 0, 0 };
		gbl_panel_2.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_panel_2.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		gbl_panel_2.rowWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		panel_2.setLayout(gbl_panel_2);

		// 查詢期間
		JLabel label = new JLabel("\u67E5\u8A62\u671F\u9593\uFF1A");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.anchor = GridBagConstraints.EAST;
		gbc_label.gridx = 0;
		gbc_label.gridy = 0;
		panel_2.add(label, gbc_label);

		// 輸入查詢起日
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		panel_2.add(textField, gbc_textField);
		textField.setColumns(10);

		JLabel label_1 = new JLabel("~");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 0);
		gbc_label_1.gridx = 2;
		gbc_label_1.gridy = 0;
		panel_2.add(label_1, gbc_label_1);

		// 輸入查詢迄日
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.gridx = 3;
		gbc_textField_1.gridy = 0;
		panel_2.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);

		// 查詢按鈕
		JButton searchBtn = new JButton("\u67E5\u8A62");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 5, 5, 0);
		gbc_btnNewButton.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton.gridx = 4;
		gbc_btnNewButton.gridy = 0;
		// 按鈕事件處理
		searchBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				// 取得各textField內容
				beg_date = textField.getText();
				end_date = textField_1.getText();
				invs_code = textField_2.getText();

				// 執行抓資料塞table
				controller.executeInnerMission(beg_date, end_date, invs_code);

				// 顯示查詢基金代碼名稱
				displbl.setText(group03.getInvestAuto03s().get(0)
						.getR_invs_title());
			}
		});

		panel_2.add(searchBtn, gbc_btnNewButton);

		JLabel label_2 = new JLabel("\u57FA\u91D1\u4EE3\u78BC\uFF1A");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.anchor = GridBagConstraints.EAST;
		gbc_label_2.insets = new Insets(3, 0, 5, 5);
		gbc_label_2.gridx = 0;
		gbc_label_2.gridy = 1;
		panel_2.add(label_2, gbc_label_2);

		// 輸入查詢基金代碼
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(3, 0, 5, 0);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 1;
		panel_2.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);

		// 顯示查詢基金代碼名稱
		displbl = new JLabel();
		displbl.setForeground(Color.BLUE);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.gridx = 3;
		gbc_lblNewLabel.gridy = 1;
		panel_2.add(displbl, gbc_lblNewLabel);

		JScrollPane scrollPane_2 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_2 = new GridBagConstraints();
		gbc_scrollPane_2.insets = new Insets(4, 0, 0, 0);
		gbc_scrollPane_2.gridwidth = 5;
		gbc_scrollPane_2.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_2.gridx = 0;
		gbc_scrollPane_2.gridy = 2;
		panel_2.add(scrollPane_2, gbc_scrollPane_2);

		table_2 = new JTable();
		scrollPane_2.setViewportView(table_2);
		initDataBindings();

		// 調整table欄位寬度
		table.getColumnModel().getColumn(0).setPreferredWidth(55);
		table.getColumnModel().getColumn(5).setPreferredWidth(260);
	}

	public void setController(InvestAutoController controller) {
		this.controller = controller;
	}

	public void addInvestAuto01(InvestAuto01 investauto01) {
		group01.addInvestAuto01(investauto01);
	}

	// 下次自動轉換日期
	public void setInvestAuto01(HashMap<String, String> hsmap) {
		verticalPane1.clearValues();
		investauto01.setValues(hsmap);
		verticalPane1.setValue(investauto01.getValues(1));
	}
	
	public void addInvestAuto02(InvestAuto02 investauto02) {
		group02.addInvestAuto02(investauto02);
	}

	public void addInvestAuto03(InvestAuto03 investauto03) {
		group03.addInvestAuto03(investauto03);
	}

	public void setDefaultRow()
	{
		if (table.getRowCount() > 0)
		{	
		ListSelectionModel selectionModel =    table.getSelectionModel(); 
		selectionModel.setSelectionInterval(0, 0);
//		getNewData();
		}
	}
	
	public void clearInvestAuto01() {
		group01.removeAll();
	}

	public void clearInvestAuto02() {
		group02.removeAll();
	}

	public void clearInvestAuto03() {
		group03.removeAll();
	}

	public void nullAll() {
		table = null;
		table_1 = null;
		textField = null;
		textField_1 = null;
		table_2 = null;
		textField_2 = null;
		controller = null;
		group01 = null;
		group02 = null;
		group03 = null;
		investauto01 = null;
		verticalPane1 = null;
		auto_tr_date = null;
		invs_avail_type = null;
		beg_date = null;
		end_date = null;
		invs_code = null;
		invs_tilte = null;
		displbl = null;
	}
	
	protected void initDataBindings() {
		BeanProperty<InvestAuto01Group, List<InvestAuto01>> investAuto01GroupBeanProperty = BeanProperty
				.create("investAuto01s");
		JTableBinding<InvestAuto01, InvestAuto01Group, JTable> jTableBinding = SwingBindings
				.createJTableBinding(UpdateStrategy.READ, group01,
						investAuto01GroupBeanProperty, table);
		//
		BeanProperty<InvestAuto01, String> investAuto01BeanProperty = BeanProperty
				.create("r_auto_tr_date");
		jTableBinding.addColumnBinding(investAuto01BeanProperty).setColumnName(
				"\u9031\u6708\u65E5");
		//
		BeanProperty<InvestAuto01, String> investAuto01BeanProperty_1 = BeanProperty
				.create("r_effect_date");
		jTableBinding.addColumnBinding(investAuto01BeanProperty_1)
				.setColumnName("\u6279\u6B21\u4F5C\u696D\u65E5");
		//
		BeanProperty<InvestAuto01, String> investAuto01BeanProperty_2 = BeanProperty
				.create("r_sum_feed_amt");
		jTableBinding.addColumnBinding(investAuto01BeanProperty_2)
				.setColumnName("\u61C9\u8F49\u51FA\u91D1\u984D");
		//
		BeanProperty<InvestAuto01, String> investAuto01BeanProperty_3 = BeanProperty
				.create("r_invs_ad_amt");
		jTableBinding.addColumnBinding(investAuto01BeanProperty_3)
				.setColumnName("\u5BE6\u969B\u8F49\u51FA\u91D1\u984D");
		//
		BeanProperty<InvestAuto01, String> investAuto01BeanProperty_4 = BeanProperty
				.create("r_ivchg_sts_desc");
		jTableBinding.addColumnBinding(investAuto01BeanProperty_4)
				.setColumnName("\u57F7\u884C\u72C0\u614B");
		//
		BeanProperty<InvestAuto01, String> investAuto01BeanProperty_5 = BeanProperty
				.create("r_auto_tr_desc");
		jTableBinding.addColumnBinding(investAuto01BeanProperty_5)
				.setColumnName("\u4E8B\u7531");
		//
		jTableBinding.setEditable(false);
		jTableBinding.bind();
		//
		BeanProperty<InvestAuto02Group, List<InvestAuto02>> investAuto02GroupBeanProperty = BeanProperty
				.create("investAuto02s");
		JTableBinding<InvestAuto02, InvestAuto02Group, JTable> jTableBinding_1 = SwingBindings
				.createJTableBinding(UpdateStrategy.READ, group02,
						investAuto02GroupBeanProperty, table_1);
		//
		BeanProperty<InvestAuto02, String> investAuto02BeanProperty = BeanProperty
				.create("r_invs_code");
		jTableBinding_1.addColumnBinding(investAuto02BeanProperty)
				.setColumnName("\u57FA\u91D1\u4EE3\u78BC");
		//
		BeanProperty<InvestAuto02, String> investAuto02BeanProperty_1 = BeanProperty
				.create("r_drip_feed_amount");
		jTableBinding_1.addColumnBinding(investAuto02BeanProperty_1)
				.setColumnName("\u81EA\u52D5\u8F49\u63DB\u91D1\u984D");
		//
		BeanProperty<InvestAuto02, String> investAuto02BeanProperty_2 = BeanProperty
				.create("r_gain_rate");
		jTableBinding_1.addColumnBinding(investAuto02BeanProperty_2)
				.setColumnName("\u5831\u916C\u7387%");
		//
		BeanProperty<InvestAuto02, String> investAuto02BeanProperty_3 = BeanProperty
				.create("r_over_feed_desc");
		jTableBinding_1.addColumnBinding(investAuto02BeanProperty_3)
				.setColumnName("\u52A0\u78BC\u6A5F\u5236");
		//
		BeanProperty<InvestAuto02, String> investAuto02BeanProperty_4 = BeanProperty
				.create("r_over_multiple");
		jTableBinding_1.addColumnBinding(investAuto02BeanProperty_4)
				.setColumnName("\u52A0\u78BC\u500D\u6578");
		//
		BeanProperty<InvestAuto02, String> investAuto02BeanProperty_5 = BeanProperty
				.create("r_plus_drip_feed");
		jTableBinding_1.addColumnBinding(investAuto02BeanProperty_5)
				.setColumnName("\u52A0\u78BC\u5F8C\u8F49\u63DB\u91D1\u984D");
		//
		jTableBinding_1.setEditable(false);
		jTableBinding_1.bind();
		//
		BeanProperty<InvestAuto03Group, List<InvestAuto03>> investAuto03GroupBeanProperty = BeanProperty
				.create("investAuto03s");
		JTableBinding<InvestAuto03, InvestAuto03Group, JTable> jTableBinding_2 = SwingBindings
				.createJTableBinding(UpdateStrategy.READ, group03,
						investAuto03GroupBeanProperty, table_2);
		//
		BeanProperty<InvestAuto03, String> investAuto03BeanProperty = BeanProperty
				.create("r_effect_date");
		jTableBinding_2.addColumnBinding(investAuto03BeanProperty)
				.setColumnName("\u6279\u6B21\u4F5C\u696D\u65E5");
		//
		BeanProperty<InvestAuto03, String> investAuto03BeanProperty_1 = BeanProperty
				.create("r_invs_code");
		jTableBinding_2.addColumnBinding(investAuto03BeanProperty_1)
				.setColumnName("\u57FA\u91D1\u4EE3\u78BC");
		//
		BeanProperty<InvestAuto03, String> investAuto03BeanProperty_2 = BeanProperty
				.create("r_gain_lock_rate");
		jTableBinding_2.addColumnBinding(investAuto03BeanProperty_2)
				.setColumnName("\u9810\u5B9A\u505C\u5229%");
		//
		BeanProperty<InvestAuto03, String> investAuto03BeanProperty_3 = BeanProperty
				.create("r_gain_rate");
		jTableBinding_2.addColumnBinding(investAuto03BeanProperty_3)
				.setColumnName("\u5831\u916C\u7387%");
		//
		BeanProperty<InvestAuto03, String> investAuto03BeanProperty_4 = BeanProperty
				.create("r_invs_cost_amt");
		jTableBinding_2.addColumnBinding(investAuto03BeanProperty_4)
				.setColumnName("\u6301\u6709\u6210\u672C");
		//
		BeanProperty<InvestAuto03, String> investAuto03BeanProperty_5 = BeanProperty
				.create("r_invs_amt");
		jTableBinding_2.addColumnBinding(investAuto03BeanProperty_5)
				.setColumnName("\u57FA\u91D1\u5B50\u50F9\u503C");
		//
		jTableBinding_2.setEditable(false);
		jTableBinding_2.bind();
	}
}
