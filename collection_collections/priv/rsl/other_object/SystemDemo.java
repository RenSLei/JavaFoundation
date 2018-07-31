package priv.rsl.other_object;
/*
System�ࣺSystem �����һЩ���õ����ֶκͷ����������ܱ�ʵ������
1��System������ķ����Լ����Զ��Ǿ�̬�ģ�
2��out:��׼�����Ĭ���ǿ���̨��
3��in����׼���룬Ĭ���Ǽ��̣�

����������ϵͳ��Ϣ��

��ȡϵͳ������Ϣ��Properties getProperties();
ȷ����ǰ��ϵͳ����

*/

import java.util.*;
class SystemDemo
{
	public static void main(String[] args) 
	{
		Properties prop = System.getProperties();
		/*
		ͨ������API����֪��Properties:
		java.lang.Object
  �̳��� java.util.Dictionary<K,V>
      �̳��� java.util.Hashtable<Object,Object>
          �̳��� java.util.Properties

		  ���Կ������̳���HashTable,Ҳ����Map���ϵ�һ���������
		  �������������Լ�ֵ����ʽ�洢����Ϣ�����Կ���ͨ��Map���ȡ����������ȡ��Ϣ
		  һ����keySet��һ����entrySet

		  ���ü����ж����ַ�����û�ж��巺��
		*/

		/*
		//����Զ���һЩ������Ϣ�أ�
		System.setProperty("one","1");

		//��ȡ����������Ϣ������ǿfor��������
		for(Object obj : prop.keySet())
		{
			String value = (String)prop.get(obj);
			System.out.println(obj+"--->"+value);
		}
		*/

		//��ȡָ��������Ӧ��������Ϣ��
		sop("���������"+System.getProperty("user.name"));
		sop("����ϵͳ��"+System.getProperty("os.name"));

		//�����JVM������ʱ�򣬶�̬����һЩ������Ϣ��
		sop(System.getProperty("renshilei"));//��û���������Ӧֵ����Ϊnull
		/*
		����ʱ��̬���أ�
		F:\OneDrive\java\day18_��������IO��>java -Drenshilei=�� SystemDemo
		���������computer-rsl
		����ϵͳ��Windows 10
		��
		*/



		//System.out.println("Hello World!");
	}

	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
}
