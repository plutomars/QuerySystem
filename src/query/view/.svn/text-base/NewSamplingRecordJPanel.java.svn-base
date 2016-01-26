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
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.Bindings;
import org.jdesktop.beansbinding.ObjectProperty;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

import query.controller.NewSamplingRecordController;
import query.model.NewSamplingRecord.SamplingRecord;
import query.model.NewSamplingRecord.SamplingRecordList;
import query.model.NewSamplingRecord.SamplingRecordListGroup;
import org.jdesktop.beansbinding.ELProperty;

public class NewSamplingRecordJPanel extends JPanel {

	/**
	 * 抽檢記錄查詢
	 */
	private static final long serialVersionUID = 1L;
	private JTable samplingrecord_table;
	private JTextField txtAgentID;
	private JTextField withoutpay;
	private JTextField name;
	private NewSamplingRecordController controller;
	private SamplingRecord samplingRecord = new SamplingRecord();
	private SamplingRecordListGroup samplingRecordListGroup = new SamplingRecordListGroup();

	/**
	 * Create the panel.
	 */
	public NewSamplingRecordJPanel() {
		setLayout(new BorderLayout(0, 0));
		//panel 1
		JPanel SamplingJpanel = new JPanel();
		add(SamplingJpanel,"North");
		GridBagLayout gbl_SamplingJpanel = new GridBagLayout();
		gbl_SamplingJpanel.columnWidths = new int[] { 80, 80, 50, 80, 80, 40,
				0, 0 };
		gbl_SamplingJpanel.rowHeights = new int[] { 25, 0 };
		gbl_SamplingJpanel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_SamplingJpanel.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		SamplingJpanel.setLayout(gbl_SamplingJpanel);

		JLabel AgentId = new JLabel("\u696D\u52D9\u54E1ID");
		GridBagConstraints gbc_AgentId = new GridBagConstraints();
		gbc_AgentId.insets = new Insets(0, 0, 0, 5);
		gbc_AgentId.gridx = 0;
		gbc_AgentId.gridy = 0;
		SamplingJpanel.add(AgentId, gbc_AgentId);

		txtAgentID = new JTextField();
		GridBagConstraints gbc_txtAgentID = new GridBagConstraints();
		gbc_txtAgentID.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAgentID.anchor = GridBagConstraints.NORTH;
		gbc_txtAgentID.insets = new Insets(0, 0, 0, 5);
		gbc_txtAgentID.gridx = 1;
		gbc_txtAgentID.gridy = 0;
		SamplingJpanel.add(txtAgentID, gbc_txtAgentID);
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
		
		//button
		JButton JButton = new JButton("\u67E5\u8A62");
		GridBagConstraints gbc_JButton = new GridBagConstraints();
		gbc_JButton.gridx = 6;
		gbc_JButton.gridy = 0;

		SamplingJpanel.add(JButton, gbc_JButton);

		JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				samplingrecord_table.updateUI();
				txtAgentID.setText(txtAgentID.getText().toUpperCase());
//				cleanAll();
				controller.executeMission(txtAgentID.getText());
			}
		});

		JLabel Name = new JLabel("\u59D3\u540D");
		GridBagConstraints gbc_Name = new GridBagConstraints();
		gbc_Name.insets = new Insets(0, 0, 0, 5);
		gbc_Name.gridx = 2;
		gbc_Name.gridy = 0;
		SamplingJpanel.add(Name, gbc_Name);

		name = new JTextField();
		GridBagConstraints gbc_name = new GridBagConstraints();
		gbc_name.fill = GridBagConstraints.HORIZONTAL;
		gbc_name.insets = new Insets(0, 0, 0, 5);
		gbc_name.gridx = 3;
		gbc_name.gridy = 0;
		SamplingJpanel.add(name, gbc_name);
		name.setColumns(10);

		JLabel WithoutPay = new JLabel("\u8C41\u514D\u4E2D(Y/N)");
		GridBagConstraints gbc_WithoutPay = new GridBagConstraints();
		gbc_WithoutPay.insets = new Insets(0, 0, 0, 5);
		gbc_WithoutPay.gridx = 4;
		gbc_WithoutPay.gridy = 0;
		SamplingJpanel.add(WithoutPay, gbc_WithoutPay);

		withoutpay = new JTextField();
		GridBagConstraints gbc_withoutpay = new GridBagConstraints();
		gbc_withoutpay.insets = new Insets(0, 0, 0, 5);
		gbc_withoutpay.fill = GridBagConstraints.HORIZONTAL;
		gbc_withoutpay.anchor = GridBagConstraints.NORTH;
		gbc_withoutpay.gridx = 5;
		gbc_withoutpay.gridy = 0;
		SamplingJpanel.add(withoutpay, gbc_withoutpay);
		withoutpay.setColumns(10);
		
		//panel 2
		JPanel recordlistpanel = new JPanel();
		add(recordlistpanel,"Center");
		recordlistpanel.setLayout(new BorderLayout(0, 0));

		JScrollPane recordlist_scrollPane = new JScrollPane();
		recordlistpanel.add(recordlist_scrollPane);

		samplingrecord_table = new JTable();
		recordlist_scrollPane.setViewportView(samplingrecord_table);
		initDataBindings();

	}

	public SamplingRecord getSamplingRecord() {
		return samplingRecord;
	}
	public void setAG(String agentid) { //
        this.txtAgentID.setText(agentid);
		// samplingRecord.setValues(hsmap);
	}
	public void setValues(String withoutpay,String names) { //
        this.withoutpay.setText(withoutpay);
        this.name.setText(names);
		// samplingRecord.setValues(hsmap);
	}

	public void addsamplingRecordpanel(SamplingRecordList SamplingRecord) {
		samplingRecordListGroup.addSamplingRecordList(SamplingRecord);
	}

	public void clearAll() {
		samplingRecordListGroup.removeAll();
	}

	public void setController(NewSamplingRecordController controller) {
		this.controller = controller;

	}
	
	public void nullAll() {
		txtAgentID = null;
		withoutpay = null;
		name = null;
		samplingrecord_table = null;
		samplingRecord = null;
		samplingRecordListGroup =  null;
	}
		
	
	
	protected void initDataBindings() {
		BeanProperty<SamplingRecordListGroup, List<SamplingRecordList>> samplingRecordListGroupBeanProperty = BeanProperty.create("samplingRecordLists");
		JTableBinding<SamplingRecordList, SamplingRecordListGroup, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, samplingRecordListGroup, samplingRecordListGroupBeanProperty, samplingrecord_table, "samplingRecord");
		//
		BeanProperty<SamplingRecordList, String> samplingRecordListBeanProperty_2 = BeanProperty.create("r_policy_no");
		jTableBinding.addColumnBinding(samplingRecordListBeanProperty_2).setColumnName("\u4FDD\u55AE\u865F\u78BC");
		//
		ELProperty<SamplingRecordList, Object> samplingRecordListEvalutionProperty = ELProperty.create("${r_po_sts_code}  ${r_po_sts_desc}");
		jTableBinding.addColumnBinding(samplingRecordListEvalutionProperty).setColumnName("\u4FDD\u55AE\u72C0\u614B");
		//
		BeanProperty<SamplingRecordList, String> samplingRecordListBeanProperty = BeanProperty.create("r_app_input_date");
		jTableBinding.addColumnBinding(samplingRecordListBeanProperty).setColumnName("\u62BD\u6AA2\u65E5\u671F");
		//
		BeanProperty<SamplingRecordList, String> samplingRecordListBeanProperty_1 = BeanProperty.create("r_medical_desc");
		jTableBinding.addColumnBinding(samplingRecordListBeanProperty_1).setColumnName("\u9AD4\u6AA2\u72C0\u614B");
		//
		jTableBinding.bind();
	}
}
