package me.inox.framework.model.chanel;

import me.inox.framework.model.component.SessionState;

public class LocalChannel implements IChannel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8859054415017912224L;
	private static String LOCAL_ID="127.0.0.1:0";
	private static String LOCAL_URI="127.0.0.1:0";
	
	@Override
	public String getId() {
		return LOCAL_ID;
	}

	@Override
	public String getUri() {
		return LOCAL_URI;
	}

	@Override
	public SessionState getSessionState() {
		return SessionState.OPENED;
	}

	@Override
	public void setSessionState(SessionState ss) {
	}

}
