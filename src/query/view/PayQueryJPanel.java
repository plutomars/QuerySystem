package query.view;

import javax.swing.JPanel;


import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import javax.swing.JLabel;

import java.awt.Color;

import javax.swing.JTable;
import query.controller.PayQueryController;
import query.model.PayQuery.PayQuery01;
import query.model.PayQuery.PayQuery01Group;
import query.model.PayQuery.PayQuery01Query;
import query.model.PayQuery.PayQuery02;
import query.model.PayQuery.PayQuery02Group;
import query.model.PayQuery.PayQuery03;
import query.model.PayQuery.PayQuery03Group;
import query.model.PayQuery.PayQuery04;
import query.model.PayQuery.PayQuery04Group;
import query.model.PayQuery.PayQuery05;
import query.model.PayQuery.PayQuery05Group;
import query.model.PayQuery.PayQuery06;
import query.model.PayQuery.PayQuery06Group;

import javax.swing.SpringLayout;
import java.awt.GridLayout;
import org.jdesktop.beansbinding.BeanProperty;

import java.util.HashMap;
import java.util.List;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.JTabbedPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SwingConstants;
import javax.swing.ScrollPaneConstants;

public class PayQueryJPanel  extends JPanel{
	
	private PayQuery01Group group01 = new PayQuery01Group();//add 主畫面索引
	private PayQuery02Group group02 = new PayQuery02Group();//add 分錄
	private PayQuery03Group group03 = new PayQuery03Group();//add 傳票
	private PayQuery04Group group04 = new PayQuery04Group();//add 重開
	private PayQuery05Group group05 = new PayQuery05Group();//add 歷史
	private PayQuery06Group group06 = new PayQuery06Group();//add 其它
	
	private PayQueryController controller;
	private JTable table0;
	private JPanel panel_1;
	private JScrollPane scrollPane_1;
	private JTable poquery03table;
	private JPanel panel_2;
	private JScrollPane scrollPane_2;
	private JTable poquery04table;
	private JPanel panel_4;
	private JPanel panel;
	private JScrollPane scrollPane;
	private JTable poquery01table;
	private JTable poquery02table;
	private JPanel panel_5;
	private JScrollPane scrollPane_3;
	private JTable poquery05table;
	private PayQuery06 pquery06 = new PayQuery06();
	private JScrollPane scrollPane_4;
	private JScrollPane scrollPane_6;
	private JScrollPane scrollPane_7;
	
	private VerticalPane verticalPane;
	private VerticalPane verticalPane_1;
	public String k_disb_no;
	public String k_check_no;
	public String k_reference_code;
	public String k_currency;
	private JLabel label_2;
	private JTextField textField;
	private JLabel lblNewLabel_1;
	private JTextField txtA;
	private JLabel label_1;
	private JTextField textField_2;
	private JButton search_btn;
	
	public PayQueryJPanel() {
		setBackground(Color.WHITE);
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		panel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel, 45, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, panel, 0, SpringLayout.EAST, this);
		panel.setBackground(Color.WHITE);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u4E3B\u7D22\u5F15\u756B\u9762", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 70, 213)));
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		
		poquery01table = new JTable();
		poquery01table.setToolTipText("\u9EDE\u64CA\u7D22\u5F15\u76F8\u95DC\u8CC7\u6599");
		poquery01table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);		
		poquery01table.getSelectionModel().addListSelectionListener(new ListSelectionHandle());
		scrollPane.setViewportView(poquery01table);
				
		panel_4 = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel_4, 220, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.SOUTH, panel, 0, SpringLayout.NORTH, panel_4);
		springLayout.putConstraint(SpringLayout.WEST, panel_4, 0, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, panel_4, 0, SpringLayout.EAST, this);
		panel_4.setBackground(Color.WHITE);
		add(panel_4);
		panel_4.setLayout(new GridLayout(0, 2, 0, 0));
		
		verticalPane = new VerticalPane(new String[] {"\u4ED8\u6B3E\u865F\u78BC", "\u652F\u7968\u65E5\u671F", "Swift_Code", "\u532F\u6B3E\u5E33\u865F", "\u8655\u7406\u65E5\u671F", "\u4ED8\u6B3E\u72C0\u6CC1\u65E5", "\u57F7\u884C\u65E5\u671F", "\u532F\u6B3E\u65E5\u671F", "\u9280\u884C\u78BC"}, "", 90, 23);
		panel_4.add(verticalPane);
		
		verticalPane_1 = new VerticalPane(new String[] {"\u53D7\u6B3E\u4EBAID", "\u50B3\u7968\u865F\u78BC", "\u514C\u73FE\u65E5\u671F", "\u9280\u884C\u540D\u7A31", "\u9280\u884C\u5730\u5740", "\u4ED8\u6B3E\u5099\u8A3B", "\u8655\u7406\u8005", "\u4ED8\u6B3E\u6458\u8981", "\u7A0B\u5F0F\u4EE3\u78BC"}, "", 90, 23);
		panel_4.add(verticalPane_1);
		
		final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		springLayout.putConstraint(SpringLayout.NORTH, tabbedPane, 430, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.SOUTH, panel_4, 0, SpringLayout.NORTH, tabbedPane);
		springLayout.putConstraint(SpringLayout.SOUTH, tabbedPane, 1, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.WEST, tabbedPane, 0, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, tabbedPane, 0, SpringLayout.EAST, this);
		
//				tabbedPane.addChangeListener(new ChangeListener() {
//					public void stateChanged(ChangeEvent arg0) {
//						int rowSelect = tabbedPane.getSelectedIndex();
//						System.out.println("rowSelect:"+ rowSelect);
//						System.out.println("k_disb_no:"+ k_disb_no);
//					    System.out.println("k_check_no:"+ k_check_no);
//					    
//					    if (rowSelect != -1)
//					    {
//					       controller.executeMissionTabValues(k_disb_no, k_check_no, rowSelect);//查詢Tab
//					    }
//					}
//			  });
		add(tabbedPane); 
		
		scrollPane_4 = new JScrollPane();
		tabbedPane.addTab("分錄", null, scrollPane_4, null);

		//poquery01table.setAutoCreateRowSorter(true);
		
		JPanel panel_0 = new JPanel();
		scrollPane_4.setViewportView(panel_0);
		springLayout.putConstraint(SpringLayout.NORTH, panel_0, 165, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, panel_0, 0, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, panel_0, 0, SpringLayout.EAST, this);
		panel_0.setBackground(Color.WHITE);
		panel_0.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "> \u5206\u9304 <", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 70, 213)));
		panel_0.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane0 = new JScrollPane();
		panel_0.add(scrollPane0, BorderLayout.CENTER);		
		scrollPane0.setViewportView(table0);				
		
		poquery02table = new JTable();
		poquery02table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane0.setViewportView(poquery02table);
		
		JScrollPane scrollPane_5 = new JScrollPane();
		tabbedPane.addTab("傳票", null, scrollPane_5, null);
		panel_1 = new JPanel();
		scrollPane_5.setViewportView(panel_1);
		springLayout.putConstraint(SpringLayout.WEST, panel_1, 0, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, panel_1, 257, SpringLayout.WEST, this);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "> \u50B3\u7968 <", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 70, 213)));
		panel_1.setLayout(new BorderLayout(0, 0));
		
		scrollPane_1 = new JScrollPane();
		panel_1.add(scrollPane_1, BorderLayout.CENTER);
		
		poquery03table = new JTable();
		scrollPane_1.setViewportView(poquery03table);
		
		scrollPane_6 = new JScrollPane();
		tabbedPane.addTab("重開", null, scrollPane_6, null);
		
		panel_2 = new JPanel();
		scrollPane_6.setViewportView(panel_2);
		springLayout.putConstraint(SpringLayout.WEST, panel_2, 0, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, panel_2, -297, SpringLayout.EAST, this);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "> \u91CD\u958B <", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 70, 213)));
		panel_2.setLayout(new BorderLayout(0, 0));
		
		scrollPane_2 = new JScrollPane();
		panel_2.add(scrollPane_2, BorderLayout.CENTER);
		
		poquery04table = new JTable();
		scrollPane_2.setViewportView(poquery04table);
		
		scrollPane_7 = new JScrollPane();
		tabbedPane.addTab("歷史", null, scrollPane_7, null);
		
		panel_5 = new JPanel();
		scrollPane_7.setViewportView(panel_5);
		springLayout.putConstraint(SpringLayout.WEST, panel_5, 0, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, panel_5, -448, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, panel_5, 0, SpringLayout.EAST, this);
		panel_5.setBackground(Color.WHITE);
		panel_5.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "> \u6B77\u53F2 <", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 70, 213)));
		panel_5.setLayout(new BorderLayout(0, 0));
		
		scrollPane_3 = new JScrollPane();
		panel_5.add(scrollPane_3, BorderLayout.CENTER);
		
		poquery05table = new JTable();
		scrollPane_3.setViewportView(poquery05table);	
		
		label_2 = new JLabel("\u76F8\u95DC\u865F\u78BC\uFF1A");
		springLayout.putConstraint(SpringLayout.WEST, label_2, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, label_2, -8, SpringLayout.NORTH, panel);
		add(label_2);
		
		textField = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, textField, 0, SpringLayout.EAST, label_2);
		springLayout.putConstraint(SpringLayout.SOUTH, textField, -6, SpringLayout.NORTH, panel);
		add(textField);
		textField.setColumns(10);
		
		lblNewLabel_1 = new JLabel("\u4ED8\u6B3E\u865F\u78BC\uFF1A");
		springLayout.putConstraint(SpringLayout.EAST, textField, -6, SpringLayout.WEST, lblNewLabel_1);
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 0, SpringLayout.NORTH, label_2);
		add(lblNewLabel_1);
		
		txtA = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, txtA, 287, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_1, -6, SpringLayout.WEST, txtA);
		springLayout.putConstraint(SpringLayout.NORTH, txtA, -3, SpringLayout.NORTH, label_2);
		add(txtA);
		txtA.setColumns(10);
		
		label_1 = new JLabel("\u652F\u7968\u65E5\u671F\uFF1A");
		springLayout.putConstraint(SpringLayout.EAST, txtA, -6, SpringLayout.WEST, label_1);
		springLayout.putConstraint(SpringLayout.WEST, label_1, 389, SpringLayout.WEST, this);
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		springLayout.putConstraint(SpringLayout.NORTH, label_1, 0, SpringLayout.NORTH, label_2);
		add(label_1);
		
		textField_2 = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, textField_2, 6, SpringLayout.EAST, label_1);
		springLayout.putConstraint(SpringLayout.SOUTH, textField_2, -6, SpringLayout.NORTH, panel);
		springLayout.putConstraint(SpringLayout.EAST, textField_2, 102, SpringLayout.EAST, label_1);
		add(textField_2);
		textField_2.setColumns(10);
		
		JButton search_btn = new JButton("\u67E5\u8A62");
		springLayout.putConstraint(SpringLayout.NORTH, search_btn, -8, SpringLayout.NORTH, label_2);
		springLayout.putConstraint(SpringLayout.WEST, search_btn, 43, SpringLayout.EAST, textField_2);
		springLayout.putConstraint(SpringLayout.SOUTH, search_btn, 23, SpringLayout.NORTH, label_2);
		springLayout.putConstraint(SpringLayout.EAST, search_btn, 111, SpringLayout.EAST, textField_2);
		search_btn.setForeground(Color.DARK_GRAY);
		search_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				group01.removeAll();
				group02.removeAll();
				group03.removeAll();
				group04.removeAll();
				group05.removeAll();
				group06.removeAll();
				verticalPane.clearValues();
				verticalPane_1.clearValues();
				controller.executeMission(textField.getText(), txtA.getText(), textField_2.getText());//查詢
			}
		});
		add(search_btn);
		
        initDataBindings();	
		
		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		
		//--1(欄位調整)				
		TableColumn headerCol = poquery01table.getColumnModel().getColumn(0);
		headerCol.setPreferredWidth(90); 
		headerCol = poquery01table.getColumnModel().getColumn(1);
		headerCol.setPreferredWidth(45);
		headerCol = poquery01table.getColumnModel().getColumn(2);
		headerCol.setPreferredWidth(60);
		headerCol = poquery01table.getColumnModel().getColumn(3);
		headerCol.setPreferredWidth(50);	
		headerCol = poquery01table.getColumnModel().getColumn(4);
		headerCol.setPreferredWidth(70);	
		headerCol = poquery01table.getColumnModel().getColumn(5);
		headerCol.setPreferredWidth(50);	
		headerCol = poquery01table.getColumnModel().getColumn(6);
		headerCol.setPreferredWidth(70);		
		headerCol.setCellRenderer(rightRenderer);
		headerCol = poquery01table.getColumnModel().getColumn(7);
		headerCol.setPreferredWidth(50);	
		headerCol.setCellRenderer(centerRenderer);
		headerCol = poquery01table.getColumnModel().getColumn(8);
		headerCol.setPreferredWidth(60);	
		headerCol = poquery01table.getColumnModel().getColumn(9);
		headerCol.setPreferredWidth(50);
		headerCol = poquery01table.getColumnModel().getColumn(10);
		headerCol.setPreferredWidth(135);
		
		//--2(欄位調整)
		TableColumn headerCol2 = poquery02table.getColumnModel().getColumn(0);	
		headerCol2.setPreferredWidth(80); 
		headerCol2 = poquery02table.getColumnModel().getColumn(1);	
		headerCol2.setPreferredWidth(60);
		headerCol2 = poquery02table.getColumnModel().getColumn(2);
		headerCol2.setPreferredWidth(80);
		headerCol2 = poquery02table.getColumnModel().getColumn(3);		
		headerCol2.setPreferredWidth(60);
		headerCol2 = poquery02table.getColumnModel().getColumn(4);	
		headerCol2.setPreferredWidth(80);
		headerCol2.setCellRenderer(rightRenderer);
		headerCol2 = poquery02table.getColumnModel().getColumn(5);	
		headerCol2.setPreferredWidth(60);
		headerCol2 = poquery02table.getColumnModel().getColumn(6);		
		headerCol2.setPreferredWidth(90);
		headerCol2 = poquery02table.getColumnModel().getColumn(7);	
		headerCol2.setPreferredWidth(90);
		headerCol2 = poquery02table.getColumnModel().getColumn(8);
		headerCol2.setPreferredWidth(60);
		headerCol2 = poquery02table.getColumnModel().getColumn(9);	
		headerCol2.setPreferredWidth(250);
	
		//--3(欄位調整)
		TableColumn headerCol3 = poquery03table.getColumnModel().getColumn(0);
		headerCol3.setPreferredWidth(60);
		headerCol3 = poquery03table.getColumnModel().getColumn(1);	
		headerCol3.setPreferredWidth(30);
		headerCol3 = poquery03table.getColumnModel().getColumn(2);	
		headerCol3.setPreferredWidth(50);
		headerCol3 = poquery03table.getColumnModel().getColumn(3);	
		headerCol3.setPreferredWidth(50);
		headerCol3 = poquery03table.getColumnModel().getColumn(4);
		headerCol3.setPreferredWidth(80);

		//--5(欄位調整)
		TableColumn headerCol5 = poquery05table.getColumnModel().getColumn(0);	
		headerCol5.setPreferredWidth(70); 
		headerCol5 = poquery05table.getColumnModel().getColumn(1);	
		headerCol5.setPreferredWidth(95);
		headerCol5 = poquery05table.getColumnModel().getColumn(2);		
		headerCol5.setPreferredWidth(60);
		headerCol5 = poquery05table.getColumnModel().getColumn(3);
		headerCol5.setPreferredWidth(60);
		headerCol5 = poquery05table.getColumnModel().getColumn(4);	
		headerCol5.setPreferredWidth(80);
		headerCol5 = poquery05table.getColumnModel().getColumn(5);	
		headerCol5.setPreferredWidth(80);
		headerCol5 = poquery05table.getColumnModel().getColumn(6);	
		headerCol5.setPreferredWidth(80);
		headerCol5 = poquery05table.getColumnModel().getColumn(7);
		headerCol5.setPreferredWidth(80);
	}
	
	private class ListSelectionHandle implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent arg0) {
			int i = poquery01table.getSelectedRow();		
			if (!((DefaultListSelectionModel) arg0.getSource())
					.getValueIsAdjusting()) {
	    	if(i != -1)
	    	{	
//	    		if(((DefaultListSelectionModel)arg0.getSource()).getValueIsAdjusting() )
//				{
	    			k_disb_no =  group01.getPayQuery01().get(i).getM_disb_no();  // 取[付款號碼]當KEY
	    			k_check_no = group01.getPayQuery01().get(i).getM_check_no(); // 取[支票號碼]當KEY
	    			k_currency = group01.getPayQuery01().get(i).getM_currency();
	    			k_reference_code = textField.getText();
	    			
	    			PayQuery01Query rq = new PayQuery01Query();

	    			//------>分錄
	    			group02.removeAll();
					List<HashMap<String,String>> list2 = rq.getResultList2(k_currency,k_reference_code,k_disb_no, PayQuery01Query.PayQ02);
					
					for (HashMap<String, String> hsmap2 : list2) {
						PayQuery02 PayQuery02 = new PayQuery02(hsmap2);
						group02.addPayQuery02(PayQuery02);
			        }
					
					//------>傳票
					group03.removeAll();
					List<HashMap<String,String>> list3 = rq.getResultList2(k_currency,k_reference_code,k_disb_no, PayQuery01Query.PayQ03);
					
					for (HashMap<String, String> hsmap3 : list3) {	
						PayQuery03 PayQuery03 = new PayQuery03(hsmap3);
						group03.addPayQuery03(PayQuery03);
			        }
					
					//------>重開
					group04.removeAll();
						List<HashMap<String,String>> list4 = rq.getResultList4(k_check_no, PayQuery01Query.PayQ04);					
						for (HashMap<String, String> hsmap4 : list4) {	
							PayQuery04 PayQuery04 = new PayQuery04(hsmap4);
							group04.addPayQuery04(PayQuery04);
				        }

					
					//------>歷史
					group05.removeAll();
					List<HashMap<String,String>> list5 = rq.getResultList2(k_currency,k_reference_code,k_disb_no, PayQuery01Query.PayQ05);
					
					for (HashMap<String, String> hsmap5 : list5) {
						PayQuery05 PayQuery05 = new PayQuery05(hsmap5);
						group05.addPayQuery05(PayQuery05);
			        }
					
					//------>其它
					group06.removeAll();
					List<HashMap<String,String>> list6 = rq.getResultList2(k_currency,k_reference_code,k_disb_no, PayQuery01Query.PayQ06);
					
					pquery06.setAttributes(list6.get(0));
					String[] values1 = pquery06.getValues(1);
					verticalPane.setValue(values1);//中間左區
					
					String[] values2 = pquery06.getValues(2);
					verticalPane_1.setValue(values2);//中間右區
//				}
	    	}
		}
		}
	}
	
	
	public void setController(PayQueryController controller){ //add
		this.controller = controller;
	}

	//新增體"付款資料查詢"至群組(PayQueryGroup)
	public void addPayQuery01(PayQuery01 payquery01) {
		group01.addPayQuery01(payquery01);
	}	

	public void addPayQuery02(PayQuery02 payquery02) {
		group02.addPayQuery02(payquery02);
	}
		
	public void addPayQuery03(PayQuery03 payquery03) {
		group03.addPayQuery03(payquery03);
	}
	
	public void addPayQuery04(PayQuery04 payquery04) {
		group04.addPayQuery04(payquery04);
	}
	
	public void addPayQuery05(PayQuery05 payquery05) {
		group05.addPayQuery05(payquery05);
	}
	
	public void addPayQuery06(PayQuery06 payquery06) {
		group06.addPayQuery06(payquery06);
	}
	
	public void setDefaultRow()
	{
		if (poquery01table.getRowCount() > 0)
		{	
			if (poquery01table.getSelectedRow()== -1){
				ListSelectionModel selectionModel =    poquery01table.getSelectionModel(); 
				selectionModel.setSelectionInterval(0, 0);
			}
		}
		
	}
	
	// 清空資料
		public void clearAll() {
			group01.removeAll();
			group02.removeAll();
			group03.removeAll();
			group04.removeAll();
			group05.removeAll();
			group06.removeAll();
			verticalPane.clearValues();
			verticalPane_1.clearValues();
		}
		
		public void nullAll() {
			group01 = null;
			group02 = null;
			group03 = null;
			group04 = null;
			group05 = null;
			group06 = null;
			controller = null;			
			table0 = null;
			poquery01table = null;
			poquery02table = null;
			poquery03table = null;
			poquery04table = null;
			poquery05table = null;			
			panel = null;
			panel_1 = null;
			panel_2 = null;
			panel_4 = null;
			panel_5 = null;			
			verticalPane = null;
			verticalPane_1 = null;
			k_disb_no = null;
			k_check_no = null;
			label_2  = null;
			textField = null;
			lblNewLabel_1 = null;
			txtA = null;
			label_1 = null;
			textField_2 = null;
		}	
		
		public void setPONO(String policy_no) {
			textField.setText(policy_no);
			txtA.setText("");
			textField_2.setText("");
		}
		

		
	//清除群組中的所有組員(Group)
	public void clearPayQuery01s() {
		group01.removeAll();
	}
	
	public void clearPayQuery02s() {
		group02.removeAll();
	}
	
	public void clearPayQuery03s() {
		group03.removeAll();
	}
	
	public void clearPayQuery04s() {
		group04.removeAll();
	}
	
	public void clearPayQuery05s() {
		group05.removeAll();
	}
	
	public void clearPayQuery06s() {
		group06.removeAll();
	}
	protected void initDataBindings() {
		BeanProperty<PayQuery01Group, List<PayQuery01>> payQuery01GroupBeanProperty = BeanProperty.create("payQuery01");
		JTableBinding<PayQuery01, PayQuery01Group, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, group01, payQuery01GroupBeanProperty, poquery01table);
		//
		BeanProperty<PayQuery01, String> payQuery01BeanProperty = BeanProperty.create("m_reference_code");
		jTableBinding.addColumnBinding(payQuery01BeanProperty).setColumnName("\u76F8\u95DC\u865F\u78BC");
		//
		BeanProperty<PayQuery01, String> payQuery01BeanProperty_1 = BeanProperty.create("m_payee");
		jTableBinding.addColumnBinding(payQuery01BeanProperty_1).setColumnName("\u53D7\u6B3E\u4EBA");
		//
		BeanProperty<PayQuery01, String> payQuery01BeanProperty_2 = BeanProperty.create("m_payee_cht");
		jTableBinding.addColumnBinding(payQuery01BeanProperty_2).setColumnName("\u53D7\u6B3E\u4EBA(\u4E2D)");
		//
		BeanProperty<PayQuery01, String> payQuery01BeanProperty_3 = BeanProperty.create("m_disb_no");
		jTableBinding.addColumnBinding(payQuery01BeanProperty_3).setColumnName("\u4ED8\u6B3E\u865F\u78BC");
		//
		BeanProperty<PayQuery01, String> payQuery01BeanProperty_4 = BeanProperty.create("m_disb_method");
		jTableBinding.addColumnBinding(payQuery01BeanProperty_4).setColumnName("\u4ED8\u6B3E\u65B9\u5F0F");
		//
		BeanProperty<PayQuery01, String> payQuery01BeanProperty_5 = BeanProperty.create("m_check_no");
		jTableBinding.addColumnBinding(payQuery01BeanProperty_5).setColumnName("\u652F\u7968\u865F\u78BC");
		//
		BeanProperty<PayQuery01, String> payQuery01BeanProperty_6 = BeanProperty.create("m_disb_amt");
		jTableBinding.addColumnBinding(payQuery01BeanProperty_6).setColumnName("\u4ED8\u6B3E\u91D1\u984D");
		//
		BeanProperty<PayQuery01, String> payQuery01BeanProperty_7 = BeanProperty.create("m_currency");
		jTableBinding.addColumnBinding(payQuery01BeanProperty_7).setColumnName("\u5E63\u5225");
		//
		BeanProperty<PayQuery01, String> payQuery01BeanProperty_8 = BeanProperty.create("m_disb_type");
		jTableBinding.addColumnBinding(payQuery01BeanProperty_8).setColumnName("\u4ED8\u6B3E\u578B\u614B");
		//
		BeanProperty<PayQuery01, String> payQuery01BeanProperty_9 = BeanProperty.create("m_disb_sts_code");
		jTableBinding.addColumnBinding(payQuery01BeanProperty_9).setColumnName("\u4ED8\u6B3E\u72C0\u6CC1");
		//
		BeanProperty<PayQuery01, String> payQuery01BeanProperty_10 = BeanProperty.create("m_function_code");
		jTableBinding.addColumnBinding(payQuery01BeanProperty_10).setColumnName("\u529F\u80FD\u78BC");
		//
		jTableBinding.setEditable(false);
		jTableBinding.bind();
		//
		BeanProperty<PayQuery02Group, List<PayQuery02>> payQuery02GroupBeanProperty = BeanProperty.create("payQuery02");
		JTableBinding<PayQuery02, PayQuery02Group, JTable> jTableBinding_1 = SwingBindings.createJTableBinding(UpdateStrategy.READ, group02, payQuery02GroupBeanProperty, poquery02table);
		//
		BeanProperty<PayQuery02, String> payQuery02BeanProperty = BeanProperty.create("m_voucher_no");
		jTableBinding_1.addColumnBinding(payQuery02BeanProperty).setColumnName("\u50B3\u7968\u865F\u78BC");
		//
		BeanProperty<PayQuery02, String> payQuery02BeanProperty_1 = BeanProperty.create("m_voucher_seq");
		jTableBinding_1.addColumnBinding(payQuery02BeanProperty_1).setColumnName("\u5E8F\u865F");
		//
		BeanProperty<PayQuery02, String> payQuery02BeanProperty_2 = BeanProperty.create("m_acct_no");
		jTableBinding_1.addColumnBinding(payQuery02BeanProperty_2).setColumnName("\u6703\u8A08\u79D1\u76EE");
		//
		BeanProperty<PayQuery02, String> payQuery02BeanProperty_3 = BeanProperty.create("m_dept_code");
		jTableBinding_1.addColumnBinding(payQuery02BeanProperty_3).setColumnName("\u90E8\u9580\u5225");
		//
		BeanProperty<PayQuery02, String> payQuery02BeanProperty_4 = BeanProperty.create("m_journal_amt");
		jTableBinding_1.addColumnBinding(payQuery02BeanProperty_4).setColumnName("\u5206\u9304\u91D1\u984D");
		//
		BeanProperty<PayQuery02, String> payQuery02BeanProperty_5 = BeanProperty.create("m_reason_code");
		jTableBinding_1.addColumnBinding(payQuery02BeanProperty_5).setColumnName("\u6C96\u92B7\u78BC");
		//
		BeanProperty<PayQuery02, String> payQuery02BeanProperty_6 = BeanProperty.create("m_policy_no");
		jTableBinding_1.addColumnBinding(payQuery02BeanProperty_6).setColumnName("\u4FDD\u55AE\u865F\u78BC");
		//
		BeanProperty<PayQuery02, String> payQuery02BeanProperty_7 = BeanProperty.create("m_agent_code");
		jTableBinding_1.addColumnBinding(payQuery02BeanProperty_7).setColumnName("\u696D\u52D9\u54E1\u4EE3\u78BC");
		//
		BeanProperty<PayQuery02, String> payQuery02BeanProperty_8 = BeanProperty.create("m_reason_code");
		jTableBinding_1.addColumnBinding(payQuery02BeanProperty_8).setColumnName("\u539F\u56E0\u78BC");
		//
		BeanProperty<PayQuery02, String> payQuery02BeanProperty_9 = BeanProperty.create("m_journal_desc");
		jTableBinding_1.addColumnBinding(payQuery02BeanProperty_9).setColumnName("\u5206\u9304\u6458\u8981");
		//
		jTableBinding_1.setEditable(false);
		jTableBinding_1.bind();
		//
		BeanProperty<PayQuery03Group, List<PayQuery03>> payQuery03GroupBeanProperty = BeanProperty.create("payQuery03");
		JTableBinding<PayQuery03, PayQuery03Group, JTable> jTableBinding_2 = SwingBindings.createJTableBinding(UpdateStrategy.READ, group03, payQuery03GroupBeanProperty, poquery03table);
		//
		BeanProperty<PayQuery03, String> payQuery03BeanProperty = BeanProperty.create("m_voucher_no");
		jTableBinding_2.addColumnBinding(payQuery03BeanProperty).setColumnName("\u50B3\u7968\u865F\u78BC");
		//
		BeanProperty<PayQuery03, String> payQuery03BeanProperty_1 = BeanProperty.create("m_journal_seq");
		jTableBinding_2.addColumnBinding(payQuery03BeanProperty_1).setColumnName("\u5E8F\u865F");
		//
		BeanProperty<PayQuery03, String> payQuery03BeanProperty_2 = BeanProperty.create("m_disb_amt");
		jTableBinding_2.addColumnBinding(payQuery03BeanProperty_2).setColumnName("\u4ED8\u6B3E\u91D1\u984D");
		//
		BeanProperty<PayQuery03, String> payQuery03BeanProperty_3 = BeanProperty.create("m_acct_no");
		jTableBinding_2.addColumnBinding(payQuery03BeanProperty_3).setColumnName("\u6703\u8A08\u79D1\u76EE");
		//
		BeanProperty<PayQuery03, String> payQuery03BeanProperty_4 = BeanProperty.create("m_journal_desc");
		jTableBinding_2.addColumnBinding(payQuery03BeanProperty_4).setColumnName("\u5206\u9304\u6458\u8981");
		//
		jTableBinding_2.setEditable(false);
		jTableBinding_2.bind();
		//
		BeanProperty<PayQuery04Group, List<PayQuery04>> payQuery04GroupBeanProperty = BeanProperty.create("payQuery04");
		JTableBinding<PayQuery04, PayQuery04Group, JTable> jTableBinding_3 = SwingBindings.createJTableBinding(UpdateStrategy.READ, group04, payQuery04GroupBeanProperty, poquery04table);
		//
		BeanProperty<PayQuery04, String> payQuery04BeanProperty = BeanProperty.create("m_dbdi_desc");
		jTableBinding_3.addColumnBinding(payQuery04BeanProperty).setColumnName("\u91CD\u958B\u8A3B\u8A18");
		//
		jTableBinding_3.setEditable(false);
		jTableBinding_3.bind();
		//
		BeanProperty<PayQuery05Group, List<PayQuery05>> payQuery05GroupBeanProperty = BeanProperty.create("payQuery05");
		JTableBinding<PayQuery05, PayQuery05Group, JTable> jTableBinding_4 = SwingBindings.createJTableBinding(UpdateStrategy.READ, group05, payQuery05GroupBeanProperty, poquery05table);
		//
		BeanProperty<PayQuery05, String> payQuery05BeanProperty = BeanProperty.create("m_disb_no");
		jTableBinding_4.addColumnBinding(payQuery05BeanProperty).setColumnName("\u4ED8\u6B3E\u865F\u78BC");
		//
		BeanProperty<PayQuery05, String> payQuery05BeanProperty_1 = BeanProperty.create("m_disb_sts_code");
		jTableBinding_4.addColumnBinding(payQuery05BeanProperty_1).setColumnName("\u4ED8\u6B3E\u72C0\u6CC1");
		//
		BeanProperty<PayQuery05, String> payQuery05BeanProperty_2 = BeanProperty.create("m_disb_sts_date");
		jTableBinding_4.addColumnBinding(payQuery05BeanProperty_2).setColumnName("\u72C0\u6CC1\u65E5");
		//
		BeanProperty<PayQuery05, String> payQuery05BeanProperty_3 = BeanProperty.create("m_dept_code");
		jTableBinding_4.addColumnBinding(payQuery05BeanProperty_3).setColumnName("\u90E8\u9580\u4EE3\u78BC");
		//
		BeanProperty<PayQuery05, String> payQuery05BeanProperty_4 = BeanProperty.create("m_voucher_no");
		jTableBinding_4.addColumnBinding(payQuery05BeanProperty_4).setColumnName("\u50B3\u7968\u865F\u78BC");
		//
		BeanProperty<PayQuery05, String> payQuery05BeanProperty_6 = BeanProperty.create("m_process_date");
		jTableBinding_4.addColumnBinding(payQuery05BeanProperty_6).setColumnName("\u8655\u7406\u65E5\u671F");
		//
		BeanProperty<PayQuery05, String> payQuery05BeanProperty_7 = BeanProperty.create("m_process_time");
		jTableBinding_4.addColumnBinding(payQuery05BeanProperty_7).setColumnName("\u8655\u7406\u6642\u9593");
		//
		BeanProperty<PayQuery05, String> payQuery05BeanProperty_8 = BeanProperty.create("m_process_user");
		jTableBinding_4.addColumnBinding(payQuery05BeanProperty_8).setColumnName("\u8655\u7406\u8005");
		//
		jTableBinding_4.setEditable(false);
		jTableBinding_4.bind();
	}
}

