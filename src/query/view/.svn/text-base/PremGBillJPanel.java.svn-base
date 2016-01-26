package query.view;

/**
 * 
 * @author swei
 * @version 1.0
 * 集體彙繳查詢畫面
 * 
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;

import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableColumn;

import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

import query.controller.PremGBillController;
import query.model.PremGBill.PremGBill01;
import query.model.PremGBill.PremGBill01Group;
import query.model.PremGBill.PremGBill01Query;
import query.model.PremGBill.PremGBill02;
import query.model.PremGBill.PremGBill02Group;
import query.model.PremGBill.PremGBill03;
import query.model.PremGBill.PremGBill03Group;

import javax.swing.UIManager;
import javax.swing.SpringLayout;


public class PremGBillJPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private JTable premgbill01table;
	private JTable premgbill03table;
	private PremGBill01Group group01 = new PremGBill01Group();//add
 	private PremGBill02Group group02 = new PremGBill02Group();//add
 	private PremGBill03Group group03 = new PremGBill03Group();//add
	private PremGBill02 gbill02 = new PremGBill02();
	private PremGBillController controller;
	private VerticalPane detailScrollPane1;
	private VerticalPane detailScrollPane2;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_1;
	
	/**
	 * Create the panel.
	 */
	public PremGBillJPanel() {
		setBackground(Color.WHITE);
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JButton button = new JButton("\u67E5\u8A62");
		add(button);
	
		button.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {			
			premgbill01table.updateUI();
			detailScrollPane1.clearValues();
			detailScrollPane2.clearValues();
			group03.removeAll();
			controller.executeMission(textField.getText(), textField_1.getText(), textField_2.getText());//查詢彙繳人清單01
			}
		});
		
		//下左方Panel
		String[] headers1 = {"彙繳編號", "彙繳地址", "郵遞區號", "受任人姓名","彙繳電話", "公司名稱"};
		
		//下左方Panel
		String[] headers2 = {"彙繳生效", "前次修改日", "前次修改者", "指示說明","總件數", "總人數"};
				
				JPanel panel_01 = new JPanel();
				springLayout.putConstraint(SpringLayout.SOUTH, button, -20, SpringLayout.NORTH, panel_01);
				springLayout.putConstraint(SpringLayout.SOUTH, panel_01, 200, SpringLayout.NORTH, this);
				springLayout.putConstraint(SpringLayout.NORTH, panel_01, 69, SpringLayout.NORTH, this);
				springLayout.putConstraint(SpringLayout.WEST, panel_01, 0, SpringLayout.WEST, this);
				springLayout.putConstraint(SpringLayout.EAST, panel_01, 0, SpringLayout.EAST, this);
				add(panel_01);
				panel_01.setBackground(Color.WHITE);
				panel_01.setBorder(new TitledBorder(null, "\u67E5\u8A62\u5F59\u7E73\u4EBA", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panel_01.setLayout(new BorderLayout(0, 0));
				
				JScrollPane poexam01scrollPane = new JScrollPane();
				panel_01.add(poexam01scrollPane, BorderLayout.CENTER);
				
				premgbill01table = new JTable();
				premgbill01table.setToolTipText("點擊以顯示下方明細");
				premgbill01table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);		
				premgbill01table.getSelectionModel().addListSelectionListener(new ListSelectionHandle());
					poexam01scrollPane.setViewportView(premgbill01table);
				
				JPanel panel_5 = new JPanel();
				springLayout.putConstraint(SpringLayout.NORTH, panel_5, 202, SpringLayout.NORTH, this);
				springLayout.putConstraint(SpringLayout.WEST, panel_5, 6, SpringLayout.WEST, this);
				springLayout.putConstraint(SpringLayout.SOUTH, panel_5, 355, SpringLayout.NORTH, this);
				springLayout.putConstraint(SpringLayout.EAST, panel_5, -5, SpringLayout.EAST, this);
				add(panel_5);
				panel_5.setLayout(new GridLayout(0, 2, 0, 0));
				detailScrollPane1 = new VerticalPane(new String[] {"\u5F59\u7E73\u7DE8\u865F", "\u5F59\u7E73\u5730\u5740", "\u90F5\u905E\u5340\u865F", "\u53D7\u4EFB\u4EBA\u59D3\u540D", "\u5F59\u7E73\u96FB\u8A71", "\u516C\u53F8\u540D\u7A31"}, "", 80, 25);
				
				panel_5.add(detailScrollPane1);
				detailScrollPane2 = new VerticalPane(headers2, "", 80, 25);
				panel_5.add(detailScrollPane2);
				
				JPanel panel = new JPanel();
				springLayout.putConstraint(SpringLayout.NORTH, panel, 3, SpringLayout.SOUTH, panel_5);
				springLayout.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, this);
				springLayout.putConstraint(SpringLayout.SOUTH, panel, 0, SpringLayout.SOUTH, this);
				springLayout.putConstraint(SpringLayout.EAST, panel, 0, SpringLayout.EAST, this);
				add(panel);
				panel.setLayout(new GridLayout(1, 1, 0, 0));
				
				JPanel panel_03 = new JPanel();
				panel.add(panel_03);
				springLayout.putConstraint(SpringLayout.NORTH, panel_03, 309, SpringLayout.NORTH, this);
				springLayout.putConstraint(SpringLayout.WEST, panel_03, 0, SpringLayout.WEST, this);
				springLayout.putConstraint(SpringLayout.SOUTH, panel_03, 412, SpringLayout.NORTH, this);
				springLayout.putConstraint(SpringLayout.EAST, panel_03, 516, SpringLayout.WEST, this);
				panel_03.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u5F59\u7E73\u5167\u5BB9", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 70, 213)));
				panel_03.setBackground(Color.WHITE);
				panel_03.setLayout(new BorderLayout(0, 0));
				
				JScrollPane scrollPane = new JScrollPane();
				panel_03.add(scrollPane, BorderLayout.CENTER);				
				
				premgbill03table = new JTable();
				scrollPane.setViewportView(premgbill03table);
				premgbill03table.setAutoCreateRowSorter(true);
				
				JLabel label_3 = new JLabel("\u5F59\u7E73\u7DE8\u865F\uFF1A");
				springLayout.putConstraint(SpringLayout.NORTH, button, 0, SpringLayout.NORTH, label_3);
				springLayout.putConstraint(SpringLayout.NORTH, label_3, 3, SpringLayout.NORTH, this);
				springLayout.putConstraint(SpringLayout.WEST, label_3, 0, SpringLayout.WEST, panel_5);
				add(label_3);
				
				textField = new JTextField();
				springLayout.putConstraint(SpringLayout.WEST, textField, 9, SpringLayout.EAST, label_3);
				add(textField);
				textField.setColumns(10);
				
				JLabel lblNewLabel_2 = new JLabel("\u516C\u53F8\u540D\u7A31\uFF1A");
				springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_2, 0, SpringLayout.WEST, panel_5);
				springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_2, -8, SpringLayout.NORTH, panel_01);
				add(lblNewLabel_2);
				
				JLabel lblNewLabel = new JLabel("\u53D7\u4EFB\u4EBA\u59D3\u540D\uFF1A");
				springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 153, SpringLayout.EAST, textField);
				springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel, 0, SpringLayout.SOUTH, label_3);
				add(lblNewLabel);
				
				textField_2 = new JTextField();
				springLayout.putConstraint(SpringLayout.WEST, button, 18, SpringLayout.EAST, textField_2);
				springLayout.putConstraint(SpringLayout.WEST, textField_2, 3, SpringLayout.EAST, lblNewLabel);
				add(textField_2);
				textField_2.setColumns(10);
				
				textField_1 = new JTextField();
				springLayout.putConstraint(SpringLayout.NORTH, textField_1, 8, SpringLayout.SOUTH, textField);
				springLayout.putConstraint(SpringLayout.WEST, textField_1, 9, SpringLayout.EAST, lblNewLabel_2);
				springLayout.putConstraint(SpringLayout.EAST, textField_1, -2, SpringLayout.EAST, textField_2);
				add(textField_1);
				textField_1.setColumns(10);

		initDataBindings();
		//---------------------------------------------------------------//		
		TableColumn headerCol1 = premgbill01table.getColumnModel().getColumn(0);
		headerCol1.setPreferredWidth(100); 
	  
		headerCol1 = premgbill01table.getColumnModel().getColumn(1);
		headerCol1.setPreferredWidth(150);
		
		
		headerCol1 = premgbill01table.getColumnModel().getColumn(2);
		headerCol1.setPreferredWidth(523);
	}
	
	private class ListSelectionHandle implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent arg0) {

	    	int i = premgbill01table.getSelectedRow();
	    	if(i != -1)
	    	{	    	
				if(((DefaultListSelectionModel)arg0.getSource()).getValueIsAdjusting() )
				{
					// 塞入"彙繳內容02"(premgbill_02)
					String k_group_code = group01.getPremGBill01().get(i).getM_group_code();
					String k_assigner = group01.getPremGBill01().get(i).getM_assigner();
					String k_company_name = group01.getPremGBill01().get(i).getM_company_name();
					
					PremGBill01Query rq = new PremGBill01Query();
					group02.removeAll();
					
					List<HashMap<String,String>> list =
							rq.getResultList(k_group_code, k_assigner, k_company_name, PremGBill01Query.GContext02);
	
					gbill02.setAttributes(list.get(0));
				
					String[] values1 = gbill02.getValues(1);
					
					detailScrollPane1.setValue(values1);
					
					String[] values2 = gbill02.getValues(2);			
					detailScrollPane2.setValue(values2);
	
					// 塞入"彙繳內容03"(premgbill_03)				
					PremGBill01Query rq3 = new PremGBill01Query();
					List<HashMap<String,String>> list3 =
							rq3.getResultList2(k_group_code, PremGBill01Query.GContext03);
					
					group03.removeAll();
					for (HashMap<String, String> hsmap : list3) {				
						PremGBill03 PremGBill03 = new PremGBill03(hsmap);
						group03.addPremGBill03(PremGBill03);
					}
					
				}
	    	}
	    }
	}



	public void setController(PremGBillController controller){ //add
		this.controller = controller;
	}

	/**
	 * 新增體檢原因資料至體檢原因群組(RelationGroup)
	 * 
	 * @param relation
	 *            Relation物件
	 */
	public void addPremGBill01(PremGBill01 premgbill01) {
		group01.addPremGBill01(premgbill01);
	}
	
	public void addPremGBill02(PremGBill02 premgbill02) {
		group02.addPremGBill02(premgbill02);
	}
	
	public void addPremGBill03(PremGBill03 premgbill03) {
		group03.addPremGBill03(premgbill03);
	}

	// 清空資料
		public void clearAll() {
			group01.removeAll();
			group02.removeAll();
			group03.removeAll();
			detailScrollPane1.clearValues();
			detailScrollPane2.clearValues();
			textField.removeAll();
			textField_1.removeAll();
			textField_2.removeAll();
		}
		
		public void nullAll() {
			premgbill01table = null;
			premgbill03table = null;
			group01 = null;
			group02 = null;
			group03 = null;
			gbill02 = null;
			controller = null;			
			detailScrollPane1 = null;
			detailScrollPane2 = null;
			textField = null;
			textField_1 = null;
			textField_2 = null;
		}
		
	//清除群組中的所有組員(Group)
	public void clearPremGBill01s() {		
		group01.removeAll();
	}
			
	//清除群組中的所有組員(Group)
	public void clearPremGBill02s() {		
		group02.removeAll();
	}
	
	//清除群組中的所有組員(Group)
	public void clearPremGBill03s() {		
		group03.removeAll();
	}
	protected void initDataBindings() {
		BeanProperty<PremGBill03Group, List<PremGBill03>> premGBill03GroupBeanProperty = BeanProperty.create("premGBill03");
		JTableBinding<PremGBill03, PremGBill03Group, JTable> jTableBinding_1 = SwingBindings.createJTableBinding(UpdateStrategy.READ, group03, premGBill03GroupBeanProperty, premgbill03table);
		//
		BeanProperty<PremGBill03, String> premGBill03BeanProperty = BeanProperty.create("m_policy_no");
		jTableBinding_1.addColumnBinding(premGBill03BeanProperty).setColumnName("\u4FDD\u55AE\u865F\u78BC");
		//
		BeanProperty<PremGBill03, String> premGBill03BeanProperty_1 = BeanProperty.create("m_owner_name");
		jTableBinding_1.addColumnBinding(premGBill03BeanProperty_1).setColumnName("\u8981\u4FDD\u4EBA");
		//
		BeanProperty<PremGBill03, String> premGBill03BeanProperty_2 = BeanProperty.create("m_insured_name");
		jTableBinding_1.addColumnBinding(premGBill03BeanProperty_2).setColumnName("\u88AB\u4FDD\u96AA\u4EBA");
		//
		BeanProperty<PremGBill03, String> premGBill03BeanProperty_3 = BeanProperty.create("m_issue_date");
		jTableBinding_1.addColumnBinding(premGBill03BeanProperty_3).setColumnName("\u751F\u6548\u65E5");
		//
		BeanProperty<PremGBill03, String> premGBill03BeanProperty_4 = BeanProperty.create("m_paid_to_date");
		jTableBinding_1.addColumnBinding(premGBill03BeanProperty_4).setColumnName("\u7E73\u8CBB\u7D42\u65E5");
		//
		BeanProperty<PremGBill03, String> premGBill03BeanProperty_5 = BeanProperty.create("m_modx");
		jTableBinding_1.addColumnBinding(premGBill03BeanProperty_5).setColumnName("\u7E73\u5225");
		//
		BeanProperty<PremGBill03, String> premGBill03BeanProperty_6 = BeanProperty.create("m_po_sts_code");
		jTableBinding_1.addColumnBinding(premGBill03BeanProperty_6).setColumnName("\u72C0\u614B");
		//
		BeanProperty<PremGBill03, String> premGBill03BeanProperty_7 = BeanProperty.create("m_new_ind");
		jTableBinding_1.addColumnBinding(premGBill03BeanProperty_7).setColumnName("\u65B0");
		//
		BeanProperty<PremGBill03, String> premGBill03BeanProperty_8 = BeanProperty.create("m_old_ind");
		jTableBinding_1.addColumnBinding(premGBill03BeanProperty_8).setColumnName("\u820A");
		//
		jTableBinding_1.setEditable(false);
		jTableBinding_1.bind();
		//
		BeanProperty<PremGBill01Group, List<PremGBill01>> premGBill01GroupBeanProperty = BeanProperty.create("premGBill01");
		JTableBinding<PremGBill01, PremGBill01Group, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, group01, premGBill01GroupBeanProperty, premgbill01table);
		//
		BeanProperty<PremGBill01, String> premGBill01BeanProperty = BeanProperty.create("m_group_code");
		jTableBinding.addColumnBinding(premGBill01BeanProperty).setColumnName("\u5F59\u7E73\u7DE8\u865F");
		//
		BeanProperty<PremGBill01, String> premGBill01BeanProperty_1 = BeanProperty.create("m_assigner");
		jTableBinding.addColumnBinding(premGBill01BeanProperty_1).setColumnName("\u53D7\u4EFB\u4EBA\u59D3\u540D");
		//
		BeanProperty<PremGBill01, String> premGBill01BeanProperty_2 = BeanProperty.create("m_company_name");
		jTableBinding.addColumnBinding(premGBill01BeanProperty_2).setColumnName(" \u516C\u53F8\u540D\u7A31 ");
		//
		jTableBinding.setEditable(false);
		jTableBinding.bind();
	}
}
