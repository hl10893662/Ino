package me.inox.framework.interactive.component;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.log4j.Logger;

import me.inox.framework.interactive.MessageConvertor;
import me.inox.framework.interactive.MessageEvent;
import me.inox.framework.listener.IListener;
import me.inox.framework.model.component.ComponentInfo;
import me.inox.framework.model.message.Message;

public abstract class AbstractComponent implements IComponent {
	protected Properties config;
	protected ComponentInfo info;
	protected ConcurrentHashMap<String, Map<String, List<IListener<MessageEvent>>>> listeners;
	protected MessageConvertor messageConvertor;
	private static Logger logger = Logger.getLogger(AbstractComponent.class);

	public Properties getConfig() {
		return config;
	}

	public void setConfig(Properties config) {
		this.config = config;
	}

	public ComponentInfo getInfo() {
		return info;
	}

	public void setInfo(ComponentInfo info) {
		this.info = info;
	}

	public void addListeners(String nodeId,
			Map<String, List<IListener<MessageEvent>>> listenerMap) {
		if (listeners == null) {
			listeners = new ConcurrentHashMap<String, Map<String, List<IListener<MessageEvent>>>>();
		}
		listeners.put(nodeId, listenerMap);
	}

	public List<IListener<MessageEvent>> getListeners(String nodeId, String type) {
		if (listeners.get(nodeId) != null
				&& listeners.get(nodeId).get(type) != null) {
			return listeners.get(nodeId).get(type);
		} else {
			return null;
		}
	}

	public Map<String, Map<String, List<IListener<MessageEvent>>>> getMessageListeners() {
		return listeners;
	}

	public void setListeners(
			ConcurrentHashMap<String, Map<String, List<IListener<MessageEvent>>>> listeners) {
		this.listeners = listeners;
	}

	@Override
	public MessageConvertor getMessageConvertor() {
		return messageConvertor;
	}

	@Override
	public void setMessageConvertor(MessageConvertor messageConvertor) {
		this.messageConvertor = messageConvertor;

	}

	protected void publishMessage(Object data, ComponentInfo sender) {
		long receiveTime = System.currentTimeMillis();
		Message message = (Message) this.messageConvertor.decode(data);
		if(message!=null){
			try{
			MessageEvent messageEvent = new MessageEvent(this,
					System.currentTimeMillis(), sender, this.getInfo(),
					message.getMessageType(), message.getMessageContent());
			if (message.getNodeId() != null&&!"".equals(message.getNodeId())) {
				for (String nodeId:this.listeners.keySet()) {
					Map<String,List<IListener<MessageEvent>>> listenerListMap =this.listeners.get(nodeId);
					if(listenerListMap.get(message.getMessageType())!=null){
						for (IListener<MessageEvent> listener : listenerListMap.get(message.getMessageType())) {
							listener.dealEvent(messageEvent);
						}				
					}
				}
			} else {
				for (String nodeId : listeners.keySet()) {
					Map<String, List<IListener<MessageEvent>>> map = listeners
							.get(nodeId);
					for (IListener<MessageEvent> listener : map.get(message
							.getMessageType())) {
						listener.dealEvent(messageEvent);
					}
				}
			}
			}catch(Exception e){
				logger.error("发布消息失败：message:"+message.getMessageType()+"--message.getNodeId():"+message.getNodeId(),e);
				if(this.listeners.get(message.getNodeId())!=null){
					for (IListener<MessageEvent> listener : this.listeners.get(
							message.getNodeId()).get(message.getMessageType())) {
						logger.error("listeners:"+listener.getClass().getName());
					}
				}
			}
		}

	}
}
