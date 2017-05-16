package me.inox.framework.interactive.component;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import me.inox.framework.common.IActivator;
import me.inox.framework.interactive.MessageConvertor;
import me.inox.framework.interactive.MessageEvent;
import me.inox.framework.listener.IListener;
import me.inox.framework.model.component.ComponentInfo;

public interface IComponent extends IActivator {
	ComponentInfo getInfo();
	
	void setInfo(ComponentInfo info);

	Properties getConfig();

	void setConfig(Properties config);

	void addListeners(String nodeId, Map<String,List<IListener<MessageEvent>>> listenerMap);

	List<IListener<MessageEvent>> getListeners(String nodeId,String typeg);

	Map<String , Map<String,List<IListener<MessageEvent>>>>  getMessageListeners();

	void onMessageReceived(Object o);

	MessageConvertor getMessageConvertor();

	void setMessageConvertor(MessageConvertor convertor);

}
