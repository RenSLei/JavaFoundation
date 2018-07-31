package priv.rsl.IO_3;
/*
���룺�ַ�������ֽ�����

���룺�ֽ��������ַ���

String ----->byte[]  ������str.getBytes(charsetName);

byte---->String�� ������new String(byte[],charsetName);


*/

import java.util.*;
class EncodeDemo 
{
	public static void main(String[] args) throws Exception
	{
		//encode_1();
		//encode_2();
		encode_3();
		
	}

	public static void encode_1() throws Exception//��ʾ�������Ĺ���
	{
		String s = "���";
		
		//���ַ�������Ϊ�ֽ�����
		byte[] b1 = s.getBytes("GBK");//����GBK����,��ʵĬ���ǰ���GBK������ġ�
		
		//���� ��
		String s1 = new String(b1,"GBK");//ע�⣺��ʲô��ľ���ʲôȥ���룬��������

		System.out.println(s1);

		//�ù��߰��е�Arrays��toString�������ֽ������е��������ַ�������ʽ���֣�
		//System.out.println(Arrays.toString(b1));//[-60, -29, -70, -61]


	}

	public static void encode_2() throws Exception//������ȷ���������δ���
	{
		String s = "���";
		
		//���ַ�������Ϊ�ֽ�����
		byte[] b1 = s.getBytes("GBK");//����GBK����,��ʵĬ���ǰ���GBK������ġ�
		
		//�������ױ��������ʲô���ݣ�
		System.out.println(Arrays.toString(b1));

		//���� ��
		String s1 = new String(b1,"iso8859-1");//����ŷ����������룬��Ȼ�����룬��ʱ��ô�죿
		
		//��ӡһ��������ַ�
		System.out.println("s1="+s1);
		
		//��ʱ�ͽ������s1���ô�������iso8859-1������,�ҵ�������ֽڣ�������ȷ�����ȥ����
		byte[] b2 = s1.getBytes("iso8859-1");

		//�����Ƿ���ԭ������ֵ
		System.out.println(Arrays.toString(b2));
		
		//���룺
		String s2 = new String(b2,"GBK");

		System.out.println("s2="+s2);

		/*
		[-60, -29, -70, -61]
		s1=????
		[-60, -29, -70, -61]
		s2=���
		*/

	}

		public static void encode_3() throws Exception//���⣺�����һ��ͬ����ʶ�����ĵ�����������
	{
		String s = "���";
		
		//���ַ�������Ϊ�ֽ�����
		byte[] b1 = s.getBytes("GBK");//����GBK����
		
		//�������ױ��������ʲô���ݣ�
		System.out.println(Arrays.toString(b1));

		//���� ��
		String s1 = new String(b1,"utf-8");//����utf-8���������
		
		//��ӡһ��������ַ�
		System.out.println("s1="+s1);
		
		//��ʱ�ͽ������s1���ô�������utf-8������,�ҵ�������ֽڣ�������ȷ�����ȥ����
		byte[] b2 = s1.getBytes("utf-8");

		//�����Ƿ���ԭ������ֵ
		System.out.println(Arrays.toString(b2));//ʵ�ʲ���ԭ�����ֽ����飬Ϊʲô����Ϊutf-8Ҳʶ������
		
		//�ٽ���͵ò���ԭ���������ˣ�
		String s2 = new String(b2,"GBK");

		System.out.println("s2="+s2);

		/*
		[-60, -29, -70, -61]
		s1=???
		[-17, -65, -67, -17, -65, -67, -17, -65, -67]
		s2=���?


		������s1����utf-8���������ģ�������utf-8ȥ�����ʱ��
		����utf-8��s1���������ģ��ͽ���˺�ԭ����һ�����ֽ�
		*/

	}


}
