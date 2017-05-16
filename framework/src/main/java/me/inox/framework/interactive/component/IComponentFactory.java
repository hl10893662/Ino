package me.inox.framework.interactive.component;

import me.inox.framework.interactive.client.IClientComponent;
import me.inox.framework.interactive.server.IServerComponent;

public interface IComponentFactory {
	public IClientComponent createClientComponent(int CommunicateType);
	public IServerComponent createServerComponent(int CommunicateType);
}
