package me.inox.framework.model.message;

import java.io.Serializable;

public class Message implements Serializable {

	private Object messageContent;

	private String nodeId;

	private String messageType;

	public Object getMessageContent() {
		return messageContent;
	}

	public void setMessageContent(Object messageContent) {
		this.messageContent = messageContent;
	}

	public String getNodeId() {
		return nodeId;
	}

	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}

	public String getMessageType() {
		return messageType;
	}

	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}

}
