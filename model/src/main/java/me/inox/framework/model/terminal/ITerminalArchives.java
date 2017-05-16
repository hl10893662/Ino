package me.inox.framework.model.terminal;

import java.io.Serializable;
import java.util.List;

import me.inox.framework.model.protocol.ProtocolInfo;

public interface ITerminalArchives extends Serializable{
	// 获得这个档案的唯一值 key
	public String getKey();
	
	public ITerminalIdentity getTerminalIdentity();
	
	public ProtocolInfo getProtocolInfo();

	// 获得这个档案的属性值
	public String getValue(String propertyName);
	// 获得这个档案的子档案
	public ITerminalArchives getArchives(String childArchiveKey);

	// 获得这个档案里面某种类型的档案列表
	public List<ITerminalArchives> getArchList(String dataType);

	// 添加一个属性
	public void setValue(String key, String value);

	// 添加一个子档案
	public void setArchives(String key, ITerminalArchives prof);
	//获得所有子节点
	public List<ITerminalArchives> getChildArchList();
	public void setArchivesKey(String archivesKey);
	public String print();
	public void iterateChild(List<ITerminalArchives> list);
}
