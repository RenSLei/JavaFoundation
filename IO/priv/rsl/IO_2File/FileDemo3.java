package priv.rsl.IO_2File;
/*

�г�ָ��Ŀ¼���ļ������ļ��У�������Ŀ¼������
Ҳ�����г�ָ��Ŀ¼�µ���������

��ΪĿ¼�л���Ŀ¼��ֻҪ��ͬһ���г�Ŀ¼���ܵĺ�������
���г������г��ֵĻ���Ŀ¼�Ļ����������ٴε��ñ�����
Ҳ���Ǻ��������������
���ֱ�����ʽ���߱���ַ������ݹ顣

�ݹ�Ҫע��ģ�
1.�޶�����
2.ע��ݹ�Ĵ����������ڴ����

*/


import java.io.*;
class FileDemo3 
{
	public static void main(String[] args) 
	{
		File dir = new File ("C:\\Users\\78658\\OneDrive");
		showDir(dir);
	}

	//��ӡ��Ŀ¼�µ��ļ���Ŀ¼��
	public static void showDir(File dir)
	{
		//listFiles()���ص���File��Ķ���
		File[] files = dir.listFiles();
		
		sop("\nĿ¼��"+dir.getName()+"   "+"filesNum="+files.length+"\n");
		for (int x=0;  x<files.length; x++)
		{
			//���˵�һЩ�ļ�Ŀ¼
			String name =files[x].getName();
			if(name.endsWith("��Ҫ�ļ�")||name.endsWith("��Ҫ����")||name.endsWith("api"))
				continue;
			else
			//����File�����е�ÿ����Ա�ж��Ƿ���Ŀ¼
			if(files[x].isDirectory())
				showDir(files[x]);
			else
				sop(files[x]);
		}

	}

	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
}
