package me.inox.framework.model.protocol;

import java.io.Serializable;

/**
 * @author 2.22 报文解帧后的数据
 */
public interface IDeCodedMeta extends Serializable {
	Object getDataUnit();

	Object getHeadUnit();

	Object getTailUnit();
}
