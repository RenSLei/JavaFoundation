package priv.rsl.other_object;
/*
System类：System 类包含一些有用的类字段和方法。它不能被实例化。
1，System类里面的方法以及属性都是静态的；
2，out:标准输出，默认是控制台；
3，in：标准输入，默认是键盘；

其中有描述系统信息：

获取系统属性信息：Properties getProperties();
确定当前的系统属性

*/

import java.util.*;
class SystemDemo
{
	public static void main(String[] args) 
	{
		Properties prop = System.getProperties();
		/*
		通过查阅API可以知道Properties:
		java.lang.Object
  继承者 java.util.Dictionary<K,V>
      继承者 java.util.Hashtable<Object,Object>
          继承者 java.util.Properties

		  可以看到它继承了HashTable,也就是Map集合的一个子类对象
		  所以它里面是以键值对形式存储的信息，所以可以通过Map里的取出方法来获取信息
		  一个是keySet，一个是entrySet

		  另，该集合中都是字符串，没有定义泛型
		*/

		/*
		//如何自定义一些属性信息呢？
		System.setProperty("one","1");

		//获取所有属性信息，用增强for来遍历：
		for(Object obj : prop.keySet())
		{
			String value = (String)prop.get(obj);
			System.out.println(obj+"--->"+value);
		}
		*/

		//获取指定键所对应的属性信息：
		sop("计算机名："+System.getProperty("user.name"));
		sop("操作系统："+System.getProperty("os.name"));

		//如何在JVM启动的时候，动态加载一些属性信息？
		sop(System.getProperty("renshilei"));//若没有这个键对应值，则为null
		/*
		运行时动态加载：
		F:\OneDrive\java\day18_其他对象、IO流>java -Drenshilei=男 SystemDemo
		计算机名：computer-rsl
		操作系统：Windows 10
		男
		*/



		//System.out.println("Hello World!");
	}

	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
}
