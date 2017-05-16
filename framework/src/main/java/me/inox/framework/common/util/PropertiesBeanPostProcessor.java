package me.inox.framework.common.util;

import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.util.ReflectionUtils;

public class PropertiesBeanPostProcessor extends PropertyPlaceholderConfigurer
		implements BeanPostProcessor, InitializingBean {

	private static Logger logger = Logger
			.getLogger(PropertiesBeanPostProcessor.class);
	private java.util.Properties pros;
	private int type;
	private ConcurrentHashMap<Object, Object> propertyMap;
	private Class[] enableClassList = { String.class };
	public void setEnableClassList(Class[] enableClassList) {
		this.enableClassList = enableClassList;
	}

	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException, IllegalArgumentException {
		return bean;
	}

	private boolean filterType(String type) {
		if (type != null) {
			for (Class c : enableClassList) {
				if (c.toString().equals(type)) {
					return true;
				}
			}
			return false;
		} else {
			return true;
		}
	}

	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		Field[] fields = bean.getClass().getDeclaredFields();
		for (Field field : fields) {
			if (field.isAnnotationPresent(Properties.class)) {
				if (filterType(field.getType().toString())) {
					Properties p = field.getAnnotation(Properties.class);
					ReflectionUtils.makeAccessible(field);
					try {
						field.set(bean, pros.getProperty(p.name()));						
					} catch (IllegalAccessException e) {
						logger.error("Properties ×¢Éä´íÎó£¬bean["+beanName+"],field["+p.name()+"]",e);
					}
				}
			}
		}
		return bean;
	}
	
	public void afterPropertiesSet() throws Exception {
		pros = mergeProperties();
		if(type!=0){
			for(Object key:pros.keySet()){
				propertyMap.put(key, pros.get(key));
			}
		}
		
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public void setPropertyMap(ConcurrentHashMap<Object, Object> propertyMap) {
		this.propertyMap = propertyMap;
		if(this.propertyMap!=null){
			java.util.Properties tmps = new java.util.Properties();
			for(Object key:this.propertyMap.keySet()){
				tmps.put(key, propertyMap.get(key));
			}
			setProperties(tmps);		
		}		
	}
	
}
