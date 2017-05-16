package me.inox.framework.model.event;

import java.util.EventObject;

import me.inox.framework.model.component.ComponentInfo;


public class LogoutedEvent extends EventObject {
	private ComponentInfo serverInfo;

	private long logoutedTime;

	public ComponentInfo getServerInfo() {
		return serverInfo;
	}

	public long getLogoutedTime() {
		return logoutedTime;
	}

	public LogoutedEvent(Object source, ComponentInfo si) {
		super(source);
		logoutedTime = System.currentTimeMillis();
		this.serverInfo = si;
	}
}
