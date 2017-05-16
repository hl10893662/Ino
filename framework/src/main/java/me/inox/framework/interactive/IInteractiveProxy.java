package me.inox.framework.interactive;

import java.util.List;
import java.util.Map;

import me.inox.framework.interactive.client.IClientComponent;
import me.inox.framework.interactive.component.IComponent;
import me.inox.framework.interactive.server.IServerComponent;
import me.inox.framework.listener.IListener;
import me.inox.framework.model.component.ComponentInfo;
import me.inox.framework.model.component.RegisterException;
import me.inox.framework.model.node.INode;

public interface IInteractiveProxy {
	public IComponent getComponent(ComponentInfo info) throws RegisterException;
	
	public IServerComponent registerServerComponent(INode node,
			ComponentInfo info, MessageConvertor convertor,
			Map<String, List<IListener<MessageEvent>>> listeners)
			throws RegisterException;
			
	public void init();
	public Map<String, IClientComponent> getClientComponents();
	public Map<String, IServerComponent> getServerComponents();
	
}
