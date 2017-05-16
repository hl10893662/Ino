package me.inox.framework.common.util;

import java.util.Enumeration;
import java.util.Set;
import java.util.Map.Entry;

/**
 * 
 * @author Administrator
 * @version 1.0
 * @see  ���ݴ洢�����������ͣ��ն˶��У����ڳ�ʱ���ƻ��ܶ��С�
 */
public interface IMapProxy <E,T>{
	/**
	 * �����񱣴浽��Ӧ�Ķ���
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
	 * ����keyֵ�����ڴ��еĶ��У�û���򷵻�null
	 * @param key
	 * @return
	 */
	public T getValue(E key);
	/**
	 * ����key��ö��,�߳�ͬ����
	 * @return
	 */
	public Enumeration<E> getKeys();
	/**
	 * ����entry��ö��,�߳�ͬ����
	 * @return
	 */	
	public Set<Entry<E, T>> getEntry();
	/**
	 * �Ƴ��ڴ�Ķ���
	 * @param key
	 * @return
	 */
	public T removeObject(E key);

}
