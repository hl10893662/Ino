package me.inox.framework.interactive.server;

import java.util.EventObject;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

import me.inox.framework.common.AbstractException;
import me.inox.framework.interactive.MessageEvent;
import me.inox.framework.interactive.component.IComponent;
import me.inox.framework.listener.IListener;
import me.inox.framework.model.component.ComponentInfo;

public interface IServerComponent extends IComponent {
	void open() throws AbstractException;

	void close() throws AbstractException;

	void disconnectClientByAddr(String addr);

	boolean clientIsReachable(String clientAddr);

	void syncSend(ComponentInfo ci, Object data) throws AbstractException;

	void asyncSend(ComponentInfo ci, Object data) throws AbstractException;

	void syncSend(ComponentInfo ci, Object data, String nodeId)
			throws AbstractException;

	void asyncSend(ComponentInfo ci, Object data, String nodeId)
			throws AbstractException;

	Map<String, ComponentInfo> getClientComponents();

	void clientLogined(ClientLoginedEvent event);

	void clientLogouted(ClientLogoutedEvent event);

	void addOpenListener(IListener<EventObject> listener);

	void removeOpenListener(IListener<EventObject> listener);

	public List<IListener<EventObject>> getOpenListener();

	void addCloseListener(IListener<EventObject> listener);

	void removeCloseListener(IListener<EventObject> listener);

	void addClientDisconnected(IListener<EventObject> listener);

	void removeClientDisconnected(IListener<EventObject> listener);

	public List<IListener<EventObject>> getClientDisconnectedListeners();
	
	ConcurrentLinkedQueue<Object>  getCache();
	public ConcurrentHashMap<String, Map<String, List<IListener<MessageEvent>>>> getListeners();
}
