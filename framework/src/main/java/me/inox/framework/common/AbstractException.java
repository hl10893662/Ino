package me.inox.framework.common;

import java.util.*;

public abstract class AbstractException extends Exception {

	public AbstractException(Calendar occursTime, Class occursClass,
			List<Exception> innerExceptions) {
		super();
		this.occursTime = Calendar.getInstance();
		this.occursClass = occursClass;
		this.innerExceptions = innerExceptions;
	}
	
	public AbstractException(String errorCode, Exception e) {
		this.errorCode = errorCode;
		addException(e);
	}
	
	public AbstractException(String errorCode) {
		this.errorCode = errorCode;
	}

	private Calendar occursTime;
	/**
	 * errorCode‘›∂®±‡¬Î
	 *   1 
	 */
	protected String errorCode;
	private Class occursClass;
	protected List<Exception> innerExceptions;

	public Calendar getOccursTime() {
		return occursTime;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public Class getOccursClass() {
		return occursClass;
	}

	public List<Exception> getInnerExceptions() {
		return innerExceptions;
	}
	
	public void addException(Exception e) {
		if(innerExceptions == null)
			innerExceptions = new ArrayList<Exception>();
		innerExceptions.add(e);
	}
	
}
