package priv.rsl.object_oriented4;
/*
��DuoTaiDemo2�еĽ��������Ż�:�����������еĹ��ܳ�ȡ�����γ�һ�������࣬
���������н�������Ķ��������ø���Ĺ��ܼ���
*/

/*
�����ࣺѧϰ��˯��
�߼��ࣺѧϰ��˯��
��ѧϰ���ݲ�ͬ
*/

abstract class  Student
{
	public abstract void study();
	public void sleep()
	{
		System.out.println("����˯");
	}
}

/*���������еĹ��ܳ�ȡ�����γ�һ��������*/
class DoSome
{
	public void doSome(Student stu)//ע���Ǹ��࣬�൱��:���� s = new ����();����ת�ͣ�
	{
		stu.study();
		stu.sleep();
	}
}
//---------------------------------------------------------------���Ͼ��������������壬�����Ǿ���ʵ��������
class BaseStudent extends Student
{
	public void study()
	{
		System.out.println("base study");
	}
	public void sleep()
	{
		System.out.println("����˯");
	}
}

class AdvStudent extends Student
{
	public void study()
	{
		System.out.println("adv study");
	}
}

//--����������������Ķ��󣬵����书�ܾ����ˣ����ݲ������½��ľ�����Ķ���
class  DuoTaiDemo3
{
	public static void main(String[] args) 
	{
		DoSome s = new DoSome();
		s.doSome(new BaseStudent());
		s.doSome(new AdvStudent());
	}
}

//�ܽ᣺�����ͽ��г�ȡ�������˶�̬�Ĳ���������ͬһ�������ͣ���Student�����Դ������е�����С���Ͷ��ܽ��в������������������չ�ԡ�
