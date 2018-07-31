package priv.rsl.IO_1;
/*
ԭʼ����ϸ���Լ���MyLineNumberReader���룺���ڶԱȺ�˵��

java.lang.Object
  �̳��� java.io.Reader
      �̳��� java.io.BufferedReader
          �̳��� java.io.LineNumberReader
����LineNumberReader�ļ��кŵĹ����Լ�дһ��ʵ�ֹ���:

���󣺶����Լ���MyLineNumberReader

*/




import java.io.*;
class MyLineNumberReader
{
	private Reader r;

	private int lineNumber;
	//���캯��
	MyLineNumberReader(Reader r)
	{
		this.r= r;
	}

	//�����ṩ��MyLn�����úͻ�ȡ����
	public void setMyLineNumber(int lineNumber)
	{
		this.lineNumber= lineNumber;
	}

	public int getMyLineNumber()
	{
		return lineNumber;
	}

	//ע�⵽LineNumberReader�����︴д��readLine����
	//��������ҲҪ��д
	public String MyReadLine() throws IOException
	{
		//��һ������һ��
		lineNumber++;
		//һ�ζ�һ�У���Ҫ����
		StringBuilder sb = new StringBuilder();

		int ch = 0;
		while ((ch= r.read())!=-1)
		{
			//���ж���
			if(ch=='\r')
				continue;
			if(ch=='\n')
				return sb.toString();
			else
				sb.append((char)ch);

			
		}
		if(sb.length()!=0)
			return sb.toString();
		return null;
	}

	//�����ṩһ��close����
	public void myClose() throws IOException
	{
		r.close();
	}


}
class MyLineNumberReaderDemo 
{
	public static void main(String[] args) throws IOException
	{
		//����һ������Reader�Ķ���
		FileReader fr = new FileReader("MyLineNumberReaderDemo.java");

		//����һ��MyLineNumberReader����
		MyLineNumberReader mylnr = new MyLineNumberReader(fr);

		String line =null;

		//��������LineNumber�ķ���
		mylnr.setMyLineNumber(100);
		while ((line=mylnr.MyReadLine())!=null)
		{
			System.out.println(mylnr.getMyLineNumber()+"::"+line);
		}

		mylnr.myClose();

		
	}
}
