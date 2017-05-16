package me.inox.framework.processing;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * processingע��
 * @author xiao
 *
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ProcessingProxyInfo {
	
	/**
	 * ���ȼ�
	 * @return
	 */
	int priority() default Thread.NORM_PRIORITY;

	/**
	 * �Ƿ��첽
	 * @return
	 */
	boolean async() default false;
	
	/**
	 * ѭ������ִ�м��
	 * @return
	 */
	long interval() default -1;
	
	
	/**
	 * ����
	 * @return
	 */
	String group() default "default";
}
