package priv.rsl.IO_1;



import java.util.*;
import java.io.*;
class SystemInfo 
{
	public static void main(String[] args) throws IOException
	{
		//����ϵͳ������Ϣ����
		Properties prop = System.getProperties();
		
		//ʹ�÷���list(PrintStream ),��ʹ������������
		prop.list(new PrintStream("sysinfo.txt"));
	}
}
