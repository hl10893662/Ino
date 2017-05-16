package me.inox.framework.tools.util;

import java.io.InputStream;
import java.io.StringReader;
import java.util.List;
import java.util.StringTokenizer;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class XmlParse {
	SAXReader reader;
	static SAXReader staticReader = new SAXReader();
	private static Logger logger = Logger.getLogger(XmlParse.class);

	@PostConstruct
	public void init() {
		reader = new SAXReader();
	}

	// 获取根节点
	public Element getRootElement(InputStream fileName)
			throws DocumentException {
		if (reader == null)
			reader = new SAXReader();
		return reader.read(fileName).getRootElement();
	}

	// 获取根节点
	public Element getRootElement(String dataUnit) throws DocumentException {

		return DocumentHelper.parseText(dataUnit).getRootElement();// reader.read(new
																	// StringReader(dataUnit)).getRootElement();
	}

	// 静态获取根节点方法
	public static Element getStaticRootElement(String dataUnit)
			throws DocumentException {
		return staticReader.read(new StringReader(dataUnit)).getRootElement();
	}

	public static String getValue(String source, String name, String path) {
		String value = null;
		if (path == null)
			path = "";
		StringTokenizer token = new StringTokenizer(path, "/");
		int count = token.countTokens() + 1;
		String[] paths = new String[count];
		int n = 0;
		while (token.hasMoreTokens()) {
			paths[n++] = token.nextToken();
		}
		paths[n] = name;
		int startIndex = 0;
		for (String p : paths) {
			String pathValue = "<" + p + ">";
			startIndex = source.indexOf(pathValue);
			if (startIndex == -1) {
				return null;
			}
			source = source.substring(startIndex + pathValue.length(),
					source.length() - 1);
		}
		String end = "</" + name + ">";
		int endIndex = source.indexOf(end);
		if ((startIndex >= 0) && (endIndex >= 0)) {
			value = source.substring(0, endIndex);
		}
		return value;
	}

	// 根据路径取得相对应的值
	public String getValue(Element elt, String name, String path) {
		String value = "";
		// long time1 = System.currentTimeMillis();
		String[] paths = path.split("/");
		if (paths != null && paths.length == 2) {
			Element e = elt.element(name);
			if (e == null) {
				return null;
			} else
				return e.getText();
		}
		int length = paths.length;
		for (int i = 0; i < length; i++) {
			if (elt.getName().equals(paths[i])) {
				List lt = elt.elements();
				int ltSize = lt.size();
				for (int n = 0; n < ltSize; n++) {
					Element e = (Element) lt.get(n);
					if (i < paths.length - 1
							&& e.getName().equals(paths[i + 1])) {
						elt = e;
						break;
					}
				}
			}
		}
		List lst = elt.elements();
		int size = lst.size();
		for (int i = 0; i < size; i++) {
			Element e = (Element) lst.get(i);
			if (e.getName().equals(name)) {
				value = e.getText();
				break;
			}
		}
		return value;
	}

}
