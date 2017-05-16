package me.inox.framework.model.protocol;

import java.io.Serializable;

public class ProtocolInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3470192430649668599L;
	private String protocolType;
	private String version;
	private int hashCodeValue = -1;
	@Override
	public int hashCode() {
		if(hashCodeValue==-1){
			hashCodeValue=(protocolType+"@"+version).hashCode();
		}

		return hashCodeValue;
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj.getClass() != ProtocolInfo.class) {
			return false;
		}
		if(hashCode()==obj.hashCode())
			return true;
		return false;
	}

	public String getProtocolType() {
		return protocolType;
	}

	public void setProtocolType(String protocolType) {
		this.protocolType = protocolType;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

}
