package priv.rsl.IO_3;
/*
GBK��utf-8����ĵط���
����ͨ���������ֵ�GBK����ǡ�÷���utf-8�Ľ�����ʽ


ע��utf-8�Ľ�����ʽ�Ѿ���ͼ�����ڵ�ǰĿ¼��
utf-8���룺������һ���ֽڱ�ʾ�ַ��������������ֽڱ�ʾ�ַ��������������ֽ�
���ȷ���Ƕ�һ�����Ƕ�����������������Ϊ����ͷλ����ʶ��
*/

import java.io.*;
class EncodeDemo2 
{
	public static void main(String[] args) throws Exception
	{
		//��ʾ��ͨ�����⣺
		String s= "��ͨ";

		byte[] by = s.getBytes("GBK");

		for(byte b : by)
		{
			//��ӡÿ������������ֽڵ����8λ
			System.out.println(Integer.toBinaryString(b&255));
		}
	}

	
}
/*
11000001
10101010
11001101
10101000
ǡ�÷���utf-8�ı������


*/
