package me.inox.framework.interactive;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.log4j.Logger;

import me.inox.framework.common.AbstractException;
import me.inox.framework.interactive.client.IClientComponent;
import me.inox.framework.interactive.client.ILocalClientComponent;
import me.inox.framework.interactive.component.IComponent;
import me.inox.framework.interactive.component.IComponentFactory;
import me.inox.framework.interactive.server.IServerComponent;
import me.inox.framework.listener.IListener;
import me.inox.framework.model.component.ComponentInfo;
import me.inox.framework.model.component.RegisterException;
import me.inox.framework.model.component.SessionState;
import me.inox.framework.model.node.INode;

public class InteractiveProxy implements IInteractiveProxy {
	private static Logger logger = Logger.getLogger(InteractiveProxy.class);
	// 存放服务端信道的集合
	private Map<String, IServerComponent> serverComponents;
	// 客户端的集合
	private Map<String, IClientComponent> clientComponents;
	private Map<String, MessageConvertor> convertors;
	// component产生工厂
	private IComponentFactory componentFactory;
	private int localCommunicateType;

	// 返回component
	public IComponent getComponent(ComponentInfo info) throws RegisterException {
		// 客户端
		if (info.isTarget()) {
			// 已存在的客服端直接返回
			if (this.serverComponents.get(info.getIdentity()) != null) {
				if (clientComponents.get(info.getIdentity()) != null) {
					if (localCommunicateType == clientComponents
							.get(info.getIdentity()).getInfo()
							.getCommunicateType()) {
						return clientComponents.get(info.getIdentity());
					} else {
						IClientComponent client = componentFactory
								.createClientComponent(localCommunicateType);
						((ILocalClientComponent) client)
								.setServerComponent(this.serverComponents
										.get(info.getIdentity()));
						clientComponents.put(info.getIdentity(), client);
						return client;
					}
				} else {
					IClientComponent client = componentFactory
							.createClientComponent(localCommunicateType);
					((ILocalClientComponent) client)
							.setServerComponent(this.serverComponents.get(info
									.getIdentity()));
					clientComponents.put(info.getIdentity(), client);
					return client;
				}
			} else {
				if (clientComponents.get(info.getIdentity()) != null) {
					//判断客户端时候还连接
					if(clientComponents.get(info.getIdentity()).getInfo().getChannel().getSessionState() == SessionState.OPENED)
						return clientComponents.get(info.getIdentity());
					else{
						try {
							clientComponents.get(info.getIdentity()).connect();
						} catch (AbstractException e) {
							logger.error("客户端到服务端的连接失败："+info.getIdentity(), e);
						}
						return clientComponents.get(info.getIdentity());						
					}
				} else {
					IClientComponent client = componentFactory
							.createClientComponent(info.getCommunicateType());
					client.setServerInfo(info);
					client.setMessageConvertor(convertors.get(info
							.getCommunicateType() + ""));
					clientComponents.put(info.getIdentity(), client);
					logger.info("创建到"+info.getIdentity()+"的客户端链接,当前节点客户端连接数："+clientComponents.size());

					try {
						client.connect();
					} catch (AbstractException e) {
						logger.error("创建客户端到服务端的连接失败："+info.getIdentity(), e);
					}
					return client;
				}
			}
		} else {
			// 已注册的服务端
			if (serverComponents.get(info.getIdentity()) != null) {
				return serverComponents.get(info.getIdentity());
			} else {
				// 未注册的服务端
				new RegisterException();
				return null;
			}
		}
	}

	public IServerComponent registerServerComponent(INode node,
			ComponentInfo info, MessageConvertor convertor,
			Map<String, List<IListener<MessageEvent>>> listeners)
			throws RegisterException {
		if (serverComponents.get(info.getIdentity()) != null) {
			IServerComponent server = serverComponents.get(info.getIdentity());
			if (listeners != null)
				server.addListeners(node.getIdentity(), listeners);
			return server;
		} else {
			IServerComponent server = componentFactory
					.createServerComponent(info.getCommunicateType());
			serverComponents.put(info.getIdentity(), server);
			server.setInfo(info);
			server.setMessageConvertor(convertor);
			if (listeners != null)
				server.addListeners(node.getIdentity(), listeners);
			server.init();
			return server;
		}

	}

	public IComponentFactory getComponentFactory() {
		return componentFactory;
	}

	public void setComponentFactory(IComponentFactory componentFactory) {
		this.componentFactory = componentFactory;
	}

	@Override
	public void init() {
		serverComponents = new ConcurrentHashMap<String, IServerComponent>();
		clientComponents = new ConcurrentHashMap<String, IClientComponent>();
	}

	public int getLocalCommunicateType() {
		return localCommunicateType;
	}

	public void setLocalCommunicateType(int localCommunicateType) {
		this.localCommunicateType = localCommunicateType;
	}

	public Map<String, MessageConvertor> getConvertors() {
		return convertors;
	}

	public void setConvertors(Map<String, MessageConvertor> convertors) {
		this.convertors = convertors;
	}

	public Map<String, IClientComponent> getClientComponents() {
		return clientComponents;
	}

	public void setClientComponents(Map<String, IClientComponent> clientComponents) {
		this.clientComponents = clientComponents;
	}

	public Map<String, IServerComponent> getServerComponents() {
		return serverComponents;
	}

	public void setServerComponents(Map<String, IServerComponent> serverComponents) {
		this.serverComponents = serverComponents;
	}

}