package priv.rsl.IO_1;
/*
�����쳣����־��Ϣ��
����һ���쳣��Ϣ��������Ϣд��ָ�����ļ���ȥ��������ʱ��

*/
//����
import java.io.*;
import java.util.*;//Date��
import java.text.*;//��ʽ��ʱ��������ڴ˰�

class ExceptionInfo
{
	public static void main(String[] args) 
	{
		//����һ���򵥵��쳣��Ϣ
		try
		{
			int[] arr = new int[2];
			System.out.println(arr[3]);
		}
		catch (Exception e)
		{
			//��ν��쳣��Ϣ�洢��ָ���ļ����أ�
			//���ȶ������ڣ�
			try
			{
				Date d = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd E HH:mm:ss");
				String time = sdf.format(d);

				//����PrintStream����
				PrintStream ps = new PrintStream("exception.log");
				ps.println(time);
				System.setOut(ps);//�ı�����豸�����ǿ���̨��Ӳ��
			}
			catch (IOException ex)
			{
				throw new RuntimeException("��־�ļ�����ʧ�ܣ�");
			}

			e.printStackTrace(System.out);//Throwable���printStackTrace�������һ�������PrintStream
		}
	}
}
//���Ͻ���Java�쳣��Ϣ�Ĺ��߰���log4j
