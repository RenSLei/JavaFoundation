package priv.rsl.object_oriented3;
/*
需求：获取一段程序运行的时间。
原理：获取程序开始和结束的时间并相减即可。

获取时间：System.currentTimeMillis();

当代码完成优化后，就可以解决这类问题。

这种方式，模板方法设计模式。

什么是模板方法呢？
在定义功能时，功能的一部分是确定的，但是有一部分是不确定，
而确定的部分在使用不确定的部分，那么这时候就将不确定的部分
暴露出去，由该类的子类去完成。

*/

abstract class GetTime {
    public final void getTime() {
	long start = System.currentTimeMillis();
	runcode();
	long end = System.currentTimeMillis();
	System.out.println("毫秒：" + (end - start));
    }

    public abstract void runcode();
}

/* 以上就是封装好的代码，用于对一段代码进行测试运行时间 */
class SubTime extends GetTime {
    public void runcode()/* 在子类中复写功能主体，以便修改代码主体 */
    {
	for (int x = 0; x < 100; x++) {
	    System.out.print(x);
	}
    }
}

class GetTimeDemo {
    public static void main(String[] args) {
	SubTime t = new SubTime();
	t.getTime();
    }
}
