package query.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.swing.DropMode;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.TransferHandler;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.TableColumnModelEvent;
import javax.swing.event.TableColumnModelListener;

import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.Bindings;
import org.jdesktop.beansbinding.ELProperty;
import org.jdesktop.swingbinding.JListBinding;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

import query.model.Contact.Contact;
import query.model.Contact.ContactGroup;
import query.model.Contact.ContactGroups;
import query.model.Contact.ContactSend;
import query.model.Contact.ContactSendGroup;
import database.connection.DBLiteConnection;

/**
 * @author fyyang<br>
 *         100/10/04
 * 
 */
@SuppressWarnings("serial")
public class JContactBook extends JDialog {
	private ContactGroups m_groups;
	private ContactSendGroup sendGroups;
	private JList send_list; // 傳送LIST
	private JSplitPane m_contentPane;
	private JList m_groupList;
	private JPanel groupToolbar;
	private JButton m_newGroupButton;
	private JButton m_editGroupButton;
	private JButton m_deleteGroupButton;
	private JTable m_personTable;
	private JButton m_newPersonButton;
	private JButton m_deletePersonButton;
	private JTextField m_nameTextField;
	private JTextField m_ipTextField;
	// private Connection conn;
	private JButton m_updatePersonButton;
	private JPanel panel;
	private JPanel panel_1;
	private JButton btnClear;
	private JButton btnSend;
	private JButton btnCancel;

	private void setDefaultValues() {
		// sendlist.add
	}

	public JContactBook(ContactGroups groups, boolean isSending,
			ContactSendGroup sendGroups) {
		this.sendGroups = sendGroups;
		init(groups, isSending);
	}

	/**
	 * @wbp.parser.constructor
	 */

	public JContactBook(ContactGroups groups, boolean isSending) {
		init(groups, isSending);
	}

	@SuppressWarnings("serial")
	public void init(ContactGroups groups, final boolean isSending) {

		Container container = this.getContentPane();
		container.setLayout(new BorderLayout());
		this.setModal(true);
		this.m_groups = groups;
		setTitle("通訊錄");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				if (isSending)
					m_groups.removeAll();
				dispose();
			}
		});
		if (isSending)
			setBounds(100, 100, 600, 400);
		else
			setBounds(100, 100, 600, 400);
		m_contentPane = new JSplitPane();
		m_contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		container.add(m_contentPane, BorderLayout.CENTER);
		{
			JPanel leftPanel = new JPanel();
			leftPanel.setBorder(null);
			GridBagLayout gridBagLayout = new GridBagLayout();
			gridBagLayout.columnWidths = new int[] { 44, 0 };
			gridBagLayout.rowHeights = new int[] { 0, 220, 0 };
			gridBagLayout.columnWeights = new double[] { 1.0, 1.0E-4 };
			gridBagLayout.rowWeights = new double[] { 0.0, 1.0, 1.0E-4 };
			leftPanel.setLayout(gridBagLayout);
			m_contentPane.setLeftComponent(leftPanel);
			{
				groupToolbar = new JPanel();
				FlowLayout flowLayout = (FlowLayout) groupToolbar.getLayout();
				flowLayout.setAlignment(FlowLayout.LEFT);
				GridBagConstraints gbc = new GridBagConstraints();
				gbc.anchor = GridBagConstraints.NORTHWEST;
				gbc.insets = new Insets(0, 0, 5, 0);
				gbc.gridx = 0;
				gbc.gridy = 0;
				leftPanel.add(groupToolbar, gbc);
				{
					m_newGroupButton = new JButton("\u65B0\u589E");
					m_newGroupButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							// PhoneGroup group = new PhoneGroup("???");
							JContactGroupDialog dialog = new JContactGroupDialog(
									m_groups, true, -1);
							dialog.setLocationRelativeTo(m_contentPane);
							dialog.setVisible(true);
							// m_groups.addGroup(group);
							// m_groupList.repaint();
						}
					});
					groupToolbar.add(m_newGroupButton);
				}
				{
					m_editGroupButton = new JButton("\u4FEE\u6539");
					m_editGroupButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							// PhoneGroup group = m_groups.getGroups().get(
							// m_groupList.getSelectedIndex());
							JContactGroupDialog dialog = new JContactGroupDialog(
									m_groups, false, m_groupList
											.getSelectedIndex());
							dialog.setLocationRelativeTo(m_contentPane);
							dialog.setVisible(true);
						}
					});
					groupToolbar.add(m_editGroupButton);
				}
				{
					m_deleteGroupButton = new JButton("\u522A\u9664");
					m_deleteGroupButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							int i = JOptionPane.showConfirmDialog(null,
									"刪除群組將會連同成員一併刪除", "刪除群組",
									JOptionPane.OK_CANCEL_OPTION);
							if (i == JOptionPane.OK_OPTION) {
								try {
									String id = m_groups
											.getGroups()
											.get(m_groupList.getSelectedIndex())
											.getId();
									Statement stat = DBLiteConnection
											.createStatement();
									stat.executeUpdate("DELETE FROM usergroup where groupid = '"
											+ id + "';");
									stat.executeUpdate("DELETE FROM user where id = '"
											+ id + "';");
									m_groups.removeGroup(m_groups
											.getGroups()
											.get(m_groupList.getSelectedIndex()));
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								} // used for usergroup

							}

							// m_groupList.repaint();
						}
					});
					groupToolbar.add(m_deleteGroupButton);
				}
			}
			{
				m_groupList = new JList();
				m_groupList
						.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				GridBagConstraints gbc = new GridBagConstraints();
				gbc.fill = GridBagConstraints.BOTH;
				gbc.gridx = 0;
				gbc.gridy = 1;
				leftPanel.add(m_groupList, gbc);
			}
		}
		{
			JSplitPane rightPanel = new JSplitPane();
			rightPanel.setBorder(null);
			rightPanel.setOrientation(JSplitPane.VERTICAL_SPLIT);
			rightPanel.setDividerLocation(1.0);
			m_contentPane.setRightComponent(rightPanel);
			{
				JPanel topPanel = new JPanel();
				GridBagLayout gridBagLayout = new GridBagLayout();
				gridBagLayout.columnWidths = new int[] { 0, 0 };
				gridBagLayout.rowHeights = new int[] { 0, 238, 0 };
				gridBagLayout.columnWeights = new double[] { 1.0, 1.0E-4 };
				gridBagLayout.rowWeights = new double[] { 0.0, 1.0, 1.0E-4 };
				topPanel.setLayout(gridBagLayout);
				rightPanel.setLeftComponent(topPanel);
				{
					JPanel personToolbar = new JPanel();
					GridBagConstraints gbc = new GridBagConstraints();
					gbc.anchor = GridBagConstraints.NORTHWEST;
					gbc.insets = new Insets(0, 0, 5, 0);
					gbc.gridx = 0;
					gbc.gridy = 0;
					topPanel.add(personToolbar, gbc);
					{
						m_newPersonButton = new JButton("\u65B0\u589E");
						m_newPersonButton
								.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										PreparedStatement groupprep;
										try {
											ContactGroup group = m_groups
													.getGroups()
													.get(m_groupList
															.getSelectedIndex());
											String id = group.getId();

											groupprep = DBLiteConnection
													.createPreparedStatement("insert into user (groupid,name,ip) values (?, ?, ?);");
											groupprep.setString(1, id);
											groupprep.setString(2, "請輸入");
											groupprep.setString(3, "0.0.0.0");
											DBLiteConnection
													.executeUpdate(groupprep);

											ResultSet rs = DBLiteConnection
													.createStatement()
													.executeQuery(
															"select last_insert_rowid();");
											if (rs.next()) {
												String rowid = rs.getString(1);
												ResultSet rs2 = DBLiteConnection
														.createStatement()
														.executeQuery(
																"select id from user where rowid = '"
																		+ rowid
																		+ "';");
												while (rs2.next()) {
													String userid = rs2
															.getString(1);
													group.addPerson(new Contact(
															userid, "請輸入",
															"0.0.0.0"));
												}
											}

										} catch (SQLException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
									}
								});
						personToolbar.add(m_newPersonButton);
					}
					{
						m_deletePersonButton = new JButton("\u522A\u9664");
						m_deletePersonButton
								.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										ContactGroup group = m_groups
												.getGroups()
												.get(m_groupList
														.getSelectedIndex());
										Contact person = group.getPersons()
												.get(m_personTable
														.getSelectedRow());
										int i = JOptionPane.showConfirmDialog(
												null,
												"確定刪除成員 -" + person.getName(),
												"刪除成員",
												JOptionPane.OK_CANCEL_OPTION);

										if (i == JOptionPane.OK_OPTION) {
											try {
												String id = person.getId();
												Statement stat = DBLiteConnection
														.createStatement();
												stat.executeUpdate("DELETE FROM user where id = '"
														+ id + "';");
												group.removePerson(person);
											} catch (SQLException e1) {
												// TODO Auto-generated catch
												// block
												e1.printStackTrace();
											} // used for usergroup

										}

									}
								});
						personToolbar.add(m_deletePersonButton);
					}
					{
						m_updatePersonButton = new JButton("\u66F4\u65B0");
						m_updatePersonButton
								.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent arg0) {
										ContactGroup group = m_groups
												.getGroups()
												.get(m_groupList
														.getSelectedIndex());
										Contact person;
										PreparedStatement userprep;
										try {
											userprep = DBLiteConnection
													.createPreparedStatement("update user set name = ?, ip = ? where id = ?;");
											int count = 0;
											System.out.println("count is:"
													+ group.getPersonCount());
											for (int i = 0; i < group
													.getPersonCount(); i++) {
												person = group.getPersons()
														.get(i);
												if (!person.getEdit()
														.equals("")) {
													System.out.println(person
															.getId()
															+ " "
															+ person.getName()
															+ " "
															+ person.getIp());
													userprep.setString(1,
															person.getName());
													userprep.setString(2,
															person.getIp());
													userprep.setString(3,
															person.getId());
													DBLiteConnection
															.executeUpdate(userprep);

													person.setEdit("");
													count++;
												}
											}
											String message;
											if (count != 0) {
												userprep.executeBatch();
												message = "更新完成";
											} else {
												message = "無資料更新";
											}
											userprep.close();
											JOptionPane
													.showMessageDialog(
															null,
															message,
															"資料更新",
															JOptionPane.INFORMATION_MESSAGE);

										} catch (SQLException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}

									}
								});
						personToolbar.add(m_updatePersonButton);
					}
				}
				{
					m_personTable = new JTable();
					m_personTable
							.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					m_personTable.getColumnModel().addColumnModelListener(
							new TableColumnModelListener() {

								@Override
								public void columnAdded(
										TableColumnModelEvent arg0) {
									// TODO Auto-generated method stub
									if (m_personTable.getColumnCount() == 1)
										m_personTable.getColumnModel()
												.getColumn(0).setMaxWidth(40);
								}

								@Override
								public void columnMarginChanged(ChangeEvent arg0) {
									// TODO Auto-generated method stub
									// System.out.println("EEE");
								}

								@Override
								public void columnMoved(TableColumnModelEvent e) {
									// TODO Auto-generated method stub

								}

								@Override
								public void columnRemoved(
										TableColumnModelEvent e) {
									// TODO Auto-generated method stub

								}

								@Override
								public void columnSelectionChanged(
										ListSelectionEvent e) {
									// TODO Auto-generated method stub

								}

							});

					JScrollPane scrollPane = new JScrollPane(m_personTable);
					GridBagConstraints gbc = new GridBagConstraints();
					gbc.fill = GridBagConstraints.BOTH;
					gbc.gridx = 0;
					gbc.gridy = 1;
					topPanel.add(scrollPane, gbc);
				}
			}
			{
				JPanel bottomPanel = new JPanel();
				bottomPanel.setBorder(new MatteBorder(10, 10, 10, 10,
						(Color) null));
				GridBagLayout gridBagLayout = new GridBagLayout();
				gridBagLayout.columnWidths = new int[] { 0, 0, 0 };
				gridBagLayout.rowHeights = new int[] { 0, 0, 0 };
				gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 1.0E-4 };
				gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 1.0E-4 };
				bottomPanel.setLayout(gridBagLayout);
				rightPanel.setRightComponent(bottomPanel);
				{
					JLabel lblName = new JLabel("\u59D3\u540D:");
					GridBagConstraints gbc = new GridBagConstraints();
					gbc.insets = new Insets(0, 0, 5, 5);
					gbc.anchor = GridBagConstraints.WEST;
					gbc.gridx = 0;
					gbc.gridy = 0;
					bottomPanel.add(lblName, gbc);
				}
				{
					m_nameTextField = new JTextField();
					GridBagConstraints gbc = new GridBagConstraints();
					gbc.insets = new Insets(0, 0, 5, 0);
					gbc.fill = GridBagConstraints.HORIZONTAL;
					gbc.gridx = 1;
					gbc.gridy = 0;
					bottomPanel.add(m_nameTextField, gbc);
					m_nameTextField.setColumns(10);
				}
				{
					JLabel lblEmail = new JLabel("IP:");
					GridBagConstraints gbc = new GridBagConstraints();
					gbc.anchor = GridBagConstraints.WEST;
					gbc.insets = new Insets(0, 0, 0, 5);
					gbc.gridx = 0;
					gbc.gridy = 1;
					bottomPanel.add(lblEmail, gbc);
				}
				{
					m_ipTextField = new JTextField();
					GridBagConstraints gbc_m_ipTextField = new GridBagConstraints();
					gbc_m_ipTextField.fill = GridBagConstraints.HORIZONTAL;
					gbc_m_ipTextField.gridx = 1;
					gbc_m_ipTextField.gridy = 1;
					bottomPanel.add(m_ipTextField, gbc_m_ipTextField);
					m_ipTextField.setColumns(10);
				}
			}
		}
		// --------------------------------------------------------------
		// -----------------------if isSending---------------------------
		if (isSending) {
			if (sendGroups == null)
				sendGroups = new ContactSendGroup();
			panel = new JPanel();
			panel.setPreferredSize(new Dimension(170, 30));
			getContentPane().add(panel, BorderLayout.EAST);
			panel.setLayout(new BorderLayout());
			{
				send_list = new JList();
				send_list.setBorder(new TitledBorder(null,
						"\u5BC4\u9001\u6E05\u55AE", TitledBorder.LEADING,
						TitledBorder.TOP, null, null));
				JScrollPane listView = new JScrollPane(send_list);

				panel.add(listView, BorderLayout.CENTER);
			}
			send_list.setVisibleRowCount(-1);
			send_list.getSelectionModel().setSelectionMode(
					ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

			send_list.setTransferHandler(new TransferHandler() {

				public boolean canImport(TransferHandler.TransferSupport info) {
					// we only import Strings
					if (!info.isDataFlavorSupported(DataFlavor.stringFlavor)) {
						return false;
					}

					JList.DropLocation dl = (JList.DropLocation) info
							.getDropLocation();
					if (dl.getIndex() == -1) {

						return false;
					}

					return true;
				}

				public boolean importData(TransferHandler.TransferSupport info) {

					if (!info.isDrop()) {

						return false;
					}

					// Check for String flavor
					if (!info.isDataFlavorSupported(DataFlavor.stringFlavor)) {
						displayDropLocation("List doesn't accept a drop of this type.");

						return false;
					}

					// JList.DropLocation dl = (JList.DropLocation) info
					// .getDropLocation();
					// DefaultListModel listModel = (DefaultListModel) send_list
					// .getModel();
					// int index = dl.getIndex();
					// boolean insert = dl.isInsert();
					// Get the current string under the drop.
					// String value = (String)listModel.getElementAt(index);

					// Get the string that is being dropped.
					Transferable t = info.getTransferable();
					String data;
					try {
						// System.out.println("88888888888888");
						data = (String) t
								.getTransferData(DataFlavor.stringFlavor);
						System.out.println(data);
					} catch (Exception e) {

						return false;
					}
					// Display a dialog with the drop information.
					// String dropValue = "\"" + data + "\" dropped ";
					// if (dl.isInsert()) {
					// if (dl.getIndex() == 0) {
					// // displayDropLocation(dropValue +
					// // "at beginning of list");
					// } else if (dl.getIndex() >= send_list.getModel()
					// .getSize()) {
					// // displayDropLocation(dropValue +
					// // "at end of list");
					// } else {
					// String value1 = (String) send_list.getModel()
					// .getElementAt(dl.getIndex() - 1);
					// String value2 = (String) send_list.getModel()
					// .getElementAt(dl.getIndex());
					// displayDropLocation(dropValue + "between \""
					// + value1 + "\" and \"" + value2 + "\""
					// + data);
					// }
					// } else {
					// // displayDropLocation(dropValue + "on top of " + "\"" +
					// // value + "\"");
					// }
					// if (data.)
					// 尾巴為)結尾為GROUP(JList節點)
					if (data.substring(data.length() - 1).equals(")")) {
						int select = m_groupList.getSelectedIndex();
						ContactGroup contactGroup = m_groups.getGroups().get(
								select);
						List<Contact> contactList = contactGroup.getPersons();
						for (int i = 0; i < contactList.size(); i++) {
							Contact contact = contactList.get(i);
							ContactSend contactSend = new ContactSend(contact
									.getId(), contact.getIp(), contact
									.getName());
							sendGroups.addGroup(contactSend);
						}

					} else { // 個人節點
						int selectgroup = m_groupList.getSelectedIndex();
						int select = m_personTable.getSelectedRow();
						Contact contact = m_groups.getGroups().get(selectgroup)
								.getPersons().get(select);
						ContactSend contactSend = new ContactSend(contact
								.getId(), contact.getIp(), contact.getName());
						sendGroups.addGroup(contactSend);
					}
					return false;
				}

				public int getSourceActions(JComponent c) {
					return COPY;
				}

				protected Transferable createTransferable(JComponent c) {
					JList list = (JList) c;
					Object[] values = list.getSelectedValues();

					StringBuffer buff = new StringBuffer();

					for (int i = 0; i < values.length; i++) {
						Object val = values[i];
						buff.append(val == null ? "" : val.toString());
						if (i != values.length - 1) {
							buff.append("\n");
						}
					}
					return new StringSelection(buff.toString());
				}

			});
			send_list.setDropMode(DropMode.ON_OR_INSERT);
			send_list.setDragEnabled(isSending);
			{
				panel_1 = new JPanel();
				panel.add(panel_1, BorderLayout.SOUTH);
				panel_1.setLayout(new GridLayout(0, 3, 0, 0));
				{
					btnClear = new JButton("清空");
					btnClear.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent arg0) {
							sendGroups.removeAll();
						}
					});
					panel_1.add(btnClear);
				}
				{
					btnSend = new JButton("寄送");
					btnSend.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent arg0) {
							dispose();
						}
					});
					panel_1.add(btnSend);
				}
				{
					btnCancel = new JButton("取消");
					btnCancel.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent arg0) {
							sendGroups.removeAll();
							m_groups = null;
							sendGroups = null;
							dispose();
						}
					});
					panel_1.add(btnCancel);
				}
			}
			m_personTable.setDragEnabled(isSending);
			m_groupList.setDragEnabled(isSending);
		}
		// ------------------------end IF isSending--------------------------
		setDefaultValues();
		initDataBindings();

	}

	private void displayDropLocation(final String string) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JOptionPane.showMessageDialog(null, string);
			}
		});
	}

	protected void initDataBindings() {
		ELProperty<JList, Object> jListEvalutionProperty = ELProperty
				.create("${ selectedElement != null }");
		BeanProperty<JButton, Boolean> jButtonBeanProperty = BeanProperty
				.create("enabled");
		AutoBinding<JList, Object, JButton, Boolean> autoBinding = Bindings
				.createAutoBinding(UpdateStrategy.READ, m_groupList,
						jListEvalutionProperty, m_editGroupButton,
						jButtonBeanProperty);
		autoBinding.bind();
		//
		ELProperty<JList, Object> jListEvalutionProperty_1 = ELProperty
				.create("${ selectedElement != null }");
		BeanProperty<JButton, Boolean> jButtonBeanProperty_1 = BeanProperty
				.create("enabled");
		AutoBinding<JList, Object, JButton, Boolean> autoBinding_6 = Bindings
				.createAutoBinding(UpdateStrategy.READ, m_groupList,
						jListEvalutionProperty_1, m_deleteGroupButton,
						jButtonBeanProperty_1);
		autoBinding_6.bind();
		//
		ELProperty<JTable, Object> jTableEvalutionProperty = ELProperty
				.create("${ selectedElement != null }");
		BeanProperty<JButton, Boolean> jButtonBeanProperty_2 = BeanProperty
				.create("enabled");
		AutoBinding<JTable, Object, JButton, Boolean> autoBinding_7 = Bindings
				.createAutoBinding(UpdateStrategy.READ, m_personTable,
						jTableEvalutionProperty, m_deletePersonButton,
						jButtonBeanProperty_2);
		autoBinding_7.bind();
		//
		BeanProperty<ContactGroups, List<ContactGroup>> phoneGroupsBeanProperty = BeanProperty
				.create("groups");
		JListBinding<ContactGroup, ContactGroups, JList> jListBinding = SwingBindings
				.createJListBinding(UpdateStrategy.READ, m_groups,
						phoneGroupsBeanProperty, m_groupList);
		//
		ELProperty<ContactGroup, Object> phoneGroupEvalutionProperty = ELProperty
				.create("${name}(${personCount})");
		jListBinding.setDetailBinding(phoneGroupEvalutionProperty);
		//
		jListBinding.bind();
		//
		BeanProperty<JList, List<Contact>> jListBeanProperty = BeanProperty
				.create("selectedElement.persons");
		JTableBinding<Contact, JList, JTable> jTableBinding = SwingBindings
				.createJTableBinding(UpdateStrategy.READ, m_groupList,
						jListBeanProperty, m_personTable);
		//
		BeanProperty<Contact, String> personBeanProperty = BeanProperty
				.create("edit");
		jTableBinding.addColumnBinding(personBeanProperty).setColumnName(
				"\u4FEE\u6539");
		//
		BeanProperty<Contact, String> personBeanProperty_1 = BeanProperty
				.create("name");
		jTableBinding.addColumnBinding(personBeanProperty_1).setColumnName(
				"\u59D3\u540D");
		//
		BeanProperty<Contact, String> personBeanProperty_2 = BeanProperty
				.create("ip");
		jTableBinding.addColumnBinding(personBeanProperty_2)
				.setColumnName("IP");
		//
		jTableBinding.setEditable(false);
		jTableBinding.bind();
		//
		BeanProperty<JTable, String> jTableBeanProperty = BeanProperty
				.create("selectedElement.name");
		BeanProperty<JTextField, String> jTextFieldBeanProperty = BeanProperty
				.create("text");
		AutoBinding<JTable, String, JTextField, String> autoBinding_1 = Bindings
				.createAutoBinding(UpdateStrategy.READ_WRITE, m_personTable,
						jTableBeanProperty, m_nameTextField,
						jTextFieldBeanProperty);
		autoBinding_1.bind();
		//
		BeanProperty<JTable, String> jTableBeanProperty_1 = BeanProperty
				.create("selectedElement.ip");
		BeanProperty<JTextField, String> jTextFieldBeanProperty_1 = BeanProperty
				.create("text");
		AutoBinding<JTable, String, JTextField, String> autoBinding_2 = Bindings
				.createAutoBinding(UpdateStrategy.READ_WRITE, m_personTable,
						jTableBeanProperty_1, m_ipTextField,
						jTextFieldBeanProperty_1);
		autoBinding_2.bind();
		//
		ELProperty<JTable, Object> jTableEvalutionProperty_1 = ELProperty
				.create("${selectedElement!=null}");
		BeanProperty<JTextField, Boolean> jTextFieldBeanProperty_2 = BeanProperty
				.create("editable");
		AutoBinding<JTable, Object, JTextField, Boolean> autoBinding_3 = Bindings
				.createAutoBinding(UpdateStrategy.READ, m_personTable,
						jTableEvalutionProperty_1, m_nameTextField,
						jTextFieldBeanProperty_2);
		autoBinding_3.bind();
		//
		ELProperty<JTable, Object> jTableEvalutionProperty_2 = ELProperty
				.create("${selectedElement!=null}");
		AutoBinding<JTable, Object, JTextField, Boolean> autoBinding_4 = Bindings
				.createAutoBinding(UpdateStrategy.READ, m_personTable,
						jTableEvalutionProperty_2, m_ipTextField,
						jTextFieldBeanProperty_2);
		autoBinding_4.bind();
		//
		ELProperty<JList, Object> jListEvalutionProperty_2 = ELProperty
				.create("${selectedElement!=null}");
		AutoBinding<JList, Object, JButton, Boolean> autoBinding_5 = Bindings
				.createAutoBinding(UpdateStrategy.READ, m_groupList,
						jListEvalutionProperty_2, m_newPersonButton,
						jButtonBeanProperty);
		autoBinding_5.bind();
		//
		ELProperty<JTable, Object> jTableEvalutionProperty_3 = ELProperty
				.create("${selectedElement!=null}");
		AutoBinding<JTable, Object, JButton, Boolean> autoBinding_8 = Bindings
				.createAutoBinding(UpdateStrategy.READ, m_personTable,
						jTableEvalutionProperty_3, m_updatePersonButton,
						jButtonBeanProperty);
		autoBinding_8.bind();
		//
		BeanProperty<ContactSendGroup, List<ContactSend>> contactSendGroupBeanProperty = BeanProperty
				.create("groups");
		JListBinding<ContactSend, ContactSendGroup, JList> jListBinding_1 = SwingBindings
				.createJListBinding(UpdateStrategy.READ, sendGroups,
						contactSendGroupBeanProperty, send_list);
		//
		ELProperty<ContactSend, Object> contactSendEvalutionProperty = ELProperty
				.create("${name}<${ip}>");
		jListBinding_1.setDetailBinding(contactSendEvalutionProperty);
		//
		jListBinding_1.bind();
	}
}