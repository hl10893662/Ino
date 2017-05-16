package me.inox.framework.model.protocol;

import java.io.Serializable;

/**
 * @author  组帧后的数据，即要下发的报文
 */
public interface IEnCodedMeta extends Serializable{
	public Object getEnCodedContent();
} 