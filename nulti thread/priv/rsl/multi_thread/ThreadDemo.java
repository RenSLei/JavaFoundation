package priv.rsl.multi_thread;
/*
进程：是一个正在执行中的程序
每一个进程执行都有一个执行顺序。该顺序是一个执行路径，或者叫一个控制单元。

线程：就是进程中的一个独立的控制单元。
一个进程中至少有一个线程。

java VM 启动时会有一个进程java.exe

该进程中至少一个线程负责java程序的执行
而且这个线程运行的代码存在于main方法中。

该线程称之为主线程。

扩展：其实更细节说明jvm，jvm启动不止一个线程，还有负责垃圾回收机制的线程。

------------------------------------------------
02:
通过对api的查找，java已经提供了对线程这类事物的描述。就是Thread类。

创建线程的第一种方式：继承Thread类。
步骤：
1、定义类继承Thread
2、复写Thread中的run方法：将自定义代码存储在run方法中，认线程运行。
3、调用线程的start方法，该方法有两个作用：
1）启动线程
2）调用run方法

运行结果每次不一样的原因：多线程都在获取CPU的执行权。cpu执行到谁，谁就运行。
某一时刻，只能有一个程序在运行。（多核除外）
cpu在做着快速的切换，以达到看上去是同时运行的效果。

多线程的一个特性：随机性。谁抢到谁就执行，至于执行多长，cpu说了算。

为什么要覆盖run方法呢？

Thread类用于描述线程。
该类就定义了一个功能，用于存储线程要运行的代码。该存储功能就是run方法。
即run方法，用于存储线程要运行的代码。


---------
06：原来线程都有自己默认的名称。
Thread-编号 该编号从0开始。通过在run中调用：this.getName();获取。

父类中的static Thread currentThread()方法:获取当前线程对象。
getName():获取线程的名称。

设置线程的名称：setName()和构造函数两个方法


*/

class Demo extends Thread
{
	public void run()//存储单独开启的线程要运行的代码
	{
		for(int x = 0;x<60;x++)
		System.out.println("demo run--"+x);
	}

}




class ThreadDemo
{
	public static void main(String[] args) 
	{
		//for(int x=0;x<4000;x++)
		//System.out.println("Hello World!");

		Demo d = new Demo();//创建好一个线程。
		d.start();//开启线程并执行该线程的run方法；
		d.run();//仅仅是对象调用方法。而线程创建了，并没有运行。
		
		

		for(int x=0;x<60;x++)
		System.out.println("Hello World--"+x);
	}
}
