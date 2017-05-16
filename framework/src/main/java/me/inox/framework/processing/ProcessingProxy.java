package me.inox.framework.processing;

import java.util.EventObject;
import java.util.concurrent.ConcurrentHashMap;


import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * processing代理实现
 * @author xiao
 *
 */
@Aspect
public class ProcessingProxy implements IProcessingProxy {
	private IProcessingExecutor executor;
	private ConcurrentHashMap<Class, ProcessingProxyInfo> cache;
	private static Logger logger = Logger.getLogger(ProcessingProxy.class);

	public void init() {
		this.cache = new ConcurrentHashMap<Class, ProcessingProxyInfo>();
	}

	@Around("execution(* me.inox.framework.common.util.IListener+.dealEvent(*))  && args(event)")
	public void execute(ProceedingJoinPoint pjp, EventObject event)
			throws Throwable {
		Class clazz = pjp.getThis().getClass();
		String name = clazz.getName();
		long interval = -1;
		int priority = Thread.NORM_PRIORITY;
		String group = "default";
		boolean asyn = false;
		ProcessingProxyInfo annotation = cache.get(clazz);
		if (annotation == null) {
			annotation = (ProcessingProxyInfo) clazz
					.getAnnotation(ProcessingProxyInfo.class);
		}
		if (annotation != null) {
			interval = annotation.interval();
			priority = annotation.priority();
			asyn = annotation.async();
			group = annotation.group();
			cache.put(clazz, annotation);
		}
		IProcessingContext context = executor.createProcessingContext(name,
				interval, priority, asyn, group);
		context.setPjp(pjp);
		executor.execute(context);
	}

	public void setExecutor(IProcessingExecutor executor) {
		this.executor = executor;
	}
}
