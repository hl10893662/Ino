package me.inox.framework.interactive.client;

import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.apache.log4j.Logger;

import me.inox.framework.common.AbstractException;
import me.inox.framework.interactive.component.AbstractComponent;
import me.inox.framework.listener.IListener;
import me.inox.framework.model.component.ComponentInfo;
import me.inox.framework.model.message.Message;

public abstract class AbstractClientComponent extends AbstractComponent
		implements IClientComponent {
	private static Logger logger = Logger
			.getLogger(AbstractClientComponent.class);
	protected ComponentInfo serverInfo;

	protected List<IListener<EventObject>> connectListeners = new ArrayList<IListener<EventObject>>();

	protected List<IListener<EventObject>> disconnectListeners = new ArrayList<IListener<EventObject>>();


	private ConcurrentLinkedQueue<Object> cache = new ConcurrentLinkedQueue<Object>();		
	public abstract void asyncSendMessage(Object sent) throws AbstractException;

	public abstract void syncSendMessage(Object source)
			throws AbstractException;

	public void syncSend(Object sent, String nodeId) throws AbstractException {
		if (this.getMessageConvertor() != null) {
			Message message = new Message();
			message.setMessageType(sent.getClass().getName());
			message.setMessageContent(sent);
			message.setNodeId(nodeId);
			Object sendData = this.getMessageConvertor().encode(message);
			this.syncSendMessage(sendData);
		} else
			this.syncSendMessage(sent);
	}

	public void asyncSend(Object sent, String nodeId) throws AbstractException {
		if (this.getMessageConvertor() != null) {
			Message message = new Message();
			message.setMessageType(sent.getClass().getName());
			message.setMessageContent(sent);
			message.setNodeId(nodeId);
			this.cache.add(message);
		} else
			this.syncSendMessage(sent);
	}

	public void syncSend(Object sent) throws AbstractException {
		if (this.getMessageConvertor() != null) {
			Object sendData = this.getMessageConvertor().encode(sent);
			this.syncSendMessage(sendData);
		} else
			this.syncSendMessage(sent);
	}

	public void asyncSend(Object sent) throws AbstractException {
		if (this.getMessageConvertor() != null) {
			Object sendData = this.getMessageConvertor().encode(sent);
			this.syncSendMessage(sendData);
		} else
			this.syncSendMessage(sent);
	}


	//ÅúÁ¿ÂÖÑ²
	@Override
	public void batchAsyncSend(Object obj,String nodeId) {

		Message message = new Message();
		message.setMessageContent(obj);
		message.setMessageType(obj.getClass().getName());
		message.setNodeId(nodeId);
		Object sendData = this.getMessageConvertor().encode(message);
		try {
			this.syncSendMessage(sendData);
		} catch (AbstractException e) {
		}
	}
	
	public ComponentInfo getServerInfo() {
		return serverInfo;
	}

	public void addConnectListener(IListener<EventObject> listener) {
		this.connectListeners.add(listener);
	}

	public void removeConnectListener(IListener<EventObject> listener) {
		this.connectListeners.remove(listener);
	}

	public void addDisconnectListener(IListener<EventObject> listener) {
		this.disconnectListeners.add(listener);
	}

	public void removeDisconnectListener(IListener<EventObject> listener) {
		this.disconnectListeners.add(listener);
	}

	public void setServerInfo(ComponentInfo serverInfo) {
		this.serverInfo = serverInfo;
	}


	public List<IListener<EventObject>> getConnectListeners() {
		return connectListeners;
	}

	public List<IListener<EventObject>> getDisconnectListeners() {
		return disconnectListeners;
	}

	public ConcurrentLinkedQueue<Object> getCache() {
		return cache;
	}

	public void setCache(ConcurrentLinkedQueue<Object> cache) {
		this.cache = cache;
	}

	
}
