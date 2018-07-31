package priv.rsl.IO_2File;


/*

�г�ָ��Ŀ¼���ļ������ļ��У�������Ŀ¼������
Ҳ�����г�ָ��Ŀ¼�µ���������

�г�����Ŀ¼���������ݣ������в��


*/


import java.io.*;
class FileDemo4 
{
	public static void main(String[] args) 
	{
		File dir = new File ("C:\\Users\\78658\\OneDrive\\java\\day20_IO_File");
		showDir(dir,0);
	}
	
	//дһ�����������ƫ�Ʒ��ŵĺ���
	public static String getLevel(int level)
	{

		StringBuilder sb = new StringBuilder();
		for (int x=0; x<level;x++ )
		{
			sb.append("|---");
		}
		
		return sb.toString();

	}
	//��ӡ��Ŀ¼�µ��ļ���Ŀ¼��
	public static void showDir(File dir,int level)
	{
		//listFiles()���ص���File��Ķ���
		File[] files = dir.listFiles();
		
		sop(getLevel(level)+dir.getName()+"   "+"filesNum="+files.length+"\n");
		level++;

		for (int x=0;  x<files.length; x++)
		{
			//����File�����е�ÿ����Ա�ж��Ƿ���Ŀ¼
			if(files[x].isDirectory())
				showDir(files[x],level);
			else
				sop(getLevel(level)+files[x]);
		}

	}

	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
}
