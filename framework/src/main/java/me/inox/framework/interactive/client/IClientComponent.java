package me.inox.framework.interactive.client;

import java.util.EventObject;
import java.util.concurrent.ConcurrentLinkedQueue;

import me.inox.framework.common.AbstractException;
import me.inox.framework.interactive.component.IComponent;
import me.inox.framework.listener.IListener;
import me.inox.framework.model.component.ComponentInfo;

public interface IClientComponent extends IComponent {
	ComponentInfo getServerInfo();

	void setServerInfo(ComponentInfo serverInfo);
	
	void connect() throws AbstractException;

	void disConnect() throws AbstractException;

	void syncSend(Object sent,String nodeId) throws AbstractException;

	void asyncSend(Object sent,String nodeId) throws AbstractException;
	
	void syncSend(Object sent) throws AbstractException;

	void asyncSend(Object sent) throws AbstractException;

	void addConnectListener(IListener<EventObject> listener);

	void removeConnectListener(IListener<EventObject> listener);

	void addDisconnectListener(IListener<EventObject> listener);

	void removeDisconnectListener(IListener<EventObject> listener);
	
	boolean isAlive();
	
	void batchAsyncSend(Object sendObject,String nodeId);
	
	ConcurrentLinkedQueue<Object>  getCache();
	
	ComponentInfo getInfo();

}
