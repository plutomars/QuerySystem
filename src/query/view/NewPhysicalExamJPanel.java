package query.view;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import query.controller.NewPhysicalExamController;
import query.controller.NewSamplingRecordController;
import query.model.NewPhysicalExam.NewPhysicalExam;
import query.model.NewPhysicalExam.NewPhysicalExamGroup;
import query.model.NewSamplingRecord.SamplingRecordList;
import org.jdesktop.beansbinding.BeanProperty;

import java.text.ParseException;
import java.util.List;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.ELProperty;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.text.MaskFormatter;

public class NewPhysicalExamJPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable examlist_table;
	private JTextField txtAgentID;
	private JLabel lblName;
	private JTextField month_textField;

	private NewPhysicalExamController controller;
	private NewPhysicalExam physicalExam ; //= new NewPhysicalExam();
	private NewPhysicalExamGroup physicalExamGroup = new NewPhysicalExamGroup();
	
	/**
	 * 體檢費扣佣查詢
	 * Cora
	 */
	public NewPhysicalExamJPanel() {
		setLayout(new BorderLayout(0, 0));
		//panel 1
		JPanel physical_panel1 = new JPanel();
		add(physical_panel1,"North");
		GridBagLayout gbl_physical_panel1 = new GridBagLayout();
		gbl_physical_panel1.columnWidths = new int[]{0, 68, 84, 9, 53, 78, 0};
		gbl_physical_panel1.rowHeights = new int[]{0, 0};
		gbl_physical_panel1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_physical_panel1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		physical_panel1.setLayout(gbl_physical_panel1);
		
		JLabel lblid = new JLabel("\u696D\u52D9\u54E1ID");
		GridBagConstraints gbc_lblid = new GridBagConstraints();
		gbc_lblid.insets = new Insets(0, 0, 0, 5);
		gbc_lblid.anchor = GridBagConstraints.EAST;
		gbc_lblid.gridx = 0;
		gbc_lblid.gridy = 0;
		physical_panel1.add(lblid, gbc_lblid);
		
		txtAgentID = new JTextField();
		GridBagConstraints gbc_txtAgentID = new GridBagConstraints();
		gbc_txtAgentID.anchor = GridBagConstraints.NORTH;
		gbc_txtAgentID.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAgentID.insets = new Insets(0, 0, 0, 5);
		gbc_txtAgentID.gridx = 1;
		gbc_txtAgentID.gridy = 0;
		physical_panel1.add(txtAgentID, gbc_txtAgentID);
		txtAgentID.setColumns(10);
		txtAgentID.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
//				if (e.getKeyCode() != KeyEvent.VK_ENTER) {
				//字串英文自動轉大寫
					txtAgentID.setText(txtAgentID.getText().toUpperCase());
//				}
			}
		});
		
		
		lblName = new JLabel("");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.anchor = GridBagConstraints.WEST;
		gbc_lblName.insets = new Insets(0, 0, 0, 5);
		gbc_lblName.gridx = 2;
		gbc_lblName.gridy = 0;
		physical_panel1.add(lblName, gbc_lblName);
		
		JLabel lblxxxxx = new JLabel("\u6263\u4F63\u6708\u4EFD");
		GridBagConstraints gbc_lblxxxxx = new GridBagConstraints();
		gbc_lblxxxxx.anchor = GridBagConstraints.EAST;
		gbc_lblxxxxx.insets = new Insets(0, 0, 0, 5);
		gbc_lblxxxxx.gridx = 3;
		gbc_lblxxxxx.gridy = 0;
		physical_panel1.add(lblxxxxx, gbc_lblxxxxx);
		//new JFormattedTextField(new MaskFormatter(
//	"###/##"));
//birthField.setText("000/00/00");
		try {
		month_textField = new JFormattedTextField(new MaskFormatter("###/##"));
		month_textField.setText("000/00");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		GridBagConstraints gbc_month_textField = new GridBagConstraints();
		gbc_month_textField.insets = new Insets(0, 0, 0, 5);
		gbc_month_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_month_textField.gridx = 4;
		gbc_month_textField.gridy = 0;
		physical_panel1.add(month_textField, gbc_month_textField);
		month_textField.setColumns(10);
		
		JButton btnQuery = new JButton("\u67E5\u8A62");
		GridBagConstraints gbc_btnQuery = new GridBagConstraints();
		gbc_btnQuery.gridx = 5;
		gbc_btnQuery.gridy = 0;
		physical_panel1.add(btnQuery, gbc_btnQuery);
		
		btnQuery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				examlist_table.updateUI();
				txtAgentID.setText(txtAgentID.getText().toUpperCase());
//				cleanAll();
				controller.executeMission(txtAgentID.getText(),month_textField.getText());
			}
		});
		//panel 2
		JPanel physical_panel2 = new JPanel();
		add(physical_panel2,"Center");
		physical_panel2.setLayout(new GridLayout(1, 0, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		physical_panel2.add(scrollPane);
		
		examlist_table = new JTable();
		scrollPane.setViewportView(examlist_table);
//		physical_panel2.add(examlist_table);
		initDataBindings();
		
		TableColumn headerCol;
		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		
		headerCol = examlist_table.getColumnModel().getColumn(0);		//被保險人ID
		headerCol.setCellRenderer(centerRenderer);
		headerCol.setMaxWidth(90);
		headerCol.setPreferredWidth(85);
		
		headerCol = examlist_table.getColumnModel().getColumn(1);		//姓名
		headerCol.setMaxWidth(90);
		
		headerCol = examlist_table.getColumnModel().getColumn(2);		//體檢日期
		headerCol.setCellRenderer(centerRenderer);
		headerCol.setMaxWidth(90);
		
		headerCol = examlist_table.getColumnModel().getColumn(3);		//保單號碼
		headerCol.setCellRenderer(centerRenderer);
		headerCol.setMaxWidth(100);
		
		headerCol = examlist_table.getColumnModel().getColumn(4);		//扣佣金額
		headerCol.setCellRenderer(rightRenderer);
		headerCol.setMaxWidth(90);
		
		headerCol = examlist_table.getColumnModel().getColumn(0);		//體檢原因
		headerCol.setMaxWidth(100);
	}
	
	public void setAG(String agentid) { //
        this.txtAgentID.setText(agentid);
		// samplingRecord.setValues(hsmap);
	}
	public void setValues(String names) { //
        this.lblName.setText(names);
		// samplingRecord.setValues(hsmap);
	}
	
	
	public void addNewPhysicalExampanel(NewPhysicalExam newPhysicalExam) {
		physicalExamGroup.addNewPhysicalExam(newPhysicalExam);
	}

	public void clearAll() {
		physicalExamGroup.removeAll();
	}
	
	public void setController(NewPhysicalExamController controller) {
		this.controller = controller;
	}
	
	/**
	 * 將全域變數全部指向NULL,利於JAVA記憶體回收系統回收記憶體
	 */
	public void nullAll() {
		examlist_table = null;
		physicalExam = null;
		physicalExamGroup = null;
		txtAgentID = null;
		lblName = null;
	}	
	
	protected void initDataBindings() {
		BeanProperty<NewPhysicalExamGroup, List<NewPhysicalExam>> newPhysicalExamGroupBeanProperty = BeanProperty.create("newPhysicalExam");
		JTableBinding<NewPhysicalExam, NewPhysicalExamGroup, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, physicalExamGroup, newPhysicalExamGroupBeanProperty, examlist_table, "examList");
		//
		BeanProperty<NewPhysicalExam, String> newPhysicalExamBeanProperty = BeanProperty.create("insured_id");
		jTableBinding.addColumnBinding(newPhysicalExamBeanProperty).setColumnName("\u88AB\u4FDD\u96AA\u4EBAID");
		//
		
		BeanProperty<NewPhysicalExam, String> newPhysicalExamBeanProperty_1 = BeanProperty.create("insured_name");
		jTableBinding.addColumnBinding(newPhysicalExamBeanProperty_1).setColumnName("\u59D3\u540D");
		//
		BeanProperty<NewPhysicalExam, String> newPhysicalExamBeanProperty_2 = BeanProperty.create("exam_date");
		jTableBinding.addColumnBinding(newPhysicalExamBeanProperty_2).setColumnName("\u9AD4\u6AA2\u65E5\u671F");
		//
		BeanProperty<NewPhysicalExam, String> newPhysicalExamBeanProperty_3 = BeanProperty.create("policy_no");
		jTableBinding.addColumnBinding(newPhysicalExamBeanProperty_3).setColumnName("\u4FDD\u55AE\u865F\u78BC");
		//
		BeanProperty<NewPhysicalExam, String> newPhysicalExamBeanProperty_4 = BeanProperty.create("exam_fee");
		jTableBinding.addColumnBinding(newPhysicalExamBeanProperty_4).setColumnName("\u6263\u4F63\u91D1\u984D");
		//
		BeanProperty<NewPhysicalExam, String> newPhysicalExamBeanProperty_5 = BeanProperty.create("exam_reason");
		jTableBinding.addColumnBinding(newPhysicalExamBeanProperty_5).setColumnName("\u9AD4\u6AA2\u539F\u56E0");
		//
		ELProperty<NewPhysicalExam, Object> newPhysicalExamEvalutionProperty = ELProperty.create("${agent_pay_ind} ${agent_pay_desc}");
		jTableBinding.addColumnBinding(newPhysicalExamEvalutionProperty).setColumnName("\u6263\u4F63\u539F\u56E0");
		//
		jTableBinding.bind();
	}
}
