package priv.rsl.other_object;
/*
Runtime对象：
该类中没有构造函数，即该类不可以new对象，则会自然想到该类中的方法都是静态的。
但是该类中还有非静态方法，说明该类肯定提供了方法获取本类对象，而且该方法是静态的，
并且返回值类型是本类类型。

由以上特点可以看出该类使用了单例设计模式完成


获取本类对象的方法是：static Runtime getRuntime();
*/

import java.lang.*;
class  RuntimeDemo
{
	public static void main(String[] args) throws Exception
	{
		//直接获取本类对象，不是new
		Runtime r = Runtime.getRuntime();
		//exec(String command) 在单独的进程中执行指定的字符串命令。
		r.exec("D:\\QQ\\Bin\\QQScLauncher.exe");//路径
		
		/*exec方法返回类型是Process:
		public abstract class Process extends Object
		注意，此类是抽象的，方法也全是抽象的，说明不可以创建对象

		其中一个方法：public abstract void destroy()
		杀掉子进程。强制终止此 Process 对象表示的子进程。

		*/
		//
		Process p = r.exec("D:\\网易云音乐\\CloudMusic\\cloudmusic.exe");
		Thread.sleep(5000);//让线程休眠5秒
		p.destroy();//杀掉进程,可以看到程序启动后又结束了

		//不仅可以打开一个程序指令，且可以打开程序可以执行的文件,注意一般需要指定路径
		//r.exec("notepad.exe 新建文本文档");

	}
}
