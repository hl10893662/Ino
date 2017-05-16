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
	// ��ŷ�����ŵ��ļ���
	private Map<String, IServerComponent> serverComponents;
	// �ͻ��˵ļ���
	private Map<String, IClientComponent> clientComponents;
	private Map<String, MessageConvertor> convertors;
	// component��������
	private IComponentFactory componentFactory;
	private int localCommunicateType;

	// ����component
	public IComponent getComponent(ComponentInfo info) throws RegisterException {
		// �ͻ���
		if (info.isTarget()) {
			// �Ѵ��ڵĿͷ���ֱ�ӷ���
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
					//�жϿͻ���ʱ������
					if(clientComponents.get(info.getIdentity()).getInfo().getChannel().getSessionState() == SessionState.OPENED)
						return clientComponents.get(info.getIdentity());
					else{
						try {
							clientComponents.get(info.getIdentity()).connect();
						} catch (AbstractException e) {
							logger.error("�ͻ��˵�����˵�����ʧ�ܣ�"+info.getIdentity(), e);
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
					logger.info("������"+info.getIdentity()+"�Ŀͻ�������,��ǰ�ڵ�ͻ�����������"+clientComponents.size());

					try {
						client.connect();
					} catch (AbstractException e) {
						logger.error("�����ͻ��˵�����˵�����ʧ�ܣ�"+info.getIdentity(), e);
					}
					return client;
				}
			}
		} else {
			// ��ע��ķ����
			if (serverComponents.get(info.getIdentity()) != null) {
				return serverComponents.get(info.getIdentity());
			} else {
				// δע��ķ����
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