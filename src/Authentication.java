import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

import program.setting.User32;
import program.setting.W32API;
import query.view.QueryFrame;
import query.view.QueryFrame.DoSearchHandler;
import database.connection.DBConnection;

/**
 * @ * @author FYYANG
 * 
 * @version 1.0<br>
 *          100/07/28<br>
 *          主機交易查詢系統認證視窗
 * 
 * @since 1.0
 */
public class Authentication {
	// private static MessageController messageController;
	@SuppressWarnings("unused")
	private static ServerSocket serverTcp;
	private JFrame frame;
	private JPanel accountpanel;
	private JPanel buttonpanel;
	private JButton loginButton;
	private JButton clearButton;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField accountField;
	private JPasswordField passwordField;
	private int frameWidth = 250;
	private int frameHeight = 150;
	private static String argUser = "";
	private static String argPassword = "";
	private static String argPolicyNo = "";
	private static String argClientID = "";
        //test pull
	/**
	 * Launch the application
	 */
	public static void main(String[] args) {
		// 更改字體大小
		Font font = new Font("DEFAULT", Font.PLAIN, 15);

		// 接受參數以供直接啟動整合查詢程式
		if (args.length > 0) {
			for (int i = 0; i < args.length; i++) {
				switch (i) {
				case 0:
					argUser = args[i];
					break;
				case 1:
					argPassword = args[i];
					break;
				case 2:
					argPolicyNo = args[i];
					break;
				case 3:
					argClientID = args[i];
					break;
				}
			}
			argUser = (argUser == null) ? "" : argUser;
			argPassword = (argPassword == null) ? "" : argPassword;
			argPolicyNo = (argPolicyNo == null) ? "" : argPolicyNo;
			argClientID = (argClientID == null) ? "" : argClientID;
		}

		@SuppressWarnings("rawtypes")
		java.util.Enumeration keys = UIManager.getDefaults().keys();
		while (keys.hasMoreElements()) {
			Object key = keys.nextElement();
			Object value = UIManager.get(key);
			if (value instanceof javax.swing.plaf.FontUIResource) {
				UIManager.put(key, font);
			}

		}
		try {
			// 先開啟MessageController,會使用PORT 3333,順便偵測此程式是否"已"開啟
			// messageController = new MessageController();
			// 目前新增SearchServiceController會使用PORT 3333 用此方法偵測此程式是否開啟
			serverTcp = new ServerSocket(3333);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			W32API.HWND hwnd = User32.INSTANCE.FindWindow("SunAwtFrame",
					"\u4E3B\u6A5F\u4EA4\u6613\u67E5\u8A62\u7CFB\u7D71" + "："
							+ DBConnection.getServerName());
			if (hwnd != null) {
				User32.INSTANCE.ShowWindow(hwnd, 9);
				User32.INSTANCE.SetForegroundWindow(hwnd);
			}
			// JOptionPane.showMessageDialog(null, "程式已開啟", "無法重覆執行",
			// JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Authentication window = new Authentication();
					// 若為接受參數啟動則不需顯示登入畫面直接登入
					if (argUser.length() > 0) {
						window.frame.setVisible(false);
					} else {
						window.frame.setVisible(true);
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		// }
	}

	/**
	 * Create the application.
	 */
	public Authentication() {
		try {
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
			// JOptionPane.showMessageDialog(null, e.getMessage());
		}

		initialize();
		if (argUser.length() > 0 && argPassword.length() > 0) {
			accountField.setText(argUser);
			passwordField.setText(argPassword);
			connectToServer();
		}
		frame.setResizable(false);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u4E3B\u6A5F\u4EA4\u6613\u67E5\u8A62\u7CFB\u7D71" + "："
				+ DBConnection.getServerName());
		frame.getContentPane().setLocale(Locale.TRADITIONAL_CHINESE);

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setBounds((dim.width - frameWidth) / 2,
				(dim.height - frameHeight) / 2, 276, 126);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));

		accountpanel = new JPanel();
		frame.getContentPane().add(accountpanel, BorderLayout.CENTER);
		GridBagLayout gbl_accountpanel = new GridBagLayout();
		gbl_accountpanel.columnWidths = new int[] { 0, 0, 0 };
		gbl_accountpanel.rowHeights = new int[] { 0, 0, 0 };
		gbl_accountpanel.columnWeights = new double[] { 0.0, 1.0,
				Double.MIN_VALUE };
		gbl_accountpanel.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		accountpanel.setLayout(gbl_accountpanel);

		lblNewLabel = new JLabel("\u4F7F\u7528\u8005\u4EE3\u865F:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		accountpanel.add(lblNewLabel, gbc_lblNewLabel);

		accountField = new JTextField();
		GridBagConstraints gbc_accountField = new GridBagConstraints();
		gbc_accountField.insets = new Insets(0, 0, 5, 0);
		gbc_accountField.fill = GridBagConstraints.HORIZONTAL;
		gbc_accountField.gridx = 1;
		gbc_accountField.gridy = 0;
		accountpanel.add(accountField, gbc_accountField);
		accountField.setColumns(10);

		lblNewLabel_1 = new JLabel("\u4F7F\u7528\u8005\u5BC6\u78BC:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		accountpanel.add(lblNewLabel_1, gbc_lblNewLabel_1);

		passwordField = new JPasswordField();
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				// 按ENTER連線至SERVER驗證
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					connectToServer();
				}
			}
		});
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.gridx = 1;
		gbc_passwordField.gridy = 1;
		accountpanel.add(passwordField, gbc_passwordField);
		passwordField.setColumns(10);

		buttonpanel = new JPanel();
		frame.getContentPane().add(buttonpanel, BorderLayout.SOUTH);
		GridBagLayout gbl_buttonpanel = new GridBagLayout();
		gbl_buttonpanel.columnWidths = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_buttonpanel.rowHeights = new int[] { 0, 0 };
		gbl_buttonpanel.columnWeights = new double[] { 0.0, 1.0, 0.0, 1.0, 0.0,
				Double.MIN_VALUE };
		gbl_buttonpanel.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		buttonpanel.setLayout(gbl_buttonpanel);

		loginButton = new JButton("\u767B\u5165\u7CFB\u7D71");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				connectToServer();
			}
		});
		GridBagConstraints gbc_loginButton = new GridBagConstraints();
		gbc_loginButton.insets = new Insets(0, 0, 0, 5);
		gbc_loginButton.gridx = 1;
		gbc_loginButton.gridy = 0;
		buttonpanel.add(loginButton, gbc_loginButton);

		clearButton = new JButton("\u6E05\u9664\u8F38\u5165");
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				accountField.setText("");
				passwordField.setText("");
			}
		});
		GridBagConstraints gbc_clearButton = new GridBagConstraints();
		gbc_clearButton.insets = new Insets(0, 0, 0, 5);
		gbc_clearButton.gridx = 3;
		gbc_clearButton.gridy = 0;
		buttonpanel.add(clearButton, gbc_clearButton);
	}

	/**
	 * 連線至資料庫
	 * <p>
	 * 取得使用者輸入之帳號及密碼後利用DBConneciton.connect方法連線至資料庫
	 */
	public void connectToServer() {

		// 取得password
		char a[] = passwordField.getPassword();
		String password = "";
		for (int i = 0; i < a.length; i++)
			password += a[i];

		// 成功連線至資料庫則開啟QueryFrame 並關閉認證視窗
		if (DBConnection.connect(accountField.getText(), password,
				DBConnection.DBSERVER)) {
			loginSuccess();
		} else
			frame.setTitle("\u4E3B\u6A5F\u4EA4\u6613\u67E5\u8A62\u7CFB\u7D71"
					+ "：" + DBConnection.getServerName());
		// ------------------------------------------------
	}

	/**
	 * 開啟主要交易查詢視窗並關掉登入視窗
	 */
	public void loginSuccess() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// 關掉此port給SearchServiceController用
					serverTcp.close();
					QueryFrame frame = new QueryFrame();
					// frame.setMessageController(messageController);
					frame.setVisible(true);

					DoSearchHandler searchHandler = frame.getSearchHandler();

					Thread.sleep(200);
					if (argPolicyNo.length() > 0 || argClientID.length() > 0) {

						if (argPolicyNo.length() == 0)
							searchHandler.doSearch(argClientID);
						else
							searchHandler.doSearch(argPolicyNo);
					}
					searchHandler = null;

				} catch (NullPointerException e) {
					JOptionPane.showMessageDialog(null, "有nullpointer");
					System.out.println("policyNO/ID is null");
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		// 關閉登入視窗
		frame.dispose();
	}

}
