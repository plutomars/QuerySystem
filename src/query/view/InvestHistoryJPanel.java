package query.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.util.List;

import javax.swing.DefaultListSelectionModel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

import query.controller.InvestHistoryController;
import query.model.InvestHistory.InvestHistory01;
import query.model.InvestHistory.InvestHistory02;
import query.model.InvestHistory.InvestHistory03;
import query.model.InvestHistory.InvestHistory04;
import query.model.InvestHistory.InvestHistory05;
import query.model.InvestHistory.InvestHistoryGroup01;
import query.model.InvestHistory.InvestHistoryGroup02;
import query.model.InvestHistory.InvestHistoryGroup03;
import query.model.InvestHistory.InvestHistoryGroup04;
import query.model.InvestHistory.InvestHistoryGroup05;
import javax.swing.ScrollPaneConstants;

public class InvestHistoryJPanel extends JPanel implements
		ListSelectionListener {
	// private JTableBinding<InvestHistory03, InvestHistoryGroup03, JTable> aaa;
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTable table_1;
	private InvestHistoryGroup01 investHistoryGroup01 = new InvestHistoryGroup01();
	private InvestHistoryGroup02 investHistoryGroup02 = new InvestHistoryGroup02();
	private InvestHistoryGroup03 investHistoryGroup03 = new InvestHistoryGroup03();
	private InvestHistoryGroup04 investHistoryGroup04 = new InvestHistoryGroup04();
	private InvestHistoryGroup05 investHistoryGroup05 = new InvestHistoryGroup05();
	private InvestHistoryController investHistoryController;
	private JTable table_2;
	private JTable table_3;
	private JTabbedPane tabbedPane;
	private JTable table_4;

	public InvestHistoryJPanel() {
		setLayout(new BorderLayout(0, 0));

		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.5);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		add(splitPane);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u4EA4\u6613\u7D00\u9304",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		splitPane.setLeftComponent(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		table.setToolTipText("�I���H��ܤU�����");
		scrollPane.setViewportView(table);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ListSelectionModel model = table.getSelectionModel();
		model.addListSelectionListener(this);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 70, 213)));

		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setResizeWeight(0.7);
		splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		// splitPane_1.add(panel_1);

		// splitPane.setRightComponent(panel_1);
		splitPane.setRightComponent(splitPane_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane_1 = new JScrollPane();
		panel_1.add(scrollPane_1, BorderLayout.CENTER);

		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("�������", panel_1);
		splitPane_1.setLeftComponent(tabbedPane);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		tabbedPane.addTab("����������", panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane_3 = new JScrollPane();
		panel_3.add(scrollPane_3);

		table_3 = new JTable();
		scrollPane_3.setViewportView(table_3);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		tabbedPane.addTab("�b�ȩ��ỡ��", null, panel_4, null);
		panel_4.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane_4 = new JScrollPane();
		panel_4.add(scrollPane_4, BorderLayout.CENTER);

		table_4 = new JTable();
		scrollPane_4.setViewportView(table_4);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "�����Q��",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 70,
						213)));
		splitPane_1.setRightComponent(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane_2 = new JScrollPane();
		panel_2.add(scrollPane_2);

		table_2 = new JTable();
		scrollPane_2.setViewportView(table_2);

		initDataBindings();

		table_3.getColumnModel().getColumn(0).setMaxWidth(100);

		table_3.getColumnModel().getColumn(1).setMinWidth(150);
		table_3.getColumnModel().getColumn(1).setMaxWidth(150);
		table_3.getColumnModel().getColumn(2).setMinWidth(150);
		table_3.getColumnModel().getColumn(2).setMaxWidth(150);
		table_3.getColumnModel().getColumn(3).setMinWidth(150);
		table_3.getColumnModel().getColumn(3).setMaxWidth(150);
		
		table_4.getColumnModel().getColumn(0).setMaxWidth(100);
		table_4.getColumnModel().getColumn(1).setMinWidth(150);
		table_4.getColumnModel().getColumn(1).setMaxWidth(150);

		TableColumn headerCol;
		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

		headerCol = table.getColumnModel().getColumn(4); // ��J���B
		headerCol.setCellRenderer(rightRenderer);

		headerCol = table.getColumnModel().getColumn(5); //
		headerCol.setCellRenderer(centerRenderer);

		// �������
		headerCol = table_1.getColumnModel().getColumn(3); // ���ʳ��ơB
		headerCol.setCellRenderer(rightRenderer);

		headerCol = table_1.getColumnModel().getColumn(4); // ���ʪ��B�B
		headerCol.setCellRenderer(rightRenderer);

		headerCol = table_1.getColumnModel().getColumn(5); // ���ʫ��ҡB
		headerCol.setCellRenderer(rightRenderer);

		headerCol = table_1.getColumnModel().getColumn(6); // �l�q
		headerCol.setCellRenderer(rightRenderer);

		headerCol = table_1.getColumnModel().getColumn(7); //
		headerCol.setCellRenderer(rightRenderer);

		headerCol = table_1.getColumnModel().getColumn(9); //
		headerCol.setCellRenderer(rightRenderer);

		headerCol = table_1.getColumnModel().getColumn(10); //
		headerCol.setCellRenderer(centerRenderer);

		table.getColumnModel().getColumn(2)
				.setCellRenderer(new DefaultTableCellRenderer() {
					// poPlanTable.setDefaultRenderer(Object.class, new
					// DefaultTableCellRenderer() {
					/**
					 * �r��P��L�ۦP,�B�ܶ��⪺�a��select�|�ϥ�
					 */
					private static final long serialVersionUID = 1L;

					public Component getTableCellRendererComponent(
							JTable table, Object value, boolean isSelected,
							boolean hasFocus, int row, int col) {

						try {
							if (value.toString().equals("�ݧ�J"))
								setBackground(Color.yellow);
							else {
								setBackground(Color.white);

								if (isSelected)
									setBackground(table
											.getSelectionBackground());
							}
						} catch (Exception e) {
							return this;
						}
						setValue(value == null ? "" : value.toString());
						return this;
					}
				});
		// table.setDefaultRenderer(Object.class, new MultiLineCellRenderer() {
		// private static final long serialVersionUID = 1L;
		//
		// // ����]��,�Y����ά��C�ѱ��󱱨�
		// // �ǥ��ˮ�TABLE���Y��/�C���ȨӧP�w��m
		// public boolean condition(JTable table, Object value, int row,
		// int column) {
		// try {
		// if (table.getModel().getValueAt(row, 2).toString()
		// .equals("�ݧ�J"))
		// return true;
		// else
		// return false;
		//
		// } catch (Exception e) {
		// return false;
		// }
		// }
		//
		// public Color getColor() {
		// return Color.yellow;
		// }
		// });
	}

	public void addInvestHistory01(InvestHistory01 investHistory) {
		investHistoryGroup01.addInvestHistory01(investHistory);
	}

	public void addInvestHistory02(InvestHistory02 investHistory) {
		investHistoryGroup02.addInvestHistory02(investHistory);
	}

	public void addInvestHistory03(InvestHistory03 investHistory) {
		investHistoryGroup03.addInvestHistory03(investHistory);
	}

	public void addInvestHistory04(InvestHistory04 investHistory) {
		investHistoryGroup04.addInvestHistory04(investHistory);
	}

	public void addInvestHistory05(InvestHistory05 investHistory) {
		investHistoryGroup05.addInvestHistory05(investHistory);
	}

	public void clearInvestHistory01() {
		investHistoryGroup01.removeAll();
	}

	public void clearInvestHistory02() {
		investHistoryGroup02.removeAll();
	}

	public void clearInvestHistory03() {
		investHistoryGroup03.removeAll();
	}

	public void clearInvestHistory04() {
		investHistoryGroup04.removeAll();
	}

	public void clearInvestHistory05() {
		investHistoryGroup05.removeAll();
	}

	public void setDefaultRow() // �w�]�X�{�Ĥ@����ƪ�����
	{
		if (table.getRowCount() > 0) {
			ListSelectionModel selectionModel = table.getSelectionModel();
			selectionModel.setSelectionInterval(0, 0);
		}
	}

	/**
	 * �N�����ܼƥ������VNULL,�Q��JAVA�O����^���t�Φ^���O����
	 */
	public void nullAll() {
		table = null;
		table_1 = null;
		investHistoryGroup01 = null;
		investHistoryGroup02 = null;
		investHistoryGroup03 = null;
		investHistoryGroup04 = null;
		investHistoryGroup05 = null;
	}

	public void clearAll() {
		investHistoryGroup01.removeAll();
		investHistoryGroup02.removeAll();
		investHistoryGroup03.removeAll();
		investHistoryGroup04.removeAll();
		investHistoryGroup05.removeAll();
	}

	@Override
	public void valueChanged(ListSelectionEvent e) { // 600000000711
		// TODO Auto-generated method stub
		// if (e.getValueIsAdjusting()) {
		if (!((DefaultListSelectionModel) e.getSource()).getValueIsAdjusting()) {
			clearInvestHistory02();
			clearInvestHistory03();
			clearInvestHistory04();
			clearInvestHistory05();
			this.setTabPaneEnable();
			int rowSelected = table.getSelectedRow();
			if (rowSelected != -1) {
				investHistoryController.executeInnerMission(
						investHistoryGroup01.getInvestHistory01s()
								.get(rowSelected).getR_invs_ad_no(),
						investHistoryGroup01.getInvestHistory01s()
								.get(rowSelected).getR_currency(),
						investHistoryGroup01.getInvestHistory01s()
								.get(rowSelected).getR_invs_tr_date(), // vivah�����
																		// ��ײv��
						investHistoryGroup01.getInvestHistory01s()
								.get(rowSelected).getR_invs_ivtr_code(), // ����X
						investHistoryGroup01.getInvestHistory01s()
								.get(rowSelected).getR_check_info_join(),// �O�_����
						investHistoryGroup01.getInvestHistory01s()
								.get(rowSelected).getR_exsrc(), // �ײv�ӷ�
						investHistoryGroup01.getInvestHistory01s()
								.get(rowSelected).getR_exprc()); // �ײv�L�O
				if (investHistoryGroup01.getInvestHistory01s().get(rowSelected)
						.getR_invs_ivtr_code().substring(0, 1).equals("1")) {
					investHistoryController
							.executeInnerMission(investHistoryController
									.getOldPolicy_no());
				}
				if (investHistoryGroup01.getInvestHistory01s().get(rowSelected)
						.getR_invs_ad_no().length() > 0) {
					investHistoryController.executeInnerMission(
							investHistoryGroup01.getInvestHistory01s()
									.get(rowSelected).getR_invs_ad_no(), 0);
				}
				this.setTabPaneDisable();
			}
		}
	}

	public void setController(InvestHistoryController controller) {
		investHistoryController = controller;
	}

	public void setTabPaneEnable() {
		for (int i = 0; i < tabbedPane.getComponentCount(); i++) {
			tabbedPane.setEnabledAt(i, true);
		}
	}

	/**
	 * @category �M���w�冀���������@���ҤϦ��I��
	 */
	public void setTabPaneDisable() {
		// �L��Ʒ|���@�Cresult_ind = '1'
		if (investHistoryGroup04.getInvestHistory04Count() < 1
				|| investHistoryGroup04.getInvestHistory04s().get(0)
						.getR_result_ind().equals("1"))
			tabbedPane.setEnabledAt(1, false);
		if (investHistoryGroup05.getInvestHistory05Count() < 1)
			tabbedPane.setEnabledAt(2, false);

		tabbedPane.setSelectedIndex(0);

		for (int i = 0; i < tabbedPane.getComponentCount(); i++) {
			if (tabbedPane.isEnabledAt(i)) {
				tabbedPane.setSelectedIndex(i);
				break;
			}
		}
	}

	protected void initDataBindings() {
		BeanProperty<InvestHistoryGroup01, List<InvestHistory01>> investHistoryGroup01BeanProperty = BeanProperty
				.create("investHistory01s");
		JTableBinding<InvestHistory01, InvestHistoryGroup01, JTable> jTableBinding = SwingBindings
				.createJTableBinding(UpdateStrategy.READ, investHistoryGroup01,
						investHistoryGroup01BeanProperty, table);
		//
		BeanProperty<InvestHistory01, String> investHistory01BeanProperty = BeanProperty
				.create("r_invs_ad_date");
		jTableBinding.addColumnBinding(investHistory01BeanProperty)
				.setColumnName("\u6A19\u7684\u4F5C\u696D\u65E5");
		//
		BeanProperty<InvestHistory01, String> investHistory01BeanProperty_1 = BeanProperty
				.create("r_invs_tr_date");
		jTableBinding.addColumnBinding(investHistory01BeanProperty_1)
				.setColumnName("\u6A19\u7684\u4EA4\u6613\u65E5");
		//
		BeanProperty<InvestHistory01, String> investHistory01BeanProperty_2 = BeanProperty
				.create("r_invs_ad_sts_desc");
		jTableBinding.addColumnBinding(investHistory01BeanProperty_2)
				.setColumnName("\u8655\u7406\u60C5\u5F62");
		//
		BeanProperty<InvestHistory01, String> investHistory01BeanProperty_3 = BeanProperty
				.create("r_next_tr_date");
		jTableBinding.addColumnBinding(investHistory01BeanProperty_3)
				.setColumnName("\u4E0B\u6B21\u4EA4\u6613\u65E5");
		//
		BeanProperty<InvestHistory01, String> investHistory01BeanProperty_4 = BeanProperty
				.create("r_invs_ivtr_amt");
		jTableBinding.addColumnBinding(investHistory01BeanProperty_4)
				.setColumnName("\u4EA4\u6613\u7E3D\u984D");
		//
		BeanProperty<InvestHistory01, String> investHistory01BeanProperty_5 = BeanProperty
				.create("r_invs_ad_no");
		jTableBinding.addColumnBinding(investHistory01BeanProperty_5)
				.setColumnName("\u4EA4\u6613\u7DE8\u865F");
		//
		BeanProperty<InvestHistory01, String> investHistory01BeanProperty_6 = BeanProperty
				.create("r_invs_ad_desc");
		jTableBinding.addColumnBinding(investHistory01BeanProperty_6)
				.setColumnName("\u4EA4\u6613\u6307\u793A");
		//
		BeanProperty<InvestHistory01, String> investHistory01BeanProperty_7 = BeanProperty
				.create("r_invs_ivtr_code");
		jTableBinding.addColumnBinding(investHistory01BeanProperty_7)
				.setColumnName("\u4EA4\u6613\u78BC");
		//
		BeanProperty<InvestHistory01, String> investHistory01BeanProperty_8 = BeanProperty
				.create("r_check_info_join");
		jTableBinding.addColumnBinding(investHistory01BeanProperty_8)
				.setColumnName("\u4EA4\u6613\u8CC7\u8A0A");
		//
		BeanProperty<InvestHistory01, String> investHistory01BeanProperty_9 = BeanProperty
				.create("r_invs_expense");
		jTableBinding.addColumnBinding(investHistory01BeanProperty_9)
				.setColumnName("\u4EA4\u6613\u6263\u9664\u8CBB\u7528");
		//
		jTableBinding.setEditable(false);
		jTableBinding.bind();
		//
		BeanProperty<InvestHistoryGroup02, List<InvestHistory02>> investHistoryGroup02BeanProperty = BeanProperty
				.create("investHistory02s");
		JTableBinding<InvestHistory02, InvestHistoryGroup02, JTable> jTableBinding_1 = SwingBindings
				.createJTableBinding(UpdateStrategy.READ, investHistoryGroup02,
						investHistoryGroup02BeanProperty, table_1);
		//
		BeanProperty<InvestHistory02, String> investHistory02BeanProperty = BeanProperty
				.create("r_invs_ad_sub_desc");
		jTableBinding_1.addColumnBinding(investHistory02BeanProperty)
				.setColumnName("\u6B21\u6307\u793A");
		//
		BeanProperty<InvestHistory02, String> investHistory02BeanProperty_1 = BeanProperty
				.create("r_invs_no");
		jTableBinding_1.addColumnBinding(investHistory02BeanProperty_1)
				.setColumnName("\u6A19\u7684\u865F\u78BC");
		//
		BeanProperty<InvestHistory02, String> investHistory02BeanProperty_2 = BeanProperty
				.create("r_invs_code");
		jTableBinding_1.addColumnBinding(investHistory02BeanProperty_2)
				.setColumnName("\u6A19\u7684\u4EE3\u78BC");
		//
		BeanProperty<InvestHistory02, String> investHistory02BeanProperty_3 = BeanProperty
				.create("r_invs_ad_units");
		jTableBinding_1.addColumnBinding(investHistory02BeanProperty_3)
				.setColumnName("\u7570\u52D5\u55AE\u4F4D\u6578");
		//
		BeanProperty<InvestHistory02, String> investHistory02BeanProperty_4 = BeanProperty
				.create("r_invs_value");
		jTableBinding_1.addColumnBinding(investHistory02BeanProperty_4)
				.setColumnName("\u55AE\u4F4D\u6DE8\u503C");
		//
		BeanProperty<InvestHistory02, String> investHistory02BeanProperty_11 = BeanProperty
				.create("r_invs_tr_date");
		jTableBinding_1.addColumnBinding(investHistory02BeanProperty_11)
				.setColumnName("\u6DE8\u503C\u65E5\u671F");
		//
		BeanProperty<InvestHistory02, String> investHistory02BeanProperty_5 = BeanProperty
				.create("r_currency");
		jTableBinding_1.addColumnBinding(investHistory02BeanProperty_5)
				.setColumnName("\u5E63\u5225");
		//
		BeanProperty<InvestHistory02, String> investHistory02BeanProperty_6 = BeanProperty
				.create("r_exrt_rate");
		jTableBinding_1.addColumnBinding(investHistory02BeanProperty_6)
				.setColumnName("\u532F\u7387");
		//
		BeanProperty<InvestHistory02, String> investHistory02BeanProperty_12 = BeanProperty
				.create("r_exrt_date");
		jTableBinding_1.addColumnBinding(investHistory02BeanProperty_12)
				.setColumnName("\u532F\u7387\u65E5\u671F");
		//
		BeanProperty<InvestHistory02, String> investHistory02BeanProperty_7 = BeanProperty
				.create("r_invs_ad_amt");
		jTableBinding_1.addColumnBinding(investHistory02BeanProperty_7)
				.setColumnName("\u7570\u52D5\u91D1\u984D");
		//
		BeanProperty<InvestHistory02, String> investHistory02BeanProperty_8 = BeanProperty
				.create("r_invs_ad_perc");
		jTableBinding_1.addColumnBinding(investHistory02BeanProperty_8)
				.setColumnName("\u7570\u52D5\u5F8C\u6BD4\u4F8B");
		//
		BeanProperty<InvestHistory02, String> investHistory02BeanProperty_9 = BeanProperty
				.create("r_invs_gain_loss");
		jTableBinding_1.addColumnBinding(investHistory02BeanProperty_9)
				.setColumnName("\u640D\u76CA");
		//
		BeanProperty<InvestHistory02, String> investHistory02BeanProperty_10 = BeanProperty
				.create("r_ivtr_ok_desc");
		jTableBinding_1.addColumnBinding(investHistory02BeanProperty_10)
				.setColumnName("\u5B8C\u6210\u6307\u793A");
		//
		jTableBinding_1.setEditable(false);
		jTableBinding_1.bind();
		//
		BeanProperty<InvestHistoryGroup03, List<InvestHistory03>> investHistoryGroup03BeanProperty = BeanProperty
				.create("investHistory03s");
		JTableBinding<InvestHistory03, InvestHistoryGroup03, JTable> jTableBinding_2 = SwingBindings
				.createJTableBinding(UpdateStrategy.READ, investHistoryGroup03,
						investHistoryGroup03BeanProperty, table_2);
		//
		BeanProperty<InvestHistory03, String> investHistory03BeanProperty = BeanProperty
				.create("r_invs_code");
		jTableBinding_2.addColumnBinding(investHistory03BeanProperty)
				.setColumnName("�Ъ��N�X");
		//
		BeanProperty<InvestHistory03, String> investHistory03BeanProperty_1 = BeanProperty
				.create("r_int_str_date");
		jTableBinding_2.addColumnBinding(investHistory03BeanProperty_1)
				.setColumnName("�p��_��");
		//
		BeanProperty<InvestHistory03, String> investHistory03BeanProperty_2 = BeanProperty
				.create("r_int_end_date");
		jTableBinding_2.addColumnBinding(investHistory03BeanProperty_2)
				.setColumnName("�p�⨴��");
		//
		BeanProperty<InvestHistory03, String> investHistory03BeanProperty_3 = BeanProperty
				.create("r_invs_ivtr_amt");
		jTableBinding_2.addColumnBinding(investHistory03BeanProperty_3)
				.setColumnName("����");
		//
		BeanProperty<InvestHistory03, String> investHistory03BeanProperty_4 = BeanProperty
				.create("r_this_int");
		jTableBinding_2.addColumnBinding(investHistory03BeanProperty_4)
				.setColumnName("�Q��");
		//
		BeanProperty<InvestHistory03, String> investHistory03BeanProperty_5 = BeanProperty
				.create("r_tran_date");
		jTableBinding_2.addColumnBinding(investHistory03BeanProperty_5)
				.setColumnName("�b�Ȥ��");
		//
		BeanProperty<InvestHistory03, String> investHistory03BeanProperty_6 = BeanProperty
				.create("r_entry_no");
		jTableBinding_2.addColumnBinding(investHistory03BeanProperty_6)
				.setColumnName("�J�b���X");
		//
		jTableBinding_2.setEditable(false);
		jTableBinding_2.bind();
		//
		BeanProperty<InvestHistoryGroup04, List<InvestHistory04>> investHistoryGroup04BeanProperty = BeanProperty
				.create("investHistory04s");
		JTableBinding<InvestHistory04, InvestHistoryGroup04, JTable> jTableBinding_3 = SwingBindings
				.createJTableBinding(UpdateStrategy.READ, investHistoryGroup04,
						investHistoryGroup04BeanProperty, table_3);
		//
		BeanProperty<InvestHistory04, String> investHistory04BeanProperty = BeanProperty
				.create("r_invs_ad_sub_desc");
		jTableBinding_3.addColumnBinding(investHistory04BeanProperty)
				.setColumnName("������");
		//
		BeanProperty<InvestHistory04, String> investHistory04BeanProperty_1 = BeanProperty
				.create("r_invs_code");
		jTableBinding_3.addColumnBinding(investHistory04BeanProperty_1)
				.setColumnName("�Ъ��N�X");
		//
		BeanProperty<InvestHistory04, String> investHistory04BeanProperty_2 = BeanProperty
				.create("r_ori_invs_tr_date");
		jTableBinding_3.addColumnBinding(investHistory04BeanProperty_2)
				.setColumnName("���ʫe������");
		//
		BeanProperty<InvestHistory04, String> investHistory04BeanProperty_3 = BeanProperty
				.create("r_invs_tr_date");
		jTableBinding_3.addColumnBinding(investHistory04BeanProperty_3)
				.setColumnName("���ʫ������");
		//
		BeanProperty<InvestHistory04, String> investHistory04BeanProperty_4 = BeanProperty
				.create("r_desc");
		jTableBinding_3.addColumnBinding(investHistory04BeanProperty_4)
				.setColumnName("���ʻ���");
		//
		jTableBinding_3.setEditable(false);
		jTableBinding_3.bind();
		//

		BeanProperty<InvestHistoryGroup05, List<InvestHistory05>> investHistoryGroup05BeanProperty = BeanProperty
				.create("investHistory05s");
		JTableBinding<InvestHistory05, InvestHistoryGroup05, JTable> jTableBinding_4 = SwingBindings
				.createJTableBinding(UpdateStrategy.READ, investHistoryGroup05,
						investHistoryGroup05BeanProperty, table_4);
		//

		BeanProperty<InvestHistory05, String> investHistory05BeanProperty = BeanProperty
				.create("r_invs_ad_sub_desc");
		jTableBinding_4.addColumnBinding(investHistory05BeanProperty)
				.setColumnName("������");
		//
		BeanProperty<InvestHistory05, String> investHistory05BeanProperty_1 = BeanProperty
				.create("r_invs_code");
		jTableBinding_4.addColumnBinding(investHistory05BeanProperty_1)
				.setColumnName("�Ъ��N�X");
		//
		BeanProperty<InvestHistory05, String> investHistory05BeanProperty_2 = BeanProperty
				.create("r_invs_tr_date");
		jTableBinding_4.addColumnBinding(investHistory05BeanProperty_2)
				.setColumnName("�����G���b�ȵ�����");
		//		
		BeanProperty<InvestHistory05, String> investHistory05BeanProperty_4 = BeanProperty
				.create("r_get_date");
		jTableBinding_4.addColumnBinding(investHistory05BeanProperty_4)
				.setColumnName("�b�ȹ�ڨ��o���");
		//
		jTableBinding_4.setEditable(false);
		jTableBinding_4.bind();
		//

	}
}
