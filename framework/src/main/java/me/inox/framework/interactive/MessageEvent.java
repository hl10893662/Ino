package me.inox.framework.interactive;

import java.util.EventObject;

import me.inox.framework.model.component.ComponentInfo;

public class MessageEvent<T> extends EventObject {

	private long receiveTime;

	private ComponentInfo senderComponentInfo;
	private ComponentInfo receiverComponentInfo;
	private String messageType;
	private T receiveMessage;

	public long getReceiveTime() {
		return receiveTime;
	}

	public ComponentInfo getSenderComponentInfo() {
		return senderComponentInfo;
	}

	public ComponentInfo getReceiverComponentInfo() {
		return receiverComponentInfo;
	}

	public T getReceiveMessage() {
		return receiveMessage;
	}

	public String getMessageType() {
		return messageType;
	}

	public void setReceiveTime(long receiveTime) {
		this.receiveTime = receiveTime;
	}

	public void setSenderComponentInfo(ComponentInfo senderComponentInfo) {
		this.senderComponentInfo = senderComponentInfo;
	}

	public void setReceiverComponentInfo(ComponentInfo receiverComponentInfo) {
		this.receiverComponentInfo = receiverComponentInfo;
	}

	public MessageEvent(Object source, String messageType, T receiveMessage) {
		super(source);
		this.messageType = messageType;
		this.receiveMessage = receiveMessage;
	}

	public MessageEvent(Object source, long receiveTime,
			ComponentInfo senderComponentInfo,
			ComponentInfo receiverComponentInfo, String messageType,
			T receiveMessage) {
		super(source);
		this.receiveTime = receiveTime;
		this.receiveMessage = receiveMessage;
		this.senderComponentInfo = senderComponentInfo;
		this.receiverComponentInfo = receiverComponentInfo;
		this.messageType = messageType;
		this.receiveMessage = receiveMessage;
	}
}
