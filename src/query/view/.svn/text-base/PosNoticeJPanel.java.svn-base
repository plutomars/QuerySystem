package query.view;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.border.TitledBorder;
import javax.swing.table.TableColumn;

import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

import query.controller.MultiLineCellRenderer;
import query.controller.PosNoticeController;
import query.model.PosNotice.PosNotice01;
import query.model.PosNotice.PosNotice01Group;
import query.model.PosNotice.PosNotice02;
import query.model.PosNotice.PosNotice02Group;
import query.model.PosNotice.PosNotice04;
import query.model.PosNotice.PosNotice04Group;
import query.model.PosNotice.PosNotice03;
import query.model.PosNotice.PosNotice03Group;
import query.model.PosNotice.PosNotice05;
import query.model.PosNotice.PosNotice05Group;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.Bindings;
/**
 * @author cychu
 * 
 * @version 1.0<br/>
 * 			100/09/07<br/>
 * 			照會記錄畫面
 * 
 * @since 1.4
 */
public class PosNoticeJPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private SpringLayout sl = new SpringLayout();
	private VerticalPane detailPane1, detailPane2, detailPane3;
	private JTable tblNotice02, tblNotice03, tblNotice04, tblNotice05;
	private JTextField receNoField = new JTextField();
	private JTextField seqField = new JTextField();
	private PosNotice01Group pn1g = new PosNotice01Group();
	private PosNotice02Group pn2g = new PosNotice02Group();
	private PosNotice03Group pn3g = new PosNotice03Group();
	private PosNotice04Group pn4g = new PosNotice04Group();
	private PosNotice05Group pn5g = new PosNotice05Group();
	private PosNoticeController pnc;
	private PosNotice01 pn01 = new PosNotice01();

	public PosNoticeJPanel() {
		setLayout(sl);
		
		//查詢Panel
		JPanel panel_top = new JPanel();
		JLabel lblRece_no = new JLabel("受理號碼:  ");
		receNoField.setColumns(8);
		receNoField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					executeQuery();
				}
			}
		});
		JLabel lblNotice_seq = new JLabel("   照會序號: ");
		JButton btnQuery = new JButton(" 查詢 ");
		seqField.setColumns(5);
		seqField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					executeQuery();
				}
			}
		});
		panel_top.setLayout(new FlowLayout(FlowLayout.LEADING));
		panel_top.add(lblRece_no);
		panel_top.add(receNoField);
		panel_top.add(lblNotice_seq);
		panel_top.add(seqField);
		panel_top.add(btnQuery);
		btnQuery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				executeQuery();
			}
		});
		sl.putConstraint(SpringLayout.WEST, panel_top, 0, SpringLayout.WEST, this);
		sl.putConstraint(SpringLayout.EAST, panel_top, 0, SpringLayout.EAST, this);
		sl.putConstraint(SpringLayout.NORTH, panel_top, 0, SpringLayout.NORTH, this);
		sl.putConstraint(SpringLayout.SOUTH, panel_top, 40, SpringLayout.NORTH, panel_top);
		add(panel_top);
		
		//照會繳費Panel
		JPanel panel_mid = new JPanel();
		panel_mid.setBorder(new TitledBorder(null, "照會繳費", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel_mid.setLayout(new GridLayout(0, 3, 0, 0));
		String[] headers1 = {" 保單號碼", " 受理號碼", " 承辦人", " 照會序號", " 照會日期",
							 " 回覆日期", " 申請項目", " 核保通過日", " 繳費截止日"};
		detailPane1 = new VerticalPane(headers1, "", 85, 25);
		String[] headers2 = {" 主契約保費", " 壽險附約保費", " 健康險保費", " 傷害險保費",
							 " 保單價值準備金", " 延繳保費利息", " 償還借款/墊繳本息",
							 " 償還欠繳金額"};
		detailPane2 = new VerticalPane(headers2, "", 135, 25);
		String[] headers3 = {" 補收從(日期)", " 到期續期保費", " 應付解約金", " 紅利退費",
							 " 本次變更應收小計", " 暫收款", " 合計應繳金額", " 變更後繳別",
							 " 變更後繳別保費"};
		detailPane3 = new VerticalPane(headers3, "", 130, 25);
		panel_mid.add(detailPane1);
		panel_mid.add(detailPane2);
		panel_mid.add(detailPane3);
		sl.putConstraint(SpringLayout.WEST, panel_mid, 0, SpringLayout.WEST, this);
		sl.putConstraint(SpringLayout.EAST, panel_mid, 0, SpringLayout.EAST, this);
		sl.putConstraint(SpringLayout.NORTH, panel_mid, 0, SpringLayout.SOUTH, panel_top);
		sl.putConstraint(SpringLayout.SOUTH, panel_mid, 263, SpringLayout.NORTH, panel_mid);
		add(panel_mid);
		
		//照會補件/照會項目/體檢原因/體檢項目Panel
		TableColumn headerCol;
		JPanel panel_btm = new JPanel();
		panel_btm.setLayout(new GridLayout(2, 2, 0, 0));
		
		//照會補件
		tblNotice02 = new JTable() {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int rowIdx, int colIdx) {
				return false;
			}
		};
		JScrollPane pane_btm_1 = new JScrollPane();
		
		pane_btm_1.setBorder(new TitledBorder(null, "照會補件", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		pane_btm_1.setViewportView(tblNotice02);
		//體檢原因
		tblNotice03 = new JTable() {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int rowIdx, int colIdx) {
				return false;
			}
		};
		JScrollPane pane_btm_2 = new JScrollPane();
		pane_btm_2.setBorder(new TitledBorder(null, "體檢原因", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		pane_btm_2.setViewportView(tblNotice03);
		//照會項目
		tblNotice04 = new JTable() {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int rowIdx, int colIdx) {
				return false;
			}
		};
		JScrollPane pane_btm_3 = new JScrollPane();
		pane_btm_3.setBorder(new TitledBorder(null, "照會項目", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		pane_btm_3.setViewportView(tblNotice04);
		//體檢項目
		tblNotice05 = new JTable() {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int rowIdx, int colIdx) {
				return false;
			}
		};
		JScrollPane pane_btm_4 = new JScrollPane();
		pane_btm_4.setBorder(new TitledBorder(null, "體檢項目", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		pane_btm_4.setViewportView(tblNotice05);
		
		panel_btm.add(pane_btm_1);
		panel_btm.add(pane_btm_2);
		panel_btm.add(pane_btm_3);
		panel_btm.add(pane_btm_4);
		sl.putConstraint(SpringLayout.WEST, panel_btm, 0, SpringLayout.WEST, this);
		sl.putConstraint(SpringLayout.EAST, panel_btm, 0, SpringLayout.EAST, this);
		sl.putConstraint(SpringLayout.NORTH, panel_btm, 0, SpringLayout.SOUTH, panel_mid);
		sl.putConstraint(SpringLayout.SOUTH, panel_btm, 0, SpringLayout.SOUTH, this);
		add(panel_btm);
		initDataBindings();
		
		//調整tblNotice02欄位
		headerCol = tblNotice02.getColumnModel().getColumn(0);		//補件項目
		headerCol.setPreferredWidth(100);
		headerCol.setMaxWidth(100);
		//調整tblNotice03欄位
		headerCol = tblNotice03.getColumnModel().getColumn(0);		//受理項目
		headerCol.setPreferredWidth(100);
		headerCol.setMaxWidth(100);
		tblNotice03.setRowHeight(tblNotice03.getRowHeight() * 2);
		tblNotice03.getColumnModel().getColumn(1).setCellRenderer(new MultiLineCellRenderer());
		//調整tblNotice04欄位
		headerCol = tblNotice04.getColumnModel().getColumn(0);		//體檢原因
		headerCol.setPreferredWidth(100);
		headerCol.setMaxWidth(100);
		tblNotice04.setRowHeight(tblNotice04.getRowHeight() * 3);
		tblNotice04.getColumnModel().getColumn(1).setCellRenderer(new MultiLineCellRenderer());
		//調整tblNotice05欄位
		headerCol = tblNotice05.getColumnModel().getColumn(0);		//受理項目
		headerCol.setPreferredWidth(100);
		headerCol.setMaxWidth(100);
		tblNotice05.setRowHeight(tblNotice05.getRowHeight() * 2);
		tblNotice05.getColumnModel().getColumn(1).setCellRenderer(new MultiLineCellRenderer());
	}
	
	private void executeQuery() {
		String po_no = pnc.getOldPolicy_no();
		String rece_no = receNoField.getText();
		String seq = seqField.getText();

		pnc.executeInnerMission(po_no, rece_no, seq);
	}
	
	public void setController(PosNoticeController pnc){
		this.pnc = pnc;
	}
	
	public void setReceField(String rece) {
		pn01.setPo_chg_rece_no(rece);
	}
	
	public void setSeqField(String seq) {
		pn01.setNotice_seq(seq);
	}
	
	public void insertValue() {
		String values1[] = pn1g.getPosNotice01s().get(0).getValues(1);
		detailPane1.setValue(values1);
		String values2[] = pn1g.getPosNotice01s().get(0).getValues(2);
		detailPane2.setValue(values2);
		String values3[] = pn1g.getPosNotice01s().get(0).getValues(3);
		detailPane3.setValue(values3);
	}
	
	public void clearVPane() {
		detailPane1.setValue(new String[9]);
		detailPane2.setValue(new String[8]);
		detailPane3.setValue(new String[9]);
	}
	
	/**
	 * 新增照會繳費資料至照會繳費群組(PosNotice01Group)
	 * 
	 * @param posNotice01
	 *            PosNotice01Group物件
	 */
	public void addPosNotice01(PosNotice01 posNotice01) {
		pn1g.addPosNotice01(posNotice01);
	}

	/**
	 * 清除照會繳費群組中的所有組員(PosNotice01Group)
	 */
	public void clearPosNotice01s() {
		pn1g.removeAll();
	}
	
	/**
	 * 新增照會補件資料至照會補件群組(PosNotice02Group)
	 * 
	 * @param posNotice02
	 *            PosNotice02Group物件
	 */
	public void addPosNotice02(PosNotice02 posNotice02) {
		pn2g.addPosNotice02(posNotice02);
	}

	/**
	 * 清除照會補件群組中的所有組員(PosNotice02Group)
	 */
	public void clearPosNotice02s() {
		pn2g.removeAll();
	}
	
	/**
	 * 新增照會項目資料至照會項目群組(PosNotice03Group)
	 * 
	 * @param posNotice03
	 *            PosNotice03Group物件
	 */
	public void addPosNotice03(PosNotice03 posNotice03) {
		pn3g.addPosNotice03(posNotice03);
	}

	/**
	 * 清除照會項目群組中的所有組員(PosNotice03Group)
	 */
	public void clearPosNotice03s() {
		pn3g.removeAll();
	}
	
	/**
	 * 新增體檢原因資料至體檢原因群組(PosNotice04Group)
	 * 
	 * @param posNotice04
	 *            PosNotice04Group物件
	 */
	public void addPosNotice04(PosNotice04 posNotice04) {
		pn4g.addPosNotice04(posNotice04);
	}

	/**
	 * 清除體檢原因群組中的所有組員(PosNotice04Group)
	 */
	public void clearPosNotice04s() {
		pn4g.removeAll();
	}
	
	/**
	 * 新增體檢項目資料至體檢項目群組(PosNotice05Group)
	 * 
	 * @param posNotice05
	 *            PosNotice05Group物件
	 */
	public void addPosNotice05(PosNotice05 posNotice05) {
		pn5g.addPosNotice05(posNotice05);
	}

	/**
	 * 清除體檢項目群組中的所有組員(PosNotice05Group)
	 */
	public void clearPosNotice05s() {
		pn5g.removeAll();
	}
	
	public void clearAll() {
		clearVPane();
		pn1g.removeAll();
		pn2g.removeAll();
		pn3g.removeAll();
		pn4g.removeAll();
		pn5g.removeAll();
		receNoField.setText("");
		seqField.setText("");
	}
	
	public void nullAll() {
		detailPane1 = null;
		detailPane2 = null;
		detailPane3 = null;
		tblNotice02 = null;
		tblNotice03 = null;
		tblNotice04 = null;
		tblNotice05 = null;
		pn1g = null;
		pn2g = null;
		pn3g = null;
		pn4g = null;
		pn5g = null;
	}
	protected void initDataBindings() {
		BeanProperty<PosNotice02Group, List<PosNotice02>> posNotice02GroupBeanProperty = BeanProperty.create("posNotice02s");
		JTableBinding<PosNotice02, PosNotice02Group, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, pn2g, posNotice02GroupBeanProperty, tblNotice02);
		//
		BeanProperty<PosNotice02, String> posNotice02BeanProperty = BeanProperty.create("po_chg_note_code");
		jTableBinding.addColumnBinding(posNotice02BeanProperty).setColumnName("\u88DC\u4EF6\u9805\u76EE");
		//
		BeanProperty<PosNotice02, String> posNotice02BeanProperty_1 = BeanProperty.create("po_chg_note_desc");
		jTableBinding.addColumnBinding(posNotice02BeanProperty_1).setColumnName("\u88DC\u4EF6\u9805\u76EE\u8AAA\u660E");
		//
		jTableBinding.setEditable(false);
		jTableBinding.bind();
		//
		BeanProperty<PosNotice03Group, List<PosNotice03>> posNotice03GroupBeanProperty = BeanProperty.create("posNotice03s");
		JTableBinding<PosNotice03, PosNotice03Group, JTable> jTableBinding_1 = SwingBindings.createJTableBinding(UpdateStrategy.READ, pn3g, posNotice03GroupBeanProperty, tblNotice03);
		//
		BeanProperty<PosNotice03, String> posNotice03BeanProperty = BeanProperty.create("exam_reason_code");
		jTableBinding_1.addColumnBinding(posNotice03BeanProperty).setColumnName("\u9AD4\u6AA2\u539F\u56E0");
		//
		BeanProperty<PosNotice03, String> posNotice03BeanProperty_1 = BeanProperty.create("exam_reason_desc");
		jTableBinding_1.addColumnBinding(posNotice03BeanProperty_1).setColumnName("\u9AD4\u6AA2\u539F\u56E0\u8AAA\u660E");
		//
		jTableBinding_1.setEditable(false);
		jTableBinding_1.bind();
		//
		BeanProperty<PosNotice04Group, List<PosNotice04>> posNotice04GroupBeanProperty = BeanProperty.create("posNotice04s");
		JTableBinding<PosNotice04, PosNotice04Group, JTable> jTableBinding_2 = SwingBindings.createJTableBinding(UpdateStrategy.READ, pn4g, posNotice04GroupBeanProperty, tblNotice04);
		//
		BeanProperty<PosNotice04, String> posNotice04BeanProperty = BeanProperty.create("po_chg_note_code");
		jTableBinding_2.addColumnBinding(posNotice04BeanProperty).setColumnName("\u7167\u6703\u9805\u76EE");
		//
		BeanProperty<PosNotice04, String> posNotice04BeanProperty_1 = BeanProperty.create("po_chg_note_desc");
		jTableBinding_2.addColumnBinding(posNotice04BeanProperty_1).setColumnName("\u7167\u6703\u9805\u76EE\u8AAA\u660E");
		//
		jTableBinding_2.setEditable(false);
		jTableBinding_2.bind();
		//
		BeanProperty<PosNotice05Group, List<PosNotice05>> posNotice05GroupBeanProperty = BeanProperty.create("posNotice05s");
		JTableBinding<PosNotice05, PosNotice05Group, JTable> jTableBinding_3 = SwingBindings.createJTableBinding(UpdateStrategy.READ, pn5g, posNotice05GroupBeanProperty, tblNotice05);
		//
		BeanProperty<PosNotice05, String> posNotice05BeanProperty = BeanProperty.create("exam_item_code");
		jTableBinding_3.addColumnBinding(posNotice05BeanProperty).setColumnName("\u9AD4\u6AA2\u9805\u76EE");
		//
		BeanProperty<PosNotice05, String> posNotice05BeanProperty_1 = BeanProperty.create("exam_item_desc");
		jTableBinding_3.addColumnBinding(posNotice05BeanProperty_1).setColumnName("\u9AD4\u6AA2\u9805\u76EE\u8AAA\u660E");
		//
		jTableBinding_3.setEditable(false);
		jTableBinding_3.bind();
		//
		BeanProperty<PosNotice01, String> posNotice01BeanProperty = BeanProperty.create("po_chg_rece_no");
		BeanProperty<JTextField, String> jTextFieldBeanProperty = BeanProperty.create("text");
		AutoBinding<PosNotice01, String, JTextField, String> autoBinding = Bindings.createAutoBinding(UpdateStrategy.READ, pn01, posNotice01BeanProperty, receNoField, jTextFieldBeanProperty, "\u53D7\u7406\u865F\u78BC");
		autoBinding.bind();
		//
		BeanProperty<PosNotice01, String> posNotice01BeanProperty_1 = BeanProperty.create("notice_seq");
		BeanProperty<JTextField, String> jTextFieldBeanProperty_1 = BeanProperty.create("text");
		AutoBinding<PosNotice01, String, JTextField, String> autoBinding_1 = Bindings.createAutoBinding(UpdateStrategy.READ, pn01, posNotice01BeanProperty_1, seqField, jTextFieldBeanProperty_1, "\u7167\u6703\u5E8F\u865F");
		autoBinding_1.bind();
	}
}
