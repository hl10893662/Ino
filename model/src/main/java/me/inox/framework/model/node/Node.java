package me.inox.framework.model.node;

import javax.annotation.Resource;

public class Node implements INode {

	private NodeInfo Info;

	@Override
	public void init() {
	}

	@Override
	public void destroy() {

	}

	public String getIdentity() {
		return this.getInfo().getIdentity();
	}

	public NodeInfo getInfo() {
		return Info;
	}

	@Resource(name = "nodeInfo")
	public void setInfo(NodeInfo info) {
		Info = info;
	}

}
