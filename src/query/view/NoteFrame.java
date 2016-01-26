package query.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.TransferHandler;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import query.model.ComponentMover;
import query.model.ComponentResizer;
import query.model.MessageObject;
import query.model.Contact.Contact;
import query.model.Contact.ContactGroup;
import query.model.Contact.ContactGroups;
import query.model.Contact.ContactSendGroup;
import database.connection.DBLiteConnection;

@SuppressWarnings("serial")
public class NoteFrame extends JFrame {

	private JPanel contentPane;
	private ContactGroups m_groups = new ContactGroups();
	private JTextField attachField;
	private MessageObject messageObject;
	private JLabel noteTitleLabel;
	private JTextArea txtrDf;
	private JScrollPane scrollPane;
	private JPanel panel;
	private JLabel attachLabel;
	private ContactSendGroup sendGroups;
	private String fileName = "";
	private String filePath = "";
	private Long fileSize = 0l;

	// /**
	// * Launch the application.
	// */
	// public static void main(String[] args) {
	//
	// EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// try {
	// DBLiteConnection.connect();
	// NoteFrame frame = new NoteFrame(new MessageObject(2, "",
	// "CONTEXT", 50, 200, 200, 300, "", "", 0));
	// frame.setVisible(true);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	// });
	// }

	/**
	 * Create the frame.
	 */
	public NoteFrame(MessageObject messageObject) {
		super("NOTE");
		// 直接利用JTextArea來傾聽TransferHandler
		// 會導致無法使用剪下貼上等功能,
		// 故利用glasspane來完成
		JComponent glasspane = (JComponent) this.getGlassPane();
		glasspane.setVisible(true);
		// glasspane.sett

		this.messageObject = messageObject;

		try {
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
		}
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(messageObject.getX(), messageObject.getY(),
				messageObject.getWidth(), messageObject.getHeight());
		contentPane = new JPanel();
		contentPane.setBackground(Color.red);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		noteTitleLabel = new JLabel();
		noteTitleLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					String title = JOptionPane.showInputDialog(getRootPane(),
							"修改標題", noteTitleLabel.getText());

					if (title != null && title.trim().length() != 0)
						noteTitleLabel.setText(title);
				}

			}
		});
		noteTitleLabel
				.setText((messageObject.getTitle().length() == 0) ? "TITLE"
						: messageObject.getTitle());
		noteTitleLabel.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(noteTitleLabel, BorderLayout.NORTH);

		@SuppressWarnings("unused")
		ComponentResizer cr = new ComponentResizer(this);
		@SuppressWarnings("unused")
		ComponentMover cm = new ComponentMover(this, noteTitleLabel);

		txtrDf = new JTextArea();

		txtrDf.setText(messageObject.getContext());
		txtrDf.setWrapStyleWord(true);
		txtrDf.setLineWrap(true);
		txtrDf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				// 按著Ctrl時getModifiers == 2 keycode =10=>Enter
				if (arg0.getModifiers() == 2) {
					if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
						setGroupValue(); // 從資料庫讀出名單

						// --選取寄送名單
						sendGroups = new ContactSendGroup();
						JContactBook frame = new JContactBook(m_groups, true,
								sendGroups);
						frame.setVisible(true);
						m_groups.removeAll();

						setMessageObject();
						sendNotes();
						// System.out.println("send");
					} else if (arg0.getKeyCode() == 115) {
						m_groups.removeAll();
						if (sendGroups != null) {
							sendGroups.removeAll();
							sendGroups = null;
						}
						m_groups = null;

						dispose();
						System.gc(); // 呼叫資源回收機制-釋放記憶體
					} else if (arg0.getKeyCode() == 72) {
						System.out.println("hide");
					}
				}
			}
		});
		TransferHandler handler = new TransferHandler() {
			public boolean canImport(TransferHandler.TransferSupport support) {
				if (!support
						.isDataFlavorSupported(DataFlavor.javaFileListFlavor)) {
					return false;
				}
				return true;
			}

			//
			@SuppressWarnings("unchecked")
			public boolean importData(TransferHandler.TransferSupport support) {
				if (!canImport(support)) {
					return false;
				}

				Transferable t = support.getTransferable();

				try {
					java.util.List<File> l = (java.util.List<File>) t
							.getTransferData(DataFlavor.javaFileListFlavor);

					for (File f : l) {
						// new Doc(f);
						if (f.isFile()) {
							// System.out.println(f.getName());
							// System.out.println(f.getAbsolutePath());
							// System.out.println(f.toURI().toURL());
							attachField.setText(f.getName());
							fileName = f.getName();
							filePath = f.toURI().toURL().toString();
							fileSize = f.length();
						}

					}
				} catch (UnsupportedFlavorException e) {
					return false;
				} catch (IOException e) {
					return false;
				}

				return true;
			}
		};
		glasspane.setTransferHandler(handler);

		scrollPane = new JScrollPane(txtrDf);
		contentPane.add(scrollPane, BorderLayout.CENTER);

		panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BorderLayout(0, 0));

		attachField = new JTextField();
		panel.add(attachField, BorderLayout.CENTER);
		attachField.setEditable(false);
		attachField.setColumns(10);

//		attachField
//				.setText((messageObject.getFilename().trim().length() == 0) ? "拖曳傳送檔案"
//						: messageObject.getFilename().trim());
		attachField.setText("拖曳傳送檔案");

		attachLabel = new JLabel("\u9644\u4EF6:");
		panel.add(attachLabel, BorderLayout.WEST);
	}

	public void setGroupValue() {
		try {
			// used for usergroup
			Statement groupstat = DBLiteConnection.createStatement();
			
			// used for user
			Statement userstat = DBLiteConnection.createStatement();

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

	private void setMessageObject() {
		messageObject.setType(2);
		messageObject.setTitle(noteTitleLabel.getText());
		messageObject.setContext(this.txtrDf.getText());
		messageObject.setX(this.getLocation().x);
		messageObject.setY(this.getLocation().y);
		messageObject.setWidth(this.getWidth());
		messageObject.setHeight(this.getHeight());
		messageObject.setFilename(fileName);
		messageObject.setFilepath(filePath);
		messageObject.setFilesize(fileSize);
		// System.out.println(messageObject.getTitle());
		// System.out.println(messageObject.getContext());
		// System.out.println(messageObject.getX());
		// System.out.println(messageObject.getY());
		// System.out.println(messageObject.getWidth());
		// System.out.println(messageObject.getHeight());
		// System.out.println(messageObject.getFilename());
		// System.out.println(messageObject.getFilepath());
	}

	private void sendNotes() {

		for (int i = 0; i < sendGroups.getGroups().size(); i++) {
			final String ip = sendGroups.getGroups().get(i).getIp();
			new Thread() {
				public void run() {

					Socket client = new Socket();
					InetSocketAddress isa = new InetSocketAddress(ip, 3333);
					try {
						client.connect(isa, 30000);
						ObjectOutputStream out = new ObjectOutputStream(
								client.getOutputStream());
						// 送出object
						out.writeObject(messageObject);
						out.flush();
						out.close();
						client.close();
						client = null;

					} catch (java.io.IOException e) {
						System.out.println("Socket連線有問題 !");
						System.out.println("IOException :" + e.toString());
					}
				}

			}.start();
		}

	}
}
