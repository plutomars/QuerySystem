package query.view;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import query.controller.ClientInfoController;
import query.model.ClientInfo.ClientInfo02;
import query.model.ClientInfo.ClientInfo02Group;
import query.model.ClientInfo.ClientInfo03;
import query.model.ClientInfo.ClientInfo03Group;
import query.model.ClientInfo.ClientInfo04;

import org.jdesktop.beansbinding.BeanProperty;
import java.util.List;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;

import java.awt.Color;
import javax.swing.JTabbedPane;
import java.awt.Dimension;

//import java.awt.CardLayout;

public class ClientInfoJPanel extends JPanel {
	/**
	 * 保戶訊息cc232i與問題保單 cc231i cora 100/11/17
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtRestrained_desc;
	private JTextField txtRestrained;
	private JTextField txtProcess_user;
	private JTextField txtProcess_date;
	private JTable table;
	// private ClientInfo02 clientInfo02;
	private ClientInfo02Group clientInfo02Group = new ClientInfo02Group();
	private ClientInfo03Group clientInfo03Group = new ClientInfo03Group();
	// private ClientInfo04 clientInfo04 ;
	private JTextField txtPodi;
	private JTextField txtName;
	private JTable table_1;
	private VerticalPane detailVerticalPane1, detailVerticalPane2;
	public JTabbedPane tabbedPane;

	private ClientInfoController controller;

	public ClientInfoJPanel() {
		setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane_2 = new JScrollPane();
		add(scrollPane_2, BorderLayout.NORTH);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		scrollPane_2.setViewportView(tabbedPane);
		// add(tabbedPane, BorderLayout.NORTH);
		tabbedPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				int tabSelect = tabbedPane.getSelectedIndex();
				if (tabSelect > 0)
					controller.executeMissionTabValues(tabSelect);
			}
		});

		JPanel panel = new JPanel();
		tabbedPane.addTab("\u8A0A\u606F", null, panel, null);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panel1 = new JPanel();
		panel.add(panel1, BorderLayout.NORTH);
		panel1.setBorder(new TitledBorder(null, "\u554F\u984C\u4FDD\u55AE",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagLayout gbl_panel1 = new GridBagLayout();
		gbl_panel1.columnWidths = new int[] { 53, 79, 55, 83, 0, 77, 0, 0 };
		gbl_panel1.rowHeights = new int[] { 0, 52, 0 };
		gbl_panel1.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				1.0, Double.MIN_VALUE };
		gbl_panel1.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		panel1.setLayout(gbl_panel1);

		// panel.add(panel1);

		JLabel label = new JLabel("\u7A2E\u985E");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 0;
		panel1.add(label, gbc_label);

		txtRestrained = new JTextField();
		txtRestrained.setEditable(false);
		GridBagConstraints gbc_txtRestrained = new GridBagConstraints();
		gbc_txtRestrained.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtRestrained.insets = new Insets(0, 0, 5, 5);
		gbc_txtRestrained.gridx = 1;
		gbc_txtRestrained.gridy = 0;
		panel1.add(txtRestrained, gbc_txtRestrained);
		txtRestrained.setColumns(10);

		JLabel label_1 = new JLabel("\u8655\u7406\u8005");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 2;
		gbc_label_1.gridy = 0;
		panel1.add(label_1, gbc_label_1);

		txtProcess_user = new JTextField();
		txtProcess_user.setEditable(false);
		GridBagConstraints gbc_txtProcess_user = new GridBagConstraints();
		gbc_txtProcess_user.insets = new Insets(0, 0, 5, 5);
		gbc_txtProcess_user.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtProcess_user.gridx = 3;
		gbc_txtProcess_user.gridy = 0;
		panel1.add(txtProcess_user, gbc_txtProcess_user);
		txtProcess_user.setColumns(10);

		JLabel label_2 = new JLabel("\u8655\u7406\u65E5\u671F");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.anchor = GridBagConstraints.EAST;
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 4;
		gbc_label_2.gridy = 0;
		panel1.add(label_2, gbc_label_2);

		txtProcess_date = new JTextField();
		txtProcess_date.setEditable(false);
		GridBagConstraints gbc_txtProcess_date = new GridBagConstraints();
		gbc_txtProcess_date.insets = new Insets(0, 0, 5, 5);
		gbc_txtProcess_date.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtProcess_date.gridx = 5;
		gbc_txtProcess_date.gridy = 0;
		panel1.add(txtProcess_date, gbc_txtProcess_date);
		txtProcess_date.setColumns(10);

		txtPodi = new JTextField();
		txtPodi.setEditable(false);
		GridBagConstraints gbc_txtPodi = new GridBagConstraints();
		gbc_txtPodi.insets = new Insets(0, 0, 5, 5);
		gbc_txtPodi.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPodi.gridx = 6;
		gbc_txtPodi.gridy = 0;
		panel1.add(txtPodi, gbc_txtPodi);
		txtPodi.setColumns(10);

		JLabel label_3 = new JLabel("\u554F\u984C\u63CF\u8FF0");
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.insets = new Insets(0, 0, 0, 5);
		gbc_label_3.anchor = GridBagConstraints.EAST;
		gbc_label_3.gridx = 0;
		gbc_label_3.gridy = 1;
		panel1.add(label_3, gbc_label_3);

		txtRestrained_desc = new JTextField();
		txtRestrained_desc.setBackground(Color.WHITE);
		txtRestrained_desc.setEditable(false);
		GridBagConstraints gbc_txtRestrained_desc = new GridBagConstraints();
		gbc_txtRestrained_desc.gridwidth = 6;
		gbc_txtRestrained_desc.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtRestrained_desc.gridx = 1;
		gbc_txtRestrained_desc.gridy = 1;
		panel1.add(txtRestrained_desc, gbc_txtRestrained_desc);
		txtRestrained_desc.setColumns(10);

		JPanel panel2 = new JPanel();
		panel.add(panel2);
		panel2.setBorder(new TitledBorder(null, "\u4FDD\u6236\u8A0A\u606F",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel2.setLayout(new GridLayout(0, 1, 0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel2.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		table.setBackground(Color.yellow);

		JPanel panel3 = new JPanel();
		tabbedPane.addTab("\u8981\u4FDD\u4EBA\u8CC7\u6599", null, panel3, null);
		GridBagLayout gbl_panel3 = new GridBagLayout();
		gbl_panel3.columnWidths = new int[] { 581, 0 };
		gbl_panel3.rowHeights = new int[] { 30, 273, 231, 0 };
		gbl_panel3.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel3.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel3.setLayout(gbl_panel3);

		JPanel panel_1 = new JPanel();
		panel_1.setPreferredSize(new Dimension(10, 30));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.anchor = GridBagConstraints.NORTH;
		gbc_panel_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		panel3.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 74, 195, 0 };
		gbl_panel_1.rowHeights = new int[] { 25, 0 };
		gbl_panel_1.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		JLabel lblNewLabel = new JLabel(
				"\u8981\u4FDD\u4EBA\u59D3\u540D/ID\uFF1A");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel_1.add(lblNewLabel, gbc_lblNewLabel);

		txtName = new JTextField();
		txtName.setEditable(false);
		GridBagConstraints gbc_txtName = new GridBagConstraints();
		gbc_txtName.fill = GridBagConstraints.BOTH;
		gbc_txtName.gridx = 1;
		gbc_txtName.gridy = 0;
		panel_1.add(txtName, gbc_txtName);
		txtName.setColumns(10);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setPreferredSize(new Dimension(2, 300));
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.anchor = GridBagConstraints.NORTH;
		gbc_scrollPane_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 1;
		panel3.add(scrollPane_1, gbc_scrollPane_1);
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);

		// JScrollPane scrollPane_1 = new JScrollPane();
		// scrollPane_1.setPreferredSize(new Dimension(2, 30));
		// panel_2.add(scrollPane_1);
		//
		// table_1 = new JTable();
		// scrollPane_1.setViewportView(table_1);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null,
				"\u8981\u4FDD\u4EBA\u7279\u5B9A\u8CC7\u6599",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setPreferredSize(new Dimension(10, 280));
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 2;
		panel3.add(panel_3, gbc_panel_3);
		panel_3.setLayout(new GridLayout(0, 2, 0, 0));
		// 下左方Panel
		// SR130700054新增失聯保戶
		// 新增FATCA指示
		String[] headers1 = { "列管 / 手機", "列管 / E-MAIL", "台幣指定匯款帳戶", "失聯保戶",
				"FATCA指示" ,"簽樣卡"};
		String[] headers2 = { "電子表單/驗證", "自動化交易申請", "外幣指定匯款帳戶", "投資風險屬性",
				"未領還本金" };

		detailVerticalPane1 = new VerticalPane(headers1, "", 130, 25);
		detailVerticalPane2 = new VerticalPane(headers2, "", 130, 25);

		panel_3.add(detailVerticalPane1);
		panel_3.add(detailVerticalPane2);

		initDataBindings();

		table.getColumnModel().getColumn(0).setPreferredWidth(110);
		table.getColumnModel().getColumn(0).setMaxWidth(120);
		table.getColumnModel().getColumn(1).setPreferredWidth(75);
		table.getColumnModel().getColumn(1).setMaxWidth(90);
		table.getColumnModel().getColumn(3).setPreferredWidth(75);
		table.getColumnModel().getColumn(3).setMaxWidth(90);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setMaxWidth(160);

		table_1.getColumnModel().getColumn(0).setPreferredWidth(110);
		table_1.getColumnModel().getColumn(0).setMaxWidth(120);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(60);
		table_1.getColumnModel().getColumn(1).setMaxWidth(120);
		table_1.getColumnModel().getColumn(2).setPreferredWidth(60);
		table_1.getColumnModel().getColumn(2).setMaxWidth(120);
		table_1.getColumnModel().getColumn(3).setPreferredWidth(20);
		table_1.getColumnModel().getColumn(3).setMaxWidth(105);
	}

	public void setController(ClientInfoController controller) {
		this.controller = controller;
	}

	public void setProblem(String restrained, String process_user,
			String process_date, String restrained_desc, String other_prob) {
		txtRestrained.setText(restrained);
		txtProcess_user.setText(process_user);
		txtProcess_date.setText(process_date);
		txtRestrained_desc.setText(restrained_desc);
		txtPodi.setText(other_prob);
		if (!other_prob.isEmpty() && other_prob.length() > 0) {
			txtPodi.setBackground(Color.yellow);
			txtPodi.setForeground(Color.red);
		} else
			txtPodi.setBackground(txtProcess_date.getBackground());
	}

	public void addClientInfopanel(ClientInfo02 clientInfo02) {
		clientInfo02Group.addClientInfo02(clientInfo02);
	}

	public void addClientInfoTab(ClientInfo03 clientInfo03) {
		clientInfo03Group.addClientInfo03(clientInfo03);
	}

	public void setO1name(String id, String name) {
		txtName.setText(name + " / " + id);
	}

	public void setValues(ClientInfo04 clientInfo04) {
		detailVerticalPane1.setValue(clientInfo04.getValues(1));
		detailVerticalPane2.setValue(clientInfo04.getValues(2));
	}

	public void clearAll() {
		// System.out.println("clear");
		// String[] clear1 = {"","",""};
		// String[] clear2 = {"","",""};
		detailVerticalPane1.clearValues();
		detailVerticalPane2.clearValues();
		// detailVerticalPane1.setValue(clear1);
		// detailVerticalPane2.setValue(clear2);
		txtRestrained.setText("");
		txtProcess_user.setText("");
		txtProcess_date.setText("");
		txtRestrained_desc.setText("");
		txtName.setText("");
		clientInfo02Group.removeAll();
		clientInfo03Group.removeAll();
	}

	public void nullAll() {
		clientInfo02Group = null;
		clientInfo03Group = null;
		table = null;
		table_1 = null;
	}

	protected void initDataBindings() {
		BeanProperty<ClientInfo02Group, List<ClientInfo02>> clientInfo02GroupBeanProperty = BeanProperty
				.create("clientInfo02s");
		JTableBinding<ClientInfo02, ClientInfo02Group, JTable> jTableBinding = SwingBindings
				.createJTableBinding(UpdateStrategy.READ, clientInfo02Group,
						clientInfo02GroupBeanProperty, table);
		//
		BeanProperty<ClientInfo02, String> clientInfo02BeanProperty = BeanProperty
				.create("policy_no");
		jTableBinding.addColumnBinding(clientInfo02BeanProperty).setColumnName(
				"\u4FDD\u55AE\u865F\u78BC");
		//
		BeanProperty<ClientInfo02, String> clientInfo02BeanProperty_1 = BeanProperty
				.create("eccm_type");
		jTableBinding.addColumnBinding(clientInfo02BeanProperty_1)
				.setColumnName("\u8A0A\u606F\u7A2E\u985E");
		//
		BeanProperty<ClientInfo02, String> clientInfo02BeanProperty_2 = BeanProperty
				.create("comments");
		jTableBinding.addColumnBinding(clientInfo02BeanProperty_2)
				.setColumnName("\u8A0A\u606F\u5167\u5BB9");
		//
		BeanProperty<ClientInfo02, String> clientInfo02BeanProperty_3 = BeanProperty
				.create("crt_date");
		jTableBinding.addColumnBinding(clientInfo02BeanProperty_3)
				.setColumnName("\u901A\u77E5\u65E5\u671F").setEditable(false);
		//
		BeanProperty<ClientInfo02, String> clientInfo02BeanProperty_4 = BeanProperty
				.create("dept_name");
		jTableBinding.addColumnBinding(clientInfo02BeanProperty_4)
				.setColumnName("\u767C\u9001\u55AE\u4F4D").setEditable(false);
		//
		jTableBinding.setEditable(false);
		jTableBinding.bind();
		//
		BeanProperty<ClientInfo03Group, List<ClientInfo03>> clientInfo03GroupBeanProperty = BeanProperty
				.create("clientInfo03s");
		JTableBinding<ClientInfo03, ClientInfo03Group, JTable> jTableBinding_1 = SwingBindings
				.createJTableBinding(UpdateStrategy.READ, clientInfo03Group,
						clientInfo03GroupBeanProperty, table_1);
		//
		BeanProperty<ClientInfo03, String> clientInfo03BeanProperty = BeanProperty
				.create("policy_no");
		jTableBinding_1.addColumnBinding(clientInfo03BeanProperty)
				.setColumnName("\u4FDD\u55AE\u865F\u78BC").setEditable(false);
		//
		BeanProperty<ClientInfo03, String> clientInfo03BeanProperty_1 = BeanProperty
				.create("mail_addr_ind");
		jTableBinding_1.addColumnBinding(clientInfo03BeanProperty_1)
				.setColumnName("\u6536\u8CBB\u5730\u5740\u6307\u793A")
				.setEditable(false);
		//
		BeanProperty<ClientInfo03, String> clientInfo03BeanProperty_2 = BeanProperty
				.create("home_addr_ind");
		jTableBinding_1.addColumnBinding(clientInfo03BeanProperty_2)
				.setColumnName("\u4F4F\u6240\u5730\u5740\u6307\u793A")
				.setEditable(false);
		//
		BeanProperty<ClientInfo03, String> clientInfo03BeanProperty_3 = BeanProperty
				.create("pmia_sts");
		jTableBinding_1.addColumnBinding(clientInfo03BeanProperty_3)
				.setColumnName("\u7121\u6548\u6536\u8CBB\u5730\u5740")
				.setEditable(false);
		//
		BeanProperty<ClientInfo03, String> clientInfo03BeanProperty_4 = BeanProperty
				.create("mail_addr");
		jTableBinding_1.addColumnBinding(clientInfo03BeanProperty_4)
				.setColumnName("\u6536\u8CBB\u5730\u5740").setEditable(false);
		//
		BeanProperty<ClientInfo03, String> clientInfo03BeanProperty_5 = BeanProperty
				.create("home_addr");
		jTableBinding_1.addColumnBinding(clientInfo03BeanProperty_5)
				.setColumnName("\u4F4F\u6240\u5730\u5740");
		//
		jTableBinding_1.bind();
	}
}
