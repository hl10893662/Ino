package me.inox.framework.model.protocol;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import me.inox.framework.model.terminal.ITerminalIdentity;

/**
 * @author 解帧后的数据结构
 */
public class DeCodedStruct<A extends ITerminalIdentity, B extends IFrameType, C extends IDeCodedMeta, D extends IReason>
		implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<String, Object> additions;
	private C deCodedMeta;
	private B frameType;
	private ProtocolInfo protocolInfo;
	private D reason;
	private boolean success;
	private A terminalIdentity;

	public Map<String, Object> getAdditions() {
		return additions;
	}

	public C getDeCodedMeta() {
		return deCodedMeta;
	}

	public B getFrameType() {
		return frameType;
	}

	public ProtocolInfo getProtocolInfo() {
		return protocolInfo;
	}

	public D getReason() {
		return reason;
	}

	public A getTerminalIdentity() {
		return terminalIdentity;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setAdditions(Map<String, Object> additions) {
		this.additions = additions;
	}

	public void setDeCodedMeta(C deCodedMeta) {
		this.deCodedMeta = deCodedMeta;
	}

	public void setFrameType(B frameType) {
		this.frameType = frameType;
	}

	public void setProtocolInfo(ProtocolInfo protocolInfo) {
		this.protocolInfo = protocolInfo;
	}

	public void setReason(D reason) {
		this.reason = reason;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public void setTerminalIdentity(A terminalIdentity) {
		this.terminalIdentity = terminalIdentity;
	}
	
	public void setAddition(String key, Object value) {
		if(additions == null) {
			additions = new HashMap<String, Object>();
		}
		additions.put(key, value);
	}
	
	public Object getAddition(String key) {
		Object obj = null;
		if(additions != null && additions.size() > 0) {
			obj = additions.get(key);
		}
		return obj;
	}
}
