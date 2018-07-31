package priv.rsl.string;
/*
�����������Ͷ����װ�ࡣ

byte    Byte        short  Short
int     Integer     long   Long
boolean Boolean     float   Float
double  Double      char    Character

�����������Ͷ����װ����������
�������ڻ����������ͺ��ַ�������֮����ת��

������������ת���ַ����� 
������������+""
������������.toString(������������ֵ)��
�磺Integer.toString(34);//��34�������"34";

�ַ���ת�ɻ����������ͣ�
��̬���÷�ʽ��
xxx a = Xxx.parseXxx(String);
�磺int a = Integer.parseInt("123");
�磺Double b = Double.parseDouble("12.3");

������÷�ʽ��
Integer i = new Integer("123");
int num = i.intValue();


ʮ����ת���������ƣ�
�����������Ͷ���.toBinaryString();
�����������Ͷ���.toHexString();
�����������Ͷ���.toOctalString();

��������ת��ʮ���ƣ�
parseInt(string,radix); 



*/

class  IntegerDemo
{
	public static void sop(String str)
	{
		System.out.println(str);
	}

	public static void main(String[] args) 
	{
		//�������͵����ֵ��
		sop("int max :"+Integer.MAX_VALUE);
		//��һ���ַ���ת��������
		int num = Integer.parseInt("123");//���봫�����ָ�ʽ���ַ�����
		//long x = Long.parseLong("123");
		sop("num="+(num+4));

		sop(Integer.toBinaryString(6));
		sop(Integer.toHexString(60));

		int x = Integer.parseInt("3c",16);
		sop("x="+x);

	}
}
/*
���н����
int max :2147483647
num=127
110
3c
x=60
*/
