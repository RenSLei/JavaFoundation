package priv.rsl.object_oriented5;
/*
3、对捕获到的异常对象进行常见方法操作。
String getMessage();获取异常信息。

-----------------------------------------------------
在函数上声明异常。
便于提高安全性，让调用者进行处理，不处理则编译失败。
-----------------------------------------------------

对多异常的处理。
1、声明异常时，建议声明更为具体的异常，这样处理的可以更具体。
2、对方声明有几个异常，就应该对应有几个catch块来处理这个问题，不要定义多余的catch块
   如果多个catch块中的异常出现继承关系，父类异常catch块放在最下面。

3、建议在处理异常时，catch要写具体的处理方式，不要简单定义一句：e.printStackTrace();
   也不要简单的就书写一条输出语句；
   真正实际开发时，catch是将异常记录到硬盘日志文件中的，以便管理员进行程序调试。




*/

class Demo3 {
    int div(int a, int b) throws ArithmeticException, ArrayIndexOutOfBoundsException// 抛出具体可能的多异常：运算条件异常和数组角标越界异常
    {
	int[] arr = new int[a];
	System.out.println(arr[4]);
	return a / b;
    }
}

class ExceptionDemo3 {
 // throws Exception，也可以在这个地方抛出异常，但由于是jvm调用main，所以直接结束程序，所以一般不这样处理，使用try-catch功能
    public static void main(String[] args){
	Demo3 c = new Demo3();
	try {
	    int x = c.div(3, 1);
	    System.out.println("x=" + x);
	} catch (ArithmeticException e)
/*
* 注意，两个catch只能执行一个，因为先catch到的异常执行后，程序就结束了 且catch要写针对性的处理，也可以直接写：catch
* (Exception e){System.out.println(e.toString());} 但是此处理不具体，属于多态的catch处理方法，
*/
	{
	    System.out.println("被零除了！！");
	    System.out.println(e.toString());
	} catch (ArrayIndexOutOfBoundsException e) {
	    System.out.println("角标越界！！");
	    System.out.println(e.toString());
	}

    }
}
