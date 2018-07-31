package priv.rsl.multi_thread;
/*
�������ģʽ��*******�ص�����*******��
*/
/*
����ʽ:

class Single
{
	private static final Single s = new Single();//��final��Ϊ�Ͻ�
	private Single(){}
	public static Single getInstance()
	{
		return s;
	}
����ʽ�����ڰ�ȫ����
}
*/
//����ʽ
class Single
{
	private static Single s = null;
	private Single(){}
	public static  Single getInstsnce()/*����synchronizedÿ�ζ��ж����ܵ�Ч*/
	{
		if(s==null)/*˫���ж�����߳�����ͬ�������Ĵ���*/
		{
			synchronized(Single.class)
			{
				if(s==null)
					//����ȫ�ĵط����߳����׹�������
					s = new Single(); 	
			}
		}
		return s;
	}
}

class SingleDemo 
{
	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
	}
}
/*
�ܽ᣺д����ģʽ��д����ʽ����Ϊ�����ڰ�ȫ���⡣
���ǿ���ȴ��������ʽ��
���⣺
1������ʽ�Ͷ���ʽ��ʲô����
������ʽ���ص�����ʵ���ӳټ��ء�
2���ӳټ�����ʲô���⣿��ô�����
�𣺶��̷߳���ʱ����ְ�ȫ���⡣���Լ�ͬ���������
3����ô��ͬ����ͬ����Ч������Ż���
��ͬ������ʹ��ͬ��������ͬ������顣
Ч���Ż���ʹ��ͬ������飬��ʹ��˫���жϡ�������if(s==null)��
4����ͬ����ʱ��ʹ�õ�������һ����
�𣺸����������ֽ����ļ�����
*/
