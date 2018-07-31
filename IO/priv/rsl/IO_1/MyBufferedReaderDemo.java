package priv.rsl.IO_1;
/*
自定义装饰类：

根据BufferedReader的readLine()原理后
自己实现一个与其同样的功能的MyBufferedReader

那么MyBufferedReader就是一个装饰类了

但是如何让装饰一组类（指不是一个类如FileReader）?

方法：构造函数里传递父类：如FileReader 的父类Reader
		再让这个装饰类成为父类的一个子类：extends 父类


*/

import java.io.*;

class MyBufferedReader extends Reader//继承抽象类就要复写抽象方法了
{
	//构造函数传递的参数变为父类：Reader r
	private Reader r;
	MyBufferedReader(Reader r)
	{
		this.r = r;
	}

	//写一个一次读一行的方法：
	public String MyReadLine() throws IOException
	{
		//读一行返回的是字符串，定义一个字符数组用来临时存储读取的一行数据
		//为了便于演示，这里创建StringBuilder容器
		StringBuilder sb = new StringBuilder();

		//原readLine方法基于的是read()读取一个字符的方法，这里同样如此
		//定义一个int型变量记录read的返回值作为循环条件
		int ch = 0;
		while((ch=r.read())!=-1)
		{
			//当次字符是'\r'的时候就不存，继续循环
			if(ch=='\r')
				continue;

			//当此字符是'\n'的时候就返回此时容器中的字符串
			if(ch=='\n')
				return sb.toString();

			//如果是正常字符，将此字符添加到容器中，不返回
			else
			sb.append((char)ch);
		}

		//当读一行的末尾，但是又没有换行符的时候（末尾处），返回
		if(sb.length()!=0)
			return sb.toString();

		//当到文末，就返回null
		return null;
	}
	//继承了抽象类就要复写其中的抽象方法：
	public void close() throws IOException
	{
		r.close();
	}

	//复写二：
	public int read(char[] cbuf, int off, int len) throws IOException
	{
		return r.read(cbuf, off, len);
	}

	//定义我的自己关闭流资源的方法：
	public void MyClose() throws IOException
	{
		r.close();
	}
}


class MyBufferedReaderDemo 
{
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException
	{
		//外部定义缓冲对象的引用
		MyBufferedReader bufr = null;
		try
		{
			//创建缓冲流对象，指定文件
			bufr = new MyBufferedReader(new FileReader("MyBufferedReaderDemo.java"));
			
			//readLine()方法返回的是一行里的有效字符，并不返回回车符
			//在外部定义引用，while作为循环：
			String line = null;
			
			//当line不是null的时候，就没有到末尾
			while ((line = bufr.MyReadLine())!=null)
			{
				System.out.println(line);
			}
		}
		catch (IOException e)
		{
			throw new RuntimeException("读取失败！");
		}

		//关闭流资源，关闭缓冲区的流就可以了
		finally 
		{
			try
			{
				//判断下的目的是确保流创建成功了才能执行关闭操作
				if(bufr!=null)
					bufr.MyClose();
			}
			catch (IOException e)
			{
				throw new RuntimeException("关闭读取流失败！");
			}

		}
	}
}
