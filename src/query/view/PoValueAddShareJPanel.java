package query.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.text.DecimalFormat;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;

import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

import query.controller.PoValueAddShareController;
import query.model.PoValueAddShare.PoValueAddShare01;
import query.model.PoValueAddShare.PoValueAddShare02;
import query.model.PoValueAddShare.PoValueAddShare03;
import query.model.PoValueAddShare.PoValueAddShareGroup01;
import query.model.PoValueAddShare.PoValueAddShareGroup02;
import query.model.PoValueAddShare.PoValueAddShareGroup03;

/**
 * @author F1256819
 * @category 增值回饋分享金畫面Panel (window builder)
 */
public class PoValueAddShareJPanel extends JPanel {
	private JTable poValueAddShareTable;
	private JTable table_1;
	private PoValueAddShareController poValueAddShareController;
	private int vpx = 110, vpy = 25; // vertical pane 欄寬高

	private PoValueAddShareGroup01 poValueAddShareGroup01 = new PoValueAddShareGroup01();
	private PoValueAddShareGroup02 poValueAddShareGroup02 = new PoValueAddShareGroup02();
	private PoValueAddShareGroup03 poValueAddShareGroup03 = new PoValueAddShareGroup03();

	// 第一區資料 verticalPane
	private VerticalPane vp01 = new VerticalPane(new String[] { "保單號碼", "計算日期",
			"保單週月", "回饋分享金", "保單年度" }, "", vpx, vpy);
	private VerticalPane vp02 = new VerticalPane(new String[] { "要保人", "應繳費日",
			"回饋金週期", "本次利息", "保險年齡" }, "", vpx, vpy);
	private VerticalPane vp03 = new VerticalPane(new String[] { "保單生效日", "險種",
			"給付頻率", "回饋分享金總和", "回饋抵繳" }, "", vpx, vpy);
	private VerticalPane vp04 = new VerticalPane(new String[] { "幣別", "保單狀態",
			"回饋金選擇1", "回饋金選擇2", "閉鎖期(年)" }, "", vpx, vpy);

	/**
	 * Create the panel.
	 */
	public PoValueAddShareJPanel() {
		setLayout(new BorderLayout(0, 0));

		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setDividerLocation(vpy * 5 + 39);
		add(splitPane);

		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setResizeWeight(0.66);
		splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setRightComponent(splitPane_1);
		JPanel bottom_up_panel = new JPanel();
		bottom_up_panel.setBorder(new TitledBorder(null,
				"\u56DE\u994B\u5206\u4EAB\u91D1\u8AAA\u660E",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		bottom_up_panel.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();

		scrollPane.setViewportBorder(null);
		bottom_up_panel.add(scrollPane);
		splitPane_1.setLeftComponent(bottom_up_panel);

		poValueAddShareTable = new JTable();
		poValueAddShareTable
				.setToolTipText("\u56DE\u994B\u5206\u4EAB\u91D1\u8AAA\u660E");
		poValueAddShareTable
				.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		poValueAddShareTable.setFillsViewportHeight(true);
		scrollPane.setViewportView(poValueAddShareTable);

		JPanel bottom_down_panel = new JPanel();
		bottom_down_panel.setBorder(new TitledBorder(null,
				"\u5BA3\u544A\u5229\u7387", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		bottom_down_panel.setLayout(new BorderLayout(0, 0));
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setViewportBorder(null);
		bottom_down_panel.add(scrollPane_1);
		splitPane_1.setRightComponent(bottom_down_panel);

		table_1 = new JTable();
		table_1.setFillsViewportHeight(true);
		scrollPane_1.setViewportView(table_1);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null,
				"\u56DE\u994B\u5206\u4EAB\u91D1\u8CC7\u6599",
				TitledBorder.LEFT, TitledBorder.TOP, null, null));
		splitPane.setLeftComponent(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		panel.add(vp01);
		panel.add(vp02);
		panel.add(vp03);
		panel.add(vp04);
		initDataBindings();

		// 小數下兩位格式render
		TableColumnModel poValueTableModel = poValueAddShareTable
				.getColumnModel();
		DefaultTableCellRenderer digitRender = new DefaultTableCellRenderer() {
			public Component getTableCellRendererComponent(JTable table,
					Object value, boolean isSelected, boolean hasFocus,
					int row, int column) {
				DecimalFormat df = new DecimalFormat("0.00");
				try {
					value = df.format(Double.parseDouble(value.toString()));
				} catch (Exception e) {
					return this;
				}
				setValue(value);
				return this;
			}
		};
		poValueTableModel.getColumn(1).setCellRenderer(digitRender);
		poValueTableModel.getColumn(2).setCellRenderer(digitRender);
		poValueTableModel.getColumn(4).setCellRenderer(digitRender);
		poValueTableModel.getColumn(5).setCellRenderer(digitRender);
		DefaultTableCellRenderer rateRender = new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable table,
					Object value, boolean isSelected, boolean hasFocus,
					int row, int column) {
				DecimalFormat df = new DecimalFormat("0.000");
				try {
					value = df.format(Double.parseDouble(value.toString()));
				} catch (Exception e) {
					return this;
				}
				setValue(value);
				return this;
			}
		};
		table_1.getColumnModel().getColumn(1).setCellRenderer(rateRender);

		// verticalPane數字格式
		DefaultTableCellRenderer vpdigitRender = new DefaultTableCellRenderer() {
			public Component getTableCellRendererComponent(JTable table,
					Object value, boolean isSelected, boolean hasFocus,
					int row, int column) {
				if (row == 3) {
					if (value != null) {
						DecimalFormat df = new DecimalFormat("0.00");
						try {
							value = df.format(Double.parseDouble(value
									.toString()));
						} catch (Exception e) {
							return this;
						}
					}
				}
				setValue(value);
				return this;
			}
		};

		vp01.getDataTable().getColumnModel().getColumn(0)
				.setCellRenderer(vpdigitRender);
		vp02.getDataTable().getColumnModel().getColumn(0)
				.setCellRenderer(vpdigitRender);
		vp03.getDataTable().getColumnModel().getColumn(0)
				.setCellRenderer(vpdigitRender);

	}

	public void setController(PoValueAddShareController controller) {
		poValueAddShareController = controller;
	}

	public void nullAll() {
		poValueAddShareGroup01 = null;
		poValueAddShareGroup02 = null;
		poValueAddShareGroup03 = null;
	}

	public void clearAll() {
		clearPoValueAddShare01();
		poValueAddShareGroup01.removeAll();
		poValueAddShareGroup02.removeAll();
		poValueAddShareGroup03.removeAll();
	}

	public void addPoValueAddShare01(PoValueAddShare01 poValue) {
		// TODO
		poValueAddShareGroup01.addPoValueAddShare01(poValue);
		vp01.setValue(new String[] { poValue.getR_policy_no(),
				poValue.getR_calc_date(), poValue.getR_policy_moniv_date(),
				poValue.getR_accu_amt(), poValue.getR_dur() });
		vp02.setValue(new String[] { poValue.getR_o1_names(),
				poValue.getR_paid_to_date(), poValue.getR_refund_cycle(),
				poValue.getR_this_int(), poValue.getR_age() });
		vp03.setValue(new String[] { poValue.getR_po_issue_date(),
				poValue.getR_plan_code(), poValue.getR_div_pay_freq_ch(),
				poValue.getR_total_amt(), poValue.getR_accu_return_amt() });
		vp04.setValue(new String[] { poValue.getR_currency_ch(),
				poValue.getR_po_sts_code(), poValue.getR_div_option_ch(),
				poValue.getR_div_option_ch2(), poValue.getR_div_lock_dur() });

	}

	public void clearPoValueAddShare01() {
		poValueAddShareGroup01.removeAll();
		vp01.setValue(new String[4]);
		vp02.setValue(new String[4]);
		vp03.setValue(new String[4]);
		vp04.setValue(new String[4]);
	}

	public void addPoValueAddShare02(PoValueAddShare02 poValue) {
		poValueAddShareGroup02.addPoValueAddShare02(poValue);
	}

	public void addPoValueAddShare03(PoValueAddShare03 poValue) {
		poValueAddShareGroup03.addPoValueAddShare03(poValue);
	}

	public void clearPoValueAddShare02() {
		poValueAddShareGroup02.removeAll();
	}

	public void clearPoValueAddShare03() {
		poValueAddShareGroup03.removeAll();
	}

	protected void initDataBindings() {
		BeanProperty<PoValueAddShareGroup02, List<PoValueAddShare02>> poValueAddShareGroup02BeanProperty = BeanProperty
				.create("poValueAddShare02s");
		JTableBinding<PoValueAddShare02, PoValueAddShareGroup02, JTable> jTableBinding = SwingBindings
				.createJTableBinding(UpdateStrategy.READ,
						poValueAddShareGroup02,
						poValueAddShareGroup02BeanProperty,
						poValueAddShareTable);
		//
		BeanProperty<PoValueAddShare02, String> poValueAddShare02BeanProperty = BeanProperty
				.create("r_int_date");
		jTableBinding.addColumnBinding(poValueAddShare02BeanProperty)
				.setColumnName("計息日");
		//
		BeanProperty<PoValueAddShare02, String> poValueAddShare02BeanProperty_1 = BeanProperty
				.create("r_this_calc_amt");
		jTableBinding.addColumnBinding(poValueAddShare02BeanProperty_1)
				.setColumnName("計算本金");
		//
		BeanProperty<PoValueAddShare02, String> poValueAddShare02BeanProperty_2 = BeanProperty
				.create("r_this_int");
		jTableBinding.addColumnBinding(poValueAddShare02BeanProperty_2)
				.setColumnName("利息");
		//
		BeanProperty<PoValueAddShare02, String> poValueAddShare02BeanProperty_3 = BeanProperty
				.create("r_tran_item");
		jTableBinding.addColumnBinding(poValueAddShare02BeanProperty_3)
				.setColumnName("交易項目");
		//
		BeanProperty<PoValueAddShare02, String> poValueAddShare02BeanProperty_4 = BeanProperty
				.create("r_amount");
		jTableBinding.addColumnBinding(poValueAddShare02BeanProperty_4)
				.setColumnName("交易金額");
		//
		BeanProperty<PoValueAddShare02, String> poValueAddShare02BeanProperty_5 = BeanProperty
				.create("r_accu_refund");
		jTableBinding.addColumnBinding(poValueAddShare02BeanProperty_5)
				.setColumnName("累計回饋分享金");
		//
		BeanProperty<PoValueAddShare02, String> poValueAddShare02BeanProperty_6 = BeanProperty
				.create("r_accu_return_amt");
		jTableBinding.addColumnBinding(poValueAddShare02BeanProperty_6)
				.setColumnName("回饋抵繳");

		//
		BeanProperty<PoValueAddShare02, String> poValueAddShare02BeanProperty_7 = BeanProperty
				.create("r_process_date");
		jTableBinding.addColumnBinding(poValueAddShare02BeanProperty_7)
				.setColumnName("作業日期");

		//
		BeanProperty<PoValueAddShareGroup03, List<PoValueAddShare03>> poValueAddShareGroup03BeanProperty = BeanProperty
				.create("poValueAddShare03s");
		jTableBinding.setEditable(false);
		jTableBinding.bind();

		JTableBinding<PoValueAddShare03, PoValueAddShareGroup03, JTable> jTableBinding_1 = SwingBindings
				.createJTableBinding(UpdateStrategy.READ,
						poValueAddShareGroup03,
						poValueAddShareGroup03BeanProperty, table_1);
		//
		BeanProperty<PoValueAddShare03, String> poValueAddShare03BeanProperty = BeanProperty
				.create("r_int_ym");
		jTableBinding_1.addColumnBinding(poValueAddShare03BeanProperty)
				.setColumnName("日期");
		//
		BeanProperty<PoValueAddShare03, String> poValueAddShare03BeanProperty_1 = BeanProperty
				.create("r_int_rate_decl");
		jTableBinding_1.addColumnBinding(poValueAddShare03BeanProperty_1)
				.setColumnName("宣告利率％");
		//
		jTableBinding_1.setEditable(false);
		jTableBinding_1.bind();
	}
}
