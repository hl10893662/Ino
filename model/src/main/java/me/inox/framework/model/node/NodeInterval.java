package me.inox.framework.model.node;

import java.io.Serializable;

public class NodeInterval implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private int beginHash; //��ʼhash
	
	private int endHash; //����hash
	
	private String identity; //node��ʶ ͬNodeInfo.identity
	
	private long chgTime;
	
	public NodeInterval() {
		
	}
	
	public NodeInterval(int beginHash, int endHash, String identity) {
		this.beginHash = beginHash;
		this.endHash = endHash;
		this.identity = identity;
	}

	public int getBeginHash() {
		return beginHash;
	}

	public void setBeginHash(int beginHash) {
		this.beginHash = beginHash;
	}

	public int getEndHash() {
		return endHash;
	}

	public void setEndHash(int endHash) {
		this.endHash = endHash;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public long getChgTime() {
		return chgTime;
	}

	public void setChgTime(long chgTime) {
		this.chgTime = chgTime;
	}

}
