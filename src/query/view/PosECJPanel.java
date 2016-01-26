package query.view;

import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.HashMap;

import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import query.controller.MultiLineCellRenderer;
import query.controller.PoDetailController;
import query.controller.PosECController;
import query.model.SelectionTreeModel;
import query.model.InvestGoal.InvestGoalInt;
import query.model.PoDetail.PoDetailECacct;
import query.model.PoDetail.PoDetailECacctGroup;
import query.model.PoDetail.PoDetailECinsured;
import query.model.PoDetail.PoDetailECinsuredGroup;
import query.model.PoDetail.PoDetailECpasswd;
import query.model.PoDetail.PoDetailECpasswdGroup;
import query.model.PoDetail.PoDetailECprint;
import query.model.PoDetail.PoDetailECprintGroup;
import query.model.PosEC.PosECeclp;
import query.model.PosEC.PosECeclpGroup;
import query.model.PosEC.PosECectr;
import query.model.PosEC.PosECectrGroup;

import org.jdesktop.beansbinding.BeanProperty;
import java.util.List;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.ELProperty;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListSelectionModel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

public class PosECJPanel extends JPanel { //implements ListSelectionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * EC自動化交易查詢
	 * @author cora
	 * 101/07
	 */
	private JTable Accttable;
	private JTable Passwdtable;
	private JTable Insuredtable;
	private JTable PWDprinttable;
	private JTable ectrtable;
	private JTable eclptable;

	
	private JTabbedPane tabbedPane;
	private JTabbedPane tabbedPane_1;
	private PosECController controller;
	
	private JScrollPane scrollPane_1;
	private JScrollPane scrollPane_2;
	private JScrollPane scrollPane_3;
	private JScrollPane scrollPane_4;
	private JScrollPane scrollPane_5;
	private JScrollPane scrollPane_6;
	private JScrollPane scrollPane_7;

	private PoDetailECacctGroup ECacctGroup = new PoDetailECacctGroup();
	private PoDetailECpasswdGroup ECpasswdGroup = new PoDetailECpasswdGroup();
	private PoDetailECinsuredGroup ECinsuredGroup = new PoDetailECinsuredGroup();
	private PoDetailECprintGroup ECprintGroup = new PoDetailECprintGroup();
	private PosECectrGroup ECectrGroup = new PosECectrGroup();
	private PosECeclpGroup ECeclpGroup = new PosECeclpGroup();
	
	private JTextField txtClientID;
	private JTextField txtDateBeg;
	private JLabel lblNewLabel_1;
	private JTextField txtDateEnd;
	private JLabel lblNewLabel_2;
	private JTextField txtTxnCode;
	private JLabel label;
	private JTextField txtPolicyNo;
	
	private JPanel panel;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;

	private JButton button;


	
	public PosECJPanel() {
		setLayout(new GridLayout(1, 0, 0, 0));
		this.setSize(700, 600);
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane);
		
	    tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	    tabbedPane.setPreferredSize(new Dimension(5, 550));
		scrollPane.setViewportView(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setPreferredSize(new Dimension(10, 650));
		tabbedPane.addTab("\u5E33\u6236\u660E\u7D30", null, panel_1, null);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0};
		gbl_panel_1.rowHeights = new int[]{117, 79, 369, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		
//		tabbedPane.addChangeListener(new ChangeListener() {
//			public void stateChanged(ChangeEvent arg0) {
//				int tabSel = tabbedPane.getSelectedIndex();
//				if (tabSel >0 )
//					System.out.println("tab...");
////				   controller.executeMissionTabValues();
//			}
//		});
		panel_1.setLayout(gbl_panel_1);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setPreferredSize(new Dimension(2, 250));
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 0;
		panel_1.add(scrollPane_1, gbc_scrollPane_1);
		
		Accttable = new JTable();
		Accttable.setToolTipText("點擊以顯示下方明細");
		Accttable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		Accttable.getSelectionModel().addListSelectionListener(
				new ListSelectionListener() {

					@Override
					public void valueChanged(ListSelectionEvent arg0) {
						// TODO Auto-generated method stub
						if (!((DefaultListSelectionModel) arg0.getSource())
								.getValueIsAdjusting()) {
							int rowSelected = Accttable.getSelectedRow();
							if (rowSelected > -1) {
								ECinsuredGroup.removeAll();
								ECpasswdGroup.removeAll();
								controller.executeMission(ECacctGroup.getPoDetailECaccts().get(rowSelected).getacct_source()
										     	 		, ECacctGroup.getPoDetailECaccts().get(rowSelected).getremit_bank()
										     	 		, ECacctGroup.getPoDetailECaccts().get(rowSelected).getremit_account()
										     	 		, ECacctGroup.getPoDetailECaccts().get(rowSelected).getaccu_lcnt());
							}
						}
						
			}
		});
		
		scrollPane_1.setViewportView(Accttable);
//		ListSelectionModel model = Accttable.getSelectionModel();
//		model.addListSelectionListener(this);
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setPreferredSize(new Dimension(2, 250));
		GridBagConstraints gbc_scrollPane_2 = new GridBagConstraints();
		gbc_scrollPane_2.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_2.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_2.gridx = 0;
		gbc_scrollPane_2.gridy = 1;
		panel_1.add(scrollPane_2, gbc_scrollPane_2);
		
		Passwdtable = new JTable();
		Passwdtable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_2.setViewportView(Passwdtable);
		
		tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_tabbedPane_1 = new GridBagConstraints();
		gbc_tabbedPane_1.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane_1.gridx = 0;
		gbc_tabbedPane_1.gridy = 2;
		tabbedPane_1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				int tabSelect = tabbedPane_1.getSelectedIndex();
				if (tabSelect >0 )
				   controller.executeMissionTabValues();
			}
		});
		panel_1.add(tabbedPane_1, gbc_tabbedPane_1);
		
		scrollPane_3 = new JScrollPane();
		tabbedPane_1.addTab("建檔明細", null, scrollPane_3, null);
		
		Insuredtable = new JTable();
		Insuredtable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_3.setViewportView(Insuredtable);
		
		scrollPane_4 = new JScrollPane();
		scrollPane_4.setPreferredSize(new Dimension(2, 400));
		tabbedPane_1.addTab("密碼列印記錄", null, scrollPane_4, null);
		
		PWDprinttable = new JTable();
		PWDprinttable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_4.setViewportView(PWDprinttable);
//		GridBagConstraints gbc_tabbedPane_1 = new GridBagConstraints();
		gbc_tabbedPane_1.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane_1.gridx = 0;
		gbc_tabbedPane_1.gridy = 3;
		
		JPanel panel_0 = new JPanel(); //EC交易紀錄
		panel_0.setPreferredSize(new Dimension(10, 550));
		tabbedPane.addTab("EC\u4EA4\u6613\u7D00\u9304", null, panel_0, null);
		panel_0.setLayout(new BorderLayout(0, 0));
		
		panel_2 = new JPanel();
		panel_0.add(panel_2, BorderLayout.NORTH);
		
		JLabel lblid = new JLabel("\u5BA2\u6236\u8B49\u865F");
		
		txtClientID = new JTextField();
		txtClientID.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u4EA4\u6613\u671F\u9593");
		
		txtDateBeg = new JTextField();
		txtDateBeg.setColumns(10);
		
		lblNewLabel_1 = new JLabel("\uFF5E");
		
		txtDateEnd = new JTextField();
		txtDateEnd.setColumns(10);
		
		lblNewLabel_2 = new JLabel("\u4EA4\u6613\u985E\u5225");
		
		txtTxnCode = new JTextField();
		txtTxnCode.setColumns(10);
		
		label = new JLabel("\u4FDD\u55AE\u865F\u78BC");
		
		txtPolicyNo = new JTextField();
		txtPolicyNo.setColumns(10);
		
		button = new JButton("\u67E5\u8A62");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { 
//				System.out.println("++--");
				ECectrGroup.removeAll();
				controller.executeMission(txtClientID.getText(),txtDateBeg.getText(),txtDateEnd.getText(),txtTxnCode.getText(),txtPolicyNo.getText());//保單號碼/申請人ID/受理號碼
			}
		});
		
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(lblid)
							.addGap(6)
							.addComponent(txtClientID, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblNewLabel)
							.addGap(6)
							.addComponent(txtDateBeg, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_1)
							.addGap(6)
							.addComponent(txtDateEnd, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(label)
							.addGap(6)
							.addComponent(txtPolicyNo, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(lblNewLabel_2)
							.addGap(6)
							.addComponent(txtTxnCode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(button)))
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_2.createSequentialGroup()
									.addGap(3)
									.addComponent(lblid))
								.addGroup(gl_panel_2.createSequentialGroup()
									.addGap(3)
									.addComponent(lblNewLabel))
								.addGroup(gl_panel_2.createSequentialGroup()
									.addGap(3)
									.addComponent(lblNewLabel_1))
								.addGroup(gl_panel_2.createSequentialGroup()
									.addGap(3)
									.addComponent(label))
								.addComponent(txtClientID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtPolicyNo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addComponent(button)
								.addGroup(gl_panel_2.createSequentialGroup()
									.addGap(3)
									.addComponent(lblNewLabel_2))
								.addComponent(txtTxnCode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(txtDateBeg, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtDateEnd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(12))
		);
		panel_2.setLayout(gl_panel_2);
		
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(10, 250));
		panel_0.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		scrollPane_5 = new JScrollPane();
		scrollPane_5.setBorder(new TitledBorder(null, "\u4EA4\u6613\u6B77\u53F2", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(scrollPane_5);
		
		ectrtable = new JTable();
		ectrtable.setToolTipText("點擊以顯示下方明細");
		ectrtable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//		ectrtable.setRowHeight(ectrtable.getRowHeight() * 2);
		ectrtable.setDefaultRenderer(String.class, new MultiLineCellRenderer());

		ectrtable.getSelectionModel().addListSelectionListener(
				new ListSelectionListener() {

					@Override
					public void valueChanged(ListSelectionEvent arg0) {
						// TODO Auto-generated method stub
						if (!((DefaultListSelectionModel) arg0.getSource())
								.getValueIsAdjusting()) {
							int row = ectrtable.getSelectedRow();
							if (row > -1) {
								ECeclpGroup.removeAll();
								controller.executeMission(ECectrGroup.getPosECectrs().get(row).getR_txn_seq(), 
														  ECectrGroup.getPosECectrs().get(row).getR_txn_code());
							}
						}
						
			}
		});
					
		scrollPane_5.setViewportView(ectrtable);
		panel.add(scrollPane_5);
		
		panel_4 = new JPanel();
		panel_4.setPreferredSize(new Dimension(10, 150));
		panel_0.add(panel_4, BorderLayout.SOUTH);
		panel_4.setLayout(new GridLayout(0, 1, 0, 0));
		
		scrollPane_6 = new JScrollPane();
		scrollPane_6.setBorder(new TitledBorder(null, "\u4EA4\u6613\u660E\u7D30", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.add(scrollPane_6);
		
		eclptable = new JTable();
		eclptable.setRowHeight(ectrtable.getRowHeight() * 2);
		eclptable.setDefaultRenderer(String.class, new MultiLineCellRenderer());
		eclptable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		scrollPane_6.setViewportView(eclptable);
		
//		JButton btnNewButton = new JButton("\u67E5\u8A62");
		
		initDataBindings();
		
		Accttable.getColumnModel().getColumn(0).setMaxWidth(50);
		Accttable.getColumnModel().getColumn(1).setMaxWidth(50);
		Accttable.getColumnModel().getColumn(2).setMaxWidth(50);
		Accttable.getColumnModel().getColumn(3).setMaxWidth(80);
		Accttable.getColumnModel().getColumn(4).setMaxWidth(120);
		Accttable.getColumnModel().getColumn(5).setMaxWidth(150);
		Accttable.getColumnModel().getColumn(5).setPreferredWidth(120);
		
		PWDprinttable.getColumnModel().getColumn(0).setMaxWidth(80);
		PWDprinttable.getColumnModel().getColumn(1).setMaxWidth(80);
		PWDprinttable.getColumnModel().getColumn(2).setMaxWidth(80);
		PWDprinttable.getColumnModel().getColumn(3).setMaxWidth(80);
		PWDprinttable.getColumnModel().getColumn(4).setMaxWidth(90);
		
		ectrtable.getColumnModel().getColumn(0).setMaxWidth(120);
		ectrtable.getColumnModel().getColumn(0).setPreferredWidth(90);
		ectrtable.getColumnModel().getColumn(2).setMaxWidth(110);
		ectrtable.getColumnModel().getColumn(2).setPreferredWidth(85);
		ectrtable.getColumnModel().getColumn(3).setMaxWidth(110);
		ectrtable.getColumnModel().getColumn(3).setPreferredWidth(85);
		ectrtable.getColumnModel().getColumn(4).setMaxWidth(55);
		ectrtable.getColumnModel().getColumn(4).setPreferredWidth(45);
		ectrtable.getColumnModel().getColumn(5).setMaxWidth(120);
		ectrtable.getColumnModel().getColumn(5).setPreferredWidth(90);
		
		eclptable.getColumnModel().getColumn(0).setMaxWidth(120);
		eclptable.getColumnModel().getColumn(0).setPreferredWidth(90);
		eclptable.getColumnModel().getColumn(1).setMaxWidth(130);
		eclptable.getColumnModel().getColumn(1).setPreferredWidth(110);
	}

//	@Override
//	public void valueChanged(ListSelectionEvent arg0) {
//		// TODO Auto-generated method stub
//		int rowSelected = Accttable.getSelectedRow();
//		if (rowSelected > -1) {
////			String client_id = null, invs_name = null, acct_source = null ,bank_id = null,account_no = null;
////			int lcnt = 0;
//			ECinsuredGroup.removeAll();
//			ECpasswdGroup.removeAll();
//			controller.executeMission(ECacctGroup.getPoDetailECaccts().get(rowSelected).getacct_source()
//					     	 		, ECacctGroup.getPoDetailECaccts().get(rowSelected).getremit_bank()
//					     	 		, ECacctGroup.getPoDetailECaccts().get(rowSelected).getremit_account()
//					     	 		, ECacctGroup.getPoDetailECaccts().get(rowSelected).getaccu_lcnt());
//		}
//	}
	
	public void setValues(HashMap<String, String> hsmp,int blockType) //EC專用
	{
		switch(blockType){
		case 1:			// 密碼資料
			PoDetailECpasswd poDetailECpasswd = new PoDetailECpasswd(hsmp);
			ECpasswdGroup.addPoDetailECpasswd(poDetailECpasswd);
			break;
		case 2:			// 登記保單or insured資料
			PoDetailECinsured poDetailECinsured = new PoDetailECinsured(hsmp);
			ECinsuredGroup.addPoDetailECinsured(poDetailECinsured);
			break;
		case 3:			// 密碼列印記錄
			PoDetailECprint poDetailECprint = new PoDetailECprint(hsmp);
			ECprintGroup.addPoDetailECprint(poDetailECprint);
			break;
		}
	}	
	
	public void addECacctGroup(HashMap<String, String> hsmp) {
		PoDetailECacct ECacct = new PoDetailECacct(hsmp);
		ECacctGroup.addPoDetailECacct(ECacct);
	}
	
	public void addECectrGroup(HashMap<String, String> hsmp) {
		PosECectr ECectr = new PosECectr(hsmp);
		ECectrGroup.addPosECectr(ECectr);
	}

	public void addECeclpGroup(HashMap<String, String> hsmp) {
		PosECeclp ECeclp = new PosECeclp(hsmp);
		ECeclpGroup.addPosECeclp(ECeclp);
	}
	
	public void setDefaultRow()
	{
		if (Accttable.getRowCount() > 0)
		{	
		ListSelectionModel selectionModel =    Accttable.getSelectionModel(); 
		selectionModel.setSelectionInterval(0, 0);
		}
	}
	
	public void chkAuthority(){
		//EC交易歷史需鎖權限
		tabbedPane.setEnabledAt(1, SelectionTreeModel.getTabAuthority("psg07m","A"));
	}
	
	public void setController(PosECController controller){
		this.controller = controller;
	}
	
	public void setDefaultID(String client){
		this.txtClientID.setText(client);
	}
	
	public void clearAll() {
		ECacctGroup.removeAll();
		ECinsuredGroup.removeAll();
		ECpasswdGroup.removeAll();
		ECprintGroup.removeAll();
		ECectrGroup.removeAll();
		ECeclpGroup.removeAll();
	}
	/**
	 * 將全域變數全部指向NULL,利於JAVA記憶體回收系統回收記憶體
	 */
	public void nullAll() {

		Accttable = null;
		Passwdtable = null;
		Insuredtable = null;
		PWDprinttable = null;
		ectrtable = null;
		eclptable = null;
//		ECacctGroup = null;
//		ECinsuredGroup = null;
//		ECpasswdGroup = null;
//		ECprintGroup = null;
	}
	protected void initDataBindings() {
		BeanProperty<PoDetailECacctGroup, List<PoDetailECacct>> poDetailECacctGroupBeanProperty = BeanProperty.create("poDetailECaccts");
		JTableBinding<PoDetailECacct, PoDetailECacctGroup, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, ECacctGroup, poDetailECacctGroupBeanProperty, Accttable);
		//
		BeanProperty<PoDetailECacct, String> poDetailECacctBeanProperty = BeanProperty.create("active_sw");
		jTableBinding.addColumnBinding(poDetailECacctBeanProperty).setColumnName("\u72C0\u614B");
		//
		BeanProperty<PoDetailECacct, String> poDetailECacctBeanProperty_1 = BeanProperty.create("currency_ind");
		jTableBinding.addColumnBinding(poDetailECacctBeanProperty_1).setColumnName("\u5E63\u5225");
		//
		BeanProperty<PoDetailECacct, String> poDetailECacctBeanProperty_2 = BeanProperty.create("acct_source");
		jTableBinding.addColumnBinding(poDetailECacctBeanProperty_2).setColumnName("\u985E\u5225");
		//
		BeanProperty<PoDetailECacct, String> poDetailECacctBeanProperty_3 = BeanProperty.create("payee");
		jTableBinding.addColumnBinding(poDetailECacctBeanProperty_3).setColumnName("\u6236\u540D");
		//
		BeanProperty<PoDetailECacct, String> poDetailECacctBeanProperty_4 = BeanProperty.create("payee_e");
		jTableBinding.addColumnBinding(poDetailECacctBeanProperty_4).setColumnName("\u6236\u540D(\u82F1)");
		//
		ELProperty<PoDetailECacct, Object> poDetailECacctEvalutionProperty = ELProperty.create("${remit_bank} ${remit_branch}");
		jTableBinding.addColumnBinding(poDetailECacctEvalutionProperty).setColumnName("\u532F\u6B3E\u9280\u884C").setEditable(false);
		//
		BeanProperty<PoDetailECacct, String> poDetailECacctBeanProperty_5 = BeanProperty.create("remit_account");
		jTableBinding.addColumnBinding(poDetailECacctBeanProperty_5).setColumnName("\u5E33\u865F");
		//
		BeanProperty<PoDetailECacct, String> poDetailECacctBeanProperty_6 = BeanProperty.create("bank_name");
		jTableBinding.addColumnBinding(poDetailECacctBeanProperty_6).setColumnName("\u9280\u884C\u540D\u7A31");
		//
		jTableBinding.bind();
		//
		BeanProperty<PoDetailECpasswdGroup, List<PoDetailECpasswd>> poDetailECpasswdGroupBeanProperty = BeanProperty.create("poDetailECpasswds");
		JTableBinding<PoDetailECpasswd, PoDetailECpasswdGroup, JTable> jTableBinding_1 = SwingBindings.createJTableBinding(UpdateStrategy.READ, ECpasswdGroup, poDetailECpasswdGroupBeanProperty, Passwdtable);
		//
		ELProperty<PoDetailECpasswd, Object> poDetailECpasswdEvalutionProperty = ELProperty.create("${pwd_sw} ${pwd_sw_desc}");
		jTableBinding_1.addColumnBinding(poDetailECpasswdEvalutionProperty).setColumnName("\u5BC6\u78BC\u7B49\u7D1A").setEditable(false);
		//
		BeanProperty<PoDetailECpasswd, String> poDetailECpasswdBeanProperty = BeanProperty.create("accu_lcnt");
		jTableBinding_1.addColumnBinding(poDetailECpasswdBeanProperty).setColumnName("\u501F\u6B3E\u63D0\u9818\u6B21\u6578");
		//
		BeanProperty<PoDetailECpasswd, String> poDetailECpasswdBeanProperty_1 = BeanProperty.create("accu_ecnt");
		jTableBinding_1.addColumnBinding(poDetailECpasswdBeanProperty_1).setColumnName("\u7D2F\u7A4D\u932F\u8AA4\u6B21\u6578");
		//
		jTableBinding_1.bind();
		//
		BeanProperty<PoDetailECinsuredGroup, List<PoDetailECinsured>> poDetailECinsuredGroupBeanProperty = BeanProperty.create("poDetailECinsureds");
		JTableBinding<PoDetailECinsured, PoDetailECinsuredGroup, JTable> jTableBinding_2 = SwingBindings.createJTableBinding(UpdateStrategy.READ, ECinsuredGroup, poDetailECinsuredGroupBeanProperty, Insuredtable);
		//
		BeanProperty<PoDetailECinsured, String> poDetailECinsuredBeanProperty = BeanProperty.create("active_sw");
		jTableBinding_2.addColumnBinding(poDetailECinsuredBeanProperty).setColumnName("\u8A0A\u606F");
		//
		ELProperty<PoDetailECinsured, Object> poDetailECinsuredEvalutionProperty = ELProperty.create("${insured_id} / ${insured_name}");
		jTableBinding_2.addColumnBinding(poDetailECinsuredEvalutionProperty).setColumnName("\u88AB\u4FDD\u96AA\u4EBA");
		//
		BeanProperty<PoDetailECinsured, String> poDetailECinsuredBeanProperty_1 = BeanProperty.create("policy_no");
		jTableBinding_2.addColumnBinding(poDetailECinsuredBeanProperty_1).setColumnName("\u4FDD\u55AE\u865F\u78BC");
		//
		BeanProperty<PoDetailECinsured, String> poDetailECinsuredBeanProperty_2 = BeanProperty.create("po_sts_code");
		jTableBinding_2.addColumnBinding(poDetailECinsuredBeanProperty_2).setColumnName("\u4FDD\u55AE\u72C0\u614B");
		//
		ELProperty<PoDetailECinsured, Object> poDetailECinsuredEvalutionProperty_1 = ELProperty.create("${bank_id}-${account_no}");
		jTableBinding_2.addColumnBinding(poDetailECinsuredEvalutionProperty_1).setColumnName("\u9280\u884C\u4EE3\u78BC\u53CA\u5E33\u865F");
		//
		jTableBinding_2.bind();
		//
		BeanProperty<PoDetailECprintGroup, List<PoDetailECprint>> poDetailECprintGroupBeanProperty = BeanProperty.create("poDetailECprints");
		JTableBinding<PoDetailECprint, PoDetailECprintGroup, JTable> jTableBinding_3 = SwingBindings.createJTableBinding(UpdateStrategy.READ, ECprintGroup, poDetailECprintGroupBeanProperty, PWDprinttable);
		//
		BeanProperty<PoDetailECprint, String> poDetailECprintBeanProperty = BeanProperty.create("print_style_desc");
		jTableBinding_3.addColumnBinding(poDetailECprintBeanProperty).setColumnName("\u5217\u5370\u65B9\u5F0F");
		//
		BeanProperty<PoDetailECprint, String> poDetailECprintBeanProperty_1 = BeanProperty.create("prt_op_desc");
		jTableBinding_3.addColumnBinding(poDetailECprintBeanProperty_1).setColumnName("\u5217\u5370\u9805\u76EE");
		//
		BeanProperty<PoDetailECprint, String> poDetailECprintBeanProperty_2 = BeanProperty.create("print_date");
		jTableBinding_3.addColumnBinding(poDetailECprintBeanProperty_2).setColumnName("\u5217\u5370\u65E5\u671F");
		//
		BeanProperty<PoDetailECprint, String> poDetailECprintBeanProperty_3 = BeanProperty.create("overdue_date");
		jTableBinding_3.addColumnBinding(poDetailECprintBeanProperty_3).setColumnName("\u5931\u6548\u65E5\u671F");
		//
		BeanProperty<PoDetailECprint, String> poDetailECprintBeanProperty_4 = BeanProperty.create("user_name");
		jTableBinding_3.addColumnBinding(poDetailECprintBeanProperty_4).setColumnName("\u5217\u5370\u8005");
		//
		BeanProperty<PoDetailECprint, String> poDetailECprintBeanProperty_5 = BeanProperty.create("address");
		jTableBinding_3.addColumnBinding(poDetailECprintBeanProperty_5).setColumnName("\u90F5\u5BC4\u5730\u5740");
		//
		jTableBinding_3.bind();
		//
		BeanProperty<PosECectrGroup, List<PosECectr>> posECectrGroupBeanProperty = BeanProperty.create("posECectrs");
		JTableBinding<PosECectr, PosECectrGroup, JTable> jTableBinding_4 = SwingBindings.createJTableBinding(UpdateStrategy.READ, ECectrGroup, posECectrGroupBeanProperty, ectrtable);
		//
		BeanProperty<PosECectr, String> posECectrBeanProperty = BeanProperty.create("r_client_id");
		jTableBinding_4.addColumnBinding(posECectrBeanProperty).setColumnName("\u5BA2\u6236\u8B49\u865F").setEditable(false);
		//
		BeanProperty<PosECectr, String> posECectrBeanProperty_1 = BeanProperty.create("r_txn_seq");
		jTableBinding_4.addColumnBinding(posECectrBeanProperty_1).setColumnName("\u4EA4\u6613\u5E8F\u865F").setEditable(false);
		//
		BeanProperty<PosECectr, String> posECectrBeanProperty_2 = BeanProperty.create("r_txn_date");
		jTableBinding_4.addColumnBinding(posECectrBeanProperty_2).setColumnName("\u4EA4\u6613\u65E5\u671F").setEditable(false);
		//
		BeanProperty<PosECectr, String> posECectrBeanProperty_3 = BeanProperty.create("r_txn_time");
		jTableBinding_4.addColumnBinding(posECectrBeanProperty_3).setColumnName("\u4EA4\u6613\u6642\u9593").setEditable(false);
		//
		BeanProperty<PosECectr, String> posECectrBeanProperty_4 = BeanProperty.create("r_pwd_sw");
		jTableBinding_4.addColumnBinding(posECectrBeanProperty_4).setColumnName("\u7B49\u7D1A").setEditable(false);
		//
		BeanProperty<PosECectr, String> posECectrBeanProperty_5 = BeanProperty.create("r_txn_source");
		jTableBinding_4.addColumnBinding(posECectrBeanProperty_5).setColumnName("\u4F86\u6E90").setEditable(false);
		//
		ELProperty<PosECectr, Object> posECectrEvalutionProperty_2 = ELProperty.create("${r_txn_code} ${r_txn_code_desc}");
		jTableBinding_4.addColumnBinding(posECectrEvalutionProperty_2).setColumnName("\u4EA4\u6613\u985E\u5225").setEditable(false);
		//
		ELProperty<PosECectr, Object> posECectrEvalutionProperty_1 = ELProperty.create("${r_resp_code} ${r_resp_code_desc}");
		jTableBinding_4.addColumnBinding(posECectrEvalutionProperty_1).setColumnName("\u4EA4\u6613\u7D50\u679C").setEditable(false);
		//
		jTableBinding_4.bind();
		//
		BeanProperty<PosECeclpGroup, List<PosECeclp>> posECeclpGroupBeanProperty = BeanProperty.create("posECeclps");
		JTableBinding<PosECeclp, PosECeclpGroup, JTable> jTableBinding_5 = SwingBindings.createJTableBinding(UpdateStrategy.READ, ECeclpGroup, posECeclpGroupBeanProperty, eclptable);
		//
		BeanProperty<PosECeclp, String> posECeclpBeanProperty = BeanProperty.create("r_receive_no");
		jTableBinding_5.addColumnBinding(posECeclpBeanProperty).setColumnName("\u53D7\u7406\u865F\u78BC");
		//
		BeanProperty<PosECeclp, String> posECeclpBeanProperty_1 = BeanProperty.create("r_policy_no");
		jTableBinding_5.addColumnBinding(posECeclpBeanProperty_1).setColumnName("\u4FDD\u55AE\u865F\u78BC");
		//
		BeanProperty<PosECeclp, String> posECeclpBeanProperty_2 = BeanProperty.create("r_txn_detail_old");
		jTableBinding_5.addColumnBinding(posECeclpBeanProperty_2).setColumnName("\u4EA4\u6613\u5167\u5BB9A").setColumnClass(String.class);
		//
		BeanProperty<PosECeclp, String> posECeclpBeanProperty_3 = BeanProperty.create("r_txn_detail_new");
		jTableBinding_5.addColumnBinding(posECeclpBeanProperty_3).setColumnName("\u4EA4\u6613\u5167\u5BB9B").setEditable(false).setColumnClass(String.class);
		//
		jTableBinding_5.bind();
	}
}
