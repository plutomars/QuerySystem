package query.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.List;

import javax.swing.DefaultListSelectionModel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;

import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

import query.controller.InvestAppointController;
import query.model.InvestAppoint.InvestSwitchAppoint01;
import query.model.InvestAppoint.InvestSwitchAppoint02;
import query.model.InvestAppoint.InvestSwitchAppointBuyGroup;
import query.model.InvestAppoint.InvestSwitchAppointGroup01;
import query.model.InvestAppoint.InvestSwitchAppointGroup02;
import query.model.InvestAppoint.InvestSwitchAppointSellGroup;
import query.model.InvestAppoint.InvestSwitchBuyAppoint03;
import query.model.InvestAppoint.InvestSwitchSellAppoint03;
import query.model.InvestAppoint.InvestWithdrawAppoint01;
import query.model.InvestAppoint.InvestWithdrawAppoint02;
import query.model.InvestAppoint.InvestWithdrawAppoint03;
import query.model.InvestAppoint.InvestWithdrawAppointGroup01;
import query.model.InvestAppoint.InvestWithdrawAppointGroup02;
import query.model.InvestAppoint.InvestWithdrawAppointGroup03;

public class InvestAppointJPanel extends JPanel implements
		ListSelectionListener {

	private static final long serialVersionUID = 1L;
	private InvestWithdrawAppointGroup01 investWithdrawAppointGroup01 = new InvestWithdrawAppointGroup01();
	private InvestWithdrawAppointGroup02 investWithdrawAppointGroup02 = new InvestWithdrawAppointGroup02();
	private InvestWithdrawAppointGroup03 investWithdrawAppointGroup03 = new InvestWithdrawAppointGroup03();
	private InvestSwitchAppointGroup01 investSwitchAppointGroup01 = new InvestSwitchAppointGroup01();
	private InvestSwitchAppointGroup02 investSwitchAppointGroup02 = new InvestSwitchAppointGroup02();
	private InvestSwitchAppointSellGroup investSwitchAppointSellGroup = new InvestSwitchAppointSellGroup();
	private InvestSwitchAppointBuyGroup investSwitchAppointBuyGroup = new InvestSwitchAppointBuyGroup();

	private InvestAppointController investAppointController;
	private JTable withdraw_appoint_table;
	private JTable withdraw_detail_table;
	private JTable withdraw_header_table;
	private JTabbedPane tabbedPane;
	private JTable switch_header_table;
	private JTable switch_appoint_table;
	private JTable switch_sell_detail_table;
	private JTable switch_buy_detail_table;

	public InvestAppointJPanel() {
		setLayout(new BorderLayout(0, 0));

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);

		add(tabbedPane, BorderLayout.CENTER);

		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.5);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		tabbedPane.addTab("約定提領", null, splitPane, null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null,
				"\u7D04\u5B9A\u63D0\u9818\u660E\u7D30", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		splitPane.setRightComponent(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JSplitPane splitPane_2 = new JSplitPane();
		splitPane_2.setResizeWeight(0.1);
		splitPane_2.setOrientation(JSplitPane.VERTICAL_SPLIT);
		panel.add(splitPane_2, BorderLayout.CENTER);

		JScrollPane scrollPane_2 = new JScrollPane();
		splitPane_2.setLeftComponent(scrollPane_2);

		withdraw_appoint_table = new JTable();
		withdraw_appoint_table.setRowSelectionAllowed(false);
		scrollPane_2.setViewportView(withdraw_appoint_table);

		JScrollPane scrollPane_5 = new JScrollPane();
		splitPane_2.setRightComponent(scrollPane_5);

		withdraw_detail_table = new JTable();
		withdraw_detail_table.setRowSelectionAllowed(false);
		scrollPane_5.setViewportView(withdraw_detail_table);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null,
				"\u7D04\u5B9A\u63D0\u9818\u4EA4\u6613", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		splitPane.setLeftComponent(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane_1 = new JScrollPane();
		panel_1.add(scrollPane_1);

		withdraw_header_table = new JTable();
		withdraw_header_table
				.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		withdraw_header_table.getSelectionModel()
				.addListSelectionListener(this);
		scrollPane_1.setViewportView(withdraw_header_table);

		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setResizeWeight(0.5);
		splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		tabbedPane.addTab("約定轉換", null, splitPane_1, null);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null,
				"\u7D04\u5B9A\u8F49\u63DB\u4EA4\u6613", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		splitPane_1.setLeftComponent(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel_2.add(scrollPane, BorderLayout.CENTER);

		switch_header_table = new JTable();
		switch_header_table
				.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		switch_header_table.getSelectionModel().addListSelectionListener(this);
		scrollPane.setViewportView(switch_header_table);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null,
				"\u7D04\u5B9A\u8F49\u63DB\u660E\u7D30", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		splitPane_1.setRightComponent(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));

		JSplitPane splitPane_3 = new JSplitPane();
		splitPane_3.setResizeWeight(0.1);
		splitPane_3.setOrientation(JSplitPane.VERTICAL_SPLIT);
		panel_3.add(splitPane_3, BorderLayout.CENTER);

		JSplitPane splitPane_4 = new JSplitPane();
		splitPane_4.setResizeWeight(0.58);
		splitPane_3.setRightComponent(splitPane_4);

		JScrollPane scrollPane_4 = new JScrollPane();
		splitPane_4.setLeftComponent(scrollPane_4);
		// scrollPane_4.setBorder(new TitledBorder("約定轉換轉出"));
		scrollPane_4.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"),
				"\u7D04\u5B9A\u8F49\u63DB\u8F49\u51FA", TitledBorder.CENTER,
				TitledBorder.ABOVE_TOP, null, new Color(0, 70, 213)));

		switch_sell_detail_table = new JTable();
		switch_sell_detail_table.setRowSelectionAllowed(false);
		scrollPane_4.setViewportView(switch_sell_detail_table);

		JScrollPane scrollPane_6 = new JScrollPane();
		splitPane_4.setRightComponent(scrollPane_6);
		scrollPane_6.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"),
				"\u7D04\u5B9A\u8F49\u63DB\u8F49\u5165", TitledBorder.CENTER,
				TitledBorder.ABOVE_TOP, null, new Color(0, 70, 213)));

		switch_buy_detail_table = new JTable();
		switch_buy_detail_table.setRowSelectionAllowed(false);
		scrollPane_6.setViewportView(switch_buy_detail_table);

		JScrollPane scrollPane_3 = new JScrollPane();
		splitPane_3.setLeftComponent(scrollPane_3);

		switch_appoint_table = new JTable();

		switch_appoint_table.setRowSelectionAllowed(false);
		scrollPane_3.setViewportView(switch_appoint_table);
		initDataBindings();

		// 設定table header顏色
		DefaultTableCellRenderer blueheaderRenderer = new DefaultTableCellRenderer();
		blueheaderRenderer.setBackground(new Color(185, 210, 255));

		for (int i = 0; i < switch_appoint_table.getModel().getColumnCount(); i++) {
			switch_appoint_table.getColumnModel().getColumn(i)
					.setHeaderRenderer(blueheaderRenderer);
		}

		for (int i = 0; i < withdraw_appoint_table.getModel().getColumnCount(); i++) {
			withdraw_appoint_table.getColumnModel().getColumn(i)
					.setHeaderRenderer(blueheaderRenderer);
		}

	}

	public void addInvestWithdraw01(InvestWithdrawAppoint01 hsmp) {
		investWithdrawAppointGroup01.addInvestAppoint01(hsmp);
	}

	public void addInvestWithdraw02(InvestWithdrawAppoint02 hsmp) {
		investWithdrawAppointGroup02.addInvestAppoint02(hsmp);
	}

	public void addInvestWithdraw03(InvestWithdrawAppoint03 hsmp) {
		investWithdrawAppointGroup03.addInvestAppoint03(hsmp);
	}

	public void addInvestSwitchAppoint01(InvestSwitchAppoint01 hsmp) {
		investSwitchAppointGroup01.addInvestAppoint01(hsmp);
	}

	public void addInvestSwitchAppoint02(InvestSwitchAppoint02 hsmp) {
		investSwitchAppointGroup02.addInvestAppoint02(hsmp);
	}

	public void addInvestSwitchSellAppoint(InvestSwitchSellAppoint03 hsmp) {
		investSwitchAppointSellGroup.addInvestAppoint03(hsmp);
	}

	public void addInvestSwitchBuyAppoint(InvestSwitchBuyAppoint03 hsmp) {
		investSwitchAppointBuyGroup.addInvestAppoint03(hsmp);
	}

	public void clearInvestWithdraw01() {
		investWithdrawAppointGroup01.removeAll();

	}

	public void clearInvestWithdraw02() {
		investWithdrawAppointGroup02.removeAll();
	}

	public void clearInvestWithdraw03() {
		investWithdrawAppointGroup03.removeAll();
	}

	public void clearInvestSwitch01() {
		investSwitchAppointGroup01.removeAll();
	}

	public void clearInvestSwitch02() {
		investSwitchAppointGroup02.removeAll();
	}

	public void clearInvestSwitch03() {
		investSwitchAppointSellGroup.removeAll();
		investSwitchAppointBuyGroup.removeAll();
	}

	public void clearAll() {
		clearInvestWithdraw01();
		clearInvestWithdraw02();
		clearInvestWithdraw03();
		clearInvestSwitch01();
		clearInvestSwitch02();
		clearInvestSwitch03();
	}

	public void nullAll() {
		investWithdrawAppointGroup01 = null;
		investWithdrawAppointGroup02 = null;
		investWithdrawAppointGroup03 = null;
		investSwitchAppointGroup01 = null;
		investSwitchAppointGroup02 = null;
		investSwitchAppointSellGroup = null;
		investSwitchAppointBuyGroup = null;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (!((DefaultListSelectionModel) e.getSource()).getValueIsAdjusting()) {
			int withdrawRowSelect = withdraw_header_table.getSelectedRow();
			int switchRowSelect = switch_header_table.getSelectedRow();
			int chah_seq = 0;
			int chlh_seq = 0;
			if (withdrawRowSelect != -1) {
				if (e.getSource().equals(
						withdraw_header_table.getSelectionModel())) {
					setTabPaneEnable();
					chah_seq = Double.valueOf(
							investWithdrawAppointGroup01
									.getInvestWithdrawAppoint01s()
									.get(withdrawRowSelect).getR_chah_seq())
							.intValue();
					investAppointController
							.executeWithdrawInnerMission(chah_seq);

					chlh_seq = Double.valueOf(
							investWithdrawAppointGroup01
									.getInvestWithdrawAppoint01s()
									.get(withdrawRowSelect).getR_chlh_seq())
							.intValue();
					investAppointController.executeWithdrawInnerMission(
							chah_seq, chlh_seq);

				}
			}
			if (switchRowSelect != -1) {
				if (e.getSource().equals(
						switch_header_table.getSelectionModel())) {
					setTabPaneEnable();
					chah_seq = Double.valueOf(
							investSwitchAppointGroup01
									.getInvestSwitchAppoint01s()
									.get(switchRowSelect).getR_chah_seq())
							.intValue();
					investAppointController.executeSwitchInnerMission(chah_seq);

					chlh_seq = Double.valueOf(
							investSwitchAppointGroup01
									.getInvestSwitchAppoint01s()
									.get(switchRowSelect).getR_chlh_seq())
							.intValue();
					investAppointController.executeSwitchInnerMission(chah_seq,
							chlh_seq);

				}
			}
			setTabPaneEnable();
			setTabPaneDisable();
		}
	}

	public void setDefaultRow() {
		if (withdraw_header_table.getRowCount() > 0) {
			ListSelectionModel selectionModel = withdraw_header_table
					.getSelectionModel();
			selectionModel.setSelectionInterval(0, 0);
		}
		if (switch_header_table.getRowCount() > 0) {
			ListSelectionModel selectionModel = switch_header_table
					.getSelectionModel();
			selectionModel.setSelectionInterval(0, 0);
		}
	}

	public void setTabPaneEnable() {
		for (int i = 0; i < tabbedPane.getComponentCount(); i++) {
			tabbedPane.setEnabledAt(i, true);
		}
	}

	public void setTabPaneDisable() {
		// 無資料會有一列result_ind = '1'
		int tabindex = tabbedPane.indexOfTab("約定提領");
		if (investWithdrawAppointGroup01.getInvestAppoint01sCount() < 1)
			tabbedPane.setEnabledAt(tabbedPane.indexOfTab("約定提領"), false);
		// tabbedPane.setSelectedIndex(0);
		if (investSwitchAppointGroup01.getInvestAppoint01sCount() < 1)
			tabbedPane.setEnabledAt(tabbedPane.indexOfTab("約定轉換"), false);

		for (int i = 0; i < tabbedPane.getComponentCount(); i++) {
			if (tabbedPane.isEnabledAt(i)) {
				tabbedPane.setSelectedIndex(i);
				break;
			}
		}
	}

	public void setController(InvestAppointController controller) {
		investAppointController = controller;
	}

	protected void initDataBindings() {
		BeanProperty<InvestWithdrawAppointGroup01, List<InvestWithdrawAppoint01>> investWithdrawAppointGroup01BeanProperty = BeanProperty
				.create("investWithdrawAppoint01s");
		JTableBinding<InvestWithdrawAppoint01, InvestWithdrawAppointGroup01, JTable> jTableBinding = SwingBindings
				.createJTableBinding(UpdateStrategy.READ,
						investWithdrawAppointGroup01,
						investWithdrawAppointGroup01BeanProperty,
						withdraw_header_table);
		//
		BeanProperty<InvestWithdrawAppoint01, String> investWithdrawAppoint01BeanProperty = BeanProperty
				.create("r_auto_tr_date");
		jTableBinding.addColumnBinding(investWithdrawAppoint01BeanProperty)
				.setColumnName("\u7D04\u5B9A\u4EA4\u6613\u65E5")
				.setEditable(false);
		//
		BeanProperty<InvestWithdrawAppoint01, String> investWithdrawAppoint01BeanProperty_1 = BeanProperty
				.create("r_process_date");
		jTableBinding.addColumnBinding(investWithdrawAppoint01BeanProperty_1)
				.setColumnName("\u5BE6\u969B\u4F5C\u696D\u65E5")
				.setEditable(false);
		//
		BeanProperty<InvestWithdrawAppoint01, String> investWithdrawAppoint01BeanProperty_2 = BeanProperty
				.create("r_receive_no");
		jTableBinding.addColumnBinding(investWithdrawAppoint01BeanProperty_2)
				.setColumnName("\u53D7\u7406\u865F\u78BC").setEditable(false);
		//
		BeanProperty<InvestWithdrawAppoint01, String> investWithdrawAppoint01BeanProperty_3 = BeanProperty
				.create("r_invs_amt");
		jTableBinding.addColumnBinding(investWithdrawAppoint01BeanProperty_3)
				.setColumnName("\u61C9\u8D16\u56DE\u91D1\u984D")
				.setEditable(false);
		//
		BeanProperty<InvestWithdrawAppoint01, String> investWithdrawAppoint01BeanProperty_4 = BeanProperty
				.create("r_invs_real_amt");
		jTableBinding.addColumnBinding(investWithdrawAppoint01BeanProperty_4)
				.setColumnName("\u5BE6\u969B\u8D16\u56DE\u91D1\u984D")
				.setEditable(false);
		//
		BeanProperty<InvestWithdrawAppoint01, String> investWithdrawAppoint01BeanProperty_5 = BeanProperty
				.create("r_invs_ad_no");
		jTableBinding.addColumnBinding(investWithdrawAppoint01BeanProperty_5)
				.setColumnName("\u4EA4\u6613\u7DE8\u865F").setEditable(false);
		//
		BeanProperty<InvestWithdrawAppoint01, String> investWithdrawAppoint01BeanProperty_6 = BeanProperty
				.create("r_ivchg_sts_code");
		jTableBinding.addColumnBinding(investWithdrawAppoint01BeanProperty_6)
				.setColumnName("\u72C0\u614B").setEditable(false);
		//
		BeanProperty<InvestWithdrawAppoint01, String> investWithdrawAppoint01BeanProperty_7 = BeanProperty
				.create("r_resp_code");
		jTableBinding.addColumnBinding(investWithdrawAppoint01BeanProperty_7)
				.setColumnName("\u4E8B\u7531").setEditable(false);
		//
		jTableBinding.bind();
		//
		BeanProperty<InvestWithdrawAppointGroup02, List<InvestWithdrawAppoint02>> investWithdrawAppointGroup02BeanProperty = BeanProperty
				.create("investWithdrawAppoint02s");
		JTableBinding<InvestWithdrawAppoint02, InvestWithdrawAppointGroup02, JTable> jTableBinding_1 = SwingBindings
				.createJTableBinding(UpdateStrategy.READ,
						investWithdrawAppointGroup02,
						investWithdrawAppointGroup02BeanProperty,
						withdraw_appoint_table);
		//
		BeanProperty<InvestWithdrawAppoint02, String> investWithdrawAppoint02BeanProperty = BeanProperty
				.create("r_receive_no");
		jTableBinding_1.addColumnBinding(investWithdrawAppoint02BeanProperty)
				.setColumnName("\u7D04\u5B9A\u53D7\u7406\u865F\u78BC")
				.setEditable(false);
		//
		BeanProperty<InvestWithdrawAppoint02, String> investWithdrawAppoint02BeanProperty_1 = BeanProperty
				.create("r_bgn_date");
		jTableBinding_1.addColumnBinding(investWithdrawAppoint02BeanProperty_1)
				.setColumnName("\u6307\u5B9A\u65E5\u671F(\u8D77\u65E5)")
				.setEditable(false);
		//
		BeanProperty<InvestWithdrawAppoint02, String> investWithdrawAppoint02BeanProperty_2 = BeanProperty
				.create("r_chah_freq");
		jTableBinding_1.addColumnBinding(investWithdrawAppoint02BeanProperty_2)
				.setColumnName("\u983B\u7387").setEditable(false);
		//
		BeanProperty<InvestWithdrawAppoint02, String> investWithdrawAppoint02BeanProperty_3 = BeanProperty
				.create("r_auto_tr_date");
		jTableBinding_1.addColumnBinding(investWithdrawAppoint02BeanProperty_3)
				.setColumnName("\u4E0B\u6B21\u57F7\u884C\u65E5")
				.setEditable(false);
		//
		jTableBinding_1.setEditable(false);
		jTableBinding_1.bind();
		//
		BeanProperty<InvestWithdrawAppointGroup03, List<InvestWithdrawAppoint03>> investWithdrawAppointGroup03BeanProperty = BeanProperty
				.create("investWithdrawAppoint03s");
		JTableBinding<InvestWithdrawAppoint03, InvestWithdrawAppointGroup03, JTable> jTableBinding_2 = SwingBindings
				.createJTableBinding(UpdateStrategy.READ,
						investWithdrawAppointGroup03,
						investWithdrawAppointGroup03BeanProperty,
						withdraw_detail_table);
		//
		BeanProperty<InvestWithdrawAppoint03, String> investWithdrawAppoint03BeanProperty = BeanProperty
				.create("r_invs_code");
		jTableBinding_2.addColumnBinding(investWithdrawAppoint03BeanProperty)
				.setColumnName("\u7D04\u5B9A\u63D0\u9818\u57FA\u91D1")
				.setEditable(false);
		//
		BeanProperty<InvestWithdrawAppoint03, String> investWithdrawAppoint03BeanProperty_1 = BeanProperty
				.create("r_invs_title");
		jTableBinding_2.addColumnBinding(investWithdrawAppoint03BeanProperty_1)
				.setColumnName(
						"\u7D04\u5B9A\u63D0\u9818\u57FA\u91D1\u540D\u7A31");
		//
		BeanProperty<InvestWithdrawAppoint03, String> investWithdrawAppoint03BeanProperty_2 = BeanProperty
				.create("r_chah_sell_type");
		jTableBinding_2.addColumnBinding(investWithdrawAppoint03BeanProperty_2)
				.setColumnName("\u63D0\u9818\u65B9\u5F0F").setEditable(false);
		//
		BeanProperty<InvestWithdrawAppoint03, String> investWithdrawAppoint03BeanProperty_3 = BeanProperty
				.create("r_invs_ad_amt");
		jTableBinding_2.addColumnBinding(investWithdrawAppoint03BeanProperty_3)
				.setColumnName("\u7D04\u5B9A\u63D0\u9818\u91D1\u984D")
				.setEditable(false);
		//
		jTableBinding_2.setEditable(false);
		jTableBinding_2.bind();
		//
		BeanProperty<InvestSwitchAppointGroup02, List<InvestSwitchAppoint02>> investSwitchAppointGroup02BeanProperty = BeanProperty
				.create("investSwitchAppoint02s");
		JTableBinding<InvestSwitchAppoint02, InvestSwitchAppointGroup02, JTable> jTableBinding_4 = SwingBindings
				.createJTableBinding(UpdateStrategy.READ,
						investSwitchAppointGroup02,
						investSwitchAppointGroup02BeanProperty,
						switch_appoint_table);
		//
		BeanProperty<InvestSwitchAppoint02, String> investSwitchAppoint02BeanProperty = BeanProperty
				.create("r_receive_no");
		jTableBinding_4.addColumnBinding(investSwitchAppoint02BeanProperty)
				.setColumnName("\u7D04\u5B9A\u53D7\u7406\u865F\u78BC")
				.setEditable(false);
		//
		BeanProperty<InvestSwitchAppoint02, String> investSwitchAppoint02BeanProperty_1 = BeanProperty
				.create("r_bgn_date");
		jTableBinding_4.addColumnBinding(investSwitchAppoint02BeanProperty_1)
				.setColumnName("\u6307\u5B9A\u65E5\u671F(\u8D77\u65E5)")
				.setEditable(false);
		//
		BeanProperty<InvestSwitchAppoint02, String> investSwitchAppoint02BeanProperty_2 = BeanProperty
				.create("r_chah_freq");
		jTableBinding_4.addColumnBinding(investSwitchAppoint02BeanProperty_2)
				.setColumnName("\u983B\u7387").setEditable(false);
		//
		BeanProperty<InvestSwitchAppoint02, String> investSwitchAppoint02BeanProperty_3 = BeanProperty
				.create("r_auto_tr_date");
		jTableBinding_4.addColumnBinding(investSwitchAppoint02BeanProperty_3)
				.setColumnName("\u4E0B\u6B21\u57F7\u884C\u65E5")
				.setEditable(false);
		//
		jTableBinding_4.setEditable(false);
		jTableBinding_4.bind();
		//
		BeanProperty<InvestSwitchAppointGroup01, List<InvestSwitchAppoint01>> investSwitchAppointGroup01BeanProperty = BeanProperty
				.create("investSwitchAppoint01s");
		JTableBinding<InvestSwitchAppoint01, InvestSwitchAppointGroup01, JTable> jTableBinding_3 = SwingBindings
				.createJTableBinding(UpdateStrategy.READ,
						investSwitchAppointGroup01,
						investSwitchAppointGroup01BeanProperty,
						switch_header_table);
		//
		BeanProperty<InvestSwitchAppoint01, String> investSwitchAppoint01BeanProperty = BeanProperty
				.create("r_auto_tr_date");
		jTableBinding_3.addColumnBinding(investSwitchAppoint01BeanProperty)
				.setColumnName("\u7D04\u5B9A\u4F5C\u696D\u65E5")
				.setEditable(false);
		//
		BeanProperty<InvestSwitchAppoint01, String> investSwitchAppoint01BeanProperty_1 = BeanProperty
				.create("r_process_date");
		jTableBinding_3.addColumnBinding(investSwitchAppoint01BeanProperty_1)
				.setColumnName("\u5BE6\u969B\u4F5C\u696D\u65E5")
				.setEditable(false);
		//
		BeanProperty<InvestSwitchAppoint01, String> investSwitchAppoint01BeanProperty_2 = BeanProperty
				.create("r_receive_no");
		jTableBinding_3.addColumnBinding(investSwitchAppoint01BeanProperty_2)
				.setColumnName("\u53D7\u7406\u865F\u78BC").setEditable(false);
		//
		BeanProperty<InvestSwitchAppoint01, String> investSwitchAppoint01BeanProperty_3 = BeanProperty
				.create("r_invs_amt");
		jTableBinding_3.addColumnBinding(investSwitchAppoint01BeanProperty_3)
				.setColumnName("\u61C9\u8F49\u63DB\u91D1\u984D")
				.setEditable(false);
		//
		BeanProperty<InvestSwitchAppoint01, String> investSwitchAppoint01BeanProperty_4 = BeanProperty
				.create("r_invs_real_amt");
		jTableBinding_3.addColumnBinding(investSwitchAppoint01BeanProperty_4)
				.setColumnName("\u5BE6\u969B\u8F49\u63DB\u91D1\u984D")
				.setEditable(false);
		//
		BeanProperty<InvestSwitchAppoint01, String> investSwitchAppoint01BeanProperty_5 = BeanProperty
				.create("r_invs_ad_no");
		jTableBinding_3.addColumnBinding(investSwitchAppoint01BeanProperty_5)
				.setColumnName("\u4EA4\u6613\u7DE8\u865F").setEditable(false);
		//
		BeanProperty<InvestSwitchAppoint01, String> investSwitchAppoint01BeanProperty_6 = BeanProperty
				.create("r_ivchg_sts_code");
		jTableBinding_3.addColumnBinding(investSwitchAppoint01BeanProperty_6)
				.setColumnName("\u72C0\u614B").setEditable(false);
		//
		BeanProperty<InvestSwitchAppoint01, String> investSwitchAppoint01BeanProperty_7 = BeanProperty
				.create("r_resp_code");
		jTableBinding_3.addColumnBinding(investSwitchAppoint01BeanProperty_7)
				.setColumnName("\u4E8B\u7531").setEditable(false);
		//
		jTableBinding_3.setEditable(false);
		jTableBinding_3.bind();
		//
		BeanProperty<InvestSwitchAppointSellGroup, List<InvestSwitchSellAppoint03>> investSwitchAppointSellGroupBeanProperty = BeanProperty
				.create("investSwitchSellAppoint03s");
		JTableBinding<InvestSwitchSellAppoint03, InvestSwitchAppointSellGroup, JTable> jTableBinding_5 = SwingBindings
				.createJTableBinding(UpdateStrategy.READ,
						investSwitchAppointSellGroup,
						investSwitchAppointSellGroupBeanProperty,
						switch_sell_detail_table);
		//
		BeanProperty<InvestSwitchSellAppoint03, String> investSwitchSellAppoint03BeanProperty = BeanProperty
				.create("r_invs_code");
		jTableBinding_5.addColumnBinding(investSwitchSellAppoint03BeanProperty)
				.setColumnName("\u7D04\u5B9A\u8F49\u51FA\u57FA\u91D1")
				.setEditable(false);
		//
		BeanProperty<InvestSwitchSellAppoint03, String> investSwitchSellAppoint03BeanProperty_1 = BeanProperty
				.create("r_invs_title");
		jTableBinding_5
				.addColumnBinding(investSwitchSellAppoint03BeanProperty_1)
				.setColumnName(
						"\u7D04\u5B9A\u8F49\u51FA\u57FA\u91D1\u540D\u7A31")
				.setEditable(false);
		//
		BeanProperty<InvestSwitchSellAppoint03, String> investSwitchSellAppoint03BeanProperty_2 = BeanProperty
				.create("r_chah_sell_type");
		jTableBinding_5
				.addColumnBinding(investSwitchSellAppoint03BeanProperty_2)
				.setColumnName("\u8F49\u51FA\u65B9\u5F0F").setEditable(false);
		//
		BeanProperty<InvestSwitchSellAppoint03, String> investSwitchSellAppoint03BeanProperty_3 = BeanProperty
				.create("r_invs_ad_amt");
		jTableBinding_5
				.addColumnBinding(investSwitchSellAppoint03BeanProperty_3)
				.setColumnName("\u7D04\u5B9A\u8F49\u51FA\u91D1\u984D")
				.setEditable(false);
		//
		jTableBinding_5.setEditable(false);
		jTableBinding_5.bind();
		//
		BeanProperty<InvestSwitchAppointBuyGroup, List<InvestSwitchBuyAppoint03>> investSwitchAppointBuyGroupBeanProperty = BeanProperty
				.create("investSwitchBuyAppoint03s");
		JTableBinding<InvestSwitchBuyAppoint03, InvestSwitchAppointBuyGroup, JTable> jTableBinding_6 = SwingBindings
				.createJTableBinding(UpdateStrategy.READ,
						investSwitchAppointBuyGroup,
						investSwitchAppointBuyGroupBeanProperty,
						switch_buy_detail_table);
		//
		BeanProperty<InvestSwitchBuyAppoint03, String> investSwitchBuyAppoint03BeanProperty = BeanProperty
				.create("r_invs_code");
		jTableBinding_6.addColumnBinding(investSwitchBuyAppoint03BeanProperty)
				.setColumnName("\u7D04\u5B9A\u8CB7\u5165\u57FA\u91D1")
				.setEditable(false);
		//
		BeanProperty<InvestSwitchBuyAppoint03, String> investSwitchBuyAppoint03BeanProperty_1 = BeanProperty
				.create("r_invs_title");
		jTableBinding_6
				.addColumnBinding(investSwitchBuyAppoint03BeanProperty_1)
				.setColumnName(
						"\u7D04\u5B9A\u8CB7\u5165\u57FA\u91D1\u540D\u7A31")
				.setEditable(false);
		//
		BeanProperty<InvestSwitchBuyAppoint03, String> investSwitchBuyAppoint03BeanProperty_2 = BeanProperty
				.create("r_invs_ad_perc");
		jTableBinding_6
				.addColumnBinding(investSwitchBuyAppoint03BeanProperty_2)
				.setColumnName("\u8CB7\u5165\u5206\u914D\u6BD4\u4F8B")
				.setEditable(false);
		//
		jTableBinding_6.setEditable(false);
		jTableBinding_6.bind();
	}
}
