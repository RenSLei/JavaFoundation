package priv.rsl.IO_1;
/*
使用了继承后的MyLineNumberReader代码：用于对比和说明

java.lang.Object
  继承者 java.io.Reader
      继承者 java.io.BufferedReader
          继承者 java.io.LineNumberReader


注意：自己写的MyLineNumberReader里的很多代码在MyBufferedReader中已经写过了，
所以可以继承MyBufferedReader来简化代码的书写以及功能的扩展：

*/




import java.io.*;
//继承MyBufferedReader
class MyLineNumberReader2 extends MyBufferedReader
{
	private int lineNumber;
	//构造函数,调用父类的就可以了
	MyLineNumberReader2(Reader r)
	{
		super(r);
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
		//用以下来代替：
		return super.MyReadLine();
		
		/*
		一次读一行的这个功能在父类中已经实现过了
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
		return null;*/
	}
	
	
	/*
	父类中有：
	//对外提供一个close方法
	public void myClose() throws IOException
	{
		r.close();
	}
	*/


}
class MyLineNumberReaderDemo2 
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
		fr.close();
	}
}

