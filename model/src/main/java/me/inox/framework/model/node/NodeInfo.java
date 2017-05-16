package me.inox.framework.model.node;

import java.io.Serializable;
import java.util.Map;
import java.util.UUID;

import me.inox.framework.model.component.ComponentInfo;

public class NodeInfo implements Serializable {
	private Map<String, Object> properties;
	private int role;
	private ComponentInfo componentInfo;
	private NodeStatus status;
	private String identity;

	public NodeInfo() {
		this.identity = UUID.randomUUID().toString();
		this.status = NodeStatus.OFFLINE;
	}

	public Map<String, Object> getProperties() {
		return properties;
	}

	public void setProperties(Map<String, Object> properties) {
		this.properties = properties;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public NodeStatus getStatus() {
		return status;
	}

	public void setStatus(NodeStatus status) {
		this.status = status;
	}

	public ComponentInfo getComponentInfo() {
		return componentInfo;
	}

	public void setComponentInfo(ComponentInfo componentInfo) {
		this.componentInfo = componentInfo;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

}
