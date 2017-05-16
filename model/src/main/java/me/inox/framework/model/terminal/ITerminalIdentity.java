package me.inox.framework.model.terminal;

import java.io.Serializable;

public interface ITerminalIdentity extends Serializable{
	boolean equals(Object obj);
	public String toString();
	public String getId();
}
