package priv.rsl.IO_3;
/*
讲解对象的序列化：即将对象持久化存储到硬盘中去：

1、存对象（写）：
用的是IO包里面的ObjectOutputStream类：
ObjectOutputStream 将 Java 对象的基本数据类型和图形写入 OutputStream

构造方法：ObjectOutputStream(OutputStream out) 

java.lang.Object
  继承者 java.io.OutputStream
      继承者 java.io.ObjectOutputStream

写的方法：writeObject(Object obj) 


2、读取对象的话用：
ObjectOutputStream 和 ObjectInputStream 分别与 FileOutputStream 和 FileInputStream 一起使用时，可以为应用程序提供对对象图形的持久存储。

构造方法：ObjectInputStream(InputStream out) 

java.lang.Object
  继承者 java.io.InputStream
      继承者 java.io.ObjectInputStream

读的方法：readObject() 
只有支持 java.io.Serializable 或 java.io.Externalizable 接口的对象才能从流读取。
*/

import java.io.*;
class ObjectStreamDemo
{
	public static void main(String[] args) throws Exception
	{
		writeObj();
		//readObj();
	}

	//一个可以将对象持久化存储的方法
	public static void writeObj() throws IOException
	{
		//使用流对象：IO包里面的ObjectOuputStream对象的writeObject()方法

		ObjectOutputStream oos = 
			new ObjectOutputStream (new FileOutputStream("obj.txt"));

		oos.writeObject(new Person("zhangsan",55,"kr"));

		oos.close();
	}

	//一个可以读取对象的方法
	public static void readObj() throws Exception
	{
		//使用流对象：IO包里面的ObjectInputStream对象的readObject()方法

		ObjectInputStream ois = 
			new ObjectInputStream (new FileInputStream("obj.txt"));

		Person p = (Person)ois.readObject();
		System.out.println(p);
		ois.close();
	}
}
