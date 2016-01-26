package query.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

import query.controller.MultiLineCellRenderer;
import query.model.PayAccount.PayAccount01;
import query.model.PayAccount.PayAccount01Group;
import query.model.PayAccount.PayAccount02;
import query.model.PayAccount.PayAccount02Group;
/**
 * 
 * @author 陳冠瑜
 * 
 */
public class PayAccountJPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JPanel panel_1;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JTable table;
	private JTable table_1;
	private VerticalPane verticalPane_1, verticalPane_2, verticalPane_3;
	private PayAccount01Group group01 = new PayAccount01Group();
	private PayAccount02Group group02 = new PayAccount02Group();
	public String acct_type;

	/**
	 * Create the panel.
	 */
	public PayAccountJPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 150, 0 };
		gridBagLayout.rowHeights = new int[] { 200, 120, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		// 上區Panel(匯款約定帳戶明細)
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null,
				"\u53F0/\u5916\u5E63\u532F\u6B3E\u7D04\u5B9A\u5E33\u6236",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 40, 35, 130, 0 };
		gbl_panel.rowHeights = new int[] { 27, 0, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, 1.0, 1.0,
				Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		// verticalPane1
		String[] headers1 = { "客戶證號" };
		verticalPane_1 = new VerticalPane(headers1, "", 100, 25);
		GridBagConstraints gbc_scrollPane_v1 = new GridBagConstraints();
		gbc_scrollPane_v1.insets = new Insets(0, 0, 0, 0);
		gbc_scrollPane_v1.gridx = 0;
		gbc_scrollPane_v1.gridy = 0;
		gbc_scrollPane_v1.fill = GridBagConstraints.BOTH;
		panel.add(verticalPane_1, gbc_scrollPane_v1);

		// verticalPane2
		String[] headers2 = { "客戶姓名" };
		verticalPane_2 = new VerticalPane(headers2, "", 100, 25);
		GridBagConstraints gbc_scrollPane_v2 = new GridBagConstraints();
		gbc_scrollPane_v2.insets = new Insets(0, 0, 0, 0);
		gbc_scrollPane_v2.gridx = 1;
		gbc_scrollPane_v2.gridy = 0;
		gbc_scrollPane_v2.fill = GridBagConstraints.BOTH;
		panel.add(verticalPane_2, gbc_scrollPane_v2);

		// verticalPane3
		String[] headers3 = { "受款人英文名" };
		verticalPane_3 = new VerticalPane(headers3, "", 100, 25);
		GridBagConstraints gbc_scrollPane_v3 = new GridBagConstraints();
		gbc_scrollPane_v3.insets = new Insets(0, 0, 0, 0);
		gbc_scrollPane_v3.gridx = 2;
		gbc_scrollPane_v3.gridy = 0;
		gbc_scrollPane_v3.fill = GridBagConstraints.BOTH;
		panel.add(verticalPane_3, gbc_scrollPane_v3);

		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.insets = new Insets(5, 0, 0, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		panel.add(scrollPane, gbc_scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		
		// 滑鼠點一下自動轉帳資料列，顯示欲查詢之加碼明細
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 1) {
					int rowSelected = table.getSelectedRow();
					if (rowSelected != -1) {
//						verticalPane_1.setValue(group01.getPremAccount01s().get(rowSelected).getValues(1));
						verticalPane_2.setValue(group01.getPremAccount01s().get(rowSelected).getValues(2));
						verticalPane_3.setValue(group01.getPremAccount01s().get(rowSelected).getValues(3));
					}
				}
			}
		});

		// 下區Panel(異動紀錄)
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\u7570\u52D5\u7D00\u9304",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
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

		scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 0;
		panel_1.add(scrollPane_1, gbc_scrollPane_1);

		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		initDataBindings();

		// 設定行高*2
		table.setRowHeight(table.getRowHeight() * 2);
		
		// 設定欄位寬度
		table.getColumnModel().getColumn(0).setPreferredWidth(25);
		table.getColumnModel().getColumn(1).setPreferredWidth(25);
		table.getColumnModel().getColumn(2).setPreferredWidth(50);
		table.getColumnModel().getColumn(3).setPreferredWidth(50);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		table.getColumnModel().getColumn(5).setPreferredWidth(200);
		
		// 以下為欄位換行處理兩種方法
		// 1.僅設定class是String的欄位，欄位的class要再Binding設定，未設定並搭配Object.class則為全部欄位換行
		table.setDefaultRenderer(String.class, new MultiLineCellRenderer());
		// 2.設定第幾欄位為段行，使用getColumn(x);
//		table.getColumnModel().getColumn(3).setCellRenderer( new MultiLineCellRenderer());
	}

	public void addPremAccount01(PayAccount01 premaccount01) {
		group01.addPremAccount01(premaccount01);
		// 設定verticalPane的值先抓第一筆		
//		verticalPane_1.setValue(group01.getPremAccount01s().get(0).getValues(1));
		verticalPane_2.setValue(group01.getPremAccount01s().get(0).getValues(2));
		verticalPane_3.setValue(group01.getPremAccount01s().get(0).getValues(3));
	}

	public void setClientID(String[] client_id){
		verticalPane_1.setValue(client_id);
	}
	
	public void addPremAccount02(PayAccount02 premaccount02) {
		group02.addPremAccount02(premaccount02);
	}

	public void clearPremAccount01() {
		group01.removeAll();
		verticalPane_1.clearValues();
		verticalPane_2.clearValues();
		verticalPane_3.clearValues();
	}

	public void clearPremAccount02() {
		group02.removeAll();
	}
	
	public void nullAll() {
		panel = null;
		panel_1 = null;
		scrollPane = null;
		scrollPane_1 = null;
		table = null;
		table_1 = null;
		verticalPane_1 = null;
		verticalPane_2 = null;
		verticalPane_3 = null;
		group01 = null;
		group02 = null;
		acct_type = null;
	}
	protected void initDataBindings() {
		BeanProperty<PayAccount01Group, List<PayAccount01>> premAccount01GroupBeanProperty = BeanProperty.create("premAccount01s");
		JTableBinding<PayAccount01, PayAccount01Group, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, group01, premAccount01GroupBeanProperty, table);
		//
		BeanProperty<PayAccount01, String> payAccount01BeanProperty = BeanProperty.create("r_acct_source");
		jTableBinding.addColumnBinding(payAccount01BeanProperty).setColumnName("\u4F86\u6E90").setEditable(false);
		//
		BeanProperty<PayAccount01, String> payAccount01BeanProperty_1 = BeanProperty.create("r_acct_type_desc");
		jTableBinding.addColumnBinding(payAccount01BeanProperty_1).setColumnName("\u985E\u578B");
		//
		BeanProperty<PayAccount01, String> payAccount01BeanProperty_2 = BeanProperty.create("r_acct_sts_desc");
		jTableBinding.addColumnBinding(payAccount01BeanProperty_2).setColumnName("\u5E33\u6236\u72C0\u6CC1");
		//
		BeanProperty<PayAccount01, String> payAccount01BeanProperty_3 = BeanProperty.create("r_bank_code");
		jTableBinding.addColumnBinding(payAccount01BeanProperty_3).setColumnName("\u9280\u884C\u4EE3\u78BC");
		//
		BeanProperty<PayAccount01, String> payAccount01BeanProperty_4 = BeanProperty.create("r_bank_account");
		jTableBinding.addColumnBinding(payAccount01BeanProperty_4).setColumnName("\u532F\u6B3E\u5E33\u865F");
		//
		BeanProperty<PayAccount01, String> payAccount01BeanProperty_5 = BeanProperty.create("r_bank_name");
		jTableBinding.addColumnBinding(payAccount01BeanProperty_5).setColumnName("\u9280\u884C\u540D\u7A31").setEditable(false);
		//
		BeanProperty<PayAccount01, String> payAccount01BeanProperty_6 = BeanProperty.create("r_swift_code");
		jTableBinding.addColumnBinding(payAccount01BeanProperty_6).setColumnName("\u901A\u532F\u4EE3\u78BC").setEditable(false);
		//
		BeanProperty<PayAccount01, String> payAccount01BeanProperty_7 = BeanProperty.create("r_bank_name_e");
		jTableBinding.addColumnBinding(payAccount01BeanProperty_7).setColumnName("\u9280\u884C\u82F1\u6587\u540D\u7A31").setEditable(false);
		//
		BeanProperty<PayAccount01, String> payAccount01BeanProperty_8 = BeanProperty.create("r_policy_no");
		jTableBinding.addColumnBinding(payAccount01BeanProperty_8).setColumnName("\u4FDD\u55AE\u865F\u78BC").setEditable(false);
		//
		jTableBinding.setEditable(false);
		jTableBinding.bind();
		//
		BeanProperty<PayAccount02Group, List<PayAccount02>> premAccount02GroupBeanProperty = BeanProperty.create("premAccount02s");
		JTableBinding<PayAccount02, PayAccount02Group, JTable> jTableBinding_1 = SwingBindings.createJTableBinding(UpdateStrategy.READ, group02, premAccount02GroupBeanProperty, table_1);
		//
		BeanProperty<PayAccount02, String> premAccount02BeanProperty = BeanProperty.create("r_acct_type_desc");
		jTableBinding_1.addColumnBinding(premAccount02BeanProperty).setColumnName("\u5E33\u6236\u985E\u578B");
		//
		BeanProperty<PayAccount02, String> premAccount02BeanProperty_1 = BeanProperty.create("r_po_chg_rece_no");
		jTableBinding_1.addColumnBinding(premAccount02BeanProperty_1).setColumnName("\u53D7\u7406\u865F\u78BC");
		//
		BeanProperty<PayAccount02, String> premAccount02BeanProperty_2 = BeanProperty.create("r_acct_sts_desc");
		jTableBinding_1.addColumnBinding(premAccount02BeanProperty_2).setColumnName("\u52D5\u4F5C");
		//
		BeanProperty<PayAccount02, String> premAccount02BeanProperty_3 = BeanProperty.create("r_process_user");
		jTableBinding_1.addColumnBinding(premAccount02BeanProperty_3).setColumnName("\u7570\u52D5\u8005");
		//
		BeanProperty<PayAccount02, String> premAccount02BeanProperty_4 = BeanProperty.create("r_process_date");
		jTableBinding_1.addColumnBinding(premAccount02BeanProperty_4).setColumnName("\u7570\u52D5\u65E5\u671F");
		//
		BeanProperty<PayAccount02, String> premAccount02BeanProperty_5 = BeanProperty.create("r_process_time");
		jTableBinding_1.addColumnBinding(premAccount02BeanProperty_5).setColumnName("\u7570\u52D5\u6642\u9593");
		//
		jTableBinding_1.setEditable(false);
		jTableBinding_1.bind();
	}
}
