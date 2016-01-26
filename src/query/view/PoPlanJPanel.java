package query.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
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

import query.model.PoPlan.PoPlan;
import query.model.PoPlan.PoPlanGroup;
import javax.swing.SpringLayout;
//import java.awt.event.MouseAdapter;

/**
 * 
 * @author cychu
 * 
 * @version 1.0<br>
 * 			100/08/10<br>
 * 			保障險種資料查詢畫面
 *
 * @since 1.4
 */
public class PoPlanJPanel extends JPanel implements ListSelectionListener {
	
	private static final long serialVersionUID = 1L;
	private JTable poPlanTable;
	private JPanel panel_top = new JPanel();
	private JPanel panel_btm = new JPanel();
	private VerticalPane detailScrollPane1, detailScrollPane2;
	private PoPlanGroup ppg = new PoPlanGroup();
	private SpringLayout springLayout = new SpringLayout();
	
	/**
	 * Create the panel.
	 */
	public PoPlanJPanel() {
		setLayout(springLayout);
		
		//上方Panel - 保障內容
		panel_top.setBorder(new TitledBorder(
				null,
				"保障內容",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_top.setLayout(new BorderLayout());
		
		poPlanTable = new JTable(); 
		poPlanTable.setIntercellSpacing(new Dimension(10,2));

		poPlanTable.setToolTipText("點擊以顯示下方明細");
//		{	private static final long serialVersionUID = 1L;
//
//			public boolean isCellEditable(int rowIdx, int colIdx) {
//				return false;
//			}
//			
//			public String getToolTipText(MouseEvent me) {
//				String tooltip = null;
//				tooltip = "點擊以顯示下方明細";
//				return tooltip;
//			}
//		};
//		poPlanTable.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseEntered(MouseEvent arg0) {
//				poPlanTable.getToolTipText(arg0);
//			}
//		});
		poPlanTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		poPlanTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		ListSelectionModel model = poPlanTable.getSelectionModel();
		model.addListSelectionListener(this);
		JScrollPane poPlanScrollPane = new JScrollPane(poPlanTable);
		panel_top.add(poPlanScrollPane);
		
		springLayout.putConstraint(SpringLayout.NORTH, panel_top, 0, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.SOUTH, panel_top, 0, SpringLayout.NORTH, panel_btm);
		springLayout.putConstraint(SpringLayout.EAST, panel_top, 0, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.WEST, panel_top, 0, SpringLayout.WEST, this);
		add(panel_top);
		
		//下方Panel - 保障內容其他相關資料
		panel_btm.setBorder(new TitledBorder(null,
				"保障內容與其他相關資料", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel_btm.setLayout(new GridLayout(0, 2, 0, 0));
		
		//下左方Panel
		String[] headers1 = {" 險種名稱", " 單位保額", " 單位保費", " 定額加費",
							" 生效日期", " 應繳費日", " 增額繳清", " 弱體代碼",
							" 保險金額 / 保額", " 每期保費", " 基本投資"};//更新欄位名稱「保險金額 / 保額」
		detailScrollPane1 = new VerticalPane(headers1, "", 120, 25);
		panel_btm.add(detailScrollPane1);
		
		//下右方Panel
		String[] headers2 = {" 比例加費", " 繳費終日", " 展期終日", " 生存保額",
							" 基本附加", " 體位", " 原始保費", " 加費年期",
							" 保障終期", " 保障狀態", " 生存到期", " 年度目標"};
		detailScrollPane2 = new VerticalPane(headers2, "", 71, 25);
		panel_btm.add(detailScrollPane2);

		springLayout.putConstraint(SpringLayout.NORTH, panel_btm, -338, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.SOUTH, panel_btm, 0, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, panel_btm, 0, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.WEST, panel_btm, 0, SpringLayout.WEST, this);
		add(panel_btm);

		initDataBindings();
		
		//調整poPlanTable欄位寬度
		TableColumn headerCol;
		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		
		headerCol = poPlanTable.getColumnModel().getColumn(0);		//關係
		headerCol.setCellRenderer(centerRenderer);
		headerCol.setMaxWidth(60);
		//		headerCol.setPreferredWidth(50);
		headerCol = poPlanTable.getColumnModel().getColumn(1);		//產品簡名
		headerCol.setPreferredWidth(80);
		headerCol = poPlanTable.getColumnModel().getColumn(2);		//版數
		headerCol.setCellRenderer(centerRenderer);
		headerCol.setMaxWidth(60);
		headerCol = poPlanTable.getColumnModel().getColumn(3);		//社保
		headerCol.setPreferredWidth(50);
		headerCol.setCellRenderer(centerRenderer);
		headerCol.setMaxWidth(60);
		headerCol = poPlanTable.getColumnModel().getColumn(4);		//保額
		headerCol.setCellRenderer(rightRenderer);
		headerCol = poPlanTable.getColumnModel().getColumn(6);	
		headerCol.setCellRenderer(centerRenderer);
		headerCol = poPlanTable.getColumnModel().getColumn(7);		//年齡
		headerCol.setPreferredWidth(50);
		headerCol.setCellRenderer(centerRenderer);
		headerCol = poPlanTable.getColumnModel().getColumn(8);		//性別
		headerCol.setPreferredWidth(50);
		headerCol.setCellRenderer(centerRenderer);
		headerCol = poPlanTable.getColumnModel().getColumn(9);		//年度
		headerCol.setPreferredWidth(50);
		headerCol = poPlanTable.getColumnModel().getColumn(10);
		headerCol.setCellRenderer(centerRenderer);
		headerCol = poPlanTable.getColumnModel().getColumn(11);		//每期保費
		headerCol.setPreferredWidth(80);
		headerCol.setCellRenderer(rightRenderer);
		headerCol = poPlanTable.getColumnModel().getColumn(12);		//變更生效日
		headerCol.setPreferredWidth(90);
		headerCol.setCellRenderer(centerRenderer);
		
		//非狀態42時，欄位顯示特殊顏色。
		poPlanTable.getColumnModel().getColumn(5).setCellRenderer(new DefaultTableCellRenderer() {
//		poPlanTable.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
			   /**
			 * 字體與其他相同,且變黃色的地方select會反白
			 */
			private static final long serialVersionUID = 1L;

			public Component getTableCellRendererComponent(JTable table,
			     Object value, boolean isSelected, boolean hasFocus,
			     int row, int col) {
//			    JLabel label = (JLabel) super.getTableCellRendererComponent(
//			      table, value, isSelected, hasFocus, row, col);
				try {
				if 	(col == 5)
				{	
				int i = Integer.parseInt(table.getModel()
						.getValueAt(row, 5).toString().substring(0, 2));
				setForeground(Color.black);
				if (i != 42)
						setBackground(Color.yellow);
				else {
					   setBackground(Color.white);
						if (isSelected){
							setBackground(table.getSelectionBackground());
							setForeground(table.getSelectionForeground());
						}
				}
				}

				
				} catch (Exception e) {
					return this;
				}
			    setValue(value == null ? "" : value.toString());
			    return this;
			   }
			  });
			  
//		poPlanTable.getColumnModel().getColumn(5).setCellRenderer(new MultiLineCellRenderer() {
//			private static final long serialVersionUID = 1L;
//			public boolean condition(JTable table,Object value,int row,int column) {
//				try {
//					int i = Integer.parseInt(value.toString().substring(0, 2));
//					if (i != 42)
//						return true;
//					else
//						return false;
//				} catch (Exception e) {
//
//				}
//				return false;
//			}
//			public Color getColor(){
//				return new Color(245, 105, 135);
//			}
//		});
	}
	
	/**
	 * 新增保障險種資料至保障險種群組(PoPlanGroup)
	 * 
	 * @param poPlan
	 *            PoPlan物件
	 */
	public void addPoPlan(PoPlan poPlan) {
		ppg.addPoPlan(poPlan);
	}
	
	@Override
	public void valueChanged(ListSelectionEvent arg0) {
	if (!((DefaultListSelectionModel) arg0.getSource())
				.getValueIsAdjusting()) {
		int rowSelected = poPlanTable.getSelectedRow();
		//有選擇資料
		if (rowSelected != -1) {
			String[] values1 = ppg.getPoPlans().get(rowSelected).getValues(1);
			String[] values2 = ppg.getPoPlans().get(rowSelected).getValues(2);
			detailScrollPane1.setValue(values1);
			detailScrollPane2.setValue(values2);
		}
	}
	}
	
	public void setDefaultRow()
	{
		if (poPlanTable.getRowCount() > 0)
		{	
		ListSelectionModel selectionModel =    poPlanTable.getSelectionModel(); 
		selectionModel.setSelectionInterval(0, 0);
//		getNewData();
		}
	}
	
	/**
	 * 清除保障險種群組中的所有組員(PoPlanGroup)
	 */
	public void clearAll() {
		ppg.removeAll();
		detailScrollPane1.setValue(new String[11]);
		detailScrollPane2.setValue(new String[12]);
	}
	
	public void nullAll() {
		poPlanTable = null;
		panel_top = null;
		panel_btm = null;
		detailScrollPane1 = null;
		detailScrollPane2 = null;
		ppg = null;
	}
	
	protected void initDataBindings() {
		BeanProperty<PoPlanGroup, List<PoPlan>> poPlanGroupBeanProperty = BeanProperty.create("poPlans");
		JTableBinding<PoPlan, PoPlanGroup, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, ppg, poPlanGroupBeanProperty, poPlanTable);
		//
		BeanProperty<PoPlan, String> poPlanBeanProperty = BeanProperty.create("client_ident");
		jTableBinding.addColumnBinding(poPlanBeanProperty).setColumnName("關係");
		//
		BeanProperty<PoPlan, String> poPlanBeanProperty_1 = BeanProperty.create("plan_code");
		jTableBinding.addColumnBinding(poPlanBeanProperty_1).setColumnName("產品簡名");
		//
		BeanProperty<PoPlan, String> poPlanBeanProperty_2 = BeanProperty.create("rate_scale");
		jTableBinding.addColumnBinding(poPlanBeanProperty_2).setColumnName("版數");
		//
		BeanProperty<PoPlan, String> poPlanBeanProperty_3 = BeanProperty.create("rate_insu");
		jTableBinding.addColumnBinding(poPlanBeanProperty_3).setColumnName("社保");
		//
		BeanProperty<PoPlan, String> poPlanBeanProperty_4 = BeanProperty.create("face_amt");
		jTableBinding.addColumnBinding(poPlanBeanProperty_4).setColumnName("保額");
		//
		BeanProperty<PoPlan, String> poPlanBeanProperty_5 = BeanProperty.create("co_sts_desc");
		jTableBinding.addColumnBinding(poPlanBeanProperty_5).setColumnName("狀態");
		//
		BeanProperty<PoPlan, String> poPlanBeanProperty_6 = BeanProperty.create("rate_occu");
		jTableBinding.addColumnBinding(poPlanBeanProperty_6).setColumnName("職級");
		//
		BeanProperty<PoPlan, String> poPlanBeanProperty_7 = BeanProperty.create("rate_age");
		jTableBinding.addColumnBinding(poPlanBeanProperty_7).setColumnName("年齡");
		//
		BeanProperty<PoPlan, String> poPlanBeanProperty_8 = BeanProperty.create("rate_sex");
		jTableBinding.addColumnBinding(poPlanBeanProperty_8).setColumnName("性別");
		//
		BeanProperty<PoPlan, String> poPlanBeanProperty_9 = BeanProperty.create("dur");
		jTableBinding.addColumnBinding(poPlanBeanProperty_9).setColumnName("年度");
		//
		BeanProperty<PoPlan, String> poPlanBeanProperty_10 = BeanProperty.create("co_issue_date");
		jTableBinding.addColumnBinding(poPlanBeanProperty_10).setColumnName("生效日期");
		//
		BeanProperty<PoPlan, String> poPlanBeanProperty_11 = BeanProperty.create("co_mode_prem");
		jTableBinding.addColumnBinding(poPlanBeanProperty_11).setColumnName("每期保費");
		//
		BeanProperty<PoPlan, String> poPlanBeanProperty_12 = BeanProperty.create("co_chg_date");
		jTableBinding.addColumnBinding(poPlanBeanProperty_12).setColumnName("變更生效日");
		//
		jTableBinding.setEditable(false);
		jTableBinding.bind();
	}
}