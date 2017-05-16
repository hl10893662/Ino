package me.inox.framework.tools.util;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Attribute;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import me.inox.framework.model.xml.XmlNodeStruction;


public class XmlUtil {

	public static String getElementTagName(Element element) {
		return element.getName();
	}

	public static String getElementText(Element element, String name) {
		return element.elementText(name);
	}

	public static String getAttributeValue(Element element, String attrName) {
		String value = element.attributeValue(attrName);
		return value == null ? "" : value;
	}

	public static Map<String, String> getAttributeMap(Element element) {
		Map<String, String> map = new HashMap<String, String>();
		for (Iterator<Attribute> it = element.attributeIterator(); it.hasNext();) {
			Attribute attribute = it.next();
			map.put(attribute.getName(), attribute.getValue());
		}
		return map;
	}

	public static XmlNodeStruction toXmlNodeStruction(String fileName)
			throws Exception {
		XmlNodeStruction xmlNode = new XmlNodeStruction();
		SAXReader reader = new SAXReader();
		Element root = reader.read(new FileInputStream(fileName))
				.getRootElement();
		XmlUtil.parseXmlNode(root, xmlNode, 1);
		return xmlNode;
	}

	public static void parseXmlNode(Element element, XmlNodeStruction node,
			int index) {
		node.setTagName(element.getName());
		node.setAttrMap(getAttributeMap(element));
		node.setKey(element.attributeValue("name") != null ? element
				.attributeValue("name") : element.getName());
		node.setIndex(index);
		index++;
		List<XmlNodeStruction> childList = new ArrayList<XmlNodeStruction>();
		for (Iterator<Element> it = element.elementIterator(); it.hasNext();) {
			Element e = it.next();
			XmlNodeStruction child = new XmlNodeStruction();
			parseXmlNode(e, child, index);
			childList.add(child);
		}
		node.setChildList(childList);
	}
}