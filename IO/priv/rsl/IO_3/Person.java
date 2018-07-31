package priv.rsl.IO_3;
/*


*/

import java.io.*;
//只能将支持 java.io.Serializable 接口的对象写入流中。
//序列化接口没有方法或字段，仅用于标识可序列化的语义
class Person implements Serializable
{
	//将这个类的UID值固定，当成员变化时，还能读取该类序列化后的对象
	static final long serialVersionUID = 42L;

	String name;
	
	String country;
	//static String country;
	//注：静态是不能被序列化的

	//如果对非静态的成员也不想将其序列化，则用关键词修饰：
	 transient int age;
	//写构造函数：
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
