package me.inox.framework.common.util;

import java.util.Enumeration;
import java.util.Set;
import java.util.Map.Entry;

/**
 * 
 * @author Administrator
 * @version 1.0
 * @see  数据存储【有两种类型：终端队列，用于超时控制汇总队列】
 */
public interface IMapProxy <E,T>{
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
	public Enumeration<E> getKeys();
	/**
	 * 返回entry的枚举,线程同步的
	 * @return
	 */	
	public Set<Entry<E, T>> getEntry();
	/**
	 * 移除内存的对象
	 * @param key
	 * @return
	 */
	public T removeObject(E key);

}
