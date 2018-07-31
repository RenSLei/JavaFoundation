package priv.rsl.object_oriented4;
/*
Object:是所有对象的直接后者间接父类。
该类中定义的肯定是所有对象都具备的功能,即Object中的所有方法子类都能用。
那Object类中有哪些方法呢？-------此程序介绍：equals(Object obj)注意是多态。
/*中的代码是说明equals方法的比较原理，能比较所有类创建的所有对象中任何两个对象是否相等
为什么？因为equals中用了多态equals(Object obj);
*/

/*
如果自定义类中也有比较相同的功能，没有必要重新定义。
只要沿袭父类中的功能，建立自己特有比较内容即可：即使用覆盖父类中的equals方法

*/

class Demo // extends Object
{
    private int num;

    /*
     * Demo() { //super();即任何子类的构造函数里第一行默认有super(); }
     */
    Demo(int num) {
	this.num = num;
    }

    // 如果自定义类中也有比较相同的功能，没有必要重新定义。
    // 只要沿袭父类中的功能，建立自己特有比较内容即可：即使用覆盖父类中的equals方法
    public boolean equals(Object obj)// Object obj = new Demo();
    {
	if (!(obj instanceof Demo))// 判断一下是否是同一类
	    return false;
	Demo d = (Demo) obj;// 向下转型
	return this.num == d.num;
    }
}

class ObjectDemo {
    public static void main(String[] args) {

	Demo d1 = new Demo(4);
	Demo d2 = new Demo(5);
	System.out.println(d1.equals(d2));
	/*
	 * Demo d1 = new Demo(); Demo d2 = new Demo(); Demo d3 = d1;
	 * 
	 * System.out.println(d1.equals(d3)); System.out.println(d1==d3);//实际是比较的地址是否相等
	 * System.out.println(d1==d2);
	 */
    }
}
