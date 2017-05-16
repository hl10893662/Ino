package me.inox.framework.model.terminal;

import java.io.Serializable;
import java.util.List;

import me.inox.framework.model.protocol.ProtocolInfo;

public interface ITerminalArchives extends Serializable{
	// ������������Ψһֵ key
	public String getKey();
	
	public ITerminalIdentity getTerminalIdentity();
	
	public ProtocolInfo getProtocolInfo();

	// ����������������ֵ
	public String getValue(String propertyName);
	// �������������ӵ���
	public ITerminalArchives getArchives(String childArchiveKey);

	// ��������������ĳ�����͵ĵ����б�
	public List<ITerminalArchives> getArchList(String dataType);

	// ���һ������
	public void setValue(String key, String value);

	// ���һ���ӵ���
	public void setArchives(String key, ITerminalArchives prof);
	//��������ӽڵ�
	public List<ITerminalArchives> getChildArchList();
	public void setArchivesKey(String archivesKey);
	public String print();
	public void iterateChild(List<ITerminalArchives> list);
}
