package priv.rsl.IO_3;
/*


*/

import java.io.*;
//ֻ�ܽ�֧�� java.io.Serializable �ӿڵĶ���д�����С�
//���л��ӿ�û�з������ֶΣ������ڱ�ʶ�����л�������
class Person implements Serializable
{
	//��������UIDֵ�̶�������Ա�仯ʱ�����ܶ�ȡ�������л���Ķ���
	static final long serialVersionUID = 42L;

	String name;
	
	String country;
	//static String country;
	//ע����̬�ǲ��ܱ����л���

	//����ԷǾ�̬�ĳ�ԱҲ���뽫�����л������ùؼ������Σ�
	 transient int age;
	//д���캯����
	Person(String name,int age,String country)
	{
		this.name = name;
		this.age = age;
		this.country = country;
	}

	public String toString()
	{
		return name+":"+age+":"+country;
	}
}
