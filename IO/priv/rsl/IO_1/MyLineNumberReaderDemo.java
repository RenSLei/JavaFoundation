package priv.rsl.IO_1;
/*
原始的详细的自己的MyLineNumberReader代码：用于对比和说明

java.lang.Object
  继承者 java.io.Reader
      继承者 java.io.BufferedReader
          继承者 java.io.LineNumberReader
基于LineNumberReader的加行号的功能自己写一个实现过程:

需求：定义自己的MyLineNumberReader

*/




import java.io.*;
class MyLineNumberReader
{
	private Reader r;

	private int lineNumber;
	//构造函数
	MyLineNumberReader(Reader r)
	{
		this.r= r;
	}

	//对外提供对MyLn的设置和获取方法
	public void setMyLineNumber(int lineNumber)
	{
		this.lineNumber= lineNumber;
	}

	public int getMyLineNumber()
	{
		return lineNumber;
	}

	//注意到LineNumberReader方法里复写了readLine方法
	//所以我们也要复写
	public String MyReadLine() throws IOException
	{
		//读一次增加一次
		lineNumber++;
		//一次读一行，需要容器
		StringBuilder sb = new StringBuilder();

		int ch = 0;
		while ((ch= r.read())!=-1)
		{
			//先判断下
			if(ch=='\r')
				continue;
			if(ch=='\n')
				return sb.toString();
			else
				sb.append((char)ch);

			
		}
		if(sb.length()!=0)
			return sb.toString();
		return null;
	}

	//对外提供一个close方法
	public void myClose() throws IOException
	{
		r.close();
	}


}
class MyLineNumberReaderDemo 
{
	public static void main(String[] args) throws IOException
	{
		//创建一个对象Reader的对象
		FileReader fr = new FileReader("MyLineNumberReaderDemo.java");

		//创建一个MyLineNumberReader对象
		MyLineNumberReader mylnr = new MyLineNumberReader(fr);

		String line =null;

		//调用设置LineNumber的方法
		mylnr.setMyLineNumber(100);
		while ((line=mylnr.MyReadLine())!=null)
		{
			System.out.println(mylnr.getMyLineNumber()+"::"+line);
		}

		mylnr.myClose();

		
	}
}
