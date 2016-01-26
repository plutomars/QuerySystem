package query.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.DefaultListSelectionModel;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

import query.controller.PremBldtController;
import query.model.PremBldt.PremBldt;
import query.model.PremBldt.PremBldt01;
import query.model.PremBldt.PremBldt01Group;
import query.model.PremBldt.PremBldt02;
import query.model.PremBldt.PremBldt02Group;
import query.model.PremBldt.PremBldt03;
import query.model.PremBldt.PremBldt03Group;
import query.model.PremBldt.PremBldtGroup;
import query.model.PremBldt.PremBldtQuery01;

/**
 * 
 * @author cychu
 * 
 * @version 1.0<br/>
 * 			101/04/11<br/>
 * 			�e���O���d�ߵe��
 * 
 * @since 1.0
 *
 */
public class PremBldtJPanel extends JPanel implements ListSelectionListener {
	private static final long serialVersionUID = 1L;
	private SpringLayout sl = new SpringLayout();
	private VerticalPane topPane1, topPane2, topPane3;
	private VerticalPane btmPane1, btmPane2;
	private JTable premBldtTable, premBldt03Table;
	private JLabel jLblPMSts;
	private PremBldtGroup pbg = new PremBldtGroup();
	private PremBldt01Group pb01g = new PremBldt01Group();
	private PremBldt02Group pb02g = new PremBldt02Group();
	private PremBldt03Group pb03g = new PremBldt03Group();
	private PremBldtController premBldtController;

	public PremBldtJPanel() {
		setLayout(sl);
		
		//�W��VerticalPane
		JPanel panel_top1 = new JPanel(new BorderLayout());
		String[] headers1 = {" �O�渹�X", " �O�檬�A", " �ͮĤ��",
				" �Q�O�I�H", " �n�O�H", " ú�k", " ���O�覡"};
		topPane1 = new VerticalPane(headers1, "", 100, 25);
		panel_top1.add(topPane1);
		
		JPanel panel_top2 = new JPanel(new BorderLayout());
		String[] headers2 = {" ��ú�O��", " �e�������", 	" �����O�O", 
				" ��l�O�O", " ��/��ú", " �馩���B"};
		topPane2 = new VerticalPane(headers2, "", 100, 25);
		panel_top2.add(topPane2);
		
		JPanel panel_top3 = new JPanel(new BorderLayout());
		String[] headers3 = {" ���Q���B", " �^�X���ɪ�", 	" ���O�N�X", 
				" ���O��", " ���O�ϰ�", " �馩����"};
		topPane3 = new VerticalPane(headers3, "", 100, 25);
		panel_top3.add(topPane3);
		
		JPanel panel_top = new JPanel(new GridLayout(0, 3));
		panel_top.add(panel_top1);
		panel_top.add(panel_top2);
		panel_top.add(panel_top3);
		sl.putConstraint(SpringLayout.WEST, panel_top, 0, SpringLayout.WEST, this);
		sl.putConstraint(SpringLayout.EAST, panel_top, 0, SpringLayout.EAST, this);
		sl.putConstraint(SpringLayout.NORTH, panel_top, 0, SpringLayout.NORTH, this);
		sl.putConstraint(SpringLayout.SOUTH, panel_top, 177, SpringLayout.NORTH, this);
		add(panel_top);
		
		//����ScrollPane(�tJTable)
		premBldtTable = new JTable();
		premBldtTable.setToolTipText("�I���H��ܤU�����");
		premBldtTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		premBldtTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		ListSelectionModel model = premBldtTable.getSelectionModel();
		model.addListSelectionListener(this);
		JScrollPane premBldtPane = new JScrollPane(premBldtTable);
		
		//����Panel - �e���O��
		JPanel panel_mid = new JPanel(new BorderLayout());
		panel_mid.setBorder(new TitledBorder(
				null,
				"�e���O��",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_mid.add(premBldtPane,BorderLayout.CENTER);
		sl.putConstraint(SpringLayout.WEST, panel_mid, 0, SpringLayout.WEST, this);
		sl.putConstraint(SpringLayout.EAST, panel_mid, 0, SpringLayout.EAST, this);
		sl.putConstraint(SpringLayout.NORTH, panel_mid, 0, SpringLayout.SOUTH, panel_top);
		sl.putConstraint(SpringLayout.SOUTH, panel_mid, 290, SpringLayout.NORTH, panel_mid);
		add(panel_mid);
		
		//�U��Tab1 - ����VerticalPane
		JPanel panel_btm1 = new JPanel(new BorderLayout());
		String[] headers4 = {" ��l�O�O", " ���O�O", " ���O�O���B",
				" �k�ɧ妸", " ���O�v", " �w���O�O", " E-Billing"};
		btmPane1 = new VerticalPane(headers4, "", 100, 25);
		panel_btm1.add(btmPane1);
		
		//�U��Tab1 - �k��Panel
		JPanel panel_btm2 = new JPanel(sl);
		
		//�U��Tab1 - �k�W��Label(�DPM��r��)
		JPanel panel_btm2_sub = new JPanel(new BorderLayout());
		jLblPMSts = new JLabel("", SwingConstants.CENTER);
		jLblPMSts.setForeground(Color.RED);
		panel_btm2_sub.add(jLblPMSts, BorderLayout.CENTER);
		sl.putConstraint(SpringLayout.WEST, panel_btm2_sub, 0, SpringLayout.WEST, panel_btm2);
		sl.putConstraint(SpringLayout.EAST, panel_btm2_sub, 0, SpringLayout.EAST, panel_btm2);
		sl.putConstraint(SpringLayout.NORTH, panel_btm2_sub, 0, SpringLayout.NORTH, panel_btm2);
		sl.putConstraint(SpringLayout.SOUTH, panel_btm2_sub, 25, SpringLayout.NORTH, panel_btm2_sub);
		panel_btm2.add(panel_btm2_sub);
		
		//�U��Tab1 - �k��VerticalPane
		String[] headers5 = {" ��ú�O��", " ú��", " ��l�O�O",
				" �J�b���", " �O�O�馩", " �馩�v"};
		btmPane2 = new VerticalPane(headers5, "", 100, 25);
		sl.putConstraint(SpringLayout.WEST, btmPane2, 0, SpringLayout.WEST, panel_btm2);
		sl.putConstraint(SpringLayout.EAST, btmPane2, 0, SpringLayout.EAST, panel_btm2);
		sl.putConstraint(SpringLayout.NORTH, btmPane2, 0, SpringLayout.SOUTH, panel_btm2_sub);
		sl.putConstraint(SpringLayout.SOUTH, btmPane2, 0, SpringLayout.SOUTH, panel_btm2);
		panel_btm2.add(btmPane2);
		
		//�U��Tab1
		JPanel tab_panel1 = new JPanel(new GridLayout(0, 2));
		tab_panel1.add(panel_btm1);
		tab_panel1.add(panel_btm2);
		
		//�U��Tab2 - ScrollPane(�tJTable)
		premBldt03Table = new JTable();
		premBldt03Table.setToolTipText("�I���H��ܤU�����");
		premBldt03Table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		premBldt03Table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		ListSelectionModel model2 = premBldt03Table.getSelectionModel();
		model2.addListSelectionListener(this);
		JScrollPane premBldt03Pane = new JScrollPane(premBldt03Table);
		
		//�U��Tab2 - Panel - �ק���v
		JPanel tab_panel2 = new JPanel(new BorderLayout());
		tab_panel2.add(premBldt03Pane,BorderLayout.CENTER);
		
		//�U��TabbedPane
		JTabbedPane pane_btm = new JTabbedPane();
		pane_btm.add(" �e������ ", tab_panel1);
		pane_btm.add(" �ק���v ", tab_panel2);
		sl.putConstraint(SpringLayout.WEST, pane_btm, 0, SpringLayout.WEST, this);
		sl.putConstraint(SpringLayout.EAST, pane_btm, 0, SpringLayout.EAST, this);
		sl.putConstraint(SpringLayout.NORTH, pane_btm, 0, SpringLayout.SOUTH, panel_mid);
		sl.putConstraint(SpringLayout.SOUTH, pane_btm, 0, SpringLayout.SOUTH, this);
		add(pane_btm);	
		initDataBindings();
	}
	
	@Override
	public void valueChanged(ListSelectionEvent lse) {
		if (!((DefaultListSelectionModel) lse.getSource()).getValueIsAdjusting()) {
			int rowSelected = premBldtTable.getSelectedRow();

			jLblPMSts.setText("");
			clearPremBldt02s();
			clearPremBldt03s();
			//����ܸ��
			if (rowSelected != -1) {
				insertPanelBtmValue(rowSelected);
				if (pb01g.getPremBldt01s().get(rowSelected).getBldt_sts_desc()
						.substring(0, 2).equals("PM")) {
					premBldtController.executeInnerMission(
							pb01g.getPremBldt01s().get(rowSelected).getBill_no(),
							pb01g.getPremBldt01s().get(rowSelected).getRelated_key(),
							PremBldtQuery01.PREMBLDT02);
					String[] values1 = pb02g.getPremBldt02s().get(0).getValues();
					btmPane2.setValue(values1);
				} else {
					jLblPMSts.setText("�DPM��L�J�b���!");
				}
				premBldtController.executeInnerMission(
						pb01g.getPremBldt01s().get(rowSelected).getBill_no(),
						pb01g.getPremBldt01s().get(rowSelected).getRelated_key(),
						PremBldtQuery01.PREMBLDT03);
			}
		}
	}
	
	/**
	 * ���J�W��VerticalPane���
	 */
	public void insertPanelTopValue() {
		String values1[] = pbg.getPremBldts().get(0).getValues(1);
		topPane1.setValue(values1);
		String values2[] = pbg.getPremBldts().get(0).getValues(2);
		topPane2.setValue(values2);
		String values3[] = pbg.getPremBldts().get(0).getValues(3);
		topPane3.setValue(values3);
	}
	
	public void insertPanelBtmValue(int rowSelected) {
		String values4[] = pb01g.getPremBldt01s().get(rowSelected).getValues();
		btmPane1.setValue(values4);
	}
	
	/**
	 * �s�W�e���O���а򥻸�Ʀܸs��(PremBldtGroup)
	 * 
	 * @param premBldt
	 *            PremBldt����
	 */
	public void addPremBldt(PremBldt premBldt) {
		pbg.addPremBldt(premBldt);
	}
	
	/**
	 * �M���e���O���а򥻸�Ƹs�դ����Ҧ��խ�(PremBldtGroup)
	 */
	public void clearPremBldts() {
		pbg.removeAll();
		topPane1.setValue(new String[6]);
		topPane2.setValue(new String[6]);
		topPane3.setValue(new String[6]);
	}
	
	/**
	 * �s�W�e���O���аe����Ʀܸs��(PremBldt01Group)
	 * 
	 * @param premBldt01
	 *            PremBldt01����
	 */
	public void addPremBldt01(PremBldt01 premBldt01) {
		pb01g.addPremBldt01(premBldt01);
	}
	
	/**
	 * �M���e���O���аe����Ƹs�դ����Ҧ��խ�(PremBldt01Group)
	 */
	public void clearPremBldt01s() {
		pb01g.removeAll();
	}
	
	/**
	 * �s�W�e���O���ФJ�b��Ʀܸs��(PremBldt02Group)
	 * 
	 * @param premBldt02
	 *            PremBldt02����
	 */
	public void addPremBldt02(PremBldt02 premBldt02) {
		pb02g.addPremBldt02(premBldt02);
	}
	
	/**
	 * �M���e���O���ФJ�b��Ƹs�դ����Ҧ��խ�(PremBldt02Group)
	 */
	public void clearPremBldt02s() {
		pb02g.removeAll();
		btmPane1.setValue(new String[7]);
		btmPane2.setValue(new String[6]);
	}
	
	/**
	 * �s�W�e���O���Эק���v�ܸs��(PremBldt03Group)
	 * 
	 * @param premBldt03
	 *            PremBldt03����
	 */
	public void addPremBldt03(PremBldt03 premBldt03) {
		pb03g.addPremBldt03(premBldt03);
	}
	
	/**
	 * �M���e���O���Эק���v�s�դ����Ҧ��խ�(PremBldt03Group)
	 */
	public void clearPremBldt03s() {
		pb03g.removeAll();
	}
	
	/**
	 * �]�wController
	 */
	public void setController(PremBldtController controller) {
		premBldtController = controller;
	}

	/**
	 * �M���e���Ҧ����
	 */
	public void clearAll() {
		clearPremBldts();
		clearPremBldt01s();
		clearPremBldt02s();
		clearPremBldt03s();
	}

	/**
	 * �]�w�e����Ƭ�null
	 */
	public void nullAll() {
		pbg = null;
		pb01g = null;
		pb02g = null;
		pb03g = null;
		premBldtTable = null;
		premBldt03Table = null;
		topPane1 = null;
		topPane2 = null;
		topPane3 = null;
		btmPane1 = null;
		btmPane2 = null;
	}
	
	/**
	 * �w�]��ܲĤ@����ƪ�����
	 */
	public void setDefaultRow() {  
		if (premBldtTable.getRowCount() > 0) {	
			ListSelectionModel selectionModel = premBldtTable.getSelectionModel(); 
			selectionModel.setSelectionInterval(0, 0);
		}
	}
	protected void initDataBindings() {
		BeanProperty<PremBldt03Group, List<PremBldt03>> premBldt03GroupBeanProperty = BeanProperty.create("premBldt03s");
		JTableBinding<PremBldt03, PremBldt03Group, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, pb03g, premBldt03GroupBeanProperty, premBldt03Table);
		//
		BeanProperty<PremBldt03, String> premBldt03BeanProperty = BeanProperty.create("bill_sts_pre_desc");
		jTableBinding.addColumnBinding(premBldt03BeanProperty).setColumnName("\u8B8A\u66F4\u524D\u9001\u91D1\u72C0\u6CC1").setEditable(false);
		//
		BeanProperty<PremBldt03, String> premBldt03BeanProperty_1 = BeanProperty.create("collector_pre");
		jTableBinding.addColumnBinding(premBldt03BeanProperty_1).setColumnName("\u8B8A\u66F4\u524D\u6536\u8CBB\u54E1\u4EE3\u78BC").setEditable(false);
		//
		BeanProperty<PremBldt03, String> premBldt03BeanProperty_2 = BeanProperty.create("coll_rate_ind_pre");
		jTableBinding.addColumnBinding(premBldt03BeanProperty_2).setColumnName("\u8B8A\u66F4\u524D\u6536\u8CBB\u7387").setEditable(false);
		//
		BeanProperty<PremBldt03, String> premBldt03BeanProperty_3 = BeanProperty.create("mode_prem_pre");
		jTableBinding.addColumnBinding(premBldt03BeanProperty_3).setColumnName("\u8B8A\u66F4\u524D\u4FDD\u8CBB\u6536\u5165").setEditable(false);
		//
		BeanProperty<PremBldt03, String> premBldt03BeanProperty_4 = BeanProperty.create("bill_sts_new_desc");
		jTableBinding.addColumnBinding(premBldt03BeanProperty_4).setColumnName("\u8B8A\u66F4\u5F8C\u9001\u91D1\u72C0\u6CC1").setEditable(false);
		//
		BeanProperty<PremBldt03, String> premBldt03BeanProperty_5 = BeanProperty.create("collector_new");
		jTableBinding.addColumnBinding(premBldt03BeanProperty_5).setColumnName("\u8B8A\u66F4\u5F8C\u6536\u8CBB\u54E1\u4EE3\u78BC").setEditable(false);
		//
		BeanProperty<PremBldt03, String> premBldt03BeanProperty_6 = BeanProperty.create("coll_rate_ind_new");
		jTableBinding.addColumnBinding(premBldt03BeanProperty_6).setColumnName("\u8B8A\u66F4\u5F8C\u6536\u8CBB\u7387").setEditable(false);
		//
		BeanProperty<PremBldt03, String> premBldt03BeanProperty_7 = BeanProperty.create("mode_prem_new");
		jTableBinding.addColumnBinding(premBldt03BeanProperty_7).setColumnName("\u8B8A\u66F4\u5F8C\u4FDD\u8CBB\u6536\u5165").setEditable(false);
		//
		BeanProperty<PremBldt03, String> premBldt03BeanProperty_8 = BeanProperty.create("process_user_name");
		jTableBinding.addColumnBinding(premBldt03BeanProperty_8).setColumnName("\u8B8A\u66F4\u8005\u59D3\u540D").setEditable(false);
		//
		BeanProperty<PremBldt03, String> premBldt03BeanProperty_9 = BeanProperty.create("program_id");
		jTableBinding.addColumnBinding(premBldt03BeanProperty_9).setColumnName("\u7A0B\u5F0F\u4EE3\u78BC").setEditable(false);
		//
		BeanProperty<PremBldt03, String> premBldt03BeanProperty_10 = BeanProperty.create("process_date");
		jTableBinding.addColumnBinding(premBldt03BeanProperty_10).setColumnName("\u8655\u7406\u65E5\u671F").setEditable(false);
		//
		BeanProperty<PremBldt03, String> premBldt03BeanProperty_11 = BeanProperty.create("process_time");
		jTableBinding.addColumnBinding(premBldt03BeanProperty_11).setColumnName("\u8655\u7406\u6642\u9593").setEditable(false);
		//
		jTableBinding.setEditable(false);
		jTableBinding.bind();
		//
		BeanProperty<PremBldt01Group, List<PremBldt01>> premBldt01GroupBeanProperty = BeanProperty.create("premBldt01s");
		JTableBinding<PremBldt01, PremBldt01Group, JTable> jTableBinding_1 = SwingBindings.createJTableBinding(UpdateStrategy.READ, pb01g, premBldt01GroupBeanProperty, premBldtTable);
		//
		BeanProperty<PremBldt01, String> premBldt01BeanProperty = BeanProperty.create("seqno");
		jTableBinding_1.addColumnBinding(premBldt01BeanProperty).setColumnName("\u5E8F\u865F").setEditable(false);
		//
		BeanProperty<PremBldt01, String> premBldt01BeanProperty_1 = BeanProperty.create("bill_no");
		jTableBinding_1.addColumnBinding(premBldt01BeanProperty_1).setColumnName("\u9001\u91D1\u55AE\u865F").setEditable(false);
		//
		BeanProperty<PremBldt01, String> premBldt01BeanProperty_2 = BeanProperty.create("bldt_sts_desc");
		jTableBinding_1.addColumnBinding(premBldt01BeanProperty_2).setColumnName("\u72C0\u614B").setEditable(false);
		//
		BeanProperty<PremBldt01, String> premBldt01BeanProperty_3 = BeanProperty.create("bill_date_from");
		jTableBinding_1.addColumnBinding(premBldt01BeanProperty_3).setColumnName("\u61C9\u7E73\u8CBB\u65E5").setEditable(false);
		//
		BeanProperty<PremBldt01, String> premBldt01BeanProperty_4 = BeanProperty.create("collector");
		jTableBinding_1.addColumnBinding(premBldt01BeanProperty_4).setColumnName("\u6536\u8CBB\u54E1\u4EE3\u78BC").setEditable(false);
		//
		BeanProperty<PremBldt01, String> premBldt01BeanProperty_5 = BeanProperty.create("collector_name");
		jTableBinding_1.addColumnBinding(premBldt01BeanProperty_5).setColumnName("\u6536\u8CBB\u54E1").setEditable(false);
		//
		BeanProperty<PremBldt01, String> premBldt01BeanProperty_6 = BeanProperty.create("mode_prem");
		jTableBinding_1.addColumnBinding(premBldt01BeanProperty_6).setColumnName("\u5165\u5E33\u4FDD\u8CBB").setEditable(false);
		//
		BeanProperty<PremBldt01, String> premBldt01BeanProperty_7 = BeanProperty.create("related_key");
		jTableBinding_1.addColumnBinding(premBldt01BeanProperty_7).setColumnName("Related Key").setEditable(false);
		//
		BeanProperty<PremBldt01, String> premBldt01BeanProperty_8 = BeanProperty.create("process_date");
		jTableBinding_1.addColumnBinding(premBldt01BeanProperty_8).setColumnName("\u521D\u59CB\u51FA\u55AE\u65E5").setEditable(false);
		//
		BeanProperty<PremBldt01, String> premBldt01BeanProperty_9 = BeanProperty.create("bldt_sts_date");
		jTableBinding_1.addColumnBinding(premBldt01BeanProperty_9).setColumnName("\u72C0\u614B\u65E5\u671F").setEditable(false);
		//
		BeanProperty<PremBldt01, String> premBldt01BeanProperty_10 = BeanProperty.create("last_check_date");
		jTableBinding_1.addColumnBinding(premBldt01BeanProperty_10).setColumnName("\u6700\u9060\u652F\u7968\u65E5").setEditable(false);
		//
		jTableBinding_1.setEditable(false);
		jTableBinding_1.bind();
	}
}
