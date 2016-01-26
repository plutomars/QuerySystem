package query.model.ClientInfo;

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;
import query.model.ClientInfo.ClientInfo02;

public class ClientInfo02Group extends AbstractModelObject {

		private List<ClientInfo02> clientInfo02s = new ArrayList<ClientInfo02>();

		public ClientInfo02Group() {
		}

		public List<ClientInfo02> getClientInfo02s() {
			return clientInfo02s;
		}

		public void addClientInfo02(ClientInfo02 clientInfo02) {
			List<ClientInfo02> oldValue = clientInfo02s;
			clientInfo02s = new ArrayList<ClientInfo02>(clientInfo02s);
			clientInfo02s.add(clientInfo02);

			firePropertyChange("clientInfo02s", oldValue, clientInfo02s);
		}

		public void removeClientInfo02(ClientInfo02 clientInfo02) {
			clientInfo02s.remove(clientInfo02);
		}

		public void removeAll() {
			List<ClientInfo02> oldValue = clientInfo02s;
			clientInfo02s = new ArrayList<ClientInfo02>(clientInfo02s);
			clientInfo02s.clear();
			firePropertyChange("clientInfo02s", oldValue, clientInfo02s);
		}

}
