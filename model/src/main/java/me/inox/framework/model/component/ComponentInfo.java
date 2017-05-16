package me.inox.framework.model.component;

import java.io.Serializable;

import me.inox.framework.model.chanel.IChannel;

public class ComponentInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4029748467020189490L;
	protected IChannel channel;
	protected int communicateType;
	protected boolean target;

	public IChannel getChannel() {
		return channel;
	}

	public void setChannel(IChannel channel) {
		this.channel = channel;
	}

	public int getCommunicateType() {
		return communicateType;
	}

	public void setCommunicateType(int communicateType) {
		this.communicateType = communicateType;
	}

	public boolean isTarget() {
		return target;
	}

	public void setTarget(boolean target) {
		this.target = target;
	}

	public String getIdentity() {
		return channel.getUri();
	}

}
