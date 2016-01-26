package query.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.List;

import javax.swing.JLabel;
//import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
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

import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.Bindings;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

//import query.controller.MultiLineCellRenderer;
import query.controller.PoDetailController;
import query.model.PoDetail.PoDetailA;
import query.model.PoDetail.PoDetailComm;
import query.model.PoDetail.PoDetailECacct;
import query.model.PoDetail.PoDetailECacctGroup;
import query.model.PoDetail.PoDetailECinsured;
import query.model.PoDetail.PoDetailECinsuredGroup;
import query.model.PoDetail.PoDetailECpasswd;
import query.model.PoDetail.PoDetailECpasswdGroup;
import query.model.PoDetail.PoDetailECprint;
import query.model.PoDetail.PoDetailECprintGroup;
import query.model.PoDetail.PoDetailI;
import query.model.PoDetail.PoDetailIList;
import query.model.PoDetail.PoDetailIListGroup;
import query.model.PoDetail.PoDetailLFPA;
import query.model.PoDetail.PoDetailQuery;
import query.model.PoDetail.PoDetailTarget;
import query.model.PoDetail.PoDetailTargetGroup;
import query.model.PoDetail.PoDetailU;
import org.jdesktop.beansbinding.ELProperty;

//import org.jdesktop.beansbinding.ObjectProperty;
//import javax.swing.SwingConstants;

public class PoDetailJPanel extends JPanel implements ListSelectionListener {
	/**
	 * 保單明細
	 * 
	 * @author cora 100/08
	 * @category by銀保投資型新增
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtEmail;
	private JTextField txtPolicy_no;
	private JTextField txtPoStsCode;
	private JTextField txtModx;
	private JTextField txtMethod;
	private JTextField txtHomeTel;
	private JTextField txtMailTel;
	private JTextField txtCellNo;
	private JTextField txtMailAddr;
	private JTextField txtPrintDate;
	private JTextField txtInforceDate;
	private JTextField txtPoIssueDate;
	private JTextField txtApplyDate;
	private JTextField txtOwnerBirth;
	private JTextField txtOwnerName;
	private JTextField txtInsuredBirth;
	private JTextField txtInsuredName;
	private JTextField txtMailAddrSts;
	private JTextField txtEbilling;
	private JTextField txtLastOccu;
	private PoDetailComm poDetailComm = new PoDetailComm();
	private PoDetailLFPA poDetailLFPA = new PoDetailLFPA();
	private PoDetailI poDetailI = new PoDetailI();
	private PoDetailA poDetailA = new PoDetailA();
	private PoDetailU poDetailU = new PoDetailU();
	private VerticalPane detailVerticalPane1, detailVerticalPane2,
			detailVerticalPane3;
	private VerticalPane detailVerticalPane4, detailVerticalPane5,
			detailVerticalPane6, detailVerticalPane7;
	private JLabel lblPolicyNo;
	private JLabel lblEbilling;
	private JLabel lblCellNo;
	// private JTextField textCurrency;
	private JTextField txtHomeAddr;
	private JPanel panel_3;
	private JTabbedPane tabbedPane;
	private JTextField txtRowContent;
	private JPanel panel_6;
	private JPanel panel_7;
	private JPanel panel_4;
	private JTable Targettable;
	private JTable IListtable;
	private JTable Accttable;
	private JTable Passwdtable;
	private JTable Insuredtable;
	private JTable PWDprinttable;
	// private int panel_4_cnt = 0;

	private PoDetailTargetGroup TargetGroup = new PoDetailTargetGroup();
	private PoDetailIListGroup IListGroup = new PoDetailIListGroup();
	private PoDetailECacctGroup ECacctGroup = new PoDetailECacctGroup();
	private PoDetailECpasswdGroup ECpasswdGroup = new PoDetailECpasswdGroup();
	private PoDetailECinsuredGroup ECinsuredGroup = new PoDetailECinsuredGroup();
	private PoDetailECprintGroup ECprintGroup = new PoDetailECprintGroup();
	private JScrollPane scrollPane_3;

	private PoDetailController controller;

	private JLabel lblOwnerName;
	private JScrollPane scrollPane_4;
	private JScrollPane scrollPane_5;
	private JTabbedPane tabbedPane_1;
	private JScrollPane scrollPane_6;
	private JScrollPane scrollPane_7;
	private JLabel O1_income_label;
	private JLabel i1_come_label;
	private JLabel family_income_label;
	private JTextField o1_income_textField;
	private JTextField i1_income_textField;
	private JTextField family_income_textField;

	/**
	 * Create the panel.
	 */
	public PoDetailJPanel() {

		setLayout(new GridLayout(1, 0, 0, 0));

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane);

		// tab改變時 才去執行stored procedure
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				int tabSelect = tabbedPane.getSelectedIndex();
				if (tabSelect > 0)
					controller.executeMissionTabValues(tabSelect);
			}
		});
		scrollPane.setViewportView(tabbedPane);

		JScrollPane scrollPane_1 = new JScrollPane();
		tabbedPane.addTab("保單基本資料", null, scrollPane_1, null);

		JPanel panel_1 = new JPanel();
		scrollPane_1.setViewportView(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 424, 0 };
		// 自388增至413 for 年金coi欄位
		// gbl_panel_1.rowHeights = new int[]{0, 238, 388, 0};
		gbl_panel_1.rowHeights = new int[] { 0, 238, 413, 0 };
		gbl_panel_1.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		txtRowContent = new JTextField();
		GridBagConstraints gbc_txtRowContent = new GridBagConstraints();
		gbc_txtRowContent.insets = new Insets(0, 0, 5, 0);
		gbc_txtRowContent.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtRowContent.gridx = 0;
		gbc_txtRowContent.gridy = 0;
		panel_1.add(txtRowContent, gbc_txtRowContent);
		txtRowContent.setColumns(10);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "\u57FA\u672C\u8CC7\u6599",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 1;
		panel_1.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] { 0, 117, 0, 95, 0, 0, 0 };
		gbl_panel_2.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_2.columnWeights = new double[] { 0.0, 1.0, 0.0, 1.0, 0.0,
				1.0, Double.MIN_VALUE };
		gbl_panel_2.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_2.setLayout(gbl_panel_2);

		lblPolicyNo = new JLabel("\u4FDD\u55AE\u865F\u78BC");
		GridBagConstraints gbc_lblPolicyNo = new GridBagConstraints();
		gbc_lblPolicyNo.insets = new Insets(0, 0, 5, 5);
		gbc_lblPolicyNo.anchor = GridBagConstraints.WEST;
		gbc_lblPolicyNo.gridx = 0;
		gbc_lblPolicyNo.gridy = 0;
		panel_2.add(lblPolicyNo, gbc_lblPolicyNo);

		txtPolicy_no = new JTextField();
		txtPolicy_no.setBackground(Color.WHITE);
		txtPolicy_no.setEditable(false);
		txtPolicy_no.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				txtRowContent.setText(txtPolicy_no.getText());
			}
		});

		GridBagConstraints gbc_txtPolicy_no = new GridBagConstraints();
		gbc_txtPolicy_no.insets = new Insets(0, 0, 5, 5);
		gbc_txtPolicy_no.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPolicy_no.gridx = 1;
		gbc_txtPolicy_no.gridy = 0;
		panel_2.add(txtPolicy_no, gbc_txtPolicy_no);
		txtPolicy_no.setColumns(10);

		JLabel lblHomeAddr = new JLabel("\u5E8F\u865F/\u4F4F\u6240");
		GridBagConstraints gbc_lblHomeAddr = new GridBagConstraints();
		gbc_lblHomeAddr.anchor = GridBagConstraints.WEST;
		gbc_lblHomeAddr.insets = new Insets(0, 0, 5, 5);
		gbc_lblHomeAddr.gridx = 2;
		gbc_lblHomeAddr.gridy = 0;
		panel_2.add(lblHomeAddr, gbc_lblHomeAddr);

		txtHomeAddr = new JTextField();
		txtHomeAddr.setBackground(Color.WHITE);
		txtHomeAddr.setEditable(false);
		txtHomeAddr.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtRowContent.setText(txtHomeAddr.getText());
			}
		});
		txtHomeAddr.setColumns(10);
		GridBagConstraints gbc_txtHomeAddr = new GridBagConstraints();
		gbc_txtHomeAddr.insets = new Insets(0, 0, 5, 5);
		gbc_txtHomeAddr.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtHomeAddr.gridx = 3;
		gbc_txtHomeAddr.gridy = 0;
		panel_2.add(txtHomeAddr, gbc_txtHomeAddr);

		JLabel lblOwnerID = new JLabel("\u8981\u4FDD\u4EBAID/\u751F\u65E5");
		GridBagConstraints gbc_lblOwnerID = new GridBagConstraints();
		gbc_lblOwnerID.anchor = GridBagConstraints.WEST;
		gbc_lblOwnerID.insets = new Insets(0, 0, 5, 5);
		gbc_lblOwnerID.gridx = 4;
		gbc_lblOwnerID.gridy = 0;
		panel_2.add(lblOwnerID, gbc_lblOwnerID);

		txtOwnerBirth = new JTextField();
		txtOwnerBirth.setBackground(Color.WHITE);
		txtOwnerBirth.setEditable(false);
		txtOwnerBirth.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtRowContent.setText(txtOwnerBirth.getText());
			}
		});
		txtOwnerBirth.setColumns(10);
		GridBagConstraints gbc_txtOwnerBirth = new GridBagConstraints();
		gbc_txtOwnerBirth.insets = new Insets(0, 0, 5, 0);
		gbc_txtOwnerBirth.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtOwnerBirth.gridx = 5;
		gbc_txtOwnerBirth.gridy = 0;
		panel_2.add(txtOwnerBirth, gbc_txtOwnerBirth);

		JLabel lblPoStsCode = new JLabel("\u72C0\u614B");
		GridBagConstraints gbc_lblPoStsCode = new GridBagConstraints();
		gbc_lblPoStsCode.insets = new Insets(0, 0, 5, 5);
		gbc_lblPoStsCode.anchor = GridBagConstraints.WEST;
		gbc_lblPoStsCode.gridx = 0;
		gbc_lblPoStsCode.gridy = 1;
		panel_2.add(lblPoStsCode, gbc_lblPoStsCode);

		txtPoStsCode = new JTextField();
		txtPoStsCode.setEditable(false);
		txtPoStsCode.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				txtRowContent.setText(txtPoStsCode.getText());
			}
		});
		txtPoStsCode.setColumns(10);
		GridBagConstraints gbc_txtPoStsCode = new GridBagConstraints();
		gbc_txtPoStsCode.insets = new Insets(0, 0, 5, 5);
		gbc_txtPoStsCode.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPoStsCode.gridx = 1;
		gbc_txtPoStsCode.gridy = 1;
		panel_2.add(txtPoStsCode, gbc_txtPoStsCode);

		JLabel lblHomeTel = new JLabel("\u4F4F\u6240\u96FB\u8A71");
		GridBagConstraints gbc_lblHomeTel = new GridBagConstraints();
		gbc_lblHomeTel.insets = new Insets(0, 0, 5, 5);
		gbc_lblHomeTel.anchor = GridBagConstraints.WEST;
		gbc_lblHomeTel.gridx = 2;
		gbc_lblHomeTel.gridy = 1;
		panel_2.add(lblHomeTel, gbc_lblHomeTel);

		txtHomeTel = new JTextField();
		txtHomeTel.setBackground(Color.WHITE);
		txtHomeTel.setEditable(false);
		txtHomeTel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtRowContent.setText(txtHomeTel.getText());
			}
		});
		txtHomeTel.setColumns(10);
		GridBagConstraints gbc_txtHomeTel = new GridBagConstraints();
		gbc_txtHomeTel.insets = new Insets(0, 0, 5, 5);
		gbc_txtHomeTel.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtHomeTel.gridx = 3;
		gbc_txtHomeTel.gridy = 1;
		panel_2.add(txtHomeTel, gbc_txtHomeTel);

		lblOwnerName = new JLabel(
				"\u8981\u4FDD\u4EBA/\u6027\u5225/\u7C3D\u6A23");
		GridBagConstraints gbc_lblOwnerName = new GridBagConstraints();
		gbc_lblOwnerName.anchor = GridBagConstraints.WEST;
		gbc_lblOwnerName.insets = new Insets(0, 0, 5, 5);
		gbc_lblOwnerName.gridx = 4;
		gbc_lblOwnerName.gridy = 1;
		panel_2.add(lblOwnerName, gbc_lblOwnerName);

		txtOwnerName = new JTextField();
		txtOwnerName.setBackground(Color.WHITE);
		txtOwnerName.setEditable(false);
		txtOwnerName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtRowContent.setText(txtOwnerName.getText());
			}
		});
		txtOwnerName.setColumns(10);
		GridBagConstraints gbc_txtOwnerName = new GridBagConstraints();
		gbc_txtOwnerName.insets = new Insets(0, 0, 5, 0);
		gbc_txtOwnerName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtOwnerName.gridx = 5;
		gbc_txtOwnerName.gridy = 1;
		panel_2.add(txtOwnerName, gbc_txtOwnerName);

		JLabel lblModx = new JLabel("\u7E73\u5225");
		GridBagConstraints gbc_lblModx = new GridBagConstraints();
		gbc_lblModx.insets = new Insets(0, 0, 5, 5);
		gbc_lblModx.anchor = GridBagConstraints.WEST;
		gbc_lblModx.gridx = 0;
		gbc_lblModx.gridy = 2;
		panel_2.add(lblModx, gbc_lblModx);

		txtModx = new JTextField();
		txtModx.setBackground(Color.WHITE);
		txtModx.setEditable(false);
		txtModx.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtRowContent.setText(txtModx.getText());
			}
		});
		txtModx.setColumns(10);
		GridBagConstraints gbc_txtModx = new GridBagConstraints();
		gbc_txtModx.insets = new Insets(0, 0, 5, 5);
		gbc_txtModx.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtModx.gridx = 1;
		gbc_txtModx.gridy = 2;
		panel_2.add(txtModx, gbc_txtModx);

		JLabel lblMailAddr = new JLabel("\u5E8F\u865F/\u6536\u8CBB");
		GridBagConstraints gbc_lblMailAddr = new GridBagConstraints();
		gbc_lblMailAddr.insets = new Insets(0, 0, 5, 5);
		gbc_lblMailAddr.anchor = GridBagConstraints.WEST;
		gbc_lblMailAddr.gridx = 2;
		gbc_lblMailAddr.gridy = 2;
		panel_2.add(lblMailAddr, gbc_lblMailAddr);

		txtMailAddr = new JTextField();
		txtMailAddr.setBackground(Color.WHITE);
		txtMailAddr.setEditable(false);
		txtMailAddr.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtRowContent.setText(txtMailAddr.getText());
			}
		});
		txtMailAddr.setColumns(10);
		GridBagConstraints gbc_txtMailAddr = new GridBagConstraints();
		gbc_txtMailAddr.insets = new Insets(0, 0, 5, 5);
		gbc_txtMailAddr.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMailAddr.gridx = 3;
		gbc_txtMailAddr.gridy = 2;
		panel_2.add(txtMailAddr, gbc_txtMailAddr);

		JLabel lblInsuredID = new JLabel(
				"\u88AB\u4FDD\u96AA\u4EBAID/\u751F\u65E5");
		GridBagConstraints gbc_lblInsuredID = new GridBagConstraints();
		gbc_lblInsuredID.anchor = GridBagConstraints.WEST;
		gbc_lblInsuredID.insets = new Insets(0, 0, 5, 5);
		gbc_lblInsuredID.gridx = 4;
		gbc_lblInsuredID.gridy = 2;
		panel_2.add(lblInsuredID, gbc_lblInsuredID);

		txtInsuredBirth = new JTextField();
		txtInsuredBirth.setBackground(Color.WHITE);
		txtInsuredBirth.setEditable(false);
		txtInsuredBirth.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtRowContent.setText(txtInsuredBirth.getText());
			}
		});
		txtInsuredBirth.setColumns(10);
		GridBagConstraints gbc_txtInsuredBirth = new GridBagConstraints();
		gbc_txtInsuredBirth.insets = new Insets(0, 0, 5, 0);
		gbc_txtInsuredBirth.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtInsuredBirth.gridx = 5;
		gbc_txtInsuredBirth.gridy = 2;
		panel_2.add(txtInsuredBirth, gbc_txtInsuredBirth);

		JLabel lblMethod = new JLabel("\u6536\u8CBB\u65B9\u5F0F");
		GridBagConstraints gbc_lblMethod = new GridBagConstraints();
		gbc_lblMethod.insets = new Insets(0, 0, 5, 5);
		gbc_lblMethod.anchor = GridBagConstraints.WEST;
		gbc_lblMethod.gridx = 0;
		gbc_lblMethod.gridy = 3;
		panel_2.add(lblMethod, gbc_lblMethod);

		txtMethod = new JTextField();
		txtMethod.setBackground(Color.WHITE);
		txtMethod.setEditable(false);
		txtMethod.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				txtRowContent.setText(txtMethod.getText());
			}
		});
		txtMethod.setColumns(10);
		GridBagConstraints gbc_txtMethod = new GridBagConstraints();
		gbc_txtMethod.insets = new Insets(0, 0, 5, 5);
		gbc_txtMethod.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMethod.gridx = 1;
		gbc_txtMethod.gridy = 3;
		panel_2.add(txtMethod, gbc_txtMethod);

		JLabel lblMailTel = new JLabel("\u6536\u8CBB\u96FB\u8A71");
		GridBagConstraints gbc_lblMailTel = new GridBagConstraints();
		gbc_lblMailTel.insets = new Insets(0, 0, 5, 5);
		gbc_lblMailTel.anchor = GridBagConstraints.WEST;
		gbc_lblMailTel.gridx = 2;
		gbc_lblMailTel.gridy = 3;
		panel_2.add(lblMailTel, gbc_lblMailTel);

		txtMailTel = new JTextField();
		txtMailTel.setBackground(Color.WHITE);
		txtMailTel.setEditable(false);
		txtMailTel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtRowContent.setText(txtMailTel.getText());
			}
		});
		GridBagConstraints gbc_txtMailTel = new GridBagConstraints();
		gbc_txtMailTel.insets = new Insets(0, 0, 5, 5);
		gbc_txtMailTel.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMailTel.gridx = 3;
		gbc_txtMailTel.gridy = 3;
		panel_2.add(txtMailTel, gbc_txtMailTel);
		txtMailTel.setColumns(10);

		JLabel lblInsuredName = new JLabel(
				"\u88AB\u4FDD\u96AA\u4EBA/\u6027\u5225/\u7C3D\u6A23");
		GridBagConstraints gbc_lblInsuredName = new GridBagConstraints();
		gbc_lblInsuredName.anchor = GridBagConstraints.WEST;
		gbc_lblInsuredName.insets = new Insets(0, 0, 5, 5);
		gbc_lblInsuredName.gridx = 4;
		gbc_lblInsuredName.gridy = 3;
		panel_2.add(lblInsuredName, gbc_lblInsuredName);

		txtInsuredName = new JTextField();
		txtInsuredName.setBackground(Color.WHITE);
		txtInsuredName.setEditable(false);
		txtInsuredName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtRowContent.setText(txtInsuredName.getText());
			}
		});
		txtInsuredName.setColumns(10);
		GridBagConstraints gbc_txtInsuredName = new GridBagConstraints();
		gbc_txtInsuredName.insets = new Insets(0, 0, 5, 0);
		gbc_txtInsuredName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtInsuredName.gridx = 5;
		gbc_txtInsuredName.gridy = 3;
		panel_2.add(txtInsuredName, gbc_txtInsuredName);

		JLabel lblApplyDate = new JLabel("\u8981\u4FDD\u65E5");
		GridBagConstraints gbc_lblApplyDate = new GridBagConstraints();
		gbc_lblApplyDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblApplyDate.anchor = GridBagConstraints.WEST;
		gbc_lblApplyDate.gridx = 0;
		gbc_lblApplyDate.gridy = 4;
		panel_2.add(lblApplyDate, gbc_lblApplyDate);

		txtApplyDate = new JTextField();
		txtApplyDate.setBackground(Color.WHITE);
		txtApplyDate.setEditable(false);
		txtApplyDate.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				txtRowContent.setText(txtApplyDate.getText());
			}
		});
		txtApplyDate.setColumns(10);
		GridBagConstraints gbc_txtApplyDate = new GridBagConstraints();
		gbc_txtApplyDate.insets = new Insets(0, 0, 5, 5);
		gbc_txtApplyDate.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtApplyDate.gridx = 1;
		gbc_txtApplyDate.gridy = 4;
		panel_2.add(txtApplyDate, gbc_txtApplyDate);

		lblCellNo = new JLabel("\u5217\u7BA1/\u624B\u6A5F");
		GridBagConstraints gbc_lblCellNo = new GridBagConstraints();
		gbc_lblCellNo.insets = new Insets(0, 0, 5, 5);
		gbc_lblCellNo.anchor = GridBagConstraints.WEST;
		gbc_lblCellNo.gridx = 2;
		gbc_lblCellNo.gridy = 4;
		panel_2.add(lblCellNo, gbc_lblCellNo);

		txtCellNo = new JTextField();
		txtCellNo.setBackground(Color.WHITE);
		txtCellNo.setEditable(false);
		txtCellNo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtRowContent.setText(txtCellNo.getText());
			}
		});
		txtCellNo.setColumns(10);
		GridBagConstraints gbc_txtCellNo = new GridBagConstraints();
		gbc_txtCellNo.insets = new Insets(0, 0, 5, 5);
		gbc_txtCellNo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCellNo.gridx = 3;
		gbc_txtCellNo.gridy = 4;
		panel_2.add(txtCellNo, gbc_txtCellNo);

		JLabel lblMailAddrSts = new JLabel(
				"\u6536\u8CBB\u5730\u5740\u72C0\u614B/\u5217\u7BA1 ");
		GridBagConstraints gbc_lblMailAddrSts = new GridBagConstraints();
		gbc_lblMailAddrSts.anchor = GridBagConstraints.WEST;
		gbc_lblMailAddrSts.insets = new Insets(0, 0, 5, 5);
		gbc_lblMailAddrSts.gridx = 4;
		gbc_lblMailAddrSts.gridy = 4;
		panel_2.add(lblMailAddrSts, gbc_lblMailAddrSts);

		txtMailAddrSts = new JTextField();
		txtMailAddrSts.setBackground(Color.WHITE);
		txtMailAddrSts.setEditable(false);
		txtMailAddrSts.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtRowContent.setText(txtMailAddrSts.getText());
			}
		});
		txtMailAddrSts.setColumns(10);
		GridBagConstraints gbc_txtMailAddrSts = new GridBagConstraints();
		gbc_txtMailAddrSts.insets = new Insets(0, 0, 5, 0);
		gbc_txtMailAddrSts.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMailAddrSts.gridx = 5;
		gbc_txtMailAddrSts.gridy = 4;
		panel_2.add(txtMailAddrSts, gbc_txtMailAddrSts);

		JLabel lblPoIssueDate = new JLabel("\u751F\u6548\u65E5");
		GridBagConstraints gbc_lblPoIssueDate = new GridBagConstraints();
		gbc_lblPoIssueDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblPoIssueDate.anchor = GridBagConstraints.WEST;
		gbc_lblPoIssueDate.gridx = 0;
		gbc_lblPoIssueDate.gridy = 5;
		panel_2.add(lblPoIssueDate, gbc_lblPoIssueDate);

		txtPoIssueDate = new JTextField();
		txtPoIssueDate.setBackground(Color.WHITE);
		txtPoIssueDate.setEditable(false);
		txtPoIssueDate.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				txtRowContent.setText(txtPoIssueDate.getText());
			}
		});
		txtPoIssueDate.setColumns(10);
		GridBagConstraints gbc_txtPoIssueDate = new GridBagConstraints();
		gbc_txtPoIssueDate.insets = new Insets(0, 0, 5, 5);
		gbc_txtPoIssueDate.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPoIssueDate.gridx = 1;
		gbc_txtPoIssueDate.gridy = 5;
		panel_2.add(txtPoIssueDate, gbc_txtPoIssueDate);

		txtEmail = new JTextField();
		txtEmail.setBackground(Color.WHITE);
		txtEmail.setEditable(false);
		txtEmail.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtRowContent.setText(txtEmail.getText());
			}
		});

		JLabel lblEmail = new JLabel("\u5217\u7BA1/MAIL");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.WEST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 2;
		gbc_lblEmail.gridy = 5;
		panel_2.add(lblEmail, gbc_lblEmail);
		GridBagConstraints gbc_txtEmail = new GridBagConstraints();
		gbc_txtEmail.insets = new Insets(0, 0, 5, 5);
		gbc_txtEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEmail.gridx = 3;
		gbc_txtEmail.gridy = 5;
		panel_2.add(txtEmail, gbc_txtEmail);
		txtEmail.setColumns(10);

		lblEbilling = new JLabel(
				"\u96FB\u5B50\u8868\u55AE/\u9A57\u8B49/\u9996\u6B21");
		GridBagConstraints gbc_lblEbilling = new GridBagConstraints();
		gbc_lblEbilling.anchor = GridBagConstraints.WEST;
		gbc_lblEbilling.insets = new Insets(0, 0, 5, 5);
		gbc_lblEbilling.gridx = 4;
		gbc_lblEbilling.gridy = 5;
		panel_2.add(lblEbilling, gbc_lblEbilling);

		txtEbilling = new JTextField();
		txtEbilling.setBackground(Color.WHITE);
		txtEbilling.setEditable(false);
		txtEbilling.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtRowContent.setText(txtEbilling.getText());
			}
		});
		txtEbilling.setColumns(10);
		GridBagConstraints gbc_txtEbilling = new GridBagConstraints();
		gbc_txtEbilling.insets = new Insets(0, 0, 5, 0);
		gbc_txtEbilling.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEbilling.gridx = 5;
		gbc_txtEbilling.gridy = 5;
		panel_2.add(txtEbilling, gbc_txtEbilling);

		JLabel lblInforceDate = new JLabel("\u767C\u55AE\u65E5");
		GridBagConstraints gbc_lblInforceDate = new GridBagConstraints();
		gbc_lblInforceDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblInforceDate.anchor = GridBagConstraints.WEST;
		gbc_lblInforceDate.gridx = 0;
		gbc_lblInforceDate.gridy = 6;
		panel_2.add(lblInforceDate, gbc_lblInforceDate);

		txtInforceDate = new JTextField();
		txtInforceDate.setBackground(Color.WHITE);
		txtInforceDate.setEditable(false);
		txtInforceDate.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				txtRowContent.setText(txtInforceDate.getText());
			}
		});
		txtInforceDate.setColumns(10);
		GridBagConstraints gbc_txtInforceDate = new GridBagConstraints();
		gbc_txtInforceDate.insets = new Insets(0, 0, 5, 5);
		gbc_txtInforceDate.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtInforceDate.gridx = 1;
		gbc_txtInforceDate.gridy = 6;
		panel_2.add(txtInforceDate, gbc_txtInforceDate);

		txtPrintDate = new JTextField();
		txtPrintDate.setBackground(Color.WHITE);
		txtPrintDate.setEditable(false);
		txtPrintDate.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				txtRowContent.setText(txtPrintDate.getText());
			}
		});

		JLabel lblPrintDate = new JLabel("\u88FD\u55AE\u65E5");
		GridBagConstraints gbc_lblPrintDate = new GridBagConstraints();
		gbc_lblPrintDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrintDate.anchor = GridBagConstraints.WEST;
		gbc_lblPrintDate.gridx = 2;
		gbc_lblPrintDate.gridy = 6;
		panel_2.add(lblPrintDate, gbc_lblPrintDate);
		txtPrintDate.setColumns(10);
		GridBagConstraints gbc_txtPrintDate = new GridBagConstraints();
		gbc_txtPrintDate.insets = new Insets(0, 0, 5, 5);
		gbc_txtPrintDate.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPrintDate.gridx = 3;
		gbc_txtPrintDate.gridy = 6;
		panel_2.add(txtPrintDate, gbc_txtPrintDate);

		JLabel lblLastOccu = new JLabel(
				"\u6700\u65B0\u8077\u696D\u985E\u5225/\u8077\u7D1A");
		GridBagConstraints gbc_lblLastOccu = new GridBagConstraints();
		gbc_lblLastOccu.anchor = GridBagConstraints.WEST;
		gbc_lblLastOccu.insets = new Insets(0, 0, 5, 5);
		gbc_lblLastOccu.gridx = 4;
		gbc_lblLastOccu.gridy = 6;
		panel_2.add(lblLastOccu, gbc_lblLastOccu);

		txtLastOccu = new JTextField();
		txtLastOccu.setBackground(Color.WHITE);
		txtLastOccu.setEditable(false);
		txtLastOccu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtRowContent.setText(txtLastOccu.getText());
			}
		});
		txtLastOccu.setColumns(10);
		GridBagConstraints gbc_txtLastOccu = new GridBagConstraints();
		gbc_txtLastOccu.insets = new Insets(0, 0, 5, 0);
		gbc_txtLastOccu.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtLastOccu.gridx = 5;
		gbc_txtLastOccu.gridy = 6;
		panel_2.add(txtLastOccu, gbc_txtLastOccu);

		O1_income_label = new JLabel("\u8981\u4FDD\u4EBA\u5E74\u6536\u5165");
		GridBagConstraints gbc_O1_income_label = new GridBagConstraints();
		gbc_O1_income_label.anchor = GridBagConstraints.EAST;
		gbc_O1_income_label.insets = new Insets(0, 0, 5, 5);
		gbc_O1_income_label.gridx = 0;
		gbc_O1_income_label.gridy = 7;
		panel_2.add(O1_income_label, gbc_O1_income_label);

		o1_income_textField = new JTextField();
		o1_income_textField.setBackground(Color.WHITE);
		o1_income_textField.setEditable(false);
		GridBagConstraints gbc_O1_income_textField = new GridBagConstraints();
		gbc_O1_income_textField.insets = new Insets(0, 0, 5, 5);
		gbc_O1_income_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_O1_income_textField.gridx = 1;
		gbc_O1_income_textField.gridy = 7;
		panel_2.add(o1_income_textField, gbc_O1_income_textField);
		o1_income_textField.setColumns(10);

		i1_come_label = new JLabel("\u88AB\u4FDD\u4EBA\u5E74\u6536\u5165");
		GridBagConstraints gbc_i1_come_label = new GridBagConstraints();
		gbc_i1_come_label.anchor = GridBagConstraints.EAST;
		gbc_i1_come_label.insets = new Insets(0, 0, 5, 5);
		gbc_i1_come_label.gridx = 2;
		gbc_i1_come_label.gridy = 7;
		panel_2.add(i1_come_label, gbc_i1_come_label);

		i1_income_textField = new JTextField();
		i1_income_textField.setBackground(Color.WHITE);
		i1_income_textField.setEditable(false);
		GridBagConstraints gbc_i1_income_textField_1 = new GridBagConstraints();
		gbc_i1_income_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_i1_income_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_i1_income_textField_1.gridx = 3;
		gbc_i1_income_textField_1.gridy = 7;
		panel_2.add(i1_income_textField, gbc_i1_income_textField_1);
		i1_income_textField.setColumns(10);

		family_income_label = new JLabel("\u5BB6\u5EAD\u5E74\u6536\u5165");
		GridBagConstraints gbc_family_income_label = new GridBagConstraints();
		gbc_family_income_label.anchor = GridBagConstraints.WEST;
		gbc_family_income_label.insets = new Insets(0, 0, 5, 5);
		gbc_family_income_label.gridx = 4;
		gbc_family_income_label.gridy = 7;
		panel_2.add(family_income_label, gbc_family_income_label);

		JLabel lblCurrency = new JLabel("");
		GridBagConstraints gbc_lblCurrency = new GridBagConstraints();
		gbc_lblCurrency.anchor = GridBagConstraints.WEST;
		gbc_lblCurrency.insets = new Insets(0, 0, 5, 5);
		gbc_lblCurrency.gridx = 4;
		gbc_lblCurrency.gridy = 8;
		panel_2.add(lblCurrency, gbc_lblCurrency);

		family_income_textField = new JTextField();
		family_income_textField.setBackground(Color.WHITE);
		family_income_textField.setEditable(false);
		family_income_textField.setColumns(10);
		GridBagConstraints gbc_family_income_textField = new GridBagConstraints();
		gbc_family_income_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_family_income_textField.gridx = 5;
		gbc_family_income_textField.gridy = 7;
		panel_2.add(family_income_textField, gbc_family_income_textField);

		// textCurrency = new JTextField();
		// textCurrency.setForeground(new Color(128, 0, 128));
		// textCurrency.setBackground(Color.YELLOW);
		// textCurrency.setEditable(false);
		// textCurrency.addMouseListener(new MouseAdapter() {
		// @Override
		// public void mouseClicked(MouseEvent e) {
		// txtRowContent.setText(textCurrency.getText());
		// }
		// });
		GridBagConstraints gbc_textCurrency = new GridBagConstraints();
		gbc_textCurrency.fill = GridBagConstraints.HORIZONTAL;
		gbc_textCurrency.gridx = 5;
		gbc_textCurrency.gridy = 7;
		// panel_2.add(textCurrency, gbc_textCurrency);
		// textCurrency.setColumns(10);

		panel_3 = new JPanel();
		panel_3.setPreferredSize(new Dimension(10, 363));

		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 2;
		panel_1.add(panel_3, gbc_panel_3);
		panel_3.setLayout(new GridLayout(1, 3, 0, 0));

		detailVerticalPane1 = new VerticalPane();
		detailVerticalPane2 = new VerticalPane();
		detailVerticalPane3 = new VerticalPane();

		panel_3.add(detailVerticalPane1);
		panel_3.add(detailVerticalPane2);
		panel_3.add(detailVerticalPane3);

		JPanel panel = new JPanel();
		tabbedPane.addTab("金額明細及分配比例", null, panel, null);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 468, 0 };
		gbl_panel.rowHeights = new int[] { 195, 202, 0, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		panel_4 = new JPanel();
		panel_4.setPreferredSize(new Dimension(10, 163));
		panel_4.setMaximumSize(new Dimension(32767, 110));
		panel_4.setBorder(new TitledBorder(null,
				"\u6295\u8CC7\u578B\u5546\u54C1\u8A73\u7D30\u8CC7\u6599",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.insets = new Insets(0, 0, 5, 0);
		gbc_panel_4.gridx = 0;
		gbc_panel_4.gridy = 0;
		panel.add(panel_4, gbc_panel_4);
		panel_4.setLayout(new GridLayout(1, 1, 0, 0));

		detailVerticalPane4 = new VerticalPane();
		detailVerticalPane5 = new VerticalPane();
		detailVerticalPane6 = new VerticalPane();
		detailVerticalPane7 = new VerticalPane();

		panel_4.add(detailVerticalPane4);
		panel_4.add(detailVerticalPane5);
		panel_4.add(detailVerticalPane6);
		panel_4.add(detailVerticalPane7);

		scrollPane_3 = new JScrollPane();
		scrollPane_3.setBorder(new TitledBorder(null,
				"\u6295\u8CC7\u6A19\u7684\u5167\u5BB9\u5206\u914D",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_scrollPane_3 = new GridBagConstraints();
		gbc_scrollPane_3.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_3.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_3.gridx = 0;
		gbc_scrollPane_3.gridy = 1;
		panel.add(scrollPane_3, gbc_scrollPane_3);
		IListtable = new JTable();
		IListtable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// IListtable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		scrollPane_3.setViewportView(IListtable);

		// GridBagConstraints gbc_table = new GridBagConstraints();
		// gbc_table.fill = GridBagConstraints.BOTH;
		// gbc_table.gridx = 0;
		// gbc_table.gridy = 2;
		// panel.add(table, gbc_table);

		panel_6 = new JPanel();
		panel_6.setBorder(new TitledBorder(null, "\u76EE\u6A19\u5806\u758A",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		tabbedPane.addTab("目標堆疊查詢", null, panel_6, null);
		panel_6.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane_2 = new JScrollPane();
		panel_6.add(scrollPane_2);

		Targettable = new JTable();
		scrollPane_2.setViewportView(Targettable);
		// panel_6.add(Targettable);

		// Targettable
		// .setDefaultRenderer(String.class, new MultiLineCellRenderer());
		// Targettable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		// scrollPane_2.setViewportView(Targettable);

		panel_7 = new JPanel();
		tabbedPane.addTab("\u81EA\u52D5\u5316\u67E5\u8A62--\u5DF2\u642C\u5BB6",
				null, panel_7, null);
		GridBagLayout gbl_panel_7 = new GridBagLayout();
		gbl_panel_7.columnWidths = new int[] { 0, 0 };
		gbl_panel_7.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_panel_7.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel_7.rowWeights = new double[] { 0.0, 0.0, 1.0, 1.0,
				Double.MIN_VALUE };
		panel_7.setLayout(gbl_panel_7);

		scrollPane_4 = new JScrollPane();
		scrollPane_4.setPreferredSize(new Dimension(2, 150));
		GridBagConstraints gbc_scrollPane_4 = new GridBagConstraints();
		gbc_scrollPane_4.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_4.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_4.gridx = 0;
		gbc_scrollPane_4.gridy = 0;
		panel_7.add(scrollPane_4, gbc_scrollPane_4);

		Accttable = new JTable();
		Accttable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_4.setViewportView(Accttable);
		ListSelectionModel model = Accttable.getSelectionModel();
		model.addListSelectionListener(this);

		scrollPane_5 = new JScrollPane();
		scrollPane_5.setPreferredSize(new Dimension(2, 70));
		GridBagConstraints gbc_scrollPane_5 = new GridBagConstraints();
		gbc_scrollPane_5.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_5.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_5.gridx = 0;
		gbc_scrollPane_5.gridy = 1;
		panel_7.add(scrollPane_5, gbc_scrollPane_5);

		Passwdtable = new JTable();
		Passwdtable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_5.setViewportView(Passwdtable);

		tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_tabbedPane_1 = new GridBagConstraints();
		gbc_tabbedPane_1.insets = new Insets(0, 0, 5, 0);
		gbc_tabbedPane_1.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane_1.gridx = 0;
		gbc_tabbedPane_1.gridy = 2;
		tabbedPane_1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				int tabSelect = tabbedPane_1.getSelectedIndex();
				if (tabSelect > 0)
					controller.executeMissionTabValues(4);
			}
		});
		panel_7.add(tabbedPane_1, gbc_tabbedPane_1);

		scrollPane_6 = new JScrollPane();
		tabbedPane_1.addTab("建檔明細", null, scrollPane_6, null);

		Insuredtable = new JTable();
		Insuredtable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_6.setViewportView(Insuredtable);

		scrollPane_7 = new JScrollPane();
		tabbedPane_1.addTab("密碼列印記錄", null, scrollPane_7, null);

		PWDprinttable = new JTable();
		PWDprinttable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_7.setViewportView(PWDprinttable);
		// GridBagConstraints gbc_tabbedPane_1 = new GridBagConstraints();
		gbc_tabbedPane_1.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane_1.gridx = 0;
		gbc_tabbedPane_1.gridy = 3;
		// panel_7.add(tabbedPane_1, gbc_tabbedPane_1);
		initDataBindings();

		// TableColumn headerCol;

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
	}

	public void valueChanged(ListSelectionEvent e) {
		int rowSelected = Accttable.getSelectedRow();
		if (rowSelected > -1) {
			// String client_id = null, invs_name = null, acct_source = null
			// ,bank_id = null,account_no = null;
			// int lcnt = 0;
			ECinsuredGroup.removeAll();
			ECpasswdGroup.removeAll();
			controller.executeMission(
					ECacctGroup.getPoDetailECaccts().get(rowSelected)
							.getacct_source(), ECacctGroup.getPoDetailECaccts()
							.get(rowSelected).getremit_bank(), ECacctGroup
							.getPoDetailECaccts().get(rowSelected)
							.getremit_account(), ECacctGroup
							.getPoDetailECaccts().get(rowSelected)
							.getaccu_lcnt());
		}
	}

	public void setController(PoDetailController controller) {
		this.controller = controller;
	}

	public void setValues(HashMap<String, String> hsmp, int blockType,
			String class_type) {
		// COMMBASIC = 1;
		// PODETAIL_PL = 2;
		// PODETAIL_A = 3;
		// PODETAIL_U = 4;
		// PODETAIL_I = 5;

		switch (blockType) {
		case PoDetailQuery.COMMBASIC: // 共通基本
			poDetailComm.setValues(hsmp);
			// String co_sts = poDetailComm.getPo_sts_desc();
			txtPoStsCode.setBackground(Color.yellow);

			// System.out.println(poDetailComm.getPo_sts_desc().indexOf("co=51"));
			// if ( co_sts.indexOf("co=51") > 0 )
			// { txtPoStsCode.setBackground(Color.yellow);
			// poDetailComm.setPo_sts_desc(co_sts.substring(0,co_sts.indexOf("co=51")-1));
			// } else
			// txtPoStsCode.setBackground(Color.white);

			// if (
			// poDetailComm.getcorridor_ind().equals("1")||poDetailComm.getcorridor_ind().equals("2"))
			// JOptionPane.showMessageDialog(null, "該保單適用門檻法則A\n\n"
			// + "身故給付/帳戶帳值 ≧比例\n\n"
			// + "            40歲以下      130%\n"
			// + "            41-70歲         115%\n"
			// + "            71歲以上      101% \n\n");
			break;

		case PoDetailQuery.PODETAIL_PL: // Life & IPA
			poDetailLFPA.setValues(hsmp);
			panel_3.setBorder(new TitledBorder(null, "壽險與傷害險明細",
					TitledBorder.LEADING, TitledBorder.TOP, null, null));
			String[] headers1 = { "繳費終日", "保障終日", "催告日1/2", "保費到期", "送金到期",
					"墊繳終日", "停效日期", "帳戶號碼", "彙繳編號/轉帳", "附約延續權", "復效申請", "首期入賬",
					"前變更生效日", "前變更(日/人)" };
			// 設定verticalpan 表頭 中
			String[] headers2 = { "暫收契變/復效", "暫收還款/其他", "補發保單/次數", "紅利選擇",
					"紅利金額/未認紅利", "溢/欠繳", "每期保費/應繳保費", "折扣金額/折扣期限", "繳費期限",
					"最長票期 (有/無)", "支票日期", "高保費/折扣", "保費折扣", "次活動日/活動型態" };
			// 設定verticalpan 表頭 右
			String[] headers3 = { "借款利率/預定利率", "借款日期", "借款金額(本金)", "自動墊繳",
					"墊繳日期", "墊繳金額(本金)", "償還通知", "簽收日", "回執日", "重作保單",
					"專案代號/銀行", "投保身份/保單請寄", "代理投保單位", "" };
			detailVerticalPane1.setTableFormat(headers1, "", 97, 25);
			detailVerticalPane2.setTableFormat(headers2, "", 133, 25);
			detailVerticalPane3.setTableFormat(headers3, "", 128, 25);
			detailVerticalPane1.setValue(poDetailLFPA.getValues(1));
			detailVerticalPane2.setValue(poDetailLFPA.getValues(2));
			detailVerticalPane3.setValue(poDetailLFPA.getValues(3));

			detailVerticalPane2.getDataTable().getColumnModel().getColumn(0)
					.setCellRenderer(new DefaultTableCellRenderer() {

						private static final long serialVersionUID = 1L;

						public Component getTableCellRendererComponent(
								JTable table, Object value, boolean isSelected,
								boolean hasFocus, int row, int col) {
							JLabel label = (JLabel) super
									.getTableCellRendererComponent(table,
											value, isSelected, hasFocus, row,
											col);
							try {
								if (row == 5) {
									if (Float.parseFloat(value.toString()) < 0)
										setForeground(Color.red);
								} else
									setForeground(Color.black);
							} catch (Exception e) {
								return this;
							}
							setValue(value == null ? "" : value.toString());
							return this;
						}
					});
			// detailVerticalPane2.getDataTable().getColumnModel().getColumn(0).setCellRenderer(new
			// MultiLineCellRenderer() {
			// private static final long serialVersionUID = 1L;
			// public boolean condition(JTable table,Object value,int row,int
			// column) {
			// try {
			// if ( row == 5)
			// if (Integer.parseInt(value.toString())< 0)
			// return true;
			// else
			// return false;
			// } catch (Exception e) {
			//
			// }
			// return false;
			// }
			// public Color getColor(){
			// return Color.white;
			// }
			// public Color getFColor(){
			// return Color.red;
			// }
			// });

			// tabbedPane.setEnabledAt(1,false); //tab 金額明細及分配比例關掉
			// tabbedPane.setEnabledAt(2,false); //tab 目標堆疊關掉
			// addpoDetailLFPA(poDetailLFPA);
			break;
		case PoDetailQuery.PODETAIL_A: // 年金
			panel_3.setBorder(new TitledBorder(null, "年金明細",
					TitledBorder.LEADING, TitledBorder.TOP, null, null));
			poDetailA.setValues(hsmp);
			String[] headers4 = { "保障終日", "應繳費日", "保單週月日", "給付日期", "給付類型",
					"給付週期", "保證期間", "生效利率", "宣告利率", "借款利率", "解約費用率", "首期入帳",
					"送金到期", "前變更生效日", "補發保單/次數" };
			// 設定verticalpan 表頭 中
			String[] headers5 = { "保單年度", "支票日期", "借款日期", "可借金額", "免費提領",
					"部份提領上限", "償還通知", "暫收還款/其他", "暫收契變/復效", "專案代號/銀行", "溢/欠繳",
					"定期保費選擇", "定期保費", "前變更(日/人)" };
			// 設定verticalpan 表頭 右
			String[] headers6 = { "帳戶計息起日", "帳戶計息止日", "應計帳戶利息", "本次帳戶利息",
					"帳戶本金", "保單價值", "借款計息起日", "借款計息止日", "應計借款利息", "本次借款利息",
					"借款本金", "借款本息", "投保身份/保單請寄", "次活動日/活動型態" };
			detailVerticalPane1.setTableFormat(headers4, "", 105, 25);
			detailVerticalPane2.setTableFormat(headers5, "", 110, 25);
			detailVerticalPane3.setTableFormat(headers6, "", 128, 25);

			detailVerticalPane1.setValue(poDetailA.getValues(1));
			detailVerticalPane2.setValue(poDetailA.getValues(2));
			detailVerticalPane3.setValue(poDetailA.getValues(3));
			// tabbedPane.setEnabledAt(1,false); //tab 金額明細及分配比例關掉
			// tabbedPane.setEnabledAt(2,false); //tab 目標堆疊關掉
			break;
		case PoDetailQuery.PODETAIL_I: // VUL
		case PoDetailQuery.PODETAIL_N:
			poDetailI.setValues(hsmp);
			panel_3.setBorder(new TitledBorder(null, "投資型商品明細",
					TitledBorder.LEADING, TitledBorder.TOP, null, null));
			String[] headers7 = { "繳費終日", "保障終日", "保費到期", "送金到期", "保單週月",
					"保單年度", "原始保額", "首期投入", "核定日期", "帳戶號碼", "復效申請", "附約延續",
					"首期入賬", "前變更生效日", "投資日註記" }; // 銀保投資型新增
			// 設定verticalpan 表頭 中
			String[] headers8 = { "紅利選擇", "預收保費", "溢/欠繳", "暫收契變/復效", "暫收還款/其他",
					"暫收支票", "待投入", "懸帳", "贖回待付", "定期保費", "建議保費", "定期保費選擇",
					"補發保單/次數", "前變更(日/人)", "每月扣除額方式" };
			// 設定verticalpan 表頭 右
			String[] headers9 = new String[14];
			int type = 0;
			headers9[0] = "支票日期";
			headers9[1] = "催告日";
			headers9[12] = "幣別";
			// System.out.println("I?="+class_type+" sub="+class_type.substring(1,
			// 1));
			// if (class_type.equals("I1") || class_type.equals("I4")) {
			headers9[2] = "80%通知";
			headers9[3] = "90%通知";
			headers9[4] = "100%日期";
			headers9[5] = "超額通知/差額";
			headers9[6] = "停效日期";
			headers9[7] = "借款日期";
			headers9[8] = "借款金額(本金)";
			headers9[9] = "不停效保證";
			headers9[10] = "不符原因";
			headers9[11] = "不符日期";
			headers9[12] = "投保身份/保單請寄";
			headers9[13] = "次活動日/活動型態";
			type = 13;
			// } else {
			// 變額年金(HVA)保單詳細資料
			// 104.12.15 後改為都寫投資型商品明細
			if (blockType == PoDetailQuery.PODETAIL_N) {
				panel_3.setBorder(new TitledBorder(null, "變額年金詳細資料",
						TitledBorder.LEADING, TitledBorder.TOP, null, null));
				headers9[2] = "80%/90%通知";
				headers9[3] = "100%日期";
				headers9[4] = "超額通知/差額";
				headers9[5] = "停效日期";
				headers9[6] = "借款日期";
				headers9[7] = "借款金額(本金)";
				headers9[8] = "年金保證期間";
				headers9[9] = "年金給付週期/類型";
				headers9[10] = "年金開始給付日";
				headers9[11] = "年金給付日期";
				headers9[12] = "投保身份/保單請寄";
				headers9[13] = "次活動日/活動型態";
				type = 14;
			}
			detailVerticalPane1.setTableFormat(headers7, "", 105, 25);
			detailVerticalPane2.setTableFormat(headers8, "", 110, 25);
			detailVerticalPane3.setTableFormat(headers9, "", 128, 25);
			detailVerticalPane1.setValue(poDetailI.getValues(11));
			detailVerticalPane2.setValue(poDetailI.getValues(12));
			detailVerticalPane3.setValue(poDetailI.getValues(type));
			detailVerticalPane2.getDataTable().getColumnModel().getColumn(0)
					.setCellRenderer(new DefaultTableCellRenderer() {

						private static final long serialVersionUID = 1L;

						public Component getTableCellRendererComponent(
								JTable table, Object value, boolean isSelected,
								boolean hasFocus, int row, int col) {
							JLabel label = (JLabel) super
									.getTableCellRendererComponent(table,
											value, isSelected, hasFocus, row,
											col);
							try {
								if (row == 2) {
									if (Integer.parseInt(value.toString()) < 0)
										setForeground(Color.red);
								} else
									setForeground(Color.black);
							} catch (Exception e) {
								return this;
							}
							setValue(value == null ? "" : value.toString());
							return this;
						}
					});
			// detailVerticalPane2.getDataTable().getColumnModel().getColumn(0).setCellRenderer(new
			// MultiLineCellRenderer() {
			// private static final long serialVersionUID = 1L;
			// public boolean condition(JTable table,Object value,int row,int
			// column) {
			// try {
			// if ( row == 2)
			// if (Integer.parseInt(value.toString())< 0)
			// return true;
			// else
			// return false;
			// } catch (Exception e) {
			//
			// }
			// return false;
			// }
			// public Color getColor(){
			// return Color.white;
			// }
			// public Color getFColor(){
			// return Color.red;
			// }
			// });

			break;

		case PoDetailQuery.PODETAIL_U: // UL
			poDetailU.setValues(hsmp);
			panel_3.setBorder(new TitledBorder(null, "萬能壽險明細",
					TitledBorder.LEADING, TitledBorder.TOP, null, null));
			String[] headers10 = { "繳費終日", "保障終日", "催告日1/2", "保費到期日", "保單年度",
					"保單週月日", "停效通知", "停效日期", "原始保額", "首期投入", "核定日期", "帳戶號碼",
					"前變更生效日", "補發保單/次數" };

			// 設定verticalpan 表頭 中
			String[] headers11 = { "暫收契變/復效", "暫收還款/其他", "暫收支票", "建議保費",
					"定期保費", "目標保費", "償還通知", "利率加碼", "增額選擇", "增額保額", "復效申請",
					"幣別", "前變更(日/人)", "" };
			// 設定verticalpan 表頭 右
			String[] headers12 = { "帳戶計息起日", "帳戶計息止日", "本次利息", "帳戶本金", "帳戶餘額",
					"免費提領", "部份提領上限", "解約費用率", "借款起息日期", "借款止息日期", "借款本金",
					"借款本息", "次活動日/活動型態", "" };
			detailVerticalPane1.setTableFormat(headers10, "", 100, 25);
			detailVerticalPane2.setTableFormat(headers11, "", 113, 25);
			detailVerticalPane3.setTableFormat(headers12, "", 128, 25);

			detailVerticalPane1.setValue(poDetailU.getValues(1));
			detailVerticalPane2.setValue(poDetailU.getValues(2));
			detailVerticalPane3.setValue(poDetailU.getValues(3));

			break;

		case PoDetailQuery.PODETAIL_TARGET: // 目標堆疊
			PoDetailTarget poDatailTarget = new PoDetailTarget(hsmp);
			TargetGroup.addPoDetailTarget(poDatailTarget);
			break;

		case PoDetailQuery.PODETAIL_PG2: // 投資標的比例 第二頁上半部投資型明細
			if (class_type.equals("U")) {
				String[] headers21 = { "原始目標", "去年目標", "當年目標", "次年目標", "累積目標",
						"目標保費" };
				String[] headers22 = { "去年額外(超額)", "當年額外(超額)", "次年額外(超額)",
						"累積額外(超額)", "", "" };
				// String[] headers23 =
				// {"保單價值定期定額減少","預定調降保險金額","定期保險費繳費","","",""};
				String[] headers23 = { "", "", "", "", "", "" };
				String[] headers24 = { "", "", "", "", "", "" };
				detailVerticalPane4.setTableFormat(headers21, "", 75, 25);
				detailVerticalPane5.setTableFormat(headers22, "", 115, 25);
				detailVerticalPane6.setTableFormat(headers23, "", 75, 25);
				detailVerticalPane7.setTableFormat(headers24, "", 75, 25);
				detailVerticalPane4.setValue(poDetailU.getValues(21));
				detailVerticalPane5.setValue(poDetailU.getValues(22));
				detailVerticalPane6.setValue(poDetailU.getValues(23));
				detailVerticalPane7.setValue(poDetailU.getValues(24));
			} else {
				String[] headers21 = { "原始目標", "去年目標", "當年目標", "次年目標", "累積目標",
						"目標保費" };
				String[] headers22 = { "去年額外(超額)", "當年額外(超額)", "次年額外(超額)",
						"累積額外(超額)", "提領年度", "提領次數" };
				String[] headers23 = { "轉換年度", "轉換月份", "轉換次數", "特別紅利年度",
						"紅利金額", "未認紅利" };
				String[] headers24 = { "特別紅利指示", "不符原因", "不符日期", "不停效保證",
						"不符原因", "不符日期" };
				detailVerticalPane4.setTableFormat(headers21, "", 75, 25);
				detailVerticalPane5.setTableFormat(headers22, "", 115, 25);
				detailVerticalPane6.setTableFormat(headers23, "", 95, 25);
				detailVerticalPane7.setTableFormat(headers24, "", 95, 25);
				detailVerticalPane4.setValue(poDetailI.getValues(21));
				detailVerticalPane5.setValue(poDetailI.getValues(22));
				detailVerticalPane6.setValue(poDetailI.getValues(23));
				detailVerticalPane7.setValue(poDetailI.getValues(24));
			}
			break;

		case PoDetailQuery.PODETAIL_ILIST: // 投資標的比例 第二頁畫面下半投資標的比例
			PoDetailIList poDetailIList = new PoDetailIList(hsmp);
			IListGroup.addPoDetailIList(poDetailIList);
			break;

		case PoDetailQuery.PODETAIL_ECO: // EC
			PoDetailECacct poDetailECacct = new PoDetailECacct(hsmp);
			ECacctGroup.addPoDetailECacct(poDetailECacct);
			break;
		}
	}

	public void setValues(HashMap<String, String> hsmp, int blockType) // EC專用
	{
		switch (blockType) {
		case 1: // 密碼資料
			PoDetailECpasswd poDetailECpasswd = new PoDetailECpasswd(hsmp);
			ECpasswdGroup.addPoDetailECpasswd(poDetailECpasswd);
			break;
		case 2: // 登記保單or insured資料
			PoDetailECinsured poDetailECinsured = new PoDetailECinsured(hsmp);
			ECinsuredGroup.addPoDetailECinsured(poDetailECinsured);
			break;
		case 3: // 密碼列印記錄
			PoDetailECprint poDetailECprint = new PoDetailECprint(hsmp);
			ECprintGroup.addPoDetailECprint(poDetailECprint);
			break;
		}
	}

	public void addpoDetailLFPA(PoDetailLFPA poDetailLFPA) {
		String[] values1 = poDetailLFPA.getValues(1);
		String[] values2 = poDetailLFPA.getValues(2);
		String[] values3 = poDetailLFPA.getValues(3);
		detailVerticalPane1.setValue(values1);
		detailVerticalPane2.setValue(values2);
		detailVerticalPane3.setValue(values3);
	}

	public void setTabbedPaneEnable(int index, boolean enabled) {
		tabbedPane.setEnabledAt(index, enabled);
	}

	public int getTabbedPaneSelectedIndex() {
		return tabbedPane.getSelectedIndex();
	}

	public void setTabbedPaneSelectedIndex(int index) {
		tabbedPane.setSelectedIndex(index);
	}

	public void clearVer() {
		// 未曾開啟過頁籤，直接點擊功能會沒有初始化VerticalPane
		try {
			if (detailVerticalPane1 != null)
				detailVerticalPane1.clearValues();
			if (detailVerticalPane2 != null)
				detailVerticalPane2.clearValues();
			if (detailVerticalPane3 != null)
				detailVerticalPane3.clearValues();
			if (detailVerticalPane4 != null)
				detailVerticalPane4.clearValues();
			if (detailVerticalPane5 != null)
				detailVerticalPane5.clearValues();
			if (detailVerticalPane6 != null)
				detailVerticalPane6.clearValues();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

	public void clearAll() {
		TargetGroup.removeAll();
		IListGroup.removeAll();
		ECacctGroup.removeAll();
		ECinsuredGroup.removeAll();
		ECpasswdGroup.removeAll();
		ECprintGroup.removeAll();

		txtRowContent.setText("");
		txtPolicy_no.setText("");
		txtHomeAddr.setText("");
		txtOwnerBirth.setText("");
		txtPoStsCode.setText("");
		// txtHomeZip.setText("");
		txtOwnerName.setText("");
		txtModx.setText("");
		txtHomeTel.setText("");
		txtInsuredBirth.setText("");
		txtMethod.setText("");
		txtMailAddr.setText("");
		txtInsuredName.setText("");
		txtApplyDate.setText("");
		// txtMailZip.setText("");
		txtMailAddrSts.setText("");
		txtPoIssueDate.setText("");
		txtMailTel.setText("");
		txtEbilling.setText("");
		txtInforceDate.setText("");
		txtCellNo.setText("");
		txtLastOccu.setText("");
		txtPrintDate.setText("");
		txtEmail.setText("");
		o1_income_textField.setText("");
		i1_income_textField.setText("");
		family_income_textField.setText("");
		// detailVerticalPane9.clearValues();
		// agGroup.removeAll();
		// collectorField.setText("");
	}

	/**
	 * 將全域變數全部指向NULL,利於JAVA記憶體回收系統回收記憶體
	 */
	public void nullAll() {
		Targettable = null;
		IListtable = null;
		Accttable = null;
		Passwdtable = null;
		Insuredtable = null;
		PWDprinttable = null;
		TargetGroup = null;
		IListGroup = null;
		ECacctGroup = null;
		ECinsuredGroup = null;
		ECpasswdGroup = null;
		ECprintGroup = null;
	}

	public void preBinding(String class_type) {
		TableColumn headerCol;
		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

		if (class_type.substring(0, 1).equals("I")) {

			if (class_type.equals("I2") || class_type.equals("I4")) // I2 = VA =
			// cc004i_va
			{
				initDataBindings("N");

				headerCol = IListtable.getColumnModel().getColumn(0); // 序號
				headerCol.setPreferredWidth(10);
				headerCol = IListtable.getColumnModel().getColumn(1); // 標的代碼
				headerCol.setPreferredWidth(50);
				headerCol = IListtable.getColumnModel().getColumn(2); // 標的代碼
				headerCol.setPreferredWidth(100);
				headerCol = IListtable.getColumnModel().getColumn(3); // 比例
				headerCol.setPreferredWidth(25);
				headerCol = IListtable.getColumnModel().getColumn(4); // 計價貨幣
				headerCol.setPreferredWidth(40);
				headerCol = IListtable.getColumnModel().getColumn(5); // 類型
				headerCol.setPreferredWidth(20);
				headerCol = IListtable.getColumnModel().getColumn(6); // 停利點
				headerCol.setPreferredWidth(40);
				headerCol = IListtable.getColumnModel().getColumn(7); // 自動轉換金額
				headerCol.setPreferredWidth(50);
				headerCol = IListtable.getColumnModel().getColumn(8); // 加碼
				headerCol.setPreferredWidth(20);
				headerCol = IListtable.getColumnModel().getColumn(9); // 狀況
				headerCol.setPreferredWidth(20);
				headerCol = IListtable.getColumnModel().getColumn(10); // 停售日期
				headerCol.setPreferredWidth(40);

				IListtable.moveColumn(5, 1); // 101/08/14 排序前移
				headerCol = IListtable.getColumnModel().getColumn(4); // 比例
				headerCol.setCellRenderer(rightRenderer);
				headerCol = IListtable.getColumnModel().getColumn(6); // 停利點
				headerCol.setCellRenderer(rightRenderer);
				headerCol = IListtable.getColumnModel().getColumn(7); // 自動轉換金額
				headerCol.setCellRenderer(rightRenderer);
				headerCol = IListtable.getColumnModel().getColumn(8); // 加碼
				headerCol.setCellRenderer(centerRenderer);
			} else {
				if (class_type.equals("I5")) {
					initDataBindings("U");
				} else if (class_type.equals("I6")) {
					initDataBindings("U6");
				} else {
					initDataBindings("Y");
				}
				IListtable.moveColumn(5, 1);
				headerCol = IListtable.getColumnModel().getColumn(0); // 序號
				headerCol.setPreferredWidth(45);
				headerCol.setMaxWidth(50);
				headerCol = IListtable.getColumnModel().getColumn(1); // 類型
				headerCol.setPreferredWidth(45);
				headerCol.setMaxWidth(50);
				headerCol = IListtable.getColumnModel().getColumn(2); // 標的代碼
				headerCol.setPreferredWidth(100);
				headerCol.setMaxWidth(130);
				headerCol = IListtable.getColumnModel().getColumn(3); // 標的代碼
				headerCol.setPreferredWidth(250);
				headerCol = IListtable.getColumnModel().getColumn(4); // 比例
				headerCol.setPreferredWidth(55);
				headerCol = IListtable.getColumnModel().getColumn(5); // 計價貨幣
				headerCol.setPreferredWidth(50);
				headerCol = IListtable.getColumnModel().getColumn(4); // 比例
				headerCol.setCellRenderer(rightRenderer);
				headerCol = IListtable.getColumnModel().getColumn(6); // 狀況
				headerCol.setPreferredWidth(20);
				headerCol = IListtable.getColumnModel().getColumn(7); // 停售日期
				headerCol.setPreferredWidth(40);
			}
			for (int i = 2; i < Targettable.getColumnCount(); i++) {
				headerCol = Targettable.getColumnModel().getColumn(i); //
				headerCol.setCellRenderer(rightRenderer);
				// headerCol = Targettable.getColumnModel().getColumn(3); //
				// headerCol.setCellRenderer(rightRenderer);
				// headerCol = Targettable.getColumnModel().getColumn(4); //
				// headerCol.setCellRenderer(rightRenderer);
				// headerCol = Targettable.getColumnModel().getColumn(5); //
				// headerCol.setCellRenderer(rightRenderer);
			}

		} else {
			initDataBindings("0");
		}
	}

	protected void initDataBindings(String HideVAcol) {
		// BeanProperty<PoDetailComm, String> poDetailCommBeanProperty =
		// BeanProperty.create("policy_no");
		// BeanProperty<JTextField, String> jTextFieldBeanProperty =
		// BeanProperty.create("text");
		// AutoBinding<PoDetailComm, String, JTextField, String> autoBinding =
		// Bindings.createAutoBinding(UpdateStrategy.READ, poDetailComm,
		// poDetailCommBeanProperty, txtPolicy_no, jTextFieldBeanProperty);
		// autoBinding.bind();
		//

		BeanProperty<PoDetailComm, String> poDetailCommBeanProperty_1 = BeanProperty
				.create("app_apply_date");
		BeanProperty<JTextField, String> jTextFieldBeanProperty_1 = BeanProperty
				.create("text");
		AutoBinding<PoDetailComm, String, JTextField, String> autoBinding_1 = Bindings
				.createAutoBinding(UpdateStrategy.READ, poDetailComm,
						poDetailCommBeanProperty_1, txtApplyDate,
						jTextFieldBeanProperty_1);
		autoBinding_1.bind();
		//
		BeanProperty<PoDetailComm, String> poDetailCommBeanProperty_2 = BeanProperty
				.create("o1_birth");
		BeanProperty<JTextField, String> jTextFieldBeanProperty_2 = BeanProperty
				.create("text");
		AutoBinding<PoDetailComm, String, JTextField, String> autoBinding_2 = Bindings
				.createAutoBinding(UpdateStrategy.READ, poDetailComm,
						poDetailCommBeanProperty_2, txtOwnerBirth,
						jTextFieldBeanProperty_2);
		autoBinding_2.bind();
		//
		BeanProperty<PoDetailComm, String> poDetailCommBeanProperty_3 = BeanProperty
				.create("po_sts_desc");
		BeanProperty<JTextField, String> jTextFieldBeanProperty_3 = BeanProperty
				.create("text");
		AutoBinding<PoDetailComm, String, JTextField, String> autoBinding_3 = Bindings
				.createAutoBinding(UpdateStrategy.READ, poDetailComm,
						poDetailCommBeanProperty_3, txtPoStsCode,
						jTextFieldBeanProperty_3);
		autoBinding_3.bind();
		//
		BeanProperty<PoDetailComm, String> poDetailCommBeanProperty_4 = BeanProperty
				.create("po_issue_date");
		BeanProperty<JTextField, String> jTextFieldBeanProperty_4 = BeanProperty
				.create("text");
		AutoBinding<PoDetailComm, String, JTextField, String> autoBinding_4 = Bindings
				.createAutoBinding(UpdateStrategy.READ, poDetailComm,
						poDetailCommBeanProperty_4, txtPoIssueDate,
						jTextFieldBeanProperty_4);
		autoBinding_4.bind();
		//
		ELProperty<PoDetailComm, Object> poDetailCommEvalutionProperty = ELProperty
				.create("${o1_name} / ${o1_sex} / ${o1_sign_ptn_card}");
		BeanProperty<JTextField, String> jTextFieldBeanProperty_5 = BeanProperty
				.create("text");
		AutoBinding<PoDetailComm, Object, JTextField, String> autoBinding_5 = Bindings
				.createAutoBinding(UpdateStrategy.READ, poDetailComm,
						poDetailCommEvalutionProperty, txtOwnerName,
						jTextFieldBeanProperty_5);
		autoBinding_5.bind();
		//
		// BeanProperty<PoDetailComm, String> poDetailCommBeanProperty_5 =
		// BeanProperty.create("o1_name");
		// BeanProperty<JTextField, String> jTextFieldBeanProperty_5 =
		// BeanProperty.create("text");
		// AutoBinding<PoDetailComm, String, JTextField, String> autoBinding_5 =
		// Bindings.createAutoBinding(UpdateStrategy.READ, poDetailComm,
		// poDetailCommBeanProperty_5, txtOwnerName, jTextFieldBeanProperty_5);
		// autoBinding_5.bind();
		//
		BeanProperty<PoDetailComm, String> poDetailCommBeanProperty_6 = BeanProperty
				.create("modx_desc");
		BeanProperty<JTextField, String> jTextFieldBeanProperty_6 = BeanProperty
				.create("text");
		AutoBinding<PoDetailComm, String, JTextField, String> autoBinding_6 = Bindings
				.createAutoBinding(UpdateStrategy.READ, poDetailComm,
						poDetailCommBeanProperty_6, txtModx,
						jTextFieldBeanProperty_6);
		autoBinding_6.bind();
		//
		BeanProperty<PoDetailComm, String> poDetailCommBeanProperty_7 = BeanProperty
				.create("in_force_date");
		BeanProperty<JTextField, String> jTextFieldBeanProperty_7 = BeanProperty
				.create("text");
		AutoBinding<PoDetailComm, String, JTextField, String> autoBinding_7 = Bindings
				.createAutoBinding(UpdateStrategy.READ, poDetailComm,
						poDetailCommBeanProperty_7, txtInforceDate,
						jTextFieldBeanProperty_7);
		autoBinding_7.bind();
		//
		BeanProperty<PoDetailComm, String> poDetailCommBeanProperty_8 = BeanProperty
				.create("i1_birth");
		BeanProperty<JTextField, String> jTextFieldBeanProperty_8 = BeanProperty
				.create("text");
		AutoBinding<PoDetailComm, String, JTextField, String> autoBinding_8 = Bindings
				.createAutoBinding(UpdateStrategy.READ, poDetailComm,
						poDetailCommBeanProperty_8, txtInsuredBirth,
						jTextFieldBeanProperty_8);
		autoBinding_8.bind();
		//
		BeanProperty<PoDetailComm, String> poDetailCommBeanProperty_9 = BeanProperty
				.create("method_desc");
		BeanProperty<JTextField, String> jTextFieldBeanProperty_9 = BeanProperty
				.create("text");
		AutoBinding<PoDetailComm, String, JTextField, String> autoBinding_9 = Bindings
				.createAutoBinding(UpdateStrategy.READ, poDetailComm,
						poDetailCommBeanProperty_9, txtMethod,
						jTextFieldBeanProperty_9);
		autoBinding_9.bind();
		//
		BeanProperty<PoDetailComm, String> poDetailCommBeanProperty_10 = BeanProperty
				.create("image_prn_date");
		BeanProperty<JTextField, String> jTextFieldBeanProperty_10 = BeanProperty
				.create("text");
		AutoBinding<PoDetailComm, String, JTextField, String> autoBinding_10 = Bindings
				.createAutoBinding(UpdateStrategy.READ, poDetailComm,
						poDetailCommBeanProperty_10, txtPrintDate,
						jTextFieldBeanProperty_10);
		autoBinding_10.bind();
		//
		ELProperty<PoDetailComm, Object> poDetailCommEvalutionProperty_11 = ELProperty
				.create("${i1_name} / ${i1_sex} / ${i1_sign_ptn_card}");
		BeanProperty<JTextField, String> jTextFieldBeanProperty_11 = BeanProperty
				.create("text");
		AutoBinding<PoDetailComm, Object, JTextField, String> autoBinding_11 = Bindings
				.createAutoBinding(UpdateStrategy.READ, poDetailComm,
						poDetailCommEvalutionProperty_11, txtInsuredName,
						jTextFieldBeanProperty_11);
		autoBinding_11.bind();
		//
		// BeanProperty<PoDetailComm, String> poDetailCommBeanProperty_11 =
		// BeanProperty.create("${i1_name} / ${i1_sex} / ${i1_sign_ptn_card}");
		// BeanProperty<JTextField, String> jTextFieldBeanProperty_11 =
		// BeanProperty.create("text");
		// AutoBinding<PoDetailComm, String, JTextField, String> autoBinding_11
		// = Bindings.createAutoBinding(UpdateStrategy.READ, poDetailComm,
		// poDetailCommBeanProperty_11, txtInsuredName,
		// jTextFieldBeanProperty_11);
		// autoBinding_11.bind();
		//
		BeanProperty<PoDetailComm, String> poDetailCommBeanProperty_12 = BeanProperty
				.create("home_tel");
		BeanProperty<JTextField, String> jTextFieldBeanProperty_12 = BeanProperty
				.create("text");
		AutoBinding<PoDetailComm, String, JTextField, String> autoBinding_12 = Bindings
				.createAutoBinding(UpdateStrategy.READ, poDetailComm,
						poDetailCommBeanProperty_12, txtHomeTel,
						jTextFieldBeanProperty_12);
		autoBinding_12.bind();
		//
		BeanProperty<PoDetailComm, String> poDetailCommBeanProperty_14 = BeanProperty
				.create("pmia_desc");
		BeanProperty<JTextField, String> jTextFieldBeanProperty_14 = BeanProperty
				.create("text");
		AutoBinding<PoDetailComm, String, JTextField, String> autoBinding_14 = Bindings
				.createAutoBinding(UpdateStrategy.READ, poDetailComm,
						poDetailCommBeanProperty_14, txtMailAddrSts,
						jTextFieldBeanProperty_14);
		autoBinding_14.bind();
		//
		BeanProperty<PoDetailComm, String> poDetailCommBeanProperty_15 = BeanProperty
				.create("mail_tel");
		BeanProperty<JTextField, String> jTextFieldBeanProperty_15 = BeanProperty
				.create("text");
		AutoBinding<PoDetailComm, String, JTextField, String> autoBinding_15 = Bindings
				.createAutoBinding(UpdateStrategy.READ, poDetailComm,
						poDetailCommBeanProperty_15, txtMailTel,
						jTextFieldBeanProperty_15);
		autoBinding_15.bind();
		//
		// BeanProperty<PoDetailComm, String> poDetailCommBeanProperty_16 =
		// BeanProperty.create("home_zip");
		// BeanProperty<JTextField, String> jTextFieldBeanProperty_16 =
		// BeanProperty.create("text");
		// AutoBinding<PoDetailComm, String, JTextField, String> autoBinding_16
		// = Bindings.createAutoBinding(UpdateStrategy.READ, poDetailComm,
		// poDetailCommBeanProperty_16, txtHomeZip, jTextFieldBeanProperty_16);
		// autoBinding_16.bind();
		//
		BeanProperty<PoDetailComm, String> poDetailCommBeanProperty_17 = BeanProperty
				.create("mail_sts");
		BeanProperty<JTextField, String> jTextFieldBeanProperty_17 = BeanProperty
				.create("text");
		AutoBinding<PoDetailComm, String, JTextField, String> autoBinding_17 = Bindings
				.createAutoBinding(UpdateStrategy.READ, poDetailComm,
						poDetailCommBeanProperty_17, txtEbilling,
						jTextFieldBeanProperty_17);
		autoBinding_17.bind();
		//
		BeanProperty<PoDetailComm, String> poDetailCommBeanProperty_18 = BeanProperty
				.create("mobil_no");
		BeanProperty<JTextField, String> jTextFieldBeanProperty_18 = BeanProperty
				.create("text");
		AutoBinding<PoDetailComm, String, JTextField, String> autoBinding_18 = Bindings
				.createAutoBinding(UpdateStrategy.READ, poDetailComm,
						poDetailCommBeanProperty_18, txtCellNo,
						jTextFieldBeanProperty_18);
		autoBinding_18.bind();
		//
		ELProperty<PoDetailComm, String> poDetailCommBeanProperty_19 = ELProperty
				.create("${mail_addr_ind} / ${mail_zip}${mail_addr}");
		BeanProperty<JTextField, String> jTextFieldBeanProperty_19 = BeanProperty
				.create("text");
		AutoBinding<PoDetailComm, String, JTextField, String> autoBinding_19 = Bindings
				.createAutoBinding(UpdateStrategy.READ, poDetailComm,
						poDetailCommBeanProperty_19, txtMailAddr,
						jTextFieldBeanProperty_19);
		autoBinding_19.bind();
		//
		BeanProperty<PoDetailComm, String> poDetailCommBeanProperty_21 = BeanProperty
				.create("e_mail");
		BeanProperty<JTextField, String> jTextFieldBeanProperty_21 = BeanProperty
				.create("text");
		AutoBinding<PoDetailComm, String, JTextField, String> autoBinding_21 = Bindings
				.createAutoBinding(UpdateStrategy.READ, poDetailComm,
						poDetailCommBeanProperty_21, txtEmail,
						jTextFieldBeanProperty_21);
		autoBinding_21.bind();
		//
		// BeanProperty<PoDetailComm, String> poDetailCommBeanProperty_22 =
		// BeanProperty.create("mail_zip");
		// BeanProperty<JTextField, String> jTextFieldBeanProperty_22 =
		// BeanProperty.create("text");
		// AutoBinding<PoDetailComm, String, JTextField, String> autoBinding_22
		// = Bindings.createAutoBinding(UpdateStrategy.READ, poDetailComm,
		// poDetailCommBeanProperty_22, txtMailZip, jTextFieldBeanProperty_22);
		// autoBinding_22.bind();
		//
		ELProperty<PoDetailComm, String> poDetailCommBeanProperty_13 = ELProperty
				.create("${home_addr_ind} / ${home_zip}${home_addr}");
		BeanProperty<JTextField, String> jTextFieldBeanProperty_13 = BeanProperty
				.create("text");
		AutoBinding<PoDetailComm, String, JTextField, String> autoBinding_13 = Bindings
				.createAutoBinding(UpdateStrategy.READ, poDetailComm,
						poDetailCommBeanProperty_13, txtHomeAddr,
						jTextFieldBeanProperty_13);
		autoBinding_13.bind();
		//
		BeanProperty<PoDetailComm, String> poDetailCommBeanProperty_23 = BeanProperty
				.create("i1_occu");
		BeanProperty<JTextField, String> jTextFieldBeanProperty_23 = BeanProperty
				.create("text");
		AutoBinding<PoDetailComm, String, JTextField, String> autoBinding_23 = Bindings
				.createAutoBinding(UpdateStrategy.READ, poDetailComm,
						poDetailCommBeanProperty_23, txtLastOccu,
						jTextFieldBeanProperty_23, "i1_occu");
		autoBinding_23.bind();
		//
		BeanProperty<PoDetailTargetGroup, List<PoDetailTarget>> poDetailTargetGroupBeanProperty = BeanProperty
				.create("poDetailTargets");
		JTableBinding<PoDetailTarget, PoDetailTargetGroup, JTable> jTableBinding = SwingBindings
				.createJTableBinding(UpdateStrategy.READ, TargetGroup,
						poDetailTargetGroupBeanProperty, Targettable,
						"PoDetailTarget");
		//
		BeanProperty<PoDetailTarget, String> poDetailTargetBeanProperty = BeanProperty
				.create("policy_year");
		jTableBinding.addColumnBinding(poDetailTargetBeanProperty)
				.setColumnName("\u4FDD\u55AE\u5E74\u5EA6");
		//
		BeanProperty<PoDetailTarget, String> poDetailTargetBeanProperty_1 = BeanProperty
				.create("prem_year");
		jTableBinding.addColumnBinding(poDetailTargetBeanProperty_1)
				.setColumnName("\u4FDD\u8CBB\u5E74\u5EA6");
		//
		// BeanProperty<PoDetailTarget, String> poDetailTargetBeanProperty_5 =
		// BeanProperty
		// .create("prem_month");
		// jTableBinding.addColumnBinding(poDetailTargetBeanProperty_5)
		// .setColumnName("保費月份");
		// //
		BeanProperty<PoDetailTarget, String> poDetailTargetBeanProperty_2 = BeanProperty
				.create("target_prem");
		jTableBinding.addColumnBinding(poDetailTargetBeanProperty_2)
				.setColumnName("\u76EE\u6A19\u4FDD\u8CBB");
		//
		BeanProperty<PoDetailTarget, String> poDetailTargetBeanProperty_3 = BeanProperty
				.create("target_prem_accu");
		jTableBinding.addColumnBinding(poDetailTargetBeanProperty_3)
				.setColumnName("\u5DF2\u7D2F\u7A4D\u76EE\u6A19");
		//
		BeanProperty<PoDetailTarget, String> poDetailTargetBeanProperty_4 = BeanProperty
				.create("target_prem_diff");
		jTableBinding.addColumnBinding(poDetailTargetBeanProperty_4)
				.setColumnName("\u76EE\u6A19\u5DEE\u984D");
		//
		jTableBinding.setEditable(false);
		jTableBinding.bind();
		//

		if (HideVAcol != "0") {
			BeanProperty<PoDetailIListGroup, List<PoDetailIList>> poDetailIListGroupBeanProperty = BeanProperty
					.create("poDetailILists");
			JTableBinding<PoDetailIList, PoDetailIListGroup, JTable> jTableBinding_1 = SwingBindings
					.createJTableBinding(UpdateStrategy.READ, IListGroup,
							poDetailIListGroupBeanProperty, IListtable,
							"PoDetailIList");
			//
			BeanProperty<PoDetailIList, String> poDetailIListBeanProperty = BeanProperty
					.create("invs_no");
			jTableBinding_1.addColumnBinding(poDetailIListBeanProperty)
					.setColumnName("\u5E8F\u865F");
			//
			BeanProperty<PoDetailIList, String> poDetailIListBeanProperty_1 = BeanProperty
					.create("invs_code");
			jTableBinding_1.addColumnBinding(poDetailIListBeanProperty_1)
					.setColumnName("\u6A19\u7684\u4EE3\u78BC");
			//
			BeanProperty<PoDetailIList, String> poDetailIListBeanProperty_2 = BeanProperty
					.create("invs_title");
			jTableBinding_1.addColumnBinding(poDetailIListBeanProperty_2)
					.setColumnName("\u6295\u8CC7\u6A19\u7684");
			//
			BeanProperty<PoDetailIList, String> poDetailIListBeanProperty_3 = BeanProperty
					.create("invs_alloc_perc");
			jTableBinding_1.addColumnBinding(poDetailIListBeanProperty_3)
					.setColumnName("\u6BD4\u4F8B");
			//
			BeanProperty<PoDetailIList, String> poDetailIListBeanProperty_4 = BeanProperty
					.create("currency_desc");
			jTableBinding_1.addColumnBinding(poDetailIListBeanProperty_4)
					.setColumnName("\u8A08\u50F9\u8CA8\u5E63");
			//
			BeanProperty<PoDetailIList, String> poDetailIListBeanProperty_5 = BeanProperty
					.create("invs_class_desc"); // 類型
			jTableBinding_1.addColumnBinding(poDetailIListBeanProperty_5)
					.setColumnName("\u985E\u578B");
			//
			BeanProperty<PoDetailIList, String> poDetailIListBeanProperty_9 = BeanProperty
					.create("invs_sts_code");
			jTableBinding_1.addColumnBinding(poDetailIListBeanProperty_9)
					.setColumnName("\u72C0\u6CC1");
			//
			BeanProperty<PoDetailIList, String> poDetailIListBeanProperty_10 = BeanProperty
					.create("iv_shutting_date");
			jTableBinding_1.addColumnBinding(poDetailIListBeanProperty_10)
					.setColumnName("\u505C\u552E\u65E5\u671F");

			if (HideVAcol == "N") {
				BeanProperty<PoDetailIList, String> poDetailIListBeanProperty_6 = BeanProperty
						.create("gain_lock_in_rate");
				jTableBinding_1.addColumnBinding(poDetailIListBeanProperty_6)
						.setColumnName("\u505C\u5229\u9EDE");
				//
				BeanProperty<PoDetailIList, String> poDetailIListBeanProperty_7 = BeanProperty
						.create("drip_feed_amount");
				jTableBinding_1.addColumnBinding(poDetailIListBeanProperty_7)
						.setColumnName("\u81EA\u52D5\u8F49\u63DB\u91D1\u984D");
				//
				BeanProperty<PoDetailIList, String> poDetailIListBeanProperty_8 = BeanProperty
						.create("over_feed_type");
				jTableBinding_1.addColumnBinding(poDetailIListBeanProperty_8)
						.setColumnName("加碼");
			}

			if (HideVAcol == "U") {
				BeanProperty<PoDetailIList, String> poDetailIListBeanProperty_6 = BeanProperty
						.create("gain_lock_in_rate");
				jTableBinding_1.addColumnBinding(poDetailIListBeanProperty_6)
						.setColumnName("\u505C\u5229\u9EDE");
				//
			}
			if (HideVAcol == "U6") {
				BeanProperty<PoDetailIList, String> poDetailIListBeanProperty_6 = BeanProperty
						.create("gain_lock_in_rate");
				jTableBinding_1.addColumnBinding(poDetailIListBeanProperty_6)
						.setColumnName("\u505C\u5229\u9EDE");
				//
				BeanProperty<PoDetailIList, String> poDetailIListBeanProperty_7 = BeanProperty
						.create("gain_lock_join_invs_code");
				jTableBinding_1.addColumnBinding(poDetailIListBeanProperty_7)
						.setColumnName("停利指定標的代碼");
				//
				BeanProperty<PoDetailIList, String> poDetailIListBeanProperty_8 = BeanProperty
						.create("gain_lock_join_invs_title");
				jTableBinding_1.addColumnBinding(poDetailIListBeanProperty_8)
						.setColumnName("停利指定標的");
				//
				BeanProperty<PoDetailIList, String> poDetailIListBeanProperty_11 = BeanProperty
						.create("coi_seq");
				jTableBinding_1.addColumnBinding(poDetailIListBeanProperty_11)
						.setColumnName("COI扣款順序");
				//
				BeanProperty<PoDetailIList, String> poDetailIListBeanProperty_12 = BeanProperty
						.create("profit_alloc_join_invs_code");
				jTableBinding_1.addColumnBinding(poDetailIListBeanProperty_12)
						.setColumnName("收益分配指定標的代碼");
				//
				BeanProperty<PoDetailIList, String> poDetailIListBeanProperty_13 = BeanProperty
						.create("profit_alloc_join_invs_title");
				jTableBinding_1.addColumnBinding(poDetailIListBeanProperty_13)
						.setColumnName("收益分配指定標的");
				//
			}
			//
			jTableBinding_1.setEditable(false);
			jTableBinding_1.bind();
		}

	}

	protected void initDataBindings() {
		BeanProperty<PoDetailComm, String> poDetailCommBeanProperty = BeanProperty
				.create("policy_no");
		BeanProperty<JTextField, String> jTextFieldBeanProperty = BeanProperty
				.create("text");
		AutoBinding<PoDetailComm, String, JTextField, String> autoBinding = Bindings
				.createAutoBinding(UpdateStrategy.READ, poDetailComm,
						poDetailCommBeanProperty, txtPolicy_no,
						jTextFieldBeanProperty, "policy_no");
		autoBinding.bind();
		//
		BeanProperty<PoDetailComm, String> poDetailCommBeanProperty_24 = BeanProperty
				.create("income_o");
		BeanProperty<JTextField, String> jTextFieldBeanProperty_24 = BeanProperty
				.create("text");
		AutoBinding<PoDetailComm, String, JTextField, String> autoBinding_24 = Bindings
				.createAutoBinding(UpdateStrategy.READ, poDetailComm,
						poDetailCommBeanProperty_24, o1_income_textField,
						jTextFieldBeanProperty_24, "income_o");
		autoBinding_24.bind();
		//
		BeanProperty<PoDetailECacctGroup, List<PoDetailECacct>> poDetailECacctGroupBeanProperty = BeanProperty
				.create("poDetailECaccts");
		JTableBinding<PoDetailECacct, PoDetailECacctGroup, JTable> jTableBinding = SwingBindings
				.createJTableBinding(UpdateStrategy.READ, ECacctGroup,
						poDetailECacctGroupBeanProperty, Accttable, "ECacct");
		//
		BeanProperty<PoDetailECacct, String> poDetailECacctBeanProperty = BeanProperty
				.create("active_sw");
		jTableBinding.addColumnBinding(poDetailECacctBeanProperty)
				.setColumnName("\u72C0\u614B").setEditable(false);
		//
		BeanProperty<PoDetailECacct, String> poDetailECacctBeanProperty_1 = BeanProperty
				.create("currency_ind");
		jTableBinding.addColumnBinding(poDetailECacctBeanProperty_1)
				.setColumnName("\u5E63\u5225").setEditable(false);
		//
		BeanProperty<PoDetailECacct, String> poDetailECacctBeanProperty_2 = BeanProperty
				.create("acct_source");
		jTableBinding.addColumnBinding(poDetailECacctBeanProperty_2)
				.setColumnName("\u985E\u5225").setEditable(false);
		//
		BeanProperty<PoDetailECacct, String> poDetailECacctBeanProperty_3 = BeanProperty
				.create("payee");
		jTableBinding.addColumnBinding(poDetailECacctBeanProperty_3)
				.setColumnName("\u6236\u540D").setEditable(false);
		//
		BeanProperty<PoDetailECacct, String> poDetailECacctBeanProperty_4 = BeanProperty
				.create("payee_e");
		jTableBinding.addColumnBinding(poDetailECacctBeanProperty_4)
				.setColumnName("\u6236\u540D(\u82F1)");
		//
		ELProperty<PoDetailECacct, Object> poDetailECacctEvalutionProperty = ELProperty
				.create("${remit_bank} ${remit_branch}");
		jTableBinding.addColumnBinding(poDetailECacctEvalutionProperty)
				.setColumnName("\u532F\u6B3E\u9280\u884C").setEditable(false);
		//
		BeanProperty<PoDetailECacct, String> poDetailECacctBeanProperty_5 = BeanProperty
				.create("remit_account");
		jTableBinding.addColumnBinding(poDetailECacctBeanProperty_5)
				.setColumnName("\u5E33\u865F").setEditable(false);
		//
		BeanProperty<PoDetailECacct, String> poDetailECacctBeanProperty_6 = BeanProperty
				.create("bank_name");
		jTableBinding.addColumnBinding(poDetailECacctBeanProperty_6)
				.setColumnName("\u9280\u884C\u540D\u7A31").setEditable(false);
		//
		jTableBinding.setEditable(false);
		jTableBinding.bind();
		//
		BeanProperty<PoDetailECpasswdGroup, List<PoDetailECpasswd>> poDetailECpasswdGroupBeanProperty = BeanProperty
				.create("poDetailECpasswds");
		JTableBinding<PoDetailECpasswd, PoDetailECpasswdGroup, JTable> jTableBinding_1 = SwingBindings
				.createJTableBinding(UpdateStrategy.READ, ECpasswdGroup,
						poDetailECpasswdGroupBeanProperty, Passwdtable,
						"ECpasswd");
		//
		ELProperty<PoDetailECpasswd, Object> poDetailECpasswdEvalutionProperty = ELProperty
				.create("${pwd_sw} ${pwd_sw_desc}");
		jTableBinding_1.addColumnBinding(poDetailECpasswdEvalutionProperty)
				.setColumnName("\u5BC6\u78BC\u7B49\u7D1A");
		//
		BeanProperty<PoDetailECpasswd, String> poDetailECpasswdBeanProperty = BeanProperty
				.create("accu_lcnt");
		jTableBinding_1.addColumnBinding(poDetailECpasswdBeanProperty)
				.setColumnName("\u501F\u6B3E\u63D0\u9818\u6B21\u6578");
		//
		BeanProperty<PoDetailECpasswd, String> poDetailECpasswdBeanProperty_1 = BeanProperty
				.create("accu_ecnt");
		jTableBinding_1.addColumnBinding(poDetailECpasswdBeanProperty_1)
				.setColumnName("\u7D2F\u7A4D\u932F\u8AA4\u6B21\u6578");
		//
		jTableBinding_1.setEditable(false);
		jTableBinding_1.bind();
		//
		BeanProperty<PoDetailECinsuredGroup, List<PoDetailECinsured>> poDetailECinsuredGroupBeanProperty = BeanProperty
				.create("poDetailECinsureds");
		JTableBinding<PoDetailECinsured, PoDetailECinsuredGroup, JTable> jTableBinding_2 = SwingBindings
				.createJTableBinding(UpdateStrategy.READ, ECinsuredGroup,
						poDetailECinsuredGroupBeanProperty, Insuredtable,
						"ECinsured");
		//
		BeanProperty<PoDetailECinsured, String> poDetailECinsuredBeanProperty = BeanProperty
				.create("active_sw");
		jTableBinding_2.addColumnBinding(poDetailECinsuredBeanProperty)
				.setColumnName("\u8A0A\u606F");
		//
		ELProperty<PoDetailECinsured, Object> poDetailECinsuredEvalutionProperty = ELProperty
				.create("${insured_id} / ${insured_name}");
		jTableBinding_2.addColumnBinding(poDetailECinsuredEvalutionProperty)
				.setColumnName("\u88AB\u4FDD\u96AA\u4EBA");
		//
		BeanProperty<PoDetailECinsured, String> poDetailECinsuredBeanProperty_1 = BeanProperty
				.create("policy_no");
		jTableBinding_2.addColumnBinding(poDetailECinsuredBeanProperty_1)
				.setColumnName("\u4FDD\u55AE\u865F\u78BC");
		//
		BeanProperty<PoDetailECinsured, String> poDetailECinsuredBeanProperty_2 = BeanProperty
				.create("po_sts_code");
		jTableBinding_2.addColumnBinding(poDetailECinsuredBeanProperty_2)
				.setColumnName("\u4FDD\u55AE\u72C0\u614B");
		//
		ELProperty<PoDetailECinsured, Object> poDetailECinsuredEvalutionProperty_1 = ELProperty
				.create("${bank_id}-${account_no}");
		jTableBinding_2.addColumnBinding(poDetailECinsuredEvalutionProperty_1)
				.setColumnName("\u9280\u884C\u4EE3\u78BC\u53CA\u5E33\u865F");
		//
		jTableBinding_2.setEditable(false);
		jTableBinding_2.bind();
		//
		BeanProperty<PoDetailECprintGroup, List<PoDetailECprint>> poDetailECprintGroupBeanProperty = BeanProperty
				.create("poDetailECprints");
		JTableBinding<PoDetailECprint, PoDetailECprintGroup, JTable> jTableBinding_3 = SwingBindings
				.createJTableBinding(UpdateStrategy.READ, ECprintGroup,
						poDetailECprintGroupBeanProperty, PWDprinttable,
						"ECprint");
		//
		BeanProperty<PoDetailECprint, String> poDetailECprintBeanProperty = BeanProperty
				.create("print_style_desc");
		jTableBinding_3.addColumnBinding(poDetailECprintBeanProperty)
				.setColumnName("\u5217\u5370\u65B9\u5F0F");
		//
		BeanProperty<PoDetailECprint, String> poDetailECprintBeanProperty_1 = BeanProperty
				.create("prt_op_desc");
		jTableBinding_3.addColumnBinding(poDetailECprintBeanProperty_1)
				.setColumnName("\u5217\u5370\u9805\u76EE");
		//
		BeanProperty<PoDetailECprint, String> poDetailECprintBeanProperty_2 = BeanProperty
				.create("print_date");
		jTableBinding_3.addColumnBinding(poDetailECprintBeanProperty_2)
				.setColumnName("\u5217\u5370\u65E5\u671F");
		//
		BeanProperty<PoDetailECprint, String> poDetailECprintBeanProperty_3 = BeanProperty
				.create("overdue_date");
		jTableBinding_3.addColumnBinding(poDetailECprintBeanProperty_3)
				.setColumnName("\u5931\u6548\u65E5\u671F");
		//
		BeanProperty<PoDetailECprint, String> poDetailECprintBeanProperty_4 = BeanProperty
				.create("user_name");
		jTableBinding_3.addColumnBinding(poDetailECprintBeanProperty_4)
				.setColumnName("\u5217\u5370\u8005");
		//
		BeanProperty<PoDetailECprint, String> poDetailECprintBeanProperty_5 = BeanProperty
				.create("address");
		jTableBinding_3.addColumnBinding(poDetailECprintBeanProperty_5)
				.setColumnName("\u90F5\u5BC4\u5730\u5740");
		//
		jTableBinding_3.setEditable(false);
		jTableBinding_3.bind();
		//
		BeanProperty<PoDetailComm, String> poDetailCommBeanProperty_1 = BeanProperty
				.create("income_i");
		BeanProperty<JTextField, String> jTextFieldBeanProperty_1 = BeanProperty
				.create("text");
		AutoBinding<PoDetailComm, String, JTextField, String> autoBinding_1 = Bindings
				.createAutoBinding(UpdateStrategy.READ, poDetailComm,
						poDetailCommBeanProperty_1, i1_income_textField,
						jTextFieldBeanProperty_1, "income_i");
		autoBinding_1.bind();
		//
		BeanProperty<PoDetailComm, String> poDetailCommBeanProperty_2 = BeanProperty
				.create("income_f");
		BeanProperty<JTextField, String> jTextFieldBeanProperty_2 = BeanProperty
				.create("text");
		AutoBinding<PoDetailComm, String, JTextField, String> autoBinding_2 = Bindings
				.createAutoBinding(UpdateStrategy.READ, poDetailComm,
						poDetailCommBeanProperty_2, family_income_textField,
						jTextFieldBeanProperty_2, "income_f");
		autoBinding_2.bind();
	}
}
