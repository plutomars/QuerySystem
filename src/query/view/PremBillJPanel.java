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
 * 			扣款明細畫面
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
		
		//上方Panel - 目前扣款資料
		JPanel panel_top = new JPanel();
		panel_top.setBorder(new TitledBorder(
				null,
				"目前扣款資料",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		sl.putConstraint(SpringLayout.WEST, panel_top, 0, SpringLayout.WEST, this);
		sl.putConstraint(SpringLayout.EAST, panel_top, 0, SpringLayout.EAST, this);
		sl.putConstraint(SpringLayout.NORTH, panel_top, 0, SpringLayout.NORTH, this);
		sl.putConstraint(SpringLayout.SOUTH, panel_top, 235, SpringLayout.NORTH, panel_top);
		add(panel_top);
		panel_top.setLayout(new GridLayout(0, 3));
		
		//上左方VerticalPane
		String[] headers1 = {" 保單號碼", " 要保人", " 被保險人", " 保單狀態",
							 " 保單繳法", " 收費方式", " 累積失敗次數"};
		detailPane1 = new VerticalPane(headers1, "", 100, 25);
		panel_top.add(detailPane1);
		
		//上中VerticalPane
		String[] headers2 = {" 生效日期", " 應繳費日", " 通知單到期日", " 停效日期",
							 " 當期保費", " 溢/欠繳", " 紅利金額", " 回饋分享金"};
		detailPane2 = new VerticalPane(headers2, "", 130, 25);
		panel_top.add(detailPane2);

		//上右方VerticalPane
		String[] headers3 = {" 委託人姓名", " 委託人ID", " 委託對象", " 轉帳/收單行",
				" 帳號", " 帳單日", " 委託書狀態"};
		detailPane3 = new VerticalPane(headers3, "", 90, 25);
		panel_top.add(detailPane3);		
		
		//中間Panel - 扣款明細Table
		premBillTable = new JTable();
		premBillTable.setToolTipText("點擊以顯示下方明細");
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
		
		//下方Panel
		JPanel panel_btm = new JPanel();
		panel_btm.setLayout(new GridLayout(0, 4, 0, 0));
		panel_btm.setMinimumSize(new Dimension(400,177));
		
		//下方VerticalPane(左一)
		String[] headers4 = {" 保單號碼", " 送金單起日", " 送金單迄日", " 送金單號碼",
							 " 繳次", " 扣款人ID", " 扣款人姓名"};
		detailPane4 = new VerticalPane(headers4, "", 90, 25);
		panel_btm.add(detailPane4);		
		
		//下方VerticalPane(左二)
		String[] headers5 = {" 扣款銀行", " 發卡銀行", " 帳號/卡號", " 有效日期",
							 " 處理日期", " 處理者", " 變更狀態"};
		detailPane5 = new VerticalPane(headers5, "", 75, 25);
		panel_btm.add(detailPane5);
		
		//下方VerticalPane(右一)
		String[] headers6 = {" 繳別保費", " 溢/欠繳", " 紅利", " 回饋分享金", " 延滯息"};
		detailPane6 = new VerticalPane(headers6, "繳費通知", 90, 25);
		panel_btm.add(detailPane6);
		
		//下方VerticalPane(右二)
		String[] headers7 = {" 繳別保費", " 溢/欠繳", " 紅利", " 回饋分享金", " 延滯息"};
		detailPane7 = new VerticalPane(headers7, "後印送金單", 90, 25);
		panel_btm.add(detailPane7);

		//中下JSplitPane (承載 premBill01Pane & panel_btm)
		JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, premBill01Pane, panel_btm);
		splitPane.setOneTouchExpandable(false);
		splitPane.setResizeWeight(0.5);
		splitPane.setDividerLocation(205);
		splitPane.setDividerSize(7);
		splitPane.setBorder(new TitledBorder(
				null,
				"扣款明細",
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

		//有選擇資料
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
	 * 新增目前扣款資料至目前扣款資料群組(PremBillGroup)
	 * 
	 * @param premBill
	 *            PremBill物件
	 */
	public void addPremBill(PremBill premBill) {
		pbg.addPremBill(premBill);
	}

	/**
	 * 清除目前扣款資料群組中的所有組員(PremBillGroup)
	 */
	public void clearPremBills() {
		pbg.removeAll();
		detailPane1.setValue(new String[7]);
		detailPane1.setValue(new String[7]);
		detailPane3.setValue(new String[7]);
	}
	
	/**
	 * 新增目前扣款資料至目前扣款資料群組(PremBill01Group)
	 * 
	 * @param premBill01
	 *            PremBill01物件
	 */
	public void addPremBill01(PremBill01 premBill01) {
		pb01g.addPremBill01(premBill01);
	}

	/**
	 * 清除目前扣款資料群組中的所有組員(PremBill01Group)
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
		jTableBinding.addColumnBinding(premBill01BeanProperty).setColumnName("首期");
		//
		BeanProperty<PremBill01, String> premBill01BeanProperty_1 = BeanProperty.create("bill_date_from");
		jTableBinding.addColumnBinding(premBill01BeanProperty_1).setColumnName("應繳日期");
		//
		BeanProperty<PremBill01, String> premBill01BeanProperty_2 = BeanProperty.create("bank_date");
		jTableBinding.addColumnBinding(premBill01BeanProperty_2).setColumnName("扣款日期");
		//
		BeanProperty<PremBill01, String> premBill01BeanProperty_3 = BeanProperty.create("trf_type_name");
		jTableBinding.addColumnBinding(premBill01BeanProperty_3).setColumnName("扣還款");
		//
		BeanProperty<PremBill01, String> premBill01BeanProperty_4 = BeanProperty.create("trf_amt");
		jTableBinding.addColumnBinding(premBill01BeanProperty_4).setColumnName("扣款金額");
		//
		BeanProperty<PremBill01, String> premBill01BeanProperty_5 = BeanProperty.create("process_date");
		jTableBinding.addColumnBinding(premBill01BeanProperty_5).setColumnName("過帳日期");
		//
		BeanProperty<PremBill01, String> premBill01BeanProperty_6 = BeanProperty.create("err_code");
		jTableBinding.addColumnBinding(premBill01BeanProperty_6).setColumnName("轉帳結果");
		//
		BeanProperty<PremBill01, String> premBill01BeanProperty_7 = BeanProperty.create("err_reason");
		jTableBinding.addColumnBinding(premBill01BeanProperty_7).setColumnName("失敗原因");
		//
		BeanProperty<PremBill01, String> premBill01BeanProperty_8 = BeanProperty.create("method_name");
		jTableBinding.addColumnBinding(premBill01BeanProperty_8).setColumnName("收費方式");
		//
		jTableBinding.setEditable(false);
		jTableBinding.bind();
	}
}
