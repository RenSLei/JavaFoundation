package priv.rsl.IO_2File;
/*
ɾ��һ�������ݵ�Ŀ¼
ɾ��ԭ��
��windows�У�ɾ��Ŀ¼����������ɾ��


������������ɾ����Ҫ�õ��ݹ�ķ���

*/


import java.io.*;
class  RemoveDir
{
	public static void main(String[] args) 
	{
		File dir = new File("E:\\day20-Io-ɾ���ļ���Ŀ¼test");
		removeDir(dir);

	}

	public static void removeDir(File dir)
	{
		File[] files = dir.listFiles();

		for (int x= 0;x<files.length;x++ )
		{
			if(files[x].isDirectory())
				removeDir(files[x]);
			else 
				sop(files[x].toString()+"-file-"+files[x].delete());
		}

		//ɾ����һ���ļ�������ļ��󣬾Ͱ�����ļ���ɾ��
		sop(dir+"::dir::"+dir.delete());

	}

	
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
}
