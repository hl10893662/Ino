package me.inox.framework.model.protocol;

import java.io.Serializable;
import java.util.Map;

import me.inox.framework.model.terminal.ITerminalIdentity;

/**
 * @author 2.22 组帧后的数据结构
 */
public class EnCodedStruct<A extends ITerminalIdentity, B extends IEnCodedMeta, C extends IReason>
		implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private A terminalIdentity;
	private B enCodedMeta;
	private C reason;
	private Map<String, Object> additions;

	public A getTerminalIdentity() {
		return terminalIdentity;
	}

	public void setTerminalIdentity(A terminalIdentity) {
		this.terminalIdentity = terminalIdentity;
	}

	public B getEnCodedMeta() {
		return enCodedMeta;
	}

	public void setEnCodedMeta(B enCodedMeta) {
		this.enCodedMeta = enCodedMeta;
	}

	public C getReason() {
		return reason;
	}

	public void setReason(C reason) {
		this.reason = reason;
	}

	public Map<String, Object> getAdditions() {
		return additions;
	}

	public void setAdditions(Map<String, Object> additions) {
		this.additions = additions;
	}
}
