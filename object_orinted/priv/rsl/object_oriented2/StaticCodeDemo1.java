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
class StaticCode1
{
	static
	{
		System.out.println("a");
	}
	public static void show()
	{
		System.out.println("show run");
	}
}

class StaticCodeDemo1
{
	
	public static void main(String[] args) 
	{
		StaticCode1.show();/*���������þ�̬��������ʱ���еľ�̬���������𣿴��Ǽ��ء�
							��Ϊ���о�̬����һ�������ã�ע���ʱû�ж��󣩣��൱�ڸ��౻���أ�
							�������ھ�̬�����ĸ����ʼ�����ԣ�������ض�����*/
		StaticCode1 s =null;/*��ʱ��StaticCode1����������û�С�
							��Ϊ����sû�о����ʵ��ָ��*/
		s=new StaticCode1();/*��ʱ��StaticCode1�ͱ������ˣ���Ϊ����˵����һ��Ĭ�ϳ�ʼ�����캯��StaticCode(){},����൱���������ݱ�ʹ�ã�
							���Ծ�̬����鱻����
							Ϊʲôִ�н���� a show run   ��Ϊ��̬�����ִֻ��һ�Σ�main�е�һ�д����Ѿ���������ˣ������൱�ڵڶ��͵�����û��
							���ؾ�̬����飬���û�е�һ�д��룬��ִ�н��Ϊ:a*/

	}
	
}

