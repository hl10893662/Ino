package me.inox.framework.interactive.server;

import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.log4j.Logger;

import me.inox.framework.common.AbstractException;
import me.inox.framework.interactive.component.AbstractComponent;
import me.inox.framework.listener.IListener;
import me.inox.framework.model.component.ComponentInfo;
import me.inox.framework.model.message.Message;

public abstract class AbstractServerComponent extends AbstractComponent
		implements IServerComponent {
	protected ConcurrentHashMap<String, ComponentInfo> clientComponents;

	protected List<IListener<EventObject>> openListeners = new ArrayList<IListener<EventObject>>();

	protected List<IListener<EventObject>> closeListeners = new ArrayList<IListener<EventObject>>();

	protected List<IListener<EventObject>> clientDisconnectedListeners = new  ArrayList<IListener<EventObject>>();
	
	private static Logger logger = Logger
			.getLogger(AbstractServerComponent.class);

	public ConcurrentHashMap<String, ComponentInfo> getClientComponents() {
		return clientComponents;
	}

	public void setClientComponents(
			ConcurrentHashMap<String, ComponentInfo> clientComponents) {
		this.clientComponents = clientComponents;
	}

	public void addOpenListener(IListener<EventObject> listener) {
		this.openListeners.add(listener);
	}
	public List<IListener<EventObject>> getOpenListener(){
		return this.openListeners;
	}
	public void removeOpenListener(IListener<EventObject> listener) {
		this.openListeners.remove(listener);
	}

	public void addCloseListener(IListener<EventObject> listener) {
		this.closeListeners.add(listener);
	}

	public void removeCloseListener(IListener<EventObject> listener) {
		this.closeListeners.add(listener);
	}
	public void addClientDisconnected(IListener<EventObject> listener){
		this.clientDisconnectedListeners.add(listener);
	}
	
	public void removeClientDisconnected(IListener<EventObject> listener){
		this.clientDisconnectedListeners.remove(listener);
	}
	
	public void setClientDisconnectedListeners(
			List<IListener<EventObject>> clientDisconnectedListeners) {
		this.clientDisconnectedListeners = clientDisconnectedListeners;
	}

	public List<IListener<EventObject>> getClientDisconnectedListeners(){
		return this.clientDisconnectedListeners;
	}
	public void syncSend(ComponentInfo ci, Object data, String nodeId)
			throws AbstractException {
		if (this.getMessageConvertor() != null) {
			Message message = new Message();
			message.setMessageType(data.getClass().getName());
			message.setMessageContent(data);
			message.setNodeId(nodeId);
			Object sendData = this.getMessageConvertor().encode(message);
			this.syncSend(ci, sendData);
		} else
			this.syncSend(ci, data);

	}

	public void asyncSend(ComponentInfo ci, Object data, String nodeId)
			throws AbstractException {
		if (this.getMessageConvertor() != null) {
			Message message = new Message();
			message.setMessageType(data.getClass().getName());
			message.setMessageContent(data);
			message.setNodeId(nodeId);
			Object sendData = this.getMessageConvertor().encode(message);
			this.asyncSend(ci, sendData);
		} else
			this.asyncSend(ci, data);
	}

}
