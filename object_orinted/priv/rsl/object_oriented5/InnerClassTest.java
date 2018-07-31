package priv.rsl.object_oriented5;

interface Inter {
    void method();
}

class Test {

    // 不通过匿名内部类来实现：
    static class Inner implements Inter {
	public void method() {
	    System.out.println("静态内部类static class Inner run");
	}
    }

    static Inter function1() {
	return new Inner();
    }

    // 补足代码。通过匿名内部类来实现：
    static Inter function2()/*
			     * 没有子类名，则用Inter来代替。 Test.function2()能.上一个方法，必然是对象 而且是一个Inter对象
			     */
    {
	return new Inter()// return{后面都是一个整体即一个对象，这个对象里复写了接口中的方法}
	{
	    public void method() {
		System.out.println("匿名内部类static Inter run");
	    }

	};// 相当于return 对象；
    }
}

public class InnerClassTest {
    public static void main(String[] args) {
	System.out.printf("\n");
	Test.function1().method();// 一般方法，静态内部类
	System.out.printf("\n");
	Test.function2().method();// 匿名内部类方法
	System.out.printf("\n");
	Inter in = Test.function2();// 匿名内部类方法
	in.method();
	System.out.printf("\n");

	// 如何调用show方法呢？参数是Inter型接口类，如果新定义一个类去建立对象，则很麻烦
	// 这时候可以考虑将参数直接用匿名内部类去传递，代码如下：
	show(new Inter() {
	    // 复写接口中的method方法
	    public void method() {
		System.out.println("show method run");
	    }
	});

    }

    public static void show(Inter in) {
	in.method();
    }
}
