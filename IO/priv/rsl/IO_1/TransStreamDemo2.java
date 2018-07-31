package priv.rsl.IO_1;
/*
改变标准输入输出设备，小插曲，不常用

*/

import java.io.*;
class TransStreamDemo2
{
	public static void main(String[] args) throws IOException
	{
		//更改键盘源：
		System.setIn(new FileInputStream("BufferedWriterDemo.java"));

		//更改输出设备：
		System.setOut(new PrintStream("zz.txt"));

		//两个同时更改就是复制文件：将BufferedWriterDemo.java复制到zz.txt

		//获取键盘录入对象，键盘录入最常见写法
		BufferedReader bufr = 
			new BufferedReader(new InputStreamReader(System.in));
		//写文件(字符转化为字节)
		BufferedWriter bufw =
			new BufferedWriter(new OutputStreamWriter(System.out));//创建文件，写入的目标
		
		String line = null;
		while((line=bufr.readLine())!=null)//BufferedReader的readLine方法
		{
			if("over".equals(line))
				break;
			//写的方法要刷新
			bufw.write(line.toUpperCase());
			//如果要求跨平台的换行符，则要用BufferedWriter方法里面的newLine()方法
			bufw.newLine();
			//flush
			bufw.flush();
		}
		bufr.close();
	}
}
