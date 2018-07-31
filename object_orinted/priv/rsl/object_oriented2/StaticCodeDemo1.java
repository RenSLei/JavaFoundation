package priv.rsl.object_oriented2;
/*
静态代码块：
格式:
static
{
	静态代码块中的执行语句。
}

特点：随着类的加载而执行，只执行一次,并优先于主函数执行。
用于给类进行初始化的。

*/
class StaticCode1
{
	static
	{
		System.out.println("a");
	}
	public static void show()
	{
		System.out.println("show run");
	}
}

class StaticCodeDemo1
{
	
	public static void main(String[] args) 
	{
		StaticCode1.show();/*用类名调用静态方法，此时类中的静态代码块加载吗？答案是加载。
							因为类中静态方法一旦被调用（注意此时没有对象），相当于该类被加载，
							所以由于静态代码块的给类初始化特性，随类加载而加载*/
		StaticCode1 s =null;/*此时类StaticCode1被加载了吗？没有。
							因为变量s没有具体的实体指向*/
		s=new StaticCode1();/*此时类StaticCode1就被加载了，因为我们说类有一个默认初始化构造函数StaticCode(){},因此相当于类中内容被使用，
							所以静态代码块被加载
							为什么执行结果是 a show run   因为静态代码块只执行一次，main中第一行代码已经把类加载了，所以相当于第二和第三行没有
							加载静态代码块，如果没有第一行代码，则执行结果为:a*/

	}
	
}

