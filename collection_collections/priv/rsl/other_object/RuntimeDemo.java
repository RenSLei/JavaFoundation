package priv.rsl.other_object;
/*
Runtime����
������û�й��캯���������಻����new���������Ȼ�뵽�����еķ������Ǿ�̬�ġ�
���Ǹ����л��зǾ�̬������˵������϶��ṩ�˷�����ȡ������󣬶��Ҹ÷����Ǿ�̬�ģ�
���ҷ���ֵ�����Ǳ������͡�

�������ص���Կ�������ʹ���˵������ģʽ���


��ȡ�������ķ����ǣ�static Runtime getRuntime();
*/

import java.lang.*;
class  RuntimeDemo
{
	public static void main(String[] args) throws Exception
	{
		//ֱ�ӻ�ȡ������󣬲���new
		Runtime r = Runtime.getRuntime();
		//exec(String command) �ڵ����Ľ�����ִ��ָ�����ַ������
		r.exec("D:\\QQ\\Bin\\QQScLauncher.exe");//·��
		
		/*exec��������������Process:
		public abstract class Process extends Object
		ע�⣬�����ǳ���ģ�����Ҳȫ�ǳ���ģ�˵�������Դ�������

		����һ��������public abstract void destroy()
		ɱ���ӽ��̡�ǿ����ֹ�� Process �����ʾ���ӽ��̡�

		*/
		//
		Process p = r.exec("D:\\����������\\CloudMusic\\cloudmusic.exe");
		Thread.sleep(5000);//���߳�����5��
		p.destroy();//ɱ������,���Կ��������������ֽ�����

		//�������Դ�һ������ָ��ҿ��Դ򿪳������ִ�е��ļ�,ע��һ����Ҫָ��·��
		//r.exec("notepad.exe �½��ı��ĵ�");

	}
}
