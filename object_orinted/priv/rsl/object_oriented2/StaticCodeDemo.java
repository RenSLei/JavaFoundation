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
class StaticCode
{
	static
	{
		System.out.println("a");
	}
}

class StaticCodeDemo
{
	static
	{
		System.out.println("b");
	}
	public static void main(String[] args) 
	{
		new StaticCode();/*类StaticCodeDemo被加载进内存，首先执行StaticCodeDemo中的静态代码块
							打印b,再打印c；接着执行主函数，主函数中，类StaticCode被加载进内存，
							首先执行StaticCode中的静态代码块，打印a；*/
		new StaticCode();//注意，类一旦被加载进内存后，就不再初始化该类了，因此打印结果是：c b a
		System.out.println("Hello World!");
	}
	static
	{
		System.out.println("c");
	}
}
//因此打印结果是:

