package query.model.Contact;

import query.model.AbstractModelObject;

/**
 * @author fyyang<br>
 *         100/10/04
 * 
 */
public class Contact extends AbstractModelObject {
	private String edit;
	private String id;
	private String name;
	private String ip;

	public Contact(String id, String name, String ip) {
		this.edit = "";
		this.id = id;
		this.name = name;
		this.ip = ip;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		String oldValue = this.name;
		this.name = name;
		firePropertyChange("name", oldValue, this.name);
		setEdit("¡¯");
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		String oldValue = this.ip;
		this.ip = ip;
		firePropertyChange("ip", oldValue, this.ip);
		setEdit("¡¯");
	}

	public String getEdit() {
		return edit;
	}

	public void setEdit(String edit) {

		String oldValue = this.edit;
		this.edit = edit;
		firePropertyChange("edit", oldValue, this.edit);
	}

}