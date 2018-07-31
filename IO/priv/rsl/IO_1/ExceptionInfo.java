package priv.rsl.IO_1;
/*
建立异常的日志信息：
建立一个异常信息，将该信息写到指定的文件中去，并带上时间

*/
//导包
import java.io.*;
import java.util.*;//Date包
import java.text.*;//格式化时间的类属于此包

class ExceptionInfo
{
	public static void main(String[] args) 
	{
		//制造一个简单的异常信息
		try
		{
			int[] arr = new int[2];
			System.out.println(arr[3]);
		}
		catch (Exception e)
		{
			//如何将异常信息存储到指定文件中呢？
			//首先定义日期：
			try
			{
				Date d = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd E HH:mm:ss");
				String time = sdf.format(d);

				//建立PrintStream对象
				PrintStream ps = new PrintStream("exception.log");
				ps.println(time);
				System.setOut(ps);//改变输出设备，不是控制台是硬盘
			}
			catch (IOException ex)
			{
				throw new RuntimeException("日志文件创建失败！");
			}

			e.printStackTrace(System.out);//Throwable里的printStackTrace允许接受一个输出流PrintStream
		}
	}
}
//网上建立Java异常信息的工具包：log4j
