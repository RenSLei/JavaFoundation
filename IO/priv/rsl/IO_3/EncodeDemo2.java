package priv.rsl.IO_3;
/*
GBK和utf-8特殊的地方：
“联通”这两个字的GBK编码恰好符合utf-8的解码形式


注：utf-8的解码形式已经截图保存在当前目录下
utf-8解码：可以用一个字节表示字符，可以用两个字节表示字符，可以用三个字节
如何确定是读一个还是读两个或者三个？因为他有头位来标识。
*/

import java.io.*;
class EncodeDemo2 
{
	public static void main(String[] args) throws Exception
	{
		//演示联通的问题：
		String s= "联通";

		byte[] by = s.getBytes("GBK");

		for(byte b : by)
		{
			//打印每个编码出来的字节的最低8位
			System.out.println(Integer.toBinaryString(b&255));
		}
	}

	
}
/*
11000001
10101010
11001101
10101000
恰好符合utf-8的编码规则


*/
