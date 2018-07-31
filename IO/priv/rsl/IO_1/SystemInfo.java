package priv.rsl.IO_1;



import java.util.*;
import java.io.*;
class SystemInfo 
{
	public static void main(String[] args) throws IOException
	{
		//创建系统属性信息对象
		Properties prop = System.getProperties();
		
		//使用方法list(PrintStream ),并使用匿名流对象
		prop.list(new PrintStream("sysinfo.txt"));
	}
}
