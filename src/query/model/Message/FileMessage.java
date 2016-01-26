package query.model.Message;

/**
 * 
 * @author fyyang
 * @version 1.0
 *
 */
public class FileMessage {
	private String filename;
	private String filepath;
	private Long filesize;

	public FileMessage(String filename, String filepath, Long filesize) {
		this.filename = filename;
		this.filepath = filepath;
		this.filesize = filesize;
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

}
