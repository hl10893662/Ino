package me.inox.framework.tools.util;

import org.apache.log4j.Logger;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class HexBytesPrinter {
	private static Logger logger = Logger.getLogger(HexBytesPrinter.class);

	/**
	 * The high digits lookup table.
	 */
	private static final byte[] highDigits;

	/**
	 * The low digits lookup table.
	 */
	private static final byte[] lowDigits;

	/**
	 * Initialize lookup tables.
	 */
	static {
		final byte[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8',
				'9', 'A', 'B', 'C', 'D', 'E', 'F' };

		int i;
		byte[] high = new byte[256];
		byte[] low = new byte[256];

		for (i = 0; i < 256; i++) {
			high[i] = digits[i >>> 4];
			low[i] = digits[i & 0x0F];
		}

		highDigits = high;
		lowDigits = low;
	}

	public void print(Object obj) {
		if (obj instanceof byte[]) {
			byte[] buf = (byte[]) obj;
			StringBuffer sbf = new StringBuffer();
			for (byte b : buf) {
				int byteValue = b & 0xFF;
				sbf.append((char) highDigits[byteValue]);
				sbf.append((char) lowDigits[byteValue]);
				sbf.append(' ');
			}
			logger.info(sbf.toString());
		}
	}

/*	public static void main(String[] args) {
		byte[] buf = { 0x09, 0x1A, 0x12, 0x05 };
		StringBuffer sbf = new StringBuffer();
		for (byte b : buf) {
			sbf.append(" " + Byte.toString(b));
		}
		new HexBytesPrinter().print(buf);
	}*/

	public String getStr(Object obj) {
		if (obj instanceof byte[]) {
			byte[] buf = (byte[]) obj;
			StringBuffer sbf = new StringBuffer();
			for (byte b : buf) {
				int byteValue = b & 0xFF;
				sbf.append((char) highDigits[byteValue]);
				sbf.append((char) lowDigits[byteValue]);
				sbf.append(' ');
			}
		return sbf.toString();
		}
		return "";
	}
	public static void main(String[] args){
		Element e = DocumentHelper.createElement("pack");
		e.addElement("aa");
		e.addElement("bb");
		e.element("aa").setText("k");
		e.element("bb").setText("bbj");
		System.out.println(e.asXML());
		XmlParse xml = new XmlParse();
		String aa=xml.getValue(e.asXML(), "aa", "");
		System.out.println(aa);
	}
}
