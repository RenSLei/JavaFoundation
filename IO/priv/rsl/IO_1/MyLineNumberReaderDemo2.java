package priv.rsl.IO_1;
/*
ʹ���˼̳к��MyLineNumberReader���룺���ڶԱȺ�˵��

java.lang.Object
  �̳��� java.io.Reader
      �̳��� java.io.BufferedReader
          �̳��� java.io.LineNumberReader


ע�⣺�Լ�д��MyLineNumberReader��ĺܶ������MyBufferedReader���Ѿ�д���ˣ�
���Կ��Լ̳�MyBufferedReader���򻯴������д�Լ����ܵ���չ��

*/




import java.io.*;
//�̳�MyBufferedReader
class MyLineNumberReader2 extends MyBufferedReader
{
	private int lineNumber;
	//���캯��,���ø���ľͿ�����
	MyLineNumberReader2(Reader r)
	{
		super(r);
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
		//�����������棺
		return super.MyReadLine();
		
		/*
		һ�ζ�һ�е���������ڸ������Ѿ�ʵ�ֹ���
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
		return null;*/
	}
	
	
	/*
	�������У�
	//�����ṩһ��close����
	public void myClose() throws IOException
	{
		r.close();
	}
	*/


}
class MyLineNumberReaderDemo2 
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
		fr.close();
	}
}

