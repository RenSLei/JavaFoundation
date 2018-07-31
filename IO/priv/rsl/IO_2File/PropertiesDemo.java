package priv.rsl.IO_2File;
/*
Properties��hashtable������
Ҳ����˵���߱�map���ϵ��ص㣬����������洢�ļ�ֵ�Զ����ַ���������Ҫ����
��⣺���Խ�һ���ļ��м�ֵ�Զ�ȡ���������ҿ��Ը��ģ����ӡ��޸ġ����桢��ȡֵ

�Ǽ����к�IO�������ϵļ�������

�ö�����ص㣺�������ڼ�ֵ����ʽ�������ļ�

��ô�ڼ�������ʱ����Ҫ�����й̶��ĸ�ʽ����=ֵ

*/
import java.io.*;
import java.util.*;

class PropertiesDemo 
{
	public static void main(String[] args) throws IOException
	{
		//method_1();
		loadDemo();
	}

	//��ʾ����ν����е����ݴ洢��������
	//��Ҫ��info.txt�ļ��еļ�ֵ���ݴ浽�����н��в���
	/*

	1,��һ������info.txt�����
	2,��ȡһ�����ݣ������������á�=�������и�
	3���Ⱥ������Ϊ�����ұ���Ϊֵ�����뵽Properties�����м��ɡ�

	*/
	//��һ��
	public static void method_1() throws IOException
	{
		//�������ǲ����ı��ĵ�������Ҫ���Ч�ʵģ�ʹ��BUfferedReader
		//����������Դ�ļ������
		BufferedReader bufr = new BufferedReader(new FileReader("info.txt"));

		String line = null;

		Properties prop = new Properties();

		//��ȡһ�����ݣ����ָ�
		while((line=bufr.readLine())!=null)
		{
			String[] arr= line.split("=");
			
			//������ֵ���뵽prop��
			prop.setProperty(arr[0],arr[1]);

		}
		//�ر���
		bufr.close();

		sop(prop);

	}

	//����(ʹ��load(InputStream inStream))��
	public static void loadDemo() throws IOException
	{
		FileInputStream fis = new FileInputStream("info.txt");
		Properties prop = new Properties();

		prop.load(fis);
		
		//���ڴ��иı��ֵ��Ϣ������ʵ���ı�ֵ���䣩,���ԭ�е��б�����û�м�ֵ�����½�һ����ֵ�ԣ�����оͽ��˼���Ӧ����Ϣ����
		prop.setProperty("lisi","35235");//�������99�������ı�ֵ����

		//��ν��ı��ֵ���浽ԭʼ�ļ����أ�ʹ��store����
		FileOutputStream fos = new FileOutputStream("info.txt");
		prop.store(fos,"zhushi");//������֤info.txt�ı��е���Ϣ�Ѿ��ı�

		sop(prop);
	}


	//���úͻ�ȡԪ��
	public static void setAndGet()
	{
		Properties prop = new Properties();

		prop.setProperty("zhangsan","30");
		prop.setProperty("lisi","40");

		//���ݼ�����ȡֵ
		String value = prop.getProperty("lisi");
		sop(value);

		//��������ֵ
		prop.setProperty("lisi","80");

		//��ȡ���ļ��ϲ��洢��set������ȥ������ǿforѭ��ȡֵ
		Set<String> names = prop.stringPropertyNames();
		for(String s:names)
		{
			sop(s+":"+prop.getProperty(s));
		}


	}

	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
}
/*
40
zhangsan:30
lisi:80

*/
