package query.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SpringLayout;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;

import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

import query.controller.MultiLineCellRenderer;
import query.model.PoRelation.PoRelation;
import query.model.PoRelation.PoRelationAG;
import query.model.PoRelation.PoRelationAGGroup;
import query.model.PoRelation.PoRelationGroup;
import query.model.PoRelation.PoRelationPA;
import query.model.PoRelation.PoRelationPAGroup;

/**
 * @ * @author FYYANG
 * 
 * @version 1.0<br>
 *          100/07/28<br>
 *          關係人資料查詢JPanel
 * 
 * @since 1.0
 */
public class PoRelationJPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable relationtable;
	private PoRelationGroup group = new PoRelationGroup();
	private PoRelationAGGroup agGroup = new PoRelationAGGroup();
	private PoRelationPAGroup paGroup = new PoRelationPAGroup();
	private JTable agenttable;
	private JTextField collectorField;
	private JTable relationpatable;

	/**
	 * Create the panel.
	 */
	public PoRelationJPanel() {
		setLayout(new GridLayout(2, 1, 0, 0));

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(
				null,
				"\u8981\u4FDD\u4EBA\u3001\u88AB\u4FDD\u96AA\u4EBA\u3001\u53D7\u76CA\u4EBA\u8CC7\u6599",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);

		JPanel panel_3 = new JPanel();
		sl_panel.putConstraint(SpringLayout.NORTH, panel_3, 0,
				SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, panel_3, 0,
				SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_3, -80,
				SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, panel_3, 0,
				SpringLayout.EAST, panel);
		panel.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));

		relationtable = new JTable();
		relationtable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		relationtable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

		JScrollPane relationscrollPane = new JScrollPane();
		panel_3.add(relationscrollPane, BorderLayout.CENTER);
		relationscrollPane.setViewportView(relationtable);

		relationtable.setDefaultRenderer(Object.class,
				new DefaultTableCellRenderer() {
					/**
					 * 字體與其他相同,且變黃色的地方select會反白
					 */
					private static final long serialVersionUID = 1L;

					public Component getTableCellRendererComponent(
							JTable table, Object value, boolean isSelected,
							boolean hasFocus, int row, int col) {
						super.getTableCellRendererComponent(table, value,
								isSelected, hasFocus, row, col);
						try {
							int i = Integer.parseInt(table.getModel()
									.getValueAt(row, 6).toString());
							String relation = table.getModel()
									.getValueAt(row, 0).toString();
							// 信託受益人無比例但不要黃色
							if (i <= 0 && !relation.equals("信託受益人"))
								setBackground(Color.yellow);
							else
								setBackground(Color.white);

							if (isSelected)
								setBackground(table.getSelectionBackground());

						} catch (Exception e) {
							setBackground(Color.white);
							return this;
						}
						setValue(value == null ? "" : value.toString());
						return this;
					}
				});

		JPanel panel_4 = new JPanel();
		sl_panel.putConstraint(SpringLayout.NORTH, panel_4, 0,
				SpringLayout.SOUTH, panel_3);
		sl_panel.putConstraint(SpringLayout.WEST, panel_4, 0,
				SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_4, 0,
				SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, panel_4, 0,
				SpringLayout.EAST, panel);
		panel_4.setSize(10, 10);
		panel.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		relationpatable = new JTable();
		relationpatable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		relationpatable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		relationpatable.setRowHeight(relationpatable.getRowHeight() * 3);
		relationpatable.setDefaultRenderer(String.class,
				new MultiLineCellRenderer());
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_4.add(scrollPane_1);
		scrollPane_1.setViewportView(relationpatable);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null,
				"\u696D\u52D9\u54E1\u8CC7\u6599", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane);

		agenttable = new JTable();
		agenttable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		agenttable.setRowHeight(agenttable.getRowHeight() * 2);
		agenttable
				.setDefaultRenderer(String.class, new MultiLineCellRenderer());
		agenttable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		scrollPane.setViewportView(agenttable);

		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.SOUTH);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] { 0, 0, 0 };
		gbl_panel_2.rowHeights = new int[] { 0, 0 };
		gbl_panel_2.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_2.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_2.setLayout(gbl_panel_2);

		JLabel lblNewLabel = new JLabel("\u6536\u8CBB\u54E1/\u4EE3\u78BC");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel_2.add(lblNewLabel, gbc_lblNewLabel);

		collectorField = new JTextField();
		collectorField.setEditable(false);
		GridBagConstraints gbc_collectorField = new GridBagConstraints();
		gbc_collectorField.anchor = GridBagConstraints.WEST;
		gbc_collectorField.gridx = 1;
		gbc_collectorField.gridy = 0;
		panel_2.add(collectorField, gbc_collectorField);
		collectorField.setColumns(10);
		initDataBindings();
		// 調整關係人地址欄位較大
		relationtable.getColumnModel().getColumn(10).setPreferredWidth(365);
		// 預設營業處地址欄位較大
		agenttable.getColumnModel().getColumn(0).setPreferredWidth(75);
		agenttable.getColumnModel().getColumn(1).setPreferredWidth(80);
		agenttable.getColumnModel().getColumn(2).setPreferredWidth(60);
		agenttable.getColumnModel().getColumn(3).setPreferredWidth(70);
		agenttable.getColumnModel().getColumn(4).setPreferredWidth(50);
		agenttable.getColumnModel().getColumn(5).setPreferredWidth(75);
		agenttable.getColumnModel().getColumn(6).setPreferredWidth(80);
		agenttable.getColumnModel().getColumn(7).setPreferredWidth(80);
		agenttable.getColumnModel().getColumn(8).setPreferredWidth(365);
		agenttable.getColumnModel().getColumn(9).setPreferredWidth(35);

		// 代理投保單位欄位
		relationpatable.getColumnModel().getColumn(0).setPreferredWidth(70);
		relationpatable.getColumnModel().getColumn(1).setPreferredWidth(40);
		relationpatable.getColumnModel().getColumn(2).setPreferredWidth(40);
		relationpatable.getColumnModel().getColumn(4).setPreferredWidth(40);
		relationpatable.getColumnModel().getColumn(5).setPreferredWidth(110);
		relationpatable.getColumnModel().getColumn(6).setPreferredWidth(80);

	}

	/**
	 * 新增關係人資料至關係人群組(RelationGroup)
	 * 
	 * @param relation
	 *            Relation物件
	 */
	public void addRelation(PoRelation relation) {
		group.addRelation(relation);
	}

	public void clearAll() {
		group.removeAll();
		agGroup.removeAll();
		paGroup.removeAll();
		collectorField.setText("");
	}

	/**
	 * 將全域變數全部指向NULL,利於JAVA記憶體回收系統回收記憶體
	 */
	public void nullAll() {
		relationtable = null;
		group = null;
		agGroup = null;
		paGroup = null;
		agenttable = null;
		collectorField = null;
	}

	/**
	 * 新增業務員資料至業務員群組(RelationAGGroup)
	 * 
	 * @param relation
	 *            RelationAG物件
	 */
	public void addRelationAG(PoRelationAG relation) {
		agGroup.addRelationAG(relation);
	}

	/**
	 * 新增PA資料至意外險群組(RelationPAGroup)
	 * 
	 * @param relation
	 *            RelationPA物件
	 */
	public void addRelationPA(PoRelationPA relation) {
		paGroup.addRelationPA(relation);
	}

	public void setCollector(String collector) {
		collectorField.setText(collector);
	}

	protected void initDataBindings() {
		BeanProperty<PoRelationGroup, List<PoRelation>> relationGroupBeanProperty = BeanProperty
				.create("relations");
		JTableBinding<PoRelation, PoRelationGroup, JTable> jTableBinding = SwingBindings
				.createJTableBinding(UpdateStrategy.READ, group,
						relationGroupBeanProperty, relationtable);
		//
		BeanProperty<PoRelation, String> poRelationBeanProperty = BeanProperty
				.create("relation");
		jTableBinding.addColumnBinding(poRelationBeanProperty).setColumnName(
				"\u95DC\u4FC2");
		//
		BeanProperty<PoRelation, String> poRelationBeanProperty_1 = BeanProperty
				.create("names");
		jTableBinding.addColumnBinding(poRelationBeanProperty_1).setColumnName(
				"\u59D3\u540D");
		//
		BeanProperty<PoRelation, String> poRelationBeanProperty_2 = BeanProperty
				.create("sex");
		jTableBinding.addColumnBinding(poRelationBeanProperty_2).setColumnName(
				"\u6027\u5225");
		//
		BeanProperty<PoRelation, String> poRelationBeanProperty_3 = BeanProperty
				.create("birth_date");
		jTableBinding.addColumnBinding(poRelationBeanProperty_3).setColumnName(
				"\u51FA\u751F\u65E5\u671F");
		//
		BeanProperty<PoRelation, String> poRelationBeanProperty_4 = BeanProperty
				.create("client_id");
		jTableBinding.addColumnBinding(poRelationBeanProperty_4)
				.setColumnName("\u8EAB\u4EFD\u8B49\u5B57\u865F")
				.setEditable(false);
		//
		BeanProperty<PoRelation, String> poRelationBeanProperty_5 = BeanProperty
				.create("benf_order");
		jTableBinding.addColumnBinding(poRelationBeanProperty_5).setColumnName(
				"\u53D7\u76CA\u9806\u4F4D");
		//
		BeanProperty<PoRelation, String> poRelationBeanProperty_6 = BeanProperty
				.create("benf_ratio");
		jTableBinding.addColumnBinding(poRelationBeanProperty_6).setColumnName(
				"\u53D7\u76CA\u6BD4\u4F8B");
		//
		BeanProperty<PoRelation, String> poRelationBeanProperty_7 = BeanProperty
				.create("related_key");
		jTableBinding.addColumnBinding(poRelationBeanProperty_7).setColumnName(
				"\u8207I1\u95DC\u4FC2");
		//
		BeanProperty<PoRelation, String> poRelationBeanProperty_8 = BeanProperty
				.create("liaison_type");
		jTableBinding.addColumnBinding(poRelationBeanProperty_8)
				.setColumnName("\u806F\u7D61\u65B9\u5F0F").setEditable(false);
		//
		BeanProperty<PoRelation, String> poRelationBeanProperty_9 = BeanProperty
				.create("benf_tel");
		jTableBinding.addColumnBinding(poRelationBeanProperty_9)
				.setColumnName("\u96FB\u8A71").setEditable(false);
		//
		BeanProperty<PoRelation, String> poRelationBeanProperty_10 = BeanProperty
				.create("benf_address");
		jTableBinding.addColumnBinding(poRelationBeanProperty_10)
				.setColumnName("\u5730\u5740").setEditable(false);
		//
		jTableBinding.setEditable(false);
		jTableBinding.bind();
		//
		BeanProperty<PoRelationPAGroup, List<PoRelationPA>> poRelationPAGroupBeanProperty = BeanProperty
				.create("relationPAs");
		JTableBinding<PoRelationPA, PoRelationPAGroup, JTable> jTableBinding_2 = SwingBindings
				.createJTableBinding(UpdateStrategy.READ, paGroup,
						poRelationPAGroupBeanProperty, relationpatable);
		//
		BeanProperty<PoRelationPA, String> poRelationPABeanProperty = BeanProperty
				.create("r_popu_code");
		jTableBinding_2
				.addColumnBinding(poRelationPABeanProperty)
				.setColumnName(
						"\u4EE3\u7406\u6295\u4FDD\u55AE\u4F4D\u7DE8\u865F")
				.setColumnClass(String.class);
		//
		BeanProperty<PoRelationPA, String> poRelationPABeanProperty_1 = BeanProperty
				.create("r_assigner");
		jTableBinding_2.addColumnBinding(poRelationPABeanProperty_1)
				.setColumnName("\u4EE3\u8868\u4EBA")
				.setColumnClass(String.class);
		//
		BeanProperty<PoRelationPA, String> poRelationPABeanProperty_2 = BeanProperty
				.create("r_company_name");
		jTableBinding_2.addColumnBinding(poRelationPABeanProperty_2)
				.setColumnName("\u55AE\u4F4D\u540D\u7A31")
				.setColumnClass(String.class);
		//
		BeanProperty<PoRelationPA, String> poRelationPABeanProperty_3 = BeanProperty
				.create("r_address");
		jTableBinding_2.addColumnBinding(poRelationPABeanProperty_3)
				.setColumnName("\u55AE\u4F4D\u5730\u5740")
				.setColumnClass(String.class);
		//
		BeanProperty<PoRelationPA, String> poRelationPABeanProperty_4 = BeanProperty
				.create("r_tel_1");
		jTableBinding_2.addColumnBinding(poRelationPABeanProperty_4)
				.setColumnName("\u96FB\u8A71").setColumnClass(String.class);
		//
		BeanProperty<PoRelationPA, String> poRelationPABeanProperty_5 = BeanProperty
				.create("r_desc1");
		jTableBinding_2
				.addColumnBinding(poRelationPABeanProperty_5)
				.setColumnName(
						"\u4EE3\u7406\u6295\u4FDD\u55AE\u4F4D\u8207\u8981\u4FDD\u4EBA\u95DC\u4FC2")
				.setColumnClass(String.class);
		//
		BeanProperty<PoRelationPA, String> poRelationPABeanProperty_6 = BeanProperty
				.create("r_desc2");
		jTableBinding_2
				.addColumnBinding(poRelationPABeanProperty_6)
				.setColumnName(
						"\u8981/\u88AB\u4FDD\u96AA\u4EBA\u8EAB\u5206\u5225")
				.setColumnClass(String.class);
		//
		jTableBinding_2.setEditable(false);
		jTableBinding_2.bind();
		//
		BeanProperty<PoRelationAGGroup, List<PoRelationAG>> poRelationAGGroupBeanProperty = BeanProperty
				.create("relationAGs");
		JTableBinding<PoRelationAG, PoRelationAGGroup, JTable> jTableBinding_1 = SwingBindings
				.createJTableBinding(UpdateStrategy.READ, agGroup,
						poRelationAGGroupBeanProperty, agenttable);
		//
		BeanProperty<PoRelationAG, String> poRelationAGBeanProperty = BeanProperty
				.create("relation_desc");
		jTableBinding_1.addColumnBinding(poRelationAGBeanProperty)
				.setColumnName("\u95DC\u4FC2").setEditable(false);
		//
		BeanProperty<PoRelationAG, String> poRelationAGBeanProperty_1 = BeanProperty
				.create("agent_code");
		jTableBinding_1.addColumnBinding(poRelationAGBeanProperty_1)
				.setColumnName("\u8EAB\u5206\u8B49\u5B57\u865F")
				.setEditable(false);
		//
		BeanProperty<PoRelationAG, String> poRelationAGBeanProperty_10 = BeanProperty
				.create("r_agent_no");
		jTableBinding_1.addColumnBinding(poRelationAGBeanProperty_10)
				.setColumnName("\u767B\u9304\u5B57\u865F").setEditable(false);
		//
		BeanProperty<PoRelationAG, String> poRelationAGBeanProperty_2 = BeanProperty
				.create("agent_name");
		jTableBinding_1.addColumnBinding(poRelationAGBeanProperty_2)
				.setColumnName("\u59D3\u540D").setEditable(false);
		//
		BeanProperty<PoRelationAG, String> poRelationAGBeanProperty_3 = BeanProperty
				.create("level");
		jTableBinding_1.addColumnBinding(poRelationAGBeanProperty_3)
				.setColumnName("\u8077\u7D1A").setEditable(false);
		//
		BeanProperty<PoRelationAG, String> poRelationAGBeanProperty_4 = BeanProperty
				.create("dept_code");
		jTableBinding_1.addColumnBinding(poRelationAGBeanProperty_4)
				.setColumnName("\u71DF\u696D\u8655").setEditable(false);
		//
		BeanProperty<PoRelationAG, String> poRelationAGBeanProperty_5 = BeanProperty
				.create("mobile");
		jTableBinding_1.addColumnBinding(poRelationAGBeanProperty_5)
				.setColumnName("\u884C\u52D5\u96FB\u8A71").setEditable(false);
		//
		BeanProperty<PoRelationAG, String> poRelationAGBeanProperty_6 = BeanProperty
				.create("tel2");
		jTableBinding_1.addColumnBinding(poRelationAGBeanProperty_6)
				.setColumnName("\u71DF\u696D\u8655\u96FB\u8A71")
				.setEditable(false);
		//
		BeanProperty<PoRelationAG, String> poRelationAGBeanProperty_7 = BeanProperty
				.create("address");
		jTableBinding_1.addColumnBinding(poRelationAGBeanProperty_7)
				.setColumnName("\u71DF\u696D\u8655\u5730\u5740")
				.setEditable(false);
		//
		BeanProperty<PoRelationAG, String> poRelationAGBeanProperty_8 = BeanProperty
				.create("comm_share");
		jTableBinding_1.addColumnBinding(poRelationAGBeanProperty_8)
				.setColumnName("\u6BD4\u4F8B").setEditable(false);
		//
		BeanProperty<PoRelationAG, String> poRelationAGBeanProperty_9 = BeanProperty
				.create("writing_class");
		jTableBinding_1.addColumnBinding(poRelationAGBeanProperty_9)
				.setColumnName("\u62DB\u652C\u6388\u6B0A\u5206\u985E")
				.setEditable(false);
		//
		jTableBinding_1.setEditable(false);
		jTableBinding_1.bind();
	}
}
