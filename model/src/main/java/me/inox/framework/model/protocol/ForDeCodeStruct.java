package me.inox.framework.model.protocol;

import java.io.Serializable;
import java.util.Map;

import me.inox.framework.model.terminal.ITerminalIdentity;

public class ForDeCodeStruct<A extends ITerminalIdentity, B extends IFrameType, C extends IForDeCodeMeta>
		implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private A terminalIdentity;
	private B frameType;
	private C forDeCodeMeta;
	private ProtocolInfo protocolInfo;
	private Map<String, Object> additions;

	public A getTerminalIdentity() {
		return terminalIdentity;
	}

	public void setTerminalIdentity(A terminalIdentity) {
		this.terminalIdentity = terminalIdentity;
	}

	public B getFrameType() {
		return frameType;
	}

	public void setFrameType(B frameType) {
		this.frameType = frameType;
	}

	public C getForDeCodeMeta() {
		return forDeCodeMeta;
	}

	public void setForDeCodeMeta(C forDeCodeMeta) {
		this.forDeCodeMeta = forDeCodeMeta;
	}

	public ProtocolInfo getProtocolInfo() {
		return protocolInfo;
	}

	public void setProtocolInfo(ProtocolInfo protocolInfo) {
		this.protocolInfo = protocolInfo;
	}

	public Map<String, Object> getAdditions() {
		return additions;
	}

	public void setAdditions(Map<String, Object> additions) {
		this.additions = additions;
	}
}
