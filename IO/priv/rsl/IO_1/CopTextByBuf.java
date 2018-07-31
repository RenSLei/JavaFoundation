package priv.rsl.IO_1;
/*
ͨ���������������ļ���

*/
import java.io.*;
class CopTextByBuf 
{
	public static void main(String[] args) 
	{
		//�ⲿ���建����������
		BufferedWriter bufw = null;
		BufferedReader bufr = null;
		try
		{
			//��������������ָ���ļ�
			bufw = new BufferedWriter(new FileWriter("copy_by_buf.txt"));
			bufr = new BufferedReader(new FileReader("CopTextByBuf.java"));
			
			//readLine()�������ص���һ�������Ч�ַ����������ػس���
			//���ⲿ�������ã�while��Ϊѭ����
			String line = null;
			
			//��line����null��ʱ�򣬾�û�е�ĩβ
			while ((line = bufr.readLine())!=null)
			{
				//����һ��д�뻺����
				bufw.write(line);
				
				//дһ�о�Ҫд��һ�����з���������ʾ���Ķ�
				bufw.newLine();
				
				//�õ������Ҫ��flush()
				bufw.flush();
			}
		}
		catch (IOException e)
		{
			throw new RuntimeException("��дʧ�ܣ�");
		}

		//�ر�����Դ���رջ����������Ϳ�����
		finally 
		{
			try
			{
				//�ж��µ�Ŀ����ȷ���������ɹ��˲���ִ�йرղ���
				if(bufw!=null)
					bufw.close();
			}
			catch (IOException e)
			{
				throw new RuntimeException("�ر�д����ʧ�ܣ�");
			}

			//Ҫ�ֿ�try��catch
			try
			{
				//�ж��µ�Ŀ����ȷ���������ɹ��˲���ִ�йرղ���
				if(bufr!=null)
					bufr.close();
			}
			catch (IOException e)
			{
				throw new RuntimeException("�رն�ȡ��ʧ�ܣ�");
			}

		}
		
	}
}
