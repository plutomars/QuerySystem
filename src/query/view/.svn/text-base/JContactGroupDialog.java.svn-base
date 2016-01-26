package query.view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.Bindings;

import query.model.Contact.ContactGroup;
import query.model.Contact.ContactGroups;
import database.connection.DBLiteConnection;

/**
 * @author fyyang<br>
 *         100/10/04
 * 
 */
public class JContactGroupDialog extends JDialog {
	private static final long serialVersionUID = 1L;
	private final ContactGroups m_phoneGroups;
	private ContactGroup m_phoneGroup;
	// private final List<String> m_names;
	private JPanel m_contentPane;
	private JButton m_buttonOk;
	private JTextField textField;

	// private Connection conn;
	// {
	// try {
	// Class.forName("org.sqlite.JDBC");
	// conn = DriverManager.getConnection("jdbc:sqlite:test.db");
	// } catch (ClassNotFoundException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }

	public JContactGroupDialog(ContactGroups phoneGroups, final boolean isNew,
			int selected) {
		// m_names = names;
		m_phoneGroups = phoneGroups;
		//
		if (!isNew)
			m_phoneGroup = phoneGroups.getGroups().get(selected);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModal(true);
		setTitle("User Group");
		setBounds(100, 100, 432, 126);
		m_contentPane = new JPanel();
		m_contentPane.setBorder(new MatteBorder(5, 5, 5, 5, (Color) null));
		setContentPane(m_contentPane);
		//
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 1.0E-4 };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0E-4 };
		m_contentPane.setLayout(gridBagLayout);
		//
		{
			JLabel lblName = new JLabel("Name:");
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.anchor = GridBagConstraints.EAST;
			gbc.insets = new Insets(5, 5, 5, 5);
			gbc.gridx = 0;
			gbc.gridy = 0;
			m_contentPane.add(lblName, gbc);
		}
		{
			m_buttonOk = new JButton("OK");
			m_buttonOk.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					PreparedStatement groupprep;
					try {
						if (!isNew) {
							groupprep = DBLiteConnection
									.createPreparedStatement("update usergroup set name = ? where groupid = ?;");
							groupprep.setString(1, textField.getText());
							groupprep.setString(2, m_phoneGroup.getId());

							int i = DBLiteConnection.executeUpdate(groupprep);

							if (i == 0)
								return;
							m_phoneGroup.setName(textField.getText());
						}

						else {

							groupprep = DBLiteConnection
									.createPreparedStatement("insert into usergroup (name) values (?);");
							groupprep.setString(1, textField.getText());
							DBLiteConnection.getConn().setAutoCommit(true);
							int i = DBLiteConnection.executeUpdate(groupprep);

							if (i == 0)
								return;
							ResultSet rs = DBLiteConnection.createStatement()
									.executeQuery(
											"select * from usergroup where name ='"
													+ textField.getText()
													+ "';");
							while (rs.next()) {
								ContactGroup group = new ContactGroup(rs
										.getString("groupid"), rs
										.getString("name"));
								m_phoneGroups.addGroup(group);
							}

						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, "GROUP-"
								+ textField.getText() + "¤w¦s¦b", "ERROR",
								JOptionPane.WARNING_MESSAGE);
						e1.printStackTrace();
					}

					setVisible(false);
				}
			});
			{
				textField = new JTextField();
				GridBagConstraints gbc_textField = new GridBagConstraints();
				gbc_textField.insets = new Insets(0, 0, 5, 0);
				gbc_textField.fill = GridBagConstraints.HORIZONTAL;
				gbc_textField.gridx = 1;
				gbc_textField.gridy = 0;
				m_contentPane.add(textField, gbc_textField);
				textField.setColumns(10);
			}
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.anchor = GridBagConstraints.EAST;
			gbc.gridx = 1;
			gbc.gridy = 2;
			m_contentPane.add(m_buttonOk, gbc);
		}
		initDataBindings();
	}

	protected void initDataBindings() {
		BeanProperty<ContactGroup, String> phoneGroupBeanProperty = BeanProperty
				.create("name");
		BeanProperty<JTextField, String> jTextFieldBeanProperty = BeanProperty
				.create("text");
		AutoBinding<ContactGroup, String, JTextField, String> autoBinding = Bindings
				.createAutoBinding(UpdateStrategy.READ, m_phoneGroup,
						phoneGroupBeanProperty, textField,
						jTextFieldBeanProperty);
		autoBinding.bind();
	}
}