package query.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

import query.controller.NewFaceAmountController;
import query.model.NewFaceAmount.NewFaceAmount01;
import query.model.NewFaceAmount.NewFaceAmount01Group;
import query.model.NewFaceAmount.NewFaceAmount02;
import query.model.NewFaceAmount.NewFaceAmount03;
import query.model.NewFaceAmount.NewFaceAmountIPA;
import query.model.NewFaceAmount.NewFaceAmountIPAGroup;

import javax.swing.JTabbedPane;
import java.awt.GridLayout;
import java.awt.Dimension;
import javax.swing.UIManager;
import org.jdesktop.beansbinding.ObjectProperty;
import javax.swing.JSplitPane;
import java.awt.ComponentOrientation;
/**
 * 
 * @author 陳冠瑜
 * 
 */
public class NewFaceAmountJPanel extends JPanel implements ListSelectionListener{ // 處理radioButton事件需:
													// implements ItemListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtField_age;
	private JTextField txtField_ag;
	private JTable table;
	private JTable tblPONO;
	private JTable tblIPA;  // IPA續保歷史資料查詢
	private JTable table_1; // 險種類別 俊豪
	private JLabel displbl;
	private JRadioButton radioButton1;
	private JRadioButton radioButton2;
	private JRadioButton radioButton3;
	private JButton searchbutton;
	private NewFaceAmountController controller;
	private NewFaceAmount01Group group01 = new NewFaceAmount01Group();
	private NewFaceAmount01Group groupPONO = new NewFaceAmount01Group();
	private NewFaceAmount01Group groupPLAN = new NewFaceAmount01Group();
	private NewFaceAmountIPAGroup groupIPA = new NewFaceAmountIPAGroup();
	private NewFaceAmount02 newfaceamount02 = new NewFaceAmount02();
	private NewFaceAmount03 newfaceamount03 = new NewFaceAmount03();
	public String occu_code, old_occu_code, ag_ind = "0";
	public Integer byy, bmm, bdd, nyy, nmm, ndd, age;
	private JTextArea textArea;
	private String i1_id, i1_name;
	private JTextField txtField_name;
	private JLabel label_id;
	private JTextField txtField_id;
	private JLabel label_name;
	private JTabbedPane tabbedPane;
	private JScrollPane scrollPane_1;
	private JScrollPane scrollPane_2;
	private JPanel panel_3;
	private JLabel label_1;
	private JTextField txtBirth;
	private JScrollPane scrollPane_3;
	private JScrollPane scrollPane_4;
	private JSplitPane splitPane;
//	private JSplitPane splitPane_1;

	/**
	 * Create the panel.
	 */
	public NewFaceAmountJPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0 };
		gridBagLayout.rowHeights = new int[] { 39, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);
		this.setSize(500, 600);
		// 單選radio button
		ButtonGroup bgroup = new ButtonGroup();
												
												panel_3 = new JPanel();
												panel_3.setMaximumSize(new Dimension(32767, 70));
												GridBagConstraints gbc_panel_3 = new GridBagConstraints();
												gbc_panel_3.insets = new Insets(0, 0, 5, 0);
												gbc_panel_3.fill = GridBagConstraints.BOTH;
												gbc_panel_3.gridx = 0;
												gbc_panel_3.gridy = 0;
												add(panel_3, gbc_panel_3);
												GridBagLayout gbl_panel_3 = new GridBagLayout();
												gbl_panel_3.columnWidths = new int[]{0, 83, 0, 85, 0, 81, 0};
												gbl_panel_3.rowHeights = new int[]{31, 0};
												gbl_panel_3.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
												gbl_panel_3.rowWeights = new double[]{0.0, Double.MIN_VALUE};
												panel_3.setLayout(gbl_panel_3);
												
												// 顯示被保人ID
												label_id = new JLabel("\u88AB\u4FDD\u4EBAID\uFF1A");
												GridBagConstraints gbc_label_id = new GridBagConstraints();
												gbc_label_id.insets = new Insets(0, 0, 0, 5);
												gbc_label_id.gridx = 0;
												gbc_label_id.gridy = 0;
												panel_3.add(label_id, gbc_label_id);
												
												txtField_id = new JTextField();
												GridBagConstraints gbc_txtField_id = new GridBagConstraints();
												gbc_txtField_id.fill = GridBagConstraints.HORIZONTAL;
												gbc_txtField_id.insets = new Insets(0, 0, 0, 5);
												gbc_txtField_id.gridx = 1;
												gbc_txtField_id.gridy = 0;
												panel_3.add(txtField_id, gbc_txtField_id);
												txtField_id.setForeground(Color.GRAY);
												txtField_id.setEditable(false);
												txtField_id.setColumns(7);
												//		i1_id = QueryFrame.policy_info[4];
												//		txtField_id.setText(i1_id);
														
														// 顯示被保人姓名
														label_name = new JLabel("\u88AB\u4FDD\u4EBA\u540D\uFF1A");
														GridBagConstraints gbc_label_name = new GridBagConstraints();
														gbc_label_name.insets = new Insets(0, 0, 0, 5);
														gbc_label_name.gridx = 2;
														gbc_label_name.gridy = 0;
														panel_3.add(label_name, gbc_label_name);
														
														txtField_name = new JTextField();
														GridBagConstraints gbc_txtField_name = new GridBagConstraints();
														gbc_txtField_name.insets = new Insets(0, 0, 0, 5);
														gbc_txtField_name.fill = GridBagConstraints.HORIZONTAL;
														gbc_txtField_name.gridx = 3;
														gbc_txtField_name.gridy = 0;
														panel_3.add(txtField_name, gbc_txtField_name);
														txtField_name.setEditable(false);
														txtField_name.setForeground(Color.GRAY);
														txtField_name.setColumns(5);
														
														label_1 = new JLabel("\u751F\u65E5\uFF1A");
														GridBagConstraints gbc_label_1 = new GridBagConstraints();
														gbc_label_1.insets = new Insets(0, 0, 0, 5);
														gbc_label_1.anchor = GridBagConstraints.EAST;
														gbc_label_1.gridx = 4;
														gbc_label_1.gridy = 0;
														panel_3.add(label_1, gbc_label_1);
														
														txtBirth = new JTextField();
														txtBirth.setEditable(false);
														GridBagConstraints gbc_txtBirth = new GridBagConstraints();
														gbc_txtBirth.anchor = GridBagConstraints.WEST;
														gbc_txtBirth.gridx = 5;
														gbc_txtBirth.gridy = 0;
														txtBirth.setForeground(Color.GRAY);
														panel_3.add(txtBirth, gbc_txtBirth);
														txtBirth.setColumns(10);
										
												tabbedPane = new JTabbedPane(JTabbedPane.TOP);
												GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
												gbc_tabbedPane.fill = GridBagConstraints.BOTH;
												gbc_tabbedPane.gridx = 0;
												gbc_tabbedPane.gridy = 1;
												tabbedPane.addChangeListener(new ChangeListener() {
													public void stateChanged(ChangeEvent arg0) {
														int tabSelect = tabbedPane.getSelectedIndex();
//														System.out.println(tabSelect);
														if (tabSelect> 0 )
														   controller.executeMissionTabValues(tabSelect);
													}
												});
												add(tabbedPane, gbc_tabbedPane);
												
												scrollPane_1 = new JScrollPane();
												tabbedPane.addTab("\u4FDD\u55AE\u865F\u78BC", null, scrollPane_1, null);
												
												splitPane = new JSplitPane();
												splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
												splitPane.setResizeWeight(0.5);
												scrollPane_1.setViewportView(splitPane);

												
												scrollPane_3 = new JScrollPane();
												splitPane.setLeftComponent(scrollPane_3);

												tblPONO = new JTable();
												scrollPane_3.setViewportView(tblPONO);
												ListSelectionModel model = tblPONO.getSelectionModel();
												model.addListSelectionListener(this);
												
												
												tblIPA = new JTable();
												scrollPane_4 = new JScrollPane();
												scrollPane_4.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "IPA\u7E8C\u4FDD\u6B77\u53F2\u8CC7\u6599\u67E5\u8A62", TitledBorder.LEADING, TitledBorder.TOP, null, null));
												scrollPane_4.setViewportView(tblIPA);
												splitPane.setRightComponent(scrollPane_4);
									

												
												scrollPane_2 = new JScrollPane();
												tabbedPane.addTab("\u96AA\u7A2E\u985E\u5225", null, scrollPane_2, null);
												
												table_1 = new JTable();
												scrollPane_2.setViewportView(table_1);
												
												JPanel panel = new JPanel();
												tabbedPane.addTab("累計保額", null, panel, null);
												
														panel.setBorder(new TitledBorder(null,
																"\u7D2F\u8A08\u4FDD\u984D\u67E5\u8A62", TitledBorder.LEADING,
																TitledBorder.TOP, null, null));
														GridBagLayout gbl_panel = new GridBagLayout();
														gbl_panel.columnWidths = new int[] { 70, 54, 23, 71, 86, 0, 0, 0 };
														gbl_panel.rowHeights = new int[] { 0, 0, 18, 0, 43, 0 };
														gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0 };
														gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0,
																Double.MIN_VALUE };
														panel.setLayout(gbl_panel);
																//		i1_name = QueryFrame.policy_info[5];
																//		txtField_name.setText(i1_name);
																
																		// 保險年齡
																		JLabel label_age = new JLabel("\u4FDD\u96AA\u5E74\u9F61\uFF1A");
																		GridBagConstraints gbc_label_age = new GridBagConstraints();
																		gbc_label_age.insets = new Insets(0, 5, 5, 5);
																		gbc_label_age.anchor = GridBagConstraints.WEST;
																		gbc_label_age.gridx = 0;
																		gbc_label_age.gridy = 0;
																		panel.add(label_age, gbc_label_age);
																		
																				txtField_age = new JTextField();
																				txtField_age.setForeground(Color.GRAY);
																				txtField_age.setEditable(false);
																				GridBagConstraints gbc_txtField_age = new GridBagConstraints();
																				gbc_txtField_age.gridwidth = 2;
																				gbc_txtField_age.fill = GridBagConstraints.HORIZONTAL;
																				gbc_txtField_age.insets = new Insets(0, 0, 5, 5);
																				gbc_txtField_age.gridx = 1;
																				gbc_txtField_age.gridy = 0;
																				panel.add(txtField_age, gbc_txtField_age);
																				txtField_age.setColumns(5);
																				
				// 職業代碼
				JLabel label_occu = new JLabel("\u8077\u696D\u4EE3\u78BC\uFF1A");
				GridBagConstraints gbc_label_occu = new GridBagConstraints();
				gbc_label_occu.anchor = GridBagConstraints.WEST;
				gbc_label_occu.insets = new Insets(0, 5, 5, 5);
				gbc_label_occu.gridx = 0;
				gbc_label_occu.gridy = 1;
				panel.add(label_occu, gbc_label_occu);
				
				// 輸入職業代碼
				txtField_ag = new JTextField();
				GridBagConstraints gbc_txtField_ag = new GridBagConstraints();
				gbc_txtField_ag.gridwidth = 2;
				gbc_txtField_ag.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtField_ag.insets = new Insets(0, 0, 5, 5);
				gbc_txtField_ag.gridx = 1;
				gbc_txtField_ag.gridy = 1;
				// textField按下enter後事件處理
				txtField_ag.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (!txtField_ag.getText().equals(old_occu_code)) {
					// 清空顯示職業代碼label
					displbl.setText(null);
					// 取得textField值
					occu_code = txtField_ag.getText();
					// 執行抓取職業代碼說明SQL
					controller.executeInnerMssion(occu_code);
					// 紀錄已查詢過職業代碼
					old_occu_code = occu_code;
					}
						}
					});
				
					panel.add(txtField_ag, gbc_txtField_ag);
					txtField_ag.setColumns(5);
					
					// 顯示職業代碼說明
					displbl = new JLabel();
					displbl.setForeground(Color.BLUE);
					GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
					gbc_lblNewLabel.gridwidth = 5;
					gbc_lblNewLabel.insets = new Insets(0, 5, 5, 0);
					gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
					gbc_lblNewLabel.gridx = 3;
					gbc_lblNewLabel.gridy = 1;
					panel.add(displbl, gbc_lblNewLabel);
					
					// 業務員招攬授權等級
					JLabel label_ag = new JLabel(
					"\u696D\u52D9\u54E1\u62DB\u652C\u6388\u6B0A\u7B49\u7D1A\uFF1A");
					GridBagConstraints gbc_label_ag = new GridBagConstraints();
					gbc_label_ag.anchor = GridBagConstraints.WEST;
					gbc_label_ag.gridwidth = 2;
					gbc_label_ag.insets = new Insets(0, 5, 5, 5);
					gbc_label_ag.gridx = 0;
					gbc_label_ag.gridy = 2;
					panel.add(label_ag, gbc_label_ag);
					
					radioButton1 = new JRadioButton("\u8CC7\u6DF1\u512A\u826F\u514D\u9AD4\u6AA2");
					radioButton1.setSelected(true);
					// radioButton使用事件-ItemListener必須註冊
					// radioButton1.addItemListener(this);
					GridBagConstraints gbc_radioButton = new GridBagConstraints();
					gbc_radioButton.anchor = GridBagConstraints.WEST;
					gbc_radioButton.gridwidth = 2;
					gbc_radioButton.insets = new Insets(0, 0, 5, 5);
					gbc_radioButton.gridx = 2;
					gbc_radioButton.gridy = 2;
					panel.add(radioButton1, gbc_radioButton);
					
					radioButton2 = new JRadioButton("\u512A\u826F\u514D\u9AD4\u6AA2");
					// radioButton使用事件-ItemListener必須註冊
					// radioButton2.addItemListener(this);
					GridBagConstraints gbc_rdbtnNewRadioButton = new GridBagConstraints();
					gbc_rdbtnNewRadioButton.insets = new Insets(0, 0, 5, 5);
					gbc_rdbtnNewRadioButton.anchor = GridBagConstraints.WEST;
					gbc_rdbtnNewRadioButton.gridx = 4;
					gbc_rdbtnNewRadioButton.gridy = 2;
					panel.add(radioButton2, gbc_rdbtnNewRadioButton);
					gbc_rdbtnNewRadioButton.insets = new Insets(0, 0, 5, 5);
					gbc_rdbtnNewRadioButton.anchor = GridBagConstraints.WEST;
					gbc_rdbtnNewRadioButton.gridx = 5;
					gbc_rdbtnNewRadioButton.gridy = 3;
					

															
					radioButton3 = new JRadioButton("\u4E00\u822C\u514D\u9AD4\u6AA2");
					// radioButton使用事件-ItemListener必須註冊
					// radioButton2.addItemListener(this);
					GridBagConstraints gbc_rdbtnNewRadioButton2 = new GridBagConstraints();
					gbc_rdbtnNewRadioButton2.insets = new Insets(0, 0, 5, 5);
					gbc_rdbtnNewRadioButton2.gridx = 5;
					gbc_rdbtnNewRadioButton2.gridy = 2;
					panel.add(radioButton3, gbc_rdbtnNewRadioButton2);
					bgroup.add(radioButton1);
					bgroup.add(radioButton2);
					bgroup.add(radioButton3);
					
				// 查詢按鈕
				searchbutton = new JButton("\u67E5\u8A62");
				GridBagConstraints gbc_button = new GridBagConstraints();
				gbc_button.anchor = GridBagConstraints.WEST;
				gbc_button.insets = new Insets(0, 0, 5, 5);
				gbc_button.gridx = 6;
				gbc_button.gridy = 2;
				// 查詢按鈕事件處理
				searchbutton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						// 取得textField值
						occu_code = txtField_ag.getText();
						// 取得radioButtton值
						// 在按下按鈕時取值則不需使用radioButton的事件-ItemListener
						String selectedid;
						if (radioButton1.isSelected()) {
							selectedid = "0";
						} else {
							if (radioButton2.isSelected())
								selectedid = "1";
							else	
								selectedid = "2";
						}
						ag_ind = selectedid;

						// 執行抓取職業代碼說明SQL
						if (!txtField_ag.getText().equals(old_occu_code)) {
							// 清空顯示職業代碼label
							displbl.setText(null);
							// 執行抓取職業代碼說明SQL
							controller.executeInnerMssion(occu_code);
							// 紀錄已查詢過職業代碼
							old_occu_code = occu_code;
						}

						// 執行累計保額查詢並塞值
						controller.executeInnerMission(ag_ind, occu_code);
					}
				});
				panel.add(searchbutton, gbc_button);
				
						JScrollPane scrollPane = new JScrollPane();
						GridBagConstraints gbc_scrollPane = new GridBagConstraints();
						gbc_scrollPane.gridwidth = 8;
						gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
						gbc_scrollPane.fill = GridBagConstraints.BOTH;
						gbc_scrollPane.gridx = 0;
						gbc_scrollPane.gridy = 3;
						panel.add(scrollPane, gbc_scrollPane);
						
								// 累計保額table資料
								table = new JTable();
								scrollPane.setViewportView(table);
								
										// 說明
										textArea = new JTextArea();
										textArea.setForeground(new Color(139, 0, 0));
										textArea.setBackground(new Color(224, 223, 227));
										textArea.setLineWrap(true);
										textArea.setText("\u8AAA\u660E\uFF1A\r\n1. \u672C\u7CFB\u7D71\u4E4B\u7D2F\u8A08\u58FD\u96AA\u4E3B\u9644\u7D04\u4FDD\u984D\u67E5\u8A62\u4E0D\u542B\u9023\u7D50\u6295\u8CC7\u96AA\u3002\u9AD4\u6AA2\u4FDD\u984D\u4E4B\u300C\u76EE\u524D\u5C1A\u53EF\u6295\u4FDD\u984D\u5EA6\u300D\u82E5\u70BA\u8CA0\u503C\uFF0C\u5247\u5C6C\u9AD4\u6AA2\u4EF6\uFF1B\u5176\u4ED6\u6B04\u4F4D\u82E5\u70BA\u8CA0\u503C\uFF0C\u5247\u8868\u793A\u5DF2\u7121\u53EF\u6295\u4FDD\u984D\u5EA6\u3002\r\n2.\u300C\u76EE\u524D\u5C1A\u53EF\u6295\u4FDD\u984D\u5EA6\u300D\u82E5\u70BA\u7A7A\u767D\uFF0C\u8ACB\u53C3\u7167\u7279\u6B8A\u8EAB\u4EFD\u500B\u5225\u9650\u5236\u8868\u3001\u4FDD\u96AA\u5E74\u9F61\u53CA\u5E74\u6536\u5165\u8207\u4FDD\u96AA\u91D1\u984D\u9650\u5236\u8868\u6216\u6D3D\u8A62\u5951\u7D04\u79D1\u3002");
										textArea.setEditable(false);
										GridBagConstraints gbc_textArea = new GridBagConstraints();
										gbc_textArea.gridwidth = 8;
										gbc_textArea.fill = GridBagConstraints.BOTH;
										gbc_textArea.gridx = 0;
										gbc_textArea.gridy = 4;
										panel.add(textArea, gbc_textArea);


		

		
		initDataBindings();

		// table數字靠右顯示(key:要加入super才會承襲原有table設定)
		// 寫法一
//		table.getColumnModel().getColumn(1).setCellRenderer(new DefaultTableCellRenderer() {
//			public Component getTableCellRendererComponent(
//					JTable table, Object value, boolean isSelected,
//					boolean hasFocus, int row, int column) {
//				JLabel label = (JLabel) super.getTableCellRendererComponent(table, value,
//								isSelected, hasFocus, row, column);
//				setHorizontalAlignment(JLabel.RIGHT);
//				setValue(value == null ? "" : value.toString());
//				return this;
//			}
//		});
		// 寫法二
//		DefaultTableCellRenderer renderer = new DefaultTableCellRenderer() {
//			/**
//			 * 
//			 */
//			private static final long serialVersionUID = 1L;
//
//			public Component getTableCellRendererComponent(JTable table,
//					Object value, boolean isSelected, boolean hasFocus,
//					int row, int col) {
//				JLabel label = (JLabel) super.getTableCellRendererComponent(
//						table, value, isSelected, hasFocus, row, col);
//				setHorizontalAlignment(JLabel.RIGHT);
//				setValue(value == null ? "" : value.toString());
//				return this;
//			}
//		};
		
		TableColumn headerCol;
		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		
		// 調整table欄位寬度
		table.getColumnModel().getColumn(0).setPreferredWidth(190);
		table.getColumnModel().getColumn(2).setPreferredWidth(30);
		table.getColumnModel().getColumn(4).setPreferredWidth(30);
		table.getColumnModel().getColumn(1).setCellRenderer(rightRenderer);
		table.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
		
		tblPONO.getColumnModel().getColumn(0).setPreferredWidth(20);
		tblPONO.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		tblPONO.getColumnModel().getColumn(2).setPreferredWidth(20);
		tblPONO.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		tblPONO.getColumnModel().getColumn(4).setPreferredWidth(20);
		tblPONO.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
		tblPONO.getColumnModel().getColumn(5).setPreferredWidth(20);
		tblPONO.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
		tblPONO.getColumnModel().getColumn(6).setCellRenderer(rightRenderer);
		tblPONO.getColumnModel().getColumn(7).setCellRenderer(centerRenderer);
		
		tblIPA.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		tblIPA.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		tblIPA.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);
		tblIPA.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
		tblIPA.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);
		
		table_1.getColumnModel().getColumn(1).setPreferredWidth(20);
//		table_1.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		table_1.getColumnModel().getColumn(3).setPreferredWidth(20);
//		table_1.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		table_1.getColumnModel().getColumn(4).setPreferredWidth(20);
//		table_1.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
//		table_1.getColumnModel().getColumn(5).setCellRenderer(rightRenderer);
//		table_1.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);
		
		table_1.setDefaultRenderer(Object.class,
				new DefaultTableCellRenderer() {
					/**
					 * 字體與其他相同,且變色的地方select會反白
					 */
					private static final long serialVersionUID = 1L;

					public Component getTableCellRendererComponent(
							JTable table, Object value, boolean isSelected,
							boolean hasFocus, int row, int col) {
						super.getTableCellRendererComponent(table, value,
								isSelected, hasFocus, row, col);
						try {
							String i = table.getModel()
									.getValueAt(row, 0).toString();
							if (i.equals("--有效小計--"))
								setBackground(new Color(220,220,220)
);
							else
								setBackground(Color.white);

							if (col == 1||col == 3||col==4||col==6){
								setHorizontalAlignment(SwingConstants.CENTER);
							}else if (col==5) 
								setHorizontalAlignment(SwingConstants.RIGHT);
							else
								setHorizontalAlignment(SwingConstants.LEFT);
							
									
							if (isSelected)
								setBackground(table.getSelectionBackground());

						} catch (Exception e) {
							return this;
						}
						setValue(value == null ? "" : value.toString());
						return this;
					}
				});
		
	}

	public void setDefaultValue(){
		i1_id = QueryFrame.policy_info[4];
		txtField_id.setText(i1_id);
		i1_name = QueryFrame.policy_info[5];
		txtField_name.setText(i1_name);
		tabbedPane.setSelectedIndex(2);
	}
	
	public void setController(NewFaceAmountController controller) {
		this.controller = controller;
	}

	public void addNewFaceAmount01(NewFaceAmount01 newfaceamount01) {
		group01.addNewFaceAmount01(newfaceamount01);
	}

	public void addNewPONO(NewFaceAmount01 newfaceamount01) {
		groupPONO.addNewFaceAmount01(newfaceamount01);
	}
	
	public void addNewPLAN(NewFaceAmount01 newfaceamount01) {
		groupPLAN.addNewFaceAmount01(newfaceamount01);
	}
	
	public void addNewIPA(NewFaceAmountIPA newfaceamountIPA) {
		groupIPA.addNewFaceAmountIPA(newfaceamountIPA);
	}
	
	public void clearNewFaceAmount01() {
		group01.removeAll();
	}
	
	public void clearNewPONO() {
		groupPONO.removeAll();
	}

	public void clearNewPLAN() {
		groupPLAN.removeAll();
	}
	
	public void clearNewIPA() {
		groupIPA.removeAll();
	}
	
	public void clearAll() {
		group01.removeAll();
		groupPONO.removeAll();
		groupPLAN.removeAll();
		groupIPA.removeAll();
	}
	
	public void nullAll() {
		txtField_age = null;
		txtField_ag = null;
		table = null;
		displbl = null;
		radioButton1 = null;
		radioButton2 = null;
		searchbutton = null;
		controller = null;
		group01 = null;
		groupPONO = null;
		groupPLAN = null;
		tblPONO = null;
		newfaceamount02 = null;
		newfaceamount03 = null;
		occu_code = null;
		old_occu_code = null;
		ag_ind = null;
		byy = null;
		bmm = null;
		bdd = null;
		nyy = null;
		nmm = null;
		ndd = null; 
		age = null;
		textArea = null;
	}
	
	public void setNewFaceAmount02(HashMap<String, String> hsmap) {
		newfaceamount02.setValues(hsmap);
		// 塞入畫面的職業代碼textField
		txtField_ag.setText(newfaceamount02.getR_occu_code());
		// 紀錄已查詢過職業代碼
		old_occu_code = txtField_ag.getText();

		// -----------計算被保人保險年齡-----------
		// 分離年、月、日
		byy = Integer
				.valueOf(newfaceamount02.getR_birth_date().substring(0, 3));
		bmm = Integer
				.valueOf(newfaceamount02.getR_birth_date().substring(4, 6));
		bdd = Integer
				.valueOf(newfaceamount02.getR_birth_date().substring(7, 9));
		nyy = Integer.valueOf(newfaceamount02.getR_today().substring(0, 3));
		nmm = Integer.valueOf(newfaceamount02.getR_today().substring(4, 6));
		ndd = Integer.valueOf(newfaceamount02.getR_today().substring(7, 9));
		// 計算年齡
		age = nyy - byy;
		if (nmm < bmm) {
			age = age - 1;
			nmm = nmm + 12;
		}
		if ((nmm - bmm > 6) || (nmm - bmm == 6 && ndd > bdd)) {
			age = age + 1;
		}
		if (age < 0) {
			age = 0;
		}
		// 塞入畫面的保險年齡
		txtField_age.setText(Integer.toString(age));
		txtBirth.setText(newfaceamount02.getR_birth_date());
	}

	public void setNewFaceAmount03(HashMap<String, String> hsmap) {
		newfaceamount03.setValues(hsmap);
		// 塞入畫面的職業代碼說明label
		displbl.setText(newfaceamount03.getR_occupation());

	}
	
	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		// TODO Auto-generated method stub
		if (!((DefaultListSelectionModel) arg0.getSource())
				.getValueIsAdjusting()) {
		int rowSelected = tblPONO.getSelectedRow();
		//有選擇資料
		if (rowSelected != -1) {
			if(groupPONO.getNewFaceAmount01s().get(rowSelected).getR_desc4().toString().equals("*"))
				controller.executeIPAMission(groupPONO.getNewFaceAmount01s().get(rowSelected).getR_unit_1().toString());
		}
		
	}}
	protected void initDataBindings() {
		BeanProperty<NewFaceAmount01Group, List<NewFaceAmount01>> newFaceAmount01GroupBeanProperty = BeanProperty.create("newFaceAmount01s");
		JTableBinding<NewFaceAmount01, NewFaceAmount01Group, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, group01, newFaceAmount01GroupBeanProperty, table);
		//
		BeanProperty<NewFaceAmount01, String> newFaceAmount01BeanProperty = BeanProperty.create("r_plan_desc");
		jTableBinding.addColumnBinding(newFaceAmount01BeanProperty).setColumnName("\u96AA\u7A2E\u985E\u5225");
		//
		BeanProperty<NewFaceAmount01, String> newFaceAmount01BeanProperty_1 = BeanProperty.create("r_face_amt");
		jTableBinding.addColumnBinding(newFaceAmount01BeanProperty_1).setColumnName("\u7D2F\u8A08\u4FDD\u984D");
		//
		BeanProperty<NewFaceAmount01, String> newFaceAmount01BeanProperty_2 = BeanProperty.create("r_unit_1");
		jTableBinding.addColumnBinding(newFaceAmount01BeanProperty_2).setColumnName("\u55AE\u4F4D");
		//
		BeanProperty<NewFaceAmount01, String> newFaceAmount01BeanProperty_3 = BeanProperty.create("r_avail_amt");
		jTableBinding.addColumnBinding(newFaceAmount01BeanProperty_3).setColumnName("\u76EE\u524D\u5C1A\u53EF\u6295\u4FDD\u984D\u5EA6");
		//
		BeanProperty<NewFaceAmount01, String> newFaceAmount01BeanProperty_4 = BeanProperty.create("r_unit_2");
		jTableBinding.addColumnBinding(newFaceAmount01BeanProperty_4).setColumnName("\u55AE\u4F4D");
		//
		jTableBinding.setEditable(false);
		jTableBinding.bind();
		//
		JTableBinding<NewFaceAmount01, NewFaceAmount01Group, JTable> jTableBinding_1 = SwingBindings.createJTableBinding(UpdateStrategy.READ, groupPONO, newFaceAmount01GroupBeanProperty, tblPONO);
		//
		BeanProperty<NewFaceAmount01, String> newFaceAmount01BeanProperty_5 = BeanProperty.create("r_desc4");
		jTableBinding_1.addColumnBinding(newFaceAmount01BeanProperty_5).setColumnName("\u7E8C\u4FDD").setEditable(false);
		//
		BeanProperty<NewFaceAmount01, String> newFaceAmount01BeanProperty_6 = BeanProperty.create("r_unit_1");
		jTableBinding_1.addColumnBinding(newFaceAmount01BeanProperty_6).setColumnName("\u4FDD\u55AE\u865F\u78BC").setEditable(false);
		//
		BeanProperty<NewFaceAmount01, String> newFaceAmount01BeanProperty_7 = BeanProperty.create("r_avail_amt");
		jTableBinding_1.addColumnBinding(newFaceAmount01BeanProperty_7).setColumnName("ST").setEditable(false);
		//
		BeanProperty<NewFaceAmount01, String> newFaceAmount01BeanProperty_8 = BeanProperty.create("r_plan_desc");
		jTableBinding_1.addColumnBinding(newFaceAmount01BeanProperty_8).setColumnName("\u96AA\u7A2E\u7C21\u7A31").setEditable(false);
		//
		BeanProperty<NewFaceAmount01, String> newFaceAmount01BeanProperty_9 = BeanProperty.create("r_desc3");
		jTableBinding_1.addColumnBinding(newFaceAmount01BeanProperty_9).setColumnName("\u7248\u6578").setEditable(false);
		//
		BeanProperty<NewFaceAmount01, String> newFaceAmount01BeanProperty_10 = BeanProperty.create("r_unit_2");
		jTableBinding_1.addColumnBinding(newFaceAmount01BeanProperty_10).setColumnName("st").setEditable(false);
		//
		BeanProperty<NewFaceAmount01, String> newFaceAmount01BeanProperty_11 = BeanProperty.create("r_face_amt");
		jTableBinding_1.addColumnBinding(newFaceAmount01BeanProperty_11).setColumnName("\u4FDD\u984D").setEditable(false);
		//
		BeanProperty<NewFaceAmount01, String> newFaceAmount01BeanProperty_12 = BeanProperty.create("r_desc2");
		jTableBinding_1.addColumnBinding(newFaceAmount01BeanProperty_12).setColumnName("\u751F\u6548\u65E5\u671F").setEditable(false);
		//
		jTableBinding_1.setEditable(false);
		jTableBinding_1.bind();
		//
		BeanProperty<NewFaceAmountIPAGroup, List<NewFaceAmountIPA>> newFaceAmountIPAGroupBeanProperty = BeanProperty.create("newFaceAmountIPAs");
		JTableBinding<NewFaceAmountIPA, NewFaceAmountIPAGroup, JTable> jTableBinding_2 = SwingBindings.createJTableBinding(UpdateStrategy.READ, groupIPA, newFaceAmountIPAGroupBeanProperty, tblIPA);
		//
		BeanProperty<NewFaceAmountIPA, String> newFaceAmountIPABeanProperty = BeanProperty.create("r_policy_no");
		jTableBinding_2.addColumnBinding(newFaceAmountIPABeanProperty).setColumnName("\u4FDD\u55AE\u865F\u78BC").setEditable(false);
		//
		BeanProperty<NewFaceAmountIPA, String> newFaceAmountIPABeanProperty_1 = BeanProperty.create("r_plan_code");
		jTableBinding_2.addColumnBinding(newFaceAmountIPABeanProperty_1).setColumnName("\u96AA\u7A2E").setEditable(false);
		//
		BeanProperty<NewFaceAmountIPA, String> newFaceAmountIPABeanProperty_2 = BeanProperty.create("r_rate_scale");
		jTableBinding_2.addColumnBinding(newFaceAmountIPABeanProperty_2).setColumnName("\u7248\u6578").setEditable(false);
		//
		BeanProperty<NewFaceAmountIPA, String> newFaceAmountIPABeanProperty_3 = BeanProperty.create("r_rate_occu");
		jTableBinding_2.addColumnBinding(newFaceAmountIPABeanProperty_3).setColumnName("\u8077\u7D1A").setEditable(false);
		//
		BeanProperty<NewFaceAmountIPA, String> newFaceAmountIPABeanProperty_4 = BeanProperty.create("r_face_amt");
		jTableBinding_2.addColumnBinding(newFaceAmountIPABeanProperty_4).setColumnName("\u4FDD\u984D").setEditable(false);
		//
		BeanProperty<NewFaceAmountIPA, String> newFaceAmountIPABeanProperty_5 = BeanProperty.create("r_co_issue_date");
		jTableBinding_2.addColumnBinding(newFaceAmountIPABeanProperty_5).setColumnName("\u751F\u6548\u65E5").setEditable(false);
		//
		BeanProperty<NewFaceAmountIPA, String> newFaceAmountIPABeanProperty_6 = BeanProperty.create("r_po_renew_cnt");
		jTableBinding_2.addColumnBinding(newFaceAmountIPABeanProperty_6).setColumnName("\u627F\u4FDD\u5E74\u5EA6").setEditable(false);
		//
		BeanProperty<NewFaceAmountIPA, String> newFaceAmountIPABeanProperty_7 = BeanProperty.create("r_note");
		jTableBinding_2.addColumnBinding(newFaceAmountIPABeanProperty_7).setColumnName("\u8A3B\u8A18").setEditable(false);
		//
		jTableBinding_2.setEditable(false);
		jTableBinding_2.bind();
		//
		JTableBinding<NewFaceAmount01, NewFaceAmount01Group, JTable> jTableBinding_3 = SwingBindings.createJTableBinding(UpdateStrategy.READ, groupPLAN, newFaceAmount01GroupBeanProperty, table_1);
		//
		BeanProperty<NewFaceAmount01, String> newFaceAmount01BeanProperty_13 = BeanProperty.create("r_unit_1");
		jTableBinding_3.addColumnBinding(newFaceAmount01BeanProperty_13).setColumnName("\u4FDD\u55AE\u865F\u78BC");
		//
		BeanProperty<NewFaceAmount01, String> newFaceAmount01BeanProperty_14 = BeanProperty.create("r_avail_amt");
		jTableBinding_3.addColumnBinding(newFaceAmount01BeanProperty_14).setColumnName("ST");
		//
		BeanProperty<NewFaceAmount01, String> newFaceAmount01BeanProperty_15 = BeanProperty.create("r_plan_desc");
		jTableBinding_3.addColumnBinding(newFaceAmount01BeanProperty_15).setColumnName("\u96AA\u7A2E\u7C21\u7A31");
		//
		BeanProperty<NewFaceAmount01, String> newFaceAmount01BeanProperty_16 = BeanProperty.create("r_desc3");
		jTableBinding_3.addColumnBinding(newFaceAmount01BeanProperty_16).setColumnName("\u7248\u6578");
		//
		BeanProperty<NewFaceAmount01, String> newFaceAmount01BeanProperty_17 = BeanProperty.create("r_unit_2");
		jTableBinding_3.addColumnBinding(newFaceAmount01BeanProperty_17).setColumnName("st");
		//
		BeanProperty<NewFaceAmount01, String> newFaceAmount01BeanProperty_18 = BeanProperty.create("r_face_amt");
		jTableBinding_3.addColumnBinding(newFaceAmount01BeanProperty_18).setColumnName("\u4FDD\u984D");
		//
		BeanProperty<NewFaceAmount01, String> newFaceAmount01BeanProperty_19 = BeanProperty.create("r_desc2");
		jTableBinding_3.addColumnBinding(newFaceAmount01BeanProperty_19).setColumnName("\u751F\u6548\u65E5\u671F");
		//
		jTableBinding_3.setEditable(false);
		jTableBinding_3.bind();
	}
}
