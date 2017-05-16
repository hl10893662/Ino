package me.inox.framework.interactive.client;

import me.inox.framework.interactive.server.IServerComponent;

public interface ILocalClientComponent extends IClientComponent{
	public void setServerComponent(IServerComponent serverComponent);
}
