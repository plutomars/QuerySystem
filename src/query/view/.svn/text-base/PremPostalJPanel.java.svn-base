package query.view;
/**
 * @author cora
 *
 * @version 1.0<br/>
 * 			101/11/07<br/>
 * 			劃撥/ATM/便利商店繳費查詢(Query)
 * 
 * @since 1.0
 */
import javax.swing.DefaultListSelectionModel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JTable;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import query.controller.PremPostalController;

import query.model.PremPostal.PremPostal01;
import query.model.PremPostal.PremPostal02;
import query.model.PremPostal.PremPostal02Group;
import query.model.PremPostal.PremPostal03;
import query.model.PremPostal.PremPostal03Group;

import org.jdesktop.beansbinding.BeanProperty;
import java.util.List;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;


public class PremPostalJPanel extends JPanel  implements ActionListener, ListSelectionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PremPostalController controller;
	private JTable table;
	private VerticalPane detailScrollPane1, detailScrollPane2,detailScrollPane3;
	private JComboBox combo;
	private PremPostal02Group premPostal02Group = new PremPostal02Group();
	private PremPostal03Group premPostal03Group = new PremPostal03Group();
	private PremPostal01 premPostal01 = new PremPostal01();
	public String pcrc_kind = "X";
	private JTable table_1;
	
	public PremPostalJPanel() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(15, 135));
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setPreferredSize(new Dimension(15, 33));
		panel.add(panel_2, BorderLayout.NORTH);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{60, 99, 57, 0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JLabel label = new JLabel("\u4ED8\u8CBB\u7BA1\u9053\uFF1A");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 0, 5);
		gbc_label.anchor = GridBagConstraints.EAST;
		gbc_label.gridx = 0;
		gbc_label.gridy = 0;
		panel_2.add(label, gbc_label);
		
		combo = new JComboBox();
		combo.setModel(new DefaultComboBoxModel(new String[] {"\u5168\u90E8", "ATM", "\u4FBF\u5229\u5546\u5E97", "\u5283\u64A5"}));
		GridBagConstraints gbc_combo = new GridBagConstraints();
		combo.addActionListener(this);
		gbc_combo.insets = new Insets(0, 0, 0, 5);
		gbc_combo.fill = GridBagConstraints.HORIZONTAL;
		gbc_combo.gridx = 1;
		gbc_combo.gridy = 0;
		panel_2.add(combo, gbc_combo);
		
		JButton searchButton = new JButton("\u67E5\u8A62");
		GridBagConstraints gbc_searchButton = new GridBagConstraints();
		gbc_searchButton.insets = new Insets(0, 0, 0, 5);
		gbc_searchButton.gridx = 2;
		gbc_searchButton.gridy = 0;
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.executeInnerMission("0");
			}
		});
		panel_2.add(searchButton, gbc_searchButton);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new GridLayout(0, 3, 0, 0));
		
		//左區panel
		String[] headers1 = {"保單號碼","保單狀態","收費方式","溢／欠繳"};
		detailScrollPane1 = new VerticalPane(headers1,"",100,25);
		detailScrollPane1.setPreferredSize(new Dimension(157, 100));
		panel_3.add(detailScrollPane1);
		
		//中區panel
		String[] headers2 = {"要 保 人","被保險人","繳    別"," "};
		detailScrollPane2 = new VerticalPane(headers2,"",100,25);
		detailScrollPane2.setPreferredSize(new Dimension(157, 100));
		panel_3.add(detailScrollPane2);
		
		//右區panel
		String[] headers3 = {"保單生效","保費到期","原始保費","紅利金額"};
		detailScrollPane3 = new VerticalPane(headers3,"",100,25);
		detailScrollPane3.setPreferredSize(new Dimension(157, 100));
		panel_3.add(detailScrollPane3);

		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		table = new JTable();
		table.setToolTipText("點擊以顯示下方明細");
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane); //, BorderLayout.CENTER);
		scrollPane.setViewportView(table);
		
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ListSelectionModel model = table.getSelectionModel();
		model.addListSelectionListener(this);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "ATM\u5176\u4ED6\u8CC7\u8A0A", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(panel_4, BorderLayout.SOUTH);
		panel_4.setPreferredSize(new Dimension(15, 85));
		panel_4.setLayout(new GridLayout(0, 1, 0, 0));
		
		table_1 = new JTable();
//		panel_4.add(table_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_4.add(scrollPane_1);
		scrollPane_1.setViewportView(table_1);
		initDataBindings();

	}

	public void setController(PremPostalController controller) {
		this.controller = controller;
	}
	
	public void addPremPostal02(PremPostal02 postal02) {

		premPostal02Group.addPremPostal02(postal02);

	}
	
	public void addPremPostal03(PremPostal03 postal03) {

		premPostal03Group.addPremPostal03(postal03);

	}
	
	public void setValues(HashMap<String, String> hsmp){
		premPostal01.setValues(hsmp);
		detailScrollPane1.setValue(premPostal01.getValues(1));
		detailScrollPane2.setValue(premPostal01.getValues(2));
		detailScrollPane3.setValue(premPostal01.getValues(3));
	}
	// 實作選擇ComboBox項目處理
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == combo) {
			Integer comboid = combo.getSelectedIndex();
			switch (comboid) {
			case 0:
				pcrc_kind = "X";
				break;
			case 1:
				pcrc_kind = "A";
				break;
			case 2:
				pcrc_kind = "B";
				break;
			case 3:
				pcrc_kind = "C";
				break;	
			}
		}
	}
	// 清空資料
	public void clearAll() {
		if (premPostal02Group != null) 
		premPostal02Group.removeAll();
		if (premPostal03Group != null) 
		premPostal03Group.removeAll();
		if (detailScrollPane1 != null ){
		detailScrollPane1.clearValues();
		detailScrollPane2.clearValues();
		detailScrollPane3.clearValues();
		}
	}
	
	public void nullAll() {
		table = null;
		table_1 = null;
		detailScrollPane1 = null;
		detailScrollPane2 = null;
		detailScrollPane3 = null;
		premPostal01	  = null;
		combo      = null;
		controller = null;
	}
	
	public void clearPagesSub() {
		premPostal02Group.removeAll();
		premPostal03Group.removeAll();
	}
	
	public void clearPostal03Group() {
		premPostal03Group.removeAll();
	}
	
	@Override
	public void valueChanged(ListSelectionEvent e) { //600000000711
		// TODO Auto-generated method stub
//		if (e.getValueIsAdjusting()) {
		if (!((DefaultListSelectionModel) e.getSource()).getValueIsAdjusting()) {
			int rowSelected = table.getSelectedRow();
			if (rowSelected != -1 )
				if (premPostal02Group.getPremPostal02s().get(rowSelected).getsource_desc().equals("ATM")) 
					controller.executeInnerMission(premPostal02Group.getPremPostal02s().get(rowSelected).getpcrc_key());
				else
					clearPostal03Group();
		}
	}
	protected void initDataBindings() {
		BeanProperty<PremPostal02Group, List<PremPostal02>> premPostal02GroupBeanProperty = BeanProperty.create("premPostal02s");
		JTableBinding<PremPostal02, PremPostal02Group, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, premPostal02Group, premPostal02GroupBeanProperty, table);
		//
		BeanProperty<PremPostal02, String> premPostal02BeanProperty = BeanProperty.create("seq");
		jTableBinding.addColumnBinding(premPostal02BeanProperty).setColumnName("\u5E8F").setEditable(false);
		//
		BeanProperty<PremPostal02, String> premPostal02BeanProperty_1 = BeanProperty.create("source_desc");
		jTableBinding.addColumnBinding(premPostal02BeanProperty_1).setColumnName("\u4F86\u6E90").setEditable(false);
		//
		BeanProperty<PremPostal02, String> premPostal02BeanProperty_2 = BeanProperty.create("transfer_date");
		jTableBinding.addColumnBinding(premPostal02BeanProperty_2).setColumnName("\u7E73\u6B3E\u65E5\u671F").setEditable(false);
		//
		BeanProperty<PremPostal02, String> premPostal02BeanProperty_3 = BeanProperty.create("transfer_amt");
		jTableBinding.addColumnBinding(premPostal02BeanProperty_3).setColumnName("\u7E73\u6B3E\u91D1\u984D").setEditable(false);
		//
		BeanProperty<PremPostal02, String> premPostal02BeanProperty_4 = BeanProperty.create("bill_date_from");
		jTableBinding.addColumnBinding(premPostal02BeanProperty_4).setColumnName("\u61C9\u7E73\u8CBB\u65E5").setEditable(false);
		//
		BeanProperty<PremPostal02, String> premPostal02BeanProperty_5 = BeanProperty.create("mode_prem");
		jTableBinding.addColumnBinding(premPostal02BeanProperty_5).setColumnName("\u5165\u5E33\u4FDD\u8CBB").setEditable(false);
		//
		BeanProperty<PremPostal02, String> premPostal02BeanProperty_6 = BeanProperty.create("store_name");
		jTableBinding.addColumnBinding(premPostal02BeanProperty_6).setColumnName("\u5C40\u865F/\u9280\u884C/\u5546\u5E97").setEditable(false);
		//
		BeanProperty<PremPostal02, String> premPostal02BeanProperty_7 = BeanProperty.create("store_other");
		jTableBinding.addColumnBinding(premPostal02BeanProperty_7).setColumnName("\u5E8F\u865F/\u9580\u5E02").setEditable(false);
		//
		BeanProperty<PremPostal02, String> premPostal02BeanProperty_8 = BeanProperty.create("tran_date");
		jTableBinding.addColumnBinding(premPostal02BeanProperty_8).setColumnName("\u4EA4\u6613\u65E5\u671F").setEditable(false);
		//
		BeanProperty<PremPostal02, String> premPostal02BeanProperty_9 = BeanProperty.create("tran_sts");
		jTableBinding.addColumnBinding(premPostal02BeanProperty_9).setColumnName("\u904E\u5E33\u78BC").setEditable(false);
		//
		jTableBinding.setEditable(false);
		jTableBinding.bind();
		//
		BeanProperty<PremPostal03Group, List<PremPostal03>> premPostal03GroupBeanProperty = BeanProperty.create("premPostal03s");
		JTableBinding<PremPostal03, PremPostal03Group, JTable> jTableBinding_1 = SwingBindings.createJTableBinding(UpdateStrategy.READ, premPostal03Group, premPostal03GroupBeanProperty, table_1);
		//
		BeanProperty<PremPostal03, String> premPostal03BeanProperty = BeanProperty.create("transfer_bank");
		jTableBinding_1.addColumnBinding(premPostal03BeanProperty).setColumnName("\u8F49\u51FA\u9280\u884C").setEditable(false);
		//
		BeanProperty<PremPostal03, String> premPostal03BeanProperty_1 = BeanProperty.create("transfer_account");
		jTableBinding_1.addColumnBinding(premPostal03BeanProperty_1).setColumnName("\u8F49\u51FA\u5E33\u865F").setEditable(false);
		//
		BeanProperty<PremPostal03, String> premPostal03BeanProperty_2 = BeanProperty.create("transfer_time");
		jTableBinding_1.addColumnBinding(premPostal03BeanProperty_2).setColumnName("\u4EA4\u6613\u6642\u9593").setEditable(false);
		//
		BeanProperty<PremPostal03, String> premPostal03BeanProperty_3 = BeanProperty.create("atm_code");
		jTableBinding_1.addColumnBinding(premPostal03BeanProperty_3).setColumnName("ATM\u4EE3\u865F").setEditable(false);
		//
		BeanProperty<PremPostal03, String> premPostal03BeanProperty_4 = BeanProperty.create("atm_seq");
		jTableBinding_1.addColumnBinding(premPostal03BeanProperty_4).setColumnName("\u91D1\u8CC7\u5E8F\u865F").setEditable(false);
		//
		BeanProperty<PremPostal03, String> premPostal03BeanProperty_5 = BeanProperty.create("atm_fee");
		jTableBinding_1.addColumnBinding(premPostal03BeanProperty_5).setColumnName("\u8CBB\u7528").setEditable(false);
		//
		jTableBinding_1.bind();
	}
}
