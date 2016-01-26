package query.view;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.BoxLayout;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.BorderLayout;

import javax.swing.DefaultListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SpringLayout;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;

import query.controller.ValueReAssociateController;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import org.jdesktop.beansbinding.BeanProperty;

import java.util.HashMap;
import java.util.List;

import query.model.ValueReAssociate.ValueReAssociate01;
import query.model.ValueReAssociate.ValueReAssociate01Group;
import query.model.ValueReAssociate.ValueReAssociate01Query;
import query.model.ValueReAssociate.ValueReAssociate02;
import query.model.ValueReAssociate.ValueReAssociate02Group;

import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
/**
 * @version 1.0
 * @author swei
 * 回流關聯查詢PoReAssociate_view
 * 
 */
public class ValueReAssociateJPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTable table_1;
	private ValueReAssociateController controller;
	private ValueReAssociate01Group group01 = new ValueReAssociate01Group();//add 主畫面索引
	private ValueReAssociate02Group group02 = new ValueReAssociate02Group();//add 分錄
	private JTextField NewPo__textField;
	private JTextField OldPo__textField;
	private JTextField Ann_date__textField;
	/**
	 * Create the panel.
	 */
	
	public ValueReAssociateJPanel() {
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JPanel panel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel, 60, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, panel, 0, SpringLayout.EAST, this);
		panel.setBorder(new TitledBorder(null, "\u65B0\u4EF6\u4FDD\u55AE", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.getSelectionModel().addListSelectionListener(new ListSelectionHandle());
		
		JPanel panel_1 = new JPanel();
		springLayout.putConstraint(SpringLayout.SOUTH, panel, 0, SpringLayout.NORTH, panel_1);
		springLayout.putConstraint(SpringLayout.NORTH, panel_1, 248, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.SOUTH, panel_1, 0, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.WEST, panel_1, 0, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, panel_1, 0, SpringLayout.EAST, this);
		panel_1.setBorder(new TitledBorder(null, "\u820A\u4EF6\u4FDD\u55AE", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_1.add(scrollPane_1, BorderLayout.CENTER);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		JLabel label = new JLabel("\u65B0\u4EF6\u4FDD\u55AE\u865F\u78BC\uFF1A");
		springLayout.putConstraint(SpringLayout.NORTH, label, 26, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, label, 10, SpringLayout.WEST, this);
		label.setForeground(Color.BLACK);
		add(label);
		
		NewPo__textField = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, NewPo__textField, -3, SpringLayout.NORTH, label);
		springLayout.putConstraint(SpringLayout.WEST, NewPo__textField, 6, SpringLayout.EAST, label);
		add(NewPo__textField);
		NewPo__textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u820A\u4EF6\u4FDD\u55AE\u865F\u78BC\uFF1A");
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 14, SpringLayout.EAST, NewPo__textField);
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel, 0, SpringLayout.SOUTH, label);
		add(lblNewLabel);
		
		OldPo__textField = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, OldPo__textField, -3, SpringLayout.NORTH, label);
		springLayout.putConstraint(SpringLayout.WEST, OldPo__textField, 6, SpringLayout.EAST, lblNewLabel);
		add(OldPo__textField);
		OldPo__textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("  \u9084\u672C\u9031\u5E74\u65E5\uFF1A");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 0, SpringLayout.NORTH, label);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_1, 23, SpringLayout.EAST, OldPo__textField);
		add(lblNewLabel_1);
		
		Ann_date__textField = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, Ann_date__textField, -3, SpringLayout.NORTH, label);
		springLayout.putConstraint(SpringLayout.WEST, Ann_date__textField, 6, SpringLayout.EAST, lblNewLabel_1);
		add(Ann_date__textField);
		Ann_date__textField.setColumns(10);
		
		JButton button = new JButton("\u67E5\u8A62");
		springLayout.putConstraint(SpringLayout.NORTH, button, -7, SpringLayout.NORTH, label);
		springLayout.putConstraint(SpringLayout.WEST, button, 27, SpringLayout.EAST, Ann_date__textField);
		springLayout.putConstraint(SpringLayout.SOUTH, button, 22, SpringLayout.NORTH, label);
		springLayout.putConstraint(SpringLayout.EAST, button, 94, SpringLayout.EAST, Ann_date__textField);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			  group01.removeAll();
			  group02.removeAll();
		      controller.executeMission(NewPo__textField.getText(), OldPo__textField.getText(), Ann_date__textField.getText());//查詢
			}
		});
		add(button);
		initDataBindings();
	}
	
	
	private class ListSelectionHandle implements ListSelectionListener {
	public void valueChanged(ListSelectionEvent arg0) {
		if (!((DefaultListSelectionModel) arg0.getSource()).getValueIsAdjusting()) {
	int i = table.getSelectedRow();			
			if(i != -1)
			{
//				if(((DefaultListSelectionModel)arg0.getSource()).getValueIsAdjusting() )
//				{
					String k_policy_no = group01.getPoReAssociate01().get(i).getM_policy_no(); //取[保單號碼]當KEY
	    			ValueReAssociate01Query rq = new ValueReAssociate01Query();
	    			
 	    			//------>舊件保單
	    			group02.removeAll();
					List<HashMap<String,String>> list2 = rq.getResultList2(k_policy_no, ValueReAssociate01Query.PoReQ02);				
					for (HashMap<String, String> hsmap2 : list2) {
						ValueReAssociate02 poreassociate02 = new ValueReAssociate02(hsmap2);
						group02.addPoReAssociate02(poreassociate02);
			        }
				}
			}
		}
	}
	
	public void setDefaultRow()
	{
		if (table.getRowCount() > 0)
		{	
		ListSelectionModel selectionModel =    table.getSelectionModel(); 
		selectionModel.setSelectionInterval(0, 0);
		}
	}
	
	public void setController(ValueReAssociateController controller){ //add
		this.controller = controller;
	}
	
	// 清空資料
		public void clearAll() {	
			group01.removeAll();
			group02.removeAll();
		}
		
		public void nullAll() {
			table = null;
			table_1 = null;
			controller = null;
			group01 = null;
			group02 = null;
			NewPo__textField = null;
			OldPo__textField = null;
		}
	
	//新增""至群組(PremQueryGroup)
	public void addPoReAssociate01(ValueReAssociate01 poreassociate01) {
		group01.addPoReAssociate01(poreassociate01);
	}	
	
	public void addPoReAssociate02(ValueReAssociate02 poreassociate02) {
		group02.addPoReAssociate02(poreassociate02);
	}	
	
	//清除群組中的所有組員(Group)
	public void clearPoReAssociate01s() {
		group01.removeAll();
	}
	
	public void clearPoReAssociate02s() {
		group02.removeAll();
	}
	protected void initDataBindings() {
		BeanProperty<ValueReAssociate01Group, List<ValueReAssociate01>> poReAssociate01GroupBeanProperty = BeanProperty.create("poReAssociate01");
		JTableBinding<ValueReAssociate01, ValueReAssociate01Group, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, group01, poReAssociate01GroupBeanProperty, table);
		//
		BeanProperty<ValueReAssociate01, String> poReAssociate01BeanProperty = BeanProperty.create("m_policy_no");
		jTableBinding.addColumnBinding(poReAssociate01BeanProperty).setColumnName("\u4FDD\u55AE\u865F\u78BC");
		//
		BeanProperty<ValueReAssociate01, String> poReAssociate01BeanProperty_1 = BeanProperty.create("m_plan_code");
		jTableBinding.addColumnBinding(poReAssociate01BeanProperty_1).setColumnName("\u65B0\u4EF6\u96AA\u7A2E");
		//
		BeanProperty<ValueReAssociate01, String> poReAssociate01BeanProperty_2 = BeanProperty.create("m_O1_name");
		jTableBinding.addColumnBinding(poReAssociate01BeanProperty_2).setColumnName("\u65B0\u4EF6\u8981\u4FDD\u4EBA");
		//
		BeanProperty<ValueReAssociate01, String> poReAssociate01BeanProperty_3 = BeanProperty.create("m_I1_name");
		jTableBinding.addColumnBinding(poReAssociate01BeanProperty_3).setColumnName("\u65B0\u4EF6\u88AB\u4FDD\u4EBA");
		//
		jTableBinding.bind();
		//
		BeanProperty<ValueReAssociate02Group, List<ValueReAssociate02>> poReAssociate02GroupBeanProperty = BeanProperty.create("poReAssociate02");
		JTableBinding<ValueReAssociate02, ValueReAssociate02Group, JTable> jTableBinding_1 = SwingBindings.createJTableBinding(UpdateStrategy.READ, group02, poReAssociate02GroupBeanProperty, table_1);
		//
		BeanProperty<ValueReAssociate02, String> poReAssociate02BeanProperty = BeanProperty.create("m_join_policy");
		jTableBinding_1.addColumnBinding(poReAssociate02BeanProperty).setColumnName("\u820A\u4EF6\u4FDD\u55AE");
		//
		BeanProperty<ValueReAssociate02, String> poReAssociate02BeanProperty_1 = BeanProperty.create("m_benf_name");
		jTableBinding_1.addColumnBinding(poReAssociate02BeanProperty_1).setColumnName("\u53D7\u76CA\u4EBA\u59D3\u540D");
		//
		BeanProperty<ValueReAssociate02, String> poReAssociate02BeanProperty_2 = BeanProperty.create("m_cp_anniv_date");
		jTableBinding_1.addColumnBinding(poReAssociate02BeanProperty_2).setColumnName("\u9084\u672C\u9031\u5E74\u65E5");
		//
		BeanProperty<ValueReAssociate02, String> poReAssociate02BeanProperty_3 = BeanProperty.create("m_cp_real_payamt");
		jTableBinding_1.addColumnBinding(poReAssociate02BeanProperty_3).setColumnName("\u5BE6\u4ED8\u91D1\u984D");
		//
		jTableBinding_1.bind();
	}
}
