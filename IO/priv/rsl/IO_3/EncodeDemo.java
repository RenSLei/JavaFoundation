package priv.rsl.IO_3;
/*
编码：字符串变成字节数组

解码：字节数组变成字符串

String ----->byte[]  方法：str.getBytes(charsetName);

byte---->String： 方法：new String(byte[],charsetName);


*/

import java.util.*;
class EncodeDemo 
{
	public static void main(String[] args) throws Exception
	{
		//encode_1();
		//encode_2();
		encode_3();
		
	}

	public static void encode_1() throws Exception//演示编码解码的过程
	{
		String s = "你好";
		
		//将字符串编码为字节数组
		byte[] b1 = s.getBytes("GBK");//按照GBK编码,其实默认是按照GBK来编码的。
		
		//解码 ：
		String s1 = new String(b1,"GBK");//注意：用什么编的就用什么去解码，否则乱码

		System.out.println(s1);

		//用工具包中的Arrays的toString方法将字节数组中的内容以字符串的形式体现：
		//System.out.println(Arrays.toString(b1));//[-60, -29, -70, -61]


	}

	public static void encode_2() throws Exception//编码正确解码错误如何处理？
	{
		String s = "你好";
		
		//将字符串编码为字节数组
		byte[] b1 = s.getBytes("GBK");//按照GBK编码,其实默认是按照GBK来编码的。
		
		//看看到底编码出来是什么内容：
		System.out.println(Arrays.toString(b1));

		//解码 ：
		String s1 = new String(b1,"iso8859-1");//按照欧洲码表来解码，显然会乱码，此时怎么办？
		
		//打印一次乱码的字符
		System.out.println("s1="+s1);
		
		//此时就将乱码的s1再用错误的码表（iso8859-1）编码,找到具体的字节，再用正确的码表去解码
		byte[] b2 = s1.getBytes("iso8859-1");

		//看看是否是原来的数值
		System.out.println(Arrays.toString(b2));
		
		//解码：
		String s2 = new String(b2,"GBK");

		System.out.println("s2="+s2);

		/*
		[-60, -29, -70, -61]
		s1=????
		[-60, -29, -70, -61]
		s2=你好
		*/

	}

		public static void encode_3() throws Exception//特殊：如果用一个同样能识别中文的码表解码解错了
	{
		String s = "你好";
		
		//将字符串编码为字节数组
		byte[] b1 = s.getBytes("GBK");//按照GBK编码
		
		//看看到底编码出来是什么内容：
		System.out.println(Arrays.toString(b1));

		//解码 ：
		String s1 = new String(b1,"utf-8");//按照utf-8码表来解码
		
		//打印一次乱码的字符
		System.out.println("s1="+s1);
		
		//此时就将乱码的s1再用错误的码表（utf-8）编码,找到具体的字节，再用正确的码表去解码
		byte[] b2 = s1.getBytes("utf-8");

		//看看是否是原来的数值
		System.out.println(Arrays.toString(b2));//实际不是原来的字节数组，为什么？因为utf-8也识别中文
		
		//再解码就得不到原来的中文了：
		String s2 = new String(b2,"GBK");

		System.out.println("s2="+s2);

		/*
		[-60, -29, -70, -61]
		s1=???
		[-17, -65, -67, -17, -65, -67, -17, -65, -67]
		s2=锟斤拷锟?


		分析：s1是用utf-8解码解出来的，当再用utf-8去编码的时候，
		由于utf-8把s1当做了中文，就解出了和原来不一样的字节
		*/

	}


}
