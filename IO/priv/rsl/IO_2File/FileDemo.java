package priv.rsl.IO_2File;
/*
day20-02-io-File����Ĺ���-������ɾ��

File�ೣ���ķ�����
1������
	boolean createNewFile():��ָ����λ���ϴ����ļ���������ļ��Ѿ����ڣ��򲻴���������false��
							���������һ���������һ���������ļ��������ļ��Ѿ����ڣ��Ḳ�ǡ�

	boolean mkdir()�����ļ���
	boolean mkdirs()�����༶�ļ���
2��ɾ��
	boolean delete();ɾ��ʧ�ܷ���false.
	void deleteOnExit();�ڳ����˳�ʱɾ��ָ���ļ���

3���ж�
	�õ����ģ�boolean exists()
	�ж��Ƿ����ļ���isFile()
	�ж��Ƿ���·����isDirectory()
	�жϳ���·����ʾ���ļ��Ƿ������ص��ļ���isHidden()
	���Դ˳���·�����Ƿ�Ϊ����·����:isAbsolute() 

4����ȡ��Ϣ
	getName():
	getPath():
	getAbsolutePath():
	getParent()��

	long lastModified() ���ش˳���·������ʾ���ļ����һ�α��޸ĵ�ʱ�䡣
	length()

*/


import java.io.*;
class FileDemo 
{
	public static void main(String[] args)  throws IOException
	{
		Method_4();
	}
	public static void Method_1() throws IOException//��ʾ������ɾ��
	{
		File f =new File("file.txt");

		//���Ǵ������ļ���Ҫ�����ɾ����������ʱ�ļ���������ã�
		//f.deleteOnExit();//�����ڸ��ļ���Ŀ¼���������г��ֺ���״��(�쳣)����󶼻�ɾ��
		
		//�����ļ���
		sop("create:"+f.createNewFile());
		
		//�����ļ��У�·������
		File dir =new File("�ļ���1\\�ļ���2\\�ļ���3");//Ĭ�ϵ��ǵ�ǰ·��
		sop("mkdir:"+dir.mkdirs());

		//sop("delete:"+f.delete());
	}

	public static void Method_2()throws IOException//��ʾ�ж�
	{
		//�ж����кܶ࣬���ļ��Ƿ��ִ�С��ɶ�����д���Ƿ���ڸ�·�����ļ�
		File f1 = new File("FileDemo.java");

		//��õķ�����exists()
		sop("exists:"+f1.exists());//�Ǵ��ڵ�true

		File f2 = new File("file.txt");


		if(f1.exists())//���ж�
			sop("f1:isFile:"+f1.isFile());  //���ļ�:true
		else sop("f1������");
		
		if(f2.exists())//���ж�
		{
			sop("f2:isFile:"+f2.isFile());

			sop("f2:isDirectory:"+f2.isDirectory());
		}
		else sop("f2������");
		//^-^���ж��ļ������Ƿ����ļ�����·��ʱ������Ҫ��exists()���ж��ļ������װ�������Ƿ����

		File f3 = new File("C:\\Users\\78658\\OneDrive\\java\\day20_IO_File");
		sop(f3.isAbsolute());//�����̷��ž���Ϊ��true
		
	}

	public static void Method_3()
	{
		File f = new File("a.txt");	//�ļ�ʵ�ʲ�����
		sop("path:"+f.getPath());//��װ����ʲô·������ʲô·�������ļ��Ƿ�����޹�
		sop("Abspath:"+f.getAbsolutePath());//����·�������ļ��Ƿ�����޹�
		sop("parent:"+f.getParent());//���ص��Ǿ���·���е��ļ���Ŀ¼�������ȡ�������·�����򷵻ص���null
		//������·��������һ��Ŀ¼����ô�ͷ��ش�Ŀ¼

	}
	
	public static void Method_4()
	{
		File f1 = new File("Test.java");	
		File f2 = new File("haha.java");	

		sop("rename:"+f1.renameTo(f2));//��Test.java���ָ�Ϊhaha.java
	}

	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
}
/*
���н����
exists:true
f1:isFile:true
f2:isFile:false
f2:isDirectory:true

*/
