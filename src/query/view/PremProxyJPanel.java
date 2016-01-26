package query.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

import query.controller.PremProxyController;
import query.model.PremProxy.PremProxy01;
import query.model.PremProxy.PremProxy02;
import query.model.PremProxy.PremProxy02Group;
import query.model.PremProxy.PremProxy03;
import query.model.PremProxy.PremProxy03Group;
import query.model.PremProxy.PremProxy04;
import query.model.PremProxy.PremProxy04Group;
/**
 * 
 * @author 陳冠瑜
 * 
 */
public class PremProxyJPanel extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTable table_1;
	private JTable table_2; //101-10-03新增
	private VerticalPane mainPane1, mainPane2, mainPane3;
	private PremProxy02Group group02 = new PremProxy02Group();
	private PremProxy03Group group03 = new PremProxy03Group();
	private PremProxy04Group group04 = new PremProxy04Group(); // 101-10-03新增
	private PremProxy01 premproxy01 = new PremProxy01();
	private JComboBox combo;
	private PremProxyController controller;
	private JButton searchbutton;
	public String bank_op_ind = "1";

	/**
	 * Create the panel.
	 */
	public PremProxyJPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 70, 70, 70, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 180, 100, 30, 30, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 1.0, 1.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 1.0, 1.0, 1.0,
				Double.MIN_VALUE };
		setLayout(gridBagLayout);

		// 選擇銀行作業代碼
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(280, 30));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel.gridwidth = 3;
		gbc_panel.insets = new Insets(0, 0, 5, 150);
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 95, 115, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);
		// label
		JLabel label = new JLabel("銀行作業代碼:");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 0);
		gbc_label.fill = GridBagConstraints.BOTH;
		gbc_label.gridx = 0;
		gbc_label.gridy = 0;
		panel.add(label, gbc_label);
		// ComboBox
		String[] comboitem = { "委託書", "信用卡代收", "信用卡代墊" }; // ComboBox Item
		combo = new JComboBox(comboitem);
		combo.addActionListener(this);
		combo.setForeground(Color.BLACK);
		combo.setBackground(Color.WHITE);
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 0;
		panel.add(combo, gbc_comboBox);
		// button
		searchbutton = new JButton("查詢");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.fill = GridBagConstraints.VERTICAL;
		gbc_btnNewButton.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 0;
		// 按鈕事件處理
		searchbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.executeInnerMission(bank_op_ind);
			}
		});
		panel.add(searchbutton, gbc_btnNewButton);

		// 主要資料Panel
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "授權、委託書明細─主要資料",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.gridwidth = 3;
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 1;
		add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 120, 120, 120, 0 };
		gbl_panel_1.rowHeights = new int[] { 177, 0 };
		gbl_panel_1.columnWeights = new double[] { 1.0, 1.0, 1.0,
				Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);
		// 左vertical
		String[] headers1 = { "保單號碼", "要保人", "被保險人", "保單狀態", "保費繳法", "收費方式",
				"累計失敗次數" };
		mainPane1 = new VerticalPane(headers1, "", 100, 25);
		GridBagConstraints gbc_mainPane1 = new GridBagConstraints();
		gbc_mainPane1.insets = new Insets(0, 0, 0, -1);
		gbc_mainPane1.fill = GridBagConstraints.BOTH;
		panel_1.add(mainPane1, gbc_mainPane1);
		// 中vertical
		String[] headers2 = { "應繳日期", "通知單到期日", "停效日期", "帳號狀態", "授權書狀態", "異動者",
				"異動日" };
		mainPane2 = new VerticalPane(headers2, "", 100, 25);
		GridBagConstraints gbc_mainPane2 = new GridBagConstraints();
		gbc_mainPane2.insets = new Insets(0, 0, 0, -1);
		gbc_mainPane2.fill = GridBagConstraints.BOTH;
		panel_1.add(mainPane2, gbc_mainPane2);
		// 右vertical
		String[] headers3 = { "帳單日(週期)", "信用卡有效日", "授權人電話", "授權人地址", "授權人生日" };
		mainPane3 = new VerticalPane(headers3, "", 100, 25);
		GridBagConstraints gbc_mainPane3 = new GridBagConstraints();
		gbc_mainPane3.fill = GridBagConstraints.BOTH;
		panel_1.add(mainPane3, gbc_mainPane3);

		// 異動資料Panel
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "授權、委託書明細─異動資料",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.gridwidth = 3;
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 2;
		add(panel_2, gbc_panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane_2 = new JScrollPane();
		panel_2.add(scrollPane_2);

		table = new JTable();
		scrollPane_2.setViewportView(table);

		// 歸檔資料Panel 101-10-03新增
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "授權、委託書明細─歸檔資料",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 5, 0);
		gbc_panel_3.gridwidth = 3;
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 3;
		add(panel_3, gbc_panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane_3 = new JScrollPane();
		panel_3.add(scrollPane_3);

		table_1 = new JTable();
		scrollPane_3.setViewportView(table_1);
		
		// 暫停扣款資料Panel 
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "授權、委託書明細─暫停扣款資料", 
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.insets = new Insets(0, 0, 5, 0);
		gbc_panel_4.gridwidth = 3;
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 0;
		gbc_panel_4.gridy = 4;
		add(panel_4, gbc_panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_4 = new JScrollPane();
		panel_4.add(scrollPane_4);		

		table_2 = new JTable();
		scrollPane_4.setViewportView(table_2);
		
		initDataBindings();
		
		// 調整table欄位寬度
		table.getColumnModel().getColumn(1).setPreferredWidth(140);
		table.getColumnModel().getColumn(3).setPreferredWidth(125);
		table.getColumnModel().getColumn(4).setPreferredWidth(180);
		table.getColumnModel().getColumn(5).setPreferredWidth(120);
		table.getColumnModel().getColumn(6).setPreferredWidth(100);
		table.getColumnModel().getColumn(8).setPreferredWidth(90);
	}

	public void setController(PremProxyController controller) {
		this.controller = controller;
	}

	public void setPremProxy01(HashMap<String, String> hsmap) {
		// group01.addPremProxy01(premproxy01);
		premproxy01.setValues(hsmap);
		mainPane1.setValue(premproxy01.getValues(1));
		mainPane2.setValue(premproxy01.getValues(2));
		mainPane3.setValue(premproxy01.getValues(3));
	}

	public void addPremProxy02(PremProxy02 premProxy02) {
		group02.addPremProxy02(premProxy02);
	}

	public void addPremProxy03(PremProxy03 premproxy03) {
		group03.addPremProxy03(premproxy03);
	}

	public void addPremProxy04(PremProxy04 premproxy04) {
		group04.addPremProxy04(premproxy04);
	}
	
	// 清空資料
	public void clearAll() {
		mainPane1.clearValues();
		mainPane2.clearValues();
		mainPane3.clearValues();
		group02.removeAll();
		group03.removeAll();
		group04.removeAll();
	}
	
	public void nullAll() {
		table = null;
		table_1 = null;
		table_2 = null;
		mainPane1 = null;
		mainPane2 = null;
		mainPane3 = null;
		group02 = null;
		group03 = null;
		group04 = null;
		premproxy01 = null;
		combo = null;
		controller = null;
		searchbutton = null;
		bank_op_ind = null;
	}

	// 實作選擇ComboBox項目處理
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == combo) {
			Integer comboid = combo.getSelectedIndex();
			switch (comboid) {
			case 0:
				bank_op_ind = "1";
				break;
			case 1:
				bank_op_ind = "7";
				break;
			case 2:
				bank_op_ind = "9";
				break;
			}
		}
	}
	protected void initDataBindings() {
		BeanProperty<PremProxy02Group, List<PremProxy02>> premProxy02GroupBeanProperty = BeanProperty.create("premproxy02s");
		JTableBinding<PremProxy02, PremProxy02Group, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, group02, premProxy02GroupBeanProperty, table);
		//
		BeanProperty<PremProxy02, String> premProxy02BeanProperty = BeanProperty.create("process_date");
		jTableBinding.addColumnBinding(premProxy02BeanProperty).setColumnName("\u7570\u52D5\u65E5\u671F");
		//
		BeanProperty<PremProxy02, String> premProxy02BeanProperty_1 = BeanProperty.create("receive_no");
		jTableBinding.addColumnBinding(premProxy02BeanProperty_1).setColumnName("\u53D7\u7406\u865F\u78BC");
		//
		BeanProperty<PremProxy02, String> premProxy02BeanProperty_2 = BeanProperty.create("status_desc");
		jTableBinding.addColumnBinding(premProxy02BeanProperty_2).setColumnName("\u72C0\u614B");
		//
		BeanProperty<PremProxy02, String> premProxy02BeanProperty_3 = BeanProperty.create("bank_name");
		jTableBinding.addColumnBinding(premProxy02BeanProperty_3).setColumnName("\u9280\u884C");
		//
		BeanProperty<PremProxy02, String> premProxy02BeanProperty_4 = BeanProperty.create("bank_branch_d");
		jTableBinding.addColumnBinding(premProxy02BeanProperty_4).setColumnName("\u6263\u6B3E\u9280\u884C");
		//
		BeanProperty<PremProxy02, String> premProxy02BeanProperty_5 = BeanProperty.create("card_type");
		jTableBinding.addColumnBinding(premProxy02BeanProperty_5).setColumnName("\u5361\u5225/\u5E33\u865F");
		//
		BeanProperty<PremProxy02, String> premProxy02BeanProperty_6 = BeanProperty.create("bank_paid_date");
		jTableBinding.addColumnBinding(premProxy02BeanProperty_6).setColumnName("\u5E33\u55AE\u65E5(\u9031\u671F)");
		//
		BeanProperty<PremProxy02, String> premProxy02BeanProperty_7 = BeanProperty.create("acc_name");
		jTableBinding.addColumnBinding(premProxy02BeanProperty_7).setColumnName("\u6388\u6B0A\u4EBA");
		//
		BeanProperty<PremProxy02, String> premProxy02BeanProperty_8 = BeanProperty.create("acc_id");
		jTableBinding.addColumnBinding(premProxy02BeanProperty_8).setColumnName("\u6388\u6B0A\u4EBAID");
		//
		BeanProperty<PremProxy02, String> premProxy02BeanProperty_9 = BeanProperty.create("process_user");
		jTableBinding.addColumnBinding(premProxy02BeanProperty_9).setColumnName("\u7570\u52D5\u8005");
		//
		jTableBinding.setEditable(false);
		jTableBinding.bind();
		//
		BeanProperty<PremProxy03Group, List<PremProxy03>> premProxy03GroupBeanProperty = BeanProperty.create("premproxy03s");
		JTableBinding<PremProxy03, PremProxy03Group, JTable> jTableBinding_1 = SwingBindings.createJTableBinding(UpdateStrategy.READ, group03, premProxy03GroupBeanProperty, table_1);
		//
		BeanProperty<PremProxy03, String> premProxy03BeanProperty = BeanProperty.create("return_no");
		jTableBinding_1.addColumnBinding(premProxy03BeanProperty).setColumnName("\u6B78\u6A94\u865F\u78BC");
		//
		BeanProperty<PremProxy03, String> premProxy03BeanProperty_1 = BeanProperty.create("return_type");
		jTableBinding_1.addColumnBinding(premProxy03BeanProperty_1).setColumnName("\u6B78\u6A94\u985E\u5225");
		//
		BeanProperty<PremProxy03, String> premProxy03BeanProperty_2 = BeanProperty.create("return_date");
		jTableBinding_1.addColumnBinding(premProxy03BeanProperty_2).setColumnName("\u6B78\u6A94\u65E5\u671F");
		//
		BeanProperty<PremProxy03, String> premProxy03BeanProperty_3 = BeanProperty.create("return_user");
		jTableBinding_1.addColumnBinding(premProxy03BeanProperty_3).setColumnName("\u6B78\u6A94\u8005");
		//
		BeanProperty<PremProxy03, String> premProxy03BeanProperty_4 = BeanProperty.create("receive_no");
		jTableBinding_1.addColumnBinding(premProxy03BeanProperty_4).setColumnName("\u53D7\u7406\u865F\u78BC");
		//
		BeanProperty<PremProxy03, String> premProxy03BeanProperty_5 = BeanProperty.create("return_reason");
		jTableBinding_1.addColumnBinding(premProxy03BeanProperty_5).setColumnName("\u6B78\u6A94\u539F\u56E0");
		//
		jTableBinding_1.setEditable(false);
		jTableBinding_1.bind();
		//
		BeanProperty<PremProxy04Group, List<PremProxy04>> premProxy04GroupBeanProperty = BeanProperty.create("premproxy04s");
		JTableBinding<PremProxy04, PremProxy04Group, JTable> jTableBinding_2 = SwingBindings.createJTableBinding(UpdateStrategy.READ, group04, premProxy04GroupBeanProperty, table_2);
		//
		BeanProperty<PremProxy04, String> premProxy04BeanProperty = BeanProperty.create("trf_end_date");
		jTableBinding_2.addColumnBinding(premProxy04BeanProperty).setColumnName("\u66AB\u505C\u6263\u6B3E\u8FC4\u6708");
		//
		BeanProperty<PremProxy04, String> premProxy04BeanProperty_1 = BeanProperty.create("process_date");
		jTableBinding_2.addColumnBinding(premProxy04BeanProperty_1).setColumnName("\u8655\u7406\u65E5\u671F");
		//
		BeanProperty<PremProxy04, String> premProxy04BeanProperty_2 = BeanProperty.create("process_time");
		jTableBinding_2.addColumnBinding(premProxy04BeanProperty_2).setColumnName("\u8655\u7406\u6642\u9593");
		//
		BeanProperty<PremProxy04, String> premProxy04BeanProperty_3 = BeanProperty.create("process_user");
		jTableBinding_2.addColumnBinding(premProxy04BeanProperty_3).setColumnName("\u8655\u7406\u8005");
		//
		jTableBinding_2.setEditable(false);
		jTableBinding_2.bind();
	}
}
