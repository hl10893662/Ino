package me.inox.framework.model.protocol;

import java.io.Serializable;

/**
 * @author 2.22 ���Ľ�֡�������
 */
public interface IDeCodedMeta extends Serializable {
	Object getDataUnit();

	Object getHeadUnit();

	Object getTailUnit();
}
