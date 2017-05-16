package me.inox.framework.processing;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * ��Ƭ�����Ľӿ�
 * @author xiao
 *
 */
public interface IProcessingContext {
	String getName();

	ProceedingJoinPoint getPjp();

	int getPriority();

	long getInterval();

	boolean isAsyn();

	String getGroup();

	long getTimeStamp();
	
	void setPjp(ProceedingJoinPoint pjp);
}
