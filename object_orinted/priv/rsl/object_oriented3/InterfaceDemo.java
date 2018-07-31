package priv.rsl.object_oriented3;
/*
接口：初期理解，可以是一个特殊的抽象类
当抽象类中的方法都是抽象的，那么该类可以通过接口的形式来表示
class用于定义类
interface用于定义接口。

接口定义时，格式特点：
1、接口中常见的定义：常量，抽象方法。
2、接口中的成员都有固定修饰符。
常量：public static final
方法：public abstract
记住：接口中的成员都是public的。

接口是不可以创建对象的，因为有抽象方法。
需要被子类实现，子类对接口中的抽象方法全都覆盖后，子类才可以实例化。
否则子类是一个抽象类。

接口可以被类多实现，也是对多继承不支持的转换形式。java支持多实现。
接口与接口之间是继承关系，且可以多继承！

接口的主要功能是扩展子类功能，通过子类去实现。

基本功能放在类中，是其子类所必须具备的功能；而扩展功能放在接口中，需要时用子类去实现就可以了。

*/

interface Inter {
    public static final int NUM = 3;

    public abstract void show();

}

interface InterA {

    public abstract void method();

}

class Demo {
    public void function() {
    }
}

class Test extends Demo implements Inter, InterA
/*
* 可以先继承再多实现,可以用来扩展一个类的功能。
* 一个类可以实现多个接口，但对类只能单继承。因为如果类与类可以多继承，父类可能含有相同功能名称 子类在调用的时候不知道调用哪一个
* 而类对接口可以多实现是因为接口中的方法都是抽象的，而抽象方法中没有主体 需要子类去写具体主体，即不存在子类不知道访问哪个函数的问题
*/
{
    public void show() {
	System.out.println("重写接口的方法show");
    }/* 对接口Inter中show方法进行覆盖 */

    public void method() {
	System.out.println("重写接口A的方法method");
    }/* 对接口InterA中method方法进行覆盖 */
}

interface A {
    void methodA();
}

interface B // extends A
{
    void methodB();
}

interface C extends B, A/* 接口之间可以多继承，因为没有方法体，但在方法名相同时，必须返回值类型相同 */
{
    void methodC();
}

class D implements C {
    /* D实现C,则D中需要覆盖三个方法，注意实现接口一定要加public */
    public void methodC() {
    }

    public void methodB() {
    }

    public void methodA() {
    }
}

class InterfaceDemo {
    public static void main(String[] args) {
	Test t = new Test();
	System.out.println(t.NUM);
	System.out.println(Test.NUM);
	System.out.println(Inter.NUM);
	t.method();
	t.show();

    }
}
