package me.inox.framework.processing;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

import org.apache.log4j.Logger;
/**
 * 线程失败回调
 * @author xiao
 *
 */
public class RejectedAllExecutionHandler implements RejectedExecutionHandler{
	private static Logger logger = Logger.getLogger(RejectedAllExecutionHandler.class);
	private static int dropNum=0;
	@Override
	public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
		dropNum++;
		if(dropNum%10000==0)
		logger.info("queue:"+executor.getQueue().size()+", rejected :" +r.getClass().getName());
	/*	try{
	        if (!executor.isShutdown()) {
	        	System.out.println("queue:"+executor.getQueue().size());
	        	for(Iterator it=executor.getQueue().iterator();it.hasNext();){
	        		TestThread tt = (TestThread)it.next();
	        		if(tt.getPriority()!=3)
	        			it.remove();
	        	}
	        	if(((TestThread)r).getPriority()==3&&executor.getQueue().size()<1000){
	        		executor.execute(r);
	        	}else{
	        		executor.execute(r);
	        		System.out.println("RejectedByPrioExecutionHandler:"+executor.getQueue().size()+",run:"+((TestThread)r).getGroup());
	        	}
	        }
		}catch(Exception e){
			e.printStackTrace();
		} */
	}

}
