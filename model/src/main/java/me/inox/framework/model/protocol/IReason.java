package me.inox.framework.model.protocol;

import java.io.Serializable;
/**
 * DecodedReason---0：解帧成功：1：规约不兼容:2：数据出错 3：无有效数据 4：其它
 * EncodedReason--- 0：组帧成功 1：组帧失败
 * @author Administrator
 *
 */
public interface IReason extends Serializable{
	
   int getCode();
   
   Object getContent(int code);
   
}
