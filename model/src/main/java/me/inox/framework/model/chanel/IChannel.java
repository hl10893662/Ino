package me.inox.framework.model.chanel;

import java.io.Serializable;

import me.inox.framework.model.component.SessionState;

public interface IChannel extends Serializable {
	String getId();

	String getUri();

	SessionState getSessionState();

	void setSessionState(SessionState ss);

	boolean equals(Object obj);

	String toString();
}
