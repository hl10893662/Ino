package me.inox.framework.model.protocol;

import java.io.Serializable;

/**
 * @author 
 * ����֡������
 */
public interface IForDeCodeMeta  extends Serializable{
	IForDeCodeMeta append(IForDeCodeMeta meta);
	IForDeCodeMeta create();
	byte[] getByteArray();
}
