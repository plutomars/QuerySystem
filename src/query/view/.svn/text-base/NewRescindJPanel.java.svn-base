package query.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

import query.controller.NewRescindController;
import query.model.NewRescind.NewRescind01;
import query.model.NewRescind.NewRescind02;
import query.model.NewRescind.NewRescind02Group;
import query.model.NewRescind.NewRescind03;
import query.model.NewRescind.NewRescind03Group;
import query.model.NewRescind.NewRescind04;
import query.model.NewRescind.NewRescind04Group;

public class NewRescindJPanel extends JPanel implements ListSelectionListener {

	private static final long serialVersionUID = 1L;
	private VerticalPane NewRescindScrollPane1, NewRescindScrollPane2,
			NewRescindScrollPane3;
	private JScrollPane scrollPane_2;
	private JScrollPane scrollPane_3;
	private JTable NewRescind04_table;
	private JPanel panel02_1;
	private JTable NewRescind02_table;
	private JTable NewRescind03_table;
	private NewRescindController controller;

	private NewRescind01 newRescind01 = new NewRescind01();

	private NewRescind02Group newRescind02Group = new NewRescind02Group();
	private NewRescind03Group newRescind03Group = new NewRescind03Group();
	private NewRescind04Group newRescind04Group = new NewRescind04Group();

	private JPanel panel02_1_1;
	private JPanel panel02_1_2;

	/**
	 * Create the panel.
	 */
	public NewRescindJPanel() {
		setLayout(new BorderLayout(0, 0));

		JPanel panel01 = new JPanel();
		panel01.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "\u57FA\u672C\u8CC7\u6599",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(153,
						84, 10)));
		panel01.setPreferredSize(new Dimension(20, 138));
		add(panel01, BorderLayout.NORTH);
		panel01.setLayout(new GridLayout(0, 3, 0, 0));

//		String[] headers1 = { "保單號碼", "要保人", "被保人", "契撤狀態碼", "契撤狀態" };
		String[] headers1 = { "保單號碼", "要保人", "被保人", "保單狀態" };
		NewRescindScrollPane1 = new VerticalPane(headers1, "", 80, 25);
		panel01.add(NewRescindScrollPane1);

//		String[] headers2 = { "發單日期", "契撤日期", "受理日期", "結案日期", "退件原因碼" };
		String[] headers2 = { "承保日期","製單日期", "契撤日期", "受理日期" };
		NewRescindScrollPane2 = new VerticalPane(headers2, "", 80, 25);
		panel01.add(NewRescindScrollPane2);

//		String[] headers3 = { "退件原因", "保單狀態碼", "保單狀態", "保費轉入之保單號碼" };
		String[] headers3 = { "結案日期","契撤狀態","退件原因", "保費轉入之保單號碼" };
		NewRescindScrollPane3 = new VerticalPane(headers3, "", 140, 25);
		panel01.add(NewRescindScrollPane3);

		JPanel panel02 = new JPanel();
		add(panel02, BorderLayout.CENTER);
		panel02.setLayout(new GridLayout(2, 0, 0, 0));

		panel02_1 = new JPanel();
		panel02.add(panel02_1);
		panel02_1.setLayout(new GridLayout(0, 2, 0, 0));

		panel02_1_1 = new JPanel();
		panel02_1_1.setBorder(new TitledBorder(null,
				"\u5951\u64A4\u76F8\u95DC\u7D22\u5F15\u8CC7\u6599",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel02_1.add(panel02_1_1);
		panel02_1_1.setLayout(new GridLayout(0, 1, 0, 0));

		scrollPane_2 = new JScrollPane();
		panel02_1_1.add(scrollPane_2);

		NewRescind02_table = new JTable();
		scrollPane_2.setViewportView(NewRescind02_table);

		panel02_1_2 = new JPanel();
		panel02_1_2.setBorder(new TitledBorder(null,
				"\u7167\u6703\u8CC7\u6599", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel02_1.add(panel02_1_2);
		panel02_1_2.setLayout(new GridLayout(0, 1, 0, 0));

		scrollPane_3 = new JScrollPane();
		panel02_1_2.add(scrollPane_3);

		NewRescind03_table = new JTable();
		NewRescind03_table.setToolTipText("點擊以顯示下方明細");
		scrollPane_3.setViewportView(NewRescind03_table);
		NewRescind03_table
				.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ListSelectionModel model = NewRescind03_table.getSelectionModel();
		model.addListSelectionListener(this);

		JScrollPane scrollPane_4 = new JScrollPane();
		panel02.add(scrollPane_4);

		NewRescind04_table = new JTable();
		scrollPane_4.setViewportView(NewRescind04_table);
		initDataBindings();
		
		NewRescind04_table.getColumnModel().getColumn(0).setMaxWidth(60);
		NewRescind04_table.getColumnModel().getColumn(1).setMaxWidth(80);
		NewRescind04_table.getColumnModel().getColumn(2).setMaxWidth(80);

	}

	public void setController(NewRescindController controller) {
		this.controller = controller;
	}

	public void addNewRescind02(NewRescind02 rescind02) {
		newRescind02Group.addNewRescind02(rescind02);
	}

	public void addNewRescind03(NewRescind03 newRescind03) {
		newRescind03Group.addNewRescind03(newRescind03);
	}

	public void addNewRescind04(NewRescind04 rescind04) {
		newRescind04Group.addNewRescind04(rescind04);
	}

	/**
	 * 清除回覆資料群組群組中的所有組員(PoPlanGroup)
	 */
	public void cleanNewRescind() {
		newRescind02Group.removeAll();
		newRescind03Group.removeAll();
		newRescind04Group.removeAll();
		NewRescindScrollPane1.setValue(new String[] { "", "", "", "" });
		NewRescindScrollPane2.setValue(new String[] { "", "", "", "" });
		NewRescindScrollPane3.setValue(new String[] { "", "", "", "" });
	}

	public void cleanNewRescind04group() {
		newRescind04Group.removeAll();
	}

	public void setNewRescind01(HashMap<String, String> hsmp) {
		newRescind01.setValues(hsmp);
		NewRescindScrollPane1.setValue(newRescind01.getColumn1Values());
		NewRescindScrollPane2.setValue(newRescind01.getColumn2Values());
		NewRescindScrollPane3.setValue(newRescind01.getColumn3Values());
	}

	
	/**
	 * 將全域變數全部指向NULL,利於JAVA記憶體回收系統回收記憶體
	 */
	public void nullAll() {
		newRescind02Group = null;
		newRescind03Group = null;
		newRescind04Group = null;
		newRescind01 = null;
		NewRescind04_table = null;
	}
	
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (e.getValueIsAdjusting()) {
//			System.out.println("here");
			int rowSelected = NewRescind03_table.getSelectedRow();
			if (rowSelected >= 0) {
				String r_notify_date = null;
				r_notify_date = newRescind03Group.getNewrescind03group()
						.get(rowSelected).getR_notify_date();
				controller.executeMissionRescind04(r_notify_date);
//				System.out.println("r_notify_date");
			}
		}
	}

	protected void initDataBindings() {
		BeanProperty<NewRescind02Group, List<NewRescind02>> newRescind02GroupBeanProperty = BeanProperty
				.create("newrescind02group");
		JTableBinding<NewRescind02, NewRescind02Group, JTable> jTableBinding = SwingBindings
				.createJTableBinding(UpdateStrategy.READ, newRescind02Group,
						newRescind02GroupBeanProperty, NewRescind02_table);
		//
		BeanProperty<NewRescind02, String> newRescind02BeanProperty = BeanProperty
				.create("r_pocc_msg");
		jTableBinding.addColumnBinding(newRescind02BeanProperty).setColumnName(
				"\u5951\u64A4\u76F8\u95DC\u7D22\u5F15\u8CC7\u6599");
		//
		jTableBinding.setEditable(false);
		jTableBinding.bind();
		//
		BeanProperty<NewRescind03Group, List<NewRescind03>> newRescind03GroupBeanProperty = BeanProperty
				.create("newrescind03group");
		JTableBinding<NewRescind03, NewRescind03Group, JTable> jTableBinding_1 = SwingBindings
				.createJTableBinding(UpdateStrategy.READ, newRescind03Group,
						newRescind03GroupBeanProperty, NewRescind03_table);
		//
		BeanProperty<NewRescind03, String> newRescind03BeanProperty = BeanProperty
				.create("r_notify_date");
		jTableBinding_1.addColumnBinding(newRescind03BeanProperty)
				.setColumnName("\u7167\u6703\u65E5\u671F");
		//
		BeanProperty<NewRescind03, String> newRescind03BeanProperty_1 = BeanProperty
				.create("r_exp_return_date");
		jTableBinding_1.addColumnBinding(newRescind03BeanProperty_1)
				.setColumnName("\u7167\u6703\u61C9\u56DE\u8986\u65E5\u671F");
		//
		BeanProperty<NewRescind03, String> newRescind03BeanProperty_2 = BeanProperty
				.create("r_dept_code");
		jTableBinding_1.addColumnBinding(newRescind03BeanProperty_2)
				.setColumnName("\u71DF\u696D\u8655");
		//
		BeanProperty<NewRescind03, String> newRescind03BeanProperty_3 = BeanProperty
				.create("r_agent_name");
		jTableBinding_1.addColumnBinding(newRescind03BeanProperty_3)
				.setColumnName("\u696D\u52D9\u54E1");
		//
		jTableBinding_1.setEditable(false);
		jTableBinding_1.bind();
		//
		BeanProperty<NewRescind04Group, List<NewRescind04>> newRescind04GroupBeanProperty = BeanProperty
				.create("newrescind04group");
		JTableBinding<NewRescind04, NewRescind04Group, JTable> jTableBinding_2 = SwingBindings
				.createJTableBinding(UpdateStrategy.READ, newRescind04Group,
						newRescind04GroupBeanProperty, NewRescind04_table);
		//
		BeanProperty<NewRescind04, String> newRescind04BeanProperty = BeanProperty
				.create("r_nbcd_sts_code");
		jTableBinding_2.addColumnBinding(newRescind04BeanProperty)
				.setColumnName("\u56DE\u8986");
		//
		BeanProperty<NewRescind04, String> newRescind04BeanProperty_1 = BeanProperty
				.create("r_act_return_date");
		jTableBinding_2.addColumnBinding(newRescind04BeanProperty_1)
				.setColumnName("\u56DE\u8986\u65E5\u671F");
		//
		BeanProperty<NewRescind04, String> newRescind04BeanProperty_2 = BeanProperty
				.create("r_nb_notify_code");
		jTableBinding_2.addColumnBinding(newRescind04BeanProperty_2)
				.setColumnName("\u7167\u6703\u78BC");
		//
		BeanProperty<NewRescind04, String> newRescind04BeanProperty_3 = BeanProperty
				.create("r_nb_notify_desc");
		jTableBinding_2.addColumnBinding(newRescind04BeanProperty_3)
				.setColumnName("\u7167\u6703\u5167\u5BB9");
		//
		jTableBinding_2.setEditable(false);
		jTableBinding_2.bind();
	}
}
