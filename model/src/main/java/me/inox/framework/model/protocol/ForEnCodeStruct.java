package me.inox.framework.model.protocol;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import me.inox.framework.model.terminal.ITerminalArchives;
import me.inox.framework.model.terminal.ITerminalIdentity;

/**
 * @author 2.22 待组帧的数据结构
 */
public class ForEnCodeStruct<A extends ITerminalIdentity, B extends IFrameType, C extends ITerminalArchives, D extends IForEnCodeMeta>
		implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private A terminalIdentity;
	private B frameType;
	private C terminalArchives;
	private D forEnCodeMeta;
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

	public C getTerminalArchives() {
		return terminalArchives;
	}

	public void setTerminalArchives(C terminalArchives) {
		this.terminalArchives = terminalArchives;
	}

	public ProtocolInfo getProtocolInfo() {
		return protocolInfo;
	}

	public void setProtocolInfo(ProtocolInfo protocolInfo) {
		this.protocolInfo = protocolInfo;
	}

	public D getForEnCodeMeta() {
		return forEnCodeMeta;
	}

	public void setForEnCodeMeta(D forEnCodeMeta) {
		this.forEnCodeMeta = forEnCodeMeta;
	}

	public Map<String, Object> getAdditions() {
		return additions;
	}
	
	public void addAddtion(String key,Object value){
		if(additions==null)
			additions = new HashMap<String,Object>();
		additions.put(key, value);
	}
	
	public void setAdditions(Map<String, Object> additions) {
		this.additions = additions;
	}
}
