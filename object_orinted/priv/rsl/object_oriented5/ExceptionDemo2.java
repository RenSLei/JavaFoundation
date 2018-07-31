package priv.rsl.object_oriented5;
/*

在函数上声明异常。
便于提高安全性，让调用者进行处理，不处理则编译失败。

*/

class Demo2 {
    // 在功能上通过throws的关键字声明了该功能有可能会出现问题。
    int div(int a, int b) throws Exception {
	return a / b;
    }
}

class ExceptionDemo2 {
    public static void main(String[] args)// throws
					  // Exception，也可以在这个地方抛出异常，但由于是jvm调用main，所以直接结束程序，所以一般不这样处理，使用try-catch功能
    {
	Demo2 c = new Demo2();
	try {
	    int x = c.div(4, 0);
	    System.out.println("x=" + x);
	} catch (Exception e) {
	    e.printStackTrace();// 异常名称，异常信息，异常出现的位置
	    // 其实jvm默认的异常处理机制，就是在调用printStackTrace方法
	    // 打印异常的堆栈跟踪信息
	}
	System.out.println("over");
    }
}
