package priv.rsl.object_oriented5;
/*
因为项目中会出现特有的问题
而这些问题并未被java所描述并封装对象。
所以对于这些特有的问题可以按照java的对问题封装的思想，
将特有的问题，进行自定义的异常封装。

自定义异常：

需求：在本程序中，对于除数是负数，也视为是错误的，是无法进行运算的
那么就需要对这个问题进行自定义的描述。

当在函数内部出现了throw抛出异常对象，那么就必须要给对应的处理动作
要么在内部try catch 处理
要么在函数上声明让调用者处理。

一般情况下，函数内出现异常，函数上需要声明。

定义自定义异常信息：父类中已经把异常信息的操作都完成了。
	所以子类只要在构造时将异常信息传递给父类通过super语句
	就可以直接通过getMessage方法获取自定义的异常信息。

自定义异常：必须是自定义类继承Exception

为什么继承Exception？
异常体系有一个特点：因为异常类和异常对象都被抛出，他们都具备可抛性，这个可抛性
是Throwale中独有特点

只有这个体系中的类和对象才可以被throw和throws抛出。

throws和throws的区别：
1、	throws使用在函数上
	throw使用在函数内

2、	throws后面跟的是异常类，可以跟多个。用逗号隔开。
	throw后跟的是异常对象


*/

class FuShuException extends Exception {
    /*
     * private String msg; FuShuException(String msg) { this.msg = msg; } public
     * String getMessage() { return msg; } 太麻烦
     */
    // 下面用此方法完成自定义异常：
    private int num;

    FuShuException(String msg, int num) {
	super(msg);
	this.num = num;
    }

    public int getFuShu() {
	return num;
    }

    FuShuException() {
	super();
    }

}

class Demo4 {
    int div(int a, int b) throws FuShuException// 函数内已经throw了，那么函数上就要声明。
    { // 手动通过throw关键字抛出一个自定义异常对象。
	if (b < 0)
	    throw new FuShuException("出现负数", b);
	return a / b;
    }
}

public class ExceptionDemo4 {
    public static void main(String[] args) {
	Demo4 c = new Demo4();
	try {
	    int x = c.div(4, -1);
	    System.out.println("x=" + x);
	} catch (FuShuException e) {
	    System.out.println(e.toString());
	    System.out.println("错误的负数是：" + e.getFuShu());
	}
	System.out.println("over");
    }
}
