package me.inox.framework.model.xml;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XmlNodeStruction {
	private String tagName="";
	private String key="";
	private Map<String,String> attrMap;
	private List<XmlNodeStruction> childList;
	private int index;
	

	public XmlNodeStruction(){
		attrMap = new HashMap<String,String>();
		childList = new ArrayList<XmlNodeStruction>();
	}
	/**
	 * �ж��������Ƿ���ָ������
	 * @param key
	 * @return
	 */	
	public  boolean isExistAttribute(String key){
		if(attrMap.get(key)==null)
			return false;
		return true;
	}
	/**
	 * �������
	 */
	public String getAttribute(String key){
		return attrMap.get(key);
	}
	/**
	 * �Ƿ����ӽڵ�
	 */
	public boolean isHasNode(){
		if(childList.size()>0){
			return true;
		}
		return false;
	}
	/**
	 *�Ƿ����ָ���ӽڵ� 
	 */
	public boolean isExistNode(String key){
		if(isHasNode()){
			for(XmlNodeStruction node:childList){
				if(node.getKey().equals(key))
					return true;
			}
		}
		return false;
	}
	/**
	 * ���ָ���ӽڵ�
	 */
	public XmlNodeStruction getNode(String key){
		if(isHasNode()){
			for(XmlNodeStruction node:childList){
				if(node.getKey().equals(key))
					return node;
			}
		}
		return null;		
	}
	/**
	 * ���ָ��Ԫ�����͵��ӽڵ�
	 * @return
	 */
	public List<XmlNodeStruction> getChildByTagName(String tagName){
		List<XmlNodeStruction> list = new ArrayList<XmlNodeStruction>();
		if(isHasNode()){
			for(XmlNodeStruction node:childList){
				if(node.getTagName().equals(tagName))
					list.add(node);
			}
		}
		return list;	
	}
	public String getTagName() {
		return tagName;
	}
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public Map<String, String> getAttrMap() {
		return attrMap;
	}
	public void setAttrMap(Map<String, String> attrMap) {
		this.attrMap = attrMap;
	}
	public List<XmlNodeStruction> getChildList() {
		return childList;
	}
	public void setChildList(List<XmlNodeStruction> childList) {
		this.childList = childList;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	
}
