package priv.rsl.IO_1;
/*
通过缓冲区来拷贝文件：

*/
import java.io.*;
class CopTextByBuf 
{
	public static void main(String[] args) 
	{
		//外部定义缓冲对象的引用
		BufferedWriter bufw = null;
		BufferedReader bufr = null;
		try
		{
			//创建缓冲流对象，指定文件
			bufw = new BufferedWriter(new FileWriter("copy_by_buf.txt"));
			bufr = new BufferedReader(new FileReader("CopTextByBuf.java"));
			
			//readLine()方法返回的是一行里的有效字符，并不返回回车符
			//在外部定义引用，while作为循环：
			String line = null;
			
			//当line不是null的时候，就没有到末尾
			while ((line = bufr.readLine())!=null)
			{
				//将这一行写入缓冲流
				bufw.write(line);
				
				//写一行就要写入一个换行符，利于显示和阅读
				bufw.newLine();
				
				//用到缓冲就要用flush()
				bufw.flush();
			}
		}
		catch (IOException e)
		{
			throw new RuntimeException("读写失败！");
		}

		//关闭流资源，关闭缓冲区的流就可以了
		finally 
		{
			try
			{
				//判断下的目的是确保流创建成功了才能执行关闭操作
				if(bufw!=null)
					bufw.close();
			}
			catch (IOException e)
			{
				throw new RuntimeException("关闭写入流失败！");
			}

			//要分开try和catch
			try
			{
				//判断下的目的是确保流创建成功了才能执行关闭操作
				if(bufr!=null)
					bufr.close();
			}
			catch (IOException e)
			{
				throw new RuntimeException("关闭读取流失败！");
			}

		}
		
	}
}
