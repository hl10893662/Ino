package me.inno.framework.processing;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 切片上下文接口
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
