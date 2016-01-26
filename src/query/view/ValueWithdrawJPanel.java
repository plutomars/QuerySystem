package query.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.DefaultListSelectionModel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

import query.controller.MultiLineCellRenderer;
import query.model.ValueWithdraw.ValueWithdraw;
import query.model.ValueWithdraw.ValueWithdrawGroup;
/**
 * 年金提存明細
 * @author 陳冠瑜
 *
 */
public class ValueWithdrawJPanel extends JPanel implements ListSelectionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private ValueWithdrawGroup group01 = new ValueWithdrawGroup();  //取得Binding欄位
	private VerticalPane detailScrollPane1, detailScrollPane2;
	/**
	 * Create the panel.
	 */
	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		// TODO Auto-generated method stub
		if (!((DefaultListSelectionModel) arg0.getSource())
				.getValueIsAdjusting()) {
		int rowSelected = table.getSelectedRow();
		//有選擇資料
		if (rowSelected != -1) {
			String[] values1 = group01.getValueWithdraws().get(rowSelected).getValues(1);
			String[] values2 = group01.getValueWithdraws().get(rowSelected).getValues(2);
			detailScrollPane1.setValue(values1);
			detailScrollPane2.setValue(values2);
		}		
		}
	}
//	public void resetScrollPanes(){
//		//清空下區資料
//		String values1[] = {"","","",""};
//		String values2[] = {"","","",""};
//		detailScrollPane1.setValue(values1);
//		detailScrollPane2.setValue(values2);
//	}
	public ValueWithdrawJPanel() {
		setLayout(new BorderLayout(0, 0));
		
		//----上區Panel-提存明細內容------
		//panel
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null,
				"提存明細內容", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		add(panel, BorderLayout.CENTER);  
		panel.setLayout(new BorderLayout(0, 0));
		
		//table
		table = new JTable();	
		table.setToolTipText("點擊以顯示下方明細");
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); //選單一行
		ListSelectionModel model = table.getSelectionModel();
		model.addListSelectionListener(this);
		//selectionModel.addListSelectionListener(this);
		
		//scrollPane
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane); //, BorderLayout.CENTER);
		scrollPane.setViewportView(table);
		
		//----下區Panel-提存明細其他相關資料----
		//panel
		JPanel panel_1 = new JPanel();
		panel_1.setPreferredSize(new Dimension(15, 138));
		panel_1.setBorder(new TitledBorder(null,
				"提存明細其他相關資料",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new GridLayout(0,2,0,0));
		
		//下左區panel
		String[] headers1 = {"登錄序號","處理狀況","本次計算利息","變動本金"};
		detailScrollPane1 = new VerticalPane(headers1,"",100,25);
		detailScrollPane1.setPreferredSize(new Dimension(157, 100));
		panel_1.add(detailScrollPane1);
		
		//下右區panel
		String[] headers2 = {"附加費用","使用利息","預收保費","解約費用"};
		detailScrollPane2 = new VerticalPane(headers2,"",100,25);
		detailScrollPane2.setPreferredSize(new Dimension(157, 100));
		panel_1.add(detailScrollPane2);

		initDataBindings();
		
		
		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumn headerCol = table.getColumnModel().getColumn(0);
		headerCol.setPreferredWidth(80);
		table.getColumnModel().getColumn(1).setPreferredWidth(63);		
		table.getTableHeader().setDefaultRenderer(new MultiLineCellRenderer(true));
		table.getTableHeader().setPreferredSize(new Dimension(table.getWidth(),46)); //加高header高度

		int i = 2;
		for (i=2;i<=7;i++){
		headerCol = table.getColumnModel().getColumn(i);
		headerCol.setCellRenderer(rightRenderer);
		}
	}

	public void addValueWithdraw(ValueWithdraw withdraw) {
		group01.addValueWithdraws(withdraw);

	}
	public void clearAll() {
		group01.removeAll();
		detailScrollPane1.clearValues();
		detailScrollPane2.clearValues();
	}
	public void nullAll() {
		table = null;
		group01 = null;
		detailScrollPane1 = null;
		detailScrollPane2 = null;
	}
	
	public void setDefaultRow()
	{
		if (table.getRowCount() > 0)
		{	
		ListSelectionModel selectionModel =    table.getSelectionModel(); 
		selectionModel.setSelectionInterval(0, 0);
		}
	}
	protected void initDataBindings() {
		BeanProperty<ValueWithdrawGroup, List<ValueWithdraw>> valueWithdraw01GroupBeanProperty = BeanProperty.create("valueWithdraws");
		JTableBinding<ValueWithdraw, ValueWithdrawGroup, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, group01, valueWithdraw01GroupBeanProperty, table);
		//
		BeanProperty<ValueWithdraw, String> valueWithdrawBeanProperty = BeanProperty.create("policy_no");
		jTableBinding.addColumnBinding(valueWithdrawBeanProperty).setColumnName("\u4FDD\u55AE\u865F\u78BC");
		//
		BeanProperty<ValueWithdraw, String> valueWithdrawBeanProperty_1 = BeanProperty.create("tran_date");
		jTableBinding.addColumnBinding(valueWithdrawBeanProperty_1).setColumnName("\u4F5C\u696D\u65E5\u671F");
		//
		BeanProperty<ValueWithdraw, String> valueWithdrawBeanProperty_2 = BeanProperty.create("last_accu_amt");
		jTableBinding.addColumnBinding(valueWithdrawBeanProperty_2).setColumnName("\u4F5C\u696D\u524D\u7D2F\u7A4D\u672C\u91D1");
		//
		BeanProperty<ValueWithdraw, String> valueWithdrawBeanProperty_3 = BeanProperty.create("last_misc_ac_amt");
		jTableBinding.addColumnBinding(valueWithdrawBeanProperty_3).setColumnName("\u4F5C\u696D\u524D\u672A\u627F\u8A8DAV");
		//
		BeanProperty<ValueWithdraw, String> valueWithdrawBeanProperty_4 = BeanProperty.create("last_ac_bal_int");
		jTableBinding.addColumnBinding(valueWithdrawBeanProperty_4).setColumnName("\u4F5C\u696D\u524D\u61C9\u8A08\u5229\u606F");
		//
		BeanProperty<ValueWithdraw, String> valueWithdrawBeanProperty_5 = BeanProperty.create("accu_amt");
		jTableBinding.addColumnBinding(valueWithdrawBeanProperty_5).setColumnName("\u4F5C\u696D\u5F8C\u7D2F\u7A4D\u672C\u91D1");
		//
		BeanProperty<ValueWithdraw, String> valueWithdrawBeanProperty_6 = BeanProperty.create("misc_accu_amt");
		jTableBinding.addColumnBinding(valueWithdrawBeanProperty_6).setColumnName("\u4F5C\u696D\u5F8C\u672A\u627F\u8A8DAV");
		//
		BeanProperty<ValueWithdraw, String> valueWithdrawBeanProperty_7 = BeanProperty.create("accu_bal_int");
		jTableBinding.addColumnBinding(valueWithdrawBeanProperty_7).setColumnName("\u4F5C\u696D\u5F8C\u61C9\u8A08\u5229\u606F");
		//
		jTableBinding.setEditable(false);
		jTableBinding.bind();
	}
}
