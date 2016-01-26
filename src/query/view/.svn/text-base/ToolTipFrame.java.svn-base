package query.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class ToolTipFrame {
	private static JFrame frame;
	private static int areaHeight = 2;
	private static int frameHeight = 0;
	private static int lineBorder = 10;
	private static JTextArea textArea;
	private static JPanel contentPane;
	private static JTable table;
	private static boolean moved = false;
	private static Point pre;

	/**
	 * Create the frame.
	 */
	public static void createFrame() {
		frame = new JFrame();
		frame.setUndecorated(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);

		textArea = new JTextArea(areaHeight, 1);
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setFocusable(false);

		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(Color.BLACK, lineBorder));
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {

				pre = null;

			}
		});
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				int x, y;

				if (pre == null) {
					pre = arg0.getLocationOnScreen();
					x = 0;
					y = 0;
				} else {
					x = arg0.getXOnScreen() - pre.x;
					y = arg0.getYOnScreen() - pre.y;
				}
				pre = arg0.getLocationOnScreen();

				frame.setLocation(frame.getLocation().x + x,
						frame.getLocation().y + y);

				moved = true;
			}
		});
		frame.setContentPane(contentPane);

		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);

		table = new JTable() {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int rowIdx, int colIdx) {
				return false;
			}
		};
		// table.addFocusListener(new FocusAdapter() {
		// @Override
		// public void focusLost(FocusEvent arg0) {
		// hide();
		// }
		// });
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent arg0) {
				show();
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				hide();
			}
		});
		scrollPane.setViewportView(table);

		setListSelectionListener();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// hide();
	}

	public static void hide() {
		frame.setVisible(false);
		((DefaultTableModel) table.getModel()).setRowCount(0);
		textArea.setText("");
	}

	public static void show() {
		frame.setVisible(true);
		frame.setAlwaysOnTop(true);
		frame.toFront();
	}

	public static void setTable(String[] title, String[][] context,
			boolean textShow, int[] rightAlig) {
		setTable(title, context, textShow);
		rightAlig(rightAlig);
	}

	public static void setTable(String[] title, String[][] context,
			boolean textShow) {
		if (frame == null) {
			createFrame();
		}
		DefaultTableModel jTable1Model = new DefaultTableModel(
				new String[title.length][0], title);
		table.setModel(jTable1Model);
		jTable1Model.setRowCount(0);
		jTable1Model.setRowCount(context.length);

		for (int j = 1; j <= context.length; j++)
			for (int i = 1; i <= jTable1Model.getColumnCount(); i++) {

				jTable1Model.setValueAt(context[j - 1][i - 1], j - 1, i - 1);
			}
		if (textShow) {
			textArea.setText("");
			contentPane.add(textArea, BorderLayout.SOUTH);
			frame.validate();
			frameHeight = (table.getRowHeight() + 2)
					* (table.getRowCount() + 2) + lineBorder * 2 + areaHeight
					* 20;
		} else {
			contentPane.remove(textArea);
			frameHeight = (table.getRowHeight() + 2)
					* (table.getRowCount() + 2) + lineBorder * 2;
		}

		show();
	}

	public static void setSizeAndLocation(int width, Component c) {
		frame.setSize(width, frameHeight);

		// 第一次開啟,位置依附在Component上
		if (!moved)
			frame.setLocationRelativeTo(c);
	}

	public static void setTable(String[] title, String[][] context,
			int[] columnsize, boolean textShow) {
		setTable(title, context, textShow);

		for (int i = 0; i < columnsize.length; i++) {
			table.getColumnModel().getColumn(i)
					.setPreferredWidth(columnsize[i]);
		}
	}

	public static void setTable(String[] title, String[][] context,
			int[] columnsize, int[] rightAlig, boolean textShow) {
		setTable(title, context, columnsize, textShow);
		rightAlig(rightAlig);
	}

	private static void rightAlig(int[] rightAlig) {
		if (rightAlig != null) {
			DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
			rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
			for (int i : rightAlig) {
				table.getColumnModel().getColumn(i)
						.setCellRenderer(rightRenderer);
			}
		}
	}

	public static void setListSelectionListener() {
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				int row = table.getSelectedRow();
				int column = table.getSelectedColumn();
				if (row != -1) {
					textArea.setText(table.getValueAt(row, column).toString());
				}

			}
		});
	}
}
