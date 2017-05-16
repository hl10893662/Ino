package me.inox.framework.model.event;

import java.util.EventObject;

import me.inox.framework.model.component.ComponentInfo;


public class LoginedEvent extends EventObject {
	private ComponentInfo serverInfo;

	private long loginedTime;

	public long getLoginedTime() {
		return loginedTime;
	}

	public ComponentInfo getServerInfo() {
		return serverInfo;
	}

	public LoginedEvent(Object source, ComponentInfo si) {
		super(source);
		loginedTime = System.currentTimeMillis();
		this.serverInfo = si;
	}
}
