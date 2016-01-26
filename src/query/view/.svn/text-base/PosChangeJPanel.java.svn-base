package query.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListSelectionModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

import query.controller.MultiLineCellRenderer;
import query.controller.PosChangeController;
import query.model.PosChange.PosChange01;
import query.model.PosChange.PosChange02;
import query.model.PosChange.PosChange03;
import query.model.PosChange.PosChange04;
import query.model.PosChange.PosChange05;
import query.model.PosChange.PosChangeGroup01;
import query.model.PosChange.PosChangeGroup02;
import query.model.PosChange.PosChangeGroup03;
import query.model.PosChange.PosChangeGroup04;
import query.model.PosChange.PosChangeGroup05;

public class PosChangeJPanel extends JPanel implements ListSelectionListener {
	private static final long serialVersionUID = 1L;
	private PosChangeGroup01 posChangeGroup01 = new PosChangeGroup01();
	private PosChangeGroup02 posChangeGroup02 = new PosChangeGroup02();
	private PosChangeGroup03 posChangeGroup03 = new PosChangeGroup03();
	private PosChangeGroup04 posChangeGroup04 = new PosChangeGroup04();
	private PosChangeGroup05 posChangeGroup05 = new PosChangeGroup05();
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTable table_3;
	private PosChangeController posChangeController;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTabbedPane tabbedPane;
	private JTable table_4;

	public PosChangeJPanel() {
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel("  \u4FDD\u55AE\u865F\u78BC  :");

		textField = new JTextField();
		// textField.setBackground(Color.LIGHT_GRAY);
		textField.setColumns(10);

		JLabel lblid = new JLabel("  \u7533\u8ACB\u4EBAID  :");

		textField_1 = new JTextField();
		textField_1.setColumns(10);

		JLabel label = new JLabel("  \u53D7\u7406\u865F\u78BC  :");

		textField_2 = new JTextField();
		textField_2.setColumns(10);

		JButton btnNewButton = new JButton("\u9001\u51FA"); // 101.04.02
															// 新增保單號碼/申請人ID/受理號碼
															// 之索引
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				posChangeController.executeMission(textField.getText(), "",
						textField_1.getText(), textField_2.getText());// 保單號碼/申請人ID/受理號碼
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_panel.createSequentialGroup()
						.addGap(7)
						.addComponent(lblNewLabel)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblid)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(label)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnNewButton)));
		gl_panel.setVerticalGroup(gl_panel
				.createParallelGroup(Alignment.LEADING)
				.addGroup(
						gl_panel.createSequentialGroup()
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.LEADING)
												.addGroup(
														gl_panel.createSequentialGroup()
																.addGap(11)
																.addComponent(
																		lblNewLabel))
												.addGroup(
														gl_panel.createSequentialGroup()
																.addGap(11)
																.addComponent(
																		lblid))
												.addGroup(
														gl_panel.createSequentialGroup()
																.addGap(11)
																.addComponent(
																		label))
												.addGroup(
														gl_panel.createSequentialGroup()
																.addGap(7)
																.addComponent(
																		btnNewButton))
												.addGroup(
														gl_panel.createSequentialGroup()
																.addGap(7)
																.addComponent(
																		textField,
																		GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE))
												.addGroup(
														gl_panel.createSequentialGroup()
																.addGap(7)
																.addComponent(
																		textField_1,
																		GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE))
												.addGroup(
														gl_panel.createSequentialGroup()
																.addGap(7)
																.addComponent(
																		textField_2,
																		GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE)))
								.addContainerGap(GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)));
		panel.setLayout(gl_panel);

		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.5);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		add(splitPane, BorderLayout.CENTER);

		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setResizeWeight(0.5);
		splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setLeftComponent(splitPane_1);

		JScrollPane scrollPane = new JScrollPane();
		splitPane_1.setLeftComponent(scrollPane);
		scrollPane.setBorder(new TitledBorder(null,
				"\u5951\u7D04\u8B8A\u66F4\u8A18\u9304", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));

		table = new JTable();
		table.setToolTipText("點擊以顯示下方明細");
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		ListSelectionModel table_model = table.getSelectionModel();
		table_model.addListSelectionListener(this);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "\u53D7\u7406\u9805\u76EE",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 70,
						213)));
		splitPane_1.setRightComponent(scrollPane_1);

		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);

		JSplitPane splitPane_2 = new JSplitPane();
		splitPane_2.setResizeWeight(0.5);
		splitPane_2.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setRightComponent(splitPane_2);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 70, 213)));
		tabbedPane = new JTabbedPane();
		tabbedPane.setForeground(Color.BLUE);
		tabbedPane.addTab("檢附文件", null, scrollPane_2, null);
		splitPane_2.setLeftComponent(tabbedPane);

		table_2 = new JTable();
		scrollPane_2.setViewportView(table_2);

		JScrollPane scrollPane_4 = new JScrollPane();
		tabbedPane.addTab("\u5176\u5B83\u5951\u8B8A\u4FDD\u55AE\u67E5\u8A62",
				null, scrollPane_4, null);

		table_4 = new JTable();
		scrollPane_4.setViewportView(table_4);

		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"),
				"\u9000\u4EF6\u539F\u56E0\u8AAA\u660E", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 70, 213)));
		splitPane_2.setRightComponent(scrollPane_3);

		table_3 = new JTable();
		scrollPane_3.setViewportView(table_3);
		initDataBindings();
		table_1.getColumnModel().getColumn(0).setMaxWidth(150);
		table_1.getColumnModel().getColumn(0).setMinWidth(150);
		table_2.getColumnModel().getColumn(0).setMaxWidth(150);
		table_2.getColumnModel().getColumn(0).setMinWidth(150);
		table_3.getColumnModel().getColumn(0).setMaxWidth(150);
		table_3.getColumnModel().getColumn(0).setMinWidth(150);
		table_3.setRowHeight(table_3.getRowHeight() * 2);
		table_3.setDefaultRenderer(String.class, new MultiLineCellRenderer());

	}

	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		// TODO Auto-generated method stub
		// if (arg0.getValueIsAdjusting()) {
		if (!((DefaultListSelectionModel) arg0.getSource())
				.getValueIsAdjusting()) {
			setTabPaneEnable();
			getNewData();
			setTabPaneDisable();
		}

	}

	public void getNewData() {
		int rowSelected = table.getSelectedRow();
		if (rowSelected != -1) {

			// 清除原畫面資料
			clearPosChange02();
			clearPosChange03();
			clearPosChange04();
			clearPosChange05();

			// 受理項目部份
			posChangeController.executeInnerMission02(posChangeGroup01
					.getPosChange01s().get(rowSelected).getR_po_chg_rece_no());

			// 檢附文件部份
			posChangeController.executeInnerMission03(posChangeGroup01
					.getPosChange01s().get(rowSelected).getR_po_chg_rece_no());

			// 退件原因部份

			posChangeController.executeInnerMission04(posChangeGroup01
					.getPosChange01s().get(rowSelected).getR_po_chg_rece_no());

			// 其它契變保單查詢
			posChangeController.executeInnerMission05(posChangeGroup01
					.getPosChange01s().get(rowSelected).getR_po_chg_rece_no());

		}
	}

	public void setController(PosChangeController controller) {
		posChangeController = controller;
	}

	public void addPosChange01(PosChange01 posChange01) {
		posChangeGroup01.addPosChange01(posChange01);
	}

	public void addPosChange02(PosChange02 posChange02) {
		posChangeGroup02.addPosChange02(posChange02);
	}

	public void addPosChange03(PosChange03 posChange03) {
		posChangeGroup03.addPosChange03(posChange03);
	}

	public void addPosChange04(PosChange04 posChange04) {
		posChangeGroup04.addPosChange04(posChange04);
	}

	public void addPosChange05(PosChange05 posChange05) {
		posChangeGroup05.addPosChange05(posChange05);
	}

	public void setDefaultRow() {
		if (table.getRowCount() > 0) {
			ListSelectionModel selectionModel = table.getSelectionModel();
			selectionModel.setSelectionInterval(0, 0);
		}
	}

	public void clearPosChange01() {
		posChangeGroup01.removeAll();
	}

	public void clearPosChange02() {
		posChangeGroup02.removeAll();
	}

	public void clearPosChange03() {
		posChangeGroup03.removeAll();
	}

	public void clearPosChange04() {
		posChangeGroup04.removeAll();
	}

	public void clearPosChange05() {
		posChangeGroup05.removeAll();
	}

	public void clearAll() {
		posChangeGroup01.removeAll();
		posChangeGroup02.removeAll();
		posChangeGroup03.removeAll();
		posChangeGroup04.removeAll();
		posChangeGroup05.removeAll();
	}

	/**
	 * 將全域變數全部指向NULL,利於JAVA記憶體回收系統回收記憶體
	 */
	public void nullAll() {
		table = null;
		table_1 = null;
		table_2 = null;
		table_3 = null;
		table_4 = null;
		posChangeGroup01 = null;
		posChangeGroup02 = null;
		posChangeGroup03 = null;
		posChangeGroup04 = null;
		posChangeGroup05 = null;
	}

	public void setPONO(String policy_no) {
		textField.setText(policy_no);
		textField_1.setText("");
		textField_2.setText("");
	}

	public void setTabPaneEnable() {
		for (int i = 0; i < tabbedPane.getComponentCount(); i++) {
			tabbedPane.setEnabledAt(i, true);
		}
	}

	public void setTabPaneDisable() {
		if (posChangeGroup05.getPosChange05sCount() == 0) {
			tabbedPane.setEnabledAt(tabbedPane.indexOfTab("其它契變保單查詢"), false);
		}
	}

	protected void initDataBindings() {
		BeanProperty<PosChangeGroup01, List<PosChange01>> posChangeGroup01BeanProperty = BeanProperty
				.create("posChange01s");
		JTableBinding<PosChange01, PosChangeGroup01, JTable> jTableBinding = SwingBindings
				.createJTableBinding(UpdateStrategy.READ, posChangeGroup01,
						posChangeGroup01BeanProperty, table);
		//
		BeanProperty<PosChange01, String> posChange01BeanProperty = BeanProperty
				.create("r_po_chg_rece_no");
		jTableBinding.addColumnBinding(posChange01BeanProperty).setColumnName(
				"\u53D7\u7406\u865F\u78BC");
		//
		BeanProperty<PosChange01, String> posChange01BeanProperty_1 = BeanProperty
				.create("r_po_chg_rece_date");
		jTableBinding.addColumnBinding(posChange01BeanProperty_1)
				.setColumnName("\u53D7\u7406\u65E5\u671F");
		//
		BeanProperty<PosChange01, String> posChange01BeanProperty_2 = BeanProperty
				.create("r_policy_no");
		jTableBinding.addColumnBinding(posChange01BeanProperty_2)
				.setColumnName("\u4FDD\u55AE\u865F\u78BC");
		//
		BeanProperty<PosChange01, String> posChange01BeanProperty_3 = BeanProperty
				.create("r_applicant_id");
		jTableBinding.addColumnBinding(posChange01BeanProperty_3)
				.setColumnName("\u7533\u8ACB\u4EBAID");
		//
		BeanProperty<PosChange01, String> posChange01BeanProperty_8 = BeanProperty
				.create("r_dept_code");
		jTableBinding.addColumnBinding(posChange01BeanProperty_8)
				.setColumnName("單位");
		//
		BeanProperty<PosChange01, String> posChange01BeanProperty_4 = BeanProperty
				.create("r_agent_name");
		jTableBinding.addColumnBinding(posChange01BeanProperty_4)
				.setColumnName("\u4EE3\u8FA6\u4EBA");
		//
		BeanProperty<PosChange01, String> posChange01BeanProperty_5 = BeanProperty
				.create("r_accesser_name");
		jTableBinding.addColumnBinding(posChange01BeanProperty_5)
				.setColumnName("\u627F\u8FA6\u4EBA");
		//
		BeanProperty<PosChange01, String> posChange01BeanProperty_6 = BeanProperty
				.create("r_sts_desc");
		jTableBinding.addColumnBinding(posChange01BeanProperty_6)
				.setColumnName("\u53D7\u7406\u72C0\u6CC1");
		//
		BeanProperty<PosChange01, String> posChange01BeanProperty_7 = BeanProperty
				.create("r_po_chg_sts_date");
		jTableBinding.addColumnBinding(posChange01BeanProperty_7)
				.setColumnName("\u72C0\u6CC1\u65E5\u671F");
		//
		jTableBinding.setEditable(false);
		jTableBinding.bind();
		//
		BeanProperty<PosChangeGroup02, List<PosChange02>> posChangeGroup02BeanProperty = BeanProperty
				.create("posChange02s");
		JTableBinding<PosChange02, PosChangeGroup02, JTable> jTableBinding_1 = SwingBindings
				.createJTableBinding(UpdateStrategy.READ, posChangeGroup02,
						posChangeGroup02BeanProperty, table_1);
		//
		BeanProperty<PosChange02, String> posChange02BeanProperty = BeanProperty
				.create("r_po_chg_code");
		jTableBinding_1.addColumnBinding(posChange02BeanProperty)
				.setColumnName("\u53D7\u7406\u9805\u76EE");
		//
		BeanProperty<PosChange02, String> posChange02BeanProperty_1 = BeanProperty
				.create("r_po_chg_desc");
		jTableBinding_1.addColumnBinding(posChange02BeanProperty_1)
				.setColumnName("\u53D7\u7406\u9805\u76EE\u8AAA\u660E");
		//
		jTableBinding_1.setEditable(false);
		jTableBinding_1.bind();
		//
		BeanProperty<PosChangeGroup03, List<PosChange03>> posChangeGroup03BeanProperty = BeanProperty
				.create("posChange03s");
		JTableBinding<PosChange03, PosChangeGroup03, JTable> jTableBinding_2 = SwingBindings
				.createJTableBinding(UpdateStrategy.READ, posChangeGroup03,
						posChangeGroup03BeanProperty, table_2);
		//
		BeanProperty<PosChange03, String> posChange03BeanProperty = BeanProperty
				.create("r_po_chg_doc_code");
		jTableBinding_2.addColumnBinding(posChange03BeanProperty)
				.setColumnName("\u6587\u4EF6\u9805\u76EE");
		//
		BeanProperty<PosChange03, String> posChange03BeanProperty_1 = BeanProperty
				.create("r_po_chg_doc_desc");
		jTableBinding_2.addColumnBinding(posChange03BeanProperty_1)
				.setColumnName("\u6587\u4EF6\u9805\u76EE\u8AAA\u660E");
		//
		BeanProperty<PosChange03, String> posChange03BeanProperty_2 = BeanProperty
				.create("r_form_id");
		jTableBinding_2.addColumnBinding(posChange03BeanProperty_2)
				.setColumnName("\u8868\u55AE\u4EE3\u78BC");
		//
		jTableBinding_2.setEditable(false);
		jTableBinding_2.bind();
		//
		BeanProperty<PosChangeGroup04, List<PosChange04>> posChangeGroup04BeanProperty = BeanProperty
				.create("posChange04s");
		JTableBinding<PosChange04, PosChangeGroup04, JTable> jTableBinding_3 = SwingBindings
				.createJTableBinding(UpdateStrategy.READ, posChangeGroup04,
						posChangeGroup04BeanProperty, table_3);
		//
		BeanProperty<PosChange04, String> posChange04BeanProperty = BeanProperty
				.create("r_po_chg_rj_code");
		jTableBinding_3.addColumnBinding(posChange04BeanProperty)
				.setColumnName("\u9000\u4EF6\u9805\u76EE");
		//
		BeanProperty<PosChange04, String> posChange04BeanProperty_1 = BeanProperty
				.create("r_po_chg_rj_desc");
		jTableBinding_3.addColumnBinding(posChange04BeanProperty_1)
				.setColumnName("\u9000\u4EF6\u9805\u76EE\u8AAA\u660E")
				.setColumnClass(String.class);
		//
		jTableBinding_3.setEditable(false);
		jTableBinding_3.bind();
		//
		BeanProperty<PosChangeGroup05, List<PosChange05>> posChangeGroup05BeanProperty = BeanProperty
				.create("posChange05s");
		JTableBinding<PosChange05, PosChangeGroup05, JTable> jTableBinding_4 = SwingBindings
				.createJTableBinding(UpdateStrategy.READ, posChangeGroup05,
						posChangeGroup05BeanProperty, table_4);
		//
		BeanProperty<PosChange05, String> posChange05BeanProperty = BeanProperty
				.create("r_policy_no");
		jTableBinding_4.addColumnBinding(posChange05BeanProperty)
				.setColumnName("保單號碼");
		//
		BeanProperty<PosChange05, String> posChange05BeanProperty_1 = BeanProperty
				.create("r_po_sts_code");
		jTableBinding_4.addColumnBinding(posChange05BeanProperty_1)
				.setColumnName("狀況");
		//
		jTableBinding_4.setEditable(false);
		jTableBinding_4.bind();
		//
	}
}
