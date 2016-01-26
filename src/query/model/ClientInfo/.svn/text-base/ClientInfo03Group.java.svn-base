package query.model.ClientInfo;

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;

public class ClientInfo03Group extends AbstractModelObject {
	private List<ClientInfo03> clientInfo03s = new ArrayList<ClientInfo03>();

	public ClientInfo03Group() {
	}

	public List<ClientInfo03> getClientInfo03s() {
		return clientInfo03s;
	}

	public void addClientInfo03(ClientInfo03 clientInfo03) {
		List<ClientInfo03> oldValue = clientInfo03s;
		clientInfo03s = new ArrayList<ClientInfo03>(clientInfo03s);
		clientInfo03s.add(clientInfo03);

		firePropertyChange("clientInfo03s", oldValue, clientInfo03s);
	}

	public void removeClientInfo03(ClientInfo03 clientInfo03) {
		clientInfo03s.remove(clientInfo03);
	}

	public void removeAll() {
		List<ClientInfo03> oldValue = clientInfo03s;
		clientInfo03s = new ArrayList<ClientInfo03>(clientInfo03s);
		clientInfo03s.clear();
		firePropertyChange("clientInfo03s", oldValue, clientInfo03s);
	}

}
