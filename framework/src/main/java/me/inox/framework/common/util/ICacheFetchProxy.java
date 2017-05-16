package me.inox.framework.common.util;

import java.util.List;

import me.inox.framework.model.terminal.ITerminalIdentity;

public interface ICacheFetchProxy<E,T> {
	public void init();
	/**
	 * 将任务保存到对应的队列
	 * @param obj
	 * @return
	 */
	public int addElement(E key,T value);
	/**
	 * @param key
	 * @return
	 */
	public T patrolElement(E key);
	/**
	 * 根据key值检索内存中的队列，没有则返回null
	 * @param key
	 * @return
	 */
	public T getValue(E key);
	/**
	 * 返回key的枚举,线程同步的
	 * @return
	 */
	public List<E> getKeys();
	/**
	 * 移除内存的对象
	 * @param key
	 * @return
	 */
	public boolean removeObject(E key);
	/**
	 * 获取优先级终端列表
	 * @return
	 */
	public List<ITerminalIdentity> getPrioList();
}
