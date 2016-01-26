package query.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.TableColumn;

import query.model.PoExam.PoExam00;
import query.model.PoExam.PoExam00Group;
import query.model.PoExam.PoExam01;
import query.model.PoExam.PoExam01Group;
import query.model.PoExam.PoExam02;
import query.model.PoExam.PoExam02Group;
import query.model.PoExam.PoExam03;
import query.model.PoExam.PoExam03Group;

import java.awt.Color;
import org.jdesktop.beansbinding.BeanProperty;
import java.util.List;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;

/**
 * @version 1.0
 * @author swei
 * 體檢批註告知查詢
 * 
 */

public class PoExam01JPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable poexam01table;
	private JTable poexam02table;
	private JTable poexam03table;
	private JTable poexam00table;
	private PoExam00Group group00 = new PoExam00Group();//add
	private PoExam01Group group01 = new PoExam01Group();//add
	private PoExam02Group group02 = new PoExam02Group();//add
	private PoExam03Group group03 = new PoExam03Group();//add
	

	/**
	 * Create the panel.
	 */
	public PoExam01JPanel() {
		setForeground(Color.WHITE);
		setLayout(new GridLayout(4, 0, 0, 0));

		JPanel panel = new JPanel();//------(1)
		panel.setToolTipText("");
		panel.setBorder(new TitledBorder(null,"體檢原因資料",TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		poexam01table = new JTable();
		poexam01table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		JScrollPane poexam01scrollPane = new JScrollPane(poexam01table);
		panel.add(poexam01scrollPane);
		poexam01scrollPane.setViewportView(poexam01table);
		
		JPanel panel_1 = new JPanel();//------(2)
		panel_1.setBorder(new TitledBorder(null,"告知資料",TitledBorder.LEADING,	TitledBorder.TOP, null, null));
		add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		poexam02table = new JTable();
		poexam02table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		JScrollPane poexam02scrollPane = new JScrollPane();
		panel_1.add(poexam02scrollPane);		
		poexam02scrollPane.setViewportView(poexam02table);
	
		JPanel panel_2 = new JPanel();//------(3)
		panel_2.setBorder(new TitledBorder(null,"批註資料",TitledBorder.LEADING,	TitledBorder.TOP, null, null));
		add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		JScrollPane poexam03scrollPane = new JScrollPane();
		panel_2.add(poexam03scrollPane);
		
		poexam03table = new JTable();
		poexam03table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		poexam03scrollPane.setViewportView(poexam03table);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "\u5F31\u9AD4\u8CC7\u6599", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JScrollPane poexam00scrollPane = new JScrollPane();
		panel_3.add(poexam00scrollPane, BorderLayout.CENTER);
		
		poexam00table = new JTable();
		poexam00scrollPane.setViewportView(poexam00table);
		initDataBindings();
		
		
		//--體檢原因資料(欄位調整)
		TableColumn headerCol = poexam01table.getColumnModel().getColumn(0);
		headerCol.setPreferredWidth(50); 
	  
		headerCol = poexam01table.getColumnModel().getColumn(1);
		headerCol.setPreferredWidth(100);
		
		headerCol = poexam01table.getColumnModel().getColumn(2);
		headerCol.setPreferredWidth(50);
		
		headerCol = poexam01table.getColumnModel().getColumn(3);
		headerCol.setPreferredWidth(100);
		
		headerCol = poexam01table.getColumnModel().getColumn(4);
		headerCol.setPreferredWidth(423);
		
		//--告知資料(欄位調整)
		TableColumn headerCol2 = poexam02table.getColumnModel().getColumn(0);
		headerCol2.setPreferredWidth(50); 
	  
		headerCol2 = poexam02table.getColumnModel().getColumn(1);
		headerCol2.setPreferredWidth(100);
		
		headerCol2 = poexam02table.getColumnModel().getColumn(2);
		headerCol2.setPreferredWidth(100);
		
		headerCol2 = poexam02table.getColumnModel().getColumn(3);
		headerCol2.setPreferredWidth(100);
		
		headerCol2 = poexam02table.getColumnModel().getColumn(4);
		headerCol2.setPreferredWidth(100);
		
		headerCol2 = poexam02table.getColumnModel().getColumn(5);
		headerCol2.setPreferredWidth(523);
		
		headerCol2 = poexam02table.getColumnModel().getColumn(6);
		headerCol2.setPreferredWidth(107);
		
		//--批註資料(欄位調整)
		TableColumn headerCol3 = poexam03table.getColumnModel().getColumn(0);
		headerCol3.setPreferredWidth(50);
		
		headerCol3 = poexam03table.getColumnModel().getColumn(1);
		headerCol3.setPreferredWidth(100);
		
		headerCol3 = poexam03table.getColumnModel().getColumn(2);
		headerCol3.setPreferredWidth(50);
		
		headerCol3 = poexam03table.getColumnModel().getColumn(3);
		headerCol3.setPreferredWidth(100);
		
		headerCol3 = poexam03table.getColumnModel().getColumn(4);
		headerCol3.setPreferredWidth(100);
		
		headerCol3 = poexam03table.getColumnModel().getColumn(5);
		headerCol3.setPreferredWidth(70);
		
		headerCol3 = poexam03table.getColumnModel().getColumn(6);
		headerCol3.setPreferredWidth(185);
		
		headerCol3 = poexam03table.getColumnModel().getColumn(7);
		headerCol3.setPreferredWidth(67);
		
		//--體檢批註補告知(欄位調整)
		TableColumn headerCol4 = poexam00table.getColumnModel().getColumn(0);
		headerCol4.setPreferredWidth(20);
		
		headerCol4 = poexam00table.getColumnModel().getColumn(1);
		headerCol4.setPreferredWidth(60);
		
		headerCol4 = poexam00table.getColumnModel().getColumn(2);
		headerCol4.setPreferredWidth(60);
		
		headerCol4 = poexam00table.getColumnModel().getColumn(3);
		headerCol4.setPreferredWidth(60);
		
		headerCol4 = poexam00table.getColumnModel().getColumn(4);
		headerCol4.setPreferredWidth(60);
		
		headerCol4 = poexam00table.getColumnModel().getColumn(5);
		headerCol4.setPreferredWidth(280);
	}

	public void clearAll() {
		group00.removeAll();
		group01.removeAll();
		group02.removeAll();
		group03.removeAll();
	}
	
	public void nullAll() {
		poexam01table = null;
		poexam02table = null;
		poexam03table = null;
		poexam00table = null;
		group00 = null;
		group01 = null;
		group02 = null;
		group03 = null;
	}
	
	/**
	 * 新增體"檢原因資料"至體檢原因群組(PoExamGroup)
	 * 
	 */
	public void addPoExam01(PoExam01 poexam01) {
		group01.addPoExam01(poexam01);
	}
	
	/**
	 * 新增"告知資料"至告知資料群組(PoExamGroup)
	 * 
	 */	
	public void addPoExam02(PoExam02 poexam02) {
		group02.addPoExam02(poexam02);
	}
	
	/**
	 * 新增"批註資料"至批註資料群組(PoExamGroup)
	 * 
	 */
	public void addPoExam03(PoExam03 poexam03) {
		group03.addPoExam03(poexam03);
	}
	/**
	 * 新增"弱體資料"(PoExamGroup)
	 * 
	 */
	public void addPoExam00(PoExam00 poexam00) {
		group00.addPoExam00(poexam00);
	}
	
	/*-------------------------------------------*/	
	/**
	 * 清除群組中的所有組員(PoExamAGGroup)--01
	 */
	public void clearPoExam01s() {
		group01.removeAll();
	}
	
	/**
	 * 清除群組中的所有組員(PoExamAGGroup)--02
	 */
	public void clearPoExam02s() {
		group02.removeAll();
	}
	
	/**
	 * 清除群組中的所有組員(PoExamAGGroup)--03
	 */
	public void clearPoExam03s() {
		group03.removeAll();
	}
	
	/**
	 * 清除群組中的所有組員--04
	 */
	public void clearPoExam00s() {
		group00.removeAll();
	}
	protected void initDataBindings() {
		BeanProperty<PoExam01Group, List<PoExam01>> poExam01GroupBeanProperty = BeanProperty.create("poExam01s");
		JTableBinding<PoExam01, PoExam01Group, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, group01, poExam01GroupBeanProperty, poexam01table);
		//
		BeanProperty<PoExam01, String> poExam01BeanProperty = BeanProperty.create("m_client_ident");
		jTableBinding.addColumnBinding(poExam01BeanProperty).setColumnName("\u95DC\u4FC2");
		//
		BeanProperty<PoExam01, String> poExam01BeanProperty_1 = BeanProperty.create("m_client_id");
		jTableBinding.addColumnBinding(poExam01BeanProperty_1).setColumnName("\u8EAB\u5206\u8B49\u5B57\u865F");
		//
		BeanProperty<PoExam01, String> poExam01BeanProperty_2 = BeanProperty.create("m_names");
		jTableBinding.addColumnBinding(poExam01BeanProperty_2).setColumnName("\u59D3\u540D");
		//
		BeanProperty<PoExam01, String> poExam01BeanProperty_3 = BeanProperty.create("m_notify_date");
		jTableBinding.addColumnBinding(poExam01BeanProperty_3).setColumnName("\u7167\u6703\u65E5\u671F");
		//
		BeanProperty<PoExam01, String> poExam01BeanProperty_4 = BeanProperty.create("m_exam_reason");
		jTableBinding.addColumnBinding(poExam01BeanProperty_4).setColumnName("\u9AD4\u6AA2\u539F\u56E0");
		//
		jTableBinding.setEditable(false);
		jTableBinding.bind();
		//
		BeanProperty<PoExam02Group, List<PoExam02>> poExam02GroupBeanProperty = BeanProperty.create("poExam02");
		JTableBinding<PoExam02, PoExam02Group, JTable> jTableBinding_1 = SwingBindings.createJTableBinding(UpdateStrategy.READ, group02, poExam02GroupBeanProperty, poexam02table);
		//
		BeanProperty<PoExam02, String> poExam02BeanProperty = BeanProperty.create("m_client_ident");
		jTableBinding_1.addColumnBinding(poExam02BeanProperty).setColumnName("\u95DC\u4FC2");
		//
		BeanProperty<PoExam02, String> poExam02BeanProperty_1 = BeanProperty.create("m_receive_date");
		jTableBinding_1.addColumnBinding(poExam02BeanProperty_1).setColumnName("\u7167\u6703\u65E5\u671F");
		//
		BeanProperty<PoExam02, String> poExam02BeanProperty_2 = BeanProperty.create("m_receive_no");
		jTableBinding_1.addColumnBinding(poExam02BeanProperty_2).setColumnName("\u7167\u6703\u865F\u78BC");
		//
		BeanProperty<PoExam02, String> poExam02BeanProperty_3 = BeanProperty.create("m_client_id");
		jTableBinding_1.addColumnBinding(poExam02BeanProperty_3).setColumnName("\u8EAB\u5206\u8B49\u5B57\u865F");
		//
		BeanProperty<PoExam02, String> poExam02BeanProperty_4 = BeanProperty.create("m_names");
		jTableBinding_1.addColumnBinding(poExam02BeanProperty_4).setColumnName("\u59D3\u540D");
		//
		BeanProperty<PoExam02, String> poExam02BeanProperty_5 = BeanProperty.create("m_statement");
		jTableBinding_1.addColumnBinding(poExam02BeanProperty_5).setColumnName("\u544A\u77E5\u4E8B\u9805");
		//
		BeanProperty<PoExam02, String> poExam02BeanProperty_6 = BeanProperty.create("m_policy_no");
		jTableBinding_1.addColumnBinding(poExam02BeanProperty_6).setColumnName("\u76F8\u95DC\u4FDD\u55AE");
		//
		jTableBinding_1.setEditable(false);
		jTableBinding_1.bind();
		//
		BeanProperty<PoExam03Group, List<PoExam03>> poExam03GroupBeanProperty = BeanProperty.create("poExam03");
		JTableBinding<PoExam03, PoExam03Group, JTable> jTableBinding_2 = SwingBindings.createJTableBinding(UpdateStrategy.READ, group03, poExam03GroupBeanProperty, poexam03table);
		//
		BeanProperty<PoExam03, String> poExam03BeanProperty = BeanProperty.create("m_client_ident");
		jTableBinding_2.addColumnBinding(poExam03BeanProperty).setColumnName("\u95DC\u4FC2");
		//
		BeanProperty<PoExam03, String> poExam03BeanProperty_1 = BeanProperty.create("m_client_id");
		jTableBinding_2.addColumnBinding(poExam03BeanProperty_1).setColumnName("\u8EAB\u5206\u8B49\u5B57\u865F");
		//
		BeanProperty<PoExam03, String> poExam03BeanProperty_2 = BeanProperty.create("m_names");
		jTableBinding_2.addColumnBinding(poExam03BeanProperty_2).setColumnName("\u59D3\u540D");
		//
		BeanProperty<PoExam03, String> poExam03BeanProperty_3 = BeanProperty.create("m_process_date");
		jTableBinding_2.addColumnBinding(poExam03BeanProperty_3).setColumnName("\u6279\u8A3B\u65E5\u671F");
		//
		BeanProperty<PoExam03, String> poExam03BeanProperty_4 = BeanProperty.create("m_cancel_date");
		jTableBinding_2.addColumnBinding(poExam03BeanProperty_4).setColumnName("\u53D6\u6D88\u65E5\u671F");
		//
		BeanProperty<PoExam03, String> poExam03BeanProperty_5 = BeanProperty.create("m_cmnt_class");
		jTableBinding_2.addColumnBinding(poExam03BeanProperty_5).setColumnName("\u985E\u5225");
		//
		BeanProperty<PoExam03, String> poExam03BeanProperty_6 = BeanProperty.create("m_comments");
		jTableBinding_2.addColumnBinding(poExam03BeanProperty_6).setColumnName("\u6279\u8A3B\u5167\u5BB9");
		//
		BeanProperty<PoExam03, String> poExam03BeanProperty_7 = BeanProperty.create("m_cmnt_year");
		jTableBinding_2.addColumnBinding(poExam03BeanProperty_7).setColumnName("\u6279\u8A3B\u5E74\u9650");
		//
		jTableBinding_2.setEditable(false);
		jTableBinding_2.bind();
		//
		BeanProperty<PoExam00Group, List<PoExam00>> poExam00GroupBeanProperty = BeanProperty.create("poExam00");
		JTableBinding<PoExam00, PoExam00Group, JTable> jTableBinding_3 = SwingBindings.createJTableBinding(UpdateStrategy.READ, group00, poExam00GroupBeanProperty, poexam00table);
		//
		BeanProperty<PoExam00, String> poExam00BeanProperty = BeanProperty.create("m_client_ident");
		jTableBinding_3.addColumnBinding(poExam00BeanProperty).setColumnName("\u95DC\u4FC2").setEditable(false);
		//
		BeanProperty<PoExam00, String> poExam00BeanProperty_1 = BeanProperty.create("m_receive_date");
		jTableBinding_3.addColumnBinding(poExam00BeanProperty_1).setColumnName("\u53D7\u7406\u65E5\u671F");
		//
		BeanProperty<PoExam00, String> poExam00BeanProperty_2 = BeanProperty.create("m_receive_no");
		jTableBinding_3.addColumnBinding(poExam00BeanProperty_2).setColumnName("\u53D7\u7406\u865F\u78BC");
		//
		BeanProperty<PoExam00, String> poExam00BeanProperty_3 = BeanProperty.create("m_client_id");
		jTableBinding_3.addColumnBinding(poExam00BeanProperty_3).setColumnName("\u8EAB\u5206\u8B49\u5B57\u865F");
		//
		BeanProperty<PoExam00, String> poExam00BeanProperty_4 = BeanProperty.create("m_names");
		jTableBinding_3.addColumnBinding(poExam00BeanProperty_4).setColumnName("\u59D3\u540D");
		//
		BeanProperty<PoExam00, String> poExam00BeanProperty_5 = BeanProperty.create("m_statement");
		jTableBinding_3.addColumnBinding(poExam00BeanProperty_5).setColumnName("\u5F31\u9AD4");
		//
		BeanProperty<PoExam00, String> poExam00BeanProperty_6 = BeanProperty.create("m_policy_no");
		jTableBinding_3.addColumnBinding(poExam00BeanProperty_6).setColumnName("\u4FDD\u55AE\u865F\u78BC");
		//
		jTableBinding_3.setEditable(false);
		jTableBinding_3.bind();
	}
}
