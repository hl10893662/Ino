package me.inox.framework.processing;

public interface IProcessingExecutor {
	void execute(IProcessingContext processingContext) throws Throwable;

	IProcessingContext createProcessingContext(String name, long interval,
			int priority, boolean asyn, String group);
}
