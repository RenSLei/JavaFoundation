package priv.rsl.IO_2File;
/*

��ʾ�ļ��б�list��һϵ�з���

*/


import java.io.*;
class FileDemo2 
{
	public static void main(String[] args) 
	{
		listFilesDemo();
	}

	public static void listFilesDemo()
	{
		File dir = new File ("C:\\Users\\78658\\OneDrive");

		//���ص���File����,���Ե���һϵ�з�����Ӧ�ýϹ�
		File[] files =dir.listFiles();

		for (File f : files)
		{
			sop("name:"+f.getName()+"------>len:"+f.length());
		}
	}
	
	//list(FilenameFilter Filter):����һ���ַ�������
	//��Щ�ַ���ָ���˳���·������ʾ��Ŀ¼������ָ�����������ļ���Ŀ¼��
	public static void listDemo2()
	{
		File dir = new File("C:\\Users\\78658\\OneDrive");
		
		//list���ط�������ܵ���һ���ӿڣ�FilenameFilter���ýӿ�ֻ��һ�����������Կ���ֱ��ʹ�������ڲ���
		String[] someNames = dir.list(new FilenameFilter()
		{
			//���ǵ����еķ�����accept()
			//dirָ����File����name������Ҫ���˵��ļ���
			public boolean accept(File dir,String name)
			{
				//�����ǵ��ļ�������.jpg������ʱ�򷵻�true
				return name.endsWith(".jpg");

			}
		});
		for (String name :someNames)
		{
			sop(name);
		}

		/*
		�����	2017-2018У��.jpg
				QQͼƬ20171105231537.jpg
		*/
	}



	//list():���ص���һ��String������飬�����ǳ���·�����µ��ļ�����Ŀ¼��
	public static void listDemo()
	{
		File f = new File("c:\\");

		String[] names = f.list();//����list������file��������Ƿ�װ��һ��Ŀ¼����Ŀ¼��������ڡ�
		for (String name :names)
		{
			sop(name);
		}
	}



	//listRoots():ֱ����File.listRoots()����ȡ�����̷�
	public static void listRootsDemo()
	{
		File[] files  = File.listRoots();//��ȡ�������̷�

		for (File f : files)
		{
			sop(f);
		}
	}

	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
}
