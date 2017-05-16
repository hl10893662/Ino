package me.inox.framework.interactive;

public interface ISerialize<T,E> {

	T encode(E source);
	E decode(T source);

	

}
