package me.inox.framework.model.protocol;

import java.io.Serializable;
import java.util.List;

public class EnCodeStructList implements Serializable{

	private static final long serialVersionUID = 6050043511448359681L;

	private List<EnCodedStruct> enCodedStructs;
	private String nodeId;
	public EnCodeStructList(){
		
	}
	public EnCodeStructList( List<EnCodedStruct> enCodedStructs,String nodeId){
		 this.enCodedStructs = enCodedStructs;
		 this.nodeId = nodeId;
	 }
	public List<EnCodedStruct> getEnCodedStructs() {
		return enCodedStructs;
	}
	public String getNodeId() {
		return nodeId;
	}
	public void add(EnCodedStruct struct){
		this.enCodedStructs.add(struct);
	}
	public void setEnCodedStructs(List<EnCodedStruct> enCodedStructs) {
		this.enCodedStructs = enCodedStructs;
	}
	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}
	
}
