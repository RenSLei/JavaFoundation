package priv.rsl.IO_1;
/*
字符读取流的缓冲区：
缓冲区提供了一个一次读一行的方法 readLine,方便对文本数据的获取
当readLine()方法返回值为null时，表示读到文件末尾

*/
import java.io.*;
class BufferReaderDemo 
{
	public static void main(String[] args) throws IOException
	{
		//创建一个读取流对象和文件相关联。
		FileReader fr = new FileReader("buf.txt");

		//为了提高效率，加入缓冲区技术。将字符读取流对象作为参数传递给缓冲对象的构造函数
		BufferedReader bufr = new BufferedReader(fr);

		//查阅API可以知道：readLine()方法的返回值为空的时候，表示读取到文本的末尾
		//所以设置一个变量记录返回值，当返回值不是空的时候就继续读
		String line = null;

		while((line=bufr.readLine())!=null)
		{
			System.out.println(line);
		}

		bufr.close();
	}
}
/*
abcd1
abcd2
abcd3
abcd4

*/
