package priv.rsl.IO_3;


/*
学习内容：DataStreamDemo:

DataInputStream：数据输入流允许应用程序以与机器无关方式从底层输入流中读取基本 Java 数据类型。

DataOutputStream：数据输出流允许应用程序以适当方式将基本 Java 数据类型写入输出流中。

DataInputStream与 DataOutputStream

可以写入和读取基本数据类型的流对象

记住：凡是操作基本数据类型就用：DataOutputStream和DataInputStream

*/

import java.io.*;
class DataStreamDemo 
{
	public static void main(String[] args) throws IOException
	{
		//writeData();
		//readData();
		//writeUTFDemo();
		readUTFDemo();
	}

	public static void writeData()throws IOException
	{
		DataOutputStream dos = new DataOutputStream(new FileOutputStream("data.txt"));

		dos.writeInt(234);
		dos.writeBoolean(true);
		dos.writeDouble(234.264);

		dos.close();
	}

	public static void readData()throws IOException
	{
		DataInputStream dis = new DataInputStream(new FileInputStream("data.txt"));

		int num = dis.readInt();
		boolean b = dis.readBoolean();
		Double d = dis.readDouble();
		
		System.out.println("num="+num);
		System.out.println("b="+b);
		System.out.println("d="+d);

		dis.close();
	}

	public static void writeUTFDemo() throws IOException
	{
		DataOutputStream dos = new DataOutputStream(new FileOutputStream("utfdata.txt"));

		dos.writeUTF("你好");

		dos.close();
	}

	public static void readUTFDemo() throws IOException
	{
		DataInputStream dis = new DataInputStream(new FileInputStream("utfdata.txt"));
		
		String s = dis.readUTF();

		System.out.println(s);
	}

}
