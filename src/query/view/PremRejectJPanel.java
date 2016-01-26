package query.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.DefaultListSelectionModel;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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

import query.controller.PremRejectController;
import query.model.PremReject.PremReject;
import query.model.PremReject.PremReject01;
import query.model.PremReject.PremReject01Group;
import query.model.PremReject.PremRejectGroup;

/**
 * 
 * @author cychu
 * 
 * @version 1.0<br>
 * 			101/03/22<br>
 * 			退件查詢畫面
 * 
 * @since 1.0
 */

public class PremRejectJPanel extends JPanel implements ListSelectionListener {
	private static final long serialVersionUID = 1L;
	private SpringLayout sl = new SpringLayout();
	private VerticalPane detailPane1, detailPane2, detailPane3;
	private JTable premRejectTable;
	private JLabel jLblGroup, jLblReject, jLblPcceSts;
	private PremRejectGroup prg = new PremRejectGroup();
	private PremReject01Group pr01g = new PremReject01Group();
	private PremRejectController premRejectController;
	
	public PremRejectJPanel() {
		setLayout(sl);
		
		//上方ScrollPane (含Table)
		premRejectTable = new JTable();
		premRejectTable.setToolTipText("點擊以顯示下方明細");
		premRejectTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		premRejectTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		ListSelectionModel model = premRejectTable.getSelectionModel();
		model.addListSelectionListener(this);
		JScrollPane premRejectPane = new JScrollPane(premRejectTable);
		
		//上方Panel - 退件資料
		JPanel panel_top = new JPanel(new BorderLayout());
		panel_top.setBorder(new TitledBorder(
				null,
				"退件資料",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_top.add(premRejectPane,BorderLayout.CENTER);
		sl.putConstraint(SpringLayout.WEST, panel_top, 0, SpringLayout.WEST, this);
		sl.putConstraint(SpringLayout.EAST, panel_top, 0, SpringLayout.EAST, this);
		sl.putConstraint(SpringLayout.NORTH, panel_top, 0, SpringLayout.NORTH, this);
		sl.putConstraint(SpringLayout.SOUTH, panel_top, 250, SpringLayout.NORTH, panel_top);
		add(panel_top);
		
		//中間Panel - 退件狀態/"新集彙件"字樣/"退件狀態"描述
		JPanel panel_mid_left = new JPanel(new BorderLayout());
		jLblPcceSts = new JLabel("", SwingConstants.CENTER);
		jLblPcceSts.setForeground(Color.RED);
		panel_mid_left.add(jLblPcceSts, BorderLayout.CENTER);
		
		JPanel panel_mid_mid = new JPanel(new BorderLayout());
		jLblGroup = new JLabel("", SwingConstants.CENTER);
		jLblGroup.setForeground(Color.RED);
		panel_mid_mid.add(jLblGroup, BorderLayout.CENTER);
		
		JPanel panel_mid_right = new JPanel(new BorderLayout());
		jLblReject = new JLabel("", SwingConstants.CENTER);
		jLblReject.setForeground(Color.RED);
		panel_mid_right.add(jLblReject, BorderLayout.CENTER);
		
		JPanel panel_mid = new JPanel(new GridLayout(0, 3));
		panel_mid.add(panel_mid_left);
		panel_mid.add(panel_mid_mid);
		panel_mid.add(panel_mid_right);
		sl.putConstraint(SpringLayout.WEST, panel_mid, 0, SpringLayout.WEST, this);
		sl.putConstraint(SpringLayout.EAST, panel_mid, 0, SpringLayout.EAST, this);
		sl.putConstraint(SpringLayout.NORTH, panel_mid, 0, SpringLayout.SOUTH, panel_top);
		sl.putConstraint(SpringLayout.SOUTH, panel_mid, 30, SpringLayout.NORTH, panel_mid);
		add(panel_mid);
		
		//下左Panel - 保戶資料
		JPanel panel_btm_1 = new JPanel(new BorderLayout());
		panel_btm_1.setBorder(new TitledBorder(
				null,
				"保戶資料",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		String[] headers1 = {" 狀態", " 姓名", " 身份證字號"};
		detailPane1 = new VerticalPane(headers1, "", 100, 25);
		panel_btm_1.add(detailPane1);
		
		//下中Panel - 業務員資料
		JPanel panel_btm_2 = new JPanel(new BorderLayout());
		panel_btm_2.setBorder(new TitledBorder(
				null,
				"業務員資料",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		String[] headers2 = {" 狀態", " 姓名", " 身份證字號", " 營業處"};
		detailPane2 = new VerticalPane(headers2, "", 100, 25);
		panel_btm_2.add(detailPane2);

		//下右Panel - 代辦人資料
		JPanel panel_btm_3 = new JPanel(new BorderLayout());
		panel_btm_3.setBorder(new TitledBorder(
				null,
				"代辦人資料",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		String[] headers3 = {" 狀態", " 姓名", " 身份證字號", " 營業處",
				" 代辦人身份"};
		detailPane3 = new VerticalPane(headers3, "", 90, 25);
		panel_btm_3.add(detailPane3);
		
		//下方Panel - 退件明細(承載保戶資料、業務員資料、代辦人資料)
		JPanel panel_btm = new JPanel();
		panel_btm.setLayout(new GridLayout(0, 3));
		panel_btm.add(panel_btm_1);
		panel_btm.add(panel_btm_2);
		panel_btm.add(panel_btm_3);
		sl.putConstraint(SpringLayout.WEST, panel_btm, 0, SpringLayout.WEST, this);
		sl.putConstraint(SpringLayout.EAST, panel_btm, 0, SpringLayout.EAST, this);
		sl.putConstraint(SpringLayout.NORTH, panel_btm, 0, SpringLayout.SOUTH, panel_mid);
		sl.putConstraint(SpringLayout.SOUTH, panel_btm, 163, SpringLayout.NORTH, panel_btm);
		add(panel_btm);
		
		initDataBindings();
	}
	
	@Override
	public void valueChanged(ListSelectionEvent lse) {
		if (!((DefaultListSelectionModel) lse.getSource()).getValueIsAdjusting()) {
			int rowSelected = premRejectTable.getSelectedRow();
			
			clearPremReject01s();
			//有選擇資料
			if (rowSelected != -1) {
				premRejectController.executeInnerMission(
						prg.getPremRejects()
								.get(rowSelected).getPolicy_no(),
						prg.getPremRejects()
								.get(rowSelected).getBank_op_ind(),
						prg.getPremRejects()
								.get(rowSelected).getProcess_date());
				String[] values1 = pr01g.getPremReject01s().get(0).getValues(1);
				detailPane1.setValue(values1);
				String[] values2 = pr01g.getPremReject01s().get(0).getValues(2);
				detailPane2.setValue(values2);
				String[] values3 = pr01g.getPremReject01s().get(0).getValues(3);
				detailPane3.setValue(values3);
				jLblPcceSts.setText(pr01g.getPremReject01s().get(0).getPcce_sts_desc());
				jLblGroup.setText(pr01g.getPremReject01s().get(0).getGroup_desc());
				jLblReject.setText(pr01g.getPremReject01s().get(0).getReject_desc());
			}
		}
	}
	
	/**
	 * 新增退件資料至退件資料群組(PremRejectGroup)
	 * 
	 * @param premReject
	 *            PremReject物件
	 */
	public void addPremReject(PremReject premReject) {
		prg.addPremReject(premReject);
	}
	
	/**
	 * 清除退件資料群組中的所有組員(PremRejectGroup)
	 */
	public void clearPremRejects() {
		prg.removeAll();
	}
	
	/**
	 * 新增退件資料至退件資料群組(PremReject01Group)
	 * 
	 * @param premReject01
	 *            PremReject01物件
	 */
	public void addPremReject01(PremReject01 premReject01) {
		pr01g.addPremReject01(premReject01);
	}
	
	/**
	 * 清除退件資料群組中的所有組員(PremReject01Group)
	 */
	public void clearPremReject01s() {
		pr01g.removeAll();
		detailPane1.setValue(new String[3]);
		detailPane2.setValue(new String[4]);
		detailPane3.setValue(new String[5]);
	}
	
	public void clearAll() {
		clearPremRejects();
		clearPremReject01s();
	}
	
	public void nullAll() {
		premRejectTable = null;
		prg = null;
		pr01g = null;
		detailPane1 = null;
		detailPane2 = null;
		detailPane3 = null;
	}
	
	//預設出現第一筆資料的明細
	public void setDefaultRow() {  
		if (premRejectTable.getRowCount() > 0) {	
			ListSelectionModel selectionModel = premRejectTable.getSelectionModel(); 
			selectionModel.setSelectionInterval(0, 0);
		}
	}
	
	public void setController(PremRejectController controller) {
		premRejectController = controller;
	}
	
	protected void initDataBindings() {
		BeanProperty<PremRejectGroup, List<PremReject>> premRejectGroupBeanProperty = BeanProperty.create("premRejects");
		JTableBinding<PremReject, PremRejectGroup, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, prg, premRejectGroupBeanProperty, premRejectTable);
		//
		BeanProperty<PremReject, String> premRejectBeanProperty = BeanProperty.create("policy_no");
		jTableBinding.addColumnBinding(premRejectBeanProperty).setColumnName("\u4FDD\u55AE\u865F\u78BC").setEditable(false);
		//
		BeanProperty<PremReject, String> premRejectBeanProperty_1 = BeanProperty.create("bank_op_desc");
		jTableBinding.addColumnBinding(premRejectBeanProperty_1).setColumnName("\u985E\u5225").setEditable(false);
		//
		BeanProperty<PremReject, String> premRejectBeanProperty_2 = BeanProperty.create("currency_desc");
		jTableBinding.addColumnBinding(premRejectBeanProperty_2).setColumnName("\u5E63\u5225").setEditable(false);
		//
		BeanProperty<PremReject, String> premRejectBeanProperty_3 = BeanProperty.create("reject_msg");
		jTableBinding.addColumnBinding(premRejectBeanProperty_3).setColumnName("\u932F\u8AA4\u8A0A\u606F").setEditable(false);
		//
		BeanProperty<PremReject, String> premRejectBeanProperty_4 = BeanProperty.create("method_desc");
		jTableBinding.addColumnBinding(premRejectBeanProperty_4).setColumnName("\u6536\u8CBB\u65B9\u5F0F").setEditable(false);
		//
		BeanProperty<PremReject, String> premRejectBeanProperty_5 = BeanProperty.create("paid_to_date");
		jTableBinding.addColumnBinding(premRejectBeanProperty_5).setColumnName("\u61C9\u7E73\u65E5\u671F").setEditable(false);
		//
		BeanProperty<PremReject, String> premRejectBeanProperty_6 = BeanProperty.create("process_date");
		jTableBinding.addColumnBinding(premRejectBeanProperty_6).setColumnName("\u8655\u7406\u65E5\u671F").setEditable(false);
		//
		BeanProperty<PremReject, String> premRejectBeanProperty_7 = BeanProperty.create("receive_no");
		jTableBinding.addColumnBinding(premRejectBeanProperty_7).setColumnName("\u53D7\u7406\u865F\u78BC").setEditable(false);
		//
		BeanProperty<PremReject, String> premRejectBeanProperty_8 = BeanProperty.create("process_user");
		jTableBinding.addColumnBinding(premRejectBeanProperty_8).setColumnName("\u8655\u7406\u8005").setEditable(false);
		//
		jTableBinding.setEditable(false);
		jTableBinding.bind();
	}
}
