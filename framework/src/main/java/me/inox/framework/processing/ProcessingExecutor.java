package me.inox.framework.processing;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

/**
 * processing处理实现
 * @author xiao
 *
 */
public class ProcessingExecutor implements IProcessingExecutor {
	private ThreadPoolExecutor defaultExecutor;
	private ScheduledThreadPoolExecutor defaultScheduledExecutor;
	private ThreadPoolExecutor coreExecutor;
	private ScheduledThreadPoolExecutor coreScheduledExecutor;
	private IComparer comparer;
	private static Logger logger = Logger.getLogger(ProcessingExecutor.class);

	@Override
	public void execute(IProcessingContext processingContext) throws Throwable {
		if (processingContext.isAsyn()) {
			if (processingContext.getInterval() >= 0) {
				if ("core".equals(processingContext.getGroup())) {
					coreScheduledExecutor.scheduleAtFixedRate(
							(ProcessingThread) processingContext, 0,
							processingContext.getInterval(),
							TimeUnit.MILLISECONDS);
				} else {
					defaultScheduledExecutor.scheduleAtFixedRate(
							(ProcessingThread) processingContext, 0,
							processingContext.getInterval(),
							TimeUnit.MILLISECONDS);
				}
			} else {
				if ("core".equals(processingContext.getGroup())) {
					int size = coreExecutor.getQueue().size();
					if ((size > 0) && (size % 500 == 0)) {
						logger.trace(processingContext.getName()+"_"+coreExecutor.getActiveCount()+"_核心线程池等待队列大小：" + size);
					}
					coreExecutor.execute((ProcessingThread) processingContext);
				} else {
					int size = defaultExecutor.getQueue().size();
					if ((size > 0) && (size % 500 == 0)) {
						logger.trace(processingContext.getName()+"_"+defaultExecutor.getActiveCount()+"业务线程池等待队列大小：" + size);
					}
					defaultExecutor
							.execute((ProcessingThread) processingContext);
				}
			}
		} else {
			((ProcessingThread) processingContext).run();
		}
	}

	@Override
	public IProcessingContext createProcessingContext(String name,
			long interval, int priority, boolean asyn, String group) {
		ProcessingThread thread = new ProcessingThread();
		thread.setName(name);
		thread.setInterval(interval);
		thread.setPriority(priority);
		thread.setAsyn(asyn);
		thread.setTimeStamp(System.currentTimeMillis());
		thread.setComparer(comparer);
		thread.setGroup(group);
		return thread;
	}

	public void setDefaultExecutor(ThreadPoolExecutor defaultExecutor) {
		this.defaultExecutor = defaultExecutor;
	}

	public void setDefaultScheduledExecutor(
			ScheduledThreadPoolExecutor defaultScheduledExecutor) {
		this.defaultScheduledExecutor = defaultScheduledExecutor;
	}

	public void setCoreExecutor(ThreadPoolExecutor coreExecutor) {
		this.coreExecutor = coreExecutor;
	}

	public void setCoreScheduledExecutor(
			ScheduledThreadPoolExecutor coreScheduledExecutor) {
		this.coreScheduledExecutor = coreScheduledExecutor;
	}

	public void setComparer(IComparer comparer) {
		this.comparer = comparer;
	}

	public ThreadPoolExecutor getCoreExecutor() {
		return coreExecutor;
	}
	/*
	public static void main(String[] args){
	    BlockingQueue<Runnable> queue =new LinkedBlockingQueue<Runnable>(100);
		ThreadPoolExecutor excutor = new ThreadPoolExecutor(50,150,30,TimeUnit.SECONDS,queue,new RejectedAllExecutionHandler());
		for(int i=0;i<500;i++){
			TestThread t1 = new TestThread(i);
			excutor.execute(t1);
			
		}
		System.out.println("++++++++++++++++++++++++++==");
	} */  
}
