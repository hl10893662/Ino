package me.inox.framework.model.chanel;

import me.inox.framework.model.component.SessionState;

public class TcpChannel implements IChannel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1852256848854806268L;
	public String Id;
	public String Ip;
	public int port;
	public SessionState sessionState;
	private int hashCodeValue = -1;

	@Override
	public int hashCode() {
		if (hashCodeValue == -1) {
			int ipCodeHash = 0;
			int portHash = 0;
			if (Ip != null) {
				ipCodeHash = Ip.hashCode();
			}
			portHash = port;
			hashCodeValue = ipCodeHash * 100000 + portHash;
		}
		return hashCodeValue;
	}

	public String getIp() {
		return Ip;
	}

	public void setIp(String ip) {
		Ip = ip;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public void setId(String id) {
		Id = id;
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return Id;
	}

	@Override
	public SessionState getSessionState() {
		// TODO Auto-generated method stub
		return sessionState;
	}

	public void setSessionState(SessionState sessionState) {
		this.sessionState = sessionState;
	}

	@Override
	public String getUri() {
		// TODO Auto-generated method stub
		return this.Ip + ":" + this.port;
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj.getClass() != TcpChannel.class) {
			return false;
		}
		TcpChannel f = (TcpChannel) obj;

		if ((Id.equals(f.Id)) && (Ip.equals(f.Ip)) && (port == f.port)
				&& (sessionState == f.sessionState)) {
			return true;
		}
		return false;

	}

	public String toString() {
		return this.Ip + ":" + this.port + "  id=" +Id+ "  sessionState=" + this.sessionState;

	}

}
