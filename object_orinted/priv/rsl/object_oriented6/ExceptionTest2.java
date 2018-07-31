package priv.rsl.object_oriented6;
/*
��һ��Բ�κͳ�����
�����Ի�ȡ������������������ַǷ�����ֵ����Ϊ�ǻ�ȡ����������⡣
����ͨ���쳣����ʾ��
���ڶ����������л�����ơ�

*/

class NoValueException extends RuntimeException//��Ϊ���ַǷ�ֵʱ�������ܶ������������˽�������
{
	NoValueException(String message)
	{
		super(message);
	}
}



interface Shape
{
	void getArea();
}

class Rec implements Shape
{
	private int len,wid;
	Rec(int len,int wid)//��Ϊ�̳е���RuntimException�쳣����������throws NoValueException��������Ҫ������쳣��ֱ�ӽ���������ʾ����
	{
		if(len<=0 || wid<=0)
			throw new NoValueException("���ַǷ�ֵ");
		this.len = len;
		this.wid = wid;
	}
	public void getArea()
	{
		System.out.println(len*wid);
	}
}

class Circle implements Shape
{
	private int radius;
	public static final double PI =3.14;
	Circle(int radius)
	{
		if(radius<=0)
			throw new NoValueException("�����Ƿ�");
		this.radius = radius;
	}
	public void getArea()
	{
		System.out.println(radius*radius*PI);
	}
}

class  ExceptionTest2
{
	public static void main(String[] args) 
	{

			Rec r = new Rec(3,4);
			r.getArea();

			Circle c = new Circle(-8);
			c.getArea();
		    System.out.println("over");
	}
}
