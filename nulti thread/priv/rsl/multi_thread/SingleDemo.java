package priv.rsl.multi_thread;
/*
单例设计模式（*******重点掌握*******）
*/
/*
饿汉式:

class Single
{
	private static final Single s = new Single();//加final更为严谨
	private Single(){}
	public static Single getInstance()
	{
		return s;
	}
饿汉式不存在安全问题
}
*/
//懒汉式
class Single
{
	private static Single s = null;
	private Single(){}
	public static  Single getInstsnce()/*若加synchronized每次都判断锁很低效*/
	{
		if(s==null)/*双重判断提高线程运行同步函数的次数*/
		{
			synchronized(Single.class)
			{
				if(s==null)
					//不安全的地方，线程容易挂在这里
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
总结：写单例模式都写饿汉式。因为不存在安全问题。
但是考试却常考懒汉式。
问题：
1、懒汉式和饿汉式有什么区别？
答：懒汉式的特点在于实例延迟加载。
2、延迟加载有什么问题？怎么解决？
答：多线程访问时会出现安全问题。可以加同步来解决。
3、怎么加同步？同步的效率如何优化？
答：同步可以使用同步函数和同步代码块。
效率优化：使用同步代码块，且使用双重判断。即两个if(s==null)。
4、加同步的时候使用的锁是哪一个？
答：该类所属的字节码文件对象。
*/
