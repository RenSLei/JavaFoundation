package priv.rsl.IO_1;
/*
通过刚刚的例子：通过键盘录入一行再打印一行的代码，发现就是一次读一行的方法
也就是readLine方法

能不能直接使用readLine方法呢？

readLine方法是字符流BufferedReader类中的方法

而键盘录入的read方法是字节流InputStream的方法

那么，能不能将字节流转成字符流再使用缓冲区的readLine方法呢

*/

import java.io.*;
class TransStreamDemo
{
	public static void main(String[] args) throws IOException
	{
		/*
		//获取键盘录入对象
		InputStream in = System.in;

		//将 字节流 对象转成 字符流 对象使用 InputStreamReader 转换流,并将录入对象传进来
		InputStreamReader isr = new InputStreamReader(in);
		
		//提高效率，将字符串进行缓冲区技术高效操作。考虑在 BufferedReader 内包装 InputStreamReader
		BufferedReader bufr = new BufferedReader(isr);
		*/

		//以上三句话写成一句话：***_____*****重点：：
		BufferedReader bufr = 
			new BufferedReader(new InputStreamReader(System.in));//键盘录入最常见写法
		
		

		/*
		//同样演示字符流转为字节流的OutputStreamWriter
		OutputStream out = System.out;

		//将 字符流 对象转成 字节流 对象使用 OutputStreamWriter 转换流,并将录入对象传进来
		OutputStreamWriter osw = new OutputStreamWriter(out);
		
		//提高效率，将字符串进行缓冲区技术高效操作。考虑在 BufferedWriter 内包装 OutputStreamWriter
		BufferedWriter bufw = new BufferedWriter(osw);

		*/
		//写成一句话：
		BufferedWriter bufw =
			new BufferedWriter(new OutputStreamWriter(System.out));
		
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

/*
运行结果：
dfhdfhadh
DFHDFHADH
hfdhadfh
HFDHADFH
abfkja
ABFKJA
sdag
SDAG
ga
GA
*/
