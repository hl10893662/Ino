package me.inox.framework.model.protocol;

import java.io.Serializable;
/**
 * DecodedReason---0����֡�ɹ���1����Լ������:2�����ݳ��� 3������Ч���� 4������
 * EncodedReason--- 0����֡�ɹ� 1����֡ʧ��
 * @author Administrator
 *
 */
public interface IReason extends Serializable{
	
   int getCode();
   
   Object getContent(int code);
   
}
