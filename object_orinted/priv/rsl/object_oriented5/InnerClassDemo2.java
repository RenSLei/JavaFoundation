package priv.rsl.object_oriented5;
/*
内部类的访问规则:
1、内部类可以直接访问外部类中的成员，包括私有。
之所以可以直接访问外部类中的成员，是因为内部类中持有了一个外部类的引用
格式：外部类名.this
2、外部类要访问内部类，必须建立内部类对象；

访问格式：
1、当内部类定义在外部类的成员位置上，而且非私有，可以在外部其他类中。
可以直接建立内部类对象。
格式 ：  外部类名.内部类名  变量名 = 外部类对象.内部类对象;
   Outer.Inner in= new Outer().new Inner();
2、当内部类在成员位置上时，就可以被成员修饰符所修饰。
比如，private:将内部类在外部类中进行封装。
static:内部类就具备Static的特性。
当内部类被静态类修饰后，只能直接访问外部类中的static成员。出现了访问局限。

在外部其他类中，如何直接访问static内部类的非静态成员呢？
new Outer.Inner().function();

在外部其他类中，如何直接访问static内部类的静态成员呢？
Outer.Inner.function();

注意：当内部类中定义了静态成员，该内部类必须是静态的
	  当内部类中的静态方法访问内部类时，内部类也必须是static的（42-53）

当描述事物时，事物的内部还有事物，该事物用内部类来描述。
因为内部事物在使用外部事物的内容。常常将该内部类私有化。再提供方法访问。

*/

class Outer2 {
    private static int x = 8;

    // 静态内部类
    static class Inner {
	//类中有成员是静态的，类一定是静态的
	static void function() {
	    System.out.println("inner:" + x);
	}
    }

    static class Inner2 {
	void show() {
	    System.out.println("inner2 show");
	}
    }

    public static void method() {
	new Inner2().show();// Inner2在Outer类内部中，又是静态的，直接新建Inner2对象来调用show方法
	// Inner.function();内部类访问静态成员直接用类名调用
    }
}

class InnerClassDemo2 {
    public static void main(String[] args) {
	Outer2.method();
	Outer2.Inner.function();// 直接访问static内部类的静态成员
	// new Outer.Inner().show();在外部其他类中直接引用静态内部类的非静态功能的方法
//	new Outer.Inner()是一个整体，因为show()是非静态的，所以要建立对象来调用

    }
}
