package me.inox.framework.model.protocol;

import java.io.Serializable;

/**
 * @author 
 * 待解帧的数据
 */
public interface IForDeCodeMeta  extends Serializable{
	IForDeCodeMeta append(IForDeCodeMeta meta);
	IForDeCodeMeta create();
	byte[] getByteArray();
}
