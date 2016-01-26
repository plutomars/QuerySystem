package query.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.DefaultEditorKit;
import javax.swing.text.MaskFormatter;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.swingbinding.JComboBoxBinding;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

import query.controller.FlowerControl;
import query.controller.HighlightTreeCellRenderer;
import query.controller.MessageController;
import query.controller.NettermController;
import query.controller.SearchServiceController;
import query.controller.SelectionTreeController;
import query.model.JTextFieldLimit;
import query.model.QueryPolicy;
import query.model.QueryPolicyGroup;
import query.model.QueryPolicyQuery;
import query.model.ScreenCapture;
import query.model.SelectionTreeModel;
import database.connection.DBConnection;
import database.connection.DBLiteConnection;

/**
 * @ * @author FYYANG
 * 
 * @version 1.0<br>
 *          100/07/28<br>
 *          主機交易查詢系統主要視窗
 * 
 * @since 1.0
 */
@SuppressWarnings("serial")
public class QueryFrame extends JFrame {
	// 100000018265
	// 677500092478

	private boolean loading; // 判斷是否有載入花花LOADING
	private int executeType = 0; // 1.節點,2.Table3.Tab
	private boolean isExist;
	private String nodeName; // 目前執行節點名稱
	public static String[] policy_info;

	private int select; // 目前Tab所在index

	private JPanel contentPane;

	private JSplitPane splitPane_1;
	private JSplitPane splitPane;
	private JTree tree;
	private JPanel panel_1; // 畫面正中間,包含tabbedPane && panel_2
	private JPanel panel_2;
	private JPanel treepanel;
	private JLabel label;
	private JTextField policyField;;
	private JSplitPane splitPane_2;
	private JPanel panel_4;
	private JTextField custField;
	private JScrollPane scrollPane;
	private JTable potable;
	private JButton button;
	private JScrollPane scrollPane_1;
	private DnDTabbedPane tabbedPane;
	private WaitGlassPane glassPane;
	private boolean isExtended = false;
	private int dividerLocation1, dividerLocation2;
	private QueryPolicyGroup policyGroup = new QueryPolicyGroup();
	private QueryPolicy queryPolicy = new QueryPolicy();
	private int tabCount = 0;
	private static JPopupMenu jpopupmenu1 = new JPopupMenu(); // 支援右鍵**剪下,貼上,複製

	private List<String> searchArray = new ArrayList<String>(); // 保單搜尋選項
	private List<String> areaArray = new ArrayList<String>(); // 縣市選項

	private HighlightTreeCellRenderer renderer = new HighlightTreeCellRenderer();

	private SelectionTreeController treeController;
	private NettermController nettermController = new NettermController();
	private MessageController messageController;
	private SearchServiceController searchServiceController;

	/**
	 * @author F1256819
	 * @category 外部啟動搜尋的委派
	 */
	public interface DoSearchHandler {
		public void doSearch(final String custData);
	}

	private DoSearchHandler searchHandler;
	private FlowerControl flowerControl = new FlowerControl() {

		@Override
		public void closeFlower() {
			// TODO Auto-generated method stub
			new Thread(new Runnable() {
				public void run() {
					glassPane.stop();
					glassPane.setVisible(false);
				}
			});
		}

	};
	private JTextField currencyField;
	private JLabel label_2;
	private JTextField ownerField;
	private JLabel label_3;
	private JTextField insuredField;
	private JComboBox searchCoboBox;
	private JLabel areaLabel;
	private JComboBox areaComboBox;
	private QueryPolicyQuery policyquery = new QueryPolicyQuery();
	private ProcessDialog processDialog = new ProcessDialog() {

		/**
		 * 
		 */
		private static final long serialVersionUID = -5613635731512998589L;

		public void stopSearch() {
			// TODO Auto-generated method stub
			glassPane.stop();
			glassPane.setVisible(false);
			stopSearching();
		}

	};
	private JTextField treeSearchField;
	private JPanel panel_3;
	private JPanel panel_5;
	private JButton clearbtn;
	private JLabel dataResultLabel;
	private JFormattedTextField birthField;
	private boolean isName; // 用來判斷搜尋是否為輸入姓名
	private static int DEPT_TYPE = 1; // 1:birth,2:area

	public QueryFrame() {

		// 進來時便最大化
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		// connect to SQLite DB in Advance
		if (!DBLiteConnection.connect()) {
			JOptionPane.showMessageDialog(this, "連結至SQLiteDB失敗",
					"Connection Error", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		if (DBConnection.user_dept.matches("9[A-Z0-9]81[0-9]*"))
			DEPT_TYPE = 2; // 預設部門為保費
		addWindowStateListener(new WindowStateListener() {
			// 6放大,縮小
			public void windowStateChanged(WindowEvent arg0) {
				if (arg0.getNewState() == 6 || arg0.getOldState() == 6) {
					isExtended = false;
				}
			}
		});
		searchHandler = new DoSearchHandler() {

			@Override
			public void doSearch(final String custData) {
				// TODO Auto-generated method stub
				doSearchByCallback(custData);
			}
		};
		initController();
		setGlassPane(glassPane = new WaitGlassPane());
		setMinimumSize(new Dimension(800, 600));
		initialize();
		// 目前暫時無用
		// setSystemTray();

		// 加上提示訊息視窗
		addClientInfoTAB();
		initDataBindings();
		initOptionalBindings();
		// potable.getColumnModel().getColumn(14).setMinWidth(0); //
		// home_addr_ind
		// potable.getColumnModel().getColumn(14).setMaxWidth(0);
		// potable.getColumnModel().getColumn(15).setMinWidth(0); //
		// mail_addr_ind
		// potable.getColumnModel().getColumn(15).setMaxWidth(0);
		// potable.getColumnModel().getColumn(16).setMinWidth(0); // 核定日
		// potable.getColumnModel().getColumn(16).setMaxWidth(0);
		if (DBConnection.user_dept.matches("9[A-Z0-9]43[0-9]*")) // POS
		// if (DBConnection.user_dept.matches("9[A-Z0-9]2[0-9]*"))
		{
			potable.getColumnModel().getColumn(5).setMinWidth(0); // 參考保費
			potable.getColumnModel().getColumn(5).setMaxWidth(0);
			potable.getColumnModel().getColumn(1).setMinWidth(0); // 要保日
			potable.getColumnModel().getColumn(1).setMaxWidth(0);
			potable.getColumnModel().getColumn(8).setMinWidth(0); // 收費地區
			potable.getColumnModel().getColumn(8).setMaxWidth(0);
			potable.getColumnModel().getColumn(10).setMinWidth(0); // 送金到期
			potable.getColumnModel().getColumn(10).setMaxWidth(0);
			potable.getColumnModel().getColumn(14).setMinWidth(0); // home_addr_ind
			potable.getColumnModel().getColumn(14).setMaxWidth(0);
			potable.getColumnModel().getColumn(15).setMinWidth(0); // mail_addr_ind
			potable.getColumnModel().getColumn(15).setMaxWidth(0);
			potable.getColumnModel().getColumn(16).setMinWidth(0); // 核定日
			potable.getColumnModel().getColumn(16).setMaxWidth(0);
			potable.getColumnModel().getColumn(0).setPreferredWidth(100);
			potable.moveColumn(6, 1);
			potable.moveColumn(7, 2);
			potable.moveColumn(7, 12);
		} else if (DBConnection.user_dept.matches("9[A-Z0-9]81[0-9]*")) // PC
		{
			potable.getColumnModel().getColumn(14).setMinWidth(0); // home_addr_ind
			potable.getColumnModel().getColumn(14).setMaxWidth(0);
			potable.getColumnModel().getColumn(15).setMinWidth(0); // mail_addr_ind
			potable.getColumnModel().getColumn(15).setMaxWidth(0);
			potable.getColumnModel().getColumn(16).setMinWidth(0); // 核定日
			potable.getColumnModel().getColumn(16).setMaxWidth(0);
			potable.moveColumn(10, 13);
			potable.moveColumn(3, 13);
			potable.moveColumn(2, 13);
			potable.moveColumn(1, 13);
			potable.moveColumn(3, 1);
			potable.moveColumn(4, 2);
			potable.moveColumn(7, 5);
			potable.moveColumn(7, 6);
			potable.moveColumn(8, 7);
			potable.getColumnModel().getColumn(0).setPreferredWidth(90); // po
			potable.getColumnModel().getColumn(5).setPreferredWidth(40); // 繳法
			potable.getColumnModel().getColumn(9).setPreferredWidth(15);
			potable.getColumnModel().getColumn(10).setPreferredWidth(15);
			potable.getColumnModel().getColumn(11).setPreferredWidth(15);
			potable.getColumnModel().getColumn(12).setPreferredWidth(15);
			potable.getColumnModel().getColumn(13).setPreferredWidth(15);

		} else if (DBConnection.user_dept.matches("9[A-Z0-9]41[0-9]*")) // NB
		{
			potable.moveColumn(12, 13);
			potable.moveColumn(11, 13);
			potable.moveColumn(10, 13);
			potable.moveColumn(9, 13);
			potable.moveColumn(8, 13);
			potable.moveColumn(16, 3);
			potable.moveColumn(15, 9);
			potable.moveColumn(16, 10);
			potable.getColumnModel().getColumn(6).setMinWidth(0); // 參考保費
			potable.getColumnModel().getColumn(6).setMaxWidth(0);
			potable.getColumnModel().getColumn(16).setMinWidth(0);
			potable.getColumnModel().getColumn(16).setMaxWidth(0);
			potable.getColumnModel().getColumn(15).setMinWidth(0);
			potable.getColumnModel().getColumn(15).setMaxWidth(0);
			potable.getColumnModel().getColumn(14).setMinWidth(0);
			potable.getColumnModel().getColumn(14).setMaxWidth(0);
			potable.getColumnModel().getColumn(12).setMinWidth(0);
			potable.getColumnModel().getColumn(12).setMaxWidth(0);
			potable.getColumnModel().getColumn(13).setMinWidth(0);
			potable.getColumnModel().getColumn(13).setMaxWidth(0);
			potable.getColumnModel().getColumn(0).setPreferredWidth(100);
			// potable.getColumnModel().getColumn(14).setMinWidth(5); //
			// home_addr_ind
			// potable.getColumnModel().getColumn(14).setMaxWidth(15);
			// potable.getColumnModel().getColumn(15).setMinWidth(5); //
			// mail_addr_ind
			// potable.getColumnModel().getColumn(15).setMaxWidth(15);
			// potable.getColumnModel().getColumn(16).setMinWidth(5); // 核定日
			// potable.getColumnModel().getColumn(16).setMaxWidth(15);
		} else if (DBConnection.user_dept.matches("9[A-Z0-9]42[0-9]*")) // CL
		{
			potable.getColumnModel().getColumn(14).setMinWidth(0); // home_addr_ind
			potable.getColumnModel().getColumn(14).setMaxWidth(0);
			potable.getColumnModel().getColumn(15).setMinWidth(0); // mail_addr_ind
			potable.getColumnModel().getColumn(15).setMaxWidth(0);
			potable.getColumnModel().getColumn(16).setMinWidth(0); // 核定日
			potable.getColumnModel().getColumn(16).setMaxWidth(0);
			potable.getColumnModel().getColumn(5).setMinWidth(0); // 參考保費
			potable.getColumnModel().getColumn(5).setMaxWidth(0);
			potable.moveColumn(12, 13);
			potable.moveColumn(5, 13);
			potable.moveColumn(9, 13);
			potable.moveColumn(7, 13);
			potable.getColumnModel().getColumn(0).setPreferredWidth(100);
			potable.getColumnModel().getColumn(8).setPreferredWidth(40); // 繳法
			potable.getColumnModel().getColumn(10).setPreferredWidth(15);
			potable.getColumnModel().getColumn(11).setPreferredWidth(15);
			potable.getColumnModel().getColumn(12).setPreferredWidth(15);
			potable.getColumnModel().getColumn(13).setPreferredWidth(15);
		} else if (DBConnection.user_dept.matches("9[0-9]44[0-9]*")) // CC
																		// 101/10/17
		{
			potable.moveColumn(10, 16);
			potable.moveColumn(1, 16);
			potable.moveColumn(7, 9);
			potable.moveColumn(4, 10);
			potable.moveColumn(6, 9);
			potable.moveColumn(7, 9);
			potable.moveColumn(6, 2);
			potable.getColumnModel().getColumn(16).setMinWidth(0);
			potable.getColumnModel().getColumn(16).setMaxWidth(0);
			potable.getColumnModel().getColumn(15).setMinWidth(0);
			potable.getColumnModel().getColumn(15).setMaxWidth(0);
			potable.getColumnModel().getColumn(14).setMinWidth(0);
			potable.getColumnModel().getColumn(14).setMaxWidth(0);
			potable.getColumnModel().getColumn(13).setMinWidth(0);
			potable.getColumnModel().getColumn(13).setMaxWidth(0);
			potable.getColumnModel().getColumn(12).setMinWidth(0);
			potable.getColumnModel().getColumn(12).setMaxWidth(0);

			potable.getColumnModel().getColumn(0).setPreferredWidth(85);
			potable.getColumnModel().getColumn(1).setPreferredWidth(55); // 生效日
			potable.getColumnModel().getColumn(2).setPreferredWidth(20); // 繳法
			potable.getColumnModel().getColumn(3).setPreferredWidth(45); //
			potable.getColumnModel().getColumn(4).setPreferredWidth(40); //
			potable.getColumnModel().getColumn(5).setPreferredWidth(30); //
			potable.getColumnModel().getColumn(6).setPreferredWidth(30); //
			potable.getColumnModel().getColumn(7).setPreferredWidth(10); //
			potable.getColumnModel().getColumn(8).setPreferredWidth(10); //
			potable.getColumnModel().getColumn(9).setPreferredWidth(10); //
			potable.getColumnModel().getColumn(10).setPreferredWidth(10);
			potable.getColumnModel().getColumn(11).setPreferredWidth(10);
		}
	}

	/**
	 * @return the searchCallback
	 */
	public DoSearchHandler getSearchHandler() {
		return searchHandler;
	}

	// 系統資料匣
	private void setSystemTray() {
		// if (SystemTray.isSupported()) {
		// System.out.println("supported SystemTray");
		// SystemTray tray = SystemTray.getSystemTray();
		// final PopupMenu popup = new PopupMenu();
		// // *********************************************
		// // ---------------------秀出--------------------
		// MenuItem showItem = new MenuItem("顯示保戶訊息視窗");
		// // 設定選單項目的動作
		// showItem.addActionListener(new ActionListener() {
		//
		// @Override
		// public void actionPerformed(ActionEvent arg0) {
		// // TODO Auto-generated method stub
		// messageController.show();
		//
		// }
		//
		// });
		//
		// // 建立突顯式選單
		// popup.add(showItem);
		//
		// TrayIcon trayIcon = null;
		// try {
		//
		// // 讀取Java Archive檔案內的圖像檔案
		// ClassLoader cl = this.getClass().getClassLoader();
		// ImageIcon imageIcon = new ImageIcon(cl.getResource("mli.GIF"));
		// Image image = imageIcon.getImage();
		//
		// trayIcon = new TrayIcon(image);
		//
		// } catch (NullPointerException e) {
		// try {
		// BufferedImage buffeeimage = null;
		// buffeeimage = ImageIO.read(new File("mli.GIF"));
		// trayIcon = new TrayIcon(buffeeimage);
		// } catch (IOException ioe) {
		// JOptionPane.showMessageDialog(this, "找不到圖像檔", "ERROR",
		// JOptionPane.ERROR_MESSAGE);
		// System.exit(0);
		// }
		// }
		//
		// // trayIcon = new TrayIcon(null);
		//
		// trayIcon.setPopupMenu(popup);
		// try {
		// tray.add(trayIcon);
		//
		// } catch (AWTException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// trayIcon.displayMessage("保戶訊息區", "保戶訊息及公佈欄可由這裡打開",
		// TrayIcon.MessageType.INFO);
		//
		// }
	}

	/**
	 * Create the frame.
	 */
	private void initialize() {
		setTitle("\u4E3B\u6A5F\u4EA4\u6613\u67E5\u8A62\u7CFB\u7D71" + "："
				+ DBConnection.getServerName());

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				DBConnection.closeCon();
				DBLiteConnection.closeCon();
				System.exit(0);
			}
		});
		setBounds(100, 100, 1000, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		splitPane_1 = new JSplitPane();

		splitPane_1.setOneTouchExpandable(true);
		splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		contentPane.add(splitPane_1, BorderLayout.CENTER);

		splitPane = new JSplitPane();
		splitPane_1.setRightComponent(splitPane);

		tree = new JTree(SelectionTreeModel.getInstance());

		tree.setToolTipText("\u9023\u64CA\u5169\u4E0B\u958B\u555F\u4EA4\u6613");

		tree.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {
				if (me.getClickCount() == 2) {
					TreePath tp = tree.getPathForLocation(me.getX(), me.getY());
					checkTreeNode(tp);
				}
				label.requestFocus();
			}
		});
		treepanel = new JPanel();
		treepanel.setLayout(new BorderLayout());
		scrollPane_1 = new JScrollPane();

		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 2;

		panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Search",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 70,
						213)));
		treepanel.add(panel_3, BorderLayout.NORTH);
		panel_3.setLayout(new BorderLayout(0, 0));

		treeSearchField = new JTextField();
		panel_3.add(treeSearchField, BorderLayout.CENTER);

		// 新增節點搜尋功能 1001028
		treeSearchField.getDocument().addDocumentListener(
				new DocumentListener() {
					@Override
					public void insertUpdate(DocumentEvent e) {
						fireDocumentChangeEvent();
					}

					@Override
					public void removeUpdate(DocumentEvent e) {
						fireDocumentChangeEvent();
					}

					@Override
					public void changedUpdate(DocumentEvent e) {
					}
				});

		scrollPane_1.setViewportView(tree);
		scrollPane_1.setMinimumSize(new Dimension(200, 400));
		scrollPane_1.setPreferredSize(new Dimension(200, 400));
		treepanel.add(scrollPane_1, BorderLayout.CENTER);

		splitPane.setLeftComponent(treepanel);
		// splitPane.setDividerLocation(200);
		panel_1 = new JPanel();
		splitPane.setRightComponent(panel_1);
		splitPane.setOneTouchExpandable(true);

		panel_1.setLayout(new BorderLayout(0, 0));

		panel_2 = new JPanel();
		panel_2.setPreferredSize(new Dimension(280, 30));
		panel_1.add(panel_2, BorderLayout.NORTH);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] { 75, 140, 33, 56, 119, 68, 137,
				136, 108, 129, 0 };
		gbl_panel_2.rowHeights = new int[] { 30, 0 };
		gbl_panel_2.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel_2.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		panel_2.setLayout(gbl_panel_2);

		label = new JLabel("\u4FDD\u55AE\u67E5\u8A62\uFF1A");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.fill = GridBagConstraints.BOTH;
		gbc_label.insets = new Insets(0, 0, 0, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 0;
		panel_2.add(label, gbc_label);

		policyField = new JTextField();
		policyField.setEditable(false);
		policyField.setForeground(Color.BLACK);
		policyField.setFont(new Font("細明體", Font.BOLD, 14));
		policyField.setColumns(10);

		// 允許保單欄位使用剪下貼上
		policyField.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {

				showPopmenu(true, e);
			}
		});
		policyField.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
			}

			public void removeUpdate(DocumentEvent e) {
			}

			public void insertUpdate(DocumentEvent e) {
				warn();
			}

			public void warn() {
				if (tabbedPane.getTabCount() > 0) {
					executeMission(tabbedPane.getTitleAt(0), 2);
					executeMission(tabbedPane.getTitleAt(tabbedPane
							.getSelectedIndex()), 2);
				}
			}
		});
		GridBagConstraints gbc_policyField = new GridBagConstraints();
		gbc_policyField.fill = GridBagConstraints.HORIZONTAL;
		gbc_policyField.insets = new Insets(0, 0, 0, 5);
		gbc_policyField.gridx = 1;
		gbc_policyField.gridy = 0;
		panel_2.add(policyField, gbc_policyField);

		label_2 = new JLabel("\u8981\u4FDD\u4EBA\uFF1A");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.anchor = GridBagConstraints.EAST;
		gbc_label_2.insets = new Insets(0, 0, 0, 5);
		gbc_label_2.gridx = 3;
		gbc_label_2.gridy = 0;
		panel_2.add(label_2, gbc_label_2);

		ownerField = new JTextField();
		ownerField.setFont(new Font("新細明體", Font.BOLD, 14));
		ownerField.setEditable(false);
		// 允許要保人欄位使用剪下貼上
		ownerField.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {

				showPopmenu(true, e);
			}
		});
		GridBagConstraints gbc_ownerField = new GridBagConstraints();
		gbc_ownerField.insets = new Insets(0, 0, 0, 5);
		gbc_ownerField.fill = GridBagConstraints.HORIZONTAL;
		gbc_ownerField.gridx = 4;
		gbc_ownerField.gridy = 0;
		panel_2.add(ownerField, gbc_ownerField);
		ownerField.setColumns(10);

		label_3 = new JLabel("\u88AB\u4FDD\u96AA\u4EBA\uFF1A");
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.anchor = GridBagConstraints.EAST;
		gbc_label_3.insets = new Insets(0, 0, 0, 5);
		gbc_label_3.gridx = 5;
		gbc_label_3.gridy = 0;
		panel_2.add(label_3, gbc_label_3);

		insuredField = new JTextField();
		insuredField.setFont(new Font("新細明體", Font.BOLD, 14));
		insuredField.setEditable(false);
		// 允許被保人欄位使用剪下貼上
		insuredField.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {

				showPopmenu(true, e);
			}
		});
		GridBagConstraints gbc_insuredField = new GridBagConstraints();
		gbc_insuredField.insets = new Insets(0, 0, 0, 5);
		gbc_insuredField.fill = GridBagConstraints.HORIZONTAL;
		gbc_insuredField.gridx = 6;
		gbc_insuredField.gridy = 0;
		panel_2.add(insuredField, gbc_insuredField);
		insuredField.setColumns(10);

		currencyField = new JTextField();
		currencyField.setEditable(false);
		currencyField.setFont(new Font("新細明體", Font.BOLD, 14));
		currencyField.setForeground(new Color(139, 0, 0));
		currencyField.setBackground(new Color(255, 250, 205));
		GridBagConstraints gbc_currencyField = new GridBagConstraints();
		gbc_currencyField.insets = new Insets(0, 0, 0, 5);
		gbc_currencyField.fill = GridBagConstraints.HORIZONTAL;
		gbc_currencyField.gridx = 8;
		gbc_currencyField.gridy = 0;
		panel_2.add(currencyField, gbc_currencyField);
		currencyField.setColumns(10);

		// 設置Tab標頭為可拖拉
		tabbedPane = new DnDTabbedPane();
		tabbedPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				// // 3Tab點選
				if (executeType == 1 || tabbedPane.getSelectedIndex() == -1)
					return;
				else {
					if (tabbedPane.getTabCount() > 0
							&& tabCount == tabbedPane.getTabCount()) {
						executeMission(tabbedPane.getTitleAt(tabbedPane
								.getSelectedIndex()), 3);
					}
					tabCount = tabbedPane.getTabCount();
				}
			}
		});
		tabbedPane.setTabLayoutPolicy(JTabbedPane.WRAP_TAB_LAYOUT);
		// panel_1.add(tabbedPane,BorderLayout.CENTER);
		tabbedPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// 當按下滑鼠按鍵時
				if (arg0.getButton() == MouseEvent.BUTTON1) {
					System.out.println(arg0.getClickCount());
					if (arg0.getClickCount() == 2) {
						System.out.println("here");
						isExtended = !isExtended;
						if (isExtended) {
							dividerLocation1 = splitPane.getDividerLocation();
							dividerLocation2 = splitPane_1.getDividerLocation();
							splitPane.setDividerLocation(0);
							splitPane_1.setDividerLocation(0);
						} else {
							splitPane.setDividerLocation(dividerLocation1);
							splitPane_1.setDividerLocation(dividerLocation2);
						}
					}
				} else {

					// Paste
					final JPopupMenu jpopupmenu2 = new JPopupMenu(); //
					JMenuItem jmnuPaste1 = new JMenuItem("擷取畫面");
					// 建立突顯式選單
					jpopupmenu2.add(jmnuPaste1);

					// 畫面擷取
					jmnuPaste1.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent arg0) {
							// TODO Auto-generated method stub
							new Thread(new Runnable() {
								public void run() {
									ScreenCapture.capture(tabbedPane
											.getTitleAt(tabbedPane
													.getSelectedIndex()),
											panel_1.getLocationOnScreen(),
											panel_1.getSize());
								}
							}).start();

						}

					});
					// 顯示突顯式選單
					jpopupmenu2.show(arg0.getComponent(), arg0.getX(),
							arg0.getY());
				}

			}
		});

		splitPane_2 = new JSplitPane();
		splitPane_2.setMinimumSize(new Dimension(0, 110));
		splitPane_1.setLeftComponent(splitPane_2);

		panel_4 = new JPanel();
		splitPane_2.setLeftComponent(panel_4);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[] { 92, 92 };
		gbl_panel_4.rowHeights = new int[] { 17, 18, 16, 14, 0 };
		gbl_panel_4.columnWeights = new double[] { 1.0, 1.0 };
		gbl_panel_4.rowWeights = new double[] { 1.0, 1.0, 1.0, 1.0,
				Double.MIN_VALUE };
		panel_4.setLayout(gbl_panel_4);

		searchCoboBox = new JComboBox();
		searchCoboBox.setFocusable(false);
		searchCoboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (searchCoboBox.getSelectedIndex() == 3
						|| searchCoboBox.getSelectedIndex() == 4
						|| searchCoboBox.getSelectedIndex() == 5) {
					switch (DEPT_TYPE) {
					case 1:
						birthField.setEnabled(true);
						break;
					case 2:
						areaComboBox.setEnabled(true);
						break;
					}
				} else {
					switch (DEPT_TYPE) {
					case 1:
						birthField.setEnabled(false);
						break;
					case 2:
						areaComboBox.setEnabled(false);
						break;
					}
				}

			}
		});
		GridBagConstraints gbc_searchCoboBox = new GridBagConstraints();
		gbc_searchCoboBox.insets = new Insets(0, 0, 5, 5);
		gbc_searchCoboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_searchCoboBox.gridx = 0;
		gbc_searchCoboBox.gridy = 0;
		panel_4.add(searchCoboBox, gbc_searchCoboBox);

		custField = new JTextField();
		custField.setDocument(new JTextFieldLimit(12));
		custField.setHorizontalAlignment(SwingConstants.CENTER);
		custField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					// 字串英文自動轉大寫
					custField.setText(custField.getText().toUpperCase());
					switch (DEPT_TYPE) {
					case 1:
						doSearch(custField.getText(), birthField.getText());
						break;
					case 2:
						doSearch(custField.getText(), areaComboBox
								.getSelectedItem().toString());
						break;
					}
					// if (DEPT_TYPE == 2)

					// 由保單ID欄位搜尋時不做直接executeMission
				}
			}
		});
		custField.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				showPopmenu(false, e);
			}
		});
		GridBagConstraints gbc_custField = new GridBagConstraints();
		gbc_custField.fill = GridBagConstraints.HORIZONTAL;
		gbc_custField.insets = new Insets(0, 0, 5, 0);
		gbc_custField.gridx = 1;
		gbc_custField.gridy = 0;
		panel_4.add(custField, gbc_custField);
		custField.setColumns(8);

		areaLabel = new JLabel("\u51FA\u751F\u65E5\u671F");
		GridBagConstraints gbc_areaLabel = new GridBagConstraints();
		gbc_areaLabel.insets = new Insets(0, 0, 5, 5);
		gbc_areaLabel.gridx = 0;
		gbc_areaLabel.gridy = 1;
		panel_4.add(areaLabel, gbc_areaLabel);

		GridBagConstraints gbc_areaComboBox = new GridBagConstraints();
		gbc_areaComboBox.insets = new Insets(0, 0, 5, 0);
		gbc_areaComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_areaComboBox.gridx = 1;
		gbc_areaComboBox.gridy = 1;

		switch (DEPT_TYPE) {
		case 1:
			try {
				birthField = new JFormattedTextField(new MaskFormatter(
						"###/##/##"));
				birthField.setText("000/00/00");
				panel_4.add(birthField, gbc_areaComboBox);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case 2:
			areaLabel.setText("收費地址");
			areaComboBox = new JComboBox();
			panel_4.add(areaComboBox, gbc_areaComboBox);
			break;
		}

		dataResultLabel = new JLabel("");
		dataResultLabel.setFont(new Font("新細明體", Font.BOLD, 13));
		dataResultLabel.setForeground(Color.RED);
		GridBagConstraints gbc_dataResultLabel = new GridBagConstraints();
		gbc_dataResultLabel.insets = new Insets(0, 0, 5, 5);
		gbc_dataResultLabel.gridx = 0;
		gbc_dataResultLabel.gridy = 2;

		panel_4.add(dataResultLabel, gbc_dataResultLabel);

		panel_5 = new JPanel();
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.insets = new Insets(0, 0, 5, 0);
		gbc_panel_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_5.gridx = 1;
		gbc_panel_5.gridy = 2;
		panel_4.add(panel_5, gbc_panel_5);
		panel_5.setLayout(new GridLayout(0, 2, 0, 0));

		clearbtn = new JButton("\u6E05\u9664");
		clearbtn.setFocusable(false);
		clearbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				custField.setText("");
				if (DEPT_TYPE == 1)
					birthField.setText("000/00/00");
			}
		});
		panel_5.add(clearbtn);

		button = new JButton("\u57F7\u884C");
		panel_5.add(button);
		button.setFocusable(false);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				custField.setText(custField.getText().toUpperCase());
				switch (DEPT_TYPE) {
				case 1:
					doSearch(custField.getText(), birthField.getText());
					break;
				case 2:
					doSearch(custField.getText(), areaComboBox
							.getSelectedItem().toString());
					break;
				}
				// 由保單ID欄位搜尋時不直接做executeMission
			}
		});

		GridBagConstraints gbc_custnameField = new GridBagConstraints();
		gbc_custnameField.insets = new Insets(0, 0, 0, 5);
		gbc_custnameField.fill = GridBagConstraints.HORIZONTAL;
		gbc_custnameField.gridx = 0;
		gbc_custnameField.gridy = 4;

		GridBagConstraints gbc_custpoField = new GridBagConstraints();
		gbc_custpoField.fill = GridBagConstraints.HORIZONTAL;
		gbc_custpoField.gridx = 1;
		gbc_custpoField.gridy = 4;

		scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(2, 100));
		splitPane_2.setRightComponent(scrollPane);

		// potable = new TipJTable("連擊兩下開啟交易").getTable();// new JTable();
		potable = new JTable();
		potable.setToolTipText("連擊兩下開啟交易");
		potable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		scrollPane.setViewportView(potable);
		potable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// 應USER要求,點兩下再換保單號碼
				if (e.getClickCount() == 2) {
					// 2Table 點選
					setPolicy_info(potable.getSelectedRow());
					if (tabbedPane.getTabCount() > 0) {
						executeMission(tabbedPane.getTitleAt(tabbedPane
								.getSelectedIndex()), 2);
					}
				}
				label.requestFocus();
			}
		});
		// *******************************************************
		// ---------------------搜尋區塊JList 資料設置-------------
		searchArray.add("保單號碼/ID");
		searchArray.add("要保人ID");
		searchArray.add("被保人ID");
		searchArray.add("要/被保人姓名");
		searchArray.add("要保人姓名");
		searchArray.add("被保人姓名");
		searchArray.add("生存/滿期受益人ID");
		searchArray.add("生存/滿期受益人姓名");

		// *******************************************************
		// ---------------------取得縣市丟入ComboBox---------------
		setAreaArray();

		// *******************************************************
		// ---------------------剪下,複製,貼上--------------------
		Action action = null;
		// Cut
		JMenuItem jmnuCut1 = new JMenuItem();
		action = new DefaultEditorKit.CutAction();
		action.putValue(Action.NAME, "Cut");
		// 設定選單項目的動作
		jmnuCut1.setAction(action);
		jmnuCut1.setText("剪下");
		jmnuCut1.setMnemonic('t');
		jmnuCut1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,
				ActionEvent.CTRL_MASK));

		// Copy
		JMenuItem jmnuCopy1 = new JMenuItem();
		action = new DefaultEditorKit.CopyAction();
		action.putValue(Action.NAME, "Copy");
		// 設定選單項目的動作
		jmnuCopy1.setAction(action);
		jmnuCopy1.setText("複製");
		jmnuCopy1.setMnemonic('C');
		jmnuCopy1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,
				ActionEvent.CTRL_MASK));

		// Paste
		JMenuItem jmnuPaste1 = new JMenuItem();
		action = new DefaultEditorKit.PasteAction();
		action.putValue(Action.NAME, "Paste");
		// 設定選單項目的動作
		jmnuPaste1.setAction(action);
		jmnuPaste1.setText("貼上");
		jmnuPaste1.setMnemonic('P');
		jmnuPaste1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,
				ActionEvent.CTRL_MASK));

		// 建立突顯式選單
		jpopupmenu1.add(jmnuCut1);
		jpopupmenu1.add(jmnuCopy1);
		jpopupmenu1.add(jmnuPaste1);
		// ******************************************************
		// 設置節點選取
		tree.setCellRenderer(renderer);
		renderer.q = treeSearchField.getText();
		fireDocumentChangeEvent();
	}

	private void fireDocumentChangeEvent() {
		String q = treeSearchField.getText();
		renderer.q = q;
		TreePath root = tree.getPathForRow(0);
		if (q.length() != 0)
			collapseAll(tree, root);
		else {
			tree.expandPath(root);
		}
		if (!q.isEmpty())
			searchTree(tree, root, q);
		tree.repaint();
	}

	private static void searchTree(JTree tree, TreePath path, String q) {
		TreeNode node = (TreeNode) path.getLastPathComponent();
		String nodename = "" + node.toString();
		if (node == null || nodename.equals("null"))
			return;
		if (nodename.contains(q))
			tree.expandPath(path.getParentPath());
		if (!node.isLeaf() && node.getChildCount() >= 0) {
			@SuppressWarnings("rawtypes")
			Enumeration e = node.children();
			while (e.hasMoreElements())
				searchTree(tree, path.pathByAddingChild(e.nextElement()), q);
		}
	}

	private void collapseAll(JTree tree, TreePath parent) {
		TreeNode node = (TreeNode) parent.getLastPathComponent();
		if (!node.isLeaf() && node.getChildCount() >= 0) {
			@SuppressWarnings("rawtypes")
			Enumeration e = node.children();
			while (e.hasMoreElements()) {
				TreeNode n = (TreeNode) e.nextElement();
				TreePath path = parent.pathByAddingChild(n);
				collapseAll(tree, path);
			}
		}
		tree.collapsePath(parent);
	}

	public static void showPopmenu(boolean copyOnly, MouseEvent e) {

		// 當按下滑鼠按鍵時
		if (e.getButton() == MouseEvent.BUTTON2
				|| e.getButton() == MouseEvent.BUTTON3) {
			// 顯示突顯式選單
			((JComponent) e.getSource()).requestFocus();
			((JTextField) e.getSource()).selectAll();
			if (copyOnly) {
				// 剪下貼上不可使用
				jpopupmenu1.getComponent(0).setEnabled(false);
				jpopupmenu1.getComponent(2).setEnabled(false);
			} else {
				// 剪下貼上不可使用
				jpopupmenu1.getComponent(0).setEnabled(true);
				jpopupmenu1.getComponent(2).setEnabled(true);
			}

			jpopupmenu1.show(e.getComponent(), e.getX(), e.getY());
		}

	}

	private void setAreaArray() {
		areaArray.clear();

		List<HashMap<String, String>> list = policyquery
				.getResultList(QueryPolicyQuery.AREANAME);
		// 塞入關係人欄位資料
		for (HashMap<String, String> hsmap : list) {
			areaArray.add(hsmap.get("city_name"));
		}
	}

	private void doSearchByCallback(final String custData) {
		custField.setText(custData);
		searchCoboBox.setSelectedIndex(0); // 設為保單號碼及ID搜尋
		DEPT_TYPE = 1;
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		doSearch(custData, "");
	}

	private void doSearch(final String custData, final String areaData) {
		// set resultLabel to "", if there is no result, it's going to be set to
		// "查無資料"
		dataResultLabel.setText("");

		isName = false;
		char[] custChars = custData.toCharArray();
		for (int i = 0; i < custChars.length; i++) {
			// 判斷若輸入的值非為A-Z(65-90) || 0-9(48-57) 則為名字(非保單或ID)
			if (!(((int) custChars[i] >= 48 && (int) custChars[i] <= 57) || ((int) custChars[i] >= 65 && (int) custChars[i] <= 90))) {
				isName = true;
			}
		}
		setGlassPane(glassPane);
		getGlassPane().setVisible(true);
		startWaitingThread();

		policyGroup.removeAll();

		new Thread() {
			public void run() {

				List<HashMap<String, String>> list = null;
				// int type = -1;
				// 想加入有processDialog可以中斷的查詢項目index
				if (searchCoboBox.getSelectedIndex() == 3
						|| searchCoboBox.getSelectedIndex() == 4
						|| searchCoboBox.getSelectedIndex() == 5
						|| searchCoboBox.getSelectedIndex() == 6
						|| searchCoboBox.getSelectedIndex() == 7
						|| searchCoboBox.getSelectedIndex() == 0) {
					processDialog.setVisible(true);
				}
				if (isName)
					processDialog.setVisible(true);
				switch (searchCoboBox.getSelectedIndex()) {
				case 0: // 保單號碼/ID
					if (!isName) {
						if (custData.length() == 12)
							list = policyquery.getResultList(custData,
									QueryPolicyQuery.POLICY_NO);
						else if (custData.length() == 8
								&& custData.substring(0, 1).equals("T")) {
							list = policyquery.getResultList(custData,
									QueryPolicyQuery.POLICY_NO);
						} else if (custData.length() == 10)
							list = policyquery.getResultList(custData,
									QueryPolicyQuery.CLIENT_ID);
					} else
						// 要/被保人姓名搜尋
						list = policyquery.getResultList(custData, "",
								QueryPolicyQuery.NAMES);

					break;
				case 1: // 要保人ID
					if (!isName)
						list = policyquery.getResultList(custData,
								QueryPolicyQuery.O1_CLIENT_ID);
					else
						list = policyquery.getResultList(custData, "",
								QueryPolicyQuery.NAMES);
					break;
				case 2: // 被保人ID
					if (!isName)
						list = policyquery.getResultList(custData,
								QueryPolicyQuery.I1_CLIENT_ID);
					else
						list = policyquery.getResultList(custData, "",
								QueryPolicyQuery.NAMES);
					break;
				case 3: // 要/被保人姓名
					switch (DEPT_TYPE) {
					case 1:
						list = policyquery.getResultList(custData,
								birthField.getText(),
								QueryPolicyQuery.BIRTH_NAMES);
						break;
					case 2:
						list = policyquery.getResultList(custData, areaData,
								QueryPolicyQuery.AREA_NAMES);
						break;
					}

					break;
				case 4: // 要保人姓名
					switch (DEPT_TYPE) {
					case 1:
						list = policyquery.getResultList(custData,
								birthField.getText(),
								QueryPolicyQuery.O1_BIRTH_NAME);
						break;
					case 2:
						list = policyquery.getResultList(custData, areaData,
								QueryPolicyQuery.O1_AREA_NAME);
						break;
					}

					break;
				case 5: // 被保人姓名
					switch (DEPT_TYPE) {
					case 1:
						list = policyquery.getResultList(custData,
								birthField.getText(),
								QueryPolicyQuery.I1_BIRTH_NAME);
						break;
					case 2:
						list = policyquery.getResultList(custData, areaData,
								QueryPolicyQuery.I1_AREA_NAME);
						break;
					}
					break;
				case 6: // 受益人ID
					if (!isName)
						list = policyquery.getResultList(custData,
								QueryPolicyQuery.BENEFICIARIES_ID);
					else
						list = policyquery.getResultList(custData,
								QueryPolicyQuery.BENEFICIARIES_NAME);
					break;
				case 7: // 受益人姓名
					if (!isName)
						list = policyquery.getResultList(custData,
								QueryPolicyQuery.BENEFICIARIES_ID);
					else
						list = policyquery.getResultList(custData,
								QueryPolicyQuery.BENEFICIARIES_NAME);
					break;
				}
				endSearch(list, custData);

			}
		}.start();

	}

	public void endSearch(final List<HashMap<String, String>> list,
			final String custData) {

		final Timer stopper = new Timer(10, new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				boolean found = false;
				glassPane.stop();
				glassPane.setVisible(false);

				if (list == null) {
					found = false;
				} else
					// 塞入關係人欄位資料
					for (HashMap<String, String> hsmap : list) {
						QueryPolicy policy = new QueryPolicy(hsmap);
						policyGroup.addQueryPolicy(policy);
						found = true;
					}
				if (found) {
					int row = -1;
					if (custData.length() == 10)
						row = 0;
					else if (custData.length() == 12) {
						for (int i = 0; i < potable.getRowCount(); i++) {
							if (potable.getValueAt(i, 0).toString()
									.equals(custData)) {
								row = i;
								break;
							}
						}
					} else
						row = 0;

					// 設定選取列位置
					setQueryPolicy(row);

					// 讓JTable可以sort
					TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(
							potable.getModel());
					potable.setRowSorter(sorter);
					potable.getSelectionModel().setSelectionInterval(0, row);

					currencyField.setText(queryPolicy.getCurrency());
					ownerField.setText(queryPolicy.getO1_id());
					insuredField.setText(queryPolicy.getI1_id());
					policyField.setText(queryPolicy.getPolicy_no());

					// 若筆數超過200筆跳出視窗警告
					if (list.size() > 200)
						JOptionPane.showMessageDialog(null, "筆數超過200筆,請輸入更多條件",
								"輸出結果過多", JOptionPane.WARNING_MESSAGE);
				} else {

					currencyField.setText("");
					ownerField.setText("");
					insuredField.setText("");
					queryPolicy = null;
					policyField.setText("");
					switch (searchCoboBox.getSelectedIndex()) {
					case 0: // 保單號碼/ID
						// if (custData.length() == 12)
						// policyField.setText(custData);
						// else
						if (custData.length() == 10) {
							ownerField.setText(custData);
							insuredField.setText(custData);
							policyField.setText("------------");
						} else
							policyField.setText(custData);
						break;
					case 1: // 要保人ID
						ownerField.setText(custData);
						break;
					case 2: // 被保人ID
						insuredField.setText(custData);
						break;
					}
				}

				processDialog.setVisible(false);
			}
		});
		stopper.setRepeats(false);
		if (!stopper.isRunning()) {
			stopper.start();
		}
		if (list == null || list.size() == 0) {
			dataResultLabel.setText("查無資料");
			return;
		}
		if (list.size() == 201) {
			JOptionPane.showMessageDialog(this, "資料超過200筆，請給下更多條件", "筆數超出",
					JOptionPane.WARNING_MESSAGE);
		}
	}

	private void stopSearching() {
		processDialog.setVisible(false);
		policyquery.stopSearching();
	}

	/**
	 * Create the Controller<br>
	 * 建立一控制所有JTree引發事件之Root Controller
	 */
	private void initController() {
		treeController = new SelectionTreeController();
		// *****改版前使用****
		try {
			// messageController = new MessageController();
			// new Thread(messageController).start();
			searchServiceController = new SearchServiceController(3333);
			searchServiceController.setQueryFrameHandler(this);
			new Thread(searchServiceController).start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		treeController.getAuthority();
		treeController.setFrame(this);

		DBConnection.setFlowerControl(flowerControl);
		SelectionTreeModel.setAuthorities(treeController.getAuthorityGroup()
				.getAuthorities());
	}

	// *****改版後使用****
	public void setMessageController(MessageController controller) {
		messageController = controller;
		new Thread(messageController).start();
	}

	public void checkTreeNode(TreePath treePath) {
		// TODO Auto-generated method stub

		if (treePath == null)
			return;
		DefaultMutableTreeNode selectionNode = (DefaultMutableTreeNode) treePath
				.getLastPathComponent();
		if (selectionNode == null)
			return;
		// 無子節點(最後節點):執行
		if (selectionNode.isLeaf()) {
			// searchbutton.setVisible(false);
			String nodeName = selectionNode.toString();

			int depth = selectionNode.getLevel();
			TreeNode node = selectionNode;
			for (int i = 0; i < depth - 1; i++)
				node = node.getParent();

			if (node.toString().equals("連結NETTERM")) {
				nettermController.executeMission(policyField.getText(),
						ownerField.getText(), insuredField.getText(), nodeName);
			} else
				// 1節點
				executeMission(nodeName, 1);
		}
	}

	// 節點名稱,是否確認節點,是否為從TAB上執行之例外
	// 0為搜尋按鍵點選
	// 1為節點點選
	// 2為上方JTable點選
	// 3為Tab點選
	public void executeMission(String nodeName, int executeType) {

		setGlassPane(glassPane);
		getGlassPane().setVisible(true);
		startWaitingThread();

		// -------------------------------------------------------
		// 若為點選左邊TREE節點,則判斷是否存在dataControl,
		// 若TAB內無資料卻有則移除treeController內的控制並新增
		this.executeType = executeType;
		loading = true;
		isExist = treeController.isExist(nodeName);
		select = -1;
		this.nodeName = nodeName;

		// this.check = check;
		if (executeType == 1) {
			for (int i = 0; i < tabbedPane.getTabCount(); i++) {
				select = tabbedPane.getTitleAt(i).equals(nodeName) ? i : -1;
				if (select != -1)
					break;
			}
			if (select == -1 && isExist) {
				treeController.removeController(nodeName, false);
				isExist = false;
			} else
				tabbedPane.setSelectedIndex(select);

		}
		// -------------------------------------------------------
		tabCount = tabbedPane.getTabCount();

		treeController.setMission(1);
		treeController.setNodeName(nodeName);
		treeController.run();

		tabbedPane.setPolicy_info(getControllData());

		label.requestFocus();
	}

	// 供selectionTreeControl
	// 判斷來源,選擇執行方式
	public int jobCheck(JPanel panel, boolean isNewPolicy) {
		if (panel != null) {

			treeController.setPolicyInfo(getControllData());
			// button查詢:check/exception =false/false
			// Tab點:check/exception=false/true
			// Tree點:check/exception=true/false
			boolean policy_chk = checkPolicyno(policyField.getText());

			// 執接點選查詢BUTTON 不用做CHECK
			if (((executeType == 3 && !isNewPolicy) || (executeType == 1 && !isNewPolicy))
					&& policy_chk) {
				// mission 2為直接執行不檢查保單號碼
				return 2;
			} else if (executeType == 2 && policy_chk) {
				// mission 3為檢查保單號碼執行
				return 3;
			}
		}
		return -1;
	}

	public void stopFlower() {
		// 有載入花花LOADING則停止

		if (loading) {
			glassPane.stop();
			glassPane.setVisible(false);
			loading = false;
			// 若為選擇節點則需確認是否已存在再做執行
			if (executeType == 1) {
				// 若 tabbed title 中無此panel 則新增
				if (select == -1) {
					tabbedPane.add(nodeName, treeController.getReturnPanel(),
							treeController.getControl(nodeName));

					tabbedPane.setSelectedComponent(treeController
							.getReturnPanel());

					tabbedPane.setTabComponentAt(tabbedPane.getSelectedIndex(),
							new ButtonTabComponent(tabbedPane, treeController));
				} else {
					tabbedPane.setSelectedIndex(select);
				}

				// if (tabbedPane.getTabCount() != 0) {
				// panel_1.add(tabbedPane, BorderLayout.CENTER);
				//
				// }
				tabbedPane.validate();
				panel_1.validate();

				// 設成-1避免混淆
				executeType = -1;
			}
			label.requestFocus();
		}

		// 記憶tab數以判斷移除TAB事件
		tabCount = tabbedPane.getTabCount();
	}

	/**
	 * CHECK TAB 中是否有訊息視窗,無則新增
	 */
	private void addClientInfoTAB() {
		treeController.setJPanel("提示訊息");
		tabbedPane.add("提示訊息", treeController.getReturnPanel(),
				treeController.getControl(nodeName));
		panel_1.add(tabbedPane, BorderLayout.CENTER);
	}

	public void setFocusTAB(boolean j) {
		if (j == true) {
			// tabbedPane.setSelectedIndex(0);
			tabbedPane.setForegroundAt(0, Color.RED);
		} else
			tabbedPane.setForegroundAt(0, Color.BLACK);
	}

	public void setPolicy_info(int row) {
		// TODO Auto-generated method stub

		if (row != -1) {
			this.setQueryPolicy(row);
			policyField.setText(queryPolicy.getPolicy_no());
			currencyField.setText(queryPolicy.getCurrency());
			ownerField.setText(queryPolicy.getO1_id());
			insuredField.setText(queryPolicy.getI1_id());
		}
	}

	// 設定所選取的QueryPolicy
	private void setQueryPolicy(int row) {
		// System.out.println("row" + row);
		String policy_no = "";
		for (int i = 0; i < potable.getColumnCount(); i++) {
			if (potable.getColumnModel().getColumn(i).getHeaderValue()
					.equals("保單號碼")) {
				policy_no = potable.getValueAt(row, i).toString();
				break;
			}
		}
		queryPolicy = policyGroup.searhQueryPolicy(policy_no);
	}

	private String[] getControllData() {
		if (queryPolicy == null) {
			// System.out.println("insured = " + insuredField.getText());
			policy_info = new String[] { policyField.getText(),
					ownerField.getText(), "", "", insuredField.getText(), "",
					"" };

		} else
			policy_info = new String[] { queryPolicy.getPolicy_no(),
					queryPolicy.getO1_id(), queryPolicy.getO1_name(),
					queryPolicy.getClass_type(), queryPolicy.getI1_id(),
					queryPolicy.getI1_name(), queryPolicy.getCurrency() };
		return policy_info;
	}

	// 檢查保單號碼是否為12碼
	private boolean checkPolicyno(String policy_no) {
		if (policy_no.length() != 12)
			return false;
		else
			return true;
	}

	// 啟動停止花花執行緒
	private void startWaitingThread() {
		Thread waiting = new Thread(new Runnable() {
			public void run() {
				glassPane.start();
			}
		});
		waiting.start();
	}

	// 資料處理視窗
	class ProcessDialog extends JDialog {

		/**
		 * 
		 */
		private static final long serialVersionUID = -1773469383089081642L;
		private final JPanel contentPanel = new JPanel();

		/**
		 * Create the dialog.
		 */
		public ProcessDialog() {
			this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
			setTitle("資料擷取");

			setResizable(false);
			setBounds(350, 200, 170, 65);

			getContentPane().setLayout(new BorderLayout());
			contentPanel.setLayout(new BorderLayout());
			contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
			getContentPane().add(contentPanel, BorderLayout.CENTER);
			JLabel label2 = new JLabel("Processing ");
			label2.setHorizontalTextPosition(JLabel.LEADING);
			AnimatedIcon icon2 = new AnimatedIcon(label2);
			icon2.setAlignmentX(AnimatedIcon.LEFT);
			icon2.addIcon(new TextIcon(label2, "."));
			icon2.addIcon(new TextIcon(label2, ".."));
			icon2.addIcon(new TextIcon(label2, "..."));
			icon2.addIcon(new TextIcon(label2, "...."));
			icon2.addIcon(new TextIcon(label2, "....."));
			icon2.start();
			label2.setIcon(icon2);
			contentPanel.add(label2, BorderLayout.CENTER);
			{
				JButton cancelButton = new JButton("中斷");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						setVisible(false);
						stopSearch();

					}
				});
				cancelButton.setActionCommand("Cancel");
				contentPanel.add(cancelButton, BorderLayout.EAST);
			}
			setAlwaysOnTop(true);
		}

		public void stopSearch() {

		}
	}

	protected void initOptionalBindings() {
		if (DEPT_TYPE == 2) {
			JComboBoxBinding<String, List<String>, JComboBox> jComboBinding_1 = SwingBindings
					.createJComboBoxBinding(UpdateStrategy.READ, areaArray,
							areaComboBox);
			jComboBinding_1.bind();
		}
	}

	protected void initDataBindings() {
		BeanProperty<QueryPolicyGroup, List<QueryPolicy>> queryPolicyGroupBeanProperty = BeanProperty
				.create("queryPolicy");
		JTableBinding<QueryPolicy, QueryPolicyGroup, JTable> jTableBinding = SwingBindings
				.createJTableBinding(UpdateStrategy.READ, policyGroup,
						queryPolicyGroupBeanProperty, potable);
		//
		BeanProperty<QueryPolicy, String> queryPolicyBeanProperty = BeanProperty
				.create("policy_no");
		jTableBinding.addColumnBinding(queryPolicyBeanProperty).setColumnName(
				"\u4FDD\u55AE\u865F\u78BC");
		//
		BeanProperty<QueryPolicy, String> queryPolicyBeanProperty_1 = BeanProperty
				.create("app_apply_date");
		jTableBinding.addColumnBinding(queryPolicyBeanProperty_1)
				.setColumnName("\u8981\u4FDD\u65E5");
		//
		BeanProperty<QueryPolicy, String> queryPolicyBeanProperty_2 = BeanProperty
				.create("issue_date");
		jTableBinding.addColumnBinding(queryPolicyBeanProperty_2)
				.setColumnName("\u751F\u6548\u65E5");
		//
		BeanProperty<QueryPolicy, String> queryPolicyBeanProperty_3 = BeanProperty
				.create("plan_code");
		jTableBinding.addColumnBinding(queryPolicyBeanProperty_3)
				.setColumnName("\u4E3B\u7D04\u96AA\u7A2E");
		//
		BeanProperty<QueryPolicy, String> queryPolicyBeanProperty_4 = BeanProperty
				.create("sts_code");
		jTableBinding.addColumnBinding(queryPolicyBeanProperty_4)
				.setColumnName("\u72C0\u614B");
		//
		BeanProperty<QueryPolicy, String> queryPolicyBeanProperty_5 = BeanProperty
				.create("mode_prem");
		jTableBinding.addColumnBinding(queryPolicyBeanProperty_5)
				.setColumnName("\u53C3\u8003\u7528\u6BCF\u671F\u4FDD\u8CBB");
		//
		BeanProperty<QueryPolicy, String> queryPolicyBeanProperty_6 = BeanProperty
				.create("o1_name");
		jTableBinding.addColumnBinding(queryPolicyBeanProperty_6)
				.setColumnName("\u8981\u4FDD\u4EBA");
		//
		BeanProperty<QueryPolicy, String> queryPolicyBeanProperty_7 = BeanProperty
				.create("i1_name");
		jTableBinding.addColumnBinding(queryPolicyBeanProperty_7)
				.setColumnName("\u88AB\u4FDD\u4EBA");
		//
		BeanProperty<QueryPolicy, String> queryPolicyBeanProperty_8 = BeanProperty
				.create("mail_addr");
		jTableBinding.addColumnBinding(queryPolicyBeanProperty_8)
				.setColumnName("\u6536\u8CBB\u5730\u5340");
		//
		BeanProperty<QueryPolicy, String> queryPolicyBeanProperty_9 = BeanProperty
				.create("paid_to_date");
		jTableBinding.addColumnBinding(queryPolicyBeanProperty_9)
				.setColumnName("\u61C9\u7E73\u8CBB\u65E5");
		//
		BeanProperty<QueryPolicy, String> queryPolicyBeanProperty_10 = BeanProperty
				.create("bill_to_date");
		jTableBinding.addColumnBinding(queryPolicyBeanProperty_10)
				.setColumnName("\u9001\u91D1\u5230\u671F\u65E5");
		//
		BeanProperty<QueryPolicy, String> queryPolicyBeanProperty_11 = BeanProperty
				.create("modx");
		jTableBinding.addColumnBinding(queryPolicyBeanProperty_11)
				.setColumnName("\u7E73\u6CD5");
		//
		BeanProperty<QueryPolicy, String> queryPolicyBeanProperty_12 = BeanProperty
				.create("method");
		jTableBinding.addColumnBinding(queryPolicyBeanProperty_12)
				.setColumnName("\u6536\u8CBB\u65B9\u5F0F");
		//
		BeanProperty<QueryPolicy, String> queryPolicyBeanProperty_13 = BeanProperty
				.create("s_ag_name");
		jTableBinding.addColumnBinding(queryPolicyBeanProperty_13)
				.setColumnName("\u670D\u52D9\u696D\u52D9\u54E1");
		//
		BeanProperty<QueryPolicy, String> queryPolicyBeanProperty_14 = BeanProperty
				.create("mail_addr_ind");
		jTableBinding.addColumnBinding(queryPolicyBeanProperty_14)
				.setColumnName("\u6536\u8CBB\u6307\u793A");
		//
		BeanProperty<QueryPolicy, String> queryPolicyBeanProperty_15 = BeanProperty
				.create("home_addr_ind");
		jTableBinding.addColumnBinding(queryPolicyBeanProperty_15)
				.setColumnName("\u4F4F\u6240\u6307\u793A");
		//
		BeanProperty<QueryPolicy, String> queryPolicyBeanProperty_16 = BeanProperty
				.create("uw_write_date");
		jTableBinding.addColumnBinding(queryPolicyBeanProperty_16)
				.setColumnName("\u6838\u5B9A\u65E5\u671F");
		//
		jTableBinding.setEditable(false);
		jTableBinding.bind();
		//
		JComboBoxBinding<String, List<String>, JComboBox> jComboBinding = SwingBindings
				.createJComboBoxBinding(UpdateStrategy.READ, searchArray,
						searchCoboBox);
		jComboBinding.bind();

	}
}
