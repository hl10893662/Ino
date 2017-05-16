package me.inox.framework.interactive.component;

import java.util.HashMap;

import me.inox.framework.interactive.client.IClientComponent;
import me.inox.framework.interactive.server.IServerComponent;

public class ComponentFactory implements IComponentFactory{
	private HashMap<String,IComponentTemplate<IClientComponent>> clientComponentMap;
	private HashMap<String,IComponentTemplate<IServerComponent>> serverComponentMap;
	@Override
	public IClientComponent createClientComponent(int CommunicateType) {
		IClientComponent clientComponent = clientComponentMap.get(String.valueOf(CommunicateType)).createComponent();
		clientComponent.getInfo().setCommunicateType(CommunicateType);
		return clientComponent;
	}

	@Override
	public IServerComponent createServerComponent(int communicateType) {
		IServerComponent serverComponent = serverComponentMap.get(String.valueOf(communicateType)).createComponent();
		return serverComponent;
	}

	public HashMap<String, IComponentTemplate<IClientComponent>> getClientComponentMap() {
		return clientComponentMap;
	}

	public void setClientComponentMap(
			HashMap<String, IComponentTemplate<IClientComponent>> clientComponentMap) {
		this.clientComponentMap = clientComponentMap;
	}

	public HashMap<String, IComponentTemplate<IServerComponent>> getServerComponentMap() {
		return serverComponentMap;
	}

	public void setServerComponentMap(
			HashMap<String, IComponentTemplate<IServerComponent>> serverComponentMap) {
		this.serverComponentMap = serverComponentMap;
	}


}
