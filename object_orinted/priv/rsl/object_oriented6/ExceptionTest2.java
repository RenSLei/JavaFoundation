package priv.rsl.object_oriented6;
/*
有一个圆形和长方形
都可以获取面积。对于面积如果出现非法的数值，视为是获取面积出现问题。
问题通过异常来表示。
现在对这个程序进行基本设计。

*/

class NoValueException extends RuntimeException//因为出现非法值时根本不能对其求面积，因此结束程序
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
	Rec(int len,int wid)//因为继承的是RuntimException异常，不用声明throws NoValueException，即不想要处理该异常，直接结束程序，提示出错
	{
		if(len<=0 || wid<=0)
			throw new NoValueException("出现非法值");
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
			throw new NoValueException("参数非法");
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
