package me.inox.framework.processing;

import java.util.EventObject;

import org.aspectj.lang.ProceedingJoinPoint;
/**
 * processing代理接口
 * @author xiao
 *
 */
public interface IProcessingProxy {
	public void execute(ProceedingJoinPoint pjp, EventObject event)
			throws Throwable;
}
