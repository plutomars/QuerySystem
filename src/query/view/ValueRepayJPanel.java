package query.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.DefaultListSelectionModel;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
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
import org.jdesktop.beansbinding.ELProperty;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

import query.controller.MultiLineCellRenderer;
import query.controller.ValueRepayController;
import query.model.ValueRepay.ValueRepay01;
import query.model.ValueRepay.ValueRepay02;
import query.model.ValueRepay.ValueRepay03;
import query.model.ValueRepay.ValueRepay04;
import query.model.ValueRepay.ValueRepay05;
import query.model.ValueRepay.ValueRepay06;
import query.model.ValueRepay.ValueRepay07;
import query.model.ValueRepay.ValueRepay08;
import query.model.ValueRepay.ValueRepay09;
import query.model.ValueRepay.ValueRepay10;
import query.model.ValueRepay.ValueRepay11;
import query.model.ValueRepay.ValueRepayGroup01;
import query.model.ValueRepay.ValueRepayGroup02;
import query.model.ValueRepay.ValueRepayGroup03;
import query.model.ValueRepay.ValueRepayGroup04;
import query.model.ValueRepay.ValueRepayGroup05;
import query.model.ValueRepay.ValueRepayGroup06;
import query.model.ValueRepay.ValueRepayGroup07;
import query.model.ValueRepay.ValueRepayGroup08;
import query.model.ValueRepay.ValueRepayGroup09;
import query.model.ValueRepay.ValueRepayGroup10;
import query.model.ValueRepay.ValueRepayGroup11;

public class ValueRepayJPanel extends JPanel implements ListSelectionListener {

	private static final long serialVersionUID = 1L;
	private JSplitPane splitPane;
	private JSplitPane splitPane_1;
	private ValueRepayGroup01 valueRepayGroup01 = new ValueRepayGroup01();
	private ValueRepayGroup02 valueRepayGroup02 = new ValueRepayGroup02();
	private ValueRepayGroup03 valueRepayGroup03 = new ValueRepayGroup03();
	private ValueRepayGroup04 valueRepayGroup04 = new ValueRepayGroup04();
	private ValueRepayGroup05 valueRepayGroup05 = new ValueRepayGroup05();
	private ValueRepayGroup06 valueRepayGroup06 = new ValueRepayGroup06();
	private ValueRepayGroup07 valueRepayGroup07 = new ValueRepayGroup07();
	private ValueRepayGroup08 valueRepayGroup08 = new ValueRepayGroup08();
	private ValueRepayGroup09 valueRepayGroup09 = new ValueRepayGroup09();
	private ValueRepayGroup10 valueRepayGroup10 = new ValueRepayGroup10();
	private ValueRepayGroup11 valueRepayGroup11 = new ValueRepayGroup11();
	private JTabbedPane tabbedPane;
	private JSplitPane splitPane_2;
	private JSplitPane splitPane_3;
	private int vpx = 110, vpy = 25;
	// 上區VerticalPane
	private VerticalPane vp01 = new VerticalPane(
			new String[] { "保單號碼", "保單狀態" }, "", vpx, vpy);
	private VerticalPane vp02 = new VerticalPane(new String[] { "保單狀態(中文)",
			"收費方式" }, "", vpx, vpy);
	private VerticalPane vp03 = new VerticalPane(
			new String[] { "生效日", "保費到期日" }, "", vpx, vpy);
	private VerticalPane vp04 = new VerticalPane(new String[] { "作帳日", "" },
			"", vpx, vpy);
	// 下區VerticalPane
	private VerticalPane bvp01 = new VerticalPane(new String[] { "還本週年日",
			"給付方式", "業務員", "未兌支票", "給付變更" }, "", 80, vpy);
	private VerticalPane bvp02 = new VerticalPane(new String[] { "回覆指示",
			"超借指示", "還款指示", "ID影本檢付", "註記" }, "", vpx, vpy);
	private VerticalPane bvp03 = new VerticalPane(new String[] { "郵寄地址", "領取人",
			"領取人ID", "領取地點", "受益人" }, "", vpx, vpy);
	private VerticalPane bvp04 = new VerticalPane(new String[] { "電匯指示",
			"電匯日期", "", "", "" }, "", vpx, vpy);

	// 下區第二頁
	private VerticalPane bvp05 = new VerticalPane(new String[] { "", "", "",
			"", "", "", "" }, "", 0, vpy);
	private VerticalPane bvp06 = new VerticalPane(new String[] { "", "", "",
			"", "" }, "", 0, vpy);

	// 下區第三頁VerticalPane
	private VerticalPane bvp07 = new VerticalPane(
			new String[] { "週年日", "郵寄地址" }, "", vpx, vpy);
	private VerticalPane bvp08 = new VerticalPane(new String[] { "付款方式", "" },
			"", vpx, vpy);
	private VerticalPane bvp09 = new VerticalPane(new String[] { "建檔者", "" },
			"", vpx, vpy);

	private JPanel panel;
	private JPanel panel_1;
	private JScrollPane scrollPane;
	private JTable ValueRepayTable02;
	private JPanel panel_2;
	private JScrollPane scrollPane_1;
	private JScrollPane scrollPane_2;
	private JTable ValueRepayTable04;
	private JTable ValueRepayTable05;
	private JSplitPane splitPane_4;
	private JSplitPane splitPane_5;
	private JScrollPane scrollPane_3;
	private JTable ValueRepayTable06;
	private JTable ValueRepayTable07;
	private JTable ValueRepayTable08;
	private ValueRepayController valueRepayController;
	private JSplitPane splitPane_6;
	private JSplitPane splitPane_7;
	private JPanel panel_3;
	private JScrollPane scrollPane_4;
	private JScrollPane scrollPane_5;

	public ValueRepayJPanel() {
		setLayout(new BorderLayout(0, 0));
		// this.setSize(500, 600);

		splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.5);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setDividerLocation(250);
		add(splitPane, BorderLayout.CENTER);

		splitPane_1 = new JSplitPane();
		splitPane_1.setLayout(new GridLayout(4, 0, 0, 0));
		splitPane_1.setDividerLocation(vpy * 2 + 39);
		splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setLeftComponent(splitPane_1);

		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "給付資料", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		splitPane_1.setLeftComponent(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		panel.add(vp01);
		panel.add(vp02);
		panel.add(vp03);
		panel.add(vp04);

		panel_1 = new JPanel();
		splitPane_1.setRightComponent(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);

		ValueRepayTable02 = new JTable();
		ValueRepayTable02.setToolTipText("點擊以顯示下方明細");
		ValueRepayTable02.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ValueRepayTable02.setFillsViewportHeight(true);
		scrollPane.setViewportView(ValueRepayTable02);
		ListSelectionModel model02 = ValueRepayTable02.getSelectionModel();
		model02.addListSelectionListener(this);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		splitPane.setRightComponent(tabbedPane);

		splitPane_2 = new JSplitPane();
		splitPane_2.setBorder(new TitledBorder(null, "明細資料",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		splitPane_2.setDividerLocation(vpy * 5 + 30);
		splitPane_2.setOrientation(JSplitPane.VERTICAL_SPLIT);
		tabbedPane.addTab("明細資料", null, splitPane_2, null);

		splitPane_3 = new JSplitPane();
		splitPane_3.setResizeWeight(0.65);
		splitPane_3.setDividerLocation(600);
		splitPane_2.setRightComponent(splitPane_3);

		scrollPane_1 = new JScrollPane();
		splitPane_3.setLeftComponent(scrollPane_1);
		scrollPane_1.setBorder(new TitledBorder(null, "給付項目",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));

		ValueRepayTable04 = new JTable();
		ValueRepayTable04.setRowSelectionAllowed(false);
		scrollPane_1.setViewportView(ValueRepayTable04);
		ValueRepayTable04.setRowHeight(ValueRepayTable04.getRowHeight() * 2);
		ValueRepayTable04.setDefaultRenderer(String.class,
				new MultiLineCellRenderer());

		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBorder(new TitledBorder(null, "抵繳保單",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		splitPane_3.setRightComponent(scrollPane_2);

		ValueRepayTable05 = new JTable();
		ValueRepayTable05.setRowSelectionAllowed(false);
		scrollPane_2.setViewportView(ValueRepayTable05);

		panel_2 = new JPanel();
		splitPane_2.setLeftComponent(panel_2);
		panel_2.setLayout(new GridLayout(1, 0, 0, 0));
		panel_2.add(bvp01);
		panel_2.add(bvp02);
		panel_2.add(bvp03);
		panel_2.add(bvp04);

		bvp01.getDataTable().getColumnModel().getColumn(0)
				.setCellRenderer(new DefaultTableCellRenderer() {

					private static final long serialVersionUID = 1L;

					public Component getTableCellRendererComponent(
							JTable table, Object value, boolean isSelected,
							boolean hasFocus, int row, int col) {
						JLabel label = (JLabel) super
								.getTableCellRendererComponent(table, value,
										isSelected, hasFocus, row, col);
						try {
							if (row == 1)
								setBackground(Color.yellow);
							else
								setBackground(Color.white);
						} catch (Exception e) {
							return this;
						}
						setValue(value == null ? "" : value.toString());
						return this;
					}
				});
		bvp02.getDataTable().getColumnModel().getColumn(0)
				.setCellRenderer(new DefaultTableCellRenderer() {

					private static final long serialVersionUID = 1L;

					public Component getTableCellRendererComponent(
							JTable table, Object value, boolean isSelected,
							boolean hasFocus, int row, int col) {
						JLabel label = (JLabel) super
								.getTableCellRendererComponent(table, value,
										isSelected, hasFocus, row, col);
						try {
							if (row == 1 || row == 2)
								setBackground(Color.yellow);
							else
								setBackground(Color.white);
						} catch (Exception e) {
							return this;
						}
						setValue(value == null ? "" : value.toString());
						return this;
					}
				});
		bvp04.getDataTable().getColumnModel().getColumn(0)
				.setCellRenderer(new DefaultTableCellRenderer() {

					private static final long serialVersionUID = 1L;

					public Component getTableCellRendererComponent(
							JTable table, Object value, boolean isSelected,
							boolean hasFocus, int row, int col) {
						JLabel label = (JLabel) super
								.getTableCellRendererComponent(table, value,
										isSelected, hasFocus, row, col);
						try {
							if (row == 1)
								setBackground(Color.yellow);
							else
								setBackground(Color.white);
						} catch (Exception e) {
							return this;
						}
						setValue(value == null ? "" : value.toString());
						return this;
					}
				});
		// bvp01.getDataTable().getColumnModel().getColumn(0)
		// .setCellRenderer(new MultiLineCellRenderer() {
		// private static final long serialVersionUID = 1L;
		//
		// public boolean condition(JTable table, Object value,
		// int row, int column) {
		// try {
		// if (row == 1)
		// return true;
		// else
		// return false;
		// } catch (Exception e) {
		//
		// }
		// return false;
		// }
		//
		// public Color getColor() {
		// return Color.yellow;
		// }
		//
		// });

		splitPane_4 = new JSplitPane();
		splitPane_4.setResizeWeight(0.5);
		splitPane_4.setDividerLocation(189);
		splitPane_4.setOrientation(JSplitPane.VERTICAL_SPLIT);
		tabbedPane.addTab("回覆情形及註記", null, splitPane_4, null);

		splitPane_5 = new JSplitPane();
		splitPane_5.setResizeWeight(0.5);
		splitPane_4.setLeftComponent(splitPane_5);

		bvp06.setBorder(new TitledBorder(null, "註記內容", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		splitPane_4.setRightComponent(bvp06);
		bvp05.setBorder(new TitledBorder(null, "缺件資料", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		splitPane_5.setRightComponent(bvp05);

		scrollPane_3 = new JScrollPane();
		scrollPane_3.setBorder(new TitledBorder(null, "回覆情形",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		splitPane_5.setLeftComponent(scrollPane_3);

		ValueRepayTable06 = new JTable();
		ValueRepayTable06.setFillsViewportHeight(true);
		ValueRepayTable06.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_3.setViewportView(ValueRepayTable06);

		splitPane_6 = new JSplitPane();
		splitPane_6.setResizeWeight(0.5);
		splitPane_6.setOrientation(JSplitPane.VERTICAL_SPLIT);
		tabbedPane.addTab("還本未回回覆", null, splitPane_6, null);

		splitPane_7 = new JSplitPane();
		splitPane_7.setResizeWeight(0.90);
		splitPane_7.setDividerLocation(vpx*8);
		splitPane_6.setRightComponent(splitPane_7);

		splitPane_6.setDividerLocation(vpy * 2 + 39);

		scrollPane_4 = new JScrollPane();
		scrollPane_4.setBorder(new TitledBorder(null, "給付明細",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));

		splitPane_7.setLeftComponent(scrollPane_4);

		ValueRepayTable07 = new JTable();
		ValueRepayTable07.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		scrollPane_4.setViewportView(ValueRepayTable07);

		scrollPane_5 = new JScrollPane();
		scrollPane_5.setBorder(new TitledBorder(null, "抵繳保單",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		splitPane_7.setRightComponent(scrollPane_5);

		ValueRepayTable08 = new JTable();
		ValueRepayTable08.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		scrollPane_5.setViewportView(ValueRepayTable08);

		panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "\u56DE\u8986\u660E\u7D30",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.add(bvp07);
		panel_3.add(bvp08);
		panel_3.add(bvp09);
		splitPane_6.setLeftComponent(panel_3);
		panel_3.setLayout(new GridLayout(1, 0, 0, 0));
		ListSelectionModel model06 = ValueRepayTable06.getSelectionModel();
		model06.addListSelectionListener(this);
		initDataBindings();
		TableColumn headerCol;
		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

		// ValueRepayTable04(欄位調整) 101.04.02
		headerCol = ValueRepayTable04.getColumnModel().getColumn(0);
		headerCol.setMaxWidth(45);
		// headerCol.setPreferredWidth(25);
		headerCol = ValueRepayTable04.getColumnModel().getColumn(1);
		headerCol.setMaxWidth(80);
		headerCol = ValueRepayTable04.getColumnModel().getColumn(2);
		headerCol.setMaxWidth(70);
		headerCol = ValueRepayTable04.getColumnModel().getColumn(3);
		headerCol.setMaxWidth(90);
		headerCol = ValueRepayTable04.getColumnModel().getColumn(4);
		headerCol.setMaxWidth(80);
		// headerCol = ValueRepayTable04.getColumnModel().getColumn(5);
		// headerCol.setPreferredWidth(85);

		headerCol = ValueRepayTable02.getColumnModel().getColumn(5);
		headerCol.setCellRenderer(rightRenderer);
		headerCol = ValueRepayTable02.getColumnModel().getColumn(6);
		headerCol.setCellRenderer(rightRenderer);
		headerCol = ValueRepayTable02.getColumnModel().getColumn(7);
		headerCol.setCellRenderer(rightRenderer);
		headerCol = ValueRepayTable02.getColumnModel().getColumn(8);
		headerCol.setCellRenderer(rightRenderer);
		headerCol = ValueRepayTable02.getColumnModel().getColumn(9);
		headerCol.setCellRenderer(centerRenderer);

	}

	public void setController(ValueRepayController controller) {
		valueRepayController = controller;
	}

	/**
	 * 將全域變數全部指向NULL,利於JAVA記憶體回收系統回收記憶體
	 */
	public void nullAll() {
		ValueRepayTable02 = null;
		ValueRepayTable04 = null;
		ValueRepayTable05 = null;
		ValueRepayTable06 = null;
		ValueRepayTable07 = null;
		ValueRepayTable08 = null;
		valueRepayGroup01 = null;
		valueRepayGroup02 = null;
		valueRepayGroup03 = null;
		valueRepayGroup04 = null;
		valueRepayGroup05 = null;
		valueRepayGroup06 = null;
		valueRepayGroup07 = null;
		valueRepayGroup08 = null;
		valueRepayGroup09 = null;
		valueRepayGroup10 = null;
		valueRepayGroup11 = null;
	}

	public void clearAll() {
		valueRepayGroup01.removeAll();
		valueRepayGroup02.removeAll();
		valueRepayGroup03.removeAll();
		valueRepayGroup04.removeAll();
		valueRepayGroup05.removeAll();
		valueRepayGroup06.removeAll();
		valueRepayGroup07.removeAll();
		valueRepayGroup08.removeAll();
		valueRepayGroup09.removeAll();
		valueRepayGroup10.removeAll();
		valueRepayGroup11.removeAll();
	}

	public void addValueRepay01(ValueRepay01 valueRepay) {
		valueRepayGroup01.addValueRepay01(valueRepay);
		vp01.setValue(new String[] { valueRepay.getR_policy_no(),
				valueRepay.getR_po_sts_code() });
		vp02.setValue(new String[] { valueRepay.getR_po_sts_desc(),
				valueRepay.getR_method_desc() });
		vp03.setValue(new String[] { valueRepay.getR_po_issue_date(),
				valueRepay.getR_paid_to_date() });
		vp04.setValue(new String[] { valueRepay.getR_tran_date(), "" });
	}

	public void clearValueRepay01() {
		valueRepayGroup01.removeAll();
		vp01.setValue(new String[2]);
		vp02.setValue(new String[2]);
		vp03.setValue(new String[2]);
		vp04.setValue(new String[2]);
	}

	public void addValueRepay02(ValueRepay02 valueRepay) {
		valueRepayGroup02.addValueRepay02(valueRepay);
	}

	public void addValueRepay04(ValueRepay04 valueRepay) {
		valueRepayGroup04.addValueRepay04(valueRepay);
	}

	public void clearValueRepay02() {
		valueRepayGroup02.removeAll();
	}

	public void addValueRepay03(ValueRepay03 valueRepay) {
		valueRepayGroup03.addValueRepay03(valueRepay);
	}

	public void addValueRepay05(ValueRepay05 valueRepay) {
		valueRepayGroup05.addValueRepay05(valueRepay);
	}

	public void addValueRepay06(ValueRepay06 valueRepay) {
		valueRepayGroup06.addValueRepay06(valueRepay);
	}

	public void addValueRepay07(ValueRepay07 valueRepay) {
		valueRepayGroup07.addValueRepay07(valueRepay);
	}

	public void addValueRepay08(ValueRepay08 valueRepay) {
		valueRepayGroup08.addValueRepay08(valueRepay);
	}

	public void addValueRepay09(ValueRepay09 valueRepay) {
		valueRepayGroup09.addValueRepay09(valueRepay);
		bvp07.setValue(new String[] { valueRepay.getR_cp_anniv_date(),
				valueRepay.getR_mail_addr() });
		bvp08.setValue(new String[] { valueRepay.getR_ca_disb_desc(), "" });
		bvp09.setValue(new String[] { valueRepay.getR_crt_user_name(), "" });

	}

	public void addValueRepay10(ValueRepay10 valueRepay) {
		valueRepayGroup10.addValueRepay10(valueRepay);
	}

	public void clearValueRepay10() {
		valueRepayGroup10.removeAll();
	}

	public void addValueRepay11(ValueRepay11 valueRepay) {
		valueRepayGroup11.addValueRepay11(valueRepay);
	}

	public void clearValueRepay11() {
		valueRepayGroup11.removeAll();
	}

	public void clearValueRepay03() {
		valueRepayGroup03.removeAll();
		bvp01.setValue(new String[5]);
		bvp02.setValue(new String[5]);
		bvp03.setValue(new String[5]);
		bvp04.setValue(new String[5]);
	}

	public void clearValueRepay04() {
		valueRepayGroup04.removeAll();
	}

	public void clearValueRepay05() {
		valueRepayGroup05.removeAll();
	}

	public void clearValueRepay06() {
		valueRepayGroup06.removeAll();
	}

	public void clearValueRepay07() {
		valueRepayGroup07.removeAll();
		bvp05.setValue(new String[6]);
	}

	public void clearValueRepay08() {
		valueRepayGroup08.removeAll();
		bvp06.setValue(new String[5]);
	}

	public void clearValueRepay09() {
		valueRepayGroup09.removeAll();
		bvp07.setValue(new String[2]);
		bvp08.setValue(new String[2]);
		bvp09.setValue(new String[2]);
	}

	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		// TODO Auto-generated method stub
		// if (arg0.getValueIsAdjusting()) {
		if (!((DefaultListSelectionModel) arg0.getSource())
				.getValueIsAdjusting()) {

			int rowSelect = ValueRepayTable02.getSelectedRow();
			String policy_no = null, cp_anniv_date = null;

			if (rowSelect != -1) {
				policy_no = valueRepayGroup01.getValueRepay01s().get(0)
						.getR_policy_no();
				cp_anniv_date = valueRepayGroup02.getValueRepay02s()
						.get(rowSelect).getR_cp_anniv_date();

				// System.out.println("event start1:"+rowSelect);
				if (arg0.getSource().equals(
						ValueRepayTable02.getSelectionModel())) {
					setTabPaneEnable();

					clearValueRepay03();
					clearValueRepay04();
					clearValueRepay05();
					clearValueRepay06();
					clearValueRepay08();
					clearValueRepay09();
					clearValueRepay10();
					clearValueRepay11();

					policy_no = valueRepayGroup01.getValueRepay01s().get(0)
							.getR_policy_no();
					cp_anniv_date = valueRepayGroup02.getValueRepay02s()
							.get(rowSelect).getR_cp_anniv_date();

					valueRepayController.executeInnerMission03(policy_no,
							cp_anniv_date);

					bvp01.setValue(valueRepayGroup03.getValueRepay03s().get(0)
							.getColumn1());

					bvp02.setValue(valueRepayGroup03.getValueRepay03s().get(0)
							.getColumn2());

					bvp03.setValue(valueRepayGroup03.getValueRepay03s().get(0)
							.getColumn3());

					bvp04.setValue(valueRepayGroup03.getValueRepay03s().get(0)
							.getColumn4());

					valueRepayController.executeInnerMission04(policy_no,
							cp_anniv_date, valueRepayGroup03.getValueRepay03s()
									.get(0).getR_disb_spec_ind(),
							valueRepayGroup03.getValueRepay03s().get(0)
									.getR_relation());
					// i_policy_no
					// i_cp_anniv_date
					// i_disb_spec_ind
					// i_relation
					// i_currency

					valueRepayController.executeInnerMission05(policy_no,
							cp_anniv_date);

					valueRepayController.executeInnerMission06(policy_no,
							cp_anniv_date);
					valueRepayController.executeInnerMission08(policy_no,
							cp_anniv_date);
					valueRepayController.executeInnerMission09(policy_no,
							cp_anniv_date);
					valueRepayController.executeInnerMission10(policy_no,
							cp_anniv_date);
					valueRepayController.executeInnerMission11(policy_no,
							cp_anniv_date);

					bvp06.setValue(valueRepayGroup08.getValueRepay08s().get(0)
							.getColumn());
					setTabPaneDisable();
					setDefaultRow();
				}
			}

			if (arg0.getSource().equals(ValueRepayTable06.getSelectionModel())) {
				clearValueRepay07();
				int rowSelected06 = ValueRepayTable06.getSelectedRow();
				// System.out.println("event start:"+rowSelected06+":"+Integer.parseInt(valueRepayGroup06
				// .getValueRepay06s().get(rowSelected06)
				// .getR_cp_notice_serial()));
				if (rowSelected06 != -1) {
					valueRepayController.executeInnerMission07(
							policy_no,
							cp_anniv_date,
							Integer.parseInt(valueRepayGroup06
									.getValueRepay06s().get(rowSelected06)
									.getR_cp_notice_serial()));

					bvp05.setValue(valueRepayGroup07.getValueRepay07s().get(0)
							.getColumn());

				}
			}

		}

	}

	public void setDefaultRow() {

		if (ValueRepayTable02.getRowCount() > 0) {
			if (ValueRepayTable02.getSelectedRow() == -1) {
				ListSelectionModel selectionModel = ValueRepayTable02
						.getSelectionModel();
				selectionModel.setSelectionInterval(0, 0);
			}
		}

		if (ValueRepayTable06.getRowCount() > 0) {
			if (ValueRepayTable06.getSelectedRow() == -1) {
				ListSelectionModel selectionModel = ValueRepayTable06
						.getSelectionModel();
				selectionModel.setSelectionInterval(0, 0);
			}
		}

	}

	public void setTabPaneEnable() {
		for (int i = 0; i < tabbedPane.getComponentCount(); i++) {
			tabbedPane.setEnabledAt(i, true);
		}
	}

	public void setTabPaneDisable() {
		// 無資料會有一列result_ind = '1'

		if (valueRepayGroup09.getValueRepay09Count() < 1
				|| valueRepayGroup09.getValueRepay09s().get(0)
						.getR_result_ind().equals("1"))
			tabbedPane.setEnabledAt(tabbedPane.indexOfTab("還本未回回覆"), false);
		// tabbedPane.setSelectedIndex(0);

		for (int i = 0; i < tabbedPane.getComponentCount(); i++) {
			if (tabbedPane.isEnabledAt(i)) {
				tabbedPane.setSelectedIndex(i);
				break;
			}
		}
	}

	protected void initDataBindings() {
		BeanProperty<ValueRepayGroup02, List<ValueRepay02>> valueRepayGroup02BeanProperty = BeanProperty
				.create("valueRepay02s");
		JTableBinding<ValueRepay02, ValueRepayGroup02, JTable> jTableBinding = SwingBindings
				.createJTableBinding(UpdateStrategy.READ, valueRepayGroup02,
						valueRepayGroup02BeanProperty, ValueRepayTable02);
		//
		BeanProperty<ValueRepay02, String> valueRepay02BeanProperty = BeanProperty
				.create("r_cp_anniv_date");
		jTableBinding.addColumnBinding(valueRepay02BeanProperty).setColumnName(
				"\u9084\u672C\u9031\u5E74\u65E5");
		//
		BeanProperty<ValueRepay02, String> valueRepay02BeanProperty_1 = BeanProperty
				.create("r_plan_code");
		jTableBinding.addColumnBinding(valueRepay02BeanProperty_1)
				.setColumnName("\u9084\u672C\u7522\u54C1\u7C21\u540D");
		//
		BeanProperty<ValueRepay02, String> valueRepay02BeanProperty_2 = BeanProperty
				.create("r_rate_scale");
		jTableBinding.addColumnBinding(valueRepay02BeanProperty_2)
				.setColumnName("\u9084\u672C\u7248\u6578");
		//
		BeanProperty<ValueRepay02, String> valueRepay02BeanProperty_3 = BeanProperty
				.create("r_nonresp_sw");
		jTableBinding.addColumnBinding(valueRepay02BeanProperty_3)
				.setColumnName("註記");
		//
		BeanProperty<ValueRepay02, String> valueRepay02BeanProperty_4 = BeanProperty
				.create("r_cp_sts_desc");
		jTableBinding.addColumnBinding(valueRepay02BeanProperty_4)
				.setColumnName("\u9084\u672C\u72C0\u6CC1");
		//
		BeanProperty<ValueRepay02, String> valueRepay02BeanProperty_5 = BeanProperty
				.create("r_chk_sw");
		jTableBinding.addColumnBinding(valueRepay02BeanProperty_5)
				.setColumnName("\u652F\u7968\u514C\u73FE");
		//
		BeanProperty<ValueRepay02, String> valueRepay02BeanProperty_6 = BeanProperty
				.create("r_cp_amt");
		jTableBinding.addColumnBinding(valueRepay02BeanProperty_6)
				.setColumnName("\u61C9\u4ED8\u91D1\u984D");
		//
		BeanProperty<ValueRepay02, String> valueRepay02BeanProperty_7 = BeanProperty
				.create("r_add_amt");
		jTableBinding.addColumnBinding(valueRepay02BeanProperty_7)
				.setColumnName("\u52A0\u9805\u91D1\u984D");
		//
		BeanProperty<ValueRepay02, String> valueRepay02BeanProperty_8 = BeanProperty
				.create("r_sub_amt");
		jTableBinding.addColumnBinding(valueRepay02BeanProperty_8)
				.setColumnName("\u6E1B\u9805\u91D1\u984D");
		//
		BeanProperty<ValueRepay02, String> valueRepay02BeanProperty_9 = BeanProperty
				.create("r_cp_pay_amt");
		jTableBinding.addColumnBinding(valueRepay02BeanProperty_9)
				.setColumnName("\u5BE6\u4ED8\u91D1\u984D");
		//
		BeanProperty<ValueRepay02, String> valueRepay02BeanProperty_10 = BeanProperty
				.create("r_pay_type");
		jTableBinding.addColumnBinding(valueRepay02BeanProperty_10)
				.setColumnName("\u9084\u672C\u7A2E\u985E");
		//
		BeanProperty<ValueRepay02, String> valueRepay02BeanProperty_11 = BeanProperty
				.create("r_cp_return_date_interval");
		jTableBinding.addColumnBinding(valueRepay02BeanProperty_11)
				.setColumnName("回流專案回覆期間");
		//
		jTableBinding.setEditable(false);
		jTableBinding.bind();
		//
		BeanProperty<ValueRepayGroup04, List<ValueRepay04>> valueRepayGroup04BeanProperty = BeanProperty
				.create("valueRepay04s");
		JTableBinding<ValueRepay04, ValueRepayGroup04, JTable> jTableBinding_1 = SwingBindings
				.createJTableBinding(UpdateStrategy.READ, valueRepayGroup04,
						valueRepayGroup04BeanProperty, ValueRepayTable04);
		//
		BeanProperty<ValueRepay04, String> valueRepay04BeanProperty = BeanProperty
				.create("r_cp_pay_seq");
		jTableBinding_1.addColumnBinding(valueRepay04BeanProperty)
				.setColumnName("\u9806\u5E8F");
		//
		BeanProperty<ValueRepay04, String> valueRepay04BeanProperty_1 = BeanProperty
				.create("r_benf_name");
		jTableBinding_1.addColumnBinding(valueRepay04BeanProperty_1)
				.setColumnName("\u53D7\u9818\u4EBA");
		//
		BeanProperty<ValueRepay04, String> valueRepay04BeanProperty_2 = BeanProperty
				.create("r_benf_ratio");
		jTableBinding_1.addColumnBinding(valueRepay04BeanProperty_2)
				.setColumnName("\u6BD4\u7387(%)");
		//
		BeanProperty<ValueRepay04, String> valueRepay04BeanProperty_3 = BeanProperty
				.create("r_cp_pay_amt");
		jTableBinding_1.addColumnBinding(valueRepay04BeanProperty_3)
				.setColumnName("\u5BE6\u4ED8\u91D1\u984D");
		//
		BeanProperty<ValueRepay04, String> valueRepay04BeanProperty_4 = BeanProperty
				.create("r_disb_no");
		jTableBinding_1.addColumnBinding(valueRepay04BeanProperty_4)
				.setColumnName("\u4ED8\u6B3E\u865F\u78BC");
		//
		// BeanProperty<ValueRepay04, String> valueRepay04BeanProperty_5 =
		// BeanProperty
		// .create("r_remit_account");
		// jTableBinding_1.addColumnBinding(valueRepay04BeanProperty_5)
		// .setColumnName("\u96FB\u532F\u5E33\u865F")
		// .setColumnClass(String.class);
		//
		ELProperty<ValueRepay04, Object> valueRepay04BeanProperty_5 = ELProperty
				.create("${r_remit_account}${r_bank_name}");
		jTableBinding_1.addColumnBinding(valueRepay04BeanProperty_5)
				.setColumnName("\u96FB\u532F\u5E33\u865F")
				.setColumnClass(String.class);

		jTableBinding_1.setEditable(false);
		jTableBinding_1.bind();
		//
		BeanProperty<ValueRepayGroup05, List<ValueRepay05>> valueRepayGroup05BeanProperty = BeanProperty
				.create("valueRepay05s");
		JTableBinding<ValueRepay05, ValueRepayGroup05, JTable> jTableBinding_2 = SwingBindings
				.createJTableBinding(UpdateStrategy.READ, valueRepayGroup05,
						valueRepayGroup05BeanProperty, ValueRepayTable05);
		//
		BeanProperty<ValueRepay05, String> valueRepay05BeanProperty = BeanProperty
				.create("r_col_policy_no");
		jTableBinding_2.addColumnBinding(valueRepay05BeanProperty)
				.setColumnName("\u4FDD\u55AE\u865F\u78BC");
		//
		BeanProperty<ValueRepay05, String> valueRepay05BeanProperty_1 = BeanProperty
				.create("r_po_sts_code");
		jTableBinding_2.addColumnBinding(valueRepay05BeanProperty_1)
				.setColumnName("\u4FDD\u55AE\u72C0\u614B");
		//
		BeanProperty<ValueRepay05, String> valueRepay05BeanProperty_2 = BeanProperty
				.create("r_method_desc");
		jTableBinding_2.addColumnBinding(valueRepay05BeanProperty_2)
				.setColumnName("\u6536\u8CBB\u65B9\u5F0F");
		//
		BeanProperty<ValueRepay05, String> valueRepay05BeanProperty_3 = BeanProperty
				.create("r_paid_to_date");
		jTableBinding_2.addColumnBinding(valueRepay05BeanProperty_3)
				.setColumnName("\u7E73\u8CBB\u7D42\u65E5");
		//
		jTableBinding_2.setEditable(false);
		jTableBinding_2.bind();
		//
		BeanProperty<ValueRepayGroup06, List<ValueRepay06>> valueRepayGroup06BeanProperty = BeanProperty
				.create("valueRepay06s");
		JTableBinding<ValueRepay06, ValueRepayGroup06, JTable> jTableBinding_3 = SwingBindings
				.createJTableBinding(UpdateStrategy.READ, valueRepayGroup06,
						valueRepayGroup06BeanProperty, ValueRepayTable06);
		//
		BeanProperty<ValueRepay06, String> valueRepay06BeanProperty = BeanProperty
				.create("r_cp_notice_serial");
		jTableBinding_3.addColumnBinding(valueRepay06BeanProperty)
				.setColumnName("\u56DE\u8986\u5E8F\u865F");
		//
		BeanProperty<ValueRepay06, String> valueRepay06BeanProperty_1 = BeanProperty
				.create("r_act_return_date");
		jTableBinding_3.addColumnBinding(valueRepay06BeanProperty_1)
				.setColumnName("\u56DE\u8986\u65E5\u671F");
		//
		BeanProperty<ValueRepay06, String> valueRepay06BeanProperty_2 = BeanProperty
				.create("r_notice_desc");
		jTableBinding_3.addColumnBinding(valueRepay06BeanProperty_2)
				.setColumnName("\u56DE\u8986\u60C5\u5F62");
		//
		BeanProperty<ValueRepay06, String> valueRepay06BeanProperty_3 = BeanProperty
				.create("r_notice_sub_desc");
		jTableBinding_3.addColumnBinding(valueRepay06BeanProperty_3)
				.setColumnName("\u8655\u7406\u60C5\u5F62");
		//
		BeanProperty<ValueRepay06, String> valueRepay06BeanProperty_4 = BeanProperty
				.create("r_process_name");
		jTableBinding_3.addColumnBinding(valueRepay06BeanProperty_4)
				.setColumnName("\u627F\u8FA6\u8005(\u4E2D\u6587)");
		//
		BeanProperty<ValueRepay06, String> valueRepay06BeanProperty_5 = BeanProperty
				.create("r_dept_name");
		jTableBinding_3.addColumnBinding(valueRepay06BeanProperty_5)
				.setColumnName("\u627F\u8FA6\u55AE\u4F4D");
		//
		jTableBinding_3.setEditable(false);
		jTableBinding_3.bind();
		//
		BeanProperty<ValueRepayGroup10, List<ValueRepay10>> valueRepayGroup10BeanProperty = BeanProperty
				.create("valueRepay10s");
		JTableBinding<ValueRepay10, ValueRepayGroup10, JTable> jTableBinding_4 = SwingBindings
				.createJTableBinding(UpdateStrategy.READ, valueRepayGroup10,
						valueRepayGroup10BeanProperty, ValueRepayTable07);
		//
		BeanProperty<ValueRepay10, String> valueRepay10BeanProperty = BeanProperty
				.create("r_check_no");
		jTableBinding_4.addColumnBinding(valueRepay10BeanProperty)
				.setColumnName("支票號碼");
		//
		BeanProperty<ValueRepay10, String> valueRepay10BeanProperty_1 = BeanProperty
				.create("r_payee_id_ori");
		jTableBinding_4.addColumnBinding(valueRepay10BeanProperty_1)
				.setColumnName("原受領人ID");
		//
		BeanProperty<ValueRepay10, String> valueRepay10BeanProperty_2 = BeanProperty
				.create("r_payee_name_ori");
		jTableBinding_4.addColumnBinding(valueRepay10BeanProperty_2)
				.setColumnName("原受領人姓名");
		//
		BeanProperty<ValueRepay10, String> valueRepay10BeanProperty_3 = BeanProperty
				.create("r_payee_id_new");
		jTableBinding_4.addColumnBinding(valueRepay10BeanProperty_3)
				.setColumnName("新受領人ID");
		//
		BeanProperty<ValueRepay10, String> valueRepay10BeanProperty_4 = BeanProperty
				.create("r_payee_name_new");
		jTableBinding_4.addColumnBinding(valueRepay10BeanProperty_4)
				.setColumnName("新受領人姓名");
		//
		BeanProperty<ValueRepay10, String> valueRepay10BeanProperty_5 = BeanProperty
				.create("r_remit_title");
		jTableBinding_4.addColumnBinding(valueRepay10BeanProperty_5)
				.setColumnName("匯款銀行");
		//
		BeanProperty<ValueRepay10, String> valueRepay10BeanProperty_6 = BeanProperty
				.create("r_remit_account");
		jTableBinding_4.addColumnBinding(valueRepay10BeanProperty_6)
				.setColumnName("匯款帳號");
		//
		BeanProperty<ValueRepay10, String> valueRepay10BeanProperty_7 = BeanProperty
				.create("r_pay_desc");
		jTableBinding_4.addColumnBinding(valueRepay10BeanProperty_7)
				.setColumnName("說明");
		//
		jTableBinding_4.setEditable(false);
		jTableBinding_4.bind();
		//

		BeanProperty<ValueRepayGroup11, List<ValueRepay11>> valueRepayGroup11BeanProperty = BeanProperty
				.create("valueRepay11s");
		JTableBinding<ValueRepay11, ValueRepayGroup11, JTable> jTableBinding_5 = SwingBindings
				.createJTableBinding(UpdateStrategy.READ, valueRepayGroup11,
						valueRepayGroup11BeanProperty, ValueRepayTable08);
		//
		BeanProperty<ValueRepay11, String> valueRepay11BeanProperty = BeanProperty
				.create("r_policy_no");
		jTableBinding_5.addColumnBinding(valueRepay11BeanProperty)
				.setColumnName("保單號碼");
		//
		jTableBinding_5.setEditable(false);
		jTableBinding_5.bind();
		//
	}
}
