package me.inox.framework.interactive;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service
public class MessageConvertor {
	private ISerialize serialize;
	private IFormat format;

	public Object decode(Object source) {
		if (format != null) {
			return this.format.decode(this.serialize.decode(source));
		} else {
			return this.serialize.decode(source);
		}

	}

	public Object encode(Object source) {
		if (format != null) {
			return this.serialize.encode(this.format.encode(source));
		} else {
			return this.serialize.encode(source);
		}
	}

	
	public void setSerialize(ISerialize serialize) {
		this.serialize = serialize;
	}


	public void setFormat(IFormat format) {
		this.format = format;
	}
}
