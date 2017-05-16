package me.inox.framework.model.protocol;

import java.util.List;

public interface IFrameInfo {
	
	public final static int SINGLEFRAME = 0; //单帧
	
	public final static int HEADFRAME = 1; //多帧第一帧
	
	public final static int MIDFRAME = 2; //多帧中间帧
	
	public final static int TAILFRAME = 3; //多帧结束帧
	
	public void addMultiFrame(byte[] byteArray);
	
	public byte[] getByteArray();

	public void setByteArray(byte[] byteArray);

	public int getLocation();

	public void setLocation(int location);

	public int getRseq();

	public void setRseq(int rseq);

	public List<byte[]> getMultiFrames();

	public void setMultiFrames(List<byte[]> multiFrames);
	
	public String getProtocolType();

	public void setProtocolType(String protocolType);
}
