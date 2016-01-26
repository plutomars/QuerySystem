package query.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.DefaultListSelectionModel;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;

import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

import query.controller.ClaimAssoController;
import query.model.ClaimAssoDetail.ClaimAssoDetail;
import query.model.ClaimAssoDetail.ClaimAssoDetailGroup;
import query.model.NewDetail.NewDetailCommInsured;
import query.model.NewDetail.NewDetailCommInsuredGroup;
import query.model.NewDetail.NewDetailNewAssoIndex;
import query.model.NewDetail.NewDetailNewAssoIndexGroup;
/**
 * @author cychu
 * 
 * @version 1.0<br/>
 * 			101/04/23<br/>
 * 			公會投保資料查詢
 * 
 * @version 1.0
 *
 */
public class ClaimAssoJPanel extends JPanel implements ListSelectionListener {

	private static final long serialVersionUID = 1L;
	private SpringLayout sl = new SpringLayout();
	private JLabel jLblId, jLblName, jLblBirth;
	private JTextField jTxtId, jTxtName, jTxtBirth;
	private JTable claimAssoTable, claimDetailTable;
	private ClaimAssoController claimAssoController;
	private NewDetailCommInsuredGroup ndcig = new NewDetailCommInsuredGroup();
	private NewDetailNewAssoIndexGroup ndnaig = new NewDetailNewAssoIndexGroup();
	private ClaimAssoDetailGroup cadg = new ClaimAssoDetailGroup();
	
	public ClaimAssoJPanel() {
		setLayout(sl);
		
		//上方Panel: 被保險人ID、姓名、出生日期
		JPanel panel_top = new JPanel(new GridLayout(0, 3));
		panel_top.setBorder(new TitledBorder(
				null,
				"被保險人資料",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel_top1 = new JPanel();
		jLblId = new JLabel("身份證字號：");
		jTxtId = new JTextField(10);
		jTxtId.setFont(new Font("PMingLiU", Font.PLAIN, 14));
		jTxtId.setEditable(false);
		panel_top1.add(jLblId);
		panel_top1.add(jTxtId);
		
		JPanel panel_top2 = new JPanel();
		jLblName = new JLabel("姓名：");
		jTxtName = new JTextField(18);
		jTxtName.setFont(new Font("PMingLiU", Font.PLAIN, 14));
		jTxtName.setEditable(false);
		panel_top2.add(jLblName);
		panel_top2.add(jTxtName);
		
		JPanel panel_top3 = new JPanel();
		jLblBirth = new JLabel("出生日期：");
		jTxtBirth = new JTextField(9);
		jTxtBirth.setFont(new Font("PMingLiU", Font.PLAIN, 14));
		jTxtBirth.setEditable(false);
		panel_top3.add(jLblBirth);
		panel_top3.add(jTxtBirth);
		
		panel_top.add(panel_top1);
		panel_top.add(panel_top2);
		panel_top.add(panel_top3);
		
		sl.putConstraint(SpringLayout.WEST, panel_top, 0, SpringLayout.WEST, this);
		sl.putConstraint(SpringLayout.EAST, panel_top, 0, SpringLayout.EAST, this);
		sl.putConstraint(SpringLayout.NORTH, panel_top, 0, SpringLayout.NORTH, this);
		sl.putConstraint(SpringLayout.SOUTH, panel_top, 85, SpringLayout.NORTH, panel_top);
		add(panel_top);
		
		//中間Panel - ScrollPane(含JTable) -- 公會投保資料
		claimAssoTable = new JTable();
		claimAssoTable.setToolTipText("點擊以顯示下方明細");
		claimAssoTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		claimAssoTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		ListSelectionModel model = claimAssoTable.getSelectionModel();
		model.addListSelectionListener(this);
		JScrollPane claimAssoPane = new JScrollPane(claimAssoTable);
		
		JPanel panel_mid = new JPanel(new BorderLayout());
		panel_mid.setBorder(new TitledBorder(
				null,
				"公會投保資料",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_mid.add(claimAssoPane,BorderLayout.CENTER);
		sl.putConstraint(SpringLayout.WEST, panel_mid, 0, SpringLayout.WEST, this);
		sl.putConstraint(SpringLayout.EAST, panel_mid, 0, SpringLayout.EAST, this);
		sl.putConstraint(SpringLayout.NORTH, panel_mid, 0, SpringLayout.SOUTH, panel_top);
		sl.putConstraint(SpringLayout.SOUTH, panel_mid, 250, SpringLayout.NORTH, panel_mid);
		add(panel_mid);
		
		//下方Panel - ScrollPane(含JTable) -- 投保明細
		claimDetailTable = new JTable();
		claimDetailTable.setToolTipText("點擊以顯示下方明細");
		claimDetailTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		claimDetailTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		ListSelectionModel model2 = claimAssoTable.getSelectionModel();
		model2.addListSelectionListener(this);
		JScrollPane claimDetailPane = new JScrollPane(claimDetailTable);
		
		JPanel panel_btm = new JPanel(new BorderLayout());
		panel_btm.setBorder(new TitledBorder(
				null,
				"公會投保明細",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_btm.add(claimDetailPane,BorderLayout.CENTER);
		sl.putConstraint(SpringLayout.WEST, panel_btm, 0, SpringLayout.WEST, this);
		sl.putConstraint(SpringLayout.EAST, panel_btm, 0, SpringLayout.EAST, this);
		sl.putConstraint(SpringLayout.NORTH, panel_btm, 0, SpringLayout.SOUTH, panel_mid);
		sl.putConstraint(SpringLayout.SOUTH, panel_btm, 0, SpringLayout.SOUTH, this);
		add(panel_btm);
		initDataBindings();
		
		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

		claimAssoTable.getColumnModel().getColumn(6).setCellRenderer(rightRenderer);
	}
	
	@Override
	public void valueChanged(ListSelectionEvent lse) {
		if (!((DefaultListSelectionModel) lse.getSource()).getValueIsAdjusting()) {
			int rowSelected = claimAssoTable.getSelectedRow();
		
			clearClaimAssoDetail();
			if (rowSelected != -1) {
				claimAssoController.executeInnerMission(
					ndnaig.getNewDetailNewAssoIndexs().get(rowSelected).getR_insured_id(),
					ndnaig.getNewDetailNewAssoIndexs().get(rowSelected).getR_nbui_industry(),
					ndnaig.getNewDetailNewAssoIndexs().get(rowSelected).getR_policy_type(),
					ndnaig.getNewDetailNewAssoIndexs().get(rowSelected).getR_un_ins_type(),
					ndnaig.getNewDetailNewAssoIndexs().get(rowSelected).getR_un_plan_type(),
					ndnaig.getNewDetailNewAssoIndexs().get(rowSelected).getR_un_rpt_item(),
					ndnaig.getNewDetailNewAssoIndexs().get(rowSelected).getR_nbui_company_code());
			}
		}
	}
	
	/**
	 * 設定上方Panel 被保險人資料
	 */
	public void insertTopValue() {
		jTxtId.setText(ndcig.getNewDetailCommInsureds().get(
				ndcig.getNewDetailCommCount()-1).getI1_id());
		jTxtName.setText(ndcig.getNewDetailCommInsureds().get(
				ndcig.getNewDetailCommCount()-1).getI1_name());
		jTxtBirth.setText(ndcig.getNewDetailCommInsureds().get(
				ndcig.getNewDetailCommCount()-1).getI1_birth());
	}
	
	/**
	 * 清除畫面所有資料
	 */
	public void clearAll() {
		jTxtId.setText("");
		jTxtName.setText("");
		jTxtBirth.setText("");
		clearNewAssoIndex();
		clearClaimAssoDetail();
		ndcig.removeAll();
		ndnaig.removeAll();
	}

	/**
	 * 設定畫面資料為null
	 */
	public void nullAll() {
		jTxtId = null;
		jTxtName = null;
		jTxtBirth = null;
		ndcig = null;
		ndnaig = null;
		claimAssoTable = null;
		claimDetailTable = null;
	}
	
	/**
	 * 預設顯示第一筆資料的明細
	 */
	public void setDefaultRow() {  
		if (claimAssoTable.getRowCount() > 0) {	
			ListSelectionModel selectionModel = claimAssoTable.getSelectionModel(); 
			selectionModel.setSelectionInterval(0, 0);
		}
	}
	
	/**
	 * 設定Controller
	 */
	public void setController(ClaimAssoController controller) {
		claimAssoController = controller;
	}
	
	public void addCommInsured(NewDetailCommInsured ndci) {
		ndcig.addNewDetailCommInsured(ndci);
	}
	
	public void clearCommInsured() {
		ndcig.removeAll();
	}
	
	public void addNewAssoIndex(NewDetailNewAssoIndex ndnai) {
		ndnaig.addNewDetailNewAssoIndex(ndnai);
	}

	public void clearNewAssoIndex() {
		ndnaig.removeAll();
	}
	
	public void addClaimAssoDetail(ClaimAssoDetail cad) {
		cadg.addClaimAssoDetail(cad);
	}

	public void clearClaimAssoDetail() {
		cadg.removeAll();
	}
	protected void initDataBindings() {
		BeanProperty<NewDetailNewAssoIndexGroup, List<NewDetailNewAssoIndex>> newDetailNewAssoIndexGroupBeanProperty = BeanProperty.create("newDetailNewAssoIndexs");
		JTableBinding<NewDetailNewAssoIndex, NewDetailNewAssoIndexGroup, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, ndnaig, newDetailNewAssoIndexGroupBeanProperty, claimAssoTable);
		//
		BeanProperty<NewDetailNewAssoIndex, String> newDetailNewAssoIndexBeanProperty = BeanProperty.create("r_company_name");
		jTableBinding.addColumnBinding(newDetailNewAssoIndexBeanProperty).setColumnName("\u516C\u53F8\u540D\u7A31").setEditable(false);
		//
		BeanProperty<NewDetailNewAssoIndex, String> newDetailNewAssoIndexBeanProperty_1 = BeanProperty.create("r_nbui_indu_desc");
		jTableBinding.addColumnBinding(newDetailNewAssoIndexBeanProperty_1).setColumnName("\u96AA\u5225").setEditable(false);
		//
		BeanProperty<NewDetailNewAssoIndex, String> newDetailNewAssoIndexBeanProperty_2 = BeanProperty.create("r_policy_type_desc");
		jTableBinding.addColumnBinding(newDetailNewAssoIndexBeanProperty_2).setColumnName("\u4FDD\u55AE\u5206\u985E").setEditable(false);
		//
		BeanProperty<NewDetailNewAssoIndex, String> newDetailNewAssoIndexBeanProperty_3 = BeanProperty.create("r_un_ins_type_desc");
		jTableBinding.addColumnBinding(newDetailNewAssoIndexBeanProperty_3).setColumnName("\u96AA\u7A2E\u5206\u985E").setEditable(false);
		//
		BeanProperty<NewDetailNewAssoIndex, String> newDetailNewAssoIndexBeanProperty_4 = BeanProperty.create("r_un_plan_type_desc");
		jTableBinding.addColumnBinding(newDetailNewAssoIndexBeanProperty_4).setColumnName("\u96AA\u7A2E").setEditable(false);
		//
		BeanProperty<NewDetailNewAssoIndex, String> newDetailNewAssoIndexBeanProperty_5 = BeanProperty.create("r_un_rpt_item_desc");
		jTableBinding.addColumnBinding(newDetailNewAssoIndexBeanProperty_5).setColumnName("\u7D66\u4ED8\u9805\u76EE").setEditable(false);
		//
		BeanProperty<NewDetailNewAssoIndex, String> newDetailNewAssoIndexBeanProperty_6 = BeanProperty.create("r_un_rpt_value");
		jTableBinding.addColumnBinding(newDetailNewAssoIndexBeanProperty_6).setColumnName("\u4FDD\u984D").setEditable(false);
		//
		jTableBinding.setEditable(false);
		jTableBinding.bind();
		//
		BeanProperty<ClaimAssoDetailGroup, List<ClaimAssoDetail>> claimAssoDetailGroupBeanProperty = BeanProperty.create("claimAssoDetails");
		JTableBinding<ClaimAssoDetail, ClaimAssoDetailGroup, JTable> jTableBinding_1 = SwingBindings.createJTableBinding(UpdateStrategy.READ, cadg, claimAssoDetailGroupBeanProperty, claimDetailTable);
		//
		BeanProperty<ClaimAssoDetail, String> claimAssoDetailBeanProperty = BeanProperty.create("nbui_pno");
		jTableBinding_1.addColumnBinding(claimAssoDetailBeanProperty).setColumnName("\u4FDD\u55AE\u865F\u78BC").setEditable(false);
		//
		BeanProperty<ClaimAssoDetail, String> claimAssoDetailBeanProperty_1 = BeanProperty.create("un_po_sts");
		jTableBinding_1.addColumnBinding(claimAssoDetailBeanProperty_1).setColumnName("\u4FDD\u55AE\u72C0\u6CC1").setEditable(false);
		//
		BeanProperty<ClaimAssoDetail, String> claimAssoDetailBeanProperty_2 = BeanProperty.create("mode_prem");
		jTableBinding_1.addColumnBinding(claimAssoDetailBeanProperty_2).setColumnName("\u4FDD\u8CBB").setEditable(false);
		//
		BeanProperty<ClaimAssoDetail, String> claimAssoDetailBeanProperty_3 = BeanProperty.create("po_issue_date");
		jTableBinding_1.addColumnBinding(claimAssoDetailBeanProperty_3).setColumnName("\u751F\u6548\u65E5\u671F").setEditable(false);
		//
		BeanProperty<ClaimAssoDetail, String> claimAssoDetailBeanProperty_4 = BeanProperty.create("expired_date");
		jTableBinding_1.addColumnBinding(claimAssoDetailBeanProperty_4).setColumnName("\u6EFF\u671F\u65E5\u671F").setEditable(false);
		//
		jTableBinding_1.setEditable(false);
		jTableBinding_1.bind();
	}
}
