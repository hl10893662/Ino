package me.inox.framework.model.node;

import me.inox.framework.model.IActivator;

public interface INode extends IActivator {
	NodeInfo getInfo();

	void setInfo(NodeInfo nodeInfo);

	String getIdentity();
}
