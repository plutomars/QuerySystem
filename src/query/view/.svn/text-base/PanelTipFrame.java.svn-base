package query.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import query.controller.DataControl;

/**
 * 參考ToolTipFrame 實作顯示Panel的TipFrame
 * 
 * @author epf
 * 
 */
public class PanelTipFrame {
	private static JFrame frame;
	private static int frameHeight = 0;
	private static int lineBorder = 10;
	private static JPanel contentPane;
	private static boolean moved = false;
	private static Point pre;
	private static JPanel panel;
	private static DataControl control;

	/**
	 * Create the frame.
	 */
	public static void createFrame() {
		frame = new JFrame();
		frame.setUndecorated(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);

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
		//hide();
	}

	/**
	 * 隱藏PanelTipFrame
	 * @author epf
	 */
	public static void hide() {
		if (control != null) {
			control.executeClearMission();
			control = null;
		}
		contentPane.removeAll();
		frame.setVisible(false);
		contentPane.removeAll();
	}

	/**
	 * 顯示PanelTipFrame
	 * @author epf
	 */
	public static void show() {
		frame.setVisible(true);
		frame.setAlwaysOnTop(true);
		frame.toFront();
	}

	/**
	 * 顯示功能Panel
	 * @param dataControl 整合查詢功能Panel對應的controller
	 */
	public static void setPanel(DataControl dataControl) {		
		if (frame == null) {
			createFrame();
		}		
		control = dataControl;
		panel = control.getPanel();
		JScrollPane scrollPane = new JScrollPane();		
		contentPane.add(scrollPane, BorderLayout.CENTER);
		panel.setPreferredSize(new Dimension(700, 700));
		scrollPane.setViewportView(panel);
		frameHeight = 700;
		frame.validate();
		show();
	}

	/**
	 * 設定PanelTipFrame大小及顯示位置
	 * @param width 顯示寬度
	 * @param c PanelTipFrame 依附的Component
	 */
	public static void setSizeAndLocation(int width, Component c) {
		frame.setSize(width, frameHeight);

		// 第一次開啟,位置依附在Component上
		if (!moved)
			frame.setLocationRelativeTo(c);
	}
}
