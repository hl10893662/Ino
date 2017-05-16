package me.inox.framework.interactive.server;

import java.util.Calendar;
import java.util.EventObject;

import me.inox.framework.model.component.ComponentInfo;

public class ClientLogoutedEvent extends EventObject {
	private ComponentInfo client;

	private Calendar logoutedTime;

	public ClientLogoutedEvent(Object source, ComponentInfo nd) {
		super(source);
		this.client = nd;
		logoutedTime = Calendar.getInstance();
	}

	public ComponentInfo getClient() {
		return client;
	}

	public Calendar getLogoutedTime() {
		return logoutedTime;
	}
}
