package priv.rsl.IO_2File;
/*
Properties是hashtable的子类
也就是说它具备map集合的特点，而且它里面存储的键值对都是字符串。不需要泛型
理解：可以将一个文件中键值对读取出来，并且可以更改：增加、修改、保存、获取值

是集合中和IO技术相结合的集合容器

该对象的特点：可以用于键值对形式的配置文件

那么在加载数据时，需要数据有固定的格式：键=值

*/
import java.io.*;
import java.util.*;

class PropertiesDemo 
{
	public static void main(String[] args) throws IOException
	{
		//method_1();
		loadDemo();
	}

	//演示：如何将流中的数据存储到集合中
	//想要将info.txt文件中的键值数据存到集合中进行操作
	/*

	1,用一个流和info.txt相关联
	2,读取一行数据，将该行数据用“=”进行切割
	3，等号左边作为键，右边作为值。存入到Properties集合中即可。

	*/
	//法一：
	public static void method_1() throws IOException
	{
		//首先这是操作文本文档，并想要提高效率的，使用BUfferedReader
		//创建流并和源文件相关联
		BufferedReader bufr = new BufferedReader(new FileReader("info.txt"));

		String line = null;

		Properties prop = new Properties();

		//读取一行数据，并分割
		while((line=bufr.readLine())!=null)
		{
			String[] arr= line.split("=");
			
			//将键和值存入到prop中
			prop.setProperty(arr[0],arr[1]);

		}
		//关闭流
		bufr.close();

		sop(prop);

	}

	//法二(使用load(InputStream inStream))：
	public static void loadDemo() throws IOException
	{
		FileInputStream fis = new FileInputStream("info.txt");
		Properties prop = new Properties();

		prop.load(fis);
		
		//在内存中改变键值信息（但是实际文本值不变）,如果原有的列表里面没有键值，则新建一个键值对，如果有就将此键对应的信息更改
		prop.setProperty("lisi","35235");//输出的是99，但是文本值不变

		//如何将改变的值保存到原始文件中呢？使用store方法
		FileOutputStream fos = new FileOutputStream("info.txt");
		prop.store(fos,"zhushi");//可以验证info.txt文本中的信息已经改变

		sop(prop);
	}


	//设置和获取元素
	public static void setAndGet()
	{
		Properties prop = new Properties();

		prop.setProperty("zhangsan","30");
		prop.setProperty("lisi","40");

		//根据键来获取值
		String value = prop.getProperty("lisi");
		sop(value);

		//重新设置值
		prop.setProperty("lisi","80");

		//获取键的集合并存储到set集合中去，用增强for循环取值
		Set<String> names = prop.stringPropertyNames();
		for(String s:names)
		{
			sop(s+":"+prop.getProperty(s));
		}


	}

	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
}
/*
40
zhangsan:30
lisi:80

*/
