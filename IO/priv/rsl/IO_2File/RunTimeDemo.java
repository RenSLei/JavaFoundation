package priv.rsl.IO_2File;

/*
用于记录应用程序运行次数，
如果使用次数已到，那么给出注册提示。

想到的是计数器。
可是该计数器定义在程序中，随着程序的运行而在内存中存在，并进行自增
随着程序的退出，该计数器也在内存中消失

下一次在启动该程序时，又重新开始从0计数
这样不是我们想要的

程序即使结束，该计数器的值也存在
下次程序再起动会先加载该计数器的值并加一后重新存储起来

所以要建立一个配置文件，用于记录该软件的使用次数

该配置文件使用键值对的形式这样便于阅读数据和操作数据

键值对数据是map集合
数据是以文件形式存储，使用io技术
那么io+map--->properties

配置文件可以实现应用程序数据的共享
*/

import java.util.*;
import java.io.*;
class  RunTimeDemo
{
	public static void main(String[] args) throws IOException
	{
		//创建properties对象
		Properties prop = new Properties();

		//将要操作的文件创建成对象
		//在当前目录创建一个想要操作的文本文件
		File file = new File("RunTime.ini");

		//想要讲prop和流对象关联起来，想到FileInputStream
		//但是在关联文件的时候最好先确保有文件
		if (!file.exists())
		{
			file.createNewFile();
		}

		//关联文件

		FileInputStream fis = new FileInputStream(file);
		
		//将读取流传递到load方法中
		prop.load(fis);
		
		//定义一个计数器
		int count = 0;
		
		String value = prop.getProperty("time");

		//获取一个指定的键的值
		if(value!=null)
		{
			//将值赋给count
			count = Integer.parseInt(value);

			//判断一下count的条件
			if (count>=5)
			{
				sop("程序使用次数已经用完！请注册！");
				return;
			}
			
		}

		count++;

		prop.setProperty("time",count+"");

		//使用store方法，将更改信息保存到文件中

		FileOutputStream fos = new FileOutputStream(file);

		prop.store(fos,"");


		//关闭流资源
		fos.close();
		fis.close();




	}
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
}
