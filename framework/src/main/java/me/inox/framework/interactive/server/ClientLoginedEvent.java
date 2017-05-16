package me.inox.framework.interactive.server;

import java.util.Calendar;
import java.util.EventObject;

import me.inox.framework.model.component.ComponentInfo;

public class ClientLoginedEvent extends EventObject {
	private ComponentInfo client;

	private Calendar loginedTime;

	public ClientLoginedEvent(Object source, ComponentInfo ci) {
		super(source);
		this.client = ci;
		loginedTime = Calendar.getInstance();
	}

	public Calendar getLoginedTime() {
		return loginedTime;
	}

	public ComponentInfo getClient() {
		return client;
	}

}
