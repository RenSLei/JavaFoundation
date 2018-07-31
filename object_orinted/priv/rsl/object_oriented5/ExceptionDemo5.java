package priv.rsl.object_oriented5;
/*
Exception 中有一个特殊的子类异常：RuntimeException 运行时异常

如果在函数内抛出该异常，函数上可以不用声明，编译一样通过
如果在函数上声明了该异常，调用者可以不用进行处理，编译一样通过

之所以不用再函数上声明，是因为不需要让调用者处理
当该异常发生，希望程序停止。因为在运行时，出现了无法继续运算的情况
希望停止程序后，对代码进行修正。  

自定义异常时如果该异常的发生无法再继续进行运算的话，就让自定义异常继承RuntimeException
好处是，如果传递的参数不是合法的，则让程序停掉，并等待修改代码，直到代码正确。


对于异常分两种：
1、编译时被检测的异常
(1)是函数内部抛出了除RuntimeException异常及其子类如Exception，而函数上没有声明
(2)是声明了，但调用者未做处理（抛出或者处理））

2、编译时不被检测的异常（运行时异常，RuntimeException以及其子类）
*/

class FuShuException5 extends RuntimeException {
    public FuShuException5(String msg) {
	super(msg);
    }
}

class Demo5 {
    int div(int a, int b)// 注意，FuShuException继承了RuntimeException，函数内抛出自定义异常，就不用在函数上声明throws
			 // ArithmeticException！！！
    {
	if (b < 0)
	    throw new FuShuException5("除数为负数了！");
	if (b == 0)
	    throw new FuShuException5("除数为零了！");
	return a / b;
	// throw new ArithmeticException("被零除了")
    }
}

class ExceptionDemo5 {
    public static void main(String[] args) {
	Demo5 d = new Demo5();
	int x = d.div(4, -3);
	System.out.println("x=" + x);

	System.out.println("over");
    }
}
