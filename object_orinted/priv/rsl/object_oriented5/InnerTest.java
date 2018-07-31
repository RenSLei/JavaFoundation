package priv.rsl.object_oriented5;
/*
说一个小问题；如果没有父类或者接口呢？该如何使用匿名对象去调用一个方法呢？

*/

class InnerTest {
    public static void main(String[] args) {
	// Object是所有类的根类；即以Object为父类新建匿名对象
	new Object()// 注意:1、不能给此对象命名来调用show,因为Object没有show方法2、()后没有分号
	{
	    public void show() {
		System.out.println("new Object(){}; run");
	    }
	}.show();
    }
}
