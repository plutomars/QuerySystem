package query.model;

import java.io.Serializable;

/**
 * 
 * @author fyyang
 * @version 1.0<br>
 *          100/09/30<br>
 *          訊息處理
 */
@SuppressWarnings("serial")
public class MessageObject implements Serializable {

	/**
	 * 
	 */

	public final static int M_INFORMATION = 0;
	public final static int M_SOURCE = 1;
	public final static int M_POSTIT = 2;
	public final static int M_CHATTING = 3;

	// 保戶訊息,資源分享,便利貼,聊天室
	private int type;
	private String title;
	private String context;
	private int x;
	private int y;
	private int width;
	private int height;
	private String filename;
	private String filepath;
	private Long filesize;
	private int fontsize;

	public MessageObject() {
		this.title = "";
		this.filename = "";
		this.x = 50;
		this.y = 50;
		this.width = 200;
		this.height = 400;
	}

	public MessageObject(int type, String title, String context, int x, int y,
			int width, int height, String filename, String filepath,
			long filesize, int fontsize) {
		this.type = type;
		this.title = title;
		this.context = context;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.filename = filename;
		this.filepath = filepath;
		this.filesize = filesize;
		this.fontsize = fontsize;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	public Long getFilesize() {
		return filesize;
	}

	public void setFilesize(Long filesize) {
		this.filesize = filesize;
	}

	public int getFontsize() {
		return fontsize;
	}

	public void setFontsize(int fontsize) {
		this.fontsize = fontsize;
	}

}
