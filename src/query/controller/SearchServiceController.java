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
 * @category �}��Socket�s�u�H������ƶi��j�M
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
				// �[�W�����r#�@13�X
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
					System.out.println("�ǿ��Ƶ�������#");
					searchHandler.doSearch("");
					continue;
				}
				// �T�w���O�渹�X�θ�ƪ���
				custData = custData.substring(0,
						(custData.length() < 12) ? custData.length() : 12);

				// �P�_�Y��J���ȫD��A-Z(65-90) || 0-9(48-57) �h���B�z
				char[] custChars = custData.toCharArray();
				for (int i = 0; i < custChars.length - 1; i++) {
					if (!(((int) custChars[i] >= 48 && (int) custChars[i] <= 57) || ((int) custChars[i] >= 65 && (int) custChars[i] <= 90))) {
						isPolicyNoOrClientID = false;
					}
				}

				if (!isPolicyNoOrClientID) {
					System.out.println("��J��ƫD�O���ID");
					searchHandler.doSearch("");
					continue;
				}

				// ���X��
				String[] split_data = custData.split("#");
				if (split_data.length > 0)
					searchHandler.doSearch(split_data[0]);
				else
					searchHandler.doSearch("");

				Thread.sleep(200);
			} catch (NullPointerException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "�w�}�ҥD���d�ߨt��", "�w�}��",
						JOptionPane.ERROR_MESSAGE);
				System.exit(0);

			} catch (Exception e) {
				e.printStackTrace();
				searchHandler.doSearch("");
			}

		}

	}
}
