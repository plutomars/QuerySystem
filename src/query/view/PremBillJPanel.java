package query.view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SpringLayout;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

import query.model.PremBill.PremBill;
import query.model.PremBill.PremBill01;
import query.model.PremBill.PremBill01Group;
import query.model.PremBill.PremBillGroup;
/**
 * 
 * @author cychu
 *
 * @version 1.1<br/>
 * 			104/04/16<br/>
 * 			���ک��ӵe��
 * 
 * @since 1.0
 */
public class PremBillJPanel extends JPanel implements ListSelectionListener {
	private static final long serialVersionUID = 1L;
	private SpringLayout sl = new SpringLayout();
	private JTable premBillTable;
	private VerticalPane detailPane1, detailPane2, detailPane3,
						 detailPane4, detailPane5, detailPane6,
						 detailPane7;
	private PremBillGroup pbg = new PremBillGroup();
	private PremBill01Group pb01g = new PremBill01Group();

	/**
	 * Create the panel.
	 */
	public PremBillJPanel() {
		setLayout(sl);
		
		//�W��Panel - �ثe���ڸ��
		JPanel panel_top = new JPanel();
		panel_top.setBorder(new TitledBorder(
				null,
				"�ثe���ڸ��",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		sl.putConstraint(SpringLayout.WEST, panel_top, 0, SpringLayout.WEST, this);
		sl.putConstraint(SpringLayout.EAST, panel_top, 0, SpringLayout.EAST, this);
		sl.putConstraint(SpringLayout.NORTH, panel_top, 0, SpringLayout.NORTH, this);
		sl.putConstraint(SpringLayout.SOUTH, panel_top, 235, SpringLayout.NORTH, panel_top);
		add(panel_top);
		panel_top.setLayout(new GridLayout(0, 3));
		
		//�W����VerticalPane
		String[] headers1 = {" �O�渹�X", " �n�O�H", " �Q�O�I�H", " �O�檬�A",
							 " �O��ú�k", " ���O�覡", " �ֿn���Ѧ���"};
		detailPane1 = new VerticalPane(headers1, "", 100, 25);
		panel_top.add(detailPane1);
		
		//�W��VerticalPane
		String[] headers2 = {" �ͮĤ��", " ��ú�O��", " �q��������", " ���Ĥ��",
							 " ����O�O", " ��/��ú", " ���Q���B", " �^�X���ɪ�"};
		detailPane2 = new VerticalPane(headers2, "", 130, 25);
		panel_top.add(detailPane2);

		//�W�k��VerticalPane
		String[] headers3 = {" �e�U�H�m�W", " �e�U�HID", " �e�U��H", " ��b/�����",
				" �b��", " �b���", " �e�U�Ѫ��A"};
		detailPane3 = new VerticalPane(headers3, "", 90, 25);
		panel_top.add(detailPane3);		
		
		//����Panel - ���ک���Table
		premBillTable = new JTable();
		premBillTable.setToolTipText("�I���H��ܤU�����");
//			private static final long serialVersionUID = 1L;
//
//			public boolean isCellEditable(int rowIdx, int colIdx) {
//				return false;
//			}
//		};
		premBillTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		premBillTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		ListSelectionModel model = premBillTable.getSelectionModel();
		model.addListSelectionListener(this);
		
		JScrollPane premBill01Pane = new JScrollPane(premBillTable);

		initDataBindings();
		
		//�U��Panel
		JPanel panel_btm = new JPanel();
		panel_btm.setLayout(new GridLayout(0, 4, 0, 0));
		panel_btm.setMinimumSize(new Dimension(400,177));
		
		//�U��VerticalPane(���@)
		String[] headers4 = {" �O�渹�X", " �e����_��", " �e���樴��", " �e���渹�X",
							 " ú��", " ���ڤHID", " ���ڤH�m�W"};
		detailPane4 = new VerticalPane(headers4, "", 90, 25);
		panel_btm.add(detailPane4);		
		
		//�U��VerticalPane(���G)
		String[] headers5 = {" ���ڻȦ�", " �o�d�Ȧ�", " �b��/�d��", " ���Ĥ��",
							 " �B�z���", " �B�z��", " �ܧ󪬺A"};
		detailPane5 = new VerticalPane(headers5, "", 75, 25);
		panel_btm.add(detailPane5);
		
		//�U��VerticalPane(�k�@)
		String[] headers6 = {" ú�O�O�O", " ��/��ú", " ���Q", " �^�X���ɪ�", " ������"};
		detailPane6 = new VerticalPane(headers6, "ú�O�q��", 90, 25);
		panel_btm.add(detailPane6);
		
		//�U��VerticalPane(�k�G)
		String[] headers7 = {" ú�O�O�O", " ��/��ú", " ���Q", " �^�X���ɪ�", " ������"};
		detailPane7 = new VerticalPane(headers7, "��L�e����", 90, 25);
		panel_btm.add(detailPane7);

		//���UJSplitPane (�Ӹ� premBill01Pane & panel_btm)
		JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, premBill01Pane, panel_btm);
		splitPane.setOneTouchExpandable(false);
		splitPane.setResizeWeight(0.5);
		splitPane.setDividerLocation(205);
		splitPane.setDividerSize(7);
		splitPane.setBorder(new TitledBorder(
				null,
				"���ک���",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		sl.putConstraint(SpringLayout.WEST, splitPane, 0, SpringLayout.WEST, this);
		sl.putConstraint(SpringLayout.EAST, splitPane, 0, SpringLayout.EAST, this);
		sl.putConstraint(SpringLayout.NORTH, splitPane, 0, SpringLayout.SOUTH, panel_top);
		sl.putConstraint(SpringLayout.SOUTH, splitPane, 0, SpringLayout.SOUTH, this);
		add(splitPane);
	}
	
	public void insertValue() {
		String values1[] = pbg.getPremBills().get(0).getValues(1);
		detailPane1.setValue(values1);
		String values2[] = pbg.getPremBills().get(0).getValues(2);
		detailPane2.setValue(values2);
		String values3[] = pbg.getPremBills().get(0).getValues(3);
		detailPane3.setValue(values3);
	}
	
	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		int rowSelected = premBillTable.getSelectedRow();

		//����ܸ��
		if (rowSelected != -1) {
			String[] values4 = pb01g.getPremBill01s().get(rowSelected).getValues(1);
			String[] values5 = pb01g.getPremBill01s().get(rowSelected).getValues(2);
			String[] values6 = pb01g.getPremBill01s().get(rowSelected).getValues(3);
			String[] values7 = pb01g.getPremBill01s().get(rowSelected).getValues(4);
			detailPane4.setValue(values4);
			detailPane5.setValue(values5);
			detailPane6.setValue(values6);
			detailPane7.setValue(values7);
		}
	}
	
	/**
	 * �s�W�ثe���ڸ�Ʀܥثe���ڸ�Ƹs��(PremBillGroup)
	 * 
	 * @param premBill
	 *            PremBill����
	 */
	public void addPremBill(PremBill premBill) {
		pbg.addPremBill(premBill);
	}

	/**
	 * �M���ثe���ڸ�Ƹs�դ����Ҧ��խ�(PremBillGroup)
	 */
	public void clearPremBills() {
		pbg.removeAll();
		detailPane1.setValue(new String[7]);
		detailPane1.setValue(new String[7]);
		detailPane3.setValue(new String[7]);
	}
	
	/**
	 * �s�W�ثe���ڸ�Ʀܥثe���ڸ�Ƹs��(PremBill01Group)
	 * 
	 * @param premBill01
	 *            PremBill01����
	 */
	public void addPremBill01(PremBill01 premBill01) {
		pb01g.addPremBill01(premBill01);
	}

	/**
	 * �M���ثe���ڸ�Ƹs�դ����Ҧ��խ�(PremBill01Group)
	 */
	public void clearPremBill01s() {
		pb01g.removeAll();
		detailPane4.setValue(new String[7]);
		detailPane5.setValue(new String[7]);
		detailPane6.setValue(new String[4]);
		detailPane7.setValue(new String[4]);
	}
	
	public void clearAll() {
		clearPremBills();
		clearPremBill01s();
	}
	
	public void nullAll() {
		premBillTable = null;
		pbg = null;
		pb01g = null;
		detailPane1 = null;
		detailPane2 = null;
		detailPane3 = null;
		detailPane4 = null;
		detailPane5 = null;
		detailPane6 = null;
		detailPane7 = null;
	}
	
	protected void initDataBindings() {
		BeanProperty<PremBill01Group, List<PremBill01>> premBill01GroupBeanProperty = BeanProperty.create("premBill01s");
		JTableBinding<PremBill01, PremBill01Group, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, pb01g, premBill01GroupBeanProperty, premBillTable);
		//
		BeanProperty<PremBill01, String> premBill01BeanProperty = BeanProperty.create("first_auto_ind");
		jTableBinding.addColumnBinding(premBill01BeanProperty).setColumnName("����");
		//
		BeanProperty<PremBill01, String> premBill01BeanProperty_1 = BeanProperty.create("bill_date_from");
		jTableBinding.addColumnBinding(premBill01BeanProperty_1).setColumnName("��ú���");
		//
		BeanProperty<PremBill01, String> premBill01BeanProperty_2 = BeanProperty.create("bank_date");
		jTableBinding.addColumnBinding(premBill01BeanProperty_2).setColumnName("���ڤ��");
		//
		BeanProperty<PremBill01, String> premBill01BeanProperty_3 = BeanProperty.create("trf_type_name");
		jTableBinding.addColumnBinding(premBill01BeanProperty_3).setColumnName("���ٴ�");
		//
		BeanProperty<PremBill01, String> premBill01BeanProperty_4 = BeanProperty.create("trf_amt");
		jTableBinding.addColumnBinding(premBill01BeanProperty_4).setColumnName("���ڪ��B");
		//
		BeanProperty<PremBill01, String> premBill01BeanProperty_5 = BeanProperty.create("process_date");
		jTableBinding.addColumnBinding(premBill01BeanProperty_5).setColumnName("�L�b���");
		//
		BeanProperty<PremBill01, String> premBill01BeanProperty_6 = BeanProperty.create("err_code");
		jTableBinding.addColumnBinding(premBill01BeanProperty_6).setColumnName("��b���G");
		//
		BeanProperty<PremBill01, String> premBill01BeanProperty_7 = BeanProperty.create("err_reason");
		jTableBinding.addColumnBinding(premBill01BeanProperty_7).setColumnName("���ѭ�]");
		//
		BeanProperty<PremBill01, String> premBill01BeanProperty_8 = BeanProperty.create("method_name");
		jTableBinding.addColumnBinding(premBill01BeanProperty_8).setColumnName("���O�覡");
		//
		jTableBinding.setEditable(false);
		jTableBinding.bind();
	}
}
