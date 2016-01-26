package query.view;

/**
 * @author swei
 * 
 * @version 1.0<br>
 *          101/03/28<br>
 *          投資交易_每月扣除額(VIEW)
 * @since 1.0
 */
import java.awt.BorderLayout;
import java.util.List;

import javax.swing.DefaultListSelectionModel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SpringLayout;
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

import query.controller.InvestDeductionController;
import query.model.InvestDeduction.InvestDeduction01;
import query.model.InvestDeduction.InvestDeduction01Group;
import query.model.InvestDeduction.InvestDeduction02;
import query.model.InvestDeduction.InvestDeduction02Group;

public class InvestDeductionJPanel extends JPanel {
	private JTable table_1;
	private InvestDeductionController controller;
	public String k_policy_no = "";
	public String k_paid_to_date;
	public String k_seq_no;

	private InvestDeduction01Group group01 = new InvestDeduction01Group();// add
	private InvestDeduction02Group group02 = new InvestDeduction02Group();// add
	private JTable table;

	/**
	 * Create the panel.
	 */
	public InvestDeductionJPanel() {
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);

		JPanel panel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel, 0,
				SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, panel, 0,
				SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, panel, -242,
				SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, panel, 0,
				SpringLayout.EAST, this);
		panel.setBorder(new TitledBorder(null,
				"\u6BCF\u6708\u6263\u9664\u984D", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane_1 = new JScrollPane();
		panel.add(scrollPane_1, BorderLayout.CENTER);

		table_1 = new JTable();
		table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// 選取扣除額明細event handle
		// 修改掉原來作法以免又跟ListSelectionHandler搞混
		table_1.getSelectionModel().addListSelectionListener(
				new ListSelectionHandle());
		scrollPane_1.setViewportView(table_1);
		new VerticalPane();

		JPanel panel_1 = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel_1, 6,
				SpringLayout.SOUTH, panel);
		springLayout.putConstraint(SpringLayout.WEST, panel_1, 0,
				SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, panel_1, 0,
				SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, panel_1, 0,
				SpringLayout.EAST, this);
		panel_1.setBorder(new TitledBorder(null,
				"\u6263\u9664\u984D\u660E\u7D30", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		scrollPane.setViewportView(table);

		initDataBindings();

		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);

		// table_1(欄位調整)
		TableColumn headerCol = table_1.getColumnModel().getColumn(0);
		headerCol.setPreferredWidth(60);
		headerCol = table_1.getColumnModel().getColumn(1);
		headerCol.setPreferredWidth(60);
		headerCol = table_1.getColumnModel().getColumn(6);
		headerCol.setPreferredWidth(20);

		// Table2_(欄位調整)
		TableColumn headerCol2 = table.getColumnModel().getColumn(0);
		headerCol2.setPreferredWidth(10);
		headerCol2 = table.getColumnModel().getColumn(1);
		headerCol2.setPreferredWidth(30);
		headerCol2 = table.getColumnModel().getColumn(2);
		headerCol2.setPreferredWidth(30);
		headerCol2 = table.getColumnModel().getColumn(3);
		headerCol2.setPreferredWidth(30);

		// 調整靠右
		for (int i = 1; i < 5; i++) {
			headerCol = table_1.getColumnModel().getColumn(i);
			headerCol.setCellRenderer(rightRenderer);
		}
		for (int i = 3; i < table.getColumnCount(); i++) {
			headerCol = table.getColumnModel().getColumn(i);
			headerCol.setCellRenderer(rightRenderer);
		}
	}

	// ------>扣除額明細
	private class ListSelectionHandle implements ListSelectionListener {
		//
		public void valueChanged(ListSelectionEvent arg0) {
			if (!((DefaultListSelectionModel) arg0.getSource())
					.getValueIsAdjusting()) {
				int i = table_1.getSelectedRow();
				if (i != -1) {
					k_policy_no = QueryFrame.policy_info[0];// "649800033764";
					k_paid_to_date = group01.getMonthlydeduction01s().get(i)
							.getM_paid_to_date();// 取[週年日]
					k_seq_no = group01.getMonthlydeduction01s().get(i)
							.getM_seq_no(); // 取[序號]

					controller.executeMission(k_policy_no, k_paid_to_date,
							k_seq_no);

				}
			}
		}
	}

	public void setDefaultRow() {
		if (table_1.getRowCount() > 0) {
			if (table_1.getSelectedRow() == -1) {
				ListSelectionModel selectionModel = table_1.getSelectionModel();
				selectionModel.setSelectionInterval(0, 0);
			}
		}
	}

	// 清空資料
	public void clearAll() {
		group01.removeAll();
		group02.removeAll();
	}

	public void nullAll() {
		group01 = null;
		group02 = null;
		controller = null;
	}

	/**
	 * @category 新增群組(MonthlyDeductionGroup)
	 * 
	 * @param monthlydeduction01
	 */

	public void addMonthlyDeduction01(InvestDeduction01 monthlydeduction01) {
		group01.addMonthlyDeduction01(monthlydeduction01);
	}

	public void addMonthlyDeduction02(InvestDeduction02 monthlydeDeduction02) {
		group02.addMonthlyDeduction02(monthlydeDeduction02);
	}

	// 清除群組中的所有組員(Group)
	public void clearMonthlyDeduction01s() {
		group01.removeAll();
	}

	public void clearMonthlyDeduction02s() {
		group02.removeAll();

	}

	public void setController(InvestDeductionController controller) { // add
		this.controller = controller;
	}

	protected void initDataBindings() {
		BeanProperty<InvestDeduction01Group, List<InvestDeduction01>> monthlyDeduction01GroupBeanProperty = BeanProperty
				.create("monthlydeduction01s");
		JTableBinding<InvestDeduction01, InvestDeduction01Group, JTable> jTableBinding = SwingBindings
				.createJTableBinding(UpdateStrategy.READ, group01,
						monthlyDeduction01GroupBeanProperty, table_1);
		//
		BeanProperty<InvestDeduction01, String> monthlyDeduction01BeanProperty = BeanProperty
				.create("m_paid_to_date");
		jTableBinding.addColumnBinding(monthlyDeduction01BeanProperty)
				.setColumnName("\u9031\u5E74\u65E5");
		//
		BeanProperty<InvestDeduction01, String> monthlyDeduction01BeanProperty_1 = BeanProperty
				.create("m_acct_fee");
		jTableBinding.addColumnBinding(monthlyDeduction01BeanProperty_1)
				.setColumnName("\u5E33\u6236\u7BA1\u7406\u8CBB");
		//
		BeanProperty<InvestDeduction01, String> monthlyDeduction01BeanProperty_2 = BeanProperty
				.create("m_target_fee");
		jTableBinding.addColumnBinding(monthlyDeduction01BeanProperty_2)
				.setColumnName("\u76EE\u6A19\u7BA1\u7406\u8CBB");
		//
		BeanProperty<InvestDeduction01, String> monthlyDeduction01BeanProperty_3 = BeanProperty
				.create("m_coi_amt");
		jTableBinding.addColumnBinding(monthlyDeduction01BeanProperty_3)
				.setColumnName("\u61C9\u6263COI");
		//
		BeanProperty<InvestDeduction01, String> monthlyDeduction01BeanProperty_4 = BeanProperty
				.create("m_coi_amt_pay");
		jTableBinding.addColumnBinding(monthlyDeduction01BeanProperty_4)
				.setColumnName("\u5BE6\u6263COI");
		//
		BeanProperty<InvestDeduction01, String> monthlyDeduction01BeanProperty_5 = BeanProperty
				.create("m_tran_date");
		jTableBinding.addColumnBinding(monthlyDeduction01BeanProperty_5)
				.setColumnName("\u5165\u5E33\u65E5");
		//
		BeanProperty<InvestDeduction01, String> monthlyDeduction01BeanProperty_6 = BeanProperty
				.create("m_vcoid_sts");
		jTableBinding.addColumnBinding(monthlyDeduction01BeanProperty_6)
				.setColumnName("\u6263\u5426");
		//
		BeanProperty<InvestDeduction01, String> investDeduction01BeanProperty = BeanProperty
				.create("r_coi_seq_ind");
		jTableBinding.addColumnBinding(investDeduction01BeanProperty)
				.setColumnName("\u5BE6\u969B\u6263\u6536\u65B9\u5F0F");
		//
		jTableBinding.setEditable(false);
		jTableBinding.bind();
		//
		BeanProperty<InvestDeduction02Group, List<InvestDeduction02>> monthlyDeduction02GroupBeanProperty = BeanProperty
				.create("monthlydeduction02s");
		JTableBinding<InvestDeduction02, InvestDeduction02Group, JTable> jTableBinding_1 = SwingBindings
				.createJTableBinding(UpdateStrategy.READ, group02,
						monthlyDeduction02GroupBeanProperty, table);
		//
		BeanProperty<InvestDeduction02, String> monthlyDeduction02BeanProperty = BeanProperty
				.create("m_seq_no");
		jTableBinding_1.addColumnBinding(monthlyDeduction02BeanProperty)
				.setColumnName("\u5E8F\u865F");
		//
		BeanProperty<InvestDeduction02, String> monthlyDeduction02BeanProperty_1 = BeanProperty
				.create("m_plan_code");
		jTableBinding_1.addColumnBinding(monthlyDeduction02BeanProperty_1)
				.setColumnName("\u7522\u54C1\u96AA\u7A2E");
		//
		BeanProperty<InvestDeduction02, String> monthlyDeduction02BeanProperty_2 = BeanProperty
				.create("m_rate_scale");
		jTableBinding_1.addColumnBinding(monthlyDeduction02BeanProperty_2)
				.setColumnName("\u7248\u6578");
		//
		BeanProperty<InvestDeduction02, String> investDeduction02BeanProperty = BeanProperty
				.create("m_coi_face_amt");
		jTableBinding_1.addColumnBinding(investDeduction02BeanProperty)
				.setColumnName("\u6DE8\u5371\u96AA\u4FDD\u984D(\u842C)");
		//
		BeanProperty<InvestDeduction02, String> monthlyDeduction02BeanProperty_4 = BeanProperty
				.create("m_coi_amt2");
		jTableBinding_1.addColumnBinding(monthlyDeduction02BeanProperty_4)
				.setColumnName("\u61C9\u6263COI");
		//
		BeanProperty<InvestDeduction02, String> monthlyDeduction02BeanProperty_5 = BeanProperty
				.create("m_coi_amt_pay2");
		jTableBinding_1.addColumnBinding(monthlyDeduction02BeanProperty_5)
				.setColumnName("\u5BE6\u6263COI");
		//
		jTableBinding_1.setEditable(false);
		jTableBinding_1.bind();
	}
}
