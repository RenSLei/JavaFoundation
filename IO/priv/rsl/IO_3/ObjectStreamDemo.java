package priv.rsl.IO_3;
/*
�����������л�����������־û��洢��Ӳ����ȥ��

1�������д����
�õ���IO�������ObjectOutputStream�ࣺ
ObjectOutputStream �� Java ����Ļ����������ͺ�ͼ��д�� OutputStream

���췽����ObjectOutputStream(OutputStream out) 

java.lang.Object
  �̳��� java.io.OutputStream
      �̳��� java.io.ObjectOutputStream

д�ķ�����writeObject(Object obj) 


2����ȡ����Ļ��ã�
ObjectOutputStream �� ObjectInputStream �ֱ��� FileOutputStream �� FileInputStream һ��ʹ��ʱ������ΪӦ�ó����ṩ�Զ���ͼ�εĳ־ô洢��

���췽����ObjectInputStream(InputStream out) 

java.lang.Object
  �̳��� java.io.InputStream
      �̳��� java.io.ObjectInputStream

���ķ�����readObject() 
ֻ��֧�� java.io.Serializable �� java.io.Externalizable �ӿڵĶ�����ܴ�����ȡ��
*/

import java.io.*;
class ObjectStreamDemo
{
	public static void main(String[] args) throws Exception
	{
		writeObj();
		//readObj();
	}

	//һ�����Խ�����־û��洢�ķ���
	public static void writeObj() throws IOException
	{
		//ʹ��������IO�������ObjectOuputStream�����writeObject()����

		ObjectOutputStream oos = 
			new ObjectOutputStream (new FileOutputStream("obj.txt"));

		oos.writeObject(new Person("zhangsan",55,"kr"));

		oos.close();
	}

	//һ�����Զ�ȡ����ķ���
	public static void readObj() throws Exception
	{
		//ʹ��������IO�������ObjectInputStream�����readObject()����

		ObjectInputStream ois = 
			new ObjectInputStream (new FileInputStream("obj.txt"));

		Person p = (Person)ois.readObject();
		System.out.println(p);
		ois.close();
	}
}
