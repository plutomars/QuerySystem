package query.controller;

import java.awt.EventQueue;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

import query.model.MessageObject;
import query.view.MessageFrame;
import query.view.NoteFrame;

public class MessageController implements Runnable {
	private MessageFrame messageFrame;
	private ServerSocket serverTcp;;

	public MessageController() throws IOException {
		// 用某一個 Port 接收資料
		serverTcp = new ServerSocket(3333);
	}

	public void show() {
		messageFrame.setVisible(true);
	}

	@Override
	// ===========================================================
	public void run() { // 以 TCP 接收檔案資料
		// byte[] theData = new byte[1]; // = new byte[100];

		messageFrame = new MessageFrame();
		messageFrame.setAlwaysOnTop(true);
		while (true) {
			try {

				Socket connSocket = serverTcp.accept();
				InetAddress ip = connSocket.getInetAddress();
				ObjectInputStream in = new ObjectInputStream(
						connSocket.getInputStream());

				final MessageObject data = (MessageObject) in.readObject();
				// System.out.println("我取得的值:" + data.getType() +
				// data.getTitle()
				// + data.getContext() + ip.getHostAddress());
				in.close();
				in = null;
				connSocket.close();

				// 公佈欄
				if (data.getType() == 1)
					messageFrame.addMessage(data, ip.getHostAddress());

				// 便利貼
				else if (data.getType() == 2) {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								NoteFrame frame = new NoteFrame(data);
								frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}
				// BufferedInputStream serverInput
				// = new BufferedInputStream(connSocket.getInputStream(),8192);
				// //用 Buffer，處理較快
				// //=========================================================
				// File theTar = new File( textField5.getText().trim());
				// File tarParent = theTar.getParentFile();
				// if( (tarParent!=null) &&!tarParent.exists())
				// tarParent.mkdirs();
				// //若檔案路徑中有部分目錄不存在，就替它建目錄，參考 File I/O
				// //=========================================================
				// BufferedOutputStream FileObj
				// =new BufferedOutputStream(new FileOutputStream(theTar),8192);
				//
				// while( serverInput.read(theData) != -1)
				// {
				// FileObj.write(theData);
				// }
				// FileObj.flush();
				// FileObj.close();
				// serverInput.close();
				// connSocket.close();
				// //serverTcp.close();
				// /* 若關閉，則第二次接收檔案會引發例外。
				// 因為本例的 ServerSocket 要一直使用，因此不要關閉它。*/
				// JOptionPane.showMessageDialog(null,"接收了一個檔案！");
				Thread.sleep(200);
			} catch (NullPointerException e) {
				JOptionPane.showMessageDialog(null, "已開啟主機查詢系統", "已開啟",
						JOptionPane.ERROR_MESSAGE);
				System.exit(0);

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException ecp) {
				System.out.println("Ecp1");
			} catch (FileNotFoundException ecp) {
				System.out.println("Ecp2");
			} catch (IOException ecp) {
				System.out.println("Ecp3");
			}
		}

	} // void run() end

}
