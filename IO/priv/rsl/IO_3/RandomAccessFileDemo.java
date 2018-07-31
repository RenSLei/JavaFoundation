package priv.rsl.IO_3;
/*
RandomAccessFile:Ӧ�ã����ݵķֶ�д�룬�����߳�ͬʱ�����ļ�

���಻����IO��ϵ�е�����ֱ�Ӽ̳�Object
��������IO���еĳ�Ա����Ϊ���߱���ȡ��д�빦��

�ڲ���װ��һ�����飬����ͨ��ָ��������Ԫ�ؽ��в���
����ͨ��getFilePointer��ȡָ��λ��
ͬʱҲ����ͨ��seek�ı�ָ���λ��

��ʵ��ɶ���д��ԭ������ڲ���װ���ֽ������������

ͨ�����캯�����Է��֣�����ֻ�ܲ����ļ�
���Ҳ����ļ�����ģʽ:ֻ����r   ��д��rw

���ģʽΪֻ����r�����ᴴ���ļ�����ȥ��ȡһ���Ѿ����ڵ��ļ���������ļ������ڣ��������쳣
���ģʽΪrw���������ļ������ڻ��Զ���������������򲻻Ḳ�ǡ�

*/

//
import java.io.*;
class RandomAccessFileDemo 
{
	public static void main(String[] args) throws IOException
	{
		//writeFile();	
		//readFile();
		writeFile_2();
	}

	public static void readFile()throws IOException
	{
		RandomAccessFile raf = new RandomAccessFile("ran.txt","r");

		//����ָ�룺-----�ص㣺
		//raf.seek(8);//��ָ��λ���Ƶ���9���ֽڴ�
		//������ǣ�name=����age=99

		//����ָ�����ֽ�����ֻ��������
		raf.skipBytes(8);

		byte[] buf = new byte[4];//����һ��4���ֽڵĻ�������

		raf.read(buf);

		String name = new String(buf);

		int age = raf.readInt();//һ�ζ���һ��4���ֽں�ָ�뵽��ָ������ĵط�����ʱ�ٶ��պ��ܶ���ָ��

		System.out.println("name="+name+"age="+age);
	}
	

	public static void writeFile() throws IOException
	{
		RandomAccessFile raf = new RandomAccessFile("ran.txt","rw");

		raf.write("����".getBytes());

		//raf.write(258);//ע�⣺write��д�����8λ�������ֽڣ����������������ݵĶ�ʧ

		raf.writeInt(97);//�����ĸ��ֽ�д��

		raf.write("����".getBytes());

		raf.writeInt(99);

		raf.close();
	}

	public static void writeFile_2() throws IOException//���д
	{
		RandomAccessFile raf = new RandomAccessFile("ran.txt","rw");
		
		//��ָ����λ��д���ݣ��������ڵ�4��8λд����
		raf.seek(8*3);

		raf.write("����".getBytes());//���ҿ������λ�õ�д�룬���Ḳ������

		raf.writeInt(103);
		
		//д��֮���ran.txt�����ݣ�����   a����   c        ����   g
	}
}
