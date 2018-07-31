package priv.rsl.IO_3;


/*
ѧϰ���ݣ�DataStreamDemo:

DataInputStream����������������Ӧ�ó�����������޹ط�ʽ�ӵײ��������ж�ȡ���� Java �������͡�

DataOutputStream���������������Ӧ�ó������ʵ���ʽ������ Java ��������д��������С�

DataInputStream�� DataOutputStream

����д��Ͷ�ȡ�����������͵�������

��ס�����ǲ��������������;��ã�DataOutputStream��DataInputStream

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

		dos.writeUTF("���");

		dos.close();
	}

	public static void readUTFDemo() throws IOException
	{
		DataInputStream dis = new DataInputStream(new FileInputStream("utfdata.txt"));
		
		String s = dis.readUTF();

		System.out.println(s);
	}

}
