package priv.rsl.object_oriented6;

/*
Ϊ�˼���������д��ʹ��һ���ؼ��֣�import
import  ������ǰ��е���

����ĳ�����кܶ��࣬����������룬Ҳ������ͨ��� * ȫ������
����ʵ�ʿ����в�������*��Ϊռ�ڴ�ϴ�

���絼��������Բ�ͬ������������ʱ��������Ӱ�����





*/

class  PackageDemo
{
	public static void main(String[] args) 
	{
	    priv.rsl.object_oriented6.DemoA d = new priv.rsl.object_oriented6.DemoA();//ע�������ǰ���.����
		d.show();
		//packb.DemoB p = new packb.DemoB();//ע��ֻ��������ſ��Է���method;
		//p.method();
	}
}

/*
ע�⣺
	1�������ʱ��
		1)����Ѱ����ڵ�ǰĿ¼�ã�javac -d . ����(PackageDemo).java
		2������Ѱ�����ָ��Ŀ¼�ã�javac -d ָ��Ŀ¼·�� ����(PackageDemo).java
	2�����У�
		java ����.����
	3�����ĳ���ʹjavaԴ�ļ��������ļ�����롣
*/
