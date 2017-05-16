package me.inox.framework.listener;

import java.util.*;

public interface IListener<T extends EventObject>{
	void dealEvent(T event);
}