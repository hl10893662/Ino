package me.inox.framework.interactive;

public interface IFormat<T, E> {
	T decode(E source);

	E encode(T source);
}
