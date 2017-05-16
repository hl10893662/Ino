package me.inox.framework.processing;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 *	线程实体
 * @author xiao
 *
 */
public class ProcessingThread implements Runnable, IProcessingContext,
		Comparable {
	private static Logger logger = Logger
			.getLogger(ProcessingThread.class);
	private String name;

	private ProceedingJoinPoint pjp;

	private int priority;

	private long interval;

	private long timeStamp;

	private boolean asyn;

	private String group;
	
	private IComparer comparer;
	@Override
	public void run() {
		try {
			pjp.proceed();
		} catch (Throwable e) {
			logger.error("业务线程"+name+"执行错误",e);
		}
	}

	@Override
	public int compareTo(Object o) {
		return comparer.compare(this, (ProcessingThread) o);
	}

	public String getName() {
		return name;
	}

	public ProceedingJoinPoint getPjp() {
		return pjp;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPjp(ProceedingJoinPoint pjp) {
		this.pjp = pjp;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public long getInterval() {
		return interval;
	}

	public void setInterval(long interval) {
		this.interval = interval;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}

	public boolean isAsyn() {
		return asyn;
	}

	public void setAsyn(boolean asyn) {
		this.asyn = asyn;
	}
	
	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public void setComparer(IComparer comparer) {
		this.comparer = comparer;
	}
}
