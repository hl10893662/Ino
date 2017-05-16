package me.inox.framework.model.protocol;

import java.util.ArrayList;
import java.util.List;

public class ForDeCodeStructList implements ImessageList{
	private List<ForDeCodeStruct> struct;
	private String nodeId;
	public ForDeCodeStructList() {
		// TODO Auto-generated constructor stub
		struct = new ArrayList<ForDeCodeStruct>();
	}
	public List<ForDeCodeStruct> getStruct() {
		return struct;
	}
	public void setStruct(List<ForDeCodeStruct> struct) {
		this.struct = struct;
	}
	public String getNodeId() {
		return nodeId;
	}
	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}
	@Override
	public void addMessage(Object obj) {
		// TODO Auto-generated method stub
		struct.add((ForDeCodeStruct) obj);
	}
	
}
