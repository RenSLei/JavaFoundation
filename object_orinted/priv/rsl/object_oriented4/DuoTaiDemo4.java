package priv.rsl.object_oriented4;

class Fu
{
	int num = 5;
	void method1()
	{
		System.out.println("fu method_1");
	}
	void method2()
	{
		System.out.println("fu method_2");
	}
	static void method4()
	{
		System.out.println("fu method_4");
	}
}

class Zi extends Fu
{
	int num = 8;
	void method1()
	{
		System.out.println("zi method_1");
	}
	void method3()
	{
		System.out.println("zi method_3");
	}
	static void method4()
	{
		System.out.println("zi method_4");
	}
}

class  DuoTaiDemo4
{
	public static void main(String[] args) 
	{
		Fu f = new Zi();//注意是多态的形式，和一般的new对象不同

		f.method1();
		f.method2();
		//f.method3();//要编译失败，因为父类中没有method3();
/*在多态中，非静态成员函数的特点：
  在编译时期：参阅引用型变量(指父类指向了子类时的父类)所属的类中是否有调用的方法，如果有，编译通过，
			  如果没有，编译失败（如Fu类中没有method3）
  在运行时期：参阅对象所属类中是否有调用的方法。
总结：成员函数在多态调用时，编译看左边，运行看右边。


特殊：
在多态中，成员变量的特点：
无论编译和运行，都参考左边（引用型变量所属的类）如此程序的int = 5和int = 8；

  */
		//特殊：
		Fu f1 = new Zi();
		f1.method4();//在多态中，静态成员函数的特点：无论编译和运行都参考左边

		//Zi z = new Zi();
		//z.method1();//打印zi method_1(因为重写)
		//z.method2();//打印fu method_2(因为继承)
		//z.method3();//打印zi method_3(因为子类特有)
		//System.out.println("Hello World!");
	}
}
