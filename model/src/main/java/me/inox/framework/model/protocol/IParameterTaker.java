package me.inox.framework.model.protocol;

import java.util.List;

public interface IParameterTaker<T> {
	public List<T> getParamTypeByFrameType();
}
