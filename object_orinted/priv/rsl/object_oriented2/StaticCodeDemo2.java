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
class StaticCode2
{
	int num=9;//�����ԣ��Ǿ�̬����ʼ����������Ե�
	/*���캯��һ���ǳ�ʼ������ģ���Ϊû�д�������֮��Ӧ�Ķ���,���Բ����ӡb*/
	StaticCode2()
	{
		System.out.println("b");
	}
	/*��̬����飬�ǳ�ʼ����ģ���Ϊ������һ����������,���������أ����Ի��ӡa*/
	static
	{
		System.out.println("a");
		//System.out.println("a"+num);//�����ᱨ��ԭ���Ǿ�ֻ̬�ܷ��ʾ�̬�����ܷ��ʷǾ�̬��
	}
	/*�������飬�ǳ�ʼ������ģ���Ϊ������һ����������,���������أ����Ի��ӡc,�ҿ��Է���num*/
	{
		System.out.println("c"+num);
	}
	/*���캯�������ǹ��캯��һ�����أ��ǳ�ʼ������ģ���Ϊ������һ����֮��Ӧ����������,���������أ����Ի��ӡd*/
	StaticCode2(int x)
	{
		System.out.println("d");
	}
	/*��̬����,ע�⣺���ڷ���������ͨ������ֱ�ӵ��ã�Ҳ�����ý����Ķ�����ã���Ϊ��̬�Ǳ����ж���������Ϊû�б����ã����Բ��ᱻִ��*/
	public static void show()
	{
		System.out.println("show run");
	}
}

class StaticCodeDemo2
{
	/*��̬����飬�ǳ�ʼ����ģ���ִ��java StaticCodeDemo2ʱ������ͱ������ˣ����Ի����ȴ�ӡe*/
	static
	{
		System.out.println("e");
	}
	public static void main(String[] args) 
	{
		new StaticCode2(4);
	}
	
}

