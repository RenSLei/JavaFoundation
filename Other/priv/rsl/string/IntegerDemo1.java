package priv.rsl.string;
/*
JDK1.5版本以后出现的新特性。
*/



class IntegerDemo1 
{
	public static void sop(String str)
	{
		System.out.println(str);
	}

	public static void main(String[] args) 
	{
		//Integer x = new Integer("123");
		//新特性：
		Integer x =123;//自动装箱。//new Integer(123);
		//注意，这样写之后可以将null赋给x了。运行就会出错，抛出RuntimeException
		x = x+2;//x=123:进行了自动拆箱。变成了int类型。和2进行加法运算
				//再将和进行装箱赋给x. 

		Integer m = 128;//超过byte范围内容，开辟新空间
		Integer n = 128;
		sop("m==n："+(m==n));//结果为false

		Integer a = 127;
		Integer b = 127;
		sop("a==b："+(a==b));//结果为true.
	}
}
 //因为a和b指向了同一个对象。
 //因为当数值在byte范围内容，对于新特性，如果该数值已经存在，则不会在开辟新的空间。
	
/*原有写法，很麻烦
	public static void method()
	{
		Integer x = new Integer("123");
		Integer y = new Integer(123);
		sop("x==y:"+(x==y));
		sop("x.equals(y):"+x.equals(y));
	}
}
*/

/*
运行结果：
m==n：false
a==b：true
*/

