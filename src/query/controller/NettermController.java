package query.controller;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;

import database.connection.DBConnection;

import program.setting.User32;
import program.setting.W32API;
import query.model.SelectionTreeModel;

public class NettermController {
	private String windowname = DBConnection.getServerName();// "測試環境";
	private Robot robot;

	public NettermController() {

		try {
			robot = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean showNetterm() {
		// W32API.HWND hwnd = User32.INSTANCE.FindWindow("SunAwtFrame",
		// "主機交易查詢2系統");
		W32API.HWND hwnd = User32.INSTANCE.FindWindow("NetTermClass",
				windowname);
		if (hwnd != null) {
			User32.INSTANCE.ShowWindow(hwnd, 9);
			User32.INSTANCE.SetForegroundWindow(hwnd);
			return true;
		}
		return false;
	}

	public void executeMission(String policy_no, String client_id,
			String insured_id, String nodename) {
		if (policy_no.equals("") || policy_no == null) {
			policy_no = "            ";
		}
		if (client_id.equals("") || client_id == null) {
			client_id = "          ";
		}

		if (showNetterm()) {
			sendEscapeKey();
			int keyInput[] = mappingKey(policy_no.toCharArray(),
					client_id.toCharArray(), insured_id.toCharArray(),
					SelectionTreeModel.getActionNodeValue(nodename));
			if (keyInput == null)
				return;
			for (int i = 0; i < keyInput.length; i++) {
				if (keyInput[i] > 199)
					robot.delay(keyInput[i]);
				else {
					sendKey(keyInput[i]);
				}
			}
		} else
			JOptionPane.showMessageDialog(null, "尚未打開NETTERM或NETTERM視窗名字不符\""
					+ windowname + "\"", "連結NETTERM失敗",
					JOptionPane.ERROR_MESSAGE);
	}

	private int[] mappingKey(char[] policy_no, char[] client_id,
			char[] insured_id, int type) {
		// int keyInput[];
		switch (type) {
		case SelectionTreeModel.S_NETTERM_11:
			return new int[] { KeyEvent.VK_4, KeyEvent.VK_4, KeyEvent.VK_1,
					KeyEvent.VK_ENTER, 1000, KeyEvent.VK_1, 200, policy_no[0],
					policy_no[1], policy_no[2], policy_no[3], policy_no[4],
					policy_no[5], policy_no[6], policy_no[7], policy_no[8],
					policy_no[9], policy_no[10], policy_no[11] };

		case SelectionTreeModel.S_NETTERM_12:
			return new int[] { KeyEvent.VK_I, KeyEvent.VK_3, KeyEvent.VK_1,
					KeyEvent.VK_ENTER, 1000, KeyEvent.VK_1, 200, policy_no[0],
					policy_no[1], policy_no[2], policy_no[3], policy_no[4],
					policy_no[5], policy_no[6], policy_no[7], policy_no[8],
					policy_no[9], policy_no[10], policy_no[11] };

			// case SelectionTreeModel.S_NETTERM_13:
			// return new int[] { KeyEvent.VK_4, KeyEvent.VK_7, KeyEvent.VK_1,
			// KeyEvent.VK_ENTER, 1000, KeyEvent.VK_1, 200, policy_no[0],
			// policy_no[1], policy_no[2], policy_no[3], policy_no[4],
			// policy_no[5], policy_no[6], policy_no[7], policy_no[8],
			// policy_no[9], policy_no[10], policy_no[11] };
			//
			// case SelectionTreeModel.S_NETTERM_14:
			// return new int[] { KeyEvent.VK_I, KeyEvent.VK_3, KeyEvent.VK_7,
			// KeyEvent.VK_ENTER, 1000, KeyEvent.VK_1, 200, policy_no[0],
			// policy_no[1], policy_no[2], policy_no[3], policy_no[4],
			// policy_no[5], policy_no[6], policy_no[7], policy_no[8],
			// policy_no[9], policy_no[10], policy_no[11] };

		case SelectionTreeModel.S_NETTERM_15:
			return new int[] { KeyEvent.VK_4, KeyEvent.VK_6, KeyEvent.VK_ENTER,
					1000, KeyEvent.VK_1, 200, policy_no[0], policy_no[1],
					policy_no[2], policy_no[3], policy_no[4], policy_no[5],
					policy_no[6], policy_no[7], policy_no[8], policy_no[9],
					policy_no[10], policy_no[11] };

		case SelectionTreeModel.S_NETTERM_16:
			return new int[] { KeyEvent.VK_4, KeyEvent.VK_I, KeyEvent.VK_4,
					KeyEvent.VK_ENTER, 600, KeyEvent.VK_6, 200, policy_no[0],
					policy_no[1], policy_no[2], policy_no[3], policy_no[4],
					policy_no[5], policy_no[6], policy_no[7], policy_no[8],
					policy_no[9], policy_no[10], policy_no[11] };

		case SelectionTreeModel.S_NETTERM_17:
			return new int[] { KeyEvent.VK_I, KeyEvent.VK_3, KeyEvent.VK_3,
					KeyEvent.VK_ENTER, 1000, KeyEvent.VK_1, 500, policy_no[0],
					policy_no[1], policy_no[2], policy_no[3], policy_no[4],
					policy_no[5], policy_no[6], policy_no[7], policy_no[8],
					policy_no[9], policy_no[10], policy_no[11] };

		case SelectionTreeModel.S_NETTERM_18:
			return new int[] { KeyEvent.VK_4, KeyEvent.VK_A, KeyEvent.VK_1,
					KeyEvent.VK_ENTER, 1000, KeyEvent.VK_1, 200, policy_no[0],
					policy_no[1], policy_no[2], policy_no[3], policy_no[4],
					policy_no[5], policy_no[6], policy_no[7], policy_no[8],
					policy_no[9], policy_no[10], policy_no[11] };

		case SelectionTreeModel.S_NETTERM_19:
			return new int[] { KeyEvent.VK_I, KeyEvent.VK_3, KeyEvent.VK_6,
					KeyEvent.VK_ENTER, 1000, KeyEvent.VK_1, 200, policy_no[0],
					policy_no[1], policy_no[2], policy_no[3], policy_no[4],
					policy_no[5], policy_no[6], policy_no[7], policy_no[8],
					policy_no[9], policy_no[10], policy_no[11] };

		case SelectionTreeModel.S_NETTERM_21:
			return new int[] { KeyEvent.VK_C, KeyEvent.VK_4, KeyEvent.VK_ENTER,
					600, KeyEvent.VK_1, 500, policy_no[0], policy_no[1],
					policy_no[2], policy_no[3], policy_no[4], policy_no[5],
					policy_no[6], policy_no[7], policy_no[8], policy_no[9],
					policy_no[10], policy_no[11], 1000, KeyEvent.VK_ESCAPE };

		case SelectionTreeModel.S_NETTERM_31:
			return new int[] { KeyEvent.VK_5, KeyEvent.VK_2, KeyEvent.VK_6,
					KeyEvent.VK_ENTER };

		case SelectionTreeModel.S_NETTERM_32:
			return new int[] { KeyEvent.VK_5, KeyEvent.VK_2, KeyEvent.VK_3,
					KeyEvent.VK_ENTER };

		case SelectionTreeModel.S_NETTERM_41:
			return new int[] { KeyEvent.VK_6, KeyEvent.VK_3, KeyEvent.VK_4,
					KeyEvent.VK_ENTER, 1000, KeyEvent.VK_4, 200, policy_no[0],
					policy_no[1], policy_no[2], policy_no[3], policy_no[4],
					policy_no[5], policy_no[6], policy_no[7], policy_no[8],
					policy_no[9], policy_no[10], policy_no[11] };

		case SelectionTreeModel.S_NETTERM_42:
			return new int[] { KeyEvent.VK_6, KeyEvent.VK_6, KeyEvent.VK_1,
					KeyEvent.VK_ENTER, 1000, KeyEvent.VK_1, 500, policy_no[0],
					policy_no[1], policy_no[2], policy_no[3], policy_no[4],
					policy_no[5], policy_no[6], policy_no[7], policy_no[8],
					policy_no[9], policy_no[10], policy_no[11] };

		case SelectionTreeModel.S_NETTERM_43:
			return new int[] { KeyEvent.VK_C, KeyEvent.VK_A, KeyEvent.VK_ENTER,
					1500, KeyEvent.VK_9, 500, KeyEvent.VK_1, 500, policy_no[0],
					policy_no[1], policy_no[2], policy_no[3], policy_no[4],
					policy_no[5], policy_no[6], policy_no[7], policy_no[8],
					policy_no[9], policy_no[10], policy_no[11] };

		case SelectionTreeModel.S_NETTERM_44:
			return new int[] { KeyEvent.VK_6, KeyEvent.VK_3, KeyEvent.VK_1,
					KeyEvent.VK_ENTER, 1500, KeyEvent.VK_3, KeyEvent.VK_1, 500,
					policy_no[0], policy_no[1], policy_no[2], policy_no[3],
					policy_no[4], policy_no[5], policy_no[6], policy_no[7],
					policy_no[8], policy_no[9], policy_no[10], policy_no[11] };

		case SelectionTreeModel.S_NETTERM_51:
			return new int[] { KeyEvent.VK_4, KeyEvent.VK_3, KeyEvent.VK_2,
					KeyEvent.VK_ENTER, 1000, KeyEvent.VK_1, 200, policy_no[0],
					policy_no[1], policy_no[2], policy_no[3], policy_no[4],
					policy_no[5], policy_no[6], policy_no[7], policy_no[8],
					policy_no[9], policy_no[10], policy_no[11], KeyEvent.VK_5 };

		case SelectionTreeModel.S_NETTERM_52:
			return new int[] { KeyEvent.VK_4, KeyEvent.VK_3, KeyEvent.VK_2,
					KeyEvent.VK_ENTER, 1000, KeyEvent.VK_1, 200, policy_no[0],
					policy_no[1], policy_no[2], policy_no[3], policy_no[4],
					policy_no[5], policy_no[6], policy_no[7], policy_no[8],
					policy_no[9], policy_no[10], policy_no[11], KeyEvent.VK_9 };

		case SelectionTreeModel.S_NETTERM_53:
			return new int[] { KeyEvent.VK_4, KeyEvent.VK_3, KeyEvent.VK_8,
					KeyEvent.VK_ENTER, 600, KeyEvent.VK_1, 200, policy_no[0],
					policy_no[1], policy_no[2], policy_no[3], policy_no[4],
					policy_no[5], policy_no[6], policy_no[7], policy_no[8],
					policy_no[9], policy_no[10], policy_no[11] };

		case SelectionTreeModel.S_NETTERM_61:
			return new int[] { KeyEvent.VK_4, KeyEvent.VK_E, KeyEvent.VK_ENTER,
					1000, KeyEvent.VK_2 };

		case SelectionTreeModel.S_NETTERM_62:
			return new int[] { KeyEvent.VK_4, KeyEvent.VK_B, KeyEvent.VK_ENTER,
					1000, KeyEvent.VK_1, 200, insured_id[0], insured_id[1],
					insured_id[2], insured_id[3], insured_id[4], insured_id[5],
					insured_id[6], insured_id[7], insured_id[8], insured_id[9] };

		case SelectionTreeModel.S_NETTERM_63:
			return new int[] { KeyEvent.VK_4, KeyEvent.VK_2, KeyEvent.VK_5,
					KeyEvent.VK_ENTER, 1000, KeyEvent.VK_1, 200, client_id[0],
					client_id[1], client_id[2], client_id[3], client_id[4],
					client_id[5], client_id[6], client_id[7], client_id[8],
					client_id[9] };

		case SelectionTreeModel.S_NETTERM_64:
			return new int[] { KeyEvent.VK_4, KeyEvent.VK_2, KeyEvent.VK_5,
					KeyEvent.VK_ENTER, 1000, KeyEvent.VK_2, 200, client_id[0],
					client_id[1], client_id[2], client_id[3], client_id[4],
					client_id[5], client_id[6], client_id[7], client_id[8],
					client_id[9] };

		case SelectionTreeModel.S_NETTERM_65:
			return new int[] { KeyEvent.VK_4, KeyEvent.VK_3, KeyEvent.VK_ENTER,
					1000, KeyEvent.VK_1, KeyEvent.VK_ENTER, 1000,
					KeyEvent.VK_1, 500, policy_no[0], policy_no[1],
					policy_no[2], policy_no[3], policy_no[4], policy_no[5],
					policy_no[6], policy_no[7], policy_no[8], policy_no[9],
					policy_no[10], policy_no[11], 500, KeyEvent.VK_1, 500,
					KeyEvent.VK_F8 };

		case SelectionTreeModel.S_NETTERM_71:
			return new int[] { KeyEvent.VK_H, KeyEvent.VK_7, KeyEvent.VK_ENTER,
					1000, KeyEvent.VK_9 };

		case SelectionTreeModel.S_NETTERM_72:
			return new int[] { KeyEvent.VK_4, KeyEvent.VK_5, KeyEvent.VK_6,
					KeyEvent.VK_ENTER };

		case SelectionTreeModel.S_NETTERM_73:
			return new int[] { KeyEvent.VK_1, KeyEvent.VK_1, KeyEvent.VK_ENTER,
					1000, KeyEvent.VK_4 };

		case SelectionTreeModel.S_NETTERM_81:
			return new int[] { KeyEvent.VK_9, KeyEvent.VK_2, KeyEvent.VK_5,
					KeyEvent.VK_ENTER };

		case SelectionTreeModel.S_NETTERM_82:
			return new int[] { KeyEvent.VK_H, KeyEvent.VK_1, KeyEvent.VK_2,
					KeyEvent.VK_ENTER };

		case SelectionTreeModel.S_NETTERM_91:
			return new int[] { KeyEvent.VK_4, KeyEvent.VK_7, KeyEvent.VK_2,
					KeyEvent.VK_1, KeyEvent.VK_ENTER, 1000, KeyEvent.VK_1, 200,
					policy_no[0], policy_no[1], policy_no[2], policy_no[3],
					policy_no[4], policy_no[5], policy_no[6], policy_no[7],
					policy_no[8], policy_no[9], policy_no[10], policy_no[11] };

		case SelectionTreeModel.S_NETTERM_92:
			return new int[] { KeyEvent.VK_I, KeyEvent.VK_3, KeyEvent.VK_B,
					KeyEvent.VK_ENTER, 1000, KeyEvent.VK_1, 200, policy_no[0],
					policy_no[1], policy_no[2], policy_no[3], policy_no[4],
					policy_no[5], policy_no[6], policy_no[7], policy_no[8],
					policy_no[9], policy_no[10], policy_no[11] };

		case SelectionTreeModel.S_NETTERM_93:
			return new int[] { KeyEvent.VK_4, KeyEvent.VK_4, KeyEvent.VK_4,
					KeyEvent.VK_ENTER, 1000, KeyEvent.VK_1, 200, policy_no[0],
					policy_no[1], policy_no[2], policy_no[3], policy_no[4],
					policy_no[5], policy_no[6], policy_no[7], policy_no[8],
					policy_no[9], policy_no[10], policy_no[11] };

		case SelectionTreeModel.S_NETTERM_94:
			return new int[] { KeyEvent.VK_4, KeyEvent.VK_7, KeyEvent.VK_1,
					KeyEvent.VK_ENTER, 1000, KeyEvent.VK_1, 200, policy_no[0],
					policy_no[1], policy_no[2], policy_no[3], policy_no[4],
					policy_no[5], policy_no[6], policy_no[7], policy_no[8],
					policy_no[9], policy_no[10], policy_no[11] };

		case SelectionTreeModel.S_NETTERM_95:
			return new int[] { KeyEvent.VK_I, KeyEvent.VK_3, KeyEvent.VK_7,
					KeyEvent.VK_ENTER, KeyEvent.VK_1, 200, policy_no[0],
					policy_no[1], policy_no[2], policy_no[3], policy_no[4],
					policy_no[5], policy_no[6], policy_no[7], policy_no[8],
					policy_no[9], policy_no[10], policy_no[11] };

		case SelectionTreeModel.S_NETTERM_101:
			return new int[] { KeyEvent.VK_B, KeyEvent.VK_1, KeyEvent.VK_ENTER,
					600, KeyEvent.VK_4 };

		case SelectionTreeModel.S_NETTERM_102:
			return new int[] { KeyEvent.VK_A, KeyEvent.VK_8, KeyEvent.VK_ENTER,
					KeyEvent.VK_4, 1000, client_id[0], client_id[1],
					client_id[2], client_id[3], client_id[4], client_id[5],
					client_id[6], client_id[7], client_id[8], client_id[9] };

		case SelectionTreeModel.S_NETTERM_103:
			return new int[] { KeyEvent.VK_4, KeyEvent.VK_A, KeyEvent.VK_2,
					KeyEvent.VK_ENTER, 1000, KeyEvent.VK_4, 200, policy_no[0],
					policy_no[1], policy_no[2], policy_no[3], policy_no[4],
					policy_no[5], policy_no[6], policy_no[7], policy_no[8],
					policy_no[9], policy_no[10], policy_no[11] };
		case SelectionTreeModel.S_NETTERM_104:
			return new int[] {};

		case SelectionTreeModel.S_NETTERM_111:
			return new int[] { KeyEvent.VK_4, KeyEvent.VK_I, KeyEvent.VK_3,
					KeyEvent.VK_ENTER, 600, KeyEvent.VK_6, 200, policy_no[0],
					policy_no[1], policy_no[2], policy_no[3], policy_no[4],
					policy_no[5], policy_no[6], policy_no[7], policy_no[8],
					policy_no[9], policy_no[10], policy_no[11] };

		case SelectionTreeModel.S_NETTERM_112:
			return new int[] { KeyEvent.VK_4, KeyEvent.VK_I, KeyEvent.VK_9,
					KeyEvent.VK_ENTER, 600, KeyEvent.VK_1, 200, policy_no[0],
					policy_no[1], policy_no[2], policy_no[3], policy_no[4],
					policy_no[5], policy_no[6], policy_no[7], policy_no[8],
					policy_no[9], policy_no[10], policy_no[11] };

		case SelectionTreeModel.S_NETTERM_113:
			return new int[] { KeyEvent.VK_I, KeyEvent.VK_3, KeyEvent.VK_2,
					KeyEvent.VK_ENTER, 600, KeyEvent.VK_1, 200, policy_no[0],
					policy_no[1], policy_no[2], policy_no[3], policy_no[4],
					policy_no[5], policy_no[6], policy_no[7], policy_no[8],
					policy_no[9], policy_no[10], policy_no[11] };
		case SelectionTreeModel.S_NETTERM_121:
			return new int[] { KeyEvent.VK_2, KeyEvent.VK_D, KeyEvent.VK_1,
					KeyEvent.VK_ENTER, 600, KeyEvent.VK_1, 200, insured_id[0],
					insured_id[1], insured_id[2], insured_id[3], insured_id[4],
					insured_id[5], insured_id[6], insured_id[7], insured_id[8],
					insured_id[9] };
		}
		return null;
	}

	private void sendKey(int key) {
		robot.keyPress(key);
		robot.keyRelease(key);
	}

	private void sendEscapeKey() {
		robot.keyPress(KeyEvent.VK_CONTROL);
		sendKey(KeyEvent.VK_C);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.delay(100);
		robot.keyPress(KeyEvent.VK_CONTROL);
		sendKey(KeyEvent.VK_C);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.delay(100);
		sendKey(KeyEvent.VK_0);
		sendKey(KeyEvent.VK_ENTER);
		robot.delay(200);
		sendKey(KeyEvent.VK_0);
		sendKey(KeyEvent.VK_ENTER);
		robot.delay(200);
		sendKey(KeyEvent.VK_0);
		sendKey(KeyEvent.VK_ENTER);
		robot.delay(200);
		sendKey(KeyEvent.VK_0);
		sendKey(KeyEvent.VK_ENTER);
		robot.delay(200);
		sendKey(KeyEvent.VK_0);
		sendKey(KeyEvent.VK_ENTER);
		robot.delay(200);
	}
}
