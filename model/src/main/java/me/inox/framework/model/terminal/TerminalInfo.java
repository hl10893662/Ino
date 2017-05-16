package me.inox.framework.model.terminal;

import java.io.Serializable;
import java.util.Map;


/**
 *  keyÃû³Æ£º
 * 	terminalIdentity 
	terminalStatus 
	statusChangeTime 
	nodeId
	serverComponentInfo 
	clientComponentInfo  
	lastActiveTime
	ip 
	protocolInfo
 *
 */

public class TerminalInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -46822939637779649L;
	private Map<String,Object> properties;

	public Map<String, Object> getProperties() {
		return properties;
	}

	public void setProperties(Map<String, Object> properties) {
		this.properties = properties;
	}
	
	
}
