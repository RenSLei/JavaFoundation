package priv.rsl.IO_1;
/*
读取键盘的录入
System.out:对应的是标准的输出设备，控制台
System.in:对应的是标准的输入设备，键盘

需求：
通过键盘录入数据
当录入一行数据后，就将该行数据进行打印
如果录入的数据是over，那么停止录入

*/

import java.io.*;
class ReadIn 
{
	public static void main(String[] args) throws IOException
	{
		//获取键盘录入对象
		InputStream in = System.in;
		//定义一个缓冲容器,用于存放一行的数据
		StringBuilder sb = new StringBuilder();
		//写循环
		while(true)
		{
			int ch = in.read();
			//如果读到的是'\r',则继续
			if(ch=='\r')
				continue;
			if(ch=='\n')
			{
				//将容器中的数据转换成字符串
				String s = sb.toString();
				//如果字符串是over则结束循环
				if("over".equals(s))
					break;
				System.out.println(s.toUpperCase());
				//每打印一次应该将缓冲区清空
				sb.delete(0,sb.length());
			}
			else
				sb.append((char)ch);
		}

	}
}
