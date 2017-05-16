package me.inox.framework.processing;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * processing注解
 * @author xiao
 *
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ProcessingProxyInfo {
	
	/**
	 * 优先级
	 * @return
	 */
	int priority() default Thread.NORM_PRIORITY;

	/**
	 * 是否异步
	 * @return
	 */
	boolean async() default false;
	
	/**
	 * 循环任务执行间隔
	 * @return
	 */
	long interval() default -1;
	
	
	/**
	 * 分组
	 * @return
	 */
	String group() default "default";
}
