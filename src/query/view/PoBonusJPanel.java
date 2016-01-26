package query.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.HashMap;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.Bindings;
import org.jdesktop.beansbinding.ELProperty;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

import query.model.PoBonus.PoBonus;
import query.model.PoBonus.PoBonusList;
import query.model.PoBonus.PoBonusListGroup;


/**
 * @ * @author YIHUA
 * 
 * @version 1.0<br>
 *          100/08/03<br>
 *          紅利查詢JPanel
 * 
 * @since 1.0
 */

public class PoBonusJPanel extends JPanel {
	
		
	private static final long serialVersionUID = 1L;
//	private PoBonusGroup group = new PoBonusGroup();
	private PoBonus poBonus = new PoBonus();
	private PoBonusListGroup listGroup = new PoBonusListGroup();			
	
	private JTable listtable;
	private JTextField policy_no;
	private JTextField div_option;
	private JTextField po_sts_code;
	private JTextField applicant_name;
	private JTextField insured_name;
	private JTextField last_div_dur;
	private JTextField div_this_year;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_11;
	private JTextField cal_date;
	private JTextField accumulated_div;
	private JTextField div_int;
	private JTextField div_total;
	private JPanel panel;
	private JPanel bonustable;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel_1;

	/**
	 * Create the panel.
	 */
	public PoBonusJPanel() {
		setLayout(new BorderLayout(0, 0));
		
		bonustable = new JPanel();
		add(bonustable, BorderLayout.NORTH);
		bonustable.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u57FA\u672C\u8CC7\u6599", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(139, 69, 19)));
		GridBagLayout gbl_bonustable = new GridBagLayout();
		gbl_bonustable.columnWidths = new int[]{0, 70, 0, 70, 0, 89, 1, 0};
		gbl_bonustable.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_bonustable.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_bonustable.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		bonustable.setLayout(gbl_bonustable);
		
		JLabel lblNewLabel = new JLabel("\u4FDD\u55AE\u865F\u78BC");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		bonustable.add(lblNewLabel, gbc_lblNewLabel);
		
		policy_no = new JTextField();
		policy_no.setEditable(false);
		policy_no.setBackground(Color.WHITE);
		GridBagConstraints gbc_policy_no = new GridBagConstraints();
		gbc_policy_no.fill = GridBagConstraints.HORIZONTAL;
		gbc_policy_no.insets = new Insets(0, 0, 5, 5);
		gbc_policy_no.gridx = 1;
		gbc_policy_no.gridy = 0;
		bonustable.add(policy_no, gbc_policy_no);
		policy_no.setColumns(10);
		
		lblNewLabel_1 = new JLabel("\u7D05\u5229\u9078\u64C7");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 2;
		gbc_lblNewLabel_1.gridy = 0;
		bonustable.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		div_option = new JTextField();
		div_option.setEditable(false);
		div_option.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_div_option = new GridBagConstraints();
		gbc_div_option.insets = new Insets(0, 0, 5, 5);
		gbc_div_option.fill = GridBagConstraints.HORIZONTAL;
		gbc_div_option.gridx = 3;
		gbc_div_option.gridy = 0;
		bonustable.add(div_option, gbc_div_option);
		div_option.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u5132\u5B58\u8A08\u606F");
		lblNewLabel_2.setFont(new Font("新細明體", Font.PLAIN, 15));
		lblNewLabel_2.setBackground(new Color(152, 251, 152));
		lblNewLabel_2.setForeground(new Color(0, 0, 255));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.gridwidth = 3;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 4;
		gbc_lblNewLabel_2.gridy = 0;
		bonustable.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u4FDD\u55AE\u72C0\u614B");
		lblNewLabel_3.setBackground(new Color(0, 191, 255));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 1;
		bonustable.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		po_sts_code = new JTextField();
		po_sts_code.setEditable(false);
		po_sts_code.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_po_sts_code = new GridBagConstraints();
		gbc_po_sts_code.fill = GridBagConstraints.HORIZONTAL;
		gbc_po_sts_code.insets = new Insets(0, 0, 5, 5);
		gbc_po_sts_code.gridx = 1;
		gbc_po_sts_code.gridy = 1;
		bonustable.add(po_sts_code, gbc_po_sts_code);
		po_sts_code.setColumns(10);
		
		lblNewLabel_6 = new JLabel("\u7D66\u4ED8\u5E74\u5EA6");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.gridx = 2;
		gbc_lblNewLabel_6.gridy = 1;
		bonustable.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		last_div_dur = new JTextField();
		last_div_dur.setEditable(false);
		last_div_dur.setBackground(Color.WHITE);
		GridBagConstraints gbc_last_div_dur = new GridBagConstraints();
		gbc_last_div_dur.insets = new Insets(0, 0, 5, 5);
		gbc_last_div_dur.fill = GridBagConstraints.HORIZONTAL;
		gbc_last_div_dur.gridx = 3;
		gbc_last_div_dur.gridy = 1;
		bonustable.add(last_div_dur, gbc_last_div_dur);
		last_div_dur.setColumns(10);
		
		lblNewLabel_8 = new JLabel("\u8A08\u606F\u65E5");
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.gridx = 4;
		gbc_lblNewLabel_8.gridy = 1;
		bonustable.add(lblNewLabel_8, gbc_lblNewLabel_8);
		
		cal_date = new JTextField();
		cal_date.setEditable(false);
		cal_date.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_cal_date = new GridBagConstraints();
		gbc_cal_date.insets = new Insets(0, 0, 5, 5);
		gbc_cal_date.fill = GridBagConstraints.HORIZONTAL;
		gbc_cal_date.gridx = 5;
		gbc_cal_date.gridy = 1;
		bonustable.add(cal_date, gbc_cal_date);
		cal_date.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("\u8981\u4FDD\u4EBA");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 2;
		bonustable.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		applicant_name = new JTextField();
		applicant_name.setEditable(false);
		applicant_name.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_applicant_name = new GridBagConstraints();
		gbc_applicant_name.fill = GridBagConstraints.HORIZONTAL;
		gbc_applicant_name.insets = new Insets(0, 0, 5, 5);
		gbc_applicant_name.gridx = 1;
		gbc_applicant_name.gridy = 2;
		bonustable.add(applicant_name, gbc_applicant_name);
		applicant_name.setColumns(10);
		
		lblNewLabel_7 = new JLabel("\u7D66\u4ED8\u7D05\u5229");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_7.gridx = 2;
		gbc_lblNewLabel_7.gridy = 2;
		bonustable.add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		div_this_year = new JTextField();
		div_this_year.setEditable(false);
		div_this_year.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_div_this_year = new GridBagConstraints();
		gbc_div_this_year.insets = new Insets(0, 0, 5, 5);
		gbc_div_this_year.fill = GridBagConstraints.HORIZONTAL;
		gbc_div_this_year.gridx = 3;
		gbc_div_this_year.gridy = 2;
		bonustable.add(div_this_year, gbc_div_this_year);
		div_this_year.setColumns(10);
		
		lblNewLabel_9 = new JLabel("\u7D05\u5229\u91D1\u984D");
		GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
		gbc_lblNewLabel_9.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_9.gridx = 4;
		gbc_lblNewLabel_9.gridy = 2;
		bonustable.add(lblNewLabel_9, gbc_lblNewLabel_9);
		
		accumulated_div = new JTextField();
		accumulated_div.setEditable(false);
		accumulated_div.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_accumulated_div = new GridBagConstraints();
		gbc_accumulated_div.insets = new Insets(0, 0, 5, 5);
		gbc_accumulated_div.fill = GridBagConstraints.HORIZONTAL;
		gbc_accumulated_div.gridx = 5;
		gbc_accumulated_div.gridy = 2;
		bonustable.add(accumulated_div, gbc_accumulated_div);
		accumulated_div.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("\u88AB\u4FDD\u4EBA");
		lblNewLabel_5.setBackground(new Color(0, 191, 255));
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 3;
		bonustable.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		insured_name = new JTextField();
		insured_name.setEditable(false);
		insured_name.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_insured_name = new GridBagConstraints();
		gbc_insured_name.fill = GridBagConstraints.HORIZONTAL;
		gbc_insured_name.insets = new Insets(0, 0, 5, 5);
		gbc_insured_name.gridx = 1;
		gbc_insured_name.gridy = 3;
		bonustable.add(insured_name, gbc_insured_name);
		insured_name.setColumns(10);
		
		lblNewLabel_10 = new JLabel("\u7D05\u5229\u5229\u606F");
		GridBagConstraints gbc_lblNewLabel_10 = new GridBagConstraints();
		gbc_lblNewLabel_10.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_10.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_10.gridx = 4;
		gbc_lblNewLabel_10.gridy = 3;
		bonustable.add(lblNewLabel_10, gbc_lblNewLabel_10);
		
		div_int = new JTextField();
		div_int.setEditable(false);
		div_int.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_div_int = new GridBagConstraints();
		gbc_div_int.insets = new Insets(0, 0, 5, 5);
		gbc_div_int.fill = GridBagConstraints.HORIZONTAL;
		gbc_div_int.gridx = 5;
		gbc_div_int.gridy = 3;
		bonustable.add(div_int, gbc_div_int);
		div_int.setColumns(10);
		
		lblNewLabel_11 = new JLabel("\u5408\u8A08\u91D1\u984D");
		GridBagConstraints gbc_lblNewLabel_11 = new GridBagConstraints();
		gbc_lblNewLabel_11.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_11.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_11.gridx = 4;
		gbc_lblNewLabel_11.gridy = 4;
		bonustable.add(lblNewLabel_11, gbc_lblNewLabel_11);
		
		div_total = new JTextField();
		div_total.setEditable(false);
		div_total.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_div_total = new GridBagConstraints();
		gbc_div_total.insets = new Insets(0, 0, 0, 5);
		gbc_div_total.fill = GridBagConstraints.HORIZONTAL;
		gbc_div_total.gridx = 5;
		gbc_div_total.gridy = 4;
		bonustable.add(div_total, gbc_div_total);
		div_total.setColumns(10);
		
		panel = new JPanel();
		panel.setForeground(new Color(0, 0, 0));
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u660E\u7D30\u8CC7\u6599", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(139, 69, 19)));
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(153, 84, 10)));
		panel.add(scrollPane);
		
		listtable = new JTable();
		listtable.setColumnSelectionAllowed(true);
		scrollPane.setViewportView(listtable);
		initDataBindings();

	}
	/**
	 * 新增紅利資料至紅利群組(PoBonusGroup)
	 * 
	 * @param pobonus
	 *            PoBonus物件
	 */

//	public void clearPoBonus() {
//		group.removeAll();
//		
//	}

//	public void addBonus(PoBonus bonus) {
//		group.addBonus(bonus);
//		
//	}
	/**
	 * 新增紅利明細資料至紅利明細群組(PoBonusListGroup)
	 * 
	 * @param bonuslists
	 *            BonusList物件
	 */
	public void clearPoBonusLists() {
		listGroup.removeAll();
		
	}
	
	public void addPoBonusLists(PoBonusList bonus) {
		listGroup.addPoBonusList(bonus);
		
	}

	public PoBonus getPoBonus() {
		return poBonus;
	}

	public void setPoBonus(HashMap<String, String> hsmap) {
		poBonus.setValues(hsmap);
	}


	public void clearPoBonus() {
		listGroup.removeAll();
				
	}
	
	public void nullAll() {
		poBonus   = null;
		listGroup  = null;
	}
	protected void initDataBindings() {
		BeanProperty<PoBonus, String> poBonusBeanProperty = BeanProperty.create("policy_no");
		BeanProperty<JTextField, String> jTextFieldBeanProperty = BeanProperty.create("text");
		AutoBinding<PoBonus, String, JTextField, String> autoBinding = Bindings.createAutoBinding(UpdateStrategy.READ, poBonus, poBonusBeanProperty, policy_no, jTextFieldBeanProperty);
		autoBinding.bind();
		//
		BeanProperty<PoBonus, String> poBonusBeanProperty_3 = BeanProperty.create("last_div_dur");
		BeanProperty<JTextField, String> jTextFieldBeanProperty_3 = BeanProperty.create("text");
		AutoBinding<PoBonus, String, JTextField, String> autoBinding_3 = Bindings.createAutoBinding(UpdateStrategy.READ, poBonus, poBonusBeanProperty_3, last_div_dur, jTextFieldBeanProperty_3);
		autoBinding_3.bind();
		//
		BeanProperty<PoBonus, String> poBonusBeanProperty_4 = BeanProperty.create("cal_date");
		BeanProperty<JTextField, String> jTextFieldBeanProperty_4 = BeanProperty.create("text");
		AutoBinding<PoBonus, String, JTextField, String> autoBinding_4 = Bindings.createAutoBinding(UpdateStrategy.READ, poBonus, poBonusBeanProperty_4, cal_date, jTextFieldBeanProperty_4);
		autoBinding_4.bind();
		//
		BeanProperty<PoBonus, String> poBonusBeanProperty_5 = BeanProperty.create("applicant_name");
		BeanProperty<JTextField, String> jTextFieldBeanProperty_5 = BeanProperty.create("text");
		AutoBinding<PoBonus, String, JTextField, String> autoBinding_5 = Bindings.createAutoBinding(UpdateStrategy.READ, poBonus, poBonusBeanProperty_5, applicant_name, jTextFieldBeanProperty_5);
		autoBinding_5.bind();
		//
		BeanProperty<PoBonus, String> poBonusBeanProperty_7 = BeanProperty.create("accumulated_div");
		BeanProperty<JTextField, String> jTextFieldBeanProperty_7 = BeanProperty.create("text");
		AutoBinding<PoBonus, String, JTextField, String> autoBinding_7 = Bindings.createAutoBinding(UpdateStrategy.READ, poBonus, poBonusBeanProperty_7, accumulated_div, jTextFieldBeanProperty_7);
		autoBinding_7.bind();
		//
		BeanProperty<PoBonus, String> poBonusBeanProperty_6 = BeanProperty.create("div_this_year");
		BeanProperty<JTextField, String> jTextFieldBeanProperty_6 = BeanProperty.create("text");
		AutoBinding<PoBonus, String, JTextField, String> autoBinding_6 = Bindings.createAutoBinding(UpdateStrategy.READ, poBonus, poBonusBeanProperty_6, div_this_year, jTextFieldBeanProperty_6);
		autoBinding_6.bind();
		//
		BeanProperty<PoBonus, String> poBonusBeanProperty_8 = BeanProperty.create("insured_name");
		BeanProperty<JTextField, String> jTextFieldBeanProperty_8 = BeanProperty.create("text");
		AutoBinding<PoBonus, String, JTextField, String> autoBinding_8 = Bindings.createAutoBinding(UpdateStrategy.READ, poBonus, poBonusBeanProperty_8, insured_name, jTextFieldBeanProperty_8);
		autoBinding_8.bind();
		//
		BeanProperty<PoBonus, String> poBonusBeanProperty_9 = BeanProperty.create("div_int");
		BeanProperty<JTextField, String> jTextFieldBeanProperty_9 = BeanProperty.create("text");
		AutoBinding<PoBonus, String, JTextField, String> autoBinding_9 = Bindings.createAutoBinding(UpdateStrategy.READ, poBonus, poBonusBeanProperty_9, div_int, jTextFieldBeanProperty_9);
		autoBinding_9.bind();
		//
		BeanProperty<PoBonus, String> poBonusBeanProperty_10 = BeanProperty.create("div_total");
		BeanProperty<JTextField, String> jTextFieldBeanProperty_10 = BeanProperty.create("text");
		AutoBinding<PoBonus, String, JTextField, String> autoBinding_10 = Bindings.createAutoBinding(UpdateStrategy.READ, poBonus, poBonusBeanProperty_10, div_total, jTextFieldBeanProperty_10);
		autoBinding_10.bind();
		//
		ELProperty<PoBonus, Object> poBonusEvalutionProperty = ELProperty.create("${po_sts_code}${po_sts_desc}");
		BeanProperty<JTextField, String> jTextFieldBeanProperty_11 = BeanProperty.create("text");
		AutoBinding<PoBonus, Object, JTextField, String> autoBinding_11 = Bindings.createAutoBinding(UpdateStrategy.READ, poBonus, poBonusEvalutionProperty, po_sts_code, jTextFieldBeanProperty_11);
		autoBinding_11.bind();
		//
		ELProperty<PoBonus, Object> poBonusEvalutionProperty_1 = ELProperty.create("${div_option_desc1}");
		BeanProperty<JTextField, String> jTextFieldBeanProperty_2 = BeanProperty.create("text");
		AutoBinding<PoBonus, Object, JTextField, String> autoBinding_1 = Bindings.createAutoBinding(UpdateStrategy.READ, poBonus, poBonusEvalutionProperty_1, div_option, jTextFieldBeanProperty_2);
		autoBinding_1.bind();
		//
		BeanProperty<PoBonusListGroup, List<PoBonusList>> poBonusListGroupBeanProperty = BeanProperty.create("bonuslists");
		JTableBinding<PoBonusList, PoBonusListGroup, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, listGroup, poBonusListGroupBeanProperty, listtable);
		//
		BeanProperty<PoBonusList, String> poBonusListBeanProperty = BeanProperty.create("plan_code");
		jTableBinding.addColumnBinding(poBonusListBeanProperty).setColumnName("\u4FDD\u55AE\u72C0\u614B\u78BC");
		//
		BeanProperty<PoBonusList, String> poBonusListBeanProperty_1 = BeanProperty.create("rate_scale");
		jTableBinding.addColumnBinding(poBonusListBeanProperty_1).setColumnName("\u96AA\u7A2E\u7248\u6578");
		//
		BeanProperty<PoBonusList, String> poBonusListBeanProperty_2 = BeanProperty.create("pua_this_year");
		jTableBinding.addColumnBinding(poBonusListBeanProperty_2).setColumnName("\u5E74\u5EA6PUA\u4FDD\u984D");
		//
		BeanProperty<PoBonusList, String> poBonusListBeanProperty_3 = BeanProperty.create("accumulated_pua");
		jTableBinding.addColumnBinding(poBonusListBeanProperty_3).setColumnName("\u6B77\u5E74\u5EA6PUA\u7D2F\u7A4D\u4FDD\u984D");
		//
		jTableBinding.setEditable(false);
		jTableBinding.bind();
	}
}
