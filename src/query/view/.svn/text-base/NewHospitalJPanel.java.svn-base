package query.view;
/**
 * @version 1.0
 * @author swei
 * 體檢醫院查詢畫面
 * 
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

import query.model.NewHospital.NewHospital01;
import query.model.NewHospital.NewHospital01Group;
import query.model.NewHospital.NewHospital02;
import query.model.NewHospital.NewHospital02Group;
import query.model.NewHospital.NewHospitalQuery;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.UIManager;
import javax.swing.JLabel;

public class NewHospitalJPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable NewHospital_table1;
	private JTable NewHospital_table2;
	private NewHospital01Group group01 = new NewHospital01Group();//add
	private NewHospital02Group group02 = new NewHospital02Group();//add
	private JTextField txt_search;

	/**
	 * Create the panel.
	 */
	public NewHospitalJPanel() {
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		final ButtonGroup bgroup = new ButtonGroup();
		
		JPanel panel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel, 0, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, this);
		add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{24, 93, 111, 0, 63, 183, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{29, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);

		final JComboBox Area_comboBox = new JComboBox();
		Area_comboBox.setEditable(true);
		Area_comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u6240\u6709\u5340\u57DF", "\u53F0\u5317", "\u4E2D\u58E2", "\u53F0\u4E2D", "\u5609\u7FA9", "\u53F0\u5357", "\u9AD8\u96C4", "\u5F70\u5316"}));
		Area_comboBox.setForeground(UIManager.getColor("Button.darkShadow"));
		Area_comboBox.setBackground(Color.WHITE);
		GridBagConstraints gbc_Area_comboBox = new GridBagConstraints();
		gbc_Area_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_Area_comboBox.insets = new Insets(0, 0, 0, 5);
		gbc_Area_comboBox.gridx = 2;
		gbc_Area_comboBox.gridy = 0;
		panel.add(Area_comboBox, gbc_Area_comboBox);
		
		final JRadioButton Single_RadioButton = new JRadioButton("\u5730\u5340\u9078\u64C7\uFF1A", true);
		GridBagConstraints gbc_Single_RadioButton = new GridBagConstraints();
		gbc_Single_RadioButton.insets = new Insets(0, 0, 0, 5);
		gbc_Single_RadioButton.gridx = 1;
		gbc_Single_RadioButton.gridy = 0;
		panel.add(Single_RadioButton, gbc_Single_RadioButton);
		bgroup.add(Single_RadioButton);
		
		Single_RadioButton.addActionListener(new ActionListener(){
			@Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                Area_comboBox.setEnabled(true);
            }
        });
		
		JPanel panel_1 = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel_1, 0, SpringLayout.SOUTH, panel);
		springLayout.putConstraint(SpringLayout.WEST, panel_1, 0, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, panel_1, 0, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, panel_1, 0, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.EAST, panel, 0, SpringLayout.EAST, panel_1);
				
				txt_search = new JTextField();
				txt_search.setColumns(400);
				txt_search.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent arg0) {
						txt_search.setToolTipText("\u95DC\u9375\u5B57\u67E5\u8A62");
					}

				});
				
				JLabel lblNewLabel = new JLabel("\u3000");
				GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
				gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
				gbc_lblNewLabel.gridx = 3;
				gbc_lblNewLabel.gridy = 0;
				panel.add(lblNewLabel, gbc_lblNewLabel);
				
				JLabel label = new JLabel("\u91AB\u9662\u540D\u7A31\uFF1A");
				GridBagConstraints gbc_label = new GridBagConstraints();
				gbc_label.insets = new Insets(0, 0, 0, 5);
				gbc_label.anchor = GridBagConstraints.EAST;
				gbc_label.gridx = 4;
				gbc_label.gridy = 0;
				panel.add(label, gbc_label);
				txt_search.setToolTipText("\u95DC\u9375\u5B57\u67E5\u8A62");
				txt_search.setHorizontalAlignment(SwingConstants.LEFT);
				
						txt_search.setForeground(new Color(105, 105, 105));
						GridBagConstraints gbc_txt_search = new GridBagConstraints();
						gbc_txt_search.fill = GridBagConstraints.HORIZONTAL;
						gbc_txt_search.insets = new Insets(0, 0, 0, 5);
						gbc_txt_search.gridx = 5;
						gbc_txt_search.gridy = 0;
						panel.add(txt_search, gbc_txt_search);
				
		
				JButton quiry_button = new JButton("\u67E5\u8A62");
				
				GridBagConstraints gbc_quiry_button = new GridBagConstraints();
				gbc_quiry_button.anchor = GridBagConstraints.WEST;
				gbc_quiry_button.gridx = 8;
				gbc_quiry_button.gridy = 0;
				panel.add(quiry_button, gbc_quiry_button);
				
				quiry_button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
	    		/**Menu_Listener**/
	    		 SwingUtilities.invokeLater(new Runnable() {
							public void run() {
								group02.removeAll();
								if (Single_RadioButton.isSelected()== true){
									int area_code = Area_comboBox.getSelectedIndex();//選擇地區
									if(area_code == 0)
									{}
									else
									{
						    		    if (area_code > 1) 
						    		        area_code=area_code+1;
						    		    if (area_code > 7) 
						    		        area_code=area_code+1;
									}
									NewHospitalQuery QRY_NewHospital01 = new NewHospitalQuery();
									List<HashMap<String,String>> list =
											QRY_NewHospital01.getResultList(String.valueOf(area_code),txt_search.getText(), NewHospitalQuery.NewHospital_HM);
							
									group01.removeAll();
									if(list.isEmpty())
									{
										JOptionPane.showMessageDialog (null, "查無訊息，請重新檢查輸入條件！", "提示", JOptionPane.INFORMATION_MESSAGE);
									}
									for (HashMap<String, String> hsmap : list) {
										NewHospital01 newhospital01 = new NewHospital01(hsmap);
										group01.addNewHospital01(newhospital01);
									}
								}
							
    				}
    			});
	    	 }
	    });
		add(panel_1);
		panel_1.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "\u9AD4\u6AA2\u91AB\u9662\u8CC7\u6599-\u9AD4\u6AA2\u91AB\u7642\u9662\u6240", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_2.add(scrollPane, BorderLayout.CENTER);
		
		NewHospital_table1 = new JTable();
		NewHospital_table1.setToolTipText("點擊以顯示下方明細");
		NewHospital_table1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(NewHospital_table1);
		NewHospital_table1.getSelectionModel().addListSelectionListener(new ListSelectionHandle());
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "\u9AD4\u6AA2\u91AB\u9662\u8CC7\u6599-\u9AD4\u6AA2\u9805\u76EE", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_3.add(scrollPane_1, BorderLayout.CENTER);
		
		NewHospital_table2 = new JTable();
		NewHospital_table2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_1.setViewportView(NewHospital_table2);
		initDataBindings();
		//---------------------------------------------------------------//		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumn headerCol1 = NewHospital_table1.getColumnModel().getColumn(0);
		headerCol1.setCellRenderer(centerRenderer);
		headerCol1.setMaxWidth(70); 
	  
		headerCol1 = NewHospital_table1.getColumnModel().getColumn(1);
		headerCol1.setPreferredWidth(100);

		headerCol1 = NewHospital_table1.getColumnModel().getColumn(2);
		headerCol1.setCellRenderer(centerRenderer);
		headerCol1.setMaxWidth(70); 
		
		headerCol1 = NewHospital_table1.getColumnModel().getColumn(3);
		headerCol1.setCellRenderer(centerRenderer);
		headerCol1.setMaxWidth(80); 
		
		headerCol1 = NewHospital_table1.getColumnModel().getColumn(4);
		headerCol1.setPreferredWidth(343);
		
		headerCol1 = NewHospital_table1.getColumnModel().getColumn(5);
		headerCol1.setMaxWidth(130); 
		headerCol1.setPreferredWidth(120);

		//---------------------------------------------------------------//		
		TableColumn headerCol2 = NewHospital_table2.getColumnModel().getColumn(0);
		headerCol2.setPreferredWidth(93); 
	  
		headerCol2 = NewHospital_table2.getColumnModel().getColumn(1);
		headerCol2.setPreferredWidth(93);

		headerCol2 = NewHospital_table2.getColumnModel().getColumn(2);
		headerCol2.setPreferredWidth(576);
	}
	        /**table1_Listener**/
			private class ListSelectionHandle implements ListSelectionListener {
			    public void valueChanged(ListSelectionEvent arg0) {
					if(((DefaultListSelectionModel)arg0.getSource()).getValueIsAdjusting() )
					{
				    	int i = NewHospital_table1.getSelectedRow();
				    	if(i != -1)
				    	{
							String k_hospital_id = group01.getNewHospital01().get(i).getM_hospital_id().toString();
							NewHospitalQuery QRY_NewHospital = new NewHospitalQuery();
							List<HashMap<String,String>> list =
									QRY_NewHospital.getResultList2(k_hospital_id.toString(), NewHospitalQuery.NewHospital_HC);
							group02.removeAll();
							for (HashMap<String, String> hsmap : list) {
								NewHospital02 newhospital02 = new NewHospital02(hsmap);
								group02.addNewHospital02(newhospital02);								
							}
				    	}
					}
			    }
			}

			
	// 清空資料
	public void clearAll() {
		group01.removeAll();
		group02.removeAll();
	}
	
	public void nullAll() {
		NewHospital_table1 = null;
		NewHospital_table2 = null;
		group01 = null;
		group02 = null;
	}
	/*-------------------------------*/
	/**
	 * 清除群組中的所有組員(NewHospital01)--01
	 */
	public void clearNewHospital01s() {
		// TODO Auto-generated method stub
		group01.removeAll();
	}
	
	/*-------------------------------*/
	/**
	 * 清除群組中的所有組員(NewHospital02)--01
	 */
	public void clearNewHospital02s() {
		// TODO Auto-generated method stub
		group02.removeAll();
	}
	/*-------------------------------*/
	/**
	 * 新增體檢原因資料至體檢原因群組(NewHospitalGroup)--01
	 * 
	 */	
	public void addNewHospital01(NewHospital01 newhospital01) {
		// TODO Auto-generated method stub
		group01.addNewHospital01(newhospital01);
	}
	
	public void setGroup01(NewHospital01Group group01) {
		this.group01 = group01;
	}
	protected void initDataBindings() {
		BeanProperty<NewHospital01Group, List<NewHospital01>> newHospital01GroupBeanProperty = BeanProperty.create("newHospital01");
		JTableBinding<NewHospital01, NewHospital01Group, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, group01, newHospital01GroupBeanProperty, NewHospital_table1);
		//
		BeanProperty<NewHospital01, String> newHospital01BeanProperty = BeanProperty.create("m_hospital_id");
		jTableBinding.addColumnBinding(newHospital01BeanProperty).setColumnName("\u4EE3\u78BC");
		//
		BeanProperty<NewHospital01, String> newHospital01BeanProperty_1 = BeanProperty.create("m_hospital_name");
		jTableBinding.addColumnBinding(newHospital01BeanProperty_1).setColumnName("\u91AB\u9662\u540D\u7A31");
		//
		BeanProperty<NewHospital01, String> newHospital01BeanProperty_2 = BeanProperty.create("m_hospital_hc");
		jTableBinding.addColumnBinding(newHospital01BeanProperty_2).setColumnName("\u5065\u6AA2");
		//
		BeanProperty<NewHospital01, String> newHospital01BeanProperty_3 = BeanProperty.create("m_assign");
		jTableBinding.addColumnBinding(newHospital01BeanProperty_3).setColumnName("\u6307\u5B9A\u91AB\u9662");
		//
		BeanProperty<NewHospital01, String> newHospital01BeanProperty_4 = BeanProperty.create("m_address");
		jTableBinding.addColumnBinding(newHospital01BeanProperty_4).setColumnName("\u5730\u5740");
		//
		BeanProperty<NewHospital01, String> newHospital01BeanProperty_5 = BeanProperty.create("m_tel");
		jTableBinding.addColumnBinding(newHospital01BeanProperty_5).setColumnName("\u96FB\u8A71");
		//
		BeanProperty<NewHospital01, String> newHospital01BeanProperty_6 = BeanProperty.create("m_area_name");
		jTableBinding.addColumnBinding(newHospital01BeanProperty_6).setColumnName("\u6240\u5C6C\u5730\u5340");
		//
		jTableBinding.setEditable(false);
		jTableBinding.bind();
		//
		BeanProperty<NewHospital02Group, List<NewHospital02>> newHospital02GroupBeanProperty = BeanProperty.create("newHospital02");
		JTableBinding<NewHospital02, NewHospital02Group, JTable> jTableBinding_1 = SwingBindings.createJTableBinding(UpdateStrategy.READ, group02, newHospital02GroupBeanProperty, NewHospital_table2);
		//
		BeanProperty<NewHospital02, String> newHospital02BeanProperty = BeanProperty.create("m_exam_item_code");
		jTableBinding_1.addColumnBinding(newHospital02BeanProperty).setColumnName("\u9AD4\u6AA2\u9805\u76EE");
		//
		BeanProperty<NewHospital02, String> newHospital02BeanProperty_1 = BeanProperty.create("m_exam_fee");
		jTableBinding_1.addColumnBinding(newHospital02BeanProperty_1).setColumnName("\u9AD4\u6AA2\u8CBB");
		//
		BeanProperty<NewHospital02, String> newHospital02BeanProperty_2 = BeanProperty.create("m_exam_item_desc");
		jTableBinding_1.addColumnBinding(newHospital02BeanProperty_2).setColumnName("\u9AD4\u6AA2\u9805\u76EE\u8AAA\u660E");
		//
		jTableBinding_1.setEditable(false);
		jTableBinding_1.bind();
	}
}
