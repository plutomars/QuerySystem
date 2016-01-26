package query.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.Bindings;
import org.jdesktop.beansbinding.ELProperty;
import org.jdesktop.swingbinding.JComboBoxBinding;
import org.jdesktop.swingbinding.SwingBindings;

import query.model.ComponentMover;
import query.model.MessageObject;
import query.model.Contact.Contact;
import query.model.Contact.ContactGroup;
import query.model.Contact.ContactGroups;
import query.model.Message.FileMessageGroup;
import database.connection.DBLiteConnection;

@SuppressWarnings("serial")
public class MessageFrame extends JFrame {

	/**
	 * 
	 */
	private ContactGroups m_groups = new ContactGroups();
	// private List<String> groupList = new ArrayList<String>();
	private JPanel contentPane;
	// private Point pre;
	private JTabbedPane tabbedPane;
	private JTextPane textPane;
	private JTextPane policyPane;
	// 文件樣式
	private Document textDocument;
	// 文件樣式
	private Document policyDocument;
	private SimpleAttributeSet attrset = new SimpleAttributeSet();
	private JComboBox comboBox;
	private JTextField titleField;
	private JTextField contextField;
	private JButton sendButton;
	private JPopupMenu jpopupmenu = new JPopupMenu(); // 支援右鍵**新增便利貼
	private FileMessageGroup queueGruop = new FileMessageGroup();
	private FileMessageGroup downloadGroup = new FileMessageGroup();

	/**
	 * Create the frame.
	 */
	public MessageFrame() {

		init();
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Get the size of the default screen
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

		setBounds((int) dim.getWidth() - 450, (int) dim.getHeight() - 330, 450,
				300);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(UIManager.getColor("inactiveCaptionText"));
		setJMenuBar(menuBar);

		JMenu mnClose = new JMenu("\u9078\u9805");
		mnClose.setMnemonic('M');

		mnClose.setBackground(UIManager.getColor("inactiveCaptionText"));

		menuBar.add(mnClose);

		JMenuItem menuItem = new JMenuItem("\u901A\u8A0A\u9304");
		menuItem.setBackground(UIManager.getColor("inactiveCaptionText"));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							JContactBook frame = new JContactBook(m_groups,
									false);
							frame.setVisible(true);
							// initPublishList();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		mnClose.add(menuItem);

		JMenuItem menuItem_1 = new JMenuItem("\u95DC\u9589");
		menuItem_1.setBackground(UIManager.getColor("inactiveCaptionText"));
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		mnClose.add(menuItem_1);

		// JMenuItem mntmClose = new JMenuItem("Close2");
		// mnClose.addActionListener(new ActionListener() {
		// public void actionPerformed(ActionEvent arg0) {
		// System.exit(0);
		// }
		// });
		// mnClose.add(mntmClose);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("inactiveCaptionText"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		// ComponentMover cm =
		new ComponentMover(this, menuBar);
		// // 可以移動
		// menuBar.addMouseListener(new MouseAdapter() {
		// @Override
		// public void mouseReleased(MouseEvent arg0) {
		//
		// pre = null;
		//
		// }
		// });
		// menuBar.addMouseMotionListener(new MouseMotionAdapter() {
		// @Override
		// public void mouseDragged(MouseEvent arg0) {
		// int x, y;
		//
		// if (pre == null) {
		// pre = arg0.getLocationOnScreen();
		// x = 0;
		// y = 0;
		// } else {
		// x = arg0.getXOnScreen() - pre.x;
		// y = arg0.getYOnScreen() - pre.y;
		// }
		// pre = arg0.getLocationOnScreen();
		//
		// setLocation(getLocationOnScreen().x + x,
		// getLocationOnScreen().y + y);
		//
		// // moved = true;
		// }
		// });
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(UIManager.getColor("inactiveCaptionText"));
		contentPane.add(tabbedPane, BorderLayout.CENTER);

		JPanel panel = new JPanel();
		tabbedPane.addTab("保戶訊息", null, panel, null);
		panel.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);

		policyPane = new JTextPane();
		scrollPane.setViewportView(policyPane);
		policyPane.setEditable(false);
		policyDocument = policyPane.getDocument();

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("公佈欄", null, panel_1, null);
		panel_1.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane_1 = new JScrollPane();
		panel_1.add(scrollPane_1);

		textPane = new JTextPane();
		scrollPane_1.setViewportView(textPane);
		textDocument = textPane.getDocument();

		textPane.setEditable(false);

		JPanel panel_5 = new JPanel();
		panel_1.add(panel_5, BorderLayout.NORTH);
		panel_5.setLayout(new GridLayout(2, 0, 0, 0));

		JPanel panel_6 = new JPanel();
		panel_5.add(panel_6);
		panel_6.setLayout(new GridLayout(0, 2, 0, 0));

		JPanel panel_4 = new JPanel();
		panel_6.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));

		JLabel groupLabel = new JLabel("\u7FA4\u7D44");
		panel_4.add(groupLabel, BorderLayout.WEST);

		comboBox = new JComboBox();
		panel_4.add(comboBox, BorderLayout.CENTER);

		JPanel panel_7 = new JPanel();
		panel_6.add(panel_7);
		panel_7.setLayout(new BorderLayout(0, 0));

		JLabel titleLabel = new JLabel("\u6A19\u984C");
		panel_7.add(titleLabel, BorderLayout.WEST);

		titleField = new JTextField();
		panel_7.add(titleField);
		titleField.setColumns(10);

		JPanel panel_8 = new JPanel();
		panel_5.add(panel_8);
		panel_8.setLayout(new BorderLayout(0, 0));

		JLabel contextLabel = new JLabel("\u5167\u5BB9");
		panel_8.add(contextLabel, BorderLayout.WEST);

		contextField = new JTextField();
		panel_8.add(contextField, BorderLayout.CENTER);
		contextField.setColumns(10);

		sendButton = new JButton("\u9001\u51FA");
		sendButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				final MessageObject data = new MessageObject(1, titleField
						.getText(), contextField.getText(), 0, 0, 0, 0, "", "",
						0, 0);
				ContactGroup group = m_groups.getGroups().get(
						comboBox.getSelectedIndex());

				for (int i = 0; i < group.getPersons().size(); i++) {
					final String ip = group.getPersons().get(i).getIp();
					new Thread() {
						public void run() {

							Socket client = new Socket();
							InetSocketAddress isa = new InetSocketAddress(ip,
									3333);
							try {
								client.connect(isa, 30000);
								ObjectOutputStream out = new ObjectOutputStream(
										client.getOutputStream());
								// 送出object
								out.writeObject(data);
								out.flush();
								out.close();
								client.close();
								client = null;

							} catch (java.io.IOException e) {
								System.out.println("Socket連線有問題 !");
								System.out.println("IOException :"
										+ e.toString());
							}
						}

					}.start();
				}

			}
		});
		panel_8.add(sendButton, BorderLayout.EAST);

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("便利貼", null, panel_2, null);
		tabbedPane.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				showPopmenu(e);
			}
		});

		// Add
		JMenuItem jmnuAdd = new JMenuItem();
		jmnuAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new NoteFrame(new MessageObject()).setVisible(true);
			}

		});
		// 設定選單項目的動作
		jmnuAdd.setText("新增");

		// 建立突顯式選單
		jpopupmenu.add(jmnuAdd);

		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("檔案中心", null, panel_3, null);
		panel_3.setLayout(new BorderLayout(0, 0));

		JPanel panel_9 = new JPanel();
		panel_3.add(panel_9, BorderLayout.CENTER);
		panel_9.setLayout(new GridLayout(1, 2, 0, 0));

		JScrollPane downloadscrollPane = new JScrollPane();
		panel_9.add(downloadscrollPane);

		JList downloadList = new JList();
		downloadList.setBorder(new TitledBorder(null, "下載佇列",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		downloadscrollPane.setViewportView(downloadList);

		JScrollPane downloadedscrollPane = new JScrollPane();
		panel_9.add(downloadedscrollPane);

		JList downloadedList = new JList();
		downloadedList.setBorder(new TitledBorder(null, "已下載",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		downloadedscrollPane.setViewportView(downloadedList);

		JProgressBar progressBar = new JProgressBar();
		panel_3.add(progressBar, BorderLayout.SOUTH);

		initDataBindings();
		// JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		// panel_3.add(tabbedPane_1);
	}

	private void showPopmenu(MouseEvent e) {
		// 當按下滑鼠按鍵時
		if (e.getButton() == MouseEvent.BUTTON2
				|| e.getButton() == MouseEvent.BUTTON3)
			// 顯示突顯式選單
			jpopupmenu.show(e.getComponent(), e.getX(), e.getY());
	}

	public void init() {
		try {

			Statement groupstat = DBLiteConnection.createStatement(); // used
																		// for
																		// usergroup
			Statement userstat = DBLiteConnection.createStatement(); // used for
																		// user

			groupstat
					.executeUpdate("create table if not exists user (id INTEGER PRIMARY KEY ASC AUTOINCREMENT,"
							+ "groupid INTEGER,name VARCHAR(30),ip VARCHAR(15));");
			groupstat
					.executeUpdate("create table if not exists usergroup (groupid INTEGER PRIMARY KEY ASC AUTOINCREMENT,"
							+ "name VARCHAR(40) UNIQUE);");

			ResultSet rs = groupstat.executeQuery("select * from usergroup;");
			while (rs.next()) {
				ContactGroup group = new ContactGroup(rs.getString("groupid"),
						rs.getString("name"));
				m_groups.addGroup(group);
				ResultSet rs2 = userstat
						.executeQuery("select * from user where groupid = '"
								+ rs.getString("groupid") + "';");
				while (rs2.next())
					group.addPerson(new Contact(rs2.getString("id"), rs2
							.getString("name"), rs2.getString("ip")));
				rs2.close();
			}
			rs.close();
			groupstat.close();
			userstat.close();
		} catch (SQLException e) {
			System.out.println("ERROR" + e.getMessage());
		}

	}

	// type 對應到各個TAB
	// 0:保戶訊息
	// 1:資源分享
	// 2.便利貼
	// 3.檔案夾
	public void addMessage(final MessageObject data, String ipAddress) {

		try {

			StyleConstants.setFontSize(attrset, 16);

			switch (data.getType()) {
			case MessageObject.M_INFORMATION:
				StyleConstants.setForeground(attrset, Color.RED);
				policyDocument.insertString(policyDocument.getLength(),
						data.getContext(), attrset);
				break;

			case MessageObject.M_SOURCE:
				if (data.getContext().contains("http")) {
					StyledDocument doc = (StyledDocument) textPane
							.getDocument();
					JTextField field = new JTextField();
					field.setColumns(data.getTitle().length());
					field.setText(data.getTitle());
					field.setEditable(false);
					field.setOpaque(true);
					field.setForeground(Color.BLUE);

					// The component must first be wrapped in a style
					Style style = doc.addStyle("StyleName", null);
					StyleConstants.setComponent(style, field);

					// Insert the component at the end of the text
					doc.insertString(doc.getLength(), " ", style);

					field.addMouseListener(new MouseAdapter() {
						public void mouseClicked(java.awt.event.MouseEvent evt) {
							if (evt.getClickCount() == 2) {

								List<String> cmdlist = new ArrayList<String>();
								cmdlist.add("cmd.exe");
								cmdlist.add("/c");
								cmdlist.add("start");
								String link = data.getContext().replaceAll("&",
										"\"&\"");
								cmdlist.add(link);

								try {

									new ProcessBuilder(cmdlist).start();
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						}
					});
				} else {
					StyleConstants.setForeground(attrset, Color.BLACK);
					textDocument.insertString(textDocument.getLength(),
							data.getContext(), attrset);
				}
				tabbedPane.setSelectedIndex(data.getType());
				break;

			case MessageObject.M_POSTIT:
				if (data.getFilename().length() != 0)
					tabbedPane.setSelectedIndex(data.getType() + 1);
				break;

			case MessageObject.M_CHATTING:
				break;

			default:
				break;
			}
			if (data.getContext().length() != 0)
				textDocument.insertString(textDocument.getLength(), "\n",
						attrset);
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	protected void initDataBindings() {
		BeanProperty<ContactGroups, List<String>> contactGroupsBeanProperty = BeanProperty
				.create("groupnames");
		JComboBoxBinding<String, ContactGroups, JComboBox> jComboBinding = SwingBindings
				.createJComboBoxBinding(UpdateStrategy.READ, m_groups,
						contactGroupsBeanProperty, comboBox);
		jComboBinding.bind();
		//
		ELProperty<JTextField, Object> jTextFieldEvalutionProperty_1 = ELProperty
				.create("${text!=''}");
		BeanProperty<JButton, Boolean> jButtonBeanProperty = BeanProperty
				.create("enabled");
		AutoBinding<JTextField, Object, JButton, Boolean> autoBinding_1 = Bindings
				.createAutoBinding(UpdateStrategy.READ, contextField,
						jTextFieldEvalutionProperty_1, sendButton,
						jButtonBeanProperty);
		autoBinding_1.bind();
		//
		ELProperty<JComboBox, Object> jComboBoxEvalutionProperty = ELProperty
				.create("${selectedItem!=null}");
		AutoBinding<JComboBox, Object, JButton, Boolean> autoBinding = Bindings
				.createAutoBinding(UpdateStrategy.READ, comboBox,
						jComboBoxEvalutionProperty, sendButton,
						jButtonBeanProperty);
		autoBinding.bind();
	}
}
