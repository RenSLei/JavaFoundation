package priv.rsl.object_oriented2;
/*
��̬����飺
��ʽ:
static
{
	��̬������е�ִ����䡣
}

�ص㣺������ļ��ض�ִ�У�ִֻ��һ��,��������������ִ�С�
���ڸ�����г�ʼ���ġ�

*/
class StaticCode
{
	static
	{
		System.out.println("a");
	}
}

class StaticCodeDemo
{
	static
	{
		System.out.println("b");
	}
	public static void main(String[] args) 
	{
		new StaticCode();/*��StaticCodeDemo�����ؽ��ڴ棬����ִ��StaticCodeDemo�еľ�̬�����
							��ӡb,�ٴ�ӡc������ִ�����������������У���StaticCode�����ؽ��ڴ棬
							����ִ��StaticCode�еľ�̬����飬��ӡa��*/
		new StaticCode();//ע�⣬��һ�������ؽ��ڴ�󣬾Ͳ��ٳ�ʼ�������ˣ���˴�ӡ����ǣ�c b a
		System.out.println("Hello World!");
	}
	static
	{
		System.out.println("c");
	}
}
//��˴�ӡ�����:

