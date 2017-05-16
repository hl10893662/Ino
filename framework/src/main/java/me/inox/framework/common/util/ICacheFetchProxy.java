package me.inox.framework.common.util;

import java.util.List;

import me.inox.framework.model.terminal.ITerminalIdentity;

public interface ICacheFetchProxy<E,T> {
	public void init();
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
	public List<E> getKeys();
	/**
	 * �Ƴ��ڴ�Ķ���
	 * @param key
	 * @return
	 */
	public boolean removeObject(E key);
	/**
	 * ��ȡ���ȼ��ն��б�
	 * @return
	 */
	public List<ITerminalIdentity> getPrioList();
}
