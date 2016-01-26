/**
 * 
 */
package query.controller;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

import query.view.QueryFrame;
import query.view.QueryFrame.DoSearchHandler;

/**
 * @author F1256819
 * @category 開啟Socket連線以接收資料進行搜尋
 */
public class SearchServiceController implements Runnable {
	private static ServerSocket serverTcp;
	private DoSearchHandler searchHandler;

	public SearchServiceController() throws IOException {
		serverTcp = new ServerSocket(3333, 0,
				InetAddress.getByName("localhost"));
	}

	public SearchServiceController(int portNum) throws IOException {
		serverTcp = new ServerSocket(portNum, 0,
				InetAddress.getByName("localhost"));
	}

	public void setQueryFrameHandler(QueryFrame frame) {
		searchHandler = frame.getSearchHandler();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			try {
				Socket connSocket = serverTcp.accept();

				System.out.println("connect ip:"
						+ connSocket.getInetAddress().getHostAddress());
				InputStream in = connSocket.getInputStream();
				// 加上結尾字#共13碼
				byte[] temp_data = new byte[13];
				in.read(temp_data);
				String custData = new String(temp_data, "UTF-8");
				custData = custData.trim();
				System.out.println("receive data:" + custData);
				in.close();
				in = null;
				connSocket.close();
				connSocket = null;
				boolean isPolicyNoOrClientID = true;
				char check_char = ' ';
				if (custData.length() > 0)
					check_char = custData.charAt(custData.length() - 1);

				if (check_char != '#') {
					System.out.println("傳輸資料結尾不為#");
					searchHandler.doSearch("");
					continue;
				}
				// 固定切保單號碼或資料長度
				custData = custData.substring(0,
						(custData.length() < 12) ? custData.length() : 12);

				// 判斷若輸入的值非為A-Z(65-90) || 0-9(48-57) 則不處理
				char[] custChars = custData.toCharArray();
				for (int i = 0; i < custChars.length - 1; i++) {
					if (!(((int) custChars[i] >= 48 && (int) custChars[i] <= 57) || ((int) custChars[i] >= 65 && (int) custChars[i] <= 90))) {
						isPolicyNoOrClientID = false;
					}
				}

				if (!isPolicyNoOrClientID) {
					System.out.println("輸入資料非保單或ID");
					searchHandler.doSearch("");
					continue;
				}

				// 切出值
				String[] split_data = custData.split("#");
				if (split_data.length > 0)
					searchHandler.doSearch(split_data[0]);
				else
					searchHandler.doSearch("");

				Thread.sleep(200);
			} catch (NullPointerException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "已開啟主機查詢系統", "已開啟",
						JOptionPane.ERROR_MESSAGE);
				System.exit(0);

			} catch (Exception e) {
				e.printStackTrace();
				searchHandler.doSearch("");
			}

		}

	}
}
