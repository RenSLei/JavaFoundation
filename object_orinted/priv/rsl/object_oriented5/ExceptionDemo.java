package priv.rsl.object_oriented5;
/*
异常：就是程序在运行时出现不正常情况。
异常的由来：问题也是现实生活中的一个具体事物，也可以通过java的类的形式进行描述。
并封装成对象。
其实就是java对不正常情况进行描述后的对象体现。

对于问题的划分：两种
一种是严重的：java通过Error进行描述，一般不编写针对性的代码对其进行处理。

一种非严重的：java通过Exception类进行描述，对于Exception可以针对性的处理方式进行处理。

无论Error或者Exception都具有一些共性的内容
比如：不正常情况的信息，引发原因等。

Throwable
   ---Error
   ---Exception

2、异常的处理
java提供了特有的语句进行处理
try
{
	需要被检测的代码；
}
catch(异常类 变量)
{
	处理异常的代码；（处理方式）
}
finally
{
	一定会执行的语句；
}

3、对捕获到的异常对象进行常见方法操作。
String getMessage();获取异常信息。
*/

class Demo{
	int div(int a, int b){
		return a/b;
	}
}

class ExceptionDemo {
	public static void main(String[] args) {
		Demo c = new Demo();
		try{
			int x = c.div(4,0);
			System.out.println("x="+x);
		}
		catch (Exception e){
			System.out.println("除零啦");
			System.out.println(e.getMessage());//     /by zero

			System.out.println(e.toString());//异常名称：异常信息

			e.printStackTrace();//异常名称，异常信息，异常出现的位置
			//其实jvm默认的异常处理机制，就是在调用printStackTrace方法
			//打印异常的堆栈跟踪信息
		}
		
		System.out.println("over");
	}
}
