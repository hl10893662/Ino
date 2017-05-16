package me.inox.framework.model.chanel;

import java.net.InetSocketAddress;
import java.net.SocketAddress;

import me.inox.framework.model.component.SessionState;


public class UdpChannel implements IChannel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6019522774276704105L;
	public String Id;
	private String ip;
	private int port;
	public SessionState sessionState;
	private SocketAddress socketAddress;
	private int hashCodeValue = -1;
	public void setId(String id) {
		Id = id;
	}

	@Override
	public String getId() {
		return Id;
	}
	@Override
	public int hashCode() {
		if (hashCodeValue == -1) {
			int ipCodeHash = 0;
			int portHash = 0;
			if (ip != null) {
				ipCodeHash = ip.hashCode();
			}
			portHash = port;
			hashCodeValue = ipCodeHash * 100000 + portHash;
		}
		return hashCodeValue;
	}
	@Override
	public SessionState getSessionState() {
		return sessionState;
	}

	public void setSessionState(SessionState sessionState) {
		this.sessionState = sessionState;
	}

	@Override
	public String getUri() {
		return this.ip + ":" + this.port+"|u";
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj.getClass() != TcpChannel.class) {
			return false;
		}
		TcpChannel f = (TcpChannel) obj;

		if ((Id.equals(f.Id)) && (ip.equals(f.Ip)) && (port == f.port)
				&& (sessionState == f.sessionState)) {
			return true;
		}
		return false;

	}
	public void setSocketAddress(SocketAddress sa){
		this.ip = ((InetSocketAddress)sa).getAddress().getHostAddress();
		this.port = ((InetSocketAddress)sa).getPort();
		this.socketAddress=sa;
	}
	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public SocketAddress getSocketAddress() {
		if(socketAddress!=null)
		 return socketAddress;
		SocketAddress addr =new InetSocketAddress(getIp(), getPort());
		return addr;
	}

	public String toString() {
		return this.ip + ":" + this.port + "  id=" + this.Id
				+ "  sessionState=" + this.sessionState;

	}
}
